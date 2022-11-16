package ru.netology.repository;

import ru.netology.model.Post;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

// Stub
public class PostRepository {
  private final ConcurrentHashMap<Long, Post> posts = new ConcurrentHashMap<>();
  private final AtomicLong counter = new AtomicLong();


  public Collection<Post> all() {
    return posts.values();
  }

  public Optional<Post> getById(long id) {
    return Optional.ofNullable(posts.get((int) id));
  }

  public Post save(Post post) {
    if (post.getId() == 0) {
      long id = counter.incrementAndGet();
      post.setId(id);
      posts.put(id,post);
    } else if (post.getId() != 0) {
      Long id = post.getId();
      posts.put(id, post);
    }
    return post;
  }

  public void removeById(long id) {
    posts.remove(id);
  }
}
