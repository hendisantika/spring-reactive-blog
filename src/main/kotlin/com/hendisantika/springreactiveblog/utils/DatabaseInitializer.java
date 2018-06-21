package com.hendisantika.springreactiveblog.utils;

import com.hendisantika.springreactiveblog.domain.Post;
import com.hendisantika.springreactiveblog.domain.User;
import com.hendisantika.springreactiveblog.repository.PostRepository;
import com.hendisantika.springreactiveblog.repository.UserRepository;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-reactive-blog
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/06/18
 * Time: 18.14
 * To change this template use File | Settings | File Templates.
 */
@Component
public class DatabaseInitializer implements SmartInitializingSingleton {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public DatabaseInitializer(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void afterSingletonsInstantiated() {

        User user1 = new User("hendisantika");
        User user2 = new User("naruto");

        Post post1 = new Post(
                "Spring5 reactive",
                "With the release of [Spring Framework 5.0](https://spring.io/blog/2017/09/28/spring-framework-5-0-goes-ga) now just happening, you can imagine this is a giant step for Project Reactor :)\n",
                user1,
                LocalDateTime.of(2017, 9, 28, 12, 0)
        );
        Post post2 = new Post(
                "Spring5 reactive source",
                "" +
                        "```java\n" +
                        "@SpringBootApplication\n" +
                        "public class SpringReactiveBlogApplication {\n" +
                        "\n" +
                        "\tpublic static void main(String[] args) {\n" +
                        "\t\tSpringApplication.run(SpringReactiveBlogApplication.class, args);\n" +
                        "\t}\n" +
                        "}\n```\n",
                user2,
                LocalDateTime.of(2017, 11, 20, 11, 10)
        );
        Post post3 = new Post(
                "Spring reactor",
                "### Flux \n A Reactive Streams Publisher with rx operators that emits `0` to `N` elements, and then completes (successfully or with an error). \n ### Mono  \n A Reactive Streams Publisher with basic rx operators that completes successfully by emitting an element, or with an error.\n",
                user1,
                LocalDateTime.of(2017, 12, 25, 07, 16)
        );

        userRepository.deleteAll()
                .thenMany(postRepository.deleteAll())
                .thenMany(this.userRepository.saveAll(Arrays.asList(user1, user2)))
                .thenMany(postRepository.saveAll(Arrays.asList(post1, post2, post3)))
                .thenMany(postRepository.findAll())
                .subscribe(System.out::println);

    }
}