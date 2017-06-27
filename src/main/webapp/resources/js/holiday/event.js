/**
 * Created by huchao on 2017/6/21.
 */
(function ($) {
    var search = function (condition) {
        var newYear_begin = condition+'-'+MyWeb().Year[condition][0];
        var newYear_end = condition+'-'+MyWeb().Year[condition][6];
        var search_condition = {
            "year": condition,
            "begin":newYear_begin,
            "end":newYear_end
        };
        var json_str = JSON.stringify(search_condition);
        var showChart = function (year, res) {
            console.log(res[0]);
            var data_v1 = [];
            var data_v2 = [];
            $.each(res[0], function (i, d) {
                data_v1.push(d['huawu_count']);
            });
            $.each(res[1], function (i, d) {
                data_v2.push(d['huawu_count']);
            });
            Year_index1.setOption({
                title: {
                    text: year + '年春节话务量分布'
                },
                xAxis: {data:MyWeb().Year[condition]},
                series: {data: data_v1}
            });
            Year_index2.setOption({
                title: {
                    text: year + '年春节话务时间段分布'
                },
                series: {data: data_v2}
            });
        };
        $.ajax({
            type: "post",
            async: true,
            url: "/holiday",
            contentType: 'application/json;charset=utf-8',
            data: json_str,
            success: function (result) {
                showChart(condition, result);
            }
        })
    };
    $("#listern_condition").click(function () {
        var year = $('#search_conditon').val();
        search(year);
    });
})($);