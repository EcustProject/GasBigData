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
    @Select("select * from heating_user_usage limit 0, 10")
    List<HeatingUserUsage> select();
}
