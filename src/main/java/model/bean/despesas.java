/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author SARA
 */
public class despesas {
    
    private int expenseId;
    private BigDecimal expenseAmount;
    private Date spendOnDate;
    private String note;

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public BigDecimal getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(BigDecimal expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public Date getSpendOnDate() {
        return spendOnDate;
    }

    public void setSpendOnDate(Date spendOnDate) {
        this.spendOnDate = spendOnDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
}
