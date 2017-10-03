package ecust.shgas.controller;
import ecust.shgas.service.VoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by dengcunbin on 17/6/3.
 */
@Controller
public class VoiceController {
    @Autowired
    @Qualifier("voiceService")
    private VoiceService voiceService;
    @RequestMapping(value = "/voice",method = RequestMethod.POST)
    @ResponseBody
    public List<List> requestVoiceData() {
        List<Integer> voiceTimeSpan = voiceService.getTimeSpan();
        List<Integer> voiceBusyTime = voiceService.getBusyTime();
        List<Integer> voicePhoneNumber = voiceService.getPhoneNumber();
        List<List> voices = new ArrayList<List>();
        voices.add(voiceTimeSpan);
        voices.add(voiceBusyTime);
        voices.add(voicePhoneNumber);
        return voices;

    }

}
