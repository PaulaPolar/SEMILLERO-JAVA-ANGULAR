package com.heinsohn.semillero.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.heinsohn.semillero.dto.*;

@Repository
public interface UsuariariosRepository extends CrudRepository<Usuarios, Integer> {
	
	//public Usuarios buscarPorCorreo(String correo);
	
}
