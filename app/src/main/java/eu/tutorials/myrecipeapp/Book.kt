package eu.tutorials.myrecipeapp

data class Book(
    val title: String,
    val author: String,
    val coverUrl: String = ""
)

data class BookResponse(
    val docs: List<BookDoc>
)

data class BookDoc(
    val title: String,
    val author_name: List<String>? = null,
    val cover_i: Int? = null
) {
    fun toBook(): Book = Book(
        title = title,
        author = author_name?.firstOrNull() ?: "Unknown Author",
        coverUrl = if (cover_i != null) "https://covers.openlibrary.org/b/id/$cover_i-M.jpg" else ""
    )
}