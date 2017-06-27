package ecust.shgas.dao.mysql;

import ecust.shgas.domain.HeatingUserUsage;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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

    // 某区某年用气量分布图数据
    @Select(" select user_usage 'usage' ,count(*) 'count' from ( " +
            "    select  sum(heating_usage) user_usage from heating_user_usage " +
            "    where heating_area = #{area} and heating_year = #{year}" +
            "    group by heating_cid " +
            " ) year_usage group by user_usage order by user_usage")
    List<Map<String, Object>> area_distribute_user_year_usage(@Param("area") String area,
                                                              @Param("year") String year);

    // 上海市某年用气量分布图数据
    @Select(" select user_usage 'usage' ,count(*) 'count' from ( " +
            "    select  sum(heating_usage) user_usage from heating_user_usage " +
            "    where heating_year = #{year} GROUP BY heating_cid " +
            " ) year_usage group by user_usage order by user_usage")
    List<Map<String, Object>> city_distribute_user_year_usage(@Param("year") String year);

    // 某区某日期区间用气量分布图数据
    @Select(" select user_usage 'usage',count(*) 'count' from (" +
            "     select sum(heating_usage) user_usage from heating_user_usage " +
            "     where heating_area = #{area} and heating_time >= #{startDate} and heating_time <= #{endDate}" +
            "     group by heating_cid" +
            " ) hot_usage group by user_usage order by user_usage;")
    List<Map<String, Object>> area_distribute_user_date_range_usage(@Param("area") String area,
                                                                    @Param("startDate") String startDate,
                                                                    @Param("endDate") String endDate);

    // 上海市某日期区间用气量分布图数据
    @Select(" select user_usage 'usage',count(*) 'count' from (" +
            "     select sum(heating_usage) user_usage from heating_user_usage " +
            "     where heating_time >= #{startDate} and heating_time <= #{endDate}" +
            "     group by heating_cid" +
            " ) hot_usage group by user_usage order by user_usage;")
    List<Map<String, Object>> city_distribute_user_date_range_usage(@Param("startDate") String startDate,
                                                               @Param("endDate") String endDate);

    // 某年各区总用气量
    @Select(" select heating_area 'area', sum(heating_usage) 'usage' " +
            " from heating_user_usage where heating_year = #{year}" +
            " group by heating_area order by 'usage'")
    List<Map<String, Object>> area_year_usage(@Param("year") String year);

    // 某日期区间各区用气量
    @Select(" select heating_area 'area', sum(heating_usage) 'usage' " +
            "from heating_user_usage " +
            " where heating_time >= #{startDate} and heating_time <= #{endDate}" +
            " group by heating_area")
    List<Map<String, Object>> area_date_range_usage(@Param("startDate") String startDate,
                                                    @Param("endDate") String endDate);

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

    // 年用气量区间人数分布
    @Select(" select heating_area 'area', count(*) 'count' from (" +
            "    select sum(heating_usage) user_usage, heating_area from heating_user_usage " +
            "    where heating_year=#{year} " +
            "    group by heating_cid,heating_area " +
            " ) hot_usage " +
            " where user_usage >= #{lowUsage} and user_usage < #{highUsage}" +
            " group by heating_area")
    List<Map<String, Object>> area_year_usage_range_count(@Param("year") String year,
                                               @Param("lowUsage")int lowUsage,
                                               @Param("highUsage")int highUsage);

    // 区间日期用气量区间人数分布
    @Select(" select heating_area 'area', count(*) 'count' from (" +
            "    select sum(heating_usage) user_usage, heating_area from heating_user_usage " +
            "    where heating_time >= #{startDate} and heating_time <= #{endDate}" +
            "    group by heating_cid,heating_area " +
            " ) hot_usage " +
            " where user_usage >= #{lowUsage} and user_usage < #{highUsage}" +
            " group by heating_area")
    List<Map<String, Object>> area_date_usage_range_count(@Param("startDate") String startDate,
                                               @Param("endDate") String endDate,
                                               @Param("lowUsage")int lowUsage,
                                               @Param("highUsage")int highUsage);

    // 上海市区间人数分布
    @Select(" select count(*) 'count' from (" +
            "    select sum(heating_usage) user_usage from heating_user_usage " +
            "    where heating_year = #{year}" +
            "    group by heating_cid " +
            " ) hot_usage " +
            " where user_usage >= #{lowUsage} and user_usage < #{highUsage}")
    int city_year_usage_range_count(@Param("year") String year,
                                    @Param("lowUsage")int lowUsage,
                                    @Param("highUsage")int highUsage);

    // 上海市区间人数分布
    @Select(" select count(*) 'count' from (" +
            "    select sum(heating_usage) user_usage from heating_user_usage " +
            "    where heating_time >= #{startDate} and heating_time <= #{endDate}" +
            "    group by heating_cid " +
            " ) hot_usage " +
            " where user_usage >= #{lowUsage} and user_usage < #{highUsage}")
    int city_date_usage_range_count(@Param("startDate") String startDate,
                                                          @Param("endDate") String endDate,
                                                          @Param("lowUsage")int lowUsage,
                                                          @Param("highUsage")int highUsage);

    /**
     * 修复部分没有区域的数据
     */
    @Select("SELECT distinct(left(heating_address,3)) FROM heating_user_usage WHERE heating_area = ''")
    List<String> select_need_repair_data();

    @Select("SELECT distinct(heating_area) from heating_user_usage " +
            "where heating_area != '' and heating_address like #{address}")
    List<String> select_area_by_address(@Param("address") String address);

    @Update("update heating_user_usage set heating_area = #{area} " +
            "where heating_area='' and left(heating_address,3) = #{address}")
    int update_need_repair_data(@Param("area")String area, @Param("address") String address);

}
