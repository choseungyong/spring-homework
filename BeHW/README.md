# 🛒 상품 관리 API

Spring Boot 기반으로 상품 정보를 조회, 추가, 수정, 삭제할 수 있는 간단한 HTTP API입니다.  
메모리 기반 저장소를 사용하며, JSON 형식으로 요청/응답이 이루어집니다.

---

## ✅ 사용 기술

- Java 21
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- H2 Database (in-memory)
- Lombok
- JUnit

---

## ✅ 기능 목록

- [ ] 상품 전체 조회 API (`GET /api/products`)
- [ ] 상품 단건 조회 API (`GET /api/products/{id}`)
- [ ] 상품 등록 API (`POST /api/products`)
- [ ] 상품 수정 API (`PUT /api/products/{id}`)
- [ ] 상품 삭제 API (`DELETE /api/products/{id}`)
- [ ] 단위 테스트 작성
- [ ] E2E 테스트 작성


### 회원 기능
- [ ] 회원 가입 API (/api/members/register)
    - 이메일, 비밀번호로 회원 가입
    - 가입 시 JWT 토큰 발급
- [ ] 로그인 API (/api/members/login)
    - 이메일, 비밀번호로 로그인
    - 로그인 성공 시 JWT 토큰 발급
- [ ] JWT 토큰 생성 기능
    - jjwt 라이브러리 사용
    - 시크릿 키는 외부 파일로 관리

### 인증 처리
- [ ] Authorization 헤더로 JWT 인증
- [ ] 401: 토큰 없음 또는 무효
- [ ] 403: 잘못된 이메일/비밀번호 조합

### (선택) 관리자 화면
- [ ] 회원 목록 조회/수정/삭제 기능
---

## ✅ 도메인 설계

```java
Product {
  Long id;
  String name;
  int price;
  String imageUrl;
}
