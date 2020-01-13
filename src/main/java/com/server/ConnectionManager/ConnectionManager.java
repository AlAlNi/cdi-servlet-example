package com.server.ConnectionManager;

import java.sql.Connection;

public interface ConnectionManager {
    Connection getConnection();
}