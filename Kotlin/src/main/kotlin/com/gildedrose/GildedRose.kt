package com.gildedrose

import com.gildedrose.ItemName.AGED_BRIE
import com.gildedrose.ItemName.BACKSTAGE_PASSES
import com.gildedrose.ItemName.CONJURED
import com.gildedrose.ItemName.SULFURAS
import com.gildedrose.domain.AgedBrie
import com.gildedrose.domain.BackstagePass
import com.gildedrose.domain.Conjured
import com.gildedrose.domain.CustomItem
import com.gildedrose.domain.Sulfuras

const val MAX_QUALITY = 50

class GildedRose(items: List<Item>) {
    val items: List<CustomItem>

    init {
        this.items = items.map {
            when (it.name) {
                AGED_BRIE.label -> AgedBrie(it.name, it.sellIn, it.quality)
                BACKSTAGE_PASSES.label -> BackstagePass(it.name, it.sellIn, it.quality)
                SULFURAS.label -> Sulfuras(it.name, it.sellIn, it.quality)
                CONJURED.label -> Conjured(it.name, it.sellIn, it.quality)
                else -> CustomItem(it.name, it.sellIn, it.quality)
            }
        }
    }

    fun processItemsForDay() {
        for (item in items) {

            item.updateQuality()
            updateSellIn(item)
        }
    }

    private fun updateSellIn(item: Item) {
        if (item.name != SULFURAS.label) {
            item.sellIn = item.sellIn - 1
        }
    }
}

