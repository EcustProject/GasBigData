package ecust.shgas.dao.mysql;

import ecust.shgas.domain.HeatingUserUsage;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wenqing on 2017/6/22.
 */
@Repository
public interface HeatingUserUsageMapper {
    @Select("select heating_cid cid,heating_name name, heating_address address, heating_area area, heating_time time, " +
            " heating_year year, heating_month month, heating_type type,heating_usage 'usage' from heating_user_usage limit 0, 10")
    List<HeatingUserUsage> select();
}
