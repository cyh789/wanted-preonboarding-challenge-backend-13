package com.wanted.preonboarding.theater.dto;

import com.wanted.preonboarding.cafe.dto.Order;
import lombok.Builder;

import java.util.List;

@Builder
public record CustomerRequest(String paymentMethod, List<Order> orders) {

}
