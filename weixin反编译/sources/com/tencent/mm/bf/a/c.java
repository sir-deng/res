package com.tencent.mm.bf.a;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;

public class c {
    private static final String TAG = c.class.getSimpleName();
    public static SharedPreferences hbz = ad.cgg();
    private ag handler;
    private boolean iaK;
    private int iaL;
    private boolean iaM;
    private boolean iaN;
    private long iaO;
    private int iaP;
    private boolean iaQ;
    private a iaR;
    private com.qq.wx.voice.vad.a iaS;
    public a iaT;
    private short[] iaU;

    public interface a {
        void Vc();

        void Vd();

        void a(short[] sArr, int i);

        void uZ();
    }

    public static String Vh() {
        return String.format(Locale.CHINA, "%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s", new Object[]{"sil_time", Integer.valueOf(hbz.getInt("sil_time", 500)), "s_n_ration", Float.valueOf(hbz.getFloat("s_n_ration", 2.5f)), "s_window", Integer.valueOf(hbz.getInt("s_window", 500)), "s_length", Integer.valueOf(hbz.getInt("s_length", 350)), "s_delay_time", Integer.valueOf(hbz.getInt("s_delay_time", 550))});
    }

    public c() {
        this(3500, 16000, hbz.getInt("sil_time", 1000), hbz.getFloat("s_n_ration", 2.5f), hbz.getInt("s_window", 500), hbz.getInt("s_length", 350), hbz.getInt("s_delay_time", 550), true, true);
    }

    public c(int i, int i2, int i3, float f, int i4, int i5, int i6, boolean z, boolean z2) {
        this.iaK = true;
        this.iaL = 3;
        this.iaM = false;
        this.iaN = false;
        this.iaO = 0;
        this.iaP = 3500;
        this.iaQ = false;
        this.handler = new ag(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                if (message.what == 0 && c.this.iaT != null) {
                    c.this.iaT.uZ();
                }
            }
        };
        this.iaR = null;
        this.iaS = null;
        this.iaP = i;
        this.iaS = new com.qq.wx.voice.vad.a();
        int i7 = 0;
        if (ad.cgj()) {
            com.tencent.mm.storage.c fp = com.tencent.mm.y.c.c.IL().fp("100235");
            if (fp.isValid()) {
                i7 = bi.getInt((String) fp.civ().get("MMVoipVadOn"), 0);
            }
        }
        x.i(TAG, "VoiceSilentDetectAPI: abTestFlag = [%s]", Integer.valueOf(i7));
        if (i7 == 0) {
            com.qq.wx.voice.vad.a.ax(false);
        } else {
            com.qq.wx.voice.vad.a.ax(true);
        }
        com.qq.wx.voice.vad.a aVar = this.iaS;
        if (com.qq.wx.voice.vad.a.bgz) {
            aVar.bgw = aVar.bgy.Init(16000, i3, f, i4, i5);
        } else {
            aVar.bgw = aVar.bgx.Init(16000, i3, f, i4, i5);
        }
        if (com.qq.wx.voice.vad.a.DEBUG) {
            System.out.println("EVad Init handle = " + aVar.bgw);
        }
        if ((aVar.bgw == 0 ? 1 : 0) != 1) {
            com.qq.wx.voice.vad.a aVar2 = this.iaS;
            if (aVar2.bgw == 0) {
                i7 = 1;
            } else {
                if (com.qq.wx.voice.vad.a.DEBUG) {
                    System.out.println("EVad Reset handle = " + aVar2.bgw);
                }
                i7 = com.qq.wx.voice.vad.a.bgz ? aVar2.bgy.Reset(aVar2.bgw) : aVar2.bgx.Reset(aVar2.bgw);
            }
            if (i7 != 1) {
                this.iaR = new a(i6 * 16);
                this.iaU = new short[4000];
                this.handler.removeMessages(0);
                this.handler.sendEmptyMessageDelayed(0, (long) i);
                this.iaM = z;
                this.iaN = z2;
                return;
            }
        }
        throw new b("Init ERROR");
    }

    public final void c(short[] sArr, int i) {
        x.d(TAG, "input() called with: voice = [%s], length = [%s]", sArr, Integer.valueOf(i));
        if (sArr != null && sArr.length != 0 && i > 0 && i <= sArr.length) {
            if (this.iaQ) {
                x.i(TAG, "VoiceSilentDetectAPI is released.");
                return;
            }
            int i2;
            int length;
            int i3;
            com.qq.wx.voice.vad.a aVar = this.iaS;
            if (aVar.bgw == 0) {
                i2 = 1;
            } else {
                if (com.qq.wx.voice.vad.a.DEBUG) {
                    System.out.println("EVad AddData handle = " + aVar.bgw);
                }
                i2 = com.qq.wx.voice.vad.a.bgz ? aVar.bgy.AddData(aVar.bgw, sArr, i) : aVar.bgx.AddData(aVar.bgw, sArr, i);
            }
            x.d(TAG, "currState = %s,prevState = %s,directFirstStart = %s,directTempState = %s", Integer.valueOf(i2), Integer.valueOf(this.iaL), Boolean.valueOf(this.iaM), Boolean.valueOf(this.iaN));
            long currentTimeMillis;
            int i4;
            if (this.iaM) {
                if (this.iaN) {
                    currentTimeMillis = System.currentTimeMillis();
                    if (this.iaT != null) {
                        this.iaT.Vd();
                    }
                    this.iaO = currentTimeMillis;
                    if (!this.iaQ) {
                        i4 = this.iaR.iaI;
                        length = this.iaU.length;
                        while (i4 > 0) {
                            if (length > i4) {
                                i3 = i4;
                            } else {
                                i3 = length;
                            }
                            this.iaR.b(this.iaU, i3);
                            i4 -= i3;
                            if (this.iaT != null) {
                                this.iaT.a(this.iaU, i3);
                            }
                        }
                        this.iaN = false;
                        this.handler.removeMessages(0);
                        this.handler.sendEmptyMessageDelayed(0, (long) this.iaP);
                    } else {
                        return;
                    }
                }
                if (this.iaL == 3 && i2 == 2) {
                    this.iaM = false;
                }
                if (!(this.iaL == 3 && i2 == 3)) {
                    this.handler.removeMessages(0);
                    this.handler.sendEmptyMessageDelayed(0, (long) this.iaP);
                }
                this.iaK = false;
                this.iaL = i2;
            } else if (this.iaL == 3 && i2 == 2) {
                this.iaL = i2;
                this.handler.removeMessages(0);
                this.handler.sendEmptyMessageDelayed(0, (long) this.iaP);
                currentTimeMillis = System.currentTimeMillis();
                if (this.iaT != null) {
                    this.iaT.Vd();
                }
                this.iaO = currentTimeMillis;
                if (!this.iaQ) {
                    i3 = this.iaR.iaI;
                    i4 = this.iaU.length;
                    while (i3 > 0) {
                        if (i4 > i3) {
                            i2 = i3;
                        } else {
                            i2 = i4;
                        }
                        this.iaR.b(this.iaU, i2);
                        i3 -= i2;
                        if (this.iaT != null) {
                            this.iaT.a(this.iaU, i2);
                        }
                    }
                    this.iaK = false;
                } else {
                    return;
                }
            } else if (this.iaL == 2 && i2 == 3) {
                this.iaL = i2;
                this.iaK = true;
                this.handler.removeMessages(0);
                this.handler.sendEmptyMessageDelayed(0, (long) this.iaP);
                currentTimeMillis = System.currentTimeMillis();
                if (this.iaT != null) {
                    this.iaT.Vc();
                }
                this.iaO = currentTimeMillis;
                if (this.iaQ) {
                    return;
                }
            } else if (this.iaL == 3 && i2 == 3) {
                this.iaK = true;
            } else if (this.iaL == 2 && i2 == 2) {
                this.iaK = false;
                this.handler.removeMessages(0);
                this.handler.sendEmptyMessageDelayed(0, (long) this.iaP);
            }
            if (!this.iaQ) {
                a aVar2 = this.iaR;
                if (sArr.length >= 0) {
                    i3 = i > sArr.length + 0 ? sArr.length + 0 : i;
                    if (i3 != 0) {
                        i2 = aVar2.iaJ.length - aVar2.iaI;
                        if (i3 > i2) {
                            i2 = i3 - i2;
                            if (i2 != 0) {
                                if (i2 >= aVar2.iaI) {
                                    i2 = aVar2.iaI;
                                }
                                if (i2 <= aVar2.iaJ.length - aVar2.iaG) {
                                    aVar2.iaG += i2;
                                    if (aVar2.iaG >= aVar2.iaJ.length) {
                                        aVar2.iaG = 0;
                                    }
                                } else {
                                    aVar2.iaG = i2 - (aVar2.iaJ.length - aVar2.iaG);
                                }
                                aVar2.iaI -= i2;
                            }
                        }
                        if (i3 > aVar2.iaJ.length) {
                            i3 = (i3 - aVar2.iaJ.length) + 0;
                            i2 = aVar2.iaJ.length;
                        } else {
                            i2 = i3;
                            i3 = 0;
                        }
                        if (i2 <= aVar2.iaJ.length - aVar2.iaH) {
                            System.arraycopy(sArr, i3, aVar2.iaJ, aVar2.iaH, i2);
                            aVar2.iaH += i2;
                            if (aVar2.iaH >= aVar2.iaJ.length) {
                                aVar2.iaH = 0;
                            }
                        } else {
                            length = aVar2.iaJ.length - aVar2.iaH;
                            System.arraycopy(sArr, i3, aVar2.iaJ, aVar2.iaH, length);
                            int i5 = i2 - length;
                            System.arraycopy(sArr, i3 + length, aVar2.iaJ, 0, i5);
                            aVar2.iaH = i5;
                        }
                        aVar2.iaI = i2 + aVar2.iaI;
                    }
                }
                x.d(TAG, "isSilent %s", Boolean.valueOf(this.iaK));
                if (!this.iaK && this.iaT != null) {
                    this.iaT.a(sArr, i);
                }
            }
        }
    }

    public final void release() {
        x.d(TAG, "released");
        this.iaQ = true;
        this.iaM = false;
        this.iaN = false;
        if (this.iaS != null) {
            int i;
            com.qq.wx.voice.vad.a aVar = this.iaS;
            if (aVar.bgw == 0) {
                i = 1;
            } else {
                if (com.qq.wx.voice.vad.a.DEBUG) {
                    System.out.println("EVad Release handle = " + aVar.bgw);
                }
                i = com.qq.wx.voice.vad.a.bgz ? aVar.bgy.Release(aVar.bgw) : aVar.bgx.Release(aVar.bgw);
            }
            if (i == 1) {
                throw new b();
            }
            this.iaS = null;
        }
        this.iaR = null;
        this.iaU = null;
        if (this.handler != null) {
            this.handler.removeMessages(0);
            this.handler = null;
        }
        this.iaT = null;
    }
}
