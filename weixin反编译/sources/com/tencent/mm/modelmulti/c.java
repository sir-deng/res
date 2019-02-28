package com.tencent.mm.modelmulti;

import java.util.ArrayList;

public interface c {

    public static class b {
        long fileLenInvalidCount;
        long fxb;
        final String hGD;
        long hGE;
        long hGF;
        boolean hGJ = false;
        final int tag;

        b(String str, int i) {
            this.hGD = str;
            this.tag = i;
        }

        public final String toString() {
            return String.format("SubDirResult hash(%d) root[%d][%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.tag), this.hGD, Boolean.valueOf(this.hGJ), Long.valueOf(this.hGE), Long.valueOf(this.hGF), Long.valueOf(this.fxb), Long.valueOf(this.fileLenInvalidCount)});
        }
    }

    public static class c {
        long fxb;
        final String hGD;
        long hGE;
        long hGF;
        boolean hGJ = false;
        long hGK;

        c(String str) {
            this.hGD = str;
        }

        public final String toString() {
            return String.format("TempAccDirResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvaildCount[%d]", new Object[]{Integer.valueOf(hashCode()), this.hGD, Boolean.valueOf(this.hGJ), Long.valueOf(this.hGE), Long.valueOf(this.hGF), Long.valueOf(this.fxb), Long.valueOf(this.hGK)});
        }
    }

    public static class a {
        int axZ;
        long fileLenInvalidCount;
        long fxb;
        final String hGD;
        long hGE;
        long hGF;
        long hGG;
        ArrayList<b> hGH = new ArrayList(20);
        ArrayList<c> hGI = new ArrayList(20);
        boolean hGJ = false;

        a(String str) {
            this.hGD = str;
        }

        public final String toString() {
            return String.format("FileResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d], subDirResult[%d], tempAccDirResult[%d], totalTime[%d], depth[%d]", new Object[]{Integer.valueOf(hashCode()), this.hGD, Boolean.valueOf(this.hGJ), Long.valueOf(this.hGE), Long.valueOf(this.hGF), Long.valueOf(this.fxb), Long.valueOf(this.fileLenInvalidCount), Integer.valueOf(this.hGH.size()), Integer.valueOf(this.hGI.size()), Long.valueOf(this.hGG), Integer.valueOf(this.axZ)});
        }
    }

    void a(int i, a aVar);
}
