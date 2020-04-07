<%--
  Created by IntelliJ IDEA.
  User: jq Chen
  Date: 2018/5/10
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>当月详细页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
    <meta name="viewport" content="width=device-width, initial-scale=0.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />
    <%@include file="../main/publics.jsp"%>
</head>
<body>
<div id="contentDiv">
    <input type="hidden" id="month" value="${month}">
    <input type="hidden" id="flag" value="${flag}">
    <div class="lyy_header">
        <a class="btn_left" v-if="history" onclick="window.history.back();">
            <img src="${pageContext.request.contextPath}/Images/common/header_back.png">
        </a>
        <span>账单详细</span>
        <a class="btn_right" v-if="history" href="${pageContext.request.contextPath}">
            <img src="${pageContext.request.contextPath}/Images/common/header_index.png">
        </a>
    </div>
    <div v-if="loading" v-cloak>
        <p style='text-align: center; line-height: 3em; vertical-align: middle;margin-top: 100px;'>正在努力加载...</p>
    </div>
    <%--<div v-if="!loading && !dto.breakfast" v-cloak>
        &lt;%&ndash;<p style='text-align: center; line-height: 3em; vertical-align: middle;margin-top: 100px;'>无此账单信息...</p>&ndash;%&gt;
        <div class="lyy_noorder">暂无账单信息</div>
    </div>--%>
    <div class="lyy_nonav_box" style="bottom: 5px;" v-if="!loading && dto.flag">
        <ul class="lyy_common_name">
            <li>
                <div class="lyy_title fl">人物</div>
                <div class="lyy_input fl inline-block">
                    {{dto.flag | convertFlag}}
                </div>
                <div class="clear"></div>
            </li>
            <li>
                <div class="lyy_title fl">日期</div>
                <div class="lyy_input fl inline-block">
                    {{dto.addDate}}
                </div>
                <div class="clear"></div>
            </li>
            <li>
                <div class="lyy_title fl">早餐</div>
                {{dto.breakfast}}
                <div class="clear"></div>
            </li>
            <li>
                <div class="lyy_title fl">午餐</div>
                {{dto.lunch}}
                <div class="clear"></div>
            </li>
            <li>
                <div class="lyy_title fl">晚餐</div>
                {{dto.supper}}
                <div class="clear"></div>
            </li>
            <li>
                <div class="lyy_title fl">水果</div>
                {{dto.fruit}}
                <div class="clear"></div>
            </li>
            <li>
                <div class="lyy_title fl">水/饮料</div>
                {{dto.drink}}
                <div class="clear"></div>
            </li>
            <li>
                <div class="lyy_title fl">面包/剁</div>
                {{dto.cake}}
                <div class="clear"></div>
            </li>
            <li>
                <div class="lyy_title fl">超市</div>
                {{dto.supermarket}}
                <div class="clear"></div>
            </li>
            <li>
                <div class="lyy_title fl">交通</div>
                {{dto.traffic}}
                <div class="clear"></div>
            </li>
            <li>
                <div class="lyy_title fl">煤气</div>
                {{dto.gass}}
                <div class="clear"></div>
            </li>
            <li>
                <div class="lyy_title fl">话费</div>
                {{dto.phone}}
                <div class="clear"></div>
            </li>
            <li>
                <div class="lyy_title fl">房租</div>
                {{dto.rent}}
                <div class="clear"></div>
            </li>
            <li>
                <div class="lyy_title fl">踢球</div>
                {{dto.football}}
                <div class="clear"></div>
            </li>
            <li>
                <div class="lyy_title fl">食物</div>
                {{dto.totalFood}}
                <div class="clear"></div>
            </li>
            <li>
                <div class="lyy_title fl">全部</div>
                {{dto.total}}
                <div class="clear"></div>
            </li>
            <li style="text-align: center">其他</li>
            <li v-for="(other,index) in dto.others">
                <div class="lyy_title fl" v-cloak>
                    {{other.other}}
                </div>
                <div class="fl" style="width: 33%;">
                    {{other.otherPrice}}
                </div>
                <div class="fr" style="width: 33%">
                    {{other.addDate}}
                </div>
                <div class="clear"></div>
            </li>
        </ul>
    </div>
</div>
<script>
    var vm = new Vue({
        el: "#contentDiv",
        data: {
            loading : true,
            dto: {
                month: $("#month").val(),
                flag: $("#flag").val(),
                others : []
            }
        },
        mounted: function () {
            this.getMonthDetail();
        },
        methods: {
            getMonthDetail : function() {
                var _this = this;
                var id = $("#id").val();
                var url = contextPath + "/accounts/monthDetail?month=" + _this.dto.month + "&flag=" +  _this.dto.flag;
                axios.post(url).then(function(response) {
                    var obj = response.data;
                    if (obj.status == "0000") {
                        _this.dto = obj.obj;
                    }
                    _this.loading = false;
                });
            },
            formatPrice2 : function(val) {
                if(val) {
                    if(typeof(val) == "string") {
                        return val.replace(/[^\d.]/g, '');
                    }else {
                        return val;
                    }
                }
                //return 0;
            },
            formatPrice : function(price) {
                if(price && Number(price)) {
                    return Number(price);
                }
                return 0;
            }
        },
        filters : {
            convertFlag : function(val) {
                if(val == "0") {
                    return "cjq";
                }
                return "wqx";
            }
        }
    });
</script>
</body>
</html>
