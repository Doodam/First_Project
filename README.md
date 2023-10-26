<div align="center">
<img src=https://github.com/Doodam/First_Project/assets/121950964/a4afc830-5e47-44ee-8715-bf76dbd19ed8/>
<h2>[2023] 학생 관리 프로그램 👩‍💻</h2>
개인프로젝트로, 현재 다니고 있는 학원을 모티브로 했으며 학생들의 개인정보와 시험점수를 관리해주는 프로그램입니다.
MVC 패턴 및 데이터베이스에서 자주 사용되는 CRUD 데이터 처리 기능을 사용했습니다.
</div>

<br>

## 목차
  - [개요](#개요) 
  - [프로그램 설명](#프로그램-설명)

<br>

## 개요
- 프로젝트 이름 : ITWILL 학생관리프로그램
- 프로젝트 지속기간 : 2023.04.17 - 2023.04.24
- 개발 엔진 및 언어, DB : Eclipse & JAVA & Oracle

<br>

## 프로그램 설명
### 로그인
|<img src=https://github.com/Doodam/First_Project/assets/121950964/d78f17b2-69ee-4dbd-bf11-45be47e9f661>|<img src=https://github.com/Doodam/First_Project/assets/121950964/18f1a494-dbd0-4dee-a86d-1f7753f5d452>|<img src=https://github.com/Doodam/First_Project/assets/121950964/c3f14e91-ccce-4c3d-b120-1663f17964fd>
|:---:|:---:|:---:|
|시작 화면|로그인 실패|로그인 성공|

- 처음 시작 화면으로 로그인 방식은 간단하게 만들었습니다. <br>
- 로그인 실패 시, 모달 창이 띄워지며 로그인 불가. <br>
- 로그인 성공 시, 모달 창이 띄워지며 홈으로 창 전환. <br>

<br>

### 홈 화면
<img src=https://github.com/Doodam/First_Project/assets/121950964/4f325335-b34f-4add-a301-e15b1bbbd8ff width="400" height="350"/> <br>
- 홈페이지 홈 화면입니다.

<br>

### 학생 등록
|<img src=https://github.com/Doodam/First_Project/assets/121950964/9369b98e-5c4a-4fef-bafc-d2e3fff1147b>|<img src=https://github.com/Doodam/First_Project/assets/121950964/d227dd54-c69d-4679-8e15-ab990e310eda>|<img src=https://github.com/Doodam/First_Project/assets/121950964/3c75bff7-f2a1-4472-b054-1792d2dd5a05>|<img src=https://github.com/Doodam/First_Project/assets/121950964/c2ab2472-ba6e-462e-9efd-e133c0b36d3b>
|:---:|:---:|:---:|:---:|
|학생 등록|자동 나이 계산|등록|홈 화면|

|<img src=https://github.com/Doodam/First_Project/assets/121950964/3d3e0b5d-f9ef-4289-ba74-4bb94867228c/>|
|:---:|
|학생 정보 DB|
- 학생등록 버튼 클릭 시, 새로운 모달 창이 띄워지며 학생 정보를 입력할 수 있습니다.  
- 생년월일 작성 시, YYYY-MM-DD 형식으로 적어야 하며 알림 창이 띄워집니다. 또한 형식에 맞게 작성하면 자동으로 나이가 계산 됩니다.  
- 등록 버튼을 클릭 하면 DB에 저장이 되고 홈으로 이동합니다.  
- 홈 화면에 등록된 학생 정보가 바로 확인 가능합니다.



<br>

### 상세보기
<img src=https://github.com/Doodam/First_Project/assets/121950964/0d533a7a-4fda-4e07-ba7e-4df50cfcd6d7 width="400" height="350"/> <br>
- 학생 정보를 보고 싶을 때 상세보기 버튼 클릭 시, 확인 가능합니다.

<br>

### 수정하기
|<img src=https://github.com/Doodam/First_Project/assets/121950964/b3f52976-bc21-4b61-9db1-f20744eea2b9>|<img src=https://github.com/Doodam/First_Project/assets/121950964/4113fc57-8c8d-4513-8eb3-e3252714cf2d>|<img src=https://github.com/Doodam/First_Project/assets/121950964/064c1fd3-914f-429f-92f6-4692d6dd417b>|<img src=https://github.com/Doodam/First_Project/assets/121950964/b8205049-9dd2-44d5-a064-1c663b0daac0>|
|:---:|:---:|:---:|:---:|
|수정하기 화면|수정하기|홈 화면|상세보기|

- 학생 정보를 수정하고 싶으면 수정하기 버튼 클릭 시, 화면으로 이동합니다.  
- 정보를 수정하고 수정하기 버튼을 클릭하면 수정이 완료됩니다.  
- 홈 화면에 수정된 학생 정보가 띄워집니다.  
- 수정된 학생 정보를 상세 확인 가능합니다.

<br>

### 성적 등록
|<img src=https://github.com/Doodam/First_Project/assets/121950964/da43d748-2326-455b-83d9-20c08573224c>|<img src=https://github.com/Doodam/First_Project/assets/121950964/f1e80967-3e45-4280-8353-a91d490bd6fd>|<img src=https://github.com/Doodam/First_Project/assets/121950964/ea28b0b8-9830-47fc-bb89-b0b47cfd357c>|
|:---:|:---:|:---:|
|성적 기록 화면|성적 등록 1|성적 등록 2|

|<img src=https://github.com/Doodam/First_Project/assets/121950964/401e9db0-8e5c-47d2-95b0-97046f025cee>|<img src=https://user-images.githubusercontent.com/121950964/267244639-aca520bd-57cf-4d73-9ac7-65ccd9508286.png>|
|:---:|:---:|
|삭제|삭제 완료|

|<img src=https://github.com/Doodam/First_Project/assets/121950964/14878a33-cc6a-4ee2-b94b-10823d04f4ea/>|
|:---:|
|성적 정보 DB|

- 수정하기 버튼을 클릭 시, 성적 등록도 함께 할 수 있습니다.
- 학생의 성적을 작성 시, 과목을 선택 후 점수를 입력합니다.
- 결과 버튼을 클릭 시, 입력된 과목들의 평균을 자동으로 계산해줍니다.
- 삭제할 학생을 클릭 후, 삭제 버튼을 클릭 하면 등록된 성적을 삭제 할 수 있습니다.  

<br>

### 검색
|<img src=https://github.com/Doodam/First_Project/assets/121950964/614e8160-787d-4801-9e20-aaed6173d540>|<img src=https://github.com/Doodam/First_Project/assets/121950964/21667778-7824-4f41-bac0-85cc731ba186>|
|:---:|:---:|
|검색 1|검색 2|

- 검색 창으로 학생을 찾을 수 있습니다.

<br>

### 삭제
<img src=https://github.com/Doodam/First_Project/assets/121950964/e25a1a70-1df1-4056-a495-6ad70dfd9df2 width="400" height="350"/> <br>
- 홈 화면에서도 학생을 삭제할 수 있습니다.

<br>

### 로그아웃
<img src=https://github.com/Doodam/First_Project/assets/121950964/90944256-68cc-4f99-a1bc-89f6352e51e0 width="400" height="350"/> <br>
- 로그아웃 클릭 시, 로그아웃이 되며 로그인 화면으로 이동합니다.

<br>

<img src=https://github.com/Doodam/First_Project/assets/121950964/f8e6ed75-3885-4ee4-863a-525bcb3c2764 width="500" height="350"/> 

