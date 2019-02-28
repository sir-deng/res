package com.tencent.mm.plugin.mmsight.model;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.Camera.Parameters;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.model.g.b;
import com.tencent.mm.plugin.t.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.u;

public final class j {
    static int mlH;
    public static boolean oyA = true;
    private static boolean oyB = false;
    private static boolean oyC = false;
    public static o oyD;
    static double oyE;

    public static boolean d(Point point) {
        if (oyB) {
            String str;
            Context context = ad.getContext();
            Resources resources = ad.getResources();
            int i = a.oJO;
            Object[] objArr = new Object[1];
            if (oyD == null) {
                str = "";
            } else {
                str = Integer.valueOf(oyD.oyM);
            }
            objArr[0] = str;
            u.makeText(context, resources.getString(i, objArr), 1).show();
            return false;
        }
        x.i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy, deviceInfo recorderType: %s, recorderOption: %s, isUseRecorderOption: %s", Integer.valueOf(q.gHM.gHU), Integer.valueOf(q.gHM.gIb), Boolean.valueOf(oyC));
        if (oyC) {
            return false;
        }
        if (q.gHM.gHU != -1) {
            return true;
        }
        if (oyD != null && 1 == oyD.gHU) {
            return true;
        }
        if (point == null) {
            return false;
        }
        if (d.ta(point.x) && d.ta(point.y)) {
            return true;
        }
        if (oyD != null) {
            x.i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy not happy %s", point.toString());
            oyD.gHU = 1;
        }
        return false;
    }

    public static void a(Parameters parameters, boolean z) {
        if (oyB) {
            String str;
            Context context = ad.getContext();
            Resources resources = ad.getResources();
            int i = a.oJO;
            Object[] objArr = new Object[1];
            if (oyD == null) {
                str = "";
            } else {
                str = Integer.valueOf(oyD.oyM);
            }
            objArr[0] = str;
            u.makeText(context, resources.getString(i, objArr), 1).show();
            return;
        }
        x.i("MicroMsg.MMSightRecorderConfig", "autoConfig, recorderOption: %s, isUseRecorderOption: %s", Integer.valueOf(q.gHM.gIb), Boolean.valueOf(oyC));
        if (!oyC) {
            boolean z2;
            o oVar;
            Point bav = d.bav();
            int i2 = bi.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightMediaCodecMinApiLevel"), 19);
            x.i("MicroMsg.MMSightRecorderConfig", "apiLevel: %s record1080pApiLevel: %s, record720pApiLevel: %s", Integer.valueOf(i2), Integer.valueOf(bi.getInt(CaptureMMProxy.getInstance().getDynamicConfig("Sight1080pRecordMinApiLevel"), 19)), Integer.valueOf(bi.getInt(CaptureMMProxy.getInstance().getDynamicConfig("Sight720pRecordMinApiLevel"), 19)));
            if (q.gHM.gIa == -1 || (q.gHM.gIa & 1) != 0) {
                if (q.gHM.gIa != -1 && (q.gHM.gIa & 1) != 0) {
                    oyD.baS().oyO = true;
                    z2 = true;
                    if (q.gHM.gHV != -1) {
                        oyD.oyN = false;
                    } else {
                        if (q.gHM.gHV == 1) {
                        }
                        oyD.oyN = q.gHM.gHV == 1;
                    }
                    if (q.gHM.gIa == -1) {
                    }
                    oVar = oyD;
                    oVar.oyR = g.b(parameters, d.bav(), 720, z);
                    if (oVar.oyR != null) {
                    }
                    z2 = false;
                    if (z2) {
                        oyD.baQ().oyO = true;
                    }
                    oyD.oyM = -1;
                    x.i("MicroMsg.MMSightRecorderConfig", "autoConfig parameter byserver %s", oyD.toString());
                } else if (com.tencent.mm.compatible.util.d.fN(r3) && mlH >= WXMediaMessage.TITLE_LENGTH_LIMIT && oyE >= 1725.0d && Math.min(bav.x, bav.y) >= 1080) {
                    oVar = oyD;
                    oVar.oyR = g.b(parameters, d.bav(), oVar.owp.width * 2, z);
                    if (oVar.oyR == null || oVar.oyR.oyr == null) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        oyD.baS().oyO = true;
                        z2 = true;
                        if (q.gHM.gHV != -1) {
                            oyD.oyN = q.gHM.gHV == 1;
                        } else {
                            oyD.oyN = false;
                        }
                        if (q.gHM.gIa == -1 || (q.gHM.gIa & 2) != 0) {
                            if (q.gHM.gIa == -1 && (q.gHM.gIa & 2) != 0) {
                                oVar = oyD.baQ();
                                oVar.oyO = false;
                                oVar.baR();
                            } else if (!z2 && com.tencent.mm.compatible.util.d.fN(r5) && mlH >= WXMediaMessage.TITLE_LENGTH_LIMIT && oyE >= 1725.0d && Math.min(bav.x, bav.y) >= 720) {
                                oVar = oyD;
                                oVar.oyR = g.b(parameters, d.bav(), 720, z);
                                if (oVar.oyR != null || oVar.oyR.oyr == null) {
                                    z2 = false;
                                } else {
                                    z2 = true;
                                }
                                if (z2) {
                                    oyD.baQ().oyO = true;
                                }
                            }
                        }
                        oyD.oyM = -1;
                        x.i("MicroMsg.MMSightRecorderConfig", "autoConfig parameter byserver %s", oyD.toString());
                    }
                }
            }
            z2 = false;
            if (q.gHM.gHV != -1) {
                if (q.gHM.gHV == 1) {
                }
                oyD.oyN = q.gHM.gHV == 1;
            } else {
                oyD.oyN = false;
            }
            if (q.gHM.gIa == -1) {
            }
            oVar = oyD;
            oVar.oyR = g.b(parameters, d.bav(), 720, z);
            if (oVar.oyR != null) {
            }
            z2 = false;
            if (z2) {
                oyD.baQ().oyO = true;
            }
            oyD.oyM = -1;
            x.i("MicroMsg.MMSightRecorderConfig", "autoConfig parameter byserver %s", oyD.toString());
        }
    }

    public static void b(VideoTransPara videoTransPara) {
        int i;
        int i2;
        boolean z = true;
        oyB = false;
        oyC = false;
        mlH = ((ActivityManager) ad.getContext().getSystemService("activity")).getLargeMemoryClass();
        oyE = (double) d.dd(ad.getContext());
        String ckL = be.ckL();
        x.i("MicroMsg.MMSightRecorderConfig", "MXM_DynaCfg_AV_Item_Key_SightMediaCodecMinApiLevel: %s", Integer.valueOf(bi.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightMediaCodecMinApiLevel"), 19)));
        if (CaptureMMProxy.getInstance() != null) {
            q.eK(CaptureMMProxy.getInstance().getDeviceInfoConfig());
        }
        x.i("MicroMsg.MMSightRecorderConfig", "init large memory class: %sMB, totalMemory: %sGB  fingerprint: %s mmSightRecorderInfo: %s", Integer.valueOf(mlH), Double.valueOf(oyE), ckL, q.gHM);
        if (CaptureMMProxy.getInstance() != null) {
            i = CaptureMMProxy.getInstance().getInt(w.a.USERINFO_LOCAL_SIGHT_SETTING_PRESET_INT_SYNC, -1);
            i2 = CaptureMMProxy.getInstance().getInt(w.a.USERINFO_LOCAL_SIGHT_FOCUS_INT_SYNC, 1);
        } else {
            i2 = 1;
            i = -1;
        }
        o a = o.a(i, videoTransPara);
        oyD = a;
        int i3;
        if (a != null) {
            if (i2 == 1) {
                oyD.oyP = true;
            } else {
                oyD.oyP = false;
            }
            oyB = true;
            Context context = ad.getContext();
            Resources resources = ad.getResources();
            i3 = a.oJO;
            Object[] objArr = new Object[1];
            if (oyD == null) {
                ckL = "";
            } else {
                ckL = Integer.valueOf(oyD.oyM);
            }
            objArr[0] = ckL;
            u.makeText(context, resources.getString(i3, objArr), 1).show();
            return;
        }
        i = q.gHM.gIb;
        x.i("MicroMsg.MMSightRecorderConfig", "recorderOption: %s", Integer.valueOf(i));
        if (i != -1) {
            oyD = o.a(i, videoTransPara);
        }
        if (oyD != null) {
            if (i2 == 1) {
                oyD.oyP = true;
            } else {
                oyD.oyP = false;
            }
            oyC = true;
            return;
        }
        oyD = o.a(1, videoTransPara);
        if (i2 == 1) {
            oyD.oyP = true;
        } else {
            oyD.oyP = false;
        }
        if (q.gHM.gHU != -1) {
            oyD.gHU = q.gHM.gHU;
        } else if (com.tencent.mm.compatible.util.d.fN(i3)) {
            oyD.gHU = 2;
        } else {
            oyD.gHU = 1;
        }
        if (q.gHM.gHX != -1) {
            boolean z2;
            if (q.gHM.gHX == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            oyA = z2;
        }
        if (q.gHM.gHV != -1) {
            o oVar = oyD;
            if (q.gHM.gHV != 1) {
                z = false;
            }
            oVar.oyN = z;
            return;
        }
        oyD.oyN = false;
    }

    public static void a(b bVar) {
        if (bVar.oyr == null) {
            x.i("MicroMsg.MMSightRecorderConfig", "checkMore start %s", bVar.toString());
            bVar.oyr = bVar.oyu;
            bVar.oys = bVar.oyv;
            bVar.oyt = bVar.oyw;
            if (Math.min(bVar.oys.y, bVar.oys.x) >= oyD.owp.width + 16) {
                oyD.baR();
                oyD.oyO = false;
                oyD.oyN = false;
                x.i("MicroMsg.MMSightRecorderConfig", "checkMore out %s", bVar.toString());
            }
        }
    }

    public static void baK() {
        x.i("MicroMsg.MMSightRecorderConfig", "initSimple");
        o oVar = new o();
        oyD = oVar;
        oVar.oyN = false;
        oyD.oyO = false;
        if (com.tencent.mm.compatible.util.d.fN(19)) {
            oyD.gHU = 2;
        } else {
            oyD.gHU = 1;
        }
    }
}
