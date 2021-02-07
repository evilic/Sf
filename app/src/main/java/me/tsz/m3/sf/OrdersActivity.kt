package me.tsz.m3.sf

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import me.tsz.m3.sf.xy.floatwindow.FloatWindowSmallView

class OrdersActivity : AppCompatActivity() {
    private val tag = "OrderActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 使用 setContentView 方法装载布局文件
        setContentView(R.layout.activity_orders)

        // 绑定页面中 orders_recycler_view 的数据源
        val list = listOf(
            OrderInfo(
                "Emerson 1234567890123\n河南省 洛阳市 上海区哈哈", "二建 法规教材 *1\n二建 法规真题 *1\n" +
                        "二建 法规真题 *1\n" +
                        "二建 法规真题 *1\n" +
                        "二建 法规真题 *1\n" +
                        "二建 法规真题 *1"
            ),
            OrderInfo("Emerson 1234567890123\n不知道是重庆哪里的人", "fapidqwekvjqpievjq"),
            OrderInfo("Emerson 1234567890123\n恩我就不给你真实的地址你能怎么样", "fapidqwekvjqpievjq"),
            OrderInfo(
                "Emerson 1234567890123\nasdfpiuqvkapvaqiugadkfjbvilqebh",
                "fapidqwekvjqpievjq"
            ),
            OrderInfo(
                "Emerson 1234567890123\nasdfpiuqvkapqq3iugadkfjbvilqebh",
                "fapidqwekvjqpievjq"
            ),
            OrderInfo(
                "Emerson 1234567890123\nasdfpiuqvkapqtiugadkfjbvilqebh",
                "fapidqwekvjqpievjq"
            ),
            OrderInfo(
                "Emerson 1234567890123\nasdfpiuqvkaagdpqiugadkfjbvilqebh",
                "fapidqwekvjqpievjq"
            ),
            OrderInfo(
                "Emerson 1234567890123\nasdfpiuqvkapqiuwgwgadkfjbvilqebh",
                "fapidqwekvjqpievjq"
            ),
            OrderInfo("Emerson 1234567890123\nasdfpiuqvkapqiugadkfjbvilqebh", "fapidqwekvjqpievjq"),
            OrderInfo("asdfpiuqvkap1qgqiugadkfjbvilqebh", "fapidqwekvjqpievjq"),
            OrderInfo("asdfpiuqvkapqiweugadkfjbvilqebh", "fapidqwekvjqpievjq"),
            OrderInfo("asdfpiuqvkapqiugadkfjbvilqebh", "fapidqwekvjqpievjq"),
            OrderInfo("asdfpiuqvkapqiugadkfjbvilqebh", "fapidqwekvjqpievjq"),
            OrderInfo("asdfpiuqvkapqiadgugadkfjbvilqebh", "fapidqwekvjqpievjq"),
            OrderInfo("asdfpiuqvkapqituqrgadkfjbvilqebh", "fapidqwekvjqpievjq"),
            OrderInfo("asdfpiuqvkapqiugadkfjbvilqebh", "fapidqwekvjqpievjq"),
            OrderInfo("asdfpiuqvkapqiugadkfjbvilqebh", "fapidqwekvjqpievjq"),
            OrderInfo("asdfpiuqvkapqiugadkfjbvilqebh", "fapidqwekvjqpievjq"),
            OrderInfo("asdfpiuqvkapqiuga34q34tdkfjbvilqebh", "fapidqwekvjqpievjq"),
            OrderInfo("asdfpiuqvkapqiugadkfjbvilqebh", "fapidqwekvjqpievjq"),
            OrderInfo("asdfpiuqvkapqiugadkfjbvilqebh", "fapidqwekvjqpievjq"),
            OrderInfo("asdfpiuqvkapqiugadkfjbvilqebh", "fapidqwekvjqpievjq"),
            OrderInfo("asdfpiuqvkapqiugadkfjbvilqebh", "fapidqwekvjqpievjq"),
            OrderInfo("asdfpiuqvkapqiugadkfjbvilqebh", "fapidqwekvjqpievjq")
        )
        var ordersAdapter = OrderDetailAdapter(list)

        val recyclerView: RecyclerView = findViewById(R.id.orders_recycler_view)
        recyclerView.adapter = ordersAdapter

        var btFloatingWindow: Button = findViewById(R.id.bt_floating_window);
        btFloatingWindow.setOnClickListener {
            if (!Settings.canDrawOverlays(this)) {
                startActivityForResult(
                    Intent(
                        Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:$packageName")
                    ), 0
                )
            } else {
                var windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager;
                var firstFire = FloatWindowSmallView(this)
                windowManager.addView(firstFire, firstFire.smallWindowParams)
//            moveTaskToBack(true)
//            val intent = Intent(this@Main2Activity, FloatWinfowServices::class.java)
//            hasBind = bindService(intent, mVideoServiceConnection, Context.BIND_AUTO_CREATE)
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0) {
            if (!Settings.canDrawOverlays(this)) {
                Toast.makeText(this, "授权失败", Toast.LENGTH_SHORT).show()
            } else {
//                    Handler().postDelayed({
//                        val intent = Intent(this@Main2Activity, FloatWinfowServices::class.java)
//                        intent.putExtra("rangeTime", rangeTime)
//                        hasBind = bindService(intent, mVideoServiceConnection, Context.BIND_AUTO_CREATE)
//                        moveTaskToBack(true)
//                    }, 1000)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume")
    }
}