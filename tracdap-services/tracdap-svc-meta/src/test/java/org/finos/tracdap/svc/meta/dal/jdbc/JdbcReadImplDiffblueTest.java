package org.finos.tracdap.svc.meta.dal.jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.anyShort;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Map;
import java.util.UUID;
import org.finos.tracdap.common.exception.EValidationGap;
import org.finos.tracdap.metadata.ObjectDefinition;
import org.finos.tracdap.metadata.TagSelector;
import org.finos.tracdap.metadata.Value;
import org.finos.tracdap.svc.meta.dal.jdbc.JdbcBaseDal.KeyedItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JdbcReadImplDiffblueTest {
  /**
   * Test {@link JdbcReadImpl#readObjectTypeById(Connection, short, UUID)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then throw {@link JdbcException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readObjectTypeById(Connection, short, UUID)}
   */
  @Test
  @DisplayName("Test readObjectTypeById(Connection, short, UUID); given ResultSet next() return 'false'; then throw JdbcException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readObjectTypeById(Connection, short, UUID)"})
  void testReadObjectTypeById_givenResultSetNextReturnFalse_thenThrowJdbcException() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readObjectTypeById(conn, (short) 1, UUID.randomUUID()));
    verify(conn).prepareStatement(eq(
        "select object_pk, object_type\nfrom object_id\nwhere tenant_id = ?\nand object_id_hi = ?\nand object_id_lo = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).next();
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcReadImpl#readObjectTypeById(Connection, short, UUID)}.
   * <ul>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readObjectTypeById(Connection, short, UUID)}
   */
  @Test
  @DisplayName("Test readObjectTypeById(Connection, short, UUID); then throw SQLException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readObjectTypeById(Connection, short, UUID)"})
  void testReadObjectTypeById_thenThrowSQLException() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenThrow(new SQLException());
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(SQLException.class, () -> jdbcReadImpl.readObjectTypeById(conn, (short) 1, UUID.randomUUID()));
    verify(conn).prepareStatement(eq(
        "select object_pk, object_type\nfrom object_id\nwhere tenant_id = ?\nand object_id_hi = ?\nand object_id_lo = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet).next();
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinition(Connection, short, long, TagSelector)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then throw {@link EValidationGap}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinition(Connection, short, long, TagSelector)}
   */
  @Test
  @DisplayName("Test readDefinition(Connection, short, long, TagSelector); when DefaultInstance; then throw EValidationGap")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinition(Connection, short, long, TagSelector)"})
  void testReadDefinition_whenDefaultInstance_thenThrowEValidationGap() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Connection conn = mock(Connection.class);

    // Act and Assert
    assertThrows(EValidationGap.class,
        () -> jdbcReadImpl.readDefinition(conn, (short) 1, 1L, TagSelector.getDefaultInstance()));
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}.
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}
   */
  @Test
  @DisplayName("Test readDefinitionByVersion(Connection, short, long, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByVersion(Connection, short, long, int)"})
  void testReadDefinitionByVersion() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBytes(anyInt())).thenReturn(new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readDefinitionByVersion(conn, (short) 1, 1L, 1));
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\nand object_fk = ?\nand object_version = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setInt(eq(3), eq(1));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getBytes(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}.
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}
   */
  @Test
  @DisplayName("Test readDefinitionByVersion(Connection, short, long, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByVersion(Connection, short, long, int)"})
  void testReadDefinitionByVersion2() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBytes(anyInt())).thenReturn(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readDefinitionByVersion(conn, (short) 1, 1L, 1));
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\nand object_fk = ?\nand object_version = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setInt(eq(3), eq(1));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getBytes(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}.
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}
   */
  @Test
  @DisplayName("Test readDefinitionByVersion(Connection, short, long, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByVersion(Connection, short, long, int)"})
  void testReadDefinitionByVersion3() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBytes(anyInt())).thenReturn(new byte[]{26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readDefinitionByVersion(conn, (short) 1, 1L, 1));
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\nand object_fk = ?\nand object_version = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setInt(eq(3), eq(1));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getBytes(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}.
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}
   */
  @Test
  @DisplayName("Test readDefinitionByVersion(Connection, short, long, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByVersion(Connection, short, long, int)"})
  void testReadDefinitionByVersion4() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE));
    when(resultSet.getBytes(anyInt())).thenReturn(new byte[]{});
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readDefinitionByVersion(conn, (short) 1, 1L, 1));
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\nand object_fk = ?\nand object_version = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setInt(eq(3), eq(1));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(5));
    verify(resultSet).getBytes(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getBoolean(int)} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}
   */
  @Test
  @DisplayName("Test readDefinitionByVersion(Connection, short, long, int); given ResultSet getBoolean(int) return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByVersion(Connection, short, long, int)"})
  void testReadDefinitionByVersion_givenResultSetGetBooleanReturnTrue() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getBytes(anyInt())).thenReturn(new byte[]{});
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readDefinitionByVersion(conn, (short) 1, 1L, 1));
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\nand object_fk = ?\nand object_version = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setInt(eq(3), eq(1));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(5));
    verify(resultSet).getBytes(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getBytes(int)} return array of {@code byte} with one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}
   */
  @Test
  @DisplayName("Test readDefinitionByVersion(Connection, short, long, int); given ResultSet getBytes(int) return array of byte with one and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByVersion(Connection, short, long, int)"})
  void testReadDefinitionByVersion_givenResultSetGetBytesReturnArrayOfByteWithOneAndX() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBytes(anyInt())).thenReturn(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readDefinitionByVersion(conn, (short) 1, 1L, 1));
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\nand object_fk = ?\nand object_version = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setInt(eq(3), eq(1));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getBytes(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getBytes(int)} return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}
   */
  @Test
  @DisplayName("Test readDefinitionByVersion(Connection, short, long, int); given ResultSet getBytes(int) return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByVersion(Connection, short, long, int)"})
  void testReadDefinitionByVersion_givenResultSetGetBytesReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBytes(anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readDefinitionByVersion(conn, (short) 1, 1L, 1));
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\nand object_fk = ?\nand object_version = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setInt(eq(3), eq(1));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getBytes(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getBytes(int)} return {@code "XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}
   */
  @Test
  @DisplayName("Test readDefinitionByVersion(Connection, short, long, int); given ResultSet getBytes(int) return '\"XAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByVersion(Connection, short, long, int)"})
  void testReadDefinitionByVersion_givenResultSetGetBytesReturnXaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBytes(anyInt())).thenReturn("\"XAXAXAX".getBytes("UTF-8"));
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readDefinitionByVersion(conn, (short) 1, 1L, 1));
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\nand object_fk = ?\nand object_version = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setInt(eq(3), eq(1));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getBytes(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then throw {@link JdbcException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}
   */
  @Test
  @DisplayName("Test readDefinitionByVersion(Connection, short, long, int); given ResultSet next() return 'false'; then throw JdbcException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByVersion(Connection, short, long, int)"})
  void testReadDefinitionByVersion_givenResultSetNextReturnFalse_thenThrowJdbcException() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readDefinitionByVersion(conn, (short) 1, 1L, 1));
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\nand object_fk = ?\nand object_version = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setInt(eq(3), eq(1));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).next();
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}.
   * <ul>
   *   <li>Then return {@link KeyedItem#version} is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}
   */
  @Test
  @DisplayName("Test readDefinitionByVersion(Connection, short, long, int); then return version is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByVersion(Connection, short, long, int)"})
  void testReadDefinitionByVersion_thenReturnVersionIsOne() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getBytes(anyInt())).thenReturn(new byte[]{});
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    KeyedItem<ObjectDefinition> actualReadDefinitionByVersionResult = jdbcReadImpl.readDefinitionByVersion(conn,
        (short) 1, 1L, 1);

    // Assert
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\nand object_fk = ?\nand object_version = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setInt(eq(3), eq(1));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(5));
    verify(resultSet).getBytes(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
    assertEquals(1, actualReadDefinitionByVersionResult.version);
    assertEquals(1L, actualReadDefinitionByVersionResult.key);
    assertTrue(actualReadDefinitionByVersionResult.isLatest);
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}.
   * <ul>
   *   <li>Then throw {@link EValidationGap}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}
   */
  @Test
  @DisplayName("Test readDefinitionByVersion(Connection, short, long, int); then throw EValidationGap")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByVersion(Connection, short, long, int)"})
  void testReadDefinitionByVersion_thenThrowEValidationGap() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenThrow(new EValidationGap("Not all who wander are lost"));
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(EValidationGap.class, () -> jdbcReadImpl.readDefinitionByVersion(conn, (short) 1, 1L, 1));
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\nand object_fk = ?\nand object_version = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setInt(eq(3), eq(1));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}.
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}
   */
  @Test
  @DisplayName("Test readDefinitionByAsOf(Connection, short, long, Instant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByAsOf(Connection, short, long, Instant)"})
  void testReadDefinitionByAsOf() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBytes(anyInt())).thenReturn(new byte[]{26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readDefinitionByAsOf(conn, (short) 1, 1L,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\nand object_fk = ?\nand object_timestamp <= ?\nand (object_superseded is null or object_superseded > ?)\n"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(preparedStatement, atLeast(1)).setTimestamp(anyInt(), isA(Timestamp.class));
    verify(resultSet).close();
    verify(resultSet).getBytes(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}.
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}
   */
  @Test
  @DisplayName("Test readDefinitionByAsOf(Connection, short, long, Instant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByAsOf(Connection, short, long, Instant)"})
  void testReadDefinitionByAsOf2() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE));
    when(resultSet.getBytes(anyInt())).thenReturn(new byte[]{});
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readDefinitionByAsOf(conn, (short) 1, 1L,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\nand object_fk = ?\nand object_timestamp <= ?\nand (object_superseded is null or object_superseded > ?)\n"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(preparedStatement, atLeast(1)).setTimestamp(anyInt(), isA(Timestamp.class));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(5));
    verify(resultSet).getBytes(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getBoolean(int)} return {@code true}.</li>
   *   <li>Then calls {@link ResultSet#getBoolean(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}
   */
  @Test
  @DisplayName("Test readDefinitionByAsOf(Connection, short, long, Instant); given ResultSet getBoolean(int) return 'true'; then calls getBoolean(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByAsOf(Connection, short, long, Instant)"})
  void testReadDefinitionByAsOf_givenResultSetGetBooleanReturnTrue_thenCallsGetBoolean() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getBytes(anyInt())).thenReturn(new byte[]{});
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readDefinitionByAsOf(conn, (short) 1, 1L,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\nand object_fk = ?\nand object_timestamp <= ?\nand (object_superseded is null or object_superseded > ?)\n"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(preparedStatement, atLeast(1)).setTimestamp(anyInt(), isA(Timestamp.class));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(5));
    verify(resultSet).getBytes(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getBytes(int)} return array of {@code byte} with eighteen and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}
   */
  @Test
  @DisplayName("Test readDefinitionByAsOf(Connection, short, long, Instant); given ResultSet getBytes(int) return array of byte with eighteen and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByAsOf(Connection, short, long, Instant)"})
  void testReadDefinitionByAsOf_givenResultSetGetBytesReturnArrayOfByteWithEighteenAndX() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBytes(anyInt())).thenReturn(new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readDefinitionByAsOf(conn, (short) 1, 1L,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\nand object_fk = ?\nand object_timestamp <= ?\nand (object_superseded is null or object_superseded > ?)\n"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(preparedStatement, atLeast(1)).setTimestamp(anyInt(), isA(Timestamp.class));
    verify(resultSet).close();
    verify(resultSet).getBytes(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getBytes(int)} return array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}
   */
  @Test
  @DisplayName("Test readDefinitionByAsOf(Connection, short, long, Instant); given ResultSet getBytes(int) return array of byte with minus one and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByAsOf(Connection, short, long, Instant)"})
  void testReadDefinitionByAsOf_givenResultSetGetBytesReturnArrayOfByteWithMinusOneAndX() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBytes(anyInt())).thenReturn(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readDefinitionByAsOf(conn, (short) 1, 1L,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\nand object_fk = ?\nand object_timestamp <= ?\nand (object_superseded is null or object_superseded > ?)\n"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(preparedStatement, atLeast(1)).setTimestamp(anyInt(), isA(Timestamp.class));
    verify(resultSet).close();
    verify(resultSet).getBytes(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getBytes(int)} return array of {@code byte} with one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}
   */
  @Test
  @DisplayName("Test readDefinitionByAsOf(Connection, short, long, Instant); given ResultSet getBytes(int) return array of byte with one and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByAsOf(Connection, short, long, Instant)"})
  void testReadDefinitionByAsOf_givenResultSetGetBytesReturnArrayOfByteWithOneAndX() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBytes(anyInt())).thenReturn(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readDefinitionByAsOf(conn, (short) 1, 1L,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\nand object_fk = ?\nand object_timestamp <= ?\nand (object_superseded is null or object_superseded > ?)\n"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(preparedStatement, atLeast(1)).setTimestamp(anyInt(), isA(Timestamp.class));
    verify(resultSet).close();
    verify(resultSet).getBytes(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getBytes(int)} return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}
   */
  @Test
  @DisplayName("Test readDefinitionByAsOf(Connection, short, long, Instant); given ResultSet getBytes(int) return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByAsOf(Connection, short, long, Instant)"})
  void testReadDefinitionByAsOf_givenResultSetGetBytesReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBytes(anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readDefinitionByAsOf(conn, (short) 1, 1L,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\nand object_fk = ?\nand object_timestamp <= ?\nand (object_superseded is null or object_superseded > ?)\n"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(preparedStatement, atLeast(1)).setTimestamp(anyInt(), isA(Timestamp.class));
    verify(resultSet).close();
    verify(resultSet).getBytes(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getBytes(int)} return {@code "XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}
   */
  @Test
  @DisplayName("Test readDefinitionByAsOf(Connection, short, long, Instant); given ResultSet getBytes(int) return '\"XAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByAsOf(Connection, short, long, Instant)"})
  void testReadDefinitionByAsOf_givenResultSetGetBytesReturnXaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBytes(anyInt())).thenReturn("\"XAXAXAX".getBytes("UTF-8"));
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readDefinitionByAsOf(conn, (short) 1, 1L,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\nand object_fk = ?\nand object_timestamp <= ?\nand (object_superseded is null or object_superseded > ?)\n"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(preparedStatement, atLeast(1)).setTimestamp(anyInt(), isA(Timestamp.class));
    verify(resultSet).close();
    verify(resultSet).getBytes(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then throw {@link JdbcException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}
   */
  @Test
  @DisplayName("Test readDefinitionByAsOf(Connection, short, long, Instant); given ResultSet next() return 'false'; then throw JdbcException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByAsOf(Connection, short, long, Instant)"})
  void testReadDefinitionByAsOf_givenResultSetNextReturnFalse_thenThrowJdbcException() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readDefinitionByAsOf(conn, (short) 1, 1L,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\nand object_fk = ?\nand object_timestamp <= ?\nand (object_superseded is null or object_superseded > ?)\n"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(preparedStatement, atLeast(1)).setTimestamp(anyInt(), isA(Timestamp.class));
    verify(resultSet).close();
    verify(resultSet).next();
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}.
   * <ul>
   *   <li>Then return {@link KeyedItem#version} is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}
   */
  @Test
  @DisplayName("Test readDefinitionByAsOf(Connection, short, long, Instant); then return version is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByAsOf(Connection, short, long, Instant)"})
  void testReadDefinitionByAsOf_thenReturnVersionIsOne() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getBytes(anyInt())).thenReturn(new byte[]{});
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    KeyedItem<ObjectDefinition> actualReadDefinitionByAsOfResult = jdbcReadImpl.readDefinitionByAsOf(conn, (short) 1,
        1L, LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\nand object_fk = ?\nand object_timestamp <= ?\nand (object_superseded is null or object_superseded > ?)\n"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(preparedStatement, atLeast(1)).setTimestamp(anyInt(), isA(Timestamp.class));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(5));
    verify(resultSet).getBytes(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
    assertEquals(1, actualReadDefinitionByAsOfResult.version);
    assertEquals(1L, actualReadDefinitionByAsOfResult.key);
    assertTrue(actualReadDefinitionByAsOfResult.isLatest);
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}.
   * <ul>
   *   <li>Then throw {@link EValidationGap}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}
   */
  @Test
  @DisplayName("Test readDefinitionByAsOf(Connection, short, long, Instant); then throw EValidationGap")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByAsOf(Connection, short, long, Instant)"})
  void testReadDefinitionByAsOf_thenThrowEValidationGap() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenThrow(new EValidationGap("Not all who wander are lost"));
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(EValidationGap.class, () -> jdbcReadImpl.readDefinitionByAsOf(conn, (short) 1, 1L,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\nand object_fk = ?\nand object_timestamp <= ?\nand (object_superseded is null or object_superseded > ?)\n"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(preparedStatement, atLeast(1)).setTimestamp(anyInt(), isA(Timestamp.class));
    verify(resultSet).close();
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}.
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}
   */
  @Test
  @DisplayName("Test readDefinitionByLatest(Connection, short, long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByLatest(Connection, short, long)"})
  void testReadDefinitionByLatest() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBytes(anyInt())).thenReturn(new byte[]{18, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readDefinitionByLatest(conn, (short) 1, 1L));
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\n  and object_fk = ?\n  and object_is_latest = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setBoolean(eq(3), eq(true));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getBytes(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}.
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}
   */
  @Test
  @DisplayName("Test readDefinitionByLatest(Connection, short, long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByLatest(Connection, short, long)"})
  void testReadDefinitionByLatest2() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBytes(anyInt())).thenReturn(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readDefinitionByLatest(conn, (short) 1, 1L));
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\n  and object_fk = ?\n  and object_is_latest = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setBoolean(eq(3), eq(true));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getBytes(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}.
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}
   */
  @Test
  @DisplayName("Test readDefinitionByLatest(Connection, short, long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByLatest(Connection, short, long)"})
  void testReadDefinitionByLatest3() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBytes(anyInt())).thenReturn(new byte[]{26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readDefinitionByLatest(conn, (short) 1, 1L));
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\n  and object_fk = ?\n  and object_is_latest = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setBoolean(eq(3), eq(true));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getBytes(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}.
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}
   */
  @Test
  @DisplayName("Test readDefinitionByLatest(Connection, short, long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByLatest(Connection, short, long)"})
  void testReadDefinitionByLatest4() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenThrow(new JdbcException(JdbcErrorCode.UNKNOWN_ERROR_CODE));
    when(resultSet.getBytes(anyInt())).thenReturn(new byte[]{});
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readDefinitionByLatest(conn, (short) 1, 1L));
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\n  and object_fk = ?\n  and object_is_latest = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setBoolean(eq(3), eq(true));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(5));
    verify(resultSet).getBytes(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getBoolean(int)} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}
   */
  @Test
  @DisplayName("Test readDefinitionByLatest(Connection, short, long); given ResultSet getBoolean(int) return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByLatest(Connection, short, long)"})
  void testReadDefinitionByLatest_givenResultSetGetBooleanReturnTrue() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getBytes(anyInt())).thenReturn(new byte[]{});
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readDefinitionByLatest(conn, (short) 1, 1L));
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\n  and object_fk = ?\n  and object_is_latest = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setBoolean(eq(3), eq(true));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(5));
    verify(resultSet).getBytes(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getBytes(int)} return array of {@code byte} with one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}
   */
  @Test
  @DisplayName("Test readDefinitionByLatest(Connection, short, long); given ResultSet getBytes(int) return array of byte with one and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByLatest(Connection, short, long)"})
  void testReadDefinitionByLatest_givenResultSetGetBytesReturnArrayOfByteWithOneAndX() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBytes(anyInt())).thenReturn(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readDefinitionByLatest(conn, (short) 1, 1L));
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\n  and object_fk = ?\n  and object_is_latest = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setBoolean(eq(3), eq(true));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getBytes(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getBytes(int)} return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}
   */
  @Test
  @DisplayName("Test readDefinitionByLatest(Connection, short, long); given ResultSet getBytes(int) return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByLatest(Connection, short, long)"})
  void testReadDefinitionByLatest_givenResultSetGetBytesReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBytes(anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readDefinitionByLatest(conn, (short) 1, 1L));
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\n  and object_fk = ?\n  and object_is_latest = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setBoolean(eq(3), eq(true));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getBytes(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getBytes(int)} return {@code "XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}
   */
  @Test
  @DisplayName("Test readDefinitionByLatest(Connection, short, long); given ResultSet getBytes(int) return '\"XAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByLatest(Connection, short, long)"})
  void testReadDefinitionByLatest_givenResultSetGetBytesReturnXaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBytes(anyInt())).thenReturn("\"XAXAXAX".getBytes("UTF-8"));
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readDefinitionByLatest(conn, (short) 1, 1L));
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\n  and object_fk = ?\n  and object_is_latest = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setBoolean(eq(3), eq(true));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getBytes(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then throw {@link JdbcException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}
   */
  @Test
  @DisplayName("Test readDefinitionByLatest(Connection, short, long); given ResultSet next() return 'false'; then throw JdbcException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByLatest(Connection, short, long)"})
  void testReadDefinitionByLatest_givenResultSetNextReturnFalse_thenThrowJdbcException() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readDefinitionByLatest(conn, (short) 1, 1L));
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\n  and object_fk = ?\n  and object_is_latest = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setBoolean(eq(3), eq(true));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).next();
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}.
   * <ul>
   *   <li>Then return {@link KeyedItem#version} is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}
   */
  @Test
  @DisplayName("Test readDefinitionByLatest(Connection, short, long); then return version is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByLatest(Connection, short, long)"})
  void testReadDefinitionByLatest_thenReturnVersionIsOne() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getBytes(anyInt())).thenReturn(new byte[]{});
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    KeyedItem<ObjectDefinition> actualReadDefinitionByLatestResult = jdbcReadImpl.readDefinitionByLatest(conn,
        (short) 1, 1L);

    // Assert
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\n  and object_fk = ?\n  and object_is_latest = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setBoolean(eq(3), eq(true));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(5));
    verify(resultSet).getBytes(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
    assertEquals(1, actualReadDefinitionByLatestResult.version);
    assertEquals(1L, actualReadDefinitionByLatestResult.key);
    assertTrue(actualReadDefinitionByLatestResult.isLatest);
  }

  /**
   * Test {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}.
   * <ul>
   *   <li>Then throw {@link EValidationGap}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}
   */
  @Test
  @DisplayName("Test readDefinitionByLatest(Connection, short, long); then throw EValidationGap")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readDefinitionByLatest(Connection, short, long)"})
  void testReadDefinitionByLatest_thenThrowEValidationGap() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenThrow(new EValidationGap("Not all who wander are lost"));
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(EValidationGap.class, () -> jdbcReadImpl.readDefinitionByLatest(conn, (short) 1, 1L));
    verify(conn).prepareStatement(eq(
        "select definition_pk, object_version, object_timestamp, definition, object_is_latest\nfrom object_definition\nwhere tenant_id = ?\n  and object_fk = ?\n  and object_is_latest = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setBoolean(eq(3), eq(true));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readTagRecord(Connection, short, long, TagSelector)} with {@code conn}, {@code tenantId}, {@code definitionPk}, {@code selector}.
   * <ul>
   *   <li>Then throw {@link EValidationGap}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readTagRecord(Connection, short, long, TagSelector)}
   */
  @Test
  @DisplayName("Test readTagRecord(Connection, short, long, TagSelector) with 'conn', 'tenantId', 'definitionPk', 'selector'; then throw EValidationGap")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readTagRecord(Connection, short, long, TagSelector)"})
  void testReadTagRecordWithConnTenantIdDefinitionPkSelector_thenThrowEValidationGap() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Connection conn = mock(Connection.class);

    // Act and Assert
    assertThrows(EValidationGap.class,
        () -> jdbcReadImpl.readTagRecord(conn, (short) 1, 1L, TagSelector.getDefaultInstance()));
  }

  /**
   * Test {@link JdbcReadImpl#readTagRecordByVersion(Connection, short, long, int)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then throw {@link JdbcException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readTagRecordByVersion(Connection, short, long, int)}
   */
  @Test
  @DisplayName("Test readTagRecordByVersion(Connection, short, long, int); given ResultSet next() return 'false'; then throw JdbcException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readTagRecordByVersion(Connection, short, long, int)"})
  void testReadTagRecordByVersion_givenResultSetNextReturnFalse_thenThrowJdbcException() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readTagRecordByVersion(conn, (short) 1, 1L, 1));
    verify(conn).prepareStatement(eq(
        "select tag_pk, tag_version, tag_timestamp, tag_is_latest\nfrom tag\nwhere tenant_id = ?\nand definition_fk = ?\nand tag_version = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setInt(eq(3), eq(1));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).next();
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcReadImpl#readTagRecordByVersion(Connection, short, long, int)}.
   * <ul>
   *   <li>Then return {@link KeyedItem#item} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readTagRecordByVersion(Connection, short, long, int)}
   */
  @Test
  @DisplayName("Test readTagRecordByVersion(Connection, short, long, int); then return item is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readTagRecordByVersion(Connection, short, long, int)"})
  void testReadTagRecordByVersion_thenReturnItemIsNull() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    KeyedItem<Void> actualReadTagRecordByVersionResult = jdbcReadImpl.readTagRecordByVersion(conn, (short) 1, 1L, 1);

    // Assert
    verify(conn).prepareStatement(eq(
        "select tag_pk, tag_version, tag_timestamp, tag_is_latest\nfrom tag\nwhere tenant_id = ?\nand definition_fk = ?\nand tag_version = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setInt(eq(3), eq(1));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
    assertNull(actualReadTagRecordByVersionResult.item);
    Instant instant = actualReadTagRecordByVersionResult.timestamp;
    assertEquals(0, instant.getNano());
    assertEquals(0L, instant.getEpochSecond());
    assertEquals(1, actualReadTagRecordByVersionResult.version);
    assertEquals(1L, actualReadTagRecordByVersionResult.key);
    assertTrue(actualReadTagRecordByVersionResult.isLatest);
  }

  /**
   * Test {@link JdbcReadImpl#readTagRecordByVersion(Connection, short, long, int)}.
   * <ul>
   *   <li>Then throw {@link EValidationGap}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readTagRecordByVersion(Connection, short, long, int)}
   */
  @Test
  @DisplayName("Test readTagRecordByVersion(Connection, short, long, int); then throw EValidationGap")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readTagRecordByVersion(Connection, short, long, int)"})
  void testReadTagRecordByVersion_thenThrowEValidationGap() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenThrow(new EValidationGap("Not all who wander are lost"));
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(EValidationGap.class, () -> jdbcReadImpl.readTagRecordByVersion(conn, (short) 1, 1L, 1));
    verify(conn).prepareStatement(eq(
        "select tag_pk, tag_version, tag_timestamp, tag_is_latest\nfrom tag\nwhere tenant_id = ?\nand definition_fk = ?\nand tag_version = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setInt(eq(3), eq(1));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readTagRecordByVersion(Connection, short, long, int)}.
   * <ul>
   *   <li>Then throw {@link JdbcException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readTagRecordByVersion(Connection, short, long, int)}
   */
  @Test
  @DisplayName("Test readTagRecordByVersion(Connection, short, long, int); then throw JdbcException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readTagRecordByVersion(Connection, short, long, int)"})
  void testReadTagRecordByVersion_thenThrowJdbcException() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readTagRecordByVersion(conn, (short) 1, 1L, 1));
    verify(conn).prepareStatement(eq(
        "select tag_pk, tag_version, tag_timestamp, tag_is_latest\nfrom tag\nwhere tenant_id = ?\nand definition_fk = ?\nand tag_version = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setInt(eq(3), eq(1));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readTagRecordByAsOf(Connection, short, long, Instant)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then throw {@link JdbcException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readTagRecordByAsOf(Connection, short, long, Instant)}
   */
  @Test
  @DisplayName("Test readTagRecordByAsOf(Connection, short, long, Instant); given ResultSet next() return 'false'; then throw JdbcException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readTagRecordByAsOf(Connection, short, long, Instant)"})
  void testReadTagRecordByAsOf_givenResultSetNextReturnFalse_thenThrowJdbcException() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readTagRecordByAsOf(conn, (short) 1, 1L,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    verify(conn).prepareStatement(eq(
        "select tag_pk, tag_version, tag_timestamp, tag_is_latest\nfrom tag\nwhere tenant_id = ?\nand definition_fk = ?\nand tag_timestamp <= ?\nand (tag_superseded is null or tag_superseded > ?)\n"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(preparedStatement, atLeast(1)).setTimestamp(anyInt(), isA(Timestamp.class));
    verify(resultSet).close();
    verify(resultSet).next();
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcReadImpl#readTagRecordByAsOf(Connection, short, long, Instant)}.
   * <ul>
   *   <li>Then return {@link KeyedItem#item} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readTagRecordByAsOf(Connection, short, long, Instant)}
   */
  @Test
  @DisplayName("Test readTagRecordByAsOf(Connection, short, long, Instant); then return item is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readTagRecordByAsOf(Connection, short, long, Instant)"})
  void testReadTagRecordByAsOf_thenReturnItemIsNull() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    KeyedItem<Void> actualReadTagRecordByAsOfResult = jdbcReadImpl.readTagRecordByAsOf(conn, (short) 1, 1L,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(conn).prepareStatement(eq(
        "select tag_pk, tag_version, tag_timestamp, tag_is_latest\nfrom tag\nwhere tenant_id = ?\nand definition_fk = ?\nand tag_timestamp <= ?\nand (tag_superseded is null or tag_superseded > ?)\n"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(preparedStatement, atLeast(1)).setTimestamp(anyInt(), isA(Timestamp.class));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
    assertNull(actualReadTagRecordByAsOfResult.item);
    Instant instant = actualReadTagRecordByAsOfResult.timestamp;
    assertEquals(0, instant.getNano());
    assertEquals(0L, instant.getEpochSecond());
    assertEquals(1, actualReadTagRecordByAsOfResult.version);
    assertEquals(1L, actualReadTagRecordByAsOfResult.key);
    assertTrue(actualReadTagRecordByAsOfResult.isLatest);
  }

  /**
   * Test {@link JdbcReadImpl#readTagRecordByAsOf(Connection, short, long, Instant)}.
   * <ul>
   *   <li>Then throw {@link EValidationGap}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readTagRecordByAsOf(Connection, short, long, Instant)}
   */
  @Test
  @DisplayName("Test readTagRecordByAsOf(Connection, short, long, Instant); then throw EValidationGap")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readTagRecordByAsOf(Connection, short, long, Instant)"})
  void testReadTagRecordByAsOf_thenThrowEValidationGap() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenThrow(new EValidationGap("Not all who wander are lost"));
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(EValidationGap.class, () -> jdbcReadImpl.readTagRecordByAsOf(conn, (short) 1, 1L,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    verify(conn).prepareStatement(eq(
        "select tag_pk, tag_version, tag_timestamp, tag_is_latest\nfrom tag\nwhere tenant_id = ?\nand definition_fk = ?\nand tag_timestamp <= ?\nand (tag_superseded is null or tag_superseded > ?)\n"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(preparedStatement, atLeast(1)).setTimestamp(anyInt(), isA(Timestamp.class));
    verify(resultSet).close();
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readTagRecordByAsOf(Connection, short, long, Instant)}.
   * <ul>
   *   <li>Then throw {@link JdbcException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readTagRecordByAsOf(Connection, short, long, Instant)}
   */
  @Test
  @DisplayName("Test readTagRecordByAsOf(Connection, short, long, Instant); then throw JdbcException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readTagRecordByAsOf(Connection, short, long, Instant)"})
  void testReadTagRecordByAsOf_thenThrowJdbcException() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readTagRecordByAsOf(conn, (short) 1, 1L,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    verify(conn).prepareStatement(eq(
        "select tag_pk, tag_version, tag_timestamp, tag_is_latest\nfrom tag\nwhere tenant_id = ?\nand definition_fk = ?\nand tag_timestamp <= ?\nand (tag_superseded is null or tag_superseded > ?)\n"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(preparedStatement, atLeast(1)).setTimestamp(anyInt(), isA(Timestamp.class));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readTagRecordByLatest(Connection, short, long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then throw {@link JdbcException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readTagRecordByLatest(Connection, short, long)}
   */
  @Test
  @DisplayName("Test readTagRecordByLatest(Connection, short, long); given ResultSet next() return 'false'; then throw JdbcException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readTagRecordByLatest(Connection, short, long)"})
  void testReadTagRecordByLatest_givenResultSetNextReturnFalse_thenThrowJdbcException() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readTagRecordByLatest(conn, (short) 1, 1L));
    verify(conn).prepareStatement(eq(
        "select tag_pk, tag_version, tag_timestamp, tag_is_latest\nfrom tag\nwhere tenant_id = ?\nand definition_fk = ?\nand tag_is_latest = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setBoolean(eq(3), eq(true));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).next();
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcReadImpl#readTagRecordByLatest(Connection, short, long)}.
   * <ul>
   *   <li>Then return {@link KeyedItem#item} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readTagRecordByLatest(Connection, short, long)}
   */
  @Test
  @DisplayName("Test readTagRecordByLatest(Connection, short, long); then return item is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readTagRecordByLatest(Connection, short, long)"})
  void testReadTagRecordByLatest_thenReturnItemIsNull() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    KeyedItem<Void> actualReadTagRecordByLatestResult = jdbcReadImpl.readTagRecordByLatest(conn, (short) 1, 1L);

    // Assert
    verify(conn).prepareStatement(eq(
        "select tag_pk, tag_version, tag_timestamp, tag_is_latest\nfrom tag\nwhere tenant_id = ?\nand definition_fk = ?\nand tag_is_latest = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setBoolean(eq(3), eq(true));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
    assertNull(actualReadTagRecordByLatestResult.item);
    Instant instant = actualReadTagRecordByLatestResult.timestamp;
    assertEquals(0, instant.getNano());
    assertEquals(0L, instant.getEpochSecond());
    assertEquals(1, actualReadTagRecordByLatestResult.version);
    assertEquals(1L, actualReadTagRecordByLatestResult.key);
    assertTrue(actualReadTagRecordByLatestResult.isLatest);
  }

  /**
   * Test {@link JdbcReadImpl#readTagRecordByLatest(Connection, short, long)}.
   * <ul>
   *   <li>Then throw {@link EValidationGap}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readTagRecordByLatest(Connection, short, long)}
   */
  @Test
  @DisplayName("Test readTagRecordByLatest(Connection, short, long); then throw EValidationGap")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readTagRecordByLatest(Connection, short, long)"})
  void testReadTagRecordByLatest_thenThrowEValidationGap() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenThrow(new EValidationGap("Not all who wander are lost"));
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(EValidationGap.class, () -> jdbcReadImpl.readTagRecordByLatest(conn, (short) 1, 1L));
    verify(conn).prepareStatement(eq(
        "select tag_pk, tag_version, tag_timestamp, tag_is_latest\nfrom tag\nwhere tenant_id = ?\nand definition_fk = ?\nand tag_is_latest = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setBoolean(eq(3), eq(true));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readTagRecordByLatest(Connection, short, long)}.
   * <ul>
   *   <li>Then throw {@link JdbcException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readTagRecordByLatest(Connection, short, long)}
   */
  @Test
  @DisplayName("Test readTagRecordByLatest(Connection, short, long); then throw JdbcException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyedItem JdbcReadImpl.readTagRecordByLatest(Connection, short, long)"})
  void testReadTagRecordByLatest_thenThrowJdbcException() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(JdbcException.class, () -> jdbcReadImpl.readTagRecordByLatest(conn, (short) 1, 1L));
    verify(conn).prepareStatement(eq(
        "select tag_pk, tag_version, tag_timestamp, tag_is_latest\nfrom tag\nwhere tenant_id = ?\nand definition_fk = ?\nand tag_is_latest = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setBoolean(eq(3), eq(true));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(4));
    verify(resultSet).getInt(eq(2));
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getTimestamp(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(timestamp).toInstant();
  }

  /**
   * Test {@link JdbcReadImpl#readTagAttrs(Connection, short, long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getString(String)} throw {@link SQLException#SQLException()}.</li>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readTagAttrs(Connection, short, long)}
   */
  @Test
  @DisplayName("Test readTagAttrs(Connection, short, long); given ResultSet getString(String) throw SQLException(); then throw SQLException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JdbcReadImpl.readTagAttrs(Connection, short, long)"})
  void testReadTagAttrs_givenResultSetGetStringThrowSQLException_thenThrowSQLException() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(Mockito.<String>any())).thenThrow(new SQLException());
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act and Assert
    assertThrows(SQLException.class, () -> jdbcReadImpl.readTagAttrs(conn, (short) 1, 1L));
    verify(conn).prepareStatement(eq("select * from tag_attr\nwhere tenant_id = ?\nand tag_fk = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).getString(eq("attr_name"));
    verify(resultSet).next();
    verify(preparedStatement).close();
  }

  /**
   * Test {@link JdbcReadImpl#readTagAttrs(Connection, short, long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JdbcReadImpl#readTagAttrs(Connection, short, long)}
   */
  @Test
  @DisplayName("Test readTagAttrs(Connection, short, long); given ResultSet next() return 'false'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JdbcReadImpl.readTagAttrs(Connection, short, long)"})
  void testReadTagAttrs_givenResultSetNextReturnFalse_thenReturnEmpty() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setShort(anyInt(), anyShort());
    doNothing().when(preparedStatement).close();
    Connection conn = mock(Connection.class);
    when(conn.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Map<String, Value> actualReadTagAttrsResult = jdbcReadImpl.readTagAttrs(conn, (short) 1, 1L);

    // Assert
    verify(conn).prepareStatement(eq("select * from tag_attr\nwhere tenant_id = ?\nand tag_fk = ?"));
    verify(preparedStatement).executeQuery();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setShort(eq(1), eq((short) 1));
    verify(resultSet).close();
    verify(resultSet).next();
    verify(preparedStatement).close();
    assertTrue(actualReadTagAttrsResult.isEmpty());
  }
}
