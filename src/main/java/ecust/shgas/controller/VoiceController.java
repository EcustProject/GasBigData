package ecust.shgas.controller;
import com.google.gson.Gson;
import ecust.shgas.service.VoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    public void requestVoiceData(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        List<Integer> voiceTimeSpan = voiceService.getTimeSpan();
        List<Integer> voiceBusyTime = voiceService.getBusyTime();
        List<Integer> voicePhoneNumber = voiceService.getPhoneNumber();
        List<List> voices = new ArrayList<List>();
        voices.add(voiceTimeSpan);
        voices.add(voiceBusyTime);
        voices.add(voicePhoneNumber);
        Gson gson = new Gson();
        String json = gson.toJson(voices);
        response.getWriter().write(json);

    }

}
