package org.example.maventutorial;

import java.io.Serializable;

public class OperationMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private float leftOperand;
    private String operator;
    private float rightOperand;

    public OperationMessage() {
        this.leftOperand = 0.0f;
        this.operator = "+";
        this.rightOperand = 0.0f;
    }

    public OperationMessage(float leftOperand, String operator, float rightOperand) {
        this.leftOperand = leftOperand;
        this.operator = operator;
        this.rightOperand = rightOperand;
    }

    /**
     * @return the leftOperand
     */
    public float getLeftOperand() {
        return leftOperand;
    }

    /**
     * @param leftOperand the leftOperand to set
     */
    public void setLeftOperand(float leftOperand) {
        this.leftOperand = leftOperand;
    }

    /**
     * @return the operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     * @param operator the operator to set
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * @return the rightOperand
     */
    public float getRightOperand() {
        return rightOperand;
    }

    /**
     * @param rightOperand the rightOperand to set
     */
    public void setRightOperand(float rightOperand) {
        this.rightOperand = rightOperand;
    }

}