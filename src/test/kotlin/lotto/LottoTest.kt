package lotto

import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.ints.shouldBeInRange
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoTest {
    private lateinit var lotto: Lotto

    @BeforeEach
    fun setUp() {
        lotto = Lotto()
    }

    @Test
    fun `로또는 6개의 번호를 가진다`() {
        lotto.numbers shouldHaveSize 6
    }

    @Test
    fun `로또 번호는 서로 다른 숫자로 이루어져있다`() {
        val numbers = lotto.numbers
        val distinct = numbers.distinct()

        numbers shouldHaveSize distinct.size
        numbers shouldContainAll distinct
    }

    @Test
    fun `로또 번호는 1~45 사이의 무작위 수이다`() {
        lotto.numbers.forAll {
            it shouldBeInRange 1..45
        }
    }
}
