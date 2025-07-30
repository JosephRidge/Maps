https://developers.arcgis.com/kotlin/get-started/

https://developers.arcgis.com/kotlin/maps-2d/tutorials/display-a-map/

https://stackoverflow.com/questions/72023432/plugin-id-com-google-android-libraries-mapsplatform-secrets-gradle-plugin-w


Add Secrets: 
- Add dependency: 
in your app build.gradle:
 ` implementation(libs.secrets.gradle.plugin)`

int your libs.versions.toml file: 
 
- under dependencies:
`secrets-gradle-plugin = { module = "com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin", version.ref = "secretsGradlePlugin" }`

- under the [versions]:
`secretsGradlePlugin = "2.0.1"`


- create [secrets.properties](secrets.properties) file in the root project directory
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

- add this under a sectoin on its own:
```agsl
secrets {
    // To add your Maps API key to this project:
    // 1. If the secrets.properties file does not exist, create it in the same folder as the local.properties file.
    // 2. Add this line, where YOUR_API_KEY is your API key:
    //        MAPS_API_KEY=YOUR_API_KEY
    propertiesFileName = "secrets.properties"

    // A properties file containing default secret values. This file can be
    // checked in version control.
    defaultPropertiesFileName = "local.properties"
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


