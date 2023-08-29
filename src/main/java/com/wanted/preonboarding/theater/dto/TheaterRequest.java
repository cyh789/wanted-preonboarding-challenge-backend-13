package com.wanted.preonboarding.theater.dto;

import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.TicketSeller;
import lombok.Builder;

@Builder
public record TheaterRequest(Audience audience, TicketSeller ticketSeller) {
}
