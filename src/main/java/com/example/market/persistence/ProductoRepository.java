package com.example.market.persistence;

import com.example.market.domain.dto.Product;
import com.example.market.domain.repository.ProductRepository;
import com.example.market.persistence.crud.ProductoCrudRepository;
import com.example.market.persistence.entity.Producto;
import com.example.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        //List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
       // return Optional.of(mapper.toProducts(productos));
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId)
                .filter(productos -> !productos.isEmpty())
                .map(productos -> mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity,true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(prod -> mapper.toProduct(prod));
    }

    @Override
    public Product save(Product product) {
        return mapper.toProduct(productoCrudRepository.save(mapper.toProducto(product)));
    }

    @Override
    public void delete(int productoId){
        productoCrudRepository.deleteById(productoId);
    }
}
