package com.example.digiclassstaffcompose.di.module

import com.example.digiclassstaffcompose.ui.loginscreen.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Test {
    fun modules() =  viewModelModule
}

val repomodule = module{

}

val viewModelModule = module {
    viewModel{
        LoginViewModel()
    }
}