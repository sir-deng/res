package com.helen.kotlindemo

public fun  main( agr:Array<String>){
    var num = Array(100){IntArray(100)};
    var n =6;
    var count = 1;
    for(one in num){
        println(one)
        for (two in one){
            println(two)
        }
    }
}