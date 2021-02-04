package me.tsz.m3.sf

class OrderInfo(var address: String, var content: String) {
    fun display() {
        println("address:${address}\tcontent:${content}")
    }
}