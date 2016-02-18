package com.example.user;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_CUST_INFO")
public class UserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="CUST_NO", nullable=false)
	private int custNo;
	
	@Column(name="PWD", nullable=false)
	@NotNull
	private String pwd;	

	@Column(name="CUST_ID", nullable=false)
	private String custId;

	@Column(name="CUST_NAME", nullable=false)
	private String custName;
	
	@Column(name="NICK_NAME", nullable=false)
	private String nickName;

	@Column(name="SSN_ENC", nullable=false)
	private String ssnEnc;
	
	@Column(name="SSN_VIEW", nullable=false)
	private String ssnView;
	
	@Column(name="STTS_CD", nullable=false)
	private String sttsCd;			/* CT01001 ... */
	
	@Column(name="CUST_ROLE")
	private String selfAuthCd;		/* CI, IPIN ... */
	
	@Column(name="NAME_AUTH_YN")
	private String nameAuthYn;
	
	@Column(name="PARENT_AGREE_YN")
	private String parentAgreeYn;
	
	@Column(name="LESS14_YN")
	private String less14Yn;
	
	@Column(name="FRGNER_YN")
	private String foreignerYn;
	
	@Column(name="SELF_AUTH_YN")
	private String selfAuthYn;
	
	@Column(name="REG_CUST_NO")
	private String regCustNo;

	@Column(name="REG_DT")
	private String regDt;

	@Column(name="MOD_CUST_NO")
	private String modCustNo;
	
	@Column(name="MOD_DT")
	private String modDt;
	
	public UserInfo() { }

	// Getter and setter methods
	
	public int getCustNo() {
		return custNo;
	}

	public void setCustNo(int custNo) {
		this.custNo = custNo;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getSsnEnc() {
		return ssnEnc;
	}

	public void setSsnEnc(String ssnEnc) {
		this.ssnEnc = ssnEnc;
	}

	public String getSsnView() {
		return ssnView;
	}

	public void setSsnView(String ssnView) {
		this.ssnView = ssnView;
	}

	public String getSttsCd() {
		return sttsCd;
	}

	public void setSttsCd(String sttsCd) {
		this.sttsCd = sttsCd;
	}

	public String getSelfAuthCd() {
		return selfAuthCd;
	}

	public void setSelfAuthCd(String selfAuthCd) {
		this.selfAuthCd = selfAuthCd;
	}

	public String getNameAuthYn() {
		return nameAuthYn;
	}

	public void setNameAuthYn(String nameAuthYn) {
		this.nameAuthYn = nameAuthYn;
	}

	public String getParentAgreeYn() {
		return parentAgreeYn;
	}

	public void setParentAgreeYn(String parentAgreeYn) {
		this.parentAgreeYn = parentAgreeYn;
	}

	public String getLess14Yn() {
		return less14Yn;
	}

	public void setLess14Yn(String less14Yn) {
		this.less14Yn = less14Yn;
	}

	public String getForeignerYn() {
		return foreignerYn;
	}

	public void setForeignerYn(String foreignerYn) {
		this.foreignerYn = foreignerYn;
	}

	public String getSelfAuthYn() {
		return selfAuthYn;
	}

	public void setSelfAuthYn(String selfAuthYn) {
		this.selfAuthYn = selfAuthYn;
	}

	public String getRegCustNo() {
		return regCustNo;
	}

	public void setRegCustNo(String regCustNo) {
		this.regCustNo = regCustNo;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	public String getModCustNo() {
		return modCustNo;
	}

	public void setModCustNo(String modCustNo) {
		this.modCustNo = modCustNo;
	}

	public String getModDt() {
		return modDt;
	}

	public void setModDt(String modDt) {
		this.modDt = modDt;
	}

	
	
	
}
