package com.microservices.Inventory_Service.Controllers;


import com.microservices.Inventory_Service.DTOs.StockeCheckDTO;
import com.microservices.Inventory_Service.DTOs.UnavailableStockDTO;
import com.microservices.Inventory_Service.Services.InventoryService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Data
@RequestMapping("/inventory")
public class InventoryController {

    private InventoryService inventoryService;

    @PostMapping("/sku-stock")
    List<UnavailableStockDTO> stcokCheck(@RequestBody List<StockeCheckDTO> skus){
        return inventoryService.getStocks(skus);

    }

}
