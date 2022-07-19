package task1.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "DOCUMENTS")
public class Document {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TYPE")
    private String type;
    @Column(name = "NUMBER")
    private String number;

    @Column(name = "IS_ACTIVE")
    private Boolean status;

    public Document(String number, String type, Boolean status) {
        this.number = number;
        this.type = type;
        this.status = status;
    }

    @Override
    public String toString() {
        return "\nДокумент:\n" +
                "\tТип: " + type + '\n' +
                "\tНомер: " + number + '\n' +
                "\tАктивный: "  + status + '\n';
    }
}
