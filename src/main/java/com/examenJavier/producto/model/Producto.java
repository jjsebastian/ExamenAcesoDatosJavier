package com.examenJavier.producto.model;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name ="productos")
public class Producto {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idProducto;
        @Column(nullable = false)
        private String name;
        private String description;
        private Double price;
        private String category;
        private Integer stock;


}
