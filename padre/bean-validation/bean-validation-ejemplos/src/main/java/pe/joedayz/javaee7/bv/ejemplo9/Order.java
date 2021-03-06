package pe.joedayz.javaee7.bv.ejemplo9;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@ChronologicalDates(groups = Delivery.class)
public class Order {

	// ======================================
	  // =             Attributes             =
	  // ======================================

	  @NotNull
	  private Long id;
	  @NotNull
	  @Past
	  private Date creationDate;
	  private Double totalAmount;
	  @NotNull(groups = Payment.class)
	  @Past(groups = Payment.class)
	  private Date paymentDate;
	  @NotNull(groups = Delivery.class)
	  @Past(groups = Delivery.class)
	  private Date deliveryDate;
	  private List<OrderLine> orderLines;

	  // ======================================
	  // =            Constructors            =
	  // ======================================

	  public Order() {
	  }

	  // ======================================
	  // =          Getters & Setters         =
	  // ======================================

	  public Long getId() {
	    return id;
	  }

	  public void setId(Long id) {
	    this.id = id;
	  }

	  public Date getCreationDate() {
	    return creationDate;
	  }

	  public void setCreationDate(Date creationDate) {
	    this.creationDate = creationDate;
	  }

	  public Double getTotalAmount() {
	    return totalAmount;
	  }

	  public void setTotalAmount(Double totalAmount) {
	    this.totalAmount = totalAmount;
	  }

	  public Date getPaymentDate() {
	    return paymentDate;
	  }

	  public void setPaymentDate(Date paymentDate) {
	    this.paymentDate = paymentDate;
	  }

	  public Date getDeliveryDate() {
	    return deliveryDate;
	  }

	  public void setDeliveryDate(Date deliveryDate) {
	    this.deliveryDate = deliveryDate;
	  }

	  public List<OrderLine> getOrderLines() {
	    return orderLines;
	  }

	  public void setOrderLines(List<OrderLine> orderLines) {
	    this.orderLines = orderLines;
	  }
}
