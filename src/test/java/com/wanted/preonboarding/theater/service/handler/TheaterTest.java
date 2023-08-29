package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.dto.TheaterRequest;
import com.wanted.preonboarding.theater.service.implement.TheaterImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TheaterTest {

    @Autowired
    private TheaterImpl theater;

    @Test
    @DisplayName("초대권이 없는 관객은 초대권 금액만큼 차감 후 입장한다.")
    void audience_enter_no_ticket() {
        //given
        Audience audience = new Audience(new Bag(1000L));
        TicketSeller ticketSeller = new TicketSeller(new TicketOffice(20000L, new Ticket(100L)));

        //when
        theater.enter(TheaterRequest.builder()
                .audience(audience)
                .ticketSeller(ticketSeller)
                .build());

        //then
        assertThat(audience.getBag().getAmount()).isEqualTo(900L);
        assertThat(ticketSeller.getTicketOffice().getAmount()).isEqualTo(20100L);
    }

    @Test
    @DisplayName("초대권이 있는 관객은 금액이 차감되지 않는다")
    void audience_enter_has_ticket() {
        //given
        Audience audience = new Audience(new Bag(new Invitation(), 1000L));
        TicketSeller ticketSeller = new TicketSeller(new TicketOffice(20000L, new Ticket(100L)));

        //when
        theater.enter(TheaterRequest.builder()
                .audience(audience)
                .ticketSeller(ticketSeller)
                .build());

        //then
        assertThat(audience.getBag().getAmount()).isEqualTo(1000L);
        assertThat(ticketSeller.getTicketOffice().getAmount()).isEqualTo(20000L);
    }
}