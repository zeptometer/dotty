@main def Test: Unit =
  println("case erased: " + testExpr { def erasedfn1(erased x: String) = "placeholder"; erasedfn1("arg1")})
  println("case erased nested: " + testExpr { def erasedfn2(p: Int)(erased q: Int) = p; erasedfn2(10)(0).toString() })
