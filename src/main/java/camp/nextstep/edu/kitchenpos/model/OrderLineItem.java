package camp.nextstep.edu.kitchenpos.model;

public class OrderLineItem {
    private Long seq;
    private Long ordersId;
    private Long menuId;
    private long quantity;

    public Long getSeq() {
        return seq;
    }

    public void setSeq(final Long seq) {
        this.seq = seq;
    }

    public Long getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(final Long ordersId) {
        this.ordersId = ordersId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(final Long menuId) {
        this.menuId = menuId;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(final long quantity) {
        this.quantity = quantity;
    }
}
