package com.tencent.mm.plugin.bottle.ui;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.f.d.a;
import java.util.Calendar;
import java.util.Date;

final class f {
    private static final long[] kIn = new long[]{19416, 19168, 42352, 21717, 53856, 55632, 91476, 22176, 39632, 21970, 19168, 42422, 42192, 53840, 119381, 46400, 54944, 44450, 38320, 84343, 18800, 42160, 46261, 27216, 27968, 109396, 11104, 38256, 21234, 18800, 25958, 54432, 59984, 28309, 23248, 11104, 100067, 37600, 116951, 51536, 54432, 120998, 46416, 22176, 107956, 9680, 37584, 53938, 43344, 46423, 27808, 46416, 86869, 19872, 42448, 83315, 21200, 43432, 59728, 27296, 44710, 43856, 19296, 43748, 42352, 21088, 62051, 55632, 23383, 22176, 38608, 19925, 19152, 42192, 54484, 53840, 54616, 46400, 46496, 103846, 38320, 18864, 43380, 42160, 45690, 27216, 27968, 44870, 43872, 38256, 19189, 18800, 25776, 29859, 59984, 27480, 21952, 43872, 38613, 37600, 51552, 55636, 54432, 55888, 30034, 22176, 43959, 9680, 37584, 51893, 43344, 46240, 47780, 44368, 21977, 19360, 42416, 86390, 21168, 43312, 31060, 27296, 44368, 23378, 19296, 42726, 42208, 53856, 60005, 54576, 23200, 30371, 38608, 19415, 19152, 42192, 118966, 53840, 54560, 56645, 46496, 22224, 21938, 18864, 42359, 42160, 43600, 111189, 27936, 44448};
    private static final long kIq = new Date(0, 0, 31).getTime();
    public int kIo;
    public boolean kIp;
    public int month;
    public int year;

    public f() {
        this(Calendar.getInstance());
    }

    private f(Calendar calendar) {
        int time = (int) ((calendar.getTime().getTime() - kIq) / 86400000);
        int i = 1900;
        int i2 = 0;
        while (i < 2050 && time > 0) {
            i2 = nG(i);
            time -= i2;
            i++;
        }
        if (time < 0) {
            time += i2;
            i--;
        }
        this.year = i;
        int nI = nI(i);
        this.kIp = false;
        int i3 = 0;
        i = 1;
        while (true) {
            i2 = time;
            if (i < 13 && i2 > 0) {
                if (nI <= 0 || i != nI + 1 || this.kIp) {
                    time = (kIn[this.year + -1900] & ((long) (65536 >> i))) == 0 ? 29 : 30;
                } else {
                    i--;
                    this.kIp = true;
                    time = nH(this.year);
                }
                i2 -= time;
                i3 = this.kIp;
                if (i3 != 0) {
                    i3 = nI + 1;
                    if (i == i3) {
                        this.kIp = false;
                    }
                }
                i++;
            } else if (i2 == 0 || nI <= 0 || i != nI + 1) {
                time = i;
            } else if (this.kIp) {
                this.kIp = false;
                time = i;
            } else {
                this.kIp = true;
                time = i - 1;
            }
        }
        if (i2 == 0) {
        }
        time = i;
        if (i2 < 0) {
            i = i2 + i3;
            time--;
        } else {
            i = i2;
        }
        this.month = time;
        this.kIo = i + 1;
    }

    private static int nG(int i) {
        int i2 = a.CTRL_INDEX;
        for (int i3 = WXMediaMessage.THUMB_LENGTH_LIMIT; i3 > 8; i3 >>= 1) {
            if ((kIn[i - 1900] & ((long) i3)) != 0) {
                i2++;
            }
        }
        return i2 + nH(i);
    }

    private static int nH(int i) {
        if (nI(i) == 0) {
            return 0;
        }
        if ((kIn[i - 1900] & HardCoderJNI.ACTION_ALLOC_MEMORY) != 0) {
            return 30;
        }
        return 29;
    }

    private static int nI(int i) {
        return (int) (kIn[i - 1900] & 15);
    }
}
