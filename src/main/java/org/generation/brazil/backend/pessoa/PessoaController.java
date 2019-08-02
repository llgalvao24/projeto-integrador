package org.generation.brazil.backend.pessoa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.generation.brazil.backend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PessoaController {

  private static final String NOT_FOUND = "Não foi encontrado uma pessoa com o id: ";

  @Autowired
  private PessoaRepository pessoaRepository;

  @GetMapping("/pessoas")
  public List<Pessoa> getAllPessoas() {
    return pessoaRepository.findAll();
  }

  @GetMapping("/pessoas/{id}")
  public ResponseEntity<Pessoa> getPessoaById(@PathVariable(value = "id") Long pessoaId) {
    Pessoa pessoa = pessoaRepository.findById(pessoaId)
        .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND + pessoaId));
    return ResponseEntity.ok().body(pessoa);
  }

  @PreAuthorize("hasAnyRole('ADMIN')")
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("/pessoas")
  public Pessoa createPessoa(@Valid @RequestBody Pessoa pessoa) {
    return pessoaRepository.save(pessoa);
  }

  @PutMapping("/pessoas/{id}")
  public ResponseEntity<Pessoa> updatePessoa(@PathVariable(value = "id") Long pessoaId,
      @Valid @RequestBody Pessoa pessoaDetails) {
    Pessoa pessoa = pessoaRepository.findById(pessoaId)
        .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND + pessoaId));

    pessoa.setNome(pessoaDetails.getNome());
    pessoa.setSobrenome(pessoaDetails.getSobrenome());
    pessoa.setCidade(pessoaDetails.getCidade());
    final Pessoa updatedPessoa = pessoaRepository.save(pessoa);
    return ResponseEntity.ok(updatedPessoa);
  }

  @DeleteMapping("/pessoas/{id}")
  public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long pessoaId) {
    Pessoa pessoa = pessoaRepository.findById(pessoaId)
        .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND + pessoaId));

    pessoaRepository.delete(pessoa);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }

}
