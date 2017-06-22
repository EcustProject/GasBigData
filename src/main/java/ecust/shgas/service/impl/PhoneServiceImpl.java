package ecust.shgas.service.impl;
/**
 * Created by huchao on 2017/6/20.
 */
import ecust.shgas.dao.mysql.PhoneMapper;
import ecust.shgas.domain.Phone;
import ecust.shgas.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
  * Created by huchao on 2017/6/9.
  */
@Service("phoneService")
public class PhoneServiceImpl implements PhoneService{
            @Autowired
            private PhoneMapper phoneMapper;
            /**
             * 检测用户是否为黑明单
             *
             * @return 找到返回Phone对象，没有找到返回null
             * @Param String haoma
             */
            public Phone findPhone(String haoma) {
                return phoneMapper.findPhone(haoma);
            }
}
        