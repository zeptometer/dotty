@main def Test: Unit =
  println("case single: " + testExpr { def f(x: String) = "placeholder" + x; f("1st") + " outside" })
  println("case curried: " + testExpr { def f(x: String)(y: String) = "placeholder" + x; f("1st")("2nd") + " outside" })
  def outer() = "outside-method"
  println("case methods from outer scope " + testExpr { def f(x: String) = "placeholder" + x; f("1st") + outer() })
