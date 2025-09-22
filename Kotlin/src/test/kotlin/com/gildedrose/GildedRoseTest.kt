package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class GildedRoseTest {

    @ParameterizedTest
    @CsvSource(
        "Elixir of the Mongoose, 10, 30, 6, 24, 4",
        "Elixir of the Mongoose, 3, 30, 6, 21, -3",
        "Aged Brie, 10, 0, 2, 2, 8",
        "Aged Brie, 15, 40, 10, 50, 5",
        "Aged Brie, 5, 45, 10, 50, -5",
        "Aged Brie, 5, 20, 10, 35, -5",
        "'Sulfuras, Hand of Ragnaros', 2, 80, 30, 80, 2",
        "'Sulfuras, Hand of Ragnaros', 5, 80, 10, 80, 5",
        "'Sulfuras, Hand of Ragnaros', -1, 80, 5, 80, -1",
        "Backstage passes to a TAFKAL80ETC concert, 20, 5, 10, 15, 10",
        "Backstage passes to a TAFKAL80ETC concert, 15, 30, 7, 39, 8",
        "Backstage passes to a TAFKAL80ETC concert, 10, 35, 4, 43, 6",
        "Backstage passes to a TAFKAL80ETC concert, 5, 35, 4, 47, 1",
        "Backstage passes to a TAFKAL80ETC concert, 5, 48, 4, 50, 1"
    )
    fun `test updateQuality`(name: String, sellIn: Int, quality: Int, days: Int, qualityResult: Int, selInResult: Int) {
        val items = listOf(Item(name, sellIn, quality))
        val app = GildedRose(items)

        (1..days).map {
            app.processItemsForDay()
        }

        assertEquals(name, app.items[0].name)
        assertEquals(qualityResult, app.items[0].quality)
        assertEquals(selInResult, app.items[0].sellIn)
    }
}


