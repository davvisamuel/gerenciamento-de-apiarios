package schneider.davi.gerenciamento_de_apiario.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Apiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private String apiaryName;

    private String city;

    private String registrationNumber;

    private String territoryRegistration;

    private String description;

    private Double latitude;

    private Double longitude;
}
