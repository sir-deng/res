package com.tencent.mm.storage;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public interface as extends g {

    public interface a {
        void a(ae aeVar, as asVar);
    }

    public interface b {
        String a(int i, String str, String str2, int i2, Context context);

        void a(au auVar, PString pString, PString pString2, PInt pInt, boolean z);
    }

    boolean BC(String str);

    boolean Fk(String str);

    void XE(String str);

    ae XF(String str);

    void XG(String str);

    boolean XH(String str);

    boolean XI(String str);

    boolean XJ(String str);

    boolean XK(String str);

    boolean XL(String str);

    boolean XM(String str);

    Cursor XN(String str);

    Cursor XO(String str);

    int XP(String str);

    String XQ(String str);

    ae XR(String str);

    int XS(String str);

    void XT(String str);

    void XU(String str);

    int XV(String str);

    int a(ae aeVar, String str);

    int a(ae aeVar, String str, boolean z);

    Cursor a(String str, List<String> list, String str2, boolean z);

    Cursor a(ArrayList<String> arrayList, String str, List<String> list, String str2);

    com.tencent.mm.vending.b.b a(e eVar);

    void a(d dVar);

    void a(ae aeVar, int i, int i2);

    void a(a aVar);

    void a(a aVar, Looper looper);

    void a(b bVar);

    boolean a(String str, int i, boolean z, int i2);

    String aY(int i, String str);

    void ad(au auVar);

    void ax(LinkedList<String> linkedList);

    Cursor b(String str, List<String> list, boolean z, String str2);

    void b(c cVar, c.c cVar2);

    void b(a aVar);

    Cursor c(String str, List<String> list, String str2);

    void c(a aVar);

    boolean cjo();

    boolean cjp();

    HashMap<String, Long> cjq();

    void cjr();

    List<String> cjt();

    List<String> cju();

    Cursor cjv();

    int cjw();

    String cjx();

    Cursor cjy();

    ae cjz();

    long d(ae aeVar);

    void d(String[] strArr, String str);

    Cursor de(String str, int i);

    boolean f(ae aeVar);

    Cursor fJ(String str, String str2);

    boolean g(ae aeVar);

    int hy(String str);

    Cursor j(List<String> list, int i);

    Cursor r(String str, List<String> list);

    Cursor s(String str, List<String> list);

    b ux();
}
