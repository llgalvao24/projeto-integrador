package org.generation.brazil.backend.comment;

import com.github.javafaker.Faker;

import java.time.Instant;
import java.util.Date;
import java.util.Locale;

public class CommentMock {

  public static Comment getCommentMock() {
    Comment comment = new Comment();
    Faker faker = new Faker(new Locale("pt-BR"));
    comment.setContent(faker.hitchhikersGuideToTheGalaxy().quote());
    comment.setCommData(Date.from(Instant.now()));
    return comment;
  }

}
