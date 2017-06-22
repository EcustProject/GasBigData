/**
 * Created by huchao on 2017/6/21.
 */
(function ($) {
    var search = function (condition) {
        var search_condition = {
            "year": condition
        };
        var json_str = JSON.stringify(search_condition);
        var showChart = function (year, res) {
            console.log(res[0]);
            var data_k = [];
            var data_v = [];
            $.each(res[0], function (i, d) {
                data_k.push(d['day']);
                data_v.push(d['huawu_count']);

            });
            chart_national.setOption({
                title: {
                    text: year + '国庆节话务量分布'
                },
                series: {data: data_v}
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