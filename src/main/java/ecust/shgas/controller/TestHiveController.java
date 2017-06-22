package ecust.shgas.controller;

import ecust.shgas.dao.hive.HiveTestDao;
import ecust.shgas.domain.Hot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wenqing on 2017/6/20.
 */
@Controller
@RequestMapping("/test/hive")
public class TestHiveController {
    @Autowired
    private HiveTestDao hiveTestDao;

    @RequestMapping(value = "/hot", method = RequestMethod.GET)
    @ResponseBody public List<Hot> getHots() {
        System.out.println("execute getHots");
        List<Hot> hots = hiveTestDao.getHots();
        for(Hot hot : hots) {
            System.out.println(hot);
        }
        return hots;
    }

    @RequestMapping(value = "/script")
    @ResponseBody public Map<String, String> executeHiveScript() {
        System.out.println("executeHiveScript");
        hiveTestDao.executeHiveScript();
        Map<String, String> message = new HashMap<String, String>();
        message.put("code", "200");
        message.put("message", "executeHiveScript");
        return message;
    }
}
