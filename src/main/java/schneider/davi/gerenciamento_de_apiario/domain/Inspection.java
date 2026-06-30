package schneider.davi.gerenciamento_de_apiario.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Inspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Hive hive;

    private LocalDate inspectionDate;

    private Boolean queenSeen;

    private Boolean eggsSeen;

    private Boolean queenCellsSeen;

    private Boolean queenless;

    private String broodPattern;

    private String colonyStrength;

    private String observations;
}
