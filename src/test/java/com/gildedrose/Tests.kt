package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate

class Tests {

    @Test
    internal fun test() {
        val stock = listOf<ItemMine>()
        assertEquals(
            listOf<ItemMine>(),
            stock
        )

        val newStock = stock + ItemMine("banana", LocalDate.now(), 42u)
        assertEquals(
            listOf(ItemMine("banana", LocalDate.now(), 42u)),
            newStock
        )
    }
}

