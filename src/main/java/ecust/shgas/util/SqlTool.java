package ecust.shgas.util;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by huchao on 2017/6/23.
 */
@Component
public class SqlTool {
    private Map<String, List> map;
    public Map getMap() {
        return map;
    }
    public void setMap(Map map) {
        this.map = map;
    }
    public List<String> sqlset(){
        String split_char = "\\?";//sql字符串分隔符
        String table_prefix = "hotxx_";//表前缀
        List<String> sqlCollection = new LinkedList<String>();
        for (String key : this.map.keySet()) {
            StringBuffer sqlConnect = new StringBuffer();
            List limits = this.map.get(key);
            String[] sqls = key.split(split_char);
            //查询条件数
            int con_len = limits.size();
            //以问号进行分割sql语句,进行sql字符串拼接
            int sql_len = sqls.length;
            for (int i = 0; i < con_len; i++) {
                if(limits.get(i) instanceof String){
                    boolean isMatch = ((String) limits.get(i)).contains(table_prefix);
                        if(isMatch){
                            sqlConnect.append(sqls[i]+limits.get(i));
                        }else{
                            sqlConnect.append(sqls[i] + "'"+limits.get(i)+"'");
                        }
                }else{
                    sqlConnect.append(sqls[i]+limits.get(i));
                }

            }
            if (sql_len == con_len + 1) {
                sqlConnect.append(sqls[con_len]);
            }
            System.out.println(sqlConnect);
            sqlCollection.add(sqlConnect.toString());
        }
        return sqlCollection;
    }
}
