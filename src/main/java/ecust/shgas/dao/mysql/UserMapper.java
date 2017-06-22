package ecust.shgas.dao.mysql;
import ecust.shgas.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


/**
 * Created by huchao on 2017/4/12.
 */
@Repository
public interface UserMapper {
/**
 *根据登录名和密码查询用户
 * @Param String loginname
 * @Param  String password
 * @return 找到返回User对象,没有返回null
 **/
    @Select("select * from tb_user where loginname = #{loginname} and password = #{password}")
    User findWithLoginnameAndPassword(@Param("loginname") String loginname,
                                      @Param("password") String password);
}
