package org.finos.tracdap.common.grpc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.MethodDescriptor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ClientCompressionInterceptorDiffblueTest {
  /**
   * Test {@link ClientCompressionInterceptor#interceptCall(MethodDescriptor, CallOptions, Channel)}.
   * <p>
   * Method under test: {@link ClientCompressionInterceptor#interceptCall(MethodDescriptor, CallOptions, Channel)}
   */
  @Test
  @DisplayName("Test interceptCall(MethodDescriptor, CallOptions, Channel)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClientCall ClientCompressionInterceptor.interceptCall(MethodDescriptor, CallOptions, Channel)"})
  void testInterceptCall() {
    // Arrange
    ClientCompressionInterceptor clientCompressionInterceptor = new ClientCompressionInterceptor();
    Channel next = mock(Channel.class);
    when(next.newCall(Mockito.<MethodDescriptor<Object, Object>>any(), Mockito.<CallOptions>any()))
        .thenReturn(mock(ClientCall.class));

    // Act
    ClientCall<Object, Object> actualInterceptCallResult = clientCompressionInterceptor.interceptCall(null, null, next);

    // Assert
    verify(next).newCall(isNull(), isNull());
    assertNull(actualInterceptCallResult.getAttributes());
    assertFalse(actualInterceptCallResult.isReady());
  }
}
