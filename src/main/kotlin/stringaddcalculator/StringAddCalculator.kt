package stringaddcalculator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return 0
        }
        val tokens = parse(text)
        return addListElements(tokens)
    }

    private fun parse(text: String): List<String> {
        val customDelimiterGroup = Regex("//(.)\n(.*)").find(text)
        val basicPattern = "[,:]"

        customDelimiterGroup?.let {
            val customDelimiter = it.groupValues[1]
            val customRegex = "[$basicPattern$customDelimiter]".toRegex()
            return it.groupValues[2].split(customRegex)
        }

        val basicRegex = basicPattern.toRegex()
        return text.split(basicRegex)
    }

    private fun addListElements(list: List<String>): Int {
        val intTokens = list.map { it.toIntOrNull() ?: throw NumberFormatException("'$it'는 정수로 변환될 수 없습니다.") }
        if (intTokens.any { it < 0 }) {
            throw RuntimeException("음수는 불가능합니다.")
        }
        return list.sumOf { it -> it.toInt() }
    }
}
