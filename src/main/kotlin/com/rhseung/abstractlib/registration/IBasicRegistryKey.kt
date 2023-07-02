package com.rhseung.abstractlib.registration

interface IBasicRegistryKey {
    var translationName: MutableMap<String, String>

    override fun toString(): String
}