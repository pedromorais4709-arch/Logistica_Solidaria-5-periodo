package com.logisticasolidaria.Controller;

import com.logisticasolidaria.Model.Doacao;
import com.logisticasolidaria.Service.DoacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/doacoes")
public class DoacaoController {
     @Autowired
    private DoacaoService doacaoService;

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
        model.addAttribute("doacao", new Doacao(null, null, null, null, null, null, null, null));
        return "nova-doacao";
    }

    @PostMapping("/nova")
    public String salvarDoacao(@ModelAttribute Doacao doacao) {
        doacao.setId("DOA-" + (1000 + (int) (Math.random() * 9000)));
        doacao.setStatus("Pendente");
        doacaoService.adicionar(doacao);
        return "redirect:/doacoes";
    }
}
