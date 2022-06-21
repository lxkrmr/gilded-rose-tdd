package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate

class PrintingMineTests {

    private val now = LocalDate.parse("2022-07-21")

    @Test
    internal fun `print empty stock list`() {
        val stock = listOf<ItemMine>()
        val expected = listOf("21 July 2022")

        assertEquals(expected, stock.printout(now))
    }

    @Test
    internal fun `print non empty stock list`() {
        val stock = listOf(
            ItemMine("banana", now.minusDays(1), 42u),
            ItemMine("kumquat", now.plusDays(1), 101u)
        )
        val expected = listOf(
            "21 July 2022",
            "banana, -1, 42",
            "kumquat, 1, 101"
        )

        assertEquals(expected, stock.printout(now))
    }
}
