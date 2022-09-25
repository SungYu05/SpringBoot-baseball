# MyBatis DB연결 세팅

### 설정방법
- MyBatisConfig 파일 필요
- resources/mapper/*.xml 파일 필요

### 의존성
- Spring Boot DevTools
- Lombok
- Validation
- MyBatis Framwork
- MariaDB Driver
- Spring Web
- Jstl
- Tomcat-embed-jasper

### 주말에 변경할 목록
- DB에 포지션, 퇴출사유 테이블 따로 만들기
- Controller 구현해서 view  뿌리기
- DTO 제대로 정리해서 올리기

### RestController를 이용한 결과값
![image](https://user-images.githubusercontent.com/108706329/191903098-382ad56b-165e-4a9e-8af0-e398dcdd5a1e.png)
![image](https://user-images.githubusercontent.com/108706329/191903496-f0cb8b69-d2c1-4304-81e0-598651d623d1.png)

- 주말에 Controller 만들기

### MariaDB 사용자 생성 및 권한 주기
```sql
CREATE USER 'bsa'@'%' IDENTIFIED BY 'bsa1234';
CREATE DATABASE baseballdb;
GRANT ALL PRIVILEGES ON baseballdb.* TO 'bsa'@'%';
```

### 테이블 생성
```sql
USE baseballdb;

DROP TABLE team;
create table team(
    id int primary KEY auto_increment,
    teamName VARCHAR(20) UNIQUE,
    stadiumId INT,
    createdAt TIMESTAMP
);

DROP TABLE stadium;
create table stadium(
    id int primary KEY auto_increment,
    stadiumName VARCHAR(20),
    createdAt TIMESTAMP
);

DROP TABLE player;
create table player(
    id int primary KEY auto_increment,
    playerName VARCHAR(20),
    teamId INT,
    positionId INT,
    createdAt TIMESTAMP
);

DROP table expulsion;
create table expulsion(
    id int primary KEY auto_increment,
    playerId int,
    teamId INT,
    positionId INT,
    reasonId INT,
    createdAt TIMESTAMP
);

DROP table positions;
create table positions(
    id int primary KEY auto_increment,
    positions VARCHAR(20)
);

DROP table reason;
create table reason(
    id int primary KEY auto_increment,
    reasons VARCHAR(20)
);

SELECT * FROM team;
SELECT * FROM stadium;
SELECT * FROM player;
SELECT * FROM expulsion;
SELECT * FROM positions;
SELECT * FROM reason;
COMMIT;
```

### 더미데이터 추가
```sql
insert into stadium(stadiumName, createdAt) VALUES('광주 기아 챔피언스 필드', NOW());
insert into stadium(stadiumName, createdAt) VALUES('사직 야구장', NOW());
insert into stadium(stadiumName, createdAt) VALUES('잠실 야구장', NOW());

insert into team(teamName, stadiumId, createdAt) values('기아타이거즈', 1, NOW());
insert into team(teamName, stadiumId, createdAt) values('롯데자이언츠', 2, NOW());
insert into team(teamName, stadiumId, createdAt) values('엘지트윈스', 3, NOW());

insert into positions(positions) VALUES('타자');
insert into positions(positions) VALUES('투수');
insert into positions(positions) VALUES('외야수');
insert into positions(positions) VALUES('내야수');

insert into reason(reasons) values('자진사퇴');
insert into reason(reasons) values('성적부진');
insert into reason(reasons) values('논란');

insert into player(playerName, teamId, positionId, createdAt) VALUES('김진욱', 2, 2, NOW());
insert into player(playerName, teamId, positionId, createdAt) VALUES('안치홍', 2, 4, NOW());
insert into player(playerName, teamId, positionId, createdAt) VALUES('전준우', 2, 3, NOW());
insert into player(playerName, teamId, positionId, createdAt) VALUES('임창용', 1, 3, NOW());

insert into expulsion(playerId, teamId, positionId, reasonId, createdAt) VALUES(4, 1, 2, 3, NOW());
```

### 상세보기 쿼리
```sql
SELECT stadiumName, createdAt
FROM stadium;

SELECT s.stadiumName, t.teamName, t.createdAt
FROM team t 
LEFT OUTER JOIN stadium s
ON t.stadiumId = s.id;

SELECT t.teamName, po.positions, p.playerName, p.createdAt
FROM player p
LEFT OUTER JOIN team t ON p.teamId = t.id
LEFT OUTER JOIN positions po ON p.positionId = po.id;

SELECT t.teamName, po.positions, p.playerName, r.reasons, e.createdAt
FROM expulsion e
LEFT OUTER JOIN player p ON p.id = e.playerId
LEFT OUTER JOIN team t ON p.teamId = t.id
LEFT OUTER JOIN reason r ON r.id = e.reasonId
LEFT OUTER JOIN positions po ON po.id = e.positionId;
```