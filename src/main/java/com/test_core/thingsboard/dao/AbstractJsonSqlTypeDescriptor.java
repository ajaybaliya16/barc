//package thingsboard.dao;
//
//
//
//import java.sql.CallableStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Types;
//
//import org.hibernate.boot.model.JavaTypeDescriptor;
//import org.hibernate.type.descriptor.ValueExtractor;
//import org.hibernate.type.descriptor.WrapperOptions;
//import org.hibernate.type.descriptor.jdbc.BasicExtractor;
//import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;
//
//public abstract class AbstractJsonSqlTypeDescriptor
//        implements SqlTypeDescriptor {
//
//    @Override
//    public int getSqlType() {
//        return Types.VARCHAR;
//    }
//
//    @Override
//    public boolean canBeRemapped() {
//        return true;
//    }
//
//    @Override
//    public <X> ValueExtractor<X> getExtractor(
//            final JavaTypeDescriptor<X> javaTypeDescriptor) {
//        return new BasicExtractor<X>(javaTypeDescriptor, this) {
//            @Override
//            protected X doExtract(
//                    ResultSet rs,
//                    String name,
//                    WrapperOptions options) throws SQLException {
//                return javaTypeDescriptor.wrap(
//                        rs.getObject(name), options
//                );
//            }
//
//            @Override
//            protected X doExtract(
//                    CallableStatement statement,
//                    int index,
//                    WrapperOptions options) throws SQLException {
//                return javaTypeDescriptor.wrap(
//                        statement.getObject(index), options
//                );
//            }
//
//            @Override
//            protected X doExtract(
//                    CallableStatement statement,
//                    String name,
//                    WrapperOptions options) throws SQLException {
//                return javaTypeDescriptor.wrap(
//                        statement.getObject(name), options
//                );
//            }
//        };
//    }
//
//}
//package com;

