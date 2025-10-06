package org.finos.tracdap.svc.data.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.List;
import org.finos.tracdap.api.DataReadResponse;
import org.finos.tracdap.api.MetadataBatchRequest;
import org.finos.tracdap.api.MetadataReadRequest;
import org.finos.tracdap.api.MetadataWriteRequest;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.metadata.DataDefinition;
import org.finos.tracdap.metadata.FileDefinition;
import org.finos.tracdap.metadata.ObjectDefinition;
import org.finos.tracdap.metadata.ObjectDefinition.DefinitionCase;
import org.finos.tracdap.metadata.ObjectType;
import org.finos.tracdap.metadata.SchemaDefinition;
import org.finos.tracdap.metadata.StorageDefinition;
import org.finos.tracdap.metadata.TagHeader;
import org.finos.tracdap.metadata.TagSelector;
import org.finos.tracdap.metadata.TagUpdate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MetadataBuildersDiffblueTest {
  /**
   * Test {@link MetadataBuilders#preallocateRequest(String, ObjectType)}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link MetadataBuilders#preallocateRequest(String, ObjectType)}
   */
  @Test
  @DisplayName(
      "Test preallocateRequest(String, ObjectType); then return InitializationErrorString is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataWriteRequest MetadataBuilders.preallocateRequest(String, ObjectType)"
  })
  void testPreallocateRequest_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange and Act
    MetadataWriteRequest actualPreallocateRequestResult =
        MetadataBuilders.preallocateRequest("Tenant", ObjectType.OBJECT_TYPE_NOT_SET);

    // Assert
    assertEquals("", actualPreallocateRequestResult.getInitializationErrorString());
    assertEquals("Tenant", actualPreallocateRequestResult.getTenant());
    assertEquals(0, actualPreallocateRequestResult.getObjectTypeValue());
    assertEquals(0, actualPreallocateRequestResult.getTagUpdatesCount());
    assertEquals(1, actualPreallocateRequestResult.getAllFields().size());
    assertEquals(8, actualPreallocateRequestResult.getSerializedSize());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualPreallocateRequestResult.getObjectType());
    assertFalse(actualPreallocateRequestResult.hasDefinition());
    assertFalse(actualPreallocateRequestResult.hasPriorVersion());
    assertTrue(actualPreallocateRequestResult.findInitializationErrors().isEmpty());
    List<TagUpdate> tagUpdatesList = actualPreallocateRequestResult.getTagUpdatesList();
    assertTrue(tagUpdatesList.isEmpty());
    assertTrue(actualPreallocateRequestResult.isInitialized());
    assertSame(tagUpdatesList, actualPreallocateRequestResult.getTagUpdatesOrBuilderList());
  }

  /**
   * Test {@link MetadataBuilders#requestForSelector(String, TagSelector)}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link MetadataBuilders#requestForSelector(String, TagSelector)}
   */
  @Test
  @DisplayName(
      "Test requestForSelector(String, TagSelector); then return InitializationErrorString is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataReadRequest MetadataBuilders.requestForSelector(String, TagSelector)"
  })
  void testRequestForSelector_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange
    TagSelector selector = TagSelector.getDefaultInstance();

    // Act
    MetadataReadRequest actualRequestForSelectorResult =
        MetadataBuilders.requestForSelector("Tenant", selector);

    // Assert
    assertEquals("", actualRequestForSelectorResult.getInitializationErrorString());
    assertEquals("Tenant", actualRequestForSelectorResult.getTenant());
    assertEquals(10, actualRequestForSelectorResult.getSerializedSize());
    assertEquals(2, actualRequestForSelectorResult.getAllFields().size());
    assertTrue(actualRequestForSelectorResult.findInitializationErrors().isEmpty());
    assertTrue(actualRequestForSelectorResult.hasSelector());
    assertTrue(actualRequestForSelectorResult.isInitialized());
    assertSame(selector, actualRequestForSelectorResult.getSelector());
    assertSame(selector, actualRequestForSelectorResult.getSelectorOrBuilder());
  }

  /**
   * Test {@link MetadataBuilders#requestForBatch(String, TagSelector[])}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return SelectorList size is one.
   * </ul>
   *
   * <p>Method under test: {@link MetadataBuilders#requestForBatch(String, TagSelector[])}
   */
  @Test
  @DisplayName(
      "Test requestForBatch(String, TagSelector[]); when DefaultInstance; then return SelectorList size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataBatchRequest MetadataBuilders.requestForBatch(String, TagSelector[])"
  })
  void testRequestForBatch_whenDefaultInstance_thenReturnSelectorListSizeIsOne() {
    // Arrange
    TagSelector defaultInstance = TagSelector.getDefaultInstance();

    // Act
    MetadataBatchRequest actualRequestForBatchResult =
        MetadataBuilders.requestForBatch("Tenant", defaultInstance);

    // Assert
    List<TagSelector> selectorList = actualRequestForBatchResult.getSelectorList();
    assertEquals(1, selectorList.size());
    assertEquals(1, actualRequestForBatchResult.getSelectorCount());
    assertEquals(10, actualRequestForBatchResult.getSerializedSize());
    assertEquals(2, actualRequestForBatchResult.getAllFields().size());
    MetadataBatchRequest defaultInstanceForType =
        actualRequestForBatchResult.getDefaultInstanceForType();
    List<TagSelector> selectorList2 = defaultInstanceForType.getSelectorList();
    assertTrue(selectorList2.isEmpty());
    UnknownFieldSet unknownFields = actualRequestForBatchResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(selectorList2, defaultInstanceForType.getSelectorOrBuilderList());
    assertSame(selectorList, actualRequestForBatchResult.getSelectorOrBuilderList());
    assertSame(defaultInstance, selectorList.get(0));
  }

  /**
   * Test {@link MetadataBuilders#requestForBatch(String, TagSelector[])}.
   *
   * <ul>
   *   <li>When {@code Tenant}.
   *   <li>Then return SelectorCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link MetadataBuilders#requestForBatch(String, TagSelector[])}
   */
  @Test
  @DisplayName(
      "Test requestForBatch(String, TagSelector[]); when 'Tenant'; then return SelectorCount is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataBatchRequest MetadataBuilders.requestForBatch(String, TagSelector[])"
  })
  void testRequestForBatch_whenTenant_thenReturnSelectorCountIsZero() {
    // Arrange and Act
    MetadataBatchRequest actualRequestForBatchResult = MetadataBuilders.requestForBatch("Tenant");

    // Assert
    assertEquals(0, actualRequestForBatchResult.getSelectorCount());
    assertEquals(1, actualRequestForBatchResult.getAllFields().size());
    assertEquals(8, actualRequestForBatchResult.getSerializedSize());
    List<TagSelector> selectorList = actualRequestForBatchResult.getSelectorList();
    assertTrue(selectorList.isEmpty());
    UnknownFieldSet unknownFields = actualRequestForBatchResult.getUnknownFields();
    MetadataBatchRequest defaultInstanceForType =
        actualRequestForBatchResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    assertSame(selectorList, defaultInstanceForType.getSelectorList());
    assertSame(selectorList, defaultInstanceForType.getSelectorOrBuilderList());
    assertSame(selectorList, actualRequestForBatchResult.getSelectorOrBuilderList());
  }

  /**
   * Test {@link MetadataBuilders#bumpVersion(TagHeader)}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link MetadataBuilders#bumpVersion(TagHeader)}
   */
  @Test
  @DisplayName("Test bumpVersion(TagHeader); then return InitializationErrorString is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TagHeader MetadataBuilders.bumpVersion(TagHeader)"})
  void testBumpVersion_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange
    TagHeader priorVersion = TagHeader.getDefaultInstance();

    // Act
    TagHeader actualBumpVersionResult = MetadataBuilders.bumpVersion(priorVersion);

    // Assert
    assertEquals("", actualBumpVersionResult.getInitializationErrorString());
    assertEquals("", actualBumpVersionResult.getObjectId());
    assertEquals(0, actualBumpVersionResult.getObjectTypeValue());
    assertEquals(1, actualBumpVersionResult.getObjectVersion());
    assertEquals(1, actualBumpVersionResult.getTagVersion());
    assertEquals(2, actualBumpVersionResult.getAllFields().size());
    assertEquals(4, actualBumpVersionResult.getSerializedSize());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualBumpVersionResult.getObjectType());
    assertFalse(actualBumpVersionResult.getIsLatestObject());
    assertFalse(actualBumpVersionResult.getIsLatestTag());
    assertFalse(actualBumpVersionResult.hasObjectTimestamp());
    assertFalse(actualBumpVersionResult.hasTagTimestamp());
    assertTrue(actualBumpVersionResult.findInitializationErrors().isEmpty());
    assertTrue(actualBumpVersionResult.isInitialized());
    assertSame(priorVersion, actualBumpVersionResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link MetadataBuilders#objectOf(DataDefinition)} with {@code DataDefinition}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link MetadataBuilders#objectOf(DataDefinition)}
   */
  @Test
  @DisplayName(
      "Test objectOf(DataDefinition) with 'DataDefinition'; then return InitializationErrorString is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition MetadataBuilders.objectOf(DataDefinition)"})
  void testObjectOfWithDataDefinition_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange
    DataDefinition def = DataDefinition.getDefaultInstance();

    // Act
    ObjectDefinition actualObjectOfResult = MetadataBuilders.objectOf(def);

    // Assert
    assertEquals("", actualObjectOfResult.getInitializationErrorString());
    assertEquals(0, actualObjectOfResult.getObjectPropsCount());
    assertEquals(1, actualObjectOfResult.getObjectTypeValue());
    assertEquals(2, actualObjectOfResult.getAllFields().size());
    assertEquals(4, actualObjectOfResult.getSerializedSize());
    assertEquals(DefinitionCase.DATA, actualObjectOfResult.getDefinitionCase());
    assertEquals(ObjectType.DATA, actualObjectOfResult.getObjectType());
    assertFalse(actualObjectOfResult.hasCustom());
    assertFalse(actualObjectOfResult.hasFile());
    assertFalse(actualObjectOfResult.hasFlow());
    assertFalse(actualObjectOfResult.hasJob());
    assertFalse(actualObjectOfResult.hasModel());
    assertFalse(actualObjectOfResult.hasResult());
    assertFalse(actualObjectOfResult.hasSchema());
    assertFalse(actualObjectOfResult.hasStorage());
    assertTrue(actualObjectOfResult.findInitializationErrors().isEmpty());
    assertTrue(actualObjectOfResult.getObjectProps().isEmpty());
    assertTrue(actualObjectOfResult.getObjectPropsMap().isEmpty());
    assertTrue(actualObjectOfResult.hasData());
    assertTrue(actualObjectOfResult.isInitialized());
    assertSame(def, actualObjectOfResult.getData());
    assertSame(def, actualObjectOfResult.getDataOrBuilder());
  }

  /**
   * Test {@link MetadataBuilders#objectOf(FileDefinition)} with {@code FileDefinition}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link MetadataBuilders#objectOf(FileDefinition)}
   */
  @Test
  @DisplayName(
      "Test objectOf(FileDefinition) with 'FileDefinition'; then return InitializationErrorString is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition MetadataBuilders.objectOf(FileDefinition)"})
  void testObjectOfWithFileDefinition_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange
    FileDefinition def = FileDefinition.getDefaultInstance();

    // Act
    ObjectDefinition actualObjectOfResult = MetadataBuilders.objectOf(def);

    // Assert
    assertEquals("", actualObjectOfResult.getInitializationErrorString());
    assertEquals(0, actualObjectOfResult.getObjectPropsCount());
    assertEquals(2, actualObjectOfResult.getAllFields().size());
    assertEquals(4, actualObjectOfResult.getSerializedSize());
    assertEquals(5, actualObjectOfResult.getObjectTypeValue());
    assertEquals(DefinitionCase.FILE, actualObjectOfResult.getDefinitionCase());
    assertEquals(ObjectType.FILE, actualObjectOfResult.getObjectType());
    assertFalse(actualObjectOfResult.hasCustom());
    assertFalse(actualObjectOfResult.hasData());
    assertFalse(actualObjectOfResult.hasFlow());
    assertFalse(actualObjectOfResult.hasJob());
    assertFalse(actualObjectOfResult.hasModel());
    assertFalse(actualObjectOfResult.hasResult());
    assertFalse(actualObjectOfResult.hasSchema());
    assertFalse(actualObjectOfResult.hasStorage());
    assertTrue(actualObjectOfResult.findInitializationErrors().isEmpty());
    assertTrue(actualObjectOfResult.getObjectProps().isEmpty());
    assertTrue(actualObjectOfResult.getObjectPropsMap().isEmpty());
    assertTrue(actualObjectOfResult.hasFile());
    assertTrue(actualObjectOfResult.isInitialized());
    assertSame(def, actualObjectOfResult.getFile());
    assertSame(def, actualObjectOfResult.getFileOrBuilder());
  }

  /**
   * Test {@link MetadataBuilders#objectOf(Message)} with {@code Message}.
   *
   * <ul>
   *   <li>Then return ObjectTypeValue is five.
   * </ul>
   *
   * <p>Method under test: {@link MetadataBuilders#objectOf(Message)}
   */
  @Test
  @DisplayName("Test objectOf(Message) with 'Message'; then return ObjectTypeValue is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition MetadataBuilders.objectOf(Message)"})
  void testObjectOfWithMessage_thenReturnObjectTypeValueIsFive() {
    // Arrange
    FileDefinition def = FileDefinition.getDefaultInstance();

    // Act
    ObjectDefinition actualObjectOfResult = MetadataBuilders.objectOf((Message) def);

    // Assert
    assertEquals(5, actualObjectOfResult.getObjectTypeValue());
    assertEquals(DefinitionCase.FILE, actualObjectOfResult.getDefinitionCase());
    assertEquals(ObjectType.FILE, actualObjectOfResult.getObjectType());
    assertTrue(actualObjectOfResult.hasFile());
    assertSame(def, actualObjectOfResult.getFile());
    assertSame(def, actualObjectOfResult.getFileOrBuilder());
  }

  /**
   * Test {@link MetadataBuilders#objectOf(Message)} with {@code Message}.
   *
   * <ul>
   *   <li>Then return ObjectTypeValue is one.
   * </ul>
   *
   * <p>Method under test: {@link MetadataBuilders#objectOf(Message)}
   */
  @Test
  @DisplayName("Test objectOf(Message) with 'Message'; then return ObjectTypeValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition MetadataBuilders.objectOf(Message)"})
  void testObjectOfWithMessage_thenReturnObjectTypeValueIsOne() {
    // Arrange
    DataDefinition def = DataDefinition.getDefaultInstance();

    // Act
    ObjectDefinition actualObjectOfResult = MetadataBuilders.objectOf((Message) def);

    // Assert
    assertEquals(1, actualObjectOfResult.getObjectTypeValue());
    assertEquals(DefinitionCase.DATA, actualObjectOfResult.getDefinitionCase());
    assertEquals(ObjectType.DATA, actualObjectOfResult.getObjectType());
    assertTrue(actualObjectOfResult.hasData());
    assertSame(def, actualObjectOfResult.getData());
    assertSame(def, actualObjectOfResult.getDataOrBuilder());
  }

  /**
   * Test {@link MetadataBuilders#objectOf(Message)} with {@code Message}.
   *
   * <ul>
   *   <li>Then return ObjectTypeValue is seven.
   * </ul>
   *
   * <p>Method under test: {@link MetadataBuilders#objectOf(Message)}
   */
  @Test
  @DisplayName("Test objectOf(Message) with 'Message'; then return ObjectTypeValue is seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition MetadataBuilders.objectOf(Message)"})
  void testObjectOfWithMessage_thenReturnObjectTypeValueIsSeven() {
    // Arrange
    StorageDefinition def = StorageDefinition.getDefaultInstance();

    // Act
    ObjectDefinition actualObjectOfResult = MetadataBuilders.objectOf((Message) def);

    // Assert
    assertEquals(7, actualObjectOfResult.getObjectTypeValue());
    assertEquals(DefinitionCase.STORAGE, actualObjectOfResult.getDefinitionCase());
    assertEquals(ObjectType.STORAGE, actualObjectOfResult.getObjectType());
    assertTrue(actualObjectOfResult.hasStorage());
    assertSame(def, actualObjectOfResult.getStorage());
    assertSame(def, actualObjectOfResult.getStorageOrBuilder());
  }

  /**
   * Test {@link MetadataBuilders#objectOf(Message)} with {@code Message}.
   *
   * <ul>
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataBuilders#objectOf(Message)}
   */
  @Test
  @DisplayName("Test objectOf(Message) with 'Message'; then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition MetadataBuilders.objectOf(Message)"})
  void testObjectOfWithMessage_thenThrowEUnexpected() {
    // Arrange, Act and Assert
    assertThrows(
        EUnexpected.class, () -> MetadataBuilders.objectOf(DataReadResponse.getDefaultInstance()));
  }

  /**
   * Test {@link MetadataBuilders#objectOf(SchemaDefinition)} with {@code SchemaDefinition}.
   *
   * <p>Method under test: {@link MetadataBuilders#objectOf(SchemaDefinition)}
   */
  @Test
  @DisplayName("Test objectOf(SchemaDefinition) with 'SchemaDefinition'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition MetadataBuilders.objectOf(SchemaDefinition)"})
  void testObjectOfWithSchemaDefinition() {
    // Arrange
    SchemaDefinition def = SchemaDefinition.getDefaultInstance();

    // Act
    ObjectDefinition actualObjectOfResult = MetadataBuilders.objectOf(def);

    // Assert
    assertEquals("", actualObjectOfResult.getInitializationErrorString());
    assertEquals(0, actualObjectOfResult.getObjectPropsCount());
    assertEquals(2, actualObjectOfResult.getAllFields().size());
    assertEquals(4, actualObjectOfResult.getSerializedSize());
    assertEquals(8, actualObjectOfResult.getObjectTypeValue());
    assertEquals(DefinitionCase.SCHEMA, actualObjectOfResult.getDefinitionCase());
    assertEquals(ObjectType.SCHEMA, actualObjectOfResult.getObjectType());
    assertFalse(actualObjectOfResult.hasCustom());
    assertFalse(actualObjectOfResult.hasData());
    assertFalse(actualObjectOfResult.hasFile());
    assertFalse(actualObjectOfResult.hasFlow());
    assertFalse(actualObjectOfResult.hasJob());
    assertFalse(actualObjectOfResult.hasModel());
    assertFalse(actualObjectOfResult.hasResult());
    assertFalse(actualObjectOfResult.hasStorage());
    assertTrue(actualObjectOfResult.findInitializationErrors().isEmpty());
    assertTrue(actualObjectOfResult.getObjectProps().isEmpty());
    assertTrue(actualObjectOfResult.getObjectPropsMap().isEmpty());
    assertTrue(actualObjectOfResult.hasSchema());
    assertTrue(actualObjectOfResult.isInitialized());
    assertSame(def, actualObjectOfResult.getSchema());
    assertSame(def, actualObjectOfResult.getSchemaOrBuilder());
  }

  /**
   * Test {@link MetadataBuilders#objectOf(StorageDefinition)} with {@code StorageDefinition}.
   *
   * <p>Method under test: {@link MetadataBuilders#objectOf(StorageDefinition)}
   */
  @Test
  @DisplayName("Test objectOf(StorageDefinition) with 'StorageDefinition'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectDefinition MetadataBuilders.objectOf(StorageDefinition)"})
  void testObjectOfWithStorageDefinition() {
    // Arrange
    StorageDefinition def = StorageDefinition.getDefaultInstance();

    // Act
    ObjectDefinition actualObjectOfResult = MetadataBuilders.objectOf(def);

    // Assert
    assertEquals("", actualObjectOfResult.getInitializationErrorString());
    assertEquals(0, actualObjectOfResult.getObjectPropsCount());
    assertEquals(2, actualObjectOfResult.getAllFields().size());
    assertEquals(4, actualObjectOfResult.getSerializedSize());
    assertEquals(7, actualObjectOfResult.getObjectTypeValue());
    assertEquals(DefinitionCase.STORAGE, actualObjectOfResult.getDefinitionCase());
    assertEquals(ObjectType.STORAGE, actualObjectOfResult.getObjectType());
    assertFalse(actualObjectOfResult.hasCustom());
    assertFalse(actualObjectOfResult.hasData());
    assertFalse(actualObjectOfResult.hasFile());
    assertFalse(actualObjectOfResult.hasFlow());
    assertFalse(actualObjectOfResult.hasJob());
    assertFalse(actualObjectOfResult.hasModel());
    assertFalse(actualObjectOfResult.hasResult());
    assertFalse(actualObjectOfResult.hasSchema());
    assertTrue(actualObjectOfResult.findInitializationErrors().isEmpty());
    assertTrue(actualObjectOfResult.getObjectProps().isEmpty());
    assertTrue(actualObjectOfResult.getObjectPropsMap().isEmpty());
    assertTrue(actualObjectOfResult.hasStorage());
    assertTrue(actualObjectOfResult.isInitialized());
    assertSame(def, actualObjectOfResult.getStorage());
    assertSame(def, actualObjectOfResult.getStorageOrBuilder());
  }

  /**
   * Test {@link MetadataBuilders#buildCreateObjectReq(String, TagSelector, Message, List)}.
   *
   * <ul>
   *   <li>Given DefaultInstance.
   *   <li>When {@link ArrayList#ArrayList()} add DefaultInstance.
   * </ul>
   *
   * <p>Method under test: {@link MetadataBuilders#buildCreateObjectReq(String, TagSelector,
   * Message, List)}
   */
  @Test
  @DisplayName(
      "Test buildCreateObjectReq(String, TagSelector, Message, List); given DefaultInstance; when ArrayList() add DefaultInstance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataWriteRequest MetadataBuilders.buildCreateObjectReq(String, TagSelector, Message, List)"
  })
  void testBuildCreateObjectReq_givenDefaultInstance_whenArrayListAddDefaultInstance() {
    // Arrange
    TagSelector priorVersion = TagSelector.getDefaultInstance();
    DataReadResponse defaultInstance = DataReadResponse.getDefaultInstance();

    ArrayList<TagUpdate> tagUpdates = new ArrayList<>();
    tagUpdates.add(TagUpdate.getDefaultInstance());

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () ->
            MetadataBuilders.buildCreateObjectReq(
                "Tenant", priorVersion, defaultInstance, tagUpdates));
  }

  /**
   * Test {@link MetadataBuilders#buildCreateObjectReq(String, TagSelector, Message, List)}.
   *
   * <ul>
   *   <li>Given DefaultInstance.
   *   <li>When {@link ArrayList#ArrayList()} add DefaultInstance.
   * </ul>
   *
   * <p>Method under test: {@link MetadataBuilders#buildCreateObjectReq(String, TagSelector,
   * Message, List)}
   */
  @Test
  @DisplayName(
      "Test buildCreateObjectReq(String, TagSelector, Message, List); given DefaultInstance; when ArrayList() add DefaultInstance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataWriteRequest MetadataBuilders.buildCreateObjectReq(String, TagSelector, Message, List)"
  })
  void testBuildCreateObjectReq_givenDefaultInstance_whenArrayListAddDefaultInstance2() {
    // Arrange
    TagSelector priorVersion = TagSelector.getDefaultInstance();
    DataReadResponse defaultInstance = DataReadResponse.getDefaultInstance();

    ArrayList<TagUpdate> tagUpdates = new ArrayList<>();
    tagUpdates.add(TagUpdate.getDefaultInstance());
    tagUpdates.add(TagUpdate.getDefaultInstance());

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () ->
            MetadataBuilders.buildCreateObjectReq(
                "Tenant", priorVersion, defaultInstance, tagUpdates));
  }

  /**
   * Test {@link MetadataBuilders#buildCreateObjectReq(String, TagSelector, Message, List)}.
   *
   * <ul>
   *   <li>When {@code Tenant}.
   *   <li>Then return ObjectTypeValue is eight.
   * </ul>
   *
   * <p>Method under test: {@link MetadataBuilders#buildCreateObjectReq(String, TagSelector,
   * Message, List)}
   */
  @Test
  @DisplayName(
      "Test buildCreateObjectReq(String, TagSelector, Message, List); when 'Tenant'; then return ObjectTypeValue is eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataWriteRequest MetadataBuilders.buildCreateObjectReq(String, TagSelector, Message, List)"
  })
  void testBuildCreateObjectReq_whenTenant_thenReturnObjectTypeValueIsEight() {
    // Arrange
    TagSelector priorVersion = TagSelector.getDefaultInstance();
    SchemaDefinition defaultInstance = SchemaDefinition.getDefaultInstance();

    // Act
    MetadataWriteRequest actualBuildCreateObjectReqResult =
        MetadataBuilders.buildCreateObjectReq(
            "Tenant", priorVersion, defaultInstance, new ArrayList<>());

    // Assert
    assertEquals(8, actualBuildCreateObjectReqResult.getObjectTypeValue());
    assertEquals(ObjectType.SCHEMA, actualBuildCreateObjectReqResult.getObjectType());
  }

  /**
   * Test {@link MetadataBuilders#buildCreateObjectReq(String, TagSelector, Message, List)}.
   *
   * <ul>
   *   <li>When {@code Tenant}.
   *   <li>Then return ObjectTypeValue is five.
   * </ul>
   *
   * <p>Method under test: {@link MetadataBuilders#buildCreateObjectReq(String, TagSelector,
   * Message, List)}
   */
  @Test
  @DisplayName(
      "Test buildCreateObjectReq(String, TagSelector, Message, List); when 'Tenant'; then return ObjectTypeValue is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataWriteRequest MetadataBuilders.buildCreateObjectReq(String, TagSelector, Message, List)"
  })
  void testBuildCreateObjectReq_whenTenant_thenReturnObjectTypeValueIsFive() {
    // Arrange
    TagSelector priorVersion = TagSelector.getDefaultInstance();
    FileDefinition defaultInstance = FileDefinition.getDefaultInstance();

    // Act
    MetadataWriteRequest actualBuildCreateObjectReqResult =
        MetadataBuilders.buildCreateObjectReq(
            "Tenant", priorVersion, defaultInstance, new ArrayList<>());

    // Assert
    assertEquals(5, actualBuildCreateObjectReqResult.getObjectTypeValue());
    assertEquals(ObjectType.FILE, actualBuildCreateObjectReqResult.getObjectType());
  }

  /**
   * Test {@link MetadataBuilders#buildCreateObjectReq(String, TagSelector, Message, List)}.
   *
   * <ul>
   *   <li>When {@code Tenant}.
   *   <li>Then return ObjectTypeValue is one.
   * </ul>
   *
   * <p>Method under test: {@link MetadataBuilders#buildCreateObjectReq(String, TagSelector,
   * Message, List)}
   */
  @Test
  @DisplayName(
      "Test buildCreateObjectReq(String, TagSelector, Message, List); when 'Tenant'; then return ObjectTypeValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataWriteRequest MetadataBuilders.buildCreateObjectReq(String, TagSelector, Message, List)"
  })
  void testBuildCreateObjectReq_whenTenant_thenReturnObjectTypeValueIsOne() {
    // Arrange
    TagSelector priorVersion = TagSelector.getDefaultInstance();
    DataDefinition defaultInstance = DataDefinition.getDefaultInstance();

    // Act
    MetadataWriteRequest actualBuildCreateObjectReqResult =
        MetadataBuilders.buildCreateObjectReq(
            "Tenant", priorVersion, defaultInstance, new ArrayList<>());

    // Assert
    assertEquals(1, actualBuildCreateObjectReqResult.getObjectTypeValue());
    assertEquals(ObjectType.DATA, actualBuildCreateObjectReqResult.getObjectType());
  }

  /**
   * Test {@link MetadataBuilders#buildCreateObjectReq(String, TagSelector, Message, List)}.
   *
   * <ul>
   *   <li>When {@code Tenant}.
   *   <li>Then return ObjectTypeValue is seven.
   * </ul>
   *
   * <p>Method under test: {@link MetadataBuilders#buildCreateObjectReq(String, TagSelector,
   * Message, List)}
   */
  @Test
  @DisplayName(
      "Test buildCreateObjectReq(String, TagSelector, Message, List); when 'Tenant'; then return ObjectTypeValue is seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataWriteRequest MetadataBuilders.buildCreateObjectReq(String, TagSelector, Message, List)"
  })
  void testBuildCreateObjectReq_whenTenant_thenReturnObjectTypeValueIsSeven() {
    // Arrange
    TagSelector priorVersion = TagSelector.getDefaultInstance();
    StorageDefinition defaultInstance = StorageDefinition.getDefaultInstance();

    // Act
    MetadataWriteRequest actualBuildCreateObjectReqResult =
        MetadataBuilders.buildCreateObjectReq(
            "Tenant", priorVersion, defaultInstance, new ArrayList<>());

    // Assert
    assertEquals(7, actualBuildCreateObjectReqResult.getObjectTypeValue());
    assertEquals(ObjectType.STORAGE, actualBuildCreateObjectReqResult.getObjectType());
  }

  /**
   * Test {@link MetadataBuilders#buildCreateObjectReq(String, TagSelector, Message, List)}.
   *
   * <ul>
   *   <li>When {@code Tenant}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataBuilders#buildCreateObjectReq(String, TagSelector,
   * Message, List)}
   */
  @Test
  @DisplayName(
      "Test buildCreateObjectReq(String, TagSelector, Message, List); when 'Tenant'; then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataWriteRequest MetadataBuilders.buildCreateObjectReq(String, TagSelector, Message, List)"
  })
  void testBuildCreateObjectReq_whenTenant_thenThrowEUnexpected() {
    // Arrange
    TagSelector priorVersion = TagSelector.getDefaultInstance();
    DataReadResponse defaultInstance = DataReadResponse.getDefaultInstance();

    // Act and Assert
    assertThrows(
        EUnexpected.class,
        () ->
            MetadataBuilders.buildCreateObjectReq(
                "Tenant", priorVersion, defaultInstance, new ArrayList<>()));
  }
}
