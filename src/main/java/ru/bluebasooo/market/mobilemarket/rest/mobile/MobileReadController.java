package ru.bluebasooo.market.mobilemarket.rest.mobile;

import org.springframework.web.bind.annotation.*;
import ru.bluebasooo.market.mobilemarket.rest.mobile.dto.FindMobileRequest;
import ru.bluebasooo.market.mobilemarket.rest.mobile.dto.MobileResponse;
import ru.bluebasooo.market.mobilemarket.rest.mobile.mapper.MobileReadDtoToModelMapper;
import ru.bluebasooo.market.mobilemarket.service.mobile.MobileReadService;

import java.util.List;

@RestController
@RequestMapping("/mobile")
public class MobileReadController {

    private final MobileReadService mobileReadService;
    private final MobileReadDtoToModelMapper mapper;

    public MobileReadController(
            MobileReadService mobileReadService,
            MobileReadDtoToModelMapper mapper
    ) {
        this.mobileReadService = mobileReadService;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public MobileResponse findMobileById(@PathVariable("id") String id) {
        var mobile = mobileReadService.findMobileById(id);

        return mapper.toDto(mobile);
    }

    @GetMapping("/find")
    public List<MobileResponse> findMobile(@RequestBody FindMobileRequest findRequest) {
        var mobiles = mobileReadService.findMobile();

        return mobiles.stream()
                .map(mapper::toDto)
                .toList();
    }
}
