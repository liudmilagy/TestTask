package models;

import javax.persistence.*;

@Entity
@Table (name = "value")
public class Value {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "v")
    private Float v;

    public Value() {
    }

    public Value(Float v) {
        this.v = v;
    }
}
