package org.finos.tracdap.svc.meta.dal.jdbc;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.finos.tracdap.common.exception.ETracInternal;
import org.finos.tracdap.metadata.BasicType;
import org.finos.tracdap.metadata.Value;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JdbcAttrHelpersDiffblueTest {
  /**
   * Method under test:
   * {@link JdbcAttrHelpers#setAttrValue(PreparedStatement, int, BasicType, Value)}
   */
  @Test
  void testSetAttrValue() throws SQLException {
    // Arrange
    PreparedStatement stmt = mock(PreparedStatement.class);

    // Act and Assert
    assertThrows(ETracInternal.class,
        () -> JdbcAttrHelpers.setAttrValue(stmt, 1, BasicType.BASIC_TYPE_NOT_SET, Value.getDefaultInstance()));
  }

  /**
   * Method under test: {@link JdbcAttrHelpers#readAttrValue(ResultSet)}
   */
  @Test
  void testReadAttrValue() throws SQLException {
    // Arrange
    ResultSet rs = mock(ResultSet.class);
    when(rs.getString(Mockito.<String>any())).thenReturn("String");

    // Act and Assert
    assertThrows(ETracInternal.class, () -> JdbcAttrHelpers.readAttrValue(rs));
    verify(rs).getString(eq("attr_type"));
  }

  /**
   * Method under test: {@link JdbcAttrHelpers#readAttrValue(ResultSet)}
   */
  @Test
  void testReadAttrValue2() throws SQLException {
    // Arrange
    ResultSet rs = mock(ResultSet.class);
    when(rs.getString(Mockito.<String>any())).thenThrow(new IllegalArgumentException("attr_type"));

    // Act and Assert
    assertThrows(ETracInternal.class, () -> JdbcAttrHelpers.readAttrValue(rs));
    verify(rs).getString(eq("attr_type"));
  }

  /**
   * Method under test: {@link JdbcAttrHelpers#fetchAttrType(ResultSet)}
   */
  @Test
  void testFetchAttrType() throws SQLException {
    // Arrange
    ResultSet rs = mock(ResultSet.class);
    when(rs.getString(Mockito.<String>any())).thenReturn("String");

    // Act and Assert
    assertThrows(ETracInternal.class, () -> JdbcAttrHelpers.fetchAttrType(rs));
    verify(rs).getString(eq("attr_type"));
  }

  /**
   * Method under test: {@link JdbcAttrHelpers#fetchAttrType(ResultSet)}
   */
  @Test
  void testFetchAttrType2() throws SQLException {
    // Arrange
    ResultSet rs = mock(ResultSet.class);
    when(rs.getString(Mockito.<String>any())).thenThrow(new IllegalArgumentException("attr_type"));

    // Act and Assert
    assertThrows(ETracInternal.class, () -> JdbcAttrHelpers.fetchAttrType(rs));
    verify(rs).getString(eq("attr_type"));
  }
}
