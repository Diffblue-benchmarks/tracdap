package org.finos.tracdap.common.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import org.finos.tracdap.common.exception.EStartup;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class TracServiceBaseDiffblueTest {
  /**
   * Method under test: {@link TracServiceBase#svcMain(Class, String[])}
   */
  @Test
  void testSvcMain() {
    try (MockedStatic<Runtime> mockRuntime = mockStatic(Runtime.class)) {
      // Arrange
      Runtime runtime = mock(Runtime.class);
      doNothing().when(runtime).exit(anyInt());
      mockRuntime.when(Runtime::getRuntime).thenReturn(runtime);
      Class<TracServiceBase> svcClass = TracServiceBase.class;

      // Act
      TracServiceBase.svcMain(svcClass, new String[]{"Args"});

      // Assert
      verify(runtime, atLeast(1)).exit(eq(-1));
      mockRuntime.verify(Runtime::getRuntime, atLeast(1));
    }
  }

  /**
   * Method under test: {@link TracServiceBase#svcMain(Class, String[])}
   */
  @Test
  void testSvcMain2() {
    try (MockedStatic<Runtime> mockRuntime = mockStatic(Runtime.class)) {
      // Arrange
      Runtime runtime = mock(Runtime.class);
      doThrow(EStartup.quietShutdown(2)).when(runtime).exit(anyInt());
      mockRuntime.when(Runtime::getRuntime).thenReturn(runtime);
      Class<TracServiceBase> svcClass = TracServiceBase.class;

      // Act and Assert
      assertThrows(EStartup.class, () -> TracServiceBase.svcMain(svcClass, new String[]{"Args"}));
      verify(runtime).exit(eq(-1));
      mockRuntime.verify(Runtime::getRuntime);
    }
  }

  /**
   * Method under test: {@link TracServiceBase#svcMain(Class, String[])}
   */
  @Test
  void testSvcMain3() {
    try (MockedStatic<Runtime> mockRuntime = mockStatic(Runtime.class)) {
      // Arrange
      Runtime runtime = mock(Runtime.class);
      doNothing().when(runtime).exit(anyInt());
      mockRuntime.when(Runtime::getRuntime).thenReturn(runtime);

      // Act
      TracServiceBase.svcMain(null, new String[]{"Args"});

      // Assert that nothing has changed
      verify(runtime).exit(eq(-3));
      mockRuntime.verify(Runtime::getRuntime);
    }
  }
}
