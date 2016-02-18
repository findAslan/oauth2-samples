<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/tags.jsp"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/login.css" type="text/css" />
</head>
<body>
<h1 class="loginTit"><img src="/img/login/tit01.gif" alt="로그인" /></h1>
 
<!-- Start Of container -->	
<hr />
 
	<div id="container">
 
		<div class="loginBoxOutside">
			<div class="loginBoxInside">
				<div class="leftAdArea">
					<!--###################### main banner ######################-->
					<c:if test="${display_PTMAG ne null}">
					<a href="<c:out value="${display_PTMAG.url}" />" target="_blank"><img src="<c:out value="${display_PTMAG.img_src}" />" border="0" target="_blank"/></a>
					</c:if>
					<!--###################### main banner ######################-->
				</div>
				
<hr />
 
				<div class="loginAreaOut">
					
					<form:form commandName="user" method="post">
					<form:hidden path="backUrl" />
					
					<div class="loginAreaIn">
						<fieldset>
							<legend>구름 로그인</legend>
							<label for="id">아이디</label>
							<form:input path="custId" id="id" cssClass="clearB" onkeydown="setClearBackground(this);" onfocus="setFieldBackground($('passwd'));setClearBackground(this);" cssStyle="background-image: url(/img/login/inpuBgId.gif)" />
							<label for="passwd">비밀번호</label>
							<form:password path="pwd" id="passwd" cssClass="floL" onkeydown="setClearBackground(this);" onfocus="setFieldBackground($('id'));setClearBackground(this);"  cssStyle="background-image: url(/img/login/inpuBgPw.gif)" onkeyup="if(event.keyCode==13) formCheck();"/>
							<a href="javascript:formCheck();"><img src="/img/login/btnLogin.gif" class="loginBtn" alt="로그인" /></a>
						</fieldset>
 
						<div class="utilChk">
							<label for="idSave"><input type="checkbox" name="saveID" id="save_cnk" class="checkBox" onclick="saveform();"/>아이디저장</label>
							<label for="secuConnect"><input type="checkbox" name="secuConnect" id="secuConnect" class="checkBox" checked/>보안접속</label>
							<!--<label for="keySecu"><input type="checkbox" name="keySecu" id="secuKeyCheck" class="checkBox" onclick='keyboardSecurityCheck();'/><a href='javascript:popWinCenterNoScroll("http://www.goorm.com/popup_keySecu.html","",438,600);'>키보드보안</a></label>  -->
						</div>
						
						<ul class="utilBtn">
							<li><a href="/join/join.gm"><img src="/img/login/btnJoin.gif" alt="회원가입" /></a></li>
							<li><a href="/custinfo/inputFindCustIdNPwd.gm"><img src="/img/login/btnIdPw.gif" alt="아이디/비번 찾기" /></a></li>
						</ul>
						
						<p class="textInfo"><img src="/img/login/text01.gif" alt="구름 아이디를 만드시려면 회원가입을 해주세요.1111 (1인 3개 아이디 생성 가능)" /></p>
					
<hr />
<c:if test="${_logintry gt 4}">					
						<!-- 로그인 5회 이상 잘못 입력 -->
						<div class="loginSecu">
							<p class="pwCheckSum">비밀번호가 <strong>5회 이상 잘못 입력</strong>되었습니다. 아래 글자를 입력해주세요.</p>
							<dl class="loginCheck">
								<dt><img src="/popup/captcha.gm" height="55" style="position:relative; left:-15px;"/><!-- 자동입력 방지 이미지  --></dt>
								<dd>
									<c:if test="${_logintry gt 5}"><span>자동가입방지 값이 틀립니다.</span></c:if>
									<form:input path="captcha_answer" cssClass="loginCheckChar" onkeyup="if(event.keyCode==13) formCheck();" />
								</dd>
							</dl>
						</div>
						<!-- //로그인 5회 이상 잘못 입력 -->
</c:if>
					</div>
					
					</form:form>
				</div>
				
			</div>
		</div>
 
<hr />
 
		<div class="loginInfoBox">
			<dl class="infoTxt">
				<dt>알려드려요!</dt>
				<dd class="txt_01"><span>로그인</span> 관련하여 궁금한 사항은 help@goorm.com으로 문의하실 수 있습니다.</dd>
	<!-- 			<dd class="faqBtn"><a href="https://nerms.goorm.com/goorm/nerms_nologin.jsp"><img src="/img/login/btnFaq.gif" class="valignTop" alt="비회원 문의" /></a></dd> -->
			</dl>
		</div>
		
	</div>
<!-- End Of container -->

<script type="text/javascript">
function formCheck(){
	saveform();
	
	$('user').submit();
}

function getSaveID() 
{
	var saveId = popup_getCookie("saveid");
	
	if ( saveId && saveId != "" ){
		$('id').value = saveId;
		$('save_cnk').checked = true;
		$('passwd').focus();	
	}else{
		$('id').focus();
	}
}

function saveform() {
	var expdate = new Date();
	var id = document.getElementById("id").value;
	document.domain = "goorm.com";
	try {
		if (document.getElementById("save_cnk").checked) {
			expdate.setTime(expdate.getTime() + 1000 * 3600 * 24 * 7); // 7일 보관
		} else {
			expdate.setTime(expdate.getTime() - 1);
		}
		idSetCookie("saveid", id, expdate);
	} catch (e) {

	}
}
	
function idSetCookie (name, value, expires) {
	document.cookie = name + "=" + escape( value ) + "; domain=.goorm.com; path=/; expires=" + expires.toGMTString();
}

function keyboardSecurityCheck() {
	var secuKey = "SECU_KEY";
	var secuKeyCheck = document.getElementById( "secuKeyCheck" );
	if( secuKeyCheck != undefined ) {
		if( secuKeyCheck.checked ) {
			popup_setcookie( secuKey, "none", -1 )
		} else {
			popup_setcookie( secuKey, "none", 1 )
		}
	}
	document.location.reload();
}
</script>

<script language="javascript">

getSaveID();
setFieldBackground($('id'));
setFieldBackground($('passwd'));

//키보드 보안
if(popup_getCookie("SECU_KEY").length == 0) {
	if(popup_getCookie("SECU_KEY").length == 0) {
	//	document.write('<iframe src="/popup/nprotect.gm" id="keycrypt_frame" style="position:absolute;top:-1000px;left:-100px;width:1px;height:1px;" frameborder="0" scrolling="no"></iframe>');
	}
	//$('secuKeyCheck').checked = true;
}
</script>

<%-- validation fail. --%>
<spring:hasBindErrors name="user">
	<c:forEach var="error" items="${errors.allErrors}">
	    <script type="text/javascript">alert("<c:out value="${error.defaultMessage}" />");</script>
	</c:forEach>
</spring:hasBindErrors>

</body>
</html>