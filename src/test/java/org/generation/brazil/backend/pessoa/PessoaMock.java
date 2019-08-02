package org.generation.brazil.backend.pessoa;

import com.github.javafaker.Faker;
import java.util.Locale;

public class PessoaMock {

  public static Pessoa getPessoaMock() {
    Pessoa pessoa = new Pessoa();
    Faker faker = new Faker(new Locale("pt-BR"));
    pessoa.setNome(faker.name().firstName());
    pessoa.setSobrenome(faker.name().lastName());
    pessoa.setCidade(faker.address().cityName());
    return pessoa;
  }

}
