package com.example.digiclassstaffcompose.ui.loginscreen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.digiclassstaffcompose.R
import com.example.digiclassstaffcompose.ui.theme.Purple200


@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        email = "syedabutahir304@gmail.com",
        onEmailChanged = {},
        password = "23456",
        onPasswordChanged = {},
        onSubmit = {},
        onForgotPasswordClicked = {},
        isLoading = true
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginScreen(
    email: String,
    onEmailChanged: (String) -> Unit,
    password: String,
    onPasswordChanged: (String) -> Unit,
    onSubmit: () -> Unit,
    onForgotPasswordClicked: () -> Unit,
    isLoading: Boolean
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = Purple200,
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "Help?",
                    color = Color.White
                )
            }
        },
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.ic_bg_splash),
                contentDescription = "Background Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )

            Box(
                modifier = Modifier
                    .padding(bottom = 56.dp)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    DigiclassLogo()
                    Spacer(modifier = Modifier.padding(top = 16.dp))
                    Card(
                        backgroundColor = Color.White,
                        shape = RoundedCornerShape(6.dp),
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CollegeInfo()
                            TextInputFields(
                                email = email,
                                onEmailChanged = onEmailChanged,
                                password = password,
                                onPasswordValueChanged = onPasswordChanged,
                                onSubmit = onSubmit
                            )
                            ForgotPasswordText(
                                onForgotPasswordClicked = onForgotPasswordClicked
                            )
                        }
                    }
                    if (isLoading) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}

@Composable
fun CollegeInfo() {
    Card(
        shape = RoundedCornerShape(6.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 6.dp, start = 16.dp, end = 16.dp),
        border = BorderStroke(1.dp, Color(0x0F000000)),
        backgroundColor = Color.White
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "",
                color = Color.Gray,
                fontSize = 14.sp,
                fontFamily = FontFamily.Cursive,
                modifier = Modifier.padding(start = 6.dp)
            )
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = "Edit College",
                    tint = Color(0xFF4B5563),
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun DigiclassLogoPreview() {
    DigiclassLogo()
}

@Composable
fun DigiclassLogo() {
    Image(
        painter = painterResource(id = R.drawable.img),
        contentDescription = "Logo",
        modifier = Modifier.width(228.dp)
    )
}

@ExperimentalComposeUiApi
@Preview
@Composable
fun TextInputFieldsPreview() {
    TextInputFields(
        email = "syedabuthahir304@gmail.com",
        password = "123456",
        onEmailChanged = {},
        onPasswordValueChanged = {},
        onSubmit = {}
    )
}

@ExperimentalComposeUiApi
@Composable
fun TextInputFields(
    email: String,
    onEmailChanged: (String) -> Unit,
    password: String,
    onPasswordValueChanged: (String) -> Unit,
    onSubmit: () -> Unit
) {
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val passwordVisibility = remember { mutableStateOf(false) }
    Log.e("passwordvisibility", passwordVisibility.value.toString())
    TextField(
        value = email,
        onValueChange = {
            onEmailChanged(it.trim())
        },
        placeholder = {
            Text(text = "Enter User Email:")
        },
        singleLine = true,
        leadingIcon = {
            Image(
                painter = painterResource(id = R.drawable.ic_user),
                contentDescription = "username"
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Down) }
        ),
        shape = RoundedCornerShape(6.dp),
        modifier = Modifier
            .padding(top = 16.dp, end = 16.dp, start = 16.dp)
            .fillMaxWidth()
            .focusable(true)
            .background(color = Color(0x0F000000)),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            backgroundColor = Color.Transparent,
            cursorColor = Color(0xFF147AFC)
        )
    )

    TextField(
        value = password,
        onValueChange = onPasswordValueChanged,
        placeholder = {
            Text(text = "Enter Your Password..")
        },
        singleLine = true,
        leadingIcon = {
            Image(
                painter = painterResource(id = R.drawable.ic_password),
                contentDescription = "PasswordImage"
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = { keyboardController?.hide() }
        ),
        shape = RoundedCornerShape(6.dp),
        modifier = Modifier
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .focusable(true)
            .background(color = Color(0x0F000000)),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            backgroundColor = Color.Transparent,
            cursorColor = Color(0xFF147AFC)
        ),
        trailingIcon = {
            val description = if (passwordVisibility.value) "password visible" else "password hide"
            val image =
                if (passwordVisibility.value) Icons.Filled.Visibility else Icons.Filled.VisibilityOff

            IconButton(
                onClick = {
                    passwordVisibility.value = !passwordVisibility.value
                }
            ) {
                Icon(imageVector = image, contentDescription = description)
            }
        },
        visualTransformation = if (passwordVisibility.value) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )

    SignIn(
        focusManager = focusManager,
        keyboardController = keyboardController,
        onSubmit = onSubmit
    )

}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignIn(
    focusManager: FocusManager,
    keyboardController: SoftwareKeyboardController?,
    onSubmit: () -> Unit
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF007AFF),
            contentColor = Color(0xFF007AFF)
        ),
        onClick = {
            focusManager.clearFocus(true)
            keyboardController?.hide()
            onSubmit()
        },
        shape = RoundedCornerShape(6.dp),
        modifier = Modifier
            .padding(top = 26.dp)
            .fillMaxWidth(0.5f)
    ) {
        Text(
            text = "LOGIN",
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Composable
fun ForgotPasswordText(
    onForgotPasswordClicked: () -> Unit
) {
    Text(
        text = "Forgot Password?",
        color = Color(0xFF007AFF),
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        modifier = Modifier
            .padding(top = 8.dp, bottom = 16.dp)
            .clickable {
                onForgotPasswordClicked()
            }
    )
}