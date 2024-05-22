package ru.bluebasooo.market.mobilemarket.service.mobile;

import org.springframework.stereotype.Service;
import ru.bluebasooo.market.mobilemarket.data.mobile.MobileDao;
import ru.bluebasooo.market.mobilemarket.service.mobile.model.Mobile;

import java.util.List;

@Service
public class MobileReadService {

    private final MobileDao mobileDao;

    public MobileReadService(
            MobileDao mobileDao
    ) {
        this.mobileDao = mobileDao;
    }

    public Mobile findMobileById(String id) {
        mobileDao.find(id);

        return null;
    }

    public List<Mobile> findMobile() {
        return null;
    }

}
