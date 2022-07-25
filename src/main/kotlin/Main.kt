data class Post(
    val id: Int, //Идентификатор записи.
    val owner_id: Int, //Идентификатор владельца стены, на которой размещена запись.
    val from_id: Int, //Идентификатор автора записи (от чьего имени опубликована запись).
    val created_by: Int, //Идентификатор администратора, который опубликовал запись.
    val date: Int, //Время публикации записи.
    val text: String, //Текст записи.
    val reply_owner_id: Int, //Идентификатор владельца записи, в ответ на которую была оставлена текущая.
    val reply_post_id: Int, //Идентификатор записи, в ответ на которую была оставлена текущая.
    val friends_only: Boolean, //1, если запись была создана с опцией «Только для друзей».
    val comments: Comments, //Информация о комментариях к записи.
    val copyright: Copyright, //Источник материала.
    val likes: Likes, //Информация о лайках к записи.
    val reposts: Reposts, //Информация о репостах записи («Рассказать друзьям»).
    val views: Views, //Информация о просмотрах записи.
    val post_type: String, //Тип записи.
    val post_source: Source, //Информация о способе размещения записи
    val geo: Geo, //Информация о местоположении
    val signer_id: Int, //Идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем.
    val can_pin: Boolean, //Информация о том, может ли текущий пользователь закрепить запись.
    val can_delete: Boolean, //Информация о том, может ли текущий пользователь удалить запись.
    val can_edit: Boolean, //Информация о том, может ли текущий пользователь редактировать запись.
    val is_pinned: Boolean, //Информация о том, что запись закреплена.
    val marked_as_ads: Boolean, //Информация о том, содержит ли запись отметку "реклама"
    val is_favorite: Boolean, //true, если объект добавлен в закладки у текущего пользователя.
    val donut: Donut, //Информация о записи VK Donut.
    val postponed_id: Int, //Идентификатор отложенной записи. Это поле возвращается тогда, когда запись стояла на таймере.
    val attachments: Array<Attachment>
)

data class Comments(
    val count: Int, //количество комментариев
    val canPost: Boolean, //информация о том, может ли текущий пользователь комментировать запись
    val groupsCanPost: Boolean, //информация о том, могут ли сообщества комментировать запись
    val canClose: Boolean, //может ли текущий пользователь закрыть комментарии к записи
    val canOpen: Boolean //может ли текущий пользователь открыть комментарии к записи
)

data class Copyright(
    val id: Int,
    val link: String,
    val name: String,
    val type: String
)

data class Likes(
    val count: Int, //число пользователей, которым понравилась запись
    val user_likes: Boolean, //наличие отметки «Мне нравится» от текущего пользователя
    val can_like: Boolean, //информация о том, может ли текущий пользователь поставить отметку «Мне нравится»
    val can_publish: Boolean //информация о том, может ли текущий пользователь сделать репост записи
)

data class Reposts(
    val count: Int, //число пользователей, скопировавших запись
    val user_reposted: Boolean //наличие репоста от текущего пользователя
)

data class Views(
    val count: Int //число просмотров записи
)

data class Source(
    val type: String, //Тип источника.
    val platform: String, //Название платформы, если оно доступно.
    val data: String, //Тип действия (только для type = vk или widget).
    val url: String //URL ресурса, с которого была опубликована запись.
)

data class Geo(
    val type: String, // Тип места.
    val coordinates: String,// Координаты места.
    val place: Place // Описание места (если оно добавлено).
)

data class Place(
    val id: Int, //Идентификатор места.
    val title: String, //Название места.
    val latitude: Int, //Географическая широта, заданная в градусах (от -90 до 90).
    val longitude: Int, //Географическая широта, заданная в градусах (от -90 до 90).
    val created: Int, //Дата создания места в Unixtime.
    val icon: String, //Иконка места, URL изображения.
    val checkins: Int, //Число отметок в этом месте.
    val updated: Int, //Дата обновления места в Unixtime.
    val type: Int, //Тип места.
    val country: Int, //Идентификатор страны.
    val city: Int, //Идентификатор города.
    val address: String //Адрес места.
)

data class Donut(
    val is_donut: Boolean, //запись доступна только платным подписчикам VK Donut
    val paid_duration: Int, //время, в течение которого запись будет доступна только платным подписчикам VK Donut
    val can_publish_free_copy: Boolean, //можно ли открыть запись для всех пользователей, а не только подписчиков VK Donut
    val edit_mode: String //информация о том, какие значения VK Donut можно изменить в записи
)

interface Attachment {
    val type: String
}

data class Comment(
    val id: Int, //Идентификатор комментария.
    val from_id: Int, //Идентификатор автора комментария.
    val date: Int, //Дата создания комментария в формате Unixtime.
    val text: String, //Текст комментария.
    val donut: Donat, //Информация о VK Donut.
    val reply_to_user: Int, //Идентификатор пользователя или сообщества, в ответ которому оставлен текущий комментарий (если применимо).
    val reply_to_comment: Int, //Идентификатор комментария, в ответ на который оставлен текущий (если применимо).
    val attachment: Attachment?, //Медиавложения комментария (фотографии, ссылки и т.п.).
    val thread: Сomment_thread //Информация о вложенной ветке комментариев.
)

data class Donat(
    val is_don: Boolean, //Является ли комментатор подписчиком VK Donut.
    val placeholder: String  //Заглушка для пользователей, которые не оформили подписку VK Donut.
)

data class Сomment_thread(
    val count: Int,
    val can_post: Boolean,
    val show_reply_button: Boolean,
    val groups_can_post: Boolean
)

class PostNotFoundException(message: String): RuntimeException(message)

object WallService {
    private var posts = emptyArray<Post>()
    private var origId = 0
    private var comments = emptyArray<Comment>()

    fun add(post: Post): Post {
        var originId = true
        if (posts.size == 0) {
            posts += post.copy(id = ++origId)
        } else {
            for (postValue in posts) {
                if (post.id == postValue.id) originId = false
            }
            if (originId == true) {
                posts += post.copy(id = ++origId)
            }
        }
        return posts.last()
    }

    fun update(post: Post): Boolean {
        var isUpdate = false
        for ((index, postCheck) in posts.withIndex()) {
            if (postCheck.id == post.id) {
                posts[index] = post.copy(from_id = postCheck.from_id, date = postCheck.date)
                isUpdate = true
            }
        }
        return isUpdate
    }

    fun createComment(postId: Int, comment: Comment): Comment {
        var isPost = false
        for ((index, postCheck) in posts.withIndex()) {
            if (postCheck.id == postId) {
                isPost = true
            }
        }
        if (isPost == true) {
            comments += comment
        } else {
            throw  PostNotFoundException("Такого поста нет!")
        }
        return comments.last()
    }
}

fun main() {
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

    var postTwo = Post(
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
        arrayOf(Photo(1,1,1,1,"Photo1",11072022, arrayOf(Sizes("m","Photo1", 100,100))))
    )

    var postThree = Post(
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
        arrayOf(Photo(1,1,1,1,"Photo1",11072022, arrayOf(Sizes("m","Photo1", 100,100))))
    )

    var postOneUpdate = Post(
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
        arrayOf(Photo(1,1,1,1,"Photo1",11072022, arrayOf(Sizes("m","Photo1", 100,100))))
    )
    WallService.add(postOne)
    WallService.add(postTwo)

    WallService.add(postTwo)

    val commentOne = Comment(1,1,1657788280,"Комментарий 1", Donat(false,""),2,2,null, Сomment_thread(0,true,true,true))
}