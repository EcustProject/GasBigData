地暖用户 接口规格
=============

[TOC]

## 1.上海市某年某区域1-12月份用气量


* __Method__
GET

* __URL__
/heating/area_month_usage

* __Request__

Param | Type | Description
- | - | -
area | String | 上海市 嘉定区 宝山区 崇明县 普陀区 杨浦区 浦东新区  虹口区 金山区 静安北
year | String | 2001-2016

* __举例__
```
http://localhost:8080/heating/area_month_usage?area=上海市&year=2014
```

* __Response__

```
[
    {
        "month": "01",
        "usage": 12321321
    },
    {
        "month": "02",
        "usage": 123213
    }
    ...
]
```

## 2.上海市某年各个区域年用气量


* __Method__
GET

* __URL__
/heating/area_year_usage

* __Request__

Param | Type | Description
- | - | -
year | String | 2001-2016

* __举例__
```
http://localhost:8080/heating/area_year_usage?year=2014
```

* __Response__
```
[
    {
        "area": "嘉定区",
        "usage": 1111
    }
    ...
]
```

## 3.上海市某年各个区域11月到下年3月用气量


* __Method__
GET

* __URL__
/heating/area_11_3_usage

* __Request__

Param | Type | Description
- | - | -
year | String | 2001-2016

* __举例__
```
http://localhost:8080/heating/area_11_3_usage?year=2014
```
* __Response__
```
[
    {
        "area": "嘉定区",
        "usage": 2222
    }
    ...
]
```

## 4.某年各个区域年用气量介于[low.high)的人数


* __Method__
GET

* __URL__
/heating/area_year_range_user_count

* __Request__

Param | Type | Description
- | - | -
year | String | 2001-2016
low | int |
high | int |

* __举例__
```
http://localhost:8080/heating/area_year_range_user_count?year=2014&low=0&high=200
```
* __Response__
```
[
    {
        "area": "嘉定区",
        "count": 2
    }
    ...
]
```

## 5.某年各个区域11-3月份用气量介于[low.high)的人数


* __Method__
GET

* __URL__
/heating/area_11_3_range_user_count

* __Request__

Param | Type | Description
- | - | -
year | String | 2001-2016
low | int |
high | int |

* __举例__
```
http://localhost:8080/heating/area_11_3_range_user_count?year=2014&low=0&high=200
```
* __Response__
```
[
    {
        "area": "嘉定区",
        "count": 1
    }
    ...
]
```

## 6.上海市某年年用气量人数分布


* __Method__
GET

* __URL__
/heating/city_year_usage_range_count

* __Request__

Param | Type | Description
- | - | -
year | String | 2001-2016

* __举例__
```
http://localhost:8080/heating/city_year_usage_range_count?year=2014
```
* __Response__
```
[
    {
        "0-200": 111
    },
    {
        "200-400": 222
    }
    ...
]
```

## 7.上海市某年11-3月份用气量人数分布


* __Method__
GET

* __URL__
/heating/city_11_3_range_user_count

* __Request__

Param | Type | Description
- | - | -
year | String | 2001-2016

* __举例__
```
http://localhost:8080/heating/city_11_3_range_user_count?year=2014
```
* __Response__
```
[
    {
        "0-200": 222
    },
    {
        "200-400": 333
    }
    ...
]
```

## 8.上海市某年用气量人数分布


* __Method__
GET

* __URL__
/heating/user_year_usage

* __Request__

Param | Type | Description
- | - | -
year | String | 2001-2016

* __举例__
```
http://localhost:8080/heating/user_year_usage?year=2014
```
* __Response__
```
[
    {
        "count": 1321,
        "usage": 0
    },
    {
        "count": 213,
        "usage": 1
    },
    {
        "count": 324,
        "usage": 2
    },
    ...
]
```