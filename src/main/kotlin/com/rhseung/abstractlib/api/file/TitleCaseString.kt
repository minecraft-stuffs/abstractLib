package com.rhseung.abstractlib.api.file

@JvmInline
value class TitleCaseString(
    val string: String
) {
    init {
        require(
            string.isNotEmpty()
        ) { "TitleCaseString cannot be empty" }

        require(
            string.all { it.isUpperCase() || it.isLowerCase() } && string.first().isUpperCase()
        ) { "TitleCaseString must be camel case" }
    }

    val length: Int
        get() = string.length

    override fun toString() = string

    companion object {
        fun of(string: String): TitleCaseString {
            require(string.isNotEmpty()) { "TitleCaseString cannot be empty" }

            return TitleCaseString(string.lowercase().split("_")
                .joinToString(" ") { it.replaceFirstChar { it.titlecase() } })
        }
    }
}