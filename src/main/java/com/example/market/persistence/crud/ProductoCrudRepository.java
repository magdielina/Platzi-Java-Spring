package com.example.market.persistence.crud;

import com.example.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

//    @Query(value = "SELECT 8 FROM productos WHERE id_categoria = ?", nativeQuery = true) Native Query
    Optional<List<Producto>> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadSctock, boolean estado);

}
