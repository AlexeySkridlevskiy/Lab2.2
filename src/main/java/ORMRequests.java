import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import models.hibernate.MatriculantDataEntity;
import models.hibernate.UniversityDataEntity;
import models.WhereEnterMatriculant;
import org.intellij.lang.annotations.Language;
import org.javatuples.Pair;

import java.util.Arrays;
import java.util.List;

public class ORMRequests{

    SessionFactory sessionFactory;

    public ORMRequests() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<MatriculantDataEntity> listMatriculant() {
        List<MatriculantDataEntity> result = select("from MatriculantDataEntity");
        return result;
    }

    public List<UniversityDataEntity> listUniversity() {
        List<UniversityDataEntity> result = select("from UniversityDataEntity");
        return result;
    }

    private List select(@Language("HQL") String queryString) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query query = session.createQuery(queryString);
        List result = query.getResultList();
        tr.commit();
        return result;
    }

    private Object selectSingle(@Language("HQL") String queryString) {
        return select(queryString).get(0);
    }

    public List<MatriculantDataEntity> getbyPassingScore() {
        List<MatriculantDataEntity> result = select("select b.passingScore from MatriculantDataEntity b where b.passingScore > 225");
        return result;
    }

    public Long countMatriculantByScore()
    {
        Long result = (Long) selectSingle("select count(*) from MatriculantDataEntity where passingScore > 250");
        return result;
    }

    public Long sumMatriculantMarks()
    {
        Long result = (Long) selectSingle("select sum(marks) from MatriculantDataEntity where gender = 'мужской'");
        return result;
    }

    public Long[] MinMaxMarks()
    {
        Object[] result = (Object[]) selectSingle("select min(marks), max(marks) from MatriculantDataEntity");
        return Arrays.stream(result).toArray(Long[]::new);
    }

    public List<Pair<MatriculantDataEntity, UniversityDataEntity>> getNameWhenEnter()
    {
        List<Pair<MatriculantDataEntity, UniversityDataEntity>> result = select("select new org.javatuples.Pair(b, c) " +
                "from MatriculantDataEntity b inner join UniversityDataEntity c " +
                "on b.id = c.id where b.universityId = 3");
        return result;
    }


    public List<WhereEnterMatriculant> getWhereEnterMatriculant()
    {
        List<WhereEnterMatriculant> result = select("select " +
                "new models.WhereEnterMatriculant(b.id, b.surname, b.name, b.patronymic, b.birthday, c.name) " +
                "from MatriculantDataEntity b inner join UniversityDataEntity c on b.id = c.id");
        return result;
    }

}

class HibernateUtil {
    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure(); //"hibernate.cfg.xml"
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().configure();
        sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null)
            sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
}