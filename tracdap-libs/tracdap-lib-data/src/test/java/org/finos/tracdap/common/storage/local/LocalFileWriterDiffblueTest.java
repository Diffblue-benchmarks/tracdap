package org.finos.tracdap.common.storage.local;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.DefaultEventLoop;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;
import org.apache.arrow.memory.ArrowBuf;
import org.finos.tracdap.common.exception.EUnexpected;
import org.finos.tracdap.common.storage.StorageErrors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LocalFileWriterDiffblueTest {
  /**
   * Test {@link LocalFileWriter#writeChunkComplete(Integer, ArrowBuf)}.
   *
   * <p>Method under test: {@link LocalFileWriter#writeChunkComplete(Integer, ArrowBuf)}
   */
  @Test
  @DisplayName("Test writeChunkComplete(Integer, ArrowBuf)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalFileWriter.writeChunkComplete(Integer, ArrowBuf)"})
  void testWriteChunkComplete() {
    // Arrange
    Path absolutePath = Paths.get(System.getProperty("java.io.tmpdir"));
    CompletableFuture<Long> signal = new CompletableFuture<>();
    DefaultEventLoop executor = new DefaultEventLoop();

    LocalFileWriter localFileWriter =
        new LocalFileWriter(
            "Storage Path", absolutePath, signal, executor, new LocalStorageErrors("Storage Key"));

    ArrowBuf chunk = mock(ArrowBuf.class);
    when(chunk.capacity()).thenReturn(0L);
    when(chunk.refCnt()).thenReturn(1);
    when(chunk.readableBytes()).thenReturn(1L);
    doNothing().when(chunk).close();

    // Act
    localFileWriter.writeChunkComplete(19088743, chunk);

    // Assert
    verify(chunk).capacity();
    verify(chunk).close();
    verify(chunk).readableBytes();
    verify(chunk).refCnt();
  }

  /**
   * Test {@link LocalFileWriter#writeChunkComplete(Integer, ArrowBuf)}.
   *
   * <p>Method under test: {@link LocalFileWriter#writeChunkComplete(Integer, ArrowBuf)}
   */
  @Test
  @DisplayName("Test writeChunkComplete(Integer, ArrowBuf)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalFileWriter.writeChunkComplete(Integer, ArrowBuf)"})
  void testWriteChunkComplete2() {
    // Arrange
    StorageErrors errors = mock(StorageErrors.class);
    when(errors.handleException(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<Throwable>any()))
        .thenThrow(new IllegalStateException());
    Path absolutePath = Paths.get(System.getProperty("java.io.tmpdir"));
    CompletableFuture<Long> signal = new CompletableFuture<>();

    LocalFileWriter localFileWriter =
        new LocalFileWriter("Storage Path", absolutePath, signal, new DefaultEventLoop(), errors);

    ArrowBuf chunk = mock(ArrowBuf.class);
    when(chunk.capacity()).thenReturn(0L);
    when(chunk.refCnt()).thenReturn(1);
    when(chunk.readableBytes()).thenReturn(1L);
    doNothing().when(chunk).close();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> localFileWriter.writeChunkComplete(1, chunk));
    verify(chunk).capacity();
    verify(chunk).close();
    verify(chunk).readableBytes();
    verify(chunk).refCnt();
    verify(errors).handleException(eq("WRITE"), eq("Storage Path"), isA(Throwable.class));
  }

  /**
   * Test {@link LocalFileWriter#writeChunkComplete(Integer, ArrowBuf)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link LocalFileWriter#writeChunkComplete(Integer, ArrowBuf)}
   */
  @Test
  @DisplayName("Test writeChunkComplete(Integer, ArrowBuf); given IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalFileWriter.writeChunkComplete(Integer, ArrowBuf)"})
  void testWriteChunkComplete_givenIllegalStateException() {
    // Arrange
    Path absolutePath = Paths.get(System.getProperty("java.io.tmpdir"));
    CompletableFuture<Long> signal = new CompletableFuture<>();
    DefaultEventLoop executor = new DefaultEventLoop();

    LocalFileWriter localFileWriter =
        new LocalFileWriter(
            "Storage Path", absolutePath, signal, executor, new LocalStorageErrors("Storage Key"));

    ArrowBuf chunk = mock(ArrowBuf.class);
    when(chunk.capacity()).thenThrow(new IllegalStateException());
    when(chunk.refCnt()).thenReturn(1);
    when(chunk.readableBytes()).thenReturn(1L);
    doNothing().when(chunk).close();

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> localFileWriter.writeChunkComplete(19088743, chunk));
    verify(chunk).capacity();
    verify(chunk).close();
    verify(chunk).readableBytes();
    verify(chunk).refCnt();
  }

  /**
   * Test {@link LocalFileWriter#writeChunkComplete(Integer, ArrowBuf)}.
   *
   * <ul>
   *   <li>Given {@link StorageErrors} {@link StorageErrors#chunkNotFullyWritten(long, long)} return
   *       {@link EUnexpected#EUnexpected()}.
   * </ul>
   *
   * <p>Method under test: {@link LocalFileWriter#writeChunkComplete(Integer, ArrowBuf)}
   */
  @Test
  @DisplayName(
      "Test writeChunkComplete(Integer, ArrowBuf); given StorageErrors chunkNotFullyWritten(long, long) return EUnexpected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalFileWriter.writeChunkComplete(Integer, ArrowBuf)"})
  void testWriteChunkComplete_givenStorageErrorsChunkNotFullyWrittenReturnEUnexpected() {
    // Arrange
    StorageErrors errors = mock(StorageErrors.class);
    when(errors.chunkNotFullyWritten(anyLong(), anyLong())).thenReturn(new EUnexpected());
    when(errors.handleException(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<Throwable>any()))
        .thenReturn(new EUnexpected());
    Path absolutePath = Paths.get(System.getProperty("java.io.tmpdir"));
    CompletableFuture<Long> signal = new CompletableFuture<>();

    LocalFileWriter localFileWriter =
        new LocalFileWriter("Storage Path", absolutePath, signal, new DefaultEventLoop(), errors);

    ArrowBuf chunk = mock(ArrowBuf.class);
    when(chunk.capacity()).thenReturn(0L);
    when(chunk.refCnt()).thenReturn(1);
    when(chunk.readableBytes()).thenReturn(1L);
    doNothing().when(chunk).close();

    // Act
    localFileWriter.writeChunkComplete(19088743, chunk);

    // Assert
    verify(chunk).capacity();
    verify(chunk).close();
    verify(chunk).readableBytes();
    verify(chunk).refCnt();
    verify(errors).chunkNotFullyWritten(1L, 19088743L);
    verify(errors).handleException(eq("WRITE"), eq("Storage Path"), isA(Throwable.class));
  }

  /**
   * Test {@link LocalFileWriter#writeChunkComplete(Integer, ArrowBuf)}.
   *
   * <ul>
   *   <li>Given {@link StorageErrors} {@link StorageErrors#chunkNotFullyWritten(long, long)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LocalFileWriter#writeChunkComplete(Integer, ArrowBuf)}
   */
  @Test
  @DisplayName(
      "Test writeChunkComplete(Integer, ArrowBuf); given StorageErrors chunkNotFullyWritten(long, long) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalFileWriter.writeChunkComplete(Integer, ArrowBuf)"})
  void testWriteChunkComplete_givenStorageErrorsChunkNotFullyWrittenReturnNull() {
    // Arrange
    StorageErrors errors = mock(StorageErrors.class);
    when(errors.chunkNotFullyWritten(anyLong(), anyLong())).thenReturn(null);
    when(errors.handleException(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<Throwable>any()))
        .thenReturn(new EUnexpected());
    Path absolutePath = Paths.get(System.getProperty("java.io.tmpdir"));
    CompletableFuture<Long> signal = new CompletableFuture<>();

    LocalFileWriter localFileWriter =
        new LocalFileWriter("Storage Path", absolutePath, signal, new DefaultEventLoop(), errors);

    ArrowBuf chunk = mock(ArrowBuf.class);
    when(chunk.capacity()).thenReturn(0L);
    when(chunk.refCnt()).thenReturn(1);
    when(chunk.readableBytes()).thenReturn(1L);
    doNothing().when(chunk).close();

    // Act
    localFileWriter.writeChunkComplete(19088743, chunk);

    // Assert
    verify(chunk).capacity();
    verify(chunk).close();
    verify(chunk).readableBytes();
    verify(chunk).refCnt();
    verify(errors).chunkNotFullyWritten(1L, 19088743L);
    verify(errors).handleException(eq("WRITE"), eq("Storage Path"), isNull());
  }

  /**
   * Test {@link LocalFileWriter#writeChunkComplete(Integer, ArrowBuf)}.
   *
   * <ul>
   *   <li>When {@link ArrowBuf} {@link ArrowBuf#capacity()} return one.
   * </ul>
   *
   * <p>Method under test: {@link LocalFileWriter#writeChunkComplete(Integer, ArrowBuf)}
   */
  @Test
  @DisplayName("Test writeChunkComplete(Integer, ArrowBuf); when ArrowBuf capacity() return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalFileWriter.writeChunkComplete(Integer, ArrowBuf)"})
  void testWriteChunkComplete_whenArrowBufCapacityReturnOne() {
    // Arrange
    Path absolutePath = Paths.get(System.getProperty("java.io.tmpdir"));
    CompletableFuture<Long> signal = new CompletableFuture<>();
    DefaultEventLoop executor = new DefaultEventLoop();

    LocalFileWriter localFileWriter =
        new LocalFileWriter(
            "Storage Path", absolutePath, signal, executor, new LocalStorageErrors("Storage Key"));

    ArrowBuf chunk = mock(ArrowBuf.class);
    when(chunk.capacity()).thenReturn(1L);
    when(chunk.refCnt()).thenReturn(1);
    when(chunk.readableBytes()).thenReturn(1L);
    doNothing().when(chunk).close();

    // Act
    localFileWriter.writeChunkComplete(19088743, chunk);

    // Assert
    verify(chunk).capacity();
    verify(chunk).close();
    verify(chunk).readableBytes();
    verify(chunk).refCnt();
  }

  /**
   * Test {@link LocalFileWriter#writeChunkComplete(Integer, ArrowBuf)}.
   *
   * <ul>
   *   <li>When {@link ArrowBuf} {@link ArrowBuf#refCnt()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link LocalFileWriter#writeChunkComplete(Integer, ArrowBuf)}
   */
  @Test
  @DisplayName("Test writeChunkComplete(Integer, ArrowBuf); when ArrowBuf refCnt() return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalFileWriter.writeChunkComplete(Integer, ArrowBuf)"})
  void testWriteChunkComplete_whenArrowBufRefCntReturnZero() {
    // Arrange
    Path absolutePath = Paths.get(System.getProperty("java.io.tmpdir"));
    CompletableFuture<Long> signal = new CompletableFuture<>();
    DefaultEventLoop executor = new DefaultEventLoop();

    LocalFileWriter localFileWriter =
        new LocalFileWriter(
            "Storage Path", absolutePath, signal, executor, new LocalStorageErrors("Storage Key"));

    ArrowBuf chunk = mock(ArrowBuf.class);
    when(chunk.refCnt()).thenReturn(0);
    when(chunk.readableBytes()).thenReturn(1L);
    doNothing().when(chunk).close();

    // Act
    localFileWriter.writeChunkComplete(19088743, chunk);

    // Assert
    verify(chunk).close();
    verify(chunk).readableBytes();
    verify(chunk).refCnt();
  }

  /**
   * Test {@link LocalFileWriter#writeChunkFailed(Throwable, ArrowBuf)}.
   *
   * <p>Method under test: {@link LocalFileWriter#writeChunkFailed(Throwable, ArrowBuf)}
   */
  @Test
  @DisplayName("Test writeChunkFailed(Throwable, ArrowBuf)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalFileWriter.writeChunkFailed(Throwable, ArrowBuf)"})
  void testWriteChunkFailed() {
    // Arrange
    Path absolutePath = Paths.get(System.getProperty("java.io.tmpdir"));
    CompletableFuture<Long> signal = new CompletableFuture<>();
    DefaultEventLoop executor = new DefaultEventLoop();

    LocalFileWriter localFileWriter =
        new LocalFileWriter(
            "Storage Path", absolutePath, signal, executor, new LocalStorageErrors("Storage Key"));
    Throwable error = new Throwable();

    ArrowBuf chunk = mock(ArrowBuf.class);
    when(chunk.capacity()).thenReturn(0L);
    when(chunk.refCnt()).thenReturn(1);
    doNothing().when(chunk).close();

    // Act
    localFileWriter.writeChunkFailed(error, chunk);

    // Assert
    verify(chunk).capacity();
    verify(chunk).close();
    verify(chunk).refCnt();
  }

  /**
   * Test {@link LocalFileWriter#writeChunkFailed(Throwable, ArrowBuf)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link LocalFileWriter#writeChunkFailed(Throwable, ArrowBuf)}
   */
  @Test
  @DisplayName(
      "Test writeChunkFailed(Throwable, ArrowBuf); given IllegalStateException(); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalFileWriter.writeChunkFailed(Throwable, ArrowBuf)"})
  void testWriteChunkFailed_givenIllegalStateException_thenThrowIllegalStateException() {
    // Arrange
    Path absolutePath = Paths.get(System.getProperty("java.io.tmpdir"));
    CompletableFuture<Long> signal = new CompletableFuture<>();
    DefaultEventLoop executor = new DefaultEventLoop();

    LocalFileWriter localFileWriter =
        new LocalFileWriter(
            "Storage Path", absolutePath, signal, executor, new LocalStorageErrors("Storage Key"));
    Throwable error = new Throwable();

    ArrowBuf chunk = mock(ArrowBuf.class);
    when(chunk.capacity()).thenThrow(new IllegalStateException());
    when(chunk.refCnt()).thenReturn(1);
    doNothing().when(chunk).close();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> localFileWriter.writeChunkFailed(error, chunk));
    verify(chunk).capacity();
    verify(chunk).close();
    verify(chunk).refCnt();
  }

  /**
   * Test {@link LocalFileWriter#writeChunkFailed(Throwable, ArrowBuf)}.
   *
   * <ul>
   *   <li>Then calls {@link StorageErrors#handleException(String, String, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link LocalFileWriter#writeChunkFailed(Throwable, ArrowBuf)}
   */
  @Test
  @DisplayName(
      "Test writeChunkFailed(Throwable, ArrowBuf); then calls handleException(String, String, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalFileWriter.writeChunkFailed(Throwable, ArrowBuf)"})
  void testWriteChunkFailed_thenCallsHandleException() {
    // Arrange
    StorageErrors errors = mock(StorageErrors.class);
    when(errors.handleException(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<Throwable>any()))
        .thenReturn(new EUnexpected());
    Path absolutePath = Paths.get(System.getProperty("java.io.tmpdir"));
    CompletableFuture<Long> signal = new CompletableFuture<>();

    LocalFileWriter localFileWriter =
        new LocalFileWriter("Storage Path", absolutePath, signal, new DefaultEventLoop(), errors);
    Throwable error = new Throwable();

    ArrowBuf chunk = mock(ArrowBuf.class);
    when(chunk.capacity()).thenReturn(0L);
    when(chunk.refCnt()).thenReturn(1);
    doNothing().when(chunk).close();

    // Act
    localFileWriter.writeChunkFailed(error, chunk);

    // Assert
    verify(chunk).capacity();
    verify(chunk).close();
    verify(chunk).refCnt();
    verify(errors).handleException(eq("WRITE"), eq("Storage Path"), isA(Throwable.class));
  }

  /**
   * Test {@link LocalFileWriter#writeChunkFailed(Throwable, ArrowBuf)}.
   *
   * <ul>
   *   <li>Then calls {@link StorageErrors#handleException(String, String, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link LocalFileWriter#writeChunkFailed(Throwable, ArrowBuf)}
   */
  @Test
  @DisplayName(
      "Test writeChunkFailed(Throwable, ArrowBuf); then calls handleException(String, String, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalFileWriter.writeChunkFailed(Throwable, ArrowBuf)"})
  void testWriteChunkFailed_thenCallsHandleException2() {
    // Arrange
    StorageErrors errors = mock(StorageErrors.class);
    when(errors.handleException(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<Throwable>any()))
        .thenReturn(new EUnexpected());
    Path absolutePath = Paths.get(System.getProperty("java.io.tmpdir"));
    CompletableFuture<Long> signal = new CompletableFuture<>();

    LocalFileWriter localFileWriter =
        new LocalFileWriter("Storage Path", absolutePath, signal, new DefaultEventLoop(), errors);

    ArrowBuf chunk = mock(ArrowBuf.class);
    when(chunk.capacity()).thenReturn(0L);
    when(chunk.refCnt()).thenReturn(1);
    doNothing().when(chunk).close();

    // Act
    localFileWriter.writeChunkFailed(null, chunk);

    // Assert
    verify(chunk).capacity();
    verify(chunk).close();
    verify(chunk).refCnt();
    verify(errors).handleException(eq("WRITE"), eq("Storage Path"), isNull());
  }

  /**
   * Test {@link LocalFileWriter#writeChunkFailed(Throwable, ArrowBuf)}.
   *
   * <ul>
   *   <li>When {@link ArrowBuf} {@link ArrowBuf#capacity()} return one.
   * </ul>
   *
   * <p>Method under test: {@link LocalFileWriter#writeChunkFailed(Throwable, ArrowBuf)}
   */
  @Test
  @DisplayName("Test writeChunkFailed(Throwable, ArrowBuf); when ArrowBuf capacity() return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalFileWriter.writeChunkFailed(Throwable, ArrowBuf)"})
  void testWriteChunkFailed_whenArrowBufCapacityReturnOne() {
    // Arrange
    Path absolutePath = Paths.get(System.getProperty("java.io.tmpdir"));
    CompletableFuture<Long> signal = new CompletableFuture<>();
    DefaultEventLoop executor = new DefaultEventLoop();

    LocalFileWriter localFileWriter =
        new LocalFileWriter(
            "Storage Path", absolutePath, signal, executor, new LocalStorageErrors("Storage Key"));
    Throwable error = new Throwable();

    ArrowBuf chunk = mock(ArrowBuf.class);
    when(chunk.capacity()).thenReturn(1L);
    when(chunk.refCnt()).thenReturn(1);
    doNothing().when(chunk).close();

    // Act
    localFileWriter.writeChunkFailed(error, chunk);

    // Assert
    verify(chunk).capacity();
    verify(chunk).close();
    verify(chunk).refCnt();
  }

  /**
   * Test {@link LocalFileWriter#writeChunkFailed(Throwable, ArrowBuf)}.
   *
   * <ul>
   *   <li>When {@link ArrowBuf} {@link ArrowBuf#refCnt()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link LocalFileWriter#writeChunkFailed(Throwable, ArrowBuf)}
   */
  @Test
  @DisplayName("Test writeChunkFailed(Throwable, ArrowBuf); when ArrowBuf refCnt() return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LocalFileWriter.writeChunkFailed(Throwable, ArrowBuf)"})
  void testWriteChunkFailed_whenArrowBufRefCntReturnZero() {
    // Arrange
    Path absolutePath = Paths.get(System.getProperty("java.io.tmpdir"));
    CompletableFuture<Long> signal = new CompletableFuture<>();
    DefaultEventLoop executor = new DefaultEventLoop();

    LocalFileWriter localFileWriter =
        new LocalFileWriter(
            "Storage Path", absolutePath, signal, executor, new LocalStorageErrors("Storage Key"));
    Throwable error = new Throwable();

    ArrowBuf chunk = mock(ArrowBuf.class);
    when(chunk.refCnt()).thenReturn(0);
    doNothing().when(chunk).close();

    // Act
    localFileWriter.writeChunkFailed(error, chunk);

    // Assert
    verify(chunk).close();
    verify(chunk).refCnt();
  }
}
