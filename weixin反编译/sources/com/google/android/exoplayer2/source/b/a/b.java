package com.google.android.exoplayer2.source.b.a;

import java.util.Collections;
import java.util.List;

public final class b extends c {
    public final long aes;
    public final long asL;
    public final int auF;
    public final long auG;
    public final boolean auH;
    public final int auI;
    public final int auJ;
    public final long auK;
    public final boolean auL;
    public final boolean auM;
    public final boolean auN;
    public final a auO;
    public final List<a> auP;
    public final int version;

    public static final class a implements Comparable<Long> {
        public final long aes;
        public final boolean ami;
        public final int auQ;
        public final long auR;
        public final String auS;
        public final String auT;
        public final long auU;
        public final long auV;
        public final String url;

        public final /* synthetic */ int compareTo(Object obj) {
            Long l = (Long) obj;
            if (this.auR > l.longValue()) {
                return 1;
            }
            return this.auR < l.longValue() ? -1 : 0;
        }

        public a(String str, long j, long j2) {
            this(str, 0, -1, -9223372036854775807L, false, null, null, j, j2);
        }

        public a(String str, long j, int i, long j2, boolean z, String str2, String str3, long j3, long j4) {
            this.url = str;
            this.aes = j;
            this.auQ = i;
            this.auR = j2;
            this.ami = z;
            this.auS = str2;
            this.auT = str3;
            this.auU = j3;
            this.auV = j4;
        }
    }

    public b(int i, String str, List<String> list, long j, long j2, boolean z, int i2, int i3, int i4, long j3, boolean z2, boolean z3, boolean z4, a aVar, List<a> list2) {
        super(str, list);
        this.auF = i;
        this.asL = j2;
        this.auH = z;
        this.auI = i2;
        this.auJ = i3;
        this.version = i4;
        this.auK = j3;
        this.auL = z2;
        this.auM = z3;
        this.auN = z4;
        this.auO = aVar;
        this.auP = Collections.unmodifiableList(list2);
        if (list2.isEmpty()) {
            this.aes = 0;
        } else {
            a aVar2 = (a) list2.get(list2.size() - 1);
            this.aes = aVar2.aes + aVar2.auR;
        }
        if (j == -9223372036854775807L) {
            j = -9223372036854775807L;
        } else if (j < 0) {
            j += this.aes;
        }
        this.auG = j;
    }

    public final long kG() {
        return this.asL + this.aes;
    }
}
