package lotto.domain.dto

import lotto.domain.LotteryPrizeAmount

data class LotteryWinningStatistics(val statistics: Map<LotteryPrizeAmount, Int>)
