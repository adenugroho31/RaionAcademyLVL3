package com.example.raionacademylvl3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
@Preview
fun AppScreen(
    navController: NavHostController = rememberNavController(),
    sharedViewModel: SharedViewModel = viewModel()
) {
    val appList = listOf(
        AppObject.sepatu,
        AppObject.celana,
        AppObject.vga,
        AppObject.kaos,
        AppObject.jamtangan,
        AppObject.laptop,
        AppObject.handphone,
        AppObject.keyboard,
        AppObject.earbuds,
        AppObject.meja,
        AppObject.mio,
        AppObject.tipex,
        AppObject.horeg,
        AppObject.parfum
    )

    val count = sharedViewModel.counter.value

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { sharedViewModel.decrementCounter() },
                modifier = Modifier.padding(16.dp),
                shape = CircleShape,
                containerColor = Color.Blue
            ) {
                Text(text = count.toString(), color = Color.White, fontSize = 18.sp)
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(17.dp),
            horizontalArrangement = Arrangement.spacedBy(17.dp),
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(top = paddingValues.calculateTopPadding())
        ) {
            items(appList) { appEntity ->
                AppWidget(appEntity) {
                    navController.navigate("detail_screen/${appEntity.name}")
                }
            }
        }
    }
}