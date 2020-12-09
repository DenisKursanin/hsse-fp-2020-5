import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {

    // 1
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row) {
        print(pascal(col, row) + " ")
      }
      println()
    }
    println()
    // 2
    val list1 = List('(', '(', '(', '(', '_', '_', '_', ')', ')', ')', ')')
    println(s"Balance for ((((___)))) = ${balance(list1)}")

    val list2 = List('(', '(', '(', '(', '_', '_', '_', ')', ')', ')', ')', ')')
    println(s"Balance for ((((___))))) = ${balance(list2)}")
    println()
    // 3
    val list3 = List(2, 3)
    println(s"there is ${countChange(5, list3)} way to give change for 5 if you have coins with denomination 2 and 3")


    val list4 = List(1, 2, 3)
    println(s"there is ${countChange(5, list4)} ways to give change for 5 if you have coins with denomination 1, 2 and 3")
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) {
      return 1
    }
    pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2 Parentheses Balancing
   */
  def balance(chars: List[Char]): Boolean = {

    @tailrec
    def balance(chars: List[Char], dif: Int): Boolean = {
      if (chars.isEmpty) dif == 0

      else if (dif < 0) false
      else chars.head match {
        case '(' => balance(chars.tail, dif + 1)
        case ')' => balance(chars.tail, dif - 1)
        case _ => balance(chars.tail, dif)
      }
    }

    balance(chars, 0)
  }

  /**
   * Exercise 3 Counting Change
   * Write a recursive function that counts how many different ways you can make
   * change for an amount, given a list of coin denominations. For example,
   * there is 1 way to give change for 5 if you have coins with denomination
   * 2 and 3: 2+3.
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def count(money: Int, coins: List[Int]): Int = {
      if (coins.isEmpty) 0
      else if (money - coins.head == 0) 1
      else if (money - coins.head < 0) 0
      else countChange(money - coins.head, coins) + countChange(money, coins.tail)
    }

    count(money, coins.sorted)
  }
}