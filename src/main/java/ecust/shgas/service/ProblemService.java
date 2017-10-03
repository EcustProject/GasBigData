package ecust.shgas.service;

import java.util.List;

/**
 * Created by DXY on 2017/6/6.
 */
public interface ProblemService {
    List<Integer> getProblemSortAll();
    List<List<Integer>> getProblemByDistrict();
    List<List> getProblemByFestival();
}
