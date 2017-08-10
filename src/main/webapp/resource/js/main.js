/**
 * Created by Administrator on 2017/8/10.
 */

$(document).ready(function () {
    fileSizeCharts();
});

function fileSizeCharts(){
    var dataX=new Array();
    var dataNum=new Array();


    //var myChart = echarts.init(document.getElementById('fileSizeCharts'));
    var myChart = echarts.init($('#fileSizeCharts')[0]);

    var option = {
        color: ['#3398DB'],
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '25%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                data : [],
                axisLabel :{
                    interval:0,
                    rotate:60
                },
                axisTick: {
                    alignWithLabel: true
                }
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                name:'直接访问(B)',
                type:'bar',
                barWidth: '60%',
                // data:[10, 52, 200, 334, 390]
                data:[]
            }
        ]
    };

    $.ajax({
        url:'/mainCtrl/fileSizeCharts',
        type:'POST',
        dataType:'json',
        success:function (data) {
            if(data){
                for(var i=0;i<data.length;i++){
                    var xStr=data[i].file_name;
                    if(xStr.length>=10){
                        var strTemp=xStr.split(".");
                        xStr=strTemp[0].substr(0,5)+"."+strTemp[1];
                    }
                    dataX.unshift(xStr);
                    dataNum.unshift(data[i].file_size);
                }

                option.xAxis[0].data=dataX;
                option.series[0].data=dataNum;
                myChart.setOption(option);
            }
        }
    })


}

