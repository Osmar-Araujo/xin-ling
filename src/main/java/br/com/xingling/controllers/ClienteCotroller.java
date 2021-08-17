package br.com.xingling.controllers;

import java.util.InputMismatchException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.xingling.models.Cliente;
import br.com.xingling.repositories.ClienteRepository;

@Controller
public class ClienteCotroller {

	@Autowired
	private ClienteRepository repository;

	@GetMapping("/clientes/cadastrar")
	public ModelAndView cadastrar(Cliente cliente) {
		ModelAndView mv = new ModelAndView("clientes/cadastroCliente");
		mv.addObject("cliente", cliente);
		return mv;
	}
	
	@GetMapping("/clientes/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<Cliente>cliente = repository.findById(id);
		ModelAndView mv = new ModelAndView("clientes/cadastroCliente");
		mv.addObject("cliente", cliente);
		return mv;
	}
	

	@PostMapping("/clientes/salvar")
	public ModelAndView salvar(@Validated Cliente cliente, BindingResult result) {
		if (result.hasErrors()) {
			return cadastrar(cliente);
		}else if (isCPF(cliente.getCpf())) {
			return cadastrar(cliente);
		}
		
		repository.saveAndFlush(cliente);		
		return new ModelAndView("redirect:/clientes/listar");
	}
	
	
	@GetMapping("/clientes/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("clientes/listaClientes");
		mv.addObject("listClientes", repository.findAll() );
		return mv;
	}
	
	
	public static boolean isCPF(String CPF) {

		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
				|| CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
				|| CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
				|| CPF.equals("99999999999") || (CPF.length() != 11))
			return (false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {

			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {

				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48);
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}
}
