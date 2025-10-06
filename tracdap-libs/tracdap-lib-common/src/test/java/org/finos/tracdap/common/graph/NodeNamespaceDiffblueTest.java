package org.finos.tracdap.common.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NodeNamespaceDiffblueTest {
  /**
   * Test {@link NodeNamespace#NodeNamespace(String)}.
   *
   * <p>Method under test: {@link NodeNamespace#NodeNamespace(String)}
   */
  @Test
  @DisplayName("Test new NodeNamespace(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NodeNamespace.<init>(String)"})
  void testNewNodeNamespace() {
    // Arrange and Act
    NodeNamespace actualNodeNamespace = new NodeNamespace("Name");

    // Assert
    assertEquals("Name", actualNodeNamespace.name());
    assertSame(NodeNamespace.ROOT, actualNodeNamespace.parent());
  }

  /**
   * Test {@link NodeNamespace#NodeNamespace(String, NodeNamespace)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NodeNamespace#NodeNamespace(String, NodeNamespace)}
   */
  @Test
  @DisplayName("Test new NodeNamespace(String, NodeNamespace); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NodeNamespace.<init>(String, NodeNamespace)"})
  void testNewNodeNamespace_whenNull() {
    // Arrange and Act
    NodeNamespace actualNodeNamespace = new NodeNamespace("Name", null);

    // Assert
    assertEquals("Name", actualNodeNamespace.name());
    assertSame(NodeNamespace.ROOT, actualNodeNamespace.parent());
  }

  /**
   * Test {@link NodeNamespace#NodeNamespace(String, NodeNamespace)}.
   *
   * <ul>
   *   <li>When {@link NodeNamespace#ROOT}.
   * </ul>
   *
   * <p>Method under test: {@link NodeNamespace#NodeNamespace(String, NodeNamespace)}
   */
  @Test
  @DisplayName("Test new NodeNamespace(String, NodeNamespace); when ROOT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NodeNamespace.<init>(String, NodeNamespace)"})
  void testNewNodeNamespace_whenRoot() {
    // Arrange and Act
    NodeNamespace actualNodeNamespace = new NodeNamespace("Name", NodeNamespace.ROOT);

    // Assert
    assertEquals("Name", actualNodeNamespace.name());
    assertSame(NodeNamespace.ROOT, actualNodeNamespace.parent());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NodeNamespace#toString()}
   *   <li>{@link NodeNamespace#name()}
   *   <li>{@link NodeNamespace#parent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String NodeNamespace.name()",
    "NodeNamespace NodeNamespace.parent()",
    "String NodeNamespace.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    NodeNamespace nodeNamespace = new NodeNamespace("Name");

    // Act
    String actualToStringResult = nodeNamespace.toString();
    String actualNameResult = nodeNamespace.name();

    // Assert
    assertEquals("Name", actualNameResult);
    assertEquals("Name", actualToStringResult);
    assertSame(NodeNamespace.ROOT, nodeNamespace.parent());
  }

  /**
   * Test {@link NodeNamespace#equals(Object)}, and {@link NodeNamespace#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NodeNamespace#equals(Object)}
   *   <li>{@link NodeNamespace#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeNamespace.equals(Object)", "int NodeNamespace.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NodeNamespace nodeNamespace = NodeNamespace.ROOT;
    NodeNamespace nodeNamespace2 = NodeNamespace.ROOT;

    // Act and Assert
    assertEquals(nodeNamespace, nodeNamespace2);
    assertEquals(nodeNamespace.hashCode(), nodeNamespace2.hashCode());
  }

  /**
   * Test {@link NodeNamespace#equals(Object)}, and {@link NodeNamespace#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NodeNamespace#equals(Object)}
   *   <li>{@link NodeNamespace#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeNamespace.equals(Object)", "int NodeNamespace.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NodeNamespace nodeNamespace = new NodeNamespace("Name");
    NodeNamespace nodeNamespace2 = new NodeNamespace("Name");

    // Act and Assert
    assertEquals(nodeNamespace, nodeNamespace2);
    assertEquals(nodeNamespace.hashCode(), nodeNamespace2.hashCode());
  }

  /**
   * Test {@link NodeNamespace#equals(Object)}, and {@link NodeNamespace#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NodeNamespace#equals(Object)}
   *   <li>{@link NodeNamespace#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeNamespace.equals(Object)", "int NodeNamespace.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NodeNamespace nodeNamespace = NodeNamespace.ROOT;

    // Act and Assert
    assertEquals(nodeNamespace, nodeNamespace);
    int expectedHashCodeResult = nodeNamespace.hashCode();
    assertEquals(expectedHashCodeResult, nodeNamespace.hashCode());
  }

  /**
   * Test {@link NodeNamespace#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeNamespace#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeNamespace.equals(Object)", "int NodeNamespace.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NodeNamespace("Name"), NodeNamespace.ROOT);
  }

  /**
   * Test {@link NodeNamespace#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeNamespace#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeNamespace.equals(Object)", "int NodeNamespace.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new NodeNamespace(SocketId.SINGLE_INPUT), NodeNamespace.ROOT);
  }

  /**
   * Test {@link NodeNamespace#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeNamespace#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeNamespace.equals(Object)", "int NodeNamespace.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(NodeNamespace.ROOT, null);
  }

  /**
   * Test {@link NodeNamespace#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeNamespace#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeNamespace.equals(Object)", "int NodeNamespace.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(NodeNamespace.ROOT, "Different type to NodeNamespace");
  }
}
