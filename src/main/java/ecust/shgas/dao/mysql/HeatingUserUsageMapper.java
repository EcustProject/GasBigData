package ecust.shgas.dao.mysql;

import ecust.shgas.domain.HeatingUserUsage;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by wenqing on 2017/6/22.
 */
@Repository
public interface HeatingUserUsageMapper {

    // 基本数据
    @Select(" select heating_cid cid,heating_name name, heating_address address, heating_area area, heating_time time, " +
            " heating_year year, heating_month month, heating_type type,heating_usage 'usage' from heating_user_usage limit 0, 10")
    List<HeatingUserUsage> select();

    // 某年用气量分布图数据
    @Select(" select user_usage 'usage' ,count(*) 'count' from ( " +
            "    select  sum(heating_usage) user_usage from heating_user_usage " +
            "    where heating_year = #{year} GROUP BY heating_cid " +
            " ) year_usage group by user_usage order by user_usage")
    List<Map<String, Object>> distribute_user_year_usage(@Param("year") String year);

    // 某年各区总用气量
    @Select(" select heating_area 'area', sum(heating_usage) 'usage' " +
            " from heating_user_usage where heating_year = #{year}" +
            " group by heating_area order by 'usage'")
    List<Map<String, Object>> area_year_usage(@Param("year") String year);

    // 某年各区总人数
    @Select(" select heating_area 'area', COUNT(distinct(heating_cid)) 'count' " +
            " from heating_user_usage where heating_year = #{year} " +
            " group by heating_area order by count")
    List<Map<String, Object>> area_year_user_count(@Param("year") String year);

    // 某年各区月用气量变化
    @Select(" select heating_month 'month', sum(heating_usage) 'usage' from heating_user_usage" +
            " where heating_area = #{area} and heating_year = #{year}" +
            " group by heating_month order by heating_month")
    List<Map<String, Object>> area_month_usage_change(@Param("area") String area,
            @Param("year") String year);

    // 上海市某年月用气量变化
    @Select(" select heating_month 'month', sum(heating_usage) 'usage' from heating_user_usage" +
            " where heating_year = #{year}" +
            " group by heating_month order by heating_month")
    List<Map<String, Object>> city_month_usage_change(@Param("year") String year);

    // 各区年用气量变化
    @Select(" select heating_year 'year', sum(heating_usage) 'usage' from heating_user_usage" +
            " where heating_area = #{area}" +
            " group by heating_year order by heating_year")
    List<Map<String, Object>> area_year_usage_change(@Param("area") String area);

    // 上海市年用气量变化
    @Select(" select heating_year 'year', sum(heating_usage) 'usage' from heating_user_usage" +
            " group by heating_year order by heating_year")
    List<Map<String, Object>> city_year_usage_change();

    // 区域区间用气量

}
