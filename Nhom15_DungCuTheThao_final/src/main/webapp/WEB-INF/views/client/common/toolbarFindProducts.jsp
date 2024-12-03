
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div div="row">
            <ul class="pagination pagination-lg justify-content-end">
                <c:forEach begin="0" end="${totalPage - 1}" var="i">
                    <li class="page-item">
                        <a class="page-link rounded-0 mr-3 shadow-sm border-top-0 border-left-0" 
                           href="textSearch?pcName=${nameP}&pageIndex=${i}&pageSize=${pageSize}"
                           <c:if test="${pageIndex == i}">style="background: greenyellow"</c:if>>${i+1}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </body>
</html>
