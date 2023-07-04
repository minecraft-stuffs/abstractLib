package com.rhseung.abstractlib.api.utility

object ErrorSolver {
	fun Any?.nullsafe(lambda: () -> String): Any {
		return this ?: throw NullPointerException(lambda())
	}
	
	fun npe(message: String): Nothing = throw NullPointerException(message)
}