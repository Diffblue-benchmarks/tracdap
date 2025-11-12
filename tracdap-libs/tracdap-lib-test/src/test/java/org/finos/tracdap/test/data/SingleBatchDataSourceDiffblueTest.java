package org.finos.tracdap.test.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.finos.tracdap.common.data.DataPipeline;
import org.finos.tracdap.common.data.DataPipeline.ArrowApi;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SingleBatchDataSourceDiffblueTest {
  @InjectMocks private SingleBatchDataSource singleBatchDataSource;

  @Mock private VectorSchemaRoot vectorSchemaRoot;

  /**
   * Test {@link SingleBatchDataSource#SingleBatchDataSource(VectorSchemaRoot)}.
   *
   * <p>Method under test: {@link SingleBatchDataSource#SingleBatchDataSource(VectorSchemaRoot)}
   */
  @Test
  @DisplayName("Test new SingleBatchDataSource(VectorSchemaRoot)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SingleBatchDataSource.<init>(VectorSchemaRoot)"})
  void testNewSingleBatchDataSource() {
    // Arrange and Act
    SingleBatchDataSource actualSingleBatchDataSource = new SingleBatchDataSource(vectorSchemaRoot);

    // Assert
    assertFalse(actualSingleBatchDataSource.isDone());
    assertTrue(actualSingleBatchDataSource.isReady());
    Class<ArrowApi> expectedConsumerTypeResult = ArrowApi.class;
    assertEquals(expectedConsumerTypeResult, actualSingleBatchDataSource.consumerType());
  }

  /**
   * Test {@link SingleBatchDataSource#cancel()}.
   *
   * <p>Method under test: {@link SingleBatchDataSource#cancel()}
   */
  @Test
  @DisplayName("Test cancel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SingleBatchDataSource.cancel()"})
  void testCancel() {
    // Arrange and Act
    singleBatchDataSource.cancel();

    // Assert
    assertTrue(singleBatchDataSource.isDone());
  }
}
