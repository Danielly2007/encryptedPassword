package com.bcript.safety.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcript.safety.entities.Usuario;

@Repository
public interface UsuariorRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByEmail(String email);
	

}
