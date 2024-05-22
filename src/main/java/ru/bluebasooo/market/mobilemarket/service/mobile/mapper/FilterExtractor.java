package ru.bluebasooo.market.mobilemarket.service.mobile.mapper;

import org.springframework.stereotype.Component;
import ru.bluebasooo.market.mobilemarket.rest.mobile.dto.FilterDto;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.MatchableFilter;

import java.util.ArrayList;
import java.util.List;

@Component
public class FilterExtractor {
    public List<MatchableFilter> filters(FilterDto filterDto) {
        List<MatchableFilter> filters = new ArrayList<>();

        if (filterDto.getAccumulatorCapacityFilter() != null) {
            filters.add(filterDto.getAccumulatorCapacityFilter());
        }

        if (filterDto.getBrandFilter() != null) {
            filters.add(filterDto.getBrandFilter());
        }

        if (filterDto.getDiagonalScreenFilter() != null) {
            filters.add(filterDto.getDiagonalScreenFilter());
        }

        if (filterDto.getHddCapacityFilter() != null) {
            filters.add(filterDto.getHddCapacityFilter());
        }

        if (filterDto.getLengthFilter() != null) {
            filters.add(filterDto.getLengthFilter());
        }

        if (filterDto.getOsFilter() != null) {
            filters.add(filterDto.getOsFilter());
        }

        if (filterDto.getPriceFilter() != null) {
            filters.add(filterDto.getPriceFilter());
        }

        if (filterDto.getProcessorCoresFilter() != null) {
            filters.add(filterDto.getProcessorCoresFilter());
        }

        if (filterDto.getRamCapacityFilter() != null) {
            filters.add(filterDto.getRamCapacityFilter());
        }

        if (filterDto.getReleaseYearFilter() != null) {
            filters.add(filterDto.getReleaseYearFilter());
        }

        if (filterDto.getUpdateScreenGzFilter() != null) {
            filters.add(filterDto.getUpdateScreenGzFilter());
        }

        if (filterDto.getWidthFilter() != null) {
            filters.add(filterDto.getWidthFilter());
        }

        return filters;
    }
}
