package com.devyn.scala.data.structures

/**
  * Created by devyn on 1/10/16.
  */

case class MyFirstClass(id: Long, name: String, otherIds: Seq[String])
case class MyRelationship(id: Long, name: String, otherId: String)
class NotACaseClass(val id: Long, val name: String, val otherId: String)