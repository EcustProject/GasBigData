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

    @RequestMapping("/area_year_range_user_count")
    @ResponseBody
    public List<Map<String, Object>> userYearUsageCountRange(@RequestParam("year") String year,
                                                    @RequestParam("low") int  low,
                                                    @RequestParam("high") int high) {
        List<Map<String, Object>> results = null;
        results = heatingUserUsageMapper.area_year_usage_range_count(year, low, high);
        return results;
    }

    @RequestMapping("/area_11_3_range_user_count")
    @ResponseBody
    public List<Map<String, Object>> user11TO3UsageCountRange(@RequestParam("year") String year,
                                                    @RequestParam("low") int  low,
                                                    @RequestParam("high") int high) {
        List<Map<String, Object>> results = null;
        int nextYear = Integer.parseInt(year) + 1;
        results = heatingUserUsageMapper.area_date_usage_range_count(
                year + "-11-01",
                nextYear + "-03-01",
                low, high);
        return results;
    }

    @RequestMapping("/city_year_usage_range_count")
    @ResponseBody
    public List<Map<String, Integer>> user_count_by_11_3(@RequestParam("year") String year) {
        List<Map<String,Integer>> results = new LinkedList<Map<String, Integer>>();
        for(int low = 0; low < 800; low+=200) {
            int count = heatingUserUsageMapper.city_year_usage_range_count(
                    year, low, low+200);
            Map<String, Integer> result = new HashMap<String, Integer>(1);
            result.put(low+"-"+(low+200), count);
            results.add(result);
        }
        int count = heatingUserUsageMapper.city_year_usage_range_count(
                year,800, Integer.MAX_VALUE);
        Map<String, Integer> result = new HashMap<String, Integer>(1);
        result.put("800-", count);
        results.add(result);
        return results;
    }

    @RequestMapping("/city_11_3_range_user_count")
    @ResponseBody
    public List<Map<String, Integer>> user_count_by_year(@RequestParam("year") String year) {
        int nextYear = Integer.parseInt(year) + 1;
        String startDate = year + "-11-01";
        String endDate = nextYear + "-03-01";
        List<Map<String,Integer>> results = new LinkedList<Map<String, Integer>>();
        for(int low = 0; low < 800; low+=200) {
            int count = heatingUserUsageMapper.city_date_usage_range_count(
                    startDate, endDate,
                    low, low+200);
            Map<String, Integer> result = new HashMap<String, Integer>(1);
            result.put(low+"-"+(low+200), count);
            results.add(result);
        }
        int count = heatingUserUsageMapper.city_date_usage_range_count(
                startDate, endDate,
                800, Integer.MAX_VALUE);
        Map<String, Integer> result = new HashMap<String, Integer>(1);
        result.put("800-", count);
        results.add(result);
        return results;
    }

}
