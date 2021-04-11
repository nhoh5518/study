package com.example.study.controller.api;

import com.example.study.model.network.Header;
import com.example.study.model.network.response.SettlementApiResponse;
import com.example.study.service.SettlementApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/settlement")
public class SettlementApiController {

    @Autowired
    private SettlementApiLogicService settlementApiLogicService;

    @GetMapping("/{id}")
    public Header<SettlementApiResponse> settlement(@PathVariable Long id){
        return settlementApiLogicService.settlement(id);
    }
}
