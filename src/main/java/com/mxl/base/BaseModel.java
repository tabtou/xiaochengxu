package com.mxl.base;

import java.io.Serializable;

public abstract class BaseModel implements Serializable {
    public BaseModel() {
    }

    public abstract String toString();

    public abstract boolean equals(Object var1);

    public abstract int hashCode();
}

