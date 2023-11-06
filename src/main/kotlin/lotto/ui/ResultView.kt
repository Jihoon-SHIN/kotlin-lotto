package lotto.ui

import lotto.domain.LotteryPrizeAmount
import lotto.domain.dto.LotteryWinningStatistics

class ResultView {
    fun show(lotteryWinningStatistics: LotteryWinningStatistics, money: Int) {
        println("당첨 통계")
        val statistics = lotteryWinningStatistics.statistics
        var prizeSum = 0
        LotteryPrizeAmount.values()
            .forEach { prize ->
                val prizeAmount = statistics.getOrDefault(prize, 0)
                if (prizeAmount != 0) prizeSum += prize.prize
                println("${prize.winNum} 개 일치 ${if (prize == LotteryPrizeAmount.SECOND) "보너스 볼 일치" else ""} (${prize.prize}원)- $prizeAmount 개")
            }
        println("총 수익률은 ${prizeSum.toFloat() / money}")
    }
}
