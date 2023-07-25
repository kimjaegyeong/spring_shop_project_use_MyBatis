package spring.project.shop.enums;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(DeliveryState.class)
public class DeliveryStateHandler implements TypeHandler<DeliveryState> {

    @Override
    public void setParameter(PreparedStatement ps, int i, DeliveryState parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i,parameter.getCode());
    }

    @Override
    public DeliveryState getResult(ResultSet rs, String columnName) throws SQLException {
        String code= rs.getString(columnName);
        return getCodeEnum(code);
    }

    @Override
    public DeliveryState getResult(ResultSet rs, int columnIndex) throws SQLException {
        String code= rs.getString(columnIndex);
        return getCodeEnum(code);
    }

    @Override
    public DeliveryState getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String code = cs.getString(columnIndex);
        return getCodeEnum(code);
    }

    private DeliveryState getCodeEnum(String code){
        switch(code){
            case "OK" : return DeliveryState.OK;
            case "CANCEL" : return DeliveryState.CANCEL;
        }
        return null;
    }
}