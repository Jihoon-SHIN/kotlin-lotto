package lotto.ui

import lotto.domain.LotteryPrizeAmount
import lotto.domain.dto.LotteryWinningStatistics

class ResultView {
    fun show(lotteryWinningStatistics: LotteryWinningStatistics) {
        println("당첨 통계")
        val statistics = lotteryWinningStatistics.statistics
        LotteryPrizeAmount.values()
            .forEach { prize ->
                val prizeAmount = statistics.getOrDefault(prize, 0)
                println("${prize.winNum} 개 일치 (${prize.prize}원)- $prizeAmount 개")
            }
    }
}
