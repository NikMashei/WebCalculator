package dev.mashei.webcalculator.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.OffsetDateTime;

@Repository
@RequiredArgsConstructor
public class AuditDao {

    private final DataSource dataSource;

    public void audit(String operation) throws SQLException {
        var connection = dataSource.getConnection();
        var preparedStatement = connection.prepareStatement("insert into math_audit (operation, performed_at) values (?, ?)");
        preparedStatement.setString(1, operation);
        preparedStatement.setTimestamp(2, Timestamp.from(Instant.now()));
    }
}
