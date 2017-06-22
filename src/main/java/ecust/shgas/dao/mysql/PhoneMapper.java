package ecust.shgas.dao.mysql;
import ecust.shgas.domain.Phone;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
/**
  * Created by huchao on 2017/6/9.
  */
        public interface PhoneMapper {
        /**
          * 检测用户是否为黑明单
          * @Param String haoma
          * @return 找到返回Phone对象，没有找到返回null
          * */
        @Select("select * from blacknumber where haoma = #{haoma}")
        Phone findPhone(@Param("haoma") String haoma);
    }