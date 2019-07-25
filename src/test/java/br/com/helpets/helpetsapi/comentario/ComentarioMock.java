package br.com.helpets.helpetsapi.comentario;

import br.com.helpets.helpetsapi.model.Comentario;
import com.github.javafaker.Faker;

import java.util.Locale;

public class ComentarioMock {

    public static Comentario getComentarioMock(){
        Comentario comentario = new Comentario();
        Faker faker = new Faker(new Locale("pt-BR"));
        comentario.setConteudo(faker.hitchhikersGuideToTheGalaxy().quote());
        return comentario;
    }
}
