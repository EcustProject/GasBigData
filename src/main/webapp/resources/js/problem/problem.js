(function(){

$.get("/problemSort",function(data,status){
      var  Pcategory=new Array();
        var  Ppie=new Array();
        function ProSort(value,name){
        this.value=value;
        this.name=name;
        }
    jsondata=JSON.parse(data);
    $.each(jsondata,function(i,item){
      Pcategory.push(item['category']);
       var  proSort=new ProSort(item['numbers'],item['category']);
       Ppie.push(proSort);
    });
var problem_type = echarts.init(document.getElementById("problem_type"));
option = {
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
        data: Pcategory,
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
            data:Ppie,
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
  });
$.get("/Districtproblem",function(data,status){
 jsondata=JSON.parse(data);
 var lianjieguan,chaobiao,louqi,qita,xiaobiao,normal=new Array();
  lianjieguan=jsondata['连接管'];
  chaobiao=jsondata['抄表问题'];
  louqi=jsondata['漏气'];
  qita=jsondata['其他问题'];
  xiaobiao=jsondata['校表问题'];
  yiban=jsondata['一般维修'];
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
        data: ['一般维修', '抄表问题','漏气','其他问题','连接管','校表问题'],
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
            label: {
                normal: {
                    show: true,
                    position: 'insideRight'
                }
            },
            data: yiban
        },
        {
            name: '抄表问题',
            type: 'bar',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'insideRight'
                }
            },
            data: chaobiao
        },
        {
            name: '漏气',
            type: 'bar',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'insideRight'
                }
            },
            data:louqi
        },
         {
          name: '其他问题',
          type: 'bar',
          stack: '总量',
          label: {
              normal: {
                  show: true,
                  position: 'insideRight'
              }
          },
          data: qita
          },

          {
           name: '连接管',
           type: 'bar',
           stack: '总量',
           label: {
               normal: {
                   show: true,
                   position: 'insideRight'
               }
           },
           data:  lianjieguan
            },
           {
            name: '校表问题',
            type: 'bar',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'insideRight'
                }
            },
            data: xiaobiao
           }
    ]
};
district_problem.setOption(option);
});

$.get("/Festivalproblem",function(data,status){
  jsondata=JSON.parse(data);
  var lianjieguan,chaobiao,louqi,qita,xiaobiao,normal=new Array();
  lianjieguan=jsondata['连接管'];
  chaobiao=jsondata['抄表问题'];
  louqi=jsondata['漏气'];
  qita=jsondata['其他问题'];
  xiaobiao=jsondata['校表问题'];
  yiban=jsondata['一般维修'];
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
          data: ['一般维修', '抄表问题','漏气','其他问题','连接管','校表问题'],
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
              label: {
                  normal: {
                      show: true,
                      position: 'insideRight'
                  }
              },
              data: yiban
          },
          {
              name: '抄表问题',
              type: 'bar',
              stack: '总量',
              label: {
                  normal: {
                      show: true,
                      position: 'insideRight'
                  }
              },
              data: chaobiao
          },
          {
              name: '连接管',
              type: 'bar',
              stack: '总量',
              label: {
                  normal: {
                      show: true,
                      position: 'insideRight'
                  }
              },
              data: lianjieguan
          },
           {
                        name: '漏气',
                        type: 'bar',
                        stack: '总量',
                        label: {
                            normal: {
                                show: true,
                                position: 'insideRight'
                            }
                        },
                        data: louqi
            },
            {
                      name: '其他问题',
                      type: 'bar',
                      stack: '总量',
                      label: {
                          normal: {
                              show: true,
                              position: 'insideRight'
                          }
                      },
                      data: qita
            },
            {
                     name: '校表问题',
                     type: 'bar',
                     stack: '总量',
                     label: {
                         normal: {
                             show: true,
                             position: 'insideRight'
                         }
                     },
                     data: xiaobiao
              }
      ]
  };
  festival_problem.setOption(option);
});

})();
