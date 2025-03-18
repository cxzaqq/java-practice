package com.ohgiraffers.restapi.section01.response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* 설명. @RestController 어노테이션을 통해 Controller의 모든 핸들러 메소드에 @ResponseBody를 적용한 효과 */
/* 설명. 더 이상 view resolver가 처리하지 않는다. (어떤 반환값이든 반환됨) */
@RestController
@RequestMapping("/response")
public class ResponseRestController {

    @GetMapping("/hello")
    public String helloWord() {
        return "Hello world";
    }

    @GetMapping("/random")
    public int getRandomNumber() {
        return (int)(Math.random() * 10) + 1;
    }

    @GetMapping("/message")
    public Message getMessage() {
        return new Message(200, "이것은 메시지.");
    }

    @GetMapping("/test")
    public List<Map<String, Object>> getTest() {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("test1", new Message(200, "성공1"));
        map.put("test2", new Message(200, "성공2"));
        map.put("nextPageLink", "http://localhost:8080/hello");
        list.add(map);

        return list;
    }

    @GetMapping("/map")
    public Map<Integer, String> getMapping() {
        List<Message> messageList = new ArrayList<>();
        messageList.add(new Message(200, "성응. 성공 응답이라는 뜻"));
        messageList.add(new Message(400, "페이지를 찾을 수 없습니다."));
        messageList.add(new Message(500, "개발자의 잘못"));

        /* 설명. List -> Map으로 바꿔 JSON Object 형태로 응답하기 위한 stream 적용 */
        return messageList.stream()
                .collect(Collectors.toMap(Message::getHttpStatusCode, Message::getMessage));
    }

    /* 설명. 이미지 응답하기 */
    /* 설명. produces는 response header에 Content-Type으로 MIME 타입을 설정하는 것이다. */
    @GetMapping(value="/image", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getImage() throws IOException {
        Path path = Paths.get("D:\\SWCamp\\uploadFiles\\img\\single\\wow.PNG");
        return Files.readAllBytes(path);
    }

}
