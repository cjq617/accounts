var pattern = /^\d+(\.\d+)?$/;//验证非负浮点数

$(document).ready(function(){
    /*$(document).on("keypress", "input.priceOnly", function (event) {
        if(!pattern.test(this.value)) {
            myAlert("输入格式不正确，必须为数字！");
            return false;
        }
    });*/

    /*$(document).on("blur", "input.priceOnly", function (event) {
        this.value = this.value.replace(/[^\d.]/g, "");
    });*/
});

/**
 * 判断浏览器是否是ie
 * @returns {boolean}
 */
function isIe() {
    return /msie/.test(navigator.userAgent.toLowerCase());
}

//判断访问终端
var browser={
    versions:function(){
        var u = navigator.userAgent, app = navigator.appVersion;
        return {
            trident: u.indexOf('Trident') > -1, //IE内核
            presto: u.indexOf('Presto') > -1, //opera内核
            webKit: u.indexOf('AppleWebKit') > -1, //苹果、谷歌内核
            gecko: u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1,//火狐内核
            mobile: !!u.match(/AppleWebKit.*Mobile.*/), //是否为移动终端
            ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), //ios终端
            android: u.indexOf('Android') > -1 || u.indexOf('Adr') > -1, //android终端
            iPhone: u.indexOf('iPhone') > -1 , //是否为iPhone或者QQHD浏览器
            iPad: u.indexOf('iPad') > -1, //是否iPad
            webApp: u.indexOf('Safari') == -1, //是否web应该程序，没有头部与底部
            weixin: u.indexOf('MicroMessenger') > -1, //是否微信 （2015-01-22新增）
            qq: u.match(/\sQQ/i) == " qq" //是否QQ
        };
    }(),
    language:(navigator.browserLanguage || navigator.language).toLowerCase()
};

String.prototype.trim = function () {
    var str = this;
    str = str.replace(/^\s+/, '');
    for (var i = str.length - 1; i >= 0; i--) {
        if (/\S/.test(str.charAt(i))) {
            str = str.substring(0, i + 1);
            break;
        }
    }
    return str;
};

String.prototype.startWidth = function(str) {
    var reg=new RegExp("^"+str);
    return reg.test(this);
};

String.prototype.endWith = function(str){
    var reg=new RegExp(str+"$");
    return reg.test(this);
};

function myAlert(msg, callback) {
    $(document).dialog({
        titleShow: false,
        content: msg,
        onClosed: function () {
            if (callback) {
                callback();
            }
        }
    });
}

function myConfirm(msg, confirmCallback, cancelCallback) {
    $(document).dialog({
        type : 'confirm',
        titleShow: false,
        closeBtnShow: true,
        content: msg,
        onClickConfirmBtn: confirmCallback,
        onClickCancelBtn : function(){
            if (cancelCallback) {
                cancelCallback();
            }
        }/*,
         onClosed: function(){
         if (cancelCallback) {
         cancelCallback();
         } else {
         hideMask();
         }
         }*/
    });
}

/**
 * 弹出toast
 * @param msg       提示信息
 * @param callback  回调函数，可以留空
 * @param isSuccess true/false，成功标志，不传默认成功
 */
function myToast(msg, callback, isSuccess) {
    if (!$.isFunction(callback)) {
        isSuccess = callback;
    }
    var icon = contextPath + "/Images/dialog-icon/success.png";
    if (isSuccess === false) {
        icon = contextPath + "/Images/dialog-icon/fail.png";
    }
    $(document).dialog({
        type: 'toast',
        infoIcon: icon,
        infoText: msg,
        autoClose: 2000,
        onClosed: function () {
            if (callback) {
                callback();
            }
        }
    });
}

/**
 * 弹出带遮罩的loading, 可传一个参数--提示信息
 * @returns 返回dialog对象用于关闭
 */
function myLoading() {
    var msg = arguments[0];
    var loading = $(document).dialog({
        type: 'toast',
        infoIcon: contextPath + '/Images/dialog-icon/loading.gif',
        infoText: msg ? msg : '正在加载中'
    });

    var dialog_list = $(document).data("dialog_list");
    dialog_list || (dialog_list = []);
    dialog_list.push(loading);
    $(document).data("dialog_list", dialog_list);
    return loading;
}

/**
 * 关闭所有的loading
 */
function closeLoading() {
    var dialog_list = $(document).data("dialog_list");
    if (dialog_list) {
        for (var i = 0; i < dialog_list.length; i++) {
            dialog_list[i].close();
        }
    }
}

/**
 * 数组中是否包含str
 * @param array
 * @param str
 * @returns {boolean}
 */
function containsStr(array,str) {
    if(array != null) {
        for(var i=0;i<array.length;i++) {
            if(array[i] == str) {
                return true;
            }
        }
    }
    return false;
}
/**
 * 数组中是否包含str中的一项,通过','分割
 * @param array
 * @param strArr
 * @returns {boolean}
 */
function containsStrArr(array,strArr) {
    if(array != null) {
        for(var i=0;i<array.length;i++) {
            var strs = strArr.split(",");
            for(var j=0;j<strs.length;j++) {
                if(array[i] == strs[j]) {
                    return true;
                }
            }
        }
    }
    return false;
}

if (typeof Vue != "undefined") {
    Vue.filter('getFlagText', function (flag) {
        switch (flag) {
            case "0" :
                return "cjq";;
            case "1" :
                return "wqx";
        }
        return "";
    });
    Vue.filter('dateTOString', function (date) {
        if(date instanceof Date) {
            return dateTOString(date);
        }else {
            return dateTOString(new Date(date));
        }
    });
}