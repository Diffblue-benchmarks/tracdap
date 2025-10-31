package org.finos.tracdap.common.netty;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.concurrent.Executor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EventLoopOffloadTrackerDiffblueTest {
  /**
   * Method under test: {@link EventLoopOffloadTracker#wrappExecutor(Executor)}
   */
  @Test
  void testWrappExecutor() {
    // Arrange
    EventLoopOffloadTracker eventLoopOffloadTracker = new EventLoopOffloadTracker();
    Executor baseExecutor = mock(Executor.class);
    doNothing().when(baseExecutor).execute(Mockito.<Runnable>any());

    // Act
    eventLoopOffloadTracker.wrappExecutor(baseExecutor).execute(mock(Runnable.class));

    // Assert that nothing has changed
    verify(baseExecutor).execute(isA(Runnable.class));
  }

  /**
   * Method under test: {@link EventLoopOffloadTracker#offloadCallingThread()}
   */
  @Test
  void testOffloadCallingThread() {
    // Arrange, Act and Assert
    assertNull((new EventLoopOffloadTracker()).offloadCallingThread());
  }
}
