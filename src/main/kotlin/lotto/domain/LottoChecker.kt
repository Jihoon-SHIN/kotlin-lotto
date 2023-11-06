package lotto.domain

import lotto.domain.dto.LotteryWinningStatistics

class LottoChecker() {
    fun getWinNum(lotto: Lotto, winningNumbers: List<Int>): Int {
        val lottoNums = lotto.numbers
        return lottoNums.intersect(winningNumbers).size
    }

    fun getWinNumStatistics(lottos: Lottos, winningNumbers: List<Int>): LotteryWinningStatistics {
        val statistics = mutableMapOf<LotteryPrizeAmount, Int>()
        val lottoList = lottos.lottoList
        lottoList.forEach { lotto: Lotto ->
            val winNum = getWinNum(lotto, winningNumbers)
            val winningPrize = LotteryPrizeAmount.getWinningPrize(winNum)
            statistics[winningPrize] = statistics.getOrDefault(winningPrize, 0) + 1
        }
        return LotteryWinningStatistics(statistics)
    }
}
