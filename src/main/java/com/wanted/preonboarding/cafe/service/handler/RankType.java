package com.wanted.preonboarding.cafe.service.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RankType {

    BEGINNER(0L),
    MIDDLE(1L),
    MASTER(2L);

    private final Long rank;
}
