package org.finos.tracdap.common.middleware;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.Map;
import org.finos.tracdap.common.exception.ETracInternal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CommonConcernsDiffblueTest {
  /**
   * Test {@link CommonConcerns#addFirst(BaseConcern)}.
   * <ul>
   *   <li>Given {@link GrpcConcern} {@link BaseConcern#concernName()} return {@code Concern Name}.</li>
   *   <li>Then throw {@link ETracInternal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonConcerns#addFirst(BaseConcern)}
   */
  @Test
  @DisplayName("Test addFirst(BaseConcern); given GrpcConcern concernName() return 'Concern Name'; then throw ETracInternal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonConcerns CommonConcerns.addFirst(BaseConcern)"})
  void testAddFirst_givenGrpcConcernConcernNameReturnConcernName_thenThrowETracInternal() {
    // Arrange
    GrpcConcern grpcConcern = mock(GrpcConcern.class);
    when(grpcConcern.concernName()).thenReturn("Concern Name");

    CommonGrpcConcerns commonGrpcConcerns = new CommonGrpcConcerns("Concern Name");
    commonGrpcConcerns.addFirst(grpcConcern);
    GrpcConcern grpcConcern2 = mock(GrpcConcern.class);
    when(grpcConcern2.concernName()).thenReturn("Concern Name");

    // Act and Assert
    assertThrows(ETracInternal.class, () -> commonGrpcConcerns.addFirst(grpcConcern2));
    verify(grpcConcern2, atLeast(1)).concernName();
    verify(grpcConcern, atLeast(1)).concernName();
  }

  /**
   * Test {@link CommonConcerns#addFirst(BaseConcern)}.
   * <ul>
   *   <li>Then {@link CommonGrpcConcerns#CommonGrpcConcerns(String)} with {@code Concern Name} {@link CommonConcerns#stageOrder} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonConcerns#addFirst(BaseConcern)}
   */
  @Test
  @DisplayName("Test addFirst(BaseConcern); then CommonGrpcConcerns(String) with 'Concern Name' stageOrder size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonConcerns CommonConcerns.addFirst(BaseConcern)"})
  void testAddFirst_thenCommonGrpcConcernsWithConcernNameStageOrderSizeIsOne() {
    // Arrange
    CommonGrpcConcerns commonGrpcConcerns = new CommonGrpcConcerns("Concern Name");
    GrpcConcern grpcConcern = mock(GrpcConcern.class);
    when(grpcConcern.concernName()).thenReturn("Concern Name");

    // Act
    CommonConcerns<GrpcConcern> actualAddFirstResult = commonGrpcConcerns.addFirst(grpcConcern);

    // Assert
    verify(grpcConcern, atLeast(1)).concernName();
    List<String> stringList = commonGrpcConcerns.stageOrder;
    assertEquals(1, stringList.size());
    assertEquals("Concern Name", stringList.get(0));
    Map<String, GrpcConcern> stringGrpcConcernMap = commonGrpcConcerns.stages;
    assertEquals(1, stringGrpcConcernMap.size());
    assertSame(commonGrpcConcerns, actualAddFirstResult);
    assertSame(grpcConcern, stringGrpcConcernMap.get("Concern Name"));
  }

  /**
   * Test {@link CommonConcerns#addLast(BaseConcern)}.
   * <ul>
   *   <li>Given {@link GrpcConcern} {@link BaseConcern#concernName()} return {@code Concern Name}.</li>
   *   <li>Then throw {@link ETracInternal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonConcerns#addLast(BaseConcern)}
   */
  @Test
  @DisplayName("Test addLast(BaseConcern); given GrpcConcern concernName() return 'Concern Name'; then throw ETracInternal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonConcerns CommonConcerns.addLast(BaseConcern)"})
  void testAddLast_givenGrpcConcernConcernNameReturnConcernName_thenThrowETracInternal() {
    // Arrange
    GrpcConcern grpcConcern = mock(GrpcConcern.class);
    when(grpcConcern.concernName()).thenReturn("Concern Name");

    CommonGrpcConcerns commonGrpcConcerns = new CommonGrpcConcerns("Concern Name");
    commonGrpcConcerns.addFirst(grpcConcern);
    GrpcConcern grpcConcern2 = mock(GrpcConcern.class);
    when(grpcConcern2.concernName()).thenReturn("Concern Name");

    // Act and Assert
    assertThrows(ETracInternal.class, () -> commonGrpcConcerns.addLast(grpcConcern2));
    verify(grpcConcern2, atLeast(1)).concernName();
    verify(grpcConcern, atLeast(1)).concernName();
  }

  /**
   * Test {@link CommonConcerns#addLast(BaseConcern)}.
   * <ul>
   *   <li>Then {@link CommonGrpcConcerns#CommonGrpcConcerns(String)} with {@code Concern Name} {@link CommonConcerns#stageOrder} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonConcerns#addLast(BaseConcern)}
   */
  @Test
  @DisplayName("Test addLast(BaseConcern); then CommonGrpcConcerns(String) with 'Concern Name' stageOrder size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonConcerns CommonConcerns.addLast(BaseConcern)"})
  void testAddLast_thenCommonGrpcConcernsWithConcernNameStageOrderSizeIsOne() {
    // Arrange
    CommonGrpcConcerns commonGrpcConcerns = new CommonGrpcConcerns("Concern Name");
    GrpcConcern grpcConcern = mock(GrpcConcern.class);
    when(grpcConcern.concernName()).thenReturn("Concern Name");

    // Act
    CommonConcerns<GrpcConcern> actualAddLastResult = commonGrpcConcerns.addLast(grpcConcern);

    // Assert
    verify(grpcConcern, atLeast(1)).concernName();
    List<String> stringList = commonGrpcConcerns.stageOrder;
    assertEquals(1, stringList.size());
    assertEquals("Concern Name", stringList.get(0));
    Map<String, GrpcConcern> stringGrpcConcernMap = commonGrpcConcerns.stages;
    assertEquals(1, stringGrpcConcernMap.size());
    assertSame(commonGrpcConcerns, actualAddLastResult);
    assertSame(grpcConcern, stringGrpcConcernMap.get("Concern Name"));
  }

  /**
   * Test {@link CommonConcerns#addBefore(String, BaseConcern)}.
   * <ul>
   *   <li>Given {@link CommonGrpcConcerns#CommonGrpcConcerns(String)} with {@code Concern Name}.</li>
   *   <li>Then throw {@link ETracInternal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonConcerns#addBefore(String, BaseConcern)}
   */
  @Test
  @DisplayName("Test addBefore(String, BaseConcern); given CommonGrpcConcerns(String) with 'Concern Name'; then throw ETracInternal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonConcerns CommonConcerns.addBefore(String, BaseConcern)"})
  void testAddBefore_givenCommonGrpcConcernsWithConcernName_thenThrowETracInternal() {
    // Arrange
    CommonGrpcConcerns commonGrpcConcerns = new CommonGrpcConcerns("Concern Name");
    GrpcConcern grpcConcern = mock(GrpcConcern.class);
    when(grpcConcern.concernName()).thenReturn("Concern Name");

    // Act and Assert
    assertThrows(ETracInternal.class, () -> commonGrpcConcerns.addBefore("Before", grpcConcern));
    verify(grpcConcern).concernName();
  }

  /**
   * Test {@link CommonConcerns#addBefore(String, BaseConcern)}.
   * <ul>
   *   <li>Given {@link GrpcConcern} {@link BaseConcern#concernName()} return {@code Concern Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonConcerns#addBefore(String, BaseConcern)}
   */
  @Test
  @DisplayName("Test addBefore(String, BaseConcern); given GrpcConcern concernName() return 'Concern Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonConcerns CommonConcerns.addBefore(String, BaseConcern)"})
  void testAddBefore_givenGrpcConcernConcernNameReturnConcernName() {
    // Arrange
    GrpcConcern grpcConcern = mock(GrpcConcern.class);
    when(grpcConcern.concernName()).thenReturn("Concern Name");

    CommonGrpcConcerns commonGrpcConcerns = new CommonGrpcConcerns("Concern Name");
    commonGrpcConcerns.addFirst(grpcConcern);
    GrpcConcern grpcConcern2 = mock(GrpcConcern.class);
    when(grpcConcern2.concernName()).thenReturn("Concern Name");

    // Act and Assert
    assertThrows(ETracInternal.class, () -> commonGrpcConcerns.addBefore("Before", grpcConcern2));
    verify(grpcConcern2, atLeast(1)).concernName();
    verify(grpcConcern, atLeast(1)).concernName();
  }

  /**
   * Test {@link CommonConcerns#addBefore(String, BaseConcern)}.
   * <ul>
   *   <li>Then {@link CommonGrpcConcerns#CommonGrpcConcerns(String)} with {@code Concern Name} {@link CommonConcerns#stageOrder} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonConcerns#addBefore(String, BaseConcern)}
   */
  @Test
  @DisplayName("Test addBefore(String, BaseConcern); then CommonGrpcConcerns(String) with 'Concern Name' stageOrder size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonConcerns CommonConcerns.addBefore(String, BaseConcern)"})
  void testAddBefore_thenCommonGrpcConcernsWithConcernNameStageOrderSizeIsTwo() {
    // Arrange
    GrpcConcern grpcConcern = mock(GrpcConcern.class);
    when(grpcConcern.concernName()).thenReturn("42");

    CommonGrpcConcerns commonGrpcConcerns = new CommonGrpcConcerns("Concern Name");
    commonGrpcConcerns.addFirst(grpcConcern);
    GrpcConcern grpcConcern2 = mock(GrpcConcern.class);
    when(grpcConcern2.concernName()).thenReturn("Concern Name");

    // Act
    CommonConcerns<GrpcConcern> actualAddBeforeResult = commonGrpcConcerns.addBefore("42", grpcConcern2);

    // Assert
    verify(grpcConcern, atLeast(1)).concernName();
    verify(grpcConcern2, atLeast(1)).concernName();
    List<String> stringList = commonGrpcConcerns.stageOrder;
    assertEquals(2, stringList.size());
    assertEquals("42", stringList.get(1));
    assertEquals("Concern Name", stringList.get(0));
    Map<String, GrpcConcern> stringGrpcConcernMap = commonGrpcConcerns.stages;
    assertEquals(2, stringGrpcConcernMap.size());
    assertTrue(stringGrpcConcernMap.containsKey("42"));
    assertSame(commonGrpcConcerns, actualAddBeforeResult);
    assertSame(grpcConcern2, stringGrpcConcernMap.get("Concern Name"));
  }

  /**
   * Test {@link CommonConcerns#addAfter(String, BaseConcern)}.
   * <ul>
   *   <li>Given {@link CommonGrpcConcerns#CommonGrpcConcerns(String)} with {@code Concern Name}.</li>
   *   <li>Then throw {@link ETracInternal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonConcerns#addAfter(String, BaseConcern)}
   */
  @Test
  @DisplayName("Test addAfter(String, BaseConcern); given CommonGrpcConcerns(String) with 'Concern Name'; then throw ETracInternal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonConcerns CommonConcerns.addAfter(String, BaseConcern)"})
  void testAddAfter_givenCommonGrpcConcernsWithConcernName_thenThrowETracInternal() {
    // Arrange
    CommonGrpcConcerns commonGrpcConcerns = new CommonGrpcConcerns("Concern Name");
    GrpcConcern grpcConcern = mock(GrpcConcern.class);
    when(grpcConcern.concernName()).thenReturn("Concern Name");

    // Act and Assert
    assertThrows(ETracInternal.class, () -> commonGrpcConcerns.addAfter("After", grpcConcern));
    verify(grpcConcern).concernName();
  }

  /**
   * Test {@link CommonConcerns#addAfter(String, BaseConcern)}.
   * <ul>
   *   <li>Given {@link GrpcConcern} {@link BaseConcern#concernName()} return {@code Concern Name}.</li>
   *   <li>Then throw {@link ETracInternal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonConcerns#addAfter(String, BaseConcern)}
   */
  @Test
  @DisplayName("Test addAfter(String, BaseConcern); given GrpcConcern concernName() return 'Concern Name'; then throw ETracInternal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonConcerns CommonConcerns.addAfter(String, BaseConcern)"})
  void testAddAfter_givenGrpcConcernConcernNameReturnConcernName_thenThrowETracInternal() {
    // Arrange
    GrpcConcern grpcConcern = mock(GrpcConcern.class);
    when(grpcConcern.concernName()).thenReturn("Concern Name");

    CommonGrpcConcerns commonGrpcConcerns = new CommonGrpcConcerns("Concern Name");
    commonGrpcConcerns.addFirst(grpcConcern);
    GrpcConcern grpcConcern2 = mock(GrpcConcern.class);
    when(grpcConcern2.concernName()).thenReturn("Concern Name");

    // Act and Assert
    assertThrows(ETracInternal.class, () -> commonGrpcConcerns.addAfter("After", grpcConcern2));
    verify(grpcConcern2, atLeast(1)).concernName();
    verify(grpcConcern, atLeast(1)).concernName();
  }

  /**
   * Test {@link CommonConcerns#addAfter(String, BaseConcern)}.
   * <ul>
   *   <li>Then {@link CommonGrpcConcerns#CommonGrpcConcerns(String)} with {@code Concern Name} {@link CommonConcerns#stageOrder} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link CommonConcerns#addAfter(String, BaseConcern)}
   */
  @Test
  @DisplayName("Test addAfter(String, BaseConcern); then CommonGrpcConcerns(String) with 'Concern Name' stageOrder size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CommonConcerns CommonConcerns.addAfter(String, BaseConcern)"})
  void testAddAfter_thenCommonGrpcConcernsWithConcernNameStageOrderSizeIsTwo() {
    // Arrange
    GrpcConcern grpcConcern = mock(GrpcConcern.class);
    when(grpcConcern.concernName()).thenReturn("42");

    CommonGrpcConcerns commonGrpcConcerns = new CommonGrpcConcerns("Concern Name");
    commonGrpcConcerns.addFirst(grpcConcern);
    GrpcConcern grpcConcern2 = mock(GrpcConcern.class);
    when(grpcConcern2.concernName()).thenReturn("Concern Name");

    // Act
    CommonConcerns<GrpcConcern> actualAddAfterResult = commonGrpcConcerns.addAfter("42", grpcConcern2);

    // Assert
    verify(grpcConcern, atLeast(1)).concernName();
    verify(grpcConcern2, atLeast(1)).concernName();
    List<String> stringList = commonGrpcConcerns.stageOrder;
    assertEquals(2, stringList.size());
    assertEquals("Concern Name", stringList.get(1));
    Map<String, GrpcConcern> stringGrpcConcernMap = commonGrpcConcerns.stages;
    assertEquals(2, stringGrpcConcernMap.size());
    assertTrue(stringGrpcConcernMap.containsKey("42"));
    assertSame(commonGrpcConcerns, actualAddAfterResult);
    assertSame(grpcConcern2, stringGrpcConcernMap.get("Concern Name"));
  }

  /**
   * Test {@link CommonConcerns#stageNames()}.
   * <p>
   * Method under test: {@link CommonConcerns#stageNames()}
   */
  @Test
  @DisplayName("Test stageNames()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List CommonConcerns.stageNames()"})
  void testStageNames() {
    // Arrange, Act and Assert
    assertTrue((new CommonGrpcConcerns("Concern Name")).stageNames().isEmpty());
  }

  /**
   * Test {@link CommonConcerns#concernName()}.
   * <p>
   * Method under test: {@link CommonConcerns#concernName()}
   */
  @Test
  @DisplayName("Test concernName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CommonConcerns.concernName()"})
  void testConcernName() {
    // Arrange, Act and Assert
    assertEquals("Concern Name", (new CommonGrpcConcerns("Concern Name")).concernName());
  }
}
