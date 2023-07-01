package com.rhseung.abstractlib.init

import com.rhseung.abstractlib.api.Translation

interface IBasicRegistryKey {
    var translationName: Translation

    override fun toString(): String
}