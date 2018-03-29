// 'use strict';

var twoSum = function(nums, target) {
    let hashMap = {};
    let result = [];
    nums.forEach((e, i)=>{
        if(hashMap[e]>-1){
            result = [hashMap[e], i];
        } else {
            hashMap[target-e] = i;
        }
    });
    return result;
};

let nums = [2,3,6,5];
let target = 7;

console.log(twoSum(nums, target));

