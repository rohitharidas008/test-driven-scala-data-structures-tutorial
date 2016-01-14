package com.devyn.scala.data.structures

import org.scalatest.{BeforeAndAfterEach, FlatSpec}

import scala.collection.immutable

/**
  * Created by devyn on 1/10/16.
  */
class ClassInstanceOperationsSpec extends FlatSpec with BeforeAndAfterEach {

  it should "create a new instance of MyFirstClass" in {
    //when
    val result = ClassInstanceOperations.createMyFirstClass(1, "name1", Seq("other1"))

    //then
    assert(result.id == 1)
    assert(result.name == "name1")
    assert(result.otherIds == Seq("other1"))
  }

  it should "compare the same instance of MyFirstClass for equality" in {
    //given
    val thisOne = new MyFirstClass(1, "name1", Seq("other1", "other2"))

    //when
    val result = ClassInstanceOperations.compareMyFirstClassEquality(thisOne, thisOne)

    //then
    assert(result)
  }

  it should "compare two equivalent instances of MyFirstClass for equality" in {
    //given
    val thisOne = new MyFirstClass(1, "name1", Seq("other1", "other2"))
    val thatOne = new MyFirstClass(1, "name1", Seq("other1", "other2"))

    //when
    val result = ClassInstanceOperations.compareMyFirstClassEquality(thisOne, thatOne)

    //then
    assert(result)
  }

  it should "compare two unequivalent instances of MyFirstClass for equality" in {
    //given
    val thisOne = new MyFirstClass(1, "name1", Seq("other1", "other2"))
    val thatOne = new MyFirstClass(2, "name1", Seq("other1", "other2"))

    //when
    val result = ClassInstanceOperations.compareMyFirstClassEquality(thisOne, thatOne)

    //then
    assert(!result)
  }

  it should "create a new instance of MyRelationship" in {
    //when
    val result = ClassInstanceOperations.createMyRelationship(1, "name1", "other1")

    //then
    assert(result.id == 1)
    assert(result.name == "name1")
    assert(result.otherId == "other1")
  }

  it should "compare the same instance of MyRelationship for equality" in {
    //given
    val thisOne = new MyRelationship(1, "name1", "other1")

    //when
    val result = ClassInstanceOperations.compareMyRelationshipEquality(thisOne, thisOne)

    //then
    assert(result)
  }

  it should "compare two equivalent instances of MyRelationship for equality" in {
    //given
    val thisOne = new MyRelationship(1, "name1", "other1")
    val thatOne = new MyRelationship(1, "name1", "other1")

    //when
    val result = ClassInstanceOperations.compareMyRelationshipEquality(thisOne, thatOne)

    //then
    assert(result)
  }

  it should "compare two unequivalent instances of MyRelationship for equality" in {
    //given
    val thisOne = new MyRelationship(1, "name1", "other1")
    val thatOne = new MyRelationship(2, "name1", "other1")

    //when
    val result = ClassInstanceOperations.compareMyRelationshipEquality(thisOne, thatOne)

    //then
    assert(!result)
  }

  it should "create an instance of NotACaseClass" in {
    //val nc:NotACaseClass = new NotACaseClass(1, "name1", "other1")
    //when
    val result = ClassInstanceOperations.createNotACaseClass(1, "name1", "other1")

    //then
    assert(result.id == 1)
    assert(result.name == "name1")
    assert(result.otherId == "other1")
  }

  it should "compare the same instance NotACaseClass for equality" in {
    //given
    val thisOne = new NotACaseClass(1, "name1", "otherId")

    //when
    val result = ClassInstanceOperations.compareNotACaseClassEquality(thisOne, thisOne)

    //then
    assert(result)
  }

  it should "compare the two equivalent instances of NotACaseClass for equality" in {
    //given
    val thisOne = new NotACaseClass(1, "name1", "otherId")
    val thatOne = new NotACaseClass(1, "name1", "otherId")

    //when
    val result = ClassInstanceOperations.compareNotACaseClassEquality(thisOne, thatOne)

    //then
    assert(result)
  }

  it should "compare the two unequivalent instances of NotACaseClass for equality" in {
    //given
    val thisOne = new NotACaseClass(1, "name1", "otherId")
    val thatOne = new NotACaseClass(1, "name2", "otherId")

    //when
    val result = ClassInstanceOperations.compareNotACaseClassEquality(thisOne, thatOne)

    //then
    assert(!result)
  }

  it should "compare the same instance of NotACaseClass for identity" in {
    //given
    val thisOne = new NotACaseClass(1, "name1", "otherId")

    //when
    val result = ClassInstanceOperations.compareNotACaseClassObjectInstanceIsSame(thisOne, thisOne)

    //then
    assert(thisOne.id == 1)
  }

  it should "compare two equivalent instances of NotACaseClass for identity" in {
    //given
    val thisOne = new NotACaseClass(1, "name1", "otherId")
    val thatOne = new NotACaseClass(1, "name1", "otherId")

    //when
    val result = ClassInstanceOperations.compareNotACaseClassObjectInstanceIsSame(thisOne, thatOne)

    //then
    assert(thisOne.id == thatOne.id)
  }

  it should "compare two unequivalent instances of NotACaseClass for identity" in {
    //given
    val thisOne = new NotACaseClass(1, "name1", "otherId")
    val thatOne = new NotACaseClass(1, "name1", "otherId2")

    //when
    val result = ClassInstanceOperations.compareNotACaseClassObjectInstanceIsSame(thisOne, thatOne)

    //then
    assert(thisOne.id == thatOne.id)
  }

  it should "transform an instance of MyFirstClass with one otherId into a Sequence of MyRelationship" in {

    //when
    val result = ClassInstanceOperations.transformMyFirstClassToMyRelationship(new MyFirstClass(1, "name1", Seq("other1")))

    //then
    assert(result.size == 1)
    assert(result(0).id == 1)
    assert(result(0).name == "name1")
    assert(result(0).otherId == "other1")
  }

  it should "transform an instance of MyFirstClass with many otherIds into a Sequence of MyRelationship" in {
    //when
    val result = ClassInstanceOperations.transformMyFirstClassToMyRelationship(
      new MyFirstClass(1, "name1", Seq("other1", "otherId2", "otherId3")))

    //then
    assert(result.size == 3)
    assert(result(0).id == 1)
    assert(result(0).name == "name1")
    assert(result(0).otherId == "other1")
    assert(result(1).id == 1)
    assert(result(1).name == "name1")
    assert(result(1).otherId == "otherId2")
    assert(result(2).id == 1)
    assert(result(2).name == "name1")
    assert(result(2).otherId == "otherId3")
  }

  it should "transform an instance of MyRelationship into an instance of MyFirstClass" in {
    //when
    val result = ClassInstanceOperations.transformMyRelationToMyFirstClass(
      new MyRelationship(1, "name1", "other1"))

    //then
    assert(result.id ==1)
    assert(result.name == "name1")
    assert(result.otherIds.size == 1)
    assert(result.otherIds(0) == "other1")
  }

  it should "transform an instance of sequence of MyRelationship into an instance of MyFirstClass" in {
    //given
    val myRelationships = immutable.Seq(
      new MyRelationship(1, "name1", "other1"),
      new MyRelationship(1, "name1", "other2"),
      new MyRelationship(1, "name1", "other3")
    )
    //when
    val result = ClassInstanceOperations.transformMyRelationshipToMyFirstClass(myRelationships)

    //then
    assert(result.id ==1)
    assert(result.name == "name1")
    assert(result.otherIds.size == 3)
    assert(result.otherIds(0) == "other1")
    assert(result.otherIds(1) == "other2")
    assert(result.otherIds(2) == "other3")
  }

  it should "transform a sequence of relationships into a map by id" in {
    //given
    val myRelationships = immutable.Seq(
      new MyRelationship(1, "name1", "other1"),
      new MyRelationship(1, "name1", "other2"),
      new MyRelationship(1, "name1", "other3"),
      new MyRelationship(2, "name2", "other1"),
      new MyRelationship(2, "name2", "other2"),
      new MyRelationship(2, "name2", "other3"),
      new MyRelationship(3, "name3", "other1"),
      new MyRelationship(3, "name3", "other2"),
      new MyRelationship(3, "name3", "other3")
    )
    //when
    val result = ClassInstanceOperations.transformMyRelationshipToMyFirstClassMap(myRelationships)

    //then
    assert(result(1).id == 1)
    assert(result(1).name == "name1")
    assert(result(1).otherIds.size == 3)
    assert(result(1).otherIds(0) == "other1")
    assert(result(1).otherIds(1) == "other2")
    assert(result(1).otherIds(2) == "other3")
    assert(result(2).id == 2)
    assert(result(2).name == "name2")
    assert(result(2).otherIds.size == 3)
    assert(result(2).otherIds(0) == "other1")
    assert(result(2).otherIds(1) == "other2")
    assert(result(2).otherIds(2) == "other3")
    assert(result(3).id == 3)
    assert(result(3).name == "name3")
    assert(result(3).otherIds.size == 3)
    assert(result(3).otherIds(0) == "other1")
    assert(result(3).otherIds(1) == "other2")
    assert(result(3).otherIds(2) == "other3")
  }

  it should "transform a sequence of relationships with different lists of relationships into a map by id" in {
    val myRelationships = immutable.Seq(
      new MyRelationship(1, "name1", "other1"),
      new MyRelationship(1, "name1", "other2"),
      new MyRelationship(1, "name1", "other3"),
      new MyRelationship(2, "name2", "other1"),
      new MyRelationship(3, "name3", "other3")
    )
    //when
    val result = ClassInstanceOperations.transformMyRelationshipToMyFirstClassMap(myRelationships)

    //then
    assert(result(1).id == 1)
    assert(result(1).name == "name1")
    assert(result(1).otherIds.size == 3)
    assert(result(1).otherIds(0) == "other1")
    assert(result(1).otherIds(1) == "other2")
    assert(result(1).otherIds(2) == "other3")
    assert(result(2).id == 2)
    assert(result(2).name == "name2")
    assert(result(2).otherIds.size == 1)
    assert(result(2).otherIds(0) == "other1")
    assert(result(3).id == 3)
    assert(result(3).name == "name3")
    assert(result(3).otherIds.size == 1)
    assert(result(3).otherIds(0) == "other3")
  }

  it should "transform a sequence of relationships into a sequence of MyFirstClass" in {
    //given
    val myRelationships = immutable.Seq(
      new MyRelationship(1, "name1", "other1"),
      new MyRelationship(1, "name1", "other2"),
      new MyRelationship(1, "name1", "other3"),
      new MyRelationship(2, "name2", "other1"),
      new MyRelationship(2, "name2", "other2"),
      new MyRelationship(2, "name2", "other3"),
      new MyRelationship(3, "name3", "other1"),
      new MyRelationship(3, "name3", "other2"),
      new MyRelationship(3, "name3", "other3")
    )

    //when
    val result = ClassInstanceOperations.transformMyRelationshipToMyFirstClassSequence(myRelationships)

    //then
    assert(result(0).id == 1)
    assert(result(0).name == "name1")
    assert(result(0).otherIds.size == 3)
    assert(result(0).otherIds(0) == "other1")
    assert(result(0).otherIds(1) == "other2")
    assert(result(0).otherIds(2) == "other3")
    assert(result(1).id == 2)
    assert(result(1).name == "name2")
    assert(result(1).otherIds.size == 3)
    assert(result(1).otherIds(0) == "other1")
    assert(result(1).otherIds(1) == "other2")
    assert(result(1).otherIds(2) == "other3")
    assert(result(2).id == 3)
    assert(result(2).name == "name3")
    assert(result(2).otherIds.size == 3)
    assert(result(2).otherIds(0) == "other1")
    assert(result(2).otherIds(1) == "other2")
    assert(result(2).otherIds(2) == "other3")
  }
  it should "transform a sequence of relationships with different lists of relationships into a sequence of MyFirstClass" in {
    val myRelationships = immutable.Seq(
      new MyRelationship(1, "name1", "other1"),
      new MyRelationship(1, "name1", "other2"),
      new MyRelationship(1, "name1", "other3"),
      new MyRelationship(2, "name2", "other1"),
      new MyRelationship(3, "name3", "other3")
    )
    //when
    val result = ClassInstanceOperations.transformMyRelationshipToMyFirstClassSequence(myRelationships)

    //then
    assert(result(0).id == 1)
    assert(result(0).name == "name1")
    assert(result(0).otherIds.size == 3)
    assert(result(0).otherIds(0) == "other1")
    assert(result(0).otherIds(1) == "other2")
    assert(result(0).otherIds(2) == "other3")
    assert(result(1).id == 2)
    assert(result(1).name == "name2")
    assert(result(1).otherIds.size == 1)
    assert(result(1).otherIds(0) == "other1")
    assert(result(2).id == 3)
    assert(result(2).name == "name3")
    assert(result(2).otherIds.size == 1)
    assert(result(2).otherIds(0) == "other3")
  }
}
