package br.com.helpets.helpetsapi.comentario;

import br.com.helpets.helpetsapi.HelpetsApiApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelpetsApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ComentarioControllerIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    /**
     * Monta a URL para a chamada de teste da API
     * @param path - caminho da API
     * @return String
     */
    private String getRootUrl(String path) {
        return "http://localhost:" + port + "/api/v1" + path;
    }

    @Test
    public void testaCriacaoDeUmNovoUsuario() {
        // "Chamada da API"
        ResponseEntity<Comentario> postResponse = testRestTemplate.postForEntity(getRootUrl("/comentarios"), ComentarioMock.getComentarioMock(), Comentario.class);
        assertNotNull(postResponse);
        assertEquals(201, postResponse.getStatusCodeValue());
    }
}
