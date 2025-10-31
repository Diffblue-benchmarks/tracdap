package org.finos.tracdap.svc.meta.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.finos.tracdap.metadata.Tag;
import org.junit.jupiter.api.Test;

class TagUpdateServiceDiffblueTest {
  /**
   * Method under test: {@link TagUpdateService#applyTagUpdates(Tag, List)}
   */
  @Test
  void testApplyTagUpdates() {
    // Arrange
    Tag priorTag = Tag.getDefaultInstance();

    // Act and Assert
    assertEquals(priorTag, TagUpdateService.applyTagUpdates(priorTag, new ArrayList<>()));
  }
}
