package com.examenJavier.producto.service;

import com.examenJavier.producto.model.Producto;
import com.examenJavier.producto.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductoService {
    private final ProductoRepository productoRepository;
    @Autowired
    public ProductoService(ProductoRepository productoRepository){this.productoRepository = productoRepository;}
    public List<Producto> getProductos(){
        return productoRepository.findAll();
    }
    public Optional<Producto> getProducto(Long id){
        return productoRepository.findById(id);
    }

    public List<Producto> getProductosByStock(){
        return productoRepository.findAll();
    }

    public Producto saveOrUpdate(Producto producto) {
        return productoRepository.save(producto);
    }

    public void deleteProducto(Long id){
        productoRepository.deleteById(id);
    }

    public List<Producto> searchByName(String name){
        return productoRepository.findByNameContainingIgnoreCase(name);
    }
}
