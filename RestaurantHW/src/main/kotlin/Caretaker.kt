class Caretaker {
    private val mementoList = mutableListOf<Memento>()
    fun saveState(originator: Originator) {
        mementoList.add(originator.createMemento())
    }
    fun undo(originator: Originator) {
        if (mementoList.isNotEmpty()) {
            val memento = mementoList.removeAt(mementoList.size - 1)
            originator.restore(memento)
        }
    }
}