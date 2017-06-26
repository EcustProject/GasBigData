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

    @Test
    public void area_distribute_user_year_usage() {
        System.out.println(heatingUserUsageMapper.area_distribute_user_year_usage("虹口区", "2014"));
    }

    @Test
    public void city_distribute_user_year_usage() {
        System.out.println(heatingUserUsageMapper.city_distribute_user_year_usage("2014"));
    }

    @Test
    public void area_distribute_user_date_range_usage() {
        System.out.println(heatingUserUsageMapper.area_distribute_user_date_range_usage("虹口区","2014-11-01", "2015-03-01"));
    }

    @Test
    public void city_distribute_user_date_range_usage() {
        System.out.println(heatingUserUsageMapper.city_distribute_user_date_range_usage("2014-11-01", "2015-03-01"));
    }

    @Test
    public void area_year_usage() {
        System.out.println(heatingUserUsageMapper.area_year_usage("2014"));
    }

    @Test
    public void area_year_user_count() {
        System.out.println(heatingUserUsageMapper.area_year_user_count("2014"));
    }

    @Test
    public void area_month_usage_change() {
        System.out.println(heatingUserUsageMapper.area_month_usage_change("虹口区", "2014"));
    }

    @Test
    public void city_month_usage_change() {
        System.out.println(heatingUserUsageMapper.city_month_usage_change("2014"));
    }

    @Test
    public void area_year_usage_change() {
        System.out.println(heatingUserUsageMapper.area_year_usage_change("虹口区"));
    }

    @Test
    public void city_year_usage_change() {
        System.out.println(heatingUserUsageMapper.city_year_usage_change());
    }

}
