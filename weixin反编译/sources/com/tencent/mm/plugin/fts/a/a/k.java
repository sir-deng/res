package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.y.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public final class k extends j {
    public final k f(Cursor cursor) {
        this.mRO = cursor.getLong(0);
        this.type = cursor.getInt(1);
        this.mRc = cursor.getInt(2);
        this.mRQ = cursor.getLong(3);
        this.mRd = cursor.getString(4);
        this.timestamp = cursor.getLong(5);
        this.talker = cursor.getString(6);
        return this;
    }

    public final k g(Cursor cursor) {
        this.mRO = cursor.getLong(0);
        this.type = cursor.getInt(1);
        this.mRc = cursor.getInt(2);
        this.mRQ = cursor.getLong(3);
        this.mRd = cursor.getString(4);
        this.timestamp = cursor.getLong(5);
        this.content = cursor.getString(6);
        this.mRS = cursor.getString(7);
        this.mRY = cursor.getLong(8);
        return this;
    }

    public final k h(Cursor cursor) {
        this.mRO = cursor.getLong(0);
        this.type = cursor.getInt(1);
        this.mRc = cursor.getInt(2);
        this.mRQ = cursor.getLong(3);
        this.mRd = cursor.getString(4);
        this.timestamp = cursor.getLong(5);
        if (cursor.getColumnCount() >= 7) {
            this.content = cursor.getString(6);
        }
        if (cursor.getColumnCount() >= 8) {
            this.mRS = cursor.getString(7);
        }
        return this;
    }

    private void a(Pattern pattern) {
        int i = 0;
        this.mRV = pattern.split(this.content);
        this.mRW = new int[this.mRV.length];
        int i2 = 0;
        while (i < this.mRW.length) {
            this.mRW[i] = i2;
            i2 += this.mRV[i].length() + 1;
            i++;
        }
    }

    public final void aNF() {
        if (!bi.oN(this.mRS)) {
            switch (this.type) {
                case WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT /*131072*/:
                case 131073:
                case 131074:
                case 131076:
                case 131081:
                case 262144:
                case 327680:
                    switch (this.mRc) {
                        case 2:
                        case 3:
                        case 6:
                        case 7:
                            try {
                                String[] split = a.mQi.split(this.mRS);
                                a(a.mQm);
                                this.mRT = Arrays.binarySearch(this.mRW, new String(this.content.getBytes(), 0, Integer.valueOf(split[1]).intValue()).length());
                                if (this.mRT < 0) {
                                    this.mRT = (-this.mRT) - 2;
                                }
                                this.mRU = this.mRV[this.mRT];
                                return;
                            } catch (Exception e) {
                                this.mRT = Integer.MAX_VALUE;
                                this.mRU = "";
                                return;
                            }
                        case 11:
                        case 51:
                            this.mRT = Integer.MAX_VALUE;
                            this.mRU = "";
                            return;
                        default:
                            try {
                                this.mRT = new String(this.content.getBytes(), 0, Integer.valueOf(a.mQi.split(this.mRS)[1]).intValue()).length();
                                this.mRU = this.content;
                                return;
                            } catch (Exception e2) {
                                this.mRT = Integer.MAX_VALUE;
                                this.mRU = "";
                                return;
                            }
                    }
                case 131075:
                    aNG();
                    return;
                default:
                    return;
            }
        }
    }

    private void aNG() {
        switch (this.mRc) {
            case 38:
                List arrayList = new ArrayList();
                a(a.mQj);
                String[] split = a.mQi.split(this.mRS);
                byte[] bytes = this.content.getBytes();
                for (int i = 0; i < split.length; i += 2) {
                    String str;
                    int intValue = Integer.valueOf(split[i]).intValue();
                    int length = new String(bytes, 0, Integer.valueOf(split[i + 1]).intValue()).length();
                    int binarySearch = Arrays.binarySearch(this.mRW, length);
                    if (binarySearch < 0) {
                        binarySearch = (-binarySearch) - 2;
                    }
                    String[] split2 = a.mQk.split(this.mRV[binarySearch]);
                    int i2 = length - this.mRW[binarySearch];
                    length = 0;
                    while (length < split2.length) {
                        i2 = (i2 - split2[length].length()) - 1;
                        if (i2 < 0) {
                            str = split2[length];
                            i2 = c.mQb[length];
                            if (i2 > 0) {
                                arrayList.add(new d(binarySearch, intValue, i2, str, split2[split2.length - 1]));
                            }
                        } else {
                            length++;
                        }
                    }
                    i2 = -1;
                    str = null;
                    if (i2 > 0) {
                        arrayList.add(new d(binarySearch, intValue, i2, str, split2[split2.length - 1]));
                    }
                }
                this.mRX = arrayList;
                return;
            default:
                return;
        }
    }

    public final void a(e eVar) {
        if (eVar.mRn.length > 1) {
            this.mRZ = 1;
        } else {
            this.mRZ = 0;
        }
        if (this.type == 131075) {
            if (System.currentTimeMillis() - this.timestamp < 1209600000) {
                this.mRi += 50;
                String FY = q.FY();
                if (this.mRc == 38) {
                    HashSet hashSet = new HashSet();
                    if (this.mRX != null) {
                        for (d dVar : this.mRX) {
                            if (!FY.equals(dVar.ggL)) {
                                hashSet.add(Integer.valueOf(dVar.mRe));
                            }
                        }
                    }
                    if (((long) hashSet.size()) >= this.mRQ - 1) {
                        this.mRi += 20;
                        this.mSa = true;
                    }
                    if (eVar.mRn.length > 1 && this.content.contains(eVar.mRl)) {
                        this.mRZ = 2;
                        this.mRi += 5;
                    }
                    if (this.mRQ <= 15) {
                        this.mSc = 1;
                    }
                }
                if ((this.mRc == 5 || this.mRc == 1) && this.content.contains(eVar.mRl)) {
                    if (eVar.mRn.length > 1) {
                        this.mRZ = 2;
                    }
                    this.mRi += 10;
                }
            }
        } else if (this.type == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
            if (System.currentTimeMillis() - this.timestamp < 1105032704) {
                this.mRi += 50;
            }
            if ((this.mRc == 5 || this.mRc == 1) && this.content.contains(eVar.mRl)) {
                if (eVar.mRn.length > 1) {
                    this.mRZ = 2;
                }
                this.mRi += 10;
            }
        }
    }
}
