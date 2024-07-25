package com.example.sharedpreferencepractice.preferences

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import kotlin.math.E

class SharedPreferences(private val context: Context) {
    companion object {
        private val NAME_SHARED_PREF = "name_shared_pref"
        private val STRING_NAME= "string_name"
        private val DEFAULTS_NAME= "default name"
    }

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(NAME_SHARED_PREF, Context.MODE_PRIVATE)

    fun saveName(text: String) {
        val editor = sharedPreferences.edit()
        editor.putString(STRING_NAME, text)
        editor.apply()
        proverka(text)
    }


    fun loadName(): String {
        return sharedPreferences.getString(STRING_NAME, DEFAULTS_NAME) ?: DEFAULTS_NAME
    }

    fun proverka(prov: String) {
        if(prov != null && prov != "") {
            Toast.makeText(context, "Ваше имя успешно сохранено", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Ошибка", Toast.LENGTH_SHORT).show()

        }
    }
}