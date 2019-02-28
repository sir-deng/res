package com.tencent.mm.plugin.backup.a;

public final class f {

    public static class a {
        public long endTime;
        public int koA;
        public String koz;
        public long startTime;

        public a(int i, String str, long j, long j2) {
            this.koA = i;
            this.koz = str;
            this.startTime = j;
            this.endTime = j2;
        }
    }

    public static class b implements Cloneable, Comparable<b> {
        public String koB;
        public long koC = 0;
        public long koD = 0;
        public long koE = -1;
        public long koF = -1;

        public final /* synthetic */ Object clone() {
            return apb();
        }

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            b bVar = (b) obj;
            if (this.koE < bVar.koE) {
                return 1;
            }
            return this.koE > bVar.koE ? -1 : 0;
        }

        public final b apb() {
            b bVar = new b();
            bVar.koB = this.koB;
            bVar.koC = this.koC;
            bVar.koD = this.koD;
            bVar.koE = this.koE;
            bVar.koF = this.koF;
            return bVar;
        }
    }
}
