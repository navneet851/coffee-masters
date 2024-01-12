package com.orderapp.coffeemasters

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.orderapp.coffeemasters.Pages.InfoPage
import com.orderapp.coffeemasters.Pages.MenuPage
import com.orderapp.coffeemasters.Pages.OfferPage
import com.orderapp.coffeemasters.Pages.OrderPage

@Composable
fun MyNavHost(
    navHostController: NavHostController,
    startDestination: String,
    dataManager: DataManager
) {

    NavHost(navController = navHostController,
        startDestination = startDestination,
        builder = {
            composable(NavCons.menu) {
                MenuPage(dataManager)
            }
            composable(NavCons.offers) {
                OfferPage()
            }
            composable(NavCons.myCart) {
                OrderPage(dataManager)
            }
            composable(NavCons.info) {
                InfoPage()
            }
        })

}

sealed class Screens(val route: String, val imageVectorFilled: ImageVector, val imageVectorOutlined: ImageVector, val label: String) {

    object Menu : Screens(
        route = NavCons.menu,
        label = "Menu",
        imageVectorOutlined = Icons.Outlined.Menu,
        imageVectorFilled = Icons.Filled.Menu
    )

    object Offers : Screens(
        route = NavCons.offers,
        label = "Offers",
        imageVectorOutlined = Icons.Outlined.Star,
        imageVectorFilled = Icons.Filled.Star
    )

    object Cart : Screens(
        route = NavCons.myCart,
        label = "My Cart",
        imageVectorOutlined = Icons.Outlined.ShoppingCart,
        imageVectorFilled = Icons.Filled.ShoppingCart
    )

    object Info : Screens(
        route = NavCons.info,
        label = "Info",
        imageVectorOutlined = Icons.Outlined.Info,
        imageVectorFilled = Icons.Filled.Info
    )
}

object NavCons {
    const val menu = "Menu"
    const val offers = "Offers"
    const val myCart = "My Cart"
    const val info = "Info"
}

