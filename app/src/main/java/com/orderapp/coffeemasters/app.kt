package com.orderapp.coffeemasters

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.orderapp.coffeemasters.ui.theme.Alternative2
import com.orderapp.coffeemasters.ui.theme.Primary


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun App(
    navController: NavHostController,
    dataManager: DataManager
) {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Primary
                ),
                title = {
                    AppTitle()
                }
            )
        },
        content = {
            Column(
                Modifier.padding(it)
            ) {
                MyNavHost(
                    navHostController = navController,
                    startDestination = Screens.Menu.route,
                    dataManager
                )
            }
        },
        bottomBar = {
                BottomNav(navController = navController)
            }
    )
}


    @Composable
    fun AppTitle() {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Coffee Masters Logo"
            )
        }
    }



@Composable
fun BottomNav(
    navController: NavHostController,
) {
    var selectedIndex by remember {
        mutableIntStateOf(0)
    }
    val list = listOf(
        Screens.Menu,
        Screens.Offers,
        Screens.Cart,
        Screens.Info,

        )
    NavigationBar(
        containerColor = Primary
    ) {
        list.forEachIndexed { index, screens ->
            NavigationBarItem(
                colors = androidx.compose.material3.NavigationBarItemDefaults
                    .colors(
                        indicatorColor = Color.Black,
                    ),
                selected = selectedIndex == index,
                onClick = {
                    navController.navigate(screens.route)
                    selectedIndex = index
                },
                alwaysShowLabel = true,
                icon = {
                    Icon(
                        imageVector = if (index == selectedIndex) {
                            screens.imageVectorFilled
                        } else screens.imageVectorOutlined,
                        contentDescription = screens.label,
                        tint = Alternative2
                    )
                },
                label = {
                    Text(text = screens.label, color = Alternative2)

                },

            )
        }
    }
}
