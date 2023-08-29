package com.wanted.preonboarding.theater.dto;

import com.wanted.preonboarding.theater.service.handler.Audience;
import lombok.Builder;

@Builder
public record EnterRequest(Audience audience) {

}
