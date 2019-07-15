package br.com.helpets.helpetsapi.comentario;

import com.github.javafaker.Faker;

import java.util.Locale;

public class ComentarioMock {

    public static Comentario getComentarioMock(){
        Comentario comentario = new Comentario();
        Faker faker = new Faker(new Locale("pt-BR"));
        comentario.setTexto(faker.hitchhikersGuideToTheGalaxy().quote());
        return comentario;
    }
}
