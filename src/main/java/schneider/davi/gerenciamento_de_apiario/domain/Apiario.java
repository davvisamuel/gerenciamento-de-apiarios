package schneider.davi.gerenciamento_de_apiario.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Apiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "apiary", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Hive> hive;

    private String apiaryName;

    private String city;

    private String registrationNumber;

    private String territoryRegistration;

    private String description;

    private Double latitude;

    private Double longitude;
}
