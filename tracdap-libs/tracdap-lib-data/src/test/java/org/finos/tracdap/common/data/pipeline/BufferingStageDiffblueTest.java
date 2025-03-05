package org.finos.tracdap.common.data.pipeline;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.common.data.DataPipeline;
import org.finos.tracdap.common.data.DataPipeline.BufferApi;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BufferingStageDiffblueTest {
  /**
   * Test new {@link BufferingStage} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link BufferingStage}
   */
  @Test
  @DisplayName("Test new BufferingStage (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BufferingStage.<init>()"})
  void testNewBufferingStage() {
    // Arrange and Act
    BufferingStage actualBufferingStage = new BufferingStage();

    // Assert
    assertFalse(actualBufferingStage.isDone());
    assertTrue(actualBufferingStage.isReady());
    Class<BufferApi> expectedConsumerTypeResult = BufferApi.class;
    assertEquals(expectedConsumerTypeResult, actualBufferingStage.consumerType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BufferingStage#pump()}
   *   <li>{@link BufferingStage#isReady()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BufferingStage.isReady()", "void BufferingStage.pump()"})
  void testGettersAndSetters() {
    // Arrange
    BufferingStage bufferingStage = new BufferingStage();

    // Act
    bufferingStage.pump();

    // Assert
    assertTrue(bufferingStage.isReady());
  }
}
