package org.finos.tracdap.common.validation.core.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Map;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.junit.jupiter.api.Test;

class ValidatorBuilderDiffblueTest {
  /**
   * Method under test: {@link ValidatorBuilder#buildValidatorMap()}
   */
  @Test
  void testBuildValidatorMap() {
    // Arrange and Act
    Map<ValidationKey, ValidationFunction<?>> actualBuildValidatorMapResult = ValidatorBuilder.buildValidatorMap();

    // Assert
    assertEquals(99, actualBuildValidatorMapResult.size());
  }

  /**
   * Method under test: {@link ValidatorBuilder#scanPackages(Package[])}
   */
  @Test
  void testScanPackages() {
    // Arrange and Act
    Map<ValidationKey, ValidationFunction<?>> actualScanPackagesResult = ValidatorBuilder.scanPackages();

    // Assert
    assertTrue(actualScanPackagesResult.isEmpty());
  }

  /**
   * Method under test: {@link ValidatorBuilder#scanClass(Class)}
   */
  @Test
  void testScanClass() {
    // Arrange
    Class<Object> class_ = Object.class;

    // Act and Assert
    assertThrows(EUnexpected.class, () -> ValidatorBuilder.scanClass(class_));
  }
}
