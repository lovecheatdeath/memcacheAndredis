//package com.jnshu.utils;
//
//
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//import com.zaxxer.hikari.HikariDataSource;
//
//public class DataSource extends HikariDataSource{
//    @Override
//    public synchronized void close() {
//        try {
//            DriverManager.deregisterDriver(DriverManager.getDriver(getJdbcUrl()));
//            super.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
