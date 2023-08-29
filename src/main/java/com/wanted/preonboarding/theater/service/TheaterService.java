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
    private final TheaterImpl theater;

    public String enter(Audience audience){
        theater.enter(TheaterRequest.builder()
                .audience(audience)
                .ticketSeller(new TicketSeller(new TicketOffice(20000L, new Ticket(100L))))
                .build()
        );
        return "Have a good time.";
    }
}
