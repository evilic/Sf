package me.tsz.m3.sf.xy.floatwindow

import android.content.Context
import android.graphics.PixelFormat
import android.view.Gravity
import android.view.WindowManager
import android.widget.Button
import android.widget.LinearLayout

/**
 * https://developer.android.com/reference/kotlin/android/view/ViewManager
 */
class FloatWindowManager(var context: Context) {
    var windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager;


    fun xx() {
        var button = Button(context);
        button.text = "Window";
        var layoutParams: WindowManager.LayoutParams = WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            0,
            0,
            PixelFormat.TRANSPARENT
        );

        layoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION
        layoutParams.flags =
            WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL or WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
        layoutParams.gravity = Gravity.LEFT or Gravity.TOP
        layoutParams.x = 100
        layoutParams.y = 300


        windowManager.addView(button, layoutParams)
    }
}