package com.devyn.scala.data.structures

import scala.collection.immutable

/**
  * Created by devyn on 1/10/16.
  */
object ClassInstanceOperations {

  /**
    * create a new instance of MyFirstClass
    * @param id
    * @param name
    * @param otherIds
    * @return
    */
  def createMyFirstClass(id: Long, name: String, otherIds: Seq[String]): MyFirstClass = {
    null
  }

  /**
    * Compare two instances of MyFirstClass for equality
    *
    * @param thisOne
    * @param thatOne
    * @return true if they are the same
    */
  def compareMyFirstClassEquality(thisOne: MyFirstClass, thatOne: MyFirstClass): Boolean = {
    null
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
    null
  }

  /**
    * compare two instances of MyRelationship for equality
    * @param thisOne
    * @param thatOne
    * @return truee if they are the same
    */
  def compareMyRelationshipEquality(thisOne: MyRelationship, thatOne: MyRelationship): Boolean = {
    null
  }

  /**
    * create a new instance of NotACaseClass
    * @param id
    * @param name
    * @param otherId
    * @return a new instance of NotACaseClass
    */
  def createNotACaseClass(id: Long, name: String, otherId: String): NotACaseClass = {
    null
  }

  /**
    * compare two instances of NotACaseClass for equality based on their fields
    * @param thisOne
    * @param thatOne
    * @return true if the have the same values
    */
  def compareNotACaseClassEquality(thisOne: NotACaseClass, thatOne: NotACaseClass): Boolean = {
    null
  }

  /**
    * compare two instances of NotACaseClass are actually the same object in memory
    *
    * @param thisOne
    * @param thatOne
    * @return true if they have the same memory address
    */
  def compareNotACaseClassObjectInstanceIsSame(thisOne: NotACaseClass, thatOne: NotACaseClass): Boolean = {
    null
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
    null
  }

  /**
    * transform a single my relationship into a myFirstClass.
    *
    * Hint: Map the field names 1:1, you will have to transform the type of otherId
    * @param myRelationship
    * @return
    */
  def transformMyRelationToMyFirstClass(myRelationship: MyRelationship): MyFirstClass = {
    null
  }

  /**
    * Assume ids are the same for all MyRelationship in the input sequence
    * @param myRelationships
    * @return
    */
  def transformMyRelationshipToMyFirstClass(myRelationships: immutable.Seq[MyRelationship]): MyFirstClass = {
    null
  }


  /**
    * Do not assume there are multiple ids, but create a sequence of MyFirstClass, grouped by the various ids in MyRelationships
    *
    * Assume that the name will be the same for any relationship sharing an id.
    * Assume that otherId will be different for each relationship sharing an id.
    *
    *
    *
    */
  def transformMyRelationshipToMyFirstClassMap(myRelationships: immutable.Seq[MyRelationship]): Map[Long, MyFirstClass] = {
    null
  }

  /**
    * Do not assume there are multiple ids, but create a sequence of MyFirstClass, grouped by the various ids in MyRelationships
    *
    * Assume that the name will be the same for any relationship sharing an id.
    * Assume that otherId will be different for each relationship sharing an id.
    *
    *
    *
    */
  def transformMyRelationshipToMyFirstClassSequence(myRelationships: immutable.Seq[MyRelationship]): Seq[MyFirstClass] = {
    null
  }
}
