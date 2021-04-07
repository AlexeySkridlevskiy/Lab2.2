package models.sql;

import lombok.Setter;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "MatriculantData")
public class MatriculantData {

    @Id
    @Getter
    @Setter
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Getter
    @Setter
    @Column(name = "Name")
    private String Name;

    @Getter
    @Setter
    @Column(name = "Surname")
    private String Surname;

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
    private String Birthday;

    @Getter
    @Setter
    @Column(name = "Postcode")
    private Long Postcode;

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
}