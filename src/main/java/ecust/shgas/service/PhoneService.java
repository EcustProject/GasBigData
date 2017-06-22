package ecust.shgas.service;
import ecust.shgas.domain.Phone;
/**
  * Created by huchao on 2017/6/9.
  */
public interface PhoneService {
        /**
          * 检测用户是否为黑明单
          * @Param String haoma
          * @return 找到返回Phone对象，没有找到返回null
          * */
        Phone findPhone(String haoma);
    }
