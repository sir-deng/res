package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.ac.n;
import com.tencent.mm.au.c;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.f.a.gn;
import com.tencent.mm.f.a.js;
import com.tencent.mm.f.a.nj;
import com.tencent.mm.f.a.qr;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.a.b.j.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ad;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.protocal.c.bno;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.protocal.c.cbj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.r;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.List;

public final class bg {
    Context context;
    public OnClickListener rLk = new OnClickListener() {
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - bg.this.rSv >= 500) {
                bg.this.rSv = currentTimeMillis;
                if (view.getTag() instanceof r) {
                    r rVar = (r) view.getTag();
                    bpb bpb = rVar.ryt;
                    m LR = ae.bwf().LR(rVar.fsC);
                    if (bg.this.rxY != null) {
                        bg.this.rxY.bvK().v(LR);
                    }
                    Intent intent;
                    are are;
                    byte[] KH;
                    if (bpb.wYj.wfg == 18) {
                        Context context = bg.this.context;
                        bpb bpb2 = rVar.ryt;
                        j.a(b.AdUrl, com.tencent.mm.plugin.sns.a.b.j.a.EnterCompleteVideo, ae.bwf().LR(rVar.fsC));
                        intent = new Intent();
                        are = null;
                        if (bpb2.wYj.wfh.size() > 0) {
                            are = (are) bpb2.wYj.wfh.get(0);
                        }
                        intent.putExtra("IsAd", false);
                        intent.putExtra("KStremVideoUrl", bpb2.wYj.nlE);
                        intent.putExtra("KSta_SourceType", 2);
                        intent.putExtra("KSta_Scene", b.AdUrl.value);
                        intent.putExtra("KSta_FromUserName", bpb2.kyG);
                        intent.putExtra("KSta_SnSId", bpb2.nMq);
                        if (are == null) {
                            intent.putExtra("KMediaId", "fakeid_" + (are == null ? bpb2.nMq : are.nMq));
                        } else {
                            intent.putExtra("KMediaId", are.nMq);
                        }
                        bno bno = bpb2.wYo;
                        if (bno != null) {
                            intent.putExtra("KMediaVideoTime", bno.hfa);
                            intent.putExtra("StreamWording", bno.hfc);
                            intent.putExtra("StremWebUrl", bno.hfd);
                            intent.putExtra("KMediaTitle", bno.hfb);
                            intent.putExtra("KStremVideoUrl", bno.heZ);
                            intent.putExtra("KThumUrl", bno.hfe);
                            intent.putExtra("KSta_StremVideoAduxInfo", bno.hff);
                            intent.putExtra("KSta_StremVideoPublishId", bno.hfg);
                        }
                        intent.putExtra("KSta_SnsStatExtStr", bpb2.rzD);
                        d.b(context, "sns", ".ui.VideoAdPlayerUI", intent);
                    } else if (bpb.reA == null || bi.oN(bpb.reA.ttO)) {
                        String str = bpb.wYj.nlE;
                        String str2 = bpb.wYi.nMq;
                        x.d("MicroMsg.TimeLineClickEvent", "url:" + str);
                        String A = com.tencent.mm.plugin.sns.c.a.ihO.A(str, "timeline");
                        if (A != null && A.length() != 0) {
                            Intent intent2 = new Intent();
                            Bundle bundle = null;
                            if (bpb != null) {
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("KSnsStrId", bpb.nMq);
                                bundle2.putString("KSnsLocalId", rVar.fsC);
                                bundle2.putBoolean("KFromTimeline", true);
                                if (bpb.wYj != null && bpb.wYj.wfh.size() > 0) {
                                    bundle2.putString("K_sns_thumb_url", ((are) bpb.wYj.wfh.get(0)).wEP);
                                    bundle2.putString("K_sns_raw_url", bpb.wYj.nlE);
                                    x.i("MicroMsg.TimeLineClickEvent", "put the thumb url %s redirectUrl %s", ((are) bpb.wYj.wfh.get(0)).wEP, bpb.wYj.nlE);
                                }
                                bundle = bundle2;
                            }
                            bundle.putString("key_snsad_statextstr", bpb.rzD);
                            intent2.putExtra("rawUrl", A);
                            intent2.putExtra("shortUrl", A);
                            intent2.putExtra("useJs", true);
                            intent2.putExtra(Columns.TYPE, -255);
                            if (bpb.wYk != null) {
                                intent2.putExtra("srcUsername", bpb.wYk);
                                intent2.putExtra("srcDisplayname", bpb.vtB);
                                x.i("MicroMsg.TimeLineClickEvent", "urlRedirectListener tlObj.sourceNickName: " + bpb.vtB + " tlObj.publicUserName: " + bpb.wYk);
                            }
                            intent2.putExtra("sns_local_id", rVar.fsC);
                            if (LR != null) {
                                intent2.putExtra("KPublisherId", "sns_" + i.er(LR.field_snsId));
                                intent2.putExtra("pre_username", LR.field_userName);
                                intent2.putExtra("prePublishId", "sns_" + i.er(LR.field_snsId));
                                intent2.putExtra("preUsername", LR.field_userName);
                                intent2.putExtra("share_report_pre_msg_url", A);
                                intent2.putExtra("share_report_pre_msg_title", bpb.wYj.fpg);
                                intent2.putExtra("share_report_pre_msg_desc", bpb.wYj.nkL);
                                if (bpb.wYj.wfh != null && bpb.wYj.wfh.size() > 0) {
                                    intent2.putExtra("share_report_pre_msg_icon_url", ((are) bpb.wYj.wfh.get(0)).wEP);
                                }
                                intent2.putExtra("share_report_pre_msg_appid", "");
                                intent2.putExtra("share_report_from_scene", 1);
                            }
                            if (!(bpb == null || bpb.wYi == null)) {
                                intent2.putExtra("KAppId", bpb.wYi.nMq);
                            }
                            if (LR != null && LR.xD(32)) {
                                com.tencent.mm.plugin.sns.storage.a byD = LR.byD();
                                if (byD != null) {
                                    intent2.putExtra("KsnsViewId", byD.iWv);
                                }
                            }
                            if (!(LR == null || bpb == null)) {
                                com.tencent.mm.modelsns.b ix;
                                if (bg.this.scene == 0) {
                                    ix = com.tencent.mm.modelsns.b.ix(718);
                                } else {
                                    ix = com.tencent.mm.modelsns.b.iy(718);
                                }
                                ix.mF(i.g(LR)).iA(LR.field_type).bW(LR.xD(32)).mF(LR.bzk()).mF(bpb.wYk).mF(bpb.wYi == null ? "" : bpb.wYi.nMq).mF(bpb.wYj.nlE);
                                ix.SE();
                                if (bg.this.scene == 0) {
                                    ix = com.tencent.mm.modelsns.b.ix(743);
                                } else {
                                    ix = com.tencent.mm.modelsns.b.iy(743);
                                }
                                com.tencent.mm.modelsns.b mF = ix.mF(i.g(LR)).iA(LR.field_type).bW(LR.xD(32)).mF(LR.bzk()).mF(bpb.wYk);
                                if (bpb.wYi == null) {
                                    str2 = "";
                                } else {
                                    str2 = bpb.wYi.nMq;
                                }
                                mF.mF(str2).mF(bpb.wYj.nlE);
                                if (bundle != null) {
                                    str2 = "intent_key_StatisticsOplog";
                                    KH = ix.KH();
                                    if (KH != null) {
                                        bundle.putByteArray(str2, KH);
                                    }
                                }
                            }
                            if (bundle != null) {
                                intent2.putExtra("jsapiargs", bundle);
                            }
                            intent2.putExtra("geta8key_scene", 2);
                            intent2.putExtra("from_scence", 3);
                            if (bi.oN(bpb.rRR) || !e.LL(bpb.rRR)) {
                                com.tencent.mm.plugin.sns.c.a.ihN.j(intent2, bg.this.context);
                                str2 = null;
                                int i = 0;
                                if (!(bpb == null || bpb.wYi == null)) {
                                    str2 = bpb.wYi.nMq;
                                    i = bi.getInt(bpb.wYi.kzm, 0);
                                }
                                A = com.tencent.mm.plugin.sns.c.a.ihO.s(str2, i);
                                if (!bi.oN(A) && com.tencent.mm.plugin.sns.c.a.ihO.cA(str2)) {
                                    String str3 = null;
                                    if (!(bpb == null || bpb.rey == null || bpb.rey.vMx == null)) {
                                        str3 = bpb.rey.vMx.vMr;
                                    }
                                    com.tencent.mm.plugin.sns.c.a.ihO.a(bg.this.context, str2, A, bpb == null ? null : bpb.kyG, 5, 4, 1, str3, bpb.nMq);
                                }
                                g.pWK.h(11105, bpb.kyG, bpb.wYj.nlE);
                                if (LR != null && LR.field_type == 4) {
                                    are = (are) bpb.wYj.wfh.get(0);
                                    g gVar = g.pWK;
                                    Object[] objArr = new Object[3];
                                    objArr[0] = Integer.valueOf(1);
                                    objArr[1] = are == null ? "" : are.nkL;
                                    objArr[2] = bpb.wYi.nMq;
                                    gVar.h(13043, objArr);
                                    return;
                                }
                                return;
                            }
                            int[] iArr = new int[2];
                            if (view != null) {
                                view.getLocationInWindow(iArr);
                            }
                            int width = view.getWidth();
                            int height = view.getHeight();
                            intent = new Intent();
                            intent.putExtra("img_gallery_left", iArr[0]);
                            intent.putExtra("img_gallery_top", iArr[1]);
                            intent.putExtra("img_gallery_width", width);
                            intent.putExtra("img_gallery_height", height);
                            if (bpb != null) {
                                List list = bpb.wYj.wfh;
                                if (list.size() > 0) {
                                    intent.putExtra("sns_landing_pages_share_thumb_url", ((are) list.get(0)).wEP);
                                }
                            }
                            intent.putExtra("sns_landing_pages_share_sns_id", LR.byG());
                            intent.putExtra("sns_landing_pages_rawSnsId", LR.byF().nMq);
                            intent.putExtra("sns_landing_pages_aid", LR.bzf());
                            intent.putExtra("sns_landing_pages_traceid", LR.bzg());
                            intent.putExtra("sns_landing_pages_ux_info", LR.bzk());
                            intent.putExtra("sns_landig_pages_from_source", bg.this.scene == 0 ? 3 : 4);
                            intent.setClass(bg.this.context, SnsAdNativeLandingPagesUI.class);
                            intent.putExtra("sns_landing_pages_xml", bpb.rRR);
                            intent.putExtra("sns_landing_pages_rec_src", LR.bzm());
                            intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                            e.z(intent, bg.this.context);
                        }
                    } else {
                        bg bgVar = bg.this;
                        cbj cbj = bpb.reA;
                        if (cbj != null && !bi.oN(cbj.ttO)) {
                            intent = new Intent();
                            intent.putExtra("key_proxy_fts_rec_ui", true);
                            intent.putExtra("key_scene", 3);
                            KH = null;
                            try {
                                KH = cbj.toByteArray();
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.TimeLineClickEvent", e, "", new Object[0]);
                            }
                            if (KH != null) {
                                com.tencent.mm.ui.e.i.xMT = true;
                                intent.putExtra("key_search_web_data", KH);
                                d.b(bgVar.context, "webview", ".fts.topstory.ui.TopStoryVideoListUI", intent);
                            }
                        }
                    }
                }
            }
        }
    };
    public OnClickListener rSA = new OnClickListener() {
        public final void onClick(View view) {
            if (view.getTag() instanceof r) {
                r rVar = (r) view.getTag();
                bpb bpb = rVar.ryt;
                if (bpb.wYj.wfh.size() > 0) {
                    m LR = ae.bwf().LR(rVar.fsC);
                    if (bg.this.rxY != null) {
                        bg.this.rxY.bvK().v(LR);
                    }
                    String str = ((are) bpb.wYj.wfh.get(0)).ryq;
                    Intent intent = new Intent();
                    intent.putExtra("sns_object_data", str);
                    intent.putExtra("preceding_scence", 10);
                    intent.putExtra("download_entrance_scene", 13);
                    d.b(view.getContext(), "emoji", ".ui.EmojiStoreDetailUI", intent);
                }
            }
        }
    };
    public OnClickListener rSB = new OnClickListener() {
        public final void onClick(View view) {
            if (view.getTag() instanceof r) {
                r rVar = (r) view.getTag();
                bpb bpb = rVar.ryt;
                if (bpb.wYj.wfh.size() > 0) {
                    m LR = ae.bwf().LR(rVar.fsC);
                    if (bg.this.rxY != null) {
                        bg.this.rxY.bvK().v(LR);
                    }
                    String str = ((are) bpb.wYj.wfh.get(0)).ryq;
                    Intent intent = new Intent();
                    intent.putExtra("sns_object_data", str);
                    intent.putExtra("extra_scence", 13);
                    d.b(view.getContext(), "emoji", ".ui.v2.EmojiStoreV2DesignerUI", intent);
                }
            }
        }
    };
    public OnClickListener rSC = new OnClickListener() {
        public final void onClick(View view) {
            if (view.getTag() instanceof r) {
                r rVar = (r) view.getTag();
                bpb bpb = rVar.ryt;
                if (bpb.wYj.wfh.size() > 0) {
                    m LR = ae.bwf().LR(rVar.fsC);
                    if (bg.this.rxY != null) {
                        bg.this.rxY.bvK().v(LR);
                    }
                    String str = ((are) bpb.wYj.wfh.get(0)).ryq;
                    Intent intent = new Intent();
                    intent.putExtra("sns_object_data", str);
                    intent.putExtra("extra_scence", 13);
                    d.b(view.getContext(), "emoji", ".ui.EmojiStoreTopicUI", intent);
                }
            }
        }
    };
    public OnClickListener rSD = new OnClickListener() {
        public final void onClick(View view) {
            if (view.getTag() instanceof r) {
                r rVar = (r) view.getTag();
                bpb bpb = rVar.ryt;
                if (bpb.wYj.wfh.size() > 0) {
                    m LR = ae.bwf().LR(rVar.fsC);
                    if (bg.this.rxY != null) {
                        bg.this.rxY.bvK().v(LR);
                    }
                    String str = ((are) bpb.wYj.wfh.get(0)).ryq;
                    Intent intent = new Intent();
                    intent.putExtra("sns_object_data", str);
                    d.b(view.getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
                }
            }
        }
    };
    public OnClickListener rSE = new OnClickListener() {
        public final void onClick(View view) {
            boolean z = view.getTag() instanceof r;
            x.d("MicroMsg.TimeLineClickEvent", "musicRedirectListener click " + z);
            if (z) {
                r rVar = (r) view.getTag();
                bpb bpb = rVar.ryt;
                if (bg.Jk(bpb.nMq)) {
                    g.pWK.k(10231, "1");
                    com.tencent.mm.au.b.Qv();
                } else if (!(com.tencent.mm.o.a.aW(bg.this.context) || com.tencent.mm.o.a.aU(bg.this.context))) {
                    g.pWK.k(10090, "1,0");
                    if (bpb.wYj.wfh.size() > 0) {
                        com.tencent.mm.modelsns.b ix;
                        String str;
                        are are = (are) bpb.wYj.wfh.get(0);
                        if (bg.this.scene == 0) {
                            ix = com.tencent.mm.modelsns.b.ix(738);
                        } else {
                            ix = com.tencent.mm.modelsns.b.iy(738);
                        }
                        com.tencent.mm.modelsns.b mF = ix.mF(bpb.nMq).mF(bpb.kyG);
                        if (bpb.wYi == null) {
                            str = "";
                        } else {
                            str = bpb.wYi.nMq;
                        }
                        mF.mF(str).mF(are.fpg).mF(are.nkL).mF("");
                        ix.SE();
                    }
                    if (rVar.ryu) {
                        com.tencent.mm.au.b.a(((com.tencent.mm.au.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.au.a.a.class)).a(ae.FJ(), bpb, 9));
                    } else {
                        com.tencent.mm.au.b.b(((com.tencent.mm.au.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.au.a.a.class)).a(ae.FJ(), bpb, 1));
                    }
                }
                if (bg.this.rSu != null) {
                    bg.this.rSu.bBq();
                }
            }
        }
    };
    public OnClickListener rSF = new OnClickListener() {
        public final void onClick(View view) {
            x.i("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener");
            if (view.getTag() instanceof r) {
                r rVar = (r) view.getTag();
                bpb bpb = rVar.ryt;
                m LR = ae.bwf().LR(rVar.fsC);
                if (bg.this.rxY != null) {
                    bg.this.rxY.bvK().v(LR);
                }
                if (bpb.wYp == null) {
                    x.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener weappInfo is null");
                    return;
                }
                String str = bpb.wYp.username;
                String str2 = bpb.wYp.path;
                x.i("MicroMsg.TimeLineClickEvent", "username: " + str + "pagepath: " + str2);
                com.tencent.mm.sdk.b.b qrVar = new qr();
                qrVar.fJd.userName = str;
                qrVar.fJd.fJf = str2;
                qrVar.fJd.scene = HardCoderJNI.FUNC_RESET_SCREEN_RESOLUTION;
                qrVar.fJd.foi = bpb.nMq + ":" + bpb.kyG;
                Bundle bundle = new Bundle();
                bundle.putString("stat_send_msg_user", LR.field_userName);
                bundle.putString("stat_msg_id", "sns_" + i.er(LR.field_snsId));
                com.tencent.mm.sdk.b.a.xmy.m(qrVar);
            }
        }
    };
    public OnClickListener rSG = new OnClickListener() {
        public final void onClick(View view) {
            x.i("MicroMsg.TimeLineClickEvent", "appbrandHomeRedirectListener");
            if (view.getTag() instanceof bpb) {
                bpb bpb = (bpb) view.getTag();
                if (bpb.wYp == null) {
                    x.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener username is null");
                    return;
                }
                String str = bpb.wYp.username;
                com.tencent.mm.sdk.b.b qrVar = new qr();
                x.i("MicroMsg.TimeLineClickEvent", "username: " + str);
                qrVar.fJd.userName = str;
                qrVar.fJd.scene = HardCoderJNI.FUNC_RESET_SCREEN_RESOLUTION;
                qrVar.fJd.foi = bpb.nMq + ":" + bpb.kyG;
                com.tencent.mm.sdk.b.a.xmy.m(qrVar);
            }
        }
    };
    public OnClickListener rSH = new OnClickListener() {
        public final void onClick(View view) {
            x.i("MicroMsg.TimeLineClickEvent", "hardMallProductRedirectListener");
            if (view.getTag() instanceof r) {
                r rVar = (r) view.getTag();
                bpb bpb = rVar.ryt;
                if (bpb.wYj.wfh.size() > 0) {
                    m LR = ae.bwf().LR(rVar.fsC);
                    if (bg.this.rxY != null) {
                        bg.this.rxY.bvK().v(LR);
                    }
                    String str = ((are) bpb.wYj.wfh.get(0)).ryq;
                    Intent intent = new Intent();
                    intent.putExtra("key_product_scene", 2);
                    intent.putExtra("key_product_info", str);
                    d.b(bg.this.context, "product", ".ui.MallProductUI", intent);
                }
            }
        }
    };
    public OnClickListener rSI = new OnClickListener() {
        public final void onClick(View view) {
            x.i("MicroMsg.TimeLineClickEvent", "cardRediretListener");
            if (view.getTag() instanceof r) {
                r rVar = (r) view.getTag();
                bpb bpb = rVar.ryt;
                if (bpb.wYj.wfh.size() > 0) {
                    m LR = ae.bwf().LR(rVar.fsC);
                    if (bg.this.rxY != null) {
                        bg.this.rxY.bvK().v(LR);
                    }
                    String str = ((are) bpb.wYj.wfh.get(0)).ryq;
                    Intent intent = new Intent();
                    intent.putExtra("key_from_scene", 12);
                    if (TextUtils.isEmpty(str)) {
                        x.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData is empty");
                        return;
                    }
                    String[] split = str.split("#");
                    if (split.length >= 2) {
                        x.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData[0]:" + split[0]);
                        intent.putExtra("key_card_id", split[0]);
                        intent.putExtra("key_card_ext", split[1]);
                        d.b(bg.this.context, "card", ".ui.CardDetailUI", intent);
                    } else if (split.length == 1) {
                        x.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include cardExt");
                        x.i("MicroMsg.TimeLineClickEvent", "cardRediretListener card_id :" + str);
                        intent.putExtra("key_card_id", split[0]);
                        intent.putExtra("key_card_ext", "");
                        d.b(bg.this.context, "card", ".ui.CardDetailUI", intent);
                    } else {
                        x.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include card_id and cardExt");
                        x.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData :" + str);
                    }
                }
            }
        }
    };
    public OnClickListener rSJ = new OnClickListener() {
        public final void onClick(View view) {
            x.i("MicroMsg.TimeLineClickEvent", "noteLinkRedirectListener");
            if (view.getTag() instanceof r) {
                r rVar = (r) view.getTag();
                if (rVar.ryt.wYj.wfg == 26 && !bi.oN(rVar.ryt.wYj.wfj)) {
                    com.tencent.mm.sdk.b.b fwVar = new fw();
                    fwVar.fwl.type = 37;
                    fwVar.fwl.desc = rVar.ryt.wYj.wfj;
                    String str = "";
                    if (rVar.ryt.wYj.wfh != null && rVar.ryt.wYj.wfh.size() > 0) {
                        String r = am.r(ae.getAccSnsPath(), ((are) rVar.ryt.wYj.wfh.get(0)).nMq);
                        str = i.e((are) rVar.ryt.wYj.wfh.get(0));
                        str = FileOp.bO(new StringBuilder().append(r).append(str).toString()) ? r + str : "";
                    }
                    fwVar.fwl.path = str;
                    fwVar.fwl.title = rVar.fsC;
                    fwVar.fwl.context = bg.this.context;
                    com.tencent.mm.sdk.b.a.xmy.m(fwVar);
                }
            }
        }
    };
    a rSu;
    long rSv = 0;
    public OnClickListener rSw = new OnClickListener() {
        public final void onClick(View view) {
            boolean z;
            String str;
            String str2 = null;
            bg bgVar = bg.this;
            if (view == null || !(view.getTag() instanceof bpb)) {
                z = true;
            } else {
                str = ((bpb) view.getTag()).wYi.nMq;
                Intent intent;
                if ("wx485a97c844086dc9".equals(str)) {
                    d.b(view.getContext(), "shake", ".ui.ShakeReportUI", new Intent().putExtra("shake_music", true));
                    z = true;
                } else if ("wx7fa037cc7dfabad5".equals(str)) {
                    com.tencent.mm.plugin.sport.b.d.qq(34);
                    com.tencent.mm.kernel.g.Dr();
                    if (com.tencent.mm.k.a.ga(((h) com.tencent.mm.kernel.g.h(h.class)).Ff().Xv("gh_43f2581f6fd6").field_type)) {
                        intent = new Intent();
                        intent.putExtra("Chat_User", "gh_43f2581f6fd6");
                        intent.putExtra("finish_direct", true);
                        d.a(bgVar.context, ".ui.chatting.ChattingUI", intent);
                    } else {
                        intent = new Intent();
                        intent.putExtra("Contact_User", "gh_43f2581f6fd6");
                        d.b(bgVar.context, "profile", ".ui.ContactInfoUI", intent);
                    }
                    z = true;
                } else if ("wx9181ed3f223e6d76".equals(str) || "wx2fe12a395c426fcf".equals(str)) {
                    x.i("MicroMsg.TimeLineClickEvent", "hy: shake new year closed. try to go to shake TV");
                    intent = new Intent();
                    intent.putExtra("shake_tv", true);
                    d.b(view.getContext(), "shake", ".ui.ShakeReportUI", intent);
                    z = true;
                } else if ("wx751a1acca5688ba3".equals(str)) {
                    intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", 5);
                    if (!(com.tencent.mm.o.a.aV(bgVar.context) || com.tencent.mm.o.a.aU(bgVar.context))) {
                        d.b(bgVar.context, "scanner", ".ui.BaseScanUI", intent);
                    }
                    z = true;
                } else if ("wxfbc915ff7c30e335".equals(str)) {
                    intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", 1);
                    if (!(com.tencent.mm.o.a.aV(bgVar.context) || com.tencent.mm.o.a.aU(bgVar.context))) {
                        d.b(bgVar.context, "scanner", ".ui.BaseScanUI", intent);
                    }
                    z = true;
                } else if ("wx482a4001c37e2b74".equals(str)) {
                    intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", 2);
                    if (!(com.tencent.mm.o.a.aV(bgVar.context) || com.tencent.mm.o.a.aU(bgVar.context))) {
                        d.b(bgVar.context, "scanner", ".ui.BaseScanUI", intent);
                    }
                    z = true;
                } else if (!"wxaf060266bfa9a35c".equals(str)) {
                    z = false;
                } else if (c.QE()) {
                    intent = new Intent();
                    intent.putExtra("shake_tv", true);
                    d.b(bgVar.context, "shake", ".ui.ShakeReportUI", intent);
                    z = true;
                } else {
                    z = true;
                }
            }
            if (!z && view != null && (view.getTag() instanceof bpb)) {
                bpb bpb = (bpb) view.getTag();
                if (bpb == null || bpb.wYi == null) {
                    x.e("MicroMsg.TimeLineClickEvent", "appInfo is null");
                    return;
                }
                String str3 = bpb.wYi.nMq;
                String cy = com.tencent.mm.plugin.sns.c.a.ihO.cy(str3);
                if (bi.oN(cy) || !com.tencent.mm.plugin.sns.c.a.ihO.cA(str3)) {
                    str = com.tencent.mm.plugin.sns.c.a.ihO.f(bg.this.context, str3, "timeline");
                    if (str != null && str.length() != 0) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("rawUrl", str);
                        intent2.putExtra("shortUrl", str);
                        intent2.putExtra("useJs", true);
                        intent2.putExtra(Columns.TYPE, -255);
                        intent2.putExtra("geta8key_scene", 2);
                        com.tencent.mm.plugin.sns.c.a.ihN.j(intent2, bg.this.context);
                        return;
                    }
                    return;
                }
                int i;
                String str4 = bpb == null ? null : bpb.kyG;
                if (bpb.wYj.wfg == 1) {
                    i = 2;
                } else if (bpb.wYj.wfg == 3) {
                    i = 5;
                } else {
                    i = 2;
                }
                if (!(bpb.rey == null || bpb.rey.vMx == null)) {
                    str2 = bpb.rey.vMx.vMr;
                }
                com.tencent.mm.sdk.b.b njVar = new nj();
                njVar.fGg.context = bg.this.context;
                njVar.fGg.scene = 4;
                njVar.fGg.fGh = str3;
                njVar.fGg.packageName = cy;
                njVar.fGg.msgType = i;
                njVar.fGg.fAJ = str4;
                njVar.fGg.mediaTagName = str2;
                njVar.fGg.fGi = 5;
                njVar.fGg.fGj = 0;
                njVar.fGg.fGk = bpb.nMq;
                com.tencent.mm.sdk.b.a.xmy.m(njVar);
                com.tencent.mm.sdk.b.b gnVar = new gn();
                gnVar.fxx.actionCode = 2;
                gnVar.fxx.scene = 3;
                gnVar.fxx.extMsg = "timeline_src=3";
                gnVar.fxx.appId = str3;
                gnVar.fxx.context = bg.this.context;
                com.tencent.mm.sdk.b.a.xmy.m(gnVar);
            }
        }
    };
    public OnClickListener rSx = new OnClickListener() {
        public final void onClick(View view) {
            if (view.getTag() instanceof bd) {
                final bd bdVar = (bd) view.getTag();
                if (bi.oN(bdVar.rSg)) {
                    x.e("MicroMsg.TimeLineClickEvent", "show source profile fail, username is null");
                    Toast.makeText(bg.this.context, bg.this.context.getString(com.tencent.mm.plugin.sns.i.j.ejt, new Object[]{Integer.valueOf(3), Integer.valueOf(-1)}), 0).show();
                    return;
                }
                com.tencent.mm.kernel.g.Dr();
                ag Xv = ((h) com.tencent.mm.kernel.g.h(h.class)).Ff().Xv(bdVar.rSg);
                if (Xv == null || !Xv.field_username.equals(bdVar.rSg)) {
                    com.tencent.mm.y.ak.a.hhv.a(bdVar.rSg, "", new com.tencent.mm.y.ak.b.a() {
                        public final void v(String str, boolean z) {
                            if (bg.this.tipDialog != null) {
                                bg.this.tipDialog.dismiss();
                            }
                            if (z) {
                                com.tencent.mm.ac.b.I(str, 3);
                                n.JY().jb(str);
                                Intent intent = new Intent();
                                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                intent.putExtra("Contact_User", str);
                                intent.putExtra("Contact_Scene", 37);
                                com.tencent.mm.kernel.g.Dr();
                                com.tencent.mm.storage.x Xv = ((h) com.tencent.mm.kernel.g.h(h.class)).Ff().Xv(str);
                                if (Xv != null && Xv.ciN()) {
                                    g.pWK.k(10298, str + ",37");
                                    intent.putExtra("Contact_Scene", 37);
                                }
                                com.tencent.mm.plugin.sns.c.a.ihN.d(intent, bg.this.context);
                                return;
                            }
                            Toast.makeText(bg.this.context, bg.this.context.getString(com.tencent.mm.plugin.sns.i.j.ejt, new Object[]{Integer.valueOf(3), Integer.valueOf(-1)}), 0).show();
                        }
                    });
                    bg bgVar = bg.this;
                    Context context = bg.this.context;
                    bg.this.context.getString(com.tencent.mm.plugin.sns.i.j.dGZ);
                    bgVar.tipDialog = com.tencent.mm.ui.base.h.a(context, bg.this.context.getString(com.tencent.mm.plugin.sns.i.j.dHn), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            com.tencent.mm.y.ak.a.hhv.hN(bdVar.rSg);
                        }
                    });
                    return;
                }
                Intent intent = new Intent();
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                intent.putExtra("Contact_User", bdVar.rSg);
                g.pWK.k(10298, bdVar.rSg + ",37");
                intent.putExtra("Contact_Scene", 37);
                com.tencent.mm.plugin.sns.c.a.ihN.d(intent, bg.this.context);
            }
        }
    };
    public OnClickListener rSy = new OnClickListener() {
        public final void onClick(View view) {
            if (view.getTag() instanceof r) {
                r rVar = (r) view.getTag();
                bpb bpb = rVar.ryt;
                if (bpb.wYj.wfh.size() > 0) {
                    m LR = ae.bwf().LR(rVar.fsC);
                    if (bg.this.rxY != null) {
                        bg.this.rxY.bvK().v(LR);
                    }
                    String str = ((are) bpb.wYj.wfh.get(0)).ryq;
                    Intent intent = new Intent();
                    intent.putExtra("key_Product_xml", str);
                    intent.putExtra("key_ProductUI_getProductInfoScene", 2);
                    d.b(view.getContext(), "scanner", ".ui.ProductUI", intent);
                }
            }
        }
    };
    public OnClickListener rSz = new OnClickListener() {
        public final void onClick(View view) {
            x.d("MicroMsg.TimeLineClickEvent", "hardTVRedirectListener");
            if (view.getTag() instanceof r) {
                r rVar = (r) view.getTag();
                bpb bpb = rVar.ryt;
                if (bpb.wYj.wfh.size() > 0) {
                    m LR = ae.bwf().LR(rVar.fsC);
                    if (bg.this.rxY != null) {
                        bg.this.rxY.bvK().v(LR);
                    }
                    String str = ((are) bpb.wYj.wfh.get(0)).ryq;
                    Intent intent = new Intent();
                    intent.putExtra("key_TV_xml", str);
                    intent.putExtra("key_TV_getProductInfoScene", 2);
                    d.b(view.getContext(), "shake", ".ui.TVInfoUI", intent);
                }
            }
        }
    };
    ad rxY;
    int scene = 0;
    r tipDialog;

    public interface a {
        void bBq();
    }

    public bg(Context context, a aVar, int i, ad adVar) {
        this.context = context;
        this.rSu = aVar;
        this.scene = i;
        this.rxY = adVar;
    }

    protected static boolean Jk(String str) {
        com.tencent.mm.sdk.b.b jsVar = new js();
        jsVar.fBo.action = -2;
        com.tencent.mm.sdk.b.a.xmy.m(jsVar);
        ati ati = jsVar.fBp.fBq;
        if (ati != null && com.tencent.mm.au.b.d(ati) && str.equals(ati.wdd) && com.tencent.mm.au.b.Qx()) {
            return true;
        }
        return false;
    }
}
