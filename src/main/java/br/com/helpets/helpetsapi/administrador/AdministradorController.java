package br.com.helpets.helpetsapi.administrador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class AdministradorController {

    @Autowired//Força a injeção de dependencia
    private AdministradorRepository administradorRepository;


    // Criar
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/administrador")
    public Administrador save(@RequestBody Administrador administrador){
        return administradorRepository.save(administrador);// repository é o meud DB.
    }

    // Read
    @GetMapping("/administrador")
    public List<Administrador> findAll(){
        return administradorRepository.findAll(); //
    }

    //Update com Lambida
    @PutMapping(value="/administrador/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody Administrador administrador) {
        return administradorRepository.findById(id)
                .map(record -> {
                    record.setEmail(administrador.getEmail());
                    record.setSenha(administrador.getSenha());
                    Administrador updated = administradorRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

   // Delete
    @DeleteMapping("/administrador/{id}")
    public void delete(@PathVariable Long id){
        administradorRepository.deleteById(id);
    }


}
