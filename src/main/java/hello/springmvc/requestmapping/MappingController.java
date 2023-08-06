package hello.springmvc.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MappingController {

    @RequestMapping("/hello-basic")
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mapping-get-v2");
        return "ok";
    }

    /***
     * PathVariable 사용
     * 변수명이 같으면 생략 가능
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable String userId) {
        log.info("mappingPath userId={}", userId);
        return "ok";
    }

    /***
     * PathVariable 다중 사용
     * @param userId
     * @param orderId
     * @return
     */

    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
        log.info("mappingPath userId={} orderId={}", userId, orderId);
        return "ok";
    }

    // mode=debug인 경우에만 접근 가능 (잘 사용하지 않음)
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    // header에 mode = debug 정보가 없으면 접근 불가
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    // json 정보로 요청하지 않으면 접근 불가
    // consumes 서버의 입장에서 소비하는 입장이다.
    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }

    // 클라이언트가 header에 Accept : application/json 형태라면 받아들일 수 없다.
    // 왜냐면 서버는 text/html 형태만 제공하기 때문이다.
    @PostMapping(value = "/mapping-produces", produces = "text/html") // MediaType.TEXT_HTML_VALUE
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }

}
