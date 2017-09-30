package ecust.shgas.controller;


import ecust.shgas.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DXY on 2017/6/6.
 */
@Controller
public class ProblemController {
    @Autowired
    private ProblemService problemService;

    @RequestMapping(value = "/problem",method = RequestMethod.GET)
    @ResponseBody
    public List requestProblemData() {
        List<Integer> problemLTypeList = problemService.getProblemSortAll();
        List<List<Integer>> districtProblemList = problemService.getProblemByDistrict();
        List<List> festivalProblemList = problemService.getProblemByFestival();
        List<List> resultList = new ArrayList<List>();
        resultList.add(problemLTypeList);
        resultList.add(districtProblemList);
        resultList.add(festivalProblemList);
        return resultList;
    }
}
