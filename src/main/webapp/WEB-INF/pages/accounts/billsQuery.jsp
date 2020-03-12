<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
      <title>查询页面</title>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
      <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
      <meta name="viewport" content="width=device-width, initial-scale=0.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />
      <%@include file="../main/publics.jsp"%>
      <style>
          .condition_left{width: 40%;display: inline-block;}
          .condition_right{width: 60%;}
      </style>
  </head>
  
  <body>
  <div id="contentDiv">
      <div class="lyy_header">
          <a class="btn_left" v-if="history" onclick="window.history.back();">
              <img src="${pageContext.request.contextPath}/Images/common/header_back.png">
          </a>
          <span>账单查询</span>

          <a class="btn_right" @click="showCondition"><img src="${pageContext.request.contextPath}/Images/common/header_screen.png"></a>
      </div>
      <div id="orderDiv" class="lyy_nav_box" @scroll="scrollQuery">
          <div v-if="noMore && billList.length == 0" v-cloak>
              <div class="lyy_noorder">暂无账单信息</div>
          </div>
          <template v-else>
          <div v-if="billList.length > 0" style="margin-top: -1px;">
              <div class="lyy_order" style="margin-top: 0px;position: fixed;" v-cloak>
                  <div class="lyy_order_top container">
                      <div class="title fl" style="width: 25%">
                          日期
                      </div>
                      <div class="food fl" style="color: #333;">
                          食物
                      </div>
                      <div class="money fl" style="color: #333;">当天总额</div>
                      <div class="paid fl" style="font-size: 1em;">人物</div>
                  </div>
              </div>
          </div>
          <div style="margin-top: 40px;">
              <div v-for="bill in billList" :key="bill.id" class="lyy_order" v-cloak>
                  <a @click="showOrderDetail(bill.id)">
                      <div class="lyy_order_top container">
                          <div class="title fl">
                              {{bill.addDate | dateTOString}}
                          </div>
                          <div class="food fl">
                              ￥{{bill.totalFood}}
                          </div>
                          <div class="money fl">￥{{bill.total}}</div>
                          <div class="paid fl">{{bill.flag | getFlagText}}</div>
                      </div>
                  </a>
              </div>
          </div>
          </template>
          <div class="ge20"></div>

          <div id='load_more' v-show="isLoading" v-cloak>
              <p style='text-align: center; line-height: 3em; vertical-align: middle;'>正在努力加载...</p>
          </div>
          <div id='has_more' v-show="!isLoading && !noMore" v-cloak>
              <p style='text-align: center;'>往上拉获取更多账单...</p>
          </div>
          <div id='no_more' v-show="noMore && billList.length != 0" v-cloak>
              <p class="time" style='text-align: center;'>已显示全部账单</p>
          </div>
          <div class="ge20"></div>
      </div>
      <div class="lyy_tourism_popup_bg" v-show="maskFlag"></div>

      <div class="lyy_tourism_popup_box" v-cloak v-show="filterFlag">
          <div class="lyy_tourism_popup_wrap">
              <div class="lyy_tourism_screen_popup">
                  <div class="top">
                      <div class="lyy_submit">
                          <span class="cancel" @click="closeCondition">取消</span>

                          <div>
                              查询条件
                              <span class="sure" style="right: inherit;" @click="resetCondition">清空</span>
                          </div>

                          <span class="sure" @click="conditionQuery">确定</span>
                      </div>
                  </div>

                  <div class="bottom">
                      <div class="bottom_right" v-cloak>
                          <ul>
                              <li>
                                  <div class="lyy_title fl" style="width: 40%">人物</div>
                                  <div class="lyy_input fl inline-block" style="width: 60%;">
                                      <div class="lyy_common_radio fl" style="top: 15px;">
                                          <input id="flag0" type="radio" v-model="flag" value="0"/>
                                          <label for="flag0"><span style="top: -15px;">cjq</span></label>
                                      </div>
                                      <div class="lyy_common_radio fl" style="top: 15px;">
                                          <input id="flag1" type="radio" v-model="flag" value="1"/>
                                          <label for="flag1"><span style="top: -15px;">wqx</span></label>
                                      </div>
                                  </div>
                                  <div class="clear"></div>
                              </li>
                              <li class="filter_departTime" @click="openStartDatePicker">
                                  <span class="condition_left">开始日期</span>
                                  <span class="condition_right text_left date_div">
                                      {{startDate}}
                                  </span>
                              </li>
                              <li class="filter_departTime" @click="openEndDatePicker">
                                  <span class="condition_left">结束日期</span>
                                  <span class="condition_right text_left date_div">
                                      {{endDate}}
                                  </span>
                              </li>
                              <li>
                                  <div class="lyy_title fl" style="width: 40%">关键字</div>
                                  <div class="lyy_input fl inline-block" style="width: 60%;">
                                    <input type="text" style="width: 100%;border: none;height: 38px;" v-model="keyWord">
                                  </div>
                              </li>
                          </ul>
                      </div>
                  </div>
              </div>
          </div>
      </div>
      <div class="lyy_plane_footer">
          <ul>
              <li @click="showCondition">
                  <div class="tab1"></div>筛选
              </li>
              <li @click="sortFood" v-show="foodSort == ''" v-cloak>
                  <div class="tab3"></div>食物
              </li>
              <li @click="sortFood" v-show="foodSort == 'asc'" style="color: #38a1db" v-cloak>
                  <div class="tab2_active"></div>食物低到高
              </li>
              <li @click="sortFood" v-show="foodSort == 'desc'" style="color: #38a1db" v-cloak>
                  <div class="tab2_active"></div>食物高到低
              </li>
              <li @click="sortTotal" v-show="totalSort == ''" v-cloak>
                  <div class="tab3"></div>总额
              </li>
              <li @click="sortTotal" v-show="totalSort == 'asc'" style="color: #38a1db" v-cloak>
                  <div class="tab3_active"></div>总额低到高
              </li>
              <li @click="sortTotal" v-show="totalSort == 'desc'" style="color: #38a1db" v-cloak>
                  <div class="tab3_active"></div>总额高到低
              </li>
          </ul>
      </div>
      <mt-datetime-picker
              ref="startDatePicker"
              type="date"
              v-model="startDate"
              :start-date="minDate"
              :end-date="currentDate"
              @confirm="selectStartDate">
      </mt-datetime-picker>
      <mt-datetime-picker
              ref="endDatePicker"
              type="date"
              v-model="endDate"
              :start-date="minDate"
              :end-date="currentDate"
              @confirm="selectEndDate">
      </mt-datetime-picker>
  </div>
  <script type="text/javascript">
      var vm = new Vue({
          el : "#contentDiv",
          data: {
              minDate : stringTODate("2014-01-01"),//最小日期
              currentDate : new Date(),//当前日期
              startDate: null,//开始日期
              endDate : null,//结束日期
              flag : "",//人物标识，0:cjq;1:wqx;
              pageSize: 20,//每页条数
              currentPage: 1,//当前第几页
              totalPage: 0,//总页数
              billList: [],//账单列表
              isLoading: false,
              noMore: false,
              filterFlag : false,
              maskFlag : false,
              foodSort : '',//食物排序
              totalSort : '',//总额排序
              keyWord : ''//搜索关键字
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
                  if(_this.startDate != '开始日期') {
                      dto.startDate = _this.startDate;
                  }
                  if(_this.startDate != '结束日期') {
                      dto.endDate = _this.endDate;
                  }
                  dto.flag = _this.flag;
                  dto.currentPage = _this.currentPage;
                  dto.pageSize = _this.pageSize;
                  dto.keyWord = _this.keyWord;
                  axios.post(contextPath + "/accounts/query",dto).then(function(response){
                      if(response.data.status == "0000") {
                          var pg = response.data.pg;
                          _this.billList = _this.billList.concat(pg.data);
                          _this.totalPage = pg.totalPage;
                          _this.currentPage = pg.currentPage;
                          _this.isLoading = false;
                          if(_this.totalPage < 2) {
                              _this.noMore = true;
                          }
                      }else {
                          myToast(response.data.message ? response.data.message : "查询失败，请稍后重试！",false);
                      }
                  }).catch(function (error) {
                      console.log(error);
                  });
              },
              showOrderDetail : function(id) {
                  //window.location.href = contextPath + "/accounts/getBillById?id="+id;
                  window.open(contextPath + "/accounts/getBillById?id="+id);
              },
              /**
               * 滚动分页查询
               */
              scrollQuery : function() {
                  var _this = this;
                  var scrollTop = $("#orderDiv").scrollTop();//div滚动条距离顶端的高度
                  var height = $("#orderDiv").height();//div高度
                  var scrollHeight = document.getElementById('orderDiv').scrollHeight;//div所有可滚动高度
                  if(scrollTop + height >= scrollHeight) {
                      if(_this.currentPage != _this.totalPage && _this.totalPage > 1) {
                          _this.currentPage++;
                          _this.orderQuery();
                      }else {
                          _this.noMore = true;
                      }
                  }
                  //console.log(scrollTop,scrollHeight,height,$(document.body).height());
              },
              resetCondition : function() {
                  vm.flag = "";
                  /*vm.startDate = vm.minDate;
                  vm.endDate = vm.currentDate;*/
                  vm.keyWord = "";
              },
              showCondition : function() {
                  vm.filterFlag = true;
                  vm.maskFlag = true;
              },
              closeCondition : function() {
                  vm.filterFlag = false;
                  vm.maskFlag = false;
              },
              conditionQuery : function() {
                  vm.closeCondition();
                  vm.noMore = false;
                  vm.currentPage = 1;
                  vm.totalPage = 0;
                  vm.billList = [];
                  vm.orderQuery();
              },
              openStartDatePicker : function() {
                  this.$refs.startDatePicker.open();
              },
              selectStartDate : function(date) {
                  this.startDate = dateTOString(date);
              },
              openEndDatePicker : function() {
                  this.$refs.endDatePicker.open();
              },
              selectEndDate : function(date) {
                  this.endDate = dateTOString(date);
              },
              showFilter : function() {

              },
              sortFood : function() {
                  vm.totalSort = "";
                  if(vm.foodSort !="asc") {
                      vm.billList.sort(vm.sortFoodAsc);
                      vm.foodSort = "asc";
                  }else {
                      vm.billList.sort(vm.sortFoodDesc);
                      vm.foodSort = "desc";
                  }
              },
              sortTotal : function() {
                  vm.foodSort = "";
                  if(vm.totalSort !="asc") {
                      vm.billList.sort(vm.sortTotalAsc);
                      vm.totalSort = "asc";
                  }else {
                      vm.billList.sort(vm.sortTotalDesc);
                      vm.totalSort = "desc";
                  }
              },
              sortFoodAsc : function(a,b) {
                  return a.totalFood - b.totalFood;
              },
              sortFoodDesc : function(a, b) {
                  return b.totalFood - a.totalFood;
              },
              sortTotalAsc : function(a,b) {
                  return a.total - b.total;
              },
              sortTotalDesc : function(a, b) {
                  return b.total - a.total;
              }
          }
      });

      function sortFoodAsc(a,b) {
          return a.totalFood - b.totalFood;
      }
      function sortFoodDesc(a, b) {
          return b.totalFood - a.totalFood;
      }
      function sortTotalAsc(a,b) {
          return a.total - b.total;
      }
      function sortTotalDesc(a, b) {
          return b.total - a.total;
      }
  </script>
  </body>
</html>
