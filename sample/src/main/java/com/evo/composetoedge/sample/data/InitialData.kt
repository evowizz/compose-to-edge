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

package com.evo.composetoedge.sample.data

import com.evo.composetoedge.sample.components.Post

/**
 * Created by Dylan Roussel on 23/10/2020
 */

val androidPost = Post("Android", "Hello, world!")

val initialPosts = arrayListOf(
        Post("evowizz", "Just released my first Jetpack Compose library, which " +
                "makes it really easy for you to develop edge-to-edge apps!"),

        androidPost,
        Post("Jetpack Compose", """This is a row!
          |is
          |a
          |column!
        """.trimMargin())
)