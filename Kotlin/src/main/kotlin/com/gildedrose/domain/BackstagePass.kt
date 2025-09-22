package com.gildedrose.domain

import com.gildedrose.MAX_QUALITY

class BackstagePass(name: String, sellIn: Int, quality: Int) : CustomItem(name, sellIn, quality) {

    override fun updateQuality() {
        if (quality < MAX_QUALITY) {
            when {
                sellIn < 0 -> quality = 0
                sellIn <= 5 -> quality += 3
                sellIn <= 10 -> quality += 2
                else -> quality += 1
            }

            if (quality > MAX_QUALITY) {
                quality = 50
            }
        }
    }
}