package com.tencent.mm.plugin.appbrand.performance;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.RandomAccessFile;

public final class c {
    private final int jLF;
    private volatile RandomAccessFile jLG;
    private volatile RandomAccessFile jLH;
    private long jLI;
    private long jLJ;
    private long jLK;

    public c(int i) {
        this.jLF = i;
    }

    public final double ajZ() {
        Object e;
        double max;
        try {
            if (this.jLH == null) {
                this.jLH = new RandomAccessFile("/proc/" + this.jLF + "/stat", "r");
            }
            this.jLH.seek(0);
            String readLine = this.jLH.readLine();
            if (bi.oN(readLine)) {
                return 0.0d;
            }
            String[] split = readLine.split(" ");
            if (split.length < 17) {
                return 0.0d;
            }
            long j;
            long parseLong;
            if (this.jLG == null) {
                this.jLG = new RandomAccessFile("/proc/stat", "r");
            }
            this.jLG.seek(0);
            readLine = this.jLG.readLine();
            if (bi.oN(readLine)) {
                j = 0;
            } else {
                String[] split2 = readLine.split(" ");
                if (split2.length < 9) {
                    j = 0;
                } else {
                    j = Long.parseLong(split2[2]);
                    parseLong = Long.parseLong(split2[3]);
                    long parseLong2 = Long.parseLong(split2[4]);
                    long parseLong3 = Long.parseLong(split2[5]);
                    long parseLong4 = Long.parseLong(split2[6]);
                    long parseLong5 = Long.parseLong(split2[7]);
                    j = Long.parseLong(split2[9]) + ((((((j + parseLong) + parseLong2) + parseLong3) + parseLong4) + parseLong5) + Long.parseLong(split2[8]));
                }
            }
            parseLong = Long.parseLong(split[13]);
            long parseLong6 = Long.parseLong(split[14]);
            if (this.jLI != 0) {
                max = Math.max(0.0d, ((double) ((parseLong - this.jLJ) * 100)) / ((double) (j - this.jLI))) + Math.max(0.0d, ((double) ((parseLong6 - this.jLK) * 100)) / ((double) (j - this.jLI)));
            } else {
                max = 0.0d;
            }
            try {
                this.jLI = j;
                this.jLJ = parseLong;
                this.jLK = parseLong6;
                return max;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            max = 0.0d;
            Exception e4 = exception;
            x.e(" MicroMsg.CpuSampler", "read pid stat file error: " + e4);
            return max;
        }
    }
}
