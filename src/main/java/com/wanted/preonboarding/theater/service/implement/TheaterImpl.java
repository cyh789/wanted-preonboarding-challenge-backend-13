package com.wanted.preonboarding.theater.service.implement;

import com.wanted.preonboarding.theater.dto.TheaterRequest;
import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.Theater;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TheaterImpl implements Theater {

    @Override
    public void enter(TheaterRequest theaterRequest){
        if (!checkTicket(theaterRequest.audience())) buyTicket(theaterRequest);
        useTicket(theaterRequest);
    }

    private void useTicket(TheaterRequest theaterRequest){
        theaterRequest.audience().getBag().setTicket(theaterRequest.ticketSeller().getTicketOffice().getTicket());
    }

    private void buyTicket(TheaterRequest theaterRequest){
        Long ticketFee = theaterRequest.ticketSeller().getTicketOffice().getTicket().getFee();
        theaterRequest.audience().getBag().minusAmount(ticketFee);
        theaterRequest.ticketSeller().getTicketOffice().plusAmount(ticketFee);
    }

    private boolean checkTicket(Audience audience) {
        return audience.getBag().hasInvitation();
    }
}
