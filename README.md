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

### 해야 할 목록
- 모든 테이블 delete 만들기
- player 구현
- expulsion 구현

### 지금까지 만든 결과값
![image](https://user-images.githubusercontent.com/114338362/192148823-f30ec241-ff04-437c-9a8d-f93883c7608f.png)
![image](https://user-images.githubusercontent.com/114338362/192148845-927f0579-0c45-4dda-8c53-e54dc93fb211.png)
![image](https://user-images.githubusercontent.com/114338362/192148869-7a909d87-8518-4f49-bacd-21feba1538a0.png)
![image](https://user-images.githubusercontent.com/114338362/192148886-097f4ac0-143e-4099-89e1-4ce8da58319e.png)

### MariaDB 사용자 생성 및 권한 주기
```sql
CREATE USER 'bsa'@'%' IDENTIFIED BY 'bsa1234';
CREATE DATABASE baseballdb;
GRANbaseballdbT AbaseballdbLL PRIVILEGES ON baseballdb.* TO 'bsa'@'%';
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
    positions VARCHAR(20),
    createdAt TIMESTAMP
);

DROP table expulsion;
create table expulsion(
    id int primary KEY AUTO_INCREMENT,
    reason VARCHAR(20),
    playerId INT,
    createdAt TIMESTAMP
);

SELECT * FROM team;
SELECT * FROM stadium;
SELECT * FROM player;
SELECT * FROM expulsion;
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

insert into player(playerName, teamId, positions , createdAt) VALUES('김진욱', 2, '투수', NOW());
insert into player(playerName, teamId, positions , createdAt) VALUES('안치홍', 2, '내야수', NOW());
insert into player(playerName, teamId, positions , createdAt) VALUES('전준우', 2, '외야수', NOW());
insert into player(playerName, teamId, positions , createdAt) VALUES('임창용', 1, '투수', NOW());

insert into expulsion(reason , playerId , createdAt) VALUES('논란',4 , NOW());

SELECT * FROM team;
SELECT * FROM stadium;
SELECT * FROM player;
SELECT * FROM expulsion;
COMMIT;
```

### 상세보기 쿼리
```sql
SELECT ROW_NUMBER() over(ORDER BY id) AS numbers, id, stadiumName, createdAt
FROM stadium;

SELECT ROW_NUMBER() over(ORDER BY id) AS numbers, t.id, s.stadiumName, t.teamName, t.createdAt
FROM team t
LEFT OUTER JOIN stadium s
ON t.stadiumId = s.id;

SELECT ROW_NUMBER() over(ORDER BY id) AS numbers, t.id,
t.teamName, p.playerName, p.positions, p.createdAt
FROM player p
LEFT
OUTER JOIN team t 
ON p.teamId = t.id;
```