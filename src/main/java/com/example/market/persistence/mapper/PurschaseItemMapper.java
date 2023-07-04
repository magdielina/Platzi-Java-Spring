package com.example.market.persistence.mapper;

import com.example.market.domain.dto.PurchaseItem;
import com.example.market.persistence.entity.ComprasProducto;
import com.example.market.persistence.entity.ComprasProductoPK;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PurschaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
//            @Mapping(source = "total", target = "total")
            @Mapping(source = "estado", target = "active")
    })
    PurchaseItem toPurchaseItem(ComprasProducto comprasProducto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "producto", ignore = true),
            @Mapping(target = "id.idCompra", ignore = true),

    })
    ComprasProducto toComprasProducto(PurchaseItem purchaseItem);
}
