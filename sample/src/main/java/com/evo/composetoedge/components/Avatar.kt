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

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.ColorUtils
import androidx.ui.tooling.preview.Preview
import com.evo.composetoedge.data.androidPost

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
fun Avatar(name: String, modifier: Modifier = Modifier) {
  val backgroundColor = AvatarColors.random().toInt()
  val textColor = ColorUtils.blendARGB(backgroundColor, Color.Black.toArgb(), 0.4f)
  Surface(
    color = Color(backgroundColor),
    modifier = Modifier.size(54.dp).clip(RoundedCornerShape(50)).then(modifier)
  ) {
    Box {
      Text(
        text = name.first().toUpperCase().toString(),
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        color = Color(textColor),
        modifier = Modifier.align(Alignment.Center)
      )
    }
  }
}

@Preview
@Composable
fun PreviewAvatar() {
  Avatar(name = androidPost.username)
}