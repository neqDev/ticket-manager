package pl.ticket.event.admin.event.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.ticket.event.admin.event_occurrence.model.AdminEventOccurrence;
import pl.ticket.event.admin.image.model.AdminImage;
import pl.ticket.event.customer.event_occurrence.model.EventOccurrence;

import java.util.List;

@Data
@Builder
@Entity
@Table(name = "event")
@NoArgsConstructor
@AllArgsConstructor
public class AdminEvent
{
    @Id
    @SequenceGenerator
            (
                    name = "event_id_sequence",
                    sequenceName = "event_id_sequence"
            )
    @GeneratedValue
            (
                    strategy = GenerationType.SEQUENCE,
                    generator = "event_id_sequence"
            )
    private Long id;
    private Integer capacity;
    private String title;
    private String description;
    private String slug;
    private Long categoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private AdminImage image;
}
