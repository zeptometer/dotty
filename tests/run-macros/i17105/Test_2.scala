@main def app: Unit =
  testExpr { def f(x: Int) = "hello" * x; f(0) + "bye" }
