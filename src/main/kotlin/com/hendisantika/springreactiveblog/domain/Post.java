package com.hendisantika.springreactiveblog.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-reactive-blog
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/06/18
 * Time: 11.38
 * To change this template use File | Settings | File Templates.
 */
@Document
public class Post {

    @Id
    private String id;

    private String title;

    private String content;

    private LocalDateTime localDateTime;

    @DBRef
    private User author;

    Post() {

    }

    public Post(String title, String content, User author) {
        this(title, content, author, LocalDateTime.now());
    }

    public Post(String title, String content, User author, LocalDateTime localDateTime) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.localDateTime = localDateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (id != null ? !id.equals(post.id) : post.id != null) return false;
        if (title != null ? !title.equals(post.title) : post.title != null) return false;
        if (content != null ? !content.equals(post.content) : post.content != null) return false;
        if (localDateTime != null ? !localDateTime.equals(post.localDateTime) : post.localDateTime != null)
            return false;
        return author != null ? author.equals(post.author) : post.author == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (localDateTime != null ? localDateTime.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", localDateTime=" + localDateTime +
                ", author=" + author +
                '}';
    }

}
