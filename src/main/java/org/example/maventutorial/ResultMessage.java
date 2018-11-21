package org.example.maventutorial;

import java.io.Serializable;

/**
 * A message representing a result.
 */
public final class ResultMessage implements Serializable  {

    private static final long serialVersionUID = 1L;

    /**
     * The result.
     */
    private float result;

    /**
     * Default constructor.
     */
    public ResultMessage() {
        this.result = 0.0f;
    }

    /**
     * Fully Specified Constructor.
     *
     * @param theResult the result
     */
    public ResultMessage(final float theResult) {
        this.result = theResult;
    }

    /**
     * @return the result
     */
    public float getResult() {
        return result;
    }

    /**
     * @param theResult the result to set
     */
    public void setResult(final float theResult) {
        this.result = theResult;
    }
}
