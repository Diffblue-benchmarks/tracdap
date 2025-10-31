package org.finos.tracdap.common.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.finos.tracdap.metadata.PartKey;
import org.junit.jupiter.api.Test;

class PartKeysDiffblueTest {
  /**
   * Method under test: {@link PartKeys#opaqueKey(PartKey)}
   */
  @Test
  void testOpaqueKey() {
    // Arrange, Act and Assert
    assertEquals("part-root", PartKeys.opaqueKey(PartKeys.ROOT));
  }
}
