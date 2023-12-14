package menu.validation

import menu.model.menu.food.*

fun String.isInvalidLength(): Boolean {
    this.split(",").forEach {
        if (it.length < 2 || it.length > 4) {
            return true
        }
    }
    return false
}

fun String.isNotContainMenu(): Boolean {
    if (this == "") {
        return false
    }
    this.split(",").forEach {
        if (JapaneseFood.MENU.names.contains(it).not() && KoreanFood.MENU.names.contains(it).not()
            && AsianFood.MENU.names.contains(it).not() && ChineseFood.MENU.names.contains(it).not()
            && WesternFood.MENU.names.contains(it).not()) {
            return true
        }
    }
    return false
}