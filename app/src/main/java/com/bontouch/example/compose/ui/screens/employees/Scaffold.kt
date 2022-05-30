package com.bontouch.example.compose.ui.screens.employees

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bontouch.example.compose.ui.theme.MainTheme

@ExperimentalAnimationApi
@Preview
@Composable
fun ScaffoldPreview() {
    Scaffold(
        isShowingEmployeeDetail = false,
        onBackPressed = {},
        content = @Composable {
            Text("Empty content")
        }
    )
}

@ExperimentalAnimationApi
@Composable
fun Scaffold(
    isShowingEmployeeDetail: Boolean,
    onBackPressed: () -> Unit,
    content: @Composable () -> Unit
) {
    MainTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Scaffold(
                topBar = {
                    TopAppBar {
                        Toolbar(
                            isShowingEmployeeDetails = isShowingEmployeeDetail,
                            onBackPressed = {
                                onBackPressed()
                            }
                        )
                    }
                }) {
                content()
            }
        }
    }
}


