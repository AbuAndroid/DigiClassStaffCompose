package com.example.digiclassstaffcompose.ui.loginscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue


@Composable
fun LoginScreenRoute(
    loginViewModel: LoginViewModel
) {
    val uiState by loginViewModel.uiState.collectAsState()

    LoginScreen(
        email = loginViewModel.email.value,
        password = loginViewModel.password.value,
        onEmailChanged = { email ->
            loginViewModel.onEmailEntered(email)
        },
        onPasswordChanged = { password ->
            loginViewModel.onPasswordEntered(password)
        },
        onSubmit = {},
        onForgotPasswordClicked = {},
        isLoading = uiState.isLoading
    )

}

