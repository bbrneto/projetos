package br.com.alura.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@RequestMapping("/")
	@ResponseBody// Indica que o retorno do método deve ser serializado e devolvido no corpo da resposta.
	public String hello() {
		return "Hello World!";
	}

}
