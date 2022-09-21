package com.idat.SetiembreIIIE.services;

import com.idat.SetiembreIIIE.model.Producto;
import com.idat.SetiembreIIIE.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository repository;

    @Override
    public void guardar(Producto producto) {
        repository.guardar(producto);
    }

    @Override
    public void actualizar(Producto producto) {
        actualizar(producto);
    }

    @Override
    public void eliminar(Integer id) {
        eliminar(id);
    }

    @Override
    public List<Producto> listar() {
        return repository.listar();
    }

    @Override
    public Producto obtener(Integer id) {
        return repository.obtener(id);
    }
}
