package application

class MatrixCalculatorApplication {

  def process(m: List[Int]): Int = {
    if (m.length != 4) {
      throw new Exception("An array in the matrix contains elements less than 4.")
    } else
      m.sum

  }
}
