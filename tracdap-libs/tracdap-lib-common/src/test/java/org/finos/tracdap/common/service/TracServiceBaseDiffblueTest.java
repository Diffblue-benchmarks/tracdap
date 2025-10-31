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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.common.exception.EStartup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class TracServiceBaseDiffblueTest {
  /**
   * Test {@link TracServiceBase#svcMain(Class, String[])}.
   * <ul>
   *   <li>Given {@link Runtime} {@link Runtime#exit(int)} does nothing.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TracServiceBase#svcMain(Class, String[])}
   */
  @Test
  @DisplayName("Test svcMain(Class, String[]); given Runtime exit(int) does nothing; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TracServiceBase.svcMain(Class, String[])"})
  void testSvcMain_givenRuntimeExitDoesNothing_whenNull() {
    try (MockedStatic<Runtime> mockRuntime = mockStatic(Runtime.class)) {

      // Arrange
      Runtime runtime = mock(Runtime.class);
      doNothing().when(runtime).exit(anyInt());
      mockRuntime.when(Runtime::getRuntime).thenReturn(runtime);

      // Act
      TracServiceBase.svcMain(null, new String[]{"Args"});

      // Assert
      verify(runtime).exit(eq(-3));
      mockRuntime.verify(Runtime::getRuntime);
    }
  }

  /**
   * Test {@link TracServiceBase#svcMain(Class, String[])}.
   * <ul>
   *   <li>Given {@link Runtime} {@link Runtime#exit(int)} throw quietShutdown two.</li>
   *   <li>Then throw {@link EStartup}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TracServiceBase#svcMain(Class, String[])}
   */
  @Test
  @DisplayName("Test svcMain(Class, String[]); given Runtime exit(int) throw quietShutdown two; then throw EStartup")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TracServiceBase.svcMain(Class, String[])"})
  void testSvcMain_givenRuntimeExitThrowQuietShutdownTwo_thenThrowEStartup() {
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
   * Test {@link TracServiceBase#svcMain(Class, String[])}.
   * <ul>
   *   <li>When {@code TracServiceBase}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TracServiceBase#svcMain(Class, String[])}
   */
  @Test
  @DisplayName("Test svcMain(Class, String[]); when 'org.finos.tracdap.common.service.TracServiceBase'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TracServiceBase.svcMain(Class, String[])"})
  void testSvcMain_whenOrgFinosTracdapCommonServiceTracServiceBase() {
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
}
