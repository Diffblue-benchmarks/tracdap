package org.finos.tracdap.svc.data.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.Advice;
import com.google.protobuf.ByteString;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.List;
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
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataBuilders#preallocateRequest(String, ObjectType)}
   */
  @Test
  @DisplayName("Test preallocateRequest(String, ObjectType); then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteRequest MetadataBuilders.preallocateRequest(String, ObjectType)"})
  void testPreallocateRequest_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange and Act
    MetadataWriteRequest actualPreallocateRequestResult = MetadataBuilders.preallocateRequest("Tenant",
        ObjectType.OBJECT_TYPE_NOT_SET);

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
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataBuilders#requestForSelector(String, TagSelector)}
   */
  @Test
  @DisplayName("Test requestForSelector(String, TagSelector); then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataReadRequest MetadataBuilders.requestForSelector(String, TagSelector)"})
  void testRequestForSelector_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange
    TagSelector selector = TagSelector.getDefaultInstance();

    // Act
    MetadataReadRequest actualRequestForSelectorResult = MetadataBuilders.requestForSelector("Tenant", selector);

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
   * <ul>
   *   <li>Then return TenantBytes toStringUtf8 is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataBuilders#requestForBatch(String, TagSelector[])}
   */
  @Test
  @DisplayName("Test requestForBatch(String, TagSelector[]); then return TenantBytes toStringUtf8 is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataBatchRequest MetadataBuilders.requestForBatch(String, TagSelector[])"})
  void testRequestForBatch_thenReturnTenantBytesToStringUtf8IsEmptyString() {
    // Arrange and Act
    MetadataBatchRequest actualRequestForBatchResult = MetadataBuilders.requestForBatch("",
        TagSelector.getDefaultInstance());

    // Assert
    ByteString tenantBytes = actualRequestForBatchResult.getTenantBytes();
    assertEquals("", tenantBytes.toStringUtf8());
    assertEquals("", actualRequestForBatchResult.getTenant());
    assertEquals(2, actualRequestForBatchResult.getSerializedSize());
    assertFalse(tenantBytes.iterator().hasNext());
    assertTrue(tenantBytes.isEmpty());
    MetadataBatchRequest defaultInstanceForType = actualRequestForBatchResult.getDefaultInstanceForType();
    assertEquals(tenantBytes, defaultInstanceForType.getTenantBytes());
    UnknownFieldSet unknownFields = actualRequestForBatchResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link MetadataBuilders#requestForBatch(String, TagSelector[])}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return SelectorList size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataBuilders#requestForBatch(String, TagSelector[])}
   */
  @Test
  @DisplayName("Test requestForBatch(String, TagSelector[]); when DefaultInstance; then return SelectorList size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataBatchRequest MetadataBuilders.requestForBatch(String, TagSelector[])"})
  void testRequestForBatch_whenDefaultInstance_thenReturnSelectorListSizeIsOne() {
    // Arrange and Act
    MetadataBatchRequest actualRequestForBatchResult = MetadataBuilders.requestForBatch("Tenant",
        TagSelector.getDefaultInstance());

    // Assert
    assertEquals(1, actualRequestForBatchResult.getSelectorList().size());
    assertEquals(10, actualRequestForBatchResult.getSerializedSize());
    assertEquals(2, actualRequestForBatchResult.getAllFields().size());
  }

  /**
   * Test {@link MetadataBuilders#requestForBatch(String, TagSelector[])}.
   * <ul>
   *   <li>When {@code Tenant}.</li>
   *   <li>Then return SelectorCount is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataBuilders#requestForBatch(String, TagSelector[])}
   */
  @Test
  @DisplayName("Test requestForBatch(String, TagSelector[]); when 'Tenant'; then return SelectorCount is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataBatchRequest MetadataBuilders.requestForBatch(String, TagSelector[])"})
  void testRequestForBatch_whenTenant_thenReturnSelectorCountIsZero() {
    // Arrange and Act
    MetadataBatchRequest actualRequestForBatchResult = MetadataBuilders.requestForBatch("Tenant");

    // Assert
    assertEquals(0, actualRequestForBatchResult.getSelectorCount());
    assertEquals(8, actualRequestForBatchResult.getSerializedSize());
    List<TagSelector> selectorList = actualRequestForBatchResult.getSelectorList();
    assertTrue(selectorList.isEmpty());
    MetadataBatchRequest defaultInstanceForType = actualRequestForBatchResult.getDefaultInstanceForType();
    assertSame(selectorList, defaultInstanceForType.getSelectorList());
    assertSame(selectorList, defaultInstanceForType.getSelectorOrBuilderList());
  }

  /**
   * Test {@link MetadataBuilders#bumpVersion(TagHeader)}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataBuilders#bumpVersion(TagHeader)}
   */
  @Test
  @DisplayName("Test bumpVersion(TagHeader); then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataBuilders#objectOf(DataDefinition)}
   */
  @Test
  @DisplayName("Test objectOf(DataDefinition) with 'DataDefinition'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataBuilders#objectOf(FileDefinition)}
   */
  @Test
  @DisplayName("Test objectOf(FileDefinition) with 'FileDefinition'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link MetadataBuilders#objectOf(Message)}
   */
  @Test
  @DisplayName("Test objectOf(Message) with 'Message'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectDefinition MetadataBuilders.objectOf(Message)"})
  void testObjectOfWithMessage() {
    // Arrange, Act and Assert
    assertThrows(EUnexpected.class, () -> MetadataBuilders.objectOf(Advice.getDefaultInstance()));
  }

  /**
   * Test {@link MetadataBuilders#objectOf(SchemaDefinition)} with {@code SchemaDefinition}.
   * <p>
   * Method under test: {@link MetadataBuilders#objectOf(SchemaDefinition)}
   */
  @Test
  @DisplayName("Test objectOf(SchemaDefinition) with 'SchemaDefinition'")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link MetadataBuilders#objectOf(StorageDefinition)}
   */
  @Test
  @DisplayName("Test objectOf(StorageDefinition) with 'StorageDefinition'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given DefaultInstance.</li>
   *   <li>When {@link ArrayList#ArrayList()} add DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataBuilders#buildCreateObjectReq(String, TagSelector, Message, List)}
   */
  @Test
  @DisplayName("Test buildCreateObjectReq(String, TagSelector, Message, List); given DefaultInstance; when ArrayList() add DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteRequest MetadataBuilders.buildCreateObjectReq(String, TagSelector, Message, List)"})
  void testBuildCreateObjectReq_givenDefaultInstance_whenArrayListAddDefaultInstance() {
    // Arrange
    TagSelector priorVersion = TagSelector.getDefaultInstance();
    Advice defaultInstance = Advice.getDefaultInstance();

    ArrayList<TagUpdate> tagUpdates = new ArrayList<>();
    tagUpdates.add(TagUpdate.getDefaultInstance());

    // Act and Assert
    assertThrows(EUnexpected.class,
        () -> MetadataBuilders.buildCreateObjectReq("Tenant", priorVersion, defaultInstance, tagUpdates));
  }

  /**
   * Test {@link MetadataBuilders#buildCreateObjectReq(String, TagSelector, Message, List)}.
   * <ul>
   *   <li>Given DefaultInstance.</li>
   *   <li>When {@link ArrayList#ArrayList()} add DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataBuilders#buildCreateObjectReq(String, TagSelector, Message, List)}
   */
  @Test
  @DisplayName("Test buildCreateObjectReq(String, TagSelector, Message, List); given DefaultInstance; when ArrayList() add DefaultInstance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteRequest MetadataBuilders.buildCreateObjectReq(String, TagSelector, Message, List)"})
  void testBuildCreateObjectReq_givenDefaultInstance_whenArrayListAddDefaultInstance2() {
    // Arrange
    TagSelector priorVersion = TagSelector.getDefaultInstance();
    Advice defaultInstance = Advice.getDefaultInstance();

    ArrayList<TagUpdate> tagUpdates = new ArrayList<>();
    tagUpdates.add(TagUpdate.getDefaultInstance());
    tagUpdates.add(TagUpdate.getDefaultInstance());

    // Act and Assert
    assertThrows(EUnexpected.class,
        () -> MetadataBuilders.buildCreateObjectReq("Tenant", priorVersion, defaultInstance, tagUpdates));
  }

  /**
   * Test {@link MetadataBuilders#buildCreateObjectReq(String, TagSelector, Message, List)}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataBuilders#buildCreateObjectReq(String, TagSelector, Message, List)}
   */
  @Test
  @DisplayName("Test buildCreateObjectReq(String, TagSelector, Message, List); then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteRequest MetadataBuilders.buildCreateObjectReq(String, TagSelector, Message, List)"})
  void testBuildCreateObjectReq_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange
    TagSelector priorVersion = TagSelector.getDefaultInstance();
    DataDefinition defaultInstance = DataDefinition.getDefaultInstance();

    // Act
    MetadataWriteRequest actualBuildCreateObjectReqResult = MetadataBuilders.buildCreateObjectReq("Tenant",
        priorVersion, defaultInstance, new ArrayList<>());

    // Assert
    assertEquals("", actualBuildCreateObjectReqResult.getInitializationErrorString());
    assertEquals("Tenant", actualBuildCreateObjectReqResult.getTenant());
    assertEquals(0, actualBuildCreateObjectReqResult.getTagUpdatesCount());
    assertEquals(1, actualBuildCreateObjectReqResult.getObjectTypeValue());
    assertEquals(18, actualBuildCreateObjectReqResult.getSerializedSize());
    assertEquals(4, actualBuildCreateObjectReqResult.getAllFields().size());
    assertEquals(ObjectType.DATA, actualBuildCreateObjectReqResult.getObjectType());
    assertTrue(actualBuildCreateObjectReqResult.findInitializationErrors().isEmpty());
    List<TagUpdate> tagUpdatesList = actualBuildCreateObjectReqResult.getTagUpdatesList();
    assertTrue(tagUpdatesList.isEmpty());
    assertTrue(actualBuildCreateObjectReqResult.hasDefinition());
    assertTrue(actualBuildCreateObjectReqResult.hasPriorVersion());
    assertTrue(actualBuildCreateObjectReqResult.isInitialized());
    assertSame(tagUpdatesList, actualBuildCreateObjectReqResult.getTagUpdatesOrBuilderList());
    assertSame(priorVersion, actualBuildCreateObjectReqResult.getPriorVersion());
    assertSame(priorVersion, actualBuildCreateObjectReqResult.getPriorVersionOrBuilder());
  }

  /**
   * Test {@link MetadataBuilders#buildCreateObjectReq(String, TagSelector, Message, List)}.
   * <ul>
   *   <li>When {@code Tenant}.</li>
   *   <li>Then throw {@link EUnexpected}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataBuilders#buildCreateObjectReq(String, TagSelector, Message, List)}
   */
  @Test
  @DisplayName("Test buildCreateObjectReq(String, TagSelector, Message, List); when 'Tenant'; then throw EUnexpected")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetadataWriteRequest MetadataBuilders.buildCreateObjectReq(String, TagSelector, Message, List)"})
  void testBuildCreateObjectReq_whenTenant_thenThrowEUnexpected() {
    // Arrange
    TagSelector priorVersion = TagSelector.getDefaultInstance();
    Advice defaultInstance = Advice.getDefaultInstance();

    // Act and Assert
    assertThrows(EUnexpected.class,
        () -> MetadataBuilders.buildCreateObjectReq("Tenant", priorVersion, defaultInstance, new ArrayList<>()));
  }
}
