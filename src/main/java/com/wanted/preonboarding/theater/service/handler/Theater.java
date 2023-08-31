package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.dto.TheaterRequest;
import org.springframework.stereotype.Component;

@Component
public interface Theater {

    void enter(TheaterRequest theaterRequest);
}
