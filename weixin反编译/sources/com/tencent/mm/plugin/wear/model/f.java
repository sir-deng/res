package com.tencent.mm.plugin.wear.model;

public final class f {
    public String frM = "";
    public int id = 0;
    public String talker = "";
    public int toV = 0;
    a toW;

    public enum a {
        INIT,
        SHOWING,
        IGNORE,
        REPLY
    }

    protected final Object clone() {
        f fVar = new f();
        fVar.id = this.id;
        fVar.talker = this.talker;
        fVar.frM = this.frM;
        fVar.toV = this.toV;
        fVar.toW = this.toW;
        return fVar;
    }

    public final String toString() {
        return "WearNotification [talker=" + this.talker + ", id=" + this.id + ", md5=" + this.frM + ", ignoreInWatch=" + this.toV + ", status=" + this.toW + "]";
    }
}
