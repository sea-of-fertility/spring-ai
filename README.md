# 프로젝트 소개
이 프로젝트는 [Chat Client API를 공부한 프로젝트 입니다.](https://docs.spring.io/spring-ai/reference/api/chatclient.html) 그 중 [Ollma Chat](https://docs.spring.io/spring-ai/reference/api/chat/ollama-chat.html)의 간단한 부분만 구현했습니다.

[spring-AI-reference](https://docs.spring.io/spring-ai/reference/index.html)
자세한 내용은 위 링크를 참조해 주세요.

# Spring AI의 목적 
spring ai의 목적은 불필요와 복잡성을 없애고, 인공지능과 응용프로그램의 통합을 쉽게 하는 것을 목표로 합니다.

spring AI의 구현에 대해 자세히 알고 싶은 경우 [AI의 개념](https://docs.spring.io/spring-ai/reference/concepts.html)을 읽어보세요.


# 프로젝트 시작

## yml 설정
우선 yml을 파일을 설정합니다. 사용하는 chat model api는 ollama이고 url과 사용하는 모델과 temperature을 입력합니다.
temperature이 높으면 모델이 더 창의적으로 대답할 수 있습니다.


~~~ yaml
spring:
  ai:
    ollama:
      base-url: http://localhost:11434
      chat:
        options:
          model: mistral
          temperature: 0.7
~~~


## Sample Controller
간단한 [ChatController](src/main/java/com/example/springai/controller/ChatController.java)을 작성한다.

+ question 결과
~~~
POST http://localhost:8080/question

HTTP/1.1 200 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Tue, 09 Jul 2024 07:00:25 GMT

{
  "answer": " Hello! How can I help you today? If you have any questions or topics you'd like me to write about, feel free to ask. I'm here to help answer any inquiries you may have. Let me know if there is something specific you need assistance with. Have a great day! 😊"
}
Response file saved.
> 2024-07-09T160025.200.json

Response code: 200; Time: 2567ms (2 s 567 ms); Content length: 272 bytes (272 B)
~~~

+ generation 결과 
~~~

GET http://localhost:8080/ai/generate

HTTP/1.1 200 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Tue, 09 Jul 2024 07:01:14 GMT

{
  "generation": " Why don't scientists trust atoms?\n\nBecause they make up everything!"
}
Response file saved.
> 2024-07-09T160114.200.json

Response code: 200; Time: 977ms (977 ms); Content length: 87 bytes (87 B)
~~~