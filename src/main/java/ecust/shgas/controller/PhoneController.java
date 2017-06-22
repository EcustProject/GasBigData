package ecust.shgas.controller;
import ecust.shgas.domain.Phone;
import ecust.shgas.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* Created by huchao on 2017/5/16.
*/
@Controller
public class PhoneController {
@Autowired
private PhoneService phoneService;
@RequestMapping("/requestPhone")
public @ResponseBody
Phone requestJson(@RequestBody Phone phone){
        Phone phone1 = phoneService.findPhone(phone.getHaoma());
        return phone1;
    }
}