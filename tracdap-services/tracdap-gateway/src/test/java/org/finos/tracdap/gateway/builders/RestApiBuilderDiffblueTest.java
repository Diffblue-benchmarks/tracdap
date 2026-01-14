package org.finos.tracdap.gateway.builders;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.HttpRule;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.MethodDescriptor;
import com.google.protobuf.Descriptors.ServiceDescriptor;
import java.util.ArrayList;
import java.util.List;
import javax.management.loading.MLet;
import org.finos.tracdap.common.exception.EConfig;
import org.finos.tracdap.gateway.proxy.rest.RestApiMethod;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RestApiBuilderDiffblueTest {
  /**
   * Test {@link RestApiBuilder#buildAllMethods(ServiceDescriptor, String, ClassLoader)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RestApiBuilder#buildAllMethods(ServiceDescriptor, String,
   * ClassLoader)}
   */
  @Test
  @DisplayName(
      "Test buildAllMethods(ServiceDescriptor, String, ClassLoader); given ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RestApiBuilder.buildAllMethods(ServiceDescriptor, String, ClassLoader)"})
  void testBuildAllMethods_givenArrayList_thenReturnEmpty() {
    // Arrange
    ServiceDescriptor protoService = mock(ServiceDescriptor.class);
    when(protoService.getMethods()).thenReturn(new ArrayList<>());

    // Act
    List<RestApiMethod<?, ?>> actualBuildAllMethodsResult =
        RestApiBuilder.buildAllMethods(protoService, "Api Prefix", new MLet());

    // Assert
    verify(protoService).getMethods();
    assertTrue(actualBuildAllMethodsResult.isEmpty());
  }

  /**
   * Test {@link RestApiBuilder#buildAllMethods(ServiceDescriptor, String, ClassLoader)}.
   *
   * <ul>
   *   <li>Given {@link EConfig#EConfig(String)} with message is {@code Not all who wander are
   *       lost}.
   * </ul>
   *
   * <p>Method under test: {@link RestApiBuilder#buildAllMethods(ServiceDescriptor, String,
   * ClassLoader)}
   */
  @Test
  @DisplayName(
      "Test buildAllMethods(ServiceDescriptor, String, ClassLoader); given EConfig(String) with message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RestApiBuilder.buildAllMethods(ServiceDescriptor, String, ClassLoader)"})
  void testBuildAllMethods_givenEConfigWithMessageIsNotAllWhoWanderAreLost() {
    // Arrange
    ServiceDescriptor protoService = mock(ServiceDescriptor.class);
    when(protoService.getMethods()).thenThrow(new EConfig("Not all who wander are lost"));

    // Act and Assert
    assertThrows(
        EConfig.class,
        () -> RestApiBuilder.buildAllMethods(protoService, "Api Prefix", new MLet()));
    verify(protoService).getMethods();
  }

  /**
   * Test {@link RestApiBuilder#buildAllMethods(ServiceDescriptor, String, ClassLoader)}.
   *
   * <ul>
   *   <li>Then calls {@link MethodDescriptor#getOptions()}.
   * </ul>
   *
   * <p>Method under test: {@link RestApiBuilder#buildAllMethods(ServiceDescriptor, String,
   * ClassLoader)}
   */
  @Test
  @DisplayName(
      "Test buildAllMethods(ServiceDescriptor, String, ClassLoader); then calls getOptions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RestApiBuilder.buildAllMethods(ServiceDescriptor, String, ClassLoader)"})
  void testBuildAllMethods_thenCallsGetOptions() {
    // Arrange
    MethodDescriptor methodDescriptor = mock(MethodDescriptor.class);
    when(methodDescriptor.getOptions()).thenThrow(new EConfig("Not all who wander are lost"));

    ArrayList<MethodDescriptor> methodDescriptorList = new ArrayList<>();
    methodDescriptorList.add(methodDescriptor);

    ServiceDescriptor protoService = mock(ServiceDescriptor.class);
    when(protoService.getMethods()).thenReturn(methodDescriptorList);

    // Act and Assert
    assertThrows(
        EConfig.class,
        () -> RestApiBuilder.buildAllMethods(protoService, "Api Prefix", new MLet()));
    verify(methodDescriptor).getOptions();
    verify(protoService).getMethods();
  }

  /**
   * Test {@link RestApiBuilder#buildMethod(MethodDescriptor, String, HttpRule, ClassLoader)}.
   *
   * <p>Method under test: {@link RestApiBuilder#buildMethod(MethodDescriptor, String, HttpRule,
   * ClassLoader)}
   */
  @Test
  @DisplayName("Test buildMethod(MethodDescriptor, String, HttpRule, ClassLoader)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RestApiMethod RestApiBuilder.buildMethod(MethodDescriptor, String, HttpRule, ClassLoader)"
  })
  void testBuildMethod() {
    // Arrange
    MethodDescriptor protoMethod = mock(MethodDescriptor.class);
    when(protoMethod.getInputType()).thenThrow(new EConfig("Not all who wander are lost"));
    HttpRule httpRule = HttpRule.getDefaultInstance();

    // Act and Assert
    assertThrows(
        EConfig.class,
        () -> RestApiBuilder.buildMethod(protoMethod, "Api Prefix", httpRule, new MLet()));
    verify(protoMethod).getInputType();
  }
}
