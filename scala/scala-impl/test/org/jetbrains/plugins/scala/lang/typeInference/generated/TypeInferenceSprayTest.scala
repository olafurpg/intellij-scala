package org.jetbrains.plugins.scala.lang.typeInference.generated

import org.jetbrains.plugins.scala.DependencyManagerBase._
import org.jetbrains.plugins.scala.base.libraryLoaders.{IvyManagedLoader, LibraryLoader}
import org.jetbrains.plugins.scala.lang.typeInference.TypeInferenceTestBase
import org.junit.Ignore

/**
  * @author Alefas
  * @since 11.12.12
  */
@Ignore("Spray is obsolete, remove or replace test with Akka-HTTP test") // TODO
class TypeInferenceSprayTest extends TypeInferenceTestBase {
  //This class was generated by build script, please don't change this
  override def folderPath: String = super.folderPath + "spray/"

  override protected def additionalLibraries(): Seq[LibraryLoader] =
    IvyManagedLoader("spray-routing" % "io.spray_2.11" % "1.3.1") :: Nil

  def testSCL8274(): Unit = doTest()
}