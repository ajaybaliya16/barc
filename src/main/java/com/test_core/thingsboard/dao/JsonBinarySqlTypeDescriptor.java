//package thingsboard.dao;
//
//
//
//import com.fasterxml.jackson.databind.JsonNode;
//import org.hibernate.type.descriptor.ValueBinder;
//import org.hibernate.type.descriptor.WrapperOptions;
//
//
//import java.sql.CallableStatement;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.sql.Types;
//
//public class JsonBinarySqlTypeDescriptor extends AbstractJsonSqlTypeDescriptor {
//
//    public static final JsonBinarySqlTypeDescriptor INSTANCE = new JsonBinarySqlTypeDescriptor();
//
//    @Override
//    public int getSqlType() {
//        return Types.OTHER;
//    }
//
//    @Override
//    public <X> ValueBinder<X> getBinder(final JavaTypeDescriptor<X> javaTypeDescriptor) {
//        return new BasicBinder<X>(javaTypeDescriptor, this) {
//            @Override
//            protected void doBind(PreparedStatement st, X value, int index, WrapperOptions options) throws SQLException {
//                st.setObject(index, javaTypeDescriptor.unwrap(value, JsonNode.class, options), getSqlType());
//            }
//
//            @Override
//            protected void doBind(CallableStatement st, X value, String name, WrapperOptions options) throws SQLException {
//                st.setObject(name, javaTypeDescriptor.unwrap(value, JsonNode.class, options), getSqlType());
//            }
//        };
//    }
//}
//package com;


