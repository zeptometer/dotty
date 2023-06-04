@main def Test: Unit =
  println(testExpr { def f(x: String) = "placeholder" + x; f("1st") + " 2nd" })
