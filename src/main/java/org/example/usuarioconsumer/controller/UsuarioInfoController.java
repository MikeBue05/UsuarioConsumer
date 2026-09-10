package org.example.usuarioconsumer.controller;

import org.example.usuarioconsumer.model.UsuarioInfo;
import org.example.usuarioconsumer.service.UsuarioInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarioInfo")
public class UsuarioInfoController {

    @Autowired
    private UsuarioInfoService usuarioInfoService;

    @GetMapping("/new")
    public String newUsuario(Model model) {
        model.addAttribute("usuario", new UsuarioInfo());
        return "usuario/List";
    }

    @GetMapping("")
    public String listUsuarioInfo(Model model) {
        model.addAttribute("listUsuario", usuarioInfoService.findAll());
        return "usuario/list";
    }

    @GetMapping("/{id}/edit")
    public String editUsuario(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("usuarioInfo", usuarioInfoService.findById(id));
        return "usuario/form";
    }

    @PostMapping("/save")
    public String saveUsuario(@ModelAttribute("usuarioInfo") UsuarioInfo usuarioInfo) {
        usuarioInfoService.save(usuarioInfo);
        return "redirect:usuario";
    }
    @GetMapping("/{id}/delete")
    public String deleteUsuario(@PathVariable("id") Integer id) {
        usuarioInfoService.delete(id);
        return "redirect:/usuarioInfo";
    }
}
