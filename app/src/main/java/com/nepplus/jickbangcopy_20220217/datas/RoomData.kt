package com.nepplus.jickbangcopy_20220217.datas

import java.io.Serializable
import java.text.NumberFormat
import java.util.*

class RoomData(
    val price:Int,
    val address:String,
    val floor:Int,
    val description:String
) : Serializable {

    fun getFormattedPrice():String{

        if(this.price <10000){
            return NumberFormat.getNumberInstance(Locale.KOREA).format(this.price)
        }
        else{
            // 26500=> 2억6,500
            val uk = this.price /10000      //억단위
            val rest = this.price %10000    //천단위
            return "${uk}억 ${NumberFormat.getNumberInstance(Locale.KOREA).format(rest)}"
        }
    }

    fun getFormattedFloor():String{

        if(this.floor>0){
            return "${this.floor}층"
        }
        else if(this.floor==0){
            return "반지하"
        }
        else{
            return "지하 ${-this.floor}충"
        }
    }
}