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

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.DensityAmbient
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.evo.composetoedge.components.Messages
import com.evo.composetoedge.data.initialPosts
import com.evo.composetoedge.ui.ComposeToEdgeTheme

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setEdgeToEdgeContent {
      ComposeToEdgeTheme {
        Surface(color = MaterialTheme.colors.background) {

          val topPadding: Dp
          val bottomPadding: Dp

          with(DensityAmbient.current) {
            topPadding = WindowInsetsAmbient.current.systemWindowInsetTop.toDp()
            bottomPadding = WindowInsetsAmbient.current.systemWindowInsetBottom.toDp()
          }

          ScrollableColumn(
                  modifier = Modifier.fillMaxSize(),
                  contentPadding = PaddingValues(
                          top = topPadding,
                          bottom = bottomPadding,
                  )
          ) {
            Messages(posts = initialPosts, modifier = Modifier.padding(start = 16.dp))
          }
        }
      }
    }
  }
}