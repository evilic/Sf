package me.tsz.m3.sf.xy.floatwindow

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

/**
 * https://developer.android.google.cn/guide/components/services
 *
 * 虽然本文档分开概括讨论启动服务和绑定服务，但您的服务可同时以这两种方式运行，
 * 换言之，它既可以是启动服务（以无限期运行），亦支持绑定。
 *
 * 唯一的问题在于您是否实现一组回调方法：onStartCommand()（让组件启动服务）和 onBind()（实现服务绑定）。
 */
class FloatWindowSrv : Service() {
//    Service
//    这是适用于所有服务的基类。
//    扩展此类时，您必须创建用于执行所有服务工作的新线程，因为服务默认使用应用的主线程，这会降低应用正在运行的任何 Activity 的性能。

//    IntentService
//    这是 Service 的子类，其使用工作线程逐一处理所有启动请求。
//    如果您不要求服务同时处理多个请求，此类为最佳选择。
//    实现 onHandleIntent()，该方法会接收每个启动请求的 Intent，以便您执行后台工作。

    /**
     * 让组件启动服务。
     *
     * 当另一个组件（如 Activity）请求启动服务时，系统会通过调用 startService() 来调用此方法。
     * 执行此方法时，服务即会启动并可在后台无限期运行。
     *
     * 如果您实现此方法，则在服务工作完成后，您需负责通过调用 stopSelf() 或 stopService() 来停止服务。
     * （如果您只想提供绑定，则无需实现此方法。）
     */
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show()
        /*
        注意：默认情况下，服务与服务声明所在的应用运行于同一进程，并且运行于该应用的主线程中。
        如果服务在用户与来自同一应用的 Activity 进行交互时执行密集型或阻止性操作，则会降低 Activity 性能。
        为避免影响应用性能，请在服务内启动新线程。
         */

        stopSelf() // TODO

        /*
        请注意，onStartCommand() 方法必须返回整型数。
        整型数是一个值，用于描述系统应如何在系统终止服务的情况下继续运行服务。
        IntentService 的默认实现会为您处理此情况，但您可以对其进行修改。

        从 onStartCommand() 返回的值必须是以下常量之一：
        START_NOT_STICKY
        START_STICKY
        START_REDELIVER_INTENT
         */
        return START_STICKY
    }

    /**
     * 当不再使用服务且准备将其销毁时，系统会调用此方法。
     * 服务应通过实现此方法来清理任何资源，如线程、注册的侦听器、接收器等。
     * 这是服务接收的最后一个调用。
     */
    override fun onDestroy() {
        Toast.makeText(this, "service done", Toast.LENGTH_SHORT).show()
        super.onDestroy()
    }

    /**
     * 实现服务绑定。
     *
     * 当另一个组件想要与服务绑定（例如执行 RPC）时，系统会通过调用 bindService() 来调用此方法。
     * 在此方法的实现中，您必须通过返回 IBinder 提供一个接口，以供客户端用来与服务进行通信。
     *
     * 请务必实现此方法；但是，如果您并不希望允许绑定，则应返回 null。
     */
    override fun onBind(intent: Intent): IBinder? {
        // We don't provide binding, so return null
        return null
    }
}