package com.example.market.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    //    @Column(name = "id_producto") Not necessary
    private Integer idProducto;

    private String nombre;

    //    @Column(name = "id_categoria") Not necessary
    private Integer idCategoria;

    //    @Column(name = "codigo_barras") Not necessary
    private Integer codigoBarras;

    //    @Column(name = "precio_venta") Not necessary
    private Double precioVenta;

    //    @Column(name = "cantidad_stock") Not necessary
    private Integer cantidadStock;

    private Boolean estado;
}
