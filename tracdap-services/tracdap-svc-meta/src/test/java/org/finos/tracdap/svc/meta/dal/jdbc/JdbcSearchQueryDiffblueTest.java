package org.finos.tracdap.svc.meta.dal.jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.tracdap.svc.meta.dal.jdbc.JdbcSearchQuery.Fragment;
import org.finos.tracdap.svc.meta.dal.jdbc.JdbcSearchQuery.ParamSetter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JdbcSearchQueryDiffblueTest {
  /**
   * Test Fragment getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Fragment#Fragment(String, String, List)}
   *   <li>{@link Fragment#getJoinClause()}
   *   <li>{@link Fragment#getParams()}
   *   <li>{@link Fragment#getWhereClause()}
   * </ul>
   */
  @Test
  @DisplayName("Test Fragment getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Fragment.<init>(String, String, List)", "String Fragment.getJoinClause()",
      "List Fragment.getParams()", "String Fragment.getWhereClause()"})
  void testFragmentGettersAndSetters() {
    // Arrange
    ArrayList<ParamSetter> params = new ArrayList<>();

    // Act
    Fragment actualFragment = new Fragment("Join Clause", "Where Clause", params);
    String actualJoinClause = actualFragment.getJoinClause();
    List<ParamSetter> actualParams = actualFragment.getParams();

    // Assert
    assertEquals("Join Clause", actualJoinClause);
    assertEquals("Where Clause", actualFragment.getWhereClause());
    assertTrue(actualParams.isEmpty());
    assertSame(params, actualParams);
  }

  /**
   * Test {@link JdbcSearchQuery#JdbcSearchQuery(String, List)}.
   * <ul>
   *   <li>Given {@link ParamSetter}.</li>
   *   <li>Then return Params is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSearchQuery#JdbcSearchQuery(String, List)}
   */
  @Test
  @DisplayName("Test new JdbcSearchQuery(String, List); given ParamSetter; then return Params is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JdbcSearchQuery.<init>(String, List)"})
  void testNewJdbcSearchQuery_givenParamSetter_thenReturnParamsIsArrayList() {
    // Arrange
    ArrayList<ParamSetter> params = new ArrayList<>();
    params.add(mock(ParamSetter.class));

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

  /**
   * Test {@link JdbcSearchQuery#JdbcSearchQuery(String, List)}.
   * <ul>
   *   <li>Given {@link ParamSetter}.</li>
   *   <li>Then return Params is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSearchQuery#JdbcSearchQuery(String, List)}
   */
  @Test
  @DisplayName("Test new JdbcSearchQuery(String, List); given ParamSetter; then return Params is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JdbcSearchQuery.<init>(String, List)"})
  void testNewJdbcSearchQuery_givenParamSetter_thenReturnParamsIsArrayList2() {
    // Arrange
    ArrayList<ParamSetter> params = new ArrayList<>();
    params.add(mock(ParamSetter.class));
    params.add(mock(ParamSetter.class));

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

  /**
   * Test {@link JdbcSearchQuery#JdbcSearchQuery(int, int, int, List)}.
   * <ul>
   *   <li>Then return Fragments is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSearchQuery#JdbcSearchQuery(int, int, int, List)}
   */
  @Test
  @DisplayName("Test new JdbcSearchQuery(int, int, int, List); then return Fragments is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JdbcSearchQuery.<init>(int, int, int, List)"})
  void testNewJdbcSearchQuery_thenReturnFragmentsIsArrayList() {
    // Arrange
    ArrayList<Fragment> fragments = new ArrayList<>();
    fragments.add(new Fragment("Join Clause", "Where Clause", new ArrayList<>()));

    // Act and Assert
    assertSame(fragments, (new JdbcSearchQuery(10, 10, 10, fragments)).getFragments());
  }

  /**
   * Test {@link JdbcSearchQuery#JdbcSearchQuery(int, int, List)}.
   * <ul>
   *   <li>Then return Fragments is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSearchQuery#JdbcSearchQuery(int, int, List)}
   */
  @Test
  @DisplayName("Test new JdbcSearchQuery(int, int, List); then return Fragments is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JdbcSearchQuery.<init>(int, int, List)"})
  void testNewJdbcSearchQuery_thenReturnFragmentsIsArrayList2() {
    // Arrange
    ArrayList<Fragment> fragments = new ArrayList<>();
    fragments.add(new Fragment("Join Clause", "Where Clause", new ArrayList<>()));

    // Act and Assert
    assertSame(fragments, (new JdbcSearchQuery(10, 10, fragments)).getFragments());
  }

  /**
   * Test {@link JdbcSearchQuery#JdbcSearchQuery(int, int, int, List)}.
   * <ul>
   *   <li>Then return Fragments size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSearchQuery#JdbcSearchQuery(int, int, int, List)}
   */
  @Test
  @DisplayName("Test new JdbcSearchQuery(int, int, int, List); then return Fragments size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JdbcSearchQuery.<init>(int, int, int, List)"})
  void testNewJdbcSearchQuery_thenReturnFragmentsSizeIsTwo() {
    // Arrange
    ArrayList<Fragment> fragments = new ArrayList<>();
    fragments.add(new Fragment("Join Clause", "Where Clause", new ArrayList<>()));
    Fragment fragment = new Fragment("Join Clause", "Where Clause", new ArrayList<>());

    fragments.add(fragment);

    // Act and Assert
    List<Fragment> fragments2 = (new JdbcSearchQuery(10, 10, 10, fragments)).getFragments();
    assertEquals(2, fragments2.size());
    assertSame(fragment, fragments2.get(1));
  }

  /**
   * Test {@link JdbcSearchQuery#JdbcSearchQuery(int, int, List)}.
   * <ul>
   *   <li>Then return Fragments size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSearchQuery#JdbcSearchQuery(int, int, List)}
   */
  @Test
  @DisplayName("Test new JdbcSearchQuery(int, int, List); then return Fragments size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JdbcSearchQuery.<init>(int, int, List)"})
  void testNewJdbcSearchQuery_thenReturnFragmentsSizeIsTwo2() {
    // Arrange
    ArrayList<Fragment> fragments = new ArrayList<>();
    fragments.add(new Fragment("Join Clause", "Where Clause", new ArrayList<>()));
    Fragment fragment = new Fragment("Join Clause", "Where Clause", new ArrayList<>());

    fragments.add(fragment);

    // Act and Assert
    List<Fragment> fragments2 = (new JdbcSearchQuery(10, 10, fragments)).getFragments();
    assertEquals(2, fragments2.size());
    assertSame(fragment, fragments2.get(1));
  }

  /**
   * Test {@link JdbcSearchQuery#JdbcSearchQuery(String, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Params Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSearchQuery#JdbcSearchQuery(String, List)}
   */
  @Test
  @DisplayName("Test new JdbcSearchQuery(String, List); when ArrayList(); then return Params Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JdbcSearchQuery.<init>(String, List)"})
  void testNewJdbcSearchQuery_whenArrayList_thenReturnParamsEmpty() {
    // Arrange and Act
    JdbcSearchQuery actualJdbcSearchQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    // Assert
    assertEquals("Query", actualJdbcSearchQuery.getQuery());
    assertEquals(0, actualJdbcSearchQuery.getNextAttrNumber());
    assertEquals(0, actualJdbcSearchQuery.getSubQueryNumber());
    assertEquals(1, actualJdbcSearchQuery.getNextSubQueryNumber());
    assertTrue(actualJdbcSearchQuery.getFragments().isEmpty());
    assertTrue(actualJdbcSearchQuery.getParams().isEmpty());
  }

  /**
   * Test {@link JdbcSearchQuery#JdbcSearchQuery(int, int, int, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Query is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSearchQuery#JdbcSearchQuery(int, int, int, List)}
   */
  @Test
  @DisplayName("Test new JdbcSearchQuery(int, int, int, List); when ArrayList(); then return Query is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JdbcSearchQuery.<init>(int, int, int, List)"})
  void testNewJdbcSearchQuery_whenArrayList_thenReturnQueryIsEmptyString() {
    // Arrange and Act
    JdbcSearchQuery actualJdbcSearchQuery = new JdbcSearchQuery(10, 10, 10, new ArrayList<>());

    // Assert
    assertEquals("", actualJdbcSearchQuery.getQuery());
    assertEquals(10, actualJdbcSearchQuery.getNextAttrNumber());
    assertEquals(10, actualJdbcSearchQuery.getNextSubQueryNumber());
    assertEquals(10, actualJdbcSearchQuery.getSubQueryNumber());
    assertTrue(actualJdbcSearchQuery.getFragments().isEmpty());
    assertTrue(actualJdbcSearchQuery.getParams().isEmpty());
  }

  /**
   * Test {@link JdbcSearchQuery#JdbcSearchQuery(int, int, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Query is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSearchQuery#JdbcSearchQuery(int, int, List)}
   */
  @Test
  @DisplayName("Test new JdbcSearchQuery(int, int, List); when ArrayList(); then return Query is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JdbcSearchQuery.<init>(int, int, List)"})
  void testNewJdbcSearchQuery_whenArrayList_thenReturnQueryIsEmptyString2() {
    // Arrange and Act
    JdbcSearchQuery actualJdbcSearchQuery = new JdbcSearchQuery(10, 10, new ArrayList<>());

    // Assert
    assertEquals("", actualJdbcSearchQuery.getQuery());
    assertEquals(10, actualJdbcSearchQuery.getNextAttrNumber());
    assertEquals(10, actualJdbcSearchQuery.getSubQueryNumber());
    assertEquals(11, actualJdbcSearchQuery.getNextSubQueryNumber());
    assertTrue(actualJdbcSearchQuery.getFragments().isEmpty());
    assertTrue(actualJdbcSearchQuery.getParams().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List JdbcSearchQuery.getFragments()", "int JdbcSearchQuery.getNextAttrNumber()",
      "int JdbcSearchQuery.getNextSubQueryNumber()", "List JdbcSearchQuery.getParams()",
      "String JdbcSearchQuery.getQuery()", "int JdbcSearchQuery.getSubQueryNumber()"})
  void testGettersAndSetters() {
    // Arrange
    ArrayList<ParamSetter> params = new ArrayList<>();
    JdbcSearchQuery jdbcSearchQuery = new JdbcSearchQuery("Query", params);

    // Act
    List<Fragment> actualFragments = jdbcSearchQuery.getFragments();
    int actualNextAttrNumber = jdbcSearchQuery.getNextAttrNumber();
    int actualNextSubQueryNumber = jdbcSearchQuery.getNextSubQueryNumber();
    List<ParamSetter> actualParams = jdbcSearchQuery.getParams();
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
}
