package com.lmi.xpr.poker.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "deck")
@Data
public class DeckEntity {

    @Id
    @Column(name = "id_deck")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDeck;

    @OneToMany(mappedBy = "deck", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CardEntity> cards;

}
