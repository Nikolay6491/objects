package ru.netology

import Comments
import Copyright
import Donut
import Likes
import Post
import Reposts
import Views
import WallService
import org.junit.Test

import org.junit.Assert.*

class WallTests {

    @Test
    fun add() {
        val  postAdd = Post(
            1,
            11,
            11,
            11,
            11072022,
            "message1",
            10,
            2,
            false,
            Comments(25, true, true, true, true),
            Copyright(11, "www.netology.ru", "data class", "Post"),
            Likes(15, true, true, true),
            Reposts(15, true),
            Views(1000),
            "post",
            11,
            true,
            true,
            true,
            false,
            false,
            true,
            Donut(false, 0, false, ""),
            11
        )

        val nextId = postAdd.id
        assertEquals(1,nextId)
    }

    @Test
    fun update() {
        val service = WallService
        service.add(Post(
            1,
            11,
            11,
            11,
            11072022,
            "message1",
            10,
            2,
            false,
            Comments(25, true, true, true, true),
            Copyright(11, "www.netology.ru", "data class", "Post"),
            Likes(15, true, true, true),
            Reposts(15, true),
            Views(1000),
            "post",
            11,
            true,
            true,
            true,
            false,
            false,
            true,
            Donut(false, 0, false, ""),
            11
        ))
        service.add(Post(
            2,
            12,
            12,
            12,
            12072022,
            "message2",
            11,
            1,
            false,
            Comments(29, true, true, true, true),
            Copyright(12, "www.netology.ru", "Services", "Post"),
            Likes(35, true, true, true),
            Reposts(14, true),
            Views(1200),
            "post",
            12,
            true,
            true,
            true,
            false,
            false,
            true,
            Donut(false, 0, false, ""),
            12
        ))
        service.add(Post(
            3,
            13,
            13,
            13,
            13072022,
            "message3",
            12,
            2,
            true,
            Comments(29, true, true, true, true),
            Copyright(12, "www.netology.ru", "Services", "Post"),
            Likes(37, true, true, true),
            Reposts(104, true),
            Views(2300),
            "post",
            13,
            true,
            true,
            true,
            false,
            false,
            true,
            Donut(false, 0, false, ""),
            13
        ))

        val update1 = Post(
            1,
            22,
            21,
            22,
            15072022,
            "message4",
            10,
            2,
            false,
            Comments(45, true, true, true, true),
            Copyright(11, "www.netology.ru", "data class", "Post"),
            Likes(145, true, true, true),
            Reposts(25, true),
            Views(700),
            "post",
            11,
            true,
            true,
            true,
            false,
            false,
            true,
            Donut(false, 0, false, ""),
            11
        )

        val update2 = Post(
            4,
            32,
            23,
            32,
            13072022,
            "message4",
            10,
            2,
            false,
            Comments(65, true, true, true, true),
            Copyright(31, "www.netology.ru", "data class", "Post"),
            Likes(15, true, true, true),
            Reposts(25, true),
            Views(700),
            "post",
            11,
            true,
            true,
            true,
            false,
            false,
            true,
            Donut(false, 0, false, ""),
            31
        )

        val result1 = service.update(update1)
        assertTrue(result1)

        val result2 = service.update(update2)
        assertFalse(result2)
    }
}