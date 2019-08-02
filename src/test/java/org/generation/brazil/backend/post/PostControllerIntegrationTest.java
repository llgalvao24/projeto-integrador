package org.generation.brazil.backend.post;

import org.generation.brazil.backend.BackEndApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackEndApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class PostControllerIntegrationTest {

  @Autowired
  private TestRestTemplate testRestTemplate;

  @LocalServerPort
  private int port;

  private String getRootUrl() {
    return "http://localhost:" + port + "/api/v1/posts/";
  }

  private String token;

  @Before
  public void init() {
    this.token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI0IiwiaWF0IjoxNTY0NzY0Nzg0LCJleHAiOjE1NjU2Mjg3ODR9.HG0nzXvQbj7VcDtTzBbjpNdJAcf0SBdUG2maZBv5CLRtd3TV62SjqH_hipy8innfx4uBY1dCpCKmNIbli7MvTg";
  }

  @Test
  public void testaCriacaoDeUmPost() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    headers.add("Authorization", "Bearer " + this.token);

    HttpEntity<Post> entity = new HttpEntity<>(PostMock.getPostMock(), headers);

    ResponseEntity<Post> responseEntity = testRestTemplate.exchange(
        getRootUrl(),
        HttpMethod.POST,
        entity,
        Post.class
    );

    assertNotNull(responseEntity);
    assertEquals(201, responseEntity.getStatusCodeValue());
  }

  @Test
  public void testaConsultaDeTodasAsPosts() {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", "Bearer " + this.token);
    HttpEntity<String> entity = new HttpEntity<>(null, headers);

    ResponseEntity<String> response = testRestTemplate.exchange(
        getRootUrl(),
        HttpMethod.GET,
        entity,
        String.class);

    assertNotNull(response.getBody());
    assertEquals(200, response.getStatusCodeValue());
  }

  @Test
  public void testaConsultaPorId() {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", "Bearer " + this.token);
    HttpEntity<String> entity = new HttpEntity<>(null, headers);

    ResponseEntity<Post> response = testRestTemplate.exchange(
        getRootUrl() + "1",
        HttpMethod.GET,
        entity,
        Post.class);

    assertNotNull(response.getBody());
    assertEquals(200, response.getStatusCodeValue());
  }

  @Test
  public void testaAtualizacaoDeUmaPost() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    headers.add("Authorization", "Bearer " + this.token);

    HttpEntity<Post> entity = new HttpEntity<>(PostMock.getPostMock(), headers);

    ResponseEntity<Post> responseEntity = testRestTemplate.exchange(
        getRootUrl() + "1",
        HttpMethod.PUT,
        entity,
        Post.class
    );

    assertNotNull(responseEntity);
    assertEquals(200, responseEntity.getStatusCodeValue());
  }

}
