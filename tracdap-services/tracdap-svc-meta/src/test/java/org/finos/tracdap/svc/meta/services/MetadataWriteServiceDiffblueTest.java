package org.finos.tracdap.svc.meta.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.UnknownFieldSet;
import java.util.List;
import org.finos.tracdap.api.MetadataWriteBatchRequest;
import org.finos.tracdap.api.MetadataWriteBatchResponse;
import org.finos.tracdap.api.MetadataWriteRequest;
import org.finos.tracdap.metadata.DatetimeValue;
import org.finos.tracdap.metadata.ObjectType;
import org.finos.tracdap.metadata.TagHeader;
import org.finos.tracdap.svc.meta.dal.IMetadataDal;
import org.finos.tracdap.svc.meta.dal.MetadataBatchUpdate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MetadataWriteServiceDiffblueTest {
  /**
   * Test {@link MetadataWriteService#preallocateId(String, MetadataWriteRequest)}.
   *
   * <ul>
   *   <li>Given {@code OBJECT_TYPE_NOT_SET}.
   *   <li>Then calls {@link MetadataWriteRequest#getObjectType()}.
   * </ul>
   *
   * <p>Method under test: {@link MetadataWriteService#preallocateId(String, MetadataWriteRequest)}
   */
  @Test
  @DisplayName(
      "Test preallocateId(String, MetadataWriteRequest); given 'OBJECT_TYPE_NOT_SET'; then calls getObjectType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TagHeader MetadataWriteService.preallocateId(String, MetadataWriteRequest)"})
  void testPreallocateId_givenObjectTypeNotSet_thenCallsGetObjectType() {
    // Arrange
    IMetadataDal dal = mock(IMetadataDal.class);
    doNothing()
        .when(dal)
        .savePreallocatedIds(Mockito.<String>any(), Mockito.<List<TagHeader>>any());
    MetadataWriteService metadataWriteService = new MetadataWriteService(dal);

    MetadataWriteRequest request = mock(MetadataWriteRequest.class);
    when(request.getObjectType()).thenReturn(ObjectType.OBJECT_TYPE_NOT_SET);

    // Act
    TagHeader actualPreallocateIdResult = metadataWriteService.preallocateId("Tenant", request);

    // Assert
    verify(request).getObjectType();
    verify(dal).savePreallocatedIds(eq("Tenant"), isA(List.class));
    UnknownFieldSet unknownFields = actualPreallocateIdResult.getUnknownFields();
    TagHeader defaultInstanceForType = actualPreallocateIdResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    DatetimeValue objectTimestamp = actualPreallocateIdResult.getObjectTimestamp();
    assertSame(unknownFields, objectTimestamp.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    DatetimeValue actualDefaultInstanceForType2 = objectTimestamp.getDefaultInstanceForType();
    assertSame(objectTimestamp, actualDefaultInstanceForType2);
    assertSame(objectTimestamp, defaultInstanceForType.getObjectTimestamp());
    assertSame(objectTimestamp, defaultInstanceForType.getObjectTimestampOrBuilder());
    assertSame(objectTimestamp, actualPreallocateIdResult.getObjectTimestampOrBuilder());
    assertSame(objectTimestamp, defaultInstanceForType.getTagTimestamp());
    assertSame(objectTimestamp, actualPreallocateIdResult.getTagTimestamp());
    assertSame(objectTimestamp, defaultInstanceForType.getTagTimestampOrBuilder());
    assertSame(objectTimestamp, actualPreallocateIdResult.getTagTimestampOrBuilder());
  }

  /**
   * Test {@link MetadataWriteService#preallocateId(String, MetadataWriteRequest)}.
   *
   * <ul>
   *   <li>Then return DefaultInstanceForType UnknownFields is UnknownFields.
   * </ul>
   *
   * <p>Method under test: {@link MetadataWriteService#preallocateId(String, MetadataWriteRequest)}
   */
  @Test
  @DisplayName(
      "Test preallocateId(String, MetadataWriteRequest); then return DefaultInstanceForType UnknownFields is UnknownFields")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TagHeader MetadataWriteService.preallocateId(String, MetadataWriteRequest)"})
  void testPreallocateId_thenReturnDefaultInstanceForTypeUnknownFieldsIsUnknownFields() {
    // Arrange
    IMetadataDal dal = mock(IMetadataDal.class);
    doNothing()
        .when(dal)
        .savePreallocatedIds(Mockito.<String>any(), Mockito.<List<TagHeader>>any());

    // Act
    TagHeader actualPreallocateIdResult =
        new MetadataWriteService(dal)
            .preallocateId("Tenant", MetadataWriteRequest.getDefaultInstance());

    // Assert
    verify(dal).savePreallocatedIds(eq("Tenant"), isA(List.class));
    UnknownFieldSet unknownFields = actualPreallocateIdResult.getUnknownFields();
    TagHeader defaultInstanceForType = actualPreallocateIdResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    DatetimeValue objectTimestamp = actualPreallocateIdResult.getObjectTimestamp();
    assertSame(unknownFields, objectTimestamp.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
    DatetimeValue actualDefaultInstanceForType2 = objectTimestamp.getDefaultInstanceForType();
    assertSame(objectTimestamp, actualDefaultInstanceForType2);
    assertSame(objectTimestamp, defaultInstanceForType.getObjectTimestamp());
    assertSame(objectTimestamp, defaultInstanceForType.getObjectTimestampOrBuilder());
    assertSame(objectTimestamp, actualPreallocateIdResult.getObjectTimestampOrBuilder());
    assertSame(objectTimestamp, defaultInstanceForType.getTagTimestamp());
    assertSame(objectTimestamp, actualPreallocateIdResult.getTagTimestamp());
    assertSame(objectTimestamp, defaultInstanceForType.getTagTimestampOrBuilder());
    assertSame(objectTimestamp, actualPreallocateIdResult.getTagTimestampOrBuilder());
  }

  /**
   * Test {@link MetadataWriteService#createObject(String, MetadataWriteRequest)}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link MetadataWriteService#createObject(String, MetadataWriteRequest)}
   */
  @Test
  @DisplayName(
      "Test createObject(String, MetadataWriteRequest); then return InitializationErrorString is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TagHeader MetadataWriteService.createObject(String, MetadataWriteRequest)"})
  void testCreateObject_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange
    IMetadataDal dal = mock(IMetadataDal.class);
    doNothing()
        .when(dal)
        .saveNewObjects(Mockito.<String>any(), Mockito.<List<org.finos.tracdap.metadata.Tag>>any());

    // Act
    TagHeader actualCreateObjectResult =
        new MetadataWriteService(dal)
            .createObject("Tenant", MetadataWriteRequest.getDefaultInstance());

    // Assert
    verify(dal).saveNewObjects(eq("Tenant"), isA(List.class));
    assertEquals("", actualCreateObjectResult.getInitializationErrorString());
    assertEquals(0, actualCreateObjectResult.getObjectTypeValue());
    assertEquals(1, actualCreateObjectResult.getObjectVersion());
    assertEquals(1, actualCreateObjectResult.getTagVersion());
    assertEquals(102, actualCreateObjectResult.getSerializedSize());
    assertEquals(7, actualCreateObjectResult.getAllFields().size());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualCreateObjectResult.getObjectType());
    assertTrue(actualCreateObjectResult.findInitializationErrors().isEmpty());
    assertTrue(actualCreateObjectResult.getIsLatestObject());
    assertTrue(actualCreateObjectResult.getIsLatestTag());
    assertTrue(actualCreateObjectResult.hasObjectTimestamp());
    assertTrue(actualCreateObjectResult.hasTagTimestamp());
    assertTrue(actualCreateObjectResult.isInitialized());
    DatetimeValue expectedTagTimestampOrBuilder = actualCreateObjectResult.getTagTimestamp();
    assertSame(expectedTagTimestampOrBuilder, actualCreateObjectResult.getTagTimestampOrBuilder());
  }

  /**
   * Test {@link MetadataWriteService#writeBatch(MetadataWriteBatchRequest)}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link MetadataWriteService#writeBatch(MetadataWriteBatchRequest)}
   */
  @Test
  @DisplayName(
      "Test writeBatch(MetadataWriteBatchRequest); then return InitializationErrorString is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataWriteBatchResponse MetadataWriteService.writeBatch(MetadataWriteBatchRequest)"
  })
  void testWriteBatch_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange
    IMetadataDal dal = mock(IMetadataDal.class);
    doNothing()
        .when(dal)
        .saveBatchUpdate(Mockito.<String>any(), Mockito.<MetadataBatchUpdate>any());

    // Act
    MetadataWriteBatchResponse actualWriteBatchResult =
        new MetadataWriteService(dal).writeBatch(MetadataWriteBatchRequest.getDefaultInstance());

    // Assert
    verify(dal).saveBatchUpdate(eq(""), isA(MetadataBatchUpdate.class));
    assertEquals("", actualWriteBatchResult.getInitializationErrorString());
    assertEquals(0, actualWriteBatchResult.getCreateObjectsCount());
    assertEquals(0, actualWriteBatchResult.getCreatePreallocatedObjectsCount());
    assertEquals(0, actualWriteBatchResult.getPreallocateIdsCount());
    assertEquals(0, actualWriteBatchResult.getSerializedSize());
    assertEquals(0, actualWriteBatchResult.getUpdateObjectsCount());
    assertEquals(0, actualWriteBatchResult.getUpdateTagsCount());
    assertTrue(actualWriteBatchResult.findInitializationErrors().isEmpty());
    List<TagHeader> createObjectsList = actualWriteBatchResult.getCreateObjectsList();
    assertTrue(createObjectsList.isEmpty());
    List<TagHeader> createPreallocatedObjectsList =
        actualWriteBatchResult.getCreatePreallocatedObjectsList();
    assertTrue(createPreallocatedObjectsList.isEmpty());
    List<TagHeader> preallocateIdsList = actualWriteBatchResult.getPreallocateIdsList();
    assertTrue(preallocateIdsList.isEmpty());
    List<TagHeader> updateObjectsList = actualWriteBatchResult.getUpdateObjectsList();
    assertTrue(updateObjectsList.isEmpty());
    List<TagHeader> updateTagsList = actualWriteBatchResult.getUpdateTagsList();
    assertTrue(updateTagsList.isEmpty());
    assertTrue(actualWriteBatchResult.getAllFields().isEmpty());
    assertTrue(actualWriteBatchResult.isInitialized());
    MetadataWriteBatchResponse actualDefaultInstanceForType =
        actualWriteBatchResult.getDefaultInstanceForType();
    assertEquals(actualWriteBatchResult, actualDefaultInstanceForType);
    assertSame(createObjectsList, actualWriteBatchResult.getCreateObjectsOrBuilderList());
    assertSame(
        createPreallocatedObjectsList,
        actualWriteBatchResult.getCreatePreallocatedObjectsOrBuilderList());
    assertSame(preallocateIdsList, actualWriteBatchResult.getPreallocateIdsOrBuilderList());
    assertSame(updateObjectsList, actualWriteBatchResult.getUpdateObjectsOrBuilderList());
    assertSame(updateTagsList, actualWriteBatchResult.getUpdateTagsOrBuilderList());
  }
}
