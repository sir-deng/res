package com.helen.kotlindemo

import java.io.File

fun main(arg:Array<String>){
    println("hello kotlin")
}

fun a(vararg v:Int){
    for(b in v){
        println("b:"+b)
    }
    var s:Any =3
    if (s is Number){

    }
    for (i in 1..5 step 3){

    }
    var file = File("test").listFiles()
    var ts = null;
    println(file?.size?:"e")
    var emails = arrayListOf<String>()
    emails?.let {

    }
    var mainEmail=emails.firstOrNull()?:""
}
object Res{
    var name = "";
}
var s:String?="2"//加？表示可以为kong