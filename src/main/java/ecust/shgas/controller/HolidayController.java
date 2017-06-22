package ecust.shgas.controller;

import ecust.shgas.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by huchao on 2017/6/21.
 */
@Controller
public class HolidayController {
    @Autowired
    HolidayService holidayService;

    @RequestMapping("/holiday")
    public
    @ResponseBody
    List getHotxx(@RequestBody Map<String, String> condition) {
        System.out.println(condition.get("year"));
        List results = holidayService.getPeriodHotxx(condition.get("year"));
        return results;
    }
}
