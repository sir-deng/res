package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.e.i;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public interface o extends f {
    public static final String[] gLy = new String[]{i.a(f.gKN, "FavItemInfo")};

    f Az(String str);

    ArrayList<f> a(List<Long> list, List<f> list2, Set<Integer> set, n nVar);

    List<f> a(int i, int i2, Set<Integer> set, n nVar);

    List<f> a(long j, int i, Set<Integer> set, n nVar);

    boolean a(f fVar, String... strArr);

    e aIF();

    int aIG();

    List<f> aIH();

    List<f> aII();

    List<f> aIJ();

    List<f> aIK();

    List<f> aIL();

    List<f> aIM();

    List<Long> aIN();

    void aIO();

    List<Long> aIP();

    boolean b(f fVar, String... strArr);

    f dc(long j);

    f dd(long j);

    long f(long j, int i, int i2);

    boolean f(f fVar);

    long g(long j, int i, int i2);

    void g(f fVar);

    int getCount();

    boolean q(long j, int i);

    LinkedList<Integer> r(long j, int i);

    void t(int i, long j);
}
