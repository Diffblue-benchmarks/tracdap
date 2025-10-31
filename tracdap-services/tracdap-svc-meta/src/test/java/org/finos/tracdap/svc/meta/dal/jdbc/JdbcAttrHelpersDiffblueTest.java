package org.finos.tracdap.svc.meta.dal.jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.finos.tracdap.common.exception.ETracInternal;
import org.finos.tracdap.metadata.ArrayValue;
import org.finos.tracdap.metadata.BasicType;
import org.finos.tracdap.metadata.Value;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JdbcAttrHelpersDiffblueTest {
  /**
   * Test {@link JdbcAttrHelpers#setAttrValue(PreparedStatement, int, BasicType, Value)}.
   * <ul>
   *   <li>When {@code BASIC_TYPE_NOT_SET}.</li>
   *   <li>Then throw {@link ETracInternal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcAttrHelpers#setAttrValue(PreparedStatement, int, BasicType, Value)}
   */
  @Test
  @DisplayName("Test setAttrValue(PreparedStatement, int, BasicType, Value); when 'BASIC_TYPE_NOT_SET'; then throw ETracInternal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JdbcAttrHelpers.setAttrValue(PreparedStatement, int, BasicType, Value)"})
  void testSetAttrValue_whenBasicTypeNotSet_thenThrowETracInternal() throws SQLException {
    // Arrange
    PreparedStatement stmt = mock(PreparedStatement.class);

    // Act and Assert
    assertThrows(ETracInternal.class,
        () -> JdbcAttrHelpers.setAttrValue(stmt, 1, BasicType.BASIC_TYPE_NOT_SET, Value.getDefaultInstance()));
  }

  /**
   * Test {@link JdbcAttrHelpers#readAttrValue(ResultSet)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code attr_type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcAttrHelpers#readAttrValue(ResultSet)}
   */
  @Test
  @DisplayName("Test readAttrValue(ResultSet); given IllegalArgumentException(String) with 'attr_type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value JdbcAttrHelpers.readAttrValue(ResultSet)"})
  void testReadAttrValue_givenIllegalArgumentExceptionWithAttrType() throws SQLException {
    // Arrange
    ResultSet rs = mock(ResultSet.class);
    when(rs.getString(Mockito.<String>any())).thenThrow(new IllegalArgumentException("attr_type"));

    // Act and Assert
    assertThrows(ETracInternal.class, () -> JdbcAttrHelpers.readAttrValue(rs));
    verify(rs).getString(eq("attr_type"));
  }

  /**
   * Test {@link JdbcAttrHelpers#readAttrValue(ResultSet)}.
   * <ul>
   *   <li>Given {@code String}.</li>
   *   <li>When {@link ResultSet} {@link ResultSet#getString(String)} return {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcAttrHelpers#readAttrValue(ResultSet)}
   */
  @Test
  @DisplayName("Test readAttrValue(ResultSet); given 'String'; when ResultSet getString(String) return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value JdbcAttrHelpers.readAttrValue(ResultSet)"})
  void testReadAttrValue_givenString_whenResultSetGetStringReturnString() throws SQLException {
    // Arrange
    ResultSet rs = mock(ResultSet.class);
    when(rs.getString(Mockito.<String>any())).thenReturn("String");

    // Act and Assert
    assertThrows(ETracInternal.class, () -> JdbcAttrHelpers.readAttrValue(rs));
    verify(rs).getString(eq("attr_type"));
  }

  /**
   * Test {@link JdbcAttrHelpers#fetchAttrType(ResultSet)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code attr_type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcAttrHelpers#fetchAttrType(ResultSet)}
   */
  @Test
  @DisplayName("Test fetchAttrType(ResultSet); given IllegalArgumentException(String) with 'attr_type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BasicType JdbcAttrHelpers.fetchAttrType(ResultSet)"})
  void testFetchAttrType_givenIllegalArgumentExceptionWithAttrType() throws SQLException {
    // Arrange
    ResultSet rs = mock(ResultSet.class);
    when(rs.getString(Mockito.<String>any())).thenThrow(new IllegalArgumentException("attr_type"));

    // Act and Assert
    assertThrows(ETracInternal.class, () -> JdbcAttrHelpers.fetchAttrType(rs));
    verify(rs).getString(eq("attr_type"));
  }

  /**
   * Test {@link JdbcAttrHelpers#fetchAttrType(ResultSet)}.
   * <ul>
   *   <li>Given {@code String}.</li>
   *   <li>When {@link ResultSet} {@link ResultSet#getString(String)} return {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcAttrHelpers#fetchAttrType(ResultSet)}
   */
  @Test
  @DisplayName("Test fetchAttrType(ResultSet); given 'String'; when ResultSet getString(String) return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BasicType JdbcAttrHelpers.fetchAttrType(ResultSet)"})
  void testFetchAttrType_givenString_whenResultSetGetStringReturnString() throws SQLException {
    // Arrange
    ResultSet rs = mock(ResultSet.class);
    when(rs.getString(Mockito.<String>any())).thenReturn("String");

    // Act and Assert
    assertThrows(ETracInternal.class, () -> JdbcAttrHelpers.fetchAttrType(rs));
    verify(rs).getString(eq("attr_type"));
  }

  /**
   * Test {@link JdbcAttrHelpers#assembleArrayValue(List)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return ArrayValue ItemsList size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcAttrHelpers#assembleArrayValue(List)}
   */
  @Test
  @DisplayName("Test assembleArrayValue(List); given ArrayList(); then return ArrayValue ItemsList size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value JdbcAttrHelpers.assembleArrayValue(List)"})
  void testAssembleArrayValue_givenArrayList_thenReturnArrayValueItemsListSizeIsOne() {
    // Arrange
    ArrayList<Value> items = new ArrayList<>();
    items.add(Value.getDefaultInstance());
    ArrayList<Value> valueList = new ArrayList<>();
    items.addAll(valueList);

    // Act
    Value actualAssembleArrayValueResult = JdbcAttrHelpers.assembleArrayValue(items);

    // Assert
    ArrayValue arrayValue = actualAssembleArrayValueResult.getArrayValue();
    assertEquals(1, arrayValue.getItemsList().size());
    assertEquals(1, arrayValue.getItemsCount());
    assertEquals(10, actualAssembleArrayValueResult.getSerializedSize());
    assertEquals(2, arrayValue.getSerializedSize());
    assertEquals(valueList, actualAssembleArrayValueResult.getDescriptorForType().toProto().getReservedNameList());
  }

  /**
   * Test {@link JdbcAttrHelpers#assembleArrayValue(List)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return SerializedSize is twelve.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcAttrHelpers#assembleArrayValue(List)}
   */
  @Test
  @DisplayName("Test assembleArrayValue(List); given ArrayList(); then return SerializedSize is twelve")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Value JdbcAttrHelpers.assembleArrayValue(List)"})
  void testAssembleArrayValue_givenArrayList_thenReturnSerializedSizeIsTwelve() {
    // Arrange
    ArrayList<Value> items = new ArrayList<>();
    items.add(Value.getDefaultInstance());
    Value defaultInstance = Value.getDefaultInstance();
    items.add(defaultInstance);
    items.addAll(new ArrayList<>());

    // Act
    Value actualAssembleArrayValueResult = JdbcAttrHelpers.assembleArrayValue(items);

    // Assert
    assertEquals(12, actualAssembleArrayValueResult.getSerializedSize());
    ArrayValue arrayValue = actualAssembleArrayValueResult.getArrayValue();
    List<Value> itemsList = arrayValue.getItemsList();
    assertEquals(2, itemsList.size());
    assertEquals(2, arrayValue.getItemsCount());
    assertEquals(4, arrayValue.getSerializedSize());
    assertSame(defaultInstance, itemsList.get(1));
  }
}
