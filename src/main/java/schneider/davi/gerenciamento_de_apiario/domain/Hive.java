package schneider.davi.gerenciamento_de_apiario.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Hive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name;

    String frameType;

    String colonyOrigin;

    Integer boxCount;

    @OneToOne(cascade = CascadeType.ALL)
    private Queen queen;

    @ManyToOne
    private Apiario apiary;
}
