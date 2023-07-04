package com.example.market.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @EqualsAndHashCode.Include
    private String id;
    private String nombre;

    private String apellidos;

    private Long celular;

    private String direccion;

    private String correoElectronico;

    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;


}
