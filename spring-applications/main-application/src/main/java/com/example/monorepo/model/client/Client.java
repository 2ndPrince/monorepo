package com.example.monorepo.model.client;

import com.example.monorepo.MonoParameter;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.EnumMap;
import java.util.Map;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
@Builder
@Table(name = "client")
public class Client {

    @NotNull
    private String name;

    @Id
    @NotNull
    private String guid;

    @ElementCollection(fetch = FetchType.EAGER)
    @MapKeyColumn(name = "name")
    @MapKeyEnumerated(EnumType.STRING)
    @CollectionTable(name = "mono_parameter", joinColumns = @JoinColumn(name = "client_id"))
    @Column(name ="value", nullable = false)
    @Builder.Default
    private Map<MonoParameter, String> monoParameters = new EnumMap<>(MonoParameter.class);

}
