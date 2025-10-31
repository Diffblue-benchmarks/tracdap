package org.finos.tracdap.svc.meta.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.tracdap.metadata.Tag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TagUpdateServiceDiffblueTest {
  /**
   * Test {@link TagUpdateService#applyTagUpdates(Tag, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagUpdateService#applyTagUpdates(Tag, List)}
   */
  @Test
  @DisplayName("Test applyTagUpdates(Tag, List); when ArrayList(); then return DefaultInstance")
  @org.junit.jupiter.api.Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Tag TagUpdateService.applyTagUpdates(Tag, List)"})
  void testApplyTagUpdates_whenArrayList_thenReturnDefaultInstance() {
    // Arrange
    Tag priorTag = Tag.getDefaultInstance();

    // Act and Assert
    assertEquals(priorTag, TagUpdateService.applyTagUpdates(priorTag, new ArrayList<>()));
  }
}
