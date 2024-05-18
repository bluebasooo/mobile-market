package ru.bluebasooo.market.mobilemarket.entity.mobile.info;

import lombok.Value;

import java.time.LocalDate;

@Value
public class CommonInfo {
    MobileType type;
    String codeCreation; //TODO more good name
    LocalDate yearRelease;
}
