package com.weiglewilczek.slf4s

trait LogUtilities {
  implicit def wrapAny[A](value: A) = new AnyWrapper(value)

  class AnyWrapper[A](value: A) {
    // TODO: Add a comment explaining the usage.
    def trace(message: => String, logFn: Logger => (=> String) => Unit = _.debug)
             (implicit logger: Logger): A = {
      logFn(logger)(message + ": " + value)
      value
    }
  }
}

object LogUtilities extends LogUtilities