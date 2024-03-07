class Originator(var state:State) {
    fun createMemento(): Memento {
        return Memento(state)
    }
    fun restore(memento: Memento) {
        state = memento.state
    }
}