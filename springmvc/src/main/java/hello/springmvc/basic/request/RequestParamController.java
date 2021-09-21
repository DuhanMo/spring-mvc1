package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username = {}, age = {}", username, age);
        response.getWriter().write("ok");
    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParam2(@RequestParam("username") String memberName,
                                @RequestParam("age") int age) {
        log.info("username = {}, age = {}", memberName, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParam3(@RequestParam String username,
                                @RequestParam int age) {
        log.info("username = {}, age = {}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParam4(String username,
                                int age) {
        log.info("username = {}, age = {}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(@RequestParam(required = true) String username,
                                       @RequestParam(required = false) Integer age) {
        log.info("username = {}, age = {}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default") // defaultValue 설정해줬을 때는 required 설정 필요가 없다.
    public String requestParamDefault(@RequestParam(defaultValue = "guest") String username,
                                      @RequestParam(defaultValue = "-1") int age) {
        log.info("username = {}, age = {}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamDefault(@RequestParam Map<String, Object> paramMap) {
        log.info("username = {}, age = {}, address = {}", paramMap.get("username"), paramMap.get("age"), paramMap.get("address"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-multiMap")
    public String requestParamMultiMap(@RequestParam MultiValueMap<String, Object> paramMap) {
        log.info("username = {}, age = {}, address = {}", paramMap.get("username"), paramMap.get("age"), paramMap.get("address"));
        return "ok";
    }
}