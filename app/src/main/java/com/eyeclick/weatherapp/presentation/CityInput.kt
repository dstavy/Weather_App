package com.eyeclick.weatherapp.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp

@Composable
fun CityInput(
    state: WeatherState,
    onIntent: (intent: WeatherIntent) -> Unit,
    modifier: Modifier = Modifier
) {
    val focusManager = LocalFocusManager.current

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    )
    {
        TextField(
            value = state.inputCity,
            onValueChange = { city: String -> onIntent(WeatherIntent.UpdateCity(city)) },
            label = { Text("City") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Color.White,
                focusedLabelColor = Color.Transparent,
            ),
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(100.dp),
            onClick = {
                focusManager.clearFocus(true)
                onIntent(WeatherIntent.Load)
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray)
        )
        {
            Text(text = "Get Weather")
        }


    }
}
