import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ORMRequestsTest {

    private static final Flyway flyway = new Flyway();
    private static ORMRequests ormRequests;
    
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
            ormRequests = new ORMRequests();
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }

    @Test
    void getbyPassingScore() {
        var result = ormRequests.getbyPassingScore();
        assertEquals(result.size(), 1);
    }

    @Test
    void countMatriculantByScore()
    {
        var result = ormRequests.countMatriculantByScore();
        assertEquals(result, 1);
    }

    @Test
    void sumMatriculantMarks()
    {
        var result = ormRequests.sumMatriculantMarks();
        assertEquals(result, result.longValue());
    }

    @Test
    void MinMaxMarks()
    {
        var result = ormRequests.MinMaxMarks();
        assertEquals(result[0], result[0].longValue());
        assertEquals(result[1], result[1].longValue());
    }

    @Test
    void getNameWhenEnter()
    {
        var result = ormRequests.getNameWhenEnter();
        assertEquals(result.size(), 1);
    }

    @Test
    void getWhereEnterAbiturient()
    {
        var result = ormRequests.getWhereEnterMatriculant();
        assertEquals(result.size(), 2);
    }

    @AfterAll
    static void clean() {
        flyway.clean();
    }
}