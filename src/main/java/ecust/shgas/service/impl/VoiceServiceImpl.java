package ecust.shgas.service.impl;
import ecust.shgas.dao.mysql.VoiceMapper;
import ecust.shgas.service.VoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dengcunbin on 17/6/4.
 */
@Service("voiceService")
public class VoiceServiceImpl implements VoiceService {
    @Autowired
    @Qualifier("voiceMapper")
    private VoiceMapper voiceMapper;

    //音频持续时间
    public List<Integer> getTimeSpan(){
        List<Integer> voicesLengthInteger = new ArrayList<Integer>();
        for (Integer i = 0; i <3; i++){
            voicesLengthInteger.add(voiceMapper.findVoiceTimeSpan(i*60,(i+1)*60));
        }
        voicesLengthInteger.add(voiceMapper.findVoiceTimeSpan(3*60,Integer.MAX_VALUE));
        return voicesLengthInteger;
    }

    //音频开始时间
    public List<Integer> getBusyTime(){
        List<Integer> voicesBusyInteger = new ArrayList<Integer>();
        for (Integer i = 8; i <18; i++){
            voicesBusyInteger.add(voiceMapper.findVoiceBusyTime(i,(i+1)));
        }
        return voicesBusyInteger;
    }

    //来电显示的电话号码
    public List<Integer> getPhoneNumber() {
        List<Integer> voicesPhoneNumInteger = new ArrayList<Integer>();
        voicesPhoneNumInteger.add(voiceMapper.findVoicePhoneNumber(8));
        voicesPhoneNumInteger.add(voiceMapper.findVoicePhoneNumber(11));
        return voicesPhoneNumInteger;
    }
}
