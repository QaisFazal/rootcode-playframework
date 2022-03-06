package controllers

import application.MatrixCalculatorApplication
import payloads.MatrixPayload.Matrix
import play.api.mvc._
import play.api.libs.json._

import javax.inject._
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
      _ => BadRequest(Json.obj("message" -> "Unable to parse the JSON to Matrix")),{
        case c: Matrix =>
          val firstArrayResult: Int = matrixCalculatorApplication.process(c.firstArray)
          val secondArrayResult: Int = matrixCalculatorApplication.process(c.secondArray)

          Ok(Json.obj("firstArrayTotal" -> firstArrayResult,"secondArrayTotal" -> secondArrayResult))
        case _ =>
          BadRequest(Json.obj("message" -> "Invalid payload"))

      }
    )
  }


}
