package org.finos.tracdap.common.grpc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.MethodDescriptor;
import io.grpc.MethodDescriptor.MethodType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ClientLoggingInterceptorDiffblueTest {
  /**
   * Test {@link ClientLoggingInterceptor#interceptCall(MethodDescriptor, CallOptions, Channel)}.
   *
   * <ul>
   *   <li>Given {@code .}.
   *   <li>When {@link MethodDescriptor} {@link MethodDescriptor#getServiceName()} return {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link ClientLoggingInterceptor#interceptCall(MethodDescriptor,
   * CallOptions, Channel)}
   */
  @Test
  @DisplayName(
      "Test interceptCall(MethodDescriptor, CallOptions, Channel); given '.'; when MethodDescriptor getServiceName() return '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClientCall ClientLoggingInterceptor.interceptCall(MethodDescriptor, CallOptions, Channel)"
  })
  void testInterceptCall_givenDot_whenMethodDescriptorGetServiceNameReturnDot() {
    // Arrange
    Class<Object> serviceClass = Object.class;
    ClientLoggingInterceptor clientLoggingInterceptor = new ClientLoggingInterceptor(serviceClass);

    MethodDescriptor<Object, Object> method = mock(MethodDescriptor.class);
    when(method.getServiceName()).thenReturn(".");
    when(method.getType()).thenReturn(MethodType.UNARY);
    when(method.getBareMethodName()).thenReturn("Bare Method Name");
    CallOptions callOptions = mock(CallOptions.class);

    Channel next = mock(Channel.class);
    when(next.newCall(Mockito.<MethodDescriptor<Object, Object>>any(), Mockito.<CallOptions>any()))
        .thenReturn(mock(ClientCall.class));

    // Act
    ClientCall<Object, Object> actualInterceptCallResult =
        clientLoggingInterceptor.interceptCall(method, callOptions, next);

    // Assert
    verify(next).newCall(isA(MethodDescriptor.class), isA(CallOptions.class));
    verify(method).getBareMethodName();
    verify(method).getServiceName();
    verify(method).getType();
    assertNull(actualInterceptCallResult.getAttributes());
    assertFalse(actualInterceptCallResult.isReady());
  }

  /**
   * Test {@link ClientLoggingInterceptor#interceptCall(MethodDescriptor, CallOptions, Channel)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link MethodDescriptor} {@link MethodDescriptor#getServiceName()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link ClientLoggingInterceptor#interceptCall(MethodDescriptor,
   * CallOptions, Channel)}
   */
  @Test
  @DisplayName(
      "Test interceptCall(MethodDescriptor, CallOptions, Channel); given 'null'; when MethodDescriptor getServiceName() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClientCall ClientLoggingInterceptor.interceptCall(MethodDescriptor, CallOptions, Channel)"
  })
  void testInterceptCall_givenNull_whenMethodDescriptorGetServiceNameReturnNull() {
    // Arrange
    Class<Object> serviceClass = Object.class;
    ClientLoggingInterceptor clientLoggingInterceptor = new ClientLoggingInterceptor(serviceClass);

    MethodDescriptor<Object, Object> method = mock(MethodDescriptor.class);
    when(method.getServiceName()).thenReturn(null);
    when(method.getType()).thenReturn(MethodType.UNARY);
    when(method.getBareMethodName()).thenReturn("Bare Method Name");
    CallOptions callOptions = mock(CallOptions.class);

    Channel next = mock(Channel.class);
    when(next.newCall(Mockito.<MethodDescriptor<Object, Object>>any(), Mockito.<CallOptions>any()))
        .thenReturn(mock(ClientCall.class));

    // Act
    ClientCall<Object, Object> actualInterceptCallResult =
        clientLoggingInterceptor.interceptCall(method, callOptions, next);

    // Assert
    verify(next).newCall(isA(MethodDescriptor.class), isA(CallOptions.class));
    verify(method).getBareMethodName();
    verify(method).getServiceName();
    verify(method).getType();
    assertNull(actualInterceptCallResult.getAttributes());
    assertFalse(actualInterceptCallResult.isReady());
  }
}
