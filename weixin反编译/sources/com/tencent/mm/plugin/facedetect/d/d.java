package com.tencent.mm.plugin.facedetect.d;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.facedetect.a.c;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.d.a.b;
import com.tencent.mm.plugin.facedetect.d.b.a;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.d;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.views.FaceNumberItemView;
import com.tencent.mm.plugin.facedetect.views.FaceNumberView;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class d implements b {
    boolean kRY;
    private View lzD;
    private b mmY;
    String[] mnA;
    int mnB;
    int mnC;
    private FaceNumberView mnD;
    private long mnE;
    private long mnF;
    boolean mnG;
    boolean mnH;
    boolean mnI;
    boolean mnJ;
    private Animation mnK;
    private Animation mnL;
    private AnimationSet mnM;
    private Animation mnN;
    final Object mnO;
    boolean mnP;
    a mnQ;
    ag mnR;
    private CountDownTimer mnS;
    Runnable mnT;
    boolean mnj;
    private String mnx;
    private int mny;
    a mnz;

    static /* synthetic */ void a(d dVar) {
        dVar.mnC = 0;
        synchronized (dVar.mnO) {
            dVar.mnI = false;
        }
        dVar.aHJ();
        dVar.mnJ = true;
        if (dVar.mnB == 0) {
            x.i("MicroMsg.NumberFaceMotion", "hy: triggered start record");
            a aVar = dVar.mnz;
            Runnable anonymousClass6 = new Runnable() {
                public final void run() {
                    if (com.tencent.mm.plugin.facedetect.e.a.aIa().mqK) {
                        d.this.mnz.a(com.tencent.mm.plugin.facedetect.e.a.aIa().aIb());
                        com.tencent.mm.plugin.facedetect.e.a aIa = com.tencent.mm.plugin.facedetect.e.a.aIa();
                        aIa.mqC.F(new Runnable() {
                            public final void run() {
                                synchronized (a.this.mLock) {
                                    if (a.this.mqG == a.mrk) {
                                        x.e("MicroMsg.FaceVideoRecorder", "hy: not started. should not happen");
                                        a.d(a.this);
                                    } else if (a.this.mqG == a.mrm) {
                                        x.w("MicroMsg.FaceVideoRecorder", "hy: already started or wait start");
                                    } else {
                                        x.i("MicroMsg.FaceVideoRecorder", "hy: startRecord record");
                                        d.aGY().a(a.this.mqU);
                                        a.this.iqP.c(a.this.mqH, a.this.mqI, a.this.mqJ);
                                        a.this.mqG = a.mrm;
                                    }
                                }
                            }
                        });
                    }
                }
            };
            x.i("MicroMsg.FaceVoiceRecordLogic", "start record");
            e.b(new a(aVar, anonymousClass6, (byte) 0), "FaceVoice_record", 10);
            g gVar = f.mlS.mlT.mnX;
            if (gVar.mlW == null) {
                x.e("MicroMsg.FaceDetectNativeManager", "hy: startRecord not init");
            } else {
                gVar.mlW.engineStartRecord();
            }
        }
        ah.h(new Runnable() {
            public final void run() {
                synchronized (d.this.mnO) {
                    if (d.this.mnI) {
                        x.i("MicroMsg.NumberFaceMotion", "hy: user already start. do nothing");
                    } else {
                        x.w("MicroMsg.NumberFaceMotion", "hy: not triggered symbol. auto start");
                        d.this.mnI = true;
                        d.b(d.this);
                    }
                }
            }
        }, 2000);
    }

    static /* synthetic */ void b(d dVar) {
        long bB = bi.bB(dVar.mnF);
        x.i("MicroMsg.NumberFaceMotion", "hy: delta after request");
        if (bB < 0) {
            x.w("MicroMsg.NumberFaceMotion", "hy: too fast. regard as fake");
        } else if (bB < 1000) {
            x.w("MicroMsg.NumberFaceMotion", "hy: too fast. wait until normal");
            ah.h(new Runnable() {
                public final void run() {
                    d.this.aHK();
                }
            }, 1000 - bB);
        } else {
            dVar.aHK();
        }
    }

    public d(String str) {
        this.mnx = null;
        this.mny = 0;
        this.mnz = null;
        this.mnA = null;
        this.mnB = 0;
        this.mnC = 0;
        this.lzD = null;
        this.mnD = null;
        this.mnj = false;
        this.mnE = -1;
        this.mnF = -1;
        this.mnG = false;
        this.mnH = false;
        this.mnI = false;
        this.mnJ = false;
        this.mnO = new Object();
        this.kRY = false;
        this.mnP = false;
        this.mnQ = null;
        this.mnR = new ag(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 0:
                        x.i("MicroMsg.NumberFaceMotion", "hy: refresh number");
                        d.this.aHJ();
                        return;
                    default:
                        return;
                }
            }
        };
        this.mnS = new CountDownTimer() {
            public final void onTick(long j) {
                x.i("MicroMsg.NumberFaceMotion", "hy: on ticked");
                if (d.this.kRY) {
                    x.w("MicroMsg.NumberFaceMotion", "hy: isEnd. trigger cancel");
                    cancel();
                } else if (d.this.mnH) {
                    x.i("MicroMsg.NumberFaceMotion", "hy: suspend.");
                } else {
                    x.i("MicroMsg.NumberFaceMotion", "hy: mCurrentShowedIndexInItem: %d, mItemDatas[mCurrentGroupDataIndex].length() - 1: %d, mCurrentGroupDataIndex: %d, mItemDatas.length - 1 : %d", Integer.valueOf(d.this.mnC), Integer.valueOf(d.this.mnA[d.this.mnB].length() - 1), Integer.valueOf(d.this.mnB), Integer.valueOf(d.this.mnA.length - 1));
                    if (d.this.mnC < d.this.mnA[d.this.mnB].length() - 1) {
                        d dVar = d.this;
                        dVar.mnC++;
                        d.this.mnR.sendEmptyMessage(0);
                        return;
                    }
                    x.i("MicroMsg.NumberFaceMotion", "hy: last number in group");
                    ah.h(d.this.mnT, 1500);
                    d.this.kRY = true;
                    cancel();
                    d.this.kRY = true;
                }
            }

            public final void onFinish() {
                x.i("MicroMsg.NumberFaceMotion", "hy: on count number finished");
            }
        };
        this.mnT = new Runnable() {
            public final void run() {
                synchronized (d.this.mnO) {
                    if (d.this.mnB >= d.this.mnA.length - 1) {
                        x.i("MicroMsg.NumberFaceMotion", "hy: already last. handle upper judge.");
                        d.this.mnj = true;
                        f fVar = f.mlS;
                        byte[] d = FileOp.d(d.this.mnz.mna, -1, -1);
                        g gVar = fVar.mlT.mnX;
                        if (gVar.mlW == null) {
                            x.e("MicroMsg.FaceDetectNativeManager", "hy: set face data instance null!");
                        } else {
                            gVar.mlW.engineSetVoiceData(d);
                        }
                    } else {
                        x.i("MicroMsg.NumberFaceMotion", "hy: startShowNext");
                        d dVar = d.this;
                        dVar.mnB++;
                        d.this.mnC = -1;
                        d.this.eY(true);
                        d.this.aHJ();
                    }
                }
            }
        };
        this.mmY = new b() {
            public final void aHA() {
                synchronized (d.this.mnO) {
                    x.i("MicroMsg.NumberFaceMotion", "hy: triggered read symbol");
                    if (!d.this.mnI && d.this.mnJ) {
                        d.this.mnI = true;
                        d.b(d.this);
                    }
                }
            }

            public final void onError(int i) {
                synchronized (d.this.mnO) {
                    x.w("MicroMsg.NumberFaceMotion", "hy: on voice prepare error: %d", Integer.valueOf(i));
                    switch (i) {
                        case 11:
                            d.this.mnG = true;
                            break;
                        default:
                            d.this.mnP = true;
                            d.this.mnQ = new a(ad.getResources().getString(h.eAd));
                            break;
                    }
                }
            }
        };
        this.mnz = new a();
        this.mnz.mmY = this.mmY;
        this.mnK = AnimationUtils.loadAnimation(ad.getContext(), com.tencent.mm.plugin.facedetect.a.a.bqB);
        this.mnL = AnimationUtils.loadAnimation(ad.getContext(), com.tencent.mm.plugin.facedetect.a.a.mia);
        this.mnN = AnimationUtils.loadAnimation(ad.getContext(), com.tencent.mm.plugin.facedetect.a.a.bpZ);
        this.mnN.setDuration(250);
        this.mnN.setFillAfter(true);
        this.mnx = str;
        this.mny = this.mnx == null ? 0 : this.mnx.length();
        aHI();
        if (aHH()) {
            this.mnM = (AnimationSet) AnimationUtils.loadAnimation(ad.getContext(), com.tencent.mm.plugin.facedetect.a.a.mib);
        } else {
            this.mnM = (AnimationSet) AnimationUtils.loadAnimation(ad.getContext(), com.tencent.mm.plugin.facedetect.a.a.mic);
        }
        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) ad.getResources().getDimensionPixelSize(c.mih));
        translateAnimation.setDuration((long) ad.getContext().getResources().getInteger(com.tencent.mm.plugin.facedetect.a.f.mjn));
        this.mnM.addAnimation(translateAnimation);
        x.i("MicroMsg.NumberFaceMotion", "hy: starting read number: %s", this.mnx);
    }

    private boolean aHH() {
        return this.mny >= 6;
    }

    private void aHI() {
        int i = 0;
        if (bi.oN(this.mnx) || !aHH()) {
            this.mnA = new String[1];
            this.mnA[0] = this.mnx;
            return;
        }
        x.i("MicroMsg.NumberFaceMotion", "hy: data too long. need to split into %d rounds", Integer.valueOf(2));
        this.mnA = new String[2];
        int i2 = this.mny / 2;
        while (i < 2) {
            this.mnA[i] = this.mnx.substring(i2 * i, (i + 1) * i2);
            i++;
        }
    }

    public final boolean aHB() {
        return this.mnj;
    }

    private TextView aHG() {
        if (this.lzD != null) {
            return (TextView) this.lzD.findViewById(com.tencent.mm.plugin.facedetect.a.e.mjg);
        }
        return null;
    }

    public final void a(Context context, ViewGroup viewGroup, ViewGroup viewGroup2) {
        x.d("MicroMsg.NumberFaceMotion", "hy: on number init motion");
        this.lzD = LayoutInflater.from(context).inflate(com.tencent.mm.plugin.facedetect.a.g.mjr, viewGroup2);
        this.mnD = (FaceNumberView) this.lzD.findViewById(com.tencent.mm.plugin.facedetect.a.e.mja);
        cy(this.mnA.length, -1);
        aHG().startAnimation(this.mnK);
        if (this.mnD != null) {
            this.mnD.setVisibility(0);
            this.mnD.startAnimation(this.mnK);
            this.mnB = 0;
            eY(false);
            this.mnC = -1;
            aHJ();
            this.mnE = bi.Wz();
            this.mnF = bi.Wz();
            this.kRY = false;
        }
    }

    private static String pR(int i) {
        switch (i) {
            case 1:
                return ad.getContext().getString(h.mjP);
            case 2:
                return ad.getContext().getString(h.mjQ);
            case 3:
                return ad.getContext().getString(h.mjS);
            case 4:
                return ad.getContext().getString(h.mjT);
            default:
                x.e("MicroMsg.NumberFaceMotion", "hy: unknown length!!");
                return "";
        }
    }

    private void cy(int i, int i2) {
        x.i("MicroMsg.NumberFaceMotion", "alvinluo groupIndex: %d, itemDataLength: %d", Integer.valueOf(i2), Integer.valueOf(i));
        if (aHG() == null) {
            return;
        }
        if (i == 1) {
            aHG().setText(ad.getContext().getString(h.mjW));
            return;
        }
        CharSequence string;
        TextView aHG = aHG();
        if (i2 == -1) {
            String string2;
            Context context = ad.getContext();
            int i3 = h.mjV;
            Object[] objArr = new Object[1];
            switch (i) {
                case 2:
                    string2 = ad.getContext().getString(h.mjR);
                    break;
                default:
                    string2 = pR(i);
                    break;
            }
            objArr[0] = string2;
            string = context.getString(i3, objArr);
        } else {
            string = ad.getContext().getString(h.mjU, new Object[]{pR(this.mnB + 1)});
        }
        aHG.setText(string);
        if (i2 > 0) {
            x.i("MicroMsg.NumberFaceMotion", "alvinluo start %d group number", Integer.valueOf(i2 + 1));
            g gVar = f.mlS.mlT.mnX;
            if (gVar.mlW == null) {
                x.e("MicroMsg.FaceDetectNativeManager", "hy: startRecord not init");
            } else {
                gVar.mlW.engineGroupChange();
            }
        }
    }

    final void eY(boolean z) {
        if (this.mnD != null) {
            cy(this.mnA.length, this.mnB);
            FaceNumberView faceNumberView = this.mnD;
            int length = this.mnA[this.mnB].length();
            if (length > 12) {
                x.e("MicroMsg.Facing.MMPwdInputView", "hy: number length exceed max length: %d", Integer.valueOf(length));
            } else if (length <= 0) {
                x.e("MicroMsg.Facing.MMPwdInputView", "hy: number length exceed min length: %d", Integer.valueOf(length));
            } else if (length == faceNumberView.msO) {
                x.i("MicroMsg.Facing.MMPwdInputView", "hy: already correct length. quit");
                faceNumberView.Au(null);
            } else {
                faceNumberView.msM.removeAllViews();
                faceNumberView.msO = length;
                faceNumberView.msN = new FaceNumberItemView[faceNumberView.msO];
                for (int i = 0; i < length; i++) {
                    int i2;
                    int dimensionPixelSize;
                    FaceNumberItemView faceNumberItemView = (FaceNumberItemView) FaceNumberView.inflate(faceNumberView.getContext(), com.tencent.mm.plugin.facedetect.a.g.mjt, null);
                    faceNumberItemView.setImageResource(com.tencent.mm.plugin.facedetect.a.d.miA);
                    if (i == 0) {
                        i2 = 3;
                        dimensionPixelSize = (faceNumberView.getResources().getDimensionPixelSize(c.mij) + com.tencent.mm.bu.a.fromDPToPix(faceNumberView.getContext(), 48)) / 2;
                    } else if (i == length - 1) {
                        i2 = 5;
                        dimensionPixelSize = (faceNumberView.getResources().getDimensionPixelSize(c.mij) + com.tencent.mm.bu.a.fromDPToPix(faceNumberView.getContext(), 48)) / 2;
                    } else {
                        i2 = 17;
                        dimensionPixelSize = faceNumberView.getResources().getDimensionPixelSize(c.mij);
                    }
                    x.i("MicroMsg.FaceNumberItemView", "hy: setting gravity");
                    faceNumberItemView.msF = i2;
                    faceNumberView.msN[i] = faceNumberItemView;
                    faceNumberView.msM.addView(faceNumberItemView, new LayoutParams(dimensionPixelSize, faceNumberView.getResources().getDimensionPixelSize(c.mii)));
                }
            }
            this.mnJ = false;
            if (z) {
                this.mnK.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        ah.h(new Runnable() {
                            public final void run() {
                                d.a(d.this);
                            }
                        }, 500);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                if (this.lzD != null) {
                    this.lzD.startAnimation(this.mnK);
                    return;
                }
                return;
            }
            ah.h(new Runnable() {
                public final void run() {
                    d.a(d.this);
                }
            }, 500);
        }
    }

    final void aHJ() {
        if (this.mnD == null) {
            return;
        }
        if (this.mnB >= 0) {
            this.mnD.Au(this.mnA[this.mnB].substring(0, this.mnC + 1));
        } else {
            this.mnD.Au(null);
        }
    }

    public final boolean aHC() {
        this.mnH = true;
        return this.mnP;
    }

    public final boolean a(FaceCharacteristicsResult faceCharacteristicsResult) {
        this.mnH = true;
        return this.mnP;
    }

    public final boolean b(FaceCharacteristicsResult faceCharacteristicsResult) {
        this.mnH = false;
        return this.mnP;
    }

    public final void aHD() {
        this.kRY = true;
        this.mnP = false;
        a aVar = this.mnz;
        aVar.mmZ = true;
        x.i("MicroMsg.FaceVoiceRecordLogic", "hy: face start reset");
        synchronized (aVar) {
            if (aVar.fkr != null) {
                aVar.fkr.vj();
                aVar.fkr = null;
            }
            if (aVar.iai != null) {
                aVar.iai.vK();
                aVar.iai = null;
            }
            if (aVar.iao != null) {
                try {
                    aVar.iao.release();
                    aVar.iao = null;
                    aVar.iaK = true;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.FaceVoiceRecordLogic", e, "mVoiceSilentDetectAPI.release error", new Object[0]);
                }
            }
            aVar.iad = 0;
        }
        a aVar2 = this.mnz;
        x.i("MicroMsg.FaceVoiceRecordLogic", "hy: recycling voice.");
        aVar2.mmY = null;
        this.mnz.aHz();
        if (com.tencent.mm.plugin.facedetect.e.a.aIa().mqK && com.tencent.mm.plugin.facedetect.e.a.aIa().isStarted()) {
            this.mnz.mnb.remove(com.tencent.mm.plugin.facedetect.e.a.aIa().aIb());
            if (this.mnj) {
                com.tencent.mm.plugin.facedetect.e.a.aIa().a(null);
            } else {
                com.tencent.mm.plugin.facedetect.e.a.aIa().aIc();
            }
        }
        this.mnS.cancel();
        this.mnR.removeCallbacksAndMessages(null);
        if (this.mnD != null) {
            FaceNumberView faceNumberView = this.mnD;
            if (faceNumberView.msN != null && faceNumberView.msN.length > 0) {
                for (FaceNumberItemView aIn : faceNumberView.msN) {
                    aIn.aIn();
                }
            }
        }
        if (this.lzD != null) {
            this.mnj = false;
            this.mnE = -1;
            this.lzD = null;
            this.mnD = null;
        }
    }

    public final b.b aHE() {
        return new b.b(90004, "user cancelled in processing");
    }

    public final a aHF() {
        return this.mnQ;
    }

    final void aHK() {
        this.mnS.start();
    }
}
