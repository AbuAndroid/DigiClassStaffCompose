package com.example.digiclassstaffcompose.ui.splashscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.example.digiclassstaffcompose.R


@Preview
@Composable
fun LottieExamplePreview() {
    LottieExample()
}

@Composable
fun LottieExample() {

    val isPlaying = remember { mutableStateOf(true) }

    val speed = remember {
        mutableStateOf(1f)
    }
    val lottieComposition =
        rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.lottie))

    val progress =  animateLottieCompositionAsState(
        composition = lottieComposition.value,
   //     iterations = LottieConstants.IterateForever,
        isPlaying = isPlaying.value,
        speed = speed.value,
        restartOnPlay = false
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LottieAnimation(
            composition = lottieComposition.value,
            progress =progress.value,
            modifier = Modifier.size(400.dp)
        )
    }

}