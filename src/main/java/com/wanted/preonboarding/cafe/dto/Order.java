package com.wanted.preonboarding.cafe.dto;

import lombok.Builder;

@Builder
public record Order(String beverage, Long count) {

}
