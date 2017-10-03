/**
 * Created by huchao on 2017/6/3.
 */
(function() {
    var home_data = echarts.init(document.getElementById("home_data"));
    option = {
        title:{
            text:'上海各个区居民用户分布',
            top:10,
            left:80,
                textStyle: {
                color:'#00efe0',
                fontSize: 14
            }
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            textStyle: {
                fontSize: '10',
                color:'#fff',
                fontWeight: 'bold'
            },
            x: 'right',
            top:40,
            data:['嘉定区','宝山区','崇明县','普陀区','杨浦区','浦东新区','虹口区','金山区','静安北']
        },
        series: [
            {
                name:'非居民用户',
                type:'pie',
                center: ['40%', '55%'],
                radius: ['45%', '65%'],
                avoidLabelOverlap: false,
                label: {
                    normal: {
                        show: false,
                        position: 'right'
                    },
                    emphasis: {
                        show: true,
                        textStyle: {
                            fontSize: '12',
                            fontWeight: 'bold'
                        }
                    }
                },
                color: [
                    '#00f6e3','#4cc3ff','#62ff73','#f3e59c','#7b9def','#ef737a','#f3a174','#048586','#76ff7f'
                ],
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                data:[
                    {value:389080, name:'嘉定区'},
                    {value:562012, name:'宝山区'},
                    {value:54786, name:'崇明县'},
                    {value:452797, name:'普陀区'},
                    {value:471594, name:'杨浦区'},
                    {value:1335212, name:'浦东新区'},
                    {value:313989, name:'虹口区'},
                    {value:136606, name:'金山区'},
                    {value:322534, name:'静安北'},
                ]
            }
        ]
    };
    home_data.setOption(option);
})();