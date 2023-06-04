@main def Test: Unit =
  println("case single: " + testExpr { def f(x: String) = "placeholder" + x; f("arg1") + " outside" })
  println("case curried: " + testExpr { def f(x: String)(y: String) = "placeholder" + x; f("arg1")("arg2") + " outside" })
  def outer() = " outer-method"
  println("case methods from outer scope: " + testExpr { def f(x: String) = "placeholder" + x; f("arg1") + outer() })
  println("case contextual params: " + testExpr { given String = "given"; def f(using t: String) = "placeholder"; f + " outside" })
