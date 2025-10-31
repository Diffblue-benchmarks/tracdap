package org.finos.tracdap.svc.meta.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.tracdap.api.MetadataWriteRequest;
import org.finos.tracdap.metadata.ObjectType;
import org.finos.tracdap.metadata.Tag;
import org.finos.tracdap.metadata.TagHeader;
import org.finos.tracdap.metadata.TagSelector;
import org.finos.tracdap.svc.meta.dal.IMetadataDal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MetadataWriteServiceDiffblueTest {
  /**
   * Test {@link MetadataWriteService#updateTag(String, MetadataWriteRequest)}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetadataWriteService#updateTag(String, MetadataWriteRequest)}
   */
  @Test
  @DisplayName("Test updateTag(String, MetadataWriteRequest); then return InitializationErrorString is empty string")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TagHeader MetadataWriteService.updateTag(String, MetadataWriteRequest)"})
  void testUpdateTag_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange
    ArrayList<Tag> tagList = new ArrayList<>();
    tagList.add(Tag.getDefaultInstance());
    IMetadataDal dal = mock(IMetadataDal.class);
    doNothing().when(dal).saveNewTags(Mockito.<String>any(), Mockito.<List<Tag>>any());
    when(dal.loadPriorTags(Mockito.<String>any(), Mockito.<List<TagSelector>>any())).thenReturn(tagList);
    MetadataWriteService metadataWriteService = new MetadataWriteService(dal);

    // Act
    TagHeader actualUpdateTagResult = metadataWriteService.updateTag("Tenant",
        MetadataWriteRequest.getDefaultInstance());

    // Assert
    verify(dal).loadPriorTags(eq("Tenant"), isA(List.class));
    verify(dal).saveNewTags(eq("Tenant"), isA(List.class));
    assertEquals("", actualUpdateTagResult.getInitializationErrorString());
    assertEquals("", actualUpdateTagResult.getObjectId());
    assertEquals(0, actualUpdateTagResult.getObjectTypeValue());
    assertEquals(0, actualUpdateTagResult.getObjectVersion());
    assertEquals(1, actualUpdateTagResult.getTagVersion());
    assertEquals(3, actualUpdateTagResult.getAllFields().size());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, actualUpdateTagResult.getObjectType());
    assertFalse(actualUpdateTagResult.getIsLatestObject());
    assertFalse(actualUpdateTagResult.hasObjectTimestamp());
    assertTrue(actualUpdateTagResult.findInitializationErrors().isEmpty());
    assertTrue(actualUpdateTagResult.getIsLatestTag());
    assertTrue(actualUpdateTagResult.hasTagTimestamp());
    assertTrue(actualUpdateTagResult.isInitialized());
    assertEquals(Integer.SIZE, actualUpdateTagResult.getSerializedSize());
  }
}
