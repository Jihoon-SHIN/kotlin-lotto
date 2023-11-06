package lotto.ui

import lotto.domain.LotteryPrizeAmount

class ResultView {
    fun show(statistics: Map<LotteryPrizeAmount, Int>) {
        println("당첨 통계")

        LotteryPrizeAmount.values()
            .forEach { prize ->
                val prizeAmount = statistics.getOrDefault(prize, 0)
                println("${prize.winNum} 개 일치 (${prize.prize}원)- $prizeAmount 개")
            }
    }
}
