@main def Test: Unit =
  println("case single: " + testExpr { def f(x: String) = "placeholder" + x; f("arg1") + " outside" })
  println("case no-param-method (will be eta-expanded): " + testExpr { def f(x: String) = "placeholder" + x; (() => f)()("placeholder 2") })
  println("case curried: " + testExpr { def f(x: String)(y: String) = "placeholder" + x; f("arg1")("arg2") + " outside" })
  def outer() = " outer-method"
  println("case methods from outer scope: " + testExpr { def f(x: String) = "placeholder" + x; f("arg1") + outer() })
  println("case polymorphic method: " + testExpr { def f[B](x: B) = List(); f[String]("arg").mkString(",") + " outside"})
  // separate test case?
  // println("case contextual params: " + testCtxParam { given String = "given"; def f(using t: String) = "placeholder"; f + " outside" })
