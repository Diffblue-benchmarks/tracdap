package org.finos.tracdap.common.graph;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GraphDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Graph#Graph(Map, NodeId)}
   *   <li>{@link Graph#nodes()}
   *   <li>{@link Graph#root()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Graph.<init>(Map, NodeId)", "Map Graph.nodes()", "NodeId Graph.root()"})
  void testGettersAndSetters() {
    // Arrange
    HashMap<NodeId, Node<Object>> nodes = new HashMap<>();
    NodeId root = new NodeId("Name", NodeNamespace.ROOT);

    // Act
    Graph<Object> actualGraph = new Graph<>(nodes, root);
    Map<NodeId, Node<Object>> actualNodesResult = actualGraph.nodes();
    NodeId actualRootResult = actualGraph.root();

    // Assert
    assertTrue(actualNodesResult.isEmpty());
    assertSame(nodes, actualNodesResult);
    assertSame(root, actualRootResult);
  }
}
