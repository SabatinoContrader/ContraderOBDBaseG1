package it.contrader.automative.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;


@Controller
public class HelloController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String hello (Map<String, Object> model) {
        model.put("Prova", "Ciao Mondo!");
        return "index01";
    }

//    Model model;
//    model.addAttribute("nomeVariabile", variabile);
}
