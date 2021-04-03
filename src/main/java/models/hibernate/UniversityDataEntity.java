package models.hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="universityData", schema = "matriculant")
public class UniversityDataEntity {
    private Long ID;
    private String Name;
    private String Description;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId()
    {
        return ID;
    }

    public void setId(Long ID)
    {
        this.ID = ID;
    }

    @Basic
    @Column
    public String getName()
    {
        return Name;
    }

    public void setName(String Name)
    {
        this.Name = Name;
    }

    @Basic
    @Column
    public String getDescription()
    {
        return Description;
    }

    public void setDescription(String Description)
    {
        this.Description = Description;
    }

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