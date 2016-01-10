package com.devyn.scala.data.structures

import scala.collection.immutable

/**
  * Created by devyn on 1/10/16.
  */
class IteratorOperations {

  def newIteratorFromStringSeq(sequence: immutable.Seq[String]): Iterator[String] = {
    null
  }

  def newIteratorFromIntegerSequence(sequence: immutable.Seq[Int]): Iterator[Int] = {
    null
  }

  def newIteratorFromMyRelationshipSequence(sequence: immutable.Seq[MyRelationship]): Iterator[MyRelationship] = {
    null
  }
  /**
    * get the iterator from a sequence
    * @param sequence
    * @tparam T
    * @return
    */
  def newIteratorFromSeq[T](sequence: immutable.Seq[T]): Iterator[T] = {
    null
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
    null
  }

  /**
    * find a value in an iterator
    * @param iterator the iterator to search
    * @param value the value to search for
    * @tparam T the type of value
    * @return an Option with the value if found, None otherwise
    */
  def findValue[T](iterator: Iterator[T], value: T): Option[T] = {
    null
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
    null
  }
}
