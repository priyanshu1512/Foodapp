package eu.tutorials.myrecipeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel : ViewModel() {

    private val _categorieState = mutableStateOf(RecipeState())
    val categoriesState: State<RecipeState> = _categorieState

    private val _selectedTab = mutableStateOf(Tab.RECIPES)
    val selectedTab: State<Tab> = _selectedTab

    init {
        fetchCategories()
        fetchBooks()
    }


    private fun fetchCategories(){
        viewModelScope.launch {
            try {
                val response = recipeService.getCategories()
                _categorieState.value = _categorieState.value.copy(
                    recipeList = response.categories,
                    loading = false,
                    error = null
                )

            }catch (e: Exception){
                _categorieState.value = _categorieState.value.copy(
                    loading = false,
                    error = "Error fetching Categories ${e.message}"
                )
            }
        }
    }

    private fun fetchBooks() {
        viewModelScope.launch {
            try {
                val response = recipeService.getPopularBooks()
                _categorieState.value = _categorieState.value.copy(
                    bookList = response.docs.map { it.toBook() },
                    loading = false,
                    error = null
                )
            } catch (e: Exception) {
                _categorieState.value = _categorieState.value.copy(
                    loading = false,
                    error = "Error fetching books ${e.message}"
                )
            }
        }
    }

    fun setSelectedTab(tab: Tab) {
        _selectedTab.value = tab
    }

    data class RecipeState(
        val loading: Boolean = true,
        val recipeList: List<Category> = emptyList(),
        val bookList: List<Book> = emptyList(),
        val error: String? = null
    )

    enum class Tab {
        RECIPES, BOOKS
    }

}