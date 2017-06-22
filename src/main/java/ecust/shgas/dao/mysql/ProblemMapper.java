package ecust.shgas.dao.mysql;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

/**
 * Created by DXY on 2017/6/6.
 * 修改
 */
@Repository
public interface ProblemMapper {
    //统计各类报修问题出现的次数
    @Select("select fy_leibie category ,COUNT(fy_leibie) numbers from hotxx2 where fy_leibie in ('一般维修','抄表问题','漏气','其他问题','连接管','校表问题' ) group by fy_leibie ")
    List<Map<String,Integer>> findProblemSortAll();
    //统计某一问题在各个区县出现的次数
    @Select("select fy_quming district ,COUNT(*) numbers from hotxx2 where fy_leibie=#{problemSort} group by fy_quming ")
    List<Map<String,Integer>> findProblembyDistrict(@Param("problemSort") String problemSort);
    //统计某段时间内的各类报修次数
    @Select("select fy_leibie category,count(*) numbers from hotxx2 where fy_leibie in ('一般维修','抄表问题','漏气','其他问题','连接管','校表问题' ) and Month(create_time)=#{month} and Day(create_time) between #{minday} and #{maxday} group by fy_leibie")
    List<Map<String,Integer>> findProblemByDay(@Param("month") Integer month,@Param("minday") Integer minday,@Param("maxday") Integer maxday);
}
