package org.finos.tracdap.common.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.common.exception.EStartup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class TracServiceBaseDiffblueTest {
  /**
   * Test {@link TracServiceBase#svcMain(Class, String[])}.
   *
   * <ul>
   *   <li>Given {@link Runtime} {@link Runtime#exit(int)} does nothing.
   *   <li>When {@code null}.
   *   <li>Then calls {@link Runtime#exit(int)}.
   * </ul>
   *
   * <p>Method under test: {@link TracServiceBase#svcMain(Class, String[])}
   */
  @Test
  @DisplayName(
      "Test svcMain(Class, String[]); given Runtime exit(int) does nothing; when 'null'; then calls exit(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TracServiceBase.svcMain(Class, String[])"})
  void testSvcMain_givenRuntimeExitDoesNothing_whenNull_thenCallsExit() {
    // Arrange
    try (MockedStatic<Runtime> mockRuntime = mockStatic(Runtime.class)) {

      Runtime runtime = mock(Runtime.class);
      doNothing().when(runtime).exit(anyInt());
      mockRuntime.when(Runtime::getRuntime).thenReturn(runtime);

      // Act
      TracServiceBase.svcMain(null, new String[] {"Args"});

      // Assert
      verify(runtime).exit(-3);
      mockRuntime.verify(Runtime::getRuntime);
    }
  }

  /**
   * Test {@link TracServiceBase#svcMain(Class, String[])}.
   *
   * <ul>
   *   <li>Given {@link Runtime} {@link Runtime#getRuntime()} throw quietShutdown two.
   *   <li>Then throw {@link EStartup}.
   * </ul>
   *
   * <p>Method under test: {@link TracServiceBase#svcMain(Class, String[])}
   */
  @Test
  @DisplayName(
      "Test svcMain(Class, String[]); given Runtime getRuntime() throw quietShutdown two; then throw EStartup")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TracServiceBase.svcMain(Class, String[])"})
  void testSvcMain_givenRuntimeGetRuntimeThrowQuietShutdownTwo_thenThrowEStartup() {
    // Arrange
    try (MockedStatic<Runtime> mockRuntime = mockStatic(Runtime.class)) {
      mockRuntime.when(Runtime::getRuntime).thenThrow(EStartup.quietShutdown(2));
      Class<TracServiceBase> svcClass = TracServiceBase.class;

      // Act and Assert
      assertThrows(EStartup.class, () -> TracServiceBase.svcMain(svcClass, new String[] {"Args"}));
      mockRuntime.verify(Runtime::getRuntime);
    }
  }

  /**
   * Test {@link TracServiceBase#svcMain(Class, String[])}.
   *
   * <ul>
   *   <li>When {@code TracServiceBase}.
   * </ul>
   *
   * <p>Method under test: {@link TracServiceBase#svcMain(Class, String[])}
   */
  @Test
  @DisplayName(
      "Test svcMain(Class, String[]); when 'org.finos.tracdap.common.service.TracServiceBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TracServiceBase.svcMain(Class, String[])"})
  void testSvcMain_whenOrgFinosTracdapCommonServiceTracServiceBase() {
    // Arrange
    try (MockedStatic<Runtime> mockRuntime = mockStatic(Runtime.class)) {

      Runtime runtime = mock(Runtime.class);
      doNothing().when(runtime).exit(anyInt());
      mockRuntime.when(Runtime::getRuntime).thenReturn(runtime);
      Class<TracServiceBase> svcClass = TracServiceBase.class;

      // Act
      TracServiceBase.svcMain(svcClass, new String[] {"Args"});

      // Assert
      verify(runtime, atLeast(1)).exit(-1);
      mockRuntime.verify(Runtime::getRuntime, atLeast(1));
    }
  }
}
