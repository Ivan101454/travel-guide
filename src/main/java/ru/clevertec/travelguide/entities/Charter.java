package ru.clevertec.travelguide.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "charter", schema = "guide")
public class Charter implements BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "charter_id")
    private Long id;
    private String nameCharter;
    @OneToOne
    @JoinColumn(name = "picture_id")
    private Picture pictureForCharter;
    private String textCharter;
    @ManyToOne
    @JoinColumn(name = "guide_id")
    private Guide guide;
}
