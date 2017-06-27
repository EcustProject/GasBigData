package ecust.shgas.service;

import java.util.List;
import java.util.Map;

/**
 * Created by huchao on 2017/6/21.
 */
 public interface HolidayService {
    /*
           获取节假日单天时间段话务统计
     */
   List  getPeriodHotxx(Map<String, String> conditio);
}

