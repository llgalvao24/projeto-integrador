package br.com.helpets.helpetsapi;

import br.com.helpets.helpetsapi.model.*;
import br.com.helpets.helpetsapi.repository.*;
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
	private UserRepository userRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private LoginUserRepository loginUserRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelpetsApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Long freq1 = (long) 1;

		User user1 = new User("Luiz", "Galvao", "llgalvao24@gmail.com", "08239841414", sdf.parse("24/08/1990"), "19981181356", "profpic1", freq1);
		User user2 = new User("Ercilia", "Silva", "ercilia@gmail.com", "08239841414", sdf.parse("09/07/1992"), "19981181369", "profpic2", freq1);

		LoginUser lu1 = new LoginUser("llgalvao", "senha123", user1);
		user1.setLoginUser(lu1);
		LoginUser lu2 = new LoginUser("ercilia123", "senha123", user2);
		user2.setLoginUser(lu2);

		Address ad1 = new Address("Maria Nassif Mokarzel", "49", "no", "Jd Sta Genebra", "13084-757", "Campinas", "SP", user1);
		user1.setAddress(ad1);
		Address ad2 = new Address("Jean Nassif Mokarzel", "49", "no", "Jd Sta Genebra", "13084-757", "Campinas", "SP", user2);
		user2.setAddress(ad2);

		userRepository.saveAll(Arrays.asList(user1,user2));
		addressRepository.saveAll(Arrays.asList(ad1,ad2));
		loginUserRepository.saveAll(Arrays.asList(lu1,lu2));

		Post post1 = new Post("post1", "imageUrl1", "content 1", sdf1.parse("24/08/2019 22:01"), user1);
		Post post2 = new Post("post2", "imageUrl2", "content 2", sdf1.parse("24/08/2019 22:02"), user2);
		postRepository.saveAll(Arrays.asList(post1,post2));

		Comment comment1 = new Comment("comment 1", sdf1.parse("30/09/2019 22:22"), user1, post1 );
		Comment comment2 = new Comment("comment 2", sdf1.parse("30/09/2019 22:21"), user2, post1 );
		Comment comment3 = new Comment("comment 3", sdf1.parse("30/09/2019 22:24"), user1, post2 );
		Comment comment4 = new Comment("comment 4", sdf1.parse("30/09/2019 22:25"), user2, post2 );
		Comment comment5 = new Comment("comment 5", sdf1.parse("30/09/2019 22:26"), user1, post1 );
		commentRepository.saveAll(Arrays.asList(comment1, comment2, comment3, comment4, comment5));
	}
}
