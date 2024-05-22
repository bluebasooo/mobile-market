package ru.bluebasooo.market.mobilemarket.service.mobile.mapper;

import ru.bluebasooo.market.mobilemarket.rest.mobile.dto.FilterDto;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.Filter;

import java.util.ArrayList;
import java.util.List;

public class FilterMapper {
    List<Filter> toModel(FilterDto filterDto) {
        List<Filter> filters = new ArrayList<>();

        if (filterDto.getAccumulatorCapacityFilter() != null) {
            filters.add(
                    Filter.accumulatorCapacityFilter(
                            filterDto.getAccumulatorCapacityFilter().min(),
                            filterDto.getAccumulatorCapacityFilter().max()
                    )
            );
        }

        if (filterDto.getBrandFilter() != null) {
            filters.add(
                    Filter.brandFilter(
                            filterDto.getBrandFilter().includes(),
                            filterDto.getBrandFilter().excludes()
                    )
            );
        }

        if (filterDto.getDiagonalScreenFilter() != null) {
            filters.add(
                    Filter.diagonalScreenFilter(
                            filterDto.getDiagonalScreenFilter().min(),
                            filterDto.getDiagonalScreenFilter().max()
                    )
            );
        }

        if (filterDto.getHddCapacityFilter() != null) {
            filters.add(
                    Filter.hddCapacityFilter(
                            filterDto.getHddCapacityFilter().includes(),
                            filterDto.getHddCapacityFilter().excludes()
                    )
            );
        }

        if (filterDto.getLengthFilter() != null) {
            filters.add(
                    Filter.lengthFilter(
                            filterDto.getLengthFilter().min(),
                            filterDto.getLengthFilter().max()
                    )
            );
        }

        if (filterDto.getOsFilter() != null) {
            filters.add(
                    Filter.osFilter(
                            filterDto.getOsFilter().includes(),
                            filterDto.getOsFilter().excludes()
                    )
            );
        }

        if (filterDto.getPriceFilter() != null) {
            filters.add(
                    Filter.priceFilter(
                            filterDto.getPriceFilter().min(),
                            filterDto.getPriceFilter().max()
                    )
            );
        }

        if (filterDto.getProcessorCoresFilter() != null) {
            filters.add(
                    Filter.processorCoresFilter(
                            filterDto.getProcessorCoresFilter().includes(),
                            filterDto.getProcessorCoresFilter().excludes()
                    )
            );
        }

        if (filterDto.getRamCapacityFilter() != null) {
            filters.add(
                    Filter.ramCapacityFilter(
                            filterDto.getRamCapacityFilter().includes(),
                            filterDto.getRamCapacityFilter().excludes()
                    )
            );
        }

        if (filterDto.getReleaseYearFilter() != null) {
            filters.add(
                    Filter.releaseYearFilter(
                            filterDto.getReleaseYearFilter().min(),
                            filterDto.getReleaseYearFilter().max()
                    )
            );
        }

        if (filterDto.getScreenResolutionFilter() != null) {
            filters.add(
                    Filter.screenResolutionFilter(
                            filterDto.getScreenResolutionFilter().min(),
                            filterDto.getScreenResolutionFilter().max()
                    )
            );
        }

        if (filterDto.getUpdateScreenGzFilter() != null) {
            filters.add(
                    Filter.updateScreenGzFilter(
                            filterDto.getUpdateScreenGzFilter().includes(),
                            filterDto.getUpdateScreenGzFilter().excludes()
                    )
            );
        }

        if (filterDto.getWidthFilter() != null) {
            filters.add(
                    Filter.widthFilter(
                            filterDto.getWidthFilter().min(),
                            filterDto.getWidthFilter().max()
                    )
            );
        }

        return filters;
    }
}
