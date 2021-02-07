package me.tsz.m3.sf.bean

import me.tsz.m3.sf.bean.Good

class Item(goodSpec: Good, goodCount: Int) {
    var good = goodSpec
    var count = goodCount
}