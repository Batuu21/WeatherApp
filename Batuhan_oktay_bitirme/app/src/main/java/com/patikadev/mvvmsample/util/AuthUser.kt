package com.patikadev.mvvmsample.util

object AuthUser {


    val users = listOf("Peter", "John", "Smith")


    fun signUp(
        userName: String,
        password: String,
        repeatPassword: String,
        users : List<String> = this.users
    ): Boolean {

        if (userName.isEmpty())
            return false
        if (password.isEmpty())
            return false
        if (password != repeatPassword)
            return false
        if (users.contains(userName))
            return false
        return true
    }
}