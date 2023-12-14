package menu.validation

fun String.isInvalidLength(): Boolean {
    this.split(",").forEach {
        if (it.length < 2 || it.length > 4) {
            return true
        }
    }
    return false
}