@main def Test: Unit =
  println("case single: " + testExpr { def f(x: String) = "placeholder" + x; f("arg1") + " outside" })
  println("case curried: " + testExpr { def f(x: String)(y: String) = "placeholder" + x; f("arg1")("arg2") + " outside" })
  def outer() = " outer-method"
  println("case methods from outer scope: " + testExpr { def f(x: String) = "placeholder" + x; f("arg1") + outer() })
