class MyQueue() {
    private val elements: MutableList<Int> = mutableListOf()
    fun push(x: Int) {
        elements.add(x)
    }

    fun pop(): Int {
        return elements.removeAt(0)
    }

    fun peek(): Int {
        return elements.first()
    }

    fun empty(): Boolean {
        return elements.isEmpty()
    }
}