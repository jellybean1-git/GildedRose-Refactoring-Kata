package com.gildedrose.domain

import com.gildedrose.MAX_QUALITY

class AgedBrie(name: String, sellIn: Int, quality: Int) : CustomItem(name, sellIn, quality) {

    override fun updateQuality() {
        if (sellIn <= 0) {
            quality += 2
        } else if (quality < MAX_QUALITY) {
            quality += 1
        }

        if (quality > MAX_QUALITY) {
            quality = 50
        }
    }
}