package com.lmi.xpr.poker.data.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "card")
@Data
public class CardEntity {
    @Id
    @Column(name = "id_card")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCard;

    private Faces face;

    private Suits suit;

    private Integer position;

    @ManyToOne
    @JoinColumn(name = "fk_deck", nullable = false)
    private DeckEntity deck;

    @Column(name = "fk_player")
    private Long idPlayer;


}
