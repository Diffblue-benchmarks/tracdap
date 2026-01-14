package org.finos.tracdap.common.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.FeatureSetDefaults;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.MethodDescriptor;
import com.google.protobuf.Message;
import java.util.HashMap;
import org.finos.tracdap.api.TracErrorDetails;
import org.finos.tracdap.common.exception.EInputValidation;
import org.finos.tracdap.common.metadata.MetadataBundle;
import org.finos.tracdap.config.PlatformConfig;
import org.finos.tracdap.metadata.DataDefinition;
import org.finos.tracdap.metadata.DataDefinition.Snap;
import org.finos.tracdap.metadata.ObjectDefinition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ValidatorDiffblueTest {
  /**
   * Test {@link Validator#validateFixedMethod(Message, MethodDescriptor)}.
   *
   * <ul>
   *   <li>Then throw {@link EInputValidation}.
   * </ul>
   *
   * <p>Method under test: {@link Validator#validateFixedMethod(Message, MethodDescriptor)}
   */
  @Test
  @DisplayName("Test validateFixedMethod(Message, MethodDescriptor); then throw EInputValidation")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Validator.validateFixedMethod(Message, MethodDescriptor)"})
  void testValidateFixedMethod_thenThrowEInputValidation() {
    // Arrange
    Validator validator = new Validator();
    TracErrorDetails defaultInstance = TracErrorDetails.getDefaultInstance();

    MethodDescriptor method = mock(MethodDescriptor.class);
    when(method.getFullName()).thenThrow(new EInputValidation("Not all who wander are lost"));

    // Act and Assert
    assertThrows(
        EInputValidation.class, () -> validator.validateFixedMethod(defaultInstance, method));
    verify(method).getFullName();
  }

  /**
   * Test {@link Validator#validateFixedObject(Message)}.
   *
   * <ul>
   *   <li>Then calls {@link DescriptorProtos.FeatureSetDefaults#getDescriptorForType()}.
   * </ul>
   *
   * <p>Method under test: {@link Validator#validateFixedObject(Message)}
   */
  @Test
  @DisplayName("Test validateFixedObject(Message); then calls getDescriptorForType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Validator.validateFixedObject(Message)"})
  void testValidateFixedObject_thenCallsGetDescriptorForType() {
    // Arrange
    Validator validator = new Validator();

    FeatureSetDefaults featureSetDefaults = mock(FeatureSetDefaults.class);
    when(featureSetDefaults.getDescriptorForType())
        .thenThrow(new EInputValidation("Not all who wander are lost"));

    // Act and Assert
    assertThrows(EInputValidation.class, () -> validator.validateFixedObject(featureSetDefaults));
    verify(featureSetDefaults).getDescriptorForType();
  }

  /**
   * Test {@link Validator#validateFixedObject(Message)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then throw {@link EInputValidation}.
   * </ul>
   *
   * <p>Method under test: {@link Validator#validateFixedObject(Message)}
   */
  @Test
  @DisplayName(
      "Test validateFixedObject(Message); when DefaultInstance; then throw EInputValidation")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Validator.validateFixedObject(Message)"})
  void testValidateFixedObject_whenDefaultInstance_thenThrowEInputValidation() {
    // Arrange, Act and Assert
    assertThrows(
        EInputValidation.class,
        () -> new Validator().validateFixedObject(DataDefinition.getDefaultInstance()));
  }

  /**
   * Test {@link Validator#validateFixedObject(Message)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then throw {@link EInputValidation}.
   * </ul>
   *
   * <p>Method under test: {@link Validator#validateFixedObject(Message)}
   */
  @Test
  @DisplayName(
      "Test validateFixedObject(Message); when DefaultInstance; then throw EInputValidation")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Validator.validateFixedObject(Message)"})
  void testValidateFixedObject_whenDefaultInstance_thenThrowEInputValidation2() {
    // Arrange, Act and Assert
    assertThrows(
        EInputValidation.class,
        () -> new Validator().validateFixedObject(Snap.getDefaultInstance()));
  }

  /**
   * Test {@link Validator#validateVersion(Message, Message)}.
   *
   * <ul>
   *   <li>Then throw {@link EInputValidation}.
   * </ul>
   *
   * <p>Method under test: {@link Validator#validateVersion(Message, Message)}
   */
  @Test
  @DisplayName("Test validateVersion(Message, Message); then throw EInputValidation")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Validator.validateVersion(Message, Message)"})
  void testValidateVersion_thenThrowEInputValidation() {
    // Arrange
    Validator validator = new Validator();

    FeatureSetDefaults featureSetDefaults = mock(FeatureSetDefaults.class);
    when(featureSetDefaults.getDescriptorForType())
        .thenThrow(new EInputValidation("Not all who wander are lost"));

    // Act and Assert
    assertThrows(
        EInputValidation.class,
        () -> validator.validateVersion(featureSetDefaults, TracErrorDetails.getDefaultInstance()));
    verify(featureSetDefaults).getDescriptorForType();
  }

  /**
   * Test {@link Validator#validateConsistency(Message, MetadataBundle, PlatformConfig)}.
   *
   * <ul>
   *   <li>Then throw {@link EInputValidation}.
   * </ul>
   *
   * <p>Method under test: {@link Validator#validateConsistency(Message, MetadataBundle,
   * PlatformConfig)}
   */
  @Test
  @DisplayName(
      "Test validateConsistency(Message, MetadataBundle, PlatformConfig); then throw EInputValidation")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Validator.validateConsistency(Message, MetadataBundle, PlatformConfig)"})
  void testValidateConsistency_thenThrowEInputValidation() {
    // Arrange
    Validator validator = new Validator();

    FeatureSetDefaults featureSetDefaults = mock(FeatureSetDefaults.class);
    when(featureSetDefaults.getDescriptorForType())
        .thenThrow(new EInputValidation("Not all who wander are lost"));
    HashMap<String, ObjectDefinition> resources = new HashMap<>();
    MetadataBundle metadata = new MetadataBundle(resources, new HashMap<>());

    // Act and Assert
    assertThrows(
        EInputValidation.class,
        () ->
            validator.validateConsistency(
                featureSetDefaults, metadata, PlatformConfig.getDefaultInstance()));
    verify(featureSetDefaults).getDescriptorForType();
  }
}
