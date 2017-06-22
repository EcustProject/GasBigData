package ecust.shgas.controller;

import ecust.shgas.service.UseThreadPoolDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.LinkedList;
import java.util.List;


/**
 * 用于测试
 */
@Controller
@RequestMapping("test")
public class TestController {

    @Autowired
    private UseThreadPoolDemoService useThreadPoolDemoService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public @ResponseBody List<HelloModel> getAll(){
        List<HelloModel> results = new LinkedList<HelloModel>();
        for(int i = 0; i < 3; i++) {
            HelloModel hello = new HelloModel();
            hello.setId(i + "");
            hello.setMessage("hello world.");
            results.add(hello);
        }
        return results;
    }

    @RequestMapping(value = "/hello/{id}", method = RequestMethod.GET)
    public @ResponseBody HelloModel getOne(@PathVariable("id") String id) {
        HelloModel hello = new HelloModel();
        hello.setId(id);
        hello.setMessage("hello world.");
        return hello;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public @ResponseBody HelloModel post(@RequestBody HelloModel model) {
        System.out.println("new model");
        return model;
    }

    @RequestMapping(value = "/thread", method = RequestMethod.GET)
    public @ResponseBody HelloModel thread() {
        useThreadPoolDemoService.threadTest();
        return new HelloModel("thread1", "success");
    }

    public static class HelloModel {
        private String id;
        private String message;

        public HelloModel() {

        }

        public HelloModel(String id, String message) {
            this.id = id;
            this.message = message;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}

