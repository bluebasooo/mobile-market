package ru.bluebasooo.market.mobilemarket.entity.mobile.info;

import lombok.Value;

import java.util.List;

@Value
public class ConstructionInfo {
    CorpusType corpusType; //TODO
    List<String> materials;
    List<String> protections;
    String nameOfScreenSaver;
}
