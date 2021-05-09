package com.heinsohn.semillero.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.heinsohn.semillero.dto.Usuarios;
import com.heinsohn.semillero.repository.UsuariariosRepository;
import com.heinsohn.semillero.repository.UsuariosJpaRepository;
import com.heinsohn.semillero.repository.UsuariosPagSortRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController //
@RequestMapping("usuarios")
public class UserController {
	
	
	@Autowired
	private UsuariosJpaRepository uJpaRepository;
    //estas sirven mas para consultas y crud 
	private UsuariariosRepository uRepository;
	
	//sirve para el ordenamiento y paginacion teniendo varias funciones que se pueden utilizar para crud 
	private UsuariosPagSortRepository uPSRepository;
	
	public UserController(UsuariariosRepository uRepository, UsuariosPagSortRepository uPSRepository ) {
		this.uRepository = uRepository;
		this.uPSRepository =uPSRepository;
	}
	
	/**
	 * Metodo que retorna los datos de los usuarios
	 * por medio del metodo HTTP.GET
	 * 
	 * @return List<UsuarioDTO>
	 */
	@ApiOperation(value = "Metodo que retorna los datos de los usuarios por medio del metodo HTTP.GET",
				  response = Integer.class, tags = "consultarUsuarios")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Exitoso, funcion!"),
		@ApiResponse(code = 401, message = "No autorizado, pilas!"),
		@ApiResponse(code = 403, message = "No tienes permiso!"),
		@ApiResponse(code = 404, message = "No se encontro lo que buscabas!")
	})
	@GetMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
				produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Usuarios> getUsuario() {
		
		return (List<Usuarios>) uRepository.findAll();
	}
	
	/**
	 * Metodo que permite registrar los datos de un usuario
	 * por medio del metodo HTTP.POST
	 * 
	 * @return String
	 */
	@ApiOperation(value = "Metodo que retorna los datos de un usuario por medio del metodo HTTP.POST",
			  response = Integer.class, tags = "registrarUsuarios")
	@ApiResponses(value = {
	@ApiResponse(code = 200, message = "Exitoso, funcion!"),
	@ApiResponse(code = 401, message = "No autorizado, pilas!"),
	@ApiResponse(code = 403, message = "No tienes permiso!"),
	@ApiResponse(code = 404, message = "No se encontro la pagina que buscabas!")
	})
	@PostMapping
	public @ResponseBody String crearUsuario (@RequestParam int cedula
		      , @RequestParam String name, @RequestParam String login
		      , @RequestParam String correo, @RequestParam String password
		      , @RequestParam String estado) {
		    // @ResponseBody means the returned String is the response, not a view name
		    // @RequestParam means it is a parameter from the GET or POST request
		    if(uRepository.existsById(cedula)) {
		    	return "El registro ya existe";
		    }else {
		    	Usuarios n = new Usuarios();
			    n.setCedula(cedula);
			    n.setNombre(name);
			    n.setLogin(login);
			    n.setCorreo(correo);
			    n.setPassword(password);
			    n.setEstado(estado);
			    
			    uRepository.save(n);
			    return "El usuario se registro exitosamente!";
		    }
		    
		  }
	/*para usar jpa 
	@PostMapping
	public @ResponseBody Usuarios crearUsuarios(@RequestBody Usuarios usuario) {
		if(null != usuario) {
			return uJpaRepository.save(usuario);
		}else
			return null;
	} */
	
	/**
	 * Metodo que permite actualizar los datos de un usuario
	 * por medio del metodo HTTP.PUT
	 * 
	 * @return String
	 */
	@ApiOperation(value = "Metodo que actualiza los datos de un usuario por medio del metodo HTTP.PUT",
			  response = Integer.class, tags = "actualizarUsuarios")
	@ApiResponses(value = {
	@ApiResponse(code = 200, message = "Exitoso, funcion!"),
	@ApiResponse(code = 401, message = "No autorizado, pilas!"),
	@ApiResponse(code = 403, message = "No tienes permiso!"),
	@ApiResponse(code = 404, message = "No se encontro la pagina que buscabas!")
	})
	
	@PutMapping
	public @ResponseBody String actualizarUsuario(Usuarios usuario) {
		if(null != usuario && usuario.getCedula() > 0) {
			if( uJpaRepository.existsById(usuario.getCedula())) {
				Usuarios u = uRepository.findById(usuario.getCedula()).get();
				if(null != u  ) {
					uRepository.save(usuario);
					return "Se actualizo el registro correctamente";
				}
					
			}else
				return "Actulizacion fallida, el usuario no existe";
		}
		return "LLenar todos los campos requeridos";
	}
	
	/**
	 * Este metodo permite eliminar la información
	 * de un usuario especifico
	 * 
	 * @return String
	 */
	@ApiOperation(value = "Metodo que permite eliminar los datos de un usuario por medio del metodo HTTP.DELETE ",
			  response = Integer.class, tags = "eliminarUsuarios")
	@ApiResponses(value = {
	@ApiResponse(code = 200, message = "Exitoso, funcion!"),
	@ApiResponse(code = 401, message = "No autorizado, pilas!"),
	@ApiResponse(code = 403, message = "No tienes permiso!"),
	@ApiResponse(code = 404, message = "No se encontro la pagina que buscabas!")
	})
	@DeleteMapping
	public String eliminarUsuario(int cedula) {
		
		if(uJpaRepository.existsById(cedula)) {
			Optional<Usuarios> u = uJpaRepository.findById(cedula);
			if(u.isPresent()) {
				uJpaRepository.delete(u.get());
				uJpaRepository.flush();
				return "se elimino el usuario correctamente!";
			}
		}
		return "No es posible eliminar el usuario, no existe un usuario con esa identificacion";
	}
	
}
