package com.example.market.domain.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PurchaseItem {

    private int productId;
    private int quantity;
    private double total;
    private boolean active;
}
