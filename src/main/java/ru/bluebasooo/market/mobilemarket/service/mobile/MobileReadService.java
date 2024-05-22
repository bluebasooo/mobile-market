package ru.bluebasooo.market.mobilemarket.service.mobile;

import org.springframework.stereotype.Service;
import ru.bluebasooo.market.mobilemarket.cache.mobile.MobilesCache;
import ru.bluebasooo.market.mobilemarket.data.mobile.MobileDao;
import ru.bluebasooo.market.mobilemarket.service.mobile.mapper.MobileReadEntityToModelMapper;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.Mobile;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.Filter;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.filter.MatchableFilter;

import java.util.List;

@Service
public class MobileReadService {

    private final MobileDao mobileDao;
    private final MobilesCache mobilesCache;
    private final MobileReadEntityToModelMapper mapper;

    public MobileReadService(
            MobileDao mobileDao,
            MobileReadEntityToModelMapper mapper
    ) {
        this.mobileDao = mobileDao;
        this.mapper = mapper;
        var allMobiles = mobileDao.findAll()
                .stream()
                .map(mapper::toModel)
                .toList();

        this.mobilesCache = new MobilesCache(allMobiles);
    }

    public List<Mobile> findMobilesById(List<String> ids) {
        return mobileDao.findBatch(ids)
                .stream()
                .map(mapper::toModel)
                .toList();
    }

    public Mobile findMobileById(String id) {
        return mobileDao.find(id)
                .map(mapper::toModel)
                .orElseThrow(() -> new RuntimeException("Mobile not found by id: " + id));
    }

    public List<Mobile> findMobile(String name, List<MatchableFilter> filter) {
        if (name == null && filter == null) {
            mobilesCache.filter(new Filter(List.of()));
        }

        if (name == null) return mobilesCache.filter(new Filter(filter));

        if (filter == null) return mobilesCache.findByName(name);

        return mobilesCache.findByName(name)
                .stream()
                .filter(new Filter(filter)::isMatch)
                .toList();
    }

}
