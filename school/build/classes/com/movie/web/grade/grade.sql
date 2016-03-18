--시퀀스 설정
CREATE SEQUENCE hak
start WITH 20160001
increment BY 1
maxvalue 20169999

DROP SEQUENCE hak;

DROP TABLE Grade; CASCADE;
CREATE TABLE Grade(
	id VARCHAR2(30) NOT NULL,
	hak NUMBER PRIMARY KEY,
	java NUMBER NOT NULL,
	sql NUMBER NOT NULL,
	jsp NUMBER NOT NULL,
	spring NUMBER NOT NULL
);

INSERT INTO Grade(id, hak, java, sql, jsp, spring)
VALUES('hong', hak.NEXTVAL, 70,70,70,70);

INSERT INTO Grade(id, hak, java, sql, jsp, spring)
VALUES('kim', hak.NEXTVAL, 80,80,80,80);

INSERT INTO Grade(id, hak, java, sql, jsp, spring)
VALUES('lee', hak.NEXTVAL, 90,90,90,90);

INSERT INTO Grade(id, hak, java, sql, jsp, spring)
VALUES('han', hak.NEXTVAL, 85,85,85,85);

INSERT INTO Grade(id, hak, java, sql, jsp, spring)
VALUES('song', hak.NEXTVAL, 95,95,95,95);

INSERT INTO Grade(id, hak, java, sql, jsp, spring)
VALUES('kim2', hak.NEXTVAL, 50,50,50,50);

SELECT * FROM Grade;

select * from Grade
where id='song';
