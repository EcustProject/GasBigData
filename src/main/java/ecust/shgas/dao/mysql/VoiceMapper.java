package ecust.shgas.dao.mysql;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by dengcunbin on 17/6/3.
 */
@Repository
public interface VoiceMapper {

    //获取音频持续时间
    @Select("select COUNT(TimeSpan) from rectable where TimeSpan > #{timeSecondsBegin} and TimeSpan <= #{timeSecondsEnd}")
    Integer findVoiceTimeSpan(@Param("timeSecondsBegin") Integer timeSecondsBegin,@Param("timeSecondsEnd") Integer timeSecondsEnd);

    //获取音频开始时间
    @Select("select COUNT(hour(BeginTime)) from rectable  where hour(BeginTime) >= #{timeBegin} and hour(BeginTime) < #{timeEnd}")
    Integer findVoiceBusyTime(@Param("timeBegin") Integer timeBegin, @Param("timeEnd") Integer timeEnd);

    //获取音频来电显示号码
    @Select("select COUNT(laidian_xianshi) from demo where length(laidian_xianshi) = #{phoneLength}")
    Integer findVoicePhoneNumber(@Param("phoneLength") Integer phoneLength);
}
