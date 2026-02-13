package com.app.candm.mybatis.handler;

import com.app.candm.common.enumeration.MessageStatus;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(MessageStatus.class)
public class MessageStatusHandler implements TypeHandler<MessageStatus> {

    @Override
    public void setParameter(PreparedStatement ps, int i, MessageStatus parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getValue());
    }

    @Override
    public MessageStatus getResult(ResultSet rs, String columnName) throws SQLException {
        switch (rs.getString(columnName)) {
            case "read":
                return MessageStatus.READ;
            case "unread":
                return MessageStatus.UNREAD;
        }
        return null;
    }

    @Override
    public MessageStatus getResult(ResultSet rs, int columnIndex) throws SQLException {
        switch (rs.getString(columnIndex)) {
            case "read":
                return MessageStatus.READ;
            case "unread":
                return MessageStatus.UNREAD;
        }
        return null;
    }

    @Override
    public MessageStatus getResult(CallableStatement cs, int columnIndex) throws SQLException {
        switch (cs.getString(columnIndex)) {
            case "read":
                return MessageStatus.READ;
            case "unread":
                return MessageStatus.UNREAD;
        }
        return null;
    }
}
