package org.finos.tracdap.metadata;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.FileOptions;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.finos.tracdap.metadata.TagSelector.ObjectCriteriaCase;
import org.finos.tracdap.metadata.TagSelector.TagCriteriaCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TagSelectorDiffblueTest {
  /**
   * Test {@link TagSelector#getObjectCriteriaCase()}.
   * <p>
   * Method under test: {@link TagSelector#getObjectCriteriaCase()}
   */
  @Test
  @DisplayName("Test getObjectCriteriaCase()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectCriteriaCase TagSelector.getObjectCriteriaCase()"})
  void testGetObjectCriteriaCase() {
    // Arrange, Act and Assert
    assertEquals(ObjectCriteriaCase.OBJECTCRITERIA_NOT_SET, TagSelector.getDefaultInstance().getObjectCriteriaCase());
  }

  /**
   * Test {@link TagSelector#getTagCriteriaCase()}.
   * <p>
   * Method under test: {@link TagSelector#getTagCriteriaCase()}
   */
  @Test
  @DisplayName("Test getTagCriteriaCase()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagCriteriaCase TagSelector.getTagCriteriaCase()"})
  void testGetTagCriteriaCase() {
    // Arrange, Act and Assert
    assertEquals(TagCriteriaCase.TAGCRITERIA_NOT_SET, TagSelector.getDefaultInstance().getTagCriteriaCase());
  }

  /**
   * Test {@link TagSelector#getObjectType()}.
   * <p>
   * Method under test: {@link TagSelector#getObjectType()}
   */
  @Test
  @DisplayName("Test getObjectType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectType TagSelector.getObjectType()"})
  void testGetObjectType() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, TagSelector.getDefaultInstance().getObjectType());
  }

  /**
   * Test {@link TagSelector#getObjectId()}.
   * <p>
   * Method under test: {@link TagSelector#getObjectId()}
   */
  @Test
  @DisplayName("Test getObjectId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String TagSelector.getObjectId()"})
  void testGetObjectId() {
    // Arrange, Act and Assert
    assertEquals("", TagSelector.getDefaultInstance().getObjectId());
  }

  /**
   * Test {@link TagSelector#getObjectIdBytes()}.
   * <p>
   * Method under test: {@link TagSelector#getObjectIdBytes()}
   */
  @Test
  @DisplayName("Test getObjectIdBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString TagSelector.getObjectIdBytes()"})
  void testGetObjectIdBytes() {
    // Arrange
    TagSelector defaultInstance = TagSelector.getDefaultInstance();

    // Act
    ByteString actualObjectIdBytes = defaultInstance.getObjectIdBytes();

    // Assert
    ByteString byteString = actualObjectIdBytes.EMPTY;
    Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options.getJavaOuterClassnameBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getObjectAsOf().getIsoDatetimeBytes());
    assertEquals(byteString, actualObjectIdBytes);
  }

  /**
   * Test {@link TagSelector#hasLatestObject()}.
   * <p>
   * Method under test: {@link TagSelector#hasLatestObject()}
   */
  @Test
  @DisplayName("Test hasLatestObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TagSelector.hasLatestObject()"})
  void testHasLatestObject() {
    // Arrange, Act and Assert
    assertFalse(TagSelector.getDefaultInstance().hasLatestObject());
  }

  /**
   * Test {@link TagSelector#getLatestObject()}.
   * <p>
   * Method under test: {@link TagSelector#getLatestObject()}
   */
  @Test
  @DisplayName("Test getLatestObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TagSelector.getLatestObject()"})
  void testGetLatestObject() {
    // Arrange, Act and Assert
    assertFalse(TagSelector.getDefaultInstance().getLatestObject());
  }

  /**
   * Test {@link TagSelector#hasObjectVersion()}.
   * <p>
   * Method under test: {@link TagSelector#hasObjectVersion()}
   */
  @Test
  @DisplayName("Test hasObjectVersion()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TagSelector.hasObjectVersion()"})
  void testHasObjectVersion() {
    // Arrange, Act and Assert
    assertFalse(TagSelector.getDefaultInstance().hasObjectVersion());
  }

  /**
   * Test {@link TagSelector#getObjectVersion()}.
   * <p>
   * Method under test: {@link TagSelector#getObjectVersion()}
   */
  @Test
  @DisplayName("Test getObjectVersion()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int TagSelector.getObjectVersion()"})
  void testGetObjectVersion() {
    // Arrange, Act and Assert
    assertEquals(0, TagSelector.getDefaultInstance().getObjectVersion());
  }

  /**
   * Test {@link TagSelector#hasObjectAsOf()}.
   * <p>
   * Method under test: {@link TagSelector#hasObjectAsOf()}
   */
  @Test
  @DisplayName("Test hasObjectAsOf()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TagSelector.hasObjectAsOf()"})
  void testHasObjectAsOf() {
    // Arrange, Act and Assert
    assertFalse(TagSelector.getDefaultInstance().hasObjectAsOf());
  }

  /**
   * Test {@link TagSelector#getObjectAsOf()}.
   * <p>
   * Method under test: {@link TagSelector#getObjectAsOf()}
   */
  @Test
  @DisplayName("Test getObjectAsOf()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DatetimeValue TagSelector.getObjectAsOf()"})
  void testGetObjectAsOf() {
    // Arrange and Act
    DatetimeValue actualObjectAsOf = TagSelector.getDefaultInstance().getObjectAsOf();

    // Assert
    assertEquals("", actualObjectAsOf.getInitializationErrorString());
    assertEquals("", actualObjectAsOf.getIsoDatetime());
    assertEquals(0, actualObjectAsOf.getSerializedSize());
    assertTrue(actualObjectAsOf.findInitializationErrors().isEmpty());
    assertTrue(actualObjectAsOf.getAllFields().isEmpty());
    assertTrue(actualObjectAsOf.isInitialized());
    assertSame(actualObjectAsOf, actualObjectAsOf.getDefaultInstanceForType());
  }

  /**
   * Test {@link TagSelector#hasLatestTag()}.
   * <p>
   * Method under test: {@link TagSelector#hasLatestTag()}
   */
  @Test
  @DisplayName("Test hasLatestTag()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TagSelector.hasLatestTag()"})
  void testHasLatestTag() {
    // Arrange, Act and Assert
    assertFalse(TagSelector.getDefaultInstance().hasLatestTag());
  }

  /**
   * Test {@link TagSelector#getLatestTag()}.
   * <p>
   * Method under test: {@link TagSelector#getLatestTag()}
   */
  @Test
  @DisplayName("Test getLatestTag()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TagSelector.getLatestTag()"})
  void testGetLatestTag() {
    // Arrange, Act and Assert
    assertFalse(TagSelector.getDefaultInstance().getLatestTag());
  }

  /**
   * Test {@link TagSelector#hasTagVersion()}.
   * <p>
   * Method under test: {@link TagSelector#hasTagVersion()}
   */
  @Test
  @DisplayName("Test hasTagVersion()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TagSelector.hasTagVersion()"})
  void testHasTagVersion() {
    // Arrange, Act and Assert
    assertFalse(TagSelector.getDefaultInstance().hasTagVersion());
  }

  /**
   * Test {@link TagSelector#getTagVersion()}.
   * <p>
   * Method under test: {@link TagSelector#getTagVersion()}
   */
  @Test
  @DisplayName("Test getTagVersion()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int TagSelector.getTagVersion()"})
  void testGetTagVersion() {
    // Arrange, Act and Assert
    assertEquals(0, TagSelector.getDefaultInstance().getTagVersion());
  }

  /**
   * Test {@link TagSelector#hasTagAsOf()}.
   * <p>
   * Method under test: {@link TagSelector#hasTagAsOf()}
   */
  @Test
  @DisplayName("Test hasTagAsOf()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TagSelector.hasTagAsOf()"})
  void testHasTagAsOf() {
    // Arrange, Act and Assert
    assertFalse(TagSelector.getDefaultInstance().hasTagAsOf());
  }

  /**
   * Test {@link TagSelector#getTagAsOf()}.
   * <p>
   * Method under test: {@link TagSelector#getTagAsOf()}
   */
  @Test
  @DisplayName("Test getTagAsOf()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DatetimeValue TagSelector.getTagAsOf()"})
  void testGetTagAsOf() {
    // Arrange and Act
    DatetimeValue actualTagAsOf = TagSelector.getDefaultInstance().getTagAsOf();

    // Assert
    assertEquals("", actualTagAsOf.getInitializationErrorString());
    assertEquals("", actualTagAsOf.getIsoDatetime());
    assertEquals(0, actualTagAsOf.getSerializedSize());
    assertTrue(actualTagAsOf.findInitializationErrors().isEmpty());
    assertTrue(actualTagAsOf.getAllFields().isEmpty());
    assertTrue(actualTagAsOf.isInitialized());
    assertSame(actualTagAsOf, actualTagAsOf.getDefaultInstanceForType());
  }

  /**
   * Test {@link TagSelector#isInitialized()}.
   * <p>
   * Method under test: {@link TagSelector#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TagSelector.isInitialized()"})
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TagSelector.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link TagSelector#getSerializedSize()}.
   * <p>
   * Method under test: {@link TagSelector#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int TagSelector.getSerializedSize()"})
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TagSelector.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link TagSelector#equals(Object)}, and {@link TagSelector#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TagSelector#equals(Object)}
   *   <li>{@link TagSelector#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TagSelector.equals(Object)", "int TagSelector.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TagSelector defaultInstance = TagSelector.getDefaultInstance();
    TagSelector defaultInstance2 = TagSelector.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link TagSelector#equals(Object)}, and {@link TagSelector#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TagSelector#equals(Object)}
   *   <li>{@link TagSelector#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TagSelector.equals(Object)", "int TagSelector.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TagSelector defaultInstance = TagSelector.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link TagSelector#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagSelector#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TagSelector.equals(Object)", "int TagSelector.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TagSelector.getDefaultInstance(), 1);
  }

  /**
   * Test {@link TagSelector#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagSelector#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TagSelector.equals(Object)", "int TagSelector.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TagSelector.getDefaultInstance(), null);
  }

  /**
   * Test {@link TagSelector#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagSelector#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TagSelector.equals(Object)", "int TagSelector.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TagSelector.getDefaultInstance(), "Different type to TagSelector");
  }

  /**
   * Test ObjectCriteriaCase {@link ObjectCriteriaCase#forNumber(int)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code OBJECTASOF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectCriteriaCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ObjectCriteriaCase forNumber(int); when five; then return 'OBJECTASOF'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectCriteriaCase ObjectCriteriaCase.forNumber(int)"})
  void testObjectCriteriaCaseForNumber_whenFive_thenReturnObjectasof() {
    // Arrange, Act and Assert
    assertEquals(ObjectCriteriaCase.OBJECTASOF, ObjectCriteriaCase.forNumber(5));
  }

  /**
   * Test ObjectCriteriaCase {@link ObjectCriteriaCase#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectCriteriaCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ObjectCriteriaCase forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectCriteriaCase ObjectCriteriaCase.forNumber(int)"})
  void testObjectCriteriaCaseForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ObjectCriteriaCase.forNumber(42));
  }

  /**
   * Test ObjectCriteriaCase {@link ObjectCriteriaCase#forNumber(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code OBJECTVERSION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectCriteriaCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ObjectCriteriaCase forNumber(int); when four; then return 'OBJECTVERSION'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectCriteriaCase ObjectCriteriaCase.forNumber(int)"})
  void testObjectCriteriaCaseForNumber_whenFour_thenReturnObjectversion() {
    // Arrange, Act and Assert
    assertEquals(ObjectCriteriaCase.OBJECTVERSION, ObjectCriteriaCase.forNumber(4));
  }

  /**
   * Test ObjectCriteriaCase {@link ObjectCriteriaCase#forNumber(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code LATESTOBJECT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectCriteriaCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ObjectCriteriaCase forNumber(int); when three; then return 'LATESTOBJECT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectCriteriaCase ObjectCriteriaCase.forNumber(int)"})
  void testObjectCriteriaCaseForNumber_whenThree_thenReturnLatestobject() {
    // Arrange, Act and Assert
    assertEquals(ObjectCriteriaCase.LATESTOBJECT, ObjectCriteriaCase.forNumber(3));
  }

  /**
   * Test ObjectCriteriaCase {@link ObjectCriteriaCase#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code OBJECTCRITERIA_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectCriteriaCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test ObjectCriteriaCase forNumber(int); when zero; then return 'OBJECTCRITERIA_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectCriteriaCase ObjectCriteriaCase.forNumber(int)"})
  void testObjectCriteriaCaseForNumber_whenZero_thenReturnObjectcriteriaNotSet() {
    // Arrange, Act and Assert
    assertEquals(ObjectCriteriaCase.OBJECTCRITERIA_NOT_SET, ObjectCriteriaCase.forNumber(0));
  }

  /**
   * Test ObjectCriteriaCase {@link ObjectCriteriaCase#getNumber()}.
   * <p>
   * Method under test: {@link ObjectCriteriaCase#getNumber()}
   */
  @Test
  @DisplayName("Test ObjectCriteriaCase getNumber()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ObjectCriteriaCase.getNumber()"})
  void testObjectCriteriaCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(3, ObjectCriteriaCase.valueOf("LATESTOBJECT").getNumber());
  }

  /**
   * Test ObjectCriteriaCase {@link ObjectCriteriaCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code OBJECTASOF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectCriteriaCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ObjectCriteriaCase valueOf(int) with 'value'; when five; then return 'OBJECTASOF'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectCriteriaCase ObjectCriteriaCase.valueOf(int)"})
  void testObjectCriteriaCaseValueOfWithValue_whenFive_thenReturnObjectasof() {
    // Arrange, Act and Assert
    assertEquals(ObjectCriteriaCase.OBJECTASOF, ObjectCriteriaCase.valueOf(5));
  }

  /**
   * Test ObjectCriteriaCase {@link ObjectCriteriaCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectCriteriaCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ObjectCriteriaCase valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectCriteriaCase ObjectCriteriaCase.valueOf(int)"})
  void testObjectCriteriaCaseValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ObjectCriteriaCase.valueOf(42));
  }

  /**
   * Test ObjectCriteriaCase {@link ObjectCriteriaCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code OBJECTVERSION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectCriteriaCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ObjectCriteriaCase valueOf(int) with 'value'; when four; then return 'OBJECTVERSION'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectCriteriaCase ObjectCriteriaCase.valueOf(int)"})
  void testObjectCriteriaCaseValueOfWithValue_whenFour_thenReturnObjectversion() {
    // Arrange, Act and Assert
    assertEquals(ObjectCriteriaCase.OBJECTVERSION, ObjectCriteriaCase.valueOf(4));
  }

  /**
   * Test ObjectCriteriaCase {@link ObjectCriteriaCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code LATESTOBJECT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectCriteriaCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ObjectCriteriaCase valueOf(int) with 'value'; when three; then return 'LATESTOBJECT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectCriteriaCase ObjectCriteriaCase.valueOf(int)"})
  void testObjectCriteriaCaseValueOfWithValue_whenThree_thenReturnLatestobject() {
    // Arrange, Act and Assert
    assertEquals(ObjectCriteriaCase.LATESTOBJECT, ObjectCriteriaCase.valueOf(3));
  }

  /**
   * Test ObjectCriteriaCase {@link ObjectCriteriaCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code OBJECTCRITERIA_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectCriteriaCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test ObjectCriteriaCase valueOf(int) with 'value'; when zero; then return 'OBJECTCRITERIA_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectCriteriaCase ObjectCriteriaCase.valueOf(int)"})
  void testObjectCriteriaCaseValueOfWithValue_whenZero_thenReturnObjectcriteriaNotSet() {
    // Arrange, Act and Assert
    assertEquals(ObjectCriteriaCase.OBJECTCRITERIA_NOT_SET, ObjectCriteriaCase.valueOf(0));
  }

  /**
   * Test {@link TagSelector#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TagSelector#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector TagSelector.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    TagSelector actualParseFromResult = TagSelector.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getObjectId());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getObjectVersion());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTagVersion());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseFromResult.getObjectType());
    assertEquals(ObjectCriteriaCase.OBJECTCRITERIA_NOT_SET, actualParseFromResult.getObjectCriteriaCase());
    assertEquals(TagCriteriaCase.TAGCRITERIA_NOT_SET, actualParseFromResult.getTagCriteriaCase());
    assertFalse(actualParseFromResult.getLatestObject());
    assertFalse(actualParseFromResult.getLatestTag());
    assertFalse(actualParseFromResult.hasLatestObject());
    assertFalse(actualParseFromResult.hasLatestTag());
    assertFalse(actualParseFromResult.hasObjectAsOf());
    assertFalse(actualParseFromResult.hasObjectVersion());
    assertFalse(actualParseFromResult.hasTagAsOf());
    assertFalse(actualParseFromResult.hasTagVersion());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link TagSelector#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagSelector#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteBuffer) with 'ByteBuffer'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector TagSelector.parseFrom(ByteBuffer)"})
  void testParseFromWithByteBuffer_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    TagSelector actualParseFromResult = TagSelector.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getObjectId());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getObjectVersion());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTagVersion());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseFromResult.getObjectType());
    assertEquals(ObjectCriteriaCase.OBJECTCRITERIA_NOT_SET, actualParseFromResult.getObjectCriteriaCase());
    assertEquals(TagCriteriaCase.TAGCRITERIA_NOT_SET, actualParseFromResult.getTagCriteriaCase());
    assertFalse(actualParseFromResult.getLatestObject());
    assertFalse(actualParseFromResult.getLatestTag());
    assertFalse(actualParseFromResult.hasLatestObject());
    assertFalse(actualParseFromResult.hasLatestTag());
    assertFalse(actualParseFromResult.hasObjectAsOf());
    assertFalse(actualParseFromResult.hasObjectVersion());
    assertFalse(actualParseFromResult.hasTagAsOf());
    assertFalse(actualParseFromResult.hasTagVersion());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link TagSelector#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TagSelector#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector TagSelector.parseFrom(byte[], ExtensionRegistryLite)"})
  void testParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    TagSelector actualParseFromResult = TagSelector.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getObjectId());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getObjectVersion());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTagVersion());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseFromResult.getObjectType());
    assertEquals(ObjectCriteriaCase.OBJECTCRITERIA_NOT_SET, actualParseFromResult.getObjectCriteriaCase());
    assertEquals(TagCriteriaCase.TAGCRITERIA_NOT_SET, actualParseFromResult.getTagCriteriaCase());
    assertFalse(actualParseFromResult.getLatestObject());
    assertFalse(actualParseFromResult.getLatestTag());
    assertFalse(actualParseFromResult.hasLatestObject());
    assertFalse(actualParseFromResult.hasLatestTag());
    assertFalse(actualParseFromResult.hasObjectAsOf());
    assertFalse(actualParseFromResult.hasObjectVersion());
    assertFalse(actualParseFromResult.hasTagAsOf());
    assertFalse(actualParseFromResult.hasTagVersion());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link TagSelector#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TagSelector#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector TagSelector.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    TagSelector actualParseFromResult = TagSelector.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getObjectId());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getObjectVersion());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTagVersion());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseFromResult.getObjectType());
    assertEquals(ObjectCriteriaCase.OBJECTCRITERIA_NOT_SET, actualParseFromResult.getObjectCriteriaCase());
    assertEquals(TagCriteriaCase.TAGCRITERIA_NOT_SET, actualParseFromResult.getTagCriteriaCase());
    assertFalse(actualParseFromResult.getLatestObject());
    assertFalse(actualParseFromResult.getLatestTag());
    assertFalse(actualParseFromResult.hasLatestObject());
    assertFalse(actualParseFromResult.hasLatestTag());
    assertFalse(actualParseFromResult.hasObjectAsOf());
    assertFalse(actualParseFromResult.hasObjectVersion());
    assertFalse(actualParseFromResult.hasTagAsOf());
    assertFalse(actualParseFromResult.hasTagVersion());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedObjectIdBytes = data.EMPTY;
    assertEquals(expectedObjectIdBytes, actualParseFromResult.getObjectIdBytes());
  }

  /**
   * Test {@link TagSelector#parseFrom(ByteString)} with {@code ByteString}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagSelector#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test parseFrom(ByteString) with 'ByteString'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector TagSelector.parseFrom(ByteString)"})
  void testParseFromWithByteString_thenReturnInitializationErrorStringIsEmptyString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    TagSelector actualParseFromResult = TagSelector.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getObjectId());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getObjectVersion());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTagVersion());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseFromResult.getObjectType());
    assertEquals(ObjectCriteriaCase.OBJECTCRITERIA_NOT_SET, actualParseFromResult.getObjectCriteriaCase());
    assertEquals(TagCriteriaCase.TAGCRITERIA_NOT_SET, actualParseFromResult.getTagCriteriaCase());
    assertFalse(actualParseFromResult.getLatestObject());
    assertFalse(actualParseFromResult.getLatestTag());
    assertFalse(actualParseFromResult.hasLatestObject());
    assertFalse(actualParseFromResult.hasLatestTag());
    assertFalse(actualParseFromResult.hasObjectAsOf());
    assertFalse(actualParseFromResult.hasObjectVersion());
    assertFalse(actualParseFromResult.hasTagAsOf());
    assertFalse(actualParseFromResult.hasTagVersion());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedObjectIdBytes = data.EMPTY;
    assertEquals(expectedObjectIdBytes, actualParseFromResult.getObjectIdBytes());
  }

  /**
   * Test {@link TagSelector#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagSelector#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector TagSelector.parseFrom(byte[])"})
  void testParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString() throws InvalidProtocolBufferException {
    // Arrange and Act
    TagSelector actualParseFromResult = TagSelector.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getObjectId());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getObjectVersion());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTagVersion());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseFromResult.getObjectType());
    assertEquals(ObjectCriteriaCase.OBJECTCRITERIA_NOT_SET, actualParseFromResult.getObjectCriteriaCase());
    assertEquals(TagCriteriaCase.TAGCRITERIA_NOT_SET, actualParseFromResult.getTagCriteriaCase());
    assertFalse(actualParseFromResult.getLatestObject());
    assertFalse(actualParseFromResult.getLatestTag());
    assertFalse(actualParseFromResult.hasLatestObject());
    assertFalse(actualParseFromResult.hasLatestTag());
    assertFalse(actualParseFromResult.hasObjectAsOf());
    assertFalse(actualParseFromResult.hasObjectVersion());
    assertFalse(actualParseFromResult.hasTagAsOf());
    assertFalse(actualParseFromResult.hasTagVersion());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link TagSelector#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link TagSelector#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector TagSelector.parseFrom(CodedInputStream)"})
  void testParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    TagSelector actualParseFromResult = TagSelector.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getObjectId());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getObjectVersion());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTagVersion());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseFromResult.getObjectType());
    assertEquals(ObjectCriteriaCase.OBJECTCRITERIA_NOT_SET, actualParseFromResult.getObjectCriteriaCase());
    assertEquals(TagCriteriaCase.TAGCRITERIA_NOT_SET, actualParseFromResult.getTagCriteriaCase());
    assertFalse(actualParseFromResult.getLatestObject());
    assertFalse(actualParseFromResult.getLatestTag());
    assertFalse(actualParseFromResult.hasLatestObject());
    assertFalse(actualParseFromResult.hasLatestTag());
    assertFalse(actualParseFromResult.hasObjectAsOf());
    assertFalse(actualParseFromResult.hasObjectVersion());
    assertFalse(actualParseFromResult.hasTagAsOf());
    assertFalse(actualParseFromResult.hasTagVersion());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link TagSelector#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TagSelector#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector TagSelector.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    TagSelector actualParseFromResult = TagSelector.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getObjectId());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getObjectVersion());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTagVersion());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseFromResult.getObjectType());
    assertEquals(ObjectCriteriaCase.OBJECTCRITERIA_NOT_SET, actualParseFromResult.getObjectCriteriaCase());
    assertEquals(TagCriteriaCase.TAGCRITERIA_NOT_SET, actualParseFromResult.getTagCriteriaCase());
    assertFalse(actualParseFromResult.getLatestObject());
    assertFalse(actualParseFromResult.getLatestTag());
    assertFalse(actualParseFromResult.hasLatestObject());
    assertFalse(actualParseFromResult.hasLatestTag());
    assertFalse(actualParseFromResult.hasObjectAsOf());
    assertFalse(actualParseFromResult.hasObjectVersion());
    assertFalse(actualParseFromResult.hasTagAsOf());
    assertFalse(actualParseFromResult.hasTagVersion());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link TagSelector#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TagSelector#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector TagSelector.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    TagSelector actualParseFromResult = TagSelector.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getObjectId());
    assertEquals(0, actualParseFromResult.getObjectTypeValue());
    assertEquals(0, actualParseFromResult.getObjectVersion());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTagVersion());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseFromResult.getObjectType());
    assertEquals(ObjectCriteriaCase.OBJECTCRITERIA_NOT_SET, actualParseFromResult.getObjectCriteriaCase());
    assertEquals(TagCriteriaCase.TAGCRITERIA_NOT_SET, actualParseFromResult.getTagCriteriaCase());
    assertFalse(actualParseFromResult.getLatestObject());
    assertFalse(actualParseFromResult.getLatestTag());
    assertFalse(actualParseFromResult.hasLatestObject());
    assertFalse(actualParseFromResult.hasLatestTag());
    assertFalse(actualParseFromResult.hasObjectAsOf());
    assertFalse(actualParseFromResult.hasObjectVersion());
    assertFalse(actualParseFromResult.hasTagAsOf());
    assertFalse(actualParseFromResult.hasTagVersion());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link TagSelector#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TagSelector#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector TagSelector.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TagSelector.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link TagSelector#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagSelector#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector TagSelector.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TagSelector.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link TagSelector#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagSelector#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector TagSelector.parseFrom(InputStream)"})
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TagSelector.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link TagSelector#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagSelector#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector TagSelector.parseFrom(InputStream)"})
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TagSelector.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link TagSelector#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagSelector#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector TagSelector.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    TagSelector actualParseFromResult = TagSelector.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    DatetimeValue objectAsOf = actualParseFromResult.getObjectAsOf();
    assertSame(unknownFields, objectAsOf.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(objectAsOf, objectAsOf.getDefaultInstanceForType());
    assertSame(objectAsOf, actualParseFromResult.getObjectAsOfOrBuilder());
    assertSame(objectAsOf, actualParseFromResult.getTagAsOf());
    assertSame(objectAsOf, actualParseFromResult.getTagAsOfOrBuilder());
  }

  /**
   * Test {@link TagSelector#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagSelector#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector TagSelector.parseFrom(InputStream)"})
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    TagSelector actualParseFromResult = TagSelector.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    DatetimeValue objectAsOf = actualParseFromResult.getObjectAsOf();
    assertSame(unknownFields, objectAsOf.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(objectAsOf, objectAsOf.getDefaultInstanceForType());
    assertSame(objectAsOf, actualParseFromResult.getObjectAsOfOrBuilder());
    assertSame(objectAsOf, actualParseFromResult.getTagAsOf());
    assertSame(objectAsOf, actualParseFromResult.getTagAsOfOrBuilder());
  }

  /**
   * Test {@link TagSelector#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TagSelector#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector TagSelector.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TagSelector actualParseDelimitedFromResult = TagSelector.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getObjectId());
    assertEquals(0, actualParseDelimitedFromResult.getObjectTypeValue());
    assertEquals(0, actualParseDelimitedFromResult.getObjectVersion());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getTagVersion());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseDelimitedFromResult.getObjectType());
    assertEquals(ObjectCriteriaCase.OBJECTCRITERIA_NOT_SET, actualParseDelimitedFromResult.getObjectCriteriaCase());
    assertEquals(TagCriteriaCase.TAGCRITERIA_NOT_SET, actualParseDelimitedFromResult.getTagCriteriaCase());
    assertFalse(actualParseDelimitedFromResult.getLatestObject());
    assertFalse(actualParseDelimitedFromResult.getLatestTag());
    assertFalse(actualParseDelimitedFromResult.hasLatestObject());
    assertFalse(actualParseDelimitedFromResult.hasLatestTag());
    assertFalse(actualParseDelimitedFromResult.hasObjectAsOf());
    assertFalse(actualParseDelimitedFromResult.hasObjectVersion());
    assertFalse(actualParseDelimitedFromResult.hasTagAsOf());
    assertFalse(actualParseDelimitedFromResult.hasTagVersion());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link TagSelector#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TagSelector#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector TagSelector.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TagSelector.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link TagSelector#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TagSelector#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector TagSelector.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TagSelector.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link TagSelector#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagSelector#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector TagSelector.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TagSelector.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link TagSelector#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagSelector#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector TagSelector.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TagSelector.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link TagSelector#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagSelector#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector TagSelector.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TagSelector.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link TagSelector#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagSelector#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector TagSelector.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnInitializationErrorStringIsEmptyString() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TagSelector actualParseDelimitedFromResult = TagSelector.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getObjectId());
    assertEquals(0, actualParseDelimitedFromResult.getObjectTypeValue());
    assertEquals(0, actualParseDelimitedFromResult.getObjectVersion());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getTagVersion());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualParseDelimitedFromResult.getObjectType());
    assertEquals(ObjectCriteriaCase.OBJECTCRITERIA_NOT_SET, actualParseDelimitedFromResult.getObjectCriteriaCase());
    assertEquals(TagCriteriaCase.TAGCRITERIA_NOT_SET, actualParseDelimitedFromResult.getTagCriteriaCase());
    assertFalse(actualParseDelimitedFromResult.getLatestObject());
    assertFalse(actualParseDelimitedFromResult.getLatestTag());
    assertFalse(actualParseDelimitedFromResult.hasLatestObject());
    assertFalse(actualParseDelimitedFromResult.hasLatestTag());
    assertFalse(actualParseDelimitedFromResult.hasObjectAsOf());
    assertFalse(actualParseDelimitedFromResult.hasObjectVersion());
    assertFalse(actualParseDelimitedFromResult.hasTagAsOf());
    assertFalse(actualParseDelimitedFromResult.hasTagVersion());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link TagSelector#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagSelector#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector TagSelector.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TagSelector.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link TagSelector#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagSelector#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector TagSelector.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TagSelector.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link TagSelector#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagSelector#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector TagSelector.parseDelimitedFrom(InputStream)"})
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TagSelector.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link TagSelector#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link TagSelector#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector TagSelector.getDefaultInstanceForType()"})
  void testGetDefaultInstanceForType() {
    // Arrange
    TagSelector defaultInstance = TagSelector.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test TagCriteriaCase {@link TagCriteriaCase#forNumber(int)}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return {@code TAGASOF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagCriteriaCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test TagCriteriaCase forNumber(int); when eight; then return 'TAGASOF'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagCriteriaCase TagCriteriaCase.forNumber(int)"})
  void testTagCriteriaCaseForNumber_whenEight_thenReturnTagasof() {
    // Arrange, Act and Assert
    assertEquals(TagCriteriaCase.TAGASOF, TagCriteriaCase.forNumber(8));
  }

  /**
   * Test TagCriteriaCase {@link TagCriteriaCase#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagCriteriaCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test TagCriteriaCase forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagCriteriaCase TagCriteriaCase.forNumber(int)"})
  void testTagCriteriaCaseForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TagCriteriaCase.forNumber(42));
  }

  /**
   * Test TagCriteriaCase {@link TagCriteriaCase#forNumber(int)}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code TAGVERSION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagCriteriaCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test TagCriteriaCase forNumber(int); when seven; then return 'TAGVERSION'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagCriteriaCase TagCriteriaCase.forNumber(int)"})
  void testTagCriteriaCaseForNumber_whenSeven_thenReturnTagversion() {
    // Arrange, Act and Assert
    assertEquals(TagCriteriaCase.TAGVERSION, TagCriteriaCase.forNumber(7));
  }

  /**
   * Test TagCriteriaCase {@link TagCriteriaCase#forNumber(int)}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code LATESTTAG}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagCriteriaCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test TagCriteriaCase forNumber(int); when six; then return 'LATESTTAG'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagCriteriaCase TagCriteriaCase.forNumber(int)"})
  void testTagCriteriaCaseForNumber_whenSix_thenReturnLatesttag() {
    // Arrange, Act and Assert
    assertEquals(TagCriteriaCase.LATESTTAG, TagCriteriaCase.forNumber(6));
  }

  /**
   * Test TagCriteriaCase {@link TagCriteriaCase#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code TAGCRITERIA_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagCriteriaCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test TagCriteriaCase forNumber(int); when zero; then return 'TAGCRITERIA_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagCriteriaCase TagCriteriaCase.forNumber(int)"})
  void testTagCriteriaCaseForNumber_whenZero_thenReturnTagcriteriaNotSet() {
    // Arrange, Act and Assert
    assertEquals(TagCriteriaCase.TAGCRITERIA_NOT_SET, TagCriteriaCase.forNumber(0));
  }

  /**
   * Test TagCriteriaCase {@link TagCriteriaCase#getNumber()}.
   * <p>
   * Method under test: {@link TagCriteriaCase#getNumber()}
   */
  @Test
  @DisplayName("Test TagCriteriaCase getNumber()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int TagCriteriaCase.getNumber()"})
  void testTagCriteriaCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(6, TagCriteriaCase.valueOf("LATESTTAG").getNumber());
  }

  /**
   * Test TagCriteriaCase {@link TagCriteriaCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return {@code TAGASOF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagCriteriaCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test TagCriteriaCase valueOf(int) with 'value'; when eight; then return 'TAGASOF'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagCriteriaCase TagCriteriaCase.valueOf(int)"})
  void testTagCriteriaCaseValueOfWithValue_whenEight_thenReturnTagasof() {
    // Arrange, Act and Assert
    assertEquals(TagCriteriaCase.TAGASOF, TagCriteriaCase.valueOf(8));
  }

  /**
   * Test TagCriteriaCase {@link TagCriteriaCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagCriteriaCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test TagCriteriaCase valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagCriteriaCase TagCriteriaCase.valueOf(int)"})
  void testTagCriteriaCaseValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TagCriteriaCase.valueOf(42));
  }

  /**
   * Test TagCriteriaCase {@link TagCriteriaCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code TAGVERSION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagCriteriaCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test TagCriteriaCase valueOf(int) with 'value'; when seven; then return 'TAGVERSION'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagCriteriaCase TagCriteriaCase.valueOf(int)"})
  void testTagCriteriaCaseValueOfWithValue_whenSeven_thenReturnTagversion() {
    // Arrange, Act and Assert
    assertEquals(TagCriteriaCase.TAGVERSION, TagCriteriaCase.valueOf(7));
  }

  /**
   * Test TagCriteriaCase {@link TagCriteriaCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code LATESTTAG}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagCriteriaCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test TagCriteriaCase valueOf(int) with 'value'; when six; then return 'LATESTTAG'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagCriteriaCase TagCriteriaCase.valueOf(int)"})
  void testTagCriteriaCaseValueOfWithValue_whenSix_thenReturnLatesttag() {
    // Arrange, Act and Assert
    assertEquals(TagCriteriaCase.LATESTTAG, TagCriteriaCase.valueOf(6));
  }

  /**
   * Test TagCriteriaCase {@link TagCriteriaCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code TAGCRITERIA_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagCriteriaCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test TagCriteriaCase valueOf(int) with 'value'; when zero; then return 'TAGCRITERIA_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagCriteriaCase TagCriteriaCase.valueOf(int)"})
  void testTagCriteriaCaseValueOfWithValue_whenZero_thenReturnTagcriteriaNotSet() {
    // Arrange, Act and Assert
    assertEquals(TagCriteriaCase.TAGCRITERIA_NOT_SET, TagCriteriaCase.valueOf(0));
  }
}
