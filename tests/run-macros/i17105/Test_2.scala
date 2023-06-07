import reflect.Selectable.reflectiveSelectable

class Hoe { def f(x: Int): String = s"Hoe got ${x}" }

@main def Test: Unit =
  println("case single: " + testExpr { def f(x: String) = "placeholder" + x; f("arg1") + " outside" })
  println("case no-param-method (will be eta-expanded): " + testExpr { def f(x: String) = "placeholder" + x; (() => f)()("placeholder 2") })
  println("case curried: " + testExpr { def f(x: String)(y: String) = "placeholder" + x; f("arg1")("arg2") + " outside" })
  def outer() = " outer-method"
  println("case methods from outer scope: " + testExpr { def f(x: String) = "placeholder" + x; f("arg1") + outer() })
  println("case refinement: " + testExpr { def p(a: { def f(x: Int): String }): String = a.f(1); p(Hoe()) })
