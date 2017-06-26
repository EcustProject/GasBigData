地暖用户 接口规格
=============

[TOC]

##＃ 1.地暖用户用气量1-12份数据


* __Method__
GET

* __URL__
/heating/area_month_usage

* __Request__

Param | Type | Description
- | - | -
area | String | 上海市/虹口区等
year | String | 2011-2016

> area 上海市 嘉定区 宝山区 崇明县 普陀区 杨浦区 浦东新区  虹口区 金山区 静安北

举例
```
http://localhost:8080/heating/area_month_usage?area=上海市&year=2014
```

* __Response__

```
[
    {
        "month": "01",
        "usage": 3534708
    },
    {
        "month": "02",
        "usage": 3796623
    },
    {
        "month": "03",
        "usage": 4681806
    },
    {
        "month": "04",
        "usage": 2927337
    },
    {
        "month": "05",
        "usage": 2208033
    },
    {
        "month": "06",
        "usage": 1219008
    },
    {
        "month": "07",
        "usage": 1307700
    },
    {
        "month": "08",
        "usage": 869297
    },
    {
        "month": "09",
        "usage": 1118105
    },
    {
        "month": "10",
        "usage": 800754
    },
    {
        "month": "11",
        "usage": 1217204
    },
    {
        "month": "12",
        "usage": 1817306
    }
]
```