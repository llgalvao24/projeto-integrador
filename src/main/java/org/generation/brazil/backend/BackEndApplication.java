package org.generation.brazil.backend;

import org.generation.brazil.backend.address.Address;
import org.generation.brazil.backend.address.AddressRepository;
import org.generation.brazil.backend.animal.Animal;
import org.generation.brazil.backend.animal.AnimalRepository;
import org.generation.brazil.backend.comment.Comment;
import org.generation.brazil.backend.comment.CommentRepository;
import org.generation.brazil.backend.donation.Donation;
import org.generation.brazil.backend.donation.DonationRepository;
import org.generation.brazil.backend.post.Post;
import org.generation.brazil.backend.post.PostRepository;
import org.generation.brazil.backend.user.User;
import org.generation.brazil.backend.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class BackEndApplication {

  public static void main(String[] args) {
    SpringApplication.run(BackEndApplication.class, args);
  }
}
