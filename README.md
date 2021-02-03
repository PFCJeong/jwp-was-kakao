# 웹 애플리케이션 서버
## 진행 방법
* 웹 애플리케이션 서버 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


## 기능 요구사항
* 헤더 읽고 파싱
* 파싱된 리퀘스트를 컨트롤러에 뿌려줌
* 받아서 처리하는 컨트롤러

## todo
* [x] HttpRequest 구현
    * [x] RequestMethod 구현 
    * [x] HttpRequestHeader 구현 
    * [x] HttpRequestHeaders 구현
    * [x] HttpRequestParser 구현
  
* [x] Controller 구현
    * [x] Controllers 구현
    * [x] DispatchInfo 구현
    * [x] TemplateController 구현
    * [x] UserController 구현