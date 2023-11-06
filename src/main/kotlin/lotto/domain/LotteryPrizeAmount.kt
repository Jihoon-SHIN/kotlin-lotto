package lotto.domain

enum class LotteryPrizeAmount(val winNum: Int, val prize: Int) {
    MISS0(0, 0),
    MISS1(1, 0),
    MISS2(2, 0),
    FIFTH(3, 5000),
    FOURTH(4, 5000),
    THIRD(5, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000),
    ;

    companion object {
        fun getWinningPrize(winNum: Int): Int {
            return values().find { it.winNum == winNum }?.prize ?: 0
        }
    }
}
