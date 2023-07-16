package com.rhseung.abstractlib.api.file.path

import java.io.File

// note: 언젠가 모든 [URI]를 교체할 놈
sealed class Path(vararg val path: Path): File(path.toString()) {
	fun uri() {
	
	}
	fun uris() {
	
	}
	
//	open val fileName = path.
	override fun toString() = path.joinToString("/")
}