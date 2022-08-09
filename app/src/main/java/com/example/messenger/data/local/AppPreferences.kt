package com.example.messenger.data.local

import android.content.Context
import android.content.SharedPreferences
import com.example.messenger.data.vo.UserVO

enum class Details {
    ID,
    USERNAME,
    PHONE_NUMBER,
    STATUS,
    CREATED_AT;
}

class AppPreferences private constructor() {
    private lateinit var preferences: SharedPreferences

    companion object {
        private const val PREFERENCES_FILE_NAME = "APP_PREFERENCES"

        fun create(context: Context): AppPreferences {
            val appPreferences = AppPreferences()
            appPreferences.preferences = context.getSharedPreferences(PREFERENCES_FILE_NAME, 0)
            return appPreferences
        }
    }

    val accessToken: String?
        get() = preferences.getString("ACCESS_TOKEN", null)

    fun storeAccessToken(accessToken: String) {
        preferences.edit().putString("ACCESS_TOKEN", accessToken).apply()
    }

    val userDetails: UserVO
        get(): UserVO {
            return UserVO(
                preferences.getLong(Details.ID.name, 0),
                preferences.getString(Details.USERNAME.name, null).toString(),
                preferences.getString(Details.PHONE_NUMBER.name, null).toString(),
                preferences.getString(Details.STATUS.name, null).toString(),
                preferences.getString(Details.CREATED_AT.name, null).toString()
            )
        }

    fun storeUserDetails(user: UserVO) {
        val editor: SharedPreferences.Editor = preferences.edit()
        editor.putLong(Details.ID.name, user.id).apply()
        editor.putString(Details.USERNAME.name, user.username).apply()
        editor.putString(Details.PHONE_NUMBER.name, user.phoneNumber).apply()
        editor.putString(Details.STATUS.name, user.status).apply()
        editor.putString(Details.CREATED_AT.name, user.createdAt).apply()
    }

    fun clear() {
        val editor: SharedPreferences.Editor = preferences.edit()
        editor.clear()
        editor.apply()
    }
}