package uz.coderboy.onlineshop.ui.home.model

data class HomeMain(

    val title: String,
    val recommendationList: List<HomeRecommendation>? = null
)