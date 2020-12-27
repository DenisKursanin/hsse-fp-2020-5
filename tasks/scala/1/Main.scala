package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) {
      return 1
    }
    pascal(c-1, r-1) + pascal(c, r-1)
  }

  /**
   * Exercise 2 Parentheses Balancing
   */
   def balance(chars: List[Char]): Boolean = {
    @tailrec
    def balanceWithCount(chars: List[Char], count: Int): Boolean = (chars, count) match {
      case (_, cnt) if cnt < 0 => false
      case (Nil, cnt) => cnt == 0
      case ('(' :: tail, cnt) => balanceWithCount(tail, cnt + 1)
      case (')' :: tail, cnt) => balanceWithCount(tail, cnt - 1)
      case (_ :: tail, cnt) => balanceWithCount(tail, cnt)
    }
    balanceWithCount(chars, 0)
  }

  /**
   * Exercise 3 Counting Change
   * Write a recursive function that counts how many different ways you can make
   * change for an amount, given a list of coin denominations. For example,
   * there is 1 way to give change for 5 if you have coins with denomiation
   * 2 and 3: 2+3.
   */
  def countChange(money: Int, coins: List[Int]): Int = (money, coins) match {
    case (rest, _) if rest == 0 => 1
    case (rest, cash) if rest < 0 || cash.isEmpty => 0
    case _ => countChange(money, coins.tail) + countChange(money - coins.head, coins)
  }
}
