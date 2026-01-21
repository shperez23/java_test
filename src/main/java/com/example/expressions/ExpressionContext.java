package com.example.expressions;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public final class ExpressionContext {
    private final ZoneId zone;
    private final ZonedDateTime now;
    private final String idIngesta;

    public ExpressionContext(Clock clock, ZoneId zone, String idIngesta) {
        this.zone = zone;
        this.now = DateTimeUtils.nowInZone(clock, zone);
        this.idIngesta = idIngesta;
    }

    public ZoneId zone() {
        return zone;
    }

    public ZonedDateTime now() {
        return now;
    }

    public LocalDate today() {
        return DateTimeUtils.localDate(now);
    }

    public String idIngesta() {
        return idIngesta;
    }
}
