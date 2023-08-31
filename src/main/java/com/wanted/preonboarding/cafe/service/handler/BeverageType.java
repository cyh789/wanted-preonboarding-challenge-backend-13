package com.wanted.preonboarding.cafe.service.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum BeverageType {
    AMERICANO(100L),
    LATTE(110L),
    ESPRESSO(120L);

    private final Long price;

    public static BeverageType getBeverageTypeByOrderInput(String order) {
        return Stream.of(BeverageType.values())
                .filter(s -> s.toString().equals(order.toUpperCase()))
                .findFirst()
                .orElseThrow(
                        ()-> new RuntimeException("해당 음료는 메뉴에 없는 음료입니다.")
                );
    }
}
