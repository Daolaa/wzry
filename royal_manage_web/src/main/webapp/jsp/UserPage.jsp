<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理页面</title>

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

        function searchArticle(num,userName,roleStr){
            location.href = "${pageContext.request.contextPath}/manage_User/findByCondition.do?pageNum="+num+"&userName="+userName+"&roleStr="+roleStr;
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
                        <li><a href="#">用户信息管理</a></li>
                        <li class="active">用户信息</li>
                    </ol>
                </div>
                <hr>
                <!-- Table -->
                <div>
                    <div style="float: left">
                        <form method="post" action="${pageContext.request.contextPath}/manage_User/findByCondition.do"  id="articleSearchForm" >
                            <table>
                                <tr>
                                    <th>
                                        <label for="userName" class="control-label">用户名:</label>
                                    </th>
                                    <th>
                                        <input type="text" id="userName" class="form-control"
                                               name="userName" value="">
                                        <input type="hidden" id="pageNum" name="pageNum" value="${UserMsgs.pageNum}">
                                    </th>
                                    <th>
                                        <label for="user_roleStr" class="control-label">用户组:</label>
                                    </th>
                                    <th>
                                        <select type="text" id="user_roleStr" class="form-control" name="role">
                                            <option value="0"></option>
                                            <option value="3">超级管理员</option>
                                            <option value="2">高级用户</option>
                                            <option value="1">普通用户</option>
                                        </select>
                                    </th>
                                    <th colspan="2">
                                        <input type="submit" value="查询" class="form-control btn-primary">
                                    </th>
                                </tr>
                            </table>

                        </form>
                    </div>
                </div>
                <div style="clear:both"></div>
                <hr>
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>用户名</th>15
                        <th>用户组</th>15
                        <th>邮箱</th>25
                        <th>是否禁言</th>10
                        <th>最近登陆时间</th>20
                        <th>操作</th>10
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${UserMsgs.list}" var="user">
                            <tr>
                                <td width="15%">${user.userName}</td>
                                <td width="12%" class="line-limit-length">
                                        ${user.roleStr}
                                </td>
                                <td width="25%" class="line-limit-length">${user.email}</td>
                                <td width="10%" class="line-limit-length">
                                        ${user.talkStatusStr}
                                </td>
                                <td width="20%">
                                        ${user.lastLoginTimeStr}
                                </td>
                                <td width="13%">
                                    <c:if test="${user.isupdating==1}">
                                        <c:if test="${user.updateStatus==0}">
                                            <a href="${pageContext.request.contextPath}upgrade.do?userId=${user.userId}&pageNum=${UserMsgs.pageNum}&userName=${conditionList[0]}&roleStr=${conditionList[1]}" role="button" class="btn btn-primary">升级</a>
                                        </c:if>
                                    </c:if>
                                    <c:if test="${user.talkStatus==0}">
                                        <a href="${pageContext.request.contextPath}changeTalkStatus.do?userId=${user.userId}&talkStatus=${user.talkStatus}&pageNum=${UserMsgs.pageNum}&userName=${conditionList[0]}&roleStr=${conditionList[1]}" role="button" class="btn btn-danger" >禁言</a>
                                    </c:if>
                                    <c:if test="${user.talkStatus==1}">
                                        <a href="${pageContext.request.contextPath}changeTalkStatus.do?userId=${user.userId}&talkStatus=${user.talkStatus}&pageNum=${UserMsgs.pageNum}&userName=${conditionList[0]}&roleStr=${conditionList[1]}" role="button" class="btn btn-info" >取消</a>
                                        <%--&pn=${UserMsgs.pageNum}&title=${user.title}&sendername=${user.senderName}--%>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>


            </div><!-- /.panel panel-success -->
            <!--显示分页信息-->
            <div class="row">
                <!--文字信息-->
                <div class="col-md-6">
                    当前第 ${UserMsgs.pageNum} 页.总共 ${UserMsgs.pages} 页.一共 ${UserMsgs.total} 条记录
                </div>

                <!--点击分页-->
                <div class="col-md-6">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <!--首页-->
                            <li><a href="#" onclick="searchArticle(1,'${conditionList[0]}','${conditionList[1]}')">首页</a></li>
                            <!--上一页-->
                            <li>
                                <c:if test="${UserMsgs.hasPreviousPage}">
                                        <a href="#" onclick="searchArticle('${UserMsgs.pageNum-1}','${conditionList[0]}','${conditionList[1]}')" aria-label="Previous">
                                            <span aria-hidden="true">«</span>
                                        </a>
                                </c:if>
                            </li>

                            <c:forEach items="${UserMsgs.navigatepageNums}" var="page_num">
                                <c:if test="${page_num == UserMsgs.pageNum}">
                                    <li class="active"><a href="#">${page_num}</a></li>
                                </c:if>
                                <c:if test="${page_num != UserMsgs.pageNum}">
                                    <li><a href="#" onclick="searchArticle('${page_num}','${conditionList[0]}','${conditionList[1]}')">${page_num}</a></li>
                                </c:if>
                            </c:forEach>

                            <!--下一页-->
                            <li>
                                <c:if test="${UserMsgs.hasNextPage}">
                                    <a href="javascript:void(0)" onclick="searchArticle('${UserMsgs.pageNum+1}','${conditionList[0]}','${conditionList[1]}')"
                                       aria-label="Next">
                                        <span aria-hidden="true">»</span>
                                    </a>
                                </c:if>
                            </li>
                            <li><a href="javascript:void(0)" onclick="searchArticle('${UserMsgs.pages}','${conditionList[0]}','${conditionList[1]}')">尾页</a></li>
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
</html>
