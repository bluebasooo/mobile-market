package ru.bluebasooo.market.mobilemarket.data.mobile.entity.mobile.info;

import lombok.Value;

@Value
public class CellInfo {
    String bluetoothVersion;
    String wifiStandard;
    boolean isNfcSupport;
}
