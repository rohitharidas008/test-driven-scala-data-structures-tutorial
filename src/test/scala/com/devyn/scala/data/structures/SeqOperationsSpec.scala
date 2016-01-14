package com.devyn.scala.data.structures

import org.scalatest.{BeforeAndAfterEach, FlatSpec}

import scala.collection.immutable

/**
  * Created by devyn on 1/10/16.
  */
class SeqOperationsSpec extends FlatSpec with BeforeAndAfterEach {

  var operations: SeqOperations = _

  override def beforeEach() = {
    operations = new SeqOperations()
  }

  it should "return an empty list when I call the method to return an empty list" in {
    //when
    val result = operations.createAnEmptySeq()

    //then:
    assert(result.isEmpty)
    result match {
      case s: Seq[_] => {} //quietly succeed
      case _ => fail("result is not a sequence")
    }
  }

  it should "add the value to the sequence" in {
    //when
    val result = operations.appendToASeq(immutable.Seq("some", "values"), "added")

    //then
    assert(result(0) == "some")
    assert(result(1) == "values")
    assert(result(2) == "added")
    assert(result.size == 3)
  }

  it should "add the value to an empty sequence" in {
    //when
    val result = operations.appendToASeq(immutable.Seq(), "added")

    //then
    assert(result(0) == "added")
    assert(result.size == 1)
  }

  it should "handle the case when null is passed in for the sequence" in {
    //when
    val result = operations.appendToASeq(null, "added")

    //then
    assert(result(0) == "added")
    assert(result.size == 1)
  }

  it should "add null values to the sequence if requested" in {
    //when
    val result = operations.appendToASeq(immutable.Seq("some", "values"), null)

    //then
    assert(result(0) == "some")
    assert(result(1) == "values")
    assert(result(2) == null)
    assert(result.size == 3)
  }

  it should "say false if it does not contain a member" in {
    //when
    val result = operations.sequenceContains(immutable.Seq(1, 3, "fred"), "alphalpha")

    //then
    assert(!result)
  }

  it should "say true if it does contain a member" in {
    //when
    val result = operations.sequenceContains(immutable.Seq(1, 2, "fred"), 2)
    val result2 = operations.sequenceContains(immutable.Seq(new MyRelationship(1, "name1", "2"),
      new MyRelationship(1, "name1", "3"),
      new MyRelationship(2, "name2", "1"),
      new MyRelationship(3, "name3", "1")), new MyRelationship(1, "name1", "3"))

    //then
    assert(result)
    assert(result2)
  }

  it should "say false if the sequence is null" in {
    //when
    val result = operations.sequenceContains(null, "any val")

    //then
    assert(!result)
  }

  it should "sum the numbers in the sequence" in {
    //when
    val result = operations.sumSeqenceOfIntegers(immutable.Seq(1, 2, 3, 4, 4))

    //then
    assert(result == 1 + 2 + 3 + 4 + 4)
  }

  it should "handle the case when the list is empty when sum the numbers in the sequence" in {
    //when
    val result = operations.sumSeqenceOfIntegers(immutable.Seq())

    //then
    assert(result == 0)
  }

  it should "concatenate a seq of strings" in {
    //when
    val result = operations.concatStrings(immutable.Seq("my", "dog", "barks"), " ")

    //then
    assert(result == "my dog barks")
  }

  it should "handle the case when the list is empty when concatenate a seq of strings" in {
    //when
    val result = operations.concatStrings(immutable.Seq(), " ")

    //then
    assert(result == "")
  }

  it should "copy a seq" in {
    //when
    val result = operations.copyASequence(immutable.Seq(
      new MyRelationship(1, "name1", "2"),
      new MyRelationship(1, "name1", "3"),
      new MyRelationship(2, "name2", "1"),
      new MyRelationship(3, "name3", "1")
    ))

    //then
    assert(result(0) == new MyRelationship(1, "name1", "2"))
    assert(result(1) == new MyRelationship(1, "name1", "3"))
    assert(result(2) == new MyRelationship(2, "name2", "1"))
    assert(result(3) == new MyRelationship(3, "name3", "1"))
  }

  it should "handle the case when the sequence is empty on copy" in {
    //when
    val result = operations.copyASequence(immutable.Seq())

    //then
    assert(result.isEmpty)
  }

  it should "transform a sequence" in {
    //when
    val result = operations.transformASequence(immutable.Seq(
      new MyRelationship(1, "name1", "2"),
      new MyRelationship(1, "name1", "3"),
      new MyRelationship(2, "name2", "1"),
      new MyRelationship(3, "name3", "1")
    ))

    //then:
    assert(result(0).id == 1)
    assert(result(0).name == "name1")
    assert(result(0).otherIds == Seq("2", "3"))
    assert(result(1).id == 2)
    assert(result(1).name == "name2")
    assert(result(1).otherIds == Seq("1"))
    assert(result(2).id == 3)
    assert(result(2).name == "name3")
    assert(result(2).otherIds == Seq("1"))
  }

  it should "handle the case when the sequence is empty on transform" in {
    //when
    val result = operations.transformASequence(immutable.Seq())

    //then
    assert(result.isEmpty)
  }

  it should "transform to a map by Id" in {
    //when
    val result = operations.toMapById(immutable.Seq(
      new MyFirstClass(1, "name1", Seq("2", "3")),
      new MyFirstClass(2, "name2", Seq("1")),
      new MyFirstClass(3, "name3", Seq("1"))
    ))

    //then
    assert(result(1).id == 1)
    assert(result(1).name == "name1")
    assert(result(1).otherIds == Seq("2", "3"))
    assert(result(2).id == 2)
    assert(result(2).name == "name2")
    assert(result(2).otherIds == Seq("1"))
    assert(result(3).id == 3)
    assert(result(3).name == "name3")
    assert(result(3).otherIds == Seq("1"))
  }

  it should "handle the case when the seq is empty when transform to a map by Id" in {
    //when
    val result = operations.toMapById(immutable.Seq())

    //then
    assert(result.isEmpty)
  }


  it should "transform to otherIds by id" in {
    val result = operations.toMapOfStringSeqById(immutable.Seq(
      new MyFirstClass(1, "name1", Seq("2", "3")),
      new MyFirstClass(2, "name2", Seq("1")),
      new MyFirstClass(3, "name3", Seq("1"))
    ))

    //then
    assert(result(1) == Seq("2", "3"))
    assert(result(2) == Seq("1"))
    assert(result(3) == Seq("1"))
  }

  it should "handle the case when the seq is empty when transform to otherIds by id" in {
    //when
    val result = operations.toMapOfStringSeqById(immutable.Seq())

    //then
    assert(result.isEmpty)
  }


//  it should "transform a seq of relationships into a map of myFirstClasses" in {
//    //when
//    val result = operations.toRelationshipMapById(immutable.Seq(
//      new MyRelationship(1, "name1", "2"),
//      new MyRelationship(1, "name1", "3"),
//      new MyRelationship(2, "name2", "1"),
//      new MyRelationship(3, "name3", "1")
//    ))
//
//    //then:
//    assert(result(1).id == 1)
//    assert(result(1).name == "name1")
//    assert(result(1).otherIds == Seq("2", "3"))
//    assert(result(2).id == 2)
//    assert(result(2).name == "name2")
//    assert(result(2).otherIds == Seq("1"))
//    assert(result(3).id == 3)
//    assert(result(3).name == "name3")
//    assert(result(3).otherIds == Seq("1"))
//  }

//  it should "handle the case when the seq is empty when transform a seq of relationships into a map of myFirstClasses" in {
//    //when
//    val result = operations.toRelationshipMapById(immutable.Seq())
//
//    //then:
//    assert(result.isEmpty)
//  }

}
