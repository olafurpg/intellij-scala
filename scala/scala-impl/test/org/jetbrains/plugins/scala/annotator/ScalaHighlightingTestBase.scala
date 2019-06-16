package org.jetbrains.plugins.scala.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.psi.{PsiDocumentManager, PsiElement}
import org.jetbrains.plugins.scala.annotator.hints.AnnotatorHints
import org.jetbrains.plugins.scala.base.{AssertMatches, ScalaFixtureTestCase}
import org.jetbrains.plugins.scala.debugger.{ScalaVersion, Scala_2_11}
import org.jetbrains.plugins.scala.extensions.PsiElementExt

/**
  * @author Alefas
  * @since 23/03/16
  */
abstract class ScalaHighlightingTestBase extends ScalaFixtureTestCase with AssertMatches {

  private var filesCreated: Boolean = false

  override implicit val version: ScalaVersion = Scala_2_11

  protected def withHints = false

  def errorsFromScalaCode(scalaFileText: String): List[Message] = {
    if (filesCreated) throw new AssertionError("Don't add files 2 times in a single test")

    myFixture.configureByText("dummy.scala", scalaFileText)

    filesCreated = true

    PsiDocumentManager.getInstance(getProject).commitAllDocuments()

    val mock = new AnnotatorHolderMock(getFile)
    val annotator = getAnnotator

    getFile.depthFirst().foreach(annotator(_, mock))

    val messages = mock.annotations.filter {
      case Error(_, null) | Error(null, _) => false
      case Error(_, _) => true
      case _ => false
    }

    if (withHints) {
      val hints = getFile.elements
        .flatMap(AnnotatorHints.in(_).toSeq.flatMap(_.hints))
        .map(hint => Hint(hint.element.getText, hint.parts.map(_.string).mkString, "")).toList
      hints ::: messages
    } else {
      messages
    }
  }

  def getAnnotator: (PsiElement, AnnotationHolder) => Unit = ScalaAnnotator.forProject.annotate(_, _)
}
