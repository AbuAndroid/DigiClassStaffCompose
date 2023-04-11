package com.example.digiclassstaffcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.digiclassstaffcompose.ui.loginscreen.LoginScreen
import com.example.digiclassstaffcompose.ui.loginscreen.LoginScreenRoute
import com.example.digiclassstaffcompose.ui.loginscreen.LoginViewModel
import com.example.digiclassstaffcompose.ui.splashscreen.LottieExample
import com.example.digiclassstaffcompose.ui.theme.DigiClassStaffComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DigiClassStaffComposeTheme {
//                LoginScreenRoute(
//                    loginViewModel = LoginViewModel()
//                )
                LottieExample()
            }
        }
    }
}
