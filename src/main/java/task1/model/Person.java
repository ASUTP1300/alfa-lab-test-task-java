package task1.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PERSONS")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LAST_NAME")
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DOCUMENT_ID", referencedColumnName = "id")
    private Document document;

    public Person(String name, String lastName, Document document) {
        this.name = name;
        this.lastName = lastName;
        this.document = document;
    }

    @Override
    public String toString() {
        return "\nГражданин:\n" +
                "\tИмя: " + name + '\n' +
                "\tФамилия: " + lastName
                 + document;
    }
}
