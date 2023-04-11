package com.example.digiclassstaffcompose.ui.loginscreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class LoginViewModel() : ViewModel() {

    private val viewModelState = MutableStateFlow(
        LoginViewModelState(isLoading = false)
    )

    val uiState = viewModelState.map { it.toUiState() }
        .stateIn(viewModelScope, SharingStarted.Eagerly,viewModelState.value.toUiState())

    var email = mutableStateOf("")
        private set
    var password = mutableStateOf("")
        private set

    fun onEmailEntered(emailId:String){
        email.value = emailId
    }

    fun onPasswordEntered(password:String){
        this.password.value = password
    }

}

data class LoginViewModelState(
    val isLoading :Boolean
){
    fun toUiState() = LoginUiState(
        isLoading = isLoading
    )
}

data class LoginUiState(
    val isLoading: Boolean
)

