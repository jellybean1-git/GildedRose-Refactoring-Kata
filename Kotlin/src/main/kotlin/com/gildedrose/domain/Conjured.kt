package com.gildedrose.domain

class Conjured(name: String, sellIn: Int, quality: Int) : CustomItem(name, sellIn, quality) {
    override fun updateQuality() {
        if (sellIn <= 0) {
            quality -= 4
        } else {
            quality -= 2
        }

        if (quality < 0) {
            quality = 0
        }
    }
}