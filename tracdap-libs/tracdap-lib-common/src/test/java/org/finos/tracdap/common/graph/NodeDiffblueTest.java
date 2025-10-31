package org.finos.tracdap.common.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class NodeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Node#Node(NodeId, Map, List, Object)}
   *   <li>{@link Node#dependencies()}
   *   <li>{@link Node#nodeId()}
   *   <li>{@link Node#outputs()}
   *   <li>{@link Node#payload()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    NodeId nodeId = new NodeId("Name", NodeNamespace.ROOT);

    HashMap<String, SocketId> dependencies = new HashMap<>();
    ArrayList<String> outputs = new ArrayList<>();

    // Act
    Node<Object> actualNode = new Node<>(nodeId, dependencies, outputs, "Payload");
    Map<String, SocketId> actualDependenciesResult = actualNode.dependencies();
    NodeId actualNodeIdResult = actualNode.nodeId();
    List<String> actualOutputsResult = actualNode.outputs();

    // Assert
    assertEquals("Payload", actualNode.payload());
    assertTrue(actualOutputsResult.isEmpty());
    assertTrue(actualDependenciesResult.isEmpty());
    assertSame(outputs, actualOutputsResult);
    assertSame(dependencies, actualDependenciesResult);
    assertSame(nodeId, actualNodeIdResult);
  }
}
