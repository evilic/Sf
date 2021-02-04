package me.tsz.m3.sf

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * https://developer.android.google.cn/guide/topics/ui/layout/recyclerview#plan-your-layout
 */
class OrderDetailAdapter(private val dataSet: List<OrderInfo>) :
    RecyclerView.Adapter<OrderDetailAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     * 传过来一个 View 对象
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvAddress: TextView = view.findViewById(R.id.tvOrderAddress)
        val tvContent: TextView = view.findViewById(R.id.tvOrderContent)
    }

    /**
     * 每当 RecyclerView 需要创建新的 ViewHolder 时，它都会调用此方法。
     *
     * 此方法会创建并初始化 ViewHolder 及其关联的 View，但不会填充视图的内容，
     * 因为 ViewHolder 此时尚未绑定到具体数据。
     */
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // TODO 这里还没有搞清楚各个参数的含义，viewGroup 和 viewType 是啥J8东西？
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.order_card_item, viewGroup, false)
        return ViewHolder(view)
    }

    /**
     * RecyclerView 调用此方法将 ViewHolder 与数据相关联。
     * 此方法会提取适当的数据，并使用该数据填充 ViewHolder 的布局。
     */
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // 根据 position，得到数据源的中的数据。然后替换对应视图中的对象
        viewHolder.tvAddress.text = dataSet[position].address
        viewHolder.tvContent.text = dataSet[position].content
    }

    /**
     * RecyclerView 调用此方法来获取数据集的大小。
     * RecyclerView 使用此方法来确定什么时候没有更多的列表项可以显示。
     */
    override fun getItemCount() = dataSet.size
}