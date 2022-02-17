package com.nepplus.jickbangcopy_20220217

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nepplus.jickbangcopy_20220217.adapters.RoomAdapter
import com.nepplus.jickbangcopy_20220217.datas.RoomData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.room_list_item.*

class MainActivity : AppCompatActivity() {

    lateinit var mRoomAdapter:RoomAdapter
    val mRoomList =ArrayList<RoomData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRoomList.add(RoomData(8000,"서울시 동대문구",7,"1번째방입니다."))
        mRoomList.add(RoomData(19000,"서울시 서대문구",5,"2번째방입니다."))
        mRoomList.add(RoomData(25600,"서울시 종로구",3,"3번째방입니다."))
        mRoomList.add(RoomData(3800,"서울시 중구",-1,"4번째방입니다."))
        mRoomList.add(RoomData(56000,"서울시 마포구",8,"5번째방입니다."))
        mRoomList.add(RoomData(7800,"서울시 동작구",-2,"6번째방입니다."))
        mRoomList.add(RoomData(6800,"서울시 강서구",0,"7번째방입니다."))
        mRoomList.add(RoomData(29000,"서울시 강남구",1,"8번째방입니다."))
        mRoomList.add(RoomData(31200,"서울시 영등포구",0,"9번째방입니다."))

        mRoomAdapter = RoomAdapter(this,R.layout.room_list_item, mRoomList)

        roomListView.adapter = mRoomAdapter


        roomListView.setOnItemClickListener { adapterView, view, position, l ->

            val clickedRoom = mRoomList[position]

            val myIntent = Intent(this, ViewRoomDetailActivity::class.java)

            myIntent.putExtra("priceInfo",clickedRoom.getFormattedPrice())

            startActivity(myIntent)
        }
    }
}