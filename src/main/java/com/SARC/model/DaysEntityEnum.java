package com.SARC.model;

import java.time.DayOfWeek;

public enum DaysEntityEnum {

    MONDAY(DayOfWeek.MONDAY),
    TUESDAY(DayOfWeek.TUESDAY),
    WEDNESDAY(DayOfWeek.WEDNESDAY),
    THURSDAY(DayOfWeek.THURSDAY),
    FRIDAY(DayOfWeek.FRIDAY),
    SATURDAY(DayOfWeek.SATURDAY),
    SUNDAY(DayOfWeek.SUNDAY);

    private final DayOfWeek dayOfWeek;

    DaysEntityEnum(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
}
