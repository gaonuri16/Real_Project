<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<title> 마이페이지 기관 정보 수정 페이지 </title>
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
    .btn-box::after{
        display: block;
        content: '';
        clear: both;
    }
    
    button:hover{
        cursor: pointer;
    }

    .btn-box{
        max-width: 800px;
        min-width: 400px;
        margin: 50px 32% 0;

        
    }
    .withdrawal-btn{
        float:left;
        margin-right: 3%;
        box-sizing: border-box;
        text-align: center;
    }
    
    .modif-fin-btn{
        float:left;
        margin-right: 3%;
        box-sizing: border-box;
        text-align: center;
    }

    .cencel-btn{
        float:left;
        box-sizing: border-box;
        text-align: center;
    }

    /*btn-outline-secondary 적용시 왼쪽 짤림 보완 스타일 */
    .btn-add-style{
    border-left: 2px solid gray;
    background-color: white;
    
    }


    
    .total-box{
        border: 1px solid rgb(189, 186, 186);
        border-radius: 20px;
        /* width: 80%; */
        max-width: 800px;
        min-width: 500px;
        margin: 0 auto;
        padding: 20px 0;
    }
    
    .box1{
        border-radius: 20px;
        background-color: #EFEFEF;
        color: #676767;
        min-width: 25%;
        height: 40px;
        line-height: 40px;
        margin-left: 10%;
        margin-right: 10%;
        float: left;
        text-align: center;
    }
    .box2{
        color: #676767;
        width: 75%;
        height: 40px;
        line-height: 40px;
        margin: 0 5%;
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


            <!-- Start 나의 정보 [기관]수정-->
            <div class="col-lg-9">
            
                <form class="m-auto form-total-box" method="post" role="form">

                    <div class="title-box">MY INFO</div>

                    <div class="total-box">
                        

                        <div class="boxbox">
                            <div class="box1">이름</div>
                            <div class="box2 joinName" id="joinName" name="JOINNAME">홍길동</div>
                        </div>
                        <div class="boxbox">
                            <div class="box1">생년월일</div>
                            <div class="box2 joinBirth" id="joinSocNum" name="JOINSOCNUM" >1999년 10월 11일</div>
                        </div>
                        <div class="boxbox">
                            <div class="box1">성별</div>
                            <div class="box2 joinGen" id="joinGen" name="JOINGEN">남자</div>
                        </div>

                        <div class="boxbox">
                            <div class="box1">이메일</div>
                            <div class="box2 joinGen" id="joinEmail" name="JOINEMAIL">hong123@gmail.com</div>
                        </div>


                        <div class="boxbox">
                            <div class="box1">휴대전화</div>
                            <div class="box2" id="joinPhone" name="JOINPHONE">010 2345 6789</div>
                        </div>

                        <div class="boxbox">
                            <label class="box1" for="inputJoinAddrBasic">우편번호</label>
                            <div class="box2 input-group joinAddrBasic">
                                <input type="text" class="form-control" id="joinAddrNum" name="JOINADDRNUM">
                                <button class="input-group-text btn-add-style btn-outline-secondary ">주소 찾기</button>
                            </div>
                        </div>
                        <div class="boxbox">
                            <label class="box1" for="inputJoinAddrBasic">기본주소</label>
                            <div class="box2 input-group joinAddrBasic">
                                <input type="text" class="form-control" id="joinAddrBasic" name="JOINADDRBASIC">
                            </div>
                        </div>
                        <div class="boxbox">
                            <label class="box1" for="inputJoinAddrDetail">상세주소</label>
                            <div class="box2 input-group joinAddrDetail">
                                <input type="text" class="form-control" id="joinAddrDetail" name="JOINADDRDETAIL">
                            </div>
                        </div>

                        <div class="boxbox">
                            <label class="box1" for="inputInsName">소속 기관</label>
                            <div class="box2 input-group insName">
                                <input type="text" class="form-control" id="insName" name="INSNAME">
                            </div>
                        </div>

                        <div class="boxbox">
                            <label class="box1" for="inputInsSocNum">사업자 번호</label>
                            <div class="box2 input-group insSocNum">
                                <input type="text" class="form-control" id="insSocNum" name="INSSOCNUM" placeholder='"-"기호를 제외하고 입력해주세요.'>
                            </div>
                        </div>
            
                        <div class="boxbox">
                            <label class="box1" for="inputInsAddrBasic">기관 우편번호</label>
                            <div class="box2 input-group insAddrBasic">
                                <input type="text" class="form-control" id="insAddrNum" name="INSADDRNUM">
                                <button class="input-group-text btn-add-style btn-outline-secondary ">주소 찾기</button>
                            </div>
                        </div>
                        <div class="boxbox">
                            <label class="box1" for="inputInsAddrBasic">기관 주소</label>
                            <div class="box2 input-group insAddrBasic">
                                <input type="text" class="form-control" id="insAddrBasic" name="INSADDRBASIC">
                            </div>
                        </div>
                        <div class="boxbox">
                            <label class="box1" for="inputInsAddrDetail">기관 상세 주소</label>
                            <div class="box2 input-group insAddrDetail">
                                <input type="text" class="form-control" id="insAddrDetail" name="INSADDRDETAIL">
                            </div>
                        </div>
                    </div>

                
                    <div class="btn-box">
                        <div class="withdrawal-btn">
                            <button type="button" id="withdrawalBtn" class="btn btn-outline-secondary px-3">회원탈퇴</button>
                        </div>
                        <div class="modif-fin-btn">
                            <button type="button" id="modifFinBtn" class="btn btn-outline-secondary px-3">수정완료</button>
                        </div>
                        <div class="cencel-btn">
                            <button type="submit" id="cencelBtn" class="btn btn-outline-secondary px-3">취소</button>
                        </div>
                    </div>

                </form>
            </div>

        </div>
    </div>
    <!-- End mypage ins modif -->

    <%@ include file="../include/footer1.jsp"%>

</body>

<script>




</script>

