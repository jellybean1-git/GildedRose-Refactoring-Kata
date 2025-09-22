package com.gildedrose

import com.gildedrose.ItemName.AGED_BRIE
import com.gildedrose.ItemName.BACKSTAGE_PASSES
import com.gildedrose.ItemName.SULFURAS

const val MAX_QUALITY = 50

class GildedRose(val items: List<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            if (items[i].name != AGED_BRIE.label && items[i].name != BACKSTAGE_PASSES.label) {
                if (items[i].quality > 0) {
                    if (items[i].name != SULFURAS.label) {
                        decreaseQuality(items[i])
                    }
                }
            } else {
                increaseQuality(items[i])

                if (items[i].name == BACKSTAGE_PASSES.label) {
                    if (items[i].sellIn < 11) {
                        increaseQuality(items[i])
                    }

                    if (items[i].sellIn < 6) {
                        increaseQuality(items[i])
                    }
                }
            }

            updateSellIn(items[i])

            if (items[i].sellIn < 0) {
                if (items[i].name != AGED_BRIE.label) {
                    if (items[i].name != BACKSTAGE_PASSES.label) {
                        if (items[i].quality > 0) {
                            if (items[i].name != SULFURAS.label) {
                                decreaseQuality(items[i])
                            }
                        }
                    } else {
                        items[i].quality = 0
                    }
                } else {
                    increaseQuality(items[i])
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

