package me.tsz.m3.sf.xy.floatwindow

import android.content.Context
import android.graphics.PixelFormat
import android.view.Gravity
import android.view.WindowManager
import android.view.WindowManager.LayoutParams.*
import android.widget.Button

/**
 * https://developer.android.com/reference/kotlin/android/view/ViewManager
 *
 * https://developer.android.com/reference/kotlin/android/view/WindowManager.LayoutParams
 *
 * LayoutParams是View用来告诉它的父控件如何放置自己的。
 * 基类LayoutParams（也就是ViewGroup.LayoutParams）仅仅描述了这个View想要的宽度和高度。
 * 不同ViewGroup的继承类对应着不同的ViewGroup.LayoutParams的子类。
 */
class FloatWindowManager(var context: Context) {
    var windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager;


    fun xx() {
        var button = Button(context);
        button.text = "Window";

//        WindowManager.LayoutParams 是 WindowManager 接口的嵌套类；继承于 ViewGroup.LayoutParams 。

        /*
        LayoutParams相当于一个Layout的信息包，它封装了Layout的位置、高、宽等信息。
        假设在屏幕上一块区域是由一个Layout占领的，如果将一个View添加到一个Layout中，最好告诉Layout用户期望的布局方式，也就是将一个认可的layoutParams传递进去。

        在安卓中动态构建的布局
         */

        /*
        那时候在布局文件XML里，写的最多的肯定是 layout_width = "match_parent" 之类的了。
         */

        /*
        Android界面编程方面有两大核心，一个是View代表的界面元素，一个是WindowManager代表的界面管理。前者为卒子，后者为将帅。
        一切View，在界面最终以Window形式展现，被WindowManager管理。

        View的展现规则封装在LayoutParams中，其内部属性见：
         */
        var layoutParams = WindowManager.LayoutParams(
            WRAP_CONTENT,
            WRAP_CONTENT,
            /*
            https://www.cnblogs.com/olvo/archive/2012/05/17/2505776.html
            窗口类型。有3种主要类型： <--文章时间2012年
            Applicationwindows：
                    取值在 FIRST_APPLICATION_WINDOW 和 LAST_APPLICATION_WINDOW 之间。
                    是通常的、顶层的应用程序窗口。必须将 token 设置成 activity 的 token 。
            Sub_windows：
                    取值在 FIRST_SUB_WINDOW 和 LAST_SUB_WINDOW 之间。
                    与顶层窗口相关联，token 必须设置为它所附着的宿主窗口的 token。
            Systemwindows：
                    取值在 FIRST_SYSTEM_WINDOW 和 LAST_SYSTEM_WINDOW 之间。
                    用于特定的系统功能。它不能用于应用程序，使用时需要特殊权限。
             */
            TYPE_APPLICATION, // WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
            /**
             * https://www.cnblogs.com/olvo/archive/2012/05/17/2505776.html
             *
             * FLAG_NOT_TOUCH_MODAL
             * 当窗口可以获得焦点（没有设置 FLAG_NOT_FOCUSALBE 选项）时，仍然将窗口范围之外的点设备事件（鼠标、触摸屏）发送给后面的窗口处理。否则它将独占所有的点设备事件，而不管它们是不是发生在窗口范围内。
             * FLAG_LAYOUT_IN_SCREEN
             * 窗口占满整个屏幕，忽略周围的装饰边框（例如状态栏）。此窗口需考虑到装饰边框的内容。
             * FLAG_NOT_TOUCHABLE
             * 不接受触摸屏事件。
             * FLAG_NOT_FOCUSABLE
             * 不许获得焦点。
             * 不能获得按键输入焦点，所以不能向它发送按键或按钮事件。那些时间将发送给它后面的可以获得焦点的窗口。
             * 此选项还会设置 FLAG_NOT_TOUCH_MODAL选项。
             * 设置此选项，意味着窗口不能与软输入法进行交互，所以它的Z序独立于任何活动的输入法（换句话说，它可以 全屏显示，如果需要的话，可覆盖输入法窗口）。要修改这一行为，可参考FLAG_ALT_FOCUSALBE_IM选项。
             */
            FLAG_NOT_TOUCH_MODAL or FLAG_NOT_FOCUSABLE,
            // 标识这个window怎么响应事件，怎样的一个透明度，以及一些全屏，锁屏显示等等。
            // or WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE or WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
            PixelFormat.TRANSPARENT // PixelFormat.TRANSLUCENT
        );

        layoutParams.gravity = Gravity.LEFT or Gravity.TOP
        /*
        如果忽略gravity属性，那么它表示窗口的绝对X位置。
        什么是gravity属性呢？简单地说，就是窗口如何停靠。
        当设置了 Gravity.LEFT 或 Gravity.RIGHT 之后，x值就表示到特定边的距离。
         */
        layoutParams.x = 100
        /*
        如果忽略gravity属性，那么它表示窗口的绝对Y位置。
        当设置了 Gravity.TOP 或 Gravity.BOTTOM 之后，y值就表示到特定边的距离。
         */
        layoutParams.y = 300

        windowManager.addView(button, layoutParams)
    }
}