<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="./css/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="./css/icon.css">
    <link rel="stylesheet" type="text/css" href="./css/demo.css">
    <script type="text/javascript" src="./js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="./js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="./js/my97/WdatePicker.js"></script>
	<script type="text/javascript">
		//通过月份查出当月的每天消费信息
		function query() {
			$.ajax({
				url: "<%=path%>/calculate/calculate_settleQuery.action",
				dataType: "html",
				type: "post",
				data: $("#form1").serialize(),
				success: function(msg) {
					$("#tt").datagrid('loadData',eval("(" + msg + ")"));
				}
			});
		}
		
		//保存月结信息
		function saveMonth() {
			$.ajax({
				url: "<%=path%>/calculate/calculate_saveMonth.action",
				dataType: "html",
				type: "post",
				data: "jsonData=" + $("#jsonData").val() + "&settleDto.year=" + $("#year").val() + "&settleDto.month=" + $("#month").val(),
				success: function(msg) {
					if(msg == "0") {
						alert("保存成功！");
					} else if(msg == "2") {
						alert("该月月结记录已经存在！");
					} else {
						alert("保存失败！");
					}
				}
			});
		}
	</script>
  </head>
  
  <body>
 	<div class="easyui-panel" title="月结账单" data-options="border:false">
  	<form action="" id="form1">
		<select name="settleDto.year" id="year">
			<option value="2014">2014</option>
			<option value="2015">2015</option>
			<option value="2016" selected="selected">2016</option>
			<option value="2017">2017</option>
			<option value="2018">2018</option>
			<option value="2019">2019</option>
			<option value="2020">2020</option>
		</select>
		年
		<select name="settleDto.month" id="month">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
			<option value="10">10</option>
			<option value="11">11</option>
			<option value="12">12</option>
		</select>
		月
		<span style="position: absolute;OVERFLOW: auto; CURSOR: default;right: 100px;">
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-search'" onclick="query();">查询</a>
  		</span>
  	</form>
  	</div>
  	<div id="listDiv" style="display: none"></div>
  	<table id="tt" class="easyui-datagrid" style="width:1000px;height:500px" title="账单列表"
            data-options="rownumbers:true,singleSelect:true,toolbar:toolbar,pagination:true,fit:true,border:false">
        <thead>
            <tr>
                <th field="flag" width="30" align="right">人物</th>
                <th field="addDate" width="80" align="right">日期</th>
                <th field="breakfast" width="40" align="right">早餐</th>
                <th field="lunch" width="40" align="right">午餐</th>
                <th field="supper" width="40" align="right">晚餐</th>
                <th field="egg" width="40" align="right">鸡蛋</th>
                <th field="fruit" width="40" align="right">水果</th>
                <th field="drink" width="50" align="right">水/饮料</th>
                <th field="food" width="40" align="right">买菜</th>
                <th field="rice" width="40" align="right">买米</th>
                <th field="cake" width="50" align="right">面包/剁</th>
                <th field="supermarket" width="40" align="right">超市</th>
                <th field="traffic" width="40" align="right">交通</th>
                <th field="soy" width="40" align="right">配料</th>
                <th field="gass" width="40" align="right">煤气</th>
                <th field="phone" width="40" align="right">话费</th>
                <th field="rent" width="40" align="right">房租</th>
                <th field="football" width="40" align="right">踢球</th>
                <th field="foodSum" width="55" align="right">当天伙食</th>
                <th field="total" width="55" align="right">当天总额</th>
                <th field="needSum" width="50" align="right">需月结</th>
            </tr>
        </thead>
    </table>
    
    <script type="text/javascript">
		var toolbar = [{
			text:'月结',
            iconCls:'icon-ok',
            handler:function(){
            	$.ajax({
					url: "<%=path%>/calculate/calculate_settle.action",
					dataType: "html",
					type: "post",
					data: $("#form1").serialize(),
					success: function(msg) {
						$("#jsonData").val(msg);
						$('#w').window('open');
						$("#tt2").datagrid('loadData',eval("(" + msg + ")"));
					}
				});
            }
        }];
        
        function changeP(){
            var dg = $('#tt');
            dg.datagrid('loadData',[]);
            dg.datagrid({pagePosition:$('#p-pos').val()});
            dg.datagrid('getPager').pagination({
                layout:['list','sep','first','prev','sep',$('#p-style').val(),'sep','next','last','sep','refresh']
            });
        }
    </script>
    
    <div id="w" class="easyui-window" title="月结账单" data-options="modal:true,closed:true,tools:'#tools'" style="width:434px;height:150px;">
    	<input type="hidden" name="jsonData" id="jsonData"/>
    	<div id="tools">
	        <a href="javascript:void(0)" class="icon-save" onclick="saveMonth()"></a>
	    </div>
    	<table id="tt2" class="easyui-datagrid" style="width:420px;height:78px;"
            data-options="singleSelect:true">
        	<thead>
	            <tr>
	                <th field="flag" width="50" align="right">人物</th>
	    			<th field="month_date" width="50" align="right">月份</th>
	    			<th field="food_sum" width="50" align="right">伙食</th>
	    			<th field="need_sum" width="50" align="right">需月结</th>
	    			<th field="before_sum" width="70" align="right">结帐前总额</th>
	    			<th field="after_sum" width="70" align="right">结账后总额</th>
	    			<th field="wqx_to_cjq" width="70" align="right">wqx给cjq</th>
	    		</tr>
	    	</thead>
    	</table>
    	<div align="center">
    		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="saveMonth()">保存</a>
    	</div>
    </div>
  </body>
</html>
