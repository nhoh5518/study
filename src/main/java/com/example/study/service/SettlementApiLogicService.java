package com.example.study.service;

import com.example.study.model.entity.OrderGroup;
import com.example.study.model.entity.Settlement;
import com.example.study.model.network.Header;
import com.example.study.model.network.response.SettlementApiResponse;
import com.example.study.repository.OrderGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SettlementApiLogicService {

    @Autowired
    private OrderGroupRepository orderGroupRepository;

    public Header<SettlementApiResponse> settlement(Long id) {

        Optional<OrderGroup> optional = orderGroupRepository.findById(id);

        Settlement settlement = Settlement.builder()
                .userId(id)
                .price(optional.get().getTotalPrice())
                .build();

        SettlementApiResponse settlementApiResponse = SettlementApiResponse.builder()
                .userid(settlement.getUserId())
                .price(settlement.getPrice())
                .build();

        return Header.OK(settlementApiResponse);
    }
}
