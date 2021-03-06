package com.tp.pojo;

import com.tp.exception.InvalidMessageException;

/**
 * Created by dev on 21/05/15.
 */
public class InstructionMessage {

    public Integer InstructionType;
    public Integer ProductCode;
    public Integer Quantity;
    public Integer UOM;
    public Integer TimeStamp;

    public Integer getInstructionType() {
        return InstructionType;
    }

    public void setInstructionType(Integer instructionType) {
        InstructionType = instructionType;
    }

    public Integer getProductCode() {
        return ProductCode;
    }

    public void setProductCode(Integer productCode) {
        ProductCode = productCode;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public Integer getUOM() {
        return UOM;
    }

    public void setUOM(Integer UOM) {
        this.UOM = UOM;
    }

    public Integer getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(Integer timeStamp) {
        TimeStamp = timeStamp;
    }

    public InstructionMessage(Integer instructionType, Integer productCode, Integer quantity, Integer UOM, Integer timeStamp) {
        InstructionType = instructionType;
        ProductCode = productCode;
        Quantity = quantity;
        this.UOM = UOM;
        TimeStamp = timeStamp;
    }

    public InstructionMessage() {
    }

    public boolean isInstructionMessageValid() throws InvalidMessageException {

        if (this.getInstructionType() <= 0 || this.getInstructionType() >= 100) {
            throw new InvalidMessageException("Instruction Type must be greater than 0 and less than 100");
        }

        if (this.getProductCode() < 0) {
            throw new InvalidMessageException("Product Code must be greater than 0");
        }

        if (this.getQuantity() < 0 ) {
            throw new InvalidMessageException("Quantity must be greater than 0");
        }

        if (this.getUOM() < 0 || this.getUOM() > 256 ) {
            throw new InvalidMessageException("UOM must be greater than or equal to 0 and less than 256");
        }

        if (this.getTimeStamp() < 0 ) {
            throw new InvalidMessageException("Timestamp must be greater than 0");
        }

        return true;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InstructionMessage that = (InstructionMessage) o;

        if (InstructionType != null ? !InstructionType.equals(that.InstructionType) : that.InstructionType != null)
            return false;
        if (ProductCode != null ? !ProductCode.equals(that.ProductCode) : that.ProductCode != null) return false;
        if (Quantity != null ? !Quantity.equals(that.Quantity) : that.Quantity != null) return false;
        if (TimeStamp != null ? !TimeStamp.equals(that.TimeStamp) : that.TimeStamp != null) return false;
        if (UOM != null ? !UOM.equals(that.UOM) : that.UOM != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = InstructionType != null ? InstructionType.hashCode() : 0;
        result = 31 * result + (ProductCode != null ? ProductCode.hashCode() : 0);
        result = 31 * result + (Quantity != null ? Quantity.hashCode() : 0);
        result = 31 * result + (UOM != null ? UOM.hashCode() : 0);
        result = 31 * result + (TimeStamp != null ? TimeStamp.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "InstructionMessage{" +
                "InstructionType=" + InstructionType +
                ", ProductCode=" + ProductCode +
                ", Quantity=" + Quantity +
                ", UOM=" + UOM +
                ", TimeStamp=" + TimeStamp +
                '}';
    }
}
