package org.finos.tracdap.common.netty;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
   *
   * <p>Method under test: {@link EventLoopInterceptor#interceptCall(MethodDescriptor, CallOptions,
   * Channel)}
   */
  @Test
  @DisplayName("Test interceptCall(MethodDescriptor, CallOptions, Channel)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClientCall EventLoopInterceptor.interceptCall(MethodDescriptor, CallOptions, Channel)"
  })
  void testInterceptCall() {
    // Arrange
    EventExecutor[] eventExecutors = new EventExecutor[] {new DefaultEventLoop()};
    EventLoopResolver eventLoopResolver =
        new EventLoopResolver(eventExecutors, new EventLoopOffloadTracker());

    // Act and Assert
    assertThrows(
        ETracInternal.class,
        () ->
            new EventLoopInterceptor(eventLoopResolver)
                .interceptCall(null, mock(CallOptions.class), mock(Channel.class)));
  }

  /**
   * Test {@link EventLoopInterceptor#interceptCall(MethodDescriptor, CallOptions, Channel)}.
   *
   * <p>Method under test: {@link EventLoopInterceptor#interceptCall(MethodDescriptor, CallOptions,
   * Channel)}
   */
  @Test
  @DisplayName("Test interceptCall(MethodDescriptor, CallOptions, Channel)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClientCall EventLoopInterceptor.interceptCall(MethodDescriptor, CallOptions, Channel)"
  })
  void testInterceptCall2() {
    // Arrange
    EventLoopResolver eventLoopResolver =
        new EventLoopResolver((EventExecutor[]) null, new EventLoopOffloadTracker());

    // Act and Assert
    assertThrows(
        ETracInternal.class,
        () ->
            new EventLoopInterceptor(eventLoopResolver)
                .interceptCall(null, mock(CallOptions.class), mock(Channel.class)));
  }

  /**
   * Test {@link EventLoopInterceptor#interceptCall(MethodDescriptor, CallOptions, Channel)}.
   *
   * <p>Method under test: {@link EventLoopInterceptor#interceptCall(MethodDescriptor, CallOptions,
   * Channel)}
   */
  @Test
  @DisplayName("Test interceptCall(MethodDescriptor, CallOptions, Channel)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClientCall EventLoopInterceptor.interceptCall(MethodDescriptor, CallOptions, Channel)"
  })
  void testInterceptCall3() {
    // Arrange
    EventLoopInterceptor eventLoopInterceptor =
        new EventLoopInterceptor(new DefaultEventLoop(), false, false);
    MethodDescriptor<Object, Object> method = mock(MethodDescriptor.class);
    CallOptions options = mock(CallOptions.class);

    Channel channel = mock(Channel.class);
    when(channel.newCall(
            Mockito.<MethodDescriptor<Object, Object>>any(), Mockito.<CallOptions>any()))
        .thenReturn(mock(ClientCall.class));

    // Act
    ClientCall<Object, Object> actualInterceptCallResult =
        eventLoopInterceptor.interceptCall(method, options, channel);

    // Assert
    verify(channel).newCall(isA(MethodDescriptor.class), isA(CallOptions.class));
    assertNull(actualInterceptCallResult.getAttributes());
    assertFalse(actualInterceptCallResult.isReady());
  }

  /**
   * Test {@link EventLoopInterceptor#interceptCall(MethodDescriptor, CallOptions, Channel)}.
   *
   * <ul>
   *   <li>Given {@link ETracInternal#ETracInternal(String)} with message is {@code Not all who
   *       wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link EventLoopInterceptor#interceptCall(MethodDescriptor, CallOptions,
   * Channel)}
   */
  @Test
  @DisplayName(
      "Test interceptCall(MethodDescriptor, CallOptions, Channel); given ETracInternal(String) with message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClientCall EventLoopInterceptor.interceptCall(MethodDescriptor, CallOptions, Channel)"
  })
  void testInterceptCall_givenETracInternalWithMessageIsNotAllWhoWanderAreLost() {
    // Arrange
    EventLoopInterceptor eventLoopInterceptor =
        new EventLoopInterceptor(new DefaultEventLoop(), false, true);
    MethodDescriptor<Object, Object> method = mock(MethodDescriptor.class);
    CallOptions options = mock(CallOptions.class);

    Channel channel = mock(Channel.class);
    when(channel.newCall(
            Mockito.<MethodDescriptor<Object, Object>>any(), Mockito.<CallOptions>any()))
        .thenThrow(new ETracInternal("Not all who wander are lost"));

    // Act and Assert
    assertThrows(
        ETracInternal.class, () -> eventLoopInterceptor.interceptCall(method, options, channel));
    verify(channel).newCall(isA(MethodDescriptor.class), isA(CallOptions.class));
  }

  /**
   * Test {@link EventLoopInterceptor#interceptCall(MethodDescriptor, CallOptions, Channel)}.
   *
   * <ul>
   *   <li>Given {@link EventLoopInterceptor#EventLoopInterceptor(EventExecutorGroup)} with
   *       eventLoopGroup is {@link DefaultEventLoop#DefaultEventLoop()}.
   * </ul>
   *
   * <p>Method under test: {@link EventLoopInterceptor#interceptCall(MethodDescriptor, CallOptions,
   * Channel)}
   */
  @Test
  @DisplayName(
      "Test interceptCall(MethodDescriptor, CallOptions, Channel); given EventLoopInterceptor(EventExecutorGroup) with eventLoopGroup is DefaultEventLoop()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClientCall EventLoopInterceptor.interceptCall(MethodDescriptor, CallOptions, Channel)"
  })
  void testInterceptCall_givenEventLoopInterceptorWithEventLoopGroupIsDefaultEventLoop() {
    // Arrange, Act and Assert
    assertThrows(
        ETracInternal.class,
        () ->
            new EventLoopInterceptor(new DefaultEventLoop())
                .interceptCall(
                    mock(MethodDescriptor.class), mock(CallOptions.class), mock(Channel.class)));
  }

  /**
   * Test {@link EventLoopInterceptor#interceptCall(MethodDescriptor, CallOptions, Channel)}.
   *
   * <ul>
   *   <li>Then return Attributes is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EventLoopInterceptor#interceptCall(MethodDescriptor, CallOptions,
   * Channel)}
   */
  @Test
  @DisplayName(
      "Test interceptCall(MethodDescriptor, CallOptions, Channel); then return Attributes is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClientCall EventLoopInterceptor.interceptCall(MethodDescriptor, CallOptions, Channel)"
  })
  void testInterceptCall_thenReturnAttributesIsNull() {
    // Arrange
    EventLoopInterceptor eventLoopInterceptor =
        new EventLoopInterceptor(new DefaultEventLoop(), false, true);
    MethodDescriptor<Object, Object> method = mock(MethodDescriptor.class);
    CallOptions options = mock(CallOptions.class);

    Channel channel = mock(Channel.class);
    when(channel.newCall(
            Mockito.<MethodDescriptor<Object, Object>>any(), Mockito.<CallOptions>any()))
        .thenReturn(mock(ClientCall.class));

    // Act
    ClientCall<Object, Object> actualInterceptCallResult =
        eventLoopInterceptor.interceptCall(method, options, channel);

    // Assert
    verify(channel).newCall(isA(MethodDescriptor.class), isA(CallOptions.class));
    assertNull(actualInterceptCallResult.getAttributes());
    assertFalse(actualInterceptCallResult.isReady());
  }
}
