package com.tencent.mm.plugin.sns.ui.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.di;
import com.tencent.mm.f.a.gn;
import com.tencent.mm.f.a.nh;
import com.tencent.mm.f.a.qr;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.ad;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI;
import com.tencent.mm.plugin.sns.ui.SnsSingleTextViewUI;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.ag;
import com.tencent.mm.plugin.sns.ui.ak;
import com.tencent.mm.plugin.sns.ui.ap;
import com.tencent.mm.plugin.sns.ui.as;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.protocal.c.apl;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.au;
import com.tencent.mm.protocal.c.blb;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.bln;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.MaskImageButton;
import com.tencent.mm.y.q;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class b {
    Activity activity;
    private ClipboardManager mCW;
    public OnClickListener rVA;
    public OnClickListener rVB;
    public OnClickListener rVC;
    public OnClickListener rVD;
    public OnClickListener rVE;
    public c rVF;
    public c rVG;
    public c rVH;
    public c rVI;
    public c rVJ;
    public c rVK;
    c rVL;
    public OnTouchListener rVM;
    public OnClickListener rVN;
    public OnClickListener rVO;
    public OnClickListener rVP;
    public OnClickListener rVQ;
    public OnClickListener rVR;
    public OnClickListener rVS;
    public OnClickListener rVT;
    public OnItemClickListener rVU;
    public OnClickListener rVV = new OnClickListener() {
        public final void onClick(View view) {
            boolean z = false;
            if (view.getTag() != null) {
                m cK = b.cK(view);
                if (cK != null && cK.xD(32)) {
                    boolean z2;
                    if (cK.bzl().byB().bxk()) {
                        int i;
                        int eu = u.eu(cK.bzl().byB().bxg(), cK.bzk());
                        Object obj = eu > 0 ? 1 : null;
                        String bxg = cK.bzl().byB().bxg();
                        String bzk = cK.bzk();
                        g.Do();
                        String Co = a.Co();
                        if (obj != null) {
                            i = eu;
                        } else {
                            i = 1;
                        }
                        u.f(bxg, bzk, Co, i, obj != null ? 0 : 1);
                        if (obj == null) {
                            z = true;
                        }
                        z2 = z;
                    } else {
                        z2 = false;
                    }
                    bpb byF = cK.byF();
                    if (byF.wYj.wfg == 15 && byF.wYq != 1) {
                        b.a(b.this, view, cK, 1001, cK.bzl().byB().bxl(), z2);
                    } else if ((byF.wYj.wfg == 1 && byF.wYj.wfh.size() == 1) || byF.wYj.wfg == 7) {
                        b.b(b.this, view, cK, 1001, cK.bzl().byB().bxl(), z2);
                    }
                }
            }
        }
    };
    public OnClickListener rVW = new OnClickListener() {
        public final void onClick(View view) {
            boolean z = false;
            if (view.getTag() != null) {
                m cK = b.cK(view);
                if (cK != null && cK.xD(32)) {
                    boolean z2;
                    if (cK.bzl().byB().bxk()) {
                        int eu = u.eu(cK.bzl().byB().bxg(), cK.bzk());
                        Object obj = eu > 0 ? 1 : null;
                        String bxg = cK.bzl().byB().bxg();
                        String bzk = cK.bzk();
                        g.Do();
                        u.f(bxg, bzk, a.Co(), obj != null ? eu : 2, obj != null ? 0 : 1);
                        if (obj == null) {
                            z = true;
                        }
                        z2 = z;
                    } else {
                        z2 = false;
                    }
                    bpb byF = cK.byF();
                    if (byF.wYj.wfg == 15 && byF.wYq != 1) {
                        b.a(b.this, view, cK, 1002, cK.bzl().byB().bxm(), z2);
                    } else if ((byF.wYj.wfg == 1 && byF.wYj.wfh.size() == 1) || byF.wYj.wfg == 7) {
                        b.b(b.this, view, cK, 1002, cK.bzl().byB().bxm(), z2);
                    }
                }
            }
        }
    };
    public OnClickListener rVX;
    public av.a rVY;
    int rVZ;
    public e rVm;
    public a rVs;
    public OnClickListener rVt;
    public OnLongClickListener rVu;
    public c rVv;
    public OnClickListener rVw;
    public OnClickListener rVx;
    public OnClickListener rVy;
    public OnClickListener rVz;
    public OnClickListener rWa = new OnClickListener() {
        public final void onClick(View view) {
            TagImageView tagImageView;
            m mVar;
            MMImageView mMImageView;
            Object tag = view.getTag();
            if (tag instanceof c) {
                c cVar = (c) view.getTag();
                m LQ = h.LQ(cVar.fAR);
                tagImageView = cVar.rTU;
                mVar = LQ;
                mMImageView = null;
            } else if (tag instanceof m) {
                tagImageView = null;
                mVar = (m) tag;
                mMImageView = (MMImageView) view.getTag(f.qIM);
            } else {
                mVar = null;
                tagImageView = null;
                mMImageView = null;
            }
            if (mVar != null) {
                String w;
                k cVar2;
                boolean z;
                com.tencent.mm.plugin.sns.storage.e bzl = mVar.bzl();
                int source = bzl.getSource();
                if (mVar != null && mVar.xD(32)) {
                    com.tencent.mm.plugin.sns.storage.a byD = mVar.byD();
                    if (mVar.byB().bxd() && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.LL(mVar.bzl().field_adxml)) {
                        w = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(mVar);
                        if (!bi.oN(w)) {
                            bzl.field_adxml = w;
                        }
                        int[] iArr = new int[2];
                        view.getLocationInWindow(iArr);
                        int width = view.getWidth();
                        int height = view.getHeight();
                        if (tagImageView != null) {
                            tagImageView.getLocationInWindow(iArr);
                            width = tagImageView.getWidth();
                            height = tagImageView.getHeight();
                        } else if (mMImageView != null) {
                            mMImageView.getLocationInWindow(iArr);
                            width = mMImageView.getWidth();
                            height = mMImageView.getHeight();
                        }
                        Intent intent = new Intent();
                        intent.putExtra("img_gallery_left", iArr[0]);
                        intent.putExtra("img_gallery_top", iArr[1]);
                        intent.putExtra("img_gallery_width", width);
                        intent.putExtra("img_gallery_height", height);
                        intent.putExtra("sns_landing_pages_share_sns_id", mVar.byG());
                        intent.putExtra("sns_landing_pages_rawSnsId", mVar.byF().nMq);
                        intent.putExtra("sns_landing_pages_ux_info", mVar.bzk());
                        bpb byF = mVar.byF();
                        if (byF != null) {
                            List list = byF.wYj.wfh;
                            if (list.size() > 0) {
                                intent.putExtra("sns_landing_pages_share_thumb_url", ((are) list.get(0)).wEP);
                            }
                        }
                        intent.setClass(b.this.activity, SnsAdNativeLandingPagesUI.class);
                        intent.putExtra("sns_landig_pages_from_source", b.this.scene == 0 ? 1 : 2);
                        intent.putExtra("sns_landing_pages_xml", mVar.bzl().field_adxml);
                        intent.putExtra("sns_landing_pages_rec_src", mVar.bzm());
                        intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                        intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                        intent.putExtra("sns_landing_is_native_sight_ad", true);
                        b.this.activity.startActivity(intent);
                        b.this.activity.overridePendingTransition(0, 0);
                        cVar2 = new com.tencent.mm.plugin.sns.a.b.c(mVar.bzj(), 23, b.this.scene == 0 ? 1 : 2, "", 3, 21, source, mVar.byF().rzD, mVar.byG());
                        g.Dr();
                        g.Dp().gRu.a(cVar2, 0);
                        return;
                    } else if (byD != null && byD.rjQ == 1) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("key_card_id", byD.rjS);
                        intent2.putExtra("key_card_ext", byD.rjT);
                        intent2.putExtra("key_from_scene", 21);
                        intent2.putExtra("key_stastic_scene", 15);
                        d.b(b.this.activity, "card", ".ui.CardDetailUI", intent2);
                        cVar2 = new com.tencent.mm.plugin.sns.a.b.c(mVar.bzj(), 23, b.this.scene == 0 ? 1 : 2, "", 3, 11, source, mVar.byF().rzD, mVar.byG());
                        g.Dr();
                        g.Dp().gRu.a(cVar2, 0);
                        return;
                    } else if (b.a(b.this, byD, mVar, false)) {
                        cVar2 = new com.tencent.mm.plugin.sns.a.b.c(mVar.bzj(), 23, b.this.scene == 0 ? 1 : 2, "", mVar.bzn(), 31, source, mVar.byF().rzD, mVar.byG());
                        g.Dr();
                        g.Dp().gRu.a(cVar2, 0);
                        return;
                    }
                }
                cVar2 = new com.tencent.mm.plugin.sns.a.b.c(mVar.bzj(), 23, b.this.scene == 0 ? 1 : 2, "", 3, 0, source, mVar.byF().rzD, mVar.byG());
                g.Dr();
                g.Dp().gRu.a(cVar2, 0);
                w = mVar.bzi();
                if (bi.oN(w)) {
                    w = mVar.bzh();
                }
                x.i("MicroMsg.TimelineClickListener", "adlink url " + w + " " + mVar.byB().rkz);
                Intent intent3 = new Intent();
                boolean z2 = mVar.byB().rkz == 0;
                if (r.ifW) {
                    z = false;
                } else {
                    z = z2;
                }
                Parcelable snsAdClick = new SnsAdClick(mVar.bzj(), b.this.scene == 0 ? 1 : 2, mVar.field_snsId, mVar.bzk(), 3, (byte) 0);
                snsAdClick.hQk = mVar.byF().nMq;
                if (mVar != null && mVar.xD(32)) {
                    com.tencent.mm.plugin.sns.storage.a byD2 = mVar.byD();
                    if (byD2 != null) {
                        intent3.putExtra("KsnsViewId", byD2.iWv);
                    }
                }
                intent3.putExtra("KRightBtn", z);
                Bundle bundle = new Bundle();
                bundle.putParcelable("KSnsAdTag", snsAdClick);
                bundle.putString("key_snsad_statextstr", bzl.byF().rzD);
                intent3.putExtra("jsapiargs", bundle);
                intent3.putExtra("rawUrl", w);
                intent3.putExtra("useJs", true);
                intent3.putExtra("srcUsername", mVar.field_userName);
                intent3.putExtra("stastic_scene", 15);
                intent3.putExtra("KPublisherId", "sns_" + i.er(mVar.field_snsId));
                intent3.putExtra("pre_username", mVar.field_userName);
                intent3.putExtra("prePublishId", "sns_" + i.er(mVar.field_snsId));
                intent3.putExtra("preUsername", mVar.field_userName);
                com.tencent.mm.plugin.sns.c.a.ihN.j(intent3, b.this.activity);
            }
        }
    };
    ad rxY;
    public OnClickListener rzz;
    int scene = 0;

    public abstract void b(View view, int i, int i2, int i3);

    public abstract void bM(Object obj);

    public abstract void bzQ();

    public abstract void bzR();

    public abstract void cB(View view);

    public abstract void cC(View view);

    public abstract void cD(View view);

    public abstract void cE(View view);

    public abstract void cF(View view);

    public abstract void cG(View view);

    static /* synthetic */ void a(b bVar, View view, m mVar, int i, String str, boolean z) {
        ak akVar;
        c cVar;
        ak akVar2 = null;
        if (view.getTag() instanceof ak) {
            akVar2 = (ak) view.getTag();
        }
        if (view.getTag() instanceof c) {
            c cVar2 = (c) view.getTag();
            if (cVar2.rUI.rDk.getTag() instanceof ak) {
                akVar = (ak) cVar2.rUI.rDk.getTag();
                cVar = cVar2;
            } else {
                return;
            }
        }
        cVar = null;
        akVar = akVar2;
        if (mVar != null && akVar != null) {
            if (bVar.rxY != null) {
                bVar.rxY.bvK().v(mVar);
            }
            boolean xD = mVar.xD(32);
            bpb bpb = akVar.rDi;
            if (bpb.wYj.wfh == null || bpb.wYj.wfh.size() == 0) {
                x.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
                return;
            }
            are are = (are) bpb.wYj.wfh.get(0);
            if (xD) {
                ae.bwc();
                if (!com.tencent.mm.plugin.sns.model.g.t(are)) {
                    akVar.rqV.setVisibility(8);
                    akVar.rDl.setVisibility(0);
                    akVar.rDl.czF();
                    ae.bwc().z(are);
                    com.tencent.mm.plugin.sns.model.b bwa = ae.bwa();
                    an cjI = an.cjI();
                    cjI.time = bpb.pgR;
                    bwa.a(are, 4, null, cjI);
                    return;
                }
            }
            Object obj = (mVar.xD(32) && mVar.byB().bxd() && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.LL(str)) ? 1 : null;
            if (obj == null && xD && ae.bwc().u(are)) {
                ae.bwc().z(are);
                akVar.rqV.setVisibility(8);
                akVar.rDl.setVisibility(8);
                com.tencent.mm.plugin.sns.model.g bwc = ae.bwc();
                com.tencent.mm.plugin.sight.decode.a.a aVar = akVar.qBQ;
                int hashCode = bVar.activity.hashCode();
                int i2 = akVar.position;
                an cjI2 = an.cjI();
                cjI2.time = bpb.pgR;
                bwc.a(mVar, are, aVar, hashCode, i2, cjI2, xD);
                return;
            }
            int height;
            int i3;
            int[] iArr = new int[2];
            int width;
            if (cVar != null) {
                if (cVar.rUI.rDk != null) {
                    cVar.rUI.rDk.getLocationInWindow(iArr);
                }
                width = cVar.rUI.rDk.getWidth();
                height = cVar.rUI.rDk.getHeight();
                i3 = width;
            } else if (view.getTag() instanceof ak) {
                int height2;
                akVar2 = (ak) view.getTag();
                if (akVar2 != null) {
                    akVar2.rDk.getLocationInWindow(iArr);
                    width = akVar2.rDk.getWidth();
                    height2 = akVar2.rDk.getHeight();
                } else {
                    height2 = 0;
                    width = 0;
                }
                height = height2;
                i3 = width;
            } else if (view != null) {
                view.getLocationInWindow(iArr);
                width = view.getWidth();
                height = view.getHeight();
                i3 = width;
            } else {
                height = 0;
                i3 = 0;
            }
            if (mVar.xD(32) && mVar.byB().bxd() && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.LL(str)) {
                String w = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(mVar);
                if (!bi.oN(w)) {
                    mVar.bzl().field_adxml = w;
                }
                g.Dp().gRu.a(new com.tencent.mm.plugin.sns.a.b.c(mVar.bzj(), i, bVar.scene == 0 ? 1 : 2, "", mVar.bzn(), z ? 22 : 21, mVar.bzl() != null ? mVar.bzl().getSource() : 0, mVar.byF().rzD, mVar.byG()), 0);
                Intent intent = new Intent();
                intent.putExtra("img_gallery_left", iArr[0]);
                intent.putExtra("img_gallery_top", iArr[1]);
                intent.putExtra("img_gallery_width", i3);
                intent.putExtra("img_gallery_height", height);
                intent.putExtra("sns_landing_pages_share_sns_id", mVar.byG());
                intent.putExtra("sns_landing_pages_rawSnsId", mVar.byF().nMq);
                intent.putExtra("sns_landing_pages_ux_info", mVar.bzk());
                bpb byF = mVar.byF();
                if (byF != null) {
                    List list = byF.wYj.wfh;
                    if (list.size() > 0) {
                        intent.putExtra("sns_landing_pages_share_thumb_url", ((are) list.get(0)).wEP);
                    }
                }
                intent.setClass(bVar.activity, SnsAdNativeLandingPagesUI.class);
                intent.putExtra("sns_landig_pages_from_source", bVar.scene == 0 ? 1 : 2);
                intent.putExtra("sns_landing_pages_xml", str);
                intent.putExtra("sns_landing_pages_rec_src", mVar.bzm());
                intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                intent.putExtra("sns_landing_is_native_sight_ad", true);
                bVar.activity.startActivity(intent);
                bVar.activity.overridePendingTransition(0, 0);
                return;
            }
            x.e("MicroMsg.TimelineClickListener", "cardSelectLeftLsn invalid ad style");
        }
    }

    static /* synthetic */ void a(b bVar, bpb bpb) {
        if (bpb != null && bpb.rey != null && bpb.rey.vMx != null && com.tencent.mm.pluginsdk.model.app.g.cA(bpb.rey.vMx.nlV)) {
            au auVar = bpb.rey;
            com.tencent.mm.plugin.sns.c.a.ihO.a(bVar.activity, auVar.vMx.nlV, com.tencent.mm.plugin.sns.c.a.ihO.cy(auVar.vMx.nlV), bpb.kyG, 38, 19, 10, auVar.vMx.vMr, bpb.nMq);
        }
    }

    static /* synthetic */ boolean a(b bVar, com.tencent.mm.plugin.sns.storage.a aVar, m mVar, boolean z) {
        if (aVar != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (z && mVar.byB().rlo.fwG != null) {
                str = mVar.byB().rlo.fwG;
                str2 = mVar.byB().rlo.foj;
                str3 = mVar.byB().rlo.bpe;
            } else if (!(z || aVar.rjQ != 4 || aVar.rki == null)) {
                str = aVar.rki.fwG;
                str2 = aVar.rki.foj;
                str3 = aVar.rki.bpe;
            }
            if (!bi.oN(str)) {
                com.tencent.mm.sdk.b.b qrVar = new qr();
                qrVar.fJd.foi = i.er(mVar.field_snsId) + ":" + aVar.rfQ + ":" + ae.bvL() + ":" + System.currentTimeMillis();
                qrVar.fJd.userName = str;
                qrVar.fJd.fJh = bi.Wo(str3);
                qrVar.fJd.fJf = str2;
                qrVar.fJd.scene = bVar.scene == 0 ? 1045 : 1046;
                com.tencent.mm.sdk.b.a.xmy.m(qrVar);
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ void b(b bVar, View view, m mVar, int i, String str, boolean z) {
        TagImageView xQ = view.getTag() instanceof c ? ((c) view.getTag()).rUj.xQ(0) : view.getTag() instanceof MaskImageView ? (MaskImageView) view.getTag() : (TagImageView) view;
        if (!(xQ.getTag() instanceof ap)) {
            return;
        }
        if (mVar.byB().bxd() && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.LL(str)) {
            g.Dp().gRu.a(new com.tencent.mm.plugin.sns.a.b.c(mVar.bzj(), i, bVar.scene == 0 ? 1 : 2, "", mVar.bzn(), z ? 22 : 21, mVar.bzl() != null ? mVar.bzl().getSource() : 0, mVar.byF().rzD, mVar.byG()), 0);
            String w = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(mVar);
            if (!bi.oN(w)) {
                mVar.bzl().field_adxml = w;
            }
            int[] iArr = new int[2];
            xQ.getLocationInWindow(iArr);
            int width = xQ.getWidth();
            int height = xQ.getHeight();
            Intent intent = new Intent();
            intent.putExtra("img_gallery_left", iArr[0]);
            intent.putExtra("img_gallery_top", iArr[1]);
            intent.putExtra("img_gallery_width", width);
            intent.putExtra("img_gallery_height", height);
            intent.putExtra("sns_landing_pages_share_sns_id", mVar.byG());
            intent.putExtra("sns_landing_pages_rawSnsId", mVar.byF().nMq);
            intent.putExtra("sns_landing_pages_ux_info", mVar.bzk());
            intent.putExtra("sns_landing_pages_aid", mVar.bzf());
            intent.putExtra("sns_landing_pages_traceid", mVar.bzg());
            bpb byF = mVar.byF();
            if (byF != null) {
                List list = byF.wYj.wfh;
                if (list.size() > 0) {
                    intent.putExtra("sns_landing_pages_share_thumb_url", ((are) list.get(0)).wEP);
                }
            }
            intent.setClass(bVar.activity, SnsAdNativeLandingPagesUI.class);
            intent.putExtra("sns_landig_pages_from_source", bVar.scene == 0 ? 1 : 2);
            intent.putExtra("sns_landing_pages_xml", str);
            intent.putExtra("sns_landing_pages_rec_src", mVar.bzm());
            intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
            intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
            bVar.activity.startActivity(intent);
            bVar.activity.overridePendingTransition(0, 0);
            if (bVar.rxY != null) {
                bVar.rxY.bvK().v(mVar);
                return;
            }
            return;
        }
        x.e("MicroMsg.TimelineClickListener", "cardSelectLeftLsn invalid ad style");
    }

    static /* synthetic */ m cK(View view) {
        if (view.getTag() instanceof ap) {
            return h.LR(((ap) view.getTag()).fvn);
        }
        if (view.getTag() instanceof MaskImageView) {
            MaskImageView maskImageView = (MaskImageView) view.getTag();
            return maskImageView.getTag() instanceof ap ? h.LR(((ap) maskImageView.getTag()).fvn) : null;
        } else if (!(view.getTag() instanceof ak)) {
            return h.LQ(((c) view.getTag()).fAR);
        } else {
            return ae.bwf().LR(((ak) view.getTag()).fsC);
        }
    }

    public b(int i, Activity activity, ad adVar) {
        this.scene = i;
        this.activity = activity;
        this.rxY = adVar;
        this.rVZ = bi.getInt(com.tencent.mm.j.g.Af().getValue("SnsPOICommentFeedNewUrlSwitch"), 0);
        x.i("MicroMsg.TimelineClickListener", "init POIComment_FeedNewUrl_Switch:%d", Integer.valueOf(this.rVZ));
        this.mCW = (ClipboardManager) this.activity.getSystemService("clipboard");
        this.rVs = new a(this.activity, this.scene, this.rxY);
        this.rVC = new OnClickListener() {
            public final void onClick(View view) {
                if (view.getTag() != null && (view.getTag() instanceof Long)) {
                    String bzh;
                    com.tencent.mm.plugin.sns.storage.a byD;
                    k cVar;
                    String str;
                    Intent intent;
                    boolean z;
                    Parcelable snsAdClick;
                    Bundle bundle;
                    com.tencent.mm.plugin.sns.storage.e eL = ae.bwi().eL(((Long) view.getTag()).longValue());
                    m byH = eL.byH();
                    j.a(com.tencent.mm.plugin.sns.a.b.j.b.Sight, j.a.DetailTimeline, eL.byH());
                    int source = eL.getSource();
                    String bzi = byH.bzi();
                    if (bi.oN(bzi)) {
                        bzh = byH.bzh();
                    } else {
                        bzh = bzi;
                    }
                    if (byH.xD(32)) {
                        byD = byH.byD();
                        int i = -1;
                        com.tencent.mm.storage.a WU = com.tencent.mm.y.c.c.IM().WU("Sns_CanvasAd_DetailLink_JumpWay");
                        if (WU.isValid()) {
                            i = bi.getInt(WU.field_value, -1);
                        }
                        Intent intent2;
                        bpb byF;
                        List list;
                        if (byD != null && byD.rjQ == 1) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("key_card_id", byD.rjS);
                            intent3.putExtra("key_card_ext", byD.rjT);
                            intent3.putExtra("key_from_scene", 21);
                            intent3.putExtra("key_stastic_scene", 15);
                            d.b(b.this.activity, "card", ".ui.CardDetailUI", intent3);
                            cVar = new com.tencent.mm.plugin.sns.a.b.c(byH.bzj(), 3, b.this.scene == 0 ? 1 : 2, "", byH.bzn(), 11, source, byH.byF().rzD, byH.byG());
                            g.Dr();
                            g.Dp().gRu.a(cVar, 0);
                            return;
                        } else if (byD == null || i != 1) {
                            if (byD == null || i != 0) {
                                if (byD != null && i == -1 && byD.rjQ == 3) {
                                    if (byH.byB().bxd() && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.LL(byH.bzl().field_adxml)) {
                                        bzi = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(byH);
                                        if (!bi.oN(bzi)) {
                                            eL.field_adxml = bzi;
                                        }
                                        intent2 = new Intent();
                                        intent2.putExtra("sns_landing_pages_share_sns_id", byH.byG());
                                        intent2.putExtra("sns_landing_pages_rawSnsId", byH.byF().nMq);
                                        intent2.putExtra("sns_landing_pages_ux_info", byH.bzk());
                                        intent2.putExtra("sns_landing_pages_aid", byH.bzf());
                                        intent2.putExtra("sns_landing_pages_traceid", byH.bzg());
                                        byF = byH.byF();
                                        if (byF != null) {
                                            list = byF.wYj.wfh;
                                            if (list.size() > 0) {
                                                intent2.putExtra("sns_landing_pages_share_thumb_url", ((are) list.get(0)).wEP);
                                            }
                                        }
                                        intent2.setClass(b.this.activity, SnsAdNativeLandingPagesUI.class);
                                        intent2.putExtra("sns_landig_pages_from_source", b.this.scene == 0 ? 9 : 10);
                                        intent2.putExtra("sns_landing_pages_xml", byH.bzl().field_adxml);
                                        intent2.putExtra("sns_landing_pages_rec_src", byH.bzm());
                                        intent2.putExtra("sns_landing_pages_xml_prefix", "adxml");
                                        intent2.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                                        b.this.activity.startActivity(intent2);
                                        b.this.activity.overridePendingTransition(0, 0);
                                        cVar = new com.tencent.mm.plugin.sns.a.b.c(byH.bzj(), 3, b.this.scene == 0 ? 1 : 2, "", byH.bzn(), 21, source, byH.byF().rzD, byH.byG());
                                        g.Dr();
                                        g.Dp().gRu.a(cVar, 0);
                                        return;
                                    }
                                } else if (b.a(b.this, byD, byH, false)) {
                                    cVar = new com.tencent.mm.plugin.sns.a.b.c(byH.bzj(), 3, b.this.scene == 0 ? 1 : 2, "", byH.bzn(), 31, source, byH.byF().rzD, byH.byG());
                                    g.Dr();
                                    g.Dp().gRu.a(cVar, 0);
                                    return;
                                }
                            } else if (byH.byB().bxd() && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.LL(byH.bzl().field_adxml)) {
                                bzi = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(byH);
                                if (!bi.oN(bzi)) {
                                    eL.field_adxml = bzi;
                                }
                                Map y = com.tencent.mm.c.f.y(byH.bzl().field_adxml, "adxml");
                                if (y != null) {
                                    bzi = bi.aD((String) y.get(".adxml.adCanvasInfo.shareWebUrl"), "");
                                    if (!bi.oN(bzi)) {
                                        bzh = bzi;
                                    }
                                    str = bzh;
                                } else {
                                    x.e("MicroMsg.TimelineClickListener", "parse landingpagexml is error,landingpagexml is " + byH.bzl().field_adxml);
                                    str = bzh;
                                }
                                cVar = new com.tencent.mm.plugin.sns.a.b.c(byH.bzj(), 3, b.this.scene != 0 ? 1 : 2, "", byH.bzn(), 0, source, byH.byF().rzD, byH.byG());
                                g.Dr();
                                g.Dp().gRu.a(cVar, 0);
                                x.i("MicroMsg.TimelineClickListener", "adlink url " + str + " " + byH.byB().rkz);
                                intent = new Intent();
                                z = byH.byB().rkz != 0;
                                if (r.ifW) {
                                    z = false;
                                }
                                snsAdClick = new SnsAdClick(byH.bzj(), b.this.scene != 0 ? 1 : 2, byH.field_snsId, byH.bzk(), byH.bzn(), (byte) 0);
                                snsAdClick.hQk = byH.byF().nMq;
                                if (byH.xD(32)) {
                                    byD = byH.byD();
                                    if (byD != null) {
                                        intent.putExtra("KsnsViewId", byD.iWv);
                                    }
                                }
                                intent.putExtra("KRightBtn", z);
                                bundle = new Bundle();
                                bundle.putParcelable("KSnsAdTag", snsAdClick);
                                bundle.putString("key_snsad_statextstr", eL.byF().rzD);
                                intent.putExtra("jsapiargs", bundle);
                                intent.putExtra("rawUrl", str);
                                intent.putExtra("useJs", true);
                                intent.putExtra("srcUsername", byH.field_userName);
                                intent.putExtra("sns_local_id", byH.bza());
                                intent.putExtra("stastic_scene", 15);
                                intent.putExtra("KPublisherId", "sns_" + i.er(byH.field_snsId));
                                intent.putExtra("pre_username", byH.field_userName);
                                intent.putExtra("prePublishId", "sns_" + i.er(byH.field_snsId));
                                intent.putExtra("preUsername", byH.field_userName);
                                com.tencent.mm.plugin.sns.c.a.ihN.j(intent, b.this.activity);
                            }
                        } else if (byH.byB().bxd() && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.LL(byH.bzl().field_adxml)) {
                            bzi = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(byH);
                            if (!bi.oN(bzi)) {
                                eL.field_adxml = bzi;
                            }
                            intent2 = new Intent();
                            intent2.putExtra("sns_landing_pages_share_sns_id", byH.byG());
                            intent2.putExtra("sns_landing_pages_rawSnsId", byH.byF().nMq);
                            intent2.putExtra("sns_landing_pages_ux_info", byH.bzk());
                            intent2.putExtra("sns_landing_pages_aid", byH.bzf());
                            intent2.putExtra("sns_landing_pages_traceid", byH.bzg());
                            byF = byH.byF();
                            if (byF != null) {
                                list = byF.wYj.wfh;
                                if (list.size() > 0) {
                                    intent2.putExtra("sns_landing_pages_share_thumb_url", ((are) list.get(0)).wEP);
                                }
                            }
                            intent2.setClass(b.this.activity, SnsAdNativeLandingPagesUI.class);
                            intent2.putExtra("sns_landig_pages_from_source", b.this.scene == 0 ? 9 : 10);
                            intent2.putExtra("sns_landing_pages_xml", byH.bzl().field_adxml);
                            intent2.putExtra("sns_landing_pages_xml_prefix", "adxml");
                            intent2.putExtra("sns_landing_pages_rec_src", byH.bzm());
                            intent2.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                            b.this.activity.startActivity(intent2);
                            b.this.activity.overridePendingTransition(0, 0);
                            cVar = new com.tencent.mm.plugin.sns.a.b.c(byH.bzj(), 3, b.this.scene == 0 ? 1 : 2, "", byH.bzn(), 21, source, byH.byF().rzD, byH.byG());
                            g.Dr();
                            g.Dp().gRu.a(cVar, 0);
                            return;
                        }
                    }
                    str = bzh;
                    if (b.this.scene != 0) {
                    }
                    cVar = new com.tencent.mm.plugin.sns.a.b.c(byH.bzj(), 3, b.this.scene != 0 ? 1 : 2, "", byH.bzn(), 0, source, byH.byF().rzD, byH.byG());
                    g.Dr();
                    g.Dp().gRu.a(cVar, 0);
                    x.i("MicroMsg.TimelineClickListener", "adlink url " + str + " " + byH.byB().rkz);
                    intent = new Intent();
                    if (byH.byB().rkz != 0) {
                    }
                    if (r.ifW) {
                        z = false;
                    }
                    if (b.this.scene != 0) {
                    }
                    snsAdClick = new SnsAdClick(byH.bzj(), b.this.scene != 0 ? 1 : 2, byH.field_snsId, byH.bzk(), byH.bzn(), (byte) 0);
                    snsAdClick.hQk = byH.byF().nMq;
                    if (byH.xD(32)) {
                        byD = byH.byD();
                        if (byD != null) {
                            intent.putExtra("KsnsViewId", byD.iWv);
                        }
                    }
                    intent.putExtra("KRightBtn", z);
                    bundle = new Bundle();
                    bundle.putParcelable("KSnsAdTag", snsAdClick);
                    bundle.putString("key_snsad_statextstr", eL.byF().rzD);
                    intent.putExtra("jsapiargs", bundle);
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("useJs", true);
                    intent.putExtra("srcUsername", byH.field_userName);
                    intent.putExtra("sns_local_id", byH.bza());
                    intent.putExtra("stastic_scene", 15);
                    intent.putExtra("KPublisherId", "sns_" + i.er(byH.field_snsId));
                    intent.putExtra("pre_username", byH.field_userName);
                    intent.putExtra("prePublishId", "sns_" + i.er(byH.field_snsId));
                    intent.putExtra("preUsername", byH.field_userName);
                    com.tencent.mm.plugin.sns.c.a.ihN.j(intent, b.this.activity);
                }
            }
        };
        this.rVO = new OnClickListener() {
            public final void onClick(View view) {
                int i = 2;
                if (view.getTag() instanceof String) {
                    m LR = ae.bwf().LR((String) view.getTag());
                    if (LR == null) {
                        return;
                    }
                    com.tencent.mm.modelsns.b ix;
                    if (LR.xD(32)) {
                        x.i("MicroMsg.TimelineClickListener", "click the ad poi button");
                        k cVar = new com.tencent.mm.plugin.sns.a.b.c(LR.bzj(), 19, b.this.scene == 0 ? 1 : 2, "", LR.bzn(), LR.byG());
                        g.Dr();
                        g.Dp().gRu.a(cVar, 0);
                        com.tencent.mm.plugin.sns.storage.a byD = LR.byD();
                        if (byD == null) {
                            x.e("MicroMsg.TimelineClickListener", "the adInfo is null");
                            return;
                        } else if (bi.oN(byD.rjY)) {
                            x.e("MicroMsg.TimelineClickListener", "the adActionPOILink is null");
                            return;
                        } else {
                            if (b.this.scene == 0) {
                                ix = com.tencent.mm.modelsns.b.ix(724);
                            } else {
                                ix = com.tencent.mm.modelsns.b.iy(724);
                            }
                            ix.mF(i.g(LR)).iA(LR.field_type).bW(LR.xD(32)).mF(LR.bzk()).mF("").mF("").mF("").mF("").mF(byD.rjX).mF("").mF("");
                            ix.SE();
                            x.i("MicroMsg.TimelineClickListener", "open webview url : " + byD.rjY);
                            Intent intent = new Intent();
                            String bzj = LR.bzj();
                            int i2 = b.this.scene == 0 ? 1 : 2;
                            long j = LR.field_snsId;
                            String bzk = LR.bzk();
                            if (LR.field_type == 1) {
                                i = 1;
                            }
                            Parcelable snsAdClick = new SnsAdClick(bzj, i2, j, bzk, i);
                            snsAdClick.hQk = LR.byF().nMq;
                            if (LR != null && LR.xD(32)) {
                                com.tencent.mm.plugin.sns.storage.a byD2 = LR.byD();
                                if (byD2 != null) {
                                    intent.putExtra("KsnsViewId", byD2.iWv);
                                }
                            }
                            Bundle bundle = new Bundle();
                            bundle.putParcelable("KSnsAdTag", snsAdClick);
                            intent.putExtra("jsapiargs", bundle);
                            intent.putExtra("useJs", true);
                            intent.putExtra("KPublisherId", "sns_" + i.er(LR.field_snsId));
                            intent.putExtra("pre_username", LR.field_userName);
                            intent.putExtra("prePublishId", "sns_" + i.er(LR.field_snsId));
                            intent.putExtra("preUsername", LR.field_userName);
                            intent.putExtra("rawUrl", byD.rjY);
                            com.tencent.mm.plugin.sns.c.a.ihN.j(intent, b.this.activity);
                            return;
                        }
                    }
                    apl apl = LR.byF().wYh;
                    Intent intent2 = new Intent();
                    if (b.this.scene == 0) {
                        ix = com.tencent.mm.modelsns.b.ix(724);
                    } else {
                        ix = com.tencent.mm.modelsns.b.iy(724);
                    }
                    ix.mF(i.g(LR)).iA(LR.field_type).bW(LR.xD(32)).mF(LR.bzk()).mF(apl.wCS).iA(apl.rAj).mF(apl.vXy).mF(apl.vXx).mF(apl.nYL).mF(apl.rAh).mF(apl.hxg);
                    ix.SE();
                    if (bi.oN(apl.wCS)) {
                        intent2.putExtra("map_view_type", 7);
                        intent2.putExtra("kwebmap_slat", (double) apl.vXy);
                        intent2.putExtra("kwebmap_lng", (double) apl.vXx);
                        intent2.putExtra("kPoiName", apl.nYL);
                        intent2.putExtra("Kwebmap_locaion", apl.rAh);
                        d.b(b.this.activity, "location", ".ui.RedirectUI", intent2);
                        return;
                    }
                    String format;
                    if (b.this.rVZ == 0) {
                        format = String.format("http://mp.weixin.qq.com/mp/lifedetail?bid=%s&action=list#wechat_redirect", new Object[]{apl.wCS});
                    } else {
                        format = String.format("http://mp.weixin.qq.com/mp/lifedetail?bid=%s&tid=%s&action=list#wechat_redirect", new Object[]{apl.wCS, r1.nMq});
                    }
                    intent2.putExtra("rawUrl", format);
                    com.tencent.mm.plugin.sns.c.a.ihN.j(intent2, b.this.activity);
                }
            }
        };
        this.rVS = new OnClickListener() {
            public final void onClick(View view) {
                if (view.getTag() instanceof String) {
                    m LR = ae.bwf().LR((String) view.getTag());
                    if (LR != null && LR.xD(32)) {
                        x.i("MicroMsg.TimelineClickListener", "click the ad tailLink button");
                        com.tencent.mm.plugin.sns.storage.a byD = LR.byD();
                        if (byD == null) {
                            x.e("MicroMsg.TimelineClickListener", "the adInfo is null");
                        } else if (bi.oN(byD.rkb)) {
                            x.e("MicroMsg.TimelineClickListener", "the adActionExtTailLink is null");
                        } else {
                            x.i("MicroMsg.TimelineClickListener", "open webview url : " + byD.rkb);
                            Intent intent = new Intent();
                            intent.putExtra("jsapiargs", new Bundle());
                            intent.putExtra("useJs", true);
                            intent.putExtra("rawUrl", byD.rkb);
                            com.tencent.mm.plugin.sns.c.a.ihN.j(intent, b.this.activity);
                        }
                    }
                }
            }
        };
        this.rVT = new OnClickListener() {
            public final void onClick(View view) {
                if (view.getTag() instanceof c) {
                    m LR = ae.bwf().LR(((c) view.getTag()).fsC);
                    if (LR != null && LR.xD(32)) {
                        x.i("MicroMsg.TimelineClickListener", "click the ad tailLink button");
                        k cVar = new com.tencent.mm.plugin.sns.a.b.c(LR.bzj(), 24, b.this.scene == 0 ? 1 : 2, "", LR.bzn(), LR.byG());
                        g.Dr();
                        g.Dp().gRu.a(cVar, 0);
                        b.this.cC(view);
                    }
                }
            }
        };
        this.rVt = new OnClickListener() {
            public final void onClick(View view) {
                m mVar;
                String str;
                boolean z;
                com.tencent.mm.modelsns.b ix;
                int i = 721;
                boolean z2 = false;
                String str2 = (String) view.getTag();
                x.d("MicroMsg.TimelineClickListener", "onCommentClick:" + str2);
                Intent intent = new Intent();
                String str3 = "";
                if (!(view instanceof MaskImageButton) || ((MaskImageButton) view).zuL == null) {
                    mVar = null;
                    str = str3;
                    z = false;
                } else {
                    m LR = ae.bwf().LR((String) ((MaskImageButton) view).zuL);
                    if (LR.xD(32)) {
                        str = LR.bzj();
                        com.tencent.mm.plugin.sns.storage.b byB = LR.byB();
                        if (byB == null || byB.rkJ != 1 || bi.oN(byB.rkK)) {
                            mVar = LR;
                            z = true;
                        } else {
                            str2 = byB.rkK;
                            x.i("MicroMsg.TimelineClickListener", "headClickParam url " + str2 + " " + byB.rkL);
                            Intent intent2 = new Intent();
                            if (byB.rkL == 0) {
                                z2 = true;
                            }
                            intent2.putExtra("KsnsViewId", str);
                            intent2.putExtra("KRightBtn", z2);
                            intent2.putExtra("jsapiargs", new Bundle());
                            intent2.putExtra("rawUrl", str2);
                            intent2.putExtra("useJs", true);
                            com.tencent.mm.plugin.sns.c.a.ihN.j(intent2, b.this.activity);
                            return;
                        }
                    }
                    mVar = LR;
                    str = str3;
                    z = false;
                }
                if (mVar != null) {
                    if (b.this.scene == 0) {
                        ix = com.tencent.mm.modelsns.b.ix(mVar.xD(32) ? 722 : 721);
                    } else {
                        if (mVar.xD(32)) {
                            i = 722;
                        }
                        ix = com.tencent.mm.modelsns.b.iy(i);
                    }
                    ix.mF(i.g(mVar)).iA(mVar.field_type).bW(mVar.xD(32)).mF(mVar.bzk()).mF(str2);
                    ix.SE();
                }
                if (z) {
                    int i2;
                    Parcelable snsAdClick = new SnsAdClick(str, b.this.scene == 0 ? 1 : 2, mVar.field_snsId, mVar.bzk(), mVar.bzn(), (byte) 0);
                    snsAdClick.hQk = mVar.byF().nMq;
                    intent.putExtra("Contact_User", str2);
                    intent.putExtra("KSnsAdTag", snsAdClick);
                    com.tencent.mm.plugin.sns.c.a.ihN.d(intent, b.this.activity);
                    if (b.this.scene == 0) {
                        i2 = 1;
                    } else {
                        i2 = 2;
                    }
                    k cVar = new com.tencent.mm.plugin.sns.a.b.c(str, 1, i2, "", mVar.bzn(), mVar.byG());
                    g.Dr();
                    g.Dp().gRu.a(cVar, 0);
                    return;
                }
                b.this.rxY.bvK().a(mVar, true);
                if (b.this.scene == 0) {
                    ix = com.tencent.mm.modelsns.b.ix(746);
                } else {
                    ix = com.tencent.mm.modelsns.b.iy(746);
                }
                ix.mF(str2).bW(str2.endsWith(q.FY()));
                ix.b(intent, "intent_key_StatisticsOplog");
                intent.putExtra("Contact_User", str2);
                com.tencent.mm.plugin.sns.c.a.ihN.d(intent, b.this.activity);
            }
        };
        this.rVu = new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                final String str = (String) view.getTag();
                x.d("MicroMsg.TimelineClickListener", "onCommentLongClick:" + str);
                if (bi.oN(str)) {
                    return true;
                }
                if (str.equals(ae.bvL())) {
                    return true;
                }
                String str2;
                int i;
                if (((MaskImageButton) view).zuL == null || !(((MaskImageButton) view).zuL instanceof String)) {
                    str2 = "";
                } else {
                    str2 = (String) ((MaskImageButton) view).zuL;
                }
                Intent intent = new Intent();
                final m LR = ae.bwf().LR(str2);
                if (LR == null || !LR.xD(32)) {
                    i = 0;
                } else {
                    i = 1;
                }
                if (i != 0) {
                    return false;
                }
                com.tencent.mm.ui.widget.i iVar = new com.tencent.mm.ui.widget.i(b.this.activity, view);
                iVar.zDq = new OnCreateContextMenuListener() {
                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        contextMenu.add(0, 0, 0, b.this.activity.getString(com.tencent.mm.plugin.sns.i.j.dWa));
                        contextMenu.add(1, 1, 0, b.this.activity.getString(com.tencent.mm.plugin.sns.i.j.qSw));
                    }
                };
                iVar.rQG = new p.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        long j = 0;
                        Intent intent;
                        switch (menuItem.getItemId()) {
                            case 0:
                                intent = new Intent();
                                String str = "sns_permission_snsinfo_svr_id";
                                if (LR != null) {
                                    j = LR.field_snsId;
                                }
                                intent.putExtra(str, j);
                                intent.putExtra("sns_permission_userName", str);
                                intent.putExtra("sns_permission_anim", true);
                                intent.putExtra("sns_permission_block_scene", 5);
                                intent.setClass(b.this.activity, SnsPermissionUI.class);
                                b.this.activity.startActivityForResult(intent, 11);
                                return;
                            case 1:
                                intent = new Intent();
                                m LR = ae.bwf().LR(str2);
                                if (LR == null) {
                                    x.i("MicroMsg.TimelineClickListener", "error get snsinfo by id " + str2);
                                    return;
                                }
                                x.i("MicroMsg.TimelineClickListener", "expose id " + LR.byG() + " " + LR.field_userName);
                                String str2 = "k_expose_msg_id";
                                if (LR != null) {
                                    j = LR.field_snsId;
                                }
                                intent.putExtra(str2, j);
                                intent.putExtra("k_username", LR == null ? "" : LR.field_userName);
                                intent.putExtra("showShare", false);
                                intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                                d.b(b.this.activity, "webview", ".ui.tools.WebViewUI", intent);
                                return;
                            default:
                                return;
                        }
                    }
                };
                int[] iArr = new int[2];
                if (view.getTag(com.tencent.mm.ca.a.e.cSM) instanceof int[]) {
                    iArr = (int[]) view.getTag(com.tencent.mm.ca.a.e.cSM);
                }
                iVar.bV(iArr[0], iArr[1]);
                return false;
            }
        };
        this.rVv = new c() {
            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                as asVar = (as) view.getTag();
                m LQ = ae.bwf().LQ(asVar.fAR);
                if (LQ != null) {
                    contextMenu.add(0, 0, 0, b.this.activity.getString(com.tencent.mm.plugin.sns.i.j.dED));
                    if (d.Pu("favorite")) {
                        contextMenu.add(0, 1, 0, b.this.activity.getString(com.tencent.mm.plugin.sns.i.j.eAq));
                    }
                    bpb byF = LQ.byF();
                    if (asVar.rKT || !(byF == null || byF.wYl == 1 || asVar.rKU)) {
                        if (asVar.bBZ()) {
                            ao.b(contextMenu, true);
                        } else {
                            ao.a(contextMenu, true);
                        }
                    }
                    com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, LQ);
                }
            }

            public final boolean cL(View view) {
                if (!(view.getTag() instanceof as)) {
                    return false;
                }
                m LQ = ae.bwf().LQ(((as) view.getTag()).fAR);
                if (LQ == null) {
                    return false;
                }
                b.this.rVs.a(view, LQ.bza(), LQ.byF());
                return true;
            }
        };
        this.rVJ = new c() {
            public final boolean cL(View view) {
                if (!(view.getTag() instanceof c) && !(view.getTag() instanceof m) && !(view.getTag() instanceof ak) && !(view.getTag() instanceof ap)) {
                    return false;
                }
                m LQ;
                Object tag = view.getTag();
                if (tag instanceof c) {
                    LQ = h.LQ(((c) view.getTag()).fAR);
                } else if (tag instanceof m) {
                    LQ = (m) tag;
                } else if (tag instanceof ak) {
                    LQ = ae.bwf().LR(((ak) tag).fsC);
                } else if (view.getTag() instanceof ap) {
                    LQ = ae.bwf().LR(((ap) view.getTag()).fvn);
                } else {
                    LQ = null;
                }
                if (LQ != null) {
                    if (!LQ.xD(32)) {
                        return false;
                    }
                    if (LQ.byB() == null || LQ.byB().rll != 1) {
                        return false;
                    }
                    b.this.rVs.a(view, LQ.bza(), LQ.byF());
                }
                return true;
            }

            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                Object tag = view.getTag();
                if ((tag instanceof c) || (tag instanceof m) || (tag instanceof ak) || (tag instanceof ap)) {
                    m LQ;
                    if (tag instanceof c) {
                        LQ = h.LQ(((c) tag).fAR);
                    } else if (tag instanceof m) {
                        LQ = (m) tag;
                    } else if (tag instanceof ak) {
                        LQ = ae.bwf().LR(((ak) tag).fsC);
                    } else if (view.getTag() instanceof ap) {
                        LQ = ae.bwf().LR(((ap) view.getTag()).fvn);
                    } else {
                        LQ = null;
                    }
                    if (LQ.xD(32) && LQ.byB() != null && LQ.byB().rll == 1 && LQ.byD().rki == null) {
                        if (d.Pu("favorite")) {
                            com.tencent.mm.plugin.sns.storage.b byB = LQ.byB();
                            LQ.byD();
                            if (byB.bxi()) {
                                contextMenu.add(0, 20, 0, view.getContext().getString(com.tencent.mm.plugin.sns.i.j.eAq));
                            }
                            com.tencent.mm.sdk.b.b diVar = new di();
                            diVar.fsL.fsC = LQ.bza();
                            com.tencent.mm.sdk.b.a.xmy.m(diVar);
                            if (diVar.fsM.fsk) {
                                contextMenu.add(0, 18, 0, view.getContext().getString(com.tencent.mm.plugin.sns.i.j.qPx));
                            }
                        }
                        if (LQ != null) {
                            com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, LQ);
                        }
                    }
                }
            }
        };
        this.rVK = new c() {
            public final boolean cL(View view) {
                if (!(view.getTag() instanceof c) && !(view.getTag() instanceof m)) {
                    return false;
                }
                m LQ;
                Object tag = view.getTag();
                if (tag instanceof c) {
                    LQ = h.LQ(((c) view.getTag()).fAR);
                } else if (tag instanceof m) {
                    LQ = (m) tag;
                } else {
                    LQ = null;
                }
                if (LQ != null) {
                    b.this.rVs.a(view, LQ.bza(), LQ.byF());
                }
                return true;
            }

            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                Object tag = view.getTag();
                if ((tag instanceof c) || (tag instanceof m)) {
                    m LQ;
                    if (tag instanceof c) {
                        LQ = h.LQ(((c) tag).fAR);
                    } else if (tag instanceof m) {
                        LQ = (m) tag;
                    } else {
                        LQ = null;
                    }
                    if (d.Pu("favorite")) {
                        com.tencent.mm.plugin.sns.storage.b byB = LQ.byB();
                        com.tencent.mm.plugin.sns.storage.a byD = LQ.byD();
                        if (byB.bxh()) {
                            if (byB.bxd()) {
                                contextMenu.add(0, 2, 0, view.getContext().getString(com.tencent.mm.plugin.sns.i.j.eAq));
                            } else if (byD.rjQ == 0) {
                                contextMenu.add(0, 3, 0, view.getContext().getString(com.tencent.mm.plugin.sns.i.j.eAq));
                            }
                        }
                        com.tencent.mm.sdk.b.b diVar = new di();
                        diVar.fsL.fsC = LQ.bza();
                        com.tencent.mm.sdk.b.a.xmy.m(diVar);
                        if (diVar.fsM.fsk) {
                            contextMenu.add(0, 18, 0, view.getContext().getString(com.tencent.mm.plugin.sns.i.j.qPx));
                        }
                    }
                    if (LQ != null) {
                        com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, LQ);
                    }
                }
            }
        };
        this.rVH = new c() {
            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.r) {
                    b.this.rVL.onCreateContextMenu(contextMenu, view, contextMenuInfo);
                }
            }

            public final boolean cL(View view) {
                if (!(view.getTag() instanceof com.tencent.mm.plugin.sns.ui.r)) {
                    return false;
                }
                String str = ((com.tencent.mm.plugin.sns.ui.r) view.getTag()).fsC;
                b.this.rVs.a(view, str, ae.bwf().LR(str).byF());
                return true;
            }
        };
        this.rVG = new c() {
            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                if (view != null && (view.getTag() instanceof ap)) {
                    String str = ((ap) view.getTag()).fvn;
                    m LR = ae.bwf().LR(str);
                    if (d.Pu("favorite")) {
                        contextMenu.add(0, 2, 0, b.this.activity.getString(com.tencent.mm.plugin.sns.i.j.eAq));
                        com.tencent.mm.sdk.b.b diVar = new di();
                        diVar.fsL.fsC = str;
                        com.tencent.mm.sdk.b.a.xmy.m(diVar);
                        if (diVar.fsM.fsk) {
                            contextMenu.add(0, 18, 0, b.this.activity.getString(com.tencent.mm.plugin.sns.i.j.qPx));
                        }
                    }
                    com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, LR);
                    if (d.Pu("photoedit")) {
                        int width;
                        int height;
                        MenuItem add = contextMenu.add(0, 21, 0, b.this.activity.getString(com.tencent.mm.plugin.sns.i.j.qQC));
                        int[] iArr = new int[2];
                        if (view != null) {
                            width = view.getWidth();
                            height = view.getHeight();
                            view.getLocationInWindow(iArr);
                        } else {
                            height = 0;
                            width = 0;
                        }
                        Intent intent = new Intent();
                        intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                        add.setIntent(intent);
                    }
                }
            }

            public final boolean cL(View view) {
                if (!(view.getTag() instanceof ap)) {
                    return false;
                }
                String str = ((ap) view.getTag()).fvn;
                b.this.rVs.a(view, str, ae.bwf().LR(str).byF());
                return true;
            }
        };
        this.rzz = new OnClickListener() {
            public final void onClick(View view) {
                if (view.getTag() instanceof ap) {
                    String str = ((ap) view.getTag()).fvn;
                    m LR = h.LR(str);
                    if (LR == null) {
                        x.e("MicroMsg.TimelineClickListener", "photo click without snsinfo ,localId " + str);
                    } else if (LR.xD(32) && LR.byB() != null && LR.byB().rll == 1) {
                        b.this.rVX.onClick(view);
                    } else {
                        if (LR.byF().wYj.wfg == 21) {
                            if (q.FY().equals(LR.field_userName)) {
                                str = LR.byF().nMq;
                                com.tencent.mm.plugin.sns.lucky.a.m.j(LR);
                                com.tencent.mm.plugin.sns.lucky.a.m.i(LR);
                                System.currentTimeMillis();
                                com.tencent.mm.plugin.sns.lucky.a.b.qq(25);
                            }
                            if (!q.FY().equals(LR.field_userName)) {
                                com.tencent.mm.plugin.sns.lucky.b.a.a(2, LR);
                                com.tencent.mm.plugin.sns.lucky.a.b.qq(30);
                            }
                        }
                        if (LR.xD(32)) {
                            LR.byD();
                            if (LR.byB().bxd() && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.LL(LR.bzl().field_adxml)) {
                                str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(LR);
                                if (!bi.oN(str)) {
                                    LR.bzl().field_adxml = str;
                                }
                                k cVar = new com.tencent.mm.plugin.sns.a.b.c(LR.bzj(), 21, b.this.scene == 0 ? 1 : 2, "", LR.bzn(), LR.byG());
                                g.Dr();
                                g.Dp().gRu.a(cVar, 0);
                                int[] iArr = new int[2];
                                if (view != null) {
                                    view.getLocationInWindow(iArr);
                                }
                                int width = view.getWidth();
                                int height = view.getHeight();
                                Intent intent = new Intent();
                                intent.putExtra("img_gallery_left", iArr[0]);
                                intent.putExtra("img_gallery_top", iArr[1]);
                                intent.putExtra("img_gallery_width", width);
                                intent.putExtra("img_gallery_height", height);
                                intent.putExtra("sns_landing_pages_share_sns_id", LR.byG());
                                intent.putExtra("sns_landing_pages_rawSnsId", LR.byF().nMq);
                                intent.putExtra("sns_landing_pages_ux_info", LR.bzk());
                                intent.putExtra("sns_landing_pages_aid", LR.bzf());
                                intent.putExtra("sns_landing_pages_traceid", LR.bzg());
                                bpb byF = LR.byF();
                                if (byF != null) {
                                    List list = byF.wYj.wfh;
                                    if (list.size() > 0) {
                                        intent.putExtra("sns_landing_pages_share_thumb_url", ((are) list.get(0)).wEP);
                                        intent.putExtra("sns_landing_pages_from_outer_index", ((ap) view.getTag()).index);
                                    }
                                }
                                intent.setClass(b.this.activity, SnsAdNativeLandingPagesUI.class);
                                intent.putExtra("sns_landig_pages_from_source", b.this.scene == 0 ? 1 : 2);
                                intent.putExtra("sns_landing_pages_xml", LR.bzl().field_adxml);
                                intent.putExtra("sns_landing_pages_rec_src", LR.bzm());
                                intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                                intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                                b.this.activity.startActivity(intent);
                                b.this.activity.overridePendingTransition(0, 0);
                                if (b.this.rxY != null) {
                                    b.this.rxY.bvK().v(LR);
                                }
                            } else {
                                b.this.bM(view);
                            }
                        } else {
                            b.this.bM(view);
                        }
                        LR.xD(32);
                        ap apVar = (ap) view.getTag();
                        if (apVar.rFe && LR != null) {
                            ax.b(LR, apVar.index);
                            ax.c(LR, apVar.index);
                            com.tencent.mm.plugin.sns.model.au.Lc(LR.bza());
                        }
                        if (LR != null) {
                            bpb byF2 = LR.byF();
                            if (byF2 != null) {
                                String str2 = byF2.wYi == null ? null : byF2.wYi.nMq;
                                if (!bi.oN(str2) && com.tencent.mm.plugin.sns.c.a.ihO.cA(str2)) {
                                    com.tencent.mm.plugin.sns.c.a.ihO.a(null, str2, com.tencent.mm.plugin.sns.c.a.ihO.cy(str2), byF2.kyG, 2, 4, 4, byF2.wYn, byF2.nMq);
                                }
                            }
                        }
                    }
                }
            }
        };
        this.rVw = new OnClickListener() {
            public final void onClick(final View view) {
                com.tencent.mm.ui.base.h.a(b.this.activity, com.tencent.mm.plugin.sns.i.j.qSx, com.tencent.mm.plugin.sns.i.j.dGZ, com.tencent.mm.plugin.sns.i.j.dEH, com.tencent.mm.plugin.sns.i.j.dEy, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (view.getTag() instanceof String) {
                            String str = (String) view.getTag();
                            x.d("MicroMsg.TimelineClickListener", "onItemDelClick:" + str);
                            m LR = ae.bwf().LR(str);
                            com.tencent.mm.modelsns.b ix;
                            com.tencent.mm.modelsns.b iA;
                            String str2;
                            if (LR == null) {
                                x.d("MicroMsg.TimelineClickListener", "can not get snsinfo by localid %s then return it", str);
                            } else if (LR.bzc()) {
                                x.i("MicroMsg.TimelineClickListener", "dead item");
                                ae.bwf().xH(LR.ruM);
                                if (b.this.rVY != null) {
                                    b.this.rVY.bCo();
                                }
                                if (b.this.scene == 0) {
                                    ix = com.tencent.mm.modelsns.b.ix(739);
                                } else {
                                    ix = com.tencent.mm.modelsns.b.iy(739);
                                }
                                iA = ix.mF(i.g(LR)).iA(LR.field_type);
                                str2 = LR.bzc() ? "2" : LR.field_snsId == 0 ? "1" : "0";
                                iA.mF(str2);
                                ix.SE();
                                if (LR.field_type == 21) {
                                    com.tencent.mm.plugin.sns.lucky.a.g.buY().bva();
                                }
                            } else if (LR.bvO()) {
                                x.i("MicroMsg.TimelineClickListener", "cancel item " + LR.bza());
                                ae.bwb().r(LR);
                                b.this.bzQ();
                            } else {
                                x.i("MicroMsg.TimelineClickListener", "delete by server");
                                str = LR.byG();
                                ae.bwe().eE(u.Mk(str));
                                g.Dr();
                                g.Dp().gRu.a(new com.tencent.mm.plugin.sns.model.q(u.Mk(str), 1), 0);
                                ae.bwf().delete(u.Mk(str));
                                ae.bwk().eN(u.Mk(str));
                                b.this.bzQ();
                                bpb byF = LR.byF();
                                if (byF != null) {
                                    if (byF.wYi == null) {
                                        str = null;
                                    } else {
                                        str = byF.wYi.nMq;
                                    }
                                    if (!bi.oN(str) && com.tencent.mm.plugin.sns.c.a.ihO.cA(str)) {
                                        String cy = com.tencent.mm.plugin.sns.c.a.ihO.cy(str);
                                        com.tencent.mm.sdk.b.b nhVar = new nh();
                                        nhVar.fGb.appId = str;
                                        nhVar.fGb.fGc = byF.kyG;
                                        nhVar.fGb.ffM = cy;
                                        nhVar.fGb.mediaTagName = byF.wYn;
                                        com.tencent.mm.sdk.b.a.xmy.m(nhVar);
                                    }
                                }
                                if (b.this.scene == 0) {
                                    ix = com.tencent.mm.modelsns.b.ix(739);
                                } else {
                                    ix = com.tencent.mm.modelsns.b.iy(739);
                                }
                                iA = ix.mF(i.g(LR)).iA(LR.field_type);
                                str2 = LR.bzc() ? "2" : LR.field_snsId == 0 ? "1" : "0";
                                iA.mF(str2);
                                ix.SE();
                            }
                        }
                    }
                }, null);
            }
        };
        this.rVx = new OnClickListener() {
            public final void onClick(View view) {
                String str = (String) view.getTag();
                x.d("MicroMsg.TimelineClickListener", "onItemDelClick:" + str);
                bpb byF = ae.bwf().LR(str).byF();
                au auVar = byF.rey;
                if (auVar.vMx != null) {
                    String cy = com.tencent.mm.plugin.sns.c.a.ihO.cy(auVar.vMx.nlV);
                    int i = 0;
                    if (byF.wYj.wfg == 1) {
                        i = 2;
                    } else if (byF.wYj.wfg == 3) {
                        i = 5;
                    } else if (byF.wYj.wfg == 15) {
                        i = 38;
                    }
                    if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a(byF, b.this.activity)) {
                        com.tencent.mm.plugin.sns.c.a.ihO.a(b.this.activity, auVar.vMx.nlV, cy, byF.kyG, i, 11, 9, auVar.vMx.vMr, byF.nMq);
                        return;
                    }
                    com.tencent.mm.sdk.b.b gnVar;
                    switch (auVar.kzz) {
                        case 4:
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", auVar.nlE);
                            com.tencent.mm.plugin.sns.c.a.ihN.j(intent, b.this.activity);
                            com.tencent.mm.plugin.sns.c.a.ihO.a(b.this.activity, auVar.vMx.nlV, cy, byF.kyG, i, 11, 1, auVar.vMx.vMr, byF.nMq);
                            return;
                        case 5:
                            if (auVar.sfa == 1) {
                                gnVar = new gn();
                                gnVar.fxx.actionCode = 2;
                                gnVar.fxx.scene = 3;
                                gnVar.fxx.appId = auVar.vMx.nlV;
                                gnVar.fxx.context = b.this.activity;
                                com.tencent.mm.sdk.b.a.xmy.m(gnVar);
                                com.tencent.mm.plugin.sns.c.a.ihO.a(b.this.activity, auVar.vMx.nlV, cy, byF.kyG, i, 11, 6, auVar.vMx.vMr, byF.nMq);
                                return;
                            }
                            return;
                        case 6:
                            int a = ag.a(b.this.activity, auVar);
                            if (a == 1) {
                                gnVar = new gn();
                                gnVar.fxx.context = b.this.activity;
                                gnVar.fxx.actionCode = 2;
                                gnVar.fxx.appId = auVar.vMx.nlV;
                                gnVar.fxx.messageAction = auVar.vMx.vMt;
                                gnVar.fxx.messageExt = auVar.vMx.vMs;
                                gnVar.fxx.scene = 3;
                                com.tencent.mm.sdk.b.a.xmy.m(gnVar);
                                com.tencent.mm.plugin.sns.c.a.ihO.a(b.this.activity, auVar.vMx.nlV, cy, byF.kyG, i, 11, 6, auVar.vMx.vMr, byF.nMq);
                                return;
                            } else if (a == 2) {
                                gnVar = new gn();
                                gnVar.fxx.context = b.this.activity;
                                gnVar.fxx.actionCode = 1;
                                gnVar.fxx.appId = auVar.vMx.nlV;
                                gnVar.fxx.messageAction = auVar.vMx.vMt;
                                gnVar.fxx.messageExt = auVar.vMx.vMs;
                                gnVar.fxx.scene = 3;
                                com.tencent.mm.sdk.b.a.xmy.m(gnVar);
                                com.tencent.mm.plugin.sns.c.a.ihO.a(b.this.activity, auVar.vMx.nlV, cy, byF.kyG, i, 11, 3, auVar.vMx.vMr, byF.nMq);
                                return;
                            } else {
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.rVE = new OnClickListener() {
            public final void onClick(View view) {
                if (view.getTag() instanceof m) {
                    String str;
                    m mVar = (m) view.getTag();
                    if (mVar.field_type == 21 && q.FY().equals(mVar.field_userName)) {
                        str = mVar.byF().nMq;
                        com.tencent.mm.plugin.sns.lucky.a.m.j(mVar);
                        com.tencent.mm.plugin.sns.lucky.a.m.i(mVar);
                        System.currentTimeMillis();
                        com.tencent.mm.plugin.sns.lucky.a.b.qq(24);
                    }
                    Intent intent = new Intent();
                    intent.putExtra("key_sendid", mVar.byG());
                    intent.putExtra("key_feedid", mVar.bza());
                    intent.setClassName(b.this.activity, "com.tencent.mm.plugin.sns.lucky.ui.SnsLuckyMoneyDetailUI");
                    b.this.activity.startActivity(intent);
                    str = mVar.bza();
                    mVar.byG();
                    AnonymousClass9.MK(str);
                }
            }

            private static void MK(String str) {
                int i = 0;
                m eS = ae.bwf().eS(ae.bwf().LR(str).field_snsId);
                if (eS != null) {
                    List list;
                    bpb byF = eS.byF();
                    if (byF != null) {
                        list = byF.wYj.wfh;
                        if (list.size() > 0) {
                            list.get(0);
                        }
                    }
                    blf n = ai.n(eS);
                    list = new ArrayList();
                    List list2 = n.wVf.wVI;
                    if (list2 != null) {
                        while (true) {
                            int i2 = i;
                            if (i2 >= list2.size()) {
                                break;
                            }
                            blb blb = (blb) list2.get(i2);
                            com.tencent.mm.plugin.q.a.a aVar = new com.tencent.mm.plugin.q.a.a();
                            aVar.jPV = blb.vPp;
                            aVar.oep = blb.pgR;
                            aVar.oeq = blb.wUr;
                            list.add(aVar);
                            i = i2 + 1;
                        }
                    }
                    com.tencent.mm.plugin.q.a.i(str, list);
                }
            }
        };
        this.rVy = new OnClickListener() {
            public final void onClick(View view) {
                b.this.cB(view);
            }
        };
        this.rVz = new OnClickListener() {
            public final void onClick(View view) {
                b.this.cE(view);
            }
        };
        this.rVA = new OnClickListener() {
            public final void onClick(View view) {
                if (view.getTag() instanceof String) {
                    String str = (String) view.getTag();
                    x.d("MicroMsg.TimelineClickListener", "localId " + str);
                    ai.xb(u.Ml(str));
                    ai.wZ(u.Ml(str));
                    ae.bwb().buT();
                    b.this.bzQ();
                    if (b.this.rVY != null) {
                        b.this.rVY.bCo();
                    }
                }
            }
        };
        this.rVB = new OnClickListener() {
            public final void onClick(View view) {
                try {
                    int Ml = u.Ml((String) view.getTag());
                    Intent intent = new Intent();
                    intent.putExtra("sns_label_sns_info", Ml);
                    com.tencent.mm.plugin.sns.c.a.ihN.x(intent, b.this.activity);
                } catch (Exception e) {
                }
            }
        };
        this.rVF = new c() {
            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.m) {
                    com.tencent.mm.plugin.sns.ui.m mVar = (com.tencent.mm.plugin.sns.ui.m) view.getTag();
                    contextMenu.add(0, 11, 0, b.this.activity.getString(com.tencent.mm.plugin.sns.i.j.dED));
                    if (mVar.kyG != null && mVar.kyG.equals(q.FY())) {
                        contextMenu.add(0, 7, 0, b.this.activity.getString(com.tencent.mm.plugin.sns.i.j.dEH));
                    }
                    String ei = ao.ei(mVar.ryh, (mVar.raa.wUn != 0 ? (long) mVar.raa.wUn : mVar.raa.wUq));
                    int i = mVar.scene == 1 ? 2 : mVar.scene == 2 ? 4 : -1;
                    com.tencent.mm.plugin.sns.model.ao.b KW = ao.KW(ei);
                    boolean z = (KW == null || !KW.hjU || KW.hmT || (i & KW.fXe) == 0) ? false : true;
                    if (z) {
                        ao.b(contextMenu, false);
                    } else {
                        ao.a(contextMenu, false);
                    }
                }
            }

            public final boolean cL(View view) {
                if (!(view.getTag() instanceof com.tencent.mm.plugin.sns.ui.m)) {
                    return false;
                }
                m LQ = ae.bwf().LQ(((com.tencent.mm.plugin.sns.ui.m) view.getTag()).ryh);
                b.this.rVs.a(view, LQ.bza(), LQ.byF());
                return true;
            }
        };
        this.rVM = new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                x.d("MicroMsg.TimelineClickListener", "v " + view.getId() + "  ");
                b.this.cD(view);
                return false;
            }
        };
        this.rVN = new OnClickListener() {
            public final void onClick(View view) {
                if (view.getTag() instanceof as) {
                    m LQ = ae.bwf().LQ(((as) view.getTag()).fAR);
                    if (LQ != null) {
                        Intent intent = new Intent();
                        intent.putExtra("sns_text_show", LQ.byF().wYg);
                        intent.putExtra("sns_local_id", LQ.bza());
                        intent.setClass(b.this.activity, SnsSingleTextViewUI.class);
                        b.this.activity.startActivity(intent);
                    }
                }
            }
        };
        this.rVQ = new OnClickListener() {
            public final void onClick(View view) {
                if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.r) {
                    com.tencent.mm.plugin.sns.ui.r rVar = (com.tencent.mm.plugin.sns.ui.r) view.getTag();
                    are are = (are) rVar.ryt.wYj.wfh.get(0);
                    ae.bwf().LQ(rVar.fsC);
                    String str = "";
                    String r = am.r(ae.getAccSnsPath(), are.nMq);
                    String str2 = "";
                    String j = i.j(are);
                    if (FileOp.bO(r + j)) {
                        str = r + j;
                        str2 = r + i.e(are);
                    }
                    if (FileOp.bO(r + i.p(are))) {
                        str = r + i.p(are);
                        str2 = r + i.n(are);
                    }
                    int[] iArr = new int[2];
                    view.getLocationInWindow(iArr);
                    int width = view.getWidth();
                    int height = view.getHeight();
                    Intent intent = new Intent();
                    intent.setClass(b.this.activity, SnsOnlineVideoActivity.class);
                    intent.putExtra("intent_videopath", str);
                    intent.putExtra("intent_thumbpath", str2);
                    intent.putExtra("intent_localid", rVar.fsC);
                    intent.putExtra("intent_isad", false);
                    intent.putExtra("intent_from_scene", b.this.scene);
                    intent.putExtra("img_gallery_left", iArr[0]);
                    intent.putExtra("img_gallery_top", iArr[1]);
                    intent.putExtra("img_gallery_width", width);
                    intent.putExtra("img_gallery_height", height);
                    b.this.activity.startActivity(intent);
                    b.this.activity.overridePendingTransition(0, 0);
                    b.a(b.this, rVar.ryt);
                }
            }
        };
        this.rVP = new OnClickListener() {
            public final void onClick(View view) {
                int i;
                int i2;
                int i3;
                int i4;
                Throwable e;
                x.i("MicroMsg.TimelineClickListener", "onsight click");
                if (view.getTag() instanceof ak) {
                    ak akVar = (ak) view.getTag();
                    m LR = ae.bwf().LR(akVar.fsC);
                    if (LR != null) {
                        if (b.this.rxY != null) {
                            b.this.rxY.bvK().v(LR);
                        }
                        boolean xD = LR.xD(32);
                        if (xD && LR.byB() != null && LR.byB().rll == 1) {
                            b.this.rVX.onClick(view);
                            return;
                        }
                        bpb bpb = akVar.rDi;
                        if (bpb.wYj.wfh == null || bpb.wYj.wfh.size() == 0) {
                            x.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
                            return;
                        }
                        are are = (are) bpb.wYj.wfh.get(0);
                        if (xD) {
                            ae.bwc();
                            if (!com.tencent.mm.plugin.sns.model.g.t(are)) {
                                akVar.rqV.setVisibility(8);
                                akVar.rDl.setVisibility(0);
                                akVar.rDl.czF();
                                ae.bwc().z(are);
                                com.tencent.mm.plugin.sns.model.b bwa = ae.bwa();
                                an cjI = an.cjI();
                                cjI.time = bpb.pgR;
                                bwa.a(are, 4, null, cjI);
                                if (xD) {
                                    j.a(com.tencent.mm.plugin.sns.a.b.j.b.Sight, j.a.PlayIcon, LR);
                                    return;
                                }
                                return;
                            }
                        }
                        Object obj = (LR.xD(32) && LR.byB().bxd() && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.LL(LR.bzl().field_adxml)) ? 1 : null;
                        if (obj == null && xD && ae.bwc().u(are)) {
                            ae.bwc().z(are);
                            akVar.rqV.setVisibility(8);
                            akVar.rDl.setVisibility(8);
                            com.tencent.mm.plugin.sns.model.g bwc = ae.bwc();
                            com.tencent.mm.plugin.sight.decode.a.a aVar = akVar.qBQ;
                            int hashCode = b.this.activity.hashCode();
                            int i5 = akVar.position;
                            an cjI2 = an.cjI();
                            cjI2.time = bpb.pgR;
                            bwc.a(LR, are, aVar, hashCode, i5, cjI2, xD);
                            if (xD) {
                                j.a(com.tencent.mm.plugin.sns.a.b.j.b.Sight, j.a.PlayIcon, LR);
                                return;
                            }
                            return;
                        }
                        com.tencent.mm.modelsns.b ix;
                        if (b.this.scene == 0) {
                            ix = com.tencent.mm.modelsns.b.ix(717);
                        } else {
                            ix = com.tencent.mm.modelsns.b.iy(717);
                        }
                        ix.mF(i.g(LR)).iA(LR.field_type).bW(LR.xD(32)).mF(LR.bzk()).mF(are.nMq);
                        ix.SE();
                        if (b.this.scene == 0) {
                            ix = com.tencent.mm.modelsns.b.ix(745);
                        } else {
                            ix = com.tencent.mm.modelsns.b.iy(745);
                        }
                        ix.mF(i.g(LR)).iA(LR.field_type).bW(LR.xD(32));
                        if (xD) {
                            int i6 = b.this.scene == 0 ? 1 : 2;
                            String bzj = LR.bzj();
                            int i7 = (LR.xD(32) && LR.byB().bxd()) ? 21 : 17;
                            k cVar = new com.tencent.mm.plugin.sns.a.b.c(bzj, i7, i6, "", LR.bzn(), LR.byG());
                            g.Dr();
                            g.Dp().gRu.a(cVar, 0);
                            if (!(LR.byB().bxd() && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.LL(LR.bzl().field_adxml))) {
                                j.a(com.tencent.mm.plugin.sns.a.b.j.b.Sight, j.a.EnterFullScreen, LR);
                            }
                        }
                        String str = "";
                        String r = am.r(ae.getAccSnsPath(), are.nMq);
                        String str2 = "";
                        String j = i.j(are);
                        if (FileOp.bO(r + j)) {
                            str = r + j;
                            str2 = r + i.e(are);
                        }
                        if (FileOp.bO(r + i.p(are))) {
                            str = r + i.p(are);
                            str2 = r + i.n(are);
                        }
                        int[] iArr = new int[2];
                        view.getLocationInWindow(iArr);
                        int width = view.getWidth();
                        int height = view.getHeight();
                        com.tencent.mm.plugin.report.service.g.pWK.h(11444, Integer.valueOf(3));
                        Intent intent;
                        bpb byF;
                        if (!xD) {
                            x.i("MicroMsg.TimelineClickListener", "it not ad video, use online video activity to play.");
                            intent = new Intent();
                            intent.setClass(b.this.activity, SnsOnlineVideoActivity.class);
                            intent.putExtra("intent_videopath", str);
                            intent.putExtra("intent_thumbpath", str2);
                            intent.putExtra("intent_localid", akVar.fsC);
                            intent.putExtra("intent_isad", xD);
                            intent.putExtra("intent_from_scene", b.this.scene);
                            intent.putExtra("img_gallery_left", iArr[0]);
                            intent.putExtra("img_gallery_top", iArr[1]);
                            intent.putExtra("img_gallery_width", width);
                            intent.putExtra("img_gallery_height", height);
                            ix.b(intent, "intent_key_StatisticsOplog");
                            b.this.activity.startActivity(intent);
                            b.this.activity.overridePendingTransition(0, 0);
                            b.a(b.this, LR.byF());
                        } else if (LR.xD(32) && LR.byB().bxd() && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.LL(LR.bzl().field_adxml)) {
                            String w = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(LR);
                            if (!bi.oN(w)) {
                                LR.bzl().field_adxml = w;
                            }
                            intent = new Intent();
                            intent.putExtra("img_gallery_left", iArr[0]);
                            intent.putExtra("img_gallery_top", iArr[1]);
                            intent.putExtra("img_gallery_width", width);
                            intent.putExtra("img_gallery_height", height);
                            intent.putExtra("sns_landing_pages_share_sns_id", LR.byG());
                            intent.putExtra("sns_landing_pages_rawSnsId", LR.byF().nMq);
                            intent.putExtra("sns_landing_pages_ux_info", LR.bzk());
                            byF = LR.byF();
                            if (byF != null) {
                                List list = byF.wYj.wfh;
                                if (list.size() > 0) {
                                    intent.putExtra("sns_landing_pages_share_thumb_url", ((are) list.get(0)).wEP);
                                }
                            }
                            intent.setClass(b.this.activity, SnsAdNativeLandingPagesUI.class);
                            intent.putExtra("sns_landig_pages_from_source", b.this.scene == 0 ? 1 : 2);
                            intent.putExtra("sns_landing_pages_xml", LR.bzl().field_adxml);
                            intent.putExtra("sns_landing_pages_rec_src", LR.bzm());
                            intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                            intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                            intent.putExtra("sns_landing_is_native_sight_ad", true);
                            b.this.activity.startActivity(intent);
                            b.this.activity.overridePendingTransition(0, 0);
                        } else {
                            Intent intent2 = new Intent();
                            intent2.setClass(b.this.activity, SnsSightPlayerUI.class);
                            intent2.putExtra("intent_videopath", str);
                            intent2.putExtra("intent_thumbpath", str2);
                            intent2.putExtra("intent_localid", akVar.fsC);
                            intent2.putExtra("intent_isad", xD);
                            intent2.putExtra("intent_from_scene", b.this.scene);
                            intent2.putExtra("img_gallery_left", iArr[0]);
                            intent2.putExtra("img_gallery_top", iArr[1]);
                            intent2.putExtra("img_gallery_width", width);
                            intent2.putExtra("img_gallery_height", height);
                            ix.b(intent2, "intent_key_StatisticsOplog");
                            b.this.activity.startActivity(intent2);
                            b.this.activity.overridePendingTransition(0, 0);
                            final are are2 = are;
                            final ak akVar2 = akVar;
                            final m mVar = LR;
                            final bpb bpb2 = bpb;
                            final boolean z = xD;
                            new com.tencent.mm.sdk.platformtools.ag().postDelayed(new Runnable() {
                                public final void run() {
                                    if (ae.bwc().u(are2)) {
                                        akVar2.qBQ.aA(null, false);
                                        com.tencent.mm.plugin.sns.model.g bwc = ae.bwc();
                                        m mVar = mVar;
                                        are are = are2;
                                        com.tencent.mm.plugin.sight.decode.a.a aVar = akVar2.qBQ;
                                        int hashCode = b.this.activity.hashCode();
                                        int i = akVar2.position;
                                        an cjI = an.cjI();
                                        cjI.time = bpb2.pgR;
                                        bwc.a(mVar, are, aVar, hashCode, i, cjI, z);
                                        akVar2.rqV.setVisibility(0);
                                        akVar2.rDl.setVisibility(8);
                                        akVar2.rqV.setImageDrawable(com.tencent.mm.bu.a.b(b.this.activity, com.tencent.mm.plugin.sns.i.i.dAT));
                                    }
                                }
                            }, 500);
                            int[] iArr2 = new int[3];
                            if (!xD && ae.bwc().a(LR, iArr2) > 5) {
                                ae.bwc().y(are);
                                i = 1;
                            } else if (!xD || ae.bwc().b(LR, iArr2) <= 5) {
                                i = 2;
                            } else {
                                ae.bwc().y(are);
                                i = 1;
                            }
                            int i8 = iArr2[0];
                            int i9 = iArr2[1];
                            if (i == 2) {
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            width = iArr2[2];
                            byF = LR.byF();
                            com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
                            dVar.q("20FeedId", byF.nMq + ",");
                            dVar.q("21AdUxInfo", LR.bzk() + ",");
                            try {
                                blf blf = (blf) new blf().aH(LR.field_attrBuf);
                                if (blf.wVe != null) {
                                    bln bln = (bln) new bln().aH(blf.wVe.wRm.oz);
                                    if (bln.wVt != null) {
                                        i3 = bln.wVt.wfX;
                                        try {
                                            i4 = bln.wVt.wfY;
                                        } catch (Exception e2) {
                                            e = e2;
                                            x.printErrStackTrace("MicroMsg.TimelineClickListener", e, "", new Object[0]);
                                            i4 = 0;
                                            dVar.q("22LayerId", i3 + ",");
                                            dVar.q("23ExpId", i4 + ",");
                                            dVar.q("24ClickState", i + ",");
                                            dVar.q("25ClickTime", bi.Wx() + ",");
                                            i4 = 0;
                                            if (!com.tencent.mm.sdk.platformtools.ao.isWifi(com.tencent.mm.sdk.platformtools.ad.getContext())) {
                                                i4 = 1;
                                            } else if (!com.tencent.mm.sdk.platformtools.ao.is2G(com.tencent.mm.sdk.platformtools.ad.getContext())) {
                                                i4 = 2;
                                            } else if (!com.tencent.mm.sdk.platformtools.ao.is3G(com.tencent.mm.sdk.platformtools.ad.getContext())) {
                                                i4 = 3;
                                            } else if (com.tencent.mm.sdk.platformtools.ao.is4G(com.tencent.mm.sdk.platformtools.ad.getContext())) {
                                                i4 = 4;
                                            }
                                            dVar.q("26NetworkType", i4 + ",");
                                            dVar.q("27IsFlowControl", i8 + ",");
                                            dVar.q("28AutoDownloadSetting", i9 + ",");
                                            dVar.q("29IsAutoPlay", i2 + ",");
                                            dVar.q("30IsFlowControlDatePeriod", width + ",");
                                            x.i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + dVar.SG());
                                            com.tencent.mm.plugin.report.service.g.pWK.h(13323, dVar);
                                        }
                                        dVar.q("22LayerId", i3 + ",");
                                        dVar.q("23ExpId", i4 + ",");
                                        dVar.q("24ClickState", i + ",");
                                        dVar.q("25ClickTime", bi.Wx() + ",");
                                        i4 = 0;
                                        if (!com.tencent.mm.sdk.platformtools.ao.isWifi(com.tencent.mm.sdk.platformtools.ad.getContext())) {
                                            i4 = 1;
                                        } else if (!com.tencent.mm.sdk.platformtools.ao.is2G(com.tencent.mm.sdk.platformtools.ad.getContext())) {
                                            i4 = 2;
                                        } else if (!com.tencent.mm.sdk.platformtools.ao.is3G(com.tencent.mm.sdk.platformtools.ad.getContext())) {
                                            i4 = 3;
                                        } else if (com.tencent.mm.sdk.platformtools.ao.is4G(com.tencent.mm.sdk.platformtools.ad.getContext())) {
                                            i4 = 4;
                                        }
                                        dVar.q("26NetworkType", i4 + ",");
                                        dVar.q("27IsFlowControl", i8 + ",");
                                        dVar.q("28AutoDownloadSetting", i9 + ",");
                                        dVar.q("29IsAutoPlay", i2 + ",");
                                        dVar.q("30IsFlowControlDatePeriod", width + ",");
                                        x.i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + dVar.SG());
                                        com.tencent.mm.plugin.report.service.g.pWK.h(13323, dVar);
                                    }
                                }
                                i4 = 0;
                                i3 = 0;
                            } catch (Exception e3) {
                                e = e3;
                                i3 = 0;
                                x.printErrStackTrace("MicroMsg.TimelineClickListener", e, "", new Object[0]);
                                i4 = 0;
                                dVar.q("22LayerId", i3 + ",");
                                dVar.q("23ExpId", i4 + ",");
                                dVar.q("24ClickState", i + ",");
                                dVar.q("25ClickTime", bi.Wx() + ",");
                                i4 = 0;
                                if (!com.tencent.mm.sdk.platformtools.ao.isWifi(com.tencent.mm.sdk.platformtools.ad.getContext())) {
                                    i4 = 1;
                                } else if (!com.tencent.mm.sdk.platformtools.ao.is2G(com.tencent.mm.sdk.platformtools.ad.getContext())) {
                                    i4 = 2;
                                } else if (!com.tencent.mm.sdk.platformtools.ao.is3G(com.tencent.mm.sdk.platformtools.ad.getContext())) {
                                    i4 = 3;
                                } else if (com.tencent.mm.sdk.platformtools.ao.is4G(com.tencent.mm.sdk.platformtools.ad.getContext())) {
                                    i4 = 4;
                                }
                                dVar.q("26NetworkType", i4 + ",");
                                dVar.q("27IsFlowControl", i8 + ",");
                                dVar.q("28AutoDownloadSetting", i9 + ",");
                                dVar.q("29IsAutoPlay", i2 + ",");
                                dVar.q("30IsFlowControlDatePeriod", width + ",");
                                x.i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + dVar.SG());
                                com.tencent.mm.plugin.report.service.g.pWK.h(13323, dVar);
                            }
                            dVar.q("22LayerId", i3 + ",");
                            dVar.q("23ExpId", i4 + ",");
                            dVar.q("24ClickState", i + ",");
                            dVar.q("25ClickTime", bi.Wx() + ",");
                            i4 = 0;
                            if (!com.tencent.mm.sdk.platformtools.ao.isWifi(com.tencent.mm.sdk.platformtools.ad.getContext())) {
                                i4 = 1;
                            } else if (!com.tencent.mm.sdk.platformtools.ao.is2G(com.tencent.mm.sdk.platformtools.ad.getContext())) {
                                i4 = 2;
                            } else if (!com.tencent.mm.sdk.platformtools.ao.is3G(com.tencent.mm.sdk.platformtools.ad.getContext())) {
                                i4 = 3;
                            } else if (com.tencent.mm.sdk.platformtools.ao.is4G(com.tencent.mm.sdk.platformtools.ad.getContext())) {
                                i4 = 4;
                            }
                            dVar.q("26NetworkType", i4 + ",");
                            dVar.q("27IsFlowControl", i8 + ",");
                            dVar.q("28AutoDownloadSetting", i9 + ",");
                            dVar.q("29IsAutoPlay", i2 + ",");
                            dVar.q("30IsFlowControlDatePeriod", width + ",");
                            x.i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + dVar.SG());
                            com.tencent.mm.plugin.report.service.g.pWK.h(13323, dVar);
                        }
                    }
                }
            }
        };
        this.rVI = new c() {
            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                if (view.getTag() instanceof ak) {
                    int i;
                    com.tencent.mm.sdk.b.b diVar;
                    ak akVar = (ak) view.getTag();
                    if (!akVar.qWK) {
                        contextMenu.add(0, 19, 0, b.this.activity.getString(com.tencent.mm.plugin.sns.i.j.dRW));
                    }
                    if (bi.Wo(com.tencent.mm.j.g.Af().getValue("SIGHTCannotTransmitForFav")) == 0) {
                        if (akVar.rDi.wYj.wfh.size() > 0) {
                            are are = (are) akVar.rDi.wYj.wfh.get(0);
                            String str = am.r(ae.getAccSnsPath(), are.nMq) + i.e(are);
                            String a = com.tencent.mm.plugin.sns.model.ap.a(akVar.fsC, are);
                            x.i("MicroMsg.TimelineOnCreateContextMenuListener", "config can forward sight, thumb existed %B, video existed %B", Boolean.valueOf(FileOp.bO(str)), Boolean.valueOf(FileOp.bO(a)));
                            if (FileOp.bO(str) && r1) {
                                i = 1;
                                if (d.Pu("favorite")) {
                                    contextMenu.add(0, 10, 0, b.this.activity.getString(com.tencent.mm.plugin.sns.i.j.eAq));
                                }
                                if (i != 0) {
                                    diVar = new di();
                                    diVar.fsL.fsC = akVar.fsC;
                                    com.tencent.mm.sdk.b.a.xmy.m(diVar);
                                    if (diVar.fsM.fsk) {
                                        contextMenu.add(0, 18, 0, b.this.activity.getString(com.tencent.mm.plugin.sns.i.j.qPx));
                                    }
                                }
                            }
                        }
                        x.w("MicroMsg.TimelineOnCreateContextMenuListener", "sight item had not attch.");
                    }
                    i = 0;
                    if (d.Pu("favorite")) {
                        contextMenu.add(0, 10, 0, b.this.activity.getString(com.tencent.mm.plugin.sns.i.j.eAq));
                    }
                    if (i != 0) {
                        diVar = new di();
                        diVar.fsL.fsC = akVar.fsC;
                        com.tencent.mm.sdk.b.a.xmy.m(diVar);
                        if (diVar.fsM.fsk) {
                            contextMenu.add(0, 18, 0, b.this.activity.getString(com.tencent.mm.plugin.sns.i.j.qPx));
                        }
                    }
                }
            }

            public final boolean cL(View view) {
                if (!(view.getTag() instanceof ak)) {
                    return false;
                }
                String str = ((ak) view.getTag()).fsC;
                b.this.rVs.a(view, str, ae.bwf().LR(str).byF());
                return true;
            }
        };
        this.rVR = new OnClickListener() {
            public final void onClick(View view) {
                b.this.cF(view);
                if (view.getTag() != null && (view.getTag() instanceof com.tencent.mm.plugin.sns.data.b)) {
                    com.tencent.mm.plugin.sns.data.b bVar = (com.tencent.mm.plugin.sns.data.b) view.getTag();
                    m LR = ae.bwf().LR(bVar.fsC);
                    if (LR != null && LR.xD(32)) {
                        bVar.qWN = System.currentTimeMillis();
                        k cVar = new com.tencent.mm.plugin.sns.a.b.c(LR.bzj(), 20, b.this.scene == 0 ? 1 : 2, "", LR.bzn(), LR.byG());
                        g.Dr();
                        g.Dp().gRu.a(cVar, 0);
                    }
                }
            }
        };
        this.rVD = new OnClickListener() {
            public final void onClick(View view) {
                x.i("MicroMsg.TimelineClickListener", "unlike click");
                com.tencent.mm.plugin.sns.data.b bVar = (com.tencent.mm.plugin.sns.data.b) view.getTag();
                m LR = ae.bwf().LR(bVar.fsC);
                if (LR != null) {
                    int i;
                    if (LR.xD(32)) {
                        Object obj;
                        com.tencent.mm.plugin.sns.storage.a byD = LR.byD();
                        if (byD == null) {
                            obj = "";
                        } else {
                            String obj2 = byD.iWv;
                        }
                        ((com.tencent.mm.plugin.sns.b.c) g.h(com.tencent.mm.plugin.sns.b.c.class)).a(11855, LR.bzm(), Integer.valueOf(3), obj2, Integer.valueOf(LR.bzm()));
                    }
                    if (bVar.qWL.rSq.rkj.bxc().size() > 0) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    Object aVar;
                    k qVar;
                    if (i != 0) {
                        b.this.bzR();
                        aVar = new com.tencent.mm.plugin.sns.storage.a.b.a();
                        aVar.rkw = com.tencent.mm.plugin.sns.storage.a.b.a.rks;
                        aVar.qWN = bVar.qWN;
                        aVar.rkx = 0;
                        qVar = new com.tencent.mm.plugin.sns.model.q(LR.field_snsId, 8, aVar);
                        g.Dr();
                        g.Dp().gRu.a(qVar, 0);
                    } else if (!bVar.qWL.rSq.rkn) {
                        b.this.cG(view);
                        aVar = new com.tencent.mm.plugin.sns.storage.a.b.a();
                        aVar.qWN = bVar.qWN;
                        aVar.rkx = System.currentTimeMillis();
                        qVar = new com.tencent.mm.plugin.sns.model.q(LR.field_snsId, 8, aVar);
                        g.Dr();
                        g.Dp().gRu.a(qVar, 0);
                    }
                }
            }
        };
        this.rVU = new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (view.getTag() != null && (view.getTag() instanceof com.tencent.mm.plugin.sns.data.b)) {
                    com.tencent.mm.plugin.sns.data.b bVar = (com.tencent.mm.plugin.sns.data.b) view.getTag();
                    if (i < bVar.qWL.rSq.rkj.bxc().size() && !bVar.qWL.rSq.rkn) {
                        Object obj = (com.tencent.mm.plugin.sns.storage.a.b.a) bVar.qWL.rSq.rkj.bxc().get(i);
                        x.i("MicroMsg.TimelineClickListener", "unlike item click, reason=%s, id=%s", obj.rkt, Integer.valueOf(obj.rkw));
                        m LR = ae.bwf().LR(bVar.fsC);
                        if (LR != null) {
                            obj.qWN = bVar.qWN;
                            obj.rkx = System.currentTimeMillis();
                            k qVar = new com.tencent.mm.plugin.sns.model.q(LR.field_snsId, 8, obj);
                            g.Dr();
                            g.Dp().gRu.a(qVar, 0);
                            b.this.cG(view);
                        }
                    }
                }
            }
        };
        this.rVX = new OnClickListener() {
            public final void onClick(View view) {
                if (view.getTag() == null) {
                    return;
                }
                if ((view.getTag() instanceof c) || (view.getTag() instanceof ap) || (view.getTag() instanceof ak) || (view.getTag() instanceof MaskImageView)) {
                    Object obj;
                    int i;
                    int i2;
                    int i3;
                    int i4;
                    Object obj2;
                    m mVar;
                    MaskImageView maskImageView;
                    c cVar;
                    Object obj3 = null;
                    int i5 = 0;
                    m LR;
                    Object obj4;
                    int obj42;
                    if (view.getTag() instanceof ap) {
                        LR = h.LR(((ap) view.getTag()).fvn);
                        if (view instanceof LinearLayout) {
                            obj42 = null;
                        } else {
                            obj42 = 1;
                        }
                        if (((ap) view.getTag()).rDn) {
                            obj = 1;
                            i = ((ap) view.getTag()).index;
                            if (i > 0) {
                                i2 = 2;
                            } else {
                                i2 = 1;
                            }
                        } else {
                            i2 = 0;
                            i = 0;
                            obj = null;
                        }
                        i3 = i2;
                        i4 = i;
                        obj2 = obj;
                        obj = obj42;
                        mVar = LR;
                    } else if (view.getTag() instanceof MaskImageView) {
                        Object obj5;
                        maskImageView = (MaskImageView) view.getTag();
                        if (maskImageView.getTag() instanceof ap) {
                            mVar = h.LR(((ap) maskImageView.getTag()).fvn);
                            if (view instanceof LinearLayout) {
                                i3 = 0;
                                i4 = 0;
                                obj2 = null;
                                obj = null;
                            } else {
                                obj5 = 1;
                            }
                        } else {
                            obj5 = null;
                            mVar = null;
                        }
                        i3 = 0;
                        i4 = 0;
                        obj2 = null;
                        obj = obj5;
                    } else if (view.getTag() instanceof ak) {
                        LR = ae.bwf().LR(((ak) view.getTag()).fsC);
                        if (view instanceof LinearLayout) {
                            obj42 = null;
                        } else {
                            obj42 = 1;
                        }
                        if (((ak) view.getTag()).rDn) {
                            obj3 = 1;
                            i5 = ((ak) view.getTag()).rDo;
                            i2 = i5 > 0 ? 2 : 1;
                        } else {
                            i2 = 0;
                        }
                        i3 = i2;
                        i4 = i5;
                        obj2 = obj3;
                        obj = obj42;
                        mVar = LR;
                    } else {
                        cVar = (c) view.getTag();
                        LR = h.LQ(cVar.fAR);
                        if (cVar.rUL != null) {
                            i5 = cVar.rUL.index;
                            i3 = i5 > 0 ? 2 : 1;
                            i4 = i5;
                            int obj22 = 1;
                            obj = null;
                            mVar = LR;
                        } else {
                            i3 = 0;
                            i4 = 0;
                            obj22 = null;
                            obj = null;
                            mVar = LR;
                        }
                    }
                    if (mVar != null && mVar.xD(32)) {
                        String str;
                        String bxg;
                        String Co;
                        try {
                            Object str2;
                            com.tencent.mm.plugin.sns.storage.a byD = mVar.byD();
                            if (byD == null) {
                                str2 = "";
                            } else {
                                str2 = byD.iWv;
                            }
                            String str3 = mVar.byF().nMq;
                            if (!mVar.bxo()) {
                                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
                                Object[] objArr = new Object[4];
                                objArr[0] = Integer.valueOf(b.this.scene == 0 ? 1 : 2);
                                objArr[1] = Integer.valueOf(obj != null ? 1 : 2);
                                objArr[2] = str3;
                                objArr[3] = str2;
                                gVar.h(14066, objArr);
                            }
                        } catch (Exception e) {
                            x.e("MicroMsg.TimelineClickListener", "report click ad card style error " + e.getMessage());
                        }
                        if (mVar.bzl().byB().bxk()) {
                            bxg = mVar.bzl().byB().bxg();
                            str2 = mVar.bzk();
                            g.Do();
                            Co = a.Co();
                            u.f(bxg, str2, Co, u.Z(bxg, str2, Co), 0);
                        }
                        bpb byF = mVar.byF();
                        int i6;
                        String str4;
                        int i7;
                        k cVar2;
                        bpb byF2;
                        List list;
                        Intent intent;
                        boolean z;
                        Parcelable snsAdClick;
                        com.tencent.mm.plugin.sns.storage.a byD2;
                        Bundle bundle;
                        if ((byF.wYj.wfg == 15 && byF.wYq != 1) || (byF.wYj.wfg == 27 && byF.wYj.wfh.size() > i4 && ((are) byF.wYj.wfh.get(i4)).kzz == 6)) {
                            ak akVar;
                            c cVar3;
                            ak akVar2;
                            x.i("MicroMsg.TimelineClickListener", "onsight click");
                            if (view.getTag() instanceof ak) {
                                akVar = (ak) view.getTag();
                            } else {
                                akVar = null;
                            }
                            if (view.getTag() instanceof c) {
                                cVar = (c) view.getTag();
                                if (byF.wYj.wfg == 27) {
                                    akVar = cVar.rUM;
                                } else if (cVar.rUI.rDk != null && (cVar.rUI.rDk.getTag() instanceof ak)) {
                                    akVar = (ak) cVar.rUI.rDk.getTag();
                                }
                                if (akVar != null) {
                                    cVar3 = cVar;
                                    akVar2 = akVar;
                                } else {
                                    return;
                                }
                            }
                            cVar3 = null;
                            akVar2 = akVar;
                            if (mVar != null) {
                                if (b.this.rxY != null) {
                                    b.this.rxY.bvK().v(mVar);
                                }
                                boolean xD = mVar.xD(32);
                                bpb bpb = akVar2.rDi;
                                if (bpb.wYj.wfh == null || bpb.wYj.wfh.size() == 0) {
                                    x.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
                                    return;
                                }
                                com.tencent.mm.modelsns.b ix;
                                String j;
                                int[] iArr;
                                int i8;
                                ak akVar3;
                                Intent intent2;
                                are are = (are) bpb.wYj.wfh.get(i4);
                                if (xD) {
                                    ae.bwc();
                                    if (!com.tencent.mm.plugin.sns.model.g.t(are)) {
                                        akVar2.rqV.setVisibility(8);
                                        akVar2.rDl.setVisibility(0);
                                        akVar2.rDl.czF();
                                        ae.bwc().z(are);
                                        com.tencent.mm.plugin.sns.model.b bwa = ae.bwa();
                                        an cjI = an.cjI();
                                        cjI.time = bpb.pgR;
                                        bwa.a(are, 4, null, cjI);
                                        if (xD) {
                                            j.a(com.tencent.mm.plugin.sns.a.b.j.b.Sight, j.a.PlayIcon, mVar);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                if (mVar.xD(32) && mVar.byB().bxd()) {
                                    if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.es(mVar.bzl().field_adxml, i4 > 0 ? "adTurnCanvasInfo" : "adCanvasInfo")) {
                                        obj = 1;
                                        if (obj != null && xD && ae.bwc().u(are)) {
                                            ae.bwc().z(are);
                                            akVar2.rqV.setVisibility(8);
                                            akVar2.rDl.setVisibility(8);
                                            com.tencent.mm.plugin.sns.model.g bwc = ae.bwc();
                                            com.tencent.mm.plugin.sight.decode.a.a aVar = akVar2.qBQ;
                                            int hashCode = b.this.activity.hashCode();
                                            i6 = akVar2.position;
                                            an cjI2 = an.cjI();
                                            cjI2.time = bpb.pgR;
                                            bwc.a(mVar, are, aVar, hashCode, i6, cjI2, xD);
                                            if (xD) {
                                                j.a(com.tencent.mm.plugin.sns.a.b.j.b.Sight, j.a.PlayIcon, mVar);
                                                return;
                                            }
                                            return;
                                        }
                                        if (b.this.scene != 0) {
                                            ix = com.tencent.mm.modelsns.b.ix(717);
                                        } else {
                                            ix = com.tencent.mm.modelsns.b.iy(717);
                                        }
                                        ix.mF(i.g(mVar)).iA(mVar.field_type).bW(mVar.xD(32)).mF(mVar.bzk()).mF(are.nMq);
                                        ix.SE();
                                        if (b.this.scene != 0) {
                                            ix = com.tencent.mm.modelsns.b.ix(745);
                                        } else {
                                            ix = com.tencent.mm.modelsns.b.iy(745);
                                        }
                                        ix.mF(i.g(mVar)).iA(mVar.field_type).bW(mVar.xD(32));
                                        bxg = am.r(ae.getAccSnsPath(), are.nMq);
                                        j = i.j(are);
                                        if (FileOp.bO(bxg + j)) {
                                            new StringBuilder().append(bxg).append(j);
                                            new StringBuilder().append(bxg).append(i.e(are));
                                        }
                                        if (FileOp.bO(bxg + i.p(are))) {
                                            new StringBuilder().append(bxg).append(i.p(are));
                                            new StringBuilder().append(bxg).append(i.n(are));
                                        }
                                        iArr = new int[2];
                                        i2 = 0;
                                        if (cVar3 == null) {
                                            if (cVar3.rUI.rDk != null) {
                                                cVar3.rUI.rDk.getLocationInWindow(iArr);
                                                i = cVar3.rUI.rDk.getWidth();
                                                i2 = cVar3.rUI.rDk.getHeight();
                                                i8 = i;
                                            } else if (cVar3.rUJ == null) {
                                                cVar3.rUJ.getLocationInWindow(iArr);
                                                i = cVar3.rUJ.getWidth();
                                                i2 = cVar3.rUJ.getHeight();
                                                i8 = i;
                                            } else {
                                                i8 = 0;
                                            }
                                        } else if (view.getTag() instanceof ak) {
                                            if (view != null) {
                                                view.getLocationInWindow(iArr);
                                            }
                                            i = view.getWidth();
                                            i2 = view.getHeight();
                                            i8 = i;
                                        } else {
                                            akVar3 = (ak) view.getTag();
                                            if (akVar3 != null) {
                                                akVar3.rDk.getLocationInWindow(iArr);
                                            }
                                            i = akVar3.rDk.getWidth();
                                            i2 = akVar3.rDk.getHeight();
                                            i8 = i;
                                        }
                                        com.tencent.mm.plugin.report.service.g.pWK.h(11444, Integer.valueOf(3));
                                        if (obj == null) {
                                            Co = mVar.bzj();
                                            i6 = b.this.scene != 0 ? 1 : 2;
                                            str4 = "";
                                            if (obj22 == null) {
                                                i7 = 6;
                                            } else {
                                                i7 = 5;
                                            }
                                            if (mVar.bzl() != null) {
                                                mVar.bzl().getSource();
                                            }
                                            cVar2 = new com.tencent.mm.plugin.sns.a.b.c(Co, 22, i6, str4, i7, 21, mVar.byF().rzD, mVar.byG(), i3);
                                            g.Dr();
                                            g.Dp().gRu.a(cVar2, 0);
                                            intent2 = new Intent();
                                            intent2.putExtra("img_gallery_left", iArr[0]);
                                            intent2.putExtra("img_gallery_top", iArr[1]);
                                            intent2.putExtra("img_gallery_width", i8);
                                            intent2.putExtra("img_gallery_height", i2);
                                            intent2.putExtra("sns_landing_pages_share_sns_id", mVar.byG());
                                            intent2.putExtra("sns_landing_pages_rawSnsId", mVar.byF().nMq);
                                            intent2.putExtra("sns_landing_pages_ux_info", mVar.bzk());
                                            byF2 = mVar.byF();
                                            if (byF2 != null) {
                                                list = byF2.wYj.wfh;
                                                if (list.size() > i4) {
                                                    intent2.putExtra("sns_landing_pages_share_thumb_url", ((are) list.get(i4)).wEP);
                                                }
                                            }
                                            intent2.setClass(b.this.activity, SnsAdNativeLandingPagesUI.class);
                                            intent2.putExtra("sns_landig_pages_from_source", b.this.scene != 0 ? 1 : 2);
                                            intent2.putExtra("sns_landing_pages_xml", i4 <= 0 ? mVar.byB().bxn() : mVar.bzl().field_adxml);
                                            intent2.putExtra("sns_landing_pages_rec_src", mVar.bzm());
                                            intent2.putExtra("sns_landing_pages_xml_prefix", "adxml");
                                            intent2.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                                            intent2.putExtra("sns_landing_is_native_sight_ad", true);
                                            b.this.activity.startActivity(intent2);
                                            b.this.activity.overridePendingTransition(0, 0);
                                        }
                                        if (b.a(b.this, mVar.byD(), mVar, i4 <= 0)) {
                                            Co = mVar.bzj();
                                            i6 = b.this.scene != 0 ? 1 : 2;
                                            str4 = "";
                                            i7 = obj22 == null ? 6 : 5;
                                            if (mVar.bzl() != null) {
                                                mVar.bzl().getSource();
                                            }
                                            cVar2 = new com.tencent.mm.plugin.sns.a.b.c(Co, 22, i6, str4, i7, 0, mVar.byF().rzD, mVar.byG(), i3);
                                            g.Dr();
                                            g.Dp().gRu.a(cVar2, 0);
                                            bxg = i4 <= 0 ? mVar.byB().rlo.rjU : mVar.bzi();
                                            if (bi.oN(bxg)) {
                                                bxg = mVar.bzh();
                                            }
                                            if (!bi.oN(bxg)) {
                                                x.i("MicroMsg.TimelineClickListener", "adlink url " + bxg + " " + mVar.byB().rkz);
                                                intent = new Intent();
                                                z = mVar.byB().rkz != 0;
                                                if (r.ifW) {
                                                    z = false;
                                                }
                                                snsAdClick = new SnsAdClick(mVar.bzj(), b.this.scene != 0 ? 1 : 2, mVar.field_snsId, mVar.bzk(), obj22 == null ? 6 : 5, (byte) 0);
                                                snsAdClick.hQk = mVar.byF().nMq;
                                                if (mVar != null && mVar.xD(32)) {
                                                    byD2 = mVar.byD();
                                                    if (byD2 != null) {
                                                        intent.putExtra("KsnsViewId", byD2.iWv);
                                                    }
                                                }
                                                intent.putExtra("KRightBtn", z);
                                                bundle = new Bundle();
                                                bundle.putParcelable("KSnsAdTag", snsAdClick);
                                                bundle.putString("key_snsad_statextstr", mVar.byF().rzD);
                                                intent.putExtra("jsapiargs", bundle);
                                                intent.putExtra("rawUrl", bxg);
                                                intent.putExtra("useJs", true);
                                                intent.putExtra("srcUsername", mVar.field_userName);
                                                intent.putExtra("stastic_scene", 15);
                                                intent.putExtra("KPublisherId", "sns_" + i.er(mVar.field_snsId));
                                                intent.putExtra("pre_username", mVar.field_userName);
                                                intent.putExtra("prePublishId", "sns_" + i.er(mVar.field_snsId));
                                                intent.putExtra("preUsername", mVar.field_userName);
                                                com.tencent.mm.plugin.sns.c.a.ihN.j(intent, b.this.activity);
                                                return;
                                            }
                                            return;
                                        }
                                        Co = mVar.bzj();
                                        i6 = b.this.scene != 0 ? 1 : 2;
                                        str4 = "";
                                        i7 = mVar.bzn();
                                        if (mVar.bzl() != null) {
                                            mVar.bzl().getSource();
                                        }
                                        cVar2 = new com.tencent.mm.plugin.sns.a.b.c(Co, 22, i6, str4, i7, 31, mVar.byF().rzD, mVar.byG(), i3);
                                        g.Dr();
                                        g.Dp().gRu.a(cVar2, 0);
                                        return;
                                    }
                                }
                                obj = null;
                                if (obj != null) {
                                }
                                if (b.this.scene != 0) {
                                    ix = com.tencent.mm.modelsns.b.iy(717);
                                } else {
                                    ix = com.tencent.mm.modelsns.b.ix(717);
                                }
                                ix.mF(i.g(mVar)).iA(mVar.field_type).bW(mVar.xD(32)).mF(mVar.bzk()).mF(are.nMq);
                                ix.SE();
                                if (b.this.scene != 0) {
                                    ix = com.tencent.mm.modelsns.b.iy(745);
                                } else {
                                    ix = com.tencent.mm.modelsns.b.ix(745);
                                }
                                ix.mF(i.g(mVar)).iA(mVar.field_type).bW(mVar.xD(32));
                                bxg = am.r(ae.getAccSnsPath(), are.nMq);
                                j = i.j(are);
                                if (FileOp.bO(bxg + j)) {
                                    new StringBuilder().append(bxg).append(j);
                                    new StringBuilder().append(bxg).append(i.e(are));
                                }
                                if (FileOp.bO(bxg + i.p(are))) {
                                    new StringBuilder().append(bxg).append(i.p(are));
                                    new StringBuilder().append(bxg).append(i.n(are));
                                }
                                iArr = new int[2];
                                i2 = 0;
                                if (cVar3 == null) {
                                    if (view.getTag() instanceof ak) {
                                        if (view != null) {
                                            view.getLocationInWindow(iArr);
                                        }
                                        i = view.getWidth();
                                        i2 = view.getHeight();
                                        i8 = i;
                                    } else {
                                        akVar3 = (ak) view.getTag();
                                        if (akVar3 != null) {
                                            akVar3.rDk.getLocationInWindow(iArr);
                                        }
                                        i = akVar3.rDk.getWidth();
                                        i2 = akVar3.rDk.getHeight();
                                        i8 = i;
                                    }
                                } else if (cVar3.rUI.rDk != null) {
                                    cVar3.rUI.rDk.getLocationInWindow(iArr);
                                    i = cVar3.rUI.rDk.getWidth();
                                    i2 = cVar3.rUI.rDk.getHeight();
                                    i8 = i;
                                } else if (cVar3.rUJ == null) {
                                    i8 = 0;
                                } else {
                                    cVar3.rUJ.getLocationInWindow(iArr);
                                    i = cVar3.rUJ.getWidth();
                                    i2 = cVar3.rUJ.getHeight();
                                    i8 = i;
                                }
                                com.tencent.mm.plugin.report.service.g.pWK.h(11444, Integer.valueOf(3));
                                if (obj == null) {
                                    if (i4 <= 0) {
                                    }
                                    if (b.a(b.this, mVar.byD(), mVar, i4 <= 0)) {
                                        Co = mVar.bzj();
                                        if (b.this.scene != 0) {
                                        }
                                        str4 = "";
                                        if (obj22 == null) {
                                        }
                                        if (mVar.bzl() != null) {
                                            mVar.bzl().getSource();
                                        }
                                        cVar2 = new com.tencent.mm.plugin.sns.a.b.c(Co, 22, i6, str4, i7, 0, mVar.byF().rzD, mVar.byG(), i3);
                                        g.Dr();
                                        g.Dp().gRu.a(cVar2, 0);
                                        if (i4 <= 0) {
                                        }
                                        if (bi.oN(bxg)) {
                                            bxg = mVar.bzh();
                                        }
                                        if (!bi.oN(bxg)) {
                                            x.i("MicroMsg.TimelineClickListener", "adlink url " + bxg + " " + mVar.byB().rkz);
                                            intent = new Intent();
                                            if (mVar.byB().rkz != 0) {
                                            }
                                            if (r.ifW) {
                                                z = false;
                                            }
                                            if (b.this.scene != 0) {
                                            }
                                            if (obj22 == null) {
                                            }
                                            snsAdClick = new SnsAdClick(mVar.bzj(), b.this.scene != 0 ? 1 : 2, mVar.field_snsId, mVar.bzk(), obj22 == null ? 6 : 5, (byte) 0);
                                            snsAdClick.hQk = mVar.byF().nMq;
                                            byD2 = mVar.byD();
                                            if (byD2 != null) {
                                                intent.putExtra("KsnsViewId", byD2.iWv);
                                            }
                                            intent.putExtra("KRightBtn", z);
                                            bundle = new Bundle();
                                            bundle.putParcelable("KSnsAdTag", snsAdClick);
                                            bundle.putString("key_snsad_statextstr", mVar.byF().rzD);
                                            intent.putExtra("jsapiargs", bundle);
                                            intent.putExtra("rawUrl", bxg);
                                            intent.putExtra("useJs", true);
                                            intent.putExtra("srcUsername", mVar.field_userName);
                                            intent.putExtra("stastic_scene", 15);
                                            intent.putExtra("KPublisherId", "sns_" + i.er(mVar.field_snsId));
                                            intent.putExtra("pre_username", mVar.field_userName);
                                            intent.putExtra("prePublishId", "sns_" + i.er(mVar.field_snsId));
                                            intent.putExtra("preUsername", mVar.field_userName);
                                            com.tencent.mm.plugin.sns.c.a.ihN.j(intent, b.this.activity);
                                            return;
                                        }
                                        return;
                                    }
                                    Co = mVar.bzj();
                                    if (b.this.scene != 0) {
                                    }
                                    str4 = "";
                                    i7 = mVar.bzn();
                                    if (mVar.bzl() != null) {
                                        mVar.bzl().getSource();
                                    }
                                    cVar2 = new com.tencent.mm.plugin.sns.a.b.c(Co, 22, i6, str4, i7, 31, mVar.byF().rzD, mVar.byG(), i3);
                                    g.Dr();
                                    g.Dp().gRu.a(cVar2, 0);
                                    return;
                                }
                                Co = mVar.bzj();
                                if (b.this.scene != 0) {
                                }
                                str4 = "";
                                if (obj22 == null) {
                                    i7 = 5;
                                } else {
                                    i7 = 6;
                                }
                                if (mVar.bzl() != null) {
                                    mVar.bzl().getSource();
                                }
                                cVar2 = new com.tencent.mm.plugin.sns.a.b.c(Co, 22, i6, str4, i7, 21, mVar.byF().rzD, mVar.byG(), i3);
                                g.Dr();
                                g.Dp().gRu.a(cVar2, 0);
                                intent2 = new Intent();
                                intent2.putExtra("img_gallery_left", iArr[0]);
                                intent2.putExtra("img_gallery_top", iArr[1]);
                                intent2.putExtra("img_gallery_width", i8);
                                intent2.putExtra("img_gallery_height", i2);
                                intent2.putExtra("sns_landing_pages_share_sns_id", mVar.byG());
                                intent2.putExtra("sns_landing_pages_rawSnsId", mVar.byF().nMq);
                                intent2.putExtra("sns_landing_pages_ux_info", mVar.bzk());
                                byF2 = mVar.byF();
                                if (byF2 != null) {
                                    list = byF2.wYj.wfh;
                                    if (list.size() > i4) {
                                        intent2.putExtra("sns_landing_pages_share_thumb_url", ((are) list.get(i4)).wEP);
                                    }
                                }
                                intent2.setClass(b.this.activity, SnsAdNativeLandingPagesUI.class);
                                if (b.this.scene != 0) {
                                }
                                intent2.putExtra("sns_landig_pages_from_source", b.this.scene != 0 ? 1 : 2);
                                if (i4 <= 0) {
                                }
                                intent2.putExtra("sns_landing_pages_xml", i4 <= 0 ? mVar.byB().bxn() : mVar.bzl().field_adxml);
                                intent2.putExtra("sns_landing_pages_rec_src", mVar.bzm());
                                intent2.putExtra("sns_landing_pages_xml_prefix", "adxml");
                                intent2.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                                intent2.putExtra("sns_landing_is_native_sight_ad", true);
                                b.this.activity.startActivity(intent2);
                                b.this.activity.overridePendingTransition(0, 0);
                            }
                        } else if ((byF.wYj.wfg == 1 && byF.wYj.wfh.size() == 1) || byF.wYj.wfg == 7 || (byF.wYj.wfg == 27 && byF.wYj.wfh.size() > i4 && ((are) byF.wYj.wfh.get(i4)).kzz == 2)) {
                            TagImageView tagImageView;
                            if (view.getTag() instanceof c) {
                                cVar = (c) view.getTag();
                                if (byF.wYj.wfg == 27) {
                                    tagImageView = (TagImageView) cVar.rUL.view;
                                } else {
                                    tagImageView = cVar.rUj.xQ(0);
                                }
                            } else if (view.getTag() instanceof MaskImageView) {
                                maskImageView = (MaskImageView) view.getTag();
                            } else {
                                tagImageView = (TagImageView) view;
                            }
                            if (tagImageView.getTag() instanceof ap) {
                                if (mVar.byB().bxd()) {
                                    if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.es(mVar.bzl().field_adxml, i4 > 0 ? "adTurnCanvasInfo" : "adCanvasInfo")) {
                                        Co = mVar.bzj();
                                        i6 = b.this.scene == 0 ? 1 : 2;
                                        str4 = "";
                                        if (obj22 != null) {
                                            i7 = 6;
                                        } else {
                                            i7 = 4;
                                        }
                                        if (mVar.bzl() != null) {
                                            mVar.bzl().getSource();
                                        }
                                        cVar2 = new com.tencent.mm.plugin.sns.a.b.c(Co, 22, i6, str4, i7, 21, mVar.byF().rzD, mVar.byG(), i3);
                                        g.Dr();
                                        g.Dp().gRu.a(cVar2, 0);
                                        int[] iArr2 = new int[2];
                                        if (tagImageView != null) {
                                            tagImageView.getLocationInWindow(iArr2);
                                        }
                                        i5 = tagImageView.getWidth();
                                        i2 = tagImageView.getHeight();
                                        Intent intent3 = new Intent();
                                        intent3.putExtra("img_gallery_left", iArr2[0]);
                                        intent3.putExtra("img_gallery_top", iArr2[1]);
                                        intent3.putExtra("img_gallery_width", i5);
                                        intent3.putExtra("img_gallery_height", i2);
                                        intent3.putExtra("sns_landing_pages_share_sns_id", mVar.byG());
                                        intent3.putExtra("sns_landing_pages_rawSnsId", mVar.byF().nMq);
                                        intent3.putExtra("sns_landing_pages_ux_info", mVar.bzk());
                                        intent3.putExtra("sns_landing_pages_aid", mVar.bzf());
                                        intent3.putExtra("sns_landing_pages_traceid", mVar.bzg());
                                        byF2 = mVar.byF();
                                        if (byF2 != null) {
                                            list = byF2.wYj.wfh;
                                            if (list.size() > i4) {
                                                intent3.putExtra("sns_landing_pages_share_thumb_url", ((are) list.get(i4)).wEP);
                                            } else if (list.size() > 0) {
                                                intent3.putExtra("sns_landing_pages_share_thumb_url", ((are) list.get(0)).wEP);
                                            }
                                        }
                                        intent3.setClass(b.this.activity, SnsAdNativeLandingPagesUI.class);
                                        intent3.putExtra("sns_landig_pages_from_source", b.this.scene == 0 ? 1 : 2);
                                        intent3.putExtra("sns_landing_pages_xml", i4 > 0 ? mVar.byB().bxn() : mVar.bzl().field_adxml);
                                        intent3.putExtra("sns_landing_pages_rec_src", mVar.bzm());
                                        intent3.putExtra("sns_landing_pages_xml_prefix", "adxml");
                                        intent3.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                                        b.this.activity.startActivity(intent3);
                                        b.this.activity.overridePendingTransition(0, 0);
                                        if (b.this.rxY != null) {
                                            b.this.rxY.bvK().v(mVar);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                if (b.a(b.this, mVar.byD(), mVar, i4 > 0)) {
                                    Co = mVar.bzj();
                                    i6 = b.this.scene == 0 ? 1 : 2;
                                    str4 = "";
                                    i7 = mVar.bzn();
                                    if (mVar.bzl() != null) {
                                        mVar.bzl().getSource();
                                    }
                                    cVar2 = new com.tencent.mm.plugin.sns.a.b.c(Co, 22, i6, str4, i7, 31, mVar.byF().rzD, mVar.byG(), i3);
                                    g.Dr();
                                    g.Dp().gRu.a(cVar2, 0);
                                    return;
                                }
                                bxg = i4 > 0 ? mVar.byB().rlo.rjU : mVar.bzi();
                                if (bi.oN(bxg)) {
                                    bxg = mVar.bzh();
                                }
                                if (!bi.oN(bxg)) {
                                    Co = mVar.bzj();
                                    i6 = b.this.scene == 0 ? 1 : 2;
                                    str4 = "";
                                    i7 = obj22 != null ? 6 : 4;
                                    if (mVar.bzl() != null) {
                                        mVar.bzl().getSource();
                                    }
                                    cVar2 = new com.tencent.mm.plugin.sns.a.b.c(Co, 22, i6, str4, i7, 0, mVar.byF().rzD, mVar.byG(), i3);
                                    g.Dr();
                                    g.Dp().gRu.a(cVar2, 0);
                                    x.i("MicroMsg.TimelineClickListener", "adlink url " + bxg + " " + mVar.byB().rkz);
                                    intent = new Intent();
                                    z = mVar.byB().rkz == 0;
                                    if (r.ifW) {
                                        z = false;
                                    }
                                    snsAdClick = new SnsAdClick(mVar.bzj(), b.this.scene == 0 ? 1 : 2, mVar.field_snsId, mVar.bzk(), obj22 != null ? 6 : 4, (byte) 0);
                                    snsAdClick.hQk = mVar.byF().nMq;
                                    if (mVar != null && mVar.xD(32)) {
                                        byD2 = mVar.byD();
                                        if (byD2 != null) {
                                            intent.putExtra("KsnsViewId", byD2.iWv);
                                        }
                                    }
                                    intent.putExtra("KRightBtn", z);
                                    bundle = new Bundle();
                                    bundle.putParcelable("KSnsAdTag", snsAdClick);
                                    bundle.putString("key_snsad_statextstr", mVar.byF().rzD);
                                    intent.putExtra("jsapiargs", bundle);
                                    intent.putExtra("rawUrl", bxg);
                                    intent.putExtra("useJs", true);
                                    intent.putExtra("srcUsername", mVar.field_userName);
                                    intent.putExtra("stastic_scene", 15);
                                    intent.putExtra("KPublisherId", "sns_" + i.er(mVar.field_snsId));
                                    intent.putExtra("pre_username", mVar.field_userName);
                                    intent.putExtra("prePublishId", "sns_" + i.er(mVar.field_snsId));
                                    intent.putExtra("preUsername", mVar.field_userName);
                                    com.tencent.mm.plugin.sns.c.a.ihN.j(intent, b.this.activity);
                                }
                            }
                        }
                    }
                }
            }
        };
        this.rVL = new c() {
            public final boolean cL(View view) {
                Object tag = view.getTag();
                if (!(tag instanceof com.tencent.mm.plugin.sns.ui.r)) {
                    return false;
                }
                com.tencent.mm.plugin.sns.ui.r rVar = (com.tencent.mm.plugin.sns.ui.r) tag;
                bpb bpb = rVar.ryt;
                if (bpb.wYj.wfg == 10 || bpb.wYj.wfg == 17 || bpb.wYj.wfg == 22 || bpb.wYj.wfg == 23) {
                    return false;
                }
                b.this.rVs.a(view, rVar.fsC, bpb);
                return true;
            }

            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                Object tag = view.getTag();
                if (tag instanceof com.tencent.mm.plugin.sns.ui.r) {
                    com.tencent.mm.plugin.sns.ui.r rVar = (com.tencent.mm.plugin.sns.ui.r) tag;
                    bpb bpb = rVar.ryt;
                    if (d.Pu("favorite")) {
                        com.tencent.mm.sdk.b.b diVar;
                        switch (bpb.wYj.wfg) {
                            case 3:
                                contextMenu.add(0, 3, 0, view.getContext().getString(com.tencent.mm.plugin.sns.i.j.eAq));
                                diVar = new di();
                                diVar.fsL.fsC = rVar.fsC;
                                com.tencent.mm.sdk.b.a.xmy.m(diVar);
                                if (diVar.fsM.fsk) {
                                    contextMenu.add(0, 18, 0, view.getContext().getString(com.tencent.mm.plugin.sns.i.j.qPx));
                                    break;
                                }
                                break;
                            case 4:
                                contextMenu.add(0, 4, 0, view.getContext().getString(com.tencent.mm.plugin.sns.i.j.eAq));
                                diVar = new di();
                                diVar.fsL.fsC = rVar.fsC;
                                com.tencent.mm.sdk.b.a.xmy.m(diVar);
                                if (diVar.fsM.fsk) {
                                    contextMenu.add(0, 18, 0, view.getContext().getString(com.tencent.mm.plugin.sns.i.j.qPx));
                                    break;
                                }
                                break;
                            case 9:
                                contextMenu.add(0, 5, 0, view.getContext().getString(com.tencent.mm.plugin.sns.i.j.eAq));
                                break;
                            case 14:
                                contextMenu.add(0, 9, 0, view.getContext().getString(com.tencent.mm.plugin.sns.i.j.eAq));
                                break;
                            case 15:
                                contextMenu.add(0, 10, 0, view.getContext().getString(com.tencent.mm.plugin.sns.i.j.eAq));
                                break;
                            case 26:
                                contextMenu.add(0, 22, 0, view.getContext().getString(com.tencent.mm.plugin.sns.i.j.eAq));
                                break;
                            default:
                                contextMenu.add(0, 3, 0, view.getContext().getString(com.tencent.mm.plugin.sns.i.j.eAq));
                                break;
                        }
                    }
                    com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, ae.bwf().LR(rVar.fsC));
                }
            }
        };
        this.rVm = new e() {
            public final void d(com.tencent.mm.plugin.sight.decode.a.b bVar, int i) {
                if (bVar != null && i == 0) {
                    View view = bVar.qzz != null ? (View) bVar.qzz.get() : null;
                    if (view != null && (view instanceof com.tencent.mm.plugin.sight.decode.a.a)) {
                        com.tencent.mm.plugin.sight.decode.a.a aVar = (com.tencent.mm.plugin.sight.decode.a.a) view;
                        aVar.Uy();
                        if (aVar.bto() != null && (aVar.bto() instanceof ak)) {
                            aVar.bto();
                        }
                    }
                }
            }
        };
    }

    public final void aVm() {
        com.tencent.mm.ad.e eVar = this.rVs;
        g.Dr();
        g.Dp().gRu.a(218, eVar);
    }

    public final void aCt() {
        com.tencent.mm.ad.e eVar = this.rVs;
        g.Dr();
        g.Dp().gRu.b(218, eVar);
    }
}
