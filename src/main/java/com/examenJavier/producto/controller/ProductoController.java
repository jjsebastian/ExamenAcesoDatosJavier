package com.examenJavier.producto.controller;

import com.examenJavier.producto.model.Producto;
import com.examenJavier.producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(path ="api/v1/productos")
public class ProductoController {
    private final ProductoService productoService;
    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ResponseEntity<Producto> save(@RequestBody Producto producto){
        Producto productoNew = productoService.saveOrUpdate(producto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productoNew);
    }

    @GetMapping
    public ResponseEntity<List<Producto>> getAll(){
        List<Producto> series = productoService.getProductos();
        return ResponseEntity.ok(series);
    }
    @GetMapping("/{idProducto}")
    public ResponseEntity<Optional<Producto>> getById(@PathVariable Long idProducto){
        Optional<Producto> producto = productoService.getProducto(idProducto);
        if(producto.isPresent())
            return ResponseEntity.ok(producto);
        return ResponseEntity.notFound().build();

    }
    @GetMapping("/{stock}")
    public ResponseEntity<List<Producto>> getProductosByStock(){
        List<Producto> stocks = productoService.getProductosByStock();
        if(stocks.isEmpty())
            return ResponseEntity.ok(stocks);
        return ResponseEntity.ok(stocks);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Producto>> searchProducto(@RequestParam String name){
        List<Producto> productos = productoService.searchByName(name);
        return ResponseEntity.ok(productos);
    }

    @DeleteMapping("/{idProducto}")
    public ResponseEntity<Optional<Producto>> delete(@PathVariable Long idProducto){
        productoService.deleteProducto(idProducto);
        return  ResponseEntity.ok().build();
    }



}
