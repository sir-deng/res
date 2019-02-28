package com.tencent.mm.plugin.appbrand.appcache.b.d;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;

public class b extends i<a> {
    public static final String[] iHj = new String[]{i.a(a.iHk, "PredownloadBlockCgiRequest")};
    private final e iHl;

    public b(e eVar) {
        super(eVar, a.iHk, "PredownloadBlockCgiRequest", a.fNF);
        this.iHl = eVar;
    }

    public final Pair<Boolean, Integer> u(String str, int i, int i2) {
        return d("username", str, i, i2);
    }

    public final Pair<Boolean, Integer> v(String str, int i, int i2) {
        return d("appId", str, i, i2);
    }

    private Pair<Boolean, Integer> d(String str, String str2, int i, int i2) {
        int i3 = -1;
        long Wx = bi.Wx();
        String str3 = "select reportId from PredownloadBlockCgiRequest where " + str + "=? and startTime<" + Wx + " and " + Wx + "<endTime and cgiList" + " like '%;" + i + ";%' and sceneList like '%;" + i2 + ";%'";
        Cursor rawQuery = this.iHl.rawQuery(str3, new String[]{str2});
        if (rawQuery == null || rawQuery.isClosed()) {
            return Pair.create(Boolean.valueOf(false), Integer.valueOf(-1));
        }
        boolean moveToFirst = rawQuery.moveToFirst();
        if (moveToFirst) {
            i3 = rawQuery.getInt(0);
        }
        rawQuery.close();
        return Pair.create(Boolean.valueOf(moveToFirst), Integer.valueOf(i3));
    }
}
