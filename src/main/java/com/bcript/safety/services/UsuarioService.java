package com.bcript.safety.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bcript.safety.dto.UsuarioDTO;
import com.bcript.safety.entities.Usuario;
import com.bcript.safety.repositories.UsuariorRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuariorRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UsuarioDTO salvarUsuario(UsuarioDTO dto) {
		Usuario user = new Usuario();
		user.setEmail(dto.getEmail());
		user.setPassword(passwordEncoder.encode( dto.getPassword() )); // recebe a senha e cripitografando ela
		user = usuarioRepository.save(user);
		return new UsuarioDTO(user);
		
	}
	
	public boolean authUsuario(UsuarioDTO dto) { //autentificação
		Usuario usuario = usuarioRepository.findByEmail(dto.getEmail()); // verifica se esse email existe
		
		if(usuario == null) { //se tiver errado vai retornar false
			return false;
		}
		return passwordEncoder.matches(dto.getPassword(), usuario.getPassword()); //se existe, conpara o que recebo e o que esta no banco e prossegue  
		// já existe a senha no banco, não esta criando o método de criar uma senha.
	}

}
