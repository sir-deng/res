package com.tencent.mm.plugin.fts.a;

import android.database.Cursor;
import com.tencent.mm.storage.x;
import java.util.List;

public interface i {
    x BB(String str);

    boolean BC(String str);

    long BD(String str);

    List<String> BE(String str);

    Cursor i(String str, String[] strArr);

    Cursor rawQuery(String str, String[] strArr);
}
