package org.finos.tracdap.common.netty;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EventLoopOffloadTrackerDiffblueTest {
  /**
   * Test {@link EventLoopOffloadTracker#offloadCallingThread()}.
   * <p>
   * Method under test: {@link EventLoopOffloadTracker#offloadCallingThread()}
   */
  @Test
  @DisplayName("Test offloadCallingThread()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Thread EventLoopOffloadTracker.offloadCallingThread()"})
  void testOffloadCallingThread() {
    // Arrange, Act and Assert
    assertNull((new EventLoopOffloadTracker()).offloadCallingThread());
  }
}
