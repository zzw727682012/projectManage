package com.project.manager.common.utils;

public enum DateRange {
    WEEK(1),HALF_A_MONTH(2),MONTH(3);
    private int value;
    private DateRange(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }

    public static DateRange getDateRange(int value) {
        if (value == WEEK.value) {
            return WEEK;
        } else if (value == HALF_A_MONTH.value) {
            return HALF_A_MONTH;
        } else if (value == MONTH.value) {
            return MONTH;
        }

        return null;
    }

}
