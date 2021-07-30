package uz.coderboy.onlineshop.ui.home.model

data class HomeRecommendation(
    val title: String,
    val image: String,
    val favourite: Boolean = false,
val sold: Int? = 0
)