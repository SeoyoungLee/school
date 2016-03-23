--시퀀스 설정
CREATE SEQUENCE score_seq
start WITH 1
increment BY 1

DROP SEQUENCE scoreSeq;

DROP TABLE Grade CASCADE CONSTRAINT;
CREATE TABLE Grade(
	score_seq NUMBER PRIMARY KEY,
	id VARCHAR2(30) NOT NULL,
	java NUMBER NOT NULL,
	sql NUMBER NOT NULL,
	jsp NUMBER NOT NULL,
	spring NUMBER NOT NULL
);

ALTER TABLE Grade RENAME hak TO examSeq;

INSERT INTO Grade(score_seq, id, java, sql, jsp, spring)
VALUES( score_seq.NEXTVAL,'hong', 70,70,70,70);

INSERT INTO Grade(score_seq, id, java, sql, jsp, spring)
VALUES( score_seq.NEXTVAL, 'kim',80,80,80,80);

INSERT INTO Grade(score_seq, id, java, sql, jsp, spring)
VALUES( score_seq.NEXTVAL, 'lee',90,90,90,90);

INSERT INTO Grade(score_seq, id, java, sql, jsp, spring)
VALUES( score_seq.NEXTVAL,'han', 85,85,85,85);

INSERT INTO Grade(score_seq, id, java, sql, jsp, spring)
VALUES( score_seq.NEXTVAL,'song', 95,95,95,95);

INSERT INTO Grade(score_seq, id, java, sql, jsp, spring)
VALUES( score_seq.NEXTVAL, 'kim2',50,50,50,50);

INSERT INTO Grade(score_seq, id, java, sql, jsp, spring)
VALUES( score_seq.NEXTVAL, 'hong',65,65,65,65);

SELECT * FROM Grade;

select * from Grade
where id='song';
