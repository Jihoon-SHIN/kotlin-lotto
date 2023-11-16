package lotto.domain

import lotto.domain.dto.WinningResult
import lotto.domain.dto.WinningResults

class WinningLotto(private val winningNumbers: List<Int>, private val bonusNumber: LottoNumber) {
    private val winLotto: Lotto = Lotto(winningNumbers.toSet())

    init {
        validateBonusBall()
    }

    fun match(userLotto: Lotto): LotteryPrizeAmount {
        val count = userLotto.countMatchNumber(winLotto)
        val bonusMatch = userLotto.hasLottoNumber(bonusNumber)
        return LotteryPrizeAmount.getWinningPrize(count, bonusMatch)
    }

    fun matchLottosResult(lottos: Lottos): WinningResults {
        val lottoList = lottos.lottoList
        val statistics = mutableMapOf<LotteryPrizeAmount, Int>()
        val resultList = mutableListOf<WinningResult>()
        lottoList.forEach { lotto: Lotto ->
            val lotteryPrize = match(lotto)
            statistics[lotteryPrize] = statistics.getOrDefault(lotteryPrize, 0) + 1
        }

        LotteryPrizeAmount.values()
            .forEach {
                val count = statistics.getOrDefault(it, 0)
                val result = WinningResult(it.winNum, it.prize, count)
                resultList.add(result)
            }
        return WinningResults(resultList)
    }

    private fun validateBonusBall() {
        if (winLotto.hasLottoNumber(bonusNumber)) {
            throw IllegalArgumentException("보너스 볼은 당첨 번호 중 하나와 같을 수 없습니다.")
        }
    }
}
