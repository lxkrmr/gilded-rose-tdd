package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PassesUpdatingTests {

    @Test fun `increases in quality by one every day until 10 days to sell by date`() {
        assertEquals(
            itemOf("Backstage Passes", oct29, 43),
            itemOf("Backstage Passes", oct29, 42).updatedBy(days = 1, on = oct29.minusDays(10))
        )
    }

    @Test fun `increases in quality by two every day from 10 to 5 days to sell by date`() {
        assertEquals(
            itemOf("Backstage Passes", oct29, 44),
            itemOf("Backstage Passes", oct29, 42).updatedBy(days = 1, on = oct29.minusDays(9))
        )
        assertEquals(
            itemOf("Backstage Passes", oct29, 44),
            itemOf("Backstage Passes", oct29, 42).updatedBy(days = 1, on = oct29.minusDays(5))
        )
    }

    @Test fun `increases in quality by three every day from 5 days to sell by date`() {
        assertEquals(
            itemOf("Backstage Passes", oct29, 45),
            itemOf("Backstage Passes", oct29, 42).updatedBy(days = 1, on = oct29.minusDays(4))
        )
        assertEquals(
            itemOf("Backstage Passes", oct29, 45),
            itemOf("Backstage Passes", oct29, 42).updatedBy(days = 1, on = oct29)
        )
    }

    @Test fun `degrades completely after the sell by date`() {
        assertEquals(
            itemOf("Backstage Passes", oct29, 0),
            itemOf("Backstage Passes", oct29, 42).updatedBy(days = 1, on = oct29.plusDays(1))
        )
        assertEquals(
            itemOf("Backstage Passes", oct29, 0),
            itemOf("Backstage Passes", oct29, 42).updatedBy(days = 1, on = oct29.plusDays(2))
        )
    }

    @Test fun `doesn't get better than 50`() {
        assertEquals(
            itemOf("Backstage Passes", oct29, 50),
            itemOf("Backstage Passes", oct29, 49).updatedBy(days = 1, on = oct29)
        )
    }
}
