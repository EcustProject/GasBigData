package ecust.shgas.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * Created by dengcunbin on 17/9/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-config.xml","classpath:springmvc-config.xml"})
public class ProblemServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProblemService problemService;

    @Test
    public void testGetProblemSortAll() throws Exception {
        List<Integer> problemLeibie = problemService.getProblemSortAll();
        System.out.println("problemLeibie"+problemLeibie);
    }

    @Test
    public void testGetProblemByDistrict() throws Exception {
        List<List<Integer>> districtProblemList=problemService.getProblemByDistrict();
        System.out.println("Districtproblem" + districtProblemList);
    }

    @Test
    public void testGetProblemByFestival() throws Exception {
        List<List> festivalproblemList = problemService.getProblemByFestival();
        System.out.println("festivalproblemList"+festivalproblemList);
    }
}