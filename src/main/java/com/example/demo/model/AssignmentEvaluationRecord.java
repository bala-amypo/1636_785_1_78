@Entity
@Table(name = "assignment_evaluation_records")
public class AssignmentEvaluationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long assignmentId;
    private Integer rating;
    private String feedback;
    private LocalDateTime evaluatedAt;

    @PrePersist
    void onCreate() {
        evaluatedAt = LocalDateTime.now();
    }

    public AssignmentEvaluationRecord() {}

    public AssignmentEvaluationRecord(Long assignmentId, Integer rating, String feedback) {
        this.assignmentId = assignmentId;
        this.rating = rating;
        this.feedback = feedback;
    }
}
