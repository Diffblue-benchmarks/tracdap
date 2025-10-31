package org.finos.tracdap.svc.meta.dal.jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.finos.tracdap.common.exception.EValidationGap;
import org.finos.tracdap.metadata.LogicalExpression;
import org.finos.tracdap.metadata.SearchExpression;
import org.finos.tracdap.metadata.SearchParameters;
import org.finos.tracdap.metadata.SearchTerm;
import org.junit.jupiter.api.Test;

class JdbcSearchQueryBuilderDiffblueTest {
  /**
   * Method under test:
   * {@link JdbcSearchQueryBuilder#buildSearchQuery(short, SearchParameters)}
   */
  @Test
  void testBuildSearchQuery() {
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
   * Method under test:
   * {@link JdbcSearchQueryBuilder#buildPriorSearchQuery(short, SearchParameters)}
   */
  @Test
  void testBuildPriorSearchQuery() {
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
   * Method under test:
   * {@link JdbcSearchQueryBuilder#buildCommonSearchQuery(short, SearchParameters, String, String)}
   */
  @Test
  void testBuildCommonSearchQuery() {
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
   * Method under test:
   * {@link JdbcSearchQueryBuilder#buildSearchQueryFromTemplate(String, int, JdbcSearchQuery, Stream)}
   */
  @Test
  void testBuildSearchQueryFromTemplate() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery queryParts = new JdbcSearchQuery("Query", new ArrayList<>());

    ArrayList<JdbcSearchQuery.ParamSetter> paramSetterList = new ArrayList<>();
    Stream<JdbcSearchQuery.ParamSetter> params = paramSetterList.stream();

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
   * Method under test:
   * {@link JdbcSearchQueryBuilder#buildSearchQueryFromTemplate(String, int, JdbcSearchQuery, Stream)}
   */
  @Test
  void testBuildSearchQueryFromTemplate2() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();

    ArrayList<JdbcSearchQuery.ParamSetter> params = new ArrayList<>();
    params.add(mock(JdbcSearchQuery.ParamSetter.class));
    JdbcSearchQuery queryParts = new JdbcSearchQuery("Query", params);

    ArrayList<JdbcSearchQuery.ParamSetter> paramSetterList = new ArrayList<>();
    Stream<JdbcSearchQuery.ParamSetter> params2 = paramSetterList.stream();

    // Act
    JdbcSearchQuery actualBuildSearchQueryFromTemplateResult = jdbcSearchQueryBuilder
        .buildSearchQueryFromTemplate("Query Template", 10, queryParts, params2);

    // Assert
    assertEquals("Query Template", actualBuildSearchQueryFromTemplateResult.getQuery());
    assertEquals(0, actualBuildSearchQueryFromTemplateResult.getNextAttrNumber());
    assertEquals(0, actualBuildSearchQueryFromTemplateResult.getSubQueryNumber());
    assertEquals(1, actualBuildSearchQueryFromTemplateResult.getNextSubQueryNumber());
    assertTrue(actualBuildSearchQueryFromTemplateResult.getFragments().isEmpty());
    assertTrue(actualBuildSearchQueryFromTemplateResult.getParams().isEmpty());
  }

  /**
   * Method under test:
   * {@link JdbcSearchQueryBuilder#buildSearchExpr(JdbcSearchQuery, SearchExpression)}
   */
  @Test
  void testBuildSearchExpr() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    // Act and Assert
    assertThrows(EValidationGap.class,
        () -> jdbcSearchQueryBuilder.buildSearchExpr(baseQuery, SearchExpression.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link JdbcSearchQueryBuilder#buildSearchExpr(JdbcSearchQuery, SearchExpression)}
   */
  @Test
  void testBuildSearchExpr2() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();

    ArrayList<JdbcSearchQuery.ParamSetter> params = new ArrayList<>();
    params.add(mock(JdbcSearchQuery.ParamSetter.class));
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", params);

    // Act and Assert
    assertSame(baseQuery, jdbcSearchQueryBuilder.buildSearchExpr(baseQuery, null));
  }

  /**
   * Method under test:
   * {@link JdbcSearchQueryBuilder#buildLogicalExpr(JdbcSearchQuery, LogicalExpression)}
   */
  @Test
  void testBuildLogicalExpr() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    // Act and Assert
    assertThrows(EValidationGap.class,
        () -> jdbcSearchQueryBuilder.buildLogicalExpr(baseQuery, LogicalExpression.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link JdbcSearchQueryBuilder#buildLogicalExpr(JdbcSearchQuery, LogicalExpression)}
   */
  @Test
  void testBuildLogicalExpr2() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery(
        "Invalid logical expression (operator is missing or not recognised)", new ArrayList<>());

    // Act and Assert
    assertThrows(EValidationGap.class,
        () -> jdbcSearchQueryBuilder.buildLogicalExpr(baseQuery, LogicalExpression.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link JdbcSearchQueryBuilder#buildSearchTerm(JdbcSearchQuery, SearchTerm)}
   */
  @Test
  void testBuildSearchTerm() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    // Act and Assert
    assertThrows(EValidationGap.class,
        () -> jdbcSearchQueryBuilder.buildSearchTerm(baseQuery, SearchTerm.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link JdbcSearchQueryBuilder#buildLogicalAndOr(JdbcSearchQuery, LogicalExpression, String)}
   */
  @Test
  void testBuildLogicalAndOr() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    // Act
    JdbcSearchQuery actualBuildLogicalAndOrResult = jdbcSearchQueryBuilder.buildLogicalAndOr(baseQuery,
        LogicalExpression.getDefaultInstance(), "Op Word");

    // Assert
    assertEquals("", actualBuildLogicalAndOrResult.getQuery());
    List<JdbcSearchQuery.Fragment> fragments = actualBuildLogicalAndOrResult.getFragments();
    assertEquals(1, fragments.size());
    JdbcSearchQuery.Fragment getResult = fragments.get(0);
    assertEquals("", getResult.getJoinClause());
    assertEquals("(1 = 1)", getResult.getWhereClause());
    assertEquals(0, actualBuildLogicalAndOrResult.getNextAttrNumber());
    assertEquals(0, actualBuildLogicalAndOrResult.getSubQueryNumber());
    assertEquals(1, actualBuildLogicalAndOrResult.getNextSubQueryNumber());
    assertTrue(actualBuildLogicalAndOrResult.getParams().isEmpty());
    assertTrue(getResult.getParams().isEmpty());
  }

  /**
   * Method under test:
   * {@link JdbcSearchQueryBuilder#buildLogicalAndOr(JdbcSearchQuery, LogicalExpression, String)}
   */
  @Test
  void testBuildLogicalAndOr2() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();

    ArrayList<JdbcSearchQuery.ParamSetter> params = new ArrayList<>();
    params.add(mock(JdbcSearchQuery.ParamSetter.class));
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", params);

    // Act
    JdbcSearchQuery actualBuildLogicalAndOrResult = jdbcSearchQueryBuilder.buildLogicalAndOr(baseQuery,
        LogicalExpression.getDefaultInstance(), "Op Word");

    // Assert
    assertEquals("", actualBuildLogicalAndOrResult.getQuery());
    List<JdbcSearchQuery.Fragment> fragments = actualBuildLogicalAndOrResult.getFragments();
    assertEquals(1, fragments.size());
    JdbcSearchQuery.Fragment getResult = fragments.get(0);
    assertEquals("", getResult.getJoinClause());
    assertEquals("(1 = 1)", getResult.getWhereClause());
    assertEquals(0, actualBuildLogicalAndOrResult.getNextAttrNumber());
    assertEquals(0, actualBuildLogicalAndOrResult.getSubQueryNumber());
    assertEquals(1, actualBuildLogicalAndOrResult.getNextSubQueryNumber());
    assertTrue(actualBuildLogicalAndOrResult.getParams().isEmpty());
    assertTrue(getResult.getParams().isEmpty());
  }

  /**
   * Method under test:
   * {@link JdbcSearchQueryBuilder#buildLogicalNot(JdbcSearchQuery, LogicalExpression)}
   */
  @Test
  void testBuildLogicalNot() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    // Act and Assert
    assertThrows(EValidationGap.class,
        () -> jdbcSearchQueryBuilder.buildLogicalNot(baseQuery, LogicalExpression.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link JdbcSearchQueryBuilder#buildExistsTerm(JdbcSearchQuery, SearchTerm)}
   */
  @Test
  void testBuildExistsTerm() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    // Act
    JdbcSearchQuery actualBuildExistsTermResult = jdbcSearchQueryBuilder.buildExistsTerm(baseQuery,
        SearchTerm.getDefaultInstance());

    // Assert
    assertEquals("", actualBuildExistsTermResult.getQuery());
    List<JdbcSearchQuery.Fragment> fragments = actualBuildExistsTermResult.getFragments();
    assertEquals(1, fragments.size());
    JdbcSearchQuery.Fragment getResult = fragments.get(0);
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
   * Method under test:
   * {@link JdbcSearchQueryBuilder#buildExistsTerm(JdbcSearchQuery, SearchTerm)}
   */
  @Test
  void testBuildExistsTerm2() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();

    ArrayList<JdbcSearchQuery.ParamSetter> params = new ArrayList<>();
    params.add(mock(JdbcSearchQuery.ParamSetter.class));
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", params);

    // Act
    JdbcSearchQuery actualBuildExistsTermResult = jdbcSearchQueryBuilder.buildExistsTerm(baseQuery,
        SearchTerm.getDefaultInstance());

    // Assert
    assertEquals("", actualBuildExistsTermResult.getQuery());
    List<JdbcSearchQuery.Fragment> fragments = actualBuildExistsTermResult.getFragments();
    assertEquals(1, fragments.size());
    JdbcSearchQuery.Fragment getResult = fragments.get(0);
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
   * Method under test:
   * {@link JdbcSearchQueryBuilder#buildEqualsTerm(JdbcSearchQuery, SearchTerm)}
   */
  @Test
  void testBuildEqualsTerm() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    // Act and Assert
    assertThrows(EValidationGap.class,
        () -> jdbcSearchQueryBuilder.buildEqualsTerm(baseQuery, SearchTerm.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link JdbcSearchQueryBuilder#buildNotEqualsTerm(JdbcSearchQuery, SearchTerm)}
   */
  @Test
  void testBuildNotEqualsTerm() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    // Act and Assert
    assertThrows(EValidationGap.class,
        () -> jdbcSearchQueryBuilder.buildNotEqualsTerm(baseQuery, SearchTerm.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link JdbcSearchQueryBuilder#buildInequalityTerm(JdbcSearchQuery, SearchTerm)}
   */
  @Test
  void testBuildInequalityTerm() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    // Act and Assert
    assertThrows(EValidationGap.class,
        () -> jdbcSearchQueryBuilder.buildInequalityTerm(baseQuery, SearchTerm.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link JdbcSearchQueryBuilder#buildInTerm(JdbcSearchQuery, SearchTerm)}
   */
  @Test
  void testBuildInTerm() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    // Act and Assert
    assertThrows(EValidationGap.class,
        () -> jdbcSearchQueryBuilder.buildInTerm(baseQuery, SearchTerm.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link JdbcSearchQueryBuilder#buildSearchTermFromTemplatesForExistsOperator(JdbcSearchQuery, SearchTerm, String, String, Stream)}
   */
  @Test
  void testBuildSearchTermFromTemplatesForExistsOperator() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    SearchTerm searchTerm = SearchTerm.getDefaultInstance();

    ArrayList<JdbcSearchQuery.ParamSetter> paramSetterList = new ArrayList<>();
    Stream<JdbcSearchQuery.ParamSetter> params = paramSetterList.stream();

    // Act
    JdbcSearchQuery actualBuildSearchTermFromTemplatesForExistsOperatorResult = jdbcSearchQueryBuilder
        .buildSearchTermFromTemplatesForExistsOperator(baseQuery, searchTerm, "Join Template", "Where Template",
            params);

    // Assert
    assertEquals("", actualBuildSearchTermFromTemplatesForExistsOperatorResult.getQuery());
    List<JdbcSearchQuery.Fragment> fragments = actualBuildSearchTermFromTemplatesForExistsOperatorResult.getFragments();
    assertEquals(1, fragments.size());
    JdbcSearchQuery.Fragment getResult = fragments.get(0);
    assertEquals("(Where Template)", getResult.getWhereClause());
    assertEquals("Join Template", getResult.getJoinClause());
    assertEquals(0, actualBuildSearchTermFromTemplatesForExistsOperatorResult.getSubQueryNumber());
    assertEquals(1, actualBuildSearchTermFromTemplatesForExistsOperatorResult.getNextAttrNumber());
    assertEquals(1, actualBuildSearchTermFromTemplatesForExistsOperatorResult.getNextSubQueryNumber());
    assertTrue(actualBuildSearchTermFromTemplatesForExistsOperatorResult.getParams().isEmpty());
    assertTrue(getResult.getParams().isEmpty());
  }

  /**
   * Method under test:
   * {@link JdbcSearchQueryBuilder#buildSearchTermFromTemplatesForExistsOperator(JdbcSearchQuery, SearchTerm, String, String, Stream)}
   */
  @Test
  void testBuildSearchTermFromTemplatesForExistsOperator2() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();

    ArrayList<JdbcSearchQuery.ParamSetter> params = new ArrayList<>();
    params.add(mock(JdbcSearchQuery.ParamSetter.class));
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", params);

    SearchTerm searchTerm = SearchTerm.getDefaultInstance();

    ArrayList<JdbcSearchQuery.ParamSetter> paramSetterList = new ArrayList<>();
    Stream<JdbcSearchQuery.ParamSetter> params2 = paramSetterList.stream();

    // Act
    JdbcSearchQuery actualBuildSearchTermFromTemplatesForExistsOperatorResult = jdbcSearchQueryBuilder
        .buildSearchTermFromTemplatesForExistsOperator(baseQuery, searchTerm, "Join Template", "Where Template",
            params2);

    // Assert
    assertEquals("", actualBuildSearchTermFromTemplatesForExistsOperatorResult.getQuery());
    List<JdbcSearchQuery.Fragment> fragments = actualBuildSearchTermFromTemplatesForExistsOperatorResult.getFragments();
    assertEquals(1, fragments.size());
    JdbcSearchQuery.Fragment getResult = fragments.get(0);
    assertEquals("(Where Template)", getResult.getWhereClause());
    assertEquals("Join Template", getResult.getJoinClause());
    assertEquals(0, actualBuildSearchTermFromTemplatesForExistsOperatorResult.getSubQueryNumber());
    assertEquals(1, actualBuildSearchTermFromTemplatesForExistsOperatorResult.getNextAttrNumber());
    assertEquals(1, actualBuildSearchTermFromTemplatesForExistsOperatorResult.getNextSubQueryNumber());
    assertTrue(actualBuildSearchTermFromTemplatesForExistsOperatorResult.getParams().isEmpty());
    assertTrue(getResult.getParams().isEmpty());
  }

  /**
   * Method under test:
   * {@link JdbcSearchQueryBuilder#buildSearchTermFromTemplates(JdbcSearchQuery, SearchTerm, String, String, Stream)}
   */
  @Test
  void testBuildSearchTermFromTemplates() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    SearchTerm searchTerm = SearchTerm.getDefaultInstance();

    ArrayList<JdbcSearchQuery.ParamSetter> paramSetterList = new ArrayList<>();
    Stream<JdbcSearchQuery.ParamSetter> params = paramSetterList.stream();

    // Act and Assert
    assertThrows(EValidationGap.class, () -> jdbcSearchQueryBuilder.buildSearchTermFromTemplates(baseQuery, searchTerm,
        "Join Template", "Where Template", params));
  }

  /**
   * Method under test:
   * {@link JdbcSearchQueryBuilder#buildAsOfCondition(JdbcSearchQuery, SearchParameters)}
   */
  @Test
  void testBuildAsOfCondition() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    // Act and Assert
    assertSame(baseQuery, jdbcSearchQueryBuilder.buildAsOfCondition(baseQuery, SearchParameters.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link JdbcSearchQueryBuilder#buildAsOfCondition(JdbcSearchQuery, SearchParameters)}
   */
  @Test
  void testBuildAsOfCondition2() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();

    ArrayList<JdbcSearchQuery.ParamSetter> params = new ArrayList<>();
    params.add(mock(JdbcSearchQuery.ParamSetter.class));
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", params);

    // Act and Assert
    assertSame(baseQuery, jdbcSearchQueryBuilder.buildAsOfCondition(baseQuery, SearchParameters.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link JdbcSearchQueryBuilder#buildPriorVersions(JdbcSearchQuery, SearchParameters)}
   */
  @Test
  void testBuildPriorVersions() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    // Act
    JdbcSearchQuery actualBuildPriorVersionsResult = jdbcSearchQueryBuilder.buildPriorVersions(baseQuery,
        SearchParameters.getDefaultInstance());

    // Assert
    assertEquals("", actualBuildPriorVersionsResult.getQuery());
    List<JdbcSearchQuery.Fragment> fragments = actualBuildPriorVersionsResult.getFragments();
    assertEquals(1, fragments.size());
    JdbcSearchQuery.Fragment getResult = fragments.get(0);
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
   * Method under test:
   * {@link JdbcSearchQueryBuilder#buildPriorVersions(JdbcSearchQuery, SearchParameters)}
   */
  @Test
  void testBuildPriorVersions2() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();

    ArrayList<JdbcSearchQuery.ParamSetter> params = new ArrayList<>();
    params.add(mock(JdbcSearchQuery.ParamSetter.class));
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", params);

    // Act
    JdbcSearchQuery actualBuildPriorVersionsResult = jdbcSearchQueryBuilder.buildPriorVersions(baseQuery,
        SearchParameters.getDefaultInstance());

    // Assert
    assertEquals("", actualBuildPriorVersionsResult.getQuery());
    List<JdbcSearchQuery.Fragment> fragments = actualBuildPriorVersionsResult.getFragments();
    assertEquals(1, fragments.size());
    JdbcSearchQuery.Fragment getResult = fragments.get(0);
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
   * Method under test:
   * {@link JdbcSearchQueryBuilder#buildPriorTags(JdbcSearchQuery, SearchParameters)}
   */
  @Test
  void testBuildPriorTags() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    // Act
    JdbcSearchQuery actualBuildPriorTagsResult = jdbcSearchQueryBuilder.buildPriorTags(baseQuery,
        SearchParameters.getDefaultInstance());

    // Assert
    assertEquals("", actualBuildPriorTagsResult.getQuery());
    List<JdbcSearchQuery.Fragment> fragments = actualBuildPriorTagsResult.getFragments();
    assertEquals(1, fragments.size());
    JdbcSearchQuery.Fragment getResult = fragments.get(0);
    assertEquals("", getResult.getJoinClause());
    assertEquals("t0.tag_is_latest = ?", getResult.getWhereClause());
    assertEquals(0, actualBuildPriorTagsResult.getNextAttrNumber());
    assertEquals(0, actualBuildPriorTagsResult.getSubQueryNumber());
    assertEquals(1, getResult.getParams().size());
    assertEquals(1, actualBuildPriorTagsResult.getNextSubQueryNumber());
    assertTrue(actualBuildPriorTagsResult.getParams().isEmpty());
  }

  /**
   * Method under test:
   * {@link JdbcSearchQueryBuilder#buildPriorTags(JdbcSearchQuery, SearchParameters)}
   */
  @Test
  void testBuildPriorTags2() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();

    ArrayList<JdbcSearchQuery.ParamSetter> params = new ArrayList<>();
    params.add(mock(JdbcSearchQuery.ParamSetter.class));
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", params);

    // Act
    JdbcSearchQuery actualBuildPriorTagsResult = jdbcSearchQueryBuilder.buildPriorTags(baseQuery,
        SearchParameters.getDefaultInstance());

    // Assert
    assertEquals("", actualBuildPriorTagsResult.getQuery());
    List<JdbcSearchQuery.Fragment> fragments = actualBuildPriorTagsResult.getFragments();
    assertEquals(1, fragments.size());
    JdbcSearchQuery.Fragment getResult = fragments.get(0);
    assertEquals("", getResult.getJoinClause());
    assertEquals("t0.tag_is_latest = ?", getResult.getWhereClause());
    assertEquals(0, actualBuildPriorTagsResult.getNextAttrNumber());
    assertEquals(0, actualBuildPriorTagsResult.getSubQueryNumber());
    assertEquals(1, getResult.getParams().size());
    assertEquals(1, actualBuildPriorTagsResult.getNextSubQueryNumber());
    assertTrue(actualBuildPriorTagsResult.getParams().isEmpty());
  }

  /**
   * Method under test:
   * {@link JdbcSearchQueryBuilder#buildPriorFragment(JdbcSearchQuery, JdbcSearchQuery.Fragment)}
   */
  @Test
  void testBuildPriorFragment() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", new ArrayList<>());

    JdbcSearchQuery.Fragment fragment = new JdbcSearchQuery.Fragment("Join Clause", "Where Clause", new ArrayList<>());

    // Act
    JdbcSearchQuery actualBuildPriorFragmentResult = jdbcSearchQueryBuilder.buildPriorFragment(baseQuery, fragment);

    // Assert
    assertEquals("", actualBuildPriorFragmentResult.getQuery());
    assertEquals(0, actualBuildPriorFragmentResult.getNextAttrNumber());
    assertEquals(0, actualBuildPriorFragmentResult.getSubQueryNumber());
    List<JdbcSearchQuery.Fragment> fragments = actualBuildPriorFragmentResult.getFragments();
    assertEquals(1, fragments.size());
    assertEquals(1, actualBuildPriorFragmentResult.getNextSubQueryNumber());
    assertTrue(actualBuildPriorFragmentResult.getParams().isEmpty());
    assertSame(fragment, fragments.get(0));
  }

  /**
   * Method under test:
   * {@link JdbcSearchQueryBuilder#buildPriorFragment(JdbcSearchQuery, JdbcSearchQuery.Fragment)}
   */
  @Test
  void testBuildPriorFragment2() {
    // Arrange
    JdbcSearchQueryBuilder jdbcSearchQueryBuilder = new JdbcSearchQueryBuilder();

    ArrayList<JdbcSearchQuery.ParamSetter> params = new ArrayList<>();
    params.add(mock(JdbcSearchQuery.ParamSetter.class));
    JdbcSearchQuery baseQuery = new JdbcSearchQuery("Query", params);

    JdbcSearchQuery.Fragment fragment = new JdbcSearchQuery.Fragment("Join Clause", "Where Clause", new ArrayList<>());

    // Act
    JdbcSearchQuery actualBuildPriorFragmentResult = jdbcSearchQueryBuilder.buildPriorFragment(baseQuery, fragment);

    // Assert
    assertEquals("", actualBuildPriorFragmentResult.getQuery());
    assertEquals(0, actualBuildPriorFragmentResult.getNextAttrNumber());
    assertEquals(0, actualBuildPriorFragmentResult.getSubQueryNumber());
    List<JdbcSearchQuery.Fragment> fragments = actualBuildPriorFragmentResult.getFragments();
    assertEquals(1, fragments.size());
    assertEquals(1, actualBuildPriorFragmentResult.getNextSubQueryNumber());
    assertTrue(actualBuildPriorFragmentResult.getParams().isEmpty());
    assertSame(fragment, fragments.get(0));
  }
}
