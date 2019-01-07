package org.jogen.demo.po;

/**
 * 应付账款
 * @author Jogen
 */
public class Payable extends BasePo {

    private String supplierName;

    private String supplierAccount;

    private int invoiceQuantity;

    private double financingAmount;

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierAccount() {
        return supplierAccount;
    }

    public void setSupplierAccount(String supplierAccount) {
        this.supplierAccount = supplierAccount;
    }

    public int getInvoiceQuantity() {
        return invoiceQuantity;
    }

    public void setInvoiceQuantity(int invoiceQuantity) {
        this.invoiceQuantity = invoiceQuantity;
    }

    public double getFinancingAmount() {
        return financingAmount;
    }

    public void setFinancingAmount(double financingAmount) {
        this.financingAmount = financingAmount;
    }
}
