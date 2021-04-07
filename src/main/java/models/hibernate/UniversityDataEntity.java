package models.hibernate;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="universityData", schema = "matriculant")
public class UniversityDataEntity {

    @Id
    @Setter
    @Getter
    @GeneratedValue
    @Column(name = "id")
    private Long ID;

    @Setter
    @Getter
    @Column
    private String Name;

    @Setter
    @Getter
    @Column
    private String Description;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UniversityDataEntity that = (UniversityDataEntity) o;
        return Objects.equals(ID, that.ID) && Objects.equals(Name, that.Name) &&
                Objects.equals(Description, that.Description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, Name, Description);
    }
}