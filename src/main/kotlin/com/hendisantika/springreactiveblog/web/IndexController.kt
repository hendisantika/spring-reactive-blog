package com.hendisantika.springreactiveblog.web

import com.hendisantika.springreactiveblog.repository.PostRepository
import com.hendisantika.springreactiveblog.utils.MarkDownConverter
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.reactive.result.view.Rendering

/**
 * Created by IntelliJ IDEA.
 * Project : spring-reactive-blog
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/06/18
 * Time: 06.44
 * To change this template use File | Settings | File Templates.
 */
@Controller
class IndexController(private val postRepository: PostRepository, private val markDownConverter: MarkDownConverter) {

    @GetMapping("/")
    fun home(): Rendering {
        return Rendering
                .view("index")
                .modelAttribute("posts", this.postRepository.findAll()
                        .map { it.toDto(markDownConverter) })
                .build()
    }
}