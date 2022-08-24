package com.spring.pr.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TsVO {
	
	/*
	CREATE TABLE Ts (
		TS_NUM_SEQ	NUMBER(10)	NOT NULL,
		TS_NAME	VARCHAR2(30)	NOT NULL,
		TS_SOC_NUM	VARCHAR2(20)	NOT NULL,
		TS_HOME_NUM	VARCHAR2(20)	NULL,
		TS_ACAD_BACK	VARCHAR2(500)	NOT NULL,
		TS_ACAD_BACK_FILE	VARCHAR2(30)	NULL,
		TS_CARRER	VARCHAR2(500)	NOT NULL,
		TS_CARRER_FILE	VARCHAR2(30)	NOT NULL,
		TS_EMAIL	VARCHAR2(50)	NOT NULL,
		TS_PHONE_NUM	VARCHAR2(20)	NOT NULL,
		TS_BANK	VARCHAR2(20)	NOT NULL,
		TS_ACC_HOL	VARCHAR2(30)	NOT NULL,
		TS_BANK_NUM	VARCHAR2(30)	NOT NULL,
		TS_POST_NUM	VARCHAR2(10)	NOT NULL,
		TS_ADDR	VARCHAR2(100)	NOT NULL,
		TS_DTL_ADDR	VARCHAR2(100)	NOT NULL,
		TS_EXPRT	VARCHAR2(50)	NOT NULL,
		TS_LNGG	VARCHAR2(50)	NOT NULL,
		TS_DSG_CRT	VARCHAR2(100)	NOT NULL,
		TS_ACTIVE_AREA	VARCHAR2(100)	NOT NULL,
		APP_NUM_SEQ	NUMBER(10)	NOT NULL,
		JOIN_ID	VARCHAR2(20)	NOT NULL
		);
		
		CREATE SEQUENCE TS_NUM_SEQ_NAME
		    START WITH 1
		    INCREMENT BY 1  
		    MAXVALUE 1000
		    NOCYCLE 
		    NOCACHE;
	*/
	private int tsNum;
	private String tsName; //이름
	private String tsSocNum; //주민등록번호
	private String tsHomeNum; //집 전화번호
	private String tsPhoneNum; // 휴대폰 번호
	private String tsJob; // 직업
	private String tsEmail; // 이메일
	private String tsExprt; // 전문 분야
	private String tsLngg; // 언어
	private String tsDsgCrt; // 지정 법원
	private String tsActiveArea; //활동 지역
	private String tsAcadBack; // 학력
	private String tsAcadBackFile; // 학력 파일
	private String tsAcadBackFileReal;
	private String tsCarrer; // 경력
	private String tsCarrerFile; //경력 파일
	private String tsCarrerFileReal;
	private String tsBank; //은행
	private String tsAccHol; //예금주
	private String tsBankNum; //계좌번호
	private String tsPostNum; //우편번호
	private String tsAddr; //주소
	private String tsDtlAddr; //상세 주소
	
	private int appNumSeq;
	private String joinId;
	
}
