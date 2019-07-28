<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>版块审核</title>

</head>
<style type="text/css">
    html,body{
        overflow:auto;
        height:100%;
    }

    .line-limit-length {
        max-width: 220px;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
    }


</style>
<script>
    function searchArticle(num){
        location.href = "${pageContext.request.contextPath}/zoneApply/findByZoneapp.do?pageNum="+num;
    }
</script>
<body>
<div class="hrms_dept_container">
    <!-- 导航栏-->
    <%@ include file="commom/head.jsp"%>


    <!-- 中间部分（左侧栏+表格内容） -->
    <div class="hrms_dept_body">
        <!-- 左侧栏 -->
        <%@ include file="commom/leftsidebar.jsp"%>

        <!-- 表格内容 -->
        <div class="dept_info col-sm-10">
            <div class="panel panel-success">
                <!-- 路径导航 -->
                <div >
                    <ol class="breadcrumb">
                        <li><a href="#">用户帖管理</a></li>
                        <li class="active">版块审核</li>
                    </ol>
                </div>
                <hr>
                <div style="clear:both"></div>
                <hr>
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>新增版块名字</th>
                        <th>用户名</th>
                        <th>申请理由</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="zoneapp" items="${zoneapplist.list}">
                        <c:if test="${zoneapp.status==0}">
                        <tr>

                            <td width="10%">${zoneapp.zoneName}</td>
                            <td width="10%" class="line-limit-length">${zoneapp.userName}</td>
                            <td width="40%" class="line-limit-length">${zoneapp.reason}</td>
                            </td>
                            <td width="15%">
                                <a href="/zoneApply/saveZone2.do?id=${zoneapp.applyZoneId}&zoneName=${zoneapp.zoneName}&isDef=2&pageNum=${reportlist.pageNum}&pageSize=${reportlist.pageSize}" role="button" class="btn btn-success">同意</a>
                                <%--<c:if test="${zoneapp.status==0}">--%>
                                <a href="/zoneApply/updatestatus.do?id=${zoneapp.applyZoneId}&pageNum=${reportlist.pageNum}&pageSize=${reportlist.pageSize}" role="button" class="btn btn-info">驳回</a>
                                <%--</c:if>--%>
                            </td>
                        </tr>
                        </c:if>
                    </c:forEach>
                    </tbody>
                </table>
            </div><!-- /.panel panel-success -->
            <!--显示分页信息-->
            <div class="row">
                <!--文字信息-->
                <div class="col-md-6">
                    当前第 ${zoneapplist.pageNum} 页.总共 ${zoneapplist.pages} 页.一共 ${zoneapplist.total} 条记录
                </div>

                <!--点击分页-->
                <div class="col-md-6">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <!--首页-->
                            <li><a href="#" onclick="searchArticle(1)">首页</a></li>
                            <!--上一页-->
                            <li>
                                <c:if test="${zoneapplist.hasPreviousPage}">
                                    <a href="#" onclick="searchArticle('${zoneapplist.pageNum-1}')" aria-label="Previous">
                                        <span aria-hidden="true">«</span>
                                    </a>
                                </c:if>
                            </li>

                            <c:forEach items="${zoneapplist.navigatepageNums}" var="page_num">
                                <c:if test="${page_num == zoneapplist.pageNum}">
                                    <li class="active"><a href="#">${page_num}</a></li>
                                </c:if>
                                <c:if test="${page_num != zoneapplist.pageNum}">
                                    <li><a href="#" onclick="searchArticle('${page_num}')">${page_num}</a></li>
                                </c:if>
                            </c:forEach>

                            <!--下一页-->
                            <li>
                                <c:if test="${zoneapplist.hasNextPage}">
                                    <a href="javascript:void(0)" onclick="searchArticle('${zoneapplist.pageNum+1}')"
                                       aria-label="Next">
                                        <span aria-hidden="true">»</span>
                                    </a>
                                </c:if>
                            </li>
                            <li><a href="javascript:void(0)" onclick="searchArticle('${zoneapplist.pages}')">尾页</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div><!-- /.dept_info -->

        <!-- 尾部-->
        <%@ include file="commom/foot.jsp"%>
    </div><!-- /.hrms_dept_body -->

</div><!-- /.hrms_dept_container -->

<%--<%@ include file="ArticleAdd.jsp"%>--%>
<%--<%@ include file="ArticleUpdate.jsp"%>--%>
</body>
<script>


</script>
</html>
