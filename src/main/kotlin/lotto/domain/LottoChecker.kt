package lotto.domain

import lotto.domain.dto.LotteryWinningStatistics

class LottoChecker() {
    fun getWinNumStatistics(lottos: Lottos, winningNumbers: List<Int>, bonusBalls: Int = NO_BONUS_BALL): LotteryWinningStatistics {
        val statistics = mutableMapOf<LotteryPrizeAmount, Int>()
        val lottoList = lottos.lottoList
        lottoList.forEach { lotto: Lotto ->
            val lotteryPrize = getLotteryPrize(lotto, winningNumbers, bonusBalls)
            statistics[lotteryPrize] = statistics.getOrDefault(lotteryPrize, 0) + 1
        }
        return LotteryWinningStatistics(statistics)
    }

    fun getLotteryPrize(lotto: Lotto, winningNumbers: List<Int>, bonusBalls: Int = NO_BONUS_BALL): LotteryPrizeAmount {
        val lottoNums = lotto.numbers
        val winCount = lottoNums.intersect(winningNumbers).size
        val isContainBonus = lottoNums.contains(bonusBalls)
        return LotteryPrizeAmount.getWinningPrize(winCount, isContainBonus)
    }

    companion object {
        private const val NO_BONUS_BALL = 0
    }
}
