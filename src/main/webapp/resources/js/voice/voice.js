(function(){
    var voice_length = echarts.init(document.getElementById("voice_length"));
    var option = {
        title: {
            text: "音频长度分布",
            textStyle:{
                color:"#ffffff"
            },
            x:'center'
        },
        textStyle:{
            color:["#ffffff"],
        },

        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            },
            iconStyle:{
                normal:{
                    borderColor:'#ffffff'
                }
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true,

        },
        xAxis : [
            {
                type : 'category',
                data : ['0-1分钟','1-2分钟','2-3分钟','3分钟以上'],
                axisTick: {
                    alignWithLabel: true
                }
            }
        ],
        yAxis : [
            {
                type : 'value',
                splitLine:{
                    lineStyle:{
                        color:'#333333'
                    }
                }
            }
        ],
        series : [
            {
                name:'音频个数',
                type:'bar',
                barWidth: '60%',
                data:[],

            }
        ]
    };
    voice_length.setOption(option);

    var call_type_pie = echarts.init(document.getElementById("call_type_pie"));
    option = {
        title : {
            text: '座机手机分布',
            x:'center',
            textStyle:{
                color:"#ffffff"
            },
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        color:["#6390e8","#ef737a"],
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['座机','手机'],
            textStyle:{
                color:'#ffffff'
            }
        },
        series : [
            {
                name: '访问来源',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[
                ],
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
    call_type_pie.setOption(option);

    var voice_valid_pie = echarts.init(document.getElementById("voice_valid_pie"));
    option = {

        title : {
            text: "有效/无效音频分布图",
            x: 'center',
            textStyle:{
                color:"#ffffff"
            },
        },

        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
        },
        color:['#00f6e3','#4cc3ff'],
        legend: {
            orient: 'vertical',
            x: 'left',
            data:['有效音频','无效音频'],
            textStyle:{
                color:"#ffffff"
            }
        },
        series: [
            {
                name:'音频分布',
                type:'pie',
                radius: ['50%', '70%'],
                avoidLabelOverlap: false,
                label: {
                    normal: {
                        show: false,
                        position: 'center'
                    },
                    emphasis: {
                        show: true,
                        textStyle: {
                            fontSize: '30',
                            fontWeight: 'bold'
                        }
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                data:[
                    {value:335, name:'有效音频'},
                    {value:310, name:'无效音频'}
                ]
            }
        ]
    };
    voice_valid_pie.setOption(option);

    var tel_employee = echarts.init(document.getElementById("tel_employee"));
    option = {
        title: {
            text: '话务员时间忙碌折线图',
            x: 'center',
            textStyle:{
                color:'#ffffff'
            }
        },
        color:['#76ff7f'],
        textStyle:{
            color:["#ffffff"],
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            orient: 'vertical',
            x: 'left',
            data:['话务量'],
            textStyle:{
                color:'#ffffff'
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            },
            iconStyle:{
                normal:{
                    borderColor:'#ffffff'
                }
            }

        },
        xAxis: {
            type: 'category',
            data: ['8:00-9:00','9:00-10:00','10:00-11:00','11:00-12:00','12:00-13:00','13:00-14:00','14:00-15:00','15:00-16:00','16:00-17:00','17:00-18:00']
        },
        yAxis: {
            type: 'value',
            splitLine:{
                lineStyle:{
                    color:'#333333'
                }
            }
        },
        series: [
            {
                name:'话务量',
                type:'line',
                stack: '总量',
                data:[]
            }
        ]
    };
    tel_employee.setOption(option);

    var time_distribution = echarts.init(document.getElementById("time_distribution"));
    option = {
        title: {
            text: '有效时间和浪费时间分布',
            x:'center',
            textStyle:{
                color:'#ffffff'
            }
        },
        textStyle:{
            color:'#ffffff'
        },
        color:['#fb8a7d','#00efe0'],
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            orient: 'vertical',
            x: 'left',
            data:['有效时间', '无效时间']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            },
            iconStyle:{
                normal:{
                    borderColor:'#ffffff'
                }
            }
        },
        xAxis: {
            type: 'category',
            data: ['30秒', '1分钟', '1分半', '2分钟', '2分半', '3分钟', '3分半']
        },
        yAxis: {
            type: 'value',
            splitLine:{
                lineStyle:{
                    color:'#333333'
                }
            }
        },
        series: [
            {
                name:'有效时间数量',
                type:'line',
                step: 'start',
                data:[120, 132, 101, 134, 90, 230, 210]
            },
            {
                name:'无效时间数量',
                type:'line',
                step: 'middle',
                data:[220, 282, 201, 234, 290, 430, 410]
            }
        ]
    };
    time_distribution.setOption(option);

    var tel_traffic = echarts.init(document.getElementById("tel_traffic"));
    var base = +new Date(2009,11 , 31);
    var oneMonth = 24 * 3600 * 1000*30;
    var date = [];
    var data = [Math.random() * 300];

    for (var i = 1; i < 20000; i++) {
        var now = new Date(base += oneMonth);
        date.push([now.getFullYear(), now.getMonth() + 1, now.getDate()].join('/'));
        data.push(Math.round((Math.random() - 0.5) * 20 + data[i - 1]));
    }

    option = {
        tooltip: {
            trigger: 'axis',
            position: function (pt) {
                return [pt[0], '10%'];
            }
        },
        title: {
            left: 'center',
            text: '每月话务量',
            textStyle:{
                color:'#ffffff'
            }
        },
        textStyle:{
            color:'#ffffff'
        },
        legend: {
            top: 'bottom',
            data:['意向']
        },
        toolbox: {
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                restore: {},
                saveAsImage: {}
            },
            iconStyle:{
                normal:{
                    borderColor:'#ffffff'
                }
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: date
        },
        yAxis: {
            type: 'value',
            boundaryGap: [0, '100%'],
            splitLine:{
                lineStyle:{
                    color:'#333333'
                }
            }
        },
        dataZoom: [{
            type: 'inside',
            start: 0,
            end: 10
        }, {
            start: 0,
            end: 10,
            handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
            handleSize: '80%',
            handleStyle: {
                color: '#fff',
                shadowBlur: 3,
                shadowColor: 'rgba(0, 0, 0, 0.6)',
                shadowOffsetX: 2,
                shadowOffsetY: 2
            },
            textStyle:{
                color:'#ffffff'
            }
        }],
        series: [
            {
                name:'话务量',
                type:'line',
                smooth:true,
                symbol: 'none',
                sampling: 'average',
                itemStyle: {
                    normal: {
                        color: '#587afb'
                    }
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: '#5194ff'
                        }, {
                            offset: 1,
                            color: '#587afb'
                        }])
                    }
                },
                data: data
            }
        ]
    };
    tel_traffic.setOption(option);

    //请求数据
    $.ajax({ //使用JQuery内置的Ajax方法
        type:"post", //post请求方式
        async: true, //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url:"/voice",//请求发送到voiceController处
        data:[],//请求内包含一个key为name，value为voice_length的参数；服务器接收到客户端请求时通过request.getParameter方法获取该参数值
        datatype:"json",//返回数据形式为json
        success : function(result) {
            //请求成功时执行该函数内容，result即为服务器返回的json对象
            if (result != null && result.length > 0) {
                var resultData = $.parseJSON(result);//json解析
                voice_length.setOption({		//载入数据
                    series: [	//填入系列（内容）数据
                        {
                            data:[{
                                // 根据名字对应到相应的系列
                                itemStyle:{
                                    normal:{
                                        color:'#1797e7'
                                    }
                                },
                                value:resultData[0][0]
                            },
                                {
                                    // 根据名字对应到相应的系列
                                    itemStyle:{
                                        normal:{
                                            color:'#00cba8'
                                        }
                                    },
                                    value:resultData[0][1]
                                },
                                {
                                    // 根据名字对应到相应的系列
                                    itemStyle:{
                                        normal:{
                                            color:'#14a507'
                                        }
                                    },
                                    value:resultData[0][2]
                                },
                                {
                                    // 根据名字对应到相应的系列
                                    itemStyle:{
                                        normal:{
                                            color:'#b8c707'
                                        }
                                    },
                                    value:resultData[0][3]
                                }
                            ]

                        }
                    ]
                });
                tel_employee.setOption({
                    series:[
                        {
                            data:resultData[1]
                        }
                    ]
                });
                call_type_pie.setOption({
                    series:[
                        {
                            data:[
                                {value:resultData[2][0], name:'座机'},
                                {value:resultData[2][1], name:'手机'}
                            ]
                        }
                    ]
                });

            }
            else {
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