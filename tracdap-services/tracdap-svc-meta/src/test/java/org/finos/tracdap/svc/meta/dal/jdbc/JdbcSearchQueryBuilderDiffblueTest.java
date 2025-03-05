package org.finos.tracdap.svc.meta.dal.jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.finos.tracdap.common.exception.EValidationGap;
import org.finos.tracdap.metadata.LogicalExpression;
import org.finos.tracdap.metadata.SearchExpression;
import org.finos.tracdap.metadata.SearchParameters;
import org.finos.tracdap.metadata.SearchTerm;
import org.finos.tracdap.svc.meta.dal.jdbc.JdbcSearchQuery.Fragment;
import org.finos.tracdap.svc.meta.dal.jdbc.JdbcSearchQuery.ParamSetter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JdbcSearchQueryBuilderDiffblueTest {
  /**
   * Test {@link JdbcSearchQueryBuilder#buildSearchQuery(short, SearchParameters)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return Query is a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSearchQueryBuilder#buildSearchQuery(short, SearchParameters)}
   */
  @Test
  @DisplayName("Test buildSearchQuery(short, SearchParameters); when DefaultInstance; then return Query is a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JdbcSearchQuery JdbcSearchQueryBuilder.buildSearchQuery(short, SearchParameters)"})
  void testBuildSearchQuery_whenDefaultInstance_thenReturnQueryIsAString() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();

    // Act
    JdbcSearchQuery actualBuildSearchQueryResult = jdbcSearchQueryBuilder.buildSearchQuery((short) 1,
        SearchParameters.getDefaultInstance());

    // Assert
    assertEquals(
        "select t0.tag_pk\n" + "from tag t0\n" + "join object_definition od0\n" + "  on od0.tenant_id = t0.tenant_id\n"
            + "  and od0.definition_pk = t0.definition_fk\n" + "where t0.tenant_id = ?\n" + "  and t0.object_type = ?\n"
            + "  and od0.object_is_latest = ? and t0.tag_is_latest = ?\n" + "group by t0.tag_pk\n"
            + "order by max(t0.tag_timestamp) desc",
        actualBuildSearchQueryResult.getQuery());
    assertEquals(0, actualBuildSearchQueryResult.getNextAttrNumber());
    assertEquals(0, actualBuildSearchQueryResult.getSubQueryNumber());
    assertEquals(1, actualBuildSearchQueryResult.getNextSubQueryNumber());
    assertEquals(4, actualBuildSearchQueryResult.getParams().size());
    assertTrue(actualBuildSearchQueryResult.getFragments().isEmpty());
  }

  /**
   * Test {@link JdbcSearchQueryBuilder#buildPriorSearchQuery(short, SearchParameters)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return Query is a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSearchQueryBuilder#buildPriorSearchQuery(short, SearchParameters)}
   */
  @Test
  @DisplayName("Test buildPriorSearchQuery(short, SearchParameters); when DefaultInstance; then return Query is a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JdbcSearchQuery JdbcSearchQueryBuilder.buildPriorSearchQuery(short, SearchParameters)"})
  void testBuildPriorSearchQuery_whenDefaultInstance_thenReturnQueryIsAString() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();

    // Act
    JdbcSearchQuery actualBuildPriorSearchQueryResult = jdbcSearchQueryBuilder.buildPriorSearchQuery((short) 1,
        SearchParameters.getDefaultInstance());

    // Assert
    assertEquals("select max(t0.tag_pk) as tag_pk\n" + "from tag t0\n" + "join object_definition od0\n"
        + "  on od0.tenant_id = t0.tenant_id\n" + "  and od0.definition_pk = t0.definition_fk\n"
        + "where t0.tenant_id = ?\n" + "  and t0.object_type = ?\n"
        + "  and od0.object_is_latest = ? and t0.tag_is_latest = ?\n" + "group by od0.object_fk\n"
        + "order by max(t0.tag_timestamp) desc", actualBuildPriorSearchQueryResult.getQuery());
    assertEquals(0, actualBuildPriorSearchQueryResult.getNextAttrNumber());
    assertEquals(0, actualBuildPriorSearchQueryResult.getSubQueryNumber());
    assertEquals(1, actualBuildPriorSearchQueryResult.getNextSubQueryNumber());
    assertEquals(4, actualBuildPriorSearchQueryResult.getParams().size());
    assertTrue(actualBuildPriorSearchQueryResult.getFragments().isEmpty());
  }

  /**
   * Test {@link JdbcSearchQueryBuilder#buildCommonSearchQuery(short, SearchParameters, String, String)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return Query is a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSearchQueryBuilder#buildCommonSearchQuery(short, SearchParameters, String, String)}
   */
  @Test
  @DisplayName("Test buildCommonSearchQuery(short, SearchParameters, String, String); when DefaultInstance; then return Query is a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "JdbcSearchQuery JdbcSearchQueryBuilder.buildCommonSearchQuery(short, SearchParameters, String, String)"})
  void testBuildCommonSearchQuery_whenDefaultInstance_thenReturnQueryIsAString() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();

    // Act
    JdbcSearchQuery actualBuildCommonSearchQueryResult = jdbcSearchQueryBuilder.buildCommonSearchQuery((short) 1,
        SearchParameters.getDefaultInstance(), "Select Fields", "Group By Fields");

    // Assert
    assertEquals("select Select Fields\n" + "from tag t0\n" + "join object_definition od0\n"
        + "  on od0.tenant_id = t0.tenant_id\n" + "  and od0.definition_pk = t0.definition_fk\n"
        + "where t0.tenant_id = ?\n" + "  and t0.object_type = ?\n"
        + "  and od0.object_is_latest = ? and t0.tag_is_latest = ?\n" + "group by Group By Fields\n"
        + "order by max(t0.tag_timestamp) desc", actualBuildCommonSearchQueryResult.getQuery());
    assertEquals(0, actualBuildCommonSearchQueryResult.getNextAttrNumber());
    assertEquals(0, actualBuildCommonSearchQueryResult.getSubQueryNumber());
    assertEquals(1, actualBuildCommonSearchQueryResult.getNextSubQueryNumber());
    assertEquals(4, actualBuildCommonSearchQueryResult.getParams().size());
    assertTrue(actualBuildCommonSearchQueryResult.getFragments().isEmpty());
  }

  /**
   * Test {@link JdbcSearchQueryBuilder#buildSearchQueryFromTemplate(String, int, JdbcSearchQuery, Stream)}.
   * <p>
   * Method under test: {@link JdbcSearchQueryBuilder#buildSearchQueryFromTemplate(String, int, JdbcSearchQuery, Stream)}
   */
  @Test
  @DisplayName("Test buildSearchQueryFromTemplate(String, int, JdbcSearchQuery, Stream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "JdbcSearchQuery JdbcSearchQueryBuilder.buildSearchQueryFromTemplate(String, int, JdbcSearchQuery, Stream)"})
  void testBuildSearchQueryFromTemplate() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery queryParts = new JdbcSearchQuery("Query", new ArrayList<>());

    ArrayList<ParamSetter> paramSetterList = new ArrayList<>();
    Stream<ParamSetter> params = paramSetterList.stream();

    // Act
    JdbcSearchQuery actualBuildSearchQueryFromTemplateResult = jdbcSearchQueryBuilder
        .buildSearchQueryFromTemplate("Query Template", 10, queryParts, params);

    // Assert
    assertEquals("Query Template", actualBuildSearchQueryFromTemplateResult.getQuery());
    assertEquals(0, actualBuildSearchQueryFromTemplateResult.getNextAttrNumber());
    assertEquals(0, actualBuildSearchQueryFromTemplateResult.getSubQueryNumber());
    assertEquals(1, actualBuildSearchQueryFromTemplateResult.getNextSubQueryNumber());
    assertTrue(actualBuildSearchQueryFromTemplateResult.getFragments().isEmpty());
    assertTrue(actualBuildSearchQueryFromTemplateResult.getParams().isEmpty());
  }

  /**
   * Test {@link JdbcSearchQueryBuilder#buildSearchQueryFromTemplate(String, int, JdbcSearchQuery, Stream)}.
   * <p>
   * Method under test: {@link JdbcSearchQueryBuilder#buildSearchQueryFromTemplate(String, int, JdbcSearchQuery, Stream)}
   */
  @Test
  @DisplayName("Test buildSearchQueryFromTemplate(String, int, JdbcSearchQuery, Stream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "JdbcSearchQuery JdbcSearchQueryBuilder.buildSearchQueryFromTemplate(String, int, JdbcSearchQuery, Stream)"})
  void testBuildSearchQueryFromTemplate2() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();

    ArrayList<Fragment> fragments = new ArrayList<>();
    fragments.add(new Fragment("Join Clause", "Where Clause", new ArrayList<>()));
    JdbcSearchQuery queryParts = new JdbcSearchQuery(10, 10, fragments);

    ArrayList<ParamSetter> paramSetterList = new ArrayList<>();
    Stream<ParamSetter> params = paramSetterList.stream();

    // Act
    JdbcSearchQuery actualBuildSearchQueryFromTemplateResult = jdbcSearchQueryBuilder
        .buildSearchQueryFromTemplate("Query Template", 10, queryParts, params);

    // Assert
    assertEquals("Query Template", actualBuildSearchQueryFromTemplateResult.getQuery());
    assertEquals(0, actualBuildSearchQueryFromTemplateResult.getNextAttrNumber());
    assertEquals(0, actualBuildSearchQueryFromTemplateResult.getSubQueryNumber());
    assertEquals(1, actualBuildSearchQueryFromTemplateResult.getNextSubQueryNumber());
    assertTrue(actualBuildSearchQueryFromTemplateResult.getFragments().isEmpty());
    assertTrue(actualBuildSearchQueryFromTemplateResult.getParams().isEmpty());
  }

  /**
   * Test {@link JdbcSearchQueryBuilder#buildSearchQueryFromTemplate(String, int, JdbcSearchQuery, Stream)}.
   * <p>
   * Method under test: {@link JdbcSearchQueryBuilder#buildSearchQueryFromTemplate(String, int, JdbcSearchQuery, Stream)}
   */
  @Test
  @DisplayName("Test buildSearchQueryFromTemplate(String, int, JdbcSearchQuery, Stream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "JdbcSearchQuery JdbcSearchQueryBuilder.buildSearchQueryFromTemplate(String, int, JdbcSearchQuery, Stream)"})
  void testBuildSearchQueryFromTemplate3() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();

    ArrayList<Fragment> fragments = new ArrayList<>();
    fragments.add(new Fragment("\n", "\n", new ArrayList<>()));
    fragments.add(new Fragment("Join Clause", "Where Clause", new ArrayList<>()));
    JdbcSearchQuery queryParts = new JdbcSearchQuery(10, 10, fragments);

    ArrayList<ParamSetter> paramSetterList = new ArrayList<>();
    Stream<ParamSetter> params = paramSetterList.stream();

    // Act
    JdbcSearchQuery actualBuildSearchQueryFromTemplateResult = jdbcSearchQueryBuilder
        .buildSearchQueryFromTemplate("Query Template", 10, queryParts, params);

    // Assert
    assertEquals("Query Template", actualBuildSearchQueryFromTemplateResult.getQuery());
    assertEquals(0, actualBuildSearchQueryFromTemplateResult.getNextAttrNumber());
    assertEquals(0, actualBuildSearchQueryFromTemplateResult.getSubQueryNumber());
    assertEquals(1, actualBuildSearchQueryFromTemplateResult.getNextSubQueryNumber());
    assertTrue(actualBuildSearchQueryFromTemplateResult.getFragments().isEmpty());
    assertTrue(actualBuildSearchQueryFromTemplateResult.getParams().isEmpty());
  }

  /**
   * Test {@link JdbcSearchQueryBuilder#buildSearchExpr(JdbcSearchQuery, SearchExpression)}.
   * <ul>
   *   <li>Then return {@link JdbcSearchQuery#JdbcSearchQuery(String, List)} with {@code Query} and params is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSearchQueryBuilder#buildSearchExpr(JdbcSearchQuery, SearchExpression)}
   */
  @Test
  @DisplayName("Test buildSearchExpr(JdbcSearchQuery, SearchExpression); then return JdbcSearchQuery(String, List) with 'Query' and params is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JdbcSearchQuery JdbcSearchQueryBuilder.buildSearchExpr(JdbcSearchQuery, SearchExpression)"})
  void testBuildSearchExpr_thenReturnJdbcSearchQueryWithQueryAndParamsIsArrayList() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    // Act and Assert
    assertSame(baseQuery, jdbcSearchQueryBuilder.buildSearchExpr(baseQuery, null));
  }

  /**
   * Test {@link JdbcSearchQueryBuilder#buildSearchExpr(JdbcSearchQuery, SearchExpression)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then throw {@link EValidationGap}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSearchQueryBuilder#buildSearchExpr(JdbcSearchQuery, SearchExpression)}
   */
  @Test
  @DisplayName("Test buildSearchExpr(JdbcSearchQuery, SearchExpression); when DefaultInstance; then throw EValidationGap")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JdbcSearchQuery JdbcSearchQueryBuilder.buildSearchExpr(JdbcSearchQuery, SearchExpression)"})
  void testBuildSearchExpr_whenDefaultInstance_thenThrowEValidationGap() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    // Act and Assert
    assertThrows(EValidationGap.class,
        () -> jdbcSearchQueryBuilder.buildSearchExpr(baseQuery, SearchExpression.getDefaultInstance()));
  }

  /**
   * Test {@link JdbcSearchQueryBuilder#buildLogicalExpr(JdbcSearchQuery, LogicalExpression)}.
   * <p>
   * Method under test: {@link JdbcSearchQueryBuilder#buildLogicalExpr(JdbcSearchQuery, LogicalExpression)}
   */
  @Test
  @DisplayName("Test buildLogicalExpr(JdbcSearchQuery, LogicalExpression)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JdbcSearchQuery JdbcSearchQueryBuilder.buildLogicalExpr(JdbcSearchQuery, LogicalExpression)"})
  void testBuildLogicalExpr() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery(
        "Invalid logical expression (operator is missing or not recognised)", new ArrayList<>());

    // Act and Assert
    assertThrows(EValidationGap.class,
        () -> jdbcSearchQueryBuilder.buildLogicalExpr(baseQuery, LogicalExpression.getDefaultInstance()));
  }

  /**
   * Test {@link JdbcSearchQueryBuilder#buildLogicalExpr(JdbcSearchQuery, LogicalExpression)}.
   * <ul>
   *   <li>Then throw {@link EValidationGap}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSearchQueryBuilder#buildLogicalExpr(JdbcSearchQuery, LogicalExpression)}
   */
  @Test
  @DisplayName("Test buildLogicalExpr(JdbcSearchQuery, LogicalExpression); then throw EValidationGap")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JdbcSearchQuery JdbcSearchQueryBuilder.buildLogicalExpr(JdbcSearchQuery, LogicalExpression)"})
  void testBuildLogicalExpr_thenThrowEValidationGap() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    // Act and Assert
    assertThrows(EValidationGap.class,
        () -> jdbcSearchQueryBuilder.buildLogicalExpr(baseQuery, LogicalExpression.getDefaultInstance()));
  }

  /**
   * Test {@link JdbcSearchQueryBuilder#buildSearchTerm(JdbcSearchQuery, SearchTerm)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then throw {@link EValidationGap}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSearchQueryBuilder#buildSearchTerm(JdbcSearchQuery, SearchTerm)}
   */
  @Test
  @DisplayName("Test buildSearchTerm(JdbcSearchQuery, SearchTerm); when DefaultInstance; then throw EValidationGap")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JdbcSearchQuery JdbcSearchQueryBuilder.buildSearchTerm(JdbcSearchQuery, SearchTerm)"})
  void testBuildSearchTerm_whenDefaultInstance_thenThrowEValidationGap() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    // Act and Assert
    assertThrows(EValidationGap.class,
        () -> jdbcSearchQueryBuilder.buildSearchTerm(baseQuery, SearchTerm.getDefaultInstance()));
  }

  /**
   * Test {@link JdbcSearchQueryBuilder#buildLogicalAndOr(JdbcSearchQuery, LogicalExpression, String)}.
   * <ul>
   *   <li>Then return Query is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSearchQueryBuilder#buildLogicalAndOr(JdbcSearchQuery, LogicalExpression, String)}
   */
  @Test
  @DisplayName("Test buildLogicalAndOr(JdbcSearchQuery, LogicalExpression, String); then return Query is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "JdbcSearchQuery JdbcSearchQueryBuilder.buildLogicalAndOr(JdbcSearchQuery, LogicalExpression, String)"})
  void testBuildLogicalAndOr_thenReturnQueryIsEmptyString() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    // Act
    JdbcSearchQuery actualBuildLogicalAndOrResult = jdbcSearchQueryBuilder.buildLogicalAndOr(baseQuery,
        LogicalExpression.getDefaultInstance(), "Op Word");

    // Assert
    assertEquals("", actualBuildLogicalAndOrResult.getQuery());
    List<Fragment> fragments = actualBuildLogicalAndOrResult.getFragments();
    assertEquals(1, fragments.size());
    Fragment getResult = fragments.get(0);
    assertEquals("", getResult.getJoinClause());
    assertEquals("(1 = 1)", getResult.getWhereClause());
    assertEquals(0, actualBuildLogicalAndOrResult.getNextAttrNumber());
    assertEquals(0, actualBuildLogicalAndOrResult.getSubQueryNumber());
    assertEquals(1, actualBuildLogicalAndOrResult.getNextSubQueryNumber());
    assertTrue(actualBuildLogicalAndOrResult.getParams().isEmpty());
    assertTrue(getResult.getParams().isEmpty());
  }

  /**
   * Test {@link JdbcSearchQueryBuilder#buildLogicalNot(JdbcSearchQuery, LogicalExpression)}.
   * <ul>
   *   <li>Then throw {@link EValidationGap}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSearchQueryBuilder#buildLogicalNot(JdbcSearchQuery, LogicalExpression)}
   */
  @Test
  @DisplayName("Test buildLogicalNot(JdbcSearchQuery, LogicalExpression); then throw EValidationGap")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JdbcSearchQuery JdbcSearchQueryBuilder.buildLogicalNot(JdbcSearchQuery, LogicalExpression)"})
  void testBuildLogicalNot_thenThrowEValidationGap() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    // Act and Assert
    assertThrows(EValidationGap.class,
        () -> jdbcSearchQueryBuilder.buildLogicalNot(baseQuery, LogicalExpression.getDefaultInstance()));
  }

  /**
   * Test {@link JdbcSearchQueryBuilder#buildExistsTerm(JdbcSearchQuery, SearchTerm)}.
   * <ul>
   *   <li>Then return Query is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSearchQueryBuilder#buildExistsTerm(JdbcSearchQuery, SearchTerm)}
   */
  @Test
  @DisplayName("Test buildExistsTerm(JdbcSearchQuery, SearchTerm); then return Query is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JdbcSearchQuery JdbcSearchQueryBuilder.buildExistsTerm(JdbcSearchQuery, SearchTerm)"})
  void testBuildExistsTerm_thenReturnQueryIsEmptyString() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    // Act
    JdbcSearchQuery actualBuildExistsTermResult = jdbcSearchQueryBuilder.buildExistsTerm(baseQuery,
        SearchTerm.getDefaultInstance());

    // Assert
    assertEquals("", actualBuildExistsTermResult.getQuery());
    List<Fragment> fragments = actualBuildExistsTermResult.getFragments();
    assertEquals(1, fragments.size());
    Fragment getResult = fragments.get(0);
    assertEquals("(ta0.attr_name = ?)", getResult.getWhereClause());
    assertEquals("join tag_attr ta0\n  on ta0.tenant_id = t0.tenant_id\n  and ta0.tag_fk = t0.tag_pk",
        getResult.getJoinClause());
    assertEquals(0, actualBuildExistsTermResult.getSubQueryNumber());
    assertEquals(1, getResult.getParams().size());
    assertEquals(1, actualBuildExistsTermResult.getNextAttrNumber());
    assertEquals(1, actualBuildExistsTermResult.getNextSubQueryNumber());
    assertTrue(actualBuildExistsTermResult.getParams().isEmpty());
  }

  /**
   * Test {@link JdbcSearchQueryBuilder#buildEqualsTerm(JdbcSearchQuery, SearchTerm)}.
   * <ul>
   *   <li>Then throw {@link EValidationGap}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSearchQueryBuilder#buildEqualsTerm(JdbcSearchQuery, SearchTerm)}
   */
  @Test
  @DisplayName("Test buildEqualsTerm(JdbcSearchQuery, SearchTerm); then throw EValidationGap")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JdbcSearchQuery JdbcSearchQueryBuilder.buildEqualsTerm(JdbcSearchQuery, SearchTerm)"})
  void testBuildEqualsTerm_thenThrowEValidationGap() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    // Act and Assert
    assertThrows(EValidationGap.class,
        () -> jdbcSearchQueryBuilder.buildEqualsTerm(baseQuery, SearchTerm.getDefaultInstance()));
  }

  /**
   * Test {@link JdbcSearchQueryBuilder#buildNotEqualsTerm(JdbcSearchQuery, SearchTerm)}.
   * <ul>
   *   <li>Then throw {@link EValidationGap}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSearchQueryBuilder#buildNotEqualsTerm(JdbcSearchQuery, SearchTerm)}
   */
  @Test
  @DisplayName("Test buildNotEqualsTerm(JdbcSearchQuery, SearchTerm); then throw EValidationGap")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JdbcSearchQuery JdbcSearchQueryBuilder.buildNotEqualsTerm(JdbcSearchQuery, SearchTerm)"})
  void testBuildNotEqualsTerm_thenThrowEValidationGap() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    // Act and Assert
    assertThrows(EValidationGap.class,
        () -> jdbcSearchQueryBuilder.buildNotEqualsTerm(baseQuery, SearchTerm.getDefaultInstance()));
  }

  /**
   * Test {@link JdbcSearchQueryBuilder#buildInequalityTerm(JdbcSearchQuery, SearchTerm)}.
   * <ul>
   *   <li>Then throw {@link EValidationGap}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSearchQueryBuilder#buildInequalityTerm(JdbcSearchQuery, SearchTerm)}
   */
  @Test
  @DisplayName("Test buildInequalityTerm(JdbcSearchQuery, SearchTerm); then throw EValidationGap")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JdbcSearchQuery JdbcSearchQueryBuilder.buildInequalityTerm(JdbcSearchQuery, SearchTerm)"})
  void testBuildInequalityTerm_thenThrowEValidationGap() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    // Act and Assert
    assertThrows(EValidationGap.class,
        () -> jdbcSearchQueryBuilder.buildInequalityTerm(baseQuery, SearchTerm.getDefaultInstance()));
  }

  /**
   * Test {@link JdbcSearchQueryBuilder#buildInTerm(JdbcSearchQuery, SearchTerm)}.
   * <ul>
   *   <li>Then throw {@link EValidationGap}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSearchQueryBuilder#buildInTerm(JdbcSearchQuery, SearchTerm)}
   */
  @Test
  @DisplayName("Test buildInTerm(JdbcSearchQuery, SearchTerm); then throw EValidationGap")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JdbcSearchQuery JdbcSearchQueryBuilder.buildInTerm(JdbcSearchQuery, SearchTerm)"})
  void testBuildInTerm_thenThrowEValidationGap() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    // Act and Assert
    assertThrows(EValidationGap.class,
        () -> jdbcSearchQueryBuilder.buildInTerm(baseQuery, SearchTerm.getDefaultInstance()));
  }

  /**
   * Test {@link JdbcSearchQueryBuilder#buildSearchTermFromTemplatesForExistsOperator(JdbcSearchQuery, SearchTerm, String, String, Stream)}.
   * <ul>
   *   <li>Then return Query is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSearchQueryBuilder#buildSearchTermFromTemplatesForExistsOperator(JdbcSearchQuery, SearchTerm, String, String, Stream)}
   */
  @Test
  @DisplayName("Test buildSearchTermFromTemplatesForExistsOperator(JdbcSearchQuery, SearchTerm, String, String, Stream); then return Query is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "JdbcSearchQuery JdbcSearchQueryBuilder.buildSearchTermFromTemplatesForExistsOperator(JdbcSearchQuery, SearchTerm, String, String, Stream)"})
  void testBuildSearchTermFromTemplatesForExistsOperator_thenReturnQueryIsEmptyString() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    SearchTerm searchTerm = SearchTerm.getDefaultInstance();

    ArrayList<ParamSetter> paramSetterList = new ArrayList<>();
    Stream<ParamSetter> params = paramSetterList.stream();

    // Act
    JdbcSearchQuery actualBuildSearchTermFromTemplatesForExistsOperatorResult = jdbcSearchQueryBuilder
        .buildSearchTermFromTemplatesForExistsOperator(baseQuery, searchTerm, "Join Template", "Where Template",
            params);

    // Assert
    assertEquals("", actualBuildSearchTermFromTemplatesForExistsOperatorResult.getQuery());
    List<Fragment> fragments = actualBuildSearchTermFromTemplatesForExistsOperatorResult.getFragments();
    assertEquals(1, fragments.size());
    Fragment getResult = fragments.get(0);
    assertEquals("(Where Template)", getResult.getWhereClause());
    assertEquals("Join Template", getResult.getJoinClause());
    assertEquals(0, actualBuildSearchTermFromTemplatesForExistsOperatorResult.getSubQueryNumber());
    assertEquals(1, actualBuildSearchTermFromTemplatesForExistsOperatorResult.getNextAttrNumber());
    assertEquals(1, actualBuildSearchTermFromTemplatesForExistsOperatorResult.getNextSubQueryNumber());
    assertTrue(actualBuildSearchTermFromTemplatesForExistsOperatorResult.getParams().isEmpty());
    assertTrue(getResult.getParams().isEmpty());
  }

  /**
   * Test {@link JdbcSearchQueryBuilder#buildSearchTermFromTemplates(JdbcSearchQuery, SearchTerm, String, String, Stream)}.
   * <ul>
   *   <li>Then throw {@link EValidationGap}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSearchQueryBuilder#buildSearchTermFromTemplates(JdbcSearchQuery, SearchTerm, String, String, Stream)}
   */
  @Test
  @DisplayName("Test buildSearchTermFromTemplates(JdbcSearchQuery, SearchTerm, String, String, Stream); then throw EValidationGap")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "JdbcSearchQuery JdbcSearchQueryBuilder.buildSearchTermFromTemplates(JdbcSearchQuery, SearchTerm, String, String, Stream)"})
  void testBuildSearchTermFromTemplates_thenThrowEValidationGap() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    SearchTerm searchTerm = SearchTerm.getDefaultInstance();

    ArrayList<ParamSetter> paramSetterList = new ArrayList<>();
    Stream<ParamSetter> params = paramSetterList.stream();

    // Act and Assert
    assertThrows(EValidationGap.class, () -> jdbcSearchQueryBuilder.buildSearchTermFromTemplates(baseQuery, searchTerm,
        "Join Template", "Where Template", params));
  }

  /**
   * Test {@link JdbcSearchQueryBuilder#buildAsOfCondition(JdbcSearchQuery, SearchParameters)}.
   * <ul>
   *   <li>Then return {@link JdbcSearchQuery#JdbcSearchQuery(String, List)} with {@code Query} and params is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSearchQueryBuilder#buildAsOfCondition(JdbcSearchQuery, SearchParameters)}
   */
  @Test
  @DisplayName("Test buildAsOfCondition(JdbcSearchQuery, SearchParameters); then return JdbcSearchQuery(String, List) with 'Query' and params is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JdbcSearchQuery JdbcSearchQueryBuilder.buildAsOfCondition(JdbcSearchQuery, SearchParameters)"})
  void testBuildAsOfCondition_thenReturnJdbcSearchQueryWithQueryAndParamsIsArrayList() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    // Act and Assert
    assertSame(baseQuery, jdbcSearchQueryBuilder.buildAsOfCondition(baseQuery, SearchParameters.getDefaultInstance()));
  }

  /**
   * Test {@link JdbcSearchQueryBuilder#buildPriorVersions(JdbcSearchQuery, SearchParameters)}.
   * <ul>
   *   <li>Then return Query is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSearchQueryBuilder#buildPriorVersions(JdbcSearchQuery, SearchParameters)}
   */
  @Test
  @DisplayName("Test buildPriorVersions(JdbcSearchQuery, SearchParameters); then return Query is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JdbcSearchQuery JdbcSearchQueryBuilder.buildPriorVersions(JdbcSearchQuery, SearchParameters)"})
  void testBuildPriorVersions_thenReturnQueryIsEmptyString() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    // Act
    JdbcSearchQuery actualBuildPriorVersionsResult = jdbcSearchQueryBuilder.buildPriorVersions(baseQuery,
        SearchParameters.getDefaultInstance());

    // Assert
    assertEquals("", actualBuildPriorVersionsResult.getQuery());
    List<Fragment> fragments = actualBuildPriorVersionsResult.getFragments();
    assertEquals(1, fragments.size());
    Fragment getResult = fragments.get(0);
    assertEquals("join object_definition od0\n" + "  on od0.tenant_id = t0.tenant_id\n"
        + "  and od0.definition_pk = t0.definition_fk", getResult.getJoinClause());
    assertEquals("od0.object_is_latest = ?", getResult.getWhereClause());
    assertEquals(0, actualBuildPriorVersionsResult.getNextAttrNumber());
    assertEquals(0, actualBuildPriorVersionsResult.getSubQueryNumber());
    assertEquals(1, getResult.getParams().size());
    assertEquals(1, actualBuildPriorVersionsResult.getNextSubQueryNumber());
    assertTrue(actualBuildPriorVersionsResult.getParams().isEmpty());
  }

  /**
   * Test {@link JdbcSearchQueryBuilder#buildPriorTags(JdbcSearchQuery, SearchParameters)}.
   * <ul>
   *   <li>Then return Query is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSearchQueryBuilder#buildPriorTags(JdbcSearchQuery, SearchParameters)}
   */
  @Test
  @DisplayName("Test buildPriorTags(JdbcSearchQuery, SearchParameters); then return Query is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JdbcSearchQuery JdbcSearchQueryBuilder.buildPriorTags(JdbcSearchQuery, SearchParameters)"})
  void testBuildPriorTags_thenReturnQueryIsEmptyString() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    // Act
    JdbcSearchQuery actualBuildPriorTagsResult = jdbcSearchQueryBuilder.buildPriorTags(baseQuery,
        SearchParameters.getDefaultInstance());

    // Assert
    assertEquals("", actualBuildPriorTagsResult.getQuery());
    List<Fragment> fragments = actualBuildPriorTagsResult.getFragments();
    assertEquals(1, fragments.size());
    Fragment getResult = fragments.get(0);
    assertEquals("", getResult.getJoinClause());
    assertEquals("t0.tag_is_latest = ?", getResult.getWhereClause());
    assertEquals(0, actualBuildPriorTagsResult.getNextAttrNumber());
    assertEquals(0, actualBuildPriorTagsResult.getSubQueryNumber());
    assertEquals(1, getResult.getParams().size());
    assertEquals(1, actualBuildPriorTagsResult.getNextSubQueryNumber());
    assertTrue(actualBuildPriorTagsResult.getParams().isEmpty());
  }

  /**
   * Test {@link JdbcSearchQueryBuilder#buildPriorFragment(JdbcSearchQuery, Fragment)}.
   * <ul>
   *   <li>Then return Query is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcSearchQueryBuilder#buildPriorFragment(JdbcSearchQuery, Fragment)}
   */
  @Test
  @DisplayName("Test buildPriorFragment(JdbcSearchQuery, Fragment); then return Query is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JdbcSearchQuery JdbcSearchQueryBuilder.buildPriorFragment(JdbcSearchQuery, Fragment)"})
  void testBuildPriorFragment_thenReturnQueryIsEmptyString() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    Fragment fragment = new Fragment("Join Clause", "Where Clause", new ArrayList<>());

    // Act
    JdbcSearchQuery actualBuildPriorFragmentResult = jdbcSearchQueryBuilder.buildPriorFragment(baseQuery, fragment);

    // Assert
    assertEquals("", actualBuildPriorFragmentResult.getQuery());
    assertEquals(0, actualBuildPriorFragmentResult.getNextAttrNumber());
    assertEquals(0, actualBuildPriorFragmentResult.getSubQueryNumber());
    List<Fragment> fragments = actualBuildPriorFragmentResult.getFragments();
    assertEquals(1, fragments.size());
    assertEquals(1, actualBuildPriorFragmentResult.getNextSubQueryNumber());
    assertTrue(actualBuildPriorFragmentResult.getParams().isEmpty());
    assertSame(fragment, fragments.get(0));
  }
}
