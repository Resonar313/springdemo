package hello.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "Spring!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // 템플릿 요청 안함, 바로 http 바디에 데이터 넘김
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // html 태그가 아니라 http 바디 부분에 해당 문자열을 그대로 집어넣음, 템플릿 요청 안함
    }

    @GetMapping("hello-api")
    @ResponseBody // 데이터로 객체가 올 시, JSON 방식으로 전달(기본)
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // JSON 방식의 객체로 나옴 [키 : 밸류]
    }
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
