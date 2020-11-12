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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.evo.composetoedge.data.androidPost

/**
 * Created by Dylan Roussel on 23/10/2020
 */

@Composable
fun Messages(posts: List<Post>, modifier: Modifier) {
  repeat(4) { repeat: Int ->
    posts.forEachIndexed { index, post ->
      val topPadding = if (index != 0 || repeat != 0) 16.dp else 8.dp

      Message(post = post, modifier = Modifier.padding(top = topPadding).then(modifier))
    }
  }

}

@Composable
fun Message(
  post: Post,
  modifier: Modifier = Modifier
) {
  val bubbleColor =
    if (MaterialTheme.colors.isLight) Color(0xFFF5F5F5) else Color(0xFF222222)

  ConstraintLayout(Modifier.fillMaxWidth().then(modifier)) {
    // Declaring them separately for visibility
    val (avatar, username) = createRefs()
    val (message, moreOptions) = createRefs()

    Avatar(
      name = post.username,
      modifier = Modifier.constrainAs(avatar) {
        start.linkTo(parent.start)
        top.linkTo(parent.top)
      }
    )

    Text(
      text = post.username,
      style = MaterialTheme.typography.body1,
      fontWeight = FontWeight.Medium,
      color = MaterialTheme.colors.onBackground,
      modifier = Modifier.constrainAs(username) {
        start.linkTo(avatar.end, 12.dp)
      }
    )

    // Message bubble
    Surface(
      color = bubbleColor,
      shape = RoundedCornerShape(0.dp, 8.dp, 8.dp, 8.dp),
      modifier = Modifier.constrainAs(message) {
        width = Dimension.preferredWrapContent.atMostWrapContent
        top.linkTo(username.bottom, 4.dp)
        linkTo(username.start, moreOptions.start, endMargin = 16.dp, bias = 0f)
      }
    ) {
      Text(
        text = post.message,
        style = MaterialTheme.typography.subtitle1,
        modifier = Modifier.padding(8.dp)
      )
    }

    // More Options
    Surface(
      color = bubbleColor,
      shape = RoundedCornerShape(50),
      modifier = Modifier.size(32.dp).constrainAs(moreOptions) {
        end.linkTo(parent.end, 16.dp)
        centerVerticallyTo(message)
      }
    ) {
      Image(
        asset = Icons.Filled.MoreVert,
        modifier = Modifier.size(24.dp),
        colorFilter = ColorFilter.tint(MaterialTheme.colors.onBackground.copy(alpha = 0.60f))
      )
    }
  }
}

@Preview
@Composable
fun PreviewMesssage() {
  Surface(color = Color.White) {
    Message(androidPost)
  }
}


data class Post(val username: String, val message: String)