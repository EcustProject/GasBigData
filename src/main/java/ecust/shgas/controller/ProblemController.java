package ecust.shgas.controller;

import com.google.gson.Gson;
import ecust.shgas.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by DXY on 2017/6/6.
 */
@Controller
public class ProblemController {
    @Autowired
    @Qualifier("problemService")
    private ProblemService problemService;
    @RequestMapping(value = "/problemSort",method = RequestMethod.GET)
    public void requestProblemSortData(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        List<Map<String,Integer>> problemLeibie=problemService.getProblemSortAll();
        Gson gson = new Gson();
        String json = gson.toJson(problemLeibie);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(json);
    }
    @RequestMapping(value = "/Districtproblem",method = RequestMethod.GET)
    public void requestDistrictProblemData(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        Map<String,List<Integer>> Districtproblem=problemService.getProblemByDistrict();
        Gson gson = new Gson();
        String json = gson.toJson(Districtproblem);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(json);
    }
    @RequestMapping(value = "/Festivalproblem",method = RequestMethod.GET)
    public void requestFestivalProblemData(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        Map<String,List<Integer>> Festivalproblem=problemService.getProblemByFestival();
        Gson gson = new Gson();
        String json = gson.toJson(Festivalproblem);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(json);
    }

}
