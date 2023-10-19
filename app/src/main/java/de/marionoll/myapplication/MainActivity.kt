package de.marionoll.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NavHost(
                navController = rememberNavController(),
                startDestination = "home",
            ) {
                composable("home") {
                    HorizontalPager(
                        modifier = Modifier.fillMaxSize(),
                        state = rememberPagerState(pageCount = { 3 }),
                    ) { page ->
                        when (page) {
                            0 -> {
                                Text(text = "Page 1")
                            }

                            1 -> {
                                ConstraintLayout(
                                    Modifier.fillMaxSize()
                                ) {
                                    val (textRef) = createRefs()

                                    Text(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .constrainAs(textRef) {
                                                start.linkTo(parent.start)
                                                top.linkTo(parent.top)
                                                bottom.linkTo(parent.bottom)
                                                end.linkTo(parent.end)
                                            },
                                        text = "Page 2"
                                    )
                                }
                            }

                            2 -> {
                                Text(text = "Page 3")
                            }
                        }
                    }
                }
            }
        }
    }
}
