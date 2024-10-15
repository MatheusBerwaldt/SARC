package com.SARC.model;

public enum TimeEntityEnum {
    L("19:15-20:00"),
    M("20:00-20:45"),
    N("21:00-21:45"),
    P("21:45-22:30");

    private String timeRange;

    TimeEntityEnum(String timeRange) {
        this.timeRange = timeRange;
    }
    public String getTimeRange() {
        return timeRange;
    }
    public static TimeEntityEnum fromValue(String value) {
        for (TimeEntityEnum time : TimeEntityEnum.values()) {
            if (time.name().equalsIgnoreCase(value)) {
                return time;
            }
        }
        throw new IllegalArgumentException("Horário inválido: " + value);
    }
}

