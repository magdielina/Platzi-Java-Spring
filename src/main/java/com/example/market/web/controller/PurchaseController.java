package com.example.market.web.controller;

import com.example.market.domain.dto.Purchase;
import com.example.market.domain.service.PurchaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping
    @Operation(summary = "Gell All purchases made to the supermarket")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<List<Purchase>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{clientId}")
    @Operation(summary = "Gel purchases by client Id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK")
            ,@ApiResponse(responseCode = "404", description = "Purchases for client not found")
    })
    public ResponseEntity<List<Purchase>> getByClient(@Parameter(description = "Client id", required = true, example = "2552243") @PathVariable("clientId") String clientId) {
        return ResponseEntity.of(purchaseService.getByClient(clientId));
    }

    @PostMapping()
    @Operation(summary = "Create a purchase")
    @ApiResponse(responseCode = "201", description = "Purchase Created")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }
}
