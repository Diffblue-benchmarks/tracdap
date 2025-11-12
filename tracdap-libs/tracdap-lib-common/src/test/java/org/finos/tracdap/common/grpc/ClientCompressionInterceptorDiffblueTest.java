package org.finos.tracdap.common.grpc;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.MethodDescriptor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ClientCompressionInterceptorDiffblueTest {
  /**
   * Test {@link ClientCompressionInterceptor#interceptCall(MethodDescriptor, CallOptions,
   * Channel)}.
   *
   * <p>Method under test: {@link ClientCompressionInterceptor#interceptCall(MethodDescriptor,
   * CallOptions, Channel)}
   */
  @Test
  @DisplayName("Test interceptCall(MethodDescriptor, CallOptions, Channel)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.grpc.ClientCall ClientCompressionInterceptor.interceptCall(MethodDescriptor, CallOptions, Channel)"
  })
  void testInterceptCall() {
    // Arrange
    ClientCompressionInterceptor clientCompressionInterceptor = new ClientCompressionInterceptor();
    MethodDescriptor<Object, Object> method = mock(MethodDescriptor.class);
    CallOptions callOptions = mock(CallOptions.class);

    Channel next = mock(Channel.class);
    when(next.newCall(Mockito.<MethodDescriptor<Object, Object>>any(), Mockito.<CallOptions>any()))
        .thenReturn(null);

    // Act
    clientCompressionInterceptor.interceptCall(method, callOptions, next);

    // Assert
    verify(next).newCall(isA(MethodDescriptor.class), isA(CallOptions.class));
  }
}
