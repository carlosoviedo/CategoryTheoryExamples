package ch1

object CompositionAndIdentity {
    def id[T] = (x: T) => x
    def compose[T,U,A](f: T => U, g: U => A) = (x:T) => g(f(x))
}