package ex.db2.product.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;

@Slf4j
@Entity
@Getter
@ToString
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Setter
    private Integer price;

    private Date updatedAt;

    public Product(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    @PrePersist
    private void prePersist() {
        log.warn("prePersist() start");
        this.updatedAt = new Date();
        log.warn("prePersist() end");
    }

    @PreUpdate
    private void preUpdate() {
        log.warn("preUpdate() start");
        this.updatedAt = new Date();
        log.warn("preUpdate() end");
    }

    @PostUpdate
    private void postUpdate() {
        log.warn("postUpdate() start");
        this.updatedAt = new Date();
        log.warn("postUpdate() end");
    }
}
