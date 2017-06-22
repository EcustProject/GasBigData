package ecust.shgas.service;

import java.util.List;
import java.util.Map;

/**
 * Created by DXY on 2017/6/6.
 */
public interface ProblemService {
    List<Map<String,Integer>> getProblemSortAll();
    Map<String,List<Integer>> getProblemByDistrict();
    Map<String,List<Integer>> getProblemByFestival();
}
