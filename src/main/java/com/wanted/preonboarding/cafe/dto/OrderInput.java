package com.wanted.preonboarding.cafe.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record OrderInput(List<Order> orders) {
}
