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

package com.evo.composetoedge.components

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Stack
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview

/**
 * Created by Dylan Roussel on 23/10/2020
 */

private val AvatarColors = arrayOf(
        0xFFFAC302,
        0xFF02C3FA,
        0xFFC302FA,
        0xFF02FAC3
)

@Composable
fun Avatar(name: String) {
  Surface(
          color = Color(AvatarColors.random()),
          modifier = Modifier.size(54.dp).clip(RoundedCornerShape(50))
  ) {
    Text(text = name.first().toUpperCase().toString(), fontSize = 16.sp)
  }
}

@Preview
@Composable
fun PreviewAvatar() {
  Avatar(name = "Android")
}