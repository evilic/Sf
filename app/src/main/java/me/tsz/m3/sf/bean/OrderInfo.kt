package me.tsz.m3.sf.bean

class OrderInfo(var address: String, var content: String) {
    fun display() {
        println("address:${address}\tcontent:${content}")
    }
}