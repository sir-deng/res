package com.tencent.mm.plugin.card.ui;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.f.a.bv;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.ui.CardConsumeCodeUI;
import com.tencent.mm.plugin.card.ui.a.h;
import com.tencent.mm.plugin.card.ui.view.i;
import com.tencent.mm.plugin.card.ui.view.j;
import com.tencent.mm.plugin.card.ui.view.k;
import com.tencent.mm.plugin.card.ui.view.q;
import com.tencent.mm.plugin.card.ui.view.u;
import com.tencent.mm.plugin.card.ui.view.w;
import com.tencent.mm.plugin.card.ui.view.y;
import com.tencent.mm.plugin.card.ui.view.z;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aw;
import com.tencent.mm.protocal.c.kr;
import com.tencent.mm.protocal.c.oy;
import com.tencent.mm.protocal.c.ri;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.as;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"UseSparseArrays"})
public final class e implements com.tencent.mm.plugin.card.a.g.a, n, com.tencent.mm.ui.MMActivity.a {
    ListView Fv;
    private final String TAG = "MicroMsg.CardDetailUIContoller";
    LinearLayout ee;
    boolean fwD = false;
    OnClickListener iqi = new OnClickListener() {
        public final void onClick(View view) {
            boolean z = true;
            int i = false;
            String str;
            g gVar;
            Object[] objArr;
            oy oyVar;
            int i2;
            String aum;
            kr krVar;
            if (view.getId() == R.h.bPz || view.getId() == R.h.bPq) {
                if (e.this.kOv.atN()) {
                    if (e.this.kWY != null) {
                        e.this.kWY.awl();
                    }
                } else if (e.this.kOv.atO() && e.this.kWY != null) {
                    e.this.kWY.awj();
                }
            } else if (view.getId() == R.h.ckf || view.getId() == R.h.bIj) {
                com.tencent.mm.plugin.card.b.b.S(e.this.kWx, e.this.kWZ.kWh);
            } else if (view.getId() == R.h.bWx || view.getId() == R.h.bWo) {
                if (view.getId() == R.h.bWx) {
                    e.this.kWR = false;
                } else if (view.getId() == R.h.bWo) {
                    e.this.kWR = true;
                }
                if (e.this.kWE instanceof q) {
                    e.this.kWQ.laS = ((q) e.this.kWE).e(com.tencent.mm.plugin.card.b.c.CARDCODEREFRESHACTION_DOREFRESH);
                }
                j jVar = e.this.kWQ;
                boolean z2 = e.this.kWR;
                jVar.awN();
                jVar.kWR = z2;
                if (jVar.iqe != null && !jVar.iqe.isShowing()) {
                    jVar.iqe.showAtLocation(view.getRootView(), 17, 0, 0);
                    jVar.iqe.setFocusable(true);
                    jVar.iqe.setTouchable(true);
                    jVar.iqe.setBackgroundDrawable(new ColorDrawable(16777215));
                    jVar.iqe.setOutsideTouchable(true);
                    if (jVar.kWR) {
                        jVar.laO.setOnClickListener(jVar.iqi);
                        Bitmap bitmap = jVar.laK;
                        if (jVar.kTs != null) {
                            jVar.laK = l.t(jVar.kTs);
                        } else {
                            jVar.laK = null;
                        }
                        jVar.laO.setImageBitmap(jVar.laK);
                        jVar.laR.add(0, bitmap);
                        jVar.awP();
                        jVar.iqg.setVisibility(8);
                        jVar.laN.setVisibility(0);
                        str = jVar.kOv.auj().code;
                        if (jVar.kOv.aui().vZr == null || !jVar.kOv.aui().vZr.wgH) {
                            if (!com.tencent.pb.common.c.g.isNullOrEmpty(jVar.kOv.auj().vYv)) {
                                str = jVar.kOv.auj().vYv;
                            } else if (jVar.kOv.auc()) {
                                if (!com.tencent.pb.common.c.g.isNullOrEmpty(jVar.laS)) {
                                    str = jVar.laS;
                                }
                            }
                            if (!TextUtils.isEmpty(str) || str.length() > 40) {
                                jVar.laP.setVisibility(8);
                            } else {
                                jVar.laP.setText(m.xC(str));
                                if (jVar.kOv.atX()) {
                                    jVar.laP.setVisibility(0);
                                } else {
                                    jVar.laP.setVisibility(8);
                                }
                            }
                            if (TextUtils.isEmpty(jVar.kOv.aui().loF)) {
                                jVar.laQ.setText(jVar.kOv.aui().loF);
                                jVar.laQ.setVisibility(0);
                            } else {
                                jVar.laQ.setVisibility(8);
                            }
                        }
                        str = "";
                        if (TextUtils.isEmpty(str)) {
                        }
                        jVar.laP.setVisibility(8);
                        if (TextUtils.isEmpty(jVar.kOv.aui().loF)) {
                            jVar.laQ.setVisibility(8);
                        } else {
                            jVar.laQ.setText(jVar.kOv.aui().loF);
                            jVar.laQ.setVisibility(0);
                        }
                    } else {
                        jVar.iqf.setOnClickListener(jVar.iqi);
                        jVar.iqf.setImageBitmap(jVar.iqd);
                        str = jVar.kOv.auj().code;
                        if (jVar.kOv.aui().vZr == null || !jVar.kOv.aui().vZr.wgH) {
                            if (!com.tencent.pb.common.c.g.isNullOrEmpty(jVar.kOv.auj().vYv)) {
                                str = jVar.kOv.auj().vYv;
                            } else if (jVar.kOv.auc()) {
                                if (!com.tencent.pb.common.c.g.isNullOrEmpty(jVar.laS)) {
                                    str = jVar.laS;
                                }
                            }
                            if (!TextUtils.isEmpty(str) || str.length() > 40) {
                                jVar.laL.setVisibility(8);
                            } else {
                                jVar.laL.setText(m.xC(str));
                                if (jVar.kOv.atX()) {
                                    jVar.laL.setVisibility(0);
                                } else {
                                    jVar.laL.setVisibility(8);
                                }
                            }
                            if (TextUtils.isEmpty(jVar.kOv.aui().loF)) {
                                jVar.laM.setText(jVar.kOv.aui().loF);
                                jVar.laM.setVisibility(0);
                            } else {
                                jVar.laM.setVisibility(8);
                            }
                            jVar.iqg.setVisibility(0);
                            jVar.laN.setVisibility(8);
                        }
                        str = "";
                        if (TextUtils.isEmpty(str)) {
                        }
                        jVar.laL.setVisibility(8);
                        if (TextUtils.isEmpty(jVar.kOv.aui().loF)) {
                            jVar.laM.setVisibility(8);
                        } else {
                            jVar.laM.setText(jVar.kOv.aui().loF);
                            jVar.laM.setVisibility(0);
                        }
                        jVar.iqg.setVisibility(0);
                        jVar.laN.setVisibility(8);
                    }
                    jVar.iqe.update();
                }
            } else if (view.getId() == R.h.bQi || view.getId() == R.h.bQe || view.getId() == R.h.bQd || view.getId() == R.h.bWE || view.getId() == R.h.bQc) {
                if (view.getId() == R.h.bQi) {
                    if (e.this.kOv.atO()) {
                        int i3;
                        gVar = g.pWK;
                        objArr = new Object[9];
                        objArr[0] = "CardConsumedCodeUI";
                        objArr[1] = Integer.valueOf(e.this.kOv.aui().kPz);
                        objArr[2] = e.this.kOv.aun();
                        objArr[3] = e.this.kOv.aum();
                        objArr[4] = Integer.valueOf(0);
                        objArr[5] = Integer.valueOf(e.this.kWZ.kTE);
                        objArr[6] = e.this.kWZ.kWh;
                        if (e.this.kOv.aug()) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        objArr[7] = Integer.valueOf(i3);
                        objArr[8] = "";
                        gVar.h(11324, objArr);
                        if (e.this.kWY != null) {
                            e.this.kWY.eh(true);
                            return;
                        }
                        return;
                    }
                    e.this.a(true, new com.tencent.mm.plugin.card.a.j.b(), false);
                } else if (view.getId() != R.h.bWE || !e.this.kOv.aui().vZu) {
                    if (!e.this.kOv.atO()) {
                        e.this.a(false, new com.tencent.mm.plugin.card.a.j.b(), false);
                    } else if (e.this.kWY != null) {
                        e.this.kWY.eh(false);
                    }
                }
            } else if (view.getId() == R.h.bJC) {
                if (!TextUtils.isEmpty(e.this.kOv.aui().vYY)) {
                    com.tencent.mm.plugin.card.b.b.a(e.this.kWx, e.this.kOv.aui().vYY, 3);
                    g.pWK.h(11941, Integer.valueOf(13), e.this.kOv.aum(), e.this.kOv.aun(), "", e.this.kOv.aui().vYX);
                }
            } else if (view.getId() == R.h.bRK) {
                g.pWK.h(11582, "OpenShareUserSelectView", Integer.valueOf(0), Integer.valueOf(e.this.kOv.aui().kPz), e.this.kOv.aun(), e.this.kOv.aum(), e.this.kWZ.kWh);
                Intent intent = new Intent();
                intent.putExtra("KLabel_range_index", e.this.kUf);
                intent.putExtra("Klabel_name_list", e.this.kUg);
                intent.putExtra("Kother_user_name_list", e.this.kUh);
                intent.putExtra("k_sns_label_ui_title", e.this.kWx.getString(R.l.dPw));
                intent.putExtra("k_sns_label_ui_style", 0);
                intent.putExtra("KLabel_is_filter_private", true);
                com.tencent.mm.bl.d.b(e.this.kWx, "sns", ".ui.SnsLabelUI", intent, 2);
                e.this.kWx.jCj = e.this;
            } else if (view.getId() == R.h.bRV) {
                if (e.this.kOv.auj().vYj != null) {
                    LinkedList linkedList = e.this.kOv.auj().vYj;
                    int intValue = ((Integer) view.getTag()).intValue();
                    oyVar = (oy) linkedList.get(intValue);
                    if (com.tencent.mm.plugin.card.b.b.a(e.this.kOv.aum(), oyVar, e.this.kWZ.kTE, e.this.kWZ.kXf)) {
                        g.pWK.h(11941, Integer.valueOf(19), e.this.kOv.aum(), e.this.kOv.aun(), "", oyVar.title);
                    } else if (oyVar != null && !TextUtils.isEmpty(oyVar.url)) {
                        com.tencent.mm.plugin.card.b.b.a(e.this.kWx, oyVar.url, 1);
                        g gVar2 = g.pWK;
                        Object[] objArr2 = new Object[5];
                        switch (intValue) {
                            case 0:
                                i2 = 10;
                                break;
                            case 1:
                                i2 = 11;
                                break;
                            case 2:
                                i2 = 12;
                                break;
                            case 3:
                                i2 = 16;
                                break;
                            default:
                                i2 = 10;
                                break;
                        }
                        objArr2[0] = Integer.valueOf(i2);
                        objArr2[1] = e.this.kOv.aum();
                        objArr2[2] = e.this.kOv.aun();
                        objArr2[3] = "";
                        objArr2[4] = oyVar.title;
                        gVar2.h(11941, objArr2);
                        if (l.a(oyVar, e.this.kOv.aum())) {
                            aum = e.this.kOv.aum();
                            str = oyVar.title;
                            l.xA(aum);
                            com.tencent.mm.plugin.card.b.b.a(e.this.kWx, e.this.kOv.aui().kQL);
                        }
                    }
                }
            } else if (view.getId() == R.h.bRW) {
                if (e.this.kOv.auj().vYj != null) {
                    oyVar = (oy) e.this.kOv.auj().vYj.get(0);
                    if (com.tencent.mm.plugin.card.b.b.a(e.this.kOv.aum(), oyVar, e.this.kWZ.kTE, e.this.kWZ.kXf)) {
                        g.pWK.h(11941, Integer.valueOf(19), e.this.kOv.aum(), e.this.kOv.aun(), "", oyVar.title);
                    } else if (oyVar != null && !TextUtils.isEmpty(oyVar.url)) {
                        com.tencent.mm.plugin.card.b.b.a(e.this.kWx, oyVar.url, 1);
                        g.pWK.h(11941, Integer.valueOf(10), e.this.kOv.aum(), e.this.kOv.aun(), "", oyVar.title);
                        if (l.a(oyVar, e.this.kOv.aum())) {
                            aum = e.this.kOv.aum();
                            str = oyVar.title;
                            l.xA(aum);
                            com.tencent.mm.plugin.card.b.b.a(e.this.kWx, e.this.kOv.aui().kQL);
                        }
                    }
                }
            } else if (view.getId() == R.h.bSv || view.getId() == R.h.bRD) {
                if (e.this.kOv.auj().vYq == null) {
                    return;
                }
                if (e.this.kOv.aua()) {
                    if (!e.this.kOv.atO()) {
                        e.this.a(false, new com.tencent.mm.plugin.card.a.j.b(), false);
                    } else if (e.this.kWY != null) {
                        e.this.kWY.eh(false);
                    }
                } else if (e.this.kOv.aub()) {
                    com.tencent.mm.plugin.card.a.j.b bVar = new com.tencent.mm.plugin.card.a.j.b();
                    com.tencent.mm.plugin.card.b.b.a(e.this.kWx, bVar.kPo, bVar.kPp, false, e.this.kOv);
                } else {
                    oyVar = e.this.kOv.auj().vYq;
                    if (com.tencent.mm.plugin.card.b.b.a(e.this.kOv.aum(), oyVar, e.this.kWZ.kTE, e.this.kWZ.kXf)) {
                        g.pWK.h(11941, Integer.valueOf(20), e.this.kOv.aum(), e.this.kOv.aun(), "", oyVar.title);
                    } else if (oyVar != null && !TextUtils.isEmpty(oyVar.url)) {
                        com.tencent.mm.plugin.card.b.b.a(e.this.kWx, l.w(oyVar.url, oyVar.vZQ), 1);
                        g.pWK.h(11941, Integer.valueOf(9), e.this.kOv.aum(), e.this.kOv.aun(), "", oyVar.title);
                        if (l.a(oyVar, e.this.kOv.aum())) {
                            aum = e.this.kOv.aum();
                            str = oyVar.title;
                            l.xA(aum);
                            com.tencent.mm.plugin.card.b.b.a(e.this.kWx, e.this.kOv.aui().kQL);
                        }
                    }
                }
            } else if (view.getId() == R.h.bQt || view.getId() == R.h.bPB) {
                ri riVar = e.this.kOv.aui().vZe;
                gVar = g.pWK;
                objArr = new Object[9];
                objArr[0] = "CardLeftRightIntroduceView";
                objArr[1] = Integer.valueOf(e.this.kOv.aui().kPz);
                objArr[2] = e.this.kOv.aun();
                objArr[3] = e.this.kOv.aum();
                objArr[4] = Integer.valueOf(0);
                objArr[5] = Integer.valueOf(e.this.kWZ.kTE);
                objArr[6] = e.this.kWZ.kWh;
                if (e.this.kOv.aug()) {
                    i = 1;
                }
                objArr[7] = Integer.valueOf(i);
                objArr[8] = "";
                gVar.h(11324, objArr);
                if (riVar == null || TextUtils.isEmpty(riVar.url)) {
                    Intent intent2 = new Intent();
                    if (e.this.kOv instanceof CardInfo) {
                        intent2.putExtra("key_card_info_data", (CardInfo) e.this.kOv);
                    } else if (e.this.kOv instanceof ShareCardInfo) {
                        intent2.putExtra("key_card_info_data", (ShareCardInfo) e.this.kOv);
                    }
                    intent2.setClass(e.this.kWx, CardDetailPreference.class);
                    e.this.kWx.startActivity(intent2);
                    return;
                }
                com.tencent.mm.plugin.card.b.b.a(e.this.kWx, riVar.url, 1);
            } else if (view.getId() == R.h.cOe) {
                if (com.tencent.mm.plugin.card.sharecard.a.b.wT(e.this.kOv.aun()) > 1) {
                    e eVar = e.this;
                    if (e.this.kWA) {
                        z = false;
                    }
                    eVar.kWA = z;
                    e.this.avH();
                }
            } else if (view.getId() == R.h.bPF) {
                if (e.this.kOv.aui().vZa != null && !TextUtils.isEmpty(e.this.kOv.aui().vZa.url)) {
                    com.tencent.mm.plugin.card.b.b.a(e.this.kWx, e.this.kOv.aui().vZa.url, 3);
                    g.pWK.h(11941, Integer.valueOf(3), e.this.kOv.aum(), e.this.kOv.aun(), "", e.this.kOv.aui().vZa.text);
                }
            } else if (view.getId() == R.h.bPx) {
                if (e.this.kOv.aui().vZh != null && !bi.oN(e.this.kOv.aui().vZh.url)) {
                    com.tencent.mm.plugin.card.b.b.a(e.this.kWx, e.this.kOv.aui().vZh.url, 1);
                    g.pWK.h(11941, Integer.valueOf(14), e.this.kOv.aum(), e.this.kOv.aun(), "", e.this.kOv.aui().vZh.text);
                }
            } else if (view.getId() == R.h.cOj || view.getId() == R.h.cOk) {
                if (e.this.kOv.aui().vYQ <= 0) {
                    return;
                }
                if (e.this.kOB == null || e.this.kOB.size() == 0) {
                    x.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                    return;
                }
                krVar = (kr) e.this.kOB.get(0);
                com.tencent.mm.plugin.card.b.b.a(e.this.kWx, krVar.fAo, krVar.fBX, krVar.hzf);
                g gVar3 = g.pWK;
                Object[] objArr3 = new Object[9];
                objArr3[0] = "UsedStoresView";
                objArr3[1] = Integer.valueOf(e.this.kOv.aui().kPz);
                objArr3[2] = e.this.kOv.aun();
                objArr3[3] = e.this.kOv.aum();
                objArr3[4] = Integer.valueOf(0);
                objArr3[5] = Integer.valueOf(e.this.kWZ.kTE);
                objArr3[6] = e.this.kWZ.kWh;
                if (e.this.kOv.aug()) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                objArr3[7] = Integer.valueOf(i2);
                objArr3[8] = "";
                gVar3.h(11324, objArr3);
                g.pWK.h(11941, Integer.valueOf(5), e.this.kOv.aum(), e.this.kOv.aun(), "", krVar.name);
            } else if (view.getId() == R.h.cRv) {
                if (e.this.kOB == null || e.this.kOB.size() == 0) {
                    x.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                    return;
                }
                krVar = (kr) e.this.kOB.get(0);
                aum = (String) view.getTag();
                if (!TextUtils.isEmpty(aum) && aum.equals(e.this.kWx.getString(R.l.dNV))) {
                    e.a(e.this);
                } else if (!TextUtils.isEmpty(krVar.kRm)) {
                    com.tencent.mm.plugin.card.b.b.a(e.this.kWx, krVar.kRm, 1);
                    g.pWK.h(11941, Integer.valueOf(4), e.this.kOv.aum(), e.this.kOv.aun(), "", krVar.name);
                }
            } else if (view.getId() == R.h.cRq) {
                e.a(e.this);
            }
        }
    };
    ArrayList<kr> kOB;
    com.tencent.mm.plugin.card.base.b kOv;
    List<com.tencent.mm.plugin.card.model.b> kOz = new ArrayList();
    private View kTo;
    public int kUf = 0;
    String kUg = "";
    String kUh = "";
    public ArrayList<String> kUi = new ArrayList();
    public ArrayList<String> kUj = new ArrayList();
    boolean kWA = false;
    i kWB;
    i kWC;
    com.tencent.mm.plugin.card.widget.g kWD;
    com.tencent.mm.plugin.card.ui.view.g kWE;
    m kWF;
    i kWG;
    i kWH;
    i kWI;
    i kWJ;
    i kWK;
    i kWL;
    i kWM;
    i kWN;
    com.tencent.mm.plugin.card.ui.view.d kWO;
    i kWP;
    j kWQ;
    boolean kWR = true;
    f kWS;
    public String kWT = "";
    public String kWU = "";
    HashMap<Integer, String> kWV = new HashMap();
    HashMap<String, String> kWW = new HashMap();
    ArrayList<String> kWX = new ArrayList();
    d kWY;
    a kWZ;
    CardDetailBaseUI kWx;
    com.tencent.mm.plugin.card.ui.a.g kWy;
    i kWz;
    private ag kXa = new ag() {
        public final void handleMessage(Message message) {
            if (message.obj != null && (message.obj instanceof c)) {
                c cVar = (c) message.obj;
                if (cVar.kXl == b.kXj) {
                    if (e.this.kWE != null) {
                        com.tencent.mm.plugin.card.b.d.a(e.this.kWx, cVar.foE, false);
                        e.this.kWE.axG();
                    }
                } else if (cVar.kXl == b.kXh) {
                    if (e.this.kWE != null) {
                        e.this.kWE.d(com.tencent.mm.plugin.card.b.c.CARDCODEREFRESHACTION_SHOWING_TIMEOUT);
                    }
                } else if (e.this.kWE != null) {
                    e.this.kWE.d(cVar.kXm);
                }
            }
        }
    };
    com.tencent.mm.sdk.b.c kXb = new com.tencent.mm.sdk.b.c<bv>() {
        {
            this.xmG = bv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            bv bvVar = (bv) bVar;
            if (as.Hp()) {
                x.i("MicroMsg.CardDetailUIContoller", "deal with card notify event ConsumedCardByOfflinePayEvent");
                if (bvVar instanceof bv) {
                    if (bvVar.fqS.bjW == 0) {
                        com.tencent.mm.plugin.card.b.d.b(e.this.kWx, e.this.kWx.getResources().getString(R.l.dQd));
                    }
                    return true;
                }
            }
            return false;
        }
    };

    public static class a {
        public int kKY = 3;
        public String kOh = "";
        public boolean kPK = false;
        public int kTE = -1;
        public String kVL = "";
        public String kVM = "";
        public String kWh = "";
        public String kWi = "";
        public String kWj = "";
        public int kXf = 0;
    }

    public enum b {
        ;

        static {
            kXg = 1;
            kXh = 2;
            kXi = 3;
            kXj = 4;
            kXk = new int[]{kXg, kXh, kXi, kXj};
        }
    }

    private static class c {
        int errCode;
        String foE;
        int kXl;
        com.tencent.mm.plugin.card.b.c kXm;

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    public interface d {
        void awi();

        void awj();

        void awk();

        void awl();

        void awm();

        void awn();

        void awo();

        void d(com.tencent.mm.plugin.card.base.b bVar);

        void eh(boolean z);

        void xg(String str);
    }

    static /* synthetic */ void a(e eVar) {
        Intent intent = new Intent();
        if (eVar.kOv instanceof CardInfo) {
            intent.putExtra("key_card_info_data", (CardInfo) eVar.kOv);
        } else if (eVar.kOv instanceof ShareCardInfo) {
            intent.putExtra("key_card_info_data", (ShareCardInfo) eVar.kOv);
        }
        intent.putExtra("key_from_appbrand_type", eVar.kWZ.kXf);
        intent.setClass(eVar.kWx, CardShopUI.class);
        eVar.kWx.startActivity(intent);
        g gVar = g.pWK;
        Object[] objArr = new Object[9];
        objArr[0] = "UsedStoresView";
        objArr[1] = Integer.valueOf(eVar.kOv.aui().kPz);
        objArr[2] = eVar.kOv.aun();
        objArr[3] = eVar.kOv.aum();
        objArr[4] = Integer.valueOf(0);
        objArr[5] = Integer.valueOf(eVar.kWZ.kTE);
        objArr[6] = eVar.kWZ.kWh;
        objArr[7] = Integer.valueOf(eVar.kOv.aug() ? 1 : 0);
        objArr[8] = "";
        gVar.h(11324, objArr);
    }

    static /* synthetic */ void b(e eVar) {
        com.tencent.mm.plugin.card.b.b.a(eVar.kWx, 0, (com.tencent.mm.ui.MMActivity.a) eVar);
        eVar.kWx.jCj = eVar;
    }

    public e(CardDetailBaseUI cardDetailBaseUI, View view) {
        this.kWx = cardDetailBaseUI;
        this.kTo = view;
    }

    public final void a(com.tencent.mm.plugin.card.base.b bVar, a aVar, ArrayList<kr> arrayList) {
        this.kOv = bVar;
        this.kWZ = aVar;
        this.kOB = arrayList;
    }

    public final View findViewById(int i) {
        return this.kTo.findViewById(i);
    }

    public final com.tencent.mm.plugin.card.base.b awp() {
        return this.kOv;
    }

    public final void d(com.tencent.mm.plugin.card.base.b bVar) {
        if (bVar != null) {
            this.kOv = bVar;
            if (this.kWY != null) {
                this.kWY.d(bVar);
            }
            avH();
        }
    }

    public final boolean awq() {
        return this.kWA;
    }

    public final void awr() {
        this.kWA = false;
    }

    public final MMActivity aws() {
        return this.kWx;
    }

    public final OnClickListener awt() {
        return this.iqi;
    }

    public final com.tencent.mm.plugin.card.ui.a.g awu() {
        return this.kWy;
    }

    public final d awv() {
        return this.kWY;
    }

    public final a aww() {
        return this.kWZ;
    }

    public final f awx() {
        return this.kWS;
    }

    public final j awy() {
        return this.kWQ;
    }

    public final String getString(int i) {
        return this.kWx.getString(i);
    }

    public final void avH() {
        if (this.kOv == null) {
            x.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo == null");
            if (this.kWY != null) {
                this.kWY.awm();
            }
        } else if (this.kOv.aui() == null) {
            x.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getCardTpInfo() == null");
            if (this.kWY != null) {
                this.kWY.awm();
            }
        } else if (this.kOv.auj() == null) {
            x.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getDataInfo() == null");
            if (this.kWY != null) {
                this.kWY.awm();
            }
        } else if (this.kOv.atU()) {
            int i;
            x.i("MicroMsg.CardDetailUIContoller", "doUpdate()");
            x.i("MicroMsg.CardDetailUIContoller", "doUpdate() showAcceptView:" + this.kOv.aui().vZn);
            f fVar = this.kWS;
            com.tencent.mm.plugin.card.base.b bVar = this.kOv;
            ArrayList arrayList = this.kOB;
            int i2 = this.kWZ.kKY;
            fVar.kOv = bVar;
            fVar.kOB = arrayList;
            fVar.kKY = i2;
            boolean z = this.kWy == null ? false : this.kOv.atO() ? !(this.kWy instanceof h) : this.kOv.atP() ? !(this.kWy instanceof com.tencent.mm.plugin.card.ui.a.e) : this.kOv.atS() ? !(this.kWy instanceof com.tencent.mm.plugin.card.ui.a.b) : this.kOv.atQ() ? !(this.kWy instanceof com.tencent.mm.plugin.card.ui.a.c) : this.kOv.atR() ? !(this.kWy instanceof com.tencent.mm.plugin.card.ui.a.f) : this.kOv.atT() ? !(this.kWy instanceof com.tencent.mm.plugin.card.ui.a.d) : !(this.kWy instanceof com.tencent.mm.plugin.card.ui.a.a);
            if (z) {
                this.kWy.release();
                this.kWy = null;
                x.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, need recreate show logic, card_type:%d", Integer.valueOf(this.kOv.aui().kPz));
            }
            if (this.kWy == null) {
                x.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, mCardShowLogic == null, card_type:%d", Integer.valueOf(this.kOv.aui().kPz));
                x.i("MicroMsg.CardDetailUIContoller", "createShowLogic, card_type:%d", Integer.valueOf(this.kOv.aui().kPz));
                if (!this.kOv.atO()) {
                    switch (this.kOv.aui().kPz) {
                        case 0:
                            this.kWy = new com.tencent.mm.plugin.card.ui.a.c(this.kWx);
                            break;
                        case 10:
                            this.kWy = new com.tencent.mm.plugin.card.ui.a.e(this.kWx);
                            break;
                        case 11:
                            this.kWy = new com.tencent.mm.plugin.card.ui.a.b(this.kWx);
                            break;
                        case 20:
                            this.kWy = new com.tencent.mm.plugin.card.ui.a.f(this.kWx);
                            break;
                        case 30:
                            this.kWy = new com.tencent.mm.plugin.card.ui.a.d(this.kWx);
                            break;
                        default:
                            this.kWy = new com.tencent.mm.plugin.card.ui.a.a(this.kWx);
                            break;
                    }
                }
                this.kWy = new h(this.kWx);
            }
            x.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, card_tye:%d", Integer.valueOf(this.kOv.aui().kPz));
            this.kWy.a(this.kOv, this.kWZ);
            this.kWy.axC();
            x.i("MicroMsg.CardDetailUIContoller", "");
            if (this.kWy.axk()) {
                this.kWx.setMMTitle(this.kWS.getTitle());
            } else {
                this.kWx.setMMTitle("");
            }
            if (this.kOv == null) {
                x.e("MicroMsg.CardDetailUIContoller", "updateWidget, mCardInfo is null");
            } else {
                View axS;
                LinearLayout linearLayout;
                if (this.kWD != null) {
                    if (this.kOv.atP()) {
                        if (!(this.kWD instanceof com.tencent.mm.plugin.card.widget.e)) {
                            z = true;
                            if (z) {
                                axS = this.kWD.axS();
                                if (axS != null) {
                                    this.ee.removeView(axS);
                                }
                                this.ee.removeAllViews();
                                this.ee.invalidate();
                                this.kWD.release();
                                this.kWD = null;
                            }
                            if (this.kWD == null) {
                                if (this.kOv.atP()) {
                                    this.kWD = new com.tencent.mm.plugin.card.widget.e(this.kWx);
                                } else if (this.kOv.atS()) {
                                    this.kWD = new com.tencent.mm.plugin.card.widget.c(this.kWx);
                                } else if (this.kOv.atQ()) {
                                    this.kWD = new com.tencent.mm.plugin.card.widget.b(this.kWx);
                                } else if (this.kOv.atR()) {
                                    this.kWD = new com.tencent.mm.plugin.card.widget.f(this.kWx);
                                } else if (this.kOv.atT()) {
                                    this.kWD = new com.tencent.mm.plugin.card.widget.b(this.kWx);
                                } else {
                                    this.kWD = new com.tencent.mm.plugin.card.widget.d(this.kWx);
                                }
                                this.kWD.k(this.kOv);
                                axS = this.kWD.axS();
                                if (axS != null) {
                                    linearLayout = this.ee;
                                    axS.setLayoutParams(new LayoutParams(-1, -2));
                                    linearLayout.addView(axS);
                                }
                                this.ee.invalidate();
                                this.kWD.setOnClickListener(this.iqi);
                                r(false, false);
                            }
                            if (this.kWD != null) {
                                if (this.kOv.atR()) {
                                    ((com.tencent.mm.plugin.card.widget.f) this.kWD).kOB = this.kOB;
                                }
                                this.kWD.f(this.kOv);
                            }
                        }
                    } else if (this.kOv.atS()) {
                        if (!(this.kWD instanceof com.tencent.mm.plugin.card.widget.c)) {
                            z = true;
                            if (z) {
                                axS = this.kWD.axS();
                                if (axS != null) {
                                    this.ee.removeView(axS);
                                }
                                this.ee.removeAllViews();
                                this.ee.invalidate();
                                this.kWD.release();
                                this.kWD = null;
                            }
                            if (this.kWD == null) {
                                if (this.kOv.atP()) {
                                    this.kWD = new com.tencent.mm.plugin.card.widget.e(this.kWx);
                                } else if (this.kOv.atS()) {
                                    this.kWD = new com.tencent.mm.plugin.card.widget.c(this.kWx);
                                } else if (this.kOv.atQ()) {
                                    this.kWD = new com.tencent.mm.plugin.card.widget.b(this.kWx);
                                } else if (this.kOv.atR()) {
                                    this.kWD = new com.tencent.mm.plugin.card.widget.f(this.kWx);
                                } else if (this.kOv.atT()) {
                                    this.kWD = new com.tencent.mm.plugin.card.widget.b(this.kWx);
                                } else {
                                    this.kWD = new com.tencent.mm.plugin.card.widget.d(this.kWx);
                                }
                                this.kWD.k(this.kOv);
                                axS = this.kWD.axS();
                                if (axS != null) {
                                    linearLayout = this.ee;
                                    axS.setLayoutParams(new LayoutParams(-1, -2));
                                    linearLayout.addView(axS);
                                }
                                this.ee.invalidate();
                                this.kWD.setOnClickListener(this.iqi);
                                r(false, false);
                            }
                            if (this.kWD != null) {
                                if (this.kOv.atR()) {
                                    ((com.tencent.mm.plugin.card.widget.f) this.kWD).kOB = this.kOB;
                                }
                                this.kWD.f(this.kOv);
                            }
                        }
                    } else if (this.kOv.atQ()) {
                        if (!(this.kWD instanceof com.tencent.mm.plugin.card.widget.b)) {
                            z = true;
                            if (z) {
                                axS = this.kWD.axS();
                                if (axS != null) {
                                    this.ee.removeView(axS);
                                }
                                this.ee.removeAllViews();
                                this.ee.invalidate();
                                this.kWD.release();
                                this.kWD = null;
                            }
                            if (this.kWD == null) {
                                if (this.kOv.atP()) {
                                    this.kWD = new com.tencent.mm.plugin.card.widget.e(this.kWx);
                                } else if (this.kOv.atS()) {
                                    this.kWD = new com.tencent.mm.plugin.card.widget.c(this.kWx);
                                } else if (this.kOv.atQ()) {
                                    this.kWD = new com.tencent.mm.plugin.card.widget.b(this.kWx);
                                } else if (this.kOv.atR()) {
                                    this.kWD = new com.tencent.mm.plugin.card.widget.f(this.kWx);
                                } else if (this.kOv.atT()) {
                                    this.kWD = new com.tencent.mm.plugin.card.widget.d(this.kWx);
                                } else {
                                    this.kWD = new com.tencent.mm.plugin.card.widget.b(this.kWx);
                                }
                                this.kWD.k(this.kOv);
                                axS = this.kWD.axS();
                                if (axS != null) {
                                    linearLayout = this.ee;
                                    axS.setLayoutParams(new LayoutParams(-1, -2));
                                    linearLayout.addView(axS);
                                }
                                this.ee.invalidate();
                                this.kWD.setOnClickListener(this.iqi);
                                r(false, false);
                            }
                            if (this.kWD != null) {
                                if (this.kOv.atR()) {
                                    ((com.tencent.mm.plugin.card.widget.f) this.kWD).kOB = this.kOB;
                                }
                                this.kWD.f(this.kOv);
                            }
                        }
                    } else if (this.kOv.atR()) {
                        if (!(this.kWD instanceof com.tencent.mm.plugin.card.widget.f)) {
                            z = true;
                            if (z) {
                                axS = this.kWD.axS();
                                if (axS != null) {
                                    this.ee.removeView(axS);
                                }
                                this.ee.removeAllViews();
                                this.ee.invalidate();
                                this.kWD.release();
                                this.kWD = null;
                            }
                            if (this.kWD == null) {
                                if (this.kOv.atP()) {
                                    this.kWD = new com.tencent.mm.plugin.card.widget.e(this.kWx);
                                } else if (this.kOv.atS()) {
                                    this.kWD = new com.tencent.mm.plugin.card.widget.c(this.kWx);
                                } else if (this.kOv.atQ()) {
                                    this.kWD = new com.tencent.mm.plugin.card.widget.b(this.kWx);
                                } else if (this.kOv.atR()) {
                                    this.kWD = new com.tencent.mm.plugin.card.widget.f(this.kWx);
                                } else if (this.kOv.atT()) {
                                    this.kWD = new com.tencent.mm.plugin.card.widget.b(this.kWx);
                                } else {
                                    this.kWD = new com.tencent.mm.plugin.card.widget.d(this.kWx);
                                }
                                this.kWD.k(this.kOv);
                                axS = this.kWD.axS();
                                if (axS != null) {
                                    linearLayout = this.ee;
                                    axS.setLayoutParams(new LayoutParams(-1, -2));
                                    linearLayout.addView(axS);
                                }
                                this.ee.invalidate();
                                this.kWD.setOnClickListener(this.iqi);
                                r(false, false);
                            }
                            if (this.kWD != null) {
                                if (this.kOv.atR()) {
                                    ((com.tencent.mm.plugin.card.widget.f) this.kWD).kOB = this.kOB;
                                }
                                this.kWD.f(this.kOv);
                            }
                        }
                    } else if (this.kOv.atT() && !(this.kWD instanceof com.tencent.mm.plugin.card.widget.d)) {
                        z = true;
                        if (z) {
                            axS = this.kWD.axS();
                            if (axS != null) {
                                this.ee.removeView(axS);
                            }
                            this.ee.removeAllViews();
                            this.ee.invalidate();
                            this.kWD.release();
                            this.kWD = null;
                        }
                        if (this.kWD == null) {
                            if (this.kOv.atP()) {
                                this.kWD = new com.tencent.mm.plugin.card.widget.e(this.kWx);
                            } else if (this.kOv.atS()) {
                                this.kWD = new com.tencent.mm.plugin.card.widget.c(this.kWx);
                            } else if (this.kOv.atQ()) {
                                this.kWD = new com.tencent.mm.plugin.card.widget.b(this.kWx);
                            } else if (this.kOv.atR()) {
                                this.kWD = new com.tencent.mm.plugin.card.widget.f(this.kWx);
                            } else if (this.kOv.atT()) {
                                this.kWD = new com.tencent.mm.plugin.card.widget.d(this.kWx);
                            } else {
                                this.kWD = new com.tencent.mm.plugin.card.widget.b(this.kWx);
                            }
                            this.kWD.k(this.kOv);
                            axS = this.kWD.axS();
                            if (axS != null) {
                                linearLayout = this.ee;
                                axS.setLayoutParams(new LayoutParams(-1, -2));
                                linearLayout.addView(axS);
                            }
                            this.ee.invalidate();
                            this.kWD.setOnClickListener(this.iqi);
                            r(false, false);
                        }
                        if (this.kWD != null) {
                            if (this.kOv.atR()) {
                                ((com.tencent.mm.plugin.card.widget.f) this.kWD).kOB = this.kOB;
                            }
                            this.kWD.f(this.kOv);
                        }
                    }
                }
                z = false;
                if (z) {
                    axS = this.kWD.axS();
                    if (axS != null) {
                        this.ee.removeView(axS);
                    }
                    this.ee.removeAllViews();
                    this.ee.invalidate();
                    this.kWD.release();
                    this.kWD = null;
                }
                if (this.kWD == null) {
                    if (this.kOv.atP()) {
                        this.kWD = new com.tencent.mm.plugin.card.widget.e(this.kWx);
                    } else if (this.kOv.atS()) {
                        this.kWD = new com.tencent.mm.plugin.card.widget.c(this.kWx);
                    } else if (this.kOv.atQ()) {
                        this.kWD = new com.tencent.mm.plugin.card.widget.b(this.kWx);
                    } else if (this.kOv.atR()) {
                        this.kWD = new com.tencent.mm.plugin.card.widget.f(this.kWx);
                    } else if (this.kOv.atT()) {
                        this.kWD = new com.tencent.mm.plugin.card.widget.b(this.kWx);
                    } else {
                        this.kWD = new com.tencent.mm.plugin.card.widget.d(this.kWx);
                    }
                    this.kWD.k(this.kOv);
                    axS = this.kWD.axS();
                    if (axS != null) {
                        linearLayout = this.ee;
                        axS.setLayoutParams(new LayoutParams(-1, -2));
                        linearLayout.addView(axS);
                    }
                    this.ee.invalidate();
                    this.kWD.setOnClickListener(this.iqi);
                    r(false, false);
                }
                if (this.kWD != null) {
                    if (this.kOv.atR()) {
                        ((com.tencent.mm.plugin.card.widget.f) this.kWD).kOB = this.kOB;
                    }
                    this.kWD.f(this.kOv);
                }
            }
            if (this.kWy.axl()) {
                x.i("MicroMsg.CardDetailUIContoller", "updateShareUsersInfoLayout()");
                this.kWz.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't updateShareUsersInfoLayout()");
                this.kWz.axD();
            }
            if (this.kWy.axc()) {
                if (this.kWP == null) {
                    this.kWP = new com.tencent.mm.plugin.card.ui.view.b();
                    this.kWP.a(this);
                }
                x.i("MicroMsg.CardDetailUIContoller", "update CardAcceptView()");
                this.kWP.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't update CardAcceptView()");
                if (this.kWP != null) {
                    this.kWP.axD();
                }
            }
            this.kWx.ee(this.kWy.axg());
            if (this.kWy.axh()) {
                this.kWV.clear();
                this.kWX.clear();
                if (this.kOv.atW()) {
                    this.kWX.add(getString(R.l.eYv));
                    this.kWV.put(Integer.valueOf(0), "menu_func_share_friend");
                    this.kWX.add(getString(R.l.eYu));
                    this.kWV.put(Integer.valueOf(1), "menu_func_share_timeline");
                    i = 2;
                } else {
                    i = 0;
                }
                if (!TextUtils.isEmpty(this.kOv.auj().vYm)) {
                    this.kWX.add(getString(R.l.dOX));
                    this.kWV.put(Integer.valueOf(i), "menu_func_report");
                    i++;
                }
                ol(i);
                if (this.kWX.size() > 0) {
                    this.kWx.ee(true);
                }
            }
            if (this.kWy.axi()) {
                this.kWV.clear();
                this.kWX.clear();
                if (this.kOv.atN() && this.kOv.atV()) {
                    this.kWX.add(getString(R.l.dOW));
                    this.kWV.put(Integer.valueOf(0), "menu_func_gift");
                    i = 1;
                } else {
                    i = 0;
                }
                if (!TextUtils.isEmpty(this.kOv.auj().vYm)) {
                    this.kWX.add(getString(R.l.dOX));
                    this.kWV.put(Integer.valueOf(i), "menu_func_report");
                    i++;
                }
                if (this.kOv.atN()) {
                    this.kWX.add(getString(R.l.dEH));
                    this.kWV.put(Integer.valueOf(i), "menu_func_delete");
                    i++;
                } else if (this.kOv.atO()) {
                    String FY = com.tencent.mm.y.q.FY();
                    String auo = this.kOv.auo();
                    if (FY == null || !FY.equals(auo)) {
                        x.i("MicroMsg.CardDetailUIContoller", "the card is not belong mine");
                    } else {
                        this.kWX.add(getString(R.l.dEH));
                        this.kWV.put(Integer.valueOf(i), "menu_func_delete_share_card");
                        i++;
                    }
                }
                ol(i);
                if (this.kWX.size() > 0) {
                    this.kWx.ee(true);
                }
            }
            if (this.kWy.axj()) {
                this.kWV.clear();
                this.kWX.clear();
                if (TextUtils.isEmpty(this.kOv.auj().vYm)) {
                    i = 0;
                } else {
                    this.kWX.add(getString(R.l.dOX));
                    this.kWV.put(Integer.valueOf(0), "menu_func_report");
                    i = 1;
                }
                ol(i);
                if (this.kWX.size() > 0) {
                    this.kWx.ee(true);
                }
            }
            if (this.kWD != null && (this.kWD instanceof com.tencent.mm.plugin.card.widget.b)) {
                ((com.tencent.mm.plugin.card.widget.b) this.kWD).axY();
            }
            r(this.kWy.axe(), this.kWy.axf());
            if (!this.kOv.atP() && this.kWy.axn()) {
                x.i("MicroMsg.CardDetailUIContoller", "update mFromUserView");
                this.kWB.update();
            } else if (this.kOv.atP() && this.kWy.axn()) {
                x.i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout for username");
                this.kWC.update();
            } else if (this.kWy.axo()) {
                x.i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout");
                this.kWC.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't update mFromUserView and mAcceptHeaderLayout");
                this.kWC.axD();
                this.kWB.axD();
            }
            if (this.kWD != null) {
                this.kWD.ek(this.kWy.awA());
            }
            if (this.fwD) {
                x.i("MicroMsg.CardDetailUIContoller", "updateUIBackground onPause return");
            } else {
                View findViewById;
                LayoutParams layoutParams;
                if (this.kOv.atN() && this.kOv.atP()) {
                    this.kTo.findViewById(R.h.bQw).setBackgroundColor(this.kWx.getResources().getColor(R.e.brI));
                    com.tencent.mm.ui.statusbar.a.d(this.kTo, -1, true);
                    this.kWx.B(-1, true);
                } else {
                    i = l.xu(this.kOv.aui().hdx);
                    this.kTo.findViewById(R.h.bQw).setBackgroundColor(i);
                    com.tencent.mm.ui.statusbar.a.d(this.kTo, i, true);
                    this.kWx.B(i, false);
                }
                View findViewById2 = this.kTo.findViewById(R.h.cbp);
                View findViewById3 = this.kTo.findViewById(R.h.coA);
                View findViewById4 = this.kTo.findViewById(R.h.cbn);
                if (this.kOv.atN() && this.kWy.axn()) {
                    if (this.kOv.atQ()) {
                        findViewById2.setBackgroundResource(R.g.bAB);
                        this.kTo.findViewById(R.h.ckg).setBackgroundResource(R.g.bAp);
                        findViewById4.setBackgroundResource(0);
                    } else if (this.kOv.atP()) {
                        this.kTo.findViewById(R.h.ckg).setBackgroundResource(0);
                        findViewById4.setBackgroundColor(this.kWx.getResources().getColor(R.e.brI));
                    } else if (this.kOv.atR()) {
                        findViewById2.setBackgroundResource(R.g.bAB);
                        this.kTo.findViewById(R.h.ckg).setBackgroundResource(R.g.bAp);
                        findViewById4.setBackgroundResource(0);
                    } else if (!this.kOv.atS() && this.kOv.atT()) {
                        findViewById4.setBackgroundColor(this.kWx.getResources().getColor(R.e.brI));
                    }
                } else if (this.kOv.atO()) {
                    if (this.kWy.axl() && this.kWA) {
                        findViewById2.setBackgroundResource(R.g.bAB);
                        findViewById4.setBackgroundResource(0);
                    } else if (!this.kWy.axl() || this.kWA) {
                        findViewById2.setBackgroundResource(0);
                        if (this.kWy.awA()) {
                            findViewById4.setBackgroundResource(R.g.bAz);
                        } else {
                            findViewById4.setBackgroundResource(R.g.bAB);
                        }
                    } else {
                        findViewById2.setBackgroundResource(R.g.bAz);
                        findViewById4.setBackgroundResource(0);
                    }
                } else if (this.kOv.atQ()) {
                    findViewById2.setBackgroundResource(0);
                    if (this.kWy.awA()) {
                        findViewById4.setBackgroundResource(R.g.bAz);
                    } else {
                        findViewById4.setBackgroundResource(R.g.bAB);
                    }
                } else if (this.kOv.atR()) {
                    findViewById2.setBackgroundResource(R.g.bAD);
                    findViewById4.setBackgroundResource(0);
                } else {
                    findViewById2.setBackgroundResource(0);
                    findViewById4.setBackgroundColor(this.kWx.getResources().getColor(R.e.brI));
                }
                if (this.kOv.atT()) {
                    TextView textView = (TextView) this.kTo.findViewById(R.h.bOV);
                    Drawable bitmapDrawable = new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.Ds(R.g.bAy));
                    bitmapDrawable.setTileModeX(TileMode.REPEAT);
                    textView.setBackgroundDrawable(bitmapDrawable);
                    textView.setVisibility(0);
                }
                Rect rect = new Rect(0, 0, 0, 0);
                findViewById2.setPadding(rect.left, rect.top, rect.right, rect.bottom);
                findViewById2.invalidate();
                findViewById4.setPadding(rect.left, rect.top, rect.right, rect.bottom);
                findViewById4.invalidate();
                if (this.kOv.atO() && this.kWy.axl() && this.kWA) {
                    findViewById = this.kTo.findViewById(R.h.cOb);
                    findViewById.setPadding(rect.left, rect.top, rect.right, rect.bottom);
                    findViewById.invalidate();
                }
                if (this.kOv.atN() && this.kWy.axn()) {
                    findViewById = this.kTo.findViewById(R.h.ckg);
                    rect.left = this.kWx.getResources().getDimensionPixelOffset(R.f.bvw);
                    rect.right = this.kWx.getResources().getDimensionPixelOffset(R.f.bvw);
                    findViewById.setPadding(rect.left, rect.top, rect.right, rect.bottom);
                    findViewById.invalidate();
                    if (this.kOv.atR()) {
                        findViewById = this.kTo.findViewById(R.h.ckh);
                        layoutParams = (LayoutParams) findViewById.getLayoutParams();
                        int dimensionPixelSize = this.kWx.getResources().getDimensionPixelSize(R.f.bvT);
                        layoutParams.rightMargin = dimensionPixelSize;
                        layoutParams.leftMargin = dimensionPixelSize;
                        findViewById.setLayoutParams(layoutParams);
                    }
                }
                if (this.kWy.axn() || this.kWy.axl()) {
                    if (this.kWD != null && ((this.kOv.atN() && this.kOv.atQ()) || this.kOv.atO())) {
                        this.kWD.ot(0);
                    }
                } else if (this.kWD != null && ((this.kOv.atN() && this.kOv.atQ()) || this.kOv.atO())) {
                    if (this.kWy.awA()) {
                        this.kWD.ot(R.g.bAC);
                    } else {
                        this.kWD.ot(R.g.bAA);
                    }
                }
                if (this.kWD != null && this.kOv.atN() && this.kOv.atP()) {
                    this.kWD.a(l.cm(l.xu(this.kOv.aui().hdx), this.kWx.getResources().getDimensionPixelOffset(R.f.bwy)));
                }
                if (this.kOv.atN() && this.kOv.atP()) {
                    layoutParams = (LayoutParams) findViewById2.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    layoutParams.rightMargin = 0;
                    layoutParams.leftMargin = 0;
                    if (TextUtils.isEmpty(this.kOv.aui().vYX)) {
                        layoutParams.height = 0;
                        layoutParams.weight = 1.0f;
                    } else {
                        layoutParams.weight = 0.0f;
                        layoutParams.height = -2;
                    }
                    findViewById2.setLayoutParams(layoutParams);
                    layoutParams = (LayoutParams) findViewById3.getLayoutParams();
                    int dimensionPixelSize2 = this.kWx.getResources().getDimensionPixelSize(R.f.bvC);
                    layoutParams.rightMargin = dimensionPixelSize2;
                    layoutParams.leftMargin = dimensionPixelSize2;
                    if (this.kOv.atP()) {
                        layoutParams.topMargin = this.kWx.getResources().getDimensionPixelSize(R.f.bvz);
                        layoutParams.bottomMargin = this.kWx.getResources().getDimensionPixelSize(R.f.bvA);
                        dimensionPixelSize2 = this.kWx.getResources().getDimensionPixelSize(R.f.bvx);
                        layoutParams.rightMargin = dimensionPixelSize2;
                        layoutParams.leftMargin = dimensionPixelSize2;
                    } else {
                        dimensionPixelSize2 = this.kWx.getResources().getDimensionPixelSize(R.f.buw);
                        layoutParams.bottomMargin = dimensionPixelSize2;
                        layoutParams.topMargin = dimensionPixelSize2;
                    }
                    findViewById3.setLayoutParams(layoutParams);
                    layoutParams = (LayoutParams) findViewById4.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    layoutParams.rightMargin = 0;
                    layoutParams.leftMargin = 0;
                    if (this.kOv.atP()) {
                        layoutParams.bottomMargin = this.kWx.getResources().getDimensionPixelSize(R.f.bvx);
                    }
                    if (TextUtils.isEmpty(this.kOv.aui().vYX)) {
                        layoutParams.height = 0;
                        layoutParams.weight = 1.0f;
                    } else {
                        layoutParams.weight = 0.0f;
                        layoutParams.height = -2;
                    }
                    findViewById4.setLayoutParams(layoutParams);
                    if (!TextUtils.isEmpty(this.kOv.aui().vYX)) {
                        findViewById2 = findViewById(R.h.bJB);
                        layoutParams = (LayoutParams) findViewById2.getLayoutParams();
                        layoutParams.height = 0;
                        layoutParams.weight = 1.0f;
                        findViewById2.setLayoutParams(layoutParams);
                    }
                }
                this.kTo.invalidate();
            }
            if (this.kWy.axs()) {
                if (this.kWH == null) {
                    this.kWH = new y();
                    this.kWH.a(this);
                }
                x.i("MicroMsg.CardDetailUIContoller", "update CardStatusView");
                this.kWH.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't update CardStatusView");
                if (this.kWH != null) {
                    this.kWH.axD();
                }
            }
            if (this.kWy.axB()) {
                if (this.kWG == null) {
                    this.kWG = new com.tencent.mm.plugin.card.ui.view.c();
                    this.kWG.a(this);
                }
                x.i("MicroMsg.CardDetailUIContoller", "update mAdtitleView()");
                this.kWG.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't update AdTitleView()");
                if (this.kWG != null) {
                    this.kWG.axD();
                }
            }
            if (this.kWy.axt()) {
                if (this.kWI == null) {
                    this.kWI = new k();
                    this.kWI.a(this);
                }
                x.i("MicroMsg.CardDetailUIContoller", "update mCardDetailFieldView()");
                this.kWI.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't update mCardDetailFieldView()");
                if (this.kWI != null) {
                    this.kWI.axD();
                }
            }
            if (this.kWy.axu()) {
                if (this.kWJ == null) {
                    this.kWJ = new w();
                    this.kWJ.a(this);
                }
                x.i("MicroMsg.CardDetailUIContoller", "update CardSecondaryFieldView");
                this.kWJ.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't update CardSecondaryFieldView");
                if (this.kWJ != null) {
                    this.kWJ.axD();
                }
            }
            if (this.kWy.axv()) {
                if (this.kWK == null) {
                    this.kWK = new com.tencent.mm.plugin.card.ui.view.l();
                    this.kWK.a(this);
                }
                x.i("MicroMsg.CardDetailUIContoller", "update CardDetailTableView");
                this.kWK.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't update CardDetailTableView");
                if (this.kWK != null) {
                    this.kWK.axD();
                }
            }
            if (this.kWy.axw()) {
                if (this.kWL == null) {
                    this.kWL = new z();
                    this.kWL.a(this);
                }
                x.i("MicroMsg.CardDetailUIContoller", "update CardThirdFieldView");
                this.kWL.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't update CardThirdFieldView");
                if (this.kWL != null) {
                    this.kWL.axD();
                }
            }
            if (this.kWy.axy()) {
                if (this.kWM == null) {
                    this.kWM = new com.tencent.mm.plugin.card.ui.view.e();
                    this.kWM.a(this);
                }
                x.i("MicroMsg.CardDetailUIContoller", "updateCardAnnoucementView");
                this.kWM.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't updateCardAnnoucementView");
                if (this.kWM != null) {
                    this.kWM.axD();
                }
            }
            if (this.kWy.axx()) {
                if (this.kWN == null) {
                    this.kWN = new u();
                    this.kWN.a(this);
                }
                x.i("MicroMsg.CardDetailUIContoller", "updateCardOperateFieldView");
                this.kWN.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't updateCardOperateFieldView");
                if (this.kWN != null) {
                    this.kWN.axD();
                }
            }
            if (this.kWy.axp()) {
                com.tencent.mm.plugin.card.model.b bVar2;
                this.kOz.clear();
                List list = this.kOz;
                f fVar2 = this.kWS;
                fVar2.kOz.clear();
                if (!(fVar2.kOv.auj().vYu == null || bi.oN(fVar2.kOv.auj().vYu.title))) {
                    bVar2 = new com.tencent.mm.plugin.card.model.b();
                    bVar2.kPL = 1;
                    bVar2.title = fVar2.kOv.auj().vYu.title;
                    bVar2.kTd = "";
                    bVar2.url = "card://jump_card_gift";
                    bVar2.pfi = fVar2.kOv.auj().vYu.pfi;
                    fVar2.kOz.add(bVar2);
                }
                if (fVar2.kOv.auj().vYd != null && fVar2.kOv.auj().vYd.size() > 0) {
                    Collection ao = l.ao(fVar2.kOv.auj().vYd);
                    if (ao != null) {
                        ((com.tencent.mm.plugin.card.model.b) ao.get(0)).kPM = false;
                        fVar2.kOz.addAll(ao);
                    }
                }
                if (((fVar2.kKY == 6 && fVar2.kOv.auj().vYh <= 0) || l.os(fVar2.kKY)) && fVar2.kOv.aue() && fVar2.kOv.atN() && fVar2.kOv.atV()) {
                    bVar2 = new com.tencent.mm.plugin.card.model.b();
                    bVar2.kPL = 1;
                    bVar2.title = ad.getContext().getString(R.l.dOW);
                    bVar2.kTd = "";
                    bVar2.url = "card://jump_gift";
                    fVar2.kOz.add(bVar2);
                }
                if (!(fVar2.kOv.auj().status == 0 || fVar2.kOv.auj().status == 1)) {
                    i = fVar2.kOv.auj().status;
                }
                if (fVar2.kKY != 3 && fVar2.kKY == 6) {
                    i = fVar2.kOv.auj().vYh;
                }
                ri riVar = fVar2.kOv.aui().vZe;
                if (fVar2.kOv.auj().vYn != null) {
                    TextUtils.isEmpty(fVar2.kOv.auj().vYn.title);
                }
                com.tencent.mm.plugin.card.model.b bVar3 = new com.tencent.mm.plugin.card.model.b();
                z = fVar2.kOv.atT() ? false : riVar == null || riVar.wge == null || riVar.wge.size() <= 0 || TextUtils.isEmpty((CharSequence) riVar.wge.get(0));
                bVar3.kPM = false;
                bVar3.kPL = 1;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(fVar2.getTitle());
                stringBuilder.append(fVar2.getString(R.l.dOk));
                bVar3.title = stringBuilder.toString();
                bVar3.kPB = "";
                bVar3.kTd = "";
                bVar3.url = "card://jump_detail";
                if (z) {
                    fVar2.kOz.add(bVar3);
                }
                if (!fVar2.kOv.atR() || fVar2.kOv.aui().vYQ <= 0) {
                    kr krVar;
                    if (!fVar2.kOv.atP() || fVar2.kOv.aui().vYQ <= 0) {
                        if (fVar2.kOv.aui().vYQ > 0) {
                            x.e("MicroMsg.CardDetailDataMgr", "shop_count:" + fVar2.kOv.aui().vYQ);
                            if (fVar2.kOv.aui().vYQ > 0 && fVar2.kOB != null && fVar2.kOB.size() > 0) {
                                krVar = (kr) fVar2.kOB.get(0);
                                if (krVar != null && krVar.vYA < 50000.0f) {
                                    bVar3 = new com.tencent.mm.plugin.card.model.b();
                                    bVar3.kPL = 2;
                                    bVar3.title = krVar.name;
                                    bVar3.kPB = fVar2.kgL.getString(R.l.dPE, new Object[]{l.f(fVar2.kgL, krVar.vYA), krVar.hzf});
                                    bVar3.kTd = "";
                                    bVar3.url = "card://jump_shop";
                                    bVar3.kPP = krVar.kPP;
                                    bVar3.hdx = fVar2.kOv.aui().hdx;
                                    fVar2.kOz.add(bVar3);
                                } else if (krVar != null) {
                                    x.e("MicroMsg.CardDetailDataMgr", "distance:" + krVar.vYA);
                                }
                            }
                        }
                    }
                    if (fVar2.kOv.aui().vYQ > 0 && fVar2.kOB == null) {
                        bVar2 = new com.tencent.mm.plugin.card.model.b();
                        bVar2.kPL = 1;
                        if (TextUtils.isEmpty(fVar2.kOv.aui().vZp)) {
                            bVar2.title = fVar2.getString(R.l.dNQ);
                        } else {
                            bVar2.title = fVar2.kOv.aui().vZp;
                        }
                        bVar2.kPB = "";
                        bVar2.kTd = "";
                        bVar2.url = "card://jump_shop_list";
                        fVar2.kOz.add(bVar2);
                    } else if (fVar2.kOv.aui().vYQ > 0 && fVar2.kOB != null && fVar2.kOB.size() > 0) {
                        bVar3 = new com.tencent.mm.plugin.card.model.b();
                        bVar3.kPL = 1;
                        krVar = (kr) fVar2.kOB.get(0);
                        if (!TextUtils.isEmpty(fVar2.kOv.aui().vZp)) {
                            bVar3.title = fVar2.kOv.aui().vZp;
                        } else if (fVar2.kOv.atP() || krVar.vYA >= 5000.0f) {
                            bVar3.title = fVar2.getString(R.l.dNQ);
                        } else if (fVar2.kOv.aui().vYQ == 1 || fVar2.kOB.size() == 1) {
                            x.i("MicroMsg.CardDetailDataMgr", "shop_count is 1 or mShopList size is 1");
                        } else {
                            bVar3.title = fVar2.getString(R.l.dNW);
                        }
                        if (!fVar2.kOv.atP() || krVar.vYA >= 2000.0f) {
                            bVar3.kPB = "";
                        } else if (fVar2.kOv.aui().vYQ > 1 || (fVar2.kOB != null && fVar2.kOB.size() > 1)) {
                            bVar3.kPB = fVar2.kgL.getString(R.l.dOS, new Object[]{l.f(fVar2.kgL, krVar.vYA)});
                        } else {
                            bVar3.kPB = l.f(fVar2.kgL, krVar.vYA);
                        }
                        bVar3.kTd = "";
                        bVar3.url = "card://jump_shop_list";
                        fVar2.kOz.add(bVar3);
                    }
                }
                if (!((fVar2.kOv.atT() && fVar2.kOv.auj().status == 3) || TextUtils.isEmpty(fVar2.kOv.aui().vYJ))) {
                    fVar2.kOz.add(fVar2.auH());
                }
                list.addAll(fVar2.kOz);
                m mVar = this.kWF;
                Collection collection = this.kOz;
                mVar.kOz.clear();
                mVar.kOz.addAll(collection);
                this.kWF.lbz = this.kOv.atT();
                this.kWF.notifyDataSetChanged();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "card is membership or share card or general coupon, not accept, don't updateCellData()");
            }
            if (this.kWy.axq()) {
                this.kOv.a(this.kOv.auj());
                l.j(this.kOv);
                if (this.kWy.axr()) {
                    if (this.kWE == null) {
                        if (this.kOv.aui().vZr != null && this.kOv.aui().vZr.wgH) {
                            this.kWE = new com.tencent.mm.plugin.card.ui.view.m();
                            com.tencent.mm.plugin.card.a.g avx = am.avx();
                            if (avx.kOg == null) {
                                avx.kOg = new ArrayList();
                            }
                            if (this != null) {
                                avx.kOg.add(new WeakReference(this));
                            }
                        } else if (this.kOv.aui().kPz == 10) {
                            this.kWE = new q();
                        } else {
                            this.kWE = new j();
                        }
                        this.kWE.a(this);
                        this.kWE.update();
                    } else if (this.kWE.h(this.kOv)) {
                        this.kWE.d(this.kOv);
                        this.kWE.update();
                    }
                } else if (this.kWE != null) {
                    this.kWE.axD();
                }
                if (this.kWD != null) {
                    this.kWD.ej(true);
                }
            } else {
                x.e("MicroMsg.CardDetailUIContoller", "don't update CardCodeView");
                if (this.kWE != null) {
                    this.kWE.axD();
                }
                if (this.kWD != null) {
                    this.kWD.ej(false);
                }
            }
            if (this.kWy.axz()) {
                x.i("MicroMsg.CardDetailUIContoller", "update CardAdvertiseView");
                this.kWO.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't update CardAdvertiseView");
                this.kWO.axD();
            }
            this.kWQ.kOv = this.kOv;
        } else {
            x.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, not support card type :%d", Integer.valueOf(this.kOv.aui().kPz));
            if (TextUtils.isEmpty(this.kOv.aui().vYS)) {
                com.tencent.mm.ui.base.h.a(this.kWx, getString(R.l.dPc), null, false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        if (e.this.kWY != null) {
                            e.this.kWY.awm();
                        }
                    }
                });
                return;
            }
            com.tencent.mm.plugin.card.b.b.a(this.kWx, this.kOv.aui().vYS, 0);
            if (this.kWY != null) {
                this.kWY.awm();
            }
        }
    }

    public final void c(com.tencent.mm.plugin.card.b.c cVar) {
        x.i("MicroMsg.CardDetailUIContoller", "onGetCodeSuccess! do update code view!");
        Message obtain = Message.obtain();
        c cVar2 = new c();
        cVar2.kXl = b.kXg;
        cVar2.kXm = cVar;
        obtain.obj = cVar2;
        this.kXa.sendMessage(obtain);
    }

    public final void Y(int i, String str) {
        String string;
        x.e("MicroMsg.CardDetailUIContoller", "onGetCodeFail! errCode = %d, errMsg=%s", Integer.valueOf(i), str);
        Message obtain = Message.obtain();
        c cVar = new c();
        cVar.kXl = b.kXj;
        cVar.errCode = i;
        if (i == -1) {
            string = getString(R.l.dOp);
        } else if (i == 2) {
            string = getString(R.l.dOa);
        } else {
            string = getString(R.l.dOo);
        }
        cVar.foE = string;
        obtain.obj = cVar;
        this.kXa.sendMessage(obtain);
    }

    public final void auI() {
        x.i("MicroMsg.CardDetailUIContoller", "on show TimeExpired! do update refresh code view!");
        Message obtain = Message.obtain();
        c cVar = new c();
        cVar.kXl = b.kXh;
        obtain.obj = cVar;
        this.kXa.sendMessage(obtain);
    }

    public final void b(com.tencent.mm.plugin.card.b.c cVar) {
        x.i("MicroMsg.CardDetailUIContoller", "on onReceiveCodeUnavailable! do update refresh code view!");
        Message obtain = Message.obtain();
        c cVar2 = new c();
        cVar2.kXl = b.kXi;
        cVar2.kXm = cVar;
        obtain.obj = cVar2;
        this.kXa.sendMessage(obtain);
    }

    public final void a(boolean z, com.tencent.mm.plugin.card.a.j.b bVar, boolean z2) {
        int i = 1;
        g gVar;
        Object[] objArr;
        if (z) {
            oy oyVar = this.kOv.auj().vYq;
            g gVar2;
            Object[] objArr2;
            if (this.kOv.aub()) {
                com.tencent.mm.plugin.card.b.b.a(this.kWx, bVar.kPo, bVar.kPp, z2, this.kOv);
                g.pWK.h(11941, Integer.valueOf(17), this.kOv.aum(), this.kOv.aun(), "", this.kOv.auj().vYq.title);
                return;
            } else if (oyVar != null && !TextUtils.isEmpty(oyVar.vYB) && !TextUtils.isEmpty(oyVar.vYC)) {
                com.tencent.mm.plugin.card.b.b.a(this.kOv.aum(), oyVar, this.kWZ.kTE, this.kWZ.kXf);
                gVar2 = g.pWK;
                objArr2 = new Object[5];
                objArr2[0] = Integer.valueOf(6);
                objArr2[1] = this.kOv.aum();
                objArr2[2] = this.kOv.aun();
                objArr2[3] = "";
                objArr2[4] = oyVar.title != null ? oyVar.title : "";
                gVar2.h(11941, objArr2);
                return;
            } else if (oyVar == null || TextUtils.isEmpty(oyVar.url)) {
                gVar = g.pWK;
                objArr = new Object[9];
                objArr[0] = "CardConsumedCodeUI";
                objArr[1] = Integer.valueOf(this.kOv.aui().kPz);
                objArr[2] = this.kOv.aun();
                objArr[3] = this.kOv.aum();
                objArr[4] = Integer.valueOf(0);
                objArr[5] = Integer.valueOf(this.kWZ.kTE);
                objArr[6] = this.kWZ.kWh;
                if (!this.kOv.aug()) {
                    i = 0;
                }
                objArr[7] = Integer.valueOf(i);
                objArr[8] = "";
                gVar.h(11324, objArr);
                xh(bVar.kPl);
                return;
            } else {
                com.tencent.mm.plugin.card.b.b.a(this.kWx, l.w(oyVar.url, oyVar.vZQ), 1);
                gVar2 = g.pWK;
                objArr2 = new Object[5];
                objArr2[0] = Integer.valueOf(6);
                objArr2[1] = this.kOv.aum();
                objArr2[2] = this.kOv.aun();
                objArr2[3] = "";
                objArr2[4] = oyVar.title != null ? oyVar.title : "";
                gVar2.h(11941, objArr2);
                return;
            }
        }
        gVar = g.pWK;
        objArr = new Object[9];
        objArr[0] = "CardConsumedCodeUI";
        objArr[1] = Integer.valueOf(this.kOv.aui().kPz);
        objArr[2] = this.kOv.aun();
        objArr[3] = this.kOv.aum();
        objArr[4] = Integer.valueOf(0);
        objArr[5] = Integer.valueOf(this.kWZ.kTE);
        objArr[6] = this.kWZ.kWh;
        if (!this.kOv.aug()) {
            i = 0;
        }
        objArr[7] = Integer.valueOf(i);
        objArr[8] = "";
        gVar.h(11324, objArr);
        xh(bVar.kPl);
    }

    private void r(boolean z, boolean z2) {
        if (this.kWD != null) {
            this.kWD.r(z, z2);
        }
    }

    private void ol(int i) {
        LinkedList linkedList = this.kOv.auj().vYo;
        if (linkedList != null) {
            this.kWW.clear();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < linkedList.size()) {
                    aw awVar = (aw) linkedList.get(i3);
                    if (!(bi.oN(awVar.text) || bi.oN(awVar.url))) {
                        this.kWX.add(awVar.text);
                        this.kWV.put(Integer.valueOf(i), awVar.text);
                        this.kWW.put(awVar.text, awVar.url);
                        i++;
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final void b(final int i, int i2, Intent intent) {
        switch (i) {
            case 0:
            case 1:
            case 4:
                if (i2 == -1) {
                    this.kWT = intent.getStringExtra("Select_Conv_User");
                    final String str = this.kWT;
                    if (this.kOv.aui() == null) {
                        x.e("MicroMsg.CardDetailUIContoller", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    if (i == 0) {
                        if (TextUtils.isEmpty(this.kOv.auk().wTA)) {
                            stringBuilder.append(getString(R.l.eQm));
                        } else {
                            stringBuilder.append(this.kOv.auk().wTA);
                        }
                    } else if (i == 1) {
                        stringBuilder.append(getString(R.l.dPD) + this.kWS.getTitle());
                    } else if (i == 4) {
                        stringBuilder.append(getString(R.l.dPf) + this.kWS.getTitle());
                    }
                    com.tencent.mm.pluginsdk.ui.applet.e.a(this.kWx.mController, stringBuilder.toString(), this.kOv.aui().kPA, this.kOv.aui().title + "\n" + this.kOv.aui().kQL, null, true, this.kWx.getResources().getString(R.l.dGL), new com.tencent.mm.pluginsdk.ui.applet.o.a() {
                        public final void a(boolean z, String str, int i) {
                            if (z) {
                                e.this.kWU = str;
                                e eVar;
                                if (i == 0) {
                                    if (e.this.kWY != null) {
                                        e.this.kWY.xg(str);
                                    }
                                    g.pWK.h(11582, "OperGift", Integer.valueOf(1), Integer.valueOf(e.this.kOv.aui().kPz), e.this.kOv.aun(), e.this.kOv.aum(), e.this.kWT);
                                    com.tencent.mm.ui.base.h.bu(e.this.kWx, e.this.kWx.getResources().getString(R.l.dOz));
                                } else if (i == 1) {
                                    eVar = e.this;
                                    eVar.kOv.auk().wTA = eVar.getString(R.l.dPD) + eVar.kWS.getTitle();
                                    l.a(eVar.kOv, eVar.kWT, eVar.kWZ.kWj, 2);
                                    l.cg(eVar.kWU, eVar.kWT);
                                    com.tencent.mm.ui.base.h.bu(e.this.kWx, e.this.kWx.getResources().getString(R.l.dOz));
                                } else if (i == 4) {
                                    eVar = e.this;
                                    if (TextUtils.isEmpty(eVar.kOv.auo())) {
                                        eVar.kOv.wz(com.tencent.mm.y.q.FY());
                                    }
                                    eVar.kOv.auk().wTA = eVar.getString(R.l.dPf) + eVar.kWS.getTitle();
                                    l.a(eVar.kOv, eVar.kWT, eVar.kWZ.kWj, 23);
                                    l.cg(eVar.kWU, eVar.kWT);
                                    g.pWK.h(11582, "OpeRecommendCard", Integer.valueOf(e.this.kWZ.kKY), Integer.valueOf(e.this.kOv.aui().kPz), e.this.kOv.aun(), e.this.kOv.aum(), e.this.kWT);
                                    com.tencent.mm.ui.base.h.bu(e.this.kWx, e.this.kWx.getResources().getString(R.l.dOz));
                                }
                            }
                        }
                    });
                    return;
                }
                return;
            case 2:
                if (i2 == -1) {
                    this.kUf = intent.getIntExtra("Ktag_range_index", 0);
                    x.i("MicroMsg.CardDetailUIContoller", "mPrivateSelelct : %d", Integer.valueOf(this.kUf));
                    if (this.kUf >= 2) {
                        this.kUg = intent.getStringExtra("Klabel_name_list");
                        this.kUh = intent.getStringExtra("Kother_user_name_list");
                        x.d("MicroMsg.CardDetailUIContoller", "mPrivateSelect : %d, names : %s", Integer.valueOf(this.kUf), this.kUg);
                        if (TextUtils.isEmpty(this.kUg) && TextUtils.isEmpty(this.kUh)) {
                            x.e("MicroMsg.CardDetailUIContoller", "mLabelNameList by getIntent is empty");
                            return;
                        }
                        List asList = Arrays.asList(this.kUg.split(","));
                        this.kUj = l.aq(asList);
                        this.kUi = l.ap(asList);
                        if (this.kUh != null && this.kUh.length() > 0) {
                            this.kUi.addAll(Arrays.asList(this.kUh.split(",")));
                        }
                        if (this.kUj != null) {
                            x.i("MicroMsg.CardDetailUIContoller", "mPrivateIdsList size is " + this.kUj.size());
                        }
                        if (this.kUi != null) {
                            x.i("MicroMsg.CardDetailUIContoller", "mPrivateNamesList size is " + this.kUi.size());
                            Iterator it = this.kUi.iterator();
                            while (it.hasNext()) {
                                x.d("MicroMsg.CardDetailUIContoller", "username : %s", (String) it.next());
                            }
                        }
                        if (this.kUf == 2) {
                            this.kWO.xk(this.kWx.getString(R.l.dPv, new Object[]{avJ()}));
                            return;
                        } else if (this.kUf == 3) {
                            this.kWO.xk(this.kWx.getString(R.l.dPu, new Object[]{avJ()}));
                            return;
                        } else {
                            this.kWO.xk(this.kWx.getString(R.l.dPt));
                            return;
                        }
                    }
                    this.kWO.xk(this.kWx.getString(R.l.dPt));
                    return;
                }
                return;
            case 3:
                if (this.kWY != null) {
                    this.kWY.awo();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private String avJ() {
        if (!TextUtils.isEmpty(this.kUg) && !TextUtils.isEmpty(this.kUh)) {
            return this.kUg + "," + l.xy(this.kUh);
        }
        if (!TextUtils.isEmpty(this.kUg)) {
            return this.kUg;
        }
        if (TextUtils.isEmpty(this.kUh)) {
            return "";
        }
        return l.xy(this.kUh);
    }

    private void xh(String str) {
        Intent intent = new Intent();
        if (this.kOv instanceof CardInfo) {
            intent.putExtra("key_card_info_data", (CardInfo) this.kOv);
        } else if (this.kOv instanceof ShareCardInfo) {
            intent.putExtra("key_card_info_data", (ShareCardInfo) this.kOv);
        }
        intent.setClass(this.kWx, CardConsumeCodeUI.class);
        intent.putExtra("key_from_scene", this.kWZ.kKY);
        intent.putExtra("key_previous_scene", this.kWZ.kTE);
        intent.putExtra("key_mark_user", str);
        intent.putExtra("key_from_appbrand_type", this.kWZ.kXf);
        this.kWx.startActivityForResult(intent, 3);
        this.kWx.jCj = this;
    }

    public final int awz() {
        if (this.kWS == null) {
            return 0;
        }
        f fVar = this.kWS;
        if (fVar.kOA == null ? false : fVar.kOA.kPO) {
            return 1;
        }
        return 0;
    }

    public final boolean awA() {
        return this.kWy == null ? false : this.kWy.awA();
    }
}
