package com.devyn.scala.data.structures

import scala.collection.immutable
import scala.util.control.Breaks

/**
  * Created by devyn on 1/10/16.
  */
class IteratorOperations {

  def newIteratorFromStringSeq(sequence: immutable.Seq[String]): Iterator[String] = {
    var iterator: Iterator[String] = Iterator.empty
    if (sequence == null) {
      iterator
    }
    else {
      sequence.foreach { str =>
        iterator = iterator ++ Seq(str)
      }
      iterator
    }
  }

  def newIteratorFromIntegerSequence(sequence: immutable.Seq[Int]): Iterator[Int] = {
    var iterator: Iterator[Int] = Iterator.empty
    if (sequence == null) {
      iterator
    }
    else {
      sequence.foreach { nmbr =>
        iterator = iterator ++ Seq(nmbr)
      }
      iterator
    }
  }

  def newIteratorFromMyRelationshipSequence(sequence: immutable.Seq[MyRelationship]): Iterator[MyRelationship] = {
    var iterator: Iterator[MyRelationship] = Iterator.empty
    if (sequence == null) {
      iterator
    }
    else {
      sequence.foreach { mr =>
        iterator = iterator ++ Seq(mr)
      }
      iterator
    }
  }
  /**
    * get the iterator from a sequence
    * @param sequence
    * @tparam T
    * @return
    */
  def newIteratorFromSeq[T](sequence: immutable.Seq[T]): Iterator[T] = {
    var iterator: Iterator[T] = Iterator.empty
    if (sequence == null) {
      iterator
    }
    else {
      sequence.foreach {t =>
      iterator = iterator ++ Seq(t)
      }
      iterator
    }
  }

  /**
    * create a new seq from the iterator
    *
    * Do not use toSeq
    *
    * @param iterator
    * @tparam T
    * @return a new sequence from this iterator
    */
  def newSeqFromIterator[T](iterator: Iterator[T]): immutable.Seq[T] = {
    var sequence: Seq[T] = Seq.empty
    if(iterator == null)
      {
        sequence.to[collection.immutable.Seq]
      }
    else {
      while (iterator.hasNext) {
        sequence = sequence :+ iterator.next()
      }
      sequence.to[collection.immutable.Seq]
    }
  }

  /**
    * find a value in an iterator
    * @param iterator the iterator to search
    * @param value the value to search for
    * @tparam T the type of value
    * @return an Option with the value if found, None otherwise
    */
  def findValue[T](iterator: Iterator[T], value: T): Option[T] = {
    if(iterator ==  null){
      None
    }
    else if(iterator.contains(value)){
      Option(value)
    }
    else{
      None
    }
  }

  /**
    * find an instance of NotACaseClass in the iterator
    *
    * Note: You will not be able to get away with simple object level equality comparison.
    *   You will have to compare the individual values in the object itself,
    *     or implement equals(object) on NotACaseClass
    *
    * @param iterator the iterator to search
    * @param value an instance of NotACaseClass
    * @return an option with the value if found, None otherwise
    *
    */
  def findNonCaseClass(iterator: Iterator[NotACaseClass], value: NotACaseClass): Option[NotACaseClass] = {
    if (iterator == null){
      None
    }
    else {
      while (iterator.hasNext) {
        val result = iterator.next()
        println(result)
        if (result.id == value.id && result.name == value.name && result.otherId == value.otherId) {
          return Option(result)
        }
      }
    }
    None
  }
}
