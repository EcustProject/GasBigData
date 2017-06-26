package ecust.shgas.controller;

import ecust.shgas.dao.mysql.HeatingUserUsageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by xuwenqing on 17/6/26.
 */
@Controller
@RequestMapping("/heating")
public class HeatingUserController {
    @Autowired
    private HeatingUserUsageMapper heatingUserUsageMapper;

    @RequestMapping("/area_month_usage")
    @ResponseBody
    public List<Map<String, Object>> areaMonthUsage(
            @RequestParam("area") String area,
            @RequestParam("year") String year) {
         List<Map<String, Object>> results = null;
         if("上海市".equals(area)) {
             results = heatingUserUsageMapper.city_month_usage_change(year);
         }
         else {
             results = heatingUserUsageMapper.area_month_usage_change(area, year);
         }
         return results;
    }

    @RequestMapping("/area_year_usage")
    @ResponseBody
    public List<Map<String, Object>> areaYearUsage(@RequestParam("year") String year) {
        List<Map<String, Object>> results = null;
        results = heatingUserUsageMapper.area_year_usage(year);
        return results;
    }

    @RequestMapping("/area_11_3_usage")
    @ResponseBody
    public List<Map<String, Object>> areaMonth11To3Usage(@RequestParam("year") String year) {
        List<Map<String, Object>> results = null;
        int nextYear = Integer.parseInt(year) + 1;
        results = heatingUserUsageMapper.area_date_range_usage(year + "-11-01", nextYear + "-03-01");
        return results;
    }

    @RequestMapping("/user_year_usage")
    @ResponseBody
    public List<Map<String, Object>> userYearUsage(@RequestParam("year") String year) {
        List<Map<String, Object>> results = null;
        results = heatingUserUsageMapper.city_distribute_user_year_usage(year);
        return results;
    }
}
