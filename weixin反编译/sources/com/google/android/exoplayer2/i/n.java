package com.google.android.exoplayer2.i;

import java.util.ArrayList;
import java.util.Comparator;

public final class n {
    public static final Comparator<a> aCv = new Comparator<a>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((a) obj).index - ((a) obj2).index;
        }
    };
    public static final Comparator<a> aCw = new Comparator<a>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            a aVar = (a) obj;
            a aVar2 = (a) obj2;
            if (aVar.value < aVar2.value) {
                return -1;
            }
            return aVar2.value < aVar.value ? 1 : 0;
        }
    };
    public int aCA = -1;
    public int aCB;
    public int aCC;
    public int aCD;
    public final int aCx;
    public final ArrayList<a> aCy = new ArrayList();
    public final a[] aCz = new a[5];

    private static class a {
        public int index;
        public float value;
        public int weight;

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public n(int i) {
        this.aCx = i;
    }
}
