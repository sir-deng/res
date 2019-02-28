package com.google.android.exoplayer2.f.a;

import android.graphics.Color;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.j;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.map.e;
import com.tencent.mm.plugin.appbrand.jsapi.share.f;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.xwalk.core.R;

public final class c extends d {
    private final i awN = new i();
    private final int awO;
    private final a[] awP;
    private a awQ;
    private b awR;
    private int awS;
    private final j awt = new j();
    private List<com.google.android.exoplayer2.f.a> awy;
    private List<com.google.android.exoplayer2.f.a> awz;

    private static final class b {
        public final int axr;
        public final int axs;
        public final byte[] axt;
        int currentIndex = 0;

        public b(int i, int i2) {
            this.axr = i;
            this.axs = i2;
            this.axt = new byte[((i2 * 2) - 1)];
        }
    }

    private static final class a {
        public static final int awT = g(2, 2, 2, 0);
        public static final int awU = g(0, 0, 0, 0);
        public static final int awV = g(0, 0, 0, 3);
        static final int[] awW = new int[]{0, 0, 0, 0, 0, 2, 0};
        private static final int[] awX = new int[]{0, 0, 0, 0, 0, 0, 2};
        private static final int[] awY = new int[]{3, 3, 3, 3, 3, 3, 1};
        private static final boolean[] awZ = new boolean[]{false, false, false, true, true, true, false};
        static final int[] axa = new int[]{awU, awV, awU, awU, awV, awU, awU};
        private static final int[] axb = new int[]{0, 1, 2, 3, 4, 3, 4};
        private static final int[] axc = new int[]{0, 0, 0, 0, 0, 3, 3};
        static final int[] axd = new int[]{awU, awU, awU, awU, awU, awV, awV};
        final List<SpannableString> awH = new LinkedList();
        final SpannableStringBuilder awI = new SpannableStringBuilder();
        private int awK;
        boolean axe;
        boolean axf;
        int axg;
        int axh;
        int axi;
        boolean axj;
        private int axk;
        int axl;
        int axm;
        private int axn;
        private int axo;
        private int axp;
        private int axq;
        private int backgroundColor;
        private int foregroundColor;
        int priority;
        int row;
        int rowCount;
        boolean visible;

        public a() {
            reset();
        }

        public final boolean isEmpty() {
            return !this.axe || (this.awH.isEmpty() && this.awI.length() == 0);
        }

        public final void reset() {
            clear();
            this.axe = false;
            this.visible = false;
            this.priority = 4;
            this.axf = false;
            this.axg = 0;
            this.axh = 0;
            this.axi = 0;
            this.rowCount = 15;
            this.axj = true;
            this.axk = 0;
            this.axl = 0;
            this.axm = 0;
            this.axn = awU;
            this.foregroundColor = awT;
            this.backgroundColor = awU;
        }

        public final void clear() {
            this.awH.clear();
            this.awI.clear();
            this.axo = -1;
            this.awK = -1;
            this.axp = -1;
            this.axq = -1;
            this.row = 0;
        }

        public final void ap(int i, int i2) {
            this.axn = i;
            this.axk = i2;
        }

        public final void e(boolean z, boolean z2) {
            if (this.axo != -1) {
                if (!z) {
                    this.awI.setSpan(new StyleSpan(2), this.axo, this.awI.length(), 33);
                    this.axo = -1;
                }
            } else if (z) {
                this.axo = this.awI.length();
            }
            if (this.awK != -1) {
                if (!z2) {
                    this.awI.setSpan(new UnderlineSpan(), this.awK, this.awI.length(), 33);
                    this.awK = -1;
                }
            } else if (z2) {
                this.awK = this.awI.length();
            }
        }

        public final void aq(int i, int i2) {
            if (!(this.axp == -1 || this.foregroundColor == i)) {
                this.awI.setSpan(new ForegroundColorSpan(this.foregroundColor), this.axp, this.awI.length(), 33);
            }
            if (i != awT) {
                this.axp = this.awI.length();
                this.foregroundColor = i;
            }
            if (!(this.axq == -1 || this.backgroundColor == i2)) {
                this.awI.setSpan(new BackgroundColorSpan(this.backgroundColor), this.axq, this.awI.length(), 33);
            }
            if (i2 != awU) {
                this.axq = this.awI.length();
                this.backgroundColor = i2;
            }
        }

        public final void append(char c) {
            if (c == 10) {
                this.awH.add(kX());
                this.awI.clear();
                if (this.axo != -1) {
                    this.axo = 0;
                }
                if (this.awK != -1) {
                    this.awK = 0;
                }
                if (this.axp != -1) {
                    this.axp = 0;
                }
                if (this.axq != -1) {
                    this.axq = 0;
                }
                while (true) {
                    if ((this.axj && this.awH.size() >= this.rowCount) || this.awH.size() >= 15) {
                        this.awH.remove(0);
                    } else {
                        return;
                    }
                }
            }
            this.awI.append(c);
        }

        private SpannableString kX() {
            CharSequence spannableStringBuilder = new SpannableStringBuilder(this.awI);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.axo != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.axo, length, 33);
                }
                if (this.awK != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.awK, length, 33);
                }
                if (this.axp != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.foregroundColor), this.axp, length, 33);
                }
                if (this.axq != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), this.axq, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public final b la() {
            boolean z = false;
            if (isEmpty()) {
                return null;
            }
            Alignment alignment;
            float f;
            float f2;
            int i;
            int i2;
            CharSequence spannableStringBuilder = new SpannableStringBuilder();
            for (int i3 = 0; i3 < this.awH.size(); i3++) {
                spannableStringBuilder.append((CharSequence) this.awH.get(i3));
                spannableStringBuilder.append(10);
            }
            spannableStringBuilder.append(kX());
            switch (this.axk) {
                case 0:
                case 3:
                    alignment = Alignment.ALIGN_NORMAL;
                    break;
                case 1:
                    alignment = Alignment.ALIGN_OPPOSITE;
                    break;
                case 2:
                    alignment = Alignment.ALIGN_CENTER;
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected justification value: " + this.axk);
            }
            if (this.axf) {
                f = ((float) this.axh) / 99.0f;
                f2 = ((float) this.axg) / 99.0f;
            } else {
                f = ((float) this.axh) / 209.0f;
                f2 = ((float) this.axg) / 74.0f;
            }
            float f3 = (f * 0.9f) + 0.05f;
            f = (f2 * 0.9f) + 0.05f;
            if (this.axi % 3 == 0) {
                i = 0;
            } else if (this.axi % 3 == 1) {
                i = 1;
            } else {
                i = 2;
            }
            if (this.axi / 3 == 0) {
                i2 = 0;
            } else if (this.axi / 3 == 1) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            if (this.axn != awU) {
                z = true;
            }
            return new b(spannableStringBuilder, alignment, f, i, f3, i2, z, this.axn, this.priority);
        }

        public static int s(int i, int i2, int i3) {
            return g(i, i2, i3, 0);
        }

        public static int g(int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            int i7;
            int i8 = 255;
            com.google.android.exoplayer2.i.a.as(i, 4);
            com.google.android.exoplayer2.i.a.as(i2, 4);
            com.google.android.exoplayer2.i.a.as(i3, 4);
            com.google.android.exoplayer2.i.a.as(i4, 4);
            switch (i4) {
                case 0:
                case 1:
                    i5 = 255;
                    break;
                case 2:
                    i5 = 127;
                    break;
                case 3:
                    i5 = 0;
                    break;
                default:
                    i5 = 255;
                    break;
            }
            if (i > 1) {
                i6 = 255;
            } else {
                i6 = 0;
            }
            if (i2 > 1) {
                i7 = 255;
            } else {
                i7 = 0;
            }
            if (i3 <= 1) {
                i8 = 0;
            }
            return Color.argb(i5, i6, i7, i8);
        }
    }

    public final /* bridge */ /* synthetic */ void K(long j) {
        super.K(j);
    }

    public final /* bridge */ /* synthetic */ void b(h hVar) {
        super.b(hVar);
    }

    public final /* bridge */ /* synthetic */ com.google.android.exoplayer2.f.i kT() {
        return super.kT();
    }

    public final /* bridge */ /* synthetic */ h kU() {
        return super.kU();
    }

    public final /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    public c(int i) {
        if (i == -1) {
            i = 1;
        }
        this.awO = i;
        this.awP = new a[8];
        for (int i2 = 0; i2 < 8; i2++) {
            this.awP[i2] = new a();
        }
        this.awQ = this.awP[0];
        kS();
    }

    public final void flush() {
        super.flush();
        this.awy = null;
        this.awz = null;
        this.awS = 0;
        this.awQ = this.awP[this.awS];
        kS();
        this.awR = null;
    }

    protected final boolean kP() {
        return this.awy != this.awz;
    }

    protected final d kQ() {
        this.awz = this.awy;
        return new f(this.awy);
    }

    protected final void a(h hVar) {
        this.awt.l(hVar.aif.array(), hVar.aif.limit());
        while (this.awt.lG() >= 3) {
            int readUnsignedByte = this.awt.readUnsignedByte() & 7;
            int i = readUnsignedByte & 3;
            Object obj = (readUnsignedByte & 4) == 4 ? 1 : null;
            byte readUnsignedByte2 = (byte) this.awt.readUnsignedByte();
            byte readUnsignedByte3 = (byte) this.awt.readUnsignedByte();
            if ((i == 2 || i == 3) && obj != null) {
                byte[] bArr;
                b bVar;
                int i2;
                if (i == 3) {
                    kZ();
                    i = (readUnsignedByte2 & ar.CTRL_INDEX) >> 6;
                    readUnsignedByte = readUnsignedByte2 & 63;
                    if (readUnsignedByte == 0) {
                        readUnsignedByte = 64;
                    }
                    this.awR = new b(i, readUnsignedByte);
                    bArr = this.awR.axt;
                    bVar = this.awR;
                    i2 = bVar.currentIndex;
                    bVar.currentIndex = i2 + 1;
                    bArr[i2] = readUnsignedByte3;
                } else {
                    com.google.android.exoplayer2.i.a.ao(i == 2);
                    if (this.awR != null) {
                        bArr = this.awR.axt;
                        bVar = this.awR;
                        int i3 = bVar.currentIndex;
                        bVar.currentIndex = i3 + 1;
                        bArr[i3] = readUnsignedByte2;
                        bArr = this.awR.axt;
                        bVar = this.awR;
                        i2 = bVar.currentIndex;
                        bVar.currentIndex = i2 + 1;
                        bArr[i2] = readUnsignedByte3;
                    }
                }
                if (this.awR.currentIndex == (this.awR.axs * 2) - 1) {
                    kZ();
                }
            }
        }
    }

    private void kZ() {
        if (this.awR != null) {
            if (this.awR.currentIndex != (this.awR.axs * 2) - 1) {
                new StringBuilder("DtvCcPacket ended prematurely; size is ").append((this.awR.axs * 2) - 1).append(", but current index is ").append(this.awR.currentIndex).append(" (sequence number ").append(this.awR.axr).append("); ignoring packet");
            } else {
                this.awN.l(this.awR.axt, this.awR.currentIndex);
                int cT = this.awN.cT(3);
                int cT2 = this.awN.cT(5);
                if (cT == 7) {
                    this.awN.cS(2);
                    cT += this.awN.cT(6);
                }
                if (cT2 == 0) {
                    if (cT != 0) {
                        new StringBuilder("serviceNumber is non-zero (").append(cT).append(") when blockSize is 0");
                    }
                } else if (cT == this.awO) {
                    Object obj = null;
                    while (this.awN.lB() > 0) {
                        cT2 = this.awN.cT(8);
                        if (cT2 == 16) {
                            cT2 = this.awN.cT(8);
                            if (cT2 <= 31) {
                                if (cT2 > 7) {
                                    if (cT2 <= 15) {
                                        this.awN.cS(8);
                                    } else if (cT2 <= 23) {
                                        this.awN.cS(16);
                                    } else if (cT2 <= 31) {
                                        this.awN.cS(24);
                                    }
                                }
                            } else if (cT2 <= 127) {
                                switch (cT2) {
                                    case 32:
                                        this.awQ.append(' ');
                                        break;
                                    case 33:
                                        this.awQ.append(160);
                                        break;
                                    case 37:
                                        this.awQ.append(8230);
                                        break;
                                    case R.styleable.AppCompatTheme_dialogTheme /*42*/:
                                        this.awQ.append(352);
                                        break;
                                    case R.styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                                        this.awQ.append(338);
                                        break;
                                    case R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                                        this.awQ.append(9608);
                                        break;
                                    case R.styleable.AppCompatTheme_actionButtonStyle /*49*/:
                                        this.awQ.append(8216);
                                        break;
                                    case 50:
                                        this.awQ.append(8217);
                                        break;
                                    case 51:
                                        this.awQ.append(8220);
                                        break;
                                    case 52:
                                        this.awQ.append(8221);
                                        break;
                                    case 53:
                                        this.awQ.append(8226);
                                        break;
                                    case 57:
                                        this.awQ.append(8482);
                                        break;
                                    case 58:
                                        this.awQ.append(353);
                                        break;
                                    case 60:
                                        this.awQ.append(339);
                                        break;
                                    case 61:
                                        this.awQ.append(8480);
                                        break;
                                    case 63:
                                        this.awQ.append(376);
                                        break;
                                    case 118:
                                        this.awQ.append(8539);
                                        break;
                                    case 119:
                                        this.awQ.append(8540);
                                        break;
                                    case 120:
                                        this.awQ.append(8541);
                                        break;
                                    case 121:
                                        this.awQ.append(8542);
                                        break;
                                    case 122:
                                        this.awQ.append(9474);
                                        break;
                                    case 123:
                                        this.awQ.append(9488);
                                        break;
                                    case 124:
                                        this.awQ.append(9492);
                                        break;
                                    case 125:
                                        this.awQ.append(9472);
                                        break;
                                    case 126:
                                        this.awQ.append(9496);
                                        break;
                                    case 127:
                                        this.awQ.append(9484);
                                        break;
                                }
                                obj = 1;
                            } else if (cT2 <= JsApiGetBackgroundAudioState.CTRL_INDEX) {
                                if (cT2 <= com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX) {
                                    this.awN.cS(32);
                                } else if (cT2 <= 143) {
                                    this.awN.cS(40);
                                } else if (cT2 <= JsApiGetBackgroundAudioState.CTRL_INDEX) {
                                    this.awN.cS(2);
                                    this.awN.cS(this.awN.cT(6) * 8);
                                }
                            } else if (cT2 <= 255) {
                                if (cT2 == JsApiSetBackgroundAudioState.CTRL_INDEX) {
                                    this.awQ.append(13252);
                                } else {
                                    this.awQ.append('_');
                                }
                                obj = 1;
                            }
                        } else if (cT2 <= 31) {
                            switch (cT2) {
                                case 0:
                                case 14:
                                    break;
                                case 3:
                                    this.awy = kR();
                                    break;
                                case 8:
                                    a aVar = this.awQ;
                                    int length = aVar.awI.length();
                                    if (length <= 0) {
                                        break;
                                    }
                                    aVar.awI.delete(length - 1, length);
                                    break;
                                case 12:
                                    kS();
                                    break;
                                case 13:
                                    this.awQ.append(10);
                                    break;
                                default:
                                    if (cT2 < 17 || cT2 > 23) {
                                        if (cT2 >= 24 && cT2 <= 31) {
                                            this.awN.cS(16);
                                            break;
                                        }
                                    }
                                    this.awN.cS(8);
                                    break;
                                    break;
                            }
                        } else if (cT2 <= 127) {
                            if (cT2 == 127) {
                                this.awQ.append(9835);
                            } else {
                                this.awQ.append((char) (cT2 & 255));
                            }
                            obj = 1;
                        } else if (cT2 <= JsApiGetBackgroundAudioState.CTRL_INDEX) {
                            cJ(cT2);
                            obj = 1;
                        } else if (cT2 <= 255) {
                            this.awQ.append((char) (cT2 & 255));
                            obj = 1;
                        }
                    }
                    if (obj != null) {
                        this.awy = kR();
                    }
                }
            }
            this.awR = null;
        }
    }

    private void cJ(int i) {
        int i2;
        int i3;
        a aVar;
        switch (i) {
            case FileUtils.S_IWUSR /*128*/:
            case 129:
            case 130:
            case 131:
            case 132:
            case com.tencent.mm.plugin.appbrand.jsapi.map.d.CTRL_INDEX /*133*/:
            case com.tencent.mm.plugin.appbrand.jsapi.map.c.CTRL_INDEX /*134*/:
            case com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX /*135*/:
                i2 = i - 128;
                if (this.awS != i2) {
                    this.awS = i2;
                    this.awQ = this.awP[i2];
                    return;
                }
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.map.h.CTRL_INDEX /*136*/:
                for (i2 = 1; i2 <= 8; i2++) {
                    if (this.awN.lD()) {
                        this.awP[8 - i2].clear();
                    }
                }
                return;
            case 137:
                for (i2 = 1; i2 <= 8; i2++) {
                    if (this.awN.lD()) {
                        this.awP[8 - i2].visible = true;
                    }
                }
                return;
            case 138:
                for (i2 = 1; i2 <= 8; i2++) {
                    if (this.awN.lD()) {
                        this.awP[8 - i2].visible = false;
                    }
                }
                return;
            case v.CTRL_INDEX /*139*/:
                i2 = 1;
                while (true) {
                    i3 = i2;
                    if (i3 <= 8) {
                        if (this.awN.lD()) {
                            a aVar2 = this.awP[8 - i3];
                            aVar2.visible = !aVar2.visible;
                        }
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            case com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX /*140*/:
                for (i2 = 1; i2 <= 8; i2++) {
                    if (this.awN.lD()) {
                        this.awP[8 - i2].reset();
                    }
                }
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.map.j.CTRL_INDEX /*141*/:
                this.awN.cS(8);
                return;
            case 143:
                kS();
                return;
            case e.CTRL_INDEX /*144*/:
                if (this.awQ.axe) {
                    this.awN.cT(4);
                    this.awN.cT(2);
                    this.awN.cT(2);
                    boolean lD = this.awN.lD();
                    boolean lD2 = this.awN.lD();
                    this.awN.cT(3);
                    this.awN.cT(3);
                    this.awQ.e(lD, lD2);
                    return;
                }
                this.awN.cS(16);
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX /*145*/:
                if (this.awQ.axe) {
                    i2 = a.g(this.awN.cT(2), this.awN.cT(2), this.awN.cT(2), this.awN.cT(2));
                    i3 = a.g(this.awN.cT(2), this.awN.cT(2), this.awN.cT(2), this.awN.cT(2));
                    this.awN.cS(2);
                    a.s(this.awN.cT(2), this.awN.cT(2), this.awN.cT(2));
                    this.awQ.aq(i2, i3);
                    return;
                }
                this.awN.cS(24);
                return;
            case f.CTRL_INDEX /*146*/:
                if (this.awQ.axe) {
                    this.awN.cS(4);
                    i2 = this.awN.cT(4);
                    this.awN.cS(2);
                    this.awN.cT(6);
                    aVar = this.awQ;
                    if (aVar.row != i2) {
                        aVar.append(10);
                    }
                    aVar.row = i2;
                    return;
                }
                this.awN.cS(16);
                return;
            case 151:
                if (this.awQ.axe) {
                    i2 = a.g(this.awN.cT(2), this.awN.cT(2), this.awN.cT(2), this.awN.cT(2));
                    this.awN.cT(2);
                    a.s(this.awN.cT(2), this.awN.cT(2), this.awN.cT(2));
                    this.awN.lD();
                    this.awN.lD();
                    this.awN.cT(2);
                    this.awN.cT(2);
                    i3 = this.awN.cT(2);
                    this.awN.cS(8);
                    this.awQ.ap(i2, i3);
                    return;
                }
                this.awN.cS(32);
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.contact.d.CTRL_INDEX /*152*/:
            case 153:
            case JsApiMakeVoIPCall.CTRL_INDEX /*154*/:
            case 155:
            case 156:
            case 157:
            case 158:
            case JsApiGetBackgroundAudioState.CTRL_INDEX /*159*/:
                int i4;
                i2 = i - 152;
                aVar = this.awP[i2];
                this.awN.cS(2);
                boolean lD3 = this.awN.lD();
                boolean lD4 = this.awN.lD();
                this.awN.lD();
                int cT = this.awN.cT(3);
                boolean lD5 = this.awN.lD();
                int cT2 = this.awN.cT(7);
                int cT3 = this.awN.cT(8);
                int cT4 = this.awN.cT(4);
                int cT5 = this.awN.cT(4);
                this.awN.cS(2);
                this.awN.cT(6);
                this.awN.cS(2);
                int cT6 = this.awN.cT(3);
                int cT7 = this.awN.cT(3);
                aVar.axe = true;
                aVar.visible = lD3;
                aVar.axj = lD4;
                aVar.priority = cT;
                aVar.axf = lD5;
                aVar.axg = cT2;
                aVar.axh = cT3;
                aVar.axi = cT4;
                if (aVar.rowCount != cT5 + 1) {
                    aVar.rowCount = cT5 + 1;
                    while (true) {
                        if ((lD4 && aVar.awH.size() >= aVar.rowCount) || aVar.awH.size() >= 15) {
                            aVar.awH.remove(0);
                        }
                    }
                }
                if (!(cT6 == 0 || aVar.axl == cT6)) {
                    aVar.axl = cT6;
                    i4 = cT6 - 1;
                    aVar.ap(a.axa[i4], a.awW[i4]);
                }
                if (!(cT7 == 0 || aVar.axm == cT7)) {
                    aVar.axm = cT7;
                    i4 = cT7 - 1;
                    aVar.e(false, false);
                    aVar.aq(a.awT, a.axd[i4]);
                }
                if (this.awS != i2) {
                    this.awS = i2;
                    this.awQ = this.awP[i2];
                    return;
                }
                return;
            default:
                return;
        }
    }

    private List<com.google.android.exoplayer2.f.a> kR() {
        List arrayList = new ArrayList();
        int i = 0;
        while (i < 8) {
            if (!this.awP[i].isEmpty() && this.awP[i].visible) {
                arrayList.add(this.awP[i].la());
            }
            i++;
        }
        Collections.sort(arrayList);
        return Collections.unmodifiableList(arrayList);
    }

    private void kS() {
        for (int i = 0; i < 8; i++) {
            this.awP[i].reset();
        }
    }
}
