package org.finos.tracdap.common.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import com.google.protobuf.UnknownFieldSet;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.metadata.DatetimeValue;
import org.finos.tracdap.metadata.ObjectType;
import org.finos.tracdap.metadata.TagHeader;
import org.finos.tracdap.metadata.TagSelector;
import org.finos.tracdap.metadata.TagSelector.ObjectCriteriaCase;
import org.finos.tracdap.metadata.TagSelector.TagCriteriaCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MetadataUtilDiffblueTest {
  /**
   * Test {@link MetadataUtil#selectorFor(TagHeader, boolean, boolean)} with {@code header}, {@code latestObject}, {@code latestTag}.
   * <p>
   * Method under test: {@link MetadataUtil#selectorFor(TagHeader, boolean, boolean)}
   */
  @Test
  @DisplayName("Test selectorFor(TagHeader, boolean, boolean) with 'header', 'latestObject', 'latestTag'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector MetadataUtil.selectorFor(TagHeader, boolean, boolean)"})
  void testSelectorForWithHeaderLatestObjectLatestTag() {
    // Arrange and Act
    TagSelector actualSelectorForResult = MetadataUtil.selectorFor(TagHeader.getDefaultInstance(), true, true);

    // Assert
    Descriptor descriptorForType = actualSelectorForResult.getDescriptorForType();
    List<OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(2, oneofs.size());
    assertEquals(8, descriptorForType.getFields().size());
    assertEquals(oneofs, descriptorForType.getRealOneofs());
    TagSelector defaultInstanceForType = actualSelectorForResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    UnknownFieldSet unknownFields = actualSelectorForResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    DatetimeValue objectAsOf = actualSelectorForResult.getObjectAsOf();
    assertSame(unknownFields, objectAsOf.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(objectAsOf, objectAsOf.getDefaultInstanceForType());
    assertSame(objectAsOf, defaultInstanceForType.getObjectAsOf());
    assertSame(objectAsOf, defaultInstanceForType.getObjectAsOfOrBuilder());
    assertSame(objectAsOf, actualSelectorForResult.getObjectAsOfOrBuilder());
    assertSame(objectAsOf, defaultInstanceForType.getTagAsOf());
    assertSame(objectAsOf, actualSelectorForResult.getTagAsOf());
    assertSame(objectAsOf, defaultInstanceForType.getTagAsOfOrBuilder());
    assertSame(objectAsOf, actualSelectorForResult.getTagAsOfOrBuilder());
  }

  /**
   * Test {@link MetadataUtil#selectorFor(TagHeader, boolean, boolean)} with {@code header}, {@code latestObject}, {@code latestTag}.
   * <p>
   * Method under test: {@link MetadataUtil#selectorFor(TagHeader, boolean, boolean)}
   */
  @Test
  @DisplayName("Test selectorFor(TagHeader, boolean, boolean) with 'header', 'latestObject', 'latestTag'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector MetadataUtil.selectorFor(TagHeader, boolean, boolean)"})
  void testSelectorForWithHeaderLatestObjectLatestTag2() {
    // Arrange and Act
    TagSelector actualSelectorForResult = MetadataUtil.selectorFor(TagHeader.getDefaultInstance(), false, true);

    // Assert
    assertEquals(ObjectCriteriaCase.OBJECTVERSION, actualSelectorForResult.getObjectCriteriaCase());
    assertFalse(actualSelectorForResult.getLatestObject());
    assertFalse(actualSelectorForResult.hasLatestObject());
    assertTrue(actualSelectorForResult.hasObjectVersion());
  }

  /**
   * Test {@link MetadataUtil#selectorFor(TagHeader, boolean, boolean)} with {@code header}, {@code latestObject}, {@code latestTag}.
   * <p>
   * Method under test: {@link MetadataUtil#selectorFor(TagHeader, boolean, boolean)}
   */
  @Test
  @DisplayName("Test selectorFor(TagHeader, boolean, boolean) with 'header', 'latestObject', 'latestTag'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector MetadataUtil.selectorFor(TagHeader, boolean, boolean)"})
  void testSelectorForWithHeaderLatestObjectLatestTag3() {
    // Arrange and Act
    TagSelector actualSelectorForResult = MetadataUtil.selectorFor(TagHeader.getDefaultInstance(), true, false);

    // Assert
    assertEquals(TagCriteriaCase.TAGVERSION, actualSelectorForResult.getTagCriteriaCase());
    assertFalse(actualSelectorForResult.getLatestTag());
    assertFalse(actualSelectorForResult.hasLatestTag());
    assertTrue(actualSelectorForResult.hasTagVersion());
  }

  /**
   * Test {@link MetadataUtil#selectorFor(TagHeader)} with {@code header}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataUtil#selectorFor(TagHeader)}
   */
  @Test
  @DisplayName("Test selectorFor(TagHeader) with 'header'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector MetadataUtil.selectorFor(TagHeader)"})
  void testSelectorForWithHeader_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange and Act
    TagSelector actualSelectorForResult = MetadataUtil.selectorFor(TagHeader.getDefaultInstance());

    // Assert
    assertEquals("", actualSelectorForResult.getInitializationErrorString());
    assertEquals("", actualSelectorForResult.getObjectId());
    assertEquals(0, actualSelectorForResult.getObjectTypeValue());
    assertEquals(0, actualSelectorForResult.getObjectVersion());
    assertEquals(0, actualSelectorForResult.getTagVersion());
    assertEquals(2, actualSelectorForResult.getAllFields().size());
    assertEquals(4, actualSelectorForResult.getSerializedSize());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualSelectorForResult.getObjectType());
    assertEquals(ObjectCriteriaCase.OBJECTVERSION, actualSelectorForResult.getObjectCriteriaCase());
    assertEquals(TagCriteriaCase.TAGVERSION, actualSelectorForResult.getTagCriteriaCase());
    assertFalse(actualSelectorForResult.getLatestObject());
    assertFalse(actualSelectorForResult.getLatestTag());
    assertFalse(actualSelectorForResult.hasLatestObject());
    assertFalse(actualSelectorForResult.hasLatestTag());
    assertFalse(actualSelectorForResult.hasObjectAsOf());
    assertFalse(actualSelectorForResult.hasTagAsOf());
    assertTrue(actualSelectorForResult.findInitializationErrors().isEmpty());
    assertTrue(actualSelectorForResult.hasObjectVersion());
    assertTrue(actualSelectorForResult.hasTagVersion());
    assertTrue(actualSelectorForResult.isInitialized());
  }

  /**
   * Test {@link MetadataUtil#selectorForLatest(TagHeader)}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataUtil#selectorForLatest(TagHeader)}
   */
  @Test
  @DisplayName("Test selectorForLatest(TagHeader); then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector MetadataUtil.selectorForLatest(TagHeader)"})
  void testSelectorForLatest_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange and Act
    TagSelector actualSelectorForLatestResult = MetadataUtil.selectorForLatest(TagHeader.getDefaultInstance());

    // Assert
    assertEquals("", actualSelectorForLatestResult.getInitializationErrorString());
    assertEquals("", actualSelectorForLatestResult.getObjectId());
    assertEquals(0, actualSelectorForLatestResult.getObjectTypeValue());
    assertEquals(0, actualSelectorForLatestResult.getObjectVersion());
    assertEquals(0, actualSelectorForLatestResult.getTagVersion());
    assertEquals(2, actualSelectorForLatestResult.getAllFields().size());
    assertEquals(4, actualSelectorForLatestResult.getSerializedSize());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualSelectorForLatestResult.getObjectType());
    assertEquals(ObjectCriteriaCase.LATESTOBJECT, actualSelectorForLatestResult.getObjectCriteriaCase());
    assertEquals(TagCriteriaCase.LATESTTAG, actualSelectorForLatestResult.getTagCriteriaCase());
    assertFalse(actualSelectorForLatestResult.hasObjectAsOf());
    assertFalse(actualSelectorForLatestResult.hasObjectVersion());
    assertFalse(actualSelectorForLatestResult.hasTagAsOf());
    assertFalse(actualSelectorForLatestResult.hasTagVersion());
    assertTrue(actualSelectorForLatestResult.findInitializationErrors().isEmpty());
    assertTrue(actualSelectorForLatestResult.getLatestObject());
    assertTrue(actualSelectorForLatestResult.getLatestTag());
    assertTrue(actualSelectorForLatestResult.hasLatestObject());
    assertTrue(actualSelectorForLatestResult.hasLatestTag());
    assertTrue(actualSelectorForLatestResult.isInitialized());
  }

  /**
   * Test {@link MetadataUtil#priorVersion(TagHeader)}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataUtil#priorVersion(TagHeader)}
   */
  @Test
  @DisplayName("Test priorVersion(TagHeader); then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector MetadataUtil.priorVersion(TagHeader)"})
  void testPriorVersion_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange and Act
    TagSelector actualPriorVersionResult = MetadataUtil.priorVersion(TagHeader.getDefaultInstance());

    // Assert
    assertEquals("", actualPriorVersionResult.getInitializationErrorString());
    assertEquals("", actualPriorVersionResult.getObjectId());
    assertEquals(-1, actualPriorVersionResult.getObjectVersion());
    assertEquals(0, actualPriorVersionResult.getObjectTypeValue());
    assertEquals(0, actualPriorVersionResult.getTagVersion());
    assertEquals(13, actualPriorVersionResult.getSerializedSize());
    assertEquals(2, actualPriorVersionResult.getAllFields().size());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualPriorVersionResult.getObjectType());
    assertEquals(ObjectCriteriaCase.OBJECTVERSION, actualPriorVersionResult.getObjectCriteriaCase());
    assertEquals(TagCriteriaCase.LATESTTAG, actualPriorVersionResult.getTagCriteriaCase());
    assertFalse(actualPriorVersionResult.getLatestObject());
    assertFalse(actualPriorVersionResult.hasLatestObject());
    assertFalse(actualPriorVersionResult.hasObjectAsOf());
    assertFalse(actualPriorVersionResult.hasTagAsOf());
    assertFalse(actualPriorVersionResult.hasTagVersion());
    assertTrue(actualPriorVersionResult.findInitializationErrors().isEmpty());
    assertTrue(actualPriorVersionResult.getLatestTag());
    assertTrue(actualPriorVersionResult.hasLatestTag());
    assertTrue(actualPriorVersionResult.hasObjectVersion());
    assertTrue(actualPriorVersionResult.isInitialized());
  }

  /**
   * Test {@link MetadataUtil#nextObjectVersion(TagHeader, Instant)}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataUtil#nextObjectVersion(TagHeader, Instant)}
   */
  @Test
  @DisplayName("Test nextObjectVersion(TagHeader, Instant); then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagHeader MetadataUtil.nextObjectVersion(TagHeader, Instant)"})
  void testNextObjectVersion_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange
    TagHeader header = TagHeader.getDefaultInstance();

    // Act
    TagHeader actualNextObjectVersionResult = MetadataUtil.nextObjectVersion(header,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    assertEquals("", actualNextObjectVersionResult.getInitializationErrorString());
    assertEquals("", actualNextObjectVersionResult.getObjectId());
    assertEquals(0, actualNextObjectVersionResult.getObjectTypeValue());
    assertEquals(1, actualNextObjectVersionResult.getObjectVersion());
    assertEquals(1, actualNextObjectVersionResult.getTagVersion());
    assertEquals(4, actualNextObjectVersionResult.getAllFields().size());
    assertEquals(60, actualNextObjectVersionResult.getSerializedSize());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualNextObjectVersionResult.getObjectType());
    assertFalse(actualNextObjectVersionResult.getIsLatestObject());
    assertFalse(actualNextObjectVersionResult.getIsLatestTag());
    assertTrue(actualNextObjectVersionResult.findInitializationErrors().isEmpty());
    assertTrue(actualNextObjectVersionResult.hasObjectTimestamp());
    assertTrue(actualNextObjectVersionResult.hasTagTimestamp());
    assertTrue(actualNextObjectVersionResult.isInitialized());
    DatetimeValue expectedTagTimestampOrBuilder = actualNextObjectVersionResult.getTagTimestamp();
    assertSame(expectedTagTimestampOrBuilder, actualNextObjectVersionResult.getTagTimestampOrBuilder());
    assertSame(header, actualNextObjectVersionResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link MetadataUtil#nextTagVersion(TagHeader, Instant)}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataUtil#nextTagVersion(TagHeader, Instant)}
   */
  @Test
  @DisplayName("Test nextTagVersion(TagHeader, Instant); then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagHeader MetadataUtil.nextTagVersion(TagHeader, Instant)"})
  void testNextTagVersion_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange
    TagHeader header = TagHeader.getDefaultInstance();

    // Act
    TagHeader actualNextTagVersionResult = MetadataUtil.nextTagVersion(header,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    assertEquals("", actualNextTagVersionResult.getInitializationErrorString());
    assertEquals("", actualNextTagVersionResult.getObjectId());
    assertEquals(0, actualNextTagVersionResult.getObjectTypeValue());
    assertEquals(0, actualNextTagVersionResult.getObjectVersion());
    assertEquals(1, actualNextTagVersionResult.getTagVersion());
    assertEquals(2, actualNextTagVersionResult.getAllFields().size());
    assertEquals(30, actualNextTagVersionResult.getSerializedSize());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualNextTagVersionResult.getObjectType());
    assertFalse(actualNextTagVersionResult.getIsLatestObject());
    assertFalse(actualNextTagVersionResult.getIsLatestTag());
    assertFalse(actualNextTagVersionResult.hasObjectTimestamp());
    assertTrue(actualNextTagVersionResult.findInitializationErrors().isEmpty());
    assertTrue(actualNextTagVersionResult.hasTagTimestamp());
    assertTrue(actualNextTagVersionResult.isInitialized());
    assertSame(header, actualNextTagVersionResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link MetadataUtil#preallocated(TagHeader)} with {@code TagHeader}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataUtil#preallocated(TagHeader)}
   */
  @Test
  @DisplayName("Test preallocated(TagHeader) with 'TagHeader'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector MetadataUtil.preallocated(TagHeader)"})
  void testPreallocatedWithTagHeader_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange and Act
    TagSelector actualPreallocatedResult = MetadataUtil.preallocated(TagHeader.getDefaultInstance());

    // Assert
    assertEquals("", actualPreallocatedResult.getInitializationErrorString());
    assertEquals("", actualPreallocatedResult.getObjectId());
    assertEquals(0, actualPreallocatedResult.getObjectTypeValue());
    assertEquals(0, actualPreallocatedResult.getObjectVersion());
    assertEquals(0, actualPreallocatedResult.getTagVersion());
    assertEquals(2, actualPreallocatedResult.getAllFields().size());
    assertEquals(4, actualPreallocatedResult.getSerializedSize());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualPreallocatedResult.getObjectType());
    assertEquals(ObjectCriteriaCase.OBJECTVERSION, actualPreallocatedResult.getObjectCriteriaCase());
    assertEquals(TagCriteriaCase.TAGVERSION, actualPreallocatedResult.getTagCriteriaCase());
    assertFalse(actualPreallocatedResult.getLatestObject());
    assertFalse(actualPreallocatedResult.getLatestTag());
    assertFalse(actualPreallocatedResult.hasLatestObject());
    assertFalse(actualPreallocatedResult.hasLatestTag());
    assertFalse(actualPreallocatedResult.hasObjectAsOf());
    assertFalse(actualPreallocatedResult.hasTagAsOf());
    assertTrue(actualPreallocatedResult.findInitializationErrors().isEmpty());
    assertTrue(actualPreallocatedResult.hasObjectVersion());
    assertTrue(actualPreallocatedResult.hasTagVersion());
    assertTrue(actualPreallocatedResult.isInitialized());
  }

  /**
   * Test {@link MetadataUtil#preallocated(TagSelector)} with {@code TagSelector}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataUtil#preallocated(TagSelector)}
   */
  @Test
  @DisplayName("Test preallocated(TagSelector) with 'TagSelector'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagSelector MetadataUtil.preallocated(TagSelector)"})
  void testPreallocatedWithTagSelector_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange
    TagSelector selector = TagSelector.getDefaultInstance();

    // Act
    TagSelector actualPreallocatedResult = MetadataUtil.preallocated(selector);

    // Assert
    assertEquals("", actualPreallocatedResult.getInitializationErrorString());
    assertEquals("", actualPreallocatedResult.getObjectId());
    assertEquals(0, actualPreallocatedResult.getObjectTypeValue());
    assertEquals(0, actualPreallocatedResult.getObjectVersion());
    assertEquals(0, actualPreallocatedResult.getTagVersion());
    assertEquals(2, actualPreallocatedResult.getAllFields().size());
    assertEquals(4, actualPreallocatedResult.getSerializedSize());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualPreallocatedResult.getObjectType());
    assertEquals(ObjectCriteriaCase.OBJECTVERSION, actualPreallocatedResult.getObjectCriteriaCase());
    assertEquals(TagCriteriaCase.TAGVERSION, actualPreallocatedResult.getTagCriteriaCase());
    assertFalse(actualPreallocatedResult.getLatestObject());
    assertFalse(actualPreallocatedResult.getLatestTag());
    assertFalse(actualPreallocatedResult.hasLatestObject());
    assertFalse(actualPreallocatedResult.hasLatestTag());
    assertFalse(actualPreallocatedResult.hasObjectAsOf());
    assertFalse(actualPreallocatedResult.hasTagAsOf());
    assertTrue(actualPreallocatedResult.findInitializationErrors().isEmpty());
    assertTrue(actualPreallocatedResult.hasObjectVersion());
    assertTrue(actualPreallocatedResult.hasTagVersion());
    assertTrue(actualPreallocatedResult.isInitialized());
    assertSame(selector, actualPreallocatedResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link MetadataUtil#objectKey(TagHeader)} with {@code header}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return {@code OBJECT_TYPE_NOT_SET--v0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataUtil#objectKey(TagHeader)}
   */
  @Test
  @DisplayName("Test objectKey(TagHeader) with 'header'; when DefaultInstance; then return 'OBJECT_TYPE_NOT_SET--v0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String MetadataUtil.objectKey(TagHeader)"})
  void testObjectKeyWithHeader_whenDefaultInstance_thenReturnObjectTypeNotSetV0() {
    // Arrange, Act and Assert
    assertEquals("OBJECT_TYPE_NOT_SET--v0", MetadataUtil.objectKey(TagHeader.getDefaultInstance()));
  }

  /**
   * Test {@link MetadataUtil#objectKey(TagSelector)} with {@code selector}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then throw {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataUtil#objectKey(TagSelector)}
   */
  @Test
  @DisplayName("Test objectKey(TagSelector) with 'selector'; when DefaultInstance; then throw EUnexpected")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String MetadataUtil.objectKey(TagSelector)"})
  void testObjectKeyWithSelector_whenDefaultInstance_thenThrowEUnexpected() {
    // Arrange, Act and Assert
    assertThrows(EUnexpected.class, () -> MetadataUtil.objectKey(TagSelector.getDefaultInstance()));
  }
}
