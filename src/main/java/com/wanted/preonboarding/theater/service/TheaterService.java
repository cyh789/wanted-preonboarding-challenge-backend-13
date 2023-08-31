package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.dto.TheaterRequest;
import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.Ticket;
import com.wanted.preonboarding.theater.service.handler.TicketOffice;
import com.wanted.preonboarding.theater.service.handler.TicketSeller;
import com.wanted.preonboarding.theater.service.implement.TheaterImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {

    private final long ticketAmount = 20000L;
    private final long ticketFee = 100L;

    private final TheaterImpl theater;

    public String enter(Audience audience){
        theater.enter(TheaterRequest.builder()
                .audience(audience)
                .ticketSeller(new TicketSeller(new TicketOffice(ticketAmount, new Ticket(ticketFee))))
                .build()
        );
        return "Have a good time.";
    }
}
