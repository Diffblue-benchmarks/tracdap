package org.finos.tracdap.common.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;

class NodeIdDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NodeId#equals(Object)}
   *   <li>{@link NodeId#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NodeId nodeId = new NodeId("Name", NodeNamespace.ROOT);
    NodeId nodeId2 = new NodeId("Name", NodeNamespace.ROOT);

    // Act and Assert
    assertEquals(nodeId, nodeId2);
    int expectedHashCodeResult = nodeId.hashCode();
    assertEquals(expectedHashCodeResult, nodeId2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NodeId#equals(Object)}
   *   <li>{@link NodeId#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NodeId nodeId = new NodeId("Name", NodeNamespace.ROOT);

    // Act and Assert
    assertEquals(nodeId, nodeId);
    int expectedHashCodeResult = nodeId.hashCode();
    assertEquals(expectedHashCodeResult, nodeId.hashCode());
  }

  /**
   * Method under test: {@link NodeId#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NodeId nodeId = new NodeId(null, NodeNamespace.ROOT);

    // Act and Assert
    assertNotEquals(nodeId, new NodeId("Name", NodeNamespace.ROOT));
  }

  /**
   * Method under test: {@link NodeId#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NodeId nodeId = new NodeId("Name", new NodeNamespace("Name"));

    // Act and Assert
    assertNotEquals(nodeId, new NodeId("Name", NodeNamespace.ROOT));
  }

  /**
   * Method under test: {@link NodeId#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NodeId nodeId = new NodeId("Name", mock(NodeNamespace.class));

    // Act and Assert
    assertNotEquals(nodeId, new NodeId("Name", NodeNamespace.ROOT));
  }

  /**
   * Method under test: {@link NodeId#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NodeId("Name", NodeNamespace.ROOT), null);
  }

  /**
   * Method under test: {@link NodeId#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NodeId("Name", NodeNamespace.ROOT), "Different type to NodeId");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NodeId#NodeId(String, NodeNamespace)}
   *   <li>{@link NodeId#toString()}
   *   <li>{@link NodeId#name()}
   *   <li>{@link NodeId#namespace()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    NodeId actualNodeId = new NodeId("Name", NodeNamespace.ROOT);
    String actualToStringResult = actualNodeId.toString();
    String actualNameResult = actualNodeId.name();
    NodeNamespace actualNamespaceResult = actualNodeId.namespace();

    // Assert
    assertEquals("Name / ROOT", actualToStringResult);
    assertEquals("Name", actualNameResult);
    assertSame(actualNamespaceResult.ROOT, actualNamespaceResult);
  }
}
