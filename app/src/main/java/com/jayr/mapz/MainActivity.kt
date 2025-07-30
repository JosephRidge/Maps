package com.jayr.mapz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.arcgismaps.mapping.ArcGISMap
import com.arcgismaps.mapping.BasemapStyle
import com.jayr.mapz.ui.theme.MapzTheme

import com.arcgismaps.mapping.Viewpoint
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MapzTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   Column( modifier = Modifier.padding(innerPadding)) {
                        MainScreen(
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}
fun createMap(): ArcGISMap {
    return ArcGISMap(BasemapStyle.ArcGISTopographic).apply {
        initialViewpoint = Viewpoint(
            latitude = 34.0270,
            longitude = -118.8050,
            scale = 72000.0

        )
    }
}

@Composable
fun MainScreen(modifier: Modifier){
    val map = remember {
//        Column(modifier = modifier){
            createMap()
//        }
    }

}
//AAPTxy8BH1VEsoebNVZXo8HurLy1kvJ6TrfnBN6yXF9zToXQy_fkN-lLOsD8S3SMuVEqmxiKfwHUbcrTjTyVr1PJ79WUp_t0NkNiKbrUUkSrdVXWTR0ToyPZKOG7ZH1gWIHm2zLyJ-svGgTbBmw2zN6pMJ4e6y5ILiyyAOeBZhKmezcQvtbrKCJ49ya9l4NAoSExqXxgdQwpMbvRMpPtrUODBhv-rSbkmWRTN6ukbn3a5xg.AT1_a4xgGHex
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MapzTheme {
        Greeting("Android")
    }
}