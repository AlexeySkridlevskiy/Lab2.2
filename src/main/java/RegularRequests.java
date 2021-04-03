import org.intellij.lang.annotations.Language;
import org.javatuples.Pair;
import java.sql.*;

import models.sql.MatriculantData;
import models.sql.UniversityData;

import java.util.List;
import java.util.ArrayList;

public class RegularRequests implements AutoCloseable{

    private Connection connection;

    public RegularRequests() throws SQLException {
        String url = "jdbc:mysql://localhost/matriculant";
        String username = "root";
        String password = "##@skrid2002@##";
        connection = DriverManager.getConnection(url, username, password);
    }

    private ResultSet select(@Language("SQL") String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public List<MatriculantData> getbyPassingScore() throws SQLException {
        ResultSet resultSet = select("""
            select * from MatriculantData where PassingScore > 225;""");
        List<MatriculantData> result = new ArrayList<>();
        while (resultSet.next()) {
            MatriculantData matriculantData = new MatriculantData();

            matriculantData.setId(resultSet.getLong("ID"));
            matriculantData.setSurname(resultSet.getString("Surname"));
            matriculantData.setName(resultSet.getString("Name"));
            matriculantData.setSurname(resultSet.getString("Patronymic"));
            matriculantData.setGender(resultSet.getString("Gender"));
            matriculantData.setNationality(resultSet.getString("Nationality"));
            matriculantData.setBirthday(resultSet.getString("Birthday"));
            matriculantData.setPostcode(resultSet.getLong("Postcode"));
            matriculantData.setCountry(resultSet.getString("Country"));
            matriculantData.setRegion(resultSet.getString("Region"));
            matriculantData.setArea(resultSet.getString("Area"));
            matriculantData.setCity(resultSet.getString("City"));
            matriculantData.setStreet(resultSet.getString("Street"));
            matriculantData.setHouse(resultSet.getString("House"));
            matriculantData.setApartment(resultSet.getString("Apartment"));
            matriculantData.setMarks(resultSet.getLong("Marks"));
            matriculantData.setPassingScore(resultSet.getLong("PassingScore"));
            matriculantData.setUniversityId(resultSet.getInt("UniversityId"));
            result.add(matriculantData);
        }
        return result;
    }

    public List<Pair<MatriculantData, UniversityData>> getWhereEnterMatriculant() throws SQLException {
        ResultSet resultSet = select( """
            select MatriculantData.ID,MatriculantData.Surname,MatriculantData.Name,MatriculantData.Patronymic,MatriculantData.Birthday,UniversityData.Name
            from MatriculantData inner join UniversityData
                                       on MatriculantData.UniversityID = UniversityData.ID;""");
        List<Pair<MatriculantData, UniversityData>> result = new ArrayList<>();
        while (resultSet.next()) {
            MatriculantData matriculantData = new MatriculantData();
            matriculantData.setId(resultSet.getLong("ID"));
            matriculantData.setSurname(resultSet.getString("Surname"));
            matriculantData.setName(resultSet.getString("Name"));
            matriculantData.setSurname(resultSet.getString("Patronymic"));
            matriculantData.setBirthday(resultSet.getString("Birthday"));

            UniversityData universityData = new UniversityData();
            universityData.setName(resultSet.getString("Name"));
            result.add(new Pair<>(matriculantData, universityData));
        }
        return result;
    }

    public Long countMatriculantByScore() throws SQLException {
        ResultSet rs = select( """
            select count(*)
                from MatriculantData
                where PassingScore > 250;""");
        Long result = null;
        if (rs.next()) {
            result = rs.getLong(1);
        }
        return result;
    }

    public Long sumMatriculantMarks() throws SQLException {
        ResultSet rs = select( """
            select sum(Marks)
                from MatriculantData
                where Gender = 'мужской';""");
        Long result = null;
        if (rs.next()) {
            result = rs.getLong(1);
        }
        return result;
    }

    public Long[] MinMaxMarks() throws SQLException {
        ResultSet rs = select( """
            select min(Marks) as "min Mark", max(Marks) as "max Mark"
                from MatriculantData;""");
        Long[] result = new Long[2];
        if (rs.next()) {
            result[0] = rs.getLong(1);
            result[1] = rs.getLong(2);
        }
        return result;
    }

    public List<Pair<MatriculantData, UniversityData>> getNameWhenEnter() throws SQLException {
        ResultSet resultSet = select("""
            SELECT *, UniversityData.Name
            FROM MatriculantData INNER JOIN UniversityData
                                       ON MatriculantData.UniversityID = UniversityData.ID where MatriculantData.UniversityID = 3;""");
        List<Pair<MatriculantData, UniversityData>> result = new ArrayList<>();
        while (resultSet.next()) {
            MatriculantData matriculantData = new MatriculantData();
            matriculantData.setId(resultSet.getLong("id"));
            matriculantData.setSurname(resultSet.getString("Surname"));
            matriculantData.setName(resultSet.getString("Name"));
            matriculantData.setPatronymic(resultSet.getString("Patronymic"));
            matriculantData.setBirthday(resultSet.getString("birthday"));
            matriculantData.setGender(resultSet.getString("gender"));
            matriculantData.setNationality(resultSet.getString("nationality"));
            matriculantData.setPostcode(resultSet.getLong("postcode"));
            matriculantData.setCountry(resultSet.getString("country"));
            matriculantData.setRegion(resultSet.getString("region"));
            matriculantData.setArea(resultSet.getString("area"));
            matriculantData.setCity(resultSet.getString("city"));
            matriculantData.setStreet(resultSet.getString("street"));
            matriculantData.setHouse(resultSet.getString("house"));
            matriculantData.setApartment(resultSet.getString("apartment"));
            matriculantData.setMarks(resultSet.getLong("marks"));
            matriculantData.setPassingScore(resultSet.getLong("passingScore"));

            UniversityData universityData = new UniversityData();
            universityData.setId(resultSet.getLong("id"));
            universityData.setName(resultSet.getString("Name"));
            universityData.setDescription(resultSet.getString("Description"));

            result.add(new Pair<>(matriculantData, universityData));
        }
        return result;
    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }

}