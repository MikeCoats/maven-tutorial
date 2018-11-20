package org.example.maventutorial;

import java.io.Serializable;

public class ResultMessage implements Serializable  {

    private static final long serialVersionUID = 1L;

    private float result;

    public ResultMessage() {
        this.result = 0.0f;
    }

    public ResultMessage(float result) {
        this.result = result;
    }

    /**
     * @return the result
     */
    public float getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(float result) {
        this.result = result;
    }
}