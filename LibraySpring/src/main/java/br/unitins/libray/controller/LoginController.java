package br.unitins.libray.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.unitins.libray.service.UsuarioService;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public String login(@RequestParam String login, @RequestParam String senha) {
        boolean sucesso = usuarioService.login(login, senha);
        return sucesso ? "Login bem-sucedido!" : "Login ou senha inválidos!";
    }
    
}
