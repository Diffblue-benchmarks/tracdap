package org.finos.tracdap.common.exec;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BatchStatusDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Status Message}.
   *   <li>Then return {@code Status Message}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BatchStatus#BatchStatus(BatchStatusCode, String)}
   *   <li>{@link BatchStatus#getStatusCode()}
   *   <li>{@link BatchStatus#getStatusMessage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Status Message'; then return 'Status Message'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BatchStatus.<init>(BatchStatusCode)",
    "void BatchStatus.<init>(BatchStatusCode, String)",
    "BatchStatusCode BatchStatus.getStatusCode()",
    "String BatchStatus.getStatusMessage()"
  })
  void testGettersAndSetters_whenStatusMessage_thenReturnStatusMessage() {
    // Arrange and Act
    BatchStatus actualBatchStatus =
        new BatchStatus(BatchStatusCode.STATUS_UNKNOWN, "Status Message");
    BatchStatusCode actualStatusCode = actualBatchStatus.getStatusCode();

    // Assert
    assertEquals("Status Message", actualBatchStatus.getStatusMessage());
    assertEquals(BatchStatusCode.STATUS_UNKNOWN, actualStatusCode);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code STATUS_UNKNOWN}.
   *   <li>Then return StatusMessage is empty string.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BatchStatus#BatchStatus(BatchStatusCode)}
   *   <li>{@link BatchStatus#getStatusCode()}
   *   <li>{@link BatchStatus#getStatusMessage()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when 'STATUS_UNKNOWN'; then return StatusMessage is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BatchStatus.<init>(BatchStatusCode)",
    "void BatchStatus.<init>(BatchStatusCode, String)",
    "BatchStatusCode BatchStatus.getStatusCode()",
    "String BatchStatus.getStatusMessage()"
  })
  void testGettersAndSetters_whenStatusUnknown_thenReturnStatusMessageIsEmptyString() {
    // Arrange and Act
    BatchStatus actualBatchStatus = new BatchStatus(BatchStatusCode.STATUS_UNKNOWN);
    BatchStatusCode actualStatusCode = actualBatchStatus.getStatusCode();

    // Assert
    assertEquals("", actualBatchStatus.getStatusMessage());
    assertEquals(BatchStatusCode.STATUS_UNKNOWN, actualStatusCode);
  }
}
