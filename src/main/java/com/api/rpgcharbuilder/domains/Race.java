package com.api.rpgcharbuilder.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_race")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String raceName;

    @Enumerated(value = EnumType.STRING)
    private Dice hpDice;

    @OneToMany(mappedBy = "race", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Char> char_id;

    public Race(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return Objects.equals(id, race.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public Dice getHpDice() {
        return hpDice;
    }

    public void setHpDice(Dice hpDice) {
        this.hpDice = hpDice;
    }

    public List<Char> getChar_id() {
        return char_id;
    }

    public void setChar_id(List<Char> char_id) {
        this.char_id = char_id;
    }
}
