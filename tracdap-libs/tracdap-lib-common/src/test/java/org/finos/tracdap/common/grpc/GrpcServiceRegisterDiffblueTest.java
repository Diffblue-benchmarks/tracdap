package org.finos.tracdap.common.grpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.MethodDescriptor;
import com.google.protobuf.Descriptors.ServiceDescriptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.finos.tracdap.common.exception.ETracInternal;
import org.finos.tracdap.common.grpc.GrpcServiceRegister.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GrpcServiceRegisterDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GrpcServiceRegister Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    GrpcServiceRegister actualGrpcServiceRegister = GrpcServiceRegister.newBuilder().build();

    // Assert
    assertTrue(actualGrpcServiceRegister.methodMap.isEmpty());
    assertTrue(actualGrpcServiceRegister.serviceMap.isEmpty());
  }

  /**
   * Test Builder {@link Builder#registerService(ServiceDescriptor)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then newBuilder {@link GrpcServiceRegister#methodMap} Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#registerService(ServiceDescriptor)}
   */
  @Test
  @DisplayName(
      "Test Builder registerService(ServiceDescriptor); given ArrayList(); then newBuilder methodMap Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.registerService(ServiceDescriptor)"})
  void testBuilderRegisterService_givenArrayList_thenNewBuilderMethodMapEmpty() {
    // Arrange
    Builder newBuilderResult = GrpcServiceRegister.newBuilder();

    ServiceDescriptor serviceDescriptor = mock(ServiceDescriptor.class);
    when(serviceDescriptor.getFullName()).thenReturn("Dr Jane Doe");
    when(serviceDescriptor.getMethods()).thenReturn(new ArrayList<>());

    // Act
    Builder actualRegisterServiceResult = newBuilderResult.registerService(serviceDescriptor);

    // Assert
    verify(serviceDescriptor).getFullName();
    verify(serviceDescriptor).getMethods();
    Map<String, ServiceDescriptor> stringServiceDescriptorMap = newBuilderResult.serviceMap;
    assertEquals(1, stringServiceDescriptorMap.size());
    assertTrue(newBuilderResult.methodMap.isEmpty());
    assertSame(newBuilderResult, actualRegisterServiceResult);
    assertSame(serviceDescriptor, stringServiceDescriptorMap.get("Dr Jane Doe"));
  }

  /**
   * Test Builder {@link Builder#registerService(ServiceDescriptor)}.
   *
   * <ul>
   *   <li>Then newBuilder {@link GrpcServiceRegister#methodMap} size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#registerService(ServiceDescriptor)}
   */
  @Test
  @DisplayName(
      "Test Builder registerService(ServiceDescriptor); then newBuilder methodMap size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.registerService(ServiceDescriptor)"})
  void testBuilderRegisterService_thenNewBuilderMethodMapSizeIsOne() {
    // Arrange
    Builder newBuilderResult = GrpcServiceRegister.newBuilder();

    MethodDescriptor methodDescriptor = mock(MethodDescriptor.class);
    when(methodDescriptor.getName()).thenReturn("Name");

    ArrayList<MethodDescriptor> methodDescriptorList = new ArrayList<>();
    methodDescriptorList.add(methodDescriptor);

    ServiceDescriptor serviceDescriptor = mock(ServiceDescriptor.class);
    when(serviceDescriptor.getMethods()).thenReturn(methodDescriptorList);
    when(serviceDescriptor.getFullName()).thenReturn("Dr Jane Doe");

    // Act
    Builder actualRegisterServiceResult = newBuilderResult.registerService(serviceDescriptor);

    // Assert
    verify(methodDescriptor).getName();
    verify(serviceDescriptor, atLeast(1)).getFullName();
    verify(serviceDescriptor).getMethods();
    Map<String, MethodDescriptor> stringMethodDescriptorMap = newBuilderResult.methodMap;
    assertEquals(1, stringMethodDescriptorMap.size());
    Map<String, ServiceDescriptor> stringServiceDescriptorMap = newBuilderResult.serviceMap;
    assertEquals(1, stringServiceDescriptorMap.size());
    assertTrue(stringMethodDescriptorMap.containsKey("Dr Jane Doe/Name"));
    assertSame(newBuilderResult, actualRegisterServiceResult);
    assertSame(serviceDescriptor, stringServiceDescriptorMap.get("Dr Jane Doe"));
  }

  /**
   * Test Builder {@link Builder#registerServices(List)}.
   *
   * <p>Method under test: {@link Builder#registerServices(List)}
   */
  @Test
  @DisplayName("Test Builder registerServices(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.registerServices(List)"})
  void testBuilderRegisterServices() {
    // Arrange
    Builder newBuilderResult = GrpcServiceRegister.newBuilder();

    // Act
    Builder actualRegisterServicesResult = newBuilderResult.registerServices(new ArrayList<>());

    // Assert
    assertSame(newBuilderResult, actualRegisterServicesResult);
  }

  /**
   * Test {@link GrpcServiceRegister#newBuilder()}.
   *
   * <p>Method under test: {@link GrpcServiceRegister#newBuilder()}
   */
  @Test
  @DisplayName("Test newBuilder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder GrpcServiceRegister.newBuilder()"})
  void testNewBuilder() {
    // Arrange and Act
    Builder actualNewBuilderResult = GrpcServiceRegister.newBuilder().build().newBuilder();

    // Assert
    assertTrue(actualNewBuilderResult.methodMap.isEmpty());
    assertTrue(actualNewBuilderResult.serviceMap.isEmpty());
  }

  /**
   * Test {@link GrpcServiceRegister#getServiceDescriptor(String)}.
   *
   * <p>Method under test: {@link GrpcServiceRegister#getServiceDescriptor(String)}
   */
  @Test
  @DisplayName("Test getServiceDescriptor(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ServiceDescriptor GrpcServiceRegister.getServiceDescriptor(String)"})
  void testGetServiceDescriptor() {
    // Arrange, Act and Assert
    assertThrows(
        ETracInternal.class,
        () -> GrpcServiceRegister.newBuilder().build().getServiceDescriptor("Service Name"));
  }

  /**
   * Test {@link GrpcServiceRegister#getMethodDescriptor(String)}.
   *
   * <p>Method under test: {@link GrpcServiceRegister#getMethodDescriptor(String)}
   */
  @Test
  @DisplayName("Test getMethodDescriptor(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MethodDescriptor GrpcServiceRegister.getMethodDescriptor(String)"})
  void testGetMethodDescriptor() {
    // Arrange, Act and Assert
    assertThrows(
        ETracInternal.class,
        () -> GrpcServiceRegister.newBuilder().build().getMethodDescriptor("Method Name"));
  }
}
