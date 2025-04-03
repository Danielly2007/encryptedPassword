package com.bcript.safety.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcript.safety.dto.UsuarioDTO;
import com.bcript.safety.services.UsuarioService;

import jakarta.validation.Valid;

@RequestMapping("usuario")
@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping(value = "/save")
	public ResponseEntity<?> salvar(@Valid @RequestBody UsuarioDTO dto){
		
		dto = usuarioService.salvarUsuario(dto);
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping(value = "/login") 
		public ResponseEntity<?> login(@RequestBody UsuarioDTO dto){
		boolean login = usuarioService.authUsuario(dto);
		
		if(login) {
			return ResponseEntity.ok("success!");
		}else {
			return ResponseEntity.status(401).body("E-mail or password invalid!");// tdoso login e o service e controller
		}
	}
	

}
