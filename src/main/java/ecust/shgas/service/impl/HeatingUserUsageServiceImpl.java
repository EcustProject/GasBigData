package ecust.shgas.service.impl;

import ecust.shgas.dao.mysql.HeatingUserUsageMapper;
import ecust.shgas.service.HeatingUserUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xuwenqing on 17/6/26.
 */
@Service("heatingUserUsageService")
public class HeatingUserUsageServiceImpl implements HeatingUserUsageService {
    @Autowired
    private HeatingUserUsageMapper heatingUserUsageMapper;

    public void repairAreaIsNullData() {
        List<String> repairs = heatingUserUsageMapper.select_need_repair_data();
        for(String address : repairs) {
            List<String> area = heatingUserUsageMapper.select_area_by_address(address+"%");
            if(area.size() == 1) {
                int repair_count = heatingUserUsageMapper.update_need_repair_data(area.get(0), address);
                System.out.printf("修复 ％s 区号为 %s ，共计%s个", address, area.get(0), repair_count);
            }
            else {
                System.out.printf("%s修复失败,其对应多个区号％s \n", address, area);
                // 一个地址对应多个区号，手动sql修复
                // 譬如
                // update heating_user_usage set heating_area = '宝山区' where heating_address= '共和新路5308弄68支弄34号602室'
            }
        }
    }
}
