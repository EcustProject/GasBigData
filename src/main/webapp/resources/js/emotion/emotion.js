(function(){
var district_emotion = echarts.init(document.getElementById("district_emotion"));

option = {

	title : {
		text: "上海各区的燃气用户情感",
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
                 orient: 'horizontal',
                    x: 'left',
        data: ['消极', '中性','积极'],
          textStyle:{
                      color:['#61a0a8']
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
        data: ['黄浦','徐汇','长宁','静安','普陀','虹口','杨浦','闵行','宝山','嘉定','浦东','金山','松江','青浦','奉贤','崇明'],
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
            name: '消极',
            type: 'bar',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'insideRight'
                }
            },
            data: [320, 302, 301, 334, 390, 330, 320, 316, 324, 352, 311, 342, 351, 330, 335, 310]
        },
        {
            name: '中性',
            type: 'bar',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'insideRight'
                }
            },
            data: [120, 132, 101, 134, 90, 230, 210, 100, 123, 125, 126, 120, 130, 130, 150, 110]
        },
        {
            name: '积极',
            type: 'bar',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'insideRight'
                }
            },
            data: [220, 182, 191, 234, 290, 330, 310, 250, 255, 210, 260, 240, 259, 265, 290, 251]
        }
    ]
};

district_emotion.setOption(option);
var EmotionType_pie = echarts.init(document.getElementById("EmotionType_pie"));

option = {
	
	title : {
		text: "所有上海燃气用户的情感状态",
		x: 'center',
		 textStyle:{
                                        color:['#3398db']
                                        }
	},
	
    tooltip: {
        trigger: 'item',
        formatter: "{a} <br/>{b}: {c} ({d}%)"
    },
    legend: {
        orient: 'vertical',
        x: 'left',
        data:['消极','中性','积极'],
           textStyle:{
                              color:['#61a0a8']
                                    		}
    },
    series: [
        {
            name:'访问来源',
            type:'pie',
            selectedMode: 'single',
            radius: [0, '30%'],

            label: {
                normal: {
                    position: 'inner'
                }
            },
            labelLine: {
                normal: {
                    show: false
                }
            },
            data:[
                {value:335, name:'消极', selected:true},
                {value:679, name:'中性',
                itemStyle:{
               normal:{color:'#61a0a8'}
                     }},
                {value:200, name:'积极'}
            ]
        },
        {
            name:'访问来源',
            type:'pie',
            radius: ['40%', '55%'],

            data:[
                {value:335, name:'消极'},
                {value:679, name:'中性',
                 itemStyle:{
                      normal:{color:'#61a0a8'}
                            }},
                {value:200, name:'积极'}
            ]
        }
    ]
};
EmotionType_pie.setOption(option);
var SEType = echarts.init(document.getElementById("SEType"));

option = {
    title : {
        text: 'X用户情感分布图',
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
        data: ['消极','中性','积极'],
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
            data:[
                {value:335, name:'消极'},
                {value:310, name:'中性',
                itemStyle:{
                        normal:{color:'#61a0a8'}
                    }},
                {value:200,name:'积极'}
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
SEType.setOption(option);
})();
