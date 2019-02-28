package com.tencent.mm.compatible.e;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public final class p {
    private RandomAccessFile gHu;
    private RandomAccessFile gHv;
    private a gHw;
    private ArrayList<a> gHx;
    private long pid = 0;

    public class a {
        long gHA;
        long gHB;
        int gHC;
        int gHy;
        long gHz;
        long mLastIdle;

        public a() {
            this.gHy = 0;
            this.gHz = 0;
            this.mLastIdle = 0;
            this.gHA = 0;
            this.gHB = 0;
            this.gHC = 0;
        }

        public a(long j) {
            this.gHA = j;
        }

        public final void a(String[] strArr, String str) {
            if (this.gHA <= 0) {
                e(strArr);
                return;
            }
            if (str != null && str.length() > 0) {
                String[] split = str.split("[ ]+");
                if (split != null && split.length > 0 && split[0] != null && Long.parseLong(split[0], 10) == this.gHA) {
                    long parseLong = Long.parseLong(split[13], 10);
                    long parseLong2 = Long.parseLong(split[14], 10);
                    long parseLong3 = ((parseLong + parseLong2) + Long.parseLong(split[15], 10)) + Long.parseLong(split[16], 10);
                    long parseLong4 = Long.parseLong(strArr[4], 10);
                    Object obj = 1;
                    long j = 0;
                    for (String str2 : strArr) {
                        if (obj != null) {
                            obj = null;
                        } else {
                            j += Long.parseLong(str2, 10);
                        }
                    }
                    long j2 = j - this.gHz;
                    long j3 = parseLong3 - this.gHB;
                    this.gHy = (int) ((((float) (j2 - (parseLong4 - this.mLastIdle))) / ((float) j2)) * 100.0f);
                    this.gHC = (int) ((((float) j3) / ((float) j2)) * 100.0f);
                    this.gHz = j;
                    this.mLastIdle = parseLong4;
                    this.gHB = parseLong3;
                    x.i(" MicroMsg.CpuUsage", "CpuUsageInfo(%d) CPU total=%d idle=%d usage=%d pid=%d pidTotal=%d mPidUsage=%d [%d, %d, %d, %d], [%d, %d, %d]", Integer.valueOf(hashCode()), Long.valueOf(j), Long.valueOf(parseLong4), Integer.valueOf(this.gHy), Long.valueOf(this.gHA), Long.valueOf(parseLong3), Integer.valueOf(this.gHC), Long.valueOf(parseLong), Long.valueOf(parseLong2), Long.valueOf(r12), Long.valueOf(r14), Long.valueOf(j2), Long.valueOf(r6), Long.valueOf(j3));
                    return;
                }
            }
            x.e(" MicroMsg.CpuUsage", "update but pid not match[%d, %s] update nothing", Long.valueOf(this.gHA), str);
        }

        public final void e(String[] strArr) {
            long parseLong = Long.parseLong(strArr[4], 10);
            long j = 0;
            Object obj = 1;
            for (String str : strArr) {
                if (obj != null) {
                    obj = null;
                } else {
                    j += Long.parseLong(str, 10);
                }
            }
            long j2 = j - this.gHz;
            this.gHy = (int) ((((float) (j2 - (parseLong - this.mLastIdle))) / ((float) j2)) * 100.0f);
            this.gHz = j;
            this.mLastIdle = parseLong;
            x.i(" MicroMsg.CpuUsage", "CpuUsageInfo(" + hashCode() + ") CPU total=" + j + "; idle=" + parseLong + "; usage=" + this.gHy);
        }
    }

    public p(long j) {
        this.pid = j;
    }

    private void update() {
        try {
            this.gHu = new RandomAccessFile("/proc/stat", "r");
            if (this.pid > 0) {
                this.gHv = new RandomAccessFile("/proc/" + this.pid + "/stat", "r");
            }
            yH();
            if (this.gHu != null) {
                this.gHu.close();
            }
            if (this.gHv != null) {
                this.gHv.close();
            }
        } catch (Throwable e) {
            x.printErrStackTrace(" MicroMsg.CpuUsage", e, "update e:", new Object[0]);
            if (this.gHu != null) {
                try {
                    this.gHu.close();
                } catch (Exception e2) {
                }
                this.gHu = null;
            }
            if (this.gHv != null) {
                try {
                    this.gHv.close();
                } catch (Exception e3) {
                }
                this.gHv = null;
            }
        }
    }

    private void yH() {
        String readLine;
        int i;
        String readLine2;
        int i2;
        String str = null;
        if (this.gHv != null) {
            try {
                this.gHv.seek(0);
                readLine = this.gHv.readLine();
            } catch (IOException e) {
                x.e(" MicroMsg.CpuUsage", "Ops pidStatFile: " + e);
            }
            if (this.gHu != null) {
                this.gHu.seek(0);
                i = -1;
                while (true) {
                    readLine2 = this.gHu.readLine();
                    if (readLine2 != null || readLine2.length() <= 0) {
                        x.e(" MicroMsg.CpuUsage", "unable to get cpu line cpuId[%d]", Integer.valueOf(i));
                    } else {
                        String[] split = readLine2.split("[ ]+");
                        if (split[0].indexOf("cpu") != -1) {
                            if (i == -1) {
                                if (this.gHw == null) {
                                    this.gHw = new a(this.pid);
                                }
                                this.gHw.a(split, readLine);
                            } else {
                                try {
                                    if (this.gHx == null) {
                                        this.gHx = new ArrayList();
                                    }
                                    if (i < this.gHx.size()) {
                                        ((a) this.gHx.get(i)).e(split);
                                    } else {
                                        a aVar = new a();
                                        aVar.e(split);
                                        this.gHx.add(aVar);
                                    }
                                } catch (IOException e2) {
                                    x.e(" MicroMsg.CpuUsage", "Ops statFile: " + e2);
                                    return;
                                }
                            }
                        }
                    }
                    i2 = i + 1;
                    if (readLine2 == null) {
                        i = i2;
                    } else {
                        return;
                    }
                }
            }
        }
        readLine = str;
        if (this.gHu != null) {
            this.gHu.seek(0);
            i = -1;
            while (true) {
                readLine2 = this.gHu.readLine();
                if (readLine2 != null) {
                }
                x.e(" MicroMsg.CpuUsage", "unable to get cpu line cpuId[%d]", Integer.valueOf(i));
                i2 = i + 1;
                if (readLine2 == null) {
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }

    public final int yI() {
        return bi.cC(this.gHx) ? 1 : this.gHx.size();
    }

    public final int yJ() {
        update();
        return this.gHw != null ? this.gHw.gHy : 0;
    }

    public final int yK() {
        int i = 0;
        if (this.gHw != null) {
            i = this.gHw.gHC;
        }
        if (this.gHx == null || this.gHx.size() <= 1) {
            return i;
        }
        return i * this.gHx.size();
    }

    public final String toString() {
        update();
        StringBuffer stringBuffer = new StringBuffer();
        if (this.gHw != null) {
            stringBuffer.append("Cpu Total : ");
            stringBuffer.append(this.gHw.gHy);
            stringBuffer.append("%");
            if (this.pid > 0) {
                stringBuffer.append("pid(");
                stringBuffer.append(this.pid + ") :");
                stringBuffer.append(this.gHw.gHC);
                stringBuffer.append("%");
            }
        }
        if (this.gHx != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gHx.size()) {
                    break;
                }
                a aVar = (a) this.gHx.get(i2);
                stringBuffer.append(" Cpu Core(" + i2 + ") : ");
                stringBuffer.append(aVar.gHy);
                stringBuffer.append("%");
                i = i2 + 1;
            }
        }
        return stringBuffer.toString();
    }
}
