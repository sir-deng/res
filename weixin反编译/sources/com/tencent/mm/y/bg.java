package com.tencent.mm.y;

import android.database.Cursor;
import junit.framework.Assert;

public final class bg {
    int fEo = -1;
    public String hfO = "";
    public String hfQ = "";
    public String hiO = "";
    public String hiP = "";
    public String hiQ = "";
    public long hiR = 0;
    public String hiS = "";
    public String hiT = "";
    public int hiU = 0;
    public int hiV = 0;
    public long hiW = 0;
    public String hiX = "";
    String hiY = "";
    public String name = "";
    public long time = 0;
    public String title = "";
    public int type = 0;
    public String url = "";

    public final void b(Cursor cursor) {
        this.hiO = cursor.getString(0);
        this.time = cursor.getLong(1);
        this.type = cursor.getInt(2);
        this.name = cursor.getString(3);
        this.title = cursor.getString(4);
        this.url = cursor.getString(5);
        this.hiP = cursor.getString(6);
        this.hiQ = cursor.getString(7);
        this.hiR = cursor.getLong(8);
        this.hiS = cursor.getString(9);
        this.hiT = cursor.getString(10);
        this.hiU = cursor.getInt(11);
        this.hfO = cursor.getString(12);
        this.hfQ = cursor.getString(13);
        this.hiV = cursor.getInt(14);
        this.hiW = cursor.getLong(15);
        this.hiX = cursor.getString(16);
        this.hiY = cursor.getString(17);
    }

    public static String gW(int i) {
        if (i == 20) {
            return "newsapp";
        }
        if (i == 11) {
            return "blogapp";
        }
        Assert.assertTrue("INFO TYPE NEITHER NEWS NOR WEIBO", false);
        return null;
    }

    public final void aM(long j) {
        this.hiW = j;
    }

    public final boolean HM() {
        return this.hiV == 1;
    }

    public final String HN() {
        return this.hiO == null ? "" : this.hiO;
    }

    public final String getName() {
        return this.name == null ? "" : this.name;
    }

    public final String getTitle() {
        return this.title == null ? "" : this.title;
    }

    public final String getUrl() {
        return this.url == null ? "" : this.url;
    }

    public final String HO() {
        return this.hiP == null ? "" : this.hiP;
    }

    public final String HP() {
        return this.hiS == null ? "" : this.hiS;
    }

    public final String HQ() {
        return this.hiT == null ? "" : this.hiT;
    }

    public final String HR() {
        if (this.hfO == null) {
            return "";
        }
        String[] split = this.hfO.split("\\|");
        if (split == null || split.length <= 0) {
            return "";
        }
        return split[0];
    }

    public final String HS() {
        return this.hfQ == null ? "" : this.hfQ;
    }

    public final String HT() {
        return this.hiX == null ? "" : this.hiX;
    }
}
