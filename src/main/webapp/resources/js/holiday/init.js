/**
 * Created by huchao on 2017/6/21.
 */
//国庆节图表展示
var chart_national1 = echarts.init(document.getElementById("national_index1"));
option1 = {
    title: {
        text: '2016国庆期间话务量统计',
        textStyle: {
            color: '#00efe0',
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
chart_national1.setOption(option1)

var chart_national2 = echarts.init(document.getElementById("national_index2"));
option2 = {
    title: {
        text: '2016年国庆节话务时间段分布',
        textStyle: {
            color: '#00efe0',
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
        data: [ '01:00', '02:00', '03:00', '04:00', '05:00', '06:00', '07:00', '08:00',
            '09:00', '10:00', '11:00', '12:00', '13:00', '14:00', '15:00', '16:00',
            '17:00', '18:00', '19:00', '20:00', '21:00', '22:00', '23:00',"24:00"],
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
            gt: 6,
            lte: 8,
            color: 'red'
        }, {
            gt: 8,
            lte: 14,
            color: 'green'
        }, {
            gt: 14,
            lte: 17,
            color: 'red'
        }, {
            gt: 17,
            color: 'green'
        }]
    },
    series: [
        {
            name: '话务量',
            type: 'line',
            smooth: true,
            data: [ 8, 9, 3, 9, 23, 131, 417, 1357,
                2387, 2583, 1963, 1517, 1570, 1586, 1498, 1371,
                1029, 678, 570, 487, 321, 194, 80,28],
            markArea: {
                data: [[{
                    name: '高峰时间段',
                    xAxis: '09:00'
                }, {
                    xAxis: '13:00'
                }]],
                itemStyle: {
                    normal: {
                        color: "#5cc2df"
                    }
                },
                label: {
                    normal: {
                        offset: [60, -10],
                        textStyle: {
                            color: "#ff0",
                            fontSize: 15
                        }
                    }
                }
            },
            markPoint: {
                symbolSize: 90,
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
chart_national2.setOption(option2)

//劳动节图表展示

var Year_index1 = echarts.init(document.getElementById("Year_index1"));
option1 = {
    title: {
        text: '2016春节期间话务量统计',
        textStyle: {
            color: '#00efe0',
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
            data: ['2月7日', '2月8日', '2月9日', '2月10日', '2月11日', '2月12日', '2月13日'],
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
            data: [4211, 4257, 4914, 4853, 4471,4221,4151],
            itemStyle: {
                normal: {
                    color: function (params) {
                        var colorList = [
                            '#00f6d3','#4cc234','#62f873','#62ff83','#00f6e3','#ef737a','#f3a174'
                        ];
                        return colorList[params.dataIndex]
                    }
                }

            }
        }
    ]
};
Year_index1.setOption(option1)

var Year_index2 = echarts.init(document.getElementById("Year_index2"));
option2 = {
    title: {
        text: '2016年春节话务时间段分布',
        textStyle: {
            color: '#00efe0',
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
        data: [ '01:00', '02:00', '03:00', '04:00', '05:00', '06:00', '07:00', '08:00',
            '09:00', '10:00', '11:00', '12:00', '13:00', '14:00', '15:00', '16:00',
            '17:00', '18:00', '19:00', '20:00', '21:00', '22:00', '23:00',"24:00"],
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
            gt: 6,
            lte: 8,
            color: 'red'
        }, {
            gt: 8,
            lte: 14,
            color: 'green'
        }, {
            gt: 14,
            lte: 17,
            color: 'red'
        }, {
            gt: 17,
            color: 'green'
        }]
    },
    series: [
        {
            name: '话务量',
            type: 'line',
            smooth: true,
            data: [ 8, 9, 3, 9, 23, 131, 417, 1357,
                2387, 2583, 1963, 1517, 1570, 1586, 1498, 1371,
                1029, 678, 570, 487, 321, 194, 80,28],
            markArea: {
                data: [[{
                    name: '高峰时间段',
                    xAxis: '09:00'
                }, {
                    xAxis: '13:00'
                }]],
                itemStyle: {
                    normal: {
                        color: "#5cc2df"
                    }
                },
                label: {
                    normal: {
                        offset: [60, -10],
                        textStyle: {
                            color: "#ff0",
                            fontSize: 15
                        }
                    }
                }
            },
            markPoint: {
                symbolSize: 90,
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
Year_index2.setOption(option2)
