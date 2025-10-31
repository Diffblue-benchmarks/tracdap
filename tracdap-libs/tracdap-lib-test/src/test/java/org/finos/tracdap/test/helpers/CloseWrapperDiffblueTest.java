package org.finos.tracdap.test.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CloseWrapperDiffblueTest {
  /**
   * Test {@link CloseWrapper#wrap(Object)}.
   * <p>
   * Method under test: {@link CloseWrapper#wrap(Object)}
   */
  @Test
  @DisplayName("Test wrap(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CloseWrapper CloseWrapper.wrap(Object)"})
  void testWrap() {
    // Arrange and Act
    CloseWrapper<Object> actualWrapResult = CloseWrapper.wrap("Obj");

    // Assert
    assertEquals("Obj", actualWrapResult.get());
  }

  /**
   * Test {@link CloseWrapper#get()}.
   * <p>
   * Method under test: {@link CloseWrapper#get()}
   */
  @Test
  @DisplayName("Test get()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object CloseWrapper.get()"})
  void testGet() {
    // Arrange
    CloseWrapper<Object> wrapResult = CloseWrapper.wrap("Obj");

    // Act and Assert
    assertEquals("Obj", wrapResult.get());
  }
}
