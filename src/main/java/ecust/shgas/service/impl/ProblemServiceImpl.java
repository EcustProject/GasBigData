package ecust.shgas.service.impl;

import ecust.shgas.dao.mysql.ProblemMapper;
import ecust.shgas.domain.Problem;
import ecust.shgas.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DXY on 2017/6/6.
 */
@Service
public class ProblemServiceImpl implements ProblemService {
    @Autowired
    @Qualifier("problemMapper")
    private ProblemMapper problemMapper;

    public List<Integer> getProblemSortAll() {
        List<Problem> problemList = problemMapper.findProblemSortAll();
        List<Integer> resultList = new ArrayList<Integer>();
        for (Problem problem : problemList){
            resultList.add(problem.getNumbers());
        }
        return resultList;
    }

    public List<List<Integer>> getProblemByDistrict() {
        String[] problemName = {"一般维修", "其他问题","抄表问题","校表问题","漏气","连接管"};
        String[] districtName = {"南汇", "卢湾", "嘉定", "奉贤", "宝山", "崇明", "徐汇", "普陀", "杨浦", "松江", "浦东", "虹口", "金山", "长宁", "闵行", "闸北", "青浦", "静安", "黄浦"};
        List<List<Integer>> problemNumbersOfDistrict = new ArrayList<List<Integer>>();
        for (String problemStr : problemName) {
            List<Problem> problemList = problemMapper.findProblemByDistrict(problemStr);
            List<Integer> numbersList = new ArrayList<Integer>();
            int j = 0,k = 0;
            while (j<problemList.size()) {
                Problem problem = problemList.get(j);
                String str = districtName[k];
                if (!str.equals(problem.getDistrict()))
                    numbersList.add(0);
                else {
                    numbersList.add(problem.getNumbers());
                    ++j;
                }
                ++k;
            }
            problemNumbersOfDistrict.add(numbersList);
        }
        return problemNumbersOfDistrict;
    }

    public List<List> getProblemByFestival(){
        String[] problemName = {"一般维修", "其他问题", "抄表问题", "校表问题", "漏气", "连接管"};
        List<List> resultList = new ArrayList<List>();
        List<List> finalResultList = new ArrayList<List>();
        for(int i = 24;i<31;i++){
            List<Problem> problemList = problemMapper.findProblemByFestival(12,i,i+1);
            resultList.add(problemList);
        }
        for (int j = 0;j<problemName.length;j++){
            finalResultList.add(returnNumberOfProblem(resultList,j));
        }
        return finalResultList;
    }

    private List returnNumberOfProblem(List<List> resultList,int j){
        List<Integer> numberList = new ArrayList<Integer>();
        for (int i = 0;i<resultList.size();i++){
            List<Problem> problemList = resultList.get(i);
            Problem problem = problemList.get(j);
            numberList.add(problem.getNumbers());
        }
        return numberList;
    }
}
