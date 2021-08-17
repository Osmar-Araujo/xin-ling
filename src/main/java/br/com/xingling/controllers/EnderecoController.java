package br.com.xingling.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.xingling.models.Endereco;

@Controller
public class EnderecoController {
	
	@GetMapping("/enderecos/cadastrar")
	public ModelAndView cadastrar(Endereco endereco) {
		ModelAndView mv = new ModelAndView("enderecos/cadastraEndereco");
		mv.addObject("endereco", endereco);
		return mv;
	}
}
