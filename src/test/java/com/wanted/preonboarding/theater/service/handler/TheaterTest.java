package com.wanted.preonboarding.theater.service.handler;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

@SpringBootTest
class TheaterTest {

    @Autowired
    private Theater theater;

    @Test
    void enter() {
        //given
        Audience audience = new Audience(new Bag(1000L));
        TicketSeller ticketSeller = new TicketSeller(new TicketOffice(20000L, new Ticket(100L)));

        //when
        theater.enter(audience, ticketSeller);

        //then
        assertThat(audience.getBag().getAmount()).isEqualTo(900L);
        assertThat(ticketSeller.getTicketOffice().getAmount()).isEqualTo(20100L);
    }
}