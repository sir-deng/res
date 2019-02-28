package com.tencent.mm.plugin.wenote.model.nativenote.spans;

public final class a {
    public final q ubV;
    public int ubW;
    public int ubX;

    public a(q qVar, int i, int i2) {
        this.ubV = qVar;
        this.ubW = i;
        this.ubX = i2;
    }

    public final String toString() {
        return this.ubV.name() + " - " + this.ubW + "/" + this.ubX;
    }
}
