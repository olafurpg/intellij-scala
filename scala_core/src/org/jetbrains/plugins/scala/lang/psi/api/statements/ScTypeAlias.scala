package org.jetbrains.plugins.scala.lang.psi.api.statements

import psi.ScalaPsiElement
import toplevel.ScNamedElement
import toplevel.typedef.ScMember
import types.ScType

/**
* @author Alexander Podkhalyuzin
* Date: 22.02.2008
* Time: 9:46:00
*/

trait ScTypeAlias extends ScNamedElement with ScMember {
  def lowerBound() : ScType
  def upperBound() : ScType
}