package br.com.helpets.helpetsapi.administrador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdministradorController {

    @Autowired
    private AdministradorRepository repository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/administrador")
    public Administrador save(@RequestBody Administrador administrador){

        return repository.save(administrador);
    }

    @GetMapping("/administrador")
    public List<Administrador> finAll(){
        return  repository.findAll();
    }


    @GetMapping("/administrador/{id}")
    public optional<Administrador> findById(@PathVariable Long id){
        return repository.findById(id);
    }


    @GetMapping("/administrador/'{nome}'")
    public  optional<Administrador> findByName(@PathVariable String nome){

        return repository.findByNome(nome);
    }

}
