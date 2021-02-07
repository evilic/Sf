package me.tsz.m3.sf.xy.floatwindow

import android.content.Context
import android.graphics.PixelFormat
import android.view.*
import android.view.Gravity.LEFT
import android.view.Gravity.TOP
import android.view.WindowManager.LayoutParams.*
import android.widget.LinearLayout
import android.widget.TextView
import me.tsz.m3.sf.R


class FloatWindowSmallView(context: Context) : LinearLayout(context) {
    var smallWindowParams: WindowManager.LayoutParams

    // 0. 搞明白这个到底是怎么回事？
    init {
        // 1. 这个方法有什么用？
        // 2. 这里的context是哪个？
        // 3. 这个方法的参数具体是指啥？
        /*
        放源码之前先要知道inflate方法是干嘛的，看返回是一个View，就知道这个方法是要根据布局id把这个布局加载成一个View并返回的。

        先来看一下LayoutInflater的基本用法吧，它的用法非常简单，首先需要获取到LayoutInflater的实例 LayoutInflater.from(context)
        inflate()方法一般接收两个参数，第一个参数就是要加载的布局id，第二个参数是指给该布局的外部再嵌套一层父布局，如果不需要就直接传null。
        这样就成功成功创建了一个布局的实例，之后再将它添加到指定的位置就可以显示出来了。

        https://blog.csdn.net/guolin_blog/article/details/12921889

        https://www.jianshu.com/p/e215c90a460e
         */
        LayoutInflater.from(context).inflate(R.layout.float_window_x, this)

        val view = findViewById<View>(R.id.small_window_layout)
        var viewWidth = view.layoutParams.width
        var viewHeight = view.layoutParams.height
//        statusBarHeight = getStatusBarHeight()
        // 4. fix this
        val percentView = findViewById<View>(R.id.percent) as TextView
        percentView.text = "悬浮窗"

        smallWindowParams = WindowManager.LayoutParams().apply {
            type = TYPE_APPLICATION_OVERLAY // 设置显示类型为phone
            format = PixelFormat.RGBA_8888 // 显示图片格式
            flags = FLAG_NOT_TOUCH_MODAL or FLAG_NOT_FOCUSABLE // 设置交互模式
            gravity = LEFT or TOP // 设置对齐方式为左上
            x = 10 // ScreenUtils.getScreenWidth(context)
            y = 10 // ScreenUtils.getScreenHeight(context) / 2
            width = viewWidth
            height = viewHeight
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
    }
}