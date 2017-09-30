(function(){

    var problem_type = echarts.init(document.getElementById("problem_type"));
    var option = {
        title : {
            text: '燃气报修问题分布图',
            x:'center',
            textStyle:{
                color:['#3398db']
            }
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ["一般维修", "其他问题","抄表问题","校表问题","漏气","连接管"],
            textStyle:{
                color:['#61a0a8']
            }
        },
        series : [
            {
                name: '访问来源',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    problem_type.setOption(option);

    var district_problem = echarts.init(document.getElementById("district_problem"));
    option = {
        title : {
            text: "上海各区的报修问题统计",
            x:'center',
            textStyle:{
                color:['#3398db']
            }
        },

        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            orient: 'vertical',
            x: 'right',
            data: ['一般维修', '其他问题','抄表问题','校表问题','漏气','连接管'],
            textStyle:{
                color:'#61a0a8'
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis:  {
            type: 'value',
            axisLabel:{
                show:true,
                textStyle:{
                    color:'#61a0a8'
                }
            },
            axisLine:{
                lineStyle:{
                    color:'#61a0a8'
                }
            }
        },
        yAxis: {
            type: 'category',
            data: ['南汇', '卢湾', '嘉定', '奉贤', '宝山', '崇明', '徐汇', '普陀', '杨浦', '松江', '浦东', '虹口', '金山', '长宁', '闵行', '闸北', '青浦', '静安', '黄浦'],
            axisLabel:{
                show:true,
                textStyle:{
                    color:'#61a0a8'
                }
            },
            axisLine:{
                lineStyle:{
                    color:'#61a0a8'
                }
            }
        },
        series: [
            {
                name: '一般维修',
                type: 'bar',
                stack: '总量',
                data: []
            },
            {
                name: '抄表问题',
                type: 'bar',
                stack: '总量',
                data: []
            },
            {
                name: '漏气',
                type: 'bar',
                stack: '总量',
                data:[]
            },
            {
                name: '其他问题',
                type: 'bar',
                stack: '总量',
                data: []
            },

            {
                name: '连接管',
                type: 'bar',
                stack: '总量',
                data:  []
            },
            {
                name: '校表问题',
                type: 'bar',
                stack: '总量',
                data: []
            }
        ]
    };
    district_problem.setOption(option);


    var festival_problem = echarts.init(document.getElementById("festival_problem"));
    option = {

        title : {
            text: "节假日期间报修问题分布",
            x:'center',
            textStyle:{
                color:['#3398db']
            }
        },

        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            orient: 'vertical',
            x: 'right',
            data: ["一般维修", "其他问题", "抄表问题", "校表问题", "漏气", "连接管"],
            textStyle:{
                color:'#61a0a8'
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis:  {
            type: 'value',
            axisLabel:{
                show:true,
                textStyle:{
                    color:'#61a0a8'
                }
            },
            axisLine:{
                lineStyle:{
                    color:'#61a0a8'
                }
            }
        },
        yAxis: {
            type: 'category',
            data: ['国庆节', '中秋节', '端午节', '劳动节', '清明节', '春节', '元旦'],
            axisLabel:{
                show:true,
                textStyle:{
                    color:'#61a0a8'
                }
            },
            axisLine:{
                lineStyle:{
                    color:'#61a0a8'
                }
            }
        },
        series: [
            {
                name: '一般维修',
                type: 'bar',
                stack: '总量',
                data: []
            },
            {
                name: '其他问题',
                type: 'bar',
                stack: '总量',
                data: []
            },
            {
                name: '抄表问题',
                type: 'bar',
                stack: '总量',
                data: []
            },
            {
                name: '校表问题',
                type: 'bar',
                stack: '总量',
                data: []
            },
            {
                name: '漏气',
                type: 'bar',
                stack: '总量',
                data: []
            },
            {
                name: '连接管',
                type: 'bar',
                stack: '总量',
                data: []
            }
        ]
    };
    festival_problem.setOption(option);



    $.ajax({
        type:'get',
        async:true,
        url:'/problem',
        dataType:'json',
        success:function(result){
            if (result != null && result.length>0){
                var problemTypeResult = result[0];
                var districtProblemReuslt = result[1];
                var festivalProblemResult = result[2];
                var optionFuntion = function(data){
                    var option = {
                        series:[{
                            name:'一般维修',
                            data:data[0],
                            label: {
                                normal: {
                                    show: false
                                }
                            }
                        },
                            {
                                name:'其他问题',
                                data:data[1],
                                label: {
                                    normal: {
                                        show: false
                                    }
                                }
                            },
                            {
                                name:'抄表问题',
                                data:data[2],
                                label: {
                                    normal: {
                                        show: false
                                    }
                                }
                            },
                            {
                                name:'校表问题',
                                data:data[3],
                                label: {
                                    normal: {
                                        show: false
                                    }
                                }
                            },
                            {
                                name:'漏气',
                                data:data[4],
                                label: {
                                    normal: {
                                        show: false
                                    }
                                }
                            },
                            {
                                name:'连接管',
                                data:data[5],
                                label: {
                                    normal: {
                                        show: false
                                    }
                                }
                            }
                        ]
                    }
                    return option;
                };
                problem_type.setOption({
                    series: [{
                        data:[
                            {value:problemTypeResult[0],name:'一般维修'},
                            {value:problemTypeResult[1],name:'其他问题'},
                            {value:problemTypeResult[2],name:'抄表问题'},
                            {value:problemTypeResult[3],name:'校表问题'},
                            {value:problemTypeResult[4],name:'漏气'},
                            {value:problemTypeResult[5],name:'连接管'}
                        ]

                    }]
                });
                district_problem.setOption(optionFuntion(districtProblemReuslt));
                festival_problem.setOption(optionFuntion(festivalProblemResult));
            }else{
                //返回的数据为空时显示提示信息
                alert("图表请求数据为空，可能服务器暂未录入数据，您可以稍后再试！");
            }
        },
        error:function(errorMsg){
            //请求失败时执行该函数
            alert("图表请求数据失败，可能是服务器开小差了");
        }
    });

})();
