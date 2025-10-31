package org.finos.tracdap.common.storage.local;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.netty.util.concurrent.DefaultEventExecutor;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Flow;
import java.util.concurrent.ThreadFactory;
import org.finos.tracdap.test.grpc.GrpcTestStreams;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LocalFileWriterDiffblueTest {
  /**
   * Method under test: {@link LocalFileWriter#onSubscribe(Flow.Subscription)}
   */
  @Test
  void testOnSubscribe() {
    // Arrange
    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
    DefaultEventExecutor executor = new DefaultEventExecutor(threadFactory);
    Path absolutePath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    CompletableFuture<Long> signal = new CompletableFuture<>();
    LocalFileWriter localFileWriter = new LocalFileWriter("Storage Path", absolutePath, signal, executor,
        new LocalStorageErrors("Storage Key"));

    // Act
    localFileWriter.onSubscribe(new GrpcTestStreams.ClientResponseStream.Subscription());

    // Assert
    verify(threadFactory).newThread(isA(Runnable.class));
  }

  /**
   * Method under test: {@link LocalFileWriter#onComplete()}
   */
  @Test
  void testOnComplete() {
    // Arrange
    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
    DefaultEventExecutor executor = new DefaultEventExecutor(threadFactory);
    Path absolutePath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    CompletableFuture<Long> signal = new CompletableFuture<>();

    // Act
    (new LocalFileWriter("Storage Path", absolutePath, signal, executor, new LocalStorageErrors("Storage Key")))
        .onComplete();

    // Assert
    verify(threadFactory).newThread(isA(Runnable.class));
  }

  /**
   * Method under test: {@link LocalFileWriter#onError(Throwable)}
   */
  @Test
  void testOnError() {
    // Arrange
    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
    DefaultEventExecutor executor = new DefaultEventExecutor(threadFactory);
    Path absolutePath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    CompletableFuture<Long> signal = new CompletableFuture<>();
    LocalFileWriter localFileWriter = new LocalFileWriter("Storage Path", absolutePath, signal, executor,
        new LocalStorageErrors("Storage Key"));

    // Act
    localFileWriter.onError(new Throwable());

    // Assert
    verify(threadFactory).newThread(isA(Runnable.class));
  }
}
