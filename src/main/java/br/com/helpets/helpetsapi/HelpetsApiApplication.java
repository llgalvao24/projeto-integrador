package br.com.helpets.helpetsapi;

import br.com.helpets.helpetsapi.model.Comment;
import br.com.helpets.helpetsapi.model.Post;
import br.com.helpets.helpetsapi.repository.CommentRepository;
import br.com.helpets.helpetsapi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class HelpetsApiApplication implements CommandLineRunner {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private PostRepository postRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelpetsApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");



		Post post1 = new Post("post1", "imageUrl1", "content 1", sdf1.parse("24/08/2019 22:01"), null);
		Post post2 = new Post("post2", "imageUrl2", "content 2", sdf1.parse("24/08/2019 22:02"), null);
		postRepository.saveAll(Arrays.asList(post1,post2));

		Comment comment1 = new Comment("comment 1", sdf1.parse("30/09/2019 22:22"), null, post1 );
		Comment comment2 = new Comment("comment 2", sdf1.parse("30/09/2019 22:21"), null, post1 );
		Comment comment3 = new Comment("comment 3", sdf1.parse("30/09/2019 22:24"), null, post2 );
		Comment comment4 = new Comment("comment 4", sdf1.parse("30/09/2019 22:25"), null, post2 );
		Comment comment5 = new Comment("comment 5", sdf1.parse("30/09/2019 22:26"), null, post1 );
		commentRepository.saveAll(Arrays.asList(comment1, comment2, comment3, comment4, comment5));
	}
}
