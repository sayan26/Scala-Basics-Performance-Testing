package InternetBill

class generateBill (planName: String) {

  val rate: Int = planName match {
    case x if "monthly" contains x => 499
    case x if "Monthly" contains x => 499
    case x if "quarterly" contains x => 1399
    case x if "Quarterly" contains x => 1399
    case x if "yearly" contains x => 4999
    case x if "Yearly" contains x => 4999
    case _ => 0
  }

  val discount: Double = rate match {
    case y if 0 to 499 contains y => 0.05
    case y if 500 to 1399 contains y => 0.10
    case y if 1400 to 4999 contains y => 0.15
  }

  def totalBill(): Double  = rate - (rate*discount)

  def displayBill(billAmount: Double): Unit ={
    println(s"Your have selected: $planName plan and your bill will be: $billAmount after discount")
  }

}

object Main{
  def main(args : Array[String]): Unit ={
    val bill = new generateBill("Monthly")
    bill.displayBill(bill.totalBill())
  }
}
