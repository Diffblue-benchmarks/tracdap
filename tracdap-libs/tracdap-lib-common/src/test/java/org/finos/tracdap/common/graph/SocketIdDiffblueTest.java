package org.finos.tracdap.common.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SocketIdDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SocketId#SocketId(NodeId, String)}
   *   <li>{@link SocketId#toString()}
   *   <li>{@link SocketId#nodeId()}
   *   <li>{@link SocketId#socket()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SocketId.<init>(NodeId, String)", "NodeId SocketId.nodeId()", "String SocketId.socket()",
      "String SocketId.toString()"})
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

  /**
   * Test {@link SocketId#equals(Object)}, and {@link SocketId#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SocketId#equals(Object)}
   *   <li>{@link SocketId#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SocketId.equals(Object)", "int SocketId.hashCode()"})
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
   * Test {@link SocketId#equals(Object)}, and {@link SocketId#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SocketId#equals(Object)}
   *   <li>{@link SocketId#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SocketId.equals(Object)", "int SocketId.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SocketId socketId = new SocketId(new NodeId("Name", NodeNamespace.ROOT), "Socket");

    // Act and Assert
    assertEquals(socketId, socketId);
    int expectedHashCodeResult = socketId.hashCode();
    assertEquals(expectedHashCodeResult, socketId.hashCode());
  }

  /**
   * Test {@link SocketId#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SocketId#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SocketId.equals(Object)", "int SocketId.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SocketId socketId = new SocketId(new NodeId(null, NodeNamespace.ROOT), "Socket");

    // Act and Assert
    assertNotEquals(socketId, new SocketId(new NodeId("Name", NodeNamespace.ROOT), "Socket"));
  }

  /**
   * Test {@link SocketId#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SocketId#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SocketId.equals(Object)", "int SocketId.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SocketId socketId = new SocketId(new NodeId("Name", NodeNamespace.ROOT), null);

    // Act and Assert
    assertNotEquals(socketId, new SocketId(new NodeId("Name", NodeNamespace.ROOT), "Socket"));
  }

  /**
   * Test {@link SocketId#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SocketId#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SocketId.equals(Object)", "int SocketId.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SocketId(new NodeId("Name", NodeNamespace.ROOT), "Socket"), null);
  }

  /**
   * Test {@link SocketId#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SocketId#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SocketId.equals(Object)", "int SocketId.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SocketId(new NodeId("Name", NodeNamespace.ROOT), "Socket"), "Different type to SocketId");
  }
}
