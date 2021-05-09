package com.heinsohn.semillero.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.heinsohn.semillero.dto.Usuarios;

public interface UsuariosJpaRepository extends JpaRepository<Usuarios, Integer> {
	// 	query propia de jpa
	// @Query("SELECT u FROM usuario u WHERE u.login =?1")
	// Usuarios consuktarUsuarioLogin(String login);
	
	
	//query nativo
	@Query(value = " SELECT * FROM usuarios u WHERE u.estado = ?1 ",
			nativeQuery = true)
	List<Usuarios> consultarUsuariosActivos(String estado);
			
}
