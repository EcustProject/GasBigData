package ecust.shgas.dao;

import ecust.shgas.dao.mysql.HeatingUserUsageMapper;
import ecust.shgas.domain.HeatingUserUsage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by wenqing on 2017/6/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class TestHeatingUserUsageMapper{
    @Autowired
    private HeatingUserUsageMapper heatingUserUsageMapper;

    @Test
    public void select() {
        List<HeatingUserUsage> usages = heatingUserUsageMapper.select();
        System.out.println(usages);
    }
}
