
class Order {
    int orderId;
    int productId;
    int userId;
    float totalPrice;
    String orderDatetime;
    String status;


    public Order(int orderId, int productId, int userId, float totalPrice, String orderDatetime, String status) {
        this.orderId = orderId;
        this.productId = productId;
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.orderDatetime = orderDatetime;
        this.status = status;
    }
}
