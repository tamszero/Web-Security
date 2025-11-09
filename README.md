# 취약한 댓글 서비스 - XSS, SQL Injection 실습용

### 현재 SQL부분은 수정중이라 브랜치만 올리고 메인에는 머지하지 않은 상태입니다


## 프로젝트 설명
간단한 댓글 서비스를 통해 Stored XSS, Reflected XSS 취약점을 재현한 웹 사이트 


<img width="939" height="679" alt="main" src="https://github.com/user-attachments/assets/db34caff-b7b9-4c65-a669-7895f815bdbc" />


## 목적
- XSS 취약점을 이해하고 재현
- 안전한 출력,인코딩 기법과 패치 등을 통해 보완

## 요구환경
- Java 17
- Spring Boot
- Gradle - Groovy
- 기본 포트: 'http://localhost:8080 '


## <Stored XSS 실습 1>
- 댓글 내용 입력 칸에 스크립트 공격문 삽입

<img width="532" height="316" alt="폼에 스크립트 입력" src="https://github.com/user-attachments/assets/3cdce031-7b06-4d69-84f3-94c68e8d6179" />


- alert문 실행 성공

<img width="492" height="188" alt="StoredXss" src="https://github.com/user-attachments/assets/81328e13-a17d-4c45-be3e-98fce9d3d17d" />


- DB확인한 모습
<img width="410" height="171" alt="h2디비확인" src="https://github.com/user-attachments/assets/f44eb363-6691-4b16-b267-6c215087f66e" />


- DB에 들어와 다른 사용자에게도 영향을 미치기 때문에 페이지를 새로고침하는등의 렌더링 과정을 할 때마다  스크립트가 다시 실행된다.

## <Stored XSS 실습 2>

- 닉네임에 스크립트 문 삽입

<img width="520" height="384" alt="nickname" src="https://github.com/user-attachments/assets/913ecb74-2659-4892-8d95-6ab6dd39fc87" />


- 마지막 닉네임을 직접 눌러보면 스크립트 실행 성공
<img width="470" height="175" alt="nickXSS!" src="https://github.com/user-attachments/assets/b07a830b-edb3-4f88-9693-083694933d23" />


## <Reflected XSS 실습>
- URL에 search 파라미터를 통해 직접 스크립트 삽입
<img width="616" height="42" alt="url삽입" src="https://github.com/user-attachments/assets/990d40c2-e4e7-42d8-9198-7b97253f7f6a" />


- alert문 실행 성공
<img width="942" height="260" alt="reflectedXSS" src="https://github.com/user-attachments/assets/4a696e4d-850c-4338-89a9-6519c38fe7c0" />


- Reflected 이기 때문에 DB에 저장되지는 않는 모습

<img width="482" height="117" alt="ref" src="https://github.com/user-attachments/assets/9a5b0cdb-4aa1-4e0a-ae88-9aa94b25eb6d" />

