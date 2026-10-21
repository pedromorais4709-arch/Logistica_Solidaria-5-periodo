package com.logisticasolidaria.Controller;

import com.logisticasolidaria.Model.Doacao;
import com.logisticasolidaria.Service.DoacaoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/doacoes")
public class DoacaoController {

    private final DoacaoService doacaoService;

    public DoacaoController(DoacaoService doacaoService) {
        this.doacaoService = doacaoService;
    }

    @GetMapping
    public String listarDoacoes(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String categoria,
            Model model) {

        model.addAttribute("doacoes", doacaoService.filtrar(status, categoria));
        model.addAttribute("statusSelecionado", status);
        model.addAttribute("categoriaSelecionada", categoria);
        return "doacoes";
    }

    @GetMapping("/nova")
    public String novaDoacaoForm(Model model) {
        model.addAttribute("doacao", new Doacao());
        return "nova-doacao";
    }

    @PostMapping("/nova")
    public String salvarDoacao(@Valid @ModelAttribute Doacao doacao,
                               BindingResult result) {
        if (result.hasErrors()) {
            return "nova-doacao";
        }
        doacao.setStatus("Pendente");
        doacao.setDataCadastro(LocalDate.now());
        doacaoService.adicionar(doacao);
        return "redirect:/doacoes";
    }
}