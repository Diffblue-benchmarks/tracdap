package org.finos.tracdap.common.validation.core.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.common.validation.core.ValidationFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ValidatorBuilderDiffblueTest {
  /**
   * Test {@link ValidatorBuilder#buildValidatorMap()}.
   *
   * <p>Method under test: {@link ValidatorBuilder#buildValidatorMap()}
   */
  @Test
  @DisplayName("Test buildValidatorMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ValidatorBuilder.buildValidatorMap()"})
  void testBuildValidatorMap() {
    // Arrange and Act
    Map<ValidationKey, ValidationFunction<?>> actualBuildValidatorMapResult =
        ValidatorBuilder.buildValidatorMap();

    // Assert
    assertEquals(99, actualBuildValidatorMapResult.size());
  }

  /**
   * Test {@link ValidatorBuilder#scanPackages(Package[])}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ValidatorBuilder#scanPackages(Package[])}
   */
  @Test
  @DisplayName("Test scanPackages(Package[]); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ValidatorBuilder.scanPackages(Package[])"})
  void testScanPackages_thenReturnEmpty() {
    // Arrange and Act
    Map<ValidationKey, ValidationFunction<?>> actualScanPackagesResult =
        ValidatorBuilder.scanPackages();

    // Assert
    assertTrue(actualScanPackagesResult.isEmpty());
  }

  /**
   * Test {@link ValidatorBuilder#scanClass(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then throw {@link EUnexpected}.
   * </ul>
   *
   * <p>Method under test: {@link ValidatorBuilder#scanClass(Class)}
   */
  @Test
  @DisplayName("Test scanClass(Class); when 'java.lang.Object'; then throw EUnexpected")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ValidatorBuilder.scanClass(Class)"})
  void testScanClass_whenJavaLangObject_thenThrowEUnexpected() {
    // Arrange
    Class<Object> class_ = Object.class;

    // Act and Assert
    assertThrows(EUnexpected.class, () -> ValidatorBuilder.scanClass(class_));
  }
}
