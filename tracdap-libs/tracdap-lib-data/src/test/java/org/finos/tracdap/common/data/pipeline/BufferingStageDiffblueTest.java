package org.finos.tracdap.common.data.pipeline;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.function.Consumer;
import org.apache.arrow.memory.ArrowBuf;
import org.finos.tracdap.common.data.DataPipeline;
import org.finos.tracdap.common.data.DataPipeline.BufferApi;
import org.finos.tracdap.common.data.DataPipeline.StreamApi;
import org.finos.tracdap.common.exception.EUnexpected;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BufferingStageDiffblueTest {
  @InjectMocks private BufferingStage bufferingStage;

  @Mock private List<ArrowBuf> list;

  /**
   * Test new {@link BufferingStage} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link BufferingStage}
   */
  @Test
  @DisplayName("Test new BufferingStage (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BufferingStage.<init>()"})
  void testNewBufferingStage() {
    // Arrange and Act
    BufferingStage actualBufferingStage = new BufferingStage();

    // Assert
    assertFalse(actualBufferingStage.isDone());
    assertTrue(actualBufferingStage.isReady());
    Class<BufferApi> expectedConsumerTypeResult = BufferApi.class;
    assertEquals(expectedConsumerTypeResult, actualBufferingStage.consumerType());
  }

  /**
   * Test {@link BufferingStage#dataInterface()}.
   *
   * <p>Method under test: {@link BufferingStage#dataInterface()}
   */
  @Test
  @DisplayName("Test dataInterface()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataPipeline.StreamApi BufferingStage.dataInterface()"})
  void testDataInterface() {
    // Arrange
    BufferingStage bufferingStage = new BufferingStage();

    // Act
    StreamApi actualDataInterfaceResult = bufferingStage.dataInterface();

    // Assert
    assertSame(bufferingStage, actualDataInterfaceResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BufferingStage#pump()}
   *   <li>{@link BufferingStage#isReady()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BufferingStage.isReady()", "void BufferingStage.pump()"})
  void testGettersAndSetters() {
    // Arrange
    BufferingStage bufferingStage = new BufferingStage();

    // Act
    bufferingStage.pump();

    // Assert
    assertTrue(bufferingStage.isReady());
  }

  /**
   * Test {@link BufferingStage#onStart()}.
   *
   * <p>Method under test: {@link BufferingStage#onStart()}
   */
  @Test
  @DisplayName("Test onStart()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BufferingStage.onStart()"})
  void testOnStart() {
    // Arrange, Act and Assert
    assertThrows(EUnexpected.class, () -> bufferingStage.onStart());
  }

  /**
   * Test {@link BufferingStage#onNext(ArrowBuf)}.
   *
   * <ul>
   *   <li>Given {@link List} {@link List#add(Object)} return {@code true}.
   *   <li>When {@code null}.
   *   <li>Then calls {@link List#add(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link BufferingStage#onNext(ArrowBuf)}
   */
  @Test
  @DisplayName(
      "Test onNext(ArrowBuf); given List add(Object) return 'true'; when 'null'; then calls add(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BufferingStage.onNext(ArrowBuf)"})
  void testOnNext_givenListAddReturnTrue_whenNull_thenCallsAdd() {
    // Arrange
    when(list.add(Mockito.<ArrowBuf>any())).thenReturn(true);

    // Act
    bufferingStage.onNext(null);

    // Assert
    verify(list).add(isNull());
  }

  /**
   * Test {@link BufferingStage#close()}.
   *
   * <ul>
   *   <li>Given {@link List} {@link List#forEach(Consumer)} does nothing.
   *   <li>Then calls {@link List#forEach(Consumer)}.
   * </ul>
   *
   * <p>Method under test: {@link BufferingStage#close()}
   */
  @Test
  @DisplayName(
      "Test close(); given List forEach(Consumer) does nothing; then calls forEach(Consumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BufferingStage.close()"})
  void testClose_givenListForEachDoesNothing_thenCallsForEach() {
    // Arrange
    doNothing().when(list).forEach(Mockito.<Consumer<ArrowBuf>>any());

    // Act
    bufferingStage.close();

    // Assert
    verify(list).forEach(isA(Consumer.class));
  }
}
