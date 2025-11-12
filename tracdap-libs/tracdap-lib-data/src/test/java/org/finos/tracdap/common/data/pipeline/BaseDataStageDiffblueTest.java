package org.finos.tracdap.common.data.pipeline;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BaseDataStageDiffblueTest {
  /**
   * Test {@link BaseDataStage#markAsDone()}.
   *
   * <p>Method under test: {@link BaseDataStage#markAsDone()}
   */
  @Test
  @DisplayName("Test markAsDone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseDataStage.markAsDone()"})
  void testMarkAsDone() {
    // Arrange
    BufferingStage bufferingStage = new BufferingStage();

    // Act
    bufferingStage.markAsDone();

    // Assert
    assertTrue(bufferingStage.isDone());
  }

  /**
   * Test {@link BaseDataStage#isDone()}.
   *
   * <p>Method under test: {@link BaseDataStage#isDone()}
   */
  @Test
  @DisplayName("Test isDone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseDataStage.isDone()"})
  void testIsDone() {
    // Arrange, Act and Assert
    assertFalse(new BufferingStage().isDone());
  }
}
