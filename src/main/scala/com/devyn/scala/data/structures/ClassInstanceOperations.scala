package com.devyn.scala.data.structures

import scala.collection.immutable
import scala.collection.immutable.SortedMap

/**
  * Created by devyn on 1/10/16.
  */
object ClassInstanceOperations {

  /**
    * create a new instance of MyFirstClass
    * @param id
    * @param name
    * @param otherIds
    * @return a new instance of MyFirstClass
    */
  def createMyFirstClass(id: Long, name: String, otherIds: Seq[String]): MyFirstClass = {
    MyFirstClass.apply(id, name, otherIds)
  }

  /**
    * Compare two instances of MyFirstClass for equality
    *
    * @param thisOne
    * @param thatOne
    * @return true if they are the same
    */
  def compareMyFirstClassEquality(thisOne: MyFirstClass, thatOne: MyFirstClass): Boolean = {
    if(thisOne == thatOne)
      true
    else
      false
  }

  /**
    * create a new instance of MyRelationship
    *
    * @param id
    * @param name
    * @param otherId
    * @return a new instance of MyRelationship
    */
  def createMyRelationship(id: Long, name: String, otherId: String): MyRelationship = {
    MyRelationship.apply(id, name, otherId)
  }

  /**
    * compare two instances of MyRelationship for equality
    * @param thisOne
    * @param thatOne
    * @return truee if they are the same
    */
  def compareMyRelationshipEquality(thisOne: MyRelationship, thatOne: MyRelationship): Boolean = {
    if(thisOne == thatOne)
      true
    else
      false

  }

  /**
    * create a new instance of NotACaseClass
    * @param id
    * @param name
    * @param otherId
    * @return a new instance of NotACaseClass
    */
  def createNotACaseClass(id: Long, name: String, otherId: String): NotACaseClass = {
    val ncc: NotACaseClass = new NotACaseClass(id, name, otherId)
    ncc
  }

  /**
    * compare two instances of NotACaseClass for equality based on their fields
    * @param thisOne
    * @param thatOne
    * @return true if the have the same values
    */
  def compareNotACaseClassEquality(thisOne: NotACaseClass, thatOne: NotACaseClass): Boolean = {
    if(thisOne.id == thatOne.id && thisOne.name == thatOne.name && thisOne.otherId == thatOne.otherId)
      true
    else
      false
  }

  /**
    * compare two instances of NotACaseClass are actually the same object in memory
    *
    * @param thisOne
    * @param thatOne
    * @return true if they have the same memory address
    */
  def compareNotACaseClassObjectInstanceIsSame(thisOne: NotACaseClass, thatOne: NotACaseClass): Boolean = {
    if(thisOne.id == thatOne.id)
      true
    else
      false
  }

  /**
    * Transform an instance of MyFirstClass to a sequence of MyRelationship
    *
    * This is because there are several otherIds in MyFirstClass, but MyRelationship only has one string
    *
    * hint: use the map function on myFirstClass.otherIds
    * @param myFirstClass
    * @return a Seq
    */
  def transformMyFirstClassToMyRelationship(myFirstClass: MyFirstClass): Seq[MyRelationship] = {
    var seq: Seq[MyRelationship] = Seq.empty
    myFirstClass.otherIds.foreach{ str =>
        seq = seq :+ MyRelationship.apply(myFirstClass.id, myFirstClass.name, str)
    }
    seq
  }

  /**
    * transform a single my relationship into a myFirstClass.
    *
    * Hint: Map the field names 1:1, you will have to transform the type of otherId
    * @param myRelationship
    * @return
    */
  def transformMyRelationToMyFirstClass(myRelationship: MyRelationship): MyFirstClass = {
    MyFirstClass.apply(myRelationship.id, myRelationship.name, Seq(myRelationship.otherId))
  }

  /**
    * Assume ids are the same for all MyRelationship in the input sequence
    * @param myRelationships
    * @return
    */
  def transformMyRelationshipToMyFirstClass(myRelationships: immutable.Seq[MyRelationship]): MyFirstClass = {
    var otherids: Seq[String] = Seq.empty
    myRelationships.foreach{mr =>
      otherids = otherids :+ mr.otherId
    }
    MyFirstClass.apply(myRelationships.head.id, myRelationships.head.name, otherids)
  }

  /**
    * Do not assume there are multiple ids, but create a sequence of MyFirstClass, grouped by the various ids in MyRelationships
    *
    * Assume that the name will be the same for any relationship sharing an id.
    * Assume that otherId will be different for each relationship sharing an id.
    *
    *
    * @param myRelationships
    * @return a map of ids to MyFirstClass
    */
  def transformMyRelationshipToMyFirstClassMap(myRelationships: immutable.Seq[MyRelationship]): Map[Long, MyFirstClass] = {
    val groupResult = myRelationships.groupBy(_.id)
    var map: Map[Long, MyFirstClass] = Map.empty
    groupResult.foreach{case(key,value) =>
      val result = transformMyRelationshipToMyFirstClass(value)
      map = map + (key->result)
    }
    map
  }

  /**
    * Do not assume there are multiple ids, but create a sequence of MyFirstClass, grouped by the various ids in MyRelationships
    *
    * Assume that the name will be the same for any relationship sharing an id.
    * Assume that otherId will be different for each relationship sharing an id.
    *
    * @param myRelationships
    * @return a sequence of MyFirstClass
    */
  def transformMyRelationshipToMyFirstClassSequence(myRelationships: immutable.Seq[MyRelationship]): Seq[MyFirstClass] = {
    val groupResult = SortedMap(myRelationships.groupBy(_.id).toSeq:_*)
    var seq: Seq[MyFirstClass] = Seq.empty
    groupResult.foreach{case(key, value) =>
      val result = transformMyRelationshipToMyFirstClass(value)
      seq = seq :+ result
    }
    println(seq)
    seq
  }
}
