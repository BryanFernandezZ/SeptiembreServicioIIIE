package com.idat.SetiembreIIIE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.SetiembreIIIE.model.Producto;
import com.idat.SetiembreIIIE.repository.ProductoRepository;

@RestController
@RequestMapping("/v1/producto")
public class ProductoController {

	@Autowired
	private ProductoRepository repo;
	
	@GetMapping
	public ResponseEntity<List<Producto>> obtenerProductos(){
		return new ResponseEntity<List<Producto>>(repo.listar(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Producto> buscarProducto(@PathVariable Integer id){
		return new ResponseEntity<Producto>(repo.obtener(id), HttpStatus.OK);
	}
	
	@PostMapping
	public void guardar(@RequestBody Producto p){
		repo.guardar(p);
	}
	
	@PutMapping
	public void actualizar(@RequestBody Producto p) {
		repo.actualizar(p);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Integer id) {
		repo.eliminar(id);
	}
}

