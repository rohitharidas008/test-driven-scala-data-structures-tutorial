package com.devyn.scala.data.structures

import scala.collection.{SortedMap, immutable}

class SeqOperations {

  /**
    *
    * @return an empty sequence
    */
  def createAnEmptySeq(): immutable.Seq[_] = {
    //TODO fill me in
    immutable.Seq.empty
  }

  /**
    * append a value to a sequence and return a new sequence
    *
    * @param sequence the base sequence
    * @param value value to add
    * @tparam T the type of sequence and value
    * @return a new sequence with value appended
    */
  def appendToASeq[T](sequence: immutable.Seq[T], value: T): immutable.Seq[T] = {
    //TODO fill me in
    if (sequence == null) {
      var seq: Seq[T] = Seq.empty
      seq = seq :+ value
      seq.to[collection.immutable.Seq]
    }
    else {
      var result = sequence.to[collection.mutable.Seq]
      result = result :+ value
      result.to[collection.immutable.Seq]
    }
  }

  /**
    * should test if the sequence contains the given value
    * @param sequence - sequence to check
    * @param value - value to look for
    * @tparam T - the type of sequence and value
    * @return whether sequence contains value
    */
  def sequenceContains[T](sequence: immutable.Seq[T], value: T): Boolean = {
    //TODO fill me in
      if(sequence == null)
        false

      else if(sequence.contains(value))
        true
      else
        false
  }
  /**
    *
    * @param values
    * @return the sum of all values in values
    */
  def sumSeqenceOfIntegers(values: immutable.Seq[Int]) : Int = {
    //TODO
    values.sum
  }

  /**
    *
    * @param values
    * @param delimiter
    * @return a string of all values concatenated, delimited by delimiter
    */
  def concatStrings(values: immutable.Seq[String], delimiter: String): String = {
    //TODO
    values.mkString(delimiter)
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
    myRelationships.foreach{mr =>
      myRelationships.map(x => mr)
    }
    myRelationships
  }

  /**
    * transform the type of myRelationships to MyFirstClass
    *
    * @param myRelationships
    * @return the transformed relationships
    */
  def transformASequence(myRelationships: immutable.Seq[MyRelationship]): immutable.Seq[MyFirstClass] = {
    //TODO fill me in
    val groupResult = SortedMap(myRelationships.groupBy(_.id).toSeq:_*)
    var seq: Seq[MyFirstClass] = Seq.empty
    var otherids: Seq[String] = Seq.empty
    groupResult.foreach{case(key,value) =>
      value.foreach{mr =>
        otherids = otherids :+ mr.otherId
      }
      seq = seq :+ MyFirstClass.apply(key, value.head.name,otherids)
      otherids = Seq.empty
    }
    seq.to[collection.immutable.Seq]
  }

  /**
    * transform to a map by id
    * @param myRelationships
    * @return a map of relationships, mapped by id
    */
  def toMapById(myRelationships: immutable.Seq[MyFirstClass]): immutable.Map[Long, MyFirstClass] = {
    //TODO fill me in
    Map(myRelationships map{mfc => mfc.id -> mfc}: _* )
  }

  /**
    * transform to map of related things by id
    * @param myFirstClasses
    * @return
    */
  def toMapOfStringSeqById(myFirstClasses: immutable.Seq[MyFirstClass]): immutable.Map[Long, Seq[String]] = {
    //TODO fill me in
    Map(myFirstClasses map{mfc: MyFirstClass => mfc.id -> mfc.otherIds}:  _* )
  }
//  /**
//    * transform to a map of MyFirstClasses by Id
//    * @param myRelationships
//    * @return a map of myFirstClasses, mapped by id
//    */
//  def toRelationshipMapById(myRelationships: immutable.Seq[MyRelationship]): immutable.Map[Long, MyFirstClass] = {
//    //TODO fill me in
//    var map: Map[Long, MyFirstClass] = Map.empty
//    val result = transformASequence(myRelationships)
//    map = map + (key->result)
//    map
//  }

}