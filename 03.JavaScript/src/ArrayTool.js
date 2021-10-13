/*
    需求:
        编写一个js文件, 在js文件中自定义一个数组工具对象
        该工具对象要有一个找到最大值的方法, 与元素对应的索引值的方法.
*/

var ArrayTool = new ArrayTool();

function ArrayTool(){
    /*
        找最大值
    */
    this.getMax = function(arr){
        var max = arr[0];
        for (var index in arr) {
            if(arr[index] > max){
                max = arr[index];
            }
        }
        return max;
    }

    /*
        找索引值
    */
    this.getIndex = function(arr, target){
        for(var index in arr){
            if(arr[index] == target){
                return index;
            }
        }
        return -1;
    }
}