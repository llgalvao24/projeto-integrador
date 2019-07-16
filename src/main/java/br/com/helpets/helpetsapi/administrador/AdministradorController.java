package br.com.helpets.helpetsapi.administrador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/V1")
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

    //Update updateAdministradorbyAdministrador
    @PatchMapping("/administrador/update/{administrador}")
    public void updateByName(@PathVariable Administrador administrador, @RequestParam String texto){
        administradorRepository.updateAdministradorby(administrador, texto);
    }


   // Delete
    @DeleteMapping("/administrador/{id_admin}")
    public void delete(@PathVariable Long id_admin){
        administradorRepository.deleteById(id_admin);
    }





}
