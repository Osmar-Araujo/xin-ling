package br.com.xingling.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.xingling.models.Cartao;

@Controller
public class CartaoController {
	
	@GetMapping("/cartoes/cadastrar")
	public ModelAndView cadastrar(Cartao cartao) {
		ModelAndView mv = new ModelAndView("cartoes/cadastraCartao");
		mv.addObject("cartao", cartao);
		return mv;
	}

}
