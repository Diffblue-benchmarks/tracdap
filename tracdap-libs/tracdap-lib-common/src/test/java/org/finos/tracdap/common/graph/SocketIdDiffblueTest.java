package org.finos.tracdap.common.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;

class SocketIdDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SocketId#equals(Object)}
   *   <li>{@link SocketId#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SocketId socketId = new SocketId(new NodeId("Name", NodeNamespace.ROOT), "Socket");
    SocketId socketId2 = new SocketId(new NodeId("Name", NodeNamespace.ROOT), "Socket");

    // Act and Assert
    assertEquals(socketId, socketId2);
    int expectedHashCodeResult = socketId.hashCode();
    assertEquals(expectedHashCodeResult, socketId2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SocketId#equals(Object)}
   *   <li>{@link SocketId#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SocketId socketId = new SocketId(new NodeId("Name", NodeNamespace.ROOT), "Socket");

    // Act and Assert
    assertEquals(socketId, socketId);
    int expectedHashCodeResult = socketId.hashCode();
    assertEquals(expectedHashCodeResult, socketId.hashCode());
  }

  /**
   * Method under test: {@link SocketId#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SocketId socketId = new SocketId(new NodeId(null, NodeNamespace.ROOT), "Socket");

    // Act and Assert
    assertNotEquals(socketId, new SocketId(new NodeId("Name", NodeNamespace.ROOT), "Socket"));
  }

  /**
   * Method under test: {@link SocketId#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SocketId socketId = new SocketId(new NodeId("Name", mock(NodeNamespace.class)), "Socket");

    // Act and Assert
    assertNotEquals(socketId, new SocketId(new NodeId("Name", NodeNamespace.ROOT), "Socket"));
  }

  /**
   * Method under test: {@link SocketId#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SocketId socketId = new SocketId(new NodeId("Name", NodeNamespace.ROOT), null);

    // Act and Assert
    assertNotEquals(socketId, new SocketId(new NodeId("Name", NodeNamespace.ROOT), "Socket"));
  }

  /**
   * Method under test: {@link SocketId#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SocketId(new NodeId("Name", NodeNamespace.ROOT), "Socket"), null);
  }

  /**
   * Method under test: {@link SocketId#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SocketId(new NodeId("Name", NodeNamespace.ROOT), "Socket"), "Different type to SocketId");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SocketId#SocketId(NodeId, String)}
   *   <li>{@link SocketId#toString()}
   *   <li>{@link SocketId#nodeId()}
   *   <li>{@link SocketId#socket()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    NodeId nodeId = new NodeId("Name", NodeNamespace.ROOT);

    // Act
    SocketId actualSocketId = new SocketId(nodeId, "Socket");
    String actualToStringResult = actualSocketId.toString();
    NodeId actualNodeIdResult = actualSocketId.nodeId();

    // Assert
    assertEquals("Name.Socket / ROOT", actualToStringResult);
    assertEquals("Socket", actualSocketId.socket());
    assertSame(nodeId, actualNodeIdResult);
  }
}
