package com.jayr.mapz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.arcgismaps.ApiKey
import com.arcgismaps.ArcGISEnvironment
import com.arcgismaps.mapping.ArcGISMap
import com.arcgismaps.mapping.BasemapStyle
import com.jayr.mapz.ui.theme.MapzTheme
import com.jayr.mapz.BuildConfig

import com.arcgismaps.mapping.Viewpoint
import com.arcgismaps.toolkit.geoviewcompose.MapView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var apiKey = BuildConfig.MAP_ACCESS_TOKEN
        ArcGISEnvironment.apiKey = ApiKey.create(apiKey)
        enableEdgeToEdge()
        setContent {
            MapzTheme {
                val map = remember {
                    createMap()
                }
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   Column( modifier = Modifier.padding(innerPadding)) {
                        MainScreen(
                            modifier = Modifier.padding(innerPadding),
                            innerPadding =innerPadding,
                            map = map
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
fun MainScreen(modifier: Modifier, innerPadding: PaddingValues, map: ArcGISMap){
        MapView(
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            arcGISMap = map
        )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    fun createMap(): ArcGISMap {
        return ArcGISMap(BasemapStyle.ArcGISTopographic).apply {
            initialViewpoint = Viewpoint(
                latitude = 34.0270,
                longitude = -118.8050,
                scale = 72000.0

            )
        }
    }
    MapzTheme {
        val map = remember {
            createMap()
        }
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column( modifier = Modifier.padding(innerPadding)) {
                MainScreen(
                    modifier = Modifier.padding(innerPadding),
                    innerPadding =innerPadding,
                    map = map
                )
            }
        }
    }
}