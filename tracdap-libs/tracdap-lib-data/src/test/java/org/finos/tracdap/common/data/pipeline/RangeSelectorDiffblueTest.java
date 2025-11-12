package org.finos.tracdap.common.data.pipeline;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.arrow.vector.types.pojo.ArrowType;
import org.apache.arrow.vector.types.pojo.ArrowType.Bool;
import org.apache.arrow.vector.types.pojo.ArrowType.Int;
import org.apache.arrow.vector.types.pojo.DictionaryEncoding;
import org.apache.arrow.vector.types.pojo.Field;
import org.apache.arrow.vector.types.pojo.FieldType;
import org.apache.arrow.vector.types.pojo.Schema;
import org.finos.tracdap.common.data.DataPipeline;
import org.finos.tracdap.common.data.DataPipeline.ArrowApi;
import org.finos.tracdap.common.exception.EUnexpected;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RangeSelectorDiffblueTest {
  /**
   * Test {@link RangeSelector#RangeSelector(long, long)}.
   *
   * <p>Method under test: {@link RangeSelector#RangeSelector(long, long)}
   */
  @Test
  @DisplayName("Test new RangeSelector(long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RangeSelector.<init>(long, long)"})
  void testNewRangeSelector() {
    // Arrange and Act
    RangeSelector actualRangeSelector = new RangeSelector(1L, 1L);

    // Assert
    assertFalse(actualRangeSelector.isDone());
    Class<ArrowApi> expectedConsumerTypeResult = ArrowApi.class;
    assertEquals(expectedConsumerTypeResult, actualRangeSelector.consumerType());
  }

  /**
   * Test {@link RangeSelector#dataInterface()}.
   *
   * <p>Method under test: {@link RangeSelector#dataInterface()}
   */
  @Test
  @DisplayName("Test dataInterface()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataPipeline.ArrowApi RangeSelector.dataInterface()"})
  void testDataInterface() {
    // Arrange
    RangeSelector rangeSelector = new RangeSelector(1L, 1L);

    // Act
    ArrowApi actualDataInterfaceResult = rangeSelector.dataInterface();

    // Assert
    assertSame(rangeSelector, actualDataInterfaceResult);
  }

  /**
   * Test {@link RangeSelector#onStart(VectorSchemaRoot)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link RangeSelector#onStart(VectorSchemaRoot)}
   */
  @Test
  @DisplayName("Test onStart(VectorSchemaRoot); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RangeSelector.onStart(VectorSchemaRoot)"})
  void testOnStart_thenThrowIllegalArgumentException() {
    // Arrange
    RangeSelector rangeSelector = new RangeSelector(1L, 1L);

    ArrayList<Field> fieldList = new ArrayList<>();
    FieldType fieldType =
        new FieldType(true, Bool.INSTANCE, new DictionaryEncoding(1L, true, new Int(1, true)));
    Field field = new Field("Name", fieldType, new ArrayList<>());
    fieldList.add(field);

    Schema schema = mock(Schema.class);
    when(schema.getFields()).thenReturn(fieldList);

    VectorSchemaRoot root = mock(VectorSchemaRoot.class);
    when(root.getFieldVectors()).thenReturn(new ArrayList<>());
    when(root.getSchema()).thenReturn(schema);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> rangeSelector.onStart(root));
    verify(root).getFieldVectors();
    verify(root).getSchema();
    verify(schema, atLeast(1)).getFields();
  }

  /**
   * Test {@link RangeSelector#onBatch()}.
   *
   * <p>Method under test: {@link RangeSelector#onBatch()}
   */
  @Test
  @DisplayName("Test onBatch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RangeSelector.onBatch()"})
  void testOnBatch() {
    // Arrange, Act and Assert
    assertThrows(EUnexpected.class, () -> new RangeSelector(1L, 1L).onBatch());
  }

  /**
   * Test {@link RangeSelector#onComplete()}.
   *
   * <p>Method under test: {@link RangeSelector#onComplete()}
   */
  @Test
  @DisplayName("Test onComplete()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RangeSelector.onComplete()"})
  void testOnComplete() {
    // Arrange, Act and Assert
    assertThrows(EUnexpected.class, () -> new RangeSelector(1L, 1L).onComplete());
  }

  /**
   * Test {@link RangeSelector#onError(Throwable)}.
   *
   * <p>Method under test: {@link RangeSelector#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RangeSelector.onError(Throwable)"})
  void testOnError() {
    // Arrange
    RangeSelector rangeSelector = new RangeSelector(1L, 1L);

    // Act and Assert
    assertThrows(EUnexpected.class, () -> rangeSelector.onError(new Throwable()));
  }
}
