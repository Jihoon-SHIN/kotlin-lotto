package lotto.domain

import lotto.domain.dto.LotteryWinningStatistics

class LottoChecker() {
    fun getLotteryPrize(lotto: Lotto, winningNumbers: List<Int>, bonusBalls: Int = NO_BONUS_BALL): LotteryPrizeAmount {
        val lottoNums = lotto.numbers
        val winCount = lottoNums.intersect(winningNumbers).size
        return LotteryPrizeAmount.getWinningPrize(winCount)
    }

    fun getWinNumStatistics(lottos: Lottos, winningNumbers: List<Int>): LotteryWinningStatistics {
        val statistics = mutableMapOf<LotteryPrizeAmount, Int>()
        val lottoList = lottos.lottoList
        lottoList.forEach { lotto: Lotto ->
            val lotteryPrize = getLotteryPrize(lotto, winningNumbers)
            statistics[lotteryPrize] = statistics.getOrDefault(lotteryPrize, 0) + 1
        }
        return LotteryWinningStatistics(statistics)
    }

    companion object {
        private const val NO_BONUS_BALL = 0
    }
}
