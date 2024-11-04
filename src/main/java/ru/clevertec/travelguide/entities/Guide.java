package ru.clevertec.travelguide.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "nameOfGuide")
@Builder
@Entity
@Table(name = "guide", schema = "guide")
public class Guide implements BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guide_id")
    private Long id;
    private String nameOfGuide;
    @CreationTimestamp
    private LocalDateTime dateOfCreate;
    @OneToOne
    @JoinColumn(name = "author_id")
    private Author author;
    @OneToOne
    @JoinColumn(name = "picture_id")
    private Picture headPicture;
    private String descriptionOfGuide;
    @Builder.Default
    @OneToMany(mappedBy = "guide")
    private List<Charter> contentsCharter = new ArrayList<>();

    public void addCharter(Charter charter) {
        charter.setGuide(this);
        contentsCharter.add(charter);
    }
}
