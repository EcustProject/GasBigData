package ecust.shgas.service;

import java.util.List;

/**
 * Created by dengcunbin on 17/6/3.
 */
public interface VoiceService {
    //音频持续时间
    List<Integer> getTimeSpan();
    //话务员忙碌时间
    List<Integer> getBusyTime();
    //来电显示的电话号码
    List<Integer> getPhoneNumber();
}
