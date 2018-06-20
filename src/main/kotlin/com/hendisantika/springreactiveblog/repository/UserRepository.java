package com.hendisantika.springreactiveblog.repository;

import com.hendisantika.springreactiveblog.domain.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-reactive-blog
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/06/18
 * Time: 11.47
 * To change this template use File | Settings | File Templates.
 */
public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
