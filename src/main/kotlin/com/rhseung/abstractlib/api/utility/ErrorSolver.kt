package com.rhseung.abstractlib.api.utility

object ErrorSolver {
	fun npe(message: String): Nothing = throw NullPointerException(message)
	fun nsee(message: String): Nothing = throw NoSuchElementException(message)
}