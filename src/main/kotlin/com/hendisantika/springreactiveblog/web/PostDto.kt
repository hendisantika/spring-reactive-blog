package com.hendisantika.springreactiveblog.web

import com.hendisantika.springreactiveblog.domain.Post
import com.hendisantika.springreactiveblog.domain.User
import com.hendisantika.springreactiveblog.utils.MarkDownConverter
import com.hendisantika.springreactiveblog.utils.Utils

/**
 * Created by IntelliJ IDEA.
 * Project : spring-reactive-blog
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/06/18
 * Time: 06.21
 * To change this template use File | Settings | File Templates.
 */
data class PostDto(
        val title: String,
        val content: String,
        val addedAt: String,
        val author: User)

fun Post.toDto(markdownConverter: MarkDownConverter) = PostDto(
        title,
        markdownConverter(content),
        Utils.formatToEnglish(localDateTime),
        author
)