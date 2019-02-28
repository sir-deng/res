package com.tencent.mm.plugin.wenote.model.a;

import java.io.Serializable;

public final class p implements Serializable {
    public boolean tYq = false;
    public long tYr = -1;
    public long tYs = -1;
    public boolean tYt = false;
    public String tYu = "";
    public String tYv = "";
    public int tYw = 0;
    public int tYx = 0;

    public final String bWH() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("topIsOpenFromSession=").append(this.tYq).append(" topLocalId=").append(this.tYr).append(" topMsgId=").append(this.tYs).append(" topTitle=").append(this.tYu).append(" topNoteXml=").append(this.tYv).append(" topLastPosition=").append(this.tYw).append(" topLastOffset=").append(this.tYx);
        return stringBuilder.toString();
    }
}
