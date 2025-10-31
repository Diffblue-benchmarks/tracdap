package org.finos.tracdap.common.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class NodeNamespaceDiffblueTest {
  /**
   * Method under test: {@link NodeNamespace#NodeNamespace(String)}
   */
  @Test
  void testNewNodeNamespace() {
    // Arrange and Act
    NodeNamespace actualNodeNamespace = new NodeNamespace("Name");

    // Assert
    assertEquals("Name", actualNodeNamespace.name());
    NodeNamespace expectedParentResult = actualNodeNamespace.ROOT;
    assertSame(expectedParentResult, actualNodeNamespace.parent());
  }

  /**
   * Method under test: {@link NodeNamespace#NodeNamespace(String, NodeNamespace)}
   */
  @Test
  void testNewNodeNamespace2() {
    // Arrange and Act
    NodeNamespace actualNodeNamespace = new NodeNamespace("Name", NodeNamespace.ROOT);

    // Assert
    assertEquals("Name", actualNodeNamespace.name());
    NodeNamespace expectedParentResult = actualNodeNamespace.ROOT;
    assertSame(expectedParentResult, actualNodeNamespace.parent());
  }

  /**
   * Method under test: {@link NodeNamespace#NodeNamespace(String, NodeNamespace)}
   */
  @Test
  void testNewNodeNamespace3() {
    // Arrange and Act
    NodeNamespace actualNodeNamespace = new NodeNamespace("Name", null);

    // Assert
    assertEquals("Name", actualNodeNamespace.name());
    NodeNamespace expectedParentResult = actualNodeNamespace.ROOT;
    assertSame(expectedParentResult, actualNodeNamespace.parent());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NodeNamespace#equals(Object)}
   *   <li>{@link NodeNamespace#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NodeNamespace nodeNamespace = NodeNamespace.ROOT;
    NodeNamespace nodeNamespace2 = NodeNamespace.ROOT;

    // Act and Assert
    assertEquals(nodeNamespace, nodeNamespace2);
    int expectedHashCodeResult = nodeNamespace.hashCode();
    assertEquals(expectedHashCodeResult, nodeNamespace2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NodeNamespace#equals(Object)}
   *   <li>{@link NodeNamespace#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NodeNamespace nodeNamespace = new NodeNamespace("Name");
    NodeNamespace nodeNamespace2 = new NodeNamespace("Name");

    // Act and Assert
    assertEquals(nodeNamespace, nodeNamespace2);
    int expectedHashCodeResult = nodeNamespace.hashCode();
    assertEquals(expectedHashCodeResult, nodeNamespace2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NodeNamespace#equals(Object)}
   *   <li>{@link NodeNamespace#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NodeNamespace nodeNamespace = NodeNamespace.ROOT;

    // Act and Assert
    assertEquals(nodeNamespace, nodeNamespace);
    int expectedHashCodeResult = nodeNamespace.hashCode();
    assertEquals(expectedHashCodeResult, nodeNamespace.hashCode());
  }

  /**
   * Method under test: {@link NodeNamespace#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NodeNamespace("Name"), NodeNamespace.ROOT);
    assertNotEquals(new NodeNamespace(SocketId.SINGLE_INPUT), NodeNamespace.ROOT);
  }

  /**
   * Method under test: {@link NodeNamespace#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(NodeNamespace.ROOT, null);
  }

  /**
   * Method under test: {@link NodeNamespace#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(NodeNamespace.ROOT, "Different type to NodeNamespace");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NodeNamespace#toString()}
   *   <li>{@link NodeNamespace#name()}
   *   <li>{@link NodeNamespace#parent()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    NodeNamespace nodeNamespace = new NodeNamespace("Name");

    // Act
    String actualToStringResult = nodeNamespace.toString();
    String actualNameResult = nodeNamespace.name();
    NodeNamespace actualParentResult = nodeNamespace.parent();

    // Assert
    assertEquals("Name", actualNameResult);
    assertEquals("Name", actualToStringResult);
    assertSame(actualParentResult.ROOT, actualParentResult);
  }
}
