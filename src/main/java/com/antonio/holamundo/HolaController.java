package com.antonio.holamundo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// controlador de la pagina principal
@Controller
public class HolaController {

    @GetMapping("/")
    public String inicio(@RequestParam(defaultValue = "mundo") String nombre, Model model) {
        String hora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        model.addAttribute("nombre", nombre);
        model.addAttribute("hora", hora);
        return "index";
    }
}
