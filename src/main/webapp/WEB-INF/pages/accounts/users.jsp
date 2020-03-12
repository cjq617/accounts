<%--
  Created by IntelliJ IDEA.
  User: 56876
  Date: 2020/3/12
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>账号</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
    <meta name="viewport" content="width=device-width, initial-scale=0.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />
    <%@include file="../main/publics.jsp"%>
</head>
<body>
<div id="contentDiv">
    <div class="lyy_header">
        <a class="btn_left" v-if="history" onclick="window.history.back();">
            <img src="${pageContext.request.contextPath}/Images/common/header_back.png">
        </a>
        <span>账号</span>
        <a class="btn_right" v-if="history" href="${pageContext.request.contextPath}">
            <img src="${pageContext.request.contextPath}/Images/common/header_index.png">
        </a>
    </div>
    <div id="orderDiv" class="lyy_nav_box">
        <div v-if="userList.length == 0 && !isLoading" v-cloak>
            <div class="lyy_noorder">暂无信息</div>
        </div>
        <template v-else>
            <div v-if="userList.length > 0" style="margin-top: -1px;">
                <div class="lyy_order" style="margin-top: 0px;position: fixed;" v-cloak>
                    <div class="lyy_order_top container">
                        <div class="title fl" style="width: 33%">
                            账号
                        </div>
                        <div class="food fl" style="color: #333;width: 33%">
                            提示
                        </div>
                        <div class="food fl" style="color: #333;width: 33%">
                            备注
                        </div>
                    </div>
                </div>
            </div>
            <div style="margin-top: 40px;">
                <div v-for="bill in userList" class="lyy_order" v-cloak>
                    <div class="lyy_order_top container">
                        <div class="title fl" style="width: 33%">
                            {{bill.userId}}
                        </div>
                        <div class="paid fl" style="width: 33%">{{bill.password}}</div>
                        <div class="paid fl" style="width: 33%">{{bill.remark}}</div>
                    </div>
                </div>
            </div>
        </template>
        <div class="ge20"></div>

        <div id='load_more' v-show="isLoading" v-cloak>
            <p style='text-align: center; line-height: 3em; vertical-align: middle;'>正在努力加载...</p>
        </div>
        <div id='no_more' v-show="userList.length != 0" v-cloak>
            <p class="time" style='text-align: center;'>已显示全部信息</p>
        </div>
        <div class="ge20"></div>
    </div>
    <div class="lyy_tourism_popup_bg" v-show="maskFlag"></div>
</div>
<script>
    var vm = new Vue({
        el: "#contentDiv",
        data: {
            isLoading: false,
            userList: [],//账号列表
            maskFlag : false
        },
        mounted : function () {
            var _this = this;
            this.$nextTick(function() {
                _this.orderQuery();
            });
        },
        methods : {
            orderQuery : function() {
                var _this = this;
                _this.isLoading = true;
                var dto = {};
                dto.currentPage = _this.currentPage;
                dto.pageSize = _this.pageSize;
                axios.post(contextPath + "/accounts/usersQuery", dto).then(function (response) {
                    if (response.data.status == "0000") {
                        _this.userList = response.data.data;
                        _this.isLoading = false;
                    } else {
                        myToast(response.data.message ? response.data.message : "查询失败，请稍后重试！", false);
                    }
                }).catch(function (error) {
                    console.log(error);
                });
            }
        }
    });
</script>
</body>
</html>
