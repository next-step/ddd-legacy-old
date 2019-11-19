package camp.nextstep.edu.kitchenpos.model;

import java.time.LocalDateTime;

public class TableGroup {
    private Long id;
    private LocalDateTime createdDate;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(final LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
