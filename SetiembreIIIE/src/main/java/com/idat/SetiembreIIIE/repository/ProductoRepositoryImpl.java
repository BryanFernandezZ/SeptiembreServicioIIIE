package com.idat.SetiembreIIIE.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.idat.SetiembreIIIE.model.Producto;

@Repository
public class ProductoRepositoryImpl implements ProductoRepository {

    List<Producto> almacenamiento = new ArrayList<>();

    @Override
    public void guardar(Producto producto) {
        almacenamiento.add(producto);
    }

    @Override
    public void actualizar(Producto producto) {
        Producto pd = almacenamiento.stream().filter(p -> p.getIdProducto() == producto.getIdProducto()).findFirst().orElse(null);
        int index = almacenamiento.indexOf(pd);
        eliminar(producto.getIdProducto());
        almacenamiento.add(index, producto);
    }

    @Override
    public void eliminar(Integer id) {
        Producto existeEliminar = obtener(id);
        almacenamiento.remove(existeEliminar);
    }

    @Override
    public List<Producto> listar() {
        return almacenamiento;
    }

    @Override
    public Producto obtener(Integer id) {
        return almacenamiento.stream().filter(p -> p.getIdProducto() == id).findFirst().orElse(null);
    }

}
