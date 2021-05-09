package com.heinsohn.semillero.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.heinsohn.semillero.dto.Usuarios;

public interface UsuariosPagSortRepository extends PagingAndSortingRepository<Usuarios, Integer>{
	//aqui podriamos usar metodos de paginacion y ordenamiento
}
