/**
 * Created by huchao on 2017/6/21.
 */
//国庆节图表展示
var chart_national = echarts.init(document.getElementById("national_index"));
option1 = {
    title: {
        text: '2016国庆期间话务量统计',
        textStyle: {
            color: '#61e456',
            fontSize: 18
        }
    },
    color: ['#3398DB'],
    tooltip: {
        trigger: 'axis',
        axisPointer: {            // 坐标轴指示器，坐标轴触发有效
            type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        }
    },
    grid: {
        left: '2%',
        right: '4%',
        bottom: '2%',
        containLabel: true
    },
    xAxis: [
        {
            type: 'category',
            data: ['10月1日', '10月2日', '10月3日', '10月4日', '10月5日', '10月6日', '10月7日'],
            axisTick: {
                alignWithLabel: true
            },
            axisLine: {
                lineStyle: {
                    color: '#00fedf',
                    width: 1,//这里是为了突出显示加上的
                }
            }
        }
    ],
    yAxis: [
        {
            type: 'value',
            axisLine: {
                lineStyle: {
                    color: '#00fedf',
                    width: 1,//这里是为了突出显示加上的
                }
            }
        }
    ],
    series: [
        {
            name: '话务量',
            type: 'bar',
            barWidth: '60%',
            data: [3825, 2888, 2652, 3092, 3489, 3873, 0],
            itemStyle: {
                normal: {
                    color: function (params) {

                        var colorList = [
                            '#f0e543', '#5cc2df', '#61e456', '#e2d49c', '#8b9123', '#ef726b', '#f3a285'
                        ];
                        return colorList[params.dataIndex]
                    }
                }

            }
        }
    ]
};
chart_national.setOption(option1)
//劳动节图表展示
var chart_labor = echarts.init(document.getElementById("labor_index"));
option2 = {
    title: {
        text: '2016年国庆节话务量分布',
        textStyle: {
            color: '#61e456',
            fontSize: 18
        }
    },
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'cross'
        }
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis: {
        type: 'category',
        boundaryGap: false,
        data: ['10月1日', '10月2日', '10月3日', '10月4日', '10月5日', '10月6日', '10月7日'],
        axisLine: {
            lineStyle: {
                color: '#00fedf',
                width: 1,//这里是为了突出显示加上的
            }
        }
    },
    yAxis: {
        type: 'value',
        axisLabel: {
            formatter: '{value}'
        },
        splitLine: {
            lineStyle: {
                color: "#f0e543"
            }
        },
        axisPointer: {
            snap: true
        },
        axisLine: {
            lineStyle: {
                color: '#00fedf',
                width: 1,//这里是为了突出显示加上的
            }
        }
    },
    visualMap: {
        show: false,
        dimension: 0,
        pieces: [{
            lte: 6,
            color: 'green'
        }, {
            gt: 2000,
            lte: 2500,
            color: 'red'
        }, {
            gt: 2500,
            lte: 3000,
            color: 'green'
        }, {
            gt: 3000,
            lte: 3200,
            color: 'red'
        }, {
            gt: 3200,
            lte: 3500,
            color: 'green'
        }]
    },
    series: [
        {
            name: '话务量',
            type: 'line',
            smooth: true,
            data: [3825, 2888, 2652, 3092, 3489, 3873, 0],
            markArea: {
                data: [[{
                    name: '高峰时间段',
                    xAxis: '10月5日'
                }, {
                    xAxis: '10月6日'
                }]],
                itemStyle: {
                    normal: {
                        color: "#5cc2df"
                    }
                },
                label: {
                    normal: {
                        offset: [10, -10],
                        textStyle: {
                            color: "#ff0",
                            fontSize: 15
                        }
                    }
                }
            },
            markPoint: {
                symbolSize: 70,
                symbolRotate: 30,
                data: [
                    {type: 'max', name: '最大值'},
                    {type: 'min', name: '最小值'}
                ],
                itemStyle: {
                    normal: {
                        color: "#00feaf"
                    }
                },
                label: {
                    normal: {
                        textStyle: {
                            color: "#000",
                            fontSize: 11
                        }
                    }
                }
            }
        }
    ]
};
chart_labor.setOption(option2)