package com.rhseung.abstractlib.api.file

@JvmInline
value class SnakeCaseString(
    val string: String
) {
    init {
        require(
            string.isNotEmpty()
        ) { "LocationCaseString cannot be empty" }

        require(
            string.all { it.isLowerCase() || it == '_' } && !(string.first() == '_' || string.last() == '_')
        ) { "LocationCaseString must be snake case" }
    }

    val length: Int
        get() = string.length

    override fun toString() = string

    companion object {
        fun of(string: String): SnakeCaseString {
            require(string.isNotEmpty()) { "SnakeCaseString cannot be empty" }

            return SnakeCaseString(string.replace(" ", "_").lowercase())
        }
    }
}