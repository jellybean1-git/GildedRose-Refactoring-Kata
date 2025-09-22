package com.gildedrose

import com.gildedrose.ItemName.AGED_BRIE
import com.gildedrose.ItemName.BACKSTAGE_PASSES
import com.gildedrose.ItemName.SULFURAS

const val MAX_QUALITY = 50

class GildedRose(val items: List<Item>) {

    fun updateQuality() {
        for (item in items) {
            if (item.name != AGED_BRIE.label && item.name != BACKSTAGE_PASSES.label) {
                if (item.quality > 0) {
                    if (item.name != SULFURAS.label) {
                        decreaseQuality(item)
                    }
                }
            } else {
                increaseQuality(item)

                if (item.name == BACKSTAGE_PASSES.label) {
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
                if (item.name != AGED_BRIE.label) {
                    if (item.name != BACKSTAGE_PASSES.label) {
                        if (item.quality > 0) {
                            if (item.name != SULFURAS.label) {
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

