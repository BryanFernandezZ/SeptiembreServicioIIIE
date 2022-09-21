package com.idat.SetiembreIIIE.controller;

import java.util.List;

import com.idat.SetiembreIIIE.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.idat.SetiembreIIIE.model.Producto;
import com.idat.SetiembreIIIE.repository.ProductoRepository;

@RestController
@RequestMapping("/api/v1/producto")
public class ProductoController {

    @Autowired
    private ProductoService service;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<List<Producto>> obtenerProductos() {
        return new ResponseEntity<List<Producto>>(service.listar(), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Producto> buscarProducto(@PathVariable Integer id) {
        Producto producto = service.obtener(id);

        if (producto != null) {
            return new ResponseEntity<Producto>(service.obtener(id), HttpStatus.OK);
        }

        return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<Void> guardar(@RequestBody Producto p) {
        if (p != null) {
            service.guardar(p);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }

        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(path = "/editar", method = RequestMethod.PUT)
    public ResponseEntity<Void> actualizar(@RequestBody Producto p) {
        Producto producto = service.obtener(p.getIdProducto());

        if (producto != null) {
            service.actualizar(p);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        Producto p = service.obtener(id);
        if (p != null) {
            service.eliminar(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}

