# 운동 루틴 관리 서비스 BodyBuddy

<br>

## 프로젝트 소개

- BodyBuddy는 내 루틴을 등록하고 이를 공유할 수 있습니다.
- 내 루틴을 등록하면 자동으로 루틴 게시판에 업로드되는데 루틴 게시판에서 다른 유저들의 루틴을 찜하거나 내 루틴에 추가할 수 있습니다.
- 다른 유저의 게시글에 댓글을 작성할 수 있습니다.

<br>

## 팀원 구성

<div align="center">

|                                                         **민예림**                                                          |                                                        **김재현**                                                        |
| :-------------------------------------------------------------------------------------------------------------------------: | :----------------------------------------------------------------------------------------------------------------------: |
| [<img src="https://avatars.githubusercontent.com/yelim99" height=150 width=150> <br/> @yelim99](https://github.com/yelim99) | [<img src="https://avatars.githubusercontent.com/KimJ4ehyun" height=150 width=150> <br/> @KimJ4ehyun](https://github.com/KimJ4ehyun) |
</div>

<br>

## 1. 개발 환경

- Front : Vue.js, HTML, CSS, JavaScript
- Back-end : Spring Boot, Java
- DBMS : MySQL
- 버전 및 이슈관리 : Github
- 협업 툴 : Github, Notion, Discord
- 디자인 : Figma, BootStrap
<br>

## 2. 채택한 개발 기술과 브랜치 전략

### Vue.js

- 컴포넌트 기반 아키텍처인 Vue.js를 사용하여 코드의 재사용성과 유지보수 용이성을 고려
- Single File Component를 통해서 코드 가독성을 높였고, 스코프 스타일을 사용하여 css를 컴포넌트 별로 구분
- Vue Router를 이용하여 동적 라우트 매칭, Navigation Guard를 이용하여 사용자 인증 및 권한 검사
    
### Spring Boot, Java

- Spring Boot를 사용하여 RESTful한 웹 서비스를 개발
- Swagger를 이용한 테스트 용이성
- MyBatis와의 원활한 통합

### 브랜치 전략

- master 브랜치와 개별 브랜치로 나누어서 개발
- 개별 브랜치에서 개발한 후 master 브랜치에 merge
- 충돌 가능성이 있는 파일을 수정할 때는 주석으로 수정한 부분 처음과 끝 명시
- Commit Message 규칙을 통해서 무엇을 했는지 명시

<br>

## 3. 역할 분담

### 🍊민예림

- **Front**
    - 메인 페이지
    - 루틴 게시판 페이지
    - 찜 목록 페이지
    - 마이페이지
    - 내 루틴 관리 페이지
    - 시간표 만들기
    - Header, Footer bar
    - 로고, 각종 이미지
    - carousel
    - 루틴 상세보기
    - 루틴 -> 운동 상세보기 모달
    - 찜
    - 내 루틴에 추가
- **Back**
    - 시간표 만들기
    - 루틴 상세보기
    - 루틴 -> 운동 상세보기 모달
    - 찜
    - 내 루틴에 추가
- **그 외**
    - figma 작성
    - 더미데이터 작성
    - 기능 명세서, API 명세서 작성

<br>
    
### 🐝김재현

- **Front**
    - 회원가입, 회원 정보 수정 페이지
    - 로그인 페이지
    - 루틴 등록, 수정 페이지
    - 페이징
    - 회원가입, 회원 정보 수정
    - ID, 닉네임 중복 확인
    - 로그인, 로그아웃
    - 리뷰 목록 보기, 등록, 수정, 삭제
    - 루틴 등록, 수정, 삭제
    - alert창
    - 로그인 인터셉터
    - 운동 라이브러리
- **Back**
    - 회원가입, 회원 정보 수정
    - ID, 닉네임 중복 확인
    - 로그인, 로그아웃
    - 리뷰 목록 보기, 등록, 수정, 삭제
    - 루틴 등록, 수정, 삭제
    - 로그인 인터셉터
- **그 외**
    - ERD, Schema 작성
    - 더미 데이터 작성
    - 기능 명세서, API 명세서 작성
<br>


## 4. 개발 기간 및 작업 관리

### 개발 기간

- 전체 개발 기간 : 2024-04-24 ~ 2024-05-22
- 아이디어 회의 및 요구사항 분석 : 2024-04-24 ~ 2024-04-30
- DataBase 설계 : 2024-04-28 ~ 2024-04-30
- Figma 설계 : 2024-04-30 ~ 2024-05-06
- API 설계 : 2024-05-06 ~ 2024-05-09
- Back 구현 : 2024-05-09 ~ 2024-05-12
- Front 구현 : 2024-05-11 ~ 2024-05-22
- 테스트 : 2024-05-22 ~ 2024-05-22

<br>

### 작업 관리

- 오전 9시에 Daily Scrum 진행, 작업 상황 브리핑 및 코드 리뷰 후 PR
- 오후 6시에 Daily Wrap Up 진행, 어떤 작업을 했고, 다음에 뭘 해야되는지 확인

<br>

## 5. 프로젝트 구조

```
📂 BodyBuddy
ㄴ 📂 Back
   ㄴ 📂 BodyBuddyProject
      ㄴ 📂 .mvn
      ㄴ 📂 .settings
      ㄴ 📂 bin
      ㄴ 📂 src
         ㄴ 📂 main
            ㄴ 📂 java
               ㄴ 📂 com.boddybuddy.fit
                  ㄴ 📂 config
                     ㄴ 📄 DBConfig.java
                     ㄴ 📄 SwaggerConfig.java
                     ㄴ 📄 WebConfig.java
                  ㄴ 📂 controller
                     ㄴ 📄 MyPageController.java
                     ㄴ 📄 RBoardController.java
                     ㄴ 📄 ReviewController.java
                     ㄴ 📄 UserController.java
                     ㄴ 📄 WishController.java
                  ㄴ 📂 interceptor
                     ㄴ 📄 LoginInterceptor.java
                  ㄴ 📂 model
                     ㄴ 📂 dao
                        ㄴ 📄 MyPageDao.java
                        ㄴ 📄 ReviewDao.java
                        ㄴ 📄 RoutineDao.java
                        ㄴ 📄 UserDao.java
                        ㄴ 📄 WishDao.java
                     ㄴ 📂 dto
                        ㄴ 📄 Exercise.java
                        ㄴ 📄 Review.java
                        ㄴ 📄 Routine.java
                        ㄴ 📄 User.java
                        ㄴ 📄 Wish.java
                     ㄴ 📂 service
                        ㄴ 📄 MyPageService.java
                        ㄴ 📄 MyPageServiceImpl.java
                        ㄴ 📄 ReviewService.java
                        ㄴ 📄 ReviewServiceImpl.java
                        ㄴ 📄 RoutineService.java
                        ㄴ 📄 RoutineServiceImpl.java
                        ㄴ 📄 UserService.java
                        ㄴ 📄 UserServiceImpl.java
                        ㄴ 📄 WishService.java
                        ㄴ 📄 WishServiceImpl.java
                  ㄴ 📄 BodyBuddyProjectApplication.java
            ㄴ 📂 resources
               ㄴ 📂 mappers
                  ㄴ 📄 myPageMapper.xml
                  ㄴ 📄 reviewMapper.xml
                  ㄴ 📄 routineMapper.xml
                  ㄴ 📄 userMapper.xml
                  ㄴ 📄 wishMapper.xml
               ㄴ 📄 application.properties
               ㄴ 📄 boddybuddy.sql
               ㄴ 📄 dummy.sql
      ㄴ 📂 target
      ㄴ 📄 .classpath
      ㄴ 📄 .factorypath
      ㄴ 📄 .gitignore
      ㄴ 📄 .project
      ㄴ 📄 mvnw
      ㄴ 📄 mvnw.cmd
      ㄴ 📄 pom.xml
ㄴ 📂 Front
   ㄴ 📂 BodyBuddy
      ㄴ 📂 .vscode
      ㄴ 📂 node_modules
      ㄴ 📂 public
      ㄴ 📂 src 
         ㄴ 📂 assets
            ㄴ 📂 img
            ㄴ 📄 style.css
         ㄴ 📂 components
            ㄴ 📂 common
               ㄴ 📄 TheFooter.vue
               ㄴ 📄 TheHeader.vue
            ㄴ 📂 icons
            ㄴ 📂 main
               ㄴ 📄 carouselItem.vue
            ㄴ 📂 myPage
               ㄴ 📄 LikeList.vue
               ㄴ 📄 MyRoutine.vue
               ㄴ 📄 MyRoutineDetail.vue
               ㄴ 📄 MyRoutineRegist.vue
               ㄴ 📄 MyRoutineRegistDetail.vue
               ㄴ 📄 MyRoutineUpdate.vue
               ㄴ 📄 UserInfoEdit.vue
            ㄴ 📂 popup
               ㄴ 📄 PopupUserId.vue
               ㄴ 📄 PopupNickname.vue
            ㄴ 📂 review
               ㄴ 📄 reviewList.vue
               ㄴ 📄 reviewDetail.vue
            ㄴ 📂 routineBoard
               ㄴ 📄 addModal.vue
               ㄴ 📄 BoardDetail.vue
               ㄴ 📄 BoardList.vue
               ㄴ 📄 BoardListOne.vue
               ㄴ 📄 Modal.vue
               ㄴ 📄 TimeTable.vue
         ㄴ 📂 data
            ㄴ 📄 allExercises.js
            ㄴ 📄 exercises.js
         ㄴ 📂 router
            ㄴ 📄 index.js
         ㄴ 📂 stores
            ㄴ 📄 board.js
            ㄴ 📄 myPage.js
            ㄴ 📄 review.js
            ㄴ 📄 user.js
            ㄴ 📄 wish.js
         ㄴ 📂 views
            ㄴ 📄 HomeView.vue
            ㄴ 📄 JoinView.vue
            ㄴ 📄 LibraryView.vue
            ㄴ 📄 LoginView.vue
            ㄴ 📄 MyPageView.vue
            ㄴ 📄 RoutineBoardView.vue
         ㄴ 📄 App.vue
         ㄴ 📄 main.js
      ㄴ 📄 index.html
      ㄴ 📄 .gitignore
      ㄴ 📄 jsconfig.json
      ㄴ 📄 package.json
      ㄴ 📄 package-lock.json
      ㄴ 📄 README.md
      ㄴ 📄 vite.config.js
ㄴ 📂 Scrum
ㄴ 📄 .gitignore
ㄴ 📄 README.md    
    
```

<br>

## 6. ERD

![ERD](./assets/erd.png)



## 7. 페이지별 기능

### [홈]
  - 로그인이 되어 있지 않은 경우 : 로그인, 회원가입 문구
  - 로그인이 되어 있는 경우 : nickname 님, 로그아웃 문구

| 초기화면 |
|----------|
|![home](./assets/home.gif)|

<br>

### [회원가입]
- 모든 항목에 대해서 입력창에서 바로 유효성 검사가 진행되고 통과하지 못한 경우 각 경고 문구가 입력창 하단에 표시, 통과한 경우에는 초록색 문구로 표시
- 중복 확인을 누르면 ID 또는 Nickname에 대한 유효성 검사 및 중복 확인을 실행, 중복이 아닌 ID 또는 Nickname인 경우에 사용하기 버튼이 생성되고 해당 버튼을 누를 시에 해당 란에 사용한다고 한 ID 또는 Nickname이 그대로 들어감
- 모든 유효성 검사 통과 시에 가입하기 버튼이 활성화
- 가입하기 버튼을 누르면 회원 가입 alert창 생성

| 회원가입 |
|----------|
|![join](./assets/join.gif)|

<br>

### [로그인]
- ID 또는 Password가 일치하지 않을 시에 경고 문구 생성
- 일치할 시에 홈화면으로 이동

| 로그인 |
|----------|
|![login](./assets/login.gif)|

<br>

### [로그아웃]
- 우상단의 로그아웃 버튼을 누르면 홈화면으로 이동
- pinia와 Front, Back session에 저장되어있는 유저 정보를 삭제

| 로그아웃 |
|----------|
|![logout](./assets/logout.gif)|

<br>

### [루틴 게시판]
- 유저가 작성한 루틴들을 시간표 형태로 최신순으로 게시
- 해당 루틴을 누르면 루틴 상세 페이지로 이동
- 해당 운동을 누르면 모달로 운동의 상세 정보를 표시
- 하트 버튼을 통한 찜하기 기능 구현
- 찜한 루틴은 찜 목록에서 확인 가능
- 페이징을 통한 페이지 이동

| 루틴 게시판 |
|----------|
|![routineBoard](./assets/routineBoard.gif)|

<br>

### [루틴 상세 페이지]
- 해당 운동을 누르면 모달로 운동의 상세 정보를 표시
- 하트 버튼을 통한 찜하기 기능 구현
- 내 루틴에 추가 버튼을 누르면 내 루틴에 추가(제목, 설명 작성 가능)
- 로그인 시에 리뷰 작성 및 내 리뷰에 대한 수정 및 삭제 가능

| 루틴 상세 페이지 |
|----------|
|![routineBoardDetail](./assets/routineBoardDetail.gif)|

<br>

### [운동 라이브러리]
- 운동 목록에서 운동 검색 가능 

| 운동 라이브러리 |
|----------|
|![exerciseLibrary](./assets/exerciseLibrary.gif)|

<br>

### [마이페이지]

<br>

#### 1. 내 루틴 관리
- 내 루틴 목록에 대한 관리
- 루틴에 대한 등록, 수정, 삭제

| 내 루틴 관리 |
|----------|
|![myRoutineManage](./assets/myRoutineManage.gif)|

<br>

#### 1-1. 루틴 등록하기
- 운동 부위를 선택 후 해당 운동을 체크하면 운동에 대한 상세정보 설정 가능(세트 수, 무게, 횟수, 요일, 시간)
- 선택한 운동에 대한 요일과 시간을 모두 선택했을 때 제목과 설명을 입력할 수 있는 창 생성
- 제목과 설명은 생략가능하며 제목은 없을 시에 '제목 없음' 으로 생성

| 루틴 등록하기 |
|----------|
|![myRoutineRegist](./assets/myRoutineRegist.gif)|

<br>

#### 1-2. 루틴 수정하기
- 기존의 내용이 모두 생성된 상태로 시작
- 운동을 선택하고, 옵션들을 골라주면 루틴 수정

| 루틴 수정하기 | |
|----------|----------|
|![myRoutineUpdate](./assets/myRoutineUpdate.gif)|![myRoutineUpdate2](./assets/myRoutineUpdate2.gif)|

<br>

#### 2. 찜 목록
- 찜한 루틴을 확인
- 내 루틴에 추가 가능

| 찜 목록 |
|----------|
|![wishList](./assets/wishList.gif)|

<br>

#### 3. 회원 정보 수정
- 현재 ID는 바꿀 수 없고, 자동으로 ID창에 입력
- 나머지 항목에 대해서는 로그인 창과 동일

| 회원 정보 수정 |
|----------|
|![userInfoEdit](./assets/userInfoEdit.gif)|

<br>

## 8. 프로젝트 후기

### 🍊 민예림

깃헙을 통한 협업에 익숙해지는 것, 서로 감정 상하지 않고 무사히 마무리하는 것이 1차적인 목표였어서 항상 이 부분을 명심하면서 작업했습니다.
각자 페이지를 작업하고 합치는 과정에서 마주친 버그들이 몇 있었는데, 시간에 쫓기느라 해결하기에 급급해서 제대로 트러블슈팅 과정을 기록하지 못한 게 살짝 아쉬운 부분으로 남습니다. 그래도 2022년 한 해 동안 가장 치열하게 살았던 한 달인 것 같습니다. 조원들 모두에게 고생했다고 전하고 싶습니다🧡

<br>

### 🐝 김재현

솔직히 Back말고 Front는 할 줄도 몰랐고 할 자신도 없었는데 생각보다 Vue가 할 만해서 다행이었습니다. 또한 깃헙을 잘 사용하지 못 했었는데 이제는 최소한의 협업을 할 정도는 알게된 거 같아서 다행입니다. 페어가 프로젝트 유경험자라서 많이 물어보고 배우면서 할 수 있어서 좋았습니다. 방학 때 Back 공부 열심히 해서 2학기 때는 백엔드 개발자로서 프로젝트에 참여할 수 있으면 좋겠고, 이번 프로젝트 경험을 통해서 다음에는 더 나은 프로젝트를 할 수 있을 꺼 같은 자신감이 생겼습니다. 

<br>