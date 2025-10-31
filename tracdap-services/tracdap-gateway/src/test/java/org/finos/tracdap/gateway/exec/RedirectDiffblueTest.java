package org.finos.tracdap.gateway.exec;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.finos.tracdap.config.GatewayRedirect;
import org.junit.jupiter.api.Test;

class RedirectDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Redirect#Redirect(int, GatewayRedirect, IRouteMatcher)}
   *   <li>{@link Redirect#getConfig()}
   *   <li>{@link Redirect#getIndex()}
   *   <li>{@link Redirect#getMatcher()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    GatewayRedirect config = GatewayRedirect.getDefaultInstance();
    IRouteMatcher matcher = mock(IRouteMatcher.class);

    // Act
    Redirect actualRedirect = new Redirect(1, config, matcher);
    GatewayRedirect actualConfig = actualRedirect.getConfig();
    int actualIndex = actualRedirect.getIndex();

    // Assert
    assertEquals(1, actualIndex);
    assertSame(config, actualConfig);
    assertSame(matcher, actualRedirect.getMatcher());
  }
}
