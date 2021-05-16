package com.lmi.xpr.poker.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "game")
@Data
public class GameEntity {

    @Id
    @Column(name = "id_game")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGame;

    @ManyToMany
    @JoinTable(
            name = "game_player",
            joinColumns = @JoinColumn(name = "id_game"),
            inverseJoinColumns = @JoinColumn(name = "id_player")
    )
    private Set<PlayerEntity> players;

    @OneToMany(mappedBy = "game")
    private Set<DeckEntity> decks;

}
