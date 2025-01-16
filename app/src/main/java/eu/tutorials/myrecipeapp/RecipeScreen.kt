package eu.tutorials.myrecipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun RecipeScreen(modifier: Modifier = Modifier,
                 viewstate:MainViewModel.RecipeState,
                 selectedTab: MainViewModel.Tab,
                 onTabSelected: (MainViewModel.Tab) -> Unit,
                 navigateToDetail: (Category)-> Unit){
    Column(modifier = Modifier.fillMaxSize()) {
        TabRow(
            selectedTabIndex = if(selectedTab == MainViewModel.Tab.RECIPES) 0 else 1
        ) {
            Tab(
                selected = selectedTab == MainViewModel.Tab.RECIPES,
                onClick = { onTabSelected(MainViewModel.Tab.RECIPES) }
            ) {
                Text("Recipes", modifier = Modifier.padding(16.dp))
            }
            Tab(
                selected = selectedTab == MainViewModel.Tab.BOOKS,
                onClick = { onTabSelected(MainViewModel.Tab.BOOKS) }
            ) {
                Text("Books", modifier = Modifier.padding(16.dp))
            }
        }

        Box(modifier = Modifier.fillMaxSize()) {
            when {
                viewstate.loading -> {
                    CircularProgressIndicator(modifier.align(Alignment.Center))
                }
                viewstate.error != null -> {
                    Text("ERROR OCCURRED")
                }
                else -> {
                    when (selectedTab) {
                        MainViewModel.Tab.RECIPES -> CategoryScreen(
                            categories = viewstate.recipeList,
                            navigateToDetail
                        )
                        MainViewModel.Tab.BOOKS -> BookScreen(books = viewstate.bookList)
                    }
                }
            }
        }
    }
}

@Composable
fun CategoryScreen(categories: List<Category>,
                   navigateToDetail: (Category)-> Unit){
    LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.fillMaxSize()){
        items(categories){
            category ->
            CategoryItem(category = category,navigateToDetail )
        }
    }
}
@Composable
fun BookScreen(books: List<Book>) {
    LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
        items(books) { book ->
            BookItem(book = book)
        }
    }
}
// How each Items looks like
@Composable
fun CategoryItem(category: Category,
                 navigateToDetail: (Category)-> Unit){
    Column(modifier = Modifier
        .padding(8.dp)
        .fillMaxSize()
        .clickable { navigateToDetail(category) },
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
        )

        Text(
            text = category.strCategory,
            color = Color.Black,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top=4.dp)
        )
    }
}
@Composable
fun BookItem(book: Book) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (book.coverUrl.isNotEmpty()) {
            Image(
                painter = rememberAsyncImagePainter(book.coverUrl),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(0.7f)
            )
        }
        Text(
            text = book.title,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top = 4.dp)
        )
        Text(
            text = book.author,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(fontSize = 12.sp),
            modifier = Modifier.padding(top = 2.dp)
        )
    }
}

