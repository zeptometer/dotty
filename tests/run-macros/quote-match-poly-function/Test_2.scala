@main def Test: Unit =
    println(testExpr([B] => (x : Int, y : Int) => x + y)) // Should match case 2
    println(testExpr([B] => (x : B, y : B) => x)) // Should match case 3
    println(testExpr([B] => (x : B, y : B) => (y, x))) // Should match case 4
