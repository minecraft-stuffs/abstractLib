package com.rhseung.abstractlib.api.file

import java.io.File

sealed class P(vararg val path: P): File(path.toString()) {
	fun uri() {}
	fun uris() {}
	
//	open val fileName = path.
	override fun toString() = path.joinToString("/")
}