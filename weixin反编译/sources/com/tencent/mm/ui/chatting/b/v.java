package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ap.i.a;
import com.tencent.mm.ap.l;
import com.tencent.mm.ap.n;
import com.tencent.mm.ap.o;
import com.tencent.mm.j.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.ab;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.media.e;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.chatting.af;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.widget.DrawedCallBackLinearLayout;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;
import java.util.ArrayList;
import java.util.Iterator;

public final class v implements a {
    public p fhH;
    i ott;
    public ad yEA;
    public l yEy;

    /* renamed from: com.tencent.mm.ui.chatting.b.v$5 */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ String yJO;

        AnonymousClass5(String str) {
            this.yJO = str;
        }

        public final void run() {
            v.this.fhH.ctp().p(this.yJO, -1, false);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.b.v$4 */
    class AnonymousClass4 implements OnClickListener {
        final /* synthetic */ boolean yJM;
        final /* synthetic */ String yJN;

        AnonymousClass4(boolean z, String str) {
            this.yJM = z;
            this.yJN = str;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            if (!this.yJM || v.this.fhH.ctp() == null || v.this.fhH.ctp().vqk == null || !(v.this.fhH.ctp().vqk instanceof com.tencent.mm.ui.chatting.v)) {
                as.CN().a(new l(5, v.this.fhH.ctj(), v.this.fhH.csn(), this.yJN, 0, null, 0, "", "", true, R.g.bAI), 0);
                return;
            }
            Options options = new Options();
            options.inJustDecodeBounds = true;
            if ((d.decodeFile(this.yJN, options) == null || options.outHeight <= b.zL()) && options.outWidth <= b.zL()) {
                String a = ((c) g.k(c.class)).getEmojiMgr().a(v.this.fhH.cte().getContext(), new WXMediaMessage(new WXEmojiObject(this.yJN)), null);
                if (a != null) {
                    ((com.tencent.mm.ui.chatting.v) v.this.fhH.ctp().vqk).m(((c) g.k(c.class)).getEmojiMgr().yI(a));
                    return;
                }
                return;
            }
            Toast.makeText(v.this.fhH.cte().getContext(), R.l.dZW, 0).show();
        }
    }

    public v(p pVar) {
        this.fhH = pVar;
    }

    public final boolean f(final int i, final Intent intent) {
        int i2 = 1;
        String str;
        String csn;
        switch (i) {
            case 200:
                if (intent == null) {
                    return true;
                }
                boolean z;
                Intent intent2 = new Intent();
                intent2.setClassName(this.fhH.cte().getContext(), "com.tencent.mm.ui.tools.CropImageNewUI");
                intent2.putExtra("CropImageMode", 4);
                intent2.putExtra("CropImage_Filter", true);
                str = "CropImage_Has_Raw_Img_Btn";
                csn = this.fhH.csn();
                if (csn == null || !(x.Xd(csn) || x.Xf(csn))) {
                    z = true;
                } else {
                    z = false;
                }
                intent2.putExtra(str, z);
                intent2.putExtra("from_source", 3);
                u cte = this.fhH.cte();
                as.Hm();
                String Fp = com.tencent.mm.y.c.Fp();
                if (intent.getData().toString().startsWith("content://com.google.android.gallery3d")) {
                    new com.tencent.mm.ui.tools.a.AnonymousClass1(intent, cte, Fp, null, intent2, 203).execute(new Integer[]{Integer.valueOf(0)});
                    return true;
                }
                csn = com.tencent.mm.ui.tools.a.c(cte.getContext(), intent, Fp);
                if (bi.oN(csn)) {
                    return true;
                }
                intent2.putExtra("CropImage_ImgPath", csn);
                cte.startActivityForResult(intent2, 203);
                return true;
            case 201:
                Context applicationContext = this.fhH.cte().getContext().getApplicationContext();
                as.Hm();
                csn = k.b(applicationContext, intent, com.tencent.mm.y.c.Fp());
                if (csn == null) {
                    return true;
                }
                Intent intent3 = new Intent();
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(csn);
                intent3.putExtra("query_source_type", 3);
                intent3.putExtra("preview_image", true);
                intent3.putExtra("isTakePhoto", true);
                intent3.putExtra("GalleryUI_FromUser", this.fhH.ctj());
                intent3.putExtra("GalleryUI_ToUser", this.fhH.csn());
                intent3.putExtra("is_long_click", true);
                intent3.putStringArrayListExtra("preview_image_list", arrayList);
                intent3.addFlags(67108864);
                com.tencent.mm.bl.d.a(this.fhH.cte(), "gallery", ".ui.GalleryEntryUI", intent3, (int) e.CTRL_INDEX);
                return true;
            case 203:
                csn = intent.getStringExtra("CropImage_OutputPath");
                if (csn != null) {
                    boolean a = q.a(csn, this.fhH.csn(), intent.getBooleanExtra("CropImage_Compress_Img", true));
                    intent.getIntExtra("from_source", 0);
                    int intExtra = intent.getIntExtra("CropImage_rotateCount", 0);
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.SendImgImp", "dkimgsource" + intent.getIntExtra("from_source", 0));
                    if (!a) {
                        i2 = 0;
                    }
                    u(i2, intExtra, csn);
                    this.fhH.ctp().clearFocus();
                    break;
                }
                this.fhH.ctp().clearFocus();
                return true;
            case e.CTRL_INDEX /*217*/:
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("GalleryUI_ToUser");
                    str = bi.oN(stringExtra) ? this.fhH.csY() : stringExtra;
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.SendImgImp", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE userFromIntent:%s rawUsername:%s", stringExtra, this.fhH.csY());
                    this.fhH.ctp().clearFocus();
                    this.fhH.ctp().ccC();
                    DrawedCallBackLinearLayout drawedCallBackLinearLayout = (DrawedCallBackLinearLayout) this.fhH.cte().getView().findViewById(R.h.bTC);
                    if (drawedCallBackLinearLayout != null) {
                        drawedCallBackLinearLayout.zCc = new DrawedCallBackLinearLayout.a() {
                            public final void aOR() {
                                as.Dt().g(new Runnable() {
                                    public final void run() {
                                        as.Dt().tT();
                                        v vVar = v.this;
                                        Intent intent = intent;
                                        String str = str;
                                        if (intent != null) {
                                            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                                            l.bk(intent.getLongExtra("KSelectImgUseTime", 0));
                                            if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI.SendImgImp", "send image list is null or nil");
                                            } else {
                                                ArrayList ls;
                                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.SendImgImp", "sendMutiImage rawUserName:%s %s", vVar.fhH.csY(), stringArrayListExtra.toString());
                                                ArrayList integerArrayListExtra = intent.getIntegerArrayListExtra("GalleryUI_ImgIdList");
                                                if (integerArrayListExtra == null || (integerArrayListExtra.size() == 1 && ((Integer) integerArrayListExtra.get(0)).intValue() == -1)) {
                                                    ls = n.Pt().ls(str);
                                                } else {
                                                    ls = integerArrayListExtra;
                                                }
                                                if (intent == null || stringArrayListExtra == null || stringArrayListExtra.size() == 0) {
                                                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI.SendImgImp", "filelist is empty!");
                                                } else {
                                                    boolean booleanExtra = intent.getBooleanExtra("isTakePhoto", false);
                                                    boolean booleanExtra2 = intent.getBooleanExtra("CropImage_Compress_Img", true);
                                                    if (booleanExtra2) {
                                                        com.tencent.mm.plugin.report.service.g.pWK.h(11095, Integer.valueOf(1));
                                                    } else {
                                                        com.tencent.mm.plugin.report.service.g.pWK.h(11095, Integer.valueOf(0));
                                                    }
                                                    int intExtra = intent.getIntExtra("CropImage_rotateCount", 0);
                                                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.SendImgImp", "dkimgsource source:%d  isTakePhoto:%b rotateCount:%d compressImg:%b rawUserName:%s", Integer.valueOf(3), Boolean.valueOf(booleanExtra), Integer.valueOf(intExtra), Boolean.valueOf(booleanExtra2), vVar.fhH.csY());
                                                    if (vVar.fhH.ctk() == null || vVar.fhH.ctk().isEnable()) {
                                                        LatLongData latLongData;
                                                        if (booleanExtra) {
                                                            latLongData = (LatLongData) intent.getParcelableExtra("KlatLng");
                                                            if (latLongData != null) {
                                                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.SendImgImp", "latLongData %f %f", Float.valueOf(latLongData.fAo), Float.valueOf(latLongData.hDw));
                                                                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
                                                                Object[] objArr = new Object[4];
                                                                objArr[0] = Integer.valueOf((int) (latLongData.fAo * 1000000.0f));
                                                                objArr[1] = Integer.valueOf((int) (latLongData.hDw * 1000000.0f));
                                                                objArr[2] = Integer.valueOf(booleanExtra ? 1 : 2);
                                                                objArr[3] = Integer.valueOf(1);
                                                                gVar.h(11345, objArr);
                                                            }
                                                        }
                                                        ArrayList arrayList = new ArrayList();
                                                        ArrayList arrayList2 = new ArrayList();
                                                        int zK = b.zK();
                                                        int zM = b.zM();
                                                        Iterator it = stringArrayListExtra.iterator();
                                                        while (it.hasNext()) {
                                                            String str2 = (String) it.next();
                                                            if (str2 == null || str2.equals("") || !com.tencent.mm.a.e.bO(str2)) {
                                                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.SendImgImp", " doSendImage : filePath is null or empty");
                                                            } else {
                                                                if (!booleanExtra) {
                                                                    latLongData = ExifHelper.Vp(str2);
                                                                    if (latLongData != null) {
                                                                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.SendImgImp", "latLongData %f %f", Float.valueOf(latLongData.fAo), Float.valueOf(latLongData.hDw));
                                                                        com.tencent.mm.plugin.report.service.g gVar2 = com.tencent.mm.plugin.report.service.g.pWK;
                                                                        Object[] objArr2 = new Object[4];
                                                                        objArr2[0] = Integer.valueOf((int) (latLongData.fAo * 1000000.0f));
                                                                        objArr2[1] = Integer.valueOf((int) (latLongData.hDw * 1000000.0f));
                                                                        objArr2[2] = Integer.valueOf(booleanExtra ? 1 : 2);
                                                                        objArr2[3] = Integer.valueOf(1);
                                                                        gVar2.h(11345, objArr2);
                                                                    } else {
                                                                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.SendImgImp", "cannot get location");
                                                                    }
                                                                }
                                                                if (!vVar.yEy.a(str, str2, arrayList2, zK, zM)) {
                                                                    arrayList.add(str2);
                                                                }
                                                            }
                                                        }
                                                        if (!g.W(vVar.fhH.csW())) {
                                                            int i = 98;
                                                            if (booleanExtra) {
                                                                i = intent.getBooleanExtra("is_long_click", false) ? 99 : 97;
                                                            }
                                                            com.tencent.mm.plugin.report.service.g.pWK.a(106, (long) i, 1, false);
                                                            com.tencent.mm.plugin.report.service.g.pWK.a(106, booleanExtra2 ? 94 : 95, 1, false);
                                                            if (arrayList.size() > 0) {
                                                                if (ls == null || ls.size() <= 0) {
                                                                    o.PA().a(vVar.fhH.ctj(), str, arrayList, intExtra, booleanExtra2, R.g.bAI);
                                                                } else {
                                                                    o.PA().a(ls, vVar.fhH.ctj(), str, arrayList, intExtra, booleanExtra2, R.g.bAI);
                                                                }
                                                            }
                                                            if (arrayList2.size() > 0) {
                                                                o.PA().a(vVar.fhH.ctj(), str, arrayList2, intExtra, booleanExtra2, R.g.bAI);
                                                            }
                                                            vVar.fhH.mT(true);
                                                            vVar.fhH.ctg().post(new Runnable() {
                                                                public final void run() {
                                                                    v.this.fhH.cpZ();
                                                                }
                                                            });
                                                        }
                                                    } else {
                                                        h.b(vVar.fhH.cte().getContext(), vVar.fhH.ctk().xIx.Yo("").equalsIgnoreCase("@t.qq.com") ? vVar.fhH.cte().getMMString(R.l.ejw) : vVar.fhH.cte().getMMString(R.l.eju, com.tencent.mm.k.a.fd(vVar.fhH.ctk().name)), vVar.fhH.cte().getMMString(R.l.dGZ), true);
                                                    }
                                                }
                                            }
                                        }
                                        ad adVar = v.this.yEA;
                                        Intent intent2 = intent;
                                        if (intent2 != null) {
                                            ArrayList stringArrayListExtra2 = intent2.getStringArrayListExtra("key_select_video_list");
                                            if (stringArrayListExtra2 == null || stringArrayListExtra2.size() <= 0) {
                                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI.VideoImp", "send video list is null or nil");
                                            } else if (ab.bC(adVar.fhH.cte().getContext())) {
                                                adVar.aj(stringArrayListExtra2);
                                            } else {
                                                h.a(adVar.fhH.cte().getContext(), R.l.eTp, R.l.dGZ, new com.tencent.mm.ui.chatting.b.ad.AnonymousClass3(stringArrayListExtra2), null);
                                            }
                                        }
                                        if (v.this.fhH.ctq() != null) {
                                            v.this.fhH.ctq().j(i, intent);
                                        }
                                        as.Dt().cgr();
                                    }
                                }, 100);
                            }
                        };
                        break;
                    }
                }
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI.SendImgImp", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE intent == null");
                return true;
                break;
        }
        return false;
    }

    public final void u(int i, int i2, String str) {
        if (str == null || str.equals("") || !com.tencent.mm.a.e.bO(str)) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.SendImgImp", " doSendImage : filePath is null or empty");
        } else if (this.fhH.ctk() != null && !this.fhH.ctk().isEnable()) {
            String mMString;
            Context context = this.fhH.cte().getContext();
            if (this.fhH.ctk().xIx.Yo("").equalsIgnoreCase("@t.qq.com")) {
                mMString = this.fhH.cte().getMMString(R.l.ejw);
            } else {
                mMString = this.fhH.cte().getMMString(R.l.eju, com.tencent.mm.k.a.fd(this.fhH.ctk().name));
            }
            h.b(context, mMString, this.fhH.cte().getMMString(R.l.dGZ), true);
        } else if (!g.W(this.fhH.csW())) {
            as.CN().a(new l(4, this.fhH.ctj(), this.fhH.csn(), str, i, null, i2, "", "", true, R.g.bAI), 0);
            this.fhH.mT(true);
        }
    }

    public final boolean aP(au auVar) {
        if (!auVar.cjT()) {
            return false;
        }
        as.Hm();
        if (com.tencent.mm.y.c.isSDCardAvailable()) {
            if (!this.fhH.csW().field_username.equals("medianote")) {
                as.Hm();
                com.tencent.mm.y.c.Fe().b(new com.tencent.mm.ax.e(auVar.field_talker, auVar.field_msgSvrId));
            }
            af.aE(auVar);
            this.fhH.mT(true);
            return true;
        }
        com.tencent.mm.ui.base.u.fJ(this.fhH.cte().getContext());
        return true;
    }

    public final void b(long j, int i, int i2) {
        com.tencent.mm.ui.chatting.q ctm = this.fhH.ctm();
        if (ctm.yBZ.containsKey(Long.valueOf(j)) && ctm.yCa.containsKey(Long.valueOf(j))) {
            com.tencent.mm.ui.chatting.viewitems.x.b.a((com.tencent.mm.ui.chatting.viewitems.b.a) ((View) ctm.yBZ.get(Long.valueOf(j))).getTag(), i, i2);
        } else {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingListAdapter", "msg not display, " + j);
        }
    }

    public final void f(long j, boolean z) {
        com.tencent.mm.ui.chatting.q ctm = this.fhH.ctm();
        if (ctm.yBZ.containsKey(Long.valueOf(j)) && ctm.yCa.containsKey(Long.valueOf(j))) {
            com.tencent.mm.ui.chatting.viewitems.x.b.a((com.tencent.mm.ui.chatting.viewitems.b.a) ((View) ctm.yBZ.get(Long.valueOf(j))).getTag(), z);
        } else {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingListAdapter", "msg not display, " + j);
        }
    }
}
