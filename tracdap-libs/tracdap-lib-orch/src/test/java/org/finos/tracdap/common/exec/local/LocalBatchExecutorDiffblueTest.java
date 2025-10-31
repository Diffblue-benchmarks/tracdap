package org.finos.tracdap.common.exec.local;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Properties;
import org.finos.tracdap.common.exception.EStartup;
import org.junit.jupiter.api.Test;

class LocalBatchExecutorDiffblueTest {
  /**
   * Method under test: {@link LocalBatchExecutor#LocalBatchExecutor(Properties)}
   */
  @Test
  void testNewLocalBatchExecutor() {
    // Arrange, Act and Assert
    assertThrows(EStartup.class, () -> new LocalBatchExecutor(new Properties()));
  }
}
