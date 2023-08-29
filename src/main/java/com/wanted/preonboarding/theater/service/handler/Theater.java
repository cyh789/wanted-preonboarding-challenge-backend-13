package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Theater {

    public void enter(Audience audience, TicketSeller ticketSeller){
        if(!checkTicket(audience)){
            buyTicket(audience, ticketSeller);
        }
        useTicket(audience, ticketSeller);
    }

    public void useTicket(Audience audience, TicketSeller ticketSeller) {
        audience.getBag().setTicket(ticketSeller.getTicketOffice().getTicket());
    }

    public void buyTicket(Audience audience, TicketSeller ticketSeller) {
        Long ticketFee = ticketSeller.getTicketOffice().getTicket().getFee();
        audience.getBag().minusAmount(ticketFee);
        ticketSeller.getTicketOffice().plusAmount(ticketFee);
    }

    public boolean checkTicket(Audience audience) {
        return audience.getBag().hasInvitation();
    }
}
