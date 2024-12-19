package com.singlepointsol.lazycolumnlist

data class Bike(val Image:Int,val Make:String,val Model:String,val Price:Int,val Specifications:String,val TopSpeed:String)
fun getAllBikes() = mybikeList
val mybikeList = listOf<Bike>(
    Bike(R.drawable.st765,"Triumph","Street Triple 765",1200000,"Power:128hp","Top Speed:260"),
    Bike(R.drawable.cbr,"Honda","Fireblade CBR 1000RRR",3000000,"Power:215hp","Top Speed:333"),
    Bike(R.drawable.s1k,"BMW","S1000RR",2700000,"Power:202hp","Top Speed:320"),
    Bike(R.drawable.v4,"Ducati","Panigale V4",3400000,"Power:214hp","Top Speed:328"),
    Bike(R.drawable.cgt,"Royal Enfield","CGT 650",450000,"Power:47hp","Top Speed:190"),
    Bike(R.drawable.sportster,"Harley Davidson","Sportster",1700000,"Power:111hp","Top Speed:200"),
    Bike(R.drawable.zx10r,"Kawasaki","Ninja ZX10R",1900000,"Power:197hp","Top Speed:325"),
    Bike(R.drawable.desertx,"Ducati","DesertX",2300000,"Power:160hp","Top Speed:220")
    ,Bike(R.drawable.gsx,"Suzuki","GSX-R1000",1800000,"Power:185hp","Top Speed:312")
    ,Bike(R.drawable.r1,"Yamaha","R1 CrossPlane",1500000,"Power:188hp","Top Speed:320")
    ,Bike(R.drawable.mv,"MV Agusta","Brutale",2500000,"Power:130hp","Top Speed:250")
    )

