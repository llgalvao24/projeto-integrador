package org.generation.brazil.backend.post;

import com.github.javafaker.Faker;
import org.generation.brazil.backend.user.User;

import java.time.Instant;
import java.util.Date;
import java.util.Locale;

public class PostMock {

  public static Post getPostMock() {

      Post Post = new Post();
    Faker faker = new Faker(new Locale("pt-BR"));
    Post.setContent(faker.hitchhikersGuideToTheGalaxy().quote());
    Post.setPostData(Date.from(Instant.now()));
    Post.setPostImage(faker.hitchhikersGuideToTheGalaxy().planet());
    return Post;
  }

}
