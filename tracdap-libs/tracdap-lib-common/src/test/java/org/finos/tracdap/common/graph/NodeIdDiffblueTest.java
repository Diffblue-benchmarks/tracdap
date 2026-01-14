package org.finos.tracdap.common.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NodeIdDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NodeId#NodeId(String, NodeNamespace)}
   *   <li>{@link NodeId#toString()}
   *   <li>{@link NodeId#name()}
   *   <li>{@link NodeId#namespace()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NodeId.<init>(String, NodeNamespace)",
    "String NodeId.name()",
    "NodeNamespace NodeId.namespace()",
    "String NodeId.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    NodeId actualNodeId = new NodeId("Name", NodeNamespace.ROOT);
    String actualToStringResult = actualNodeId.toString();
    String actualNameResult = actualNodeId.name();

    // Assert
    assertEquals("Name / ROOT", actualToStringResult);
    assertEquals("Name", actualNameResult);
    assertSame(NodeNamespace.ROOT, actualNodeId.namespace());
  }

  /**
   * Test {@link NodeId#equals(Object)}, and {@link NodeId#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NodeId#equals(Object)}
   *   <li>{@link NodeId#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeId.equals(Object)", "int NodeId.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NodeId nodeId = new NodeId("Name", NodeNamespace.ROOT);
    NodeId nodeId2 = new NodeId("Name", NodeNamespace.ROOT);

    // Act and Assert
    assertEquals(nodeId, nodeId2);
    assertEquals(nodeId.hashCode(), nodeId2.hashCode());
  }

  /**
   * Test {@link NodeId#equals(Object)}, and {@link NodeId#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NodeId#equals(Object)}
   *   <li>{@link NodeId#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeId.equals(Object)", "int NodeId.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NodeId nodeId = new NodeId("Name", NodeNamespace.ROOT);

    // Act and Assert
    assertEquals(nodeId, nodeId);
    int expectedHashCodeResult = nodeId.hashCode();
    assertEquals(expectedHashCodeResult, nodeId.hashCode());
  }

  /**
   * Test {@link NodeId#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeId#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeId.equals(Object)", "int NodeId.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NodeId nodeId = new NodeId(null, NodeNamespace.ROOT);

    // Act and Assert
    assertNotEquals(nodeId, new NodeId("Name", NodeNamespace.ROOT));
  }

  /**
   * Test {@link NodeId#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeId#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeId.equals(Object)", "int NodeId.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NodeId nodeId = new NodeId("Name", new NodeNamespace("Name"));

    // Act and Assert
    assertNotEquals(nodeId, new NodeId("Name", NodeNamespace.ROOT));
  }

  /**
   * Test {@link NodeId#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeId#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeId.equals(Object)", "int NodeId.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NodeId("Name", NodeNamespace.ROOT), null);
  }

  /**
   * Test {@link NodeId#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeId#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeId.equals(Object)", "int NodeId.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NodeId("Name", NodeNamespace.ROOT), "Different type to NodeId");
  }
}
