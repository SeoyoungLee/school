	CREATE TABLE Grade(
	id VARCHAR2(30),
	hak NUMBER PRIMARY KEY,
	java NUMBER,
	sql NUMBER,
	jsp NUMBER,
	spring NUMBER
);

INSERT INTO Grade(id, hak, java, sql, jsp, spring)
VALUES('hong', 20110228, 80, 60, 75, 100);

INSERT INTO Grade(id, hak, java, sql, jsp, spring)
VALUES('kim', 20104419, 70, 85, 95, 90);

INSERT INTO Grade(id, hak, java, sql, jsp, spring)
VALUES('lee', 20156519, 65, 80, 90, 75);

INSERT INTO Grade(id, hak, java, sql, jsp, spring)
VALUES('han', 20083312, 100, 80, 95, 70);

INSERT INTO Grade(id, hak, java, sql, jsp, spring)
VALUES('song', 20074126, 85, 95, 70, 85);

INSERT INTO Grade(id, hak, java, sql, jsp, spring)
VALUES('kang', 20083325, 90, 70, 80, 100);

SELECT * FROM Grade;