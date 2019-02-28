package com.tencent.mm.plugin.fav.a;

import android.database.Cursor;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.e.i;
import java.util.LinkedList;
import java.util.List;

public interface j extends f {
    public static final String[] gLy = new String[]{i.a(c.gKN, "FavCdnInfo")};

    c Ay(String str);

    void a(i iVar);

    boolean a(c cVar, String... strArr);

    LinkedList<c> aIA();

    Cursor aIB();

    Cursor aIC();

    void aIz();

    void b(i iVar);

    boolean b(c cVar);

    boolean b(c cVar, String... strArr);

    List<c> cX(long j);

    List<c> cY(long j);

    void cZ(long j);

    void d(f fVar);

    boolean da(long j);

    int n(long j, int i);
}
