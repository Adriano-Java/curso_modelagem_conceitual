package br.com.ans.cursomc.resources;

import br.com.ans.cursomc.domain.Cliente;
import br.com.ans.cursomc.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * cursomc
 * Adriano Neto Da Silva
 * 09/02/2020
 */
@RestController/*Anotação que torna a classe um controlador do Spring*/
@RequestMapping(value = "/clientes")/*Anotação que mapeia a classe*/
public class ClienteResource {
    @Autowired
    private ClienteService service;


    /*Para que o método mapeie o serviço, use 'value' indicando o id
    * do objeto/tabela.
    * Use ResponseEntity<> no lugar do objeto que normalmente seria utilizado.
    * Esse é um objeto especial do Spring que encapsula e trata toda a transação
    * HTTP realizada pelo serviço REST.
    * O método find realiza o bind com o serviço para realizar a persistência.
    * Use @PathVariable para mapear no método o id*/
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id){
        Cliente objeto = service.buscar(id);
        return ResponseEntity.ok().body(objeto);
    }
}