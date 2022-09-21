package com.idat.SetiembreIIIE.services;

import com.idat.SetiembreIIIE.model.Producto;

import java.util.List;

public interface ProductoService {
    void guardar(Producto producto);
    void actualizar(Producto producto);
    void eliminar(Integer id);
    List<Producto> listar();
    Producto obtener(Integer id);
}
