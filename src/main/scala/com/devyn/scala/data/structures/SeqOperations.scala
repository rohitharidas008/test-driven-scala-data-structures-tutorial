package com.devyn.scala.data.structures

import scala.collection.immutable

class SeqOperations {

  /**
    *
    * @return an empty sequence
    */
  def createAnEmptySeq(): immutable.Seq[_] = {
    //TODO fill me in
    null
  }

  /**
    *
    * @param values
    * @return the sum of all values in values
    */
  def sumSeqenceOfIntegers(values: immutable.Seq[Int]) : Int = {
    //TODO
    0
  }

  /**
    *
    * @param values
    * @param delimiter
    * @return a string of all values concatenated, delimited by delimiter
    */
  def concatStrings(values: immutable.Seq[String], delimiter: String): String = {
    //TODO
    null
  }

  /**
    * Perform a deep copy on the input.
    *
    * Do not call seq.copy
    * Do not reuse the same objects.
    * manually create a copy of each object in myRelationships.
    *
    * @param myRelationships
    * @return a copyt of myRelationships
    */
  def copyASequence(myRelationships: immutable.Seq[MyRelationship]): immutable.Seq[MyRelationship] = {
    //TODO fill me in
    null
  }

  /**
    * transform the type of myRelationships to MyFirstClass
    *
    * @param myRelationships
    * @return the transformed relationships
    */
  def transformASequence(myRelationships: immutable.Seq[MyRelationship]): immutable.Seq[MyFirstClass] = {
    //TODO fill me in
    null
  }

  /**
    * transform to a map by id
    * @param myRelationships
    * @return a map of relationships, mapped by id
    */
  def toMapById(myRelationships: immutable.Seq[MyFirstClass]): immutable.Map[Long, MyFirstClass] = {
    //TODO fill me in
    null
  }

  /**
    * transform to map of related things by id
    * @param myFirstClasses
    * @return
    */
  def toMapOfStringSeqById(myFirstClasses: immutable.Seq[MyFirstClass]): immutable.Map[Long, Seq[String]] = {
    //TODO fill me in
    null
  }
  /**
    * transform to a map of MyFirstClasses by Id
    * @param myRelationships
    * @return a map of myFirstClasses, mapped by id
    */
  def toRelationshipMapById(myRelationships: immutable.Seq[MyRelationship]): immutable.Map[Long, MyFirstClass] = {
    //TODO fill me in
    null
  }

}