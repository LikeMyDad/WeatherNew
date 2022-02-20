package lmd.pet.weathernew.core.base

interface EventHandler<T> {
    fun obtainEvent(event: T)
}