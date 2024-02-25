package com.example.yomusic

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.yomusic.ui.theme.AccountView
import com.example.yomusic.ui.theme.BrowseScreen
import com.example.yomusic.ui.theme.HomeScreen
import com.example.yomusic.ui.theme.LibraryScreen
import com.example.yomusic.ui.theme.SubscriptionView
import com.example.yomusic.ui.theme.bg
import com.example.yomusic.ui.theme.bgWhite
import com.example.yomusic.ui.theme.BottomIconColor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun MainView() {

    val scaffoldState : ScaffoldState = rememberScaffoldState()
    val scope: CoroutineScope = rememberCoroutineScope()
    val viewModel : MainViewModel = viewModel()

    var isSheetFullScreen by remember {
        mutableStateOf(false)
    }
    val modifier = if(isSheetFullScreen) Modifier.fillMaxSize() else Modifier.fillMaxWidth()

    // Allow us to find on which "View" we currently are
    val controller : NavController = rememberNavController()
    val navBackStackEntry by controller.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val currentScreen = remember{viewModel.currentScreen.value}

    val title = remember{ mutableStateOf(currentScreen.title) }    // TODO Change to current screen title

    val dialogopen = remember { mutableStateOf(false) }


    val modalSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmValueChange = {
            it != ModalBottomSheetValue.HalfExpanded
        }
    )

    val RoundedCornerRadius = if(isSheetFullScreen) 0.dp else 16.dp

    val bottomBar : @Composable () -> Unit = {
        if(currentScreen is Screen.DrawerScreen || currentScreen == Screen.BottomScreen.Home) {
            BottomNavigation(modifier = Modifier.wrapContentSize(), backgroundColor = bg) {
                screenInBottom.forEach {
                    item->
                    val isSelected = currentRoute == item.broute
                    val tint = if(isSelected) Color.White else BottomIconColor
                    BottomNavigationItem(
                        selected = currentRoute == item.broute,
                        onClick = {
                            controller.navigate(item.broute)
                            title.value = item.btitle
                        },
                        icon = {
                            Icon(contentDescription = item.btitle, painter = painterResource(id = item.icon), tint = tint)
                        },
                        label = { Text(text = item.btitle, color = tint)},
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color.Black
                    )
                }
            }
        }
    }

    ModalBottomSheetLayout(
        sheetState = modalSheetState,
        sheetShape = RoundedCornerShape(topStart = RoundedCornerRadius, topEnd = RoundedCornerRadius),
        sheetContent = {
            MoreBottomSheet(modifier = modifier)
        }
    ) {
        Scaffold(
            bottomBar = bottomBar,
            backgroundColor = bgWhite,
            topBar = {
                TopAppBar(title = { Text(text = title.value)},
                    actions = {
                        IconButton(onClick = {
                            scope.launch {
                                if(modalSheetState.isVisible)
                                    modalSheetState.hide()
                                else
                                    modalSheetState.show()
                            }
                        }
                        ) {
                            Icon(imageVector = Icons.Default.MoreVert, contentDescription = "More Options")
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            //Opening the drawer
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        }) {
                            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
                        }
                    }, colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = bg))
            }, scaffoldState = scaffoldState,
            drawerContent = {
                LazyColumn(
                    modifier = Modifier.padding(16.dp)
                ) {
                    items(screenInDrawer) {
                            item ->
                        DrawerItems(isSelected = currentRoute == item.droute, item = item) {
                            scope.launch {
                                scaffoldState.drawerState.close()
                            }
                            if(item.droute == "add_account") {
                                // Add account page to open
                                dialogopen.value = true
                            } else {
                                controller.navigate(item.droute)
                                title.value = item.dtitle
                            }
                        }
                    }
                }
            }



        ) {
            Navigation(navController = controller, viewModel = viewModel, pd = it)
            Add_Account(dialogOpen = dialogopen)
        }
    }



    Scaffold(
        bottomBar = bottomBar,
        backgroundColor = bgWhite,
        topBar = {
            TopAppBar(title = { Text(text = title.value)},
                actions = {
                    IconButton(onClick = {
                        scope.launch {
                            if(modalSheetState.isVisible)
                                modalSheetState.hide()
                            else
                                modalSheetState.show()
                        }
                    }
                    ) {
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "More Options")
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {
                        //Opening the drawer
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }) {
                        Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
                    }
                }, colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = bg))
        }, scaffoldState = scaffoldState,
        drawerContent = {
            LazyColumn(
                modifier = Modifier.padding(16.dp)
            ) {
                items(screenInDrawer) {
                    item ->
                    DrawerItems(isSelected = currentRoute == item.droute, item = item) {
                        scope.launch {
                            scaffoldState.drawerState.close()
                        }
                        if(item.droute == "add_account") {
                            // Add account page to open
                            dialogopen.value = true
                        } else {
                            controller.navigate(item.droute)
                            title.value = item.dtitle
                        }
                    }
                }
            }
        }
    ) {
        Navigation(navController = controller, viewModel = viewModel, pd = it)
        Add_Account(dialogOpen = dialogopen)
    }
}

@Composable
fun DrawerItems(
    isSelected : Boolean,
    item : Screen.DrawerScreen,
    onDrawerItemClicked : () -> Unit
) {

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(if (isSelected) Color.LightGray else Color.White)
            .padding(start = 8.dp, bottom = 8.dp, top = 8.dp)
            .clickable { onDrawerItemClicked() }
    ){
        Icon(
            painter = painterResource(id = item.icon),
            tint = Color.Black,
            contentDescription = item.dtitle,
            modifier = Modifier.padding(end = 8.dp, top = 4.dp)
        )
        Text(text = item.dtitle, style = MaterialTheme.typography.titleLarge, color = Color.Black, fontWeight = FontWeight.Medium)
    }
}

@Composable
fun MoreBottomSheet(modifier : Modifier) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(250.dp)){
        Column(
            modifier = modifier.padding(8.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row (
                modifier = Modifier.padding(16.dp)
            ){
                Icon(painter = painterResource(id = R.drawable.settings), contentDescription = "Settings")
                Text(text = "Settings", fontSize = 20.sp)
            }

            Row (
                modifier = modifier.padding(16.dp)
            ){
                Icon(painter = painterResource(id = R.drawable.share), contentDescription = "Share")
                Text(text = "Share", fontSize = 20.sp)
            }

            Row (
                modifier = Modifier.padding(16.dp)
            ){
                Icon(painter = painterResource(id = R.drawable.help), contentDescription = "help")
                Text(text = "Help", fontSize = 20.sp)
            }
        }
    }
}



@Composable
fun Navigation(navController: NavController, viewModel: MainViewModel, pd : PaddingValues) {

    NavHost(navController = navController as NavHostController, startDestination = Screen.DrawerScreen.Account.route, modifier = Modifier.padding(pd)) {

        composable(Screen.BottomScreen.Home.broute) {
            //Todo add Home Screen
            HomeScreen()
        }

        composable(Screen.BottomScreen.Browse.broute) {
            //Todo add Browse Screen
            BrowseScreen()
        }

        composable(Screen.BottomScreen.Library.broute) {
            //Todo add Library Screen
            LibraryScreen()
        }

        composable(Screen.DrawerScreen.Account.route) {
            AccountView()
        }
        composable(Screen.DrawerScreen.Subsciption.route) {
            SubscriptionView()
        }
    }
}