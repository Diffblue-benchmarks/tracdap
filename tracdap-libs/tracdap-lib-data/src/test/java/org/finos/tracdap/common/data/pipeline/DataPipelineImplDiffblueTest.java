package org.finos.tracdap.common.data.pipeline;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.DefaultEventLoop;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import org.apache.arrow.memory.ArrowBuf;
import org.finos.tracdap.common.async.flow.DelayedSubscriber;
import org.finos.tracdap.common.async.flow.FutureFirstItemSubscriber;
import org.finos.tracdap.common.data.DataPipeline;
import org.finos.tracdap.common.data.DataPipeline.DataStage;
import org.finos.tracdap.common.data.DataPipeline.SinkStage;
import org.finos.tracdap.common.data.DataPipeline.SourceStage;
import org.finos.tracdap.common.data.IDataContext;
import org.finos.tracdap.common.exception.ETracInternal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DataPipelineImplDiffblueTest {
  @InjectMocks private DataPipelineImpl dataPipelineImpl;

  @Mock private IDataContext iDataContext;

  @Mock private SinkStage sinkStage;

  @Mock private SourceStage sourceStage;

  /**
   * Test {@link DataPipelineImpl#execute()}.
   *
   * <p>Method under test: {@link DataPipelineImpl#execute()}
   */
  @Test
  @DisplayName("Test execute()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.concurrent.CompletionStage DataPipelineImpl.execute()"})
  void testExecute() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class, () -> dataPipelineImpl.execute());
  }

  /**
   * Test {@link DataPipelineImpl#pumpData()}.
   *
   * <ul>
   *   <li>Given {@link IDataContext} {@link IDataContext#eventLoopExecutor()} return {@link
   *       DefaultEventLoop#DefaultEventLoop()}.
   * </ul>
   *
   * <p>Method under test: {@link DataPipelineImpl#pumpData()}
   */
  @Test
  @DisplayName("Test pumpData(); given IDataContext eventLoopExecutor() return DefaultEventLoop()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataPipelineImpl.pumpData()"})
  void testPumpData_givenIDataContextEventLoopExecutorReturnDefaultEventLoop() {
    // Arrange
    when(iDataContext.eventLoopExecutor()).thenReturn(new DefaultEventLoop());

    // Act
    dataPipelineImpl.pumpData();

    // Assert
    verify(iDataContext).eventLoopExecutor();
  }

  /**
   * Test {@link DataPipelineImpl#pumpData()}.
   *
   * <ul>
   *   <li>Then throw {@link ETracInternal}.
   * </ul>
   *
   * <p>Method under test: {@link DataPipelineImpl#pumpData()}
   */
  @Test
  @DisplayName("Test pumpData(); then throw ETracInternal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataPipelineImpl.pumpData()"})
  void testPumpData_thenThrowETracInternal() {
    // Arrange
    when(iDataContext.eventLoopExecutor())
        .thenThrow(new ETracInternal("Not all who wander are lost"));

    // Act and Assert
    assertThrows(ETracInternal.class, () -> dataPipelineImpl.pumpData());
    verify(iDataContext).eventLoopExecutor();
  }

  /**
   * Test {@link DataPipelineImpl#forSource(Publisher, IDataContext)} with {@code Publisher}, {@code
   * IDataContext}.
   *
   * <ul>
   *   <li>When {@link Publisher}.
   *   <li>Then return {@link DataPipelineImpl}.
   * </ul>
   *
   * <p>Method under test: {@link DataPipelineImpl#forSource(Publisher, IDataContext)}
   */
  @Test
  @DisplayName(
      "Test forSource(Publisher, IDataContext) with 'Publisher', 'IDataContext'; when Publisher; then return DataPipelineImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataPipeline DataPipelineImpl.forSource(Publisher, IDataContext)"})
  void testForSourceWithPublisherIDataContext_whenPublisher_thenReturnDataPipelineImpl() {
    // Arrange, Act and Assert
    assertTrue(
        DataPipelineImpl.forSource(mock(Publisher.class), iDataContext)
            instanceof DataPipelineImpl);
  }

  /**
   * Test {@link DataPipelineImpl#forSource(SourceStage, IDataContext)} with {@code SourceStage},
   * {@code IDataContext}.
   *
   * <p>Method under test: {@link DataPipelineImpl#forSource(DataPipeline.SourceStage,
   * IDataContext)}
   */
  @Test
  @DisplayName("Test forSource(SourceStage, IDataContext) with 'SourceStage', 'IDataContext'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataPipeline DataPipelineImpl.forSource(DataPipeline.SourceStage, IDataContext)"
  })
  void testForSourceWithSourceStageIDataContext() {
    // Arrange, Act and Assert
    assertTrue(DataPipelineImpl.forSource(sourceStage, iDataContext) instanceof DataPipelineImpl);
  }

  /**
   * Test {@link DataPipelineImpl#addStage(DataStage)}.
   *
   * <p>Method under test: {@link DataPipelineImpl#addStage(DataStage)}
   */
  @Test
  @DisplayName("Test addStage(DataStage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataPipeline DataPipelineImpl.addStage(DataStage)"})
  void testAddStage() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class, () -> dataPipelineImpl.addStage(new BufferingStage()));
  }

  /**
   * Test {@link DataPipelineImpl#addSink(SinkStage)} with {@code SinkStage}.
   *
   * <p>Method under test: {@link DataPipelineImpl#addSink(SinkStage)}
   */
  @Test
  @DisplayName("Test addSink(SinkStage) with 'SinkStage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataPipeline DataPipelineImpl.addSink(SinkStage)"})
  void testAddSinkWithSinkStage() {
    // Arrange, Act and Assert
    assertThrows(ETracInternal.class, () -> dataPipelineImpl.addSink(sinkStage));
  }

  /**
   * Test {@link DataPipelineImpl#addSink(Subscriber)} with {@code Subscriber}.
   *
   * <p>Method under test: {@link DataPipelineImpl#addSink(Subscriber)}
   */
  @Test
  @DisplayName("Test addSink(Subscriber) with 'Subscriber'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataPipeline DataPipelineImpl.addSink(Subscriber)"})
  void testAddSinkWithSubscriber() {
    // Arrange
    FutureFirstItemSubscriber<ArrowBuf> subscriber =
        new FutureFirstItemSubscriber<>(new CompletableFuture<>());
    DelayedSubscriber<ArrowBuf> sink =
        new DelayedSubscriber<>(subscriber, new CompletableFuture<>());

    // Act and Assert
    assertThrows(ETracInternal.class, () -> dataPipelineImpl.addSink(sink));
  }
}
