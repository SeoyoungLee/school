SELECT * FROM TEST;
CREATE TABLE Member(
	id VARCHAR2(30) PRIMARY KEY,
	name VARCHAR2(20) NOT NULL,
	password VARCHAR2(30) NOT NULL,
	addr VARCHAR2(100),
	birth NUMBER
);
INSERT INTO Member(id, name, password, addr, birth)
VALUES('hong', '홍길동', '1', '서울', 920916);
INSERT INTO Member(id, name, password, addr, birth)
VALUES('kim', '김유신', '1', '경기', 900125);
INSERT INTO Member(id, name, password, addr, birth)
VALUES('lee', '이서영', '1', '인천', 890512);
INSERT INTO Member(id, name, password, addr, birth)
VALUES('han', '한석봉', '1', '강원', 720303);
INSERT INTO Member(id, name, password, addr, birth)
VALUES('song', '송아지', '1', '부산', 850426);
INSERT INTO Member
VALUES('kang', '강은지', '1', '대전', 690911);

SELECT * FROM Member;
SELECT * FROM Member
WHERE id = 'kim';




