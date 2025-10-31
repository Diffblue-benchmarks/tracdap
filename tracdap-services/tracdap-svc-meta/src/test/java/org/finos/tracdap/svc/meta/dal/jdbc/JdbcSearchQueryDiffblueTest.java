package org.finos.tracdap.svc.meta.dal.jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class JdbcSearchQueryDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JdbcSearchQuery.Fragment#Fragment(String, String, List)}
   *   <li>{@link JdbcSearchQuery.Fragment#getJoinClause()}
   *   <li>{@link JdbcSearchQuery.Fragment#getParams()}
   *   <li>{@link JdbcSearchQuery.Fragment#getWhereClause()}
   * </ul>
   */
  @Test
  void testFragmentGettersAndSetters() {
    // Arrange
    ArrayList<JdbcSearchQuery.ParamSetter> params = new ArrayList<>();

    // Act
    JdbcSearchQuery.Fragment actualFragment = new JdbcSearchQuery.Fragment("Join Clause", "Where Clause", params);
    String actualJoinClause = actualFragment.getJoinClause();
    List<JdbcSearchQuery.ParamSetter> actualParams = actualFragment.getParams();

    // Assert
    assertEquals("Join Clause", actualJoinClause);
    assertEquals("Where Clause", actualFragment.getWhereClause());
    assertTrue(actualParams.isEmpty());
    assertSame(params, actualParams);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JdbcSearchQuery#getFragments()}
   *   <li>{@link JdbcSearchQuery#getNextAttrNumber()}
   *   <li>{@link JdbcSearchQuery#getNextSubQueryNumber()}
   *   <li>{@link JdbcSearchQuery#getParams()}
   *   <li>{@link JdbcSearchQuery#getQuery()}
   *   <li>{@link JdbcSearchQuery#getSubQueryNumber()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    ArrayList<JdbcSearchQuery.ParamSetter> params = new ArrayList<>();
    JdbcSearchQuery jdbcSearchQuery = new JdbcSearchQuery("Query", params);

    // Act
    List<JdbcSearchQuery.Fragment> actualFragments = jdbcSearchQuery.getFragments();
    int actualNextAttrNumber = jdbcSearchQuery.getNextAttrNumber();
    int actualNextSubQueryNumber = jdbcSearchQuery.getNextSubQueryNumber();
    List<JdbcSearchQuery.ParamSetter> actualParams = jdbcSearchQuery.getParams();
    String actualQuery = jdbcSearchQuery.getQuery();

    // Assert
    assertEquals("Query", actualQuery);
    assertEquals(0, actualNextAttrNumber);
    assertEquals(0, jdbcSearchQuery.getSubQueryNumber());
    assertEquals(1, actualNextSubQueryNumber);
    assertTrue(actualFragments.isEmpty());
    assertTrue(actualParams.isEmpty());
    assertSame(params, actualParams);
  }

  /**
   * Method under test:
   * {@link JdbcSearchQuery#JdbcSearchQuery(int, int, int, List)}
   */
  @Test
  void testNewJdbcSearchQuery() {
    // Arrange
    ArrayList<JdbcSearchQuery.Fragment> fragments = new ArrayList<>();

    // Act
    JdbcSearchQuery actualJdbcSearchQuery = new JdbcSearchQuery(10, 10, 10, fragments);

    // Assert
    assertEquals("", actualJdbcSearchQuery.getQuery());
    assertEquals(10, actualJdbcSearchQuery.getNextAttrNumber());
    assertEquals(10, actualJdbcSearchQuery.getNextSubQueryNumber());
    assertEquals(10, actualJdbcSearchQuery.getSubQueryNumber());
    List<JdbcSearchQuery.Fragment> fragments2 = actualJdbcSearchQuery.getFragments();
    assertTrue(fragments2.isEmpty());
    assertTrue(actualJdbcSearchQuery.getParams().isEmpty());
    assertSame(fragments, fragments2);
  }

  /**
   * Method under test:
   * {@link JdbcSearchQuery#JdbcSearchQuery(int, int, int, List)}
   */
  @Test
  void testNewJdbcSearchQuery2() {
    // Arrange
    ArrayList<JdbcSearchQuery.Fragment> fragments = new ArrayList<>();
    fragments.add(new JdbcSearchQuery.Fragment("Join Clause", "Where Clause", new ArrayList<>()));

    // Act
    JdbcSearchQuery actualJdbcSearchQuery = new JdbcSearchQuery(10, 10, 10, fragments);

    // Assert
    assertEquals("", actualJdbcSearchQuery.getQuery());
    assertEquals(10, actualJdbcSearchQuery.getNextAttrNumber());
    assertEquals(10, actualJdbcSearchQuery.getNextSubQueryNumber());
    assertEquals(10, actualJdbcSearchQuery.getSubQueryNumber());
    assertTrue(actualJdbcSearchQuery.getParams().isEmpty());
    assertSame(fragments, actualJdbcSearchQuery.getFragments());
  }

  /**
   * Method under test:
   * {@link JdbcSearchQuery#JdbcSearchQuery(int, int, int, List)}
   */
  @Test
  void testNewJdbcSearchQuery3() {
    // Arrange
    ArrayList<JdbcSearchQuery.Fragment> fragments = new ArrayList<>();
    fragments.add(new JdbcSearchQuery.Fragment("Join Clause", "Where Clause", new ArrayList<>()));
    fragments.add(new JdbcSearchQuery.Fragment("Join Clause", "Where Clause", new ArrayList<>()));

    // Act
    JdbcSearchQuery actualJdbcSearchQuery = new JdbcSearchQuery(10, 10, 10, fragments);

    // Assert
    assertEquals("", actualJdbcSearchQuery.getQuery());
    assertEquals(10, actualJdbcSearchQuery.getNextAttrNumber());
    assertEquals(10, actualJdbcSearchQuery.getNextSubQueryNumber());
    assertEquals(10, actualJdbcSearchQuery.getSubQueryNumber());
    assertTrue(actualJdbcSearchQuery.getParams().isEmpty());
    assertSame(fragments, actualJdbcSearchQuery.getFragments());
  }

  /**
   * Method under test:
   * {@link JdbcSearchQuery#JdbcSearchQuery(int, int, int, List)}
   */
  @Test
  void testNewJdbcSearchQuery4() {
    // Arrange
    ArrayList<JdbcSearchQuery.ParamSetter> params = new ArrayList<>();
    params.add(mock(JdbcSearchQuery.ParamSetter.class));
    JdbcSearchQuery.Fragment fragment = new JdbcSearchQuery.Fragment("Join Clause", "Where Clause", params);

    ArrayList<JdbcSearchQuery.Fragment> fragments = new ArrayList<>();
    fragments.add(fragment);

    // Act
    JdbcSearchQuery actualJdbcSearchQuery = new JdbcSearchQuery(10, 10, 10, fragments);

    // Assert
    assertEquals("", actualJdbcSearchQuery.getQuery());
    assertEquals(10, actualJdbcSearchQuery.getNextAttrNumber());
    assertEquals(10, actualJdbcSearchQuery.getNextSubQueryNumber());
    assertEquals(10, actualJdbcSearchQuery.getSubQueryNumber());
    assertTrue(actualJdbcSearchQuery.getParams().isEmpty());
    assertSame(fragments, actualJdbcSearchQuery.getFragments());
  }

  /**
   * Method under test: {@link JdbcSearchQuery#JdbcSearchQuery(int, int, List)}
   */
  @Test
  void testNewJdbcSearchQuery5() {
    // Arrange
    ArrayList<JdbcSearchQuery.Fragment> fragments = new ArrayList<>();

    // Act
    JdbcSearchQuery actualJdbcSearchQuery = new JdbcSearchQuery(10, 10, fragments);

    // Assert
    assertEquals("", actualJdbcSearchQuery.getQuery());
    assertEquals(10, actualJdbcSearchQuery.getNextAttrNumber());
    assertEquals(10, actualJdbcSearchQuery.getSubQueryNumber());
    assertEquals(11, actualJdbcSearchQuery.getNextSubQueryNumber());
    List<JdbcSearchQuery.Fragment> fragments2 = actualJdbcSearchQuery.getFragments();
    assertTrue(fragments2.isEmpty());
    assertTrue(actualJdbcSearchQuery.getParams().isEmpty());
    assertSame(fragments, fragments2);
  }

  /**
   * Method under test: {@link JdbcSearchQuery#JdbcSearchQuery(int, int, List)}
   */
  @Test
  void testNewJdbcSearchQuery6() {
    // Arrange
    ArrayList<JdbcSearchQuery.Fragment> fragments = new ArrayList<>();
    fragments.add(new JdbcSearchQuery.Fragment("Join Clause", "Where Clause", new ArrayList<>()));

    // Act
    JdbcSearchQuery actualJdbcSearchQuery = new JdbcSearchQuery(10, 10, fragments);

    // Assert
    assertEquals("", actualJdbcSearchQuery.getQuery());
    assertEquals(10, actualJdbcSearchQuery.getNextAttrNumber());
    assertEquals(10, actualJdbcSearchQuery.getSubQueryNumber());
    assertEquals(11, actualJdbcSearchQuery.getNextSubQueryNumber());
    assertTrue(actualJdbcSearchQuery.getParams().isEmpty());
    assertSame(fragments, actualJdbcSearchQuery.getFragments());
  }

  /**
   * Method under test: {@link JdbcSearchQuery#JdbcSearchQuery(int, int, List)}
   */
  @Test
  void testNewJdbcSearchQuery7() {
    // Arrange
    ArrayList<JdbcSearchQuery.Fragment> fragments = new ArrayList<>();
    fragments.add(new JdbcSearchQuery.Fragment("Join Clause", "Where Clause", new ArrayList<>()));
    fragments.add(new JdbcSearchQuery.Fragment("Join Clause", "Where Clause", new ArrayList<>()));

    // Act
    JdbcSearchQuery actualJdbcSearchQuery = new JdbcSearchQuery(10, 10, fragments);

    // Assert
    assertEquals("", actualJdbcSearchQuery.getQuery());
    assertEquals(10, actualJdbcSearchQuery.getNextAttrNumber());
    assertEquals(10, actualJdbcSearchQuery.getSubQueryNumber());
    assertEquals(11, actualJdbcSearchQuery.getNextSubQueryNumber());
    assertTrue(actualJdbcSearchQuery.getParams().isEmpty());
    assertSame(fragments, actualJdbcSearchQuery.getFragments());
  }

  /**
   * Method under test: {@link JdbcSearchQuery#JdbcSearchQuery(int, int, List)}
   */
  @Test
  void testNewJdbcSearchQuery8() {
    // Arrange
    ArrayList<JdbcSearchQuery.ParamSetter> params = new ArrayList<>();
    params.add(mock(JdbcSearchQuery.ParamSetter.class));
    JdbcSearchQuery.Fragment fragment = new JdbcSearchQuery.Fragment("Join Clause", "Where Clause", params);

    ArrayList<JdbcSearchQuery.Fragment> fragments = new ArrayList<>();
    fragments.add(fragment);

    // Act
    JdbcSearchQuery actualJdbcSearchQuery = new JdbcSearchQuery(10, 10, fragments);

    // Assert
    assertEquals("", actualJdbcSearchQuery.getQuery());
    assertEquals(10, actualJdbcSearchQuery.getNextAttrNumber());
    assertEquals(10, actualJdbcSearchQuery.getSubQueryNumber());
    assertEquals(11, actualJdbcSearchQuery.getNextSubQueryNumber());
    assertTrue(actualJdbcSearchQuery.getParams().isEmpty());
    assertSame(fragments, actualJdbcSearchQuery.getFragments());
  }

  /**
   * Method under test: {@link JdbcSearchQuery#JdbcSearchQuery(String, List)}
   */
  @Test
  void testNewJdbcSearchQuery9() {
    // Arrange
    ArrayList<JdbcSearchQuery.ParamSetter> params = new ArrayList<>();

    // Act
    JdbcSearchQuery actualJdbcSearchQuery = new JdbcSearchQuery("Query", params);

    // Assert
    assertEquals("Query", actualJdbcSearchQuery.getQuery());
    assertEquals(0, actualJdbcSearchQuery.getNextAttrNumber());
    assertEquals(0, actualJdbcSearchQuery.getSubQueryNumber());
    assertEquals(1, actualJdbcSearchQuery.getNextSubQueryNumber());
    assertTrue(actualJdbcSearchQuery.getFragments().isEmpty());
    List<JdbcSearchQuery.ParamSetter> params2 = actualJdbcSearchQuery.getParams();
    assertTrue(params2.isEmpty());
    assertSame(params, params2);
  }

  /**
   * Method under test: {@link JdbcSearchQuery#JdbcSearchQuery(String, List)}
   */
  @Test
  void testNewJdbcSearchQuery10() {
    // Arrange
    ArrayList<JdbcSearchQuery.ParamSetter> params = new ArrayList<>();
    params.add(mock(JdbcSearchQuery.ParamSetter.class));

    // Act
    JdbcSearchQuery actualJdbcSearchQuery = new JdbcSearchQuery("Query", params);

    // Assert
    assertEquals("Query", actualJdbcSearchQuery.getQuery());
    assertEquals(0, actualJdbcSearchQuery.getNextAttrNumber());
    assertEquals(0, actualJdbcSearchQuery.getSubQueryNumber());
    List<JdbcSearchQuery.ParamSetter> params2 = actualJdbcSearchQuery.getParams();
    assertEquals(1, params2.size());
    assertEquals(1, actualJdbcSearchQuery.getNextSubQueryNumber());
    assertTrue(actualJdbcSearchQuery.getFragments().isEmpty());
    assertSame(params, params2);
  }

  /**
   * Method under test: {@link JdbcSearchQuery#JdbcSearchQuery(String, List)}
   */
  @Test
  void testNewJdbcSearchQuery11() {
    // Arrange
    ArrayList<JdbcSearchQuery.ParamSetter> params = new ArrayList<>();
    params.add(mock(JdbcSearchQuery.ParamSetter.class));
    params.add(mock(JdbcSearchQuery.ParamSetter.class));

    // Act
    JdbcSearchQuery actualJdbcSearchQuery = new JdbcSearchQuery("Query", params);

    // Assert
    assertEquals("Query", actualJdbcSearchQuery.getQuery());
    assertEquals(0, actualJdbcSearchQuery.getNextAttrNumber());
    assertEquals(0, actualJdbcSearchQuery.getSubQueryNumber());
    assertEquals(1, actualJdbcSearchQuery.getNextSubQueryNumber());
    assertTrue(actualJdbcSearchQuery.getFragments().isEmpty());
    assertSame(params, actualJdbcSearchQuery.getParams());
  }
}
