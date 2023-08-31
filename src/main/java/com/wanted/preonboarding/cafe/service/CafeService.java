package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.dto.Order;
import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Cashier;
import com.wanted.preonboarding.cafe.service.handler.CustomerImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;
    private final String paymentMethod = "CARD";

    public String orderFrom(List<Order> orders){
        CustomerImpl customer = new CustomerImpl(paymentMethod, orders);
        return customer.buyCoffee(new Cashier(wantedCafe));
    }
}
