<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
    <title>记账页面</title>
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
		  <span>账单添加</span>
		  <a class="btn_right" v-if="history" href="${pageContext.request.contextPath}">
			  <img src="${pageContext.request.contextPath}/Images/common/header_index.png">
		  </a>
	  </div>
	  <div class="lyy_nonav_box" style="bottom: 75px;">
		  <ul class="lyy_common_name">
			  <li>
				  <div class="lyy_title fl">人物</div>
				  <div class="lyy_input fl inline-block">
					  <div class="lyy_common_radio fl">
						  <input id="flag0" type="radio" v-model="dto.flag" value="0"/>
						  <label for="flag0"><span>cjq</span></label>
					  </div>
					  <div class="lyy_common_radio fl">
						  <input id="flag1" type="radio" v-model="dto.flag" value="1"/>
						  <label for="flag1"><span>wqx</span></label>
					  </div>
				  </div>
				  <div class="clear"></div>
			  </li>
			  <li>
				  <div class="lyy_title fl">日期</div>
				  <input id="addDate" type="date" class="lyy_input transparent" v-model="dto.addDate"
						 placeholder="记账日期" maxlength="10"/>
				  <i></i>
				  <div class="clear"></div>
			  </li>
			  <li>
				  <div class="lyy_title fl">早餐</div>
				  <input class="lyy_input fl priceOnly" type="text" v-model="dto.breakfast" maxlength="24"/>
				  <div class="clear"></div>
			  </li>
			  <li>
				  <div class="lyy_title fl">午餐</div>
				  <input class="lyy_input fl priceOnly" type="text" v-model="dto.lunch" maxlength="24"/>
				  <div class="clear"></div>
			  </li>
			  <li>
				  <div class="lyy_title fl">晚餐</div>
				  <input class="lyy_input fl" type="text" v-model="dto.supper" maxlength="24"/>
				  <div class="clear"></div>
			  </li>
			  <%--<li>
				  <div class="lyy_title fl">鸡蛋</div>
				  <input class="lyy_input fl priceOnly" type="text" v-model="dto.egg" maxlength="24"/>
				  <div class="clear"></div>
			  </li>--%>
			  <li>
				  <div class="lyy_title fl">水果</div>
				  <input class="lyy_input fl priceOnly" type="text" v-model="dto.fruit" maxlength="24"/>
				  <div class="clear"></div>
			  </li>
			  <li>
				  <div class="lyy_title fl">水/饮料</div>
				  <input class="lyy_input fl priceOnly" type="text" v-model="dto.drink" maxlength="24"/>
				  <div class="clear"></div>
			  </li>
			  <%--<li>
				  <div class="lyy_title fl">买菜</div>
				  <input class="lyy_input fl priceOnly" type="text" v-model="dto.food" maxlength="24"/>
				  <div class="clear"></div>
			  </li>
			  <li>
				  <div class="lyy_title fl">买米</div>
				  <input class="lyy_input fl priceOnly" type="text" v-model="dto.rice" maxlength="24"/>
				  <div class="clear"></div>
			  </li>--%>
			  <li>
				  <div class="lyy_title fl">面包/剁</div>
				  <input class="lyy_input fl priceOnly" type="text" v-model="dto.cake" maxlength="24"/>
				  <div class="clear"></div>
			  </li>
			  <li>
				  <div class="lyy_title fl">超市</div>
				  <input class="lyy_input fl priceOnly" type="text" v-model="dto.supermarket" maxlength="24"/>
				  <div class="clear"></div>
			  </li>
			  <li>
				  <div class="lyy_title fl">交通</div>
				  <input class="lyy_input fl priceOnly" type="text" v-model="dto.traffic" maxlength="24"/>
				  <div class="clear"></div>
			  </li>
			  <%--<li>
				  <div class="lyy_title fl">配料</div>
				  <input class="lyy_input fl priceOnly" type="text" v-model="dto.soy" maxlength="24"/>
				  <div class="clear"></div>
			  </li>--%>
			  <li>
				  <div class="lyy_title fl">煤气</div>
				  <input class="lyy_input fl priceOnly" type="text" v-model="dto.gass" maxlength="24"/>
				  <div class="clear"></div>
			  </li>
			  <li>
				  <div class="lyy_title fl">话费</div>
				  <input class="lyy_input fl priceOnly" type="text" v-model="dto.phone" maxlength="24"/>
				  <div class="clear"></div>
			  </li>
			  <li>
				  <div class="lyy_title fl">房租</div>
				  <input class="lyy_input fl priceOnly" type="text" v-model="dto.rent" maxlength="24"/>
				  <div class="clear"></div>
			  </li>
			  <li>
				  <div class="lyy_title fl">踢球</div>
				  <input class="lyy_input fl priceOnly" type="text" v-model="dto.football" maxlength="24"/>
				  <div class="clear"></div>
			  </li>
			  <li v-for="(other,index) in dto.otherAccountsList">
				  <div class="lyy_title fl" v-cloak>
					  <input class="lyy_input fl" style="width: 160px" type="text" v-model="other.other" placeholder="请输入内容"/>
				  </div>
				  <div class="fr">
					  <input class="lyy_input fl" style="width: 160px" type="text" v-model="other.otherPrice" maxlength="24" placeholder="请输入金额"/>
					  <a @click="delOther(index)">删除</a>
				  </div>
				  <div class="clear"></div>
			  </li>
			  <li @click="addOther();">
				  <div class="lyy_title fl">其他</div>
				  <div class="fr">
					  <img src="${pageContext.request.contextPath}/Images/common/common_newly.png" style="width: 16px;"/>
				  </div>
				  <div class="clear"></div>
			  </li>
		  </ul>
	  </div>
	  <div class="lyy_footer container">
		  <p class="fl">当天伙食<span v-cloak>￥{{foodSum}}</span></p>

		  <a class="btn lyy_plane_btn lyy_visa_book fr" @click="save()" >保存</a>

		  <b class="fr">总金额<span v-cloak>￥{{total}}</span></b>
	  </div>
  </div>
  <script>
      var vm = new Vue({
          el: "#contentDiv",
          data: {
              dto: {
                  flag : '0',
				  addDate : dateTOString(new Date()),
                  otherAccountsList : []
			  }
          },
		  watch : {
              'dto.breakfast' : function (val,oldVal) {
                  this.dto.breakfast = vm.formatPrice2(val);
              },
              'dto.lunch' : function (val,oldVal) {
                  this.dto.lunch = vm.formatPrice2(val);
			  },
              'dto.supper' : function (val,oldVal) {
                  this.dto.supper = vm.formatPrice2(val);
              },
              'dto.fruit' : function (val,oldVal) {
                  this.dto.fruit = vm.formatPrice2(val);
              },
              'dto.drink' : function (val,oldVal) {
                  this.dto.drink = vm.formatPrice2(val);
              },
              'dto.cake' : function (val,oldVal) {
                  this.dto.cake = vm.formatPrice2(val);
              },
              'dto.supermarket' : function (val,oldVal) {
                  this.dto.supermarket = vm.formatPrice2(val);
              },
              'dto.traffic' : function (val,oldVal) {
                  this.dto.traffic = vm.formatPrice2(val);
              },
              'dto.gass' : function (val,oldVal) {
                  this.dto.gass = vm.formatPrice2(val);
              },
              'dto.phone' : function (val,oldVal) {
                  this.dto.phone = vm.formatPrice2(val);
              },
              'dto.rent' : function (val,oldVal) {
                  this.dto.rent = vm.formatPrice2(val);
              },
              'dto.football' : function (val,oldVal) {
                  this.dto.football = vm.formatPrice2(val);
              }
		  },
		  computed: {
              foodSum : function() {
                  var dto = this.dto;
                  dto.totalFood = this.formatPrice(dto.breakfast) + this.formatPrice(dto.lunch) + this.formatPrice(dto.supper);
                  return dto.totalFood;
			  },
              total : function() {
                  var dto = this.dto;
                  dto.total = this.formatPrice(dto.breakfast) + this.formatPrice(dto.lunch) + this.formatPrice(dto.supper)
				  		+ this.formatPrice(dto.fruit) + this.formatPrice(dto.drink) + this.formatPrice(dto.cake)
                  		+ this.formatPrice(dto.supermarket) + this.formatPrice(dto.traffic) + this.formatPrice(dto.gass)
				  		+ this.formatPrice(dto.phone) + this.formatPrice(dto.rent) + this.formatPrice(dto.football);
                  for(var i=0;i<dto.otherAccountsList.length;i++) {
                      dto.otherAccountsList[i].otherPrice = vm.formatPrice2(dto.otherAccountsList[i].otherPrice);
                      dto.total += this.formatPrice(dto.otherAccountsList[i].otherPrice);
				  }
                  return dto.total;
              }
		  },
          mounted: function () {

          },
          methods: {
              formatPrice2 : function(val) {
                  if(val) {
                      return val.replace(/[^\d.]/g, '');
				  }
				  //return "";
			  },
              formatPrice : function(price) {
                  if(price && Number(price)) {
                      return Number(price);
				  }
				  return 0;
              },
              addOther : function() {
                  var other = {};
                  other.other = '';
                  other.otherPrice = 0;
                  if(!vm.dto.otherAccountsList) {
                      vm.dto.otherAccountsList = [];
				  }
                  vm.dto.otherAccountsList.push(other);
			  },
              delOther : function(index) {
                  vm.dto.otherAccountsList.splice(index,1);
              },
			  save : function() {
                  myConfirm("确定要保存？",function(){
                      var dialog = myLoading();
                      var url = contextPath + "/accounts/add";
                      axios.post(url,vm.dto).then(function(response) {
                          var obj = response.data;
                          if (obj.status == "0000") {
                              myAlert("添加成功！",function(){
                                  window.location.href = contextPath + "/accounts/getBillById?id=" + obj.message;
							  });
                          }else if(obj.status == "7000"){
                              myAlert("添加失败，已存在" + vm.dto.addDate + "当天" + vm.convertFlag(vm.dto.flag) + "的记录!");
                          }else {
                              myAlert(obj.message ? obj.message : "添加失败！");
                          }
                          dialog.close();
                      });
				  });
			  },
			  convertFlag : function(val) {
                  if(val == "0") {
                      return "cjq";
				  }
				  return "wqx";
			  }
		  },
          /**
		   * 自定义组件
           */
		  directives: {
              numberOnly: {
                  bind: function(el) {
                      el.handler = function() {
                          el.value = el.value.replace(/[^\d.]/g, '');
                      };
                      el.addEventListener('input', el.handler);
                  },
                  unbind: function(el) {
                      el.removeEventListener('input', el.handler);
                  }
              }
          }
      });
  </script>
  </body>
</html>
