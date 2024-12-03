
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Site Metas -->
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta name="author" content="" />
    </head>
    <body>
        <div div="row">
            <ul class="pagination pagination-lg justify-content-end">
                <c:forEach begin="0" end="${totalPage - 1}" var="i">
                    <li class="page-item">
                        <a class="page-link rounded-0 mr-3 shadow-sm border-top-0 border-left-0" 
                           href="search?pricing=${pricing}&text=${text}&pageIndex=${i}&categoryId=${categoryId}&pageSize=${pageSize}"
                           <c:if test="${pageIndex == i}">style="background: greenyellow"</c:if>>${i+1}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </body>
</html>
