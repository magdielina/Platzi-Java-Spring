package com.example.market.persistence.mapper;

import com.example.market.domain.dto.Purchase;
import com.example.market.persistence.entity.Compra;
import com.example.market.persistence.entity.ComprasProducto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = PurschaseItemMapper.class)
//@Mapper(componentModel = "spring", uses = PurschaseItemMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "idCompra", target = "purchaseId"),
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "fecha", target = "date"),
            @Mapping(source = "medioPago", target = "paymentMethod"),
            @Mapping(source = "comentario", target = "comment"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "productos", target = "items"),
    })
    Purchase toPurchase(Compra compra);

    @InheritInverseConfiguration
    @Mapping(target = "cliente", ignore = true)
    Compra toCompra (Purchase purchase);

    List<Purchase> toPurchases(List<Compra> compras);
}
