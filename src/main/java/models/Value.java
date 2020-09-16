package models;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.*;
import javax.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateSessionFactoryUtil;

@Entity
@Table (name = "value")
public class Value extends PanacheEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column (name = "v")
    private Float v;

    public Value() {
    }

    public Value(Float v) {
        this.v = v;
    }

    @Getter
    public Long getId() {
        return id;
    }

    public Float getV() {
        return v;
    }

    @Setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setV(Float v) {
        this.v = v;
    }

}
