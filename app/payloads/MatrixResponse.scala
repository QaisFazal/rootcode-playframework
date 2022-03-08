package payloads

import ai.x.play.json.Jsonx
import ai.x.play.json.Encoders.encoder
import play.api.libs.json.Format

object MatrixResponse {
  case class MatrixResponse(sumOfRows: List[Int])

  object MatrixResponse {
    implicit lazy val jsonResponseFormatMatrix: Format[MatrixResponse] = Jsonx.formatCaseClass[MatrixResponse]
  }
}
