package schneider.davi.gerenciamento_de_apiario.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Queen {

    @Id
    String identificationNumber;

    String origin;

    String breed;

    String color;

    LocalDate birthDat;
}
