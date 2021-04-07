package models.sql;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "UniversityData")
public class UniversityData {

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
    @Column(name = "Description")
    private String Description;
}