package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class GildedRoseTest {

    @ParameterizedTest
    @CsvSource(
        "Aged Brie, 10, 0, 2, 2, 8",
        "Aged Brie, 15, 40, 10, 50, 5",
        "Aged Brie, 5, 45, 10, 50, -5",
        "Aged Brie, 5, 20, 10, 35, -5"
    )
    fun `test update aged brie`(name: String, sellIn: Int, quality: Int, days: Int, qualityResult: Int, selInResult: Int) {
        val items = listOf(Item(name, sellIn, quality))
        val app = GildedRose(items)

        (1..days).map {
            app.updateQuality()
        }

        assertEquals(name, app.items[0].name)
        assertEquals(qualityResult, app.items[0].quality)
        assertEquals(selInResult, app.items[0].sellIn)
    }
}


