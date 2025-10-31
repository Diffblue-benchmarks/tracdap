package org.finos.tracdap.test.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class CloseWrapperDiffblueTest {
  /**
   * Method under test: {@link CloseWrapper#wrap(Object)}
   */
  @Test
  void testWrap() {
    // Arrange and Act
    CloseWrapper<Object> actualWrapResult = CloseWrapper.wrap("Obj");

    // Assert
    assertEquals("Obj", actualWrapResult.get());
  }

  /**
   * Method under test: {@link CloseWrapper#get()}
   */
  @Test
  void testGet() {
    // Arrange
    CloseWrapper<Object> wrapResult = CloseWrapper.wrap("Obj");

    // Act and Assert
    assertEquals("Obj", wrapResult.get());
  }
}
