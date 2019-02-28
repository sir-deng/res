package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.plugin.appbrand.jsapi.voicejoint.JsApiVoiceSplitJoint;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.n;
import com.tencent.mm.plugin.wenote.model.a.r;
import com.tencent.mm.plugin.wenote.model.a.t;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.pluginsdk.model.c;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vp;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import java.util.HashMap;
import java.util.Iterator;

public final class g extends d implements e {
    private static HashMap<f, l> tXg = new HashMap();
    public boolean fCQ = true;
    public long fCW = -1;
    private vp fww = new vp();
    private f mzi;
    public String tXe;
    public String tXf = "";
    private int tXh = 0;
    private int tXi = 0;
    public String tXj;
    public int tXk = 0;
    public long tXl = 0;
    public String tXm;
    public String tXn;

    /* renamed from: com.tencent.mm.plugin.wenote.model.g$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ vn tXo;

        public AnonymousClass1(vn vnVar) {
            this.tXo = vnVar;
        }

        public final void run() {
            f fVar = new f();
            fVar.field_localId = g.this.fCW;
            fVar.field_favProto = this.tXo;
            g.this.tWX = fVar.field_favProto;
            g.this.tWO = fVar;
            g.this.mzi = fVar;
            if (g.tXg.containsKey(g.this.mzi)) {
                g.this.tWN = (l) g.tXg.get(g.this.mzi);
            } else {
                g.c(g.this);
            }
            g.this.cw(g.this.tWN.pLo);
            if (k.bXM() != null) {
                k.bXQ();
            }
        }

        public final String toString() {
            return super.toString() + "|dealWNoteInfo";
        }
    }

    static /* synthetic */ void c(g gVar) {
        gVar.tWN = new l();
        gVar.tWN.pLp = gVar.mzi;
        gVar.tWN.fCW = gVar.fCW;
        gVar.tWN.bjS = 1;
        if (gVar.mzi != null && gVar.mzi.field_favProto != null) {
            gVar.tWN.tYk = gVar.tXl;
            gVar.tWN.pLo = gVar.mzi.field_favProto.wlY;
            tXg.put(gVar.mzi, gVar.tWN);
        }
    }

    public g() {
        this.tWP.clear();
        this.tWO = null;
        tWU = "";
        this.tWW = false;
        c.bYZ();
        as.CN().a((int) JsApiVoiceSplitJoint.CTRL_INDEX, (e) this);
    }

    public final void a(long j, Context context, Boolean bool, int i, int i2, vp vpVar) {
        this.fCW = j;
        this.fCQ = bool.booleanValue();
        this.tXh = i;
        this.tXi = i2;
        this.fww = vpVar;
        this.mzi = f.eb(this.fCW);
        if (this.mzi != null) {
            if (this.tXl <= 0) {
                this.tXl = this.mzi.field_updateTime;
            }
            this.tWX = this.mzi.field_favProto;
            this.tWO = this.mzi;
        }
        if (this.tXk == 0 && this.tWX.wlW != null) {
            this.tXk = this.tWX.wlW.fqY;
        }
        P(context, 2);
        as.Dt().F(new Runnable() {
            public final void run() {
                if (g.tXg.containsKey(g.this.mzi)) {
                    g.this.tWN = (l) g.tXg.get(g.this.mzi);
                } else {
                    g.c(g.this);
                }
                g.this.cw(g.this.tWN.pLo);
                if (k.bXM() != null) {
                    k.bXQ();
                }
            }

            public final String toString() {
                return super.toString() + "|dealWNoteInfo";
            }
        });
    }

    public final void P(Context context, int i) {
        Intent intent = new Intent();
        intent.putExtra("note_open_from_scene", i);
        if (i == 4) {
            intent.putExtra("fav_note_thumbpath", this.tXm);
            intent.putExtra("fav_note_link_sns_xml", this.tXn);
        }
        intent.putExtra("edit_status", this.tWW);
        intent.putExtra("show_share", this.fCQ);
        intent.putExtra("note_fav_localid", this.fCW);
        intent.putExtra("note_link_sns_localid", this.tXe);
        intent.putExtra("fav_note_xml", this.tXf);
        intent.putExtra("fav_note_scroll_to_position", this.tXh);
        intent.putExtra("fav_note_scroll_to_offset", this.tXi);
        intent.putExtra("fav_note_link_source_info", this.tXj);
        intent.putExtra("note_fav_post_scene", this.tXk);
        intent.putExtra("key_detail_fav_scene", this.fww.scene);
        intent.putExtra("key_detail_fav_sub_scene", this.fww.mtU);
        intent.putExtra("key_detail_fav_index", this.fww.index);
        d.b(context, "wenote", ".ui.nativenote.NoteEditorUI", intent);
    }

    public final String h(uz uzVar) {
        return f.o(uzVar);
    }

    public final String i(uz uzVar) {
        return f.i(uzVar);
    }

    public final void n(uz uzVar) {
        l lVar = this.tWN;
        b fwVar = new fw();
        fwVar.fwl.type = 28;
        fwVar.fwl.frf = lVar.pLp.field_localId;
        fwVar.fwl.fwn = uzVar;
        fwVar.fwl.path = "";
        fwVar.fwl.fws = 18;
        a.xmy.m(fwVar);
    }

    public final void a(uz uzVar, String str) {
        l lVar = this.tWN;
        b fwVar = new fw();
        fwVar.fwl.type = 28;
        fwVar.fwl.frf = lVar.pLp.field_localId;
        fwVar.fwl.fwn = uzVar;
        fwVar.fwl.path = str;
        fwVar.fwl.fws = 18;
        a.xmy.m(fwVar);
    }

    public final void aN(Context context, String str) {
        t tVar = (t) this.tWR.get(str);
        Intent intent = new Intent();
        intent.putExtra("fav_open_from_wnnote", true);
        intent.putExtra("fav_note_xml", this.tXf);
        if (tVar != null) {
            intent.putExtra("key_detail_data_id", Ro(str));
        }
        intent.putExtra("key_detail_can_delete", false);
        intent.putExtra("key_detail_info_id", this.fCW);
        intent.putExtra("key_detail_fav_scene", this.fww.scene);
        intent.putExtra("key_detail_fav_sub_scene", this.fww.mtU);
        intent.putExtra("key_detail_fav_index", this.fww.index);
        d.b(context, "favorite", ".ui.detail.FavoriteFileDetailUI", intent, 1);
    }

    public final void aP(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("fav_open_from_wnnote", true);
        intent.putExtra("fav_note_xml", this.tXf);
        if (this.tWR.get(str) != null) {
            intent.putExtra("key_detail_data_id", ((n) this.tWR.get(str)).mBr);
        }
        intent.putExtra("key_detail_info_id", this.fCW);
        intent.putExtra("key_detail_fav_scene", this.fww.scene);
        intent.putExtra("key_detail_fav_sub_scene", this.fww.mtU);
        intent.putExtra("key_detail_fav_index", this.fww.index);
        d.b(context, "favorite", ".ui.FavImgGalleryUI", intent, 1);
    }

    public final void aO(Context context, String str) {
        String str2 = "";
        r rVar = (r) this.tWR.get(str);
        if (rVar == null) {
            h.bu(context, ad.getContext().getString(R.l.egz));
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("kwebmap_slat", rVar.lat);
        intent.putExtra("kwebmap_lng", rVar.lng);
        intent.putExtra("kPoiName", rVar.nYL);
        intent.putExtra("Kwebmap_locaion", rVar.hzf);
        if (rVar.tYB >= 0.0d) {
            intent.putExtra("kwebmap_scale", rVar.tYB);
        }
        intent.putExtra("kisUsername", str2);
        intent.putExtra("kwebmap_from_to", true);
        intent.putExtra("KFavLocSigleView", true);
        intent.putExtra("map_view_type", 2);
        intent.putExtra("kFavInfoLocalId", this.fCW);
        intent.putExtra("kFavCanDel", false);
        intent.putExtra("kFavCanRemark", false);
        d.b(context, "location", ".ui.RedirectUI", intent, 1);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        if (kVar.getType() == JsApiVoiceSplitJoint.CTRL_INDEX) {
            b fwVar = new fw();
            fwVar.fwl.frW = kVar;
            fwVar.fwl.type = 31;
            a.xmy.m(fwVar);
            if (!bi.oN(fwVar.fwm.path) && i2 == -435) {
                x.e("MicroMsg.WNNoteFavProcess", "wenote conflict when commit");
            }
            as.CN().b((int) JsApiVoiceSplitJoint.CTRL_INDEX, (e) this);
        }
    }

    public final void Rl(String str) {
        this.tXf = str;
    }

    public final String bWB() {
        return this.tXf;
    }

    private String Ro(String str) {
        f eb = f.eb(this.fCW);
        if (eb == null) {
            return ((n) this.tWR.get(str)).mBr;
        }
        Iterator it = eb.field_favProto.wlY.iterator();
        while (it.hasNext()) {
            uz uzVar = (uz) it.next();
            if (!bi.oN(uzVar.wkP) && uzVar.wkP.equals(str)) {
                return uzVar.mBr;
            }
        }
        return ((n) this.tWR.get(str)).mBr;
    }
}
