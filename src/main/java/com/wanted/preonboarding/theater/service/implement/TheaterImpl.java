package com.wanted.preonboarding.theater.service.implement;

import com.wanted.preonboarding.theater.dto.TheaterRequest;
import com.wanted.preonboarding.theater.service.handler.Theater;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TheaterImpl implements Theater {

    private TheaterRequest theaterRequest;

    @Override
    public void enter(TheaterRequest theaterRequest){
        this.theaterRequest = theaterRequest;
        if (!checkTicket()) buyTicket();
        useTicket();
    }

    @Override
    public void useTicket(){
        theaterRequest.audience().getBag().setTicket(theaterRequest.ticketSeller().getTicketOffice().getTicket());
    }

    @Override
    public void buyTicket(){
        Long ticketFee = theaterRequest.ticketSeller().getTicketOffice().getTicket().getFee();
        theaterRequest.audience().getBag().minusAmount(ticketFee);
        theaterRequest.ticketSeller().getTicketOffice().plusAmount(ticketFee);
    }

    @Override
    public boolean checkTicket() {
        return theaterRequest.audience().getBag().hasInvitation();
    }
}
