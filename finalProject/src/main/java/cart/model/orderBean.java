package cart.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import register.model.MemberBean;

@Entity
@Table(name = "cOrder")
public class orderBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer oId;
	private Integer oTotalAmount;
	private java.sql.Timestamp oTimestamp;
	private String oPayment;
	private String oAddress;
	private String mAccount;
	private String oReceiveName;
	private String oReceivePhone;
	private String oNote;
	@OneToMany(mappedBy = "orderBean", cascade = CascadeType.ALL)
	Set<orderItemBean> itemSet = new LinkedHashSet<>();

	public Set<orderItemBean> getItemSet() {
		return itemSet;
	}

	public void setItemSet(Set<orderItemBean> itemSet) {
		this.itemSet = itemSet;
	}
	
	public orderBean(Integer oId, Integer oTotalAmount, Timestamp oTimestamp, String oPayment, String oAddress,
			String mAccount) {
		super();
		this.oId = oId;
		this.oTotalAmount = oTotalAmount;
		this.oTimestamp = oTimestamp;
		this.oPayment = oPayment;
		this.oAddress = oAddress;
		this.mAccount = mAccount;
	}

	public orderBean() {
	}

	public Integer getoId() {
		return oId;
	}

	public void setoId(Integer oId) {
		this.oId = oId;
	}

	public Integer getoTotalAmount() {
		return oTotalAmount;
	}

	public void setoTotalAmount(Integer oTotalAmount) {
		this.oTotalAmount = oTotalAmount;
	}

	public java.sql.Timestamp getoTimestamp() {
		return oTimestamp;
	}

	public void setoTimestamp(java.sql.Timestamp oTimestamp) {
		this.oTimestamp = oTimestamp;
	}

	public String getoPayment() {
		return oPayment;
	}

	public void setoPayment(String oPayment) {
		this.oPayment = oPayment;
	}

	public String getmAccount() {
		return mAccount;
	}

	public void setmAccount(String mAccount) {
		this.mAccount = mAccount;
	}

	public String getoAddress() {
		return oAddress;
	}

	public void setoAddress(String oAddress) {
		this.oAddress = oAddress;
	}

	public String getoReceiveName() {
		return oReceiveName;
	}

	public void setoReceiveName(String oReceiveName) {
		this.oReceiveName = oReceiveName;
	}

	public String getoReceivePhone() {
		return oReceivePhone;
	}

	public void setoReceivePhone(String oReceivePhone) {
		this.oReceivePhone = oReceivePhone;
	}

	public String getoNote() {
		return oNote;
	}

	public void setoNote(String oNote) {
		this.oNote = oNote;
	}

}
