package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.dto.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CustomerTest {

    @Test
    @DisplayName("아메리카노를 3개 주문 후 주문결과를 확인 가능하다")
    void customer_buy_coffee_americano() {
        //given
        Cashier cashier = new Cashier(new Cafe());

        String paymentMethod = "CARD";
        Order order = new Order("Americano", 3L);
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        CustomerImpl customer = new CustomerImpl(paymentMethod, orders);

        //when
        String responseMsg = customer.buyCoffee(cashier);

        //when
        //System.out.printf("responseMsg[%s]", responseMsg);
        assertThat(responseMsg).isEqualTo("Americano:3");
    }
}