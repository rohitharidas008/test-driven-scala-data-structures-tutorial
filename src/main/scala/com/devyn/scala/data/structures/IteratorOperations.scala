package com.devyn.scala.data.structures

import scala.collection.immutable

/**
  * Created by devyn on 1/10/16.
  */
class IteratorOperations {

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
    *
    * @param iterator
    * @param value
    * @tparam T
    * @return
    */
  def findValue[T](iterator: Iterator[T], value: T): Option[T] = {
    null
  }

  def findNonCaseClass(iterator: Iterator[NotACaseClass], value: NotACaseClass): Option[NotACaseClass] = {
    null
  }
}
