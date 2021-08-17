package br.com.xingling.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.xingling.models.Funcionario;
import br.com.xingling.repositories.FuncionarioRepository;

@Controller
public class FuncionarioController {
	@Autowired
	private FuncionarioRepository repository;

	@GetMapping("/adm/funcionarios/cadastrar")
	public ModelAndView cadastrar(Funcionario funcionario) {
		ModelAndView mv = new ModelAndView("adm/funcionarios/cadastroFuncionarios");
		mv.addObject("funcionario", funcionario);
		
		System.out.println(mv);
		return mv;
	}

	@GetMapping("/adm/funcionarios/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("adm/funcionarios/listaFuncionarios");
		mv.addObject("listaFuncionarios", repository.findAll() );
		System.out.println(mv);
		return mv;
	}
	
	@PostMapping("/adm/funcionarios/salvar")
	public ModelAndView salvar(@Validated Funcionario funcionario, BindingResult result) {
		if (result.hasErrors()) {
			return cadastrar(funcionario);
		}
		
		System.out.println(result);
		
		System.out.println(funcionario);

		repository.saveAndFlush(funcionario);

		return cadastrar(new Funcionario());
	}
}
