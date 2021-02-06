/*
 * Copyright 2020 Dylan Roussel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.evo.composetoedge

import android.os.Build
import android.view.View
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.ui.platform.ViewAmbient
import androidx.compose.ui.platform.setContent
import androidx.core.view.WindowInsetsCompat

/**
 * Created by Dylan Roussel on 21/10/2020
 */

fun ComponentActivity.setEdgeToEdgeContent(content: @Composable () -> Unit) {
  setContent {
    setEdgeToEdge(window, edgeToEdge = true)
    Providers(
            WindowAmbient provides window,
            WindowInsetsAmbient provides window.getWindowInsetsCompat(),
            content = content
    )
  }
}

private fun Window.getWindowInsetsCompat(): WindowInsetsCompat {
  return WindowInsetsCompat.toWindowInsetsCompat(decorView.rootWindowInsets)
}

/**
 * Sets whether the app should draw behind system bars.
 */
@Composable
fun setEdgeToEdge(edgeToEdge: Boolean) {
  val window = WindowAmbient.current
  setEdgeToEdge(window, edgeToEdge = edgeToEdge)
}

@Composable
@Suppress("DEPRECATION")
private fun setEdgeToEdge(window: Window, edgeToEdge: Boolean) {
  val view = ViewAmbient.current

  //TODO: Use WindowCompat when AndroidX Core 1.5.0 is stable.
  // See: https://developer.android.com/jetpack/androidx/releases/core
  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
    window.setDecorFitsSystemWindows(!edgeToEdge)
  } else {
    view.systemUiVisibility =
            view.systemUiVisibility and EDGE_TO_EDGE_FLAGS.inv() or
                    if (edgeToEdge) EDGE_TO_EDGE_FLAGS else 0
  }
}

@Suppress("DEPRECATION")
private const val EDGE_TO_EDGE_FLAGS: Int = (View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
