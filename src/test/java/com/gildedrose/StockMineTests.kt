package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate

class StockMineTests {

    private val sellBy = LocalDate.parse("2022-07-21")

    @Test
    internal fun `add item to stock`() {
        val stock = listOf<ItemMine>()
        assertEquals(
            listOf<ItemMine>(),
            stock
        )

        val newStock = stock + ItemMine("banana", sellBy, 42u)
        assertEquals(
            listOf(ItemMine("banana", sellBy, 42u)),
            newStock
        )
    }
}
