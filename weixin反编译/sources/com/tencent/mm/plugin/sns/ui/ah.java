package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.h;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView;
import com.tencent.mm.plugin.sns.ui.previewimageview.e;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.apl;
import com.tencent.mm.protocal.c.bkq;
import com.tencent.mm.protocal.c.blv;
import com.tencent.mm.protocal.c.bmn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.y.s;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.b.d.i;

public final class ah extends a {
    private String appId;
    private String appName;
    MMActivity fnF;
    private String iNG;
    private boolean rAC = false;
    b rBG = new b();
    private w rBH;
    Map<String, com.tencent.mm.compatible.util.Exif.a> rBI = new HashMap();
    private Map<String, blv> rBJ = new HashMap();
    private int rBK = 0;
    private boolean rBL = false;
    apl rBM;
    private int rym;
    private com.tencent.mm.modelsns.b rys = null;
    private boolean rzG = false;
    private boolean rzH = false;
    private WXMediaMessage rzI = null;

    class b {
        ArrayList<String> rBR = new ArrayList();
        Map<String, Boolean> rBS = new HashMap();
        Map<String, Integer> rBT = new HashMap();

        b() {
        }

        public final b m(String str, int i, boolean z) {
            this.rBR.add(str);
            this.rBT.put(str, Integer.valueOf(i));
            this.rBS.put(str, Boolean.valueOf(z));
            return this;
        }

        public final void P(ArrayList<String> arrayList) {
            this.rBS.clear();
            if (arrayList == null) {
                this.rBR = new ArrayList();
                return;
            }
            this.rBR = arrayList;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.rBS.put((String) it.next(), Boolean.valueOf(false));
            }
        }

        public final String toString() {
            String str = "";
            Iterator it = this.rBR.iterator();
            while (true) {
                String str2 = str;
                if (!it.hasNext()) {
                    return str2;
                }
                str = (String) it.next();
                int i = 0;
                if (this.rBT != null) {
                    i = ((Integer) this.rBT.get(str)).intValue();
                }
                str = str2 + str + "," + i + ";";
            }
        }

        public final b MA(String str) {
            try {
                for (String split : str.split(";")) {
                    String[] split2 = split.split(",");
                    this.rBR.add(split2[0]);
                    this.rBT.put(split2[0], Integer.valueOf(bi.getInt(split2[1], 0)));
                }
            } catch (Exception e) {
            }
            return this;
        }
    }

    class a extends h<String, Integer, Boolean> {
        private ProgressDialog inI = null;
        private aw rAE;
        private List<com.tencent.mm.plugin.sns.data.h> rBO;

        public final /* synthetic */ Object bvz() {
            long currentTimeMillis = System.currentTimeMillis();
            aw awVar = this.rAE;
            awVar.bP(this.rBO);
            this.rAE = awVar;
            x.d("MicroMsg.MMAsyncTask", "commit imp time " + (System.currentTimeMillis() - currentTimeMillis));
            return Boolean.valueOf(true);
        }

        public final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Boolean) obj);
            this.inI.dismiss();
            ah.this.a(this.rAE);
        }

        public a(aw awVar, List<com.tencent.mm.plugin.sns.data.h> list) {
            this.rAE = awVar;
            this.rBO = list;
            Context context = ah.this.fnF;
            ah.this.fnF.getString(j.dGZ);
            this.inI = com.tencent.mm.ui.base.h.a(context, ah.this.fnF.getString(j.dFJ), false, new OnCancelListener(ah.this) {
                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
        }

        public final ag bvy() {
            return ae.bvS();
        }
    }

    public ah(MMActivity mMActivity) {
        this.fnF = mMActivity;
    }

    public final void F(Bundle bundle) {
        String str;
        int i = 1;
        this.rys = com.tencent.mm.modelsns.b.q(this.fnF.getIntent());
        this.rAC = this.fnF.getIntent().getBooleanExtra("Kis_take_photo", false);
        this.appId = bi.aD(this.fnF.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = bi.aD(this.fnF.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.rzG = this.fnF.getIntent().getBooleanExtra("KThrid_app", false);
        this.rBL = this.fnF.getIntent().getBooleanExtra("KBlockAdd", false);
        this.rzH = this.fnF.getIntent().getBooleanExtra("KSnsAction", false);
        this.rym = this.fnF.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.iNG = bi.aD(this.fnF.getIntent().getStringExtra("reportSessionId"), "");
        Bundle bundleExtra = this.fnF.getIntent().getBundleExtra("Ksnsupload_timeline");
        if (bundleExtra != null) {
            this.rzI = new Req(bundleExtra).message;
        }
        String stringExtra = this.fnF.getIntent().getStringExtra("sns_kemdia_path");
        byte[] byteArrayExtra = this.fnF.getIntent().getByteArrayExtra("Ksnsupload_imgbuf");
        if (byteArrayExtra == null && this.rzI != null && this.rzI.mediaObject != null && (this.rzI.mediaObject instanceof WXImageObject)) {
            byteArrayExtra = ((WXImageObject) this.rzI.mediaObject).imageData;
        }
        if (!bi.oN(stringExtra) || bi.by(byteArrayExtra)) {
            str = stringExtra;
        } else {
            stringExtra = ae.getAccSnsTmpPath() + g.s((" " + System.currentTimeMillis()).getBytes());
            FileOp.deleteFile(stringExtra);
            FileOp.b(stringExtra, byteArrayExtra, byteArrayExtra.length);
            str = stringExtra;
        }
        int intExtra = this.fnF.getIntent().getIntExtra("KFilterId", 0);
        if (bundle == null) {
            stringExtra = null;
        } else {
            stringExtra = bundle.getString("sns_kemdia_path_list");
        }
        H(bundle);
        boolean H = H(this.fnF.getIntent().getExtras());
        this.rBK = 0;
        com.tencent.mm.compatible.util.Exif.a location;
        if (!bi.oN(stringExtra)) {
            this.rBG.MA(stringExtra);
        } else if (bi.oN(str)) {
            ArrayList stringArrayListExtra = this.fnF.getIntent().getStringArrayListExtra("sns_kemdia_path_list");
            if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                Iterator it = stringArrayListExtra.iterator();
                while (it.hasNext()) {
                    str = (String) it.next();
                    x.d("MicroMsg.PicWidget", "newPath " + str);
                    this.rBG.m(str, intExtra, false);
                    if (!H) {
                        location = Exif.fromFile(str).getLocation();
                        if (location != null) {
                            this.rBI.put(str, location);
                        }
                    }
                    try {
                        File file = new File(str);
                        blv blv = new blv();
                        blv.wVP = this.rAC ? 1 : 2;
                        blv.wVR = file.lastModified() / 1000;
                        blv.wVQ = Exif.fromFile(str).getUxtimeDatatimeOriginal();
                        this.rBJ.put(str, blv);
                    } catch (Exception e) {
                        x.e("MicroMsg.PicWidget", "get report info error " + e.getMessage());
                    }
                }
            }
        } else {
            int i2;
            String str2 = ae.getAccSnsTmpPath() + "pre_temp_sns_pic" + g.s(str.getBytes());
            File file2 = new File(str2);
            if (!file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
            }
            FileOp.x(str, str2);
            if (intExtra == -1) {
                i2 = 0;
            } else {
                i2 = intExtra;
            }
            this.rBG.m(str2, i2, this.rAC);
            if (!H) {
                location = Exif.fromFile(str).getLocation();
                if (location != null) {
                    this.rBI.put(str2, location);
                }
            }
            try {
                file2 = new File(str);
                blv blv2 = new blv();
                if (!this.rAC) {
                    i = 2;
                }
                blv2.wVP = i;
                blv2.wVR = file2.lastModified() / 1000;
                blv2.wVQ = Exif.fromFile(str).getUxtimeDatatimeOriginal();
                this.rBJ.put(str2, blv2);
            } catch (Exception e2) {
                x.e("MicroMsg.PicWidget", "get report info error " + e2.getMessage());
            }
        }
    }

    private boolean H(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        ArrayList stringArrayList = bundle.getStringArrayList("sns_media_latlong_list");
        if (stringArrayList == null) {
            return false;
        }
        Iterator it = stringArrayList.iterator();
        while (it.hasNext()) {
            String[] split = ((String) it.next()).split("\n");
            if (3 != split.length) {
                x.e("MicroMsg.PicWidget", "invalid params");
                return true;
            }
            try {
                this.rBI.put(split[0].trim(), new com.tencent.mm.compatible.util.Exif.a(bi.getDouble(split[1], 0.0d), bi.getDouble(split[2], 0.0d), 0.0d));
            } catch (NumberFormatException e) {
                x.e("MicroMsg.PicWidget", e.toString());
            }
        }
        return true;
    }

    public final void G(Bundle bundle) {
        bundle.putString("sns_kemdia_path_list", this.rBG.toString());
        ArrayList arrayList = new ArrayList();
        for (Entry entry : this.rBI.entrySet()) {
            arrayList.add(String.format("%s\n%f\n%f", new Object[]{entry.getKey(), Double.valueOf(((com.tencent.mm.compatible.util.Exif.a) entry.getValue()).latitude), Double.valueOf(((com.tencent.mm.compatible.util.Exif.a) entry.getValue()).longitude)}));
        }
        bundle.putStringArrayList("sns_media_latlong_list", arrayList);
        bundle.getString("contentdesc");
    }

    public final boolean bzT() {
        if (this.rBG != null) {
            b bVar = this.rBG;
            boolean z = bVar.rBR != null && bVar.rBR.size() > 0;
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final View a(View view, View view2, DynamicGridView dynamicGridView, View view3) {
        boolean z;
        Context context = this.fnF;
        List list = this.rBG.rBR;
        com.tencent.mm.plugin.sns.ui.w.a anonymousClass1 = new com.tencent.mm.plugin.sns.ui.w.a() {
            public final void xK(int i) {
                x.d("MicroMsg.PicWidget", "I click");
                if (i < 0) {
                    ah.this.bAI();
                    return;
                }
                Intent intent = new Intent();
                intent.setClass(ah.this.fnF, SnsUploadBrowseUI.class);
                intent.putExtra("sns_gallery_position", i);
                intent.putExtra("sns_gallery_temp_paths", ah.this.rBG.rBR);
                ah.this.fnF.startActivityForResult(intent, 7);
            }
        };
        com.tencent.mm.plugin.sns.ui.previewimageview.c.a anonymousClass2 = new com.tencent.mm.plugin.sns.ui.previewimageview.c.a() {
            public final void dH(int i, int i2) {
                b bVar = ah.this.rBG;
                if (i != i2 && bVar.rBR.size() > i) {
                    String str = (String) bVar.rBR.remove(i);
                    if (i2 < bVar.rBR.size()) {
                        bVar.rBR.add(i2, str);
                    } else {
                        bVar.rBR.add(str);
                    }
                }
            }

            public final void removeItem(int i) {
                b bVar = ah.this.rBG;
                if (bVar.rBR.size() > i) {
                    bVar.rBR.remove(i);
                }
                if (ah.this.fnF instanceof SnsUploadUI) {
                    ((SnsUploadUI) ah.this.fnF).bCQ();
                }
            }
        };
        if (this.rBL) {
            z = false;
        } else {
            z = true;
        }
        this.rBH = new e(view, view2, view3, context, list, dynamicGridView, anonymousClass1, anonymousClass2, z);
        return this.rBH.getView();
    }

    public final View bzU() {
        this.rBH = new PreviewImageView(this.fnF);
        if (this.rBL) {
            this.rBH.bAc();
        }
        this.rBH.a(new com.tencent.mm.plugin.sns.ui.w.a() {
            public final void xK(int i) {
                x.d("MicroMsg.PicWidget", "I click");
                if (i < 0) {
                    ah.this.bAI();
                    return;
                }
                Intent intent = new Intent();
                intent.setClass(ah.this.fnF, SnsUploadBrowseUI.class);
                intent.putExtra("sns_gallery_position", i);
                intent.putExtra("sns_gallery_temp_paths", ah.this.rBG.rBR);
                ah.this.fnF.startActivityForResult(intent, 7);
            }
        });
        this.rBH.bW(this.rBG.rBR);
        return this.rBH.getView();
    }

    private static aw a(aw awVar, List<com.tencent.mm.plugin.sns.data.h> list) {
        awVar.bP(list);
        return awVar;
    }

    final void a(aw awVar) {
        int commit = awVar.commit();
        if (this.rys != null) {
            this.rys.iz(commit);
            com.tencent.mm.plugin.sns.h.e.rjJ.c(this.rys);
        }
        if (!(this.rBG == null || this.rBG.rBR == null || !r.bzA())) {
            com.tencent.mm.plugin.report.service.g.pWK.h(12834, Integer.valueOf(this.rBG.rBR.size()));
        }
        Intent intent = new Intent();
        intent.putExtra("sns_local_id", commit);
        this.fnF.setResult(-1, intent);
        this.fnF.finish();
    }

    public final boolean a(int i, int i2, i iVar, String str, List<String> list, apl apl, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        String str3;
        List<com.tencent.mm.plugin.sns.data.h> linkedList = new LinkedList();
        Iterator it = this.rBG.rBR.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            str3 = (String) it.next();
            com.tencent.mm.plugin.sns.data.h hVar = new com.tencent.mm.plugin.sns.data.h(str3, 2);
            hVar.type = 2;
            hVar.qXa = i;
            if (i6 == 0) {
                hVar.qWZ = i2;
                if (iVar != null) {
                    hVar.qXc = iVar.token;
                    hVar.qXd = iVar.wFv;
                }
            } else {
                hVar.qWZ = 0;
            }
            int i7 = i6 + 1;
            b bVar = this.rBG;
            hVar.qWY = bVar.rBT.containsKey(str3) ? ((Integer) bVar.rBT.get(str3)).intValue() : 0;
            hVar.desc = str;
            bVar = this.rBG;
            boolean booleanValue = (bi.oN(str3) || !bVar.rBS.containsKey(str3)) ? false : ((Boolean) bVar.rBS.get(str3)).booleanValue();
            hVar.qXf = booleanValue;
            linkedList.add(hVar);
            i6 = i7;
        }
        LinkedList linkedList2 = new LinkedList();
        if (list != null) {
            LinkedList linkedList3 = new LinkedList();
            List GO = s.GO();
            for (String str32 : list) {
                if (!GO.contains(str32)) {
                    bmn bmn = new bmn();
                    bmn.kyG = str32;
                    linkedList2.add(bmn);
                }
            }
        }
        aw awVar = new aw(1);
        pInt.value = awVar.afu;
        if (iVar != null) {
            awVar.ek(iVar.token, iVar.wFv);
        }
        if (i3 > com.tencent.mm.plugin.sns.c.a.qWI) {
            awVar.xe(3);
        }
        awVar.Le(str).a(apl).aj(linkedList2).xg(i).xh(i2);
        if (z) {
            awVar.xj(1);
        } else {
            awVar.xj(0);
        }
        if (!bi.oN(this.appId)) {
            awVar.Lk(this.appId);
        }
        if (!bi.oN(this.appName)) {
            awVar.Ll(bi.aD(this.appName, ""));
        }
        awVar.xi(this.rym);
        if (this.rzG) {
            awVar.xi(5);
        }
        if (this.rzH && this.rzI != null) {
            awVar.Lf(this.rzI.mediaTagName);
            awVar.V(this.appId, this.rzI.messageExt, this.rzI.messageAction);
        }
        awVar.e(null, null, null, i4, i5);
        awVar.bO(list2);
        awVar.qA(this.iNG);
        if (!(apl == null || apl.score == 0)) {
            i6 = apl.score;
            String str4 = apl.wCS;
            awVar.rev.wFE = new bkq();
            awVar.rev.wFE.wUz = i6;
            awVar.rev.wFE.wUw = str4;
        }
        x.i("MicroMsg.PicWidget", "commit pic size %d, browseImageCount:%d", Integer.valueOf(linkedList.size()), Integer.valueOf(this.rBK));
        com.tencent.mm.plugin.report.service.g.pWK.h(11602, Integer.valueOf(this.rBK), Integer.valueOf(linkedList.size()));
        for (com.tencent.mm.plugin.sns.data.h hVar2 : linkedList) {
            x.i("MicroMsg.PicWidget", "commit path  %s len: %d", hVar2.path, Long.valueOf(FileOp.mi(hVar2.path)));
        }
        for (com.tencent.mm.plugin.sns.data.h hVar22 : linkedList) {
            blv blv;
            String str5 = hVar22.path;
            blv blv2 = (blv) this.rBJ.get(str5);
            if (blv2 == null) {
                blv = new blv();
            } else {
                blv = blv2;
            }
            if (this.rBM == null || (this.rBM.vXy == 0.0f && this.rBM.vXx == 0.0f)) {
                blv.wVN = -1000.0f;
                blv.wVO = -1000.0f;
            } else {
                blv.wVN = this.rBM.vXy;
                blv.wVO = this.rBM.vXx;
                blv.rAl = this.rBM.rAl;
                blv.biF = this.rBM.biF;
            }
            com.tencent.mm.compatible.util.Exif.a aVar = (com.tencent.mm.compatible.util.Exif.a) this.rBI.get(str5);
            if (aVar == null || (aVar.latitude == 0.0d && aVar.longitude == 0.0d)) {
                blv.wVL = -1000.0f;
                blv.wVM = -1000.0f;
            } else {
                blv.wVL = (float) aVar.latitude;
                blv.wVM = (float) aVar.longitude;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("||index: " + awVar.rev.wFz.size());
            stringBuffer.append("||item poi lat " + blv.wVN + " " + blv.wVO);
            stringBuffer.append("||item pic lat " + blv.wVL + " " + blv.wVM);
            stringBuffer.append("||item exitime:" + blv.wVQ + " filetime: " + blv.wVR);
            stringBuffer.append("||item source: " + blv.wVP);
            x.i("MicroMsg.UploadPackHelper", "addSnsReportInfo item : " + stringBuffer.toString());
            awVar.rev.wFz.add(blv);
        }
        if (linkedList.size() <= 1) {
            a(awVar, (List) linkedList);
            a(awVar);
        } else {
            new a(awVar, linkedList).m("");
        }
        return true;
    }

    protected final boolean bAI() {
        com.tencent.mm.kernel.g.Dr();
        if (!com.tencent.mm.kernel.g.Dq().isSDCardAvailable()) {
            u.fJ(this.fnF);
            return false;
        } else if (this.rBG.rBR.size() >= 9) {
            com.tencent.mm.ui.base.h.h(this.fnF, j.qSJ, j.dGZ);
            return false;
        } else {
            try {
                ba baVar = new ba(this.fnF);
                baVar.rQF = new c() {
                    public final void a(n nVar) {
                        if (!com.tencent.mm.platformtools.r.igH) {
                            nVar.f(0, ah.this.fnF.getString(j.dFh));
                        }
                        nVar.f(1, ah.this.fnF.getString(j.dFl));
                    }
                };
                baVar.rQG = new d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        switch (menuItem.getItemId()) {
                            case 0:
                                if (9 - ah.this.rBG.rBR.size() <= 0) {
                                    x.e("MicroMsg.PicWidget", "has select the max image count");
                                    return;
                                }
                                com.tencent.mm.plugin.report.service.g.pWK.h(13822, Integer.valueOf(1), Integer.valueOf(2));
                                k.a(ah.this.fnF, 11, new Intent(), 2, 2);
                                return;
                            case 1:
                                int size = 9 - ah.this.rBG.rBR.size();
                                if (size <= 0) {
                                    x.e("MicroMsg.PicWidget", "has select the max image count");
                                    return;
                                }
                                String string = ah.this.fnF.getSharedPreferences(ad.cgf(), 0).getString("gallery", "1");
                                com.tencent.mm.plugin.report.service.g.pWK.h(13822, Integer.valueOf(2), Integer.valueOf(2));
                                if (string.equalsIgnoreCase("0")) {
                                    k.P(ah.this.fnF);
                                    return;
                                } else {
                                    k.a(ah.this.fnF, 9, size, 4, 1, false, null);
                                    return;
                                }
                            default:
                                return;
                        }
                    }
                };
                baVar.bCH();
            } catch (Exception e) {
            }
            return true;
        }
    }

    public final boolean c(List<String> list, int i, boolean z) {
        if (list == null || list.size() == 0) {
            x.i("MicroMsg.PicWidget", "no image selected");
        } else if (this.rBG.rBR.size() < 9) {
            for (String str : list) {
                if (FileOp.bO(str)) {
                    String str2 = "pre_temp_sns_pic" + g.s((str + System.currentTimeMillis()).getBytes());
                    r.Y(ae.getAccSnsTmpPath(), str, str2);
                    x.d("MicroMsg.PicWidget", "newPath " + ae.getAccSnsTmpPath() + str2);
                    this.rBG.m(ae.getAccSnsTmpPath() + str2, i, z);
                    this.rBH.bW(this.rBG.rBR);
                    try {
                        File file = new File(str);
                        blv blv = new blv();
                        blv.wVP = z ? 1 : 2;
                        blv.wVR = file.lastModified() / 1000;
                        blv.wVQ = Exif.fromFile(str).getUxtimeDatatimeOriginal();
                        this.rBJ.put(ae.getAccSnsTmpPath() + str2, blv);
                    } catch (Exception e) {
                        x.e("MicroMsg.PicWidget", "get report info error " + e.getMessage());
                    }
                    com.tencent.mm.compatible.util.Exif.a location = Exif.fromFile(str).getLocation();
                    if (location != null) {
                        this.rBI.put(ae.getAccSnsTmpPath() + str2, location);
                    }
                }
            }
        }
        return true;
    }

    public final boolean a(int i, Intent intent) {
        String b;
        String s;
        switch (i) {
            case 2:
                x.d("MicroMsg.PicWidget", "onActivityResult 1");
                if (intent == null) {
                    return false;
                }
                x.d("MicroMsg.PicWidget", "onActivityResult CONTEXT_CHOSE_IMAGE");
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 4);
                intent2.putExtra("CropImage_DirectlyIntoFilter", true);
                intent2.putExtra("CropImage_Filter", true);
                com.tencent.mm.plugin.sns.c.a.ihN.a(this.fnF, intent, intent2, ae.getAccSnsTmpPath(), 4, new com.tencent.mm.ui.tools.a.a() {
                    public final String Mz(String str) {
                        return ae.getAccSnsTmpPath() + g.s((str + System.currentTimeMillis()).getBytes());
                    }
                });
                return true;
            case 3:
                x.d("MicroMsg.PicWidget", "onActivityResult 2");
                b = k.b(this.fnF.getApplicationContext(), intent, ae.getAccSnsTmpPath());
                if (b == null) {
                    return true;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("CropImageMode", 4);
                intent3.putExtra("CropImage_Filter", true);
                intent3.putExtra("CropImage_DirectlyIntoFilter", true);
                intent3.putExtra("CropImage_ImgPath", b);
                s = g.s((b + System.currentTimeMillis()).getBytes());
                intent3.putExtra("CropImage_OutputPath", ae.getAccSnsTmpPath() + s);
                com.tencent.mm.compatible.util.Exif.a location = Exif.fromFile(b).getLocation();
                if (location != null) {
                    this.rBI.put(ae.getAccSnsTmpPath() + s, location);
                    x.d("MicroMsg.PicWidget", "take picture lat:%f, long:%f", Double.valueOf(location.latitude), Double.valueOf(location.longitude));
                }
                blv blv = new blv();
                blv.wVP = 1;
                blv.wVR = System.currentTimeMillis();
                blv.wVQ = bi.Wp(Exif.fromFile(b).dateTime);
                this.rBJ.put(ae.getAccSnsTmpPath() + s, blv);
                com.tencent.mm.plugin.sns.c.a.ihN.a(this.fnF, intent3, 4);
                this.rAC = true;
                return true;
            case 4:
                x.d("MicroMsg.PicWidget", "onActivityResult 3");
                if (intent == null) {
                    return true;
                }
                b = intent.getStringExtra("CropImage_OutputPath");
                x.d("MicroMsg.PicWidget", "REQUEST_CODE_IMAGE_SEND_COMFIRM filePath " + b);
                if (b == null) {
                    return true;
                }
                if (!FileOp.bO(b)) {
                    return true;
                }
                if (this.rBG.rBR.size() >= 9) {
                    return true;
                }
                int intExtra = intent.getIntExtra("CropImage_filterId", 0);
                s = "pre_temp_sns_pic" + g.s((b + System.currentTimeMillis()).getBytes());
                x.i("MicroMsg.PicWidget", "onactivity result " + FileOp.mi(b) + " " + b);
                FileOp.x(b, ae.getAccSnsTmpPath() + s);
                if (this.rBI.containsKey(b)) {
                    this.rBI.put(ae.getAccSnsTmpPath() + s, this.rBI.get(b));
                }
                b = ae.getAccSnsTmpPath() + s;
                x.d("MicroMsg.PicWidget", "newPath " + b);
                this.rBG.m(b, intExtra, false);
                this.rBH.bW(this.rBG.rBR);
                return true;
            case 7:
                if (intent == null) {
                    return true;
                }
                this.rBG.P(intent.getStringArrayListExtra("sns_gallery_temp_paths"));
                this.rBH.bW(this.rBG.rBR);
                this.rBK = intent.getIntExtra("sns_update_preview_image_count", 0);
                return true;
            case 9:
                return c(intent.getStringArrayListExtra("CropImage_OutputPath_List"), intent.getIntExtra("CropImage_filterId", 0), intent.getBooleanExtra("isTakePhoto", false));
            case 11:
                SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                if (sightCaptureResult != null) {
                    b = sightCaptureResult.own;
                    if (!bi.oN(b)) {
                        return c(Collections.singletonList(b), 0, true);
                    }
                }
                break;
        }
        return false;
    }

    public final boolean bzV() {
        if (this.rBH != null) {
            this.rBH.clean();
        }
        return false;
    }
}
