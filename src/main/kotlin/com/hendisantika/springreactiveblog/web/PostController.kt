package com.hendisantika.springreactiveblog.web

import com.hendisantika.springreactiveblog.repository.PostRepository
import com.hendisantika.springreactiveblog.utils.MarkDownConverter
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.reactive.result.view.Rendering

/**
 * Created by IntelliJ IDEA.
 * Project : spring-reactive-blog
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/06/18
 * Time: 06.47
 * To change this template use File | Settings | File Templates.
 */
@Controller
class PostController(private val postRepository: PostRepository, private val markDownConverter: MarkDownConverter) {

    @GetMapping("/{title}")
    fun home(@PathVariable title: String): Rendering {
        return Rendering
                .view("post")
                .modelAttribute("post", this.postRepository.findByTitle(title)
                        .map { it.toDto(markDownConverter) })
                .build()
    }
}