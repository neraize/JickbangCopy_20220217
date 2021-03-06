package com.nepplus.jickbangcopy_20220217.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.nepplus.jickbangcopy_20220217.R
import com.nepplus.jickbangcopy_20220217.datas.RoomData
import org.w3c.dom.Text

class RoomAdapter(
    val mContext:Context,
    val resId:Int,
    val mList:ArrayList<RoomData>
):ArrayAdapter<RoomData>(mContext, resId, mList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView

        if(tempRow==null){
            tempRow = LayoutInflater.from(mContext).inflate(R.layout.room_list_item, null)
        }

        val row = tempRow!!

        val data = mList[position]

        val txtPrice = row.findViewById<TextView>(R.id.txtPrice)
        val txtAddressAndFloor = row.findViewById<TextView>(R.id.txtAddressAndFloor)
        val txtDescription = row.findViewById<TextView>(R.id.txtDescription)

        txtDescription.text = data.description
        txtAddressAndFloor.text = "${data.address}, ${data.getFormattedFloor()}"

        txtPrice.text =data.getFormattedPrice()

        return  row
    }
}