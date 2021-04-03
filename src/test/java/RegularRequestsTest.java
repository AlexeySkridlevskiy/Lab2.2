import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class RegularRequestsTest {

    private static final Flyway flyway = new Flyway();
    private static RegularRequests regularRequests;

    static {
        try {
            regularRequests = new RegularRequests();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @BeforeAll
    static void init()
    {
        try {
            String url = "jdbc:mysql://localhost/matriculant";
            String username = "root";
            String password = "##@skrid2002@##";
            flyway.setDataSource(url, username, password);
            flyway.repair();
            flyway.migrate();
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }

    @Test
    void getbyPassingScore() throws SQLException {
        var result = regularRequests.getbyPassingScore();
        assertEquals(result.size(), 1);
    }

    @Test
    void getWhereEnterMatriculant() throws SQLException {
        var result = regularRequests.getWhereEnterMatriculant();
        assertEquals(result.size(), 2);
    }

    @Test
    void countMatriculantByScore() throws SQLException {
        var result = regularRequests.countMatriculantByScore();
        assertEquals(result, 1);
    }

    @Test
    void sumMatriculantMarks() throws SQLException {
        var result = regularRequests.sumMatriculantMarks();
        assertEquals(result, result.longValue());
    }

    @Test
    void MinMaxMarks() throws SQLException {
        var result = regularRequests.MinMaxMarks();
        assertEquals(result[0], result[0].longValue());
        assertEquals(result[1], result[1].longValue());
    }

    @Test
    void getNameWhenEnter() throws SQLException {
        var result = regularRequests.getNameWhenEnter();
        assertEquals(result.size(), 1);
    }

    @AfterAll
    static void clean() throws SQLException {
        regularRequests.close();
        flyway.clean();
    }
}