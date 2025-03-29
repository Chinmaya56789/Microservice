package com.microservices.Inventory_Service.Services;


import com.microservices.Inventory_Service.DTOs.StockeCheckDTO;
import com.microservices.Inventory_Service.DTOs.UnavailableStockDTO;
import com.microservices.Inventory_Service.Models.Inventory;
import com.microservices.Inventory_Service.Respositories.InventoryRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Data
public class InventoryService {

    private InventoryRepository inventoryRepo;
    public List<UnavailableStockDTO> getStocks(List<StockeCheckDTO> lst){

            List<String> skus= lst.stream().map(StockeCheckDTO::getSkuCode).toList();
            List<Inventory> currentInvesntoryList = inventoryRepo.findBySkuCodeIn(skus);

            Map<String, BigDecimal> currentStocks= currentInvesntoryList.stream().collect((Collectors.toMap(Inventory::getSkuCode,Inventory::getQuantity)));
            return lst.stream().map(x->{
                BigDecimal requestedStock = x.getRequestedQuantity();
                String requestedSKU = x.getSkuCode();
                if(requestedStock.compareTo(currentStocks.getOrDefault(requestedSKU, BigDecimal.valueOf(0)))>0){
                    return UnavailableStockDTO.builder()
                            .skuCode(x.getSkuCode())
                            .requestedStock(x.getRequestedQuantity())
                            .availableStock(currentStocks.getOrDefault(requestedSKU, BigDecimal.valueOf(0)))
                            .build();
                }
                else
                    return null;
            }).filter(Objects::nonNull).toList();


    }
}
