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
    val signer_id: Int, //Идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем.
    val can_pin: Boolean, //Информация о том, может ли текущий пользователь закрепить запись.
    val can_delete: Boolean, //Информация о том, может ли текущий пользователь удалить запись.
    val can_edit: Boolean, //Информация о том, может ли текущий пользователь редактировать запись.
    val is_pinned: Boolean, //Информация о том, что запись закреплена.
    val marked_as_ads: Boolean, //Информация о том, содержит ли запись отметку "реклама"
    val is_favorite: Boolean, //true, если объект добавлен в закладки у текущего пользователя.
    val donut: Donut, //Информация о записи VK Donut.
    val postponed_id: Int //Идентификатор отложенной записи. Это поле возвращается тогда, когда запись стояла на таймере.
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

data class Donut(
    val is_donut: Boolean, //запись доступна только платным подписчикам VK Donut
    val paid_duration: Int, //время, в течение которого запись будет доступна только платным подписчикам VK Donut
    val can_publish_free_copy: Boolean, //можно ли открыть запись для всех пользователей, а не только подписчиков VK Donut
    val edit_mode: String //информация о том, какие значения VK Donut можно изменить в записи
)

object WallService {
    private var posts = emptyArray<Post>()
    private var origId = 0

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
        12,
        true,
        true,
        true,
        false,
        false,
        true,
        Donut(false, 0, false, ""),
        12
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
        13,
        true,
        true,
        true,
        false,
        false,
        true,
        Donut(false, 0, false, ""),
        13
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
    WallService.add(postOne)
    WallService.add(postTwo)

    WallService.add(postTwo)
}