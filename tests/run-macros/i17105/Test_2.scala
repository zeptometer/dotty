@main def Test: Unit =
  println("test single: " + testExpr { def f(x: String) = "placeholder" + x; f("arg1") + " outside" })
  println("test curried: " + testExpr { def f(x: String)(y: String) = "placeholder" + x; f("arg1")("args2") + " outside" })
