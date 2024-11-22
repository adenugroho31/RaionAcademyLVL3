package com.example.raionacademylvl3

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage

@Composable
fun DetailScreen(
    productName: String?,
    sharedViewModel: SharedViewModel = viewModel()
) {
    val productDetail = when (productName) {
        "Sepatu Lari" -> ProductDetail.sepatu
        "Celana Pendek" -> ProductDetail.celana
        "T-Shirt Kece" -> ProductDetail.kaos
        "Earbuds - R82" -> ProductDetail.earbuds
        "Mechanical Keyboard" -> ProductDetail.keyboard
        "Handphone 128 GB" -> ProductDetail.handphone
        "RTX 3060 Ti" -> ProductDetail.vga
        "Meja 100x150 Cm" -> ProductDetail.meja
        "Mio Anggorawwww" -> ProductDetail.mio
        "Jam Tangan Lelaki" -> ProductDetail.jamtangan
        "Tipe-x Trondol" -> ProductDetail.tipex
        "Horegggggg" -> ProductDetail.horeg
        "Pucelle Perfume" -> ProductDetail.parfum
        "Laptop Geming" -> ProductDetail.laptop
        else -> ProductDetail.sepatu
    }

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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            if (productDetail == null) {
                Text("Produk tidak ditemukan", fontSize = 18.sp, modifier = Modifier.padding(16.dp))
            } else {
                Text(
                    text = productDetail.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = productDetail.rating,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                AsyncImage(
                    model = productDetail.image,
                    contentDescription = productDetail.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Harga: ${productDetail.harga}",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = "Deskripsi: ${productDetail.deskripsi}",
                    modifier = Modifier.padding(bottom = 32.dp)
                )

                Button(
                    onClick = { sharedViewModel.incrementCounter() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Add to Cart",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }
    }
}
