package com.logisticasolidaria.Controller;

import com.logisticasolidaria.Model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/cadastro")
    public String cadastroPage(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String processarCadastro(@ModelAttribute Usuario usuario, Model model) {
        // Em um sistema real, aqui salvaríamos no banco de dados
        boolean senhasIguais = usuario.getSenha() != null
                && usuario.getSenha().equals(usuario.getConfirmarSenha());

        if (!senhasIguais) {
            model.addAttribute("erro", "As senhas não são iguais.");
            return "cadastro";
        }

        model.addAttribute("mensagem", "Cadastro realizado com sucesso, " + usuario.getNome() + "!");
        model.addAttribute("usuario", new Usuario());
        return "cadastro";
    }
}