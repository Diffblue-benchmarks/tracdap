package org.finos.tracdap.svc.meta.dal.jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.finos.tracdap.common.exception.EValidationGap;
import org.finos.tracdap.metadata.CustomDefinition;
import org.finos.tracdap.metadata.DataDefinition;
import org.finos.tracdap.metadata.DatetimeValue;
import org.finos.tracdap.metadata.ExportDataJob;
import org.finos.tracdap.metadata.FileDefinition;
import org.finos.tracdap.metadata.FlowDefinition;
import org.finos.tracdap.metadata.FlowEdge;
import org.finos.tracdap.metadata.ImportDataJob;
import org.finos.tracdap.metadata.ImportModelJob;
import org.finos.tracdap.metadata.JobDefinition;
import org.finos.tracdap.metadata.JobGroup;
import org.finos.tracdap.metadata.JobGroupType;
import org.finos.tracdap.metadata.JobStatusCode;
import org.finos.tracdap.metadata.JobType;
import org.finos.tracdap.metadata.ModelDefinition;
import org.finos.tracdap.metadata.ModelType;
import org.finos.tracdap.metadata.ObjectDefinition;
import org.finos.tracdap.metadata.ObjectType;
import org.finos.tracdap.metadata.PartType;
import org.finos.tracdap.metadata.ResultDefinition;
import org.finos.tracdap.metadata.RunFlowJob;
import org.finos.tracdap.metadata.RunModelJob;
import org.finos.tracdap.metadata.SchemaDefinition;
import org.finos.tracdap.metadata.SchemaType;
import org.finos.tracdap.metadata.StorageDefinition;
import org.finos.tracdap.metadata.StructSchema;
import org.finos.tracdap.metadata.TableSchema;
import org.finos.tracdap.metadata.TagSelector;
import org.finos.tracdap.metadata.Value;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JdbcReadImplDiffblueTest {
  /**
   * Method under test:
   * {@link JdbcReadImpl#readObjectTypeById(Connection, short, UUID)}
   */
  @Test
  void testReadObjectTypeById() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readObjectTypeById(Connection, short, UUID)}
   */
  @Test
  void testReadObjectTypeById2() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readDefinition(Connection, short, long, TagSelector)}
   */
  @Test
  void testReadDefinition() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Connection conn = mock(Connection.class);

    // Act and Assert
    assertThrows(EValidationGap.class,
        () -> jdbcReadImpl.readDefinition(conn, (short) 1, 1L, TagSelector.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}
   */
  @Test
  void testReadDefinitionByVersion() throws UnsupportedEncodingException, SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}
   */
  @Test
  void testReadDefinitionByVersion2() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}
   */
  @Test
  void testReadDefinitionByVersion3() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}
   */
  @Test
  void testReadDefinitionByVersion4() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}
   */
  @Test
  void testReadDefinitionByVersion5() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}
   */
  @Test
  void testReadDefinitionByVersion6() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}
   */
  @Test
  void testReadDefinitionByVersion7() throws UnsupportedEncodingException, SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}
   */
  @Test
  void testReadDefinitionByVersion8() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}
   */
  @Test
  void testReadDefinitionByVersion9() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}
   */
  @Test
  void testReadDefinitionByVersion10() throws SQLException {
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
    JdbcBaseDal.KeyedItem<ObjectDefinition> actualReadDefinitionByVersionResult = jdbcReadImpl
        .readDefinitionByVersion(conn, (short) 1, 1L, 1);

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
    ObjectDefinition objectDefinition = actualReadDefinitionByVersionResult.item;
    Descriptors.Descriptor descriptorForType = objectDefinition.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(11, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertTrue(getResult.getDefaultValue() instanceof Descriptors.EnumValueDescriptor);
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertEquals("", options.getInitializationErrorString());
    CustomDefinition custom = objectDefinition.getCustom();
    Descriptors.Descriptor descriptorForType2 = custom.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    DataDefinition data = objectDefinition.getData();
    Descriptors.Descriptor descriptorForType3 = data.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    assertEquals("", toProtoResult2.getInitializationErrorString());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    TagSelector schemaId = data.getSchemaId();
    assertEquals("", schemaId.getInitializationErrorString());
    JobDefinition job = objectDefinition.getJob();
    ExportDataJob exportData = job.getExportData();
    assertEquals("", exportData.getInitializationErrorString());
    ImportDataJob importData = job.getImportData();
    assertEquals("", importData.getInitializationErrorString());
    ImportModelJob importModel = job.getImportModel();
    assertEquals("", importModel.getInitializationErrorString());
    JobGroup jobGroup = job.getJobGroup();
    assertEquals("", jobGroup.getInitializationErrorString());
    RunFlowJob runFlow = job.getRunFlow();
    assertEquals("", runFlow.getInitializationErrorString());
    RunModelJob runModel = job.getRunModel();
    assertEquals("", runModel.getInitializationErrorString());
    assertEquals("", custom.getInitializationErrorString());
    assertEquals("", data.getInitializationErrorString());
    FileDefinition file = objectDefinition.getFile();
    assertEquals("", file.getInitializationErrorString());
    FlowDefinition flow = objectDefinition.getFlow();
    assertEquals("", flow.getInitializationErrorString());
    assertEquals("", job.getInitializationErrorString());
    ModelDefinition model = objectDefinition.getModel();
    assertEquals("", model.getInitializationErrorString());
    ResultDefinition result = objectDefinition.getResult();
    assertEquals("", result.getInitializationErrorString());
    SchemaDefinition schema = objectDefinition.getSchema();
    assertEquals("", schema.getInitializationErrorString());
    StorageDefinition storage = objectDefinition.getStorage();
    assertEquals("", storage.getInitializationErrorString());
    StructSchema struct = schema.getStruct();
    assertEquals("", struct.getInitializationErrorString());
    TableSchema table = schema.getTable();
    assertEquals("", table.getInitializationErrorString());
    DatetimeValue objectAsOf = schemaId.getObjectAsOf();
    assertEquals("", objectAsOf.getInitializationErrorString());
    assertEquals("", objectDefinition.getInitializationErrorString());
    ByteString customData = custom.getCustomData();
    assertEquals("", customData.toStringUtf8());
    assertEquals("", custom.getCustomSchemaType());
    assertEquals("", objectAsOf.getIsoDatetime());
    assertEquals("", file.getDataItem());
    assertEquals("", file.getExtension());
    assertEquals("", file.getMimeType());
    assertEquals("", file.getName());
    assertEquals("", importModel.getEntryPoint());
    assertEquals("", importModel.getLanguage());
    assertEquals("", importModel.getPackage());
    assertEquals("", importModel.getPackageGroup());
    assertEquals("", importModel.getPath());
    assertEquals("", importModel.getRepository());
    assertEquals("", importModel.getVersion());
    assertEquals("", model.getEntryPoint());
    assertEquals("", model.getLanguage());
    assertEquals("", model.getPackage());
    assertEquals("", model.getPackageGroup());
    assertEquals("", model.getPath());
    assertEquals("", model.getRepository());
    assertEquals("", model.getVersion());
    assertEquals("", result.getStatusMessage());
    assertEquals("", schemaId.getObjectId());
    assertEquals("CustomDefinition", toProtoResult.getName());
    assertEquals("CustomDefinition", descriptorForType2.getName());
    assertEquals("DataDefinition", toProtoResult2.getName());
    assertEquals("DataDefinition", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = file.getDescriptorForType();
    assertEquals("FileDefinition", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = flow.getDescriptorForType();
    assertEquals("FlowDefinition", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = job.getDescriptorForType();
    assertEquals("JobDefinition", descriptorForType6.getName());
    Descriptors.Descriptor descriptorForType7 = model.getDescriptorForType();
    assertEquals("ModelDefinition", descriptorForType7.getName());
    assertEquals("ObjectDefinition", toProtoResult3.getName());
    assertEquals("ObjectDefinition", descriptorForType.getName());
    Descriptors.Descriptor descriptorForType8 = result.getDescriptorForType();
    assertEquals("ResultDefinition", descriptorForType8.getName());
    Descriptors.Descriptor descriptorForType9 = schema.getDescriptorForType();
    assertEquals("SchemaDefinition", descriptorForType9.getName());
    Descriptors.Descriptor descriptorForType10 = storage.getDescriptorForType();
    assertEquals("StorageDefinition", descriptorForType10.getName());
    Descriptors.Descriptor descriptorForType11 = schemaId.getDescriptorForType();
    assertEquals("TagSelector", descriptorForType11.getName());
    assertEquals("objectType", getResult.getJsonName());
    assertEquals("objectType", getResult.getName());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("tracdap.metadata", file2.getPackage());
    Descriptors.FileDescriptor file3 = descriptorForType3.getFile();
    assertEquals("tracdap.metadata", file3.getPackage());
    Descriptors.FileDescriptor file4 = descriptorForType.getFile();
    assertEquals("tracdap.metadata", file4.getPackage());
    assertEquals("tracdap.metadata.CustomDefinition", descriptorForType2.getFullName());
    assertEquals("tracdap.metadata.DataDefinition", descriptorForType3.getFullName());
    assertEquals("tracdap.metadata.FileDefinition", descriptorForType4.getFullName());
    assertEquals("tracdap.metadata.FlowDefinition", descriptorForType5.getFullName());
    assertEquals("tracdap.metadata.JobDefinition", descriptorForType6.getFullName());
    assertEquals("tracdap.metadata.ModelDefinition", descriptorForType7.getFullName());
    assertEquals("tracdap.metadata.ObjectDefinition", descriptorForType.getFullName());
    assertEquals("tracdap.metadata.ObjectDefinition.objectType", getResult.getFullName());
    assertEquals("tracdap.metadata.ResultDefinition", descriptorForType8.getFullName());
    assertEquals("tracdap.metadata.SchemaDefinition", descriptorForType9.getFullName());
    assertEquals("tracdap.metadata.StorageDefinition", descriptorForType10.getFullName());
    assertEquals("tracdap.metadata.TagSelector", descriptorForType11.getFullName());
    assertEquals("tracdap/metadata/custom.proto", file2.getFullName());
    assertEquals("tracdap/metadata/custom.proto", file2.getName());
    assertEquals("tracdap/metadata/data.proto", file3.getFullName());
    assertEquals("tracdap/metadata/data.proto", file3.getName());
    assertEquals("tracdap/metadata/object.proto", file4.getFullName());
    assertEquals("tracdap/metadata/object.proto", file4.getName());
    assertNull(descriptorForType11.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType8.getContainingType());
    assertNull(descriptorForType9.getContainingType());
    assertNull(descriptorForType10.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult2.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult2.getExtensionRangeCount());
    assertEquals(0, toProtoResult3.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult2.getReservedNameCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, toProtoResult2.getReservedRangeCount());
    assertEquals(0, toProtoResult3.getReservedRangeCount());
    assertEquals(0, options.getSerializedSize());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, descriptorForType2.getIndex());
    assertEquals(0, descriptorForType4.getIndex());
    assertEquals(0, descriptorForType6.getIndex());
    assertEquals(0, descriptorForType.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = objectDefinition.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    Instant instant = actualReadDefinitionByVersionResult.timestamp;
    assertEquals(0, instant.getNano());
    assertEquals(0, custom.getCustomSchemaVersion());
    assertEquals(0, custom.getSerializedSize());
    assertEquals(0, data.getPartsCount());
    assertEquals(0, data.getSerializedSize());
    assertEquals(0, objectAsOf.getSerializedSize());
    assertEquals(0, exportData.getExportsCount());
    assertEquals(0, exportData.getInputsCount());
    assertEquals(0, exportData.getOutputAttrsCount());
    assertEquals(0, exportData.getOutputsCount());
    assertEquals(0, exportData.getParametersCount());
    assertEquals(0, exportData.getPriorOutputsCount());
    assertEquals(0, exportData.getSerializedSize());
    assertEquals(0, exportData.getStorageAccessCount());
    assertEquals(0, file.getSerializedSize());
    assertEquals(0, flow.getEdgesCount());
    assertEquals(0, flow.getInputsCount());
    assertEquals(0, flow.getNodesCount());
    assertEquals(0, flow.getOutputsCount());
    assertEquals(0, flow.getParametersCount());
    assertEquals(0, flow.getSerializedSize());
    assertEquals(0, importData.getImportAttrsCount());
    assertEquals(0, importData.getImportsCount());
    assertEquals(0, importData.getInputsCount());
    assertEquals(0, importData.getOutputAttrsCount());
    assertEquals(0, importData.getOutputsCount());
    assertEquals(0, importData.getParametersCount());
    assertEquals(0, importData.getPriorOutputsCount());
    assertEquals(0, importData.getSerializedSize());
    assertEquals(0, importData.getStorageAccessCount());
    assertEquals(0, importModel.getModelAttrsCount());
    assertEquals(0, importModel.getSerializedSize());
    assertEquals(0, job.getJobTypeValue());
    assertEquals(0, job.getSerializedSize());
    assertEquals(0, jobGroup.getJobGroupTypeValue());
    assertEquals(0, jobGroup.getSerializedSize());
    assertEquals(0, model.getInputsCount());
    assertEquals(0, model.getModelTypeValue());
    assertEquals(0, model.getOutputsCount());
    assertEquals(0, model.getParametersCount());
    assertEquals(0, model.getSerializedSize());
    assertEquals(0, model.getStaticAttributesCount());
    assertEquals(0, objectDefinition.getObjectPropsCount());
    assertEquals(0, objectDefinition.getObjectTypeValue());
    assertEquals(0, objectDefinition.getSerializedSize());
    assertEquals(0, result.getSerializedSize());
    assertEquals(0, result.getStatusCodeValue());
    assertEquals(0, runFlow.getInputsCount());
    assertEquals(0, runFlow.getModelsCount());
    assertEquals(0, runFlow.getOutputAttrsCount());
    assertEquals(0, runFlow.getOutputsCount());
    assertEquals(0, runFlow.getParametersCount());
    assertEquals(0, runFlow.getPriorOutputsCount());
    assertEquals(0, runFlow.getSerializedSize());
    assertEquals(0, runModel.getInputsCount());
    assertEquals(0, runModel.getOutputAttrsCount());
    assertEquals(0, runModel.getOutputsCount());
    assertEquals(0, runModel.getParametersCount());
    assertEquals(0, runModel.getPriorOutputsCount());
    assertEquals(0, runModel.getSerializedSize());
    assertEquals(0, schema.getPartTypeValue());
    assertEquals(0, schema.getSchemaTypeValue());
    assertEquals(0, schema.getSerializedSize());
    assertEquals(0, storage.getDataItemsCount());
    assertEquals(0, storage.getSerializedSize());
    assertEquals(0, storage.getStorageOptionsCount());
    assertEquals(0, struct.getFieldsCount());
    assertEquals(0, struct.getNamedTypesCount());
    assertEquals(0, struct.getSerializedSize());
    assertEquals(0, table.getFieldsCount());
    assertEquals(0, table.getSerializedSize());
    assertEquals(0, schemaId.getObjectTypeValue());
    assertEquals(0, schemaId.getObjectVersion());
    assertEquals(0, schemaId.getSerializedSize());
    assertEquals(0, schemaId.getTagVersion());
    assertEquals(0L, instant.getEpochSecond());
    assertEquals(0L, file.getSize());
    assertEquals(1, toProtoResult3.getNestedTypeCount());
    assertEquals(1, toProtoResult2.getOneofDeclCount());
    assertEquals(1, toProtoResult3.getOneofDeclCount());
    assertEquals(1, descriptorForType11.getIndex());
    assertEquals(1, descriptorForType8.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(1, descriptorForType.getNestedTypes().size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType3.getOneofs();
    assertEquals(1, oneofs.size());
    List<Descriptors.OneofDescriptor> oneofs2 = descriptorForType.getOneofs();
    assertEquals(1, oneofs2.size());
    List<Descriptors.OneofDescriptor> realOneofs = descriptorForType3.getRealOneofs();
    assertEquals(1, realOneofs.size());
    List<Descriptors.OneofDescriptor> realOneofs2 = descriptorForType.getRealOneofs();
    assertEquals(1, realOneofs2.size());
    assertEquals(1, actualReadDefinitionByVersionResult.version);
    assertEquals(11, toProtoResult3.getFieldCount());
    assertEquals(1L, actualReadDefinitionByVersionResult.key);
    assertEquals(3, toProtoResult.getFieldCount());
    assertEquals(3, descriptorForType5.getIndex());
    assertEquals(3, descriptorForType7.getIndex());
    assertEquals(3, descriptorForType10.getIndex());
    assertEquals(3, descriptorForType2.getFields().size());
    assertEquals(4, toProtoResult2.getFieldCount());
    assertEquals(4, toProtoResult2.getNestedTypeCount());
    assertEquals(4, descriptorForType9.getIndex());
    assertEquals(4, descriptorForType3.getFields().size());
    assertEquals(4, descriptorForType3.getNestedTypes().size());
    assertEquals(570, toProtoResult2.getSerializedSize());
    assertEquals(6, descriptorForType3.getIndex());
    assertEquals(701, toProtoResult3.getSerializedSize());
    assertEquals(93, toProtoResult.getSerializedSize());
    assertEquals(Descriptors.FieldDescriptor.JavaType.ENUM, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.ENUM, getResult.getType());
    assertEquals(WireFormat.FieldType.ENUM, getResult.getLiteType());
    assertEquals(WireFormat.JavaType.ENUM, getResult.getLiteJavaType());
    assertEquals(DataDefinition.SchemaSpecifierCase.SCHEMASPECIFIER_NOT_SET, data.getSchemaSpecifierCase());
    assertEquals(JobDefinition.JobDetailsCase.JOBDETAILS_NOT_SET, job.getJobDetailsCase());
    assertEquals(JobGroup.JobGroupDetailsCase.JOBGROUPDETAILS_NOT_SET, jobGroup.getJobGroupDetailsCase());
    assertEquals(JobGroupType.JOB_GROUP_TYPE_NOT_SET, jobGroup.getJobGroupType());
    assertEquals(JobStatusCode.JOB_STATUS_CODE_NOT_SET, result.getStatusCode());
    assertEquals(JobType.JOB_TYPE_NOT_SET, job.getJobType());
    assertEquals(ModelType.STANDARD_MODEL, model.getModelType());
    assertEquals(ObjectDefinition.DefinitionCase.DEFINITION_NOT_SET, objectDefinition.getDefinitionCase());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, objectDefinition.getObjectType());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, schemaId.getObjectType());
    assertEquals(PartType.PART_ROOT, schema.getPartType());
    assertEquals(SchemaDefinition.SchemaDetailsCase.SCHEMADETAILS_NOT_SET, schema.getSchemaDetailsCase());
    assertEquals(SchemaType.SCHEMA_TYPE_NOT_SET, schema.getSchemaType());
    assertEquals(TagSelector.ObjectCriteriaCase.OBJECTCRITERIA_NOT_SET, schemaId.getObjectCriteriaCase());
    assertEquals(TagSelector.TagCriteriaCase.TAGCRITERIA_NOT_SET, schemaId.getTagCriteriaCase());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(options.getDeprecated());
    assertFalse(options.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options.getMapEntry());
    assertFalse(options.getMessageSetWireFormat());
    assertFalse(options.getNoStandardDescriptorAccessor());
    assertFalse(options.hasDeprecated());
    assertFalse(options.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options.hasFeatures());
    assertFalse(options.hasMapEntry());
    assertFalse(options.hasMessageSetWireFormat());
    assertFalse(options.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType11.isExtendable());
    assertFalse(descriptorForType2.isExtendable());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType4.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType6.isExtendable());
    assertFalse(descriptorForType7.isExtendable());
    assertFalse(descriptorForType8.isExtendable());
    assertFalse(descriptorForType9.isExtendable());
    assertFalse(descriptorForType10.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(customData.iterator().hasNext());
    assertFalse(data.hasSchema());
    assertFalse(data.hasSchemaId());
    assertFalse(data.hasStorageId());
    assertFalse(exportData.hasModel());
    assertFalse(file.hasStorageId());
    assertFalse(importData.hasModel());
    assertFalse(importModel.hasPackageGroup());
    assertFalse(job.hasExportData());
    assertFalse(job.hasImportData());
    assertFalse(job.hasImportModel());
    assertFalse(job.hasJobGroup());
    assertFalse(job.hasResultId());
    assertFalse(job.hasRunFlow());
    assertFalse(job.hasRunModel());
    assertFalse(jobGroup.hasParallel());
    assertFalse(jobGroup.hasSequential());
    assertFalse(model.hasPackageGroup());
    assertFalse(model.hasPath());
    assertFalse(objectDefinition.hasCustom());
    assertFalse(objectDefinition.hasData());
    assertFalse(objectDefinition.hasFile());
    assertFalse(objectDefinition.hasFlow());
    assertFalse(objectDefinition.hasJob());
    assertFalse(objectDefinition.hasModel());
    assertFalse(objectDefinition.hasResult());
    assertFalse(objectDefinition.hasSchema());
    assertFalse(objectDefinition.hasStorage());
    assertFalse(result.hasJobId());
    assertFalse(result.hasLogFileId());
    assertFalse(runFlow.hasFlow());
    assertFalse(runModel.hasModel());
    assertFalse(schema.hasStruct());
    assertFalse(schema.hasTable());
    assertFalse(schemaId.getLatestObject());
    assertFalse(schemaId.getLatestTag());
    assertFalse(schemaId.hasLatestObject());
    assertFalse(schemaId.hasLatestTag());
    assertFalse(schemaId.hasObjectAsOf());
    assertFalse(schemaId.hasObjectVersion());
    assertFalse(schemaId.hasTagAsOf());
    assertFalse(schemaId.hasTagVersion());
    assertTrue(customData.isEmpty());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(getResult.isOptional());
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    assertTrue(schemaId.findInitializationErrors().isEmpty());
    assertTrue(custom.findInitializationErrors().isEmpty());
    assertTrue(data.findInitializationErrors().isEmpty());
    assertTrue(file.findInitializationErrors().isEmpty());
    assertTrue(flow.findInitializationErrors().isEmpty());
    assertTrue(job.findInitializationErrors().isEmpty());
    assertTrue(model.findInitializationErrors().isEmpty());
    assertTrue(result.findInitializationErrors().isEmpty());
    assertTrue(schema.findInitializationErrors().isEmpty());
    assertTrue(storage.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = objectDefinition.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    List<FlowEdge> edgesList = flow.getEdgesList();
    assertTrue(edgesList.isEmpty());
    assertTrue(schemaId.getAllFields().isEmpty());
    assertTrue(custom.getAllFields().isEmpty());
    assertTrue(data.getAllFields().isEmpty());
    assertTrue(file.getAllFields().isEmpty());
    assertTrue(flow.getAllFields().isEmpty());
    assertTrue(job.getAllFields().isEmpty());
    assertTrue(model.getAllFields().isEmpty());
    assertTrue(result.getAllFields().isEmpty());
    assertTrue(schema.getAllFields().isEmpty());
    assertTrue(storage.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = objectDefinition.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(data.getParts().isEmpty());
    assertTrue(data.getPartsMap().isEmpty());
    assertTrue(flow.getInputs().isEmpty());
    assertTrue(flow.getInputsMap().isEmpty());
    assertTrue(flow.getNodes().isEmpty());
    assertTrue(flow.getNodesMap().isEmpty());
    assertTrue(flow.getOutputs().isEmpty());
    assertTrue(flow.getOutputsMap().isEmpty());
    assertTrue(flow.getParameters().isEmpty());
    assertTrue(flow.getParametersMap().isEmpty());
    assertTrue(model.getInputs().isEmpty());
    assertTrue(model.getInputsMap().isEmpty());
    assertTrue(model.getOutputs().isEmpty());
    assertTrue(model.getOutputsMap().isEmpty());
    assertTrue(model.getParameters().isEmpty());
    assertTrue(model.getParametersMap().isEmpty());
    assertTrue(model.getStaticAttributes().isEmpty());
    assertTrue(model.getStaticAttributesMap().isEmpty());
    assertTrue(objectDefinition.getObjectProps().isEmpty());
    assertTrue(objectDefinition.getObjectPropsMap().isEmpty());
    assertTrue(storage.getDataItems().isEmpty());
    assertTrue(storage.getDataItemsMap().isEmpty());
    assertTrue(storage.getStorageOptions().isEmpty());
    assertTrue(storage.getStorageOptionsMap().isEmpty());
    assertTrue(custom.isInitialized());
    assertTrue(data.isInitialized());
    assertTrue(objectAsOf.isInitialized());
    assertTrue(exportData.isInitialized());
    assertTrue(file.isInitialized());
    assertTrue(flow.isInitialized());
    assertTrue(importData.isInitialized());
    assertTrue(importModel.isInitialized());
    assertTrue(job.isInitialized());
    assertTrue(jobGroup.isInitialized());
    assertTrue(model.isInitialized());
    assertTrue(objectDefinition.isInitialized());
    assertTrue(result.isInitialized());
    assertTrue(runFlow.isInitialized());
    assertTrue(runModel.isInitialized());
    assertTrue(schema.isInitialized());
    assertTrue(storage.isInitialized());
    assertTrue(struct.isInitialized());
    assertTrue(table.isInitialized());
    assertTrue(schemaId.isInitialized());
    assertTrue(actualReadDefinitionByVersionResult.isLatest);
    assertEquals(findInitializationErrorsResult, options.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, exportData.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, importData.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, importModel.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, jobGroup.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, runFlow.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, runModel.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, struct.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, table.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, objectAsOf.findInitializationErrors());
    ProtocolStringList reservedNameList = toProtoResult3.getReservedNameList();
    assertEquals(findInitializationErrorsResult, reservedNameList);
    assertEquals(findInitializationErrorsResult, descriptorForType11.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType9.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType10.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType11.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType9.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType10.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType11.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType9.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType10.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType10.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getEnumTypes());
    assertEquals(findInitializationErrorsResult, file4.getEnumTypes());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file3.getExtensions());
    assertEquals(findInitializationErrorsResult, file4.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file3.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file4.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(findInitializationErrorsResult, file3.getServices());
    assertEquals(findInitializationErrorsResult, file4.getServices());
    assertEquals(allFields, exportData.getAllFields());
    assertEquals(allFields, importData.getAllFields());
    assertEquals(allFields, importModel.getAllFields());
    assertEquals(allFields, jobGroup.getAllFields());
    assertEquals(allFields, runFlow.getAllFields());
    assertEquals(allFields, runModel.getAllFields());
    assertEquals(allFields, struct.getAllFields());
    assertEquals(allFields, table.getAllFields());
    assertEquals(allFields, objectAsOf.getAllFields());
    assertEquals(allFields, options.getAllFields());
    assertEquals(allFields, options.getAllFieldsRaw());
    assertEquals(allFields, exportData.getExports());
    assertEquals(allFields, exportData.getExportsMap());
    assertEquals(allFields, exportData.getInputs());
    assertEquals(allFields, exportData.getInputsMap());
    assertEquals(allFields, exportData.getOutputs());
    assertEquals(allFields, exportData.getOutputsMap());
    assertEquals(allFields, exportData.getParameters());
    assertEquals(allFields, exportData.getParametersMap());
    assertEquals(allFields, exportData.getPriorOutputs());
    assertEquals(allFields, exportData.getPriorOutputsMap());
    assertEquals(allFields, importData.getImports());
    assertEquals(allFields, importData.getImportsMap());
    assertEquals(allFields, importData.getInputs());
    assertEquals(allFields, importData.getInputsMap());
    assertEquals(allFields, importData.getOutputs());
    assertEquals(allFields, importData.getOutputsMap());
    assertEquals(allFields, importData.getParameters());
    assertEquals(allFields, importData.getParametersMap());
    assertEquals(allFields, importData.getPriorOutputs());
    assertEquals(allFields, importData.getPriorOutputsMap());
    assertEquals(allFields, runFlow.getInputs());
    assertEquals(allFields, runFlow.getInputsMap());
    assertEquals(allFields, runFlow.getModels());
    assertEquals(allFields, runFlow.getModelsMap());
    assertEquals(allFields, runFlow.getOutputs());
    assertEquals(allFields, runFlow.getOutputsMap());
    assertEquals(allFields, runFlow.getParameters());
    assertEquals(allFields, runFlow.getParametersMap());
    assertEquals(allFields, runFlow.getPriorOutputs());
    assertEquals(allFields, runFlow.getPriorOutputsMap());
    assertEquals(allFields, runModel.getInputs());
    assertEquals(allFields, runModel.getInputsMap());
    assertEquals(allFields, runModel.getOutputs());
    assertEquals(allFields, runModel.getOutputsMap());
    assertEquals(allFields, runModel.getParameters());
    assertEquals(allFields, runModel.getParametersMap());
    assertEquals(allFields, runModel.getPriorOutputs());
    assertEquals(allFields, runModel.getPriorOutputsMap());
    assertEquals(allFields, struct.getFields());
    assertEquals(allFields, struct.getFieldsMap());
    assertEquals(allFields, struct.getNamedTypes());
    assertEquals(allFields, struct.getNamedTypesMap());
    assertEquals(customData, custom.getCustomSchemaTypeBytes());
    assertEquals(customData, objectAsOf.getIsoDatetimeBytes());
    assertEquals(customData, file.getDataItemBytes());
    assertEquals(customData, file.getExtensionBytes());
    assertEquals(customData, file.getMimeTypeBytes());
    assertEquals(customData, file.getNameBytes());
    assertEquals(customData, importModel.getEntryPointBytes());
    assertEquals(customData, importModel.getLanguageBytes());
    assertEquals(customData, importModel.getPackageBytes());
    assertEquals(customData, importModel.getPackageGroupBytes());
    assertEquals(customData, importModel.getPathBytes());
    assertEquals(customData, importModel.getRepositoryBytes());
    assertEquals(customData, importModel.getVersionBytes());
    assertEquals(customData, model.getEntryPointBytes());
    assertEquals(customData, model.getLanguageBytes());
    assertEquals(customData, model.getPackageBytes());
    assertEquals(customData, model.getPackageGroupBytes());
    assertEquals(customData, model.getPathBytes());
    assertEquals(customData, model.getRepositoryBytes());
    assertEquals(customData, model.getVersionBytes());
    assertEquals(customData, result.getStatusMessageBytes());
    assertEquals(customData, schemaId.getObjectIdBytes());
    ObjectDefinition expectedDefaultInstanceForType = actualReadDefinitionByVersionResult.item;
    assertEquals(expectedDefaultInstanceForType, objectDefinition.getDefaultInstanceForType());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    assertSame(reservedNameList, toProtoResult2.getReservedNameList());
    assertSame(reservedNameList, exportData.getStorageAccessList());
    assertSame(reservedNameList, importData.getStorageAccessList());
    assertSame(file3, descriptorForType9.getFile());
    assertSame(file4, getResult.getFile());
    assertSame(options, toProtoResult.getOptions());
    assertSame(options, toProtoResult2.getOptions());
    assertSame(options, toProtoResult3.getOptions());
    assertSame(options, toProtoResult.getOptionsOrBuilder());
    assertSame(options, toProtoResult2.getOptionsOrBuilder());
    assertSame(options, toProtoResult3.getOptionsOrBuilder());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options, descriptorForType11.getOptions());
    assertSame(options, descriptorForType2.getOptions());
    assertSame(options, descriptorForType3.getOptions());
    assertSame(options, descriptorForType4.getOptions());
    assertSame(options, descriptorForType5.getOptions());
    assertSame(options, descriptorForType6.getOptions());
    assertSame(options, descriptorForType7.getOptions());
    assertSame(options, descriptorForType8.getOptions());
    assertSame(options, descriptorForType9.getOptions());
    assertSame(options, descriptorForType10.getOptions());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, schemaId.getUnknownFields());
    assertSame(unknownFields, exportData.getUnknownFields());
    assertSame(unknownFields, importData.getUnknownFields());
    assertSame(unknownFields, importModel.getUnknownFields());
    assertSame(unknownFields, jobGroup.getUnknownFields());
    assertSame(unknownFields, runFlow.getUnknownFields());
    assertSame(unknownFields, runModel.getUnknownFields());
    assertSame(unknownFields, custom.getUnknownFields());
    assertSame(unknownFields, data.getUnknownFields());
    assertSame(unknownFields, file.getUnknownFields());
    assertSame(unknownFields, flow.getUnknownFields());
    assertSame(unknownFields, job.getUnknownFields());
    assertSame(unknownFields, model.getUnknownFields());
    assertSame(unknownFields, result.getUnknownFields());
    assertSame(unknownFields, schema.getUnknownFields());
    assertSame(unknownFields, storage.getUnknownFields());
    assertSame(unknownFields, struct.getUnknownFields());
    assertSame(unknownFields, table.getUnknownFields());
    assertSame(unknownFields, objectAsOf.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(oneofs.get(0), realOneofs.get(0));
    assertSame(oneofs2.get(0), realOneofs2.get(0));
    assertSame(schemaId, data.getSchemaIdOrBuilder());
    assertSame(schemaId, data.getStorageId());
    assertSame(schemaId, data.getStorageIdOrBuilder());
    assertSame(schemaId, exportData.getModel());
    assertSame(schemaId, exportData.getModelOrBuilder());
    assertSame(schemaId, file.getStorageId());
    assertSame(schemaId, file.getStorageIdOrBuilder());
    assertSame(schemaId, importData.getModel());
    assertSame(schemaId, importData.getModelOrBuilder());
    assertSame(schemaId, job.getResultId());
    assertSame(schemaId, job.getResultIdOrBuilder());
    assertSame(schemaId, result.getJobId());
    assertSame(schemaId, result.getJobIdOrBuilder());
    assertSame(schemaId, result.getLogFileId());
    assertSame(schemaId, result.getLogFileIdOrBuilder());
    assertSame(schemaId, runFlow.getFlow());
    assertSame(schemaId, runFlow.getFlowOrBuilder());
    assertSame(schemaId, runModel.getModel());
    assertSame(schemaId, runModel.getModelOrBuilder());
    assertSame(schemaId, schemaId.getDefaultInstanceForType());
    assertSame(edgesList, toProtoResult.getEnumTypeList());
    assertSame(edgesList, toProtoResult2.getEnumTypeList());
    assertSame(edgesList, toProtoResult3.getEnumTypeList());
    assertSame(edgesList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(edgesList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(edgesList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(edgesList, toProtoResult.getExtensionList());
    assertSame(edgesList, toProtoResult2.getExtensionList());
    assertSame(edgesList, toProtoResult3.getExtensionList());
    assertSame(edgesList, toProtoResult.getExtensionOrBuilderList());
    assertSame(edgesList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(edgesList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(edgesList, toProtoResult.getExtensionRangeList());
    assertSame(edgesList, toProtoResult2.getExtensionRangeList());
    assertSame(edgesList, toProtoResult3.getExtensionRangeList());
    assertSame(edgesList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(edgesList, toProtoResult2.getExtensionRangeOrBuilderList());
    assertSame(edgesList, toProtoResult3.getExtensionRangeOrBuilderList());
    assertSame(edgesList, toProtoResult.getNestedTypeList());
    assertSame(edgesList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(edgesList, toProtoResult.getOneofDeclList());
    assertSame(edgesList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(edgesList, toProtoResult.getReservedRangeList());
    assertSame(edgesList, toProtoResult2.getReservedRangeList());
    assertSame(edgesList, toProtoResult3.getReservedRangeList());
    assertSame(edgesList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(edgesList, toProtoResult2.getReservedRangeOrBuilderList());
    assertSame(edgesList, toProtoResult3.getReservedRangeOrBuilderList());
    assertSame(edgesList, options.getUninterpretedOptionList());
    assertSame(edgesList, options.getUninterpretedOptionOrBuilderList());
    assertSame(edgesList, exportData.getOutputAttrsList());
    assertSame(edgesList, exportData.getOutputAttrsOrBuilderList());
    assertSame(edgesList, flow.getEdgesOrBuilderList());
    assertSame(edgesList, importData.getImportAttrsList());
    assertSame(edgesList, importData.getImportAttrsOrBuilderList());
    assertSame(edgesList, importData.getOutputAttrsList());
    assertSame(edgesList, importData.getOutputAttrsOrBuilderList());
    assertSame(edgesList, importModel.getModelAttrsList());
    assertSame(edgesList, importModel.getModelAttrsOrBuilderList());
    assertSame(edgesList, runFlow.getOutputAttrsList());
    assertSame(edgesList, runFlow.getOutputAttrsOrBuilderList());
    assertSame(edgesList, runModel.getOutputAttrsList());
    assertSame(edgesList, runModel.getOutputAttrsOrBuilderList());
    assertSame(edgesList, table.getFieldsList());
    assertSame(edgesList, table.getFieldsOrBuilderList());
    assertSame(exportData, exportData.getDefaultInstanceForType());
    assertSame(exportData, job.getExportDataOrBuilder());
    assertSame(importData, importData.getDefaultInstanceForType());
    assertSame(importData, job.getImportDataOrBuilder());
    assertSame(importModel, importModel.getDefaultInstanceForType());
    assertSame(importModel, job.getImportModelOrBuilder());
    assertSame(jobGroup, job.getJobGroupOrBuilder());
    assertSame(jobGroup, jobGroup.getDefaultInstanceForType());
    assertSame(runFlow, job.getRunFlowOrBuilder());
    assertSame(runFlow, runFlow.getDefaultInstanceForType());
    assertSame(runModel, job.getRunModelOrBuilder());
    assertSame(runModel, runModel.getDefaultInstanceForType());
    assertSame(custom, custom.getDefaultInstanceForType());
    assertSame(custom, objectDefinition.getCustomOrBuilder());
    assertSame(data, data.getDefaultInstanceForType());
    assertSame(data, objectDefinition.getDataOrBuilder());
    assertSame(file, file.getDefaultInstanceForType());
    assertSame(file, objectDefinition.getFileOrBuilder());
    assertSame(flow, flow.getDefaultInstanceForType());
    assertSame(flow, objectDefinition.getFlowOrBuilder());
    assertSame(job, job.getDefaultInstanceForType());
    assertSame(job, objectDefinition.getJobOrBuilder());
    assertSame(model, model.getDefaultInstanceForType());
    assertSame(model, objectDefinition.getModelOrBuilder());
    assertSame(result, objectDefinition.getResultOrBuilder());
    assertSame(result, result.getDefaultInstanceForType());
    assertSame(schema, data.getSchema());
    assertSame(schema, data.getSchemaOrBuilder());
    assertSame(schema, objectDefinition.getSchemaOrBuilder());
    assertSame(schema, schema.getDefaultInstanceForType());
    assertSame(storage, objectDefinition.getStorageOrBuilder());
    assertSame(storage, storage.getDefaultInstanceForType());
    assertSame(struct, schema.getStructOrBuilder());
    assertSame(struct, struct.getDefaultInstanceForType());
    assertSame(table, schema.getTableOrBuilder());
    assertSame(table, table.getDefaultInstanceForType());
    assertSame(objectAsOf, objectAsOf.getDefaultInstanceForType());
    assertSame(objectAsOf, schemaId.getObjectAsOfOrBuilder());
    assertSame(objectAsOf, schemaId.getTagAsOf());
    assertSame(objectAsOf, schemaId.getTagAsOfOrBuilder());
  }

  /**
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByVersion(Connection, short, long, int)}
   */
  @Test
  void testReadDefinitionByVersion11() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}
   */
  @Test
  void testReadDefinitionByAsOf() throws UnsupportedEncodingException, SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}
   */
  @Test
  void testReadDefinitionByAsOf2() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}
   */
  @Test
  void testReadDefinitionByAsOf3() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}
   */
  @Test
  void testReadDefinitionByAsOf4() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}
   */
  @Test
  void testReadDefinitionByAsOf5() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}
   */
  @Test
  void testReadDefinitionByAsOf6() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}
   */
  @Test
  void testReadDefinitionByAsOf7() throws UnsupportedEncodingException, SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}
   */
  @Test
  void testReadDefinitionByAsOf8() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}
   */
  @Test
  void testReadDefinitionByAsOf9() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}
   */
  @Test
  void testReadDefinitionByAsOf10() throws SQLException {
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
    JdbcBaseDal.KeyedItem<ObjectDefinition> actualReadDefinitionByAsOfResult = jdbcReadImpl.readDefinitionByAsOf(conn,
        (short) 1, 1L, LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

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
    ObjectDefinition objectDefinition = actualReadDefinitionByAsOfResult.item;
    Descriptors.Descriptor descriptorForType = objectDefinition.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(11, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertTrue(getResult.getDefaultValue() instanceof Descriptors.EnumValueDescriptor);
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertEquals("", options.getInitializationErrorString());
    CustomDefinition custom = objectDefinition.getCustom();
    Descriptors.Descriptor descriptorForType2 = custom.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    DataDefinition data = objectDefinition.getData();
    Descriptors.Descriptor descriptorForType3 = data.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    assertEquals("", toProtoResult2.getInitializationErrorString());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    TagSelector schemaId = data.getSchemaId();
    assertEquals("", schemaId.getInitializationErrorString());
    JobDefinition job = objectDefinition.getJob();
    ExportDataJob exportData = job.getExportData();
    assertEquals("", exportData.getInitializationErrorString());
    ImportDataJob importData = job.getImportData();
    assertEquals("", importData.getInitializationErrorString());
    ImportModelJob importModel = job.getImportModel();
    assertEquals("", importModel.getInitializationErrorString());
    JobGroup jobGroup = job.getJobGroup();
    assertEquals("", jobGroup.getInitializationErrorString());
    RunFlowJob runFlow = job.getRunFlow();
    assertEquals("", runFlow.getInitializationErrorString());
    RunModelJob runModel = job.getRunModel();
    assertEquals("", runModel.getInitializationErrorString());
    assertEquals("", custom.getInitializationErrorString());
    assertEquals("", data.getInitializationErrorString());
    FileDefinition file = objectDefinition.getFile();
    assertEquals("", file.getInitializationErrorString());
    FlowDefinition flow = objectDefinition.getFlow();
    assertEquals("", flow.getInitializationErrorString());
    assertEquals("", job.getInitializationErrorString());
    ModelDefinition model = objectDefinition.getModel();
    assertEquals("", model.getInitializationErrorString());
    ResultDefinition result = objectDefinition.getResult();
    assertEquals("", result.getInitializationErrorString());
    SchemaDefinition schema = objectDefinition.getSchema();
    assertEquals("", schema.getInitializationErrorString());
    StorageDefinition storage = objectDefinition.getStorage();
    assertEquals("", storage.getInitializationErrorString());
    StructSchema struct = schema.getStruct();
    assertEquals("", struct.getInitializationErrorString());
    TableSchema table = schema.getTable();
    assertEquals("", table.getInitializationErrorString());
    DatetimeValue objectAsOf = schemaId.getObjectAsOf();
    assertEquals("", objectAsOf.getInitializationErrorString());
    assertEquals("", objectDefinition.getInitializationErrorString());
    ByteString customData = custom.getCustomData();
    assertEquals("", customData.toStringUtf8());
    assertEquals("", custom.getCustomSchemaType());
    assertEquals("", objectAsOf.getIsoDatetime());
    assertEquals("", file.getDataItem());
    assertEquals("", file.getExtension());
    assertEquals("", file.getMimeType());
    assertEquals("", file.getName());
    assertEquals("", importModel.getEntryPoint());
    assertEquals("", importModel.getLanguage());
    assertEquals("", importModel.getPackage());
    assertEquals("", importModel.getPackageGroup());
    assertEquals("", importModel.getPath());
    assertEquals("", importModel.getRepository());
    assertEquals("", importModel.getVersion());
    assertEquals("", model.getEntryPoint());
    assertEquals("", model.getLanguage());
    assertEquals("", model.getPackage());
    assertEquals("", model.getPackageGroup());
    assertEquals("", model.getPath());
    assertEquals("", model.getRepository());
    assertEquals("", model.getVersion());
    assertEquals("", result.getStatusMessage());
    assertEquals("", schemaId.getObjectId());
    assertEquals("CustomDefinition", toProtoResult.getName());
    assertEquals("CustomDefinition", descriptorForType2.getName());
    assertEquals("DataDefinition", toProtoResult2.getName());
    assertEquals("DataDefinition", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = file.getDescriptorForType();
    assertEquals("FileDefinition", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = flow.getDescriptorForType();
    assertEquals("FlowDefinition", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = job.getDescriptorForType();
    assertEquals("JobDefinition", descriptorForType6.getName());
    Descriptors.Descriptor descriptorForType7 = model.getDescriptorForType();
    assertEquals("ModelDefinition", descriptorForType7.getName());
    assertEquals("ObjectDefinition", toProtoResult3.getName());
    assertEquals("ObjectDefinition", descriptorForType.getName());
    Descriptors.Descriptor descriptorForType8 = result.getDescriptorForType();
    assertEquals("ResultDefinition", descriptorForType8.getName());
    Descriptors.Descriptor descriptorForType9 = schema.getDescriptorForType();
    assertEquals("SchemaDefinition", descriptorForType9.getName());
    Descriptors.Descriptor descriptorForType10 = storage.getDescriptorForType();
    assertEquals("StorageDefinition", descriptorForType10.getName());
    Descriptors.Descriptor descriptorForType11 = schemaId.getDescriptorForType();
    assertEquals("TagSelector", descriptorForType11.getName());
    assertEquals("objectType", getResult.getJsonName());
    assertEquals("objectType", getResult.getName());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("tracdap.metadata", file2.getPackage());
    Descriptors.FileDescriptor file3 = descriptorForType3.getFile();
    assertEquals("tracdap.metadata", file3.getPackage());
    Descriptors.FileDescriptor file4 = descriptorForType.getFile();
    assertEquals("tracdap.metadata", file4.getPackage());
    assertEquals("tracdap.metadata.CustomDefinition", descriptorForType2.getFullName());
    assertEquals("tracdap.metadata.DataDefinition", descriptorForType3.getFullName());
    assertEquals("tracdap.metadata.FileDefinition", descriptorForType4.getFullName());
    assertEquals("tracdap.metadata.FlowDefinition", descriptorForType5.getFullName());
    assertEquals("tracdap.metadata.JobDefinition", descriptorForType6.getFullName());
    assertEquals("tracdap.metadata.ModelDefinition", descriptorForType7.getFullName());
    assertEquals("tracdap.metadata.ObjectDefinition", descriptorForType.getFullName());
    assertEquals("tracdap.metadata.ObjectDefinition.objectType", getResult.getFullName());
    assertEquals("tracdap.metadata.ResultDefinition", descriptorForType8.getFullName());
    assertEquals("tracdap.metadata.SchemaDefinition", descriptorForType9.getFullName());
    assertEquals("tracdap.metadata.StorageDefinition", descriptorForType10.getFullName());
    assertEquals("tracdap.metadata.TagSelector", descriptorForType11.getFullName());
    assertEquals("tracdap/metadata/custom.proto", file2.getFullName());
    assertEquals("tracdap/metadata/custom.proto", file2.getName());
    assertEquals("tracdap/metadata/data.proto", file3.getFullName());
    assertEquals("tracdap/metadata/data.proto", file3.getName());
    assertEquals("tracdap/metadata/object.proto", file4.getFullName());
    assertEquals("tracdap/metadata/object.proto", file4.getName());
    assertNull(descriptorForType11.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType8.getContainingType());
    assertNull(descriptorForType9.getContainingType());
    assertNull(descriptorForType10.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult2.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult2.getExtensionRangeCount());
    assertEquals(0, toProtoResult3.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult2.getReservedNameCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, toProtoResult2.getReservedRangeCount());
    assertEquals(0, toProtoResult3.getReservedRangeCount());
    assertEquals(0, options.getSerializedSize());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, descriptorForType2.getIndex());
    assertEquals(0, descriptorForType4.getIndex());
    assertEquals(0, descriptorForType6.getIndex());
    assertEquals(0, descriptorForType.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = objectDefinition.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    Instant instant = actualReadDefinitionByAsOfResult.timestamp;
    assertEquals(0, instant.getNano());
    assertEquals(0, custom.getCustomSchemaVersion());
    assertEquals(0, custom.getSerializedSize());
    assertEquals(0, data.getPartsCount());
    assertEquals(0, data.getSerializedSize());
    assertEquals(0, objectAsOf.getSerializedSize());
    assertEquals(0, exportData.getExportsCount());
    assertEquals(0, exportData.getInputsCount());
    assertEquals(0, exportData.getOutputAttrsCount());
    assertEquals(0, exportData.getOutputsCount());
    assertEquals(0, exportData.getParametersCount());
    assertEquals(0, exportData.getPriorOutputsCount());
    assertEquals(0, exportData.getSerializedSize());
    assertEquals(0, exportData.getStorageAccessCount());
    assertEquals(0, file.getSerializedSize());
    assertEquals(0, flow.getEdgesCount());
    assertEquals(0, flow.getInputsCount());
    assertEquals(0, flow.getNodesCount());
    assertEquals(0, flow.getOutputsCount());
    assertEquals(0, flow.getParametersCount());
    assertEquals(0, flow.getSerializedSize());
    assertEquals(0, importData.getImportAttrsCount());
    assertEquals(0, importData.getImportsCount());
    assertEquals(0, importData.getInputsCount());
    assertEquals(0, importData.getOutputAttrsCount());
    assertEquals(0, importData.getOutputsCount());
    assertEquals(0, importData.getParametersCount());
    assertEquals(0, importData.getPriorOutputsCount());
    assertEquals(0, importData.getSerializedSize());
    assertEquals(0, importData.getStorageAccessCount());
    assertEquals(0, importModel.getModelAttrsCount());
    assertEquals(0, importModel.getSerializedSize());
    assertEquals(0, job.getJobTypeValue());
    assertEquals(0, job.getSerializedSize());
    assertEquals(0, jobGroup.getJobGroupTypeValue());
    assertEquals(0, jobGroup.getSerializedSize());
    assertEquals(0, model.getInputsCount());
    assertEquals(0, model.getModelTypeValue());
    assertEquals(0, model.getOutputsCount());
    assertEquals(0, model.getParametersCount());
    assertEquals(0, model.getSerializedSize());
    assertEquals(0, model.getStaticAttributesCount());
    assertEquals(0, objectDefinition.getObjectPropsCount());
    assertEquals(0, objectDefinition.getObjectTypeValue());
    assertEquals(0, objectDefinition.getSerializedSize());
    assertEquals(0, result.getSerializedSize());
    assertEquals(0, result.getStatusCodeValue());
    assertEquals(0, runFlow.getInputsCount());
    assertEquals(0, runFlow.getModelsCount());
    assertEquals(0, runFlow.getOutputAttrsCount());
    assertEquals(0, runFlow.getOutputsCount());
    assertEquals(0, runFlow.getParametersCount());
    assertEquals(0, runFlow.getPriorOutputsCount());
    assertEquals(0, runFlow.getSerializedSize());
    assertEquals(0, runModel.getInputsCount());
    assertEquals(0, runModel.getOutputAttrsCount());
    assertEquals(0, runModel.getOutputsCount());
    assertEquals(0, runModel.getParametersCount());
    assertEquals(0, runModel.getPriorOutputsCount());
    assertEquals(0, runModel.getSerializedSize());
    assertEquals(0, schema.getPartTypeValue());
    assertEquals(0, schema.getSchemaTypeValue());
    assertEquals(0, schema.getSerializedSize());
    assertEquals(0, storage.getDataItemsCount());
    assertEquals(0, storage.getSerializedSize());
    assertEquals(0, storage.getStorageOptionsCount());
    assertEquals(0, struct.getFieldsCount());
    assertEquals(0, struct.getNamedTypesCount());
    assertEquals(0, struct.getSerializedSize());
    assertEquals(0, table.getFieldsCount());
    assertEquals(0, table.getSerializedSize());
    assertEquals(0, schemaId.getObjectTypeValue());
    assertEquals(0, schemaId.getObjectVersion());
    assertEquals(0, schemaId.getSerializedSize());
    assertEquals(0, schemaId.getTagVersion());
    assertEquals(0L, instant.getEpochSecond());
    assertEquals(0L, file.getSize());
    assertEquals(1, toProtoResult3.getNestedTypeCount());
    assertEquals(1, toProtoResult2.getOneofDeclCount());
    assertEquals(1, toProtoResult3.getOneofDeclCount());
    assertEquals(1, descriptorForType11.getIndex());
    assertEquals(1, descriptorForType8.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(1, descriptorForType.getNestedTypes().size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType3.getOneofs();
    assertEquals(1, oneofs.size());
    List<Descriptors.OneofDescriptor> oneofs2 = descriptorForType.getOneofs();
    assertEquals(1, oneofs2.size());
    List<Descriptors.OneofDescriptor> realOneofs = descriptorForType3.getRealOneofs();
    assertEquals(1, realOneofs.size());
    List<Descriptors.OneofDescriptor> realOneofs2 = descriptorForType.getRealOneofs();
    assertEquals(1, realOneofs2.size());
    assertEquals(1, actualReadDefinitionByAsOfResult.version);
    assertEquals(11, toProtoResult3.getFieldCount());
    assertEquals(1L, actualReadDefinitionByAsOfResult.key);
    assertEquals(3, toProtoResult.getFieldCount());
    assertEquals(3, descriptorForType5.getIndex());
    assertEquals(3, descriptorForType7.getIndex());
    assertEquals(3, descriptorForType10.getIndex());
    assertEquals(3, descriptorForType2.getFields().size());
    assertEquals(4, toProtoResult2.getFieldCount());
    assertEquals(4, toProtoResult2.getNestedTypeCount());
    assertEquals(4, descriptorForType9.getIndex());
    assertEquals(4, descriptorForType3.getFields().size());
    assertEquals(4, descriptorForType3.getNestedTypes().size());
    assertEquals(570, toProtoResult2.getSerializedSize());
    assertEquals(6, descriptorForType3.getIndex());
    assertEquals(701, toProtoResult3.getSerializedSize());
    assertEquals(93, toProtoResult.getSerializedSize());
    assertEquals(Descriptors.FieldDescriptor.JavaType.ENUM, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.ENUM, getResult.getType());
    assertEquals(WireFormat.FieldType.ENUM, getResult.getLiteType());
    assertEquals(WireFormat.JavaType.ENUM, getResult.getLiteJavaType());
    assertEquals(DataDefinition.SchemaSpecifierCase.SCHEMASPECIFIER_NOT_SET, data.getSchemaSpecifierCase());
    assertEquals(JobDefinition.JobDetailsCase.JOBDETAILS_NOT_SET, job.getJobDetailsCase());
    assertEquals(JobGroup.JobGroupDetailsCase.JOBGROUPDETAILS_NOT_SET, jobGroup.getJobGroupDetailsCase());
    assertEquals(JobGroupType.JOB_GROUP_TYPE_NOT_SET, jobGroup.getJobGroupType());
    assertEquals(JobStatusCode.JOB_STATUS_CODE_NOT_SET, result.getStatusCode());
    assertEquals(JobType.JOB_TYPE_NOT_SET, job.getJobType());
    assertEquals(ModelType.STANDARD_MODEL, model.getModelType());
    assertEquals(ObjectDefinition.DefinitionCase.DEFINITION_NOT_SET, objectDefinition.getDefinitionCase());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, objectDefinition.getObjectType());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, schemaId.getObjectType());
    assertEquals(PartType.PART_ROOT, schema.getPartType());
    assertEquals(SchemaDefinition.SchemaDetailsCase.SCHEMADETAILS_NOT_SET, schema.getSchemaDetailsCase());
    assertEquals(SchemaType.SCHEMA_TYPE_NOT_SET, schema.getSchemaType());
    assertEquals(TagSelector.ObjectCriteriaCase.OBJECTCRITERIA_NOT_SET, schemaId.getObjectCriteriaCase());
    assertEquals(TagSelector.TagCriteriaCase.TAGCRITERIA_NOT_SET, schemaId.getTagCriteriaCase());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(options.getDeprecated());
    assertFalse(options.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options.getMapEntry());
    assertFalse(options.getMessageSetWireFormat());
    assertFalse(options.getNoStandardDescriptorAccessor());
    assertFalse(options.hasDeprecated());
    assertFalse(options.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options.hasFeatures());
    assertFalse(options.hasMapEntry());
    assertFalse(options.hasMessageSetWireFormat());
    assertFalse(options.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType11.isExtendable());
    assertFalse(descriptorForType2.isExtendable());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType4.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType6.isExtendable());
    assertFalse(descriptorForType7.isExtendable());
    assertFalse(descriptorForType8.isExtendable());
    assertFalse(descriptorForType9.isExtendable());
    assertFalse(descriptorForType10.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(customData.iterator().hasNext());
    assertFalse(data.hasSchema());
    assertFalse(data.hasSchemaId());
    assertFalse(data.hasStorageId());
    assertFalse(exportData.hasModel());
    assertFalse(file.hasStorageId());
    assertFalse(importData.hasModel());
    assertFalse(importModel.hasPackageGroup());
    assertFalse(job.hasExportData());
    assertFalse(job.hasImportData());
    assertFalse(job.hasImportModel());
    assertFalse(job.hasJobGroup());
    assertFalse(job.hasResultId());
    assertFalse(job.hasRunFlow());
    assertFalse(job.hasRunModel());
    assertFalse(jobGroup.hasParallel());
    assertFalse(jobGroup.hasSequential());
    assertFalse(model.hasPackageGroup());
    assertFalse(model.hasPath());
    assertFalse(objectDefinition.hasCustom());
    assertFalse(objectDefinition.hasData());
    assertFalse(objectDefinition.hasFile());
    assertFalse(objectDefinition.hasFlow());
    assertFalse(objectDefinition.hasJob());
    assertFalse(objectDefinition.hasModel());
    assertFalse(objectDefinition.hasResult());
    assertFalse(objectDefinition.hasSchema());
    assertFalse(objectDefinition.hasStorage());
    assertFalse(result.hasJobId());
    assertFalse(result.hasLogFileId());
    assertFalse(runFlow.hasFlow());
    assertFalse(runModel.hasModel());
    assertFalse(schema.hasStruct());
    assertFalse(schema.hasTable());
    assertFalse(schemaId.getLatestObject());
    assertFalse(schemaId.getLatestTag());
    assertFalse(schemaId.hasLatestObject());
    assertFalse(schemaId.hasLatestTag());
    assertFalse(schemaId.hasObjectAsOf());
    assertFalse(schemaId.hasObjectVersion());
    assertFalse(schemaId.hasTagAsOf());
    assertFalse(schemaId.hasTagVersion());
    assertTrue(customData.isEmpty());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(getResult.isOptional());
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    assertTrue(schemaId.findInitializationErrors().isEmpty());
    assertTrue(custom.findInitializationErrors().isEmpty());
    assertTrue(data.findInitializationErrors().isEmpty());
    assertTrue(file.findInitializationErrors().isEmpty());
    assertTrue(flow.findInitializationErrors().isEmpty());
    assertTrue(job.findInitializationErrors().isEmpty());
    assertTrue(model.findInitializationErrors().isEmpty());
    assertTrue(result.findInitializationErrors().isEmpty());
    assertTrue(schema.findInitializationErrors().isEmpty());
    assertTrue(storage.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = objectDefinition.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    List<FlowEdge> edgesList = flow.getEdgesList();
    assertTrue(edgesList.isEmpty());
    assertTrue(schemaId.getAllFields().isEmpty());
    assertTrue(custom.getAllFields().isEmpty());
    assertTrue(data.getAllFields().isEmpty());
    assertTrue(file.getAllFields().isEmpty());
    assertTrue(flow.getAllFields().isEmpty());
    assertTrue(job.getAllFields().isEmpty());
    assertTrue(model.getAllFields().isEmpty());
    assertTrue(result.getAllFields().isEmpty());
    assertTrue(schema.getAllFields().isEmpty());
    assertTrue(storage.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = objectDefinition.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(data.getParts().isEmpty());
    assertTrue(data.getPartsMap().isEmpty());
    assertTrue(flow.getInputs().isEmpty());
    assertTrue(flow.getInputsMap().isEmpty());
    assertTrue(flow.getNodes().isEmpty());
    assertTrue(flow.getNodesMap().isEmpty());
    assertTrue(flow.getOutputs().isEmpty());
    assertTrue(flow.getOutputsMap().isEmpty());
    assertTrue(flow.getParameters().isEmpty());
    assertTrue(flow.getParametersMap().isEmpty());
    assertTrue(model.getInputs().isEmpty());
    assertTrue(model.getInputsMap().isEmpty());
    assertTrue(model.getOutputs().isEmpty());
    assertTrue(model.getOutputsMap().isEmpty());
    assertTrue(model.getParameters().isEmpty());
    assertTrue(model.getParametersMap().isEmpty());
    assertTrue(model.getStaticAttributes().isEmpty());
    assertTrue(model.getStaticAttributesMap().isEmpty());
    assertTrue(objectDefinition.getObjectProps().isEmpty());
    assertTrue(objectDefinition.getObjectPropsMap().isEmpty());
    assertTrue(storage.getDataItems().isEmpty());
    assertTrue(storage.getDataItemsMap().isEmpty());
    assertTrue(storage.getStorageOptions().isEmpty());
    assertTrue(storage.getStorageOptionsMap().isEmpty());
    assertTrue(custom.isInitialized());
    assertTrue(data.isInitialized());
    assertTrue(objectAsOf.isInitialized());
    assertTrue(exportData.isInitialized());
    assertTrue(file.isInitialized());
    assertTrue(flow.isInitialized());
    assertTrue(importData.isInitialized());
    assertTrue(importModel.isInitialized());
    assertTrue(job.isInitialized());
    assertTrue(jobGroup.isInitialized());
    assertTrue(model.isInitialized());
    assertTrue(objectDefinition.isInitialized());
    assertTrue(result.isInitialized());
    assertTrue(runFlow.isInitialized());
    assertTrue(runModel.isInitialized());
    assertTrue(schema.isInitialized());
    assertTrue(storage.isInitialized());
    assertTrue(struct.isInitialized());
    assertTrue(table.isInitialized());
    assertTrue(schemaId.isInitialized());
    assertTrue(actualReadDefinitionByAsOfResult.isLatest);
    assertEquals(findInitializationErrorsResult, options.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, exportData.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, importData.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, importModel.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, jobGroup.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, runFlow.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, runModel.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, struct.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, table.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, objectAsOf.findInitializationErrors());
    ProtocolStringList reservedNameList = toProtoResult3.getReservedNameList();
    assertEquals(findInitializationErrorsResult, reservedNameList);
    assertEquals(findInitializationErrorsResult, descriptorForType11.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType9.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType10.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType11.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType9.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType10.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType11.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType9.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType10.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType10.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getEnumTypes());
    assertEquals(findInitializationErrorsResult, file4.getEnumTypes());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file3.getExtensions());
    assertEquals(findInitializationErrorsResult, file4.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file3.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file4.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(findInitializationErrorsResult, file3.getServices());
    assertEquals(findInitializationErrorsResult, file4.getServices());
    assertEquals(allFields, exportData.getAllFields());
    assertEquals(allFields, importData.getAllFields());
    assertEquals(allFields, importModel.getAllFields());
    assertEquals(allFields, jobGroup.getAllFields());
    assertEquals(allFields, runFlow.getAllFields());
    assertEquals(allFields, runModel.getAllFields());
    assertEquals(allFields, struct.getAllFields());
    assertEquals(allFields, table.getAllFields());
    assertEquals(allFields, objectAsOf.getAllFields());
    assertEquals(allFields, options.getAllFields());
    assertEquals(allFields, options.getAllFieldsRaw());
    assertEquals(allFields, exportData.getExports());
    assertEquals(allFields, exportData.getExportsMap());
    assertEquals(allFields, exportData.getInputs());
    assertEquals(allFields, exportData.getInputsMap());
    assertEquals(allFields, exportData.getOutputs());
    assertEquals(allFields, exportData.getOutputsMap());
    assertEquals(allFields, exportData.getParameters());
    assertEquals(allFields, exportData.getParametersMap());
    assertEquals(allFields, exportData.getPriorOutputs());
    assertEquals(allFields, exportData.getPriorOutputsMap());
    assertEquals(allFields, importData.getImports());
    assertEquals(allFields, importData.getImportsMap());
    assertEquals(allFields, importData.getInputs());
    assertEquals(allFields, importData.getInputsMap());
    assertEquals(allFields, importData.getOutputs());
    assertEquals(allFields, importData.getOutputsMap());
    assertEquals(allFields, importData.getParameters());
    assertEquals(allFields, importData.getParametersMap());
    assertEquals(allFields, importData.getPriorOutputs());
    assertEquals(allFields, importData.getPriorOutputsMap());
    assertEquals(allFields, runFlow.getInputs());
    assertEquals(allFields, runFlow.getInputsMap());
    assertEquals(allFields, runFlow.getModels());
    assertEquals(allFields, runFlow.getModelsMap());
    assertEquals(allFields, runFlow.getOutputs());
    assertEquals(allFields, runFlow.getOutputsMap());
    assertEquals(allFields, runFlow.getParameters());
    assertEquals(allFields, runFlow.getParametersMap());
    assertEquals(allFields, runFlow.getPriorOutputs());
    assertEquals(allFields, runFlow.getPriorOutputsMap());
    assertEquals(allFields, runModel.getInputs());
    assertEquals(allFields, runModel.getInputsMap());
    assertEquals(allFields, runModel.getOutputs());
    assertEquals(allFields, runModel.getOutputsMap());
    assertEquals(allFields, runModel.getParameters());
    assertEquals(allFields, runModel.getParametersMap());
    assertEquals(allFields, runModel.getPriorOutputs());
    assertEquals(allFields, runModel.getPriorOutputsMap());
    assertEquals(allFields, struct.getFields());
    assertEquals(allFields, struct.getFieldsMap());
    assertEquals(allFields, struct.getNamedTypes());
    assertEquals(allFields, struct.getNamedTypesMap());
    assertEquals(customData, custom.getCustomSchemaTypeBytes());
    assertEquals(customData, objectAsOf.getIsoDatetimeBytes());
    assertEquals(customData, file.getDataItemBytes());
    assertEquals(customData, file.getExtensionBytes());
    assertEquals(customData, file.getMimeTypeBytes());
    assertEquals(customData, file.getNameBytes());
    assertEquals(customData, importModel.getEntryPointBytes());
    assertEquals(customData, importModel.getLanguageBytes());
    assertEquals(customData, importModel.getPackageBytes());
    assertEquals(customData, importModel.getPackageGroupBytes());
    assertEquals(customData, importModel.getPathBytes());
    assertEquals(customData, importModel.getRepositoryBytes());
    assertEquals(customData, importModel.getVersionBytes());
    assertEquals(customData, model.getEntryPointBytes());
    assertEquals(customData, model.getLanguageBytes());
    assertEquals(customData, model.getPackageBytes());
    assertEquals(customData, model.getPackageGroupBytes());
    assertEquals(customData, model.getPathBytes());
    assertEquals(customData, model.getRepositoryBytes());
    assertEquals(customData, model.getVersionBytes());
    assertEquals(customData, result.getStatusMessageBytes());
    assertEquals(customData, schemaId.getObjectIdBytes());
    ObjectDefinition expectedDefaultInstanceForType = actualReadDefinitionByAsOfResult.item;
    assertEquals(expectedDefaultInstanceForType, objectDefinition.getDefaultInstanceForType());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    assertSame(reservedNameList, toProtoResult2.getReservedNameList());
    assertSame(reservedNameList, exportData.getStorageAccessList());
    assertSame(reservedNameList, importData.getStorageAccessList());
    assertSame(file3, descriptorForType9.getFile());
    assertSame(file4, getResult.getFile());
    assertSame(options, toProtoResult.getOptions());
    assertSame(options, toProtoResult2.getOptions());
    assertSame(options, toProtoResult3.getOptions());
    assertSame(options, toProtoResult.getOptionsOrBuilder());
    assertSame(options, toProtoResult2.getOptionsOrBuilder());
    assertSame(options, toProtoResult3.getOptionsOrBuilder());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options, descriptorForType11.getOptions());
    assertSame(options, descriptorForType2.getOptions());
    assertSame(options, descriptorForType3.getOptions());
    assertSame(options, descriptorForType4.getOptions());
    assertSame(options, descriptorForType5.getOptions());
    assertSame(options, descriptorForType6.getOptions());
    assertSame(options, descriptorForType7.getOptions());
    assertSame(options, descriptorForType8.getOptions());
    assertSame(options, descriptorForType9.getOptions());
    assertSame(options, descriptorForType10.getOptions());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, schemaId.getUnknownFields());
    assertSame(unknownFields, exportData.getUnknownFields());
    assertSame(unknownFields, importData.getUnknownFields());
    assertSame(unknownFields, importModel.getUnknownFields());
    assertSame(unknownFields, jobGroup.getUnknownFields());
    assertSame(unknownFields, runFlow.getUnknownFields());
    assertSame(unknownFields, runModel.getUnknownFields());
    assertSame(unknownFields, custom.getUnknownFields());
    assertSame(unknownFields, data.getUnknownFields());
    assertSame(unknownFields, file.getUnknownFields());
    assertSame(unknownFields, flow.getUnknownFields());
    assertSame(unknownFields, job.getUnknownFields());
    assertSame(unknownFields, model.getUnknownFields());
    assertSame(unknownFields, result.getUnknownFields());
    assertSame(unknownFields, schema.getUnknownFields());
    assertSame(unknownFields, storage.getUnknownFields());
    assertSame(unknownFields, struct.getUnknownFields());
    assertSame(unknownFields, table.getUnknownFields());
    assertSame(unknownFields, objectAsOf.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(oneofs.get(0), realOneofs.get(0));
    assertSame(oneofs2.get(0), realOneofs2.get(0));
    assertSame(schemaId, data.getSchemaIdOrBuilder());
    assertSame(schemaId, data.getStorageId());
    assertSame(schemaId, data.getStorageIdOrBuilder());
    assertSame(schemaId, exportData.getModel());
    assertSame(schemaId, exportData.getModelOrBuilder());
    assertSame(schemaId, file.getStorageId());
    assertSame(schemaId, file.getStorageIdOrBuilder());
    assertSame(schemaId, importData.getModel());
    assertSame(schemaId, importData.getModelOrBuilder());
    assertSame(schemaId, job.getResultId());
    assertSame(schemaId, job.getResultIdOrBuilder());
    assertSame(schemaId, result.getJobId());
    assertSame(schemaId, result.getJobIdOrBuilder());
    assertSame(schemaId, result.getLogFileId());
    assertSame(schemaId, result.getLogFileIdOrBuilder());
    assertSame(schemaId, runFlow.getFlow());
    assertSame(schemaId, runFlow.getFlowOrBuilder());
    assertSame(schemaId, runModel.getModel());
    assertSame(schemaId, runModel.getModelOrBuilder());
    assertSame(schemaId, schemaId.getDefaultInstanceForType());
    assertSame(edgesList, toProtoResult.getEnumTypeList());
    assertSame(edgesList, toProtoResult2.getEnumTypeList());
    assertSame(edgesList, toProtoResult3.getEnumTypeList());
    assertSame(edgesList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(edgesList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(edgesList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(edgesList, toProtoResult.getExtensionList());
    assertSame(edgesList, toProtoResult2.getExtensionList());
    assertSame(edgesList, toProtoResult3.getExtensionList());
    assertSame(edgesList, toProtoResult.getExtensionOrBuilderList());
    assertSame(edgesList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(edgesList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(edgesList, toProtoResult.getExtensionRangeList());
    assertSame(edgesList, toProtoResult2.getExtensionRangeList());
    assertSame(edgesList, toProtoResult3.getExtensionRangeList());
    assertSame(edgesList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(edgesList, toProtoResult2.getExtensionRangeOrBuilderList());
    assertSame(edgesList, toProtoResult3.getExtensionRangeOrBuilderList());
    assertSame(edgesList, toProtoResult.getNestedTypeList());
    assertSame(edgesList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(edgesList, toProtoResult.getOneofDeclList());
    assertSame(edgesList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(edgesList, toProtoResult.getReservedRangeList());
    assertSame(edgesList, toProtoResult2.getReservedRangeList());
    assertSame(edgesList, toProtoResult3.getReservedRangeList());
    assertSame(edgesList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(edgesList, toProtoResult2.getReservedRangeOrBuilderList());
    assertSame(edgesList, toProtoResult3.getReservedRangeOrBuilderList());
    assertSame(edgesList, options.getUninterpretedOptionList());
    assertSame(edgesList, options.getUninterpretedOptionOrBuilderList());
    assertSame(edgesList, exportData.getOutputAttrsList());
    assertSame(edgesList, exportData.getOutputAttrsOrBuilderList());
    assertSame(edgesList, flow.getEdgesOrBuilderList());
    assertSame(edgesList, importData.getImportAttrsList());
    assertSame(edgesList, importData.getImportAttrsOrBuilderList());
    assertSame(edgesList, importData.getOutputAttrsList());
    assertSame(edgesList, importData.getOutputAttrsOrBuilderList());
    assertSame(edgesList, importModel.getModelAttrsList());
    assertSame(edgesList, importModel.getModelAttrsOrBuilderList());
    assertSame(edgesList, runFlow.getOutputAttrsList());
    assertSame(edgesList, runFlow.getOutputAttrsOrBuilderList());
    assertSame(edgesList, runModel.getOutputAttrsList());
    assertSame(edgesList, runModel.getOutputAttrsOrBuilderList());
    assertSame(edgesList, table.getFieldsList());
    assertSame(edgesList, table.getFieldsOrBuilderList());
    assertSame(exportData, exportData.getDefaultInstanceForType());
    assertSame(exportData, job.getExportDataOrBuilder());
    assertSame(importData, importData.getDefaultInstanceForType());
    assertSame(importData, job.getImportDataOrBuilder());
    assertSame(importModel, importModel.getDefaultInstanceForType());
    assertSame(importModel, job.getImportModelOrBuilder());
    assertSame(jobGroup, job.getJobGroupOrBuilder());
    assertSame(jobGroup, jobGroup.getDefaultInstanceForType());
    assertSame(runFlow, job.getRunFlowOrBuilder());
    assertSame(runFlow, runFlow.getDefaultInstanceForType());
    assertSame(runModel, job.getRunModelOrBuilder());
    assertSame(runModel, runModel.getDefaultInstanceForType());
    assertSame(custom, custom.getDefaultInstanceForType());
    assertSame(custom, objectDefinition.getCustomOrBuilder());
    assertSame(data, data.getDefaultInstanceForType());
    assertSame(data, objectDefinition.getDataOrBuilder());
    assertSame(file, file.getDefaultInstanceForType());
    assertSame(file, objectDefinition.getFileOrBuilder());
    assertSame(flow, flow.getDefaultInstanceForType());
    assertSame(flow, objectDefinition.getFlowOrBuilder());
    assertSame(job, job.getDefaultInstanceForType());
    assertSame(job, objectDefinition.getJobOrBuilder());
    assertSame(model, model.getDefaultInstanceForType());
    assertSame(model, objectDefinition.getModelOrBuilder());
    assertSame(result, objectDefinition.getResultOrBuilder());
    assertSame(result, result.getDefaultInstanceForType());
    assertSame(schema, data.getSchema());
    assertSame(schema, data.getSchemaOrBuilder());
    assertSame(schema, objectDefinition.getSchemaOrBuilder());
    assertSame(schema, schema.getDefaultInstanceForType());
    assertSame(storage, objectDefinition.getStorageOrBuilder());
    assertSame(storage, storage.getDefaultInstanceForType());
    assertSame(struct, schema.getStructOrBuilder());
    assertSame(struct, struct.getDefaultInstanceForType());
    assertSame(table, schema.getTableOrBuilder());
    assertSame(table, table.getDefaultInstanceForType());
    assertSame(objectAsOf, objectAsOf.getDefaultInstanceForType());
    assertSame(objectAsOf, schemaId.getObjectAsOfOrBuilder());
    assertSame(objectAsOf, schemaId.getTagAsOf());
    assertSame(objectAsOf, schemaId.getTagAsOfOrBuilder());
  }

  /**
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByAsOf(Connection, short, long, Instant)}
   */
  @Test
  void testReadDefinitionByAsOf11() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}
   */
  @Test
  void testReadDefinitionByLatest() throws UnsupportedEncodingException, SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}
   */
  @Test
  void testReadDefinitionByLatest2() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}
   */
  @Test
  void testReadDefinitionByLatest3() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}
   */
  @Test
  void testReadDefinitionByLatest4() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}
   */
  @Test
  void testReadDefinitionByLatest5() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}
   */
  @Test
  void testReadDefinitionByLatest6() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}
   */
  @Test
  void testReadDefinitionByLatest7() throws UnsupportedEncodingException, SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}
   */
  @Test
  void testReadDefinitionByLatest8() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}
   */
  @Test
  void testReadDefinitionByLatest9() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}
   */
  @Test
  void testReadDefinitionByLatest10() throws SQLException {
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
    JdbcBaseDal.KeyedItem<ObjectDefinition> actualReadDefinitionByLatestResult = jdbcReadImpl
        .readDefinitionByLatest(conn, (short) 1, 1L);

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
    ObjectDefinition objectDefinition = actualReadDefinitionByLatestResult.item;
    Descriptors.Descriptor descriptorForType = objectDefinition.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(11, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertTrue(getResult.getDefaultValue() instanceof Descriptors.EnumValueDescriptor);
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertEquals("", options.getInitializationErrorString());
    CustomDefinition custom = objectDefinition.getCustom();
    Descriptors.Descriptor descriptorForType2 = custom.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    DataDefinition data = objectDefinition.getData();
    Descriptors.Descriptor descriptorForType3 = data.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    assertEquals("", toProtoResult2.getInitializationErrorString());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    TagSelector schemaId = data.getSchemaId();
    assertEquals("", schemaId.getInitializationErrorString());
    JobDefinition job = objectDefinition.getJob();
    ExportDataJob exportData = job.getExportData();
    assertEquals("", exportData.getInitializationErrorString());
    ImportDataJob importData = job.getImportData();
    assertEquals("", importData.getInitializationErrorString());
    ImportModelJob importModel = job.getImportModel();
    assertEquals("", importModel.getInitializationErrorString());
    JobGroup jobGroup = job.getJobGroup();
    assertEquals("", jobGroup.getInitializationErrorString());
    RunFlowJob runFlow = job.getRunFlow();
    assertEquals("", runFlow.getInitializationErrorString());
    RunModelJob runModel = job.getRunModel();
    assertEquals("", runModel.getInitializationErrorString());
    assertEquals("", custom.getInitializationErrorString());
    assertEquals("", data.getInitializationErrorString());
    FileDefinition file = objectDefinition.getFile();
    assertEquals("", file.getInitializationErrorString());
    FlowDefinition flow = objectDefinition.getFlow();
    assertEquals("", flow.getInitializationErrorString());
    assertEquals("", job.getInitializationErrorString());
    ModelDefinition model = objectDefinition.getModel();
    assertEquals("", model.getInitializationErrorString());
    ResultDefinition result = objectDefinition.getResult();
    assertEquals("", result.getInitializationErrorString());
    SchemaDefinition schema = objectDefinition.getSchema();
    assertEquals("", schema.getInitializationErrorString());
    StorageDefinition storage = objectDefinition.getStorage();
    assertEquals("", storage.getInitializationErrorString());
    StructSchema struct = schema.getStruct();
    assertEquals("", struct.getInitializationErrorString());
    TableSchema table = schema.getTable();
    assertEquals("", table.getInitializationErrorString());
    DatetimeValue objectAsOf = schemaId.getObjectAsOf();
    assertEquals("", objectAsOf.getInitializationErrorString());
    assertEquals("", objectDefinition.getInitializationErrorString());
    ByteString customData = custom.getCustomData();
    assertEquals("", customData.toStringUtf8());
    assertEquals("", custom.getCustomSchemaType());
    assertEquals("", objectAsOf.getIsoDatetime());
    assertEquals("", file.getDataItem());
    assertEquals("", file.getExtension());
    assertEquals("", file.getMimeType());
    assertEquals("", file.getName());
    assertEquals("", importModel.getEntryPoint());
    assertEquals("", importModel.getLanguage());
    assertEquals("", importModel.getPackage());
    assertEquals("", importModel.getPackageGroup());
    assertEquals("", importModel.getPath());
    assertEquals("", importModel.getRepository());
    assertEquals("", importModel.getVersion());
    assertEquals("", model.getEntryPoint());
    assertEquals("", model.getLanguage());
    assertEquals("", model.getPackage());
    assertEquals("", model.getPackageGroup());
    assertEquals("", model.getPath());
    assertEquals("", model.getRepository());
    assertEquals("", model.getVersion());
    assertEquals("", result.getStatusMessage());
    assertEquals("", schemaId.getObjectId());
    assertEquals("CustomDefinition", toProtoResult.getName());
    assertEquals("CustomDefinition", descriptorForType2.getName());
    assertEquals("DataDefinition", toProtoResult2.getName());
    assertEquals("DataDefinition", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = file.getDescriptorForType();
    assertEquals("FileDefinition", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = flow.getDescriptorForType();
    assertEquals("FlowDefinition", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = job.getDescriptorForType();
    assertEquals("JobDefinition", descriptorForType6.getName());
    Descriptors.Descriptor descriptorForType7 = model.getDescriptorForType();
    assertEquals("ModelDefinition", descriptorForType7.getName());
    assertEquals("ObjectDefinition", toProtoResult3.getName());
    assertEquals("ObjectDefinition", descriptorForType.getName());
    Descriptors.Descriptor descriptorForType8 = result.getDescriptorForType();
    assertEquals("ResultDefinition", descriptorForType8.getName());
    Descriptors.Descriptor descriptorForType9 = schema.getDescriptorForType();
    assertEquals("SchemaDefinition", descriptorForType9.getName());
    Descriptors.Descriptor descriptorForType10 = storage.getDescriptorForType();
    assertEquals("StorageDefinition", descriptorForType10.getName());
    Descriptors.Descriptor descriptorForType11 = schemaId.getDescriptorForType();
    assertEquals("TagSelector", descriptorForType11.getName());
    assertEquals("objectType", getResult.getJsonName());
    assertEquals("objectType", getResult.getName());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("tracdap.metadata", file2.getPackage());
    Descriptors.FileDescriptor file3 = descriptorForType3.getFile();
    assertEquals("tracdap.metadata", file3.getPackage());
    Descriptors.FileDescriptor file4 = descriptorForType.getFile();
    assertEquals("tracdap.metadata", file4.getPackage());
    assertEquals("tracdap.metadata.CustomDefinition", descriptorForType2.getFullName());
    assertEquals("tracdap.metadata.DataDefinition", descriptorForType3.getFullName());
    assertEquals("tracdap.metadata.FileDefinition", descriptorForType4.getFullName());
    assertEquals("tracdap.metadata.FlowDefinition", descriptorForType5.getFullName());
    assertEquals("tracdap.metadata.JobDefinition", descriptorForType6.getFullName());
    assertEquals("tracdap.metadata.ModelDefinition", descriptorForType7.getFullName());
    assertEquals("tracdap.metadata.ObjectDefinition", descriptorForType.getFullName());
    assertEquals("tracdap.metadata.ObjectDefinition.objectType", getResult.getFullName());
    assertEquals("tracdap.metadata.ResultDefinition", descriptorForType8.getFullName());
    assertEquals("tracdap.metadata.SchemaDefinition", descriptorForType9.getFullName());
    assertEquals("tracdap.metadata.StorageDefinition", descriptorForType10.getFullName());
    assertEquals("tracdap.metadata.TagSelector", descriptorForType11.getFullName());
    assertEquals("tracdap/metadata/custom.proto", file2.getFullName());
    assertEquals("tracdap/metadata/custom.proto", file2.getName());
    assertEquals("tracdap/metadata/data.proto", file3.getFullName());
    assertEquals("tracdap/metadata/data.proto", file3.getName());
    assertEquals("tracdap/metadata/object.proto", file4.getFullName());
    assertEquals("tracdap/metadata/object.proto", file4.getName());
    assertNull(descriptorForType11.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType7.getContainingType());
    assertNull(descriptorForType8.getContainingType());
    assertNull(descriptorForType9.getContainingType());
    assertNull(descriptorForType10.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult2.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult2.getExtensionRangeCount());
    assertEquals(0, toProtoResult3.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult2.getReservedNameCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, toProtoResult2.getReservedRangeCount());
    assertEquals(0, toProtoResult3.getReservedRangeCount());
    assertEquals(0, options.getSerializedSize());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, descriptorForType2.getIndex());
    assertEquals(0, descriptorForType4.getIndex());
    assertEquals(0, descriptorForType6.getIndex());
    assertEquals(0, descriptorForType.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = objectDefinition.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    Instant instant = actualReadDefinitionByLatestResult.timestamp;
    assertEquals(0, instant.getNano());
    assertEquals(0, custom.getCustomSchemaVersion());
    assertEquals(0, custom.getSerializedSize());
    assertEquals(0, data.getPartsCount());
    assertEquals(0, data.getSerializedSize());
    assertEquals(0, objectAsOf.getSerializedSize());
    assertEquals(0, exportData.getExportsCount());
    assertEquals(0, exportData.getInputsCount());
    assertEquals(0, exportData.getOutputAttrsCount());
    assertEquals(0, exportData.getOutputsCount());
    assertEquals(0, exportData.getParametersCount());
    assertEquals(0, exportData.getPriorOutputsCount());
    assertEquals(0, exportData.getSerializedSize());
    assertEquals(0, exportData.getStorageAccessCount());
    assertEquals(0, file.getSerializedSize());
    assertEquals(0, flow.getEdgesCount());
    assertEquals(0, flow.getInputsCount());
    assertEquals(0, flow.getNodesCount());
    assertEquals(0, flow.getOutputsCount());
    assertEquals(0, flow.getParametersCount());
    assertEquals(0, flow.getSerializedSize());
    assertEquals(0, importData.getImportAttrsCount());
    assertEquals(0, importData.getImportsCount());
    assertEquals(0, importData.getInputsCount());
    assertEquals(0, importData.getOutputAttrsCount());
    assertEquals(0, importData.getOutputsCount());
    assertEquals(0, importData.getParametersCount());
    assertEquals(0, importData.getPriorOutputsCount());
    assertEquals(0, importData.getSerializedSize());
    assertEquals(0, importData.getStorageAccessCount());
    assertEquals(0, importModel.getModelAttrsCount());
    assertEquals(0, importModel.getSerializedSize());
    assertEquals(0, job.getJobTypeValue());
    assertEquals(0, job.getSerializedSize());
    assertEquals(0, jobGroup.getJobGroupTypeValue());
    assertEquals(0, jobGroup.getSerializedSize());
    assertEquals(0, model.getInputsCount());
    assertEquals(0, model.getModelTypeValue());
    assertEquals(0, model.getOutputsCount());
    assertEquals(0, model.getParametersCount());
    assertEquals(0, model.getSerializedSize());
    assertEquals(0, model.getStaticAttributesCount());
    assertEquals(0, objectDefinition.getObjectPropsCount());
    assertEquals(0, objectDefinition.getObjectTypeValue());
    assertEquals(0, objectDefinition.getSerializedSize());
    assertEquals(0, result.getSerializedSize());
    assertEquals(0, result.getStatusCodeValue());
    assertEquals(0, runFlow.getInputsCount());
    assertEquals(0, runFlow.getModelsCount());
    assertEquals(0, runFlow.getOutputAttrsCount());
    assertEquals(0, runFlow.getOutputsCount());
    assertEquals(0, runFlow.getParametersCount());
    assertEquals(0, runFlow.getPriorOutputsCount());
    assertEquals(0, runFlow.getSerializedSize());
    assertEquals(0, runModel.getInputsCount());
    assertEquals(0, runModel.getOutputAttrsCount());
    assertEquals(0, runModel.getOutputsCount());
    assertEquals(0, runModel.getParametersCount());
    assertEquals(0, runModel.getPriorOutputsCount());
    assertEquals(0, runModel.getSerializedSize());
    assertEquals(0, schema.getPartTypeValue());
    assertEquals(0, schema.getSchemaTypeValue());
    assertEquals(0, schema.getSerializedSize());
    assertEquals(0, storage.getDataItemsCount());
    assertEquals(0, storage.getSerializedSize());
    assertEquals(0, storage.getStorageOptionsCount());
    assertEquals(0, struct.getFieldsCount());
    assertEquals(0, struct.getNamedTypesCount());
    assertEquals(0, struct.getSerializedSize());
    assertEquals(0, table.getFieldsCount());
    assertEquals(0, table.getSerializedSize());
    assertEquals(0, schemaId.getObjectTypeValue());
    assertEquals(0, schemaId.getObjectVersion());
    assertEquals(0, schemaId.getSerializedSize());
    assertEquals(0, schemaId.getTagVersion());
    assertEquals(0L, instant.getEpochSecond());
    assertEquals(0L, file.getSize());
    assertEquals(1, toProtoResult3.getNestedTypeCount());
    assertEquals(1, toProtoResult2.getOneofDeclCount());
    assertEquals(1, toProtoResult3.getOneofDeclCount());
    assertEquals(1, descriptorForType11.getIndex());
    assertEquals(1, descriptorForType8.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(1, descriptorForType.getNestedTypes().size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType3.getOneofs();
    assertEquals(1, oneofs.size());
    List<Descriptors.OneofDescriptor> oneofs2 = descriptorForType.getOneofs();
    assertEquals(1, oneofs2.size());
    List<Descriptors.OneofDescriptor> realOneofs = descriptorForType3.getRealOneofs();
    assertEquals(1, realOneofs.size());
    List<Descriptors.OneofDescriptor> realOneofs2 = descriptorForType.getRealOneofs();
    assertEquals(1, realOneofs2.size());
    assertEquals(1, actualReadDefinitionByLatestResult.version);
    assertEquals(11, toProtoResult3.getFieldCount());
    assertEquals(1L, actualReadDefinitionByLatestResult.key);
    assertEquals(3, toProtoResult.getFieldCount());
    assertEquals(3, descriptorForType5.getIndex());
    assertEquals(3, descriptorForType7.getIndex());
    assertEquals(3, descriptorForType10.getIndex());
    assertEquals(3, descriptorForType2.getFields().size());
    assertEquals(4, toProtoResult2.getFieldCount());
    assertEquals(4, toProtoResult2.getNestedTypeCount());
    assertEquals(4, descriptorForType9.getIndex());
    assertEquals(4, descriptorForType3.getFields().size());
    assertEquals(4, descriptorForType3.getNestedTypes().size());
    assertEquals(570, toProtoResult2.getSerializedSize());
    assertEquals(6, descriptorForType3.getIndex());
    assertEquals(701, toProtoResult3.getSerializedSize());
    assertEquals(93, toProtoResult.getSerializedSize());
    assertEquals(Descriptors.FieldDescriptor.JavaType.ENUM, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.ENUM, getResult.getType());
    assertEquals(WireFormat.FieldType.ENUM, getResult.getLiteType());
    assertEquals(WireFormat.JavaType.ENUM, getResult.getLiteJavaType());
    assertEquals(DataDefinition.SchemaSpecifierCase.SCHEMASPECIFIER_NOT_SET, data.getSchemaSpecifierCase());
    assertEquals(JobDefinition.JobDetailsCase.JOBDETAILS_NOT_SET, job.getJobDetailsCase());
    assertEquals(JobGroup.JobGroupDetailsCase.JOBGROUPDETAILS_NOT_SET, jobGroup.getJobGroupDetailsCase());
    assertEquals(JobGroupType.JOB_GROUP_TYPE_NOT_SET, jobGroup.getJobGroupType());
    assertEquals(JobStatusCode.JOB_STATUS_CODE_NOT_SET, result.getStatusCode());
    assertEquals(JobType.JOB_TYPE_NOT_SET, job.getJobType());
    assertEquals(ModelType.STANDARD_MODEL, model.getModelType());
    assertEquals(ObjectDefinition.DefinitionCase.DEFINITION_NOT_SET, objectDefinition.getDefinitionCase());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, objectDefinition.getObjectType());
    assertEquals(ObjectType.OBJECT_TYPE_NOT_SET, schemaId.getObjectType());
    assertEquals(PartType.PART_ROOT, schema.getPartType());
    assertEquals(SchemaDefinition.SchemaDetailsCase.SCHEMADETAILS_NOT_SET, schema.getSchemaDetailsCase());
    assertEquals(SchemaType.SCHEMA_TYPE_NOT_SET, schema.getSchemaType());
    assertEquals(TagSelector.ObjectCriteriaCase.OBJECTCRITERIA_NOT_SET, schemaId.getObjectCriteriaCase());
    assertEquals(TagSelector.TagCriteriaCase.TAGCRITERIA_NOT_SET, schemaId.getTagCriteriaCase());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(toProtoResult2.hasOptions());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(options.getDeprecated());
    assertFalse(options.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options.getMapEntry());
    assertFalse(options.getMessageSetWireFormat());
    assertFalse(options.getNoStandardDescriptorAccessor());
    assertFalse(options.hasDeprecated());
    assertFalse(options.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options.hasFeatures());
    assertFalse(options.hasMapEntry());
    assertFalse(options.hasMessageSetWireFormat());
    assertFalse(options.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType11.isExtendable());
    assertFalse(descriptorForType2.isExtendable());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType4.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType6.isExtendable());
    assertFalse(descriptorForType7.isExtendable());
    assertFalse(descriptorForType8.isExtendable());
    assertFalse(descriptorForType9.isExtendable());
    assertFalse(descriptorForType10.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(customData.iterator().hasNext());
    assertFalse(data.hasSchema());
    assertFalse(data.hasSchemaId());
    assertFalse(data.hasStorageId());
    assertFalse(exportData.hasModel());
    assertFalse(file.hasStorageId());
    assertFalse(importData.hasModel());
    assertFalse(importModel.hasPackageGroup());
    assertFalse(job.hasExportData());
    assertFalse(job.hasImportData());
    assertFalse(job.hasImportModel());
    assertFalse(job.hasJobGroup());
    assertFalse(job.hasResultId());
    assertFalse(job.hasRunFlow());
    assertFalse(job.hasRunModel());
    assertFalse(jobGroup.hasParallel());
    assertFalse(jobGroup.hasSequential());
    assertFalse(model.hasPackageGroup());
    assertFalse(model.hasPath());
    assertFalse(objectDefinition.hasCustom());
    assertFalse(objectDefinition.hasData());
    assertFalse(objectDefinition.hasFile());
    assertFalse(objectDefinition.hasFlow());
    assertFalse(objectDefinition.hasJob());
    assertFalse(objectDefinition.hasModel());
    assertFalse(objectDefinition.hasResult());
    assertFalse(objectDefinition.hasSchema());
    assertFalse(objectDefinition.hasStorage());
    assertFalse(result.hasJobId());
    assertFalse(result.hasLogFileId());
    assertFalse(runFlow.hasFlow());
    assertFalse(runModel.hasModel());
    assertFalse(schema.hasStruct());
    assertFalse(schema.hasTable());
    assertFalse(schemaId.getLatestObject());
    assertFalse(schemaId.getLatestTag());
    assertFalse(schemaId.hasLatestObject());
    assertFalse(schemaId.hasLatestTag());
    assertFalse(schemaId.hasObjectAsOf());
    assertFalse(schemaId.hasObjectVersion());
    assertFalse(schemaId.hasTagAsOf());
    assertFalse(schemaId.hasTagVersion());
    assertTrue(customData.isEmpty());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(getResult.isOptional());
    assertTrue(unknownFields.isEmpty());
    assertTrue(unknownFields.isInitialized());
    assertTrue(schemaId.findInitializationErrors().isEmpty());
    assertTrue(custom.findInitializationErrors().isEmpty());
    assertTrue(data.findInitializationErrors().isEmpty());
    assertTrue(file.findInitializationErrors().isEmpty());
    assertTrue(flow.findInitializationErrors().isEmpty());
    assertTrue(job.findInitializationErrors().isEmpty());
    assertTrue(model.findInitializationErrors().isEmpty());
    assertTrue(result.findInitializationErrors().isEmpty());
    assertTrue(schema.findInitializationErrors().isEmpty());
    assertTrue(storage.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = objectDefinition.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    List<FlowEdge> edgesList = flow.getEdgesList();
    assertTrue(edgesList.isEmpty());
    assertTrue(schemaId.getAllFields().isEmpty());
    assertTrue(custom.getAllFields().isEmpty());
    assertTrue(data.getAllFields().isEmpty());
    assertTrue(file.getAllFields().isEmpty());
    assertTrue(flow.getAllFields().isEmpty());
    assertTrue(job.getAllFields().isEmpty());
    assertTrue(model.getAllFields().isEmpty());
    assertTrue(result.getAllFields().isEmpty());
    assertTrue(schema.getAllFields().isEmpty());
    assertTrue(storage.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = objectDefinition.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(data.getParts().isEmpty());
    assertTrue(data.getPartsMap().isEmpty());
    assertTrue(flow.getInputs().isEmpty());
    assertTrue(flow.getInputsMap().isEmpty());
    assertTrue(flow.getNodes().isEmpty());
    assertTrue(flow.getNodesMap().isEmpty());
    assertTrue(flow.getOutputs().isEmpty());
    assertTrue(flow.getOutputsMap().isEmpty());
    assertTrue(flow.getParameters().isEmpty());
    assertTrue(flow.getParametersMap().isEmpty());
    assertTrue(model.getInputs().isEmpty());
    assertTrue(model.getInputsMap().isEmpty());
    assertTrue(model.getOutputs().isEmpty());
    assertTrue(model.getOutputsMap().isEmpty());
    assertTrue(model.getParameters().isEmpty());
    assertTrue(model.getParametersMap().isEmpty());
    assertTrue(model.getStaticAttributes().isEmpty());
    assertTrue(model.getStaticAttributesMap().isEmpty());
    assertTrue(objectDefinition.getObjectProps().isEmpty());
    assertTrue(objectDefinition.getObjectPropsMap().isEmpty());
    assertTrue(storage.getDataItems().isEmpty());
    assertTrue(storage.getDataItemsMap().isEmpty());
    assertTrue(storage.getStorageOptions().isEmpty());
    assertTrue(storage.getStorageOptionsMap().isEmpty());
    assertTrue(custom.isInitialized());
    assertTrue(data.isInitialized());
    assertTrue(objectAsOf.isInitialized());
    assertTrue(exportData.isInitialized());
    assertTrue(file.isInitialized());
    assertTrue(flow.isInitialized());
    assertTrue(importData.isInitialized());
    assertTrue(importModel.isInitialized());
    assertTrue(job.isInitialized());
    assertTrue(jobGroup.isInitialized());
    assertTrue(model.isInitialized());
    assertTrue(objectDefinition.isInitialized());
    assertTrue(result.isInitialized());
    assertTrue(runFlow.isInitialized());
    assertTrue(runModel.isInitialized());
    assertTrue(schema.isInitialized());
    assertTrue(storage.isInitialized());
    assertTrue(struct.isInitialized());
    assertTrue(table.isInitialized());
    assertTrue(schemaId.isInitialized());
    assertTrue(actualReadDefinitionByLatestResult.isLatest);
    assertEquals(findInitializationErrorsResult, options.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, exportData.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, importData.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, importModel.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, jobGroup.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, runFlow.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, runModel.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, struct.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, table.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, objectAsOf.findInitializationErrors());
    ProtocolStringList reservedNameList = toProtoResult3.getReservedNameList();
    assertEquals(findInitializationErrorsResult, reservedNameList);
    assertEquals(findInitializationErrorsResult, descriptorForType11.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType9.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType10.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType11.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType9.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType10.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType11.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType9.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType10.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType10.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getEnumTypes());
    assertEquals(findInitializationErrorsResult, file4.getEnumTypes());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file3.getExtensions());
    assertEquals(findInitializationErrorsResult, file4.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file3.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file4.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(findInitializationErrorsResult, file3.getServices());
    assertEquals(findInitializationErrorsResult, file4.getServices());
    assertEquals(allFields, exportData.getAllFields());
    assertEquals(allFields, importData.getAllFields());
    assertEquals(allFields, importModel.getAllFields());
    assertEquals(allFields, jobGroup.getAllFields());
    assertEquals(allFields, runFlow.getAllFields());
    assertEquals(allFields, runModel.getAllFields());
    assertEquals(allFields, struct.getAllFields());
    assertEquals(allFields, table.getAllFields());
    assertEquals(allFields, objectAsOf.getAllFields());
    assertEquals(allFields, options.getAllFields());
    assertEquals(allFields, options.getAllFieldsRaw());
    assertEquals(allFields, exportData.getExports());
    assertEquals(allFields, exportData.getExportsMap());
    assertEquals(allFields, exportData.getInputs());
    assertEquals(allFields, exportData.getInputsMap());
    assertEquals(allFields, exportData.getOutputs());
    assertEquals(allFields, exportData.getOutputsMap());
    assertEquals(allFields, exportData.getParameters());
    assertEquals(allFields, exportData.getParametersMap());
    assertEquals(allFields, exportData.getPriorOutputs());
    assertEquals(allFields, exportData.getPriorOutputsMap());
    assertEquals(allFields, importData.getImports());
    assertEquals(allFields, importData.getImportsMap());
    assertEquals(allFields, importData.getInputs());
    assertEquals(allFields, importData.getInputsMap());
    assertEquals(allFields, importData.getOutputs());
    assertEquals(allFields, importData.getOutputsMap());
    assertEquals(allFields, importData.getParameters());
    assertEquals(allFields, importData.getParametersMap());
    assertEquals(allFields, importData.getPriorOutputs());
    assertEquals(allFields, importData.getPriorOutputsMap());
    assertEquals(allFields, runFlow.getInputs());
    assertEquals(allFields, runFlow.getInputsMap());
    assertEquals(allFields, runFlow.getModels());
    assertEquals(allFields, runFlow.getModelsMap());
    assertEquals(allFields, runFlow.getOutputs());
    assertEquals(allFields, runFlow.getOutputsMap());
    assertEquals(allFields, runFlow.getParameters());
    assertEquals(allFields, runFlow.getParametersMap());
    assertEquals(allFields, runFlow.getPriorOutputs());
    assertEquals(allFields, runFlow.getPriorOutputsMap());
    assertEquals(allFields, runModel.getInputs());
    assertEquals(allFields, runModel.getInputsMap());
    assertEquals(allFields, runModel.getOutputs());
    assertEquals(allFields, runModel.getOutputsMap());
    assertEquals(allFields, runModel.getParameters());
    assertEquals(allFields, runModel.getParametersMap());
    assertEquals(allFields, runModel.getPriorOutputs());
    assertEquals(allFields, runModel.getPriorOutputsMap());
    assertEquals(allFields, struct.getFields());
    assertEquals(allFields, struct.getFieldsMap());
    assertEquals(allFields, struct.getNamedTypes());
    assertEquals(allFields, struct.getNamedTypesMap());
    assertEquals(customData, custom.getCustomSchemaTypeBytes());
    assertEquals(customData, objectAsOf.getIsoDatetimeBytes());
    assertEquals(customData, file.getDataItemBytes());
    assertEquals(customData, file.getExtensionBytes());
    assertEquals(customData, file.getMimeTypeBytes());
    assertEquals(customData, file.getNameBytes());
    assertEquals(customData, importModel.getEntryPointBytes());
    assertEquals(customData, importModel.getLanguageBytes());
    assertEquals(customData, importModel.getPackageBytes());
    assertEquals(customData, importModel.getPackageGroupBytes());
    assertEquals(customData, importModel.getPathBytes());
    assertEquals(customData, importModel.getRepositoryBytes());
    assertEquals(customData, importModel.getVersionBytes());
    assertEquals(customData, model.getEntryPointBytes());
    assertEquals(customData, model.getLanguageBytes());
    assertEquals(customData, model.getPackageBytes());
    assertEquals(customData, model.getPackageGroupBytes());
    assertEquals(customData, model.getPathBytes());
    assertEquals(customData, model.getRepositoryBytes());
    assertEquals(customData, model.getVersionBytes());
    assertEquals(customData, result.getStatusMessageBytes());
    assertEquals(customData, schemaId.getObjectIdBytes());
    ObjectDefinition expectedDefaultInstanceForType = actualReadDefinitionByLatestResult.item;
    assertEquals(expectedDefaultInstanceForType, objectDefinition.getDefaultInstanceForType());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    assertSame(reservedNameList, toProtoResult2.getReservedNameList());
    assertSame(reservedNameList, exportData.getStorageAccessList());
    assertSame(reservedNameList, importData.getStorageAccessList());
    assertSame(file3, descriptorForType9.getFile());
    assertSame(file4, getResult.getFile());
    assertSame(options, toProtoResult.getOptions());
    assertSame(options, toProtoResult2.getOptions());
    assertSame(options, toProtoResult3.getOptions());
    assertSame(options, toProtoResult.getOptionsOrBuilder());
    assertSame(options, toProtoResult2.getOptionsOrBuilder());
    assertSame(options, toProtoResult3.getOptionsOrBuilder());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options, descriptorForType11.getOptions());
    assertSame(options, descriptorForType2.getOptions());
    assertSame(options, descriptorForType3.getOptions());
    assertSame(options, descriptorForType4.getOptions());
    assertSame(options, descriptorForType5.getOptions());
    assertSame(options, descriptorForType6.getOptions());
    assertSame(options, descriptorForType7.getOptions());
    assertSame(options, descriptorForType8.getOptions());
    assertSame(options, descriptorForType9.getOptions());
    assertSame(options, descriptorForType10.getOptions());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, schemaId.getUnknownFields());
    assertSame(unknownFields, exportData.getUnknownFields());
    assertSame(unknownFields, importData.getUnknownFields());
    assertSame(unknownFields, importModel.getUnknownFields());
    assertSame(unknownFields, jobGroup.getUnknownFields());
    assertSame(unknownFields, runFlow.getUnknownFields());
    assertSame(unknownFields, runModel.getUnknownFields());
    assertSame(unknownFields, custom.getUnknownFields());
    assertSame(unknownFields, data.getUnknownFields());
    assertSame(unknownFields, file.getUnknownFields());
    assertSame(unknownFields, flow.getUnknownFields());
    assertSame(unknownFields, job.getUnknownFields());
    assertSame(unknownFields, model.getUnknownFields());
    assertSame(unknownFields, result.getUnknownFields());
    assertSame(unknownFields, schema.getUnknownFields());
    assertSame(unknownFields, storage.getUnknownFields());
    assertSame(unknownFields, struct.getUnknownFields());
    assertSame(unknownFields, table.getUnknownFields());
    assertSame(unknownFields, objectAsOf.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(oneofs.get(0), realOneofs.get(0));
    assertSame(oneofs2.get(0), realOneofs2.get(0));
    assertSame(schemaId, data.getSchemaIdOrBuilder());
    assertSame(schemaId, data.getStorageId());
    assertSame(schemaId, data.getStorageIdOrBuilder());
    assertSame(schemaId, exportData.getModel());
    assertSame(schemaId, exportData.getModelOrBuilder());
    assertSame(schemaId, file.getStorageId());
    assertSame(schemaId, file.getStorageIdOrBuilder());
    assertSame(schemaId, importData.getModel());
    assertSame(schemaId, importData.getModelOrBuilder());
    assertSame(schemaId, job.getResultId());
    assertSame(schemaId, job.getResultIdOrBuilder());
    assertSame(schemaId, result.getJobId());
    assertSame(schemaId, result.getJobIdOrBuilder());
    assertSame(schemaId, result.getLogFileId());
    assertSame(schemaId, result.getLogFileIdOrBuilder());
    assertSame(schemaId, runFlow.getFlow());
    assertSame(schemaId, runFlow.getFlowOrBuilder());
    assertSame(schemaId, runModel.getModel());
    assertSame(schemaId, runModel.getModelOrBuilder());
    assertSame(schemaId, schemaId.getDefaultInstanceForType());
    assertSame(edgesList, toProtoResult.getEnumTypeList());
    assertSame(edgesList, toProtoResult2.getEnumTypeList());
    assertSame(edgesList, toProtoResult3.getEnumTypeList());
    assertSame(edgesList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(edgesList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(edgesList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(edgesList, toProtoResult.getExtensionList());
    assertSame(edgesList, toProtoResult2.getExtensionList());
    assertSame(edgesList, toProtoResult3.getExtensionList());
    assertSame(edgesList, toProtoResult.getExtensionOrBuilderList());
    assertSame(edgesList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(edgesList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(edgesList, toProtoResult.getExtensionRangeList());
    assertSame(edgesList, toProtoResult2.getExtensionRangeList());
    assertSame(edgesList, toProtoResult3.getExtensionRangeList());
    assertSame(edgesList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(edgesList, toProtoResult2.getExtensionRangeOrBuilderList());
    assertSame(edgesList, toProtoResult3.getExtensionRangeOrBuilderList());
    assertSame(edgesList, toProtoResult.getNestedTypeList());
    assertSame(edgesList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(edgesList, toProtoResult.getOneofDeclList());
    assertSame(edgesList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(edgesList, toProtoResult.getReservedRangeList());
    assertSame(edgesList, toProtoResult2.getReservedRangeList());
    assertSame(edgesList, toProtoResult3.getReservedRangeList());
    assertSame(edgesList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(edgesList, toProtoResult2.getReservedRangeOrBuilderList());
    assertSame(edgesList, toProtoResult3.getReservedRangeOrBuilderList());
    assertSame(edgesList, options.getUninterpretedOptionList());
    assertSame(edgesList, options.getUninterpretedOptionOrBuilderList());
    assertSame(edgesList, exportData.getOutputAttrsList());
    assertSame(edgesList, exportData.getOutputAttrsOrBuilderList());
    assertSame(edgesList, flow.getEdgesOrBuilderList());
    assertSame(edgesList, importData.getImportAttrsList());
    assertSame(edgesList, importData.getImportAttrsOrBuilderList());
    assertSame(edgesList, importData.getOutputAttrsList());
    assertSame(edgesList, importData.getOutputAttrsOrBuilderList());
    assertSame(edgesList, importModel.getModelAttrsList());
    assertSame(edgesList, importModel.getModelAttrsOrBuilderList());
    assertSame(edgesList, runFlow.getOutputAttrsList());
    assertSame(edgesList, runFlow.getOutputAttrsOrBuilderList());
    assertSame(edgesList, runModel.getOutputAttrsList());
    assertSame(edgesList, runModel.getOutputAttrsOrBuilderList());
    assertSame(edgesList, table.getFieldsList());
    assertSame(edgesList, table.getFieldsOrBuilderList());
    assertSame(exportData, exportData.getDefaultInstanceForType());
    assertSame(exportData, job.getExportDataOrBuilder());
    assertSame(importData, importData.getDefaultInstanceForType());
    assertSame(importData, job.getImportDataOrBuilder());
    assertSame(importModel, importModel.getDefaultInstanceForType());
    assertSame(importModel, job.getImportModelOrBuilder());
    assertSame(jobGroup, job.getJobGroupOrBuilder());
    assertSame(jobGroup, jobGroup.getDefaultInstanceForType());
    assertSame(runFlow, job.getRunFlowOrBuilder());
    assertSame(runFlow, runFlow.getDefaultInstanceForType());
    assertSame(runModel, job.getRunModelOrBuilder());
    assertSame(runModel, runModel.getDefaultInstanceForType());
    assertSame(custom, custom.getDefaultInstanceForType());
    assertSame(custom, objectDefinition.getCustomOrBuilder());
    assertSame(data, data.getDefaultInstanceForType());
    assertSame(data, objectDefinition.getDataOrBuilder());
    assertSame(file, file.getDefaultInstanceForType());
    assertSame(file, objectDefinition.getFileOrBuilder());
    assertSame(flow, flow.getDefaultInstanceForType());
    assertSame(flow, objectDefinition.getFlowOrBuilder());
    assertSame(job, job.getDefaultInstanceForType());
    assertSame(job, objectDefinition.getJobOrBuilder());
    assertSame(model, model.getDefaultInstanceForType());
    assertSame(model, objectDefinition.getModelOrBuilder());
    assertSame(result, objectDefinition.getResultOrBuilder());
    assertSame(result, result.getDefaultInstanceForType());
    assertSame(schema, data.getSchema());
    assertSame(schema, data.getSchemaOrBuilder());
    assertSame(schema, objectDefinition.getSchemaOrBuilder());
    assertSame(schema, schema.getDefaultInstanceForType());
    assertSame(storage, objectDefinition.getStorageOrBuilder());
    assertSame(storage, storage.getDefaultInstanceForType());
    assertSame(struct, schema.getStructOrBuilder());
    assertSame(struct, struct.getDefaultInstanceForType());
    assertSame(table, schema.getTableOrBuilder());
    assertSame(table, table.getDefaultInstanceForType());
    assertSame(objectAsOf, objectAsOf.getDefaultInstanceForType());
    assertSame(objectAsOf, schemaId.getObjectAsOfOrBuilder());
    assertSame(objectAsOf, schemaId.getTagAsOf());
    assertSame(objectAsOf, schemaId.getTagAsOfOrBuilder());
  }

  /**
   * Method under test:
   * {@link JdbcReadImpl#readDefinitionByLatest(Connection, short, long)}
   */
  @Test
  void testReadDefinitionByLatest11() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readTagRecord(Connection, short, long, TagSelector)}
   */
  @Test
  void testReadTagRecord() throws SQLException {
    // Arrange
    JdbcReadImpl jdbcReadImpl = new JdbcReadImpl();
    Connection conn = mock(Connection.class);

    // Act and Assert
    assertThrows(EValidationGap.class,
        () -> jdbcReadImpl.readTagRecord(conn, (short) 1, 1L, TagSelector.getDefaultInstance()));
  }

  /**
   * Method under test:
   * {@link JdbcReadImpl#readTagRecordByVersion(Connection, short, long, int)}
   */
  @Test
  void testReadTagRecordByVersion() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readTagRecordByVersion(Connection, short, long, int)}
   */
  @Test
  void testReadTagRecordByVersion2() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readTagRecordByVersion(Connection, short, long, int)}
   */
  @Test
  void testReadTagRecordByVersion3() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readTagRecordByVersion(Connection, short, long, int)}
   */
  @Test
  void testReadTagRecordByVersion4() throws SQLException {
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
    JdbcBaseDal.KeyedItem<Void> actualReadTagRecordByVersionResult = jdbcReadImpl.readTagRecordByVersion(conn,
        (short) 1, 1L, 1);

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
   * Method under test:
   * {@link JdbcReadImpl#readTagRecordByAsOf(Connection, short, long, Instant)}
   */
  @Test
  void testReadTagRecordByAsOf() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readTagRecordByAsOf(Connection, short, long, Instant)}
   */
  @Test
  void testReadTagRecordByAsOf2() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readTagRecordByAsOf(Connection, short, long, Instant)}
   */
  @Test
  void testReadTagRecordByAsOf3() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readTagRecordByAsOf(Connection, short, long, Instant)}
   */
  @Test
  void testReadTagRecordByAsOf4() throws SQLException {
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
    JdbcBaseDal.KeyedItem<Void> actualReadTagRecordByAsOfResult = jdbcReadImpl.readTagRecordByAsOf(conn, (short) 1, 1L,
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
   * Method under test:
   * {@link JdbcReadImpl#readTagRecordByLatest(Connection, short, long)}
   */
  @Test
  void testReadTagRecordByLatest() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readTagRecordByLatest(Connection, short, long)}
   */
  @Test
  void testReadTagRecordByLatest2() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readTagRecordByLatest(Connection, short, long)}
   */
  @Test
  void testReadTagRecordByLatest3() throws SQLException {
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
   * Method under test:
   * {@link JdbcReadImpl#readTagRecordByLatest(Connection, short, long)}
   */
  @Test
  void testReadTagRecordByLatest4() throws SQLException {
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
    JdbcBaseDal.KeyedItem<Void> actualReadTagRecordByLatestResult = jdbcReadImpl.readTagRecordByLatest(conn, (short) 1,
        1L);

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
   * Method under test: {@link JdbcReadImpl#readTagAttrs(Connection, short, long)}
   */
  @Test
  void testReadTagAttrs() throws SQLException {
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
   * Method under test: {@link JdbcReadImpl#readTagAttrs(Connection, short, long)}
   */
  @Test
  void testReadTagAttrs2() throws SQLException {
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
