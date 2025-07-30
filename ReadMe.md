https://developers.arcgis.com/kotlin/get-started/

https://developers.arcgis.com/kotlin/maps-2d/tutorials/display-a-map/

https://stackoverflow.com/questions/72023432/plugin-id-com-google-android-libraries-mapsplatform-secrets-gradle-plugin-w


Add Secrets: 

create [secrets.properties](secrets.properties) file in the root project directory
add your api_key there eg MAP_API_KEY

Navigate to app level build.gradle and add:
- 
`id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin") version "2.0.1" ` 
under the plugins section such that you have:


```agsl

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin") version "2.0.1"

}
```

- Add this: `buildConfigField("String", "MAP_ACCESS_TOKEN", "\"${project.findProperty("MAP_ACCESS_TOKEN")}\"")`

```agsl
 defaultConfig {
        applicationId = "com.jayr.mapz"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField("String", "MAP_ACCESS_TOKEN", "\"${project.findProperty("MAP_ACCESS_TOKEN")}\"")
        vectorDrawables {
            useSupportLibrary = true
        }

```

- Modify the `buildFeatures` config by modifying it this way: 
```agsl
   buildFeatures {
        compose = true
        buildConfig = true
    }
```


