package ru.bluebasooo.market.mobilemarket.rest.mobile.dto;

import lombok.Value;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.filters.*;

@Value
public class FilterDto {
    AccumulatorCapacityFilter accumulatorCapacityFilter;
    BrandFilter brandFilter;
    DiagonalScreenFilter diagonalScreenFilter;
    HddCapacityFilter hddCapacityFilter;
    LengthFilter lengthFilter;
    OsFilter osFilter;
    PriceFilter priceFilter;
    ProcessorCoresFilter processorCoresFilter;
    ProcessorFrequencyFilter processorFrequencyFilter;
    RamCapacityFilter ramCapacityFilter;
    ReleaseYearFilter releaseYearFilter;
    UpdateScreenGzFilter updateScreenGzFilter;
    WidthFilter widthFilter;
}
