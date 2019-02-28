package com.tencent.mm.plugin.exdevice.model;

import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.mm.ap.o;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.f.a.dc;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.exdevice.b.k;
import com.tencent.mm.plugin.exdevice.f.a.h;
import com.tencent.mm.plugin.exdevice.f.b.a;
import com.tencent.mm.plugin.exdevice.f.b.b.e;
import com.tencent.mm.plugin.exdevice.f.b.c;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.i.g;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bq;
import com.tencent.mm.y.bt;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import junit.framework.Assert;

public final class ad implements ap {
    private static HashMap<Integer, d> gyG;
    private c lTA;
    private a lTB;
    private com.tencent.mm.plugin.exdevice.f.a.c lTC;
    private com.tencent.mm.ap.a.a lTD = null;
    private com.tencent.mm.ap.a.a.c lTE = null;
    private af lTF;
    private h lTG;
    private bt.a lTH = new bt.a() {
        public final void a(com.tencent.mm.ad.d.a aVar) {
            if (ad.aEX() != null) {
                Object obj;
                Map y;
                ad.aEX();
                bx bxVar = aVar.hoa;
                x.i("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "parseMessageFromServer");
                String a = n.a(bxVar.vNO);
                if (bi.oN(a)) {
                    x.e("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "msg content is null");
                } else {
                    Map y2 = bj.y(a, "sysmsg");
                    if (y2 != null && y2.size() > 0) {
                        a = (String) y2.get(".sysmsg.$type");
                        if (!bi.oN(a) && a.equalsIgnoreCase("wcdevicemsg")) {
                            a = (String) y2.get(".sysmsg.wcdevicemsg.xml.ToUserName");
                            String str = (String) y2.get(".sysmsg.wcdevicemsg.xml.FromUserName");
                            long j = bi.getLong((String) y2.get(".sysmsg.wcdevicemsg.xml.CreateTime"), -1);
                            String str2 = (String) y2.get(".sysmsg.wcdevicemsg.xml.MsgType");
                            String str3 = (String) y2.get(".sysmsg.wcdevicemsg.xml.DeviceType");
                            String str4 = (String) y2.get(".sysmsg.wcdevicemsg.xml.DeviceID");
                            int i = bi.getInt((String) y2.get(".sysmsg.wcdevicemsg.xml.DeviceStatus"), -1);
                            x.i("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "parseMessageFromServer:tousr=" + a + ",fromuser=" + str + ",createtime=" + j + ",msgtype=" + str2 + ",devicetype=" + str3 + ",deviceid=" + str4 + ",devicestatus=" + i);
                            b zM = ad.aER().zM(str4);
                            if (zM != null && bi.oM(zM.field_connProto).contains("4") && bi.oM(str2).contains("device_status")) {
                                if (i != 0) {
                                    ad.aFc();
                                    e.e(zM.field_brandName, zM.field_url, 2, zM.field_deviceID);
                                } else {
                                    ad.aFc();
                                    e.e(zM.field_brandName, zM.field_url, 4, zM.field_deviceID);
                                }
                                obj = 1;
                                if (obj == null) {
                                    a = n.a(bxVar.vNO);
                                    if (bi.oN(a)) {
                                        y = bj.y(a, "sysmsg");
                                        if (y != null || y.size() <= 0) {
                                            x.e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, no sysmsg");
                                            return;
                                        }
                                        a = (String) y.get(".sysmsg.$type");
                                        if (bi.oN(a) || !a.equalsIgnoreCase("wcdevicemsg")) {
                                            x.e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, type not wcdevicemsg");
                                            return;
                                        }
                                        x.i("MicroMsg.exdevice.ExDeviceMessageService", "newXml wcdevicemsg msgType = %s", bi.oM((String) y.get(".sysmsg.wcdevicemsg.xml.MsgType")));
                                        if (bi.oM((String) y.get(".sysmsg.wcdevicemsg.xml.MsgType")).equals("device_relation")) {
                                            com.tencent.mm.sdk.b.b dcVar = new dc();
                                            dcVar.fsq.fsr = true;
                                            com.tencent.mm.sdk.b.a.xmy.m(dcVar);
                                            return;
                                        }
                                        a = (String) y.get(".sysmsg.wcdevicemsg.xml.Content");
                                        x.i("MicroMsg.exdevice.ExDeviceMessageService", "contentBase64 = %s", a);
                                        if (bi.oN(a)) {
                                            x.e("MicroMsg.exdevice.ExDeviceMessageService", "Fuck off: contentBase64 is null");
                                            return;
                                        }
                                        try {
                                            byte[] decode = Base64.decode(a, 0);
                                            if (bi.by(decode)) {
                                                x.e("MicroMsg.exdevice.ExDeviceMessageService", "null == decodedContent");
                                                return;
                                            }
                                            long j2 = bi.getLong((String) y.get(".sysmsg.wcdevicemsg.xml.SessionID"), -1);
                                            x.i("MicroMsg.exdevice.ExDeviceMessageService", "------NewXml Receive------sessionId = %d, deviceId = %s, message content = %s, length = %d", Long.valueOf(j2), (String) y.get(".sysmsg.wcdevicemsg.xml.DeviceID"), a, Integer.valueOf(decode.length));
                                            zM = ad.aER().zM(str);
                                            if (zM == null) {
                                                x.e("MicroMsg.exdevice.ExDeviceMessageService", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
                                                return;
                                            } else if (0 == j2) {
                                                u.aFt().a(new g(decode, 0, zM.field_mac));
                                                return;
                                            } else {
                                                k aEs = k.aEs();
                                                x.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Recivce sendDataToManufacturerResponse, sessionId = %d", Long.valueOf(j2));
                                                Assert.assertTrue(j2 >= 0);
                                                c cVar = new c();
                                                cVar.mSessionId = j2;
                                                cVar.kCs = decode;
                                                aEs.mHandler.obtainMessage(3, cVar).sendToTarget();
                                                return;
                                            }
                                        } catch (Throwable e) {
                                            x.e("MicroMsg.exdevice.ExDeviceMessageService", "decode failed!!! %s", e.getMessage());
                                            x.printErrStackTrace("MicroMsg.exdevice.ExDeviceMessageService", e, "", new Object[0]);
                                            return;
                                        }
                                    }
                                    x.e("MicroMsg.exdevice.ExDeviceMessageService", "msg content is null");
                                }
                            }
                        }
                    }
                }
                obj = null;
                if (obj == null) {
                    a = n.a(bxVar.vNO);
                    if (bi.oN(a)) {
                        y = bj.y(a, "sysmsg");
                        if (y != null) {
                        }
                        x.e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, no sysmsg");
                        return;
                    }
                    x.e("MicroMsg.exdevice.ExDeviceMessageService", "msg content is null");
                }
            }
        }
    };
    m.b lTI = new m.b() {
        public final void a(int i, m mVar, final Object obj) {
            try {
                if (!as.Hp()) {
                    x.w("MicroMsg.exdevice.SubCoreExDevice", "onNotifyChange,acc has not ready");
                } else if (obj instanceof String) {
                    as.Dt().g(new Runnable() {
                        public final void run() {
                            String str = (String) obj;
                            if (ad.aET().zG(str)) {
                                as.Hm();
                                if (!com.tencent.mm.y.c.Ff().Xr(str)) {
                                    as.CN().a(new h(str, null), 0);
                                }
                            }
                        }
                    }, 2000);
                }
            } catch (Exception e) {
                x.e("MicroMsg.exdevice.SubCoreExDevice", "ap : onNotifyChange exception %s", e.getMessage());
            }
        }
    };
    private ab lTr = new ab();
    private b lTs;
    private com.tencent.mm.plugin.exdevice.h.c lTt;
    private com.tencent.mm.plugin.exdevice.f.b.b.d lTu;
    private com.tencent.mm.plugin.exdevice.f.b.b.a lTv;
    private com.tencent.mm.plugin.exdevice.f.b.b.b lTw;
    private e lTx;
    private e lTy;
    private d lTz;

    static /* synthetic */ void a(ad adVar) {
        try {
            ah.h(new Runnable() {
                public final void run() {
                    boolean hasSystemFeature = com.tencent.mm.sdk.platformtools.ad.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter");
                    boolean hasSystemFeature2 = com.tencent.mm.sdk.platformtools.ad.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepdetector");
                    if (hasSystemFeature && hasSystemFeature2) {
                        com.tencent.mm.plugin.report.service.g.pWK.a(11891, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, true, true);
                    } else if (hasSystemFeature) {
                        com.tencent.mm.plugin.report.service.g.pWK.a(11891, "1", true, true);
                    } else if (hasSystemFeature2) {
                        com.tencent.mm.plugin.report.service.g.pWK.a(11891, "2", true, true);
                    }
                    x.i("MicroMsg.exdevice.SubCoreExDevice", "[hakon][step] deviceFeatures stepCounter %s, stepDetector %s", Boolean.valueOf(hasSystemFeature), Boolean.valueOf(hasSystemFeature2));
                }
            }, 30000);
        } catch (Throwable e) {
            x.e("MicroMsg.exdevice.SubCoreExDevice", "[hakon][step] exception in deviceFeaturesKVStat, %s", e.getMessage());
            x.printErrStackTrace("MicroMsg.exdevice.SubCoreExDevice", e, "", new Object[0]);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        gyG = hashMap;
        hashMap.put(Integer.valueOf("HARDDEVICEINFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.plugin.exdevice.h.c.gLy;
            }
        });
        gyG.put(Integer.valueOf("HARDDEVICERANKINFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.plugin.exdevice.f.b.b.d.gLy;
            }
        });
        gyG.put(Integer.valueOf("HARDDEVICERANKFOLLOWINFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.plugin.exdevice.f.b.b.a.gLy;
            }
        });
        gyG.put(Integer.valueOf("HARDDEVICELIKEINFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return e.gLy;
            }
        });
        gyG.put(Integer.valueOf("HARDDEVICECHAMPIONINFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.plugin.exdevice.f.b.b.b.gLy;
            }
        });
        gyG.put(Integer.valueOf("HARDDEVICERANKDETAILINFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.plugin.exdevice.f.b.b.c.gLy;
            }
        });
    }

    public ad() {
        if (this.lTz == null) {
            this.lTz = new d();
        }
        if (this.lTy == null) {
            this.lTy = new e();
        }
        x.i("MicroMsg.exdevice.SubCoreExDevice", "create SubCoreExDevice.");
        com.tencent.mm.sdk.b.a.xmy.b(this.lTy.lRi);
    }

    public final HashMap<Integer, d> Bu() {
        return gyG;
    }

    private static ad aEQ() {
        as.Hg();
        ad adVar = (ad) bq.ib("plugin.exdevice");
        if (adVar != null) {
            return adVar;
        }
        x.w("MicroMsg.exdevice.SubCoreExDevice", "not found in MMCore, new one");
        Object adVar2 = new ad();
        as.Hg().a("plugin.exdevice", adVar2);
        return adVar2;
    }

    public static com.tencent.mm.plugin.exdevice.h.c aER() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aEQ().lTt == null) {
            ad aEQ = aEQ();
            as.Hm();
            aEQ.lTt = new com.tencent.mm.plugin.exdevice.h.c(com.tencent.mm.y.c.Fc());
        }
        return aEQ().lTt;
    }

    public static com.tencent.mm.plugin.exdevice.f.b.b.d aES() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aEQ().lTu == null) {
            ad aEQ = aEQ();
            as.Hm();
            aEQ.lTu = new com.tencent.mm.plugin.exdevice.f.b.b.d(com.tencent.mm.y.c.Fc());
        }
        return aEQ().lTu;
    }

    public static com.tencent.mm.plugin.exdevice.f.b.b.a aET() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aEQ().lTv == null) {
            ad aEQ = aEQ();
            as.Hm();
            aEQ.lTv = new com.tencent.mm.plugin.exdevice.f.b.b.a(com.tencent.mm.y.c.Fc());
        }
        return aEQ().lTv;
    }

    public static com.tencent.mm.ap.a.a aEU() {
        if (aEQ().lTD == null) {
            aEQ().lTD = o.PG();
        }
        return aEQ().lTD;
    }

    public static com.tencent.mm.ap.a.a.c zB(String str) {
        if (bi.oN(str)) {
            x.w("MicroMsg.exdevice.SubCoreExDevice", "newImageOptions failed, url is null or nil, return default.");
            ad aEQ = aEQ();
            if (aEQ.lTE == null) {
                com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
                o.PH();
                aVar.hFH = null;
                aVar.hFs = 640;
                aVar.hFr = 640;
                aVar.hFj = false;
                aVar.hFl = true;
                aEQ.lTE = aVar.PQ();
            }
            return aEQ().lTE;
        }
        com.tencent.mm.ap.a.a.c.a aVar2 = new com.tencent.mm.ap.a.a.c.a();
        aVar2.hFs = 640;
        aVar2.hFr = 640;
        aVar2.hFj = false;
        aVar2.hFk = true;
        as.Hm();
        aVar2.hFo = com.tencent.mm.y.c.Fp();
        return aVar2.PQ();
    }

    public static com.tencent.mm.plugin.exdevice.f.b.b.b aEV() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aEQ().lTw == null) {
            ad aEQ = aEQ();
            as.Hm();
            aEQ.lTw = new com.tencent.mm.plugin.exdevice.f.b.b.b(com.tencent.mm.y.c.Fc());
        }
        return aEQ().lTw;
    }

    public static e aEW() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aEQ().lTx == null) {
            ad aEQ = aEQ();
            as.Hm();
            aEQ.lTx = new e(com.tencent.mm.y.c.Fc());
        }
        return aEQ().lTx;
    }

    public static b aEX() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aEQ().lTs == null) {
            aEQ().lTs = new b();
        }
        return aEQ().lTs;
    }

    public static d aEY() {
        if (aEQ().lTz == null) {
            aEQ().lTz = new d();
        }
        return aEQ().lTz;
    }

    public static c aEZ() {
        if (aEQ().lTA == null) {
            aEQ().lTA = new c();
        }
        return aEQ().lTA;
    }

    public static a aFa() {
        if (aEQ().lTB == null) {
            aEQ().lTB = new a();
        }
        return aEQ().lTB;
    }

    public static com.tencent.mm.plugin.exdevice.f.a.c aFb() {
        if (aEQ().lTC == null) {
            aEQ().lTC = new com.tencent.mm.plugin.exdevice.f.a.c();
        }
        return aEQ().lTC;
    }

    public static e aFc() {
        if (aEQ().lTy == null) {
            aEQ().lTy = new e();
        }
        return aEQ().lTy;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        as.Hm();
        com.tencent.mm.y.c.Ff().a(this.lTI);
        as.CN().a(538, k.aEs());
        this.lTF = new af();
        com.tencent.mm.sdk.b.a.xmy.b(this.lTr);
        as.getSysCmdMsgExtension().a("wcdevicemsg", this.lTH, true);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lQJ);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lQK);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lQL);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lRe);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lQI);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lQH);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lQM);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lQN);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lQO);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lRf);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lQP);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lQQ);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lQR);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lQT);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lQS);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lQX);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lQV);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lQW);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lQY);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lRg);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().kAi);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lQU);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lQZ);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lRa);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lRb);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lRc);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lRp);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lRq);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lRr);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lRt);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lRs);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lRj);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lRk);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lRl);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lRm);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lRn);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lRo);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lRh);
        com.tencent.mm.sdk.b.a.xmy.b(aFc().lRi);
        com.tencent.mm.ad.e eVar = i.lSx;
        x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "addSceneEndListener");
        as.CN().a(539, eVar);
        com.tencent.mm.compatible.a.a.a(19, new com.tencent.mm.compatible.a.a.a() {
            public final void run() {
                ad.a(ad.this);
            }
        });
    }

    public final void bt(boolean z) {
    }

    public final void onAccountRelease() {
        as.Hm();
        com.tencent.mm.y.c.Ff().b(this.lTI);
        com.tencent.mm.sdk.b.a.xmy.c(aFc().lQJ);
        com.tencent.mm.sdk.b.a.xmy.c(aFc().lQK);
        com.tencent.mm.sdk.b.a.xmy.c(aFc().lQL);
        com.tencent.mm.sdk.b.a.xmy.c(aFc().lRe);
        com.tencent.mm.sdk.b.a.xmy.c(aFc().lRg);
        com.tencent.mm.sdk.b.a.xmy.c(aFc().lQI);
        com.tencent.mm.sdk.b.a.xmy.c(aFc().lQH);
        com.tencent.mm.sdk.b.a.xmy.c(aFc().lQM);
        com.tencent.mm.sdk.b.a.xmy.c(aFc().lQN);
        com.tencent.mm.sdk.b.a.xmy.c(aFc().lQO);
        com.tencent.mm.sdk.b.a.xmy.c(aFc().lRf);
        com.tencent.mm.sdk.b.a.xmy.c(aFc().lRp);
        com.tencent.mm.sdk.b.a.xmy.c(aFc().lRq);
        com.tencent.mm.sdk.b.a.xmy.c(aFc().lRr);
        com.tencent.mm.sdk.b.a.xmy.c(aFc().lRt);
        com.tencent.mm.sdk.b.a.xmy.c(aFc().lRs);
        com.tencent.mm.sdk.b.a.xmy.c(aFc().lRj);
        com.tencent.mm.sdk.b.a.xmy.c(aFc().lRk);
        com.tencent.mm.sdk.b.a.xmy.c(aFc().lRl);
        com.tencent.mm.sdk.b.a.xmy.c(aFc().lRm);
        com.tencent.mm.sdk.b.a.xmy.c(aFc().lRn);
        com.tencent.mm.sdk.b.a.xmy.c(aFc().lRo);
        com.tencent.mm.sdk.b.a.xmy.c(aFc().lQQ);
        com.tencent.mm.sdk.b.a.xmy.c(aFc().lRh);
        com.tencent.mm.sdk.b.a.xmy.c(aFc().lRi);
        x.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "releaseAllSharePreferences");
        SharedPreferences sharedPreferences = com.tencent.mm.sdk.platformtools.ad.getContext().getSharedPreferences("exdevice_pref", 0);
        if (sharedPreferences == null) {
            x.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
        } else if (!sharedPreferences.edit().clear().commit()) {
            x.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().clear().commit() Failed!!!");
        }
        f aFs = u.aFs();
        x.i("MicroMsg.exdevice.ExdeviceInfoManager", "delAllDeviceAuthFlag");
        if (aFs.lVT == null) {
            x.e("MicroMsg.exdevice.ExdeviceInfoManager", "null == exdeviceInfoList");
        } else {
            for (Entry entry : aFs.lVT.entrySet()) {
                f.a aVar = (f.a) entry.getValue();
                aVar.lVX = false;
                entry.setValue(aVar);
            }
        }
        as.CN().b(538, k.aEs());
        k.lPS = null;
        com.tencent.mm.sdk.b.a.xmy.c(this.lTr);
        as.getSysCmdMsgExtension().b("wcdevicemsg", this.lTH, true);
        com.tencent.mm.sdk.b.a.xmy.c(aFc().lQP);
        if (aEQ().lTs != null) {
            aEQ();
        }
        com.tencent.mm.ad.e eVar = i.lSx;
        x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "removeSceneEndListener");
        as.CN().b(539, eVar);
        d dVar = aEQ().lTz;
        if (!(dVar.lQo == null || dVar.lQo.isEmpty())) {
            for (Entry entry2 : dVar.lQo.entrySet()) {
                ((al) entry2.getValue()).TN();
            }
            dVar.lQo.clear();
        }
        if (aEQ().lTA != null) {
            eVar = aEQ().lTA;
            as.CN().b(1042, eVar);
            as.CN().b(1041, eVar);
            as.CN().b(1043, eVar);
            as.CN().b(1040, eVar);
        }
        if (aEQ().lTD != null) {
            aEQ().lTD.detach();
        }
        com.tencent.mm.sdk.b.a.xmy.c(this.lTF.gAp);
    }

    public static h aFd() {
        if (aEQ().lTG == null) {
            aEQ().lTG = new h();
        }
        return aEQ().lTG;
    }
}
