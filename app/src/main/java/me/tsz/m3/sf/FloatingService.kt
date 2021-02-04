package me.tsz.m3.sf

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.Chronometer
import android.widget.LinearLayout

class FloatingService : Service() {

    private var winManager: WindowManager? = null
    private var wmParams: WindowManager.LayoutParams? = null
    private var inflater: LayoutInflater? = null

    //浮动布局
    private var mFloatingLayout: View? = null
    private var linearLayout: LinearLayout? = null
    private var chronometer: Chronometer? = null

    override fun onBind(intent: Intent): IBinder {
        initWindow()
        //悬浮框点击事件的处理
        initFloating()
        return MyBinder()
    }

    inner class MyBinder : Binder() {
        val service: FloatingService
            get() = this@FloatingService
    }

    private //设置window type 下面变量2002是在屏幕区域显示，2003则可以显示在状态栏之上
    //设置可以显示在状态栏上
    //设置悬浮窗口长宽数据
    val params: WindowManager.LayoutParams
        get() {
            wmParams = WindowManager.LayoutParams()
            wmParams!!.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
            wmParams!!.flags =
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL or
                        WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN or WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR or
                        WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH
            wmParams!!.width = WindowManager.LayoutParams.WRAP_CONTENT
            wmParams!!.height = WindowManager.LayoutParams.WRAP_CONTENT
            return wmParams as WindowManager.LayoutParams
        }

    /**
     * 初始化窗口
     */
    private fun initWindow() {
        winManager = application.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        //设置好悬浮窗的参数
        wmParams = params
        // 悬浮窗默认显示以左上角为起始坐标
        wmParams!!.gravity = Gravity.LEFT or Gravity.TOP
        //悬浮窗的开始位置，因为设置的是从左上角开始，所以屏幕左上角是x=0;y=0
        wmParams!!.x = winManager!!.defaultDisplay.width
        wmParams!!.y = 210
        //得到容器，通过这个inflater来获得悬浮窗控件
        inflater = LayoutInflater.from(applicationContext)
        // 获取浮动窗口视图所在布局
        mFloatingLayout = inflater!!.inflate(R.layout.remoteview, null)
        // 添加悬浮窗的视图
        winManager!!.addView(mFloatingLayout, wmParams)
    }

    /**
     * 悬浮窗点击事件
     */
    private fun initFloating() {
        linearLayout = mFloatingLayout!!.findViewById<LinearLayout>(R.id.line1)
        linearLayout!!.setOnClickListener {
            startActivity(
                Intent(
                    this@FloatingService,
                    Main2Activity::class.java
                )
            )
        }
        //悬浮框触摸事件，设置悬浮框可拖动
//        linearLayout!!.setOnTouchListener(FloatingListener())
    }
}