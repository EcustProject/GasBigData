package ecust.shgas.dao.mysql;

import ecust.shgas.domain.Problem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by DXY on 2017/6/6.
 * 修改
 */
@Repository
public interface ProblemMapper {
    //统计各类报修问题出现的次数
    List<Problem> findProblemSortAll();
    //统计某一问题在各个区县出现的次数
    List<Problem> findProblemByDistrict(@Param("problem") String problem);
    //统计某段时间内的各类报修次数
    List<Problem> findProblemByFestival(@Param("month") Integer month,@Param("minday") Integer minday,@Param("maxday") Integer maxday);
}
