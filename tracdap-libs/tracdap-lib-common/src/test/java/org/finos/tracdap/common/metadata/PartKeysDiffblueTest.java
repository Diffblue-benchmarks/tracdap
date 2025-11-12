package org.finos.tracdap.common.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.metadata.PartKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PartKeysDiffblueTest {
  /**
   * Test {@link PartKeys#opaqueKey(PartKey)}.
   *
   * <ul>
   *   <li>When {@link PartKeys#ROOT}.
   *   <li>Then return {@code part-root}.
   * </ul>
   *
   * <p>Method under test: {@link PartKeys#opaqueKey(PartKey)}
   */
  @Test
  @DisplayName("Test opaqueKey(PartKey); when ROOT; then return 'part-root'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PartKeys.opaqueKey(PartKey)"})
  void testOpaqueKey_whenRoot_thenReturnPartRoot() {
    // Arrange, Act and Assert
    assertEquals("part-root", PartKeys.opaqueKey(PartKeys.ROOT));
  }
}
