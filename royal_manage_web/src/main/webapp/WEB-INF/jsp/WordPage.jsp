<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>帖信息管理页面</title>

</head>
<style type="text/css">
    html, body {
        overflow: auto;
        height: 100%;
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
        location.href = "${pageContext.request.contextPath}/word/findByPage.do?pageNum="+num;
    }

</script>
<body>
<div class="hrms_dept_container">
    <!-- 导航栏-->
    <%@ include file="../../jsp/commom/head.jsp" %>


    <!-- 中间部分（左侧栏+表格内容） -->
    <div class="hrms_dept_body">
        <!-- 左侧栏 -->
        <%@ include file="../../jsp/commom/leftsidebar.jsp" %>

        <!-- 表格内容 -->
        <div class="dept_info col-sm-10">
            <div class="panel panel-success">
                <!-- 路径导航 -->
                <div>
                    <ol class="breadcrumb">
                        <li><a href="#">用户帖管理</a></li>
                        <li class="active">敏感词汇管理</li>
                    </ol>
                </div>
                <hr>
                <!-- Table -->
                <div>
                    <div style="float: left">
                        <form action="/word/save.do" method="post" id="articleSearchForm">
                            <table>
                                <tr>
                                    <th>
                                        <label for="title" class="control-label">敏感词：</label>
                                    </th>
                                    <th>
                                        <input type="text" id="title" class="form-control"
                                               name="word" value="">
                                        <input type="hidden" id="pageNum" name="pn" value="">
                                    </th>
                                    <th>
                                        <label for="article_sendername" class="control-label">是否启用:</label>
                                    </th>
                                    <th>
                                        <select type="text" id="article_sendername" class="form-control" name="status" >
                                            <option value="1">是</option>
                                            <option value="0">否</option>
                                        </select>
                                    </th>
                                    <th colspan="2">
                                        <input type="submit" value="添加敏感词" class="form-control btn-primary">
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
                        <th>敏感词</th>
                        <th>是否启用</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${wordList.list}" var="words">
                        <tr>
                                <%--标题--%>
                            <td width="30%">${words.word}</td>
                                <%-- 0表示不启用； 1表示启用--%>
                            <c:if test="${words.status==0}">
                                <td width="10%" class="line-limit-length">否</td>
                            </c:if>
                            <c:if test="${words.status==1}">
                                <td width="10%" class="line-limit-length">是</td>
                            </c:if>

                            <td width="10%">
                                    <%-- 0表示不启用； 1表示启用--%>
                                <c:if test="${words.status==0}">
                                    <a href="/word/changeStatus.do?wordId=${words.wordId}&status=1&pageNum=${wordList.pageNum}&pageSize=${wordList.pageSize}" role="button"
                                       class="btn btn-danger">启用</a>
                                </c:if>
                                <c:if test="${words.status==1}">
                                    <a href="/word/changeStatus.do?wordId=${words.wordId}&status=0&pageNum=${wordList.pageNum}&pageSize=${wordList.pageSize}" role="button"
                                       class="btn btn-info">取消</a>
                                </c:if>

                                <a href="/word/deleteWord.do?wordId=${words.wordId}&pageNum=${wordList.pageNum}&pageSize=${wordList.pageSize}" role="button"
                                   class="btn btn-info">删除</a>
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
                    当前第 ${wordList.pageNum} 页.总共 ${wordList.pages} 页.一共 ${wordList.total} 条记录
                </div>

                <!--点击分页-->
                <div class="col-md-6">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <!--首页-->
                            <li><a href="#" onclick="searchArticle(1)">首页</a></li>
                            <!--上一页-->
                            <li>
                                <c:if test="${wordList.hasPreviousPage}">
                                    <a href="#" onclick="searchArticle('${wordList.pageNum-1}')"
                                       aria-label="Previous">
                                        <span aria-hidden="true"> « </span>
                                    </a>
                                </c:if>
                            </li>

                            <c:forEach items="${wordList.navigatepageNums}" var="page_num">
                                <c:if test="${page_num == wordList.pageNum}">
                                    <li class="active"><a href="#">${page_num}</a></li>
                                </c:if>
                                <c:if test="${page_num != wordList.pageNum}">
                                    <li><a href="#" onclick="searchArticle('${page_num}')">${page_num}</a></li>
                                </c:if>
                            </c:forEach>

                            <!--下一页-->
                            <li>
                                <c:if test="${wordList.hasNextPage}">
                                    <a href="javascript:void(0)" onclick="searchArticle('${wordList.pageNum+1}')"
                                       aria-label="Next">
                                        <span aria-hidden="true"> » </span>
                                    </a>
                                </c:if>
                            </li>
                            <li><a href="javascript:void(0)" onclick="searchArticle('${wordList.pages}')">尾页</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div><!-- /.dept_info -->
        <!-- 尾部-->
        <%@ include file="../../jsp/commom/foot.jsp" %>
    </div><!-- /.hrms_dept_body -->

</div><!-- /.hrms_dept_container -->

<%--<%@ include file="ArticleAdd.jsp"%>--%>
<%--<%@ include file="ArticleUpdate.jsp"%>--%>
</body>
</html>
