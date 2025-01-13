package com.gwidgets;

public class ResultDao {
    private boolean exists;

    public ResultDao(boolean exists) {
        this.exists = exists;
    }

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }
}
