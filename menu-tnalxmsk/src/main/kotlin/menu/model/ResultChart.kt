package menu.model

data class ResultChart(
    val recommendationCategory: Map<String, String>,
    val recommendationMenus: Map<String, MutableList<String>>
)
