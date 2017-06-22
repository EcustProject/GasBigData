<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8" />
  <title>上海燃气数据分析</title>
  <link rel="shortcut icon" href="/resources/images/logo.ico" />
  <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css" />
  <link rel="stylesheet" href="/resources/css/amazeui.css" />
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="/resources/css/core.css" />
  <link rel="stylesheet" href="/resources/css/menu.css" />
  <link rel="stylesheet" href="/resources/css/core.css" />
  <link rel="stylesheet" href="/resources/css/menu.css" />
  <link rel="stylesheet" href="/resources/css/index.css" />
  <link rel="stylesheet" href="/resources/css/admin.css" />
  <link rel="stylesheet" href="/resources/css/page/typography.css" />
  <link rel="stylesheet" href="/resources/css/page/form.css" />
  <link rel="stylesheet" href="/resources/css/component.css" />
    <title>首页</title>
</head>
<body>
<!-- Begin page -->
<header class="am-topbar am-topbar-fixed-top">
    <div class="am-topbar-left am-hide-sm-only">
        <a href="index.html" class="logo"><span>上海燃气</span><i class="zmdi zmdi-layers"></i></a>
    </div>

    <div class="contain">
        <ul class="am-nav am-navbar-nav am-navbar-left">
            <li><h4 class="page-title">基本表格</h4></li>
        </ul>
        <ul class="am-nav am-navbar-nav am-navbar-right">
            <li class="inform"><i class="am-icon-bell-o" aria-hidden="true"></i></li>
            <li class="hidden-xs am-hide-sm-only">
                <form role="search" class="app-search">
                    <input type="text" placeholder="Search..." class="form-control">
                    <a href=""><img src="/resources/images/search.svg"></a>
                </form>
            </li>
        </ul>
    </div>
</header>
<!-- end page -->
<div class="admin">
  <div class="admin-sidebar am-offcanvas  am-padding-0" id="admin-offcanvas">
    <div class="am-offcanvas-bar admin-offcanvas-bar">
      <!-- User -->
      <div class="user-box am-hide-sm-only">
        <div class="user-img">
          <img src="/resources/images/avatar-1.jpg" alt="user-img" title="Mat Helme" class="img-circle img-thumbnail img-responsive">
          <div class="user-status offline"><i class="am-icon-dot-circle-o" aria-hidden="true"></i></div>
        </div>
        <h5><a href="#">Mat Helme</a> </h5>
        <ul class="list-inline">
          <li>
            <a href="#">
              <i class="fa fa-cog" aria-hidden="true"></i>
            </a>
          </li>

          <li>
            <a href="#" class="text-custom">
              <i class="fa fa-cog" aria-hidden="true"></i>
            </a>
          </li>
        </ul>
      </div>
      <!-- End User -->

        <ul class="am-list admin-sidebar-list">
            <li><a href="index.html"><span class="am-icon-home"></span> 首页</a></li>
            <li class="admin-parent">
                <a class="am-cf" data-am-collapse="{target: '#collapse-nav1'}"><span class="am-icon-table"></span>话务分析 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav1">
                    <li><a href="/resources/html/audio.html" class="am-cf"> 音频分析</a></li>
                    <li><a href="/resources/html/sentiment.html">情感分析</a></li>
                </ul>
            </li>
            <li class="admin-parent">
                <a class="am-cf" data-am-collapse="{target: '#collapse-nav2'}"><i class="am-icon-line-chart" aria-hidden="true"></i> 报修预测分析 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav2">
                    <li><a href="/resources/html/problem.html" class="am-cf"> 报修问题</a></li>
                    <li><a href="/resources/html/security.html" class="am-cf"> 安全检查</a></li>
                </ul>
            </li>
            <li><a href="/resources/html/phone.html"><span class="am-icon-phone"></span> 电话黑名单</a></li>
        </ul>
    </div>
  </div>
  <div class="content-page">
    <!-- Start content -->
      <div class="content" id="main" style="width:70%;height:900px;margin-top: 15px;margin-left: 7px;border: 1px solid #00efe0;float: left;">

      </div>
      <div class="data_analysis" id="home_data" style="width:28%;height: 280px;;margin-top: 15px;border: 1px solid #00efe0;margin-left: 10px;;float: left;">
      </div>
  </div>
  <!-- end right Content here -->
  <!--</div>-->
</div>
</div>
<!-- navbar -->
<a href="admin-offcanvas" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"><!--<i class="fa fa-bars" aria-hidden="true"></i>--></a>
<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=394d79f665d50334b7abf3ce795d0216"></script>
<script type="text/javascript" src="/resources/js/jquery-1.9.1.js" ></script>
<script type="text/javascript" src="//webapi.amap.com/ui/1.0/main.js"></script>
<script type="text/javascript" src="/resources/js/amazeui.min.js"></script>
<script type="text/javascript" src="/resources/js/blockUI.js" ></script>
<script type="text/javascript" src="/resources/js/charts/echarts.min.js" ></script>
<script type="text/javascript" src="/resources/js/charts/indexChart.js" ></script>
<script type="text/javascript" src="/resources/js/home/home.js" ></script>
</body>
<script>
    var map = new AMap.Map('main', {
        mapStyle: 'amap://styles/d2d2451cea03ef02c00392f25011bfd3'
    });
    AMapUI.load(['ui/misc/PointSimplifier', 'lib/$'], function(PointSimplifier, $) {
        map.setCity("上海市");
        var pointSimplifierIns = new PointSimplifier({
            map: map, //所属的地图实例
            getPosition: function(item) {
                if(!item) {
                    return null;
                }
                //返回经纬度
                return item
            },
            getHoverTitle: function(dataItem) {
                //返回数据项的Title信息，鼠标hover时显示
                return dataItem;
            },
            renderOptions: {
                //点的样式
                pointStyle: {
                    width: 8,
                    height: 8
                },
                //鼠标hover时的title信息
                hoverTitleStyle: {
                    position: 'top'
                }
            }
        });
        $.get('/resources/js/charts/coordinate.json', function(geo) {
            var res = [];
            for(var k in geo) {
                var geoCoord = geo[k];
                if(geoCoord) {
                    res.push(geoCoord);
                }
            }
            pointSimplifierIns.setData(res);
        });
    });
</script>
</html>
