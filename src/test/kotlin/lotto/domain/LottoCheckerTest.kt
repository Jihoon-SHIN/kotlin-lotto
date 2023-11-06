package lotto.domain

import io.kotest.matchers.shouldBe
import lotto.domain.LotteryPrizeAmount.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoCheckerTest {
    private lateinit var lottoChecker: LottoChecker

    @BeforeEach
    fun setUp() {
        lottoChecker = LottoChecker()
    }

    @Test
    fun `당첨 번호가 주어졌을 때, 로또가 등 수를  알 수 있다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val prize = lottoChecker.getLotteryPrize(lotto, listOf(1, 2, 3, 9, 10, 11))
        prize shouldBe FIFTH
    }

    @Test
    fun `로또가 여러 개 존재할 때, 당첨번호가 주어졌을 때 통계를 리턴할 수 있습니다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lotto1 = Lotto(listOf(1, 2, 3, 11, 12, 13))
        val lotto2 = Lotto(listOf(1, 2, 14, 15, 16, 17))

        val lottos = Lottos(listOf(lotto, lotto1, lotto2))

        val winNumStatistics = lottoChecker.getWinNumStatistics(lottos, listOf(1, 2, 3, 4, 5, 6))
        val statistics = winNumStatistics.statistics
        statistics.get(FIRST) shouldBe 1
    }

    @Test
    fun `당첨 번호와 보너스 볼이 주어졌을 때, 2등을 찾을 수 있다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val prize = lottoChecker.getLotteryPrize(lotto, listOf(1, 2, 3, 4, 5, 7), 6)
        prize shouldBe SECOND
    }
}
