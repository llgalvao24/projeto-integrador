package org.generation.brazil.backend.pessoa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collections;
import org.generation.brazil.backend.BackEndApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackEndApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class PessoaControllerIntegrationTest {

  @Autowired
  private TestRestTemplate testRestTemplate;

  @LocalServerPort
  private int port;

  private String getRootUrl() {
    return "http://localhost:" + port + "/api/v1/pessoas/";
  }

  private String token;

  @Before
  public void init() {
    this.token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNTY0NjY2MzM0LCJleHAiOjE1NjU1MzAzMzR9.msN9ebk2SnYWLvLQQavrOKNf_lJDvROkMYreCqoMQGNznIm4UasEPVvkexHj5bfwkeSK4swiHqp4gP0gdquSQA";
  }

  @Test
  public void testaCriacaoDeUmaNovaPessoa() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    headers.add("Authorization", "Bearer " + this.token);

    HttpEntity<Pessoa> entity = new HttpEntity<>(PessoaMock.getPessoaMock(), headers);

    ResponseEntity<Pessoa> responseEntity = testRestTemplate.exchange(
        getRootUrl(),
        HttpMethod.POST,
        entity,
        Pessoa.class
    );

    assertNotNull(responseEntity);
    assertEquals(201, responseEntity.getStatusCodeValue());
  }

  @Test
  public void testaConsultaDeTodasAsPessoas() {
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

    ResponseEntity<Pessoa> response = testRestTemplate.exchange(
        getRootUrl() + "1",
        HttpMethod.GET,
        entity,
        Pessoa.class);

    assertNotNull(response.getBody());
    assertEquals(200, response.getStatusCodeValue());
  }

  @Test
  public void testaAtualizacaoDeUmaPessoa() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    headers.add("Authorization", "Bearer " + this.token);

    HttpEntity<Pessoa> entity = new HttpEntity<>(PessoaMock.getPessoaMock(), headers);

    ResponseEntity<Pessoa> responseEntity = testRestTemplate.exchange(
        getRootUrl() + "1",
        HttpMethod.PUT,
        entity,
        Pessoa.class
    );

    assertNotNull(responseEntity);
    assertEquals(200, responseEntity.getStatusCodeValue());
  }

}
