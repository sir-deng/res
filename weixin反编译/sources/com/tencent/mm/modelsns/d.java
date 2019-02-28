package com.tencent.mm.modelsns;

public final class d {
    StringBuffer hQG = new StringBuffer();
    StringBuffer hQH = new StringBuffer();
    private int index = 0;

    public final void p(String str, Object obj) {
        this.hQG.append(this.index + " " + str + "->" + obj + "\n");
        this.hQH.append(obj);
        this.index++;
    }

    public final void q(String str, Object obj) {
        this.hQG.append(str + "->" + obj + "\n");
        this.hQH.append(obj);
    }

    public final String toString() {
        return this.hQH.toString();
    }

    public final String SG() {
        this.index = 0;
        this.hQG.append("--end--\n\n");
        return this.hQG.toString();
    }
}
