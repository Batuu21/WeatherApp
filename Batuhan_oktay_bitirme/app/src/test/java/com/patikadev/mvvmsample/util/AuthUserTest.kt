package com.patikadev.mvvmsample.util

import org.junit.Assert.*
import org.junit.Test

class AuthUserTest{




    @Test
    fun `signUp function must return false if username and password is empty`(){
        //given
        val userName = ""
        val password = ""
        val repeatPassword = ""



        //when
        val isSignUpSuccess = AuthUser.signUp(userName, password, repeatPassword)

        //then
        assertFalse(isSignUpSuccess)

    }


    @Test
    fun `signUp function must return false if username is empty`(){
        //given
        val userName = ""
        val password = "13213213"
        val repeatPassword = ""



        //when
        val isSignUpSuccess = AuthUser.signUp(userName, password, repeatPassword)

        //then
        assertFalse(isSignUpSuccess)

    }


    @Test
    fun `signUp function must return false if password is empty`(){
        //given
        val userName = "12321321321"
        val password = ""
        val repeatPassword = ""



        //when
        val isSignUpSuccess = AuthUser.signUp(userName, password, repeatPassword)

        //then
        assertFalse(isSignUpSuccess)

    }


    @Test
    fun `signUp function must return false if all fields are filled but username has taken `(){

        //given
        val userName = "ali"
        val password = "123456"
        val repeatPassword = "123456"
        val takenUserNames = listOf("ali", "bulut", "anıl", "fatih")


        //when
        val isSignUpSuccess = AuthUser.signUp(userName, password, repeatPassword,takenUserNames )

        //then
        assertFalse(isSignUpSuccess)

    }


    @Test
    fun `signUp function must return false if all fields are filled, username hasnt taken but repeatPassword doesnt match `(){

        //given
        val userName = "ali"
        val password = "123456"
        val repeatPassword = "122455"



        //when
        val isSignUpSuccess = AuthUser.signUp(userName, password, repeatPassword)

        //then
        assertFalse(isSignUpSuccess)

    }


    @Test
    fun `signUp function must return true if all fields are filled and matched, username hasnt taken yet `(){

        //given
        val userName = "ali"
        val password = "123456"
        val repeatPassword = "123456"

        val takenUserNames = listOf("Emre", "Fatih", "Anıl", "Ahmet")
        //when
        val isSignUpSuccess = AuthUser.signUp(userName, password, repeatPassword, takenUserNames)

        //then
        assertTrue(isSignUpSuccess)
    }
}