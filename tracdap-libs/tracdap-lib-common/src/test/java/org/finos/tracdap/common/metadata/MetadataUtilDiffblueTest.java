package org.finos.tracdap.common.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.metadata.TagHeader;
import org.finos.tracdap.metadata.TagSelector;
import org.junit.jupiter.api.Test;

class MetadataUtilDiffblueTest {
  /**
   * Method under test: {@link MetadataUtil#objectKey(TagHeader)}
   */
  @Test
  void testObjectKey() {
    // Arrange, Act and Assert
    assertEquals("OBJECT_TYPE_NOT_SET--v0", MetadataUtil.objectKey(TagHeader.getDefaultInstance()));
    assertThrows(EUnexpected.class, () -> MetadataUtil.objectKey(TagSelector.getDefaultInstance()));
  }
}
