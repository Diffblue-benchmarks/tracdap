package org.finos.tracdap.test.meta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.finos.tracdap.metadata.BasicType;
import org.finos.tracdap.metadata.DatetimeValue;
import org.finos.tracdap.metadata.ObjectDefinition;
import org.finos.tracdap.metadata.ObjectDefinition.DefinitionCase;
import org.finos.tracdap.metadata.ObjectType;
import org.finos.tracdap.metadata.TagHeader;
import org.finos.tracdap.metadata.TagOperation;
import org.finos.tracdap.metadata.TagSelector;
import org.finos.tracdap.metadata.TagSelector.ObjectCriteriaCase;
import org.finos.tracdap.metadata.TagSelector.TagCriteriaCase;
import org.finos.tracdap.metadata.TagUpdate;
import org.finos.tracdap.metadata.TypeDescriptor;
import org.finos.tracdap.metadata.Value;
import org.finos.tracdap.metadata.Value.ValueCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SampleMetadataDiffblueTest {
  /**
   * Test {@link SampleMetadata#dummyDefinitionForType(ObjectType)}.
   *
   * <ul>
   *   <li>Then return SerializedSize is one hundred forty-seven.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#dummyDefinitionForType(ObjectType)}
   */
  @Test
  @DisplayName(
      "Test dummyDefinitionForType(ObjectType); then return SerializedSize is one hundred forty-seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition SampleMetadata.dummyDefinitionForType(ObjectType)"})
  void testDummyDefinitionForType_thenReturnSerializedSizeIsOneHundredFortySeven() {
    // Arrange and Act
    ObjectDefinition actualDummyDefinitionForTypeResult =
        SampleMetadata.dummyDefinitionForType(ObjectType.FLOW);

    // Assert
    assertEquals(147, actualDummyDefinitionForTypeResult.getSerializedSize());
    assertEquals(3, actualDummyDefinitionForTypeResult.getObjectTypeValue());
    assertEquals(DefinitionCase.FLOW, actualDummyDefinitionForTypeResult.getDefinitionCase());
    assertEquals(ObjectType.FLOW, actualDummyDefinitionForTypeResult.getObjectType());
    assertTrue(actualDummyDefinitionForTypeResult.hasFlow());
  }

  /**
   * Test {@link SampleMetadata#dummyDefinitionForType(ObjectType)}.
   *
   * <ul>
   *   <li>Then return SerializedSize is one hundred sixty-eight.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#dummyDefinitionForType(ObjectType)}
   */
  @Test
  @DisplayName(
      "Test dummyDefinitionForType(ObjectType); then return SerializedSize is one hundred sixty-eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition SampleMetadata.dummyDefinitionForType(ObjectType)"})
  void testDummyDefinitionForType_thenReturnSerializedSizeIsOneHundredSixtyEight() {
    // Arrange and Act
    ObjectDefinition actualDummyDefinitionForTypeResult =
        SampleMetadata.dummyDefinitionForType(ObjectType.FILE);

    // Assert
    assertEquals(168, actualDummyDefinitionForTypeResult.getSerializedSize());
    assertEquals(5, actualDummyDefinitionForTypeResult.getObjectTypeValue());
    assertEquals(DefinitionCase.FILE, actualDummyDefinitionForTypeResult.getDefinitionCase());
    assertEquals(ObjectType.FILE, actualDummyDefinitionForTypeResult.getObjectType());
    assertTrue(actualDummyDefinitionForTypeResult.hasFile());
  }

  /**
   * Test {@link SampleMetadata#dummyDefinitionForType(ObjectType)}.
   *
   * <ul>
   *   <li>Then return SerializedSize is one hundred twenty-nine.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#dummyDefinitionForType(ObjectType)}
   */
  @Test
  @DisplayName(
      "Test dummyDefinitionForType(ObjectType); then return SerializedSize is one hundred twenty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition SampleMetadata.dummyDefinitionForType(ObjectType)"})
  void testDummyDefinitionForType_thenReturnSerializedSizeIsOneHundredTwentyNine() {
    // Arrange and Act
    ObjectDefinition actualDummyDefinitionForTypeResult =
        SampleMetadata.dummyDefinitionForType(ObjectType.RESULT);

    // Assert
    assertEquals(129, actualDummyDefinitionForTypeResult.getSerializedSize());
    assertEquals(9, actualDummyDefinitionForTypeResult.getObjectTypeValue());
    assertEquals(DefinitionCase.RESULT, actualDummyDefinitionForTypeResult.getDefinitionCase());
    assertEquals(ObjectType.RESULT, actualDummyDefinitionForTypeResult.getObjectType());
    assertTrue(actualDummyDefinitionForTypeResult.hasResult());
  }

  /**
   * Test {@link SampleMetadata#dummyDefinitionForType(ObjectType)}.
   *
   * <ul>
   *   <li>When {@code CUSTOM}.
   *   <li>Then return ObjectTypeValue is six.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#dummyDefinitionForType(ObjectType)}
   */
  @Test
  @DisplayName(
      "Test dummyDefinitionForType(ObjectType); when 'CUSTOM'; then return ObjectTypeValue is six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition SampleMetadata.dummyDefinitionForType(ObjectType)"})
  void testDummyDefinitionForType_whenCustom_thenReturnObjectTypeValueIsSix() {
    // Arrange and Act
    ObjectDefinition actualDummyDefinitionForTypeResult =
        SampleMetadata.dummyDefinitionForType(ObjectType.CUSTOM);

    // Assert
    assertEquals(6, actualDummyDefinitionForTypeResult.getObjectTypeValue());
    assertEquals(77, actualDummyDefinitionForTypeResult.getSerializedSize());
    assertEquals(DefinitionCase.CUSTOM, actualDummyDefinitionForTypeResult.getDefinitionCase());
    assertEquals(ObjectType.CUSTOM, actualDummyDefinitionForTypeResult.getObjectType());
    assertTrue(actualDummyDefinitionForTypeResult.hasCustom());
  }

  /**
   * Test {@link SampleMetadata#dummyDefinitionForType(ObjectType)}.
   *
   * <ul>
   *   <li>When {@code DATA}.
   *   <li>Then return ObjectTypeValue is one.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#dummyDefinitionForType(ObjectType)}
   */
  @Test
  @DisplayName(
      "Test dummyDefinitionForType(ObjectType); when 'DATA'; then return ObjectTypeValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition SampleMetadata.dummyDefinitionForType(ObjectType)"})
  void testDummyDefinitionForType_whenData_thenReturnObjectTypeValueIsOne() {
    // Arrange and Act
    ObjectDefinition actualDummyDefinitionForTypeResult =
        SampleMetadata.dummyDefinitionForType(ObjectType.DATA);

    // Assert
    assertEquals(1, actualDummyDefinitionForTypeResult.getObjectTypeValue());
    assertEquals(249, actualDummyDefinitionForTypeResult.getSerializedSize());
    assertEquals(DefinitionCase.DATA, actualDummyDefinitionForTypeResult.getDefinitionCase());
    assertEquals(ObjectType.DATA, actualDummyDefinitionForTypeResult.getObjectType());
    assertTrue(actualDummyDefinitionForTypeResult.hasData());
  }

  /**
   * Test {@link SampleMetadata#dummyDefinitionForType(ObjectType)}.
   *
   * <ul>
   *   <li>When {@code JOB}.
   *   <li>Then return SerializedSize is one hundred.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#dummyDefinitionForType(ObjectType)}
   */
  @Test
  @DisplayName(
      "Test dummyDefinitionForType(ObjectType); when 'JOB'; then return SerializedSize is one hundred")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition SampleMetadata.dummyDefinitionForType(ObjectType)"})
  void testDummyDefinitionForType_whenJob_thenReturnSerializedSizeIsOneHundred() {
    // Arrange and Act
    ObjectDefinition actualDummyDefinitionForTypeResult =
        SampleMetadata.dummyDefinitionForType(ObjectType.JOB);

    // Assert
    assertEquals(100, actualDummyDefinitionForTypeResult.getSerializedSize());
    assertEquals(4, actualDummyDefinitionForTypeResult.getObjectTypeValue());
    assertEquals(DefinitionCase.JOB, actualDummyDefinitionForTypeResult.getDefinitionCase());
    assertEquals(ObjectType.JOB, actualDummyDefinitionForTypeResult.getObjectType());
    assertTrue(actualDummyDefinitionForTypeResult.hasJob());
  }

  /**
   * Test {@link SampleMetadata#dummyDefinitionForType(ObjectType)}.
   *
   * <ul>
   *   <li>When {@code MODEL}.
   *   <li>Then return ObjectTypeValue is two.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#dummyDefinitionForType(ObjectType)}
   */
  @Test
  @DisplayName(
      "Test dummyDefinitionForType(ObjectType); when 'MODEL'; then return ObjectTypeValue is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition SampleMetadata.dummyDefinitionForType(ObjectType)"})
  void testDummyDefinitionForType_whenModel_thenReturnObjectTypeValueIsTwo() {
    // Arrange and Act
    ObjectDefinition actualDummyDefinitionForTypeResult =
        SampleMetadata.dummyDefinitionForType(ObjectType.MODEL);

    // Assert
    assertEquals(2, actualDummyDefinitionForTypeResult.getObjectTypeValue());
    assertEquals(256, actualDummyDefinitionForTypeResult.getSerializedSize());
    assertEquals(DefinitionCase.MODEL, actualDummyDefinitionForTypeResult.getDefinitionCase());
    assertEquals(ObjectType.MODEL, actualDummyDefinitionForTypeResult.getObjectType());
    assertTrue(actualDummyDefinitionForTypeResult.hasModel());
  }

  /**
   * Test {@link SampleMetadata#dummyDefinitionForType(ObjectType)}.
   *
   * <ul>
   *   <li>When {@code OBJECT_TYPE_NOT_SET}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#dummyDefinitionForType(ObjectType)}
   */
  @Test
  @DisplayName(
      "Test dummyDefinitionForType(ObjectType); when 'OBJECT_TYPE_NOT_SET'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition SampleMetadata.dummyDefinitionForType(ObjectType)"})
  void testDummyDefinitionForType_whenObjectTypeNotSet_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> SampleMetadata.dummyDefinitionForType(ObjectType.OBJECT_TYPE_NOT_SET));
  }

  /**
   * Test {@link SampleMetadata#dummyDefinitionForType(ObjectType)}.
   *
   * <ul>
   *   <li>When {@code SCHEMA}.
   *   <li>Then return ObjectTypeValue is eight.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#dummyDefinitionForType(ObjectType)}
   */
  @Test
  @DisplayName(
      "Test dummyDefinitionForType(ObjectType); when 'SCHEMA'; then return ObjectTypeValue is eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition SampleMetadata.dummyDefinitionForType(ObjectType)"})
  void testDummyDefinitionForType_whenSchema_thenReturnObjectTypeValueIsEight() {
    // Arrange and Act
    ObjectDefinition actualDummyDefinitionForTypeResult =
        SampleMetadata.dummyDefinitionForType(ObjectType.SCHEMA);

    // Assert
    assertEquals(8, actualDummyDefinitionForTypeResult.getObjectTypeValue());
    assertEquals(96, actualDummyDefinitionForTypeResult.getSerializedSize());
    assertEquals(DefinitionCase.SCHEMA, actualDummyDefinitionForTypeResult.getDefinitionCase());
    assertEquals(ObjectType.SCHEMA, actualDummyDefinitionForTypeResult.getObjectType());
    assertTrue(actualDummyDefinitionForTypeResult.hasSchema());
  }

  /**
   * Test {@link SampleMetadata#dummyDefinitionForType(ObjectType)}.
   *
   * <ul>
   *   <li>When {@code STORAGE}.
   *   <li>Then return ObjectTypeValue is seven.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#dummyDefinitionForType(ObjectType)}
   */
  @Test
  @DisplayName(
      "Test dummyDefinitionForType(ObjectType); when 'STORAGE'; then return ObjectTypeValue is seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition SampleMetadata.dummyDefinitionForType(ObjectType)"})
  void testDummyDefinitionForType_whenStorage_thenReturnObjectTypeValueIsSeven() {
    // Arrange and Act
    ObjectDefinition actualDummyDefinitionForTypeResult =
        SampleMetadata.dummyDefinitionForType(ObjectType.STORAGE);

    // Assert
    assertEquals(7, actualDummyDefinitionForTypeResult.getObjectTypeValue());
    assertEquals(DefinitionCase.STORAGE, actualDummyDefinitionForTypeResult.getDefinitionCase());
    assertEquals(ObjectType.STORAGE, actualDummyDefinitionForTypeResult.getObjectType());
    assertTrue(actualDummyDefinitionForTypeResult.hasStorage());
  }

  /**
   * Test {@link SampleMetadata#dummyTagForObjectType(ObjectType)}.
   *
   * <ul>
   *   <li>Then return SerializedSize is four hundred forty-three.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#dummyTagForObjectType(ObjectType)}
   */
  @Test
  @DisplayName(
      "Test dummyTagForObjectType(ObjectType); then return SerializedSize is four hundred forty-three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.metadata.Tag SampleMetadata.dummyTagForObjectType(ObjectType)"
  })
  void testDummyTagForObjectType_thenReturnSerializedSizeIsFourHundredFortyThree() {
    // Arrange, Act and Assert
    assertEquals(443, SampleMetadata.dummyTagForObjectType(ObjectType.MODEL).getSerializedSize());
  }

  /**
   * Test {@link SampleMetadata#dummyTagForObjectType(ObjectType)}.
   *
   * <ul>
   *   <li>Then return SerializedSize is four hundred thirty-six.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#dummyTagForObjectType(ObjectType)}
   */
  @Test
  @DisplayName(
      "Test dummyTagForObjectType(ObjectType); then return SerializedSize is four hundred thirty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.metadata.Tag SampleMetadata.dummyTagForObjectType(ObjectType)"
  })
  void testDummyTagForObjectType_thenReturnSerializedSizeIsFourHundredThirtySix() {
    // Arrange, Act and Assert
    assertEquals(436, SampleMetadata.dummyTagForObjectType(ObjectType.DATA).getSerializedSize());
  }

  /**
   * Test {@link SampleMetadata#dummyTagForObjectType(ObjectType)}.
   *
   * <ul>
   *   <li>Then return SerializedSize is three hundred fifty-five.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#dummyTagForObjectType(ObjectType)}
   */
  @Test
  @DisplayName(
      "Test dummyTagForObjectType(ObjectType); then return SerializedSize is three hundred fifty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.metadata.Tag SampleMetadata.dummyTagForObjectType(ObjectType)"
  })
  void testDummyTagForObjectType_thenReturnSerializedSizeIsThreeHundredFiftyFive() {
    // Arrange, Act and Assert
    assertEquals(355, SampleMetadata.dummyTagForObjectType(ObjectType.FILE).getSerializedSize());
  }

  /**
   * Test {@link SampleMetadata#dummyTagForObjectType(ObjectType)}.
   *
   * <ul>
   *   <li>Then return SerializedSize is three hundred sixteen.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#dummyTagForObjectType(ObjectType)}
   */
  @Test
  @DisplayName(
      "Test dummyTagForObjectType(ObjectType); then return SerializedSize is three hundred sixteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.metadata.Tag SampleMetadata.dummyTagForObjectType(ObjectType)"
  })
  void testDummyTagForObjectType_thenReturnSerializedSizeIsThreeHundredSixteen() {
    // Arrange, Act and Assert
    assertEquals(316, SampleMetadata.dummyTagForObjectType(ObjectType.RESULT).getSerializedSize());
  }

  /**
   * Test {@link SampleMetadata#dummyTagForObjectType(ObjectType)}.
   *
   * <ul>
   *   <li>Then return SerializedSize is three hundred thirty-four.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#dummyTagForObjectType(ObjectType)}
   */
  @Test
  @DisplayName(
      "Test dummyTagForObjectType(ObjectType); then return SerializedSize is three hundred thirty-four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.metadata.Tag SampleMetadata.dummyTagForObjectType(ObjectType)"
  })
  void testDummyTagForObjectType_thenReturnSerializedSizeIsThreeHundredThirtyFour() {
    // Arrange, Act and Assert
    assertEquals(334, SampleMetadata.dummyTagForObjectType(ObjectType.FLOW).getSerializedSize());
  }

  /**
   * Test {@link SampleMetadata#dummyTagForObjectType(ObjectType)}.
   *
   * <ul>
   *   <li>Then return SerializedSize is two hundred eighty-two.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#dummyTagForObjectType(ObjectType)}
   */
  @Test
  @DisplayName(
      "Test dummyTagForObjectType(ObjectType); then return SerializedSize is two hundred eighty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.metadata.Tag SampleMetadata.dummyTagForObjectType(ObjectType)"
  })
  void testDummyTagForObjectType_thenReturnSerializedSizeIsTwoHundredEightyTwo() {
    // Arrange, Act and Assert
    assertEquals(282, SampleMetadata.dummyTagForObjectType(ObjectType.SCHEMA).getSerializedSize());
  }

  /**
   * Test {@link SampleMetadata#dummyTagForObjectType(ObjectType)}.
   *
   * <ul>
   *   <li>Then return SerializedSize is two hundred sixty-three.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#dummyTagForObjectType(ObjectType)}
   */
  @Test
  @DisplayName(
      "Test dummyTagForObjectType(ObjectType); then return SerializedSize is two hundred sixty-three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.metadata.Tag SampleMetadata.dummyTagForObjectType(ObjectType)"
  })
  void testDummyTagForObjectType_thenReturnSerializedSizeIsTwoHundredSixtyThree() {
    // Arrange, Act and Assert
    assertEquals(263, SampleMetadata.dummyTagForObjectType(ObjectType.CUSTOM).getSerializedSize());
  }

  /**
   * Test {@link SampleMetadata#dummyTagForObjectType(ObjectType)}.
   *
   * <ul>
   *   <li>When {@code JOB}.
   *   <li>Then return SerializedSize is two hundred eighty-six.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#dummyTagForObjectType(ObjectType)}
   */
  @Test
  @DisplayName(
      "Test dummyTagForObjectType(ObjectType); when 'JOB'; then return SerializedSize is two hundred eighty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.metadata.Tag SampleMetadata.dummyTagForObjectType(ObjectType)"
  })
  void testDummyTagForObjectType_whenJob_thenReturnSerializedSizeIsTwoHundredEightySix() {
    // Arrange, Act and Assert
    assertEquals(286, SampleMetadata.dummyTagForObjectType(ObjectType.JOB).getSerializedSize());
  }

  /**
   * Test {@link SampleMetadata#dummyTagForObjectType(ObjectType)}.
   *
   * <ul>
   *   <li>When {@code OBJECT_TYPE_NOT_SET}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#dummyTagForObjectType(ObjectType)}
   */
  @Test
  @DisplayName(
      "Test dummyTagForObjectType(ObjectType); when 'OBJECT_TYPE_NOT_SET'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.metadata.Tag SampleMetadata.dummyTagForObjectType(ObjectType)"
  })
  void testDummyTagForObjectType_whenObjectTypeNotSet_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> SampleMetadata.dummyTagForObjectType(ObjectType.OBJECT_TYPE_NOT_SET));
  }

  /**
   * Test {@link SampleMetadata#dummyVersionForType(ObjectDefinition)}.
   *
   * <p>Method under test: {@link SampleMetadata#dummyVersionForType(ObjectDefinition)}
   */
  @Test
  @DisplayName("Test dummyVersionForType(ObjectDefinition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition SampleMetadata.dummyVersionForType(ObjectDefinition)"})
  void testDummyVersionForType() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> SampleMetadata.dummyVersionForType(ObjectDefinition.getDefaultInstance()));
  }

  /**
   * Test {@link SampleMetadata#dummyBadVersionForType(ObjectDefinition)}.
   *
   * <p>Method under test: {@link SampleMetadata#dummyBadVersionForType(ObjectDefinition)}
   */
  @Test
  @DisplayName("Test dummyBadVersionForType(ObjectDefinition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition SampleMetadata.dummyBadVersionForType(ObjectDefinition)"})
  void testDummyBadVersionForType() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> SampleMetadata.dummyBadVersionForType(ObjectDefinition.getDefaultInstance()));
  }

  /**
   * Test {@link SampleMetadata#newHeader(ObjectType)}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#newHeader(ObjectType)}
   */
  @Test
  @DisplayName("Test newHeader(ObjectType); then return InitializationErrorString is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TagHeader SampleMetadata.newHeader(ObjectType)"})
  void testNewHeader_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange and Act
    TagHeader actualNewHeaderResult = SampleMetadata.newHeader(ObjectType.OBJECT_TYPE_NOT_SET);

    // Assert
    assertEquals("", actualNewHeaderResult.getInitializationErrorString());
    assertEquals(0, actualNewHeaderResult.getObjectTypeValue());
    assertEquals(1, actualNewHeaderResult.getObjectVersion());
    assertEquals(1, actualNewHeaderResult.getTagVersion());
    assertEquals(102, actualNewHeaderResult.getSerializedSize());
    assertEquals(7, actualNewHeaderResult.getAllFields().size());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualNewHeaderResult.getObjectType());
    assertTrue(actualNewHeaderResult.findInitializationErrors().isEmpty());
    assertTrue(actualNewHeaderResult.getIsLatestObject());
    assertTrue(actualNewHeaderResult.getIsLatestTag());
    assertTrue(actualNewHeaderResult.hasObjectTimestamp());
    assertTrue(actualNewHeaderResult.hasTagTimestamp());
    assertTrue(actualNewHeaderResult.isInitialized());
    DatetimeValue expectedTagTimestampOrBuilder = actualNewHeaderResult.getTagTimestamp();
    assertSame(expectedTagTimestampOrBuilder, actualNewHeaderResult.getTagTimestampOrBuilder());
  }

  /**
   * Test {@link SampleMetadata#nextTagHeader(TagHeader)}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#nextTagHeader(TagHeader)}
   */
  @Test
  @DisplayName(
      "Test nextTagHeader(TagHeader); then return InitializationErrorString is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TagHeader SampleMetadata.nextTagHeader(TagHeader)"})
  void testNextTagHeader_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange
    TagHeader priorTagHeader = TagHeader.getDefaultInstance();

    // Act
    TagHeader actualNextTagHeaderResult = SampleMetadata.nextTagHeader(priorTagHeader);

    // Assert
    assertEquals("", actualNextTagHeaderResult.getInitializationErrorString());
    assertEquals("", actualNextTagHeaderResult.getObjectId());
    assertEquals(0, actualNextTagHeaderResult.getObjectTypeValue());
    assertEquals(0, actualNextTagHeaderResult.getObjectVersion());
    assertEquals(1, actualNextTagHeaderResult.getTagVersion());
    assertEquals(3, actualNextTagHeaderResult.getAllFields().size());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualNextTagHeaderResult.getObjectType());
    assertFalse(actualNextTagHeaderResult.getIsLatestObject());
    assertFalse(actualNextTagHeaderResult.hasObjectTimestamp());
    assertTrue(actualNextTagHeaderResult.findInitializationErrors().isEmpty());
    assertTrue(actualNextTagHeaderResult.getIsLatestTag());
    assertTrue(actualNextTagHeaderResult.hasTagTimestamp());
    assertTrue(actualNextTagHeaderResult.isInitialized());
    assertEquals(Integer.SIZE, actualNextTagHeaderResult.getSerializedSize());
    assertSame(priorTagHeader, actualNextTagHeaderResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SampleMetadata#dummyDataDef()}.
   *
   * <p>Method under test: {@link SampleMetadata#dummyDataDef()}
   */
  @Test
  @DisplayName("Test dummyDataDef()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition SampleMetadata.dummyDataDef()"})
  void testDummyDataDef() {
    // Arrange and Act
    ObjectDefinition actualDummyDataDefResult = SampleMetadata.dummyDataDef();

    // Assert
    assertEquals("", actualDummyDataDefResult.getInitializationErrorString());
    assertEquals(0, actualDummyDataDefResult.getObjectPropsCount());
    assertEquals(1, actualDummyDataDefResult.getObjectTypeValue());
    assertEquals(2, actualDummyDataDefResult.getAllFields().size());
    assertEquals(249, actualDummyDataDefResult.getSerializedSize());
    assertEquals(DefinitionCase.DATA, actualDummyDataDefResult.getDefinitionCase());
    assertEquals(ObjectType.DATA, actualDummyDataDefResult.getObjectType());
    assertFalse(actualDummyDataDefResult.hasCustom());
    assertFalse(actualDummyDataDefResult.hasFile());
    assertFalse(actualDummyDataDefResult.hasFlow());
    assertFalse(actualDummyDataDefResult.hasJob());
    assertFalse(actualDummyDataDefResult.hasModel());
    assertFalse(actualDummyDataDefResult.hasResult());
    assertFalse(actualDummyDataDefResult.hasSchema());
    assertFalse(actualDummyDataDefResult.hasStorage());
    assertTrue(actualDummyDataDefResult.findInitializationErrors().isEmpty());
    assertTrue(actualDummyDataDefResult.getObjectProps().isEmpty());
    assertTrue(actualDummyDataDefResult.getObjectPropsMap().isEmpty());
    assertTrue(actualDummyDataDefResult.hasData());
    assertTrue(actualDummyDataDefResult.isInitialized());
  }

  /**
   * Test {@link SampleMetadata#nextDataDef(ObjectDefinition)}.
   *
   * <p>Method under test: {@link SampleMetadata#nextDataDef(ObjectDefinition)}
   */
  @Test
  @DisplayName("Test nextDataDef(ObjectDefinition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition SampleMetadata.nextDataDef(ObjectDefinition)"})
  void testNextDataDef() {
    // Arrange
    ObjectDefinition origDef = ObjectDefinition.getDefaultInstance();

    // Act
    ObjectDefinition actualNextDataDefResult = SampleMetadata.nextDataDef(origDef);

    // Assert
    assertEquals("", actualNextDataDefResult.getInitializationErrorString());
    assertEquals(0, actualNextDataDefResult.getObjectPropsCount());
    assertEquals(0, actualNextDataDefResult.getObjectTypeValue());
    assertEquals(1, actualNextDataDefResult.getAllFields().size());
    assertEquals(58, actualNextDataDefResult.getSerializedSize());
    assertEquals(DefinitionCase.DATA, actualNextDataDefResult.getDefinitionCase());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualNextDataDefResult.getObjectType());
    assertFalse(actualNextDataDefResult.hasCustom());
    assertFalse(actualNextDataDefResult.hasFile());
    assertFalse(actualNextDataDefResult.hasFlow());
    assertFalse(actualNextDataDefResult.hasJob());
    assertFalse(actualNextDataDefResult.hasModel());
    assertFalse(actualNextDataDefResult.hasResult());
    assertFalse(actualNextDataDefResult.hasSchema());
    assertFalse(actualNextDataDefResult.hasStorage());
    assertTrue(actualNextDataDefResult.findInitializationErrors().isEmpty());
    assertTrue(actualNextDataDefResult.getObjectProps().isEmpty());
    assertTrue(actualNextDataDefResult.getObjectPropsMap().isEmpty());
    assertTrue(actualNextDataDefResult.hasData());
    assertTrue(actualNextDataDefResult.isInitialized());
    assertSame(origDef, actualNextDataDefResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SampleMetadata#dummySchemaDef()}.
   *
   * <p>Method under test: {@link SampleMetadata#dummySchemaDef()}
   */
  @Test
  @DisplayName("Test dummySchemaDef()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition SampleMetadata.dummySchemaDef()"})
  void testDummySchemaDef() {
    // Arrange and Act
    ObjectDefinition actualDummySchemaDefResult = SampleMetadata.dummySchemaDef();

    // Assert
    assertEquals("", actualDummySchemaDefResult.getInitializationErrorString());
    assertEquals(0, actualDummySchemaDefResult.getObjectPropsCount());
    assertEquals(2, actualDummySchemaDefResult.getAllFields().size());
    assertEquals(8, actualDummySchemaDefResult.getObjectTypeValue());
    assertEquals(96, actualDummySchemaDefResult.getSerializedSize());
    assertEquals(DefinitionCase.SCHEMA, actualDummySchemaDefResult.getDefinitionCase());
    assertEquals(ObjectType.SCHEMA, actualDummySchemaDefResult.getObjectType());
    assertFalse(actualDummySchemaDefResult.hasCustom());
    assertFalse(actualDummySchemaDefResult.hasData());
    assertFalse(actualDummySchemaDefResult.hasFile());
    assertFalse(actualDummySchemaDefResult.hasFlow());
    assertFalse(actualDummySchemaDefResult.hasJob());
    assertFalse(actualDummySchemaDefResult.hasModel());
    assertFalse(actualDummySchemaDefResult.hasResult());
    assertFalse(actualDummySchemaDefResult.hasStorage());
    assertTrue(actualDummySchemaDefResult.findInitializationErrors().isEmpty());
    assertTrue(actualDummySchemaDefResult.getObjectProps().isEmpty());
    assertTrue(actualDummySchemaDefResult.getObjectPropsMap().isEmpty());
    assertTrue(actualDummySchemaDefResult.hasSchema());
    assertTrue(actualDummySchemaDefResult.isInitialized());
  }

  /**
   * Test {@link SampleMetadata#nextSchemaDef(ObjectDefinition)}.
   *
   * <p>Method under test: {@link SampleMetadata#nextSchemaDef(ObjectDefinition)}
   */
  @Test
  @DisplayName("Test nextSchemaDef(ObjectDefinition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition SampleMetadata.nextSchemaDef(ObjectDefinition)"})
  void testNextSchemaDef() {
    // Arrange
    ObjectDefinition origDef = ObjectDefinition.getDefaultInstance();

    // Act
    ObjectDefinition actualNextSchemaDefResult = SampleMetadata.nextSchemaDef(origDef);

    // Assert
    assertEquals("", actualNextSchemaDefResult.getInitializationErrorString());
    assertEquals(0, actualNextSchemaDefResult.getObjectPropsCount());
    assertEquals(0, actualNextSchemaDefResult.getObjectTypeValue());
    assertEquals(1, actualNextSchemaDefResult.getAllFields().size());
    assertEquals(56, actualNextSchemaDefResult.getSerializedSize());
    assertEquals(DefinitionCase.SCHEMA, actualNextSchemaDefResult.getDefinitionCase());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualNextSchemaDefResult.getObjectType());
    assertFalse(actualNextSchemaDefResult.hasCustom());
    assertFalse(actualNextSchemaDefResult.hasData());
    assertFalse(actualNextSchemaDefResult.hasFile());
    assertFalse(actualNextSchemaDefResult.hasFlow());
    assertFalse(actualNextSchemaDefResult.hasJob());
    assertFalse(actualNextSchemaDefResult.hasModel());
    assertFalse(actualNextSchemaDefResult.hasResult());
    assertFalse(actualNextSchemaDefResult.hasStorage());
    assertTrue(actualNextSchemaDefResult.findInitializationErrors().isEmpty());
    assertTrue(actualNextSchemaDefResult.getObjectProps().isEmpty());
    assertTrue(actualNextSchemaDefResult.getObjectPropsMap().isEmpty());
    assertTrue(actualNextSchemaDefResult.hasSchema());
    assertTrue(actualNextSchemaDefResult.isInitialized());
    assertSame(origDef, actualNextSchemaDefResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SampleMetadata#dummyStorageDef()}.
   *
   * <p>Method under test: {@link SampleMetadata#dummyStorageDef()}
   */
  @Test
  @DisplayName("Test dummyStorageDef()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition SampleMetadata.dummyStorageDef()"})
  void testDummyStorageDef() {
    // Arrange and Act
    ObjectDefinition actualDummyStorageDefResult = SampleMetadata.dummyStorageDef();

    // Assert
    assertEquals("", actualDummyStorageDefResult.getInitializationErrorString());
    assertEquals(0, actualDummyStorageDefResult.getObjectPropsCount());
    assertEquals(2, actualDummyStorageDefResult.getAllFields().size());
    assertEquals(7, actualDummyStorageDefResult.getObjectTypeValue());
    assertEquals(DefinitionCase.STORAGE, actualDummyStorageDefResult.getDefinitionCase());
    assertEquals(ObjectType.STORAGE, actualDummyStorageDefResult.getObjectType());
    assertFalse(actualDummyStorageDefResult.hasCustom());
    assertFalse(actualDummyStorageDefResult.hasData());
    assertFalse(actualDummyStorageDefResult.hasFile());
    assertFalse(actualDummyStorageDefResult.hasFlow());
    assertFalse(actualDummyStorageDefResult.hasJob());
    assertFalse(actualDummyStorageDefResult.hasModel());
    assertFalse(actualDummyStorageDefResult.hasResult());
    assertFalse(actualDummyStorageDefResult.hasSchema());
    assertTrue(actualDummyStorageDefResult.findInitializationErrors().isEmpty());
    assertTrue(actualDummyStorageDefResult.getObjectProps().isEmpty());
    assertTrue(actualDummyStorageDefResult.getObjectPropsMap().isEmpty());
    assertTrue(actualDummyStorageDefResult.hasStorage());
    assertTrue(actualDummyStorageDefResult.isInitialized());
  }

  /**
   * Test {@link SampleMetadata#dummyModelDef()}.
   *
   * <p>Method under test: {@link SampleMetadata#dummyModelDef()}
   */
  @Test
  @DisplayName("Test dummyModelDef()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition SampleMetadata.dummyModelDef()"})
  void testDummyModelDef() {
    // Arrange and Act
    ObjectDefinition actualDummyModelDefResult = SampleMetadata.dummyModelDef();

    // Assert
    assertEquals("", actualDummyModelDefResult.getInitializationErrorString());
    assertEquals(0, actualDummyModelDefResult.getObjectPropsCount());
    assertEquals(2, actualDummyModelDefResult.getAllFields().size());
    assertEquals(2, actualDummyModelDefResult.getObjectTypeValue());
    assertEquals(256, actualDummyModelDefResult.getSerializedSize());
    assertEquals(DefinitionCase.MODEL, actualDummyModelDefResult.getDefinitionCase());
    assertEquals(ObjectType.MODEL, actualDummyModelDefResult.getObjectType());
    assertFalse(actualDummyModelDefResult.hasCustom());
    assertFalse(actualDummyModelDefResult.hasData());
    assertFalse(actualDummyModelDefResult.hasFile());
    assertFalse(actualDummyModelDefResult.hasFlow());
    assertFalse(actualDummyModelDefResult.hasJob());
    assertFalse(actualDummyModelDefResult.hasResult());
    assertFalse(actualDummyModelDefResult.hasSchema());
    assertFalse(actualDummyModelDefResult.hasStorage());
    assertTrue(actualDummyModelDefResult.findInitializationErrors().isEmpty());
    assertTrue(actualDummyModelDefResult.getObjectProps().isEmpty());
    assertTrue(actualDummyModelDefResult.getObjectPropsMap().isEmpty());
    assertTrue(actualDummyModelDefResult.hasModel());
    assertTrue(actualDummyModelDefResult.isInitialized());
  }

  /**
   * Test {@link SampleMetadata#nextModelDef(ObjectDefinition)}.
   *
   * <p>Method under test: {@link SampleMetadata#nextModelDef(ObjectDefinition)}
   */
  @Test
  @DisplayName("Test nextModelDef(ObjectDefinition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition SampleMetadata.nextModelDef(ObjectDefinition)"})
  void testNextModelDef() {
    // Arrange
    ObjectDefinition origDef = ObjectDefinition.getDefaultInstance();

    // Act
    ObjectDefinition actualNextModelDefResult = SampleMetadata.nextModelDef(origDef);

    // Assert
    assertEquals("", actualNextModelDefResult.getInitializationErrorString());
    assertEquals(0, actualNextModelDefResult.getObjectPropsCount());
    assertEquals(0, actualNextModelDefResult.getObjectTypeValue());
    assertEquals(1, actualNextModelDefResult.getAllFields().size());
    assertEquals(18, actualNextModelDefResult.getSerializedSize());
    assertEquals(DefinitionCase.MODEL, actualNextModelDefResult.getDefinitionCase());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualNextModelDefResult.getObjectType());
    assertFalse(actualNextModelDefResult.hasCustom());
    assertFalse(actualNextModelDefResult.hasData());
    assertFalse(actualNextModelDefResult.hasFile());
    assertFalse(actualNextModelDefResult.hasFlow());
    assertFalse(actualNextModelDefResult.hasJob());
    assertFalse(actualNextModelDefResult.hasResult());
    assertFalse(actualNextModelDefResult.hasSchema());
    assertFalse(actualNextModelDefResult.hasStorage());
    assertTrue(actualNextModelDefResult.findInitializationErrors().isEmpty());
    assertTrue(actualNextModelDefResult.getObjectProps().isEmpty());
    assertTrue(actualNextModelDefResult.getObjectPropsMap().isEmpty());
    assertTrue(actualNextModelDefResult.hasModel());
    assertTrue(actualNextModelDefResult.isInitialized());
    assertSame(origDef, actualNextModelDefResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SampleMetadata#nextBadModelDef(ObjectDefinition)}.
   *
   * <p>Method under test: {@link SampleMetadata#nextBadModelDef(ObjectDefinition)}
   */
  @Test
  @DisplayName("Test nextBadModelDef(ObjectDefinition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition SampleMetadata.nextBadModelDef(ObjectDefinition)"})
  void testNextBadModelDef() {
    // Arrange
    ObjectDefinition origDef = ObjectDefinition.getDefaultInstance();

    // Act
    ObjectDefinition actualNextBadModelDefResult = SampleMetadata.nextBadModelDef(origDef);

    // Assert
    assertEquals("", actualNextBadModelDefResult.getInitializationErrorString());
    assertEquals(0, actualNextBadModelDefResult.getObjectPropsCount());
    assertEquals(0, actualNextBadModelDefResult.getObjectTypeValue());
    assertEquals(1, actualNextBadModelDefResult.getAllFields().size());
    assertEquals(22, actualNextBadModelDefResult.getSerializedSize());
    assertEquals(DefinitionCase.MODEL, actualNextBadModelDefResult.getDefinitionCase());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualNextBadModelDefResult.getObjectType());
    assertFalse(actualNextBadModelDefResult.hasCustom());
    assertFalse(actualNextBadModelDefResult.hasData());
    assertFalse(actualNextBadModelDefResult.hasFile());
    assertFalse(actualNextBadModelDefResult.hasFlow());
    assertFalse(actualNextBadModelDefResult.hasJob());
    assertFalse(actualNextBadModelDefResult.hasResult());
    assertFalse(actualNextBadModelDefResult.hasSchema());
    assertFalse(actualNextBadModelDefResult.hasStorage());
    assertTrue(actualNextBadModelDefResult.findInitializationErrors().isEmpty());
    assertTrue(actualNextBadModelDefResult.getObjectProps().isEmpty());
    assertTrue(actualNextBadModelDefResult.getObjectPropsMap().isEmpty());
    assertTrue(actualNextBadModelDefResult.hasModel());
    assertTrue(actualNextBadModelDefResult.isInitialized());
    assertSame(origDef, actualNextBadModelDefResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SampleMetadata#dummyFlowDef()}.
   *
   * <p>Method under test: {@link SampleMetadata#dummyFlowDef()}
   */
  @Test
  @DisplayName("Test dummyFlowDef()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition SampleMetadata.dummyFlowDef()"})
  void testDummyFlowDef() {
    // Arrange and Act
    ObjectDefinition actualDummyFlowDefResult = SampleMetadata.dummyFlowDef();

    // Assert
    assertEquals("", actualDummyFlowDefResult.getInitializationErrorString());
    assertEquals(0, actualDummyFlowDefResult.getObjectPropsCount());
    assertEquals(147, actualDummyFlowDefResult.getSerializedSize());
    assertEquals(2, actualDummyFlowDefResult.getAllFields().size());
    assertEquals(3, actualDummyFlowDefResult.getObjectTypeValue());
    assertEquals(DefinitionCase.FLOW, actualDummyFlowDefResult.getDefinitionCase());
    assertEquals(ObjectType.FLOW, actualDummyFlowDefResult.getObjectType());
    assertFalse(actualDummyFlowDefResult.hasCustom());
    assertFalse(actualDummyFlowDefResult.hasData());
    assertFalse(actualDummyFlowDefResult.hasFile());
    assertFalse(actualDummyFlowDefResult.hasJob());
    assertFalse(actualDummyFlowDefResult.hasModel());
    assertFalse(actualDummyFlowDefResult.hasResult());
    assertFalse(actualDummyFlowDefResult.hasSchema());
    assertFalse(actualDummyFlowDefResult.hasStorage());
    assertTrue(actualDummyFlowDefResult.findInitializationErrors().isEmpty());
    assertTrue(actualDummyFlowDefResult.getObjectProps().isEmpty());
    assertTrue(actualDummyFlowDefResult.getObjectPropsMap().isEmpty());
    assertTrue(actualDummyFlowDefResult.hasFlow());
    assertTrue(actualDummyFlowDefResult.isInitialized());
  }

  /**
   * Test {@link SampleMetadata#dummyJobDef()}.
   *
   * <p>Method under test: {@link SampleMetadata#dummyJobDef()}
   */
  @Test
  @DisplayName("Test dummyJobDef()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition SampleMetadata.dummyJobDef()"})
  void testDummyJobDef() {
    // Arrange and Act
    ObjectDefinition actualDummyJobDefResult = SampleMetadata.dummyJobDef();

    // Assert
    assertEquals("", actualDummyJobDefResult.getInitializationErrorString());
    assertEquals(0, actualDummyJobDefResult.getObjectPropsCount());
    assertEquals(100, actualDummyJobDefResult.getSerializedSize());
    assertEquals(2, actualDummyJobDefResult.getAllFields().size());
    assertEquals(4, actualDummyJobDefResult.getObjectTypeValue());
    assertEquals(DefinitionCase.JOB, actualDummyJobDefResult.getDefinitionCase());
    assertEquals(ObjectType.JOB, actualDummyJobDefResult.getObjectType());
    assertFalse(actualDummyJobDefResult.hasCustom());
    assertFalse(actualDummyJobDefResult.hasData());
    assertFalse(actualDummyJobDefResult.hasFile());
    assertFalse(actualDummyJobDefResult.hasFlow());
    assertFalse(actualDummyJobDefResult.hasModel());
    assertFalse(actualDummyJobDefResult.hasResult());
    assertFalse(actualDummyJobDefResult.hasSchema());
    assertFalse(actualDummyJobDefResult.hasStorage());
    assertTrue(actualDummyJobDefResult.findInitializationErrors().isEmpty());
    assertTrue(actualDummyJobDefResult.getObjectProps().isEmpty());
    assertTrue(actualDummyJobDefResult.getObjectPropsMap().isEmpty());
    assertTrue(actualDummyJobDefResult.hasJob());
    assertTrue(actualDummyJobDefResult.isInitialized());
  }

  /**
   * Test {@link SampleMetadata#dummyResultDef()}.
   *
   * <p>Method under test: {@link SampleMetadata#dummyResultDef()}
   */
  @Test
  @DisplayName("Test dummyResultDef()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition SampleMetadata.dummyResultDef()"})
  void testDummyResultDef() {
    // Arrange and Act
    ObjectDefinition actualDummyResultDefResult = SampleMetadata.dummyResultDef();

    // Assert
    assertEquals("", actualDummyResultDefResult.getInitializationErrorString());
    assertEquals(0, actualDummyResultDefResult.getObjectPropsCount());
    assertEquals(129, actualDummyResultDefResult.getSerializedSize());
    assertEquals(2, actualDummyResultDefResult.getAllFields().size());
    assertEquals(9, actualDummyResultDefResult.getObjectTypeValue());
    assertEquals(DefinitionCase.RESULT, actualDummyResultDefResult.getDefinitionCase());
    assertEquals(ObjectType.RESULT, actualDummyResultDefResult.getObjectType());
    assertFalse(actualDummyResultDefResult.hasCustom());
    assertFalse(actualDummyResultDefResult.hasData());
    assertFalse(actualDummyResultDefResult.hasFile());
    assertFalse(actualDummyResultDefResult.hasFlow());
    assertFalse(actualDummyResultDefResult.hasJob());
    assertFalse(actualDummyResultDefResult.hasModel());
    assertFalse(actualDummyResultDefResult.hasSchema());
    assertFalse(actualDummyResultDefResult.hasStorage());
    assertTrue(actualDummyResultDefResult.findInitializationErrors().isEmpty());
    assertTrue(actualDummyResultDefResult.getObjectProps().isEmpty());
    assertTrue(actualDummyResultDefResult.getObjectPropsMap().isEmpty());
    assertTrue(actualDummyResultDefResult.hasResult());
    assertTrue(actualDummyResultDefResult.isInitialized());
  }

  /**
   * Test {@link SampleMetadata#dummyFileDef()}.
   *
   * <p>Method under test: {@link SampleMetadata#dummyFileDef()}
   */
  @Test
  @DisplayName("Test dummyFileDef()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition SampleMetadata.dummyFileDef()"})
  void testDummyFileDef() {
    // Arrange and Act
    ObjectDefinition actualDummyFileDefResult = SampleMetadata.dummyFileDef();

    // Assert
    assertEquals("", actualDummyFileDefResult.getInitializationErrorString());
    assertEquals(0, actualDummyFileDefResult.getObjectPropsCount());
    assertEquals(168, actualDummyFileDefResult.getSerializedSize());
    assertEquals(2, actualDummyFileDefResult.getAllFields().size());
    assertEquals(5, actualDummyFileDefResult.getObjectTypeValue());
    assertEquals(DefinitionCase.FILE, actualDummyFileDefResult.getDefinitionCase());
    assertEquals(ObjectType.FILE, actualDummyFileDefResult.getObjectType());
    assertFalse(actualDummyFileDefResult.hasCustom());
    assertFalse(actualDummyFileDefResult.hasData());
    assertFalse(actualDummyFileDefResult.hasFlow());
    assertFalse(actualDummyFileDefResult.hasJob());
    assertFalse(actualDummyFileDefResult.hasModel());
    assertFalse(actualDummyFileDefResult.hasResult());
    assertFalse(actualDummyFileDefResult.hasSchema());
    assertFalse(actualDummyFileDefResult.hasStorage());
    assertTrue(actualDummyFileDefResult.findInitializationErrors().isEmpty());
    assertTrue(actualDummyFileDefResult.getObjectProps().isEmpty());
    assertTrue(actualDummyFileDefResult.getObjectPropsMap().isEmpty());
    assertTrue(actualDummyFileDefResult.hasFile());
    assertTrue(actualDummyFileDefResult.isInitialized());
  }

  /**
   * Test {@link SampleMetadata#nextFileDef(ObjectDefinition)}.
   *
   * <p>Method under test: {@link SampleMetadata#nextFileDef(ObjectDefinition)}
   */
  @Test
  @DisplayName("Test nextFileDef(ObjectDefinition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition SampleMetadata.nextFileDef(ObjectDefinition)"})
  void testNextFileDef() {
    // Arrange
    ObjectDefinition origDef = ObjectDefinition.getDefaultInstance();

    // Act
    ObjectDefinition actualNextFileDefResult = SampleMetadata.nextFileDef(origDef);

    // Assert
    assertEquals("", actualNextFileDefResult.getInitializationErrorString());
    assertEquals(0, actualNextFileDefResult.getObjectPropsCount());
    assertEquals(0, actualNextFileDefResult.getObjectTypeValue());
    assertEquals(1, actualNextFileDefResult.getAllFields().size());
    assertEquals(57, actualNextFileDefResult.getSerializedSize());
    assertEquals(DefinitionCase.FILE, actualNextFileDefResult.getDefinitionCase());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualNextFileDefResult.getObjectType());
    assertFalse(actualNextFileDefResult.hasCustom());
    assertFalse(actualNextFileDefResult.hasData());
    assertFalse(actualNextFileDefResult.hasFlow());
    assertFalse(actualNextFileDefResult.hasJob());
    assertFalse(actualNextFileDefResult.hasModel());
    assertFalse(actualNextFileDefResult.hasResult());
    assertFalse(actualNextFileDefResult.hasSchema());
    assertFalse(actualNextFileDefResult.hasStorage());
    assertTrue(actualNextFileDefResult.findInitializationErrors().isEmpty());
    assertTrue(actualNextFileDefResult.getObjectProps().isEmpty());
    assertTrue(actualNextFileDefResult.getObjectPropsMap().isEmpty());
    assertTrue(actualNextFileDefResult.hasFile());
    assertTrue(actualNextFileDefResult.isInitialized());
    assertSame(origDef, actualNextFileDefResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SampleMetadata#nextBadFileDef(ObjectDefinition)}.
   *
   * <p>Method under test: {@link SampleMetadata#nextBadFileDef(ObjectDefinition)}
   */
  @Test
  @DisplayName("Test nextBadFileDef(ObjectDefinition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition SampleMetadata.nextBadFileDef(ObjectDefinition)"})
  void testNextBadFileDef() {
    // Arrange
    ObjectDefinition origDef = ObjectDefinition.getDefaultInstance();

    // Act
    ObjectDefinition actualNextBadFileDefResult = SampleMetadata.nextBadFileDef(origDef);

    // Assert
    assertEquals("", actualNextBadFileDefResult.getInitializationErrorString());
    assertEquals(0, actualNextBadFileDefResult.getObjectPropsCount());
    assertEquals(0, actualNextBadFileDefResult.getObjectTypeValue());
    assertEquals(1, actualNextBadFileDefResult.getAllFields().size());
    assertEquals(47, actualNextBadFileDefResult.getSerializedSize());
    assertEquals(DefinitionCase.FILE, actualNextBadFileDefResult.getDefinitionCase());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualNextBadFileDefResult.getObjectType());
    assertFalse(actualNextBadFileDefResult.hasCustom());
    assertFalse(actualNextBadFileDefResult.hasData());
    assertFalse(actualNextBadFileDefResult.hasFlow());
    assertFalse(actualNextBadFileDefResult.hasJob());
    assertFalse(actualNextBadFileDefResult.hasModel());
    assertFalse(actualNextBadFileDefResult.hasResult());
    assertFalse(actualNextBadFileDefResult.hasSchema());
    assertFalse(actualNextBadFileDefResult.hasStorage());
    assertTrue(actualNextBadFileDefResult.findInitializationErrors().isEmpty());
    assertTrue(actualNextBadFileDefResult.getObjectProps().isEmpty());
    assertTrue(actualNextBadFileDefResult.getObjectPropsMap().isEmpty());
    assertTrue(actualNextBadFileDefResult.hasFile());
    assertTrue(actualNextBadFileDefResult.isInitialized());
    assertSame(origDef, actualNextBadFileDefResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SampleMetadata#dummyCustomDef()}.
   *
   * <p>Method under test: {@link SampleMetadata#dummyCustomDef()}
   */
  @Test
  @DisplayName("Test dummyCustomDef()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition SampleMetadata.dummyCustomDef()"})
  void testDummyCustomDef() {
    // Arrange and Act
    ObjectDefinition actualDummyCustomDefResult = SampleMetadata.dummyCustomDef();

    // Assert
    assertEquals("", actualDummyCustomDefResult.getInitializationErrorString());
    assertEquals(0, actualDummyCustomDefResult.getObjectPropsCount());
    assertEquals(2, actualDummyCustomDefResult.getAllFields().size());
    assertEquals(6, actualDummyCustomDefResult.getObjectTypeValue());
    assertEquals(77, actualDummyCustomDefResult.getSerializedSize());
    assertEquals(DefinitionCase.CUSTOM, actualDummyCustomDefResult.getDefinitionCase());
    assertEquals(ObjectType.CUSTOM, actualDummyCustomDefResult.getObjectType());
    assertFalse(actualDummyCustomDefResult.hasData());
    assertFalse(actualDummyCustomDefResult.hasFile());
    assertFalse(actualDummyCustomDefResult.hasFlow());
    assertFalse(actualDummyCustomDefResult.hasJob());
    assertFalse(actualDummyCustomDefResult.hasModel());
    assertFalse(actualDummyCustomDefResult.hasResult());
    assertFalse(actualDummyCustomDefResult.hasSchema());
    assertFalse(actualDummyCustomDefResult.hasStorage());
    assertTrue(actualDummyCustomDefResult.findInitializationErrors().isEmpty());
    assertTrue(actualDummyCustomDefResult.getObjectProps().isEmpty());
    assertTrue(actualDummyCustomDefResult.getObjectPropsMap().isEmpty());
    assertTrue(actualDummyCustomDefResult.hasCustom());
    assertTrue(actualDummyCustomDefResult.isInitialized());
  }

  /**
   * Test {@link SampleMetadata#nextCustomDef(ObjectDefinition)}.
   *
   * <p>Method under test: {@link SampleMetadata#nextCustomDef(ObjectDefinition)}
   */
  @Test
  @DisplayName("Test nextCustomDef(ObjectDefinition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition SampleMetadata.nextCustomDef(ObjectDefinition)"})
  void testNextCustomDef() {
    // Arrange
    ObjectDefinition origDef = ObjectDefinition.getDefaultInstance();

    // Act
    ObjectDefinition actualNextCustomDefResult = SampleMetadata.nextCustomDef(origDef);

    // Assert
    assertEquals("", actualNextCustomDefResult.getInitializationErrorString());
    assertEquals(0, actualNextCustomDefResult.getObjectPropsCount());
    assertEquals(0, actualNextCustomDefResult.getObjectTypeValue());
    assertEquals(1, actualNextCustomDefResult.getAllFields().size());
    assertEquals(105, actualNextCustomDefResult.getSerializedSize());
    assertEquals(DefinitionCase.CUSTOM, actualNextCustomDefResult.getDefinitionCase());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualNextCustomDefResult.getObjectType());
    assertFalse(actualNextCustomDefResult.hasData());
    assertFalse(actualNextCustomDefResult.hasFile());
    assertFalse(actualNextCustomDefResult.hasFlow());
    assertFalse(actualNextCustomDefResult.hasJob());
    assertFalse(actualNextCustomDefResult.hasModel());
    assertFalse(actualNextCustomDefResult.hasResult());
    assertFalse(actualNextCustomDefResult.hasSchema());
    assertFalse(actualNextCustomDefResult.hasStorage());
    assertTrue(actualNextCustomDefResult.findInitializationErrors().isEmpty());
    assertTrue(actualNextCustomDefResult.getObjectProps().isEmpty());
    assertTrue(actualNextCustomDefResult.getObjectPropsMap().isEmpty());
    assertTrue(actualNextCustomDefResult.hasCustom());
    assertTrue(actualNextCustomDefResult.isInitialized());
    assertSame(origDef, actualNextCustomDefResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SampleMetadata#nextBadCustomDef(ObjectDefinition)}.
   *
   * <p>Method under test: {@link SampleMetadata#nextBadCustomDef(ObjectDefinition)}
   */
  @Test
  @DisplayName("Test nextBadCustomDef(ObjectDefinition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition SampleMetadata.nextBadCustomDef(ObjectDefinition)"})
  void testNextBadCustomDef() {
    // Arrange
    ObjectDefinition origDef = ObjectDefinition.getDefaultInstance();

    // Act
    ObjectDefinition actualNextBadCustomDefResult = SampleMetadata.nextBadCustomDef(origDef);

    // Assert
    assertEquals("", actualNextBadCustomDefResult.getInitializationErrorString());
    assertEquals(0, actualNextBadCustomDefResult.getObjectPropsCount());
    assertEquals(0, actualNextBadCustomDefResult.getObjectTypeValue());
    assertEquals(1, actualNextBadCustomDefResult.getAllFields().size());
    assertEquals(13, actualNextBadCustomDefResult.getSerializedSize());
    assertEquals(DefinitionCase.CUSTOM, actualNextBadCustomDefResult.getDefinitionCase());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualNextBadCustomDefResult.getObjectType());
    assertFalse(actualNextBadCustomDefResult.hasData());
    assertFalse(actualNextBadCustomDefResult.hasFile());
    assertFalse(actualNextBadCustomDefResult.hasFlow());
    assertFalse(actualNextBadCustomDefResult.hasJob());
    assertFalse(actualNextBadCustomDefResult.hasModel());
    assertFalse(actualNextBadCustomDefResult.hasResult());
    assertFalse(actualNextBadCustomDefResult.hasSchema());
    assertFalse(actualNextBadCustomDefResult.hasStorage());
    assertTrue(actualNextBadCustomDefResult.findInitializationErrors().isEmpty());
    assertTrue(actualNextBadCustomDefResult.getObjectProps().isEmpty());
    assertTrue(actualNextBadCustomDefResult.getObjectPropsMap().isEmpty());
    assertTrue(actualNextBadCustomDefResult.hasCustom());
    assertTrue(actualNextBadCustomDefResult.isInitialized());
    assertSame(origDef, actualNextBadCustomDefResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SampleMetadata#dummyTag(ObjectDefinition, boolean)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return AllFields size is two.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#dummyTag(ObjectDefinition, boolean)}
   */
  @Test
  @DisplayName(
      "Test dummyTag(ObjectDefinition, boolean); when DefaultInstance; then return AllFields size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.metadata.Tag SampleMetadata.dummyTag(ObjectDefinition, boolean)"
  })
  void testDummyTag_whenDefaultInstance_thenReturnAllFieldsSizeIsTwo() {
    // Arrange and Act
    org.finos.tracdap.metadata.Tag actualDummyTagResult =
        SampleMetadata.dummyTag(ObjectDefinition.getDefaultInstance(), false);

    // Assert
    assertEquals(2, actualDummyTagResult.getAllFields().size());
    assertEquals(80, actualDummyTagResult.getSerializedSize());
    assertFalse(actualDummyTagResult.hasHeader());
  }

  /**
   * Test {@link SampleMetadata#dummyTag(ObjectDefinition, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return SerializedSize is one hundred eighty-four.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#dummyTag(ObjectDefinition, boolean)}
   */
  @Test
  @DisplayName(
      "Test dummyTag(ObjectDefinition, boolean); when 'true'; then return SerializedSize is one hundred eighty-four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.metadata.Tag SampleMetadata.dummyTag(ObjectDefinition, boolean)"
  })
  void testDummyTag_whenTrue_thenReturnSerializedSizeIsOneHundredEightyFour() {
    // Arrange and Act
    org.finos.tracdap.metadata.Tag actualDummyTagResult =
        SampleMetadata.dummyTag(ObjectDefinition.getDefaultInstance(), true);

    // Assert
    assertEquals(184, actualDummyTagResult.getSerializedSize());
    assertEquals(3, actualDummyTagResult.getAllFields().size());
    assertTrue(actualDummyTagResult.hasHeader());
  }

  /**
   * Test {@link SampleMetadata#dummyAttrs()}.
   *
   * <p>Method under test: {@link SampleMetadata#dummyAttrs()}
   */
  @Test
  @DisplayName("Test dummyAttrs()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SampleMetadata.dummyAttrs()"})
  void testDummyAttrs() {
    // Arrange and Act
    Map<String, Value> actualDummyAttrsResult = SampleMetadata.dummyAttrs();

    // Assert
    assertEquals(2, actualDummyAttrsResult.size());
    Value getResult = actualDummyAttrsResult.get("dataset_key");
    assertEquals("", getResult.getInitializationErrorString());
    Value getResult2 = actualDummyAttrsResult.get("widget_type");
    assertEquals("", getResult2.getInitializationErrorString());
    assertEquals("non_standard_widget", getResult2.getStringValue());
    assertEquals("widget_orders", getResult.getStringValue());
    assertEquals(0.0d, getResult.getFloatValue());
    assertEquals(0.0d, getResult2.getFloatValue());
    assertEquals(0L, getResult.getIntegerValue());
    assertEquals(0L, getResult2.getIntegerValue());
    assertEquals(19, getResult.getSerializedSize());
    assertEquals(2, getResult.getAllFields().size());
    assertEquals(2, getResult2.getAllFields().size());
    assertEquals(25, getResult2.getSerializedSize());
    assertEquals(ValueCase.STRINGVALUE, getResult.getValueCase());
    assertEquals(ValueCase.STRINGVALUE, getResult2.getValueCase());
    assertFalse(getResult.getBooleanValue());
    assertFalse(getResult2.getBooleanValue());
    assertFalse(getResult.hasArrayValue());
    assertFalse(getResult2.hasArrayValue());
    assertFalse(getResult.hasBooleanValue());
    assertFalse(getResult2.hasBooleanValue());
    assertFalse(getResult.hasDateValue());
    assertFalse(getResult2.hasDateValue());
    assertFalse(getResult.hasDatetimeValue());
    assertFalse(getResult2.hasDatetimeValue());
    assertFalse(getResult.hasDecimalValue());
    assertFalse(getResult2.hasDecimalValue());
    assertFalse(getResult.hasFloatValue());
    assertFalse(getResult2.hasFloatValue());
    assertFalse(getResult.hasIntegerValue());
    assertFalse(getResult2.hasIntegerValue());
    assertFalse(getResult.hasMapValue());
    assertFalse(getResult2.hasMapValue());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult2.findInitializationErrors().isEmpty());
    assertTrue(getResult.hasStringValue());
    assertTrue(getResult2.hasStringValue());
    assertTrue(getResult.hasType());
    assertTrue(getResult2.hasType());
    assertTrue(getResult.isInitialized());
    assertTrue(getResult2.isInitialized());
    TypeDescriptor expectedTypeOrBuilder = getResult2.getType();
    assertSame(expectedTypeOrBuilder, getResult2.getTypeOrBuilder());
  }

  /**
   * Test {@link SampleMetadata#tagUpdatesForAttrs(Map)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#tagUpdatesForAttrs(Map)}
   */
  @Test
  @DisplayName("Test tagUpdatesForAttrs(Map); given empty string; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SampleMetadata.tagUpdatesForAttrs(Map)"})
  void testTagUpdatesForAttrs_givenEmptyString_thenReturnSizeIsTwo() {
    // Arrange
    HashMap<String, Value> attrs = new HashMap<>();
    attrs.put("", Value.getDefaultInstance());
    Value defaultInstance = Value.getDefaultInstance();
    attrs.put("foo", defaultInstance);

    // Act
    List<TagUpdate> actualTagUpdatesForAttrsResult = SampleMetadata.tagUpdatesForAttrs(attrs);

    // Assert
    assertEquals(2, actualTagUpdatesForAttrsResult.size());
    TagUpdate getResult = actualTagUpdatesForAttrsResult.get(1);
    assertEquals("", getResult.getInitializationErrorString());
    TagUpdate getResult2 = actualTagUpdatesForAttrsResult.get(0);
    assertEquals("", getResult2.getAttrName());
    assertEquals("foo", getResult.getAttrName());
    assertEquals(0, getResult.getOperationValue());
    assertEquals(1, getResult2.getAllFields().size());
    assertEquals(2, getResult.getAllFields().size());
    assertEquals(2, getResult2.getSerializedSize());
    assertEquals(7, getResult.getSerializedSize());
    assertEquals(TagOperation.CREATE_OR_REPLACE_ATTR, getResult.getOperation());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.hasValue());
    assertTrue(getResult.isInitialized());
    assertSame(defaultInstance, getResult.getValue());
    assertSame(defaultInstance, getResult.getValueOrBuilder());
  }

  /**
   * Test {@link SampleMetadata#tagUpdatesForAttrs(Map)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#tagUpdatesForAttrs(Map)}
   */
  @Test
  @DisplayName("Test tagUpdatesForAttrs(Map); given 'foo'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SampleMetadata.tagUpdatesForAttrs(Map)"})
  void testTagUpdatesForAttrs_givenFoo_thenReturnSizeIsOne() {
    // Arrange
    HashMap<String, Value> attrs = new HashMap<>();
    attrs.put("foo", Value.getDefaultInstance());

    // Act
    List<TagUpdate> actualTagUpdatesForAttrsResult = SampleMetadata.tagUpdatesForAttrs(attrs);

    // Assert
    assertEquals(1, actualTagUpdatesForAttrsResult.size());
    TagUpdate getResult = actualTagUpdatesForAttrsResult.get(0);
    ByteString attrNameBytes = getResult.getAttrNameBytes();
    assertEquals("foo", attrNameBytes.toStringUtf8());
    assertEquals("foo", getResult.getAttrName());
    assertEquals(2, getResult.getAllFields().size());
    assertEquals(3, getResult.getDescriptorForType().getFields().size());
    assertEquals(7, getResult.getSerializedSize());
    assertFalse(attrNameBytes.isEmpty());
    assertTrue(attrNameBytes.iterator().hasNext());
  }

  /**
   * Test {@link SampleMetadata#tagUpdatesForAttrs(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#tagUpdatesForAttrs(Map)}
   */
  @Test
  @DisplayName("Test tagUpdatesForAttrs(Map); when HashMap(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SampleMetadata.tagUpdatesForAttrs(Map)"})
  void testTagUpdatesForAttrs_whenHashMap_thenReturnEmpty() {
    // Arrange and Act
    List<TagUpdate> actualTagUpdatesForAttrsResult =
        SampleMetadata.tagUpdatesForAttrs(new HashMap<>());

    // Assert
    assertTrue(actualTagUpdatesForAttrsResult.isEmpty());
  }

  /**
   * Test {@link SampleMetadata#tagForNextObject(Tag, ObjectDefinition, boolean)}.
   *
   * <p>Method under test: {@link SampleMetadata#tagForNextObject(org.finos.tracdap.metadata.Tag,
   * ObjectDefinition, boolean)}
   */
  @Test
  @DisplayName("Test tagForNextObject(Tag, ObjectDefinition, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.metadata.Tag SampleMetadata.tagForNextObject(org.finos.tracdap.metadata.Tag, ObjectDefinition, boolean)"
  })
  void testTagForNextObject() {
    // Arrange
    org.finos.tracdap.metadata.Tag previous = org.finos.tracdap.metadata.Tag.getDefaultInstance();
    ObjectDefinition obj = ObjectDefinition.getDefaultInstance();

    // Act
    org.finos.tracdap.metadata.Tag actualTagForNextObjectResult =
        SampleMetadata.tagForNextObject(previous, obj, true);

    // Assert
    assertEquals("", actualTagForNextObjectResult.getInitializationErrorString());
    Map<String, Value> attrs = actualTagForNextObjectResult.getAttrs();
    assertEquals(1, attrs.size());
    assertEquals(1, actualTagForNextObjectResult.getAttrsCount());
    assertEquals(113, actualTagForNextObjectResult.getSerializedSize());
    assertEquals(3, actualTagForNextObjectResult.getAllFields().size());
    assertTrue(actualTagForNextObjectResult.findInitializationErrors().isEmpty());
    assertTrue(attrs.containsKey("extra_attr"));
    assertTrue(actualTagForNextObjectResult.hasDefinition());
    assertTrue(actualTagForNextObjectResult.hasHeader());
    assertTrue(actualTagForNextObjectResult.isInitialized());
    assertEquals(attrs, actualTagForNextObjectResult.getAttrsMap());
    assertSame(obj, actualTagForNextObjectResult.getDefinition());
    assertSame(obj, actualTagForNextObjectResult.getDefinitionOrBuilder());
    assertSame(previous, actualTagForNextObjectResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SampleMetadata#nextTag(Tag, boolean)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return AllFields size is two.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#nextTag(org.finos.tracdap.metadata.Tag, boolean)}
   */
  @Test
  @DisplayName(
      "Test nextTag(Tag, boolean); when DefaultInstance; then return AllFields size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.metadata.Tag SampleMetadata.nextTag(org.finos.tracdap.metadata.Tag, boolean)"
  })
  void testNextTag_whenDefaultInstance_thenReturnAllFieldsSizeIsTwo() {
    // Arrange and Act
    org.finos.tracdap.metadata.Tag actualNextTagResult =
        SampleMetadata.nextTag(org.finos.tracdap.metadata.Tag.getDefaultInstance(), true);

    // Assert
    assertEquals(2, actualNextTagResult.getAllFields().size());
    assertEquals(79, actualNextTagResult.getSerializedSize());
    assertTrue(actualNextTagResult.hasHeader());
  }

  /**
   * Test {@link SampleMetadata#nextTag(Tag, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return AllFields size is one.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#nextTag(org.finos.tracdap.metadata.Tag, boolean)}
   */
  @Test
  @DisplayName("Test nextTag(Tag, boolean); when 'false'; then return AllFields size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.metadata.Tag SampleMetadata.nextTag(org.finos.tracdap.metadata.Tag, boolean)"
  })
  void testNextTag_whenFalse_thenReturnAllFieldsSizeIsOne() {
    // Arrange and Act
    org.finos.tracdap.metadata.Tag actualNextTagResult =
        SampleMetadata.nextTag(org.finos.tracdap.metadata.Tag.getDefaultInstance(), false);

    // Assert
    assertEquals(1, actualNextTagResult.getAllFields().size());
    assertEquals(45, actualNextTagResult.getSerializedSize());
    assertFalse(actualNextTagResult.hasHeader());
  }

  /**
   * Test {@link SampleMetadata#addMultiValuedAttr(Tag)}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#addMultiValuedAttr(org.finos.tracdap.metadata.Tag)}
   */
  @Test
  @DisplayName(
      "Test addMultiValuedAttr(Tag); then return InitializationErrorString is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.tracdap.metadata.Tag SampleMetadata.addMultiValuedAttr(org.finos.tracdap.metadata.Tag)"
  })
  void testAddMultiValuedAttr_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange
    org.finos.tracdap.metadata.Tag tag = org.finos.tracdap.metadata.Tag.getDefaultInstance();

    // Act
    org.finos.tracdap.metadata.Tag actualAddMultiValuedAttrResult =
        SampleMetadata.addMultiValuedAttr(tag);

    // Assert
    assertEquals("", actualAddMultiValuedAttrResult.getInitializationErrorString());
    assertEquals(1, actualAddMultiValuedAttrResult.getAllFields().size());
    Map<String, Value> attrs = actualAddMultiValuedAttrResult.getAttrs();
    assertEquals(1, attrs.size());
    assertEquals(1, actualAddMultiValuedAttrResult.getAttrsCount());
    assertEquals(81, actualAddMultiValuedAttrResult.getSerializedSize());
    assertFalse(actualAddMultiValuedAttrResult.hasDefinition());
    assertFalse(actualAddMultiValuedAttrResult.hasHeader());
    assertTrue(actualAddMultiValuedAttrResult.findInitializationErrors().isEmpty());
    assertTrue(attrs.containsKey("data_classification"));
    assertTrue(actualAddMultiValuedAttrResult.isInitialized());
    assertEquals(attrs, actualAddMultiValuedAttrResult.getAttrsMap());
    assertSame(tag, actualAddMultiValuedAttrResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link SampleMetadata#objectOfDifferentType(BasicType)}.
   *
   * <ul>
   *   <li>Then return {@code the_droids_you_are_looking_for}.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#objectOfDifferentType(BasicType)}
   */
  @Test
  @DisplayName(
      "Test objectOfDifferentType(BasicType); then return 'the_droids_you_are_looking_for'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Object SampleMetadata.objectOfDifferentType(BasicType)"})
  void testObjectOfDifferentType_thenReturnTheDroidsYouAreLookingFor() {
    // Arrange, Act and Assert
    assertEquals(
        "the_droids_you_are_looking_for",
        SampleMetadata.objectOfDifferentType(BasicType.BASIC_TYPE_NOT_SET));
  }

  /**
   * Test {@link SampleMetadata#objectOfDifferentType(BasicType)}.
   *
   * <ul>
   *   <li>When {@link BasicType#STRING}.
   *   <li>Then return longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#objectOfDifferentType(BasicType)}
   */
  @Test
  @DisplayName(
      "Test objectOfDifferentType(BasicType); when STRING; then return longValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Object SampleMetadata.objectOfDifferentType(BasicType)"})
  void testObjectOfDifferentType_whenString_thenReturnLongValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42L, ((Long) SampleMetadata.objectOfDifferentType(BasicType.STRING)).longValue());
  }

  /**
   * Test {@link SampleMetadata#truncateMicrosecondPrecision(OffsetDateTime)}.
   *
   * <p>Method under test: {@link SampleMetadata#truncateMicrosecondPrecision(OffsetDateTime)}
   */
  @Test
  @DisplayName("Test truncateMicrosecondPrecision(OffsetDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OffsetDateTime SampleMetadata.truncateMicrosecondPrecision(OffsetDateTime)"})
  void testTruncateMicrosecondPrecision() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    OffsetDateTime dateTime = OffsetDateTime.of(ofResult, LocalTime.MIDNIGHT, ZoneOffset.UTC);

    // Act
    OffsetDateTime actualTruncateMicrosecondPrecisionResult =
        SampleMetadata.truncateMicrosecondPrecision(dateTime);

    // Assert
    LocalDateTime toLocalDateTimeResult =
        actualTruncateMicrosecondPrecisionResult.toLocalDateTime();
    assertEquals("00:00", toLocalDateTimeResult.toLocalTime().toString());
    LocalDate toLocalDateResult = toLocalDateTimeResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Z", actualTruncateMicrosecondPrecisionResult.getOffset().toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link SampleMetadata#selectorForTag(TagHeader)} with {@code tagHeader}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#selectorForTag(TagHeader)}
   */
  @Test
  @DisplayName(
      "Test selectorForTag(TagHeader) with 'tagHeader'; then return InitializationErrorString is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TagSelector SampleMetadata.selectorForTag(TagHeader)"})
  void testSelectorForTagWithTagHeader_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange and Act
    TagSelector actualSelectorForTagResult =
        SampleMetadata.selectorForTag(TagHeader.getDefaultInstance());

    // Assert
    assertEquals("", actualSelectorForTagResult.getInitializationErrorString());
    assertEquals("", actualSelectorForTagResult.getObjectId());
    assertEquals(0, actualSelectorForTagResult.getObjectTypeValue());
    assertEquals(0, actualSelectorForTagResult.getObjectVersion());
    assertEquals(0, actualSelectorForTagResult.getTagVersion());
    assertEquals(2, actualSelectorForTagResult.getAllFields().size());
    assertEquals(4, actualSelectorForTagResult.getSerializedSize());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualSelectorForTagResult.getObjectType());
    assertEquals(
        ObjectCriteriaCase.OBJECTVERSION, actualSelectorForTagResult.getObjectCriteriaCase());
    assertEquals(TagCriteriaCase.TAGVERSION, actualSelectorForTagResult.getTagCriteriaCase());
    assertFalse(actualSelectorForTagResult.getLatestObject());
    assertFalse(actualSelectorForTagResult.getLatestTag());
    assertFalse(actualSelectorForTagResult.hasLatestObject());
    assertFalse(actualSelectorForTagResult.hasLatestTag());
    assertFalse(actualSelectorForTagResult.hasObjectAsOf());
    assertFalse(actualSelectorForTagResult.hasTagAsOf());
    assertTrue(actualSelectorForTagResult.findInitializationErrors().isEmpty());
    assertTrue(actualSelectorForTagResult.hasObjectVersion());
    assertTrue(actualSelectorForTagResult.hasTagVersion());
    assertTrue(actualSelectorForTagResult.isInitialized());
  }

  /**
   * Test {@link SampleMetadata#selectorForTag(Tag)} with {@code tag}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#selectorForTag(org.finos.tracdap.metadata.Tag)}
   */
  @Test
  @DisplayName(
      "Test selectorForTag(Tag) with 'tag'; then return InitializationErrorString is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TagSelector SampleMetadata.selectorForTag(org.finos.tracdap.metadata.Tag)"})
  void testSelectorForTagWithTag_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange and Act
    TagSelector actualSelectorForTagResult =
        SampleMetadata.selectorForTag(org.finos.tracdap.metadata.Tag.getDefaultInstance());

    // Assert
    assertEquals("", actualSelectorForTagResult.getInitializationErrorString());
    assertEquals("", actualSelectorForTagResult.getObjectId());
    assertEquals(0, actualSelectorForTagResult.getObjectTypeValue());
    assertEquals(0, actualSelectorForTagResult.getObjectVersion());
    assertEquals(0, actualSelectorForTagResult.getTagVersion());
    assertEquals(2, actualSelectorForTagResult.getAllFields().size());
    assertEquals(4, actualSelectorForTagResult.getSerializedSize());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualSelectorForTagResult.getObjectType());
    assertEquals(
        ObjectCriteriaCase.OBJECTVERSION, actualSelectorForTagResult.getObjectCriteriaCase());
    assertEquals(TagCriteriaCase.TAGVERSION, actualSelectorForTagResult.getTagCriteriaCase());
    assertFalse(actualSelectorForTagResult.getLatestObject());
    assertFalse(actualSelectorForTagResult.getLatestTag());
    assertFalse(actualSelectorForTagResult.hasLatestObject());
    assertFalse(actualSelectorForTagResult.hasLatestTag());
    assertFalse(actualSelectorForTagResult.hasObjectAsOf());
    assertFalse(actualSelectorForTagResult.hasTagAsOf());
    assertTrue(actualSelectorForTagResult.findInitializationErrors().isEmpty());
    assertTrue(actualSelectorForTagResult.hasObjectVersion());
    assertTrue(actualSelectorForTagResult.hasTagVersion());
    assertTrue(actualSelectorForTagResult.isInitialized());
  }

  /**
   * Test {@link SampleMetadata#randomPrimitive(BasicType)}.
   *
   * <ul>
   *   <li>When {@code BOOLEAN}.
   *   <li>Then return SerializedSize is six.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#randomPrimitive(BasicType)}
   */
  @Test
  @DisplayName("Test randomPrimitive(BasicType); when 'BOOLEAN'; then return SerializedSize is six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value SampleMetadata.randomPrimitive(BasicType)"})
  void testRandomPrimitive_whenBoolean_thenReturnSerializedSizeIsSix() {
    // Arrange and Act
    Value actualRandomPrimitiveResult = SampleMetadata.randomPrimitive(BasicType.BOOLEAN);

    // Assert
    assertEquals(6, actualRandomPrimitiveResult.getSerializedSize());
    assertEquals(ValueCase.BOOLEANVALUE, actualRandomPrimitiveResult.getValueCase());
    assertTrue(actualRandomPrimitiveResult.getBooleanValue());
    assertTrue(actualRandomPrimitiveResult.hasBooleanValue());
  }

  /**
   * Test {@link SampleMetadata#randomPrimitive(BasicType)}.
   *
   * <ul>
   *   <li>When {@code DATE}.
   *   <li>Then return SerializedSize is eighteen.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#randomPrimitive(BasicType)}
   */
  @Test
  @DisplayName(
      "Test randomPrimitive(BasicType); when 'DATE'; then return SerializedSize is eighteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value SampleMetadata.randomPrimitive(BasicType)"})
  void testRandomPrimitive_whenDate_thenReturnSerializedSizeIsEighteen() {
    // Arrange and Act
    Value actualRandomPrimitiveResult = SampleMetadata.randomPrimitive(BasicType.DATE);

    // Assert
    assertEquals(18, actualRandomPrimitiveResult.getSerializedSize());
    assertEquals(ValueCase.DATEVALUE, actualRandomPrimitiveResult.getValueCase());
    assertTrue(actualRandomPrimitiveResult.hasDateValue());
  }

  /**
   * Test {@link SampleMetadata#randomPrimitive(BasicType)}.
   *
   * <ul>
   *   <li>When {@code DATETIME}.
   *   <li>Then return ValueCase is {@code DATETIMEVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#randomPrimitive(BasicType)}
   */
  @Test
  @DisplayName(
      "Test randomPrimitive(BasicType); when 'DATETIME'; then return ValueCase is 'DATETIMEVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value SampleMetadata.randomPrimitive(BasicType)"})
  void testRandomPrimitive_whenDatetime_thenReturnValueCaseIsDatetimevalue() {
    // Arrange and Act
    Value actualRandomPrimitiveResult = SampleMetadata.randomPrimitive(BasicType.DATETIME);

    // Assert
    assertEquals(ValueCase.DATETIMEVALUE, actualRandomPrimitiveResult.getValueCase());
    assertTrue(actualRandomPrimitiveResult.hasDatetimeValue());
    assertEquals(Integer.SIZE, actualRandomPrimitiveResult.getSerializedSize());
  }

  /**
   * Test {@link SampleMetadata#randomPrimitive(BasicType)}.
   *
   * <ul>
   *   <li>When {@code FLOAT}.
   *   <li>Then return SerializedSize is thirteen.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#randomPrimitive(BasicType)}
   */
  @Test
  @DisplayName(
      "Test randomPrimitive(BasicType); when 'FLOAT'; then return SerializedSize is thirteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value SampleMetadata.randomPrimitive(BasicType)"})
  void testRandomPrimitive_whenFloat_thenReturnSerializedSizeIsThirteen() {
    // Arrange and Act
    Value actualRandomPrimitiveResult = SampleMetadata.randomPrimitive(BasicType.FLOAT);

    // Assert
    assertEquals(13, actualRandomPrimitiveResult.getSerializedSize());
    assertEquals(ValueCase.FLOATVALUE, actualRandomPrimitiveResult.getValueCase());
    assertTrue(actualRandomPrimitiveResult.hasFloatValue());
  }

  /**
   * Test {@link SampleMetadata#randomPrimitive(BasicType)}.
   *
   * <ul>
   *   <li>When {@code INTEGER}.
   *   <li>Then return ValueCase is {@code INTEGERVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#randomPrimitive(BasicType)}
   */
  @Test
  @DisplayName(
      "Test randomPrimitive(BasicType); when 'INTEGER'; then return ValueCase is 'INTEGERVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value SampleMetadata.randomPrimitive(BasicType)"})
  void testRandomPrimitive_whenInteger_thenReturnValueCaseIsIntegervalue() {
    // Arrange and Act
    Value actualRandomPrimitiveResult = SampleMetadata.randomPrimitive(BasicType.INTEGER);

    // Assert
    assertEquals(ValueCase.INTEGERVALUE, actualRandomPrimitiveResult.getValueCase());
    assertTrue(actualRandomPrimitiveResult.hasIntegerValue());
  }

  /**
   * Test {@link SampleMetadata#randomPrimitive(BasicType)}.
   *
   * <ul>
   *   <li>When {@code STRING}.
   *   <li>Then return ValueCase is {@code STRINGVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SampleMetadata#randomPrimitive(BasicType)}
   */
  @Test
  @DisplayName(
      "Test randomPrimitive(BasicType); when 'STRING'; then return ValueCase is 'STRINGVALUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value SampleMetadata.randomPrimitive(BasicType)"})
  void testRandomPrimitive_whenString_thenReturnValueCaseIsStringvalue() {
    // Arrange and Act
    Value actualRandomPrimitiveResult = SampleMetadata.randomPrimitive(BasicType.STRING);

    // Assert
    assertEquals(ValueCase.STRINGVALUE, actualRandomPrimitiveResult.getValueCase());
    assertTrue(actualRandomPrimitiveResult.hasStringValue());
  }
}
