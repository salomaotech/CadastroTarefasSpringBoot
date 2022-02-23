package br.com.salomaotech.tarefas.controller;

import br.com.salomaotech.tarefas.model.Cadastro;
import br.com.salomaotech.tarefas.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    CadastroRepository cadastroRepository;

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/form-cadastro")
    public String formCadastro() {
        return "form-cadastro";
    }

    @RequestMapping("/listar-itens")
    public ModelAndView listarItens() {
        ModelAndView model = new ModelAndView("listar-itens");
        model.addObject("resultados", cadastroRepository.findAll());
        return model;
    }

    @GetMapping("/form-abre-cadastro/{id}")
    public String abreCadastro(@PathVariable("id") long id, Model model) {
        model.addAttribute("cadastro", cadastroRepository.findById(id));
        return "/form-abre-cadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(Cadastro cadastro) {
        cadastroRepository.save(cadastro);
        return "redirect:/listar-itens";
    }

    @PostMapping("/atualizar")
    public String atualizar(Cadastro cadastro) {
        cadastroRepository.save(cadastro);
        return "redirect:/listar-itens";
    }

}
