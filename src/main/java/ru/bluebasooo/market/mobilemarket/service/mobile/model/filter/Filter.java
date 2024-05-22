package ru.bluebasooo.market.mobilemarket.service.mobile.model.filter;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.filters.*;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class Filter {
    private AccumulatorCapacityFilter accumulatorCapacityFilter;
    private BrandFilter brandFilter;
    private DiagonalScreenFilter diagonalScreenFilter;
    private HddCapacityFilter hddCapacityFilter;
    private LengthFilter lengthFilter;
    private OsFilter osFilter;
    private PriceFilter priceFilter;
    private ProcessorCoresFilter processorCoresFilter;
    private RamCapacityFilter ramCapacityFilter;
    private ReleaseYearFilter releaseYearFilter;
    private ScreenResolutionFilter screenResolutionFilter;
    private UpdateScreenGzFilter updateScreenGzFilter;
    private WidthFilter widthFilter;

    @Getter
    private FilterType filterType;

    public static Filter accumulatorCapacityFilter(int minCapacity, int maxCapacity) {
        return Filter.builder()
                .accumulatorCapacityFilter(new AccumulatorCapacityFilter(minCapacity, maxCapacity))
                .filterType(FilterType.ACCUMULATOR)
                .build();
    }

    public static Filter brandFilter(List<String> includeBrands, List<String> excludeBrands) {
        return Filter.builder()
                .brandFilter(new BrandFilter(includeBrands, excludeBrands))
                .filterType(FilterType.BRAND)
                .build();
    }

    public static Filter diagonalScreenFilter(double minDiagonal, double maxDiagonal) {
        return Filter.builder()
                .diagonalScreenFilter(new DiagonalScreenFilter(minDiagonal, maxDiagonal))
                .filterType(FilterType.DIAGONAL_SCREEN)
                .build();
    }

    public static Filter hddCapacityFilter(List<Integer> includeHddCapacity, List<Integer> excludeHddCapacity) {
        return Filter.builder()
                .hddCapacityFilter(new HddCapacityFilter(includeHddCapacity, excludeHddCapacity))
                .filterType(FilterType.HDD_CAPACITY)
                .build();
    }

    public static Filter lengthFilter(double minLength, double maxLength) {
        return Filter.builder()
                .lengthFilter(new LengthFilter(minLength, maxLength))
                .filterType(FilterType.LENGTH)
                .build();
    }

    public static Filter osFilter(List<String> includeOs, List<String> excludeOs) {
        return Filter.builder()
                .osFilter(new OsFilter(includeOs, excludeOs))
                .filterType(FilterType.OS)
                .build();
    }

    public static Filter priceFilter(double minPrice, double maxPrice) {
        return Filter.builder()
                .priceFilter(new PriceFilter(minPrice, maxPrice))
                .filterType(FilterType.PRICE)
                .build();
    }

    public static Filter processorCoresFilter(List<Integer> includeProcessorCores, List<Integer> excludeProcessorCores) {
        return Filter.builder()
                .processorCoresFilter(new ProcessorCoresFilter(includeProcessorCores, excludeProcessorCores))
                .filterType(FilterType.PROCESSOR_CORES)
                .build();
    }

    public static Filter ramCapacityFilter(List<Integer> includeRamCapacity, List<Integer> excludeRamCapacity) {
        return Filter.builder()
                .ramCapacityFilter(new RamCapacityFilter(includeRamCapacity, excludeRamCapacity))
                .filterType(FilterType.RAM_CAPACITY)
                .build();
    }

    public static Filter releaseYearFilter(int minYear, int maxYear) {
        return Filter.builder()
                .releaseYearFilter(new ReleaseYearFilter(minYear, maxYear))
                .filterType(FilterType.RELEASE_YEAR)
                .build();
    }

    public static Filter screenResolutionFilter(int minResolution, int maxResolution) {
        return Filter.builder()
                .screenResolutionFilter(new ScreenResolutionFilter(minResolution, maxResolution))
                .filterType(FilterType.SCREEN_RESOLUTION)
                .build();
    }

    public static Filter updateScreenGzFilter(List<Integer> includeUpdateScreenGz, List<Integer> excludeUpdateScreenGz) {
        return Filter.builder()
                .updateScreenGzFilter(new UpdateScreenGzFilter(includeUpdateScreenGz, excludeUpdateScreenGz))
                .filterType(FilterType.UPDATE_SCREEN_GZ)
                .build();
    }

    public static Filter widthFilter(double minWidth, double maxWidth) {
        return Filter.builder()
                .widthFilter(new WidthFilter(minWidth, maxWidth))
                .filterType(FilterType.WIDTH)
                .build();
    }
}
