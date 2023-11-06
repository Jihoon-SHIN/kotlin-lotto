package lotto.ui

class InputView {
    fun getNumbers(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun getBonusNumber(): Int {
        println("보너스 볼을 입력해주세요.")
        return readln().toInt()
    }

    fun getWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumbers = readln()
        return winningNumbers.split(", ")
            .toList()
            .map { it.toInt() }
    }
}
