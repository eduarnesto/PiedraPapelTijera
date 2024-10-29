package com.example.juego.composables

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.juego.R

@Composable
fun pantalla1(navHostController: NavHostController, pointsP1: String, pointsP2: String, eleccion: String){
    Column (
        Modifier
            .background(color = Color.Yellow),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "Maquina: " + pointsP1
        )
        Text(
            text = "Jugador: " + pointsP2
        )
        Row (
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
                .background(color = Color.Red)
        ){
            Image(
                modifier = Modifier
                    .size(100.dp, 100.dp),
                painter = painterResource(R.drawable.stone),
                contentDescription = ""
            )
            Image(
                modifier = Modifier
                    .size(100.dp, 100.dp),
                painter = painterResource(R.drawable.scissors),
                contentDescription = ""
            )
            Image(
                modifier = Modifier
                    .size(100.dp, 100.dp),
                painter = painterResource(R.drawable.paper),
                contentDescription = ""
            )
        }
        Row (
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
                .background(color = Color.Gray)
        ){
            cambiarImagen(eleccion)
        }
        Row (
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f)
                .background(color = Color.Blue)
        ){
            Image(
                modifier = Modifier
                    .clickable { navHostController.navigate("pantalla1/$pointsP1/$pointsP2/1")}
                    .size(100.dp, 100.dp),
                painter = painterResource(R.drawable.stone),
                contentDescription = ""

            )
            Image(
                modifier = Modifier
                    .clickable { navHostController.navigate("pantalla1/$pointsP1/$pointsP2/2") }
                    .size(100.dp, 100.dp),
                painter = painterResource(R.drawable.scissors),
                contentDescription = ""

            )
            Image(
                modifier = Modifier
                    .clickable { navHostController.navigate("pantalla1/$pointsP1/$pointsP2/3")}
                    .size(100.dp, 100.dp),
                painter = painterResource(R.drawable.paper),
                contentDescription = ""
            )

        }

        Button(
            modifier = Modifier
                .size(200.dp, 70.dp)
                .padding(top = 20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray,
                contentColor = Color(184,52,242)
            ),
            onClick = {navHostController.navigate("pantalla1")}
        ) {
            Text(
                text = "Jugar de nuevo"
            )
        }
    }
}

@Composable
fun cambiarImagen(eleccion: String){
    var imagen: Painter

    if (eleccion == "1"){
        imagen = painterResource(R.drawable.stone)
    } else if (eleccion == "2") {
        imagen = painterResource(R.drawable.scissors)
    } else {
        imagen = painterResource(R.drawable.paper)
    }

    Image(
        modifier = Modifier
            .size(100.dp, 100.dp),
        painter = imagen,
        contentDescription = ""
    )
}