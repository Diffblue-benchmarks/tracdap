package org.finos.tracdap.svc.data.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class RequestStateDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link RequestState}
   */
  @Test
  void testNewRequestState() {
    // Arrange and Act
    RequestState actualRequestState = new RequestState();

    // Assert
    assertNull(actualRequestState.dataTags);
    assertNull(actualRequestState.fileTags);
    assertNull(actualRequestState.storageTags);
    assertNull(actualRequestState.requestMetadata);
    assertNull(actualRequestState.clientConfig);
    assertNull(actualRequestState.data);
    assertNull(actualRequestState.file);
    assertNull(actualRequestState.part);
    assertNull(actualRequestState.schema);
    assertNull(actualRequestState.copy);
    assertNull(actualRequestState.storage);
    assertNull(actualRequestState.dataId);
    assertNull(actualRequestState.fileId);
    assertNull(actualRequestState.preAllocDataId);
    assertNull(actualRequestState.preAllocFileId);
    assertNull(actualRequestState.preAllocStorageId);
    assertNull(actualRequestState.storageId);
    assertEquals(0, actualRequestState.delta);
    assertEquals(0, actualRequestState.snap);
    assertEquals(0L, actualRequestState.limit);
    assertEquals(0L, actualRequestState.offset);
  }
}
