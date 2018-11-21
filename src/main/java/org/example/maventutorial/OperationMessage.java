package org.example.maventutorial;

import java.io.Serializable;

/**
 * A message that represents the mathematical function to run.
 */
public final class OperationMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The left number in the equation.
     */
    private float leftOperand;

    /**
     * The function in the equation.
     */
    private String operator;

    /**
     * The right number in the equation.
     */
    private float rightOperand;

    /**
     * Default Constructor.
     */
    public OperationMessage() {
        this.leftOperand = 0.0f;
        this.operator = "+";
        this.rightOperand = 0.0f;
    }

    /**
     * Fully Specified Constructor.
     *
     * @param theLeftOperand the leftOperand
     * @param theOperator the operator
     * @param theRightOperand the leftOperand
     */
    public OperationMessage(final float theLeftOperand,
                            final String theOperator,
                            final float theRightOperand
    ) {
        this.leftOperand = theLeftOperand;
        this.operator = theOperator;
        this.rightOperand = theRightOperand;
    }

    /**
     * @return the leftOperand
     */
    public float getLeftOperand() {
        return leftOperand;
    }

    /**
     * @param theLeftOperand the leftOperand to set
     */
    public void setLeftOperand(final float theLeftOperand) {
        this.leftOperand = theLeftOperand;
    }

    /**
     * @return the operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     * @param theOperator the operator to set
     */
    public void setOperator(final String theOperator) {
        this.operator = theOperator;
    }

    /**
     * @return the rightOperand
     */
    public float getRightOperand() {
        return rightOperand;
    }

    /**
     * @param theRightOperand the rightOperand to set
     */
    public void setRightOperand(final float theRightOperand) {
        this.rightOperand = theRightOperand;
    }

}
