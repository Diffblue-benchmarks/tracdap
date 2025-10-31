package org.finos.tracdap.common.middleware;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.Map;
import org.finos.tracdap.common.exception.ETracInternal;
import org.junit.jupiter.api.Test;

class CommonConcernsDiffblueTest {
  /**
   * Method under test: {@link CommonConcerns#addFirst(BaseConcern)}
   */
  @Test
  void testAddFirst() {
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
   * Method under test: {@link CommonConcerns#addFirst(BaseConcern)}
   */
  @Test
  void testAddFirst2() {
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
   * Method under test: {@link CommonConcerns#addLast(BaseConcern)}
   */
  @Test
  void testAddLast() {
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
   * Method under test: {@link CommonConcerns#addLast(BaseConcern)}
   */
  @Test
  void testAddLast2() {
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
   * Method under test: {@link CommonConcerns#addBefore(String, BaseConcern)}
   */
  @Test
  void testAddBefore() {
    // Arrange
    CommonGrpcConcerns commonGrpcConcerns = new CommonGrpcConcerns("Concern Name");
    GrpcConcern grpcConcern = mock(GrpcConcern.class);
    when(grpcConcern.concernName()).thenReturn("Concern Name");

    // Act and Assert
    assertThrows(ETracInternal.class, () -> commonGrpcConcerns.addBefore("Before", grpcConcern));
    verify(grpcConcern).concernName();
  }

  /**
   * Method under test: {@link CommonConcerns#addBefore(String, BaseConcern)}
   */
  @Test
  void testAddBefore2() {
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
   * Method under test: {@link CommonConcerns#addBefore(String, BaseConcern)}
   */
  @Test
  void testAddBefore3() {
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
   * Method under test: {@link CommonConcerns#addAfter(String, BaseConcern)}
   */
  @Test
  void testAddAfter() {
    // Arrange
    CommonGrpcConcerns commonGrpcConcerns = new CommonGrpcConcerns("Concern Name");
    GrpcConcern grpcConcern = mock(GrpcConcern.class);
    when(grpcConcern.concernName()).thenReturn("Concern Name");

    // Act and Assert
    assertThrows(ETracInternal.class, () -> commonGrpcConcerns.addAfter("After", grpcConcern));
    verify(grpcConcern).concernName();
  }

  /**
   * Method under test: {@link CommonConcerns#addAfter(String, BaseConcern)}
   */
  @Test
  void testAddAfter2() {
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
   * Method under test: {@link CommonConcerns#addAfter(String, BaseConcern)}
   */
  @Test
  void testAddAfter3() {
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
   * Method under test: {@link CommonConcerns#stageNames()}
   */
  @Test
  void testStageNames() {
    // Arrange, Act and Assert
    assertTrue((new CommonGrpcConcerns("Concern Name")).stageNames().isEmpty());
  }

  /**
   * Method under test: {@link CommonConcerns#stageNames()}
   */
  @Test
  void testStageNames2() {
    // Arrange
    GrpcConcern grpcConcern = mock(GrpcConcern.class);
    when(grpcConcern.concernName()).thenReturn("Concern Name");

    CommonGrpcConcerns commonGrpcConcerns = new CommonGrpcConcerns("Concern Name");
    commonGrpcConcerns.addFirst(grpcConcern);

    // Act
    List<String> actualStageNamesResult = commonGrpcConcerns.stageNames();

    // Assert
    verify(grpcConcern, atLeast(1)).concernName();
    assertEquals(1, actualStageNamesResult.size());
    assertEquals("Concern Name", actualStageNamesResult.get(0));
  }

  /**
   * Method under test: {@link CommonConcerns#concernName()}
   */
  @Test
  void testConcernName() {
    // Arrange, Act and Assert
    assertEquals("Concern Name", (new CommonGrpcConcerns("Concern Name")).concernName());
  }

  /**
   * Method under test: {@link CommonConcerns#concernName()}
   */
  @Test
  void testConcernName2() {
    // Arrange
    GrpcConcern grpcConcern = mock(GrpcConcern.class);
    when(grpcConcern.concernName()).thenReturn("Concern Name");

    CommonGrpcConcerns commonGrpcConcerns = new CommonGrpcConcerns("Concern Name");
    commonGrpcConcerns.addFirst(grpcConcern);

    // Act
    String actualConcernNameResult = commonGrpcConcerns.concernName();

    // Assert
    verify(grpcConcern, atLeast(1)).concernName();
    assertEquals("Concern Name", actualConcernNameResult);
  }
}
