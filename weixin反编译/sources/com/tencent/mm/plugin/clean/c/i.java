package com.tencent.mm.plugin.clean.c;

import com.tencent.mm.plugin.i.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class i {
    public String filePath;
    public long fqB;
    public String fwx;
    public long hXt;
    public List<a> llt = new ArrayList();
    public long size;
    public int type;
    public String userName;

    public final String toString() {
        switch (this.type) {
            case 1:
                return String.format("%-8s    %-10s  %s\r\n", new Object[]{"IMG", bi.fL(this.size), this.filePath});
            case 2:
                return String.format("%-8s    %-10s  %s\r\n", new Object[]{"VOICE", bi.fL(this.size), this.filePath});
            case 3:
                return String.format("%-8s    %-10s  %s\r\n", new Object[]{"VIDEO", bi.fL(this.size), this.filePath});
            case 4:
                return String.format("%-8s    %-10s  %s\r\n", new Object[]{"ATTACH", bi.fL(this.size), this.filePath});
            default:
                return "";
        }
    }

    public final long ayG() {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(this.hXt);
        return (long) (instance.get(2) + (instance.get(1) * 100));
    }
}
