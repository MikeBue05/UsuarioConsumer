package org.example.usuarioconsumer.Controller;

import org.example.usuarioconsumer.model.Usuario;
import org.example.usuarioconsumer.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/new")
    public String newUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario/form";
    }

    @GetMapping("")
    public String listUsuario(Model model) {
        model.addAttribute("listUsuario", usuarioService.findAll());
        return "usuario/list";
    }

    @GetMapping("/{id}/edit")
    public String editUsuario(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("usuario", usuarioService.findbyId(id));
        return "usuario/form";
    }
}
