package com.logisticasolidaria.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class PerfilController {
    @GetMapping("/perfil")
    public String perfil(Model model) {
        model.addAttribute("nome", "Mariana Alves");
        model.addAttribute("email", "mariana@email.com");
        model.addAttribute("telefone", "(82) 99999-1111");
        model.addAttribute("endereco", "Maceió - AL");
        model.addAttribute("tipo", "Doador");
        return "perfil";
    }
    
}
