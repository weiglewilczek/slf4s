package com.weiglewilczek.slf4s

trait LogUtilities {
  implicit def wrapAny[A](value: A) = new AnyWrapper(value)

  class AnyWrapper[A](value: A) {

    // This is a logging version of Kestrel combinator.
    // This method is very similar to `tap` method in Ruby. It prints the object (along with the given message)
    // on which the method was invoked, and evaluates to the same object. It is used to tap into method chains,
    // in order to inspect the values of object at various stages in processing.
    //
    // Example:
    //   List.range(1, 10).trace("Original")
    //       .map(2 *).trace("After mapping")
    //       .filter(4 <).trace("After filtering")
    //       .size.trace("Size")
    //
    // The default logging method invoked is `debug`. It is easy to invoke other logging methods instead, if
    // so required.
    //
    // Example:
    //   List.range(1, 10).trace("Original", _.info)
    def trace(message: => String, logFn: Logger => (=> String) => Unit = _.debug)
             (implicit logger: Logger): A = {
      logFn(logger)(message + ": " + value)
      value
    }
  }
}

object LogUtilities extends LogUtilities