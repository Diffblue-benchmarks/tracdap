package org.finos.tracdap.common.exec.local;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Properties;
import org.finos.tracdap.common.exception.EStartup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LocalBatchExecutorDiffblueTest {
  /**
   * Test {@link LocalBatchExecutor#LocalBatchExecutor(Properties)}.
   *
   * <p>Method under test: {@link LocalBatchExecutor#LocalBatchExecutor(Properties)}
   */
  @Test
  @DisplayName("Test new LocalBatchExecutor(Properties)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalBatchExecutor.<init>(Properties)"})
  void testNewLocalBatchExecutor() {
    // Arrange, Act and Assert
    assertThrows(EStartup.class, () -> new LocalBatchExecutor(new Properties()));
  }
}
