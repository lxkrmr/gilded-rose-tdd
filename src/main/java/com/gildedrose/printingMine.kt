package com.gildedrose

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.time.temporal.ChronoUnit


private val dateFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)

fun List<ItemMine>.printout(now: LocalDate): List<String> {
    return listOf(dateFormat.format(now)) +
        this.map { it.toPrintOut(now) }
}

private fun ItemMine.toPrintOut(now: LocalDate): String =
    "$name, ${daysUntilSellBy(now)}, $quality"

private fun ItemMine.daysUntilSellBy(now: LocalDate): Long =
    ChronoUnit.DAYS.between(now, sellByDate)
