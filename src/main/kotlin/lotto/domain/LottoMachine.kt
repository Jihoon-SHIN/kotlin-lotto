package lotto.domain

const val DEFAULT_LOTTO_PRICE = 1000
class LottoMachine(val lottoPrice: Int = DEFAULT_LOTTO_PRICE) {
    fun purchase(money: Int): Lottos {
        return Lottos(money / lottoPrice)
    }
}
