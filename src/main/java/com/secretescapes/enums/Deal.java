package com.secretescapes.enums;

public enum Deal {
    SEASONS("Seasons"),
    HOLIDAY_THEMES("Holiday themes"),
    STAY_TYPES("Stay types"),
    THINGS_TO_DO("Things to do"),
    TRAVEL_INCLUDED("Travel included"),
    TYPE_OF_TRAVELLERS("Type of travellers");

    private final String deal;

    Deal(String deal) {
        this.deal = deal;
    }

    public String getDeal() {
        return deal;
    }
}