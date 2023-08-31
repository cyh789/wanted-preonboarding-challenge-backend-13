package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.dto.Order;
import lombok.RequiredArgsConstructor;

import java.util.List;

//@Component
@RequiredArgsConstructor
public class CustomerImpl {

    private final String paymentMethod;
    private final List<Order> myOrders;

    public String buyCoffee(Cashier cashier) {
        long totalPrice = cashier.calculateTotalPrice(myOrders);
        return cashier.takeOrder(myOrders, totalPrice);
    }
}
