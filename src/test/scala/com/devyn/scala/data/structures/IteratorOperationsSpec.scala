package com.devyn.scala.data.structures


import org.scalatest.{BeforeAndAfterEach, FlatSpec}

import scala.collection.immutable

/**
  * Created by devyn on 1/10/16.
  */
class IteratorOperationsSpec extends FlatSpec with BeforeAndAfterEach {
  var operations: IteratorOperations = _

  override def beforeEach(): Unit = {
    operations = new IteratorOperations()
  }

  it should "create a new iterator from a String sequence" in {
    //when
    val result = operations.newIteratorFromStringSeq(immutable.Seq("val1", "val2"))

    //then
    assert(result.next() == "val1")
    assert(result.next() == "val2")
    assert(!result.hasNext)
  }

  it should "handle the case when the String sequence is empty" in {
    //when
    val result = operations.newIteratorFromStringSeq(immutable.Seq())

    //then
    assert(!result.hasNext)
  }


  it should "handle the case when the String sequence is null" in {
    //when
    val result = operations.newIteratorFromStringSeq(null)

    //then
    assert(!result.hasNext)
  }

  it should "create a new iterator from a Number sequence" in {
    //when
    val result = operations.newIteratorFromIntegerSequence(immutable.Seq(1, 2))

    //then
    assert(result.next() == 1)
    assert(result.next() == 2)
    assert(!result.hasNext)
  }

  it should "handle the case when the Number sequence is empty" in {
    //when
    val result = operations.newIteratorFromIntegerSequence(immutable.Seq())

    //then
    assert(!result.hasNext)
  }

  it should "handle the case when the Number sequence is null" in {
    //when
    val result = operations.newIteratorFromIntegerSequence(null)

    //then
    assert(!result.hasNext)
  }

  it should "create a new iterator from a MyRelationship sequence" in {
    //when
    val result = operations.newIteratorFromMyRelationshipSequence(
      immutable.Seq(MyRelationship(1, "name1", "other1"),
        MyRelationship(2, "name2", "other2")))

    //then
    assert(result.next() == MyRelationship(1, "name1", "other1"))
    assert(result.next() == MyRelationship(2, "name2", "other2"))
    assert(!result.hasNext)
  }

  it should "handle the case when the MyRelationship sequence is empty" in {
    //when
    val result = operations.newIteratorFromMyRelationshipSequence(immutable.Seq())

    //then
    assert(!result.hasNext)
  }


  it should "handle the case when the MyRelationship sequence is null" in {
    //when
    val result = operations.newIteratorFromMyRelationshipSequence(null)

    //then
    assert(!result.hasNext)
  }

  it should "create a new iterator from a generic sequence" in {
    //when
    val result = operations.newIteratorFromSeq(immutable.Seq("val1", 2))

    //then
    assert(result.next() == "val1")
    assert(result.next() == 2)
    assert(!result.hasNext)
  }

  it should "handle the case when the sequence is empty" in {
    //when
    val result = operations.newIteratorFromSeq(immutable.Seq())

    //then
    assert(!result.hasNext)
  }

  it should "handle the case when the sequence is null" in {
    //when
    val result = operations.newIteratorFromSeq(null)

    //then
    assert(!result.hasNext)
  }

  it should "turn an iterator into a seq" in {
    //when
    val result = operations.newSeqFromIterator(Iterator(1, 2, "val3"))

    //then
    assert(result(0) == 1)
    assert(result(1) == 2)
    assert(result(2) == "val3")
    assert(result.size == 3)
  }

  it should "handle the case where the iterator is empty" in {
    //when
    val result = operations.newSeqFromIterator(Iterator())

    //then
    assert(result.isEmpty)
  }
  it should "handle the case where the input is null" in {
    //when
    val result = operations.newSeqFromIterator(null)

    //then
    assert(result.isEmpty)
  }

  it should "be able to find a value" in {
    //when
    val result = operations.findValue(Iterator(1, 2, "really in here"), 2)
    val result2 = operations.findValue(Iterator(1, 2, "really"), "really")

    //then
    result match {
      case Some(2) => {}
      case _ => fail()
    }
    result2 match {
      case Some("really") => {}
      case _ => fail()
    }
  }
  it should "return None if the value is not in the iterator" in {
    //when
    val result = operations.findValue(Iterator(1, 2, "really in here"), "toblerone")

    //then
    assert(result.isEmpty)
  }

  it should "return None if the Iterator is null" in {
    //when
    val result = operations.findValue(null, "any val")

    assert(result.isEmpty)
  }

  it should "find NotACaseClass correctly" in {
    //when
    val result = operations.findNonCaseClass(
      Iterator(new NotACaseClass(1, "name1", "other1"),
        new NotACaseClass(2, "name2", "other2"),
        new NotACaseClass(3, "name3", "other3")),
      new NotACaseClass(2, "name2", "other2")
    )

    //then
    result match {
      case Some(value) => {
        assert(value.id == 2)
        assert(value.name == "name2")
        assert(value.otherId == "other2")
      }
      case None => fail()
    }
  }

  it should "return None if the value isn't in there" in {
    //when
    val result = operations.findNonCaseClass(
      Iterator(new NotACaseClass(1, "name1", "other1"),
        new NotACaseClass(2, "name2", "other2"),
        new NotACaseClass(3, "name3", "other3")),
      new NotACaseClass(2, "name3", "other2")
    )

    //then
    assert(result.isEmpty)
  }
  it should "return None if the iterator is null" in {
    //when
    val result = operations.findNonCaseClass(
      null,
      new NotACaseClass(2, "name2", "other2")
    )

    //then
    assert(result.isEmpty)
  }

  it should "return None if the iterator is empty" in {
    //when
    val result = operations.findNonCaseClass(
      Iterator(),
      new NotACaseClass(2, "name2", "other2")
    )

    //then
    assert(result.isEmpty)
  }


}
