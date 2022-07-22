import Attachment

open class  AudioAttachment(
    override val type: String = "Audio",
): Attachment

open class VideoAttachment(
    override val type: String = "Video"
) : Attachment

open class  PhotoAttachment(
    override val type: String = "Photo"
): Attachment

open class  FileAttachment(
    override val type: String = "File"
): Attachment

open class  GraffitiAttachment(
    override val type: String = "Graffiti",
): Attachment

class Audio(
    val id: Int, //Идентификатор аудиозаписи
    val ownerId: Int, //Идентификатор владельца аудиозаписи
    val artist: String, //Исполнитель
    val title: String, //Название композиции
    val duration: Int, //Длительность аудиозаписи в секундах
    val url: String, //Ссылка на mp3
    val lyricsId: Int?, //Идентификатор текста аудиозаписи (если доступно)
    val albumId: Int?, //Идентификатор альбома, в котором находится аудиозапись (если присвоен)
    val genreId: Int, //Идентификатор жанра из списка аудио жанров
    val date: Int, //Дата добавления
    val noSearch: Boolean, //true, если включена опция «Не выводить при поиске». Если опция отключена, поле не возвращается
    val isHq: Boolean, //true, если аудио в высоком качестве
    override val type: String = "Audio"
): AudioAttachment()

class Video(
    val id: Int, //Идентификатор видеозаписи
    val ownerId: Int, //Идентификатор владельца видеозаписи
    val title: String, //Название видеозаписи
    val description: String, //Текст описания видеозаписи
    val duration: Int, //Длительность ролика в секундах
    val image: Array<Image>, //Изображение обложки. Содержит массив объектов с полями
    val firstFrame: Array<firstFrame>, //Изображение первого кадра. Содержит массив объектов с полями
    val date: Int, //Дата создания видеозаписи в формате Unixtime
    val addingDate: Int, //Дата добавления видеозаписи пользователем или группой в формате Unixtime
    val views: Int, //Количество просмотров видеозаписи
    val localViews: Int, //Если видео внешнее, количество просмотров ВКонтакте
    val comments: Int?, //Количество комментариев к видеозаписи. Поле не возвращается, если комментарии недоступны.
    val player: String, //URL страницы с плеером, который можно использовать для воспроизведения ролика в браузере.
    val platform: String, //Название платформы (для видеозаписей, добавленных с внешних сайтов)
    val canAdd: Boolean, //Может ли пользователь добавить видеозапись к себе
    val isPrivate: Boolean, //Поле возвращается, если видеозапись приватная
    val access_Key: String, //Ключ доступа к объекту.
    val processing: Int, //Поле возвращается в том случае, если видеоролик находится в процессе обработки, всегда содержит 1
    val isFavorite: Boolean, //true, если объект добавлен в закладки у текущего пользователя
    val canComment: Boolean, //Может ли пользователь комментировать видео
    val canEdit: Boolean, //Может ли пользователь редактировать видео
    val canLike: Boolean, //Может ли пользователь добавить видео в список <<Мне нравится>>
    val canRepost: Boolean, //Может ли пользователь сделать репост видео
    val canSubscribe: Boolean, //Может ли пользователь подписаться на автора видео
    val canAddToFaves: Boolean, //Может ли пользователь добавить видео в избранное
    val canAttachLink: Boolean, //Может ли пользователь прикрепить кнопку действия к видео
    val width: Int, //Ширина видео
    val height: Int, //Высота видео
    val userId: Int, //Идентификатор пользователя, загрузившего видео, если оно было загружено в группу одним из участников
    val converting: Boolean, //Конвертируется ли видео
    val added: Int, //Добавлено ли видео в альбомы пользователя
    val isSubscribed: Boolean, //Подписан ли пользователь на автора видео
    val repeat: Int, //Поле возвращается в том случае, если видео зациклено, всегда содержит 1
    val types: String, //Тип видеозаписи.
    val balance: Int, //Баланс донатов в прямой трансляции
    val liveStatus: String, //Статус прямой трансляции. Может принимать значения: waiting, started, finished, failed, upcoming
    val live: Boolean, //Поле возвращается в том случае, если видеозапись является прямой трансляцией
    val upcoming: Int, //Поле свидетельствует о том, что трансляция скоро начнётся. Для live =1
    val spectators: Int, //Количество зрителей прямой трансляции
    val likes: LikesVideo, //Содержит объект отметки «Мне нравится».
    val reposts: RepostsVideo, //Содержит объект репоста.
    override val type: String = "Video"
): VideoAttachment()

data class RepostsVideo(
    val count: Int, //счетчик общего количества репостов. Содержит сумму репостов на стену и в личные сообщения
    val userReposted: Boolean,   //информация о том, сделал ли текущий пользователь репост этого видео.
    val wallCount: Int, //счетчик репостов на стену
    val mailCount: Int //счетчик репостов в личные сообщения
)

data class LikesVideo(
    val count: Int, //количество лайков
    val userLikes: Boolean,    // добавлено ли видео в список «Мне нравится» текущего пользователя.
)

data class Image(
    val height: Int, //высота изображения
    val url: String, //ссылка на изображение.
    val width: Int, //ширина изображения
    val withPadding: Int, //поле возвращается, если изображение с отбивкой, всегда содержит 1
)

data class firstFrame(
    val height: Int,
    val width: Int,
    val url:String
)

class Photo(
    val id: Int, //Идентификатор фотографии
    val albumId: Int, //Идентификатор альбома, в котором находится фотография
    val ownerId: Int, //Идентификатор владельца фотографии
    val userId: Int, //Идентификатор пользователя, загрузившего фото
    val text: String, //Текст описания фотографии
    val date: Int, //Дата добавления в формате Unixtime,
    val sizes: Array<Sizes>, //Массив с копиями изображения в разных размерах
    override val type: String = "Photo"
): PhotoAttachment()

data class Sizes(
    val typeCopy: String, //тип копии
    val url: String, //URL копии
    val width: Int, //высота в px
    val height: Int, //ширина в px
)

class File(
    val id: Int, //Идентификатор файла
    val ownerId: Int, //Идентификатор пользователя, загрузившего файл
    val title: String, //Название файла
    val size: Int,  //Размер файла в байтах
    val ext: String, //Расширение файла
    val url: String, //Адрес файла, по которому его можно загрузить.
    val date: Int, //Дата добавления в формате Unixtime
    val types: Int, //Тип файла.
    val preview: Preview, //Информация для предварительного просмотра файла
    override val type: String = "File"
): FileAttachment()

data class Preview(
    val photo: Photos, //изображения для предпросмотра
    val graffitis: Graffitis, //данные о граффити
    val audioMessage: AudioMessage //данные об аудиосообщении
)

data class Photos(
    val sizes: Array<Int> //массив копий изображения в разных размерах
)

data class Graffitis(
    val src: String, // URL файла с граффити
    val width: Int, //ширина изображения в px
    val height: Int //высота изображения в px
)

data class  AudioMessage(
    val duration: Int, // длительность аудиосообщения в секундах
    val waveform: Array<Int>, //массив значений (integer) для визуального отображения звука
    val linkOgg: String, //URL .ogg-файла
    val linkMp3: String //URL .mp3-файла
)

class Graffiti(
    val id: Int,
    val ownerId: Int,
    val url: String,
    val width: Int,
    val height: Int,
    override val type: String = "Graffiti"
): FileAttachment()