package com.gildedrose.domain

import com.gildedrose.Item
import com.gildedrose.MAX_QUALITY

open class CustomItem(
    name: String,
    sellIn: Int,
    quality: Int
) : Item(name, sellIn, quality) {
    open fun updateQuality() {
        if (sellIn <= 0) {
            quality -= 2
        } else {
            quality -= 1
        }

        if (quality < 0) {
            quality = 0
        }
    }
}