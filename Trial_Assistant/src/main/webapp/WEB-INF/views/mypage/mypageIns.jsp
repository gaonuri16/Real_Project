<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<title> 마이페이지 기관 정보조회 페이지 </title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">



    <!-- 페이지 무조건 추가  -->
	<link rel="shortcut icon" type="image/x-icon"
		href="${pageContext.request.contextPath }/resources/images/favicon.ico">
	
	
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/templatemo.css">
	
	
	<!-- Load fonts style after rendering the layout styles -->
	<link rel="stylesheet"
		href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/fontawesome.min.css">
	<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
		
	<!-- 아이콘 깨지는 것 해결하는 script -->
	<script src="https://kit.fontawesome.com/22ff043012.js" crossorigin="anonymous"></script>
		
	<!-- Start Script -->
	<script
		src="${pageContext.request.contextPath }/resources/js/jquery-1.11.0.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/js/jquery-migrate-1.2.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/js/bootstrap.bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/js/templatemo.js"></script>
	<script src="${pageContext.request.contextPath }/resources/js/custom.js"></script>
	<!-- End Script -->
	
	<!-- 무조건 페이지 추가  -->
	
	<style>
	
.title-box{
        text-align: center;
        justify-content: center;
        margin: 0 auto 100px;
        font-size: 30px !important;
        border:1px solid lightgray;
        border-radius: 40px;
        width: 200px;
        background-color: rgb(228, 227, 227);
        color: rgb(132, 127, 127);
        font-weight: 500 !important;
    }
    .form-total-box{
        max-width: 800px;
        min-width: 400px;
    }
    
    button:hover{
        cursor: pointer;
    }
    .btn-box{
        margin-top: 50px;
        width: 100%;
        min-width: 400px;
        text-align: center;
    }
    
    .modif-btn{
        margin: 0 50px;
        box-sizing: border-box;
        display: inline-block;
    }
    .cencel-btn{
        margin: 0 50px;
        box-sizing: border-box;
        display: inline-block;
    }
    
    .total-box{
        border: 1px solid rgb(189, 186, 186);
        border-radius: 20px;
        min-width: 80%;
        margin: 0 auto;
        padding: 20px 0;
    }
    
    .box1{
        border-radius: 20px;
        background-color: #EFEFEF;
        color: #676767;
        min-width: 30%;
        height: 40px;
        line-height: 40px;
        margin-left: 10%;
        margin-right: 10%;
        padding: 0 5%;
        float: left;
        text-align: center;
        white-space: nowrap;
    }
    .box2{
        color: #676767;
        min-width: 70%;
        height: 40px;
        line-height: 40px;
        margin-left: 5%;
    }
    .boxbox{
        display: flex;
        margin: 5% auto;
    }

	
	</style>
</head>

<body>

<jsp:include page="../include/header.jsp" /> 


    <!-- Start 사이드 바 -->
    <div class="container py-5">
        <div class="row">

            <div class="col-lg-3">
                <h1 class="h2 pb-4">MY PAGE</h1>
                <ul class="list-unstyled templatemo-accordion">
                    <li class="pb-3">
                        <a class="collapsed d-flex justify-content-between h3 text-decoration-none" href="mypage_ins.html">
                            MY INFO
                        </a>
                    </li>
                    <li class="pb-3">
                        <a class="collapsed d-flex justify-content-between h3 text-decoration-none myInfo" href="#">
                            조력자 신청/선정 현황
                        </a>
                    </li>
                    <li class="pb-3">
                        <a class="collapsed d-flex justify-content-between h3 text-decoration-none" href="#">
                            MY FAQ
                        </a>
                    </li>
                    <li class="pb-3">
                        <a class="collapsed d-flex justify-content-between h3 text-decoration-none" href="index.html">
                        로그아웃
                        </a>
                    </li>
                </ul>
            </div>
        <!-- End 사이드 바-->

            <!-- Start 나의 정보 [기관]-->
            <div class="col-lg-9">
            
                <form class="m-auto form-total-box" method="post" role="form">

                    <div class="title-box">MY INFO</div>

                    <div class="total-box">
                        
                        <div class="boxbox">
                            <div class="box1">이름</div>
                            <div class="box2 joinName" name="JOINNAME" value=${userInfo.JOINNAME}>홍길동</div>
                        </div>
                        <div class="boxbox">
                            <div class="box1">생년월일</div>
                            <div class="box2 joinBirth" name="JOINSOCNUM" value=${userInfo.JOINSOCNUM}>1999년 10월 11일</div>
                        </div>
                        <div class="boxbox">
                            <div class="box1" >성별</div>
                            <div class="box2 joinGen" name="JOINGEN" value=${userInfo.JOINGEN}>남자</div>
                        </div>
                        <div class="boxbox">
                            <div class="box1" >이메일</div>
                            <div class="box2 joinEmail" name="JOINEMAIL" value=${userInfo.JOINEMAIL}>hong123@gmail.com</div>
                        </div>
                        <div class="boxbox">
                            <div class="box1">휴대전화</div>
                            <div class="box2 joinPhone" name="JOINEPHONE" value=${userInfo.JOINPHONE}>010 2345 6789</div>
                        </div>
                        <div class="boxbox">
                            <div class="box1">우편번호</div>
                            <div class="box2 joinAddrNum" name="JOINADDRNUM" value=${userInfo.JOINADDRNUM}>서울시 강남구 테헤란로 7길</div>
                        </div>
                        <div class="boxbox">
                            <div class="box1">주소</div>
                            <div class="box2 joinAddrBasic" name="JOINADDRBASIC" value=${userInfo.JOINADDRBASIC}>서울시 강남구 테헤란로 7길</div>
                        </div>
                        <div class="boxbox">
                            <div class="box1">상세주소</div>
                            <div class="box2 joinAddrDetail" name="JOINADDRDETAIL" value=${userInfo.JOINADDRDETAIL}>길동 빌딩 7층</div>
                        </div>
                        <div class="boxbox">
                            <div class="box1">소속 기관</div>
                            <div class="box2 insName" name="INSNAME" value=${userInfo.INSNAME}>00병원</div>
                        </div>
                         <div class="boxbox">
                            <div class="box1">사업자 번호</div>
                            <div class="box2 insName" name="INSSOCNUM" value=${userInfo.INSSOCNUM}>00 000 000</div>
                        </div>
                         <div class="boxbox">
                            <div class="box1">우편번호</div>
                            <div class="box2 insAddrNum" name="INSADDRNUM" value=${userInfo.INSADDRNUM}>서울시 용산구 무지개로 7길</div>
                        </div>
                        <div class="boxbox">
                            <div class="box1">기관 주소</div>
                            <div class="box2 insAddrBasic" name="INSADDRBASIC" value=${userInfo.INSADDRBASIC}>서울시 용산구 무지개로 7길</div>
                        </div>
                        <div class="boxbox">
                            <div class="box1">기관 상세 주소</div>
                            <div class="box2 insAddrDetail" name="INSADDRDETAIL" value=${userInfo.INSADDRDETAIL}>00병원 A동</div>
                        </div>

                    </div>
                
                    <div class="btn-box">
                        <div class="col mt-2 modif-btn">
                            <button type="button" id="modifBtn" class="btn btn-outline-secondary px-3">정보수정</button>
                        </div>
                        <div class="col mt-2 cencel-btn">
                            <button type="button" id="cancelBtn" class="btn btn-outline-secondary px-3">취소</button>
                        </div>
                    </div>
                </form>
                
            </div>

        </div>
    </div>
    <!-- End Content -->

    <%@ include file="../include/footer1.jsp"%>

</body>

<script>




</script>

