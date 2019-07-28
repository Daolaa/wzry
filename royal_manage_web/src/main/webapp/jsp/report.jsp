<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>审批举报</title>

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


   function tieziContent(num) {
       $.post("/report/findById.do",{"articleId":num},function (data) {
           $("#title_ajax").html(data.title);
           $("#content_ajax").html(data.content);
       });
   }

   function searchArticle(num){
       location.href = "${pageContext.request.contextPath}/report/findByReport.do?pageNum="+num;
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
                        <li class="active">审批举报</li>
                    </ol>
                </div>
                <hr>
                <div style="clear:both"></div>
                <hr>
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>帖子ID</th>
                        <th>举报内容</th>
                        <th>举报人</th>
                        <th>举报时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="reports" items="${reportlist.list}">
                        <tr>
                            <td width="5%">${reports.articleId}</td>
                            <td width="20%" class="line-limit-length">${reports.reportContent}</td>
                            <td width="5%" class="line-limit-length">${reports.reportUserName}</td>
                            </td>
                            <td width="15%">${reports.reportTime}</td>
                            <td width="15%">
                                <a href="#" onclick="tieziContent('${reports.articleId}')" role="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">相关内容</a>
                                <c:if test="${reports.reportStatus==0}">
                                    <a href="/report/updateReport1.do?articleId=${reports.articleId}&reportId=${reports.reportId}&pageNum=${reportlist.pageNum}&pageSize=${reportlist.pageSize}" role="button" class="btn btn-danger">屏蔽</a>
                                </c:if>
                                <c:if test="${reports.reportStatus==1}">
                                    <a href="/report/updateReport0.do?articleId=${reports.articleId}&reportId=${reports.reportId}&pageNum=${reportlist.pageNum}&pageSize=${reportlist.pageSize}" role="button" class="btn btn-info" >解除</a>
                                </c:if>
                                <a href="/report/deleteById.do?reportId=${reports.reportId}&pageNum=${reportlist.pageNum}&pageSize=${reportlist.pageSize}" role="button" class="btn btn-info">驳回</a>
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
                    当前第 ${reportlist.pageNum} 页.总共 ${reportlist.pages} 页.一共 ${reportlist.total} 条记录
                </div>

                <!--点击分页-->
                <div class="col-md-6">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <!--首页-->
                            <li><a href="#" onclick="searchArticle(1)">首页</a></li>
                            <!--上一页-->
                            <li>
                                <c:if test="${reportlist.hasPreviousPage}">
                                    <a href="#" onclick="searchArticle('${reportlist.pageNum-1}')" aria-label="Previous">
                                        <span aria-hidden="true">«</span>
                                    </a>
                                </c:if>
                            </li>

                            <c:forEach items="${reportlist.navigatepageNums}" var="page_num">
                                <c:if test="${page_num == reportlist.pageNum}">
                                    <li class="active"><a href="#">${page_num}</a></li>
                                </c:if>
                                <c:if test="${page_num != reportlist.pageNum}">
                                    <li><a href="#" onclick="searchArticle('${page_num}')">${page_num}</a></li>
                                </c:if>
                            </c:forEach>

                            <!--下一页-->
                            <li>
                                <c:if test="${reportlist.hasNextPage}">
                                    <a href="javascript:void(0)" onclick="searchArticle('${reportlist.pageNum+1}')"
                                       aria-label="Next">
                                        <span aria-hidden="true">»</span>
                                    </a>
                                </c:if>
                            </li>
                            <li><a href="javascript:void(0)" onclick="searchArticle('${reportlist.pages}')">尾页</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div><!-- /.dept_info -->
        <!-- 模态框（Modal） -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">相关内容</h4>
                    </div>
                    <div class="modal-header" id="title_ajax"></div>
                    <div class="modal-body" id="content_ajax"></div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>
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
