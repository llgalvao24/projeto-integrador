package br.com.helpets.helpetsapi;

import br.com.helpets.helpetsapi.model.*;
import br.com.helpets.helpetsapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class HelpetsApiApplication implements CommandLineRunner {

	@Autowired
	private BCryptPasswordEncoder pe;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private AnimalRepository animalRepository;

	@Autowired
	private DonationRepository donationRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelpetsApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		User user1 = new User(null, "llgalvao", pe.encode("senha123"), "Luiz", "Galvao", "llgalvao24@gmail.com", "08239841414", sdf.parse("24/08/1990"), "19981181356", "profpic1", 1L);
		User user2 = new User(null, "ercilia123", pe.encode("123senha"),"Ercilia", "Silva", "ercilia@gmail.com", "08239841414", sdf.parse("09/07/1992"), "19981181369", "profpic2", 2L);

		Address ad1 = new Address("Maria Nassif Mokarzel", "49", "no", "Jd Sta Genebra", "13084-757", "Campinas", "SP", user1);
		user1.setAddress(ad1);
		Address ad2 = new Address("Jean Nassif Mokarzel", "49", "no", "Jd Sta Genebra", "13084-757", "Campinas", "SP", user2);
		user2.setAddress(ad2);

		userRepository.saveAll(Arrays.asList(user1, user2));
		addressRepository.saveAll(Arrays.asList(ad1,ad2));

		Post post1 = new Post(null,"post1", "imageUrl1", "content 1", sdf1.parse("24/08/2019 22:01"), user1);
		Post post2 = new Post(null,"post2", "imageUrl3", "content 2", sdf1.parse("24/08/2019 22:04"), user2);
		Post post3 = new Post(null,"post3", "imageUrl4", "content 4", sdf1.parse("24/08/2019 22:05"), user2);
		Post post4 = new Post(null,"post4", "imageUrl5", "content 5", sdf1.parse("24/08/2019 22:06"), user2);
		Post post5 = new Post(null,"post5", "imageUrl6", "content 6", sdf1.parse("24/08/2019 22:07"), user2);
		Post post6 = new Post(null,"post6", "imageUrl7", "content 7", sdf1.parse("24/08/2019 22:09"), user2);
		Post post7 = new Post(null,"post7", "imageUrl8", "content 7", sdf1.parse("24/08/2019 22:08"), user2);
		postRepository.saveAll(Arrays.asList(post1,post2, post3, post4, post5, post6, post7));

		Comment comment1 = new Comment(null, "comment 1", sdf1.parse("30/09/2019 22:22"), user1, post1 );
		Comment comment2 = new Comment(null, "comment 2", sdf1.parse("30/09/2019 22:21"), user2, post1 );
		Comment comment3 = new Comment(null, "comment 3", sdf1.parse("30/09/2019 22:24"), user1, post2 );
		Comment comment4 = new Comment(null, "comment 4", sdf1.parse("30/09/2019 22:25"), user2, post2 );
		Comment comment5 = new Comment(null, "comment 5", sdf1.parse("30/09/2019 22:26"), user1, post1 );
		commentRepository.saveAll(Arrays.asList(comment1, comment2, comment3, comment4, comment5));

		Animal an1 = new Animal(null,"cat", "Frida", 1, "frajola", "-", "black", 2.0, true, user1);
		Animal an2 = new Animal(null, "dog", "Apolo", 2, "pug", "small", "black", 3.0, true, user2);
		Animal an3 = new Animal(null, "dog", "Bob", 5, "pug", "small", "white", 2.0, true, user2);
		Animal an4 = new Animal(null,"rabbit", "floquinho", 1, "white", "small", "white", 2.0, true, user1);
		animalRepository.saveAll(Arrays.asList(an1, an2, an3, an4));

		Donation d1 = new Donation(null,3L, 3L, 45L, 3L, user1, an4);
		Donation d2 = new Donation(null,4L, 3L, 3L, 5L, user2, an1);
		Donation d3 = new Donation(null,6L, 3L, 40L, 3L, user2, an2);
		Donation d4 = new Donation(null,1L, 3L, 3L, 10L, user1, an3);
		Donation d5 = new Donation(null,1L, 3L, 50L, 3L, user1, an1);
		donationRepository.saveAll(Arrays.asList(d1, d2, d3, d4, d5));
	}
}
