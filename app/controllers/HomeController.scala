package controllers

import application.MatrixCalculatorApplication
import payloads.MatrixPayload.Matrix
import payloads.MatrixResponse.MatrixResponse
import play.api.mvc._
import play.api.libs.json._

import javax.inject._
import scala.collection.mutable.ListBuffer
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents,matrixCalculatorApplication: MatrixCalculatorApplication) extends BaseController {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def calculate(): Action[JsValue] = Action(parse.json) { implicit request =>
    request.body.validate[Matrix].fold(
      _ => BadRequest(Json.obj("message" -> "Unable to parse the JSON from Matrix")),{
        case c: Matrix if c.firstArray.length == 4 =>
          val sumOfIndividualRows = ListBuffer.empty[Int] //Append and prepend operations are constant time

          try{
            for (item <- c.firstArray) yield sumOfIndividualRows += matrixCalculatorApplication.process(item)
            Ok(Json.toJson(MatrixResponse(sumOfIndividualRows.result())))
          } catch {
            case e: Exception => BadRequest(Json.obj("errorMessage" -> e.getMessage))
          }
        case _ =>
          BadRequest(Json.obj("message" -> "4x4 Matrix contains only 3 rows"))

      }
    )
  }


}
