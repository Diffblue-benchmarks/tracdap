package org.finos.tracdap.common.data.pipeline;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.tracdap.common.data.DataPipeline;
import org.finos.tracdap.common.data.DataPipeline.StreamApi;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ElasticBufferDiffblueTest {
  /**
   * Test new {@link ElasticBuffer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ElasticBuffer}
   */
  @Test
  @DisplayName("Test new ElasticBuffer (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElasticBuffer.<init>()"})
  void testNewElasticBuffer() {
    // Arrange and Act
    ElasticBuffer actualElasticBuffer = new ElasticBuffer();

    // Assert
    assertFalse(actualElasticBuffer.isDone());
    assertTrue(actualElasticBuffer.isReady());
    Class<StreamApi> expectedConsumerTypeResult = StreamApi.class;
    assertEquals(expectedConsumerTypeResult, actualElasticBuffer.consumerType());
  }

  /**
   * Test {@link ElasticBuffer#dataInterface()}.
   *
   * <p>Method under test: {@link ElasticBuffer#dataInterface()}
   */
  @Test
  @DisplayName("Test dataInterface()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataPipeline.StreamApi ElasticBuffer.dataInterface()"})
  void testDataInterface() {
    // Arrange
    ElasticBuffer elasticBuffer = new ElasticBuffer();

    // Act
    StreamApi actualDataInterfaceResult = elasticBuffer.dataInterface();

    // Assert
    assertSame(elasticBuffer, actualDataInterfaceResult);
  }

  /**
   * Test {@link ElasticBuffer#isReady()}.
   *
   * <p>Method under test: {@link ElasticBuffer#isReady()}
   */
  @Test
  @DisplayName("Test isReady()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElasticBuffer.isReady()"})
  void testIsReady() {
    // Arrange, Act and Assert
    assertTrue(new ElasticBuffer().isReady());
  }
}
