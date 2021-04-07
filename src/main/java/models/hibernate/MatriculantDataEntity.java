package models.hibernate;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="matriculantData", schema = "matriculant")
public class MatriculantDataEntity {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    @Column(name = "ID")
    private Long ID;

    @Getter
    @Setter
    @Column(name = "Surname")
    private String Surname;

    @Getter
    @Setter
    @Column(name = "Name")
    private String Name;

    @Getter
    @Setter
    @Column(name = "Patronymic")
    private String Patronymic;

    @Getter
    @Setter
    @Column(name = "Gender")
    private String Gender;

    @Getter
    @Setter
    @Column(name = "Nationality")
    private String Nationality;

    @Getter
    @Setter
    @Column(name = "Birthday")
    private Date Birthday;

    @Getter
    @Setter
    @Column(name = "Postcode")
    private String Postcode;

    @Getter
    @Setter
    @Column(name = "Country")
    private String Country;

    @Getter
    @Setter
    @Column(name = "Region")
    private String Region;

    @Getter
    @Setter
    @Column(name = "Area")
    private String Area;

    @Getter
    @Setter
    @Column(name = "City")
    private String City;

    @Getter
    @Setter
    @Column(name = "Street")
    private String Street;

    @Getter
    @Setter
    @Column(name = "House")
    private String House;

    @Getter
    @Setter
    @Column(name = "Apartment")
    private String Apartment;

    @Getter
    @Setter
    @Column(name = "Marks")
    private Long Marks;

    @Getter
    @Setter
    @Column(name = "PassingScore")
    private Long PassingScore;

    @Getter
    @Setter
    @Column(name = "UniversityId")
    private Integer UniversityId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatriculantDataEntity that = (MatriculantDataEntity) o;
        return Objects.equals(ID, that.ID) && Objects.equals(Name, that.Name) &&
                Objects.equals(Surname, that.Surname) && Objects.equals(Patronymic, that.Patronymic)
                && Objects.equals(Gender, that.Gender) && Objects.equals(Nationality, that.Nationality)
                && Objects.equals(Birthday, that.Birthday) && Objects.equals(Postcode, that.Postcode)
                && Objects.equals(Country, that.Country) && Objects.equals(Region, that.Region)
                && Objects.equals(Area, that.Area) && Objects.equals(City, that.City)
                && Objects.equals(Street, that.Street) && Objects.equals(House, that.House)
                && Objects.equals(Apartment, that.Apartment) && Objects.equals(Marks, that.Marks)
                && Objects.equals(PassingScore, that.PassingScore) && Objects.equals(UniversityId, that.UniversityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, Name, Surname, Patronymic, Gender, Nationality, Birthday,
                Postcode, Country, Region, Area, City, Street, House, Apartment, Marks, PassingScore, UniversityId);
    }
}