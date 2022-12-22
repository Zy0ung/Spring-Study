package hello.request.controller;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@Controller
public class RequestController {


    @ResponseBody   // HTTP 바디에 직접 노출
    @RequestMapping("/request-param-v0")
    public String requestParamV1(@RequestParam("username") String username, @RequestParam("age") int age) {
        log.info("username={},age={}",username , age);

        return "ok";
    }


    //  @RequestMapping메서드를 지정하지 않으면 디폴트값으로 get,post 등 모두 지원
    //  controller를 통해서 결과를 렌더링 한 후 클라이언트에게 view를 응답한다
    @RequestMapping("/request-param-v1")
    public String requestParam(@RequestParam String username, @RequestParam int age) {

        log.info("username={},age={}",username , age);

        return "html-form";
    }


    // html/form형식을 통한 전달
    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String modelAttributeV1(@ModelAttribute UserData userData) {
        log.info("username={},age={}",userData.getUsername(),userData.getAge());

        return "ok";
    }



    @ResponseBody
    @PostMapping("/request-body-json-v0")
    public String requestBodyJsonV3(@RequestBody UserData userData) throws IOException {  // http 메세지 컨버터가 원하는 문자나 객체로 변환해준다.

        log.info("username={},age={}",userData.getUsername(),userData.getAge());

        return "ok";

    }

    @ResponseBody // 응답에도 적용된다.
    @PostMapping("/request-body-json-v1")
    public UserData requestBodyJsonV5(@RequestBody UserData userData) throws IOException {

        log.info("username={},age={}",userData.getUsername(),userData.getAge());

        return userData;

    }


    @Data
    static class UserData{
        private String username;
        private int age;

    }


}