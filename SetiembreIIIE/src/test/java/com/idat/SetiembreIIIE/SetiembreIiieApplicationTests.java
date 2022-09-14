package com.idat.SetiembreIIIE;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.idat.SetiembreIIIE.model.Producto;
import com.idat.SetiembreIIIE.repository.ProductoRepository;
import com.idat.SetiembreIIIE.repository.ProductoRepositoryImpl;

@SpringBootTest
class SetiembreIiieApplicationTests {

	ProductoRepository repo = new ProductoRepositoryImpl();
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void actualizar() {
		Producto p1 = new Producto();
		p1.setIdProducto(1);
		p1.setNombreProducto("Test1");
		p1.setDescripcion("Prueba");
		p1.setPrecio(12.2);
		p1.setStock(3);
		
		Producto p2 = new Producto();
		p2.setIdProducto(2);
		p2.setNombreProducto("Test1");
		p2.setDescripcion("Prueba");
		p2.setPrecio(12.2);
		p2.setStock(3);
		
		Producto p3 = new Producto();
		p3.setIdProducto(3);
		p3.setNombreProducto("Test1");
		p3.setDescripcion("Prueba");
		p3.setPrecio(12.2);
		p3.setStock(3);
		
		repo.guardar(p1);
		repo.guardar(p2);
		repo.guardar(p3);
		
		System.out.println("Productos guardados");
		
		Producto pActualizado = new Producto();
		p3.setIdProducto(2);
		p3.setNombreProducto("ProductoActualizado");
		p3.setDescripcion("PruebaActualizado");
		p3.setPrecio(12.2);
		p3.setStock(3);
		
		repo.actualizar(pActualizado);
		
		Producto output = repo.obtener(2);
		System.out.println("******Producto******");
		System.out.println("Id: " + output.getIdProducto());
		System.out.println("Nombre: " + output.getNombreProducto());
		System.out.println("Descripcion: " + output.getDescripcion());
		System.out.println("Precio: " + output.getPrecio());
		System.out.println("Stock: " + output.getStock());
	}

}
