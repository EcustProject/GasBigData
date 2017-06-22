package ecust.shgas.service.impl;

import ecust.shgas.dao.mysql.ProblemMapper;
import ecust.shgas.service.ProblemService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DXY on 2017/6/6.
 */
@Service("problemService")
public class ProblemServiceImpl implements ProblemService {
    @Qualifier("problemMapper")
    private ProblemMapper problemMapper;

    public List<Map<String, Integer>> getProblemSortAll() {
        return problemMapper.findProblemSortAll();
    }

    public Map<String, List<Integer>> getProblemByDistrict() {
        String[] ProblemName = {"一般维修", "抄表问题", "漏气", "其他问题", "连接管", "校表问题"};
        String[] DistrictName = {"南汇", "卢湾", "嘉定", "奉贤", "宝山", "崇明", "徐汇", "普陀", "杨浦", "松江", "浦东", "虹口", "金山", "长宁", "闵行", "闸北", "青浦", "静安", "黄浦"};

        Map<String, List<Integer>> resultData = new HashMap<String, List<Integer>>();
        for (String item : ProblemName) {
            List<Integer> temp = new ArrayList<Integer>();
            List<Map<String, Integer>> result = problemMapper.findProblembyDistrict(item);
            for (String data : DistrictName) {
                int i = 0;
                for (Map tempMap : result) {
                    if (data.equals(tempMap.get("district"))) {
                        temp.add(((Number) tempMap.get("numbers")).intValue());
                        break;
                    }
                    i++;
                }
                if (i == result.size()) temp.add(0);
            }
            resultData.put(item, temp);

        }
        return resultData;
    }

    public Map<String, List<Integer>> getProblemByFestival() {
        String[] FestivalName = {"国庆节", "中秋节", "端午节", "劳动节", "清明节", "春节", "元旦"};
        String[] ProblemName = {"一般维修", "其他问题", "抄表问题", "校表问题", "漏气", "连接管"};
        List<Map<String, Integer>> Guoqing = problemMapper.findProblemByDay(12, 24, 25);
        List<Map<String, Integer>> Zhongqiu = problemMapper.findProblemByDay(12, 25, 26);
        List<Map<String, Integer>> Duanwu = problemMapper.findProblemByDay(12, 26, 27);
        List<Map<String, Integer>> LaoDong = problemMapper.findProblemByDay(12, 27, 28);
        List<Map<String, Integer>> Qingming = problemMapper.findProblemByDay(12, 28, 29);
        List<Map<String, Integer>> Chunjie = problemMapper.findProblemByDay(12, 29, 30);
        List<Map<String, Integer>> YuanDan = problemMapper.findProblemByDay(12, 30, 31);
        Map<String, List<Integer>> resultdata = new HashMap<String, List<Integer>>();
        for (String data : ProblemName) {
            List<Integer> temp = new ArrayList<Integer>();
            int i = 0;
            for (Map item : Guoqing) {
                if (data.equals(item.get("category"))) {
                    temp.add(((Number) item.get("numbers")).intValue());
                    break;
                }
                i++;
            }
            if (i == Guoqing.size()) temp.add(0);
            resultdata.put(data, temp);
        }
            for(String data:ProblemName){
               int i=0;
               for(Map item:Zhongqiu){
                   if (data.equals(item.get("category"))) {
                       resultdata.get(data).add(((Number) item.get("numbers")).intValue());
                       break;
                   }
                   i++;
               }
               if(i==Zhongqiu.size()) resultdata.get(data).add(0);
             }
        for(String data:ProblemName){
            int i=0;
            for(Map item:Duanwu){
                if (data.equals(item.get("category"))) {
                    resultdata.get(data).add(((Number) item.get("numbers")).intValue());
                    break;
                }
                i++;
            }
            if(i==Duanwu.size()) resultdata.get(data).add(0);
        }
        for(String data:ProblemName){
            int i=0;
            for(Map item:LaoDong){
                if (data.equals(item.get("category"))) {
                    resultdata.get(data).add(((Number) item.get("numbers")).intValue());
                    break;
                }
                i++;
            }
            if(i==LaoDong.size()) resultdata.get(data).add(0);
        }
        for(String data:ProblemName){
            int i=0;
            for(Map item:Qingming){
                if (data.equals(item.get("category"))) {
                    resultdata.get(data).add(((Number) item.get("numbers")).intValue());
                    break;
                }
                i++;
            }
            if(i==Qingming.size()) resultdata.get(data).add(0);
        }
        for(String data:ProblemName){
            int i=0;
            for(Map item:Chunjie){
                if (data.equals(item.get("category"))) {
                    resultdata.get(data).add(((Number) item.get("numbers")).intValue());
                    break;
                }
                i++;
            }
            if(i==Chunjie.size()) resultdata.get(data).add(0);
        }
        for(String data:ProblemName){
            int i=0;
            for(Map item:YuanDan){
                if (data.equals(item.get("category"))) {
                    resultdata.get(data).add(((Number) item.get("numbers")).intValue());
                    break;
                }
                i++;
            }
            if(i==YuanDan.size()) resultdata.get(data).add(0);
        }
        return resultdata;

    }
}
