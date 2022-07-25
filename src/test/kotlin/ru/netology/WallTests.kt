package ru.netology

import Comment
import Comments
import Copyright
import Donat
import Donut
import Geo
import Likes
import Photo
import Place
import Post
import PostNotFoundException
import Reposts
import Sizes
import Source
import Video
import Views
import WallService
import org.junit.Test

import org.junit.Assert.*
import Сomment_thread

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
            Source("vk", "android", "profile_activity", "netology.ru"),
            Geo("Саратов", "51.544413, 46.050268",
                Place(1,"Журавли",51544413,46050268,2041980,"https://upload.wikimedia.org/wikipedia/ru/thumb/6/6f/Памятник_Журавли_%28Саратов%29.jpg/1280px-Памятник_Журавли_%28Саратов%29.jpg",
                    10,9052000,1,643,8452,"Парк Победы")),
            11,
            true,
            true,
            true,
            false,
            false,
            true,
            Donut(false, 0, false, ""),
            11,
            arrayOf(Photo(1,1,1,1,"Photo1",11072022, arrayOf(Sizes("m","Photo1", 640,480)))),
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
            Source("vk", "android", "profile_activity", "netology.ru"),
            Geo("Саратов", "51.544413, 46.050268",
                Place(1,"Журавли",51544413,46050268,2041980,"https://upload.wikimedia.org/wikipedia/ru/thumb/6/6f/Памятник_Журавли_%28Саратов%29.jpg/1280px-Памятник_Журавли_%28Саратов%29.jpg",
                    10,9052000,1,643,8452,"Парк Победы")),
            11,
            true,
            true,
            true,
            false,
            false,
            true,
            Donut(false, 0, false, ""),
            11,
            arrayOf(Photo(1,1,1,1,"Photo1",11072022, arrayOf(Sizes("m","Photo1", 640,480))))
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
            Source("vk", "android", "profile_activity", "netology.ru"),
            Geo("Саратов", "51.544413, 46.050268",
                Place(1,"Журавли",51544413,46050268,2041980,"https://upload.wikimedia.org/wikipedia/ru/thumb/6/6f/Памятник_Журавли_%28Саратов%29.jpg/1280px-Памятник_Журавли_%28Саратов%29.jpg",
                    10,9052000,1,643,8452,"Парк Победы")),
            12,
            true,
            true,
            true,
            false,
            false,
            true,
            Donut(false, 0, false, ""),
            12,
            arrayOf(Photo(1,1,1,1,"Photo1",11072022, arrayOf(Sizes("m","Photo1", 640,480))))
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
            Source("vk", "android", "profile_activity", "netology.ru"),
            Geo("Саратов", "51.544413, 46.050268",
                Place(1,"Журавли",51544413,46050268,2041980,"https://upload.wikimedia.org/wikipedia/ru/thumb/6/6f/Памятник_Журавли_%28Саратов%29.jpg/1280px-Памятник_Журавли_%28Саратов%29.jpg",
                    10,9052000,1,643,8452,"Парк Победы")),
            13,
            true,
            true,
            true,
            false,
            false,
            true,
            Donut(false, 0, false, ""),
            13,
            arrayOf(Photo(1,1,1,1,"Photo1",11072022, arrayOf(Sizes("m","Photo1", 640,480))))
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
            Source("vk", "android", "profile_activity", "netology.ru"),
            Geo("Саратов", "51.544413, 46.050268",
                Place(1,"Журавли",51544413,46050268,2041980,"https://upload.wikimedia.org/wikipedia/ru/thumb/6/6f/Памятник_Журавли_%28Саратов%29.jpg/1280px-Памятник_Журавли_%28Саратов%29.jpg",
                    10,9052000,1,643,8452,"Парк Победы")),
            11,
            true,
            true,
            true,
            false,
            false,
            true,
            Donut(false, 0, false, ""),
            11,
            arrayOf(Photo(1,1,1,1,"Photo1",11072022, arrayOf(Sizes("m","Photo1", 640,480))))
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
            Source("vk", "android", "profile_activity", "netology.ru"),
            Geo("Саратов", "51.544413, 46.050268",
                Place(1,"Журавли",51544413,46050268,2041980,"https://upload.wikimedia.org/wikipedia/ru/thumb/6/6f/Памятник_Журавли_%28Саратов%29.jpg/1280px-Памятник_Журавли_%28Саратов%29.jpg",
                    10,9052000,1,643,8452,"Парк Победы")),
            11,
            true,
            true,
            true,
            false,
            false,
            true,
            Donut(false, 0, false, ""),
            31,
            arrayOf(Photo(1,1,1,1,"Photo1",11072022, arrayOf(Sizes("m","Photo1", 640,480))))
        )

        val result1 = service.update(update1)
        assertTrue(result1)

        val result2 = service.update(update2)
        assertFalse(result2)
    }

    @Test(expected = PostNotFoundException::class)
    fun createComment() {
        val commentOne = Comment(1,1,1657788280,"Комментарий 1", Donat(false,""),2,2,null, Сomment_thread(0,true,true,true))
        WallService.createComment(11,commentOne)
    }

    @Test
    fun createCommentTrueId() {
        val commentOne = Comment(1,1,1657788280,"Комментарий 1", Donat(false,""),2,2,null,Сomment_thread(0,true,true,true))
        var postOne = Post(
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
            Source("vk", "android", "profile_activity", "netology.ru"),
            Geo("Саратов", "51.544413, 46.050268",
                Place(1,"Журавли",51544413,46050268,2041980,"https://upload.wikimedia.org/wikipedia/ru/thumb/6/6f/Памятник_Журавли_%28Саратов%29.jpg/1280px-Памятник_Журавли_%28Саратов%29.jpg",
                    10,9052000,1,643,8452,"Парк Победы")),
            11,
            true,
            true,
            true,
            false,
            false,
            true,
            Donut(false, 0, false, ""),
            11,
            arrayOf(Photo(1,1,1,1,"Photo1",11072022, arrayOf(Sizes("m","Photo1", 100,100))))
        )
        WallService.add(postOne)
        assertEquals(commentOne,WallService.createComment(1, commentOne))
    }

    @Test
    fun createCommentFalseId() {
        val commentOne = Comment(1,1,1657788280,"Комментарий 1", Donat(false,""),2,2,null,Сomment_thread(0,true,true,true))
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
            Source("vk", "android", "profile_activity", "netology.ru"),
            Geo("Саратов", "51.544413, 46.050268",
                Place(1,"Журавли",51544413,46050268,2041980,"https://upload.wikimedia.org/wikipedia/ru/thumb/6/6f/Памятник_Журавли_%28Саратов%29.jpg/1280px-Памятник_Журавли_%28Саратов%29.jpg",
                    10,9052000,1,643,8452,"Парк Победы")),
            11,
            true,
            true,
            true,
            false,
            false,
            true,
            Donut(false, 0, false, ""),
            31,
            arrayOf(Photo(1,1,1,1,"Photo1",11072022, arrayOf(Sizes("m","Photo1", 640,480))))
        )
        WallService.add(update2)
        assertEquals(commentOne,WallService.createComment(1, commentOne))
    }
}

