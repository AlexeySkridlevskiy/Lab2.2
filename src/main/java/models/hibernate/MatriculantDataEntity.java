package models.hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="matriculantData", schema = "matriculant")
public class MatriculantDataEntity {
    private Long ID;
    private String Name;
    private String Surname;
    private String Patronymic;
    private String Gender;
    private String Nationality;
    private Date Birthday;
    private String Postcode;
    private String Country;
    private String Region;
    private String Area;
    private String City;
    private String Street;
    private String House;
    private String Apartment;
    private Long Marks;
    private Long PassingScore;
    private Integer UniversityId;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public Long getID() {
        return ID;
    }

    public void setID(Long id) {
        this.ID = id;
    }

    @Basic
    @Column(name = "Surname")
    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    @Basic
    @Column(name = "Patronymic")
    public String getPatronymic() {
        return Patronymic;
    }

    public void setPatronymic(String Patronymic) {
        this.Patronymic = Patronymic;
    }

    @Basic
    @Column(name = "Gender")
    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    @Basic
    @Column(name = "Nationality")
    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String Nationality) {
        this.Nationality = Nationality;
    }

    @Basic
    @Column(name = "Birthday")
    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date Birthday) {
        this.Birthday = Birthday;
    }

    @Basic
    @Column(name = "Postcode")
    public String getPostcode() {
        return Postcode;
    }

    public void setPostcode(String Postcode) {
        this.Postcode = Postcode;
    }

    @Basic
    @Column(name = "Country")
    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    @Basic
    @Column(name = "Region")
    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    @Basic
    @Column(name = "Area")
    public String getArea() {
        return Area;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }

    @Basic
    @Column(name = "City")
    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    @Basic
    @Column(name = "Street")
    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    @Basic
    @Column(name = "House")
    public String getHouse() {
        return House;
    }

    public void setHouse(String House) {
        this.House = House;
    }

    @Basic
    @Column(name = "Apartment")
    public String getApartment() {
        return Apartment;
    }

    public void setApartment(String Apartment) {
        this.Apartment = Apartment;
    }

    @Basic
    @Column(name = "Marks")
    public Long getMarks() {
        return Marks;
    }

    public void setMarks(Long Marks) {
        this.Marks = Marks;
    }

    @Basic
    @Column(name = "PassingScore")
    public Long getPassingScore() {
        return PassingScore;
    }

    public void setPassingScore(Long PassingScore) {
        this.PassingScore = PassingScore;
    }

    @Basic
    @Column(name = "UniversityId")
    public Integer getUniversityId() {
        return UniversityId;
    }

    public void setUniversityId(Integer UniversityId) {
        this.UniversityId = UniversityId;
    }

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