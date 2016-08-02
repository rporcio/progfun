package calculator

sealed abstract class Expr
final case class Literal(v: Double) extends Expr
final case class Ref(name: String) extends Expr
final case class Plus(a: Expr, b: Expr) extends Expr
final case class Minus(a: Expr, b: Expr) extends Expr
final case class Times(a: Expr, b: Expr) extends Expr
final case class Divide(a: Expr, b: Expr) extends Expr

object Calculator {
  def computeValues(
    namedExpressions: Map[String, Signal[Expr]]): Map[String, Signal[Double]] = {
    namedExpressions map {
      case (name, expr) => (name -> Var(eval(expr(), namedExpressions)))
    }
  }

  def eval(expr: Expr, references: Map[String, Signal[Expr]]): Double = {
    def evalWithReferences(expr: Expr, references: Map[String, Signal[Expr]], referenced: Set[String]): Double = {
      expr match {
        case Literal(v) => v
        case Ref(name) =>
          if (referenced contains name) Double.NaN
          else evalWithReferences(getReferenceExpr(name, references), references, referenced + name)
        case Plus(a, b) =>
          evalWithReferences(a, references, referenced) + evalWithReferences(b, references, referenced)
        case Minus(a, b) =>
          evalWithReferences(a, references, referenced) - evalWithReferences(b, references, referenced)
        case Times(a, b) =>
          evalWithReferences(a, references, referenced) * evalWithReferences(b, references, referenced)
        case Divide(a, b) =>
          evalWithReferences(a, references, referenced) / evalWithReferences(b, references, referenced)
      }
    }

    evalWithReferences(expr, references, Set())
  }

  /**
   * Get the Expr for a referenced variables.
   *  If the variable is not known, returns a literal NaN.
   */
  private def getReferenceExpr(name: String,
    references: Map[String, Signal[Expr]]) = {
    references.get(name).fold[Expr] {
      Literal(Double.NaN)
    } { exprSignal =>
      exprSignal()
    }
  }
}
