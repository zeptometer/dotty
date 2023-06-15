@main def Test: Unit =
  println("case erased: " + testExpr { def erasedfn1(erased x: String) = "placeholder"; erasedfn1("arg1")})
