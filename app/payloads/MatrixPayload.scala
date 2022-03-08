package payloads

import ai.x.play.json.Encoders.encoder
import ai.x.play.json.Jsonx
import play.api.libs.json.Format


object MatrixPayload {

  case class Matrix(firstArray: List[List[Int]])

  object Matrix {
    implicit lazy val jsonFormatMatrix: Format[Matrix] = Jsonx.formatCaseClass[Matrix]
  }
}
