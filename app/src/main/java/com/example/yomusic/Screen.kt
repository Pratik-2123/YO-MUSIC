package com.example.yomusic

import androidx.annotation.DrawableRes

sealed class Screen (val title: String, val route : String){

    sealed class BottomScreen(val btitle : String, val broute: String, @DrawableRes val icon : Int) : Screen(btitle,broute) {
        object Home : BottomScreen(
            "Home",
            "home",
            R.drawable.baseline_home_24
        )
        object Browse : BottomScreen(
            "Browse",
            "browse",
            R.drawable.baseline_manage_search_24
        )
        object Library : BottomScreen(
            "Library",
            "library",
            R.drawable.baseline_library_music_24
        )
    }



    sealed class DrawerScreen(val dtitle: String, val droute : String, @DrawableRes val icon : Int)
        : Screen(dtitle,droute){

            object Account : DrawerScreen (
                "Account",
                "account",
                R.drawable.ic_account_box
            )
        object Subsciption : DrawerScreen(
            "Subscription",
            "subscribe",
            R.drawable.ic_subscribe
        )
        object AddAccount : DrawerScreen(
            "Add Account",
            "add_account",
            R.drawable.ic_add_acc
        )
    }
}

val screenInDrawer = listOf(
    Screen.DrawerScreen.Account,
    Screen.DrawerScreen.Subsciption,
    Screen.DrawerScreen.AddAccount
)

val screenInBottom = listOf(
    Screen.BottomScreen.Home,
    Screen.BottomScreen.Browse,
    Screen.BottomScreen.Library
)