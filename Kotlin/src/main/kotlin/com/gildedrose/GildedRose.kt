package com.gildedrose

import com.gildedrose.ItemName.AGED_BRIE
import com.gildedrose.ItemName.BACKSTAGE_PASSES
import com.gildedrose.ItemName.SULFURAS
import com.gildedrose.domain.BackstagePass

const val MAX_QUALITY = 50

class GildedRose(val items: List<Item>) {

    fun updateQuality() {
        for (item in items) {
            val isAgedBrie = item.name == AGED_BRIE.label
            val isBackstagePasses = item.name == BACKSTAGE_PASSES.label
            val isSulfuras = item.name == SULFURAS.label

            if (!isAgedBrie && !isBackstagePasses) {
                if (item.quality > 0) {
                    if (!isSulfuras) {
                        decreaseQuality(item)
                    }
                }
            } else {
                increaseQuality(item)

                if (isBackstagePasses) {
                    if (item.sellIn < 11) {
                        increaseQuality(item)
                    }

                    if (item.sellIn < 6) {
                        increaseQuality(item)
                    }
                }
            }

            updateSellIn(item)

            if (item.sellIn < 0) {
                if (!isAgedBrie) {
                    if (!isBackstagePasses) {
                        if (item.quality > 0) {
                            if (!isSulfuras) {
                                decreaseQuality(item)
                            }
                        }
                    } else {
                        item.quality = 0
                    }
                } else {
                    increaseQuality(item)
                }
            }
        }
    }

    private fun increaseQuality(item: Item) {
        if (item.quality < MAX_QUALITY) {
            item.quality = item.quality + 1
        }
    }

    private fun decreaseQuality(item: Item) {
        item.quality = item.quality - 1
    }

    private fun updateSellIn(item: Item) {
        if (item.name != SULFURAS.label) {
            item.sellIn = item.sellIn - 1
        }
    }
}

