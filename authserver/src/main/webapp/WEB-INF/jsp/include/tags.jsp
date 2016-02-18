<% pageContext.setAttribute("lf", "\n"); 
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@ taglib
	prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><%@ taglib
	prefix="fn" uri="http://java.sun.com/jsp/jsp/jstl/functions"%><%@ taglib 
	prefix="spring" uri="http://www.springframework.org/tags"%><%@ taglib
	prefix="form" uri="http://www.springframework.org/tags/form"%><%@ taglib
	prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %><%@ taglib 
	prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %><%@ taglib 
	prefix="str" uri="http://jakarta.apache.org/taglibs/string-1.1" %><%@ taglib 
	prefix="portalcode" uri="http://member.goorm.com/portalcodemanager" %><%

	java.util.Date date = new java.util.Date();
	pageContext.setAttribute("CURRDATE", date);
	
	//com.goorm.member.common.helpers.CertConstants _const = new com.goorm.member.common.helpers.CertConstants();
	//pageContext.setAttribute("_const", _const);
	
	%><!-- jsp:useBean id="CertConstant" class="com.goorm.member.common.helpers.GLCommonConstantForJsp" scope="page" / -->
	<c:set var="uri" value="${pageContext.request.requestURI}"/>