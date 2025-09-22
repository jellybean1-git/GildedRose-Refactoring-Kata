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
                if (items[i].quality < MAX_QUALITY) {
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
            }

            if (items[i].name != SULFURAS.label) {
                items[i].sellIn = items[i].sellIn - 1
            }

            if (items[i].sellIn < 0) {
                if (items[i].name != AGED_BRIE.label) {
                    if (items[i].name != BACKSTAGE_PASSES.label) {
                        if (items[i].quality > 0) {
                            if (items[i].name != SULFURAS.label) {
                                decreaseQuality(items[i])
                            }
                        }
                    } else {
                        decreaseQuality(items[i])
                    }
                } else {
                    increaseQuality(items[i])
                }
            }
        }
    }

    fun increaseQuality(item: Item) {
        if (item.quality < MAX_QUALITY) {
            item.quality = item.quality + 1
        }
    }

    fun decreaseQuality(item: Item) {
        item.quality = item.quality - item.quality
    }
}

