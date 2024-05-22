package ru.bluebasooo.market.mobilemarket.rest.mobile;

import org.springframework.web.bind.annotation.*;
import ru.bluebasooo.market.mobilemarket.rest.mobile.dto.FindMobileRequest;
import ru.bluebasooo.market.mobilemarket.rest.mobile.dto.MobileResponse;
import ru.bluebasooo.market.mobilemarket.rest.mobile.mapper.MobileReadDtoToModelMapper;
import ru.bluebasooo.market.mobilemarket.service.mobile.MobileReadService;
import ru.bluebasooo.market.mobilemarket.service.mobile.mapper.FilterExtractor;

import java.util.List;

@RestController
@RequestMapping("/mobile")
public class MobileReadController {

    private final MobileReadService mobileReadService;
    private final MobileReadDtoToModelMapper mapper;
    private final FilterExtractor filterExtractor;

    public MobileReadController(
            MobileReadService mobileReadService,
            MobileReadDtoToModelMapper mapper,
            FilterExtractor filterExtractor
    ) {
        this.mobileReadService = mobileReadService;
        this.mapper = mapper;
        this.filterExtractor = filterExtractor;
    }

    @GetMapping("/{id}")
    public MobileResponse findMobileById(@PathVariable("id") String id) {
        var mobile = mobileReadService.findMobileById(id);

        return mapper.toDto(mobile);
    }

    @GetMapping("/find")
    public List<MobileResponse> findMobile(@RequestBody FindMobileRequest findRequest) {
        var filters = filterExtractor.filters(findRequest.getFilterDto());
        var mobiles = mobileReadService.findMobile(findRequest.getSearchRequest(), filters);

        return mobiles.stream()
                .map(mapper::toDto)
                .toList();
    }
}
