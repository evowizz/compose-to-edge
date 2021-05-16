# Compose-To-Edge

[![](https://jitpack.io/v/evowizz/compose-to-edge.svg)](https://jitpack.io/#evowizz/compose-to-edge) ![Build](https://github.com/evowizz/compose-to-edge/workflows/Build/badge.svg?branch=main)

Compose-To-Edge is a small library allowing you to easily set up edge-to-edge configurations for your Jetpack Compose app.

## DEPRECATED
Compose-To-Edge was really fun to create. But since then, some libraries have evolved and are constantly maintained.
If you are looking for something similar to Compose-To-Edge, I suggest you to look at [Accompanist](https://google.github.io/accompanist/insets/) which you can use along with [`WindowCompat.setDecorFitsSystemWindows(window, false)`](https://developer.android.com/reference/androidx/core/view/WindowCompat#setDecorFitsSystemWindows(android.view.Window,%20boolean))

## Setup
Let's start by adding Jitpack to your project.
```gradle
    allprojects {
	    repositories {
		    ...
		    maven { url 'https://jitpack.io' }
	    }
    }
```
Finally, just add the dependency.
```gradle
    dependencies {
        // Latest available version can be found at the very top of the README file
        implementation 'com.github.evowizz:compose-to-edge:$version'
    }
```

## Usage
Here's how you would start a basic Jetpack Compose project.
```kt
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyTheme {
        Greeting("Android")
      }
    }
  }
```
To get started with Compose-To-Edge, the only thing you need to do is to replace `setContent` with `setEdgeToEdgeContent` as seen in the following example.
```kt
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setEdgeToEdgeContent {
      MyTheme {
        Greeting("Android")
      }
    }
  }
```


Additionally, Compose-To-Edge provides 2 [Ambients](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Ambient) allowing you to better control your new edge-to-edge app:
* **AmbientWindow**: Static Ambient of the current window which allows you to easily change the Status Bar and Navigation Bar colors.
* **AmbientWindowInsets**: Static Ambient of the rootWindowInsets ([as WindowInsetsCompat](https://developer.android.com/reference/androidx/core/view/WindowInsetsCompat)) allowing you to easily obtain details about system insets.

The `setEdgeToEdge(edgeToEdge: Boolean)` function is still accessible if for some reasons you want to disable the edge-to-edge configuration. (_But you won't do that, right?... RIGHT?_)

This project includes [a small sample](https://github.com/evowizz/compose-to-edge/blob/main/sample/src/main/java/com/evo/composetoedge/sample/MainActivity.kt) demonstrating the usage of `setEdgeToEdgeContent` and `WindowInsetsAmbient`.
## License

```
 Copyright 2020 Dylan Roussel

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

     https://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
```
