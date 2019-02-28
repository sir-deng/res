package com.tencent.mm.plugin.ac.a;

public final class d {
    public int fqW = 0;
    public int fqX = 0;
    public String result = "";

    public final String toString() {
        return String.format("result: %s, codeType: %s, codeVersion: %s", new Object[]{this.result, Integer.valueOf(this.fqW), Integer.valueOf(this.fqX)});
    }
}
