package org.finos.tracdap.common.netty;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.MethodDescriptor;
import io.netty.channel.DefaultEventLoop;
import io.netty.util.concurrent.EventExecutor;
import org.finos.tracdap.common.exception.ETracInternal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EventLoopInterceptorDiffblueTest {
  /**
   * Test {@link EventLoopInterceptor#interceptCall(MethodDescriptor, CallOptions, Channel)}.
   * <p>
   * Method under test: {@link EventLoopInterceptor#interceptCall(MethodDescriptor, CallOptions, Channel)}
   */
  @Test
  @DisplayName("Test interceptCall(MethodDescriptor, CallOptions, Channel)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClientCall EventLoopInterceptor.interceptCall(MethodDescriptor, CallOptions, Channel)"})
  void testInterceptCall() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class,
        () -> (new EventLoopInterceptor(
            new EventLoopResolver(new EventExecutor[]{new DefaultEventLoop()}, new EventLoopOffloadTracker())))
            .interceptCall(null, null, mock(Channel.class)));
  }

  /**
   * Test {@link EventLoopInterceptor#interceptCall(MethodDescriptor, CallOptions, Channel)}.
   * <p>
   * Method under test: {@link EventLoopInterceptor#interceptCall(MethodDescriptor, CallOptions, Channel)}
   */
  @Test
  @DisplayName("Test interceptCall(MethodDescriptor, CallOptions, Channel)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClientCall EventLoopInterceptor.interceptCall(MethodDescriptor, CallOptions, Channel)"})
  void testInterceptCall2() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class,
        () -> (new EventLoopInterceptor(new EventLoopResolver((EventExecutor[]) null, new EventLoopOffloadTracker())))
            .interceptCall(null, null, mock(Channel.class)));
  }

  /**
   * Test {@link EventLoopInterceptor#interceptCall(MethodDescriptor, CallOptions, Channel)}.
   * <p>
   * Method under test: {@link EventLoopInterceptor#interceptCall(MethodDescriptor, CallOptions, Channel)}
   */
  @Test
  @DisplayName("Test interceptCall(MethodDescriptor, CallOptions, Channel)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClientCall EventLoopInterceptor.interceptCall(MethodDescriptor, CallOptions, Channel)"})
  void testInterceptCall3() {
    // Arrange
    EventLoopInterceptor eventLoopInterceptor = new EventLoopInterceptor(new DefaultEventLoop(), false, false);
    Channel channel = mock(Channel.class);
    when(channel.newCall(Mockito.<MethodDescriptor<Object, Object>>any(), Mockito.<CallOptions>any()))
        .thenReturn(mock(ClientCall.class));

    // Act
    ClientCall<Object, Object> actualInterceptCallResult = eventLoopInterceptor.interceptCall(null, null, channel);

    // Assert
    verify(channel).newCall(isNull(), isNull());
    assertNull(actualInterceptCallResult.getAttributes());
    assertFalse(actualInterceptCallResult.isReady());
  }

  /**
   * Test {@link EventLoopInterceptor#interceptCall(MethodDescriptor, CallOptions, Channel)}.
   * <ul>
   *   <li>Given {@link ETracInternal#ETracInternal(String)} with message is {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EventLoopInterceptor#interceptCall(MethodDescriptor, CallOptions, Channel)}
   */
  @Test
  @DisplayName("Test interceptCall(MethodDescriptor, CallOptions, Channel); given ETracInternal(String) with message is 'Not all who wander are lost'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClientCall EventLoopInterceptor.interceptCall(MethodDescriptor, CallOptions, Channel)"})
  void testInterceptCall_givenETracInternalWithMessageIsNotAllWhoWanderAreLost() {
    // Arrange
    EventLoopInterceptor eventLoopInterceptor = new EventLoopInterceptor(new DefaultEventLoop(), false, true);
    Channel channel = mock(Channel.class);
    when(channel.newCall(Mockito.<MethodDescriptor<Object, Object>>any(), Mockito.<CallOptions>any()))
        .thenThrow(new ETracInternal("Not all who wander are lost"));

    // Act and Assert
    assertThrows(ETracInternal.class, () -> eventLoopInterceptor.interceptCall(null, null, channel));
    verify(channel).newCall(isNull(), isNull());
  }

  /**
   * Test {@link EventLoopInterceptor#interceptCall(MethodDescriptor, CallOptions, Channel)}.
   * <ul>
   *   <li>Given {@link EventLoopInterceptor#EventLoopInterceptor(EventExecutorGroup)} with eventLoopGroup is {@link DefaultEventLoop#DefaultEventLoop()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EventLoopInterceptor#interceptCall(MethodDescriptor, CallOptions, Channel)}
   */
  @Test
  @DisplayName("Test interceptCall(MethodDescriptor, CallOptions, Channel); given EventLoopInterceptor(EventExecutorGroup) with eventLoopGroup is DefaultEventLoop()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClientCall EventLoopInterceptor.interceptCall(MethodDescriptor, CallOptions, Channel)"})
  void testInterceptCall_givenEventLoopInterceptorWithEventLoopGroupIsDefaultEventLoop() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class,
        () -> (new EventLoopInterceptor(new DefaultEventLoop())).interceptCall(null, null, mock(Channel.class)));
  }

  /**
   * Test {@link EventLoopInterceptor#interceptCall(MethodDescriptor, CallOptions, Channel)}.
   * <ul>
   *   <li>Then return Attributes is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EventLoopInterceptor#interceptCall(MethodDescriptor, CallOptions, Channel)}
   */
  @Test
  @DisplayName("Test interceptCall(MethodDescriptor, CallOptions, Channel); then return Attributes is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClientCall EventLoopInterceptor.interceptCall(MethodDescriptor, CallOptions, Channel)"})
  void testInterceptCall_thenReturnAttributesIsNull() {
    // Arrange
    EventLoopInterceptor eventLoopInterceptor = new EventLoopInterceptor(new DefaultEventLoop(), false, true);
    Channel channel = mock(Channel.class);
    when(channel.newCall(Mockito.<MethodDescriptor<Object, Object>>any(), Mockito.<CallOptions>any()))
        .thenReturn(mock(ClientCall.class));

    // Act
    ClientCall<Object, Object> actualInterceptCallResult = eventLoopInterceptor.interceptCall(null, null, channel);

    // Assert
    verify(channel).newCall(isNull(), isNull());
    assertNull(actualInterceptCallResult.getAttributes());
    assertFalse(actualInterceptCallResult.isReady());
  }
}
