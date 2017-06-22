package ecust.shgas.service.impl;

import ecust.shgas.dao.hive.HolidayDao;
import ecust.shgas.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huchao on 2017/6/21.
 */
@Service
public class HolidayServiceImpl implements HolidayService {
    @Autowired
    private HolidayDao holidayDao;
    public List getPeriodHotxx(String condition) {
        List hotxx = holidayDao.getHotxx(condition);
        return hotxx;
    }
}
