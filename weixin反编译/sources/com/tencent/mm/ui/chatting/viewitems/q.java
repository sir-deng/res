package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.LongSparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.af.f;
import com.tencent.mm.af.m;
import com.tencent.mm.ap.a.a.c;
import com.tencent.mm.f.a.kz;
import com.tencent.mm.f.a.qr;
import com.tencent.mm.f.a.si;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.modelappbrand.o;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.boh;
import com.tencent.mm.protocal.c.cdr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.y.as;
import com.tencent.mm.y.s;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class q extends b {
    private static LongSparseArray<Boolean> yUv = new LongSparseArray(5);
    static int yUx = Color.parseColor("#888888");
    static int yUy = Color.parseColor("#888888");
    private String mAppId;
    private OnClickListener maE;
    private r xUU;
    private c xVd;
    private OnClickListener yUm;
    private OnClickListener yUn;
    private OnClickListener yUo;
    private OnClickListener yUp;
    private com.tencent.mm.ui.chatting.ChattingUI.b yUq;
    private OnClickListener yUr;
    private String yUs;
    private int yUt;
    private boolean yUu = false;
    private long yUw = -1;
    private com.tencent.mm.ui.chatting.ChattingUI.a yyH;
    private com.tencent.mm.sdk.b.c<kz> yyz;

    public static class b {
        public String fMx;
        public String hdN;
        public String hfM;
        public String hfN;
        public String hfO;
        public String hfP;
        public String hfQ;
        public long time;
        public String title;
        public int type;
        public String url;

        public static b ay(Map<String, String> map) {
            b bVar = new b();
            bVar.title = (String) map.get(".msg.appmsg.mmreader.category.item.title");
            bVar.url = (String) map.get(".msg.appmsg.mmreader.category.item.url");
            bVar.fMx = (String) map.get(".msg.appmsg.mmreader.category.item.native_url");
            bVar.hfM = (String) map.get(".msg.appmsg.mmreader.category.item.shorturl");
            bVar.hfN = (String) map.get(".msg.appmsg.mmreader.category.item.longurl");
            bVar.time = bi.getLong((String) map.get(".msg.appmsg.mmreader.category.item.pub_time"), 0);
            bVar.hfO = (String) map.get(".msg.appmsg.mmreader.category.item.cover");
            bVar.hfP = (String) map.get(".msg.appmsg.mmreader.category.item.tweetid");
            bVar.hfQ = (String) map.get(".msg.appmsg.mmreader.category.item.digest");
            bVar.type = bi.getInt((String) map.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
            bVar.hdN = (String) map.get(".msg.appmsg.template_id");
            return bVar;
        }
    }

    private final class a implements OnClickListener {
        private a() {
        }

        /* synthetic */ a(q qVar, byte b) {
            this();
        }

        public final void onClick(final View view) {
            if (view.getTag() instanceof au) {
                final au auVar = (au) view.getTag();
                if (auVar == null) {
                    x.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, msg null.");
                    return;
                }
                Map y = bj.y(auVar.field_content, "msg");
                if (y == null || y.size() == 0) {
                    x.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, values null.");
                    return;
                }
                final String oM = bi.oM((String) y.get(".msg.fromusername"));
                g gVar = new g(view.getContext(), g.zCt, false);
                gVar.rQF = new p.c() {
                    public final void a(n nVar) {
                        nVar.add(0, 1, 0, view.getResources().getString(R.l.ezG));
                    }
                };
                gVar.rQG = new d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        x.d("MicroMsg.ChattingItemDyeingTemplate", "on menu(id : %d, index : %d) item selected.", Integer.valueOf(menuItem.getItemId()), Integer.valueOf(i));
                        switch (menuItem.getItemId()) {
                            case 1:
                                as.CN().a(1198, new e() {
                                    public final void a(int i, int i2, String str, k kVar) {
                                        as.CN().b(1198, (e) this);
                                        x.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(false));
                                        if (q.this.xUU != null) {
                                            q.this.xUU.dismiss();
                                            q.this.xUU = null;
                                        }
                                        if (i != 0 || i2 != 0) {
                                            u.makeText(view.getContext(), R.l.ezH, 0).show();
                                        } else if (auVar != view.getTag()) {
                                            x.w("MicroMsg.ChattingItemDyeingTemplate", "item msg(%s) has changed.", Long.valueOf(auVar.field_msgId));
                                        } else {
                                            cdr Jl = ((o) kVar).Jl();
                                            if (Jl == null) {
                                                u.makeText(view.getContext(), R.l.ezH, 0).show();
                                                return;
                                            }
                                            String str2 = Jl.xje;
                                            x.d("MicroMsg.ChattingItemDyeingTemplate", "more view clicked, menu item COMPLAIN_APP_BRAND selected, sync attr username %s", oM);
                                            try {
                                                x.i("MicroMsg.ChattingItemDyeingTemplate", "go to complain page(%s, %s), url:%s", str2, q.this.yUs, String.format("https://mp.weixin.qq.com/mp/infringement?from=8&username=%s&template_id=%s&template_msg_id=%s1#wechat_redirect", new Object[]{oM, URLEncoder.encode(q.this.yUs, ProtocolPackage.ServerEncoding), URLEncoder.encode(str2, ProtocolPackage.ServerEncoding)}));
                                                Intent intent = new Intent();
                                                intent.putExtra("rawUrl", r1);
                                                com.tencent.mm.bl.d.b(q.this.yyH.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                            } catch (UnsupportedEncodingException e) {
                                                x.e("MicroMsg.ChattingItemDyeingTemplate", "Error occurred when encode url.");
                                                u.makeText(view.getContext(), R.l.ezL, 0).show();
                                            }
                                        }
                                    }
                                });
                                final k oVar = new o(auVar.field_content);
                                q qVar = q.this;
                                Context context = view.getContext();
                                view.getResources().getString(R.l.dGZ);
                                qVar.xUU = h.a(context, view.getResources().getString(R.l.dHn), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        as.CN().c(oVar);
                                    }
                                });
                                as.CN().a(oVar, 0);
                                return;
                            default:
                                return;
                        }
                    }
                };
                gVar.bUX();
                return;
            }
            x.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, tag not msg.");
        }
    }

    static /* synthetic */ void a(q qVar, String str) {
        WxaAttributes rf = ((com.tencent.mm.plugin.appbrand.n.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.c.class)).rf(str);
        if (rf != null) {
            A(1, rf.field_appId, qVar.yUs);
        }
        Intent intent = new Intent();
        intent.putExtra("key_username", str);
        intent.putExtra("key_from_scene", 5);
        if (rf != null) {
            com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a aVar = new com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a();
            aVar.appId = rf.field_appId;
            aVar.fqZ = 6;
            intent.putExtra("key_scene_exposed_params", aVar.acv());
        }
        com.tencent.mm.bl.d.b(qVar.yyH.getContext(), "appbrand", ".ui.AppBrandProfileUI", intent);
    }

    static /* synthetic */ void b(Context context, String str, long j) {
        if (str == null) {
            x.e("MicroMsg.ChattingItemDyeingTemplate", "[gotoChattingUIWithPosition] username is null");
            return;
        }
        as.Hm();
        x.i("MicroMsg.ChattingItemDyeingTemplate", "[gotoChattingUIWithPosition] msgLocalId:%s", Long.valueOf(com.tencent.mm.y.c.Fh().G(str, j).field_msgId));
        if (str.contains("@")) {
            as.Hm();
            if (com.tencent.mm.y.c.Fo().hG(str) == null) {
                x.w("MicroMsg.ChattingItemDyeingTemplate", "[gotoChattingUIWithPosition] member is null! username:%s", str);
                h.a(context, context.getString(R.l.eEI), context.getString(R.l.cSb), null);
                return;
            }
        }
        as.Hm();
        ag Xv = com.tencent.mm.y.c.Ff().Xv(str);
        if (Xv == null || !com.tencent.mm.k.a.ga(Xv.field_type)) {
            if (Xv == null) {
                x.w("MicroMsg.ChattingItemDyeingTemplate", "[gotoChattingUIWithPosition] contact is null! username:%s", str);
            } else {
                x.w("MicroMsg.ChattingItemDyeingTemplate", "[gotoChattingUIWithPosition] isContact not ! username:%s", str);
            }
            h.a(context, context.getString(R.l.eEI), context.getString(R.l.cSb), null);
            return;
        }
        com.tencent.mm.plugin.chatroom.a.ihN.e(new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", r0), context);
    }

    public final boolean aXP() {
        return false;
    }

    public q() {
        com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
        aVar.hFJ = true;
        aVar.hFA = R.g.bAa;
        this.xVd = aVar.PQ();
        this.yUn = new a();
        this.yUm = new OnClickListener() {
            public final void onClick(final View view) {
                final au auVar = (au) view.getTag(R.h.czN);
                if (auVar == null) {
                    x.w("MicroMsg.ChattingItemDyeingTemplate", "on more view click, but msg is null.");
                    return;
                }
                Map y = bj.y(auVar.field_content, "msg");
                if (y != null && y.size() != 0) {
                    final String oM = bi.oM((String) y.get(".msg.fromusername"));
                    WxaAttributes rf = ((com.tencent.mm.plugin.appbrand.n.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.c.class)).rf(oM);
                    final int p = bi.p(y.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), -1);
                    final int p2 = bi.p(y.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_version"), -1);
                    g gVar = new g(view.getContext(), g.zCt, false);
                    final boolean z = rf != null && (rf.field_appOpt & 1) > 0;
                    if (z) {
                        gVar.e(view.getResources().getString(R.l.ezP), 3);
                    } else {
                        gVar.e(view.getResources().getString(R.l.ezC), 3);
                    }
                    gVar.rQF = new p.c() {
                        public final void a(n nVar) {
                            if (z) {
                                nVar.a(1, view.getResources().getColor(R.e.bsE), view.getResources().getString(R.l.ezO));
                            } else {
                                nVar.a(0, view.getResources().getColor(R.e.btD), view.getResources().getString(R.l.ezB));
                            }
                            nVar.add(0, 2, 0, view.getResources().getString(R.l.ezG));
                        }
                    };
                    final View view2 = view;
                    gVar.rQG = new d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            x.d("MicroMsg.ChattingItemDyeingTemplate", "on menu(id : %d, index : %d) item selected.", Integer.valueOf(menuItem.getItemId()), Integer.valueOf(i));
                            com.tencent.mm.sdk.b.b siVar;
                            LinkedList linkedList;
                            boh boh;
                            switch (menuItem.getItemId()) {
                                case 0:
                                    ((aw) view2.getTag(R.h.czu)).yXR.setVisibility(0);
                                    siVar = new si();
                                    siVar.fKS.foe = oM;
                                    siVar.fKS.action = 1;
                                    siVar.fKS.fKU = 1;
                                    com.tencent.mm.sdk.b.a.xmy.m(siVar);
                                    linkedList = new LinkedList();
                                    boh = new boh();
                                    boh.wXP = oM;
                                    boh.wXO = 0;
                                    boh.kzz = 1;
                                    linkedList.add(boh);
                                    q.A(2, q.this.mAppId, q.this.yUs);
                                    as.CN().a(1176, new e() {
                                        public final void a(int i, int i2, String str, k kVar) {
                                            as.CN().b(1176, (e) this);
                                            x.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(true));
                                            if (auVar != view2.getTag(R.h.czN)) {
                                                x.w("MicroMsg.ChattingItemDyeingTemplate", "item msg(%s) has changed.", Long.valueOf(auVar.field_msgId));
                                            } else if (i != 0 || i2 != 0) {
                                                ((aw) view2.getTag(R.h.czu)).yXR.setVisibility(8);
                                                u.makeText(view2.getContext(), R.l.ezL, 0).show();
                                                com.tencent.mm.sdk.b.b siVar = new si();
                                                siVar.fKS.foe = oM;
                                                siVar.fKS.action = 2;
                                                siVar.fKS.fKU = 1;
                                                com.tencent.mm.sdk.b.a.xmy.m(siVar);
                                                if (q.this.yyH != null) {
                                                    q.this.yyH.cpZ();
                                                }
                                            }
                                        }
                                    });
                                    as.CN().a(new com.tencent.mm.modelappbrand.k(linkedList), 0);
                                    if (q.this.yyH != null) {
                                        q.this.yyH.cpZ();
                                        return;
                                    }
                                    return;
                                case 1:
                                    ((aw) view2.getTag(R.h.czu)).yXR.setVisibility(8);
                                    siVar = new si();
                                    siVar.fKS.foe = oM;
                                    siVar.fKS.action = 2;
                                    siVar.fKS.fKU = 1;
                                    com.tencent.mm.sdk.b.a.xmy.m(siVar);
                                    linkedList = new LinkedList();
                                    boh = new boh();
                                    boh.wXP = oM;
                                    boh.wXO = 1;
                                    boh.kzz = 1;
                                    linkedList.add(boh);
                                    q.A(3, q.this.mAppId, q.this.yUs);
                                    as.CN().a(1176, new e() {
                                        public final void a(int i, int i2, String str, k kVar) {
                                            as.CN().b(1176, (e) this);
                                            x.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(false));
                                            if (auVar != view2.getTag(R.h.czN)) {
                                                x.w("MicroMsg.ChattingItemDyeingTemplate", "item msg(%s) has changed.", Long.valueOf(auVar.field_msgId));
                                            } else if (i != 0 || i2 != 0) {
                                                ((aw) view2.getTag(R.h.czu)).yXR.setVisibility(0);
                                                u.makeText(view2.getContext(), R.l.ezL, 0).show();
                                                com.tencent.mm.sdk.b.b siVar = new si();
                                                siVar.fKS.foe = oM;
                                                siVar.fKS.action = 1;
                                                siVar.fKS.fKU = 1;
                                                com.tencent.mm.sdk.b.a.xmy.m(siVar);
                                                if (q.this.yyH != null) {
                                                    q.this.yyH.cpZ();
                                                }
                                            }
                                        }
                                    });
                                    as.CN().a(new com.tencent.mm.modelappbrand.k(linkedList), 0);
                                    if (q.this.yyH != null) {
                                        q.this.yyH.cpZ();
                                        return;
                                    }
                                    return;
                                case 2:
                                    as.CN().a(1198, new e() {
                                        public final void a(int i, int i2, String str, k kVar) {
                                            as.CN().b(1198, (e) this);
                                            x.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(false));
                                            if (q.this.xUU != null) {
                                                q.this.xUU.dismiss();
                                                q.this.xUU = null;
                                            }
                                            if (i == 0 && i2 == 0) {
                                                cdr Jl = ((o) kVar).Jl();
                                                if (Jl == null) {
                                                    u.makeText(view2.getContext(), R.l.ezH, 0).show();
                                                    return;
                                                }
                                                final String str2 = Jl.xje;
                                                x.i("MicroMsg.ChattingItemDyeingTemplate", "more view clicked, menu item COMPLAIN_APP_BRAND selected, sync attr username %s", oM);
                                                ((com.tencent.mm.plugin.appbrand.n.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.c.class)).a(oM, new com.tencent.mm.plugin.appbrand.n.c.a() {
                                                    public final void b(WxaAttributes wxaAttributes) {
                                                        if (wxaAttributes == null) {
                                                            u.makeText(view2.getContext(), R.l.ezL, 0).show();
                                                            return;
                                                        }
                                                        if (TextUtils.isEmpty(wxaAttributes.field_appId) || TextUtils.isEmpty(str2)) {
                                                            x.i("MicroMsg.ChattingItemDyeingTemplate", "appId(%s) or msgId(%s) is null or nil.", r0, str2);
                                                            u.makeText(view2.getContext(), R.l.ezL, 0).show();
                                                            return;
                                                        }
                                                        try {
                                                            x.d("MicroMsg.ChattingItemDyeingTemplate", "go to complain page(%s, %s), url:%s", str2, r0, String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&msgid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect", new Object[]{URLEncoder.encode(r0, ProtocolPackage.ServerEncoding), URLEncoder.encode(str2, ProtocolPackage.ServerEncoding), Integer.valueOf(1), Integer.valueOf(p), Integer.valueOf(p2)}));
                                                            Intent intent = new Intent();
                                                            intent.putExtra("rawUrl", r1);
                                                            com.tencent.mm.bl.d.b(q.this.yyH.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                                        } catch (UnsupportedEncodingException e) {
                                                            x.e("MicroMsg.ChattingItemDyeingTemplate", "Error occurred when encode url.");
                                                            u.makeText(view2.getContext(), R.l.ezL, 0).show();
                                                        }
                                                    }
                                                });
                                                return;
                                            }
                                            u.makeText(view2.getContext(), R.l.ezH, 0).show();
                                        }
                                    });
                                    final k oVar = new o(auVar.field_content);
                                    q qVar = q.this;
                                    Context context = view2.getContext();
                                    view2.getResources().getString(R.l.dGZ);
                                    qVar.xUU = h.a(context, view2.getResources().getString(R.l.dHn), true, new OnCancelListener() {
                                        public final void onCancel(DialogInterface dialogInterface) {
                                            as.CN().c(oVar);
                                        }
                                    });
                                    as.CN().a(oVar, 0);
                                    q.A(4, q.this.mAppId, q.this.yUs);
                                    return;
                                default:
                                    return;
                            }
                        }
                    };
                    gVar.bUX();
                }
            }
        };
        this.yUr = new OnClickListener() {
            public final void onClick(View view) {
                ar arVar = (ar) view.getTag();
                x.i("MicroMsg.ChattingItemDyeingTemplate", "on header (%s) name click", arVar.userName);
                Map y = bj.y(arVar.fFE.field_content, "msg");
                String oM = bi.oM((String) y.get(".msg.fromusername"));
                com.tencent.mm.plugin.report.service.g.pWK.h(11608, q.this.yUs, oM, Integer.valueOf(66666));
                String oM2 = bi.oM((String) y.get(".msg.appmsg.mmreader.template_header.weapp_username"));
                if (bi.oN(oM2)) {
                    String oM3 = bi.oM((String) y.get(".msg.appmsg.mmreader.template_header.header_jump_url"));
                    if (!bi.oN(oM3)) {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", oM3);
                        com.tencent.mm.bl.d.b(q.this.yyH.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                        return;
                    }
                    return;
                }
                String oM4 = bi.oM((String) y.get(".msg.appmsg.mmreader.template_header.weapp_path"));
                int i = bi.getInt((String) y.get(".msg.appmsg.mmreader.template_header.weapp_state"), 0);
                int i2 = bi.getInt((String) y.get(".msg.appmsg.mmreader.template_header.weapp_version"), 0);
                oM = bi.oM((String) y.get(".msg.appmsg.template_id"));
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.foi = arVar.fFE.field_msgSvrId + ":" + arVar.userName + ":" + q.this.yyH.csn() + ":" + oM;
                appBrandStatObject.scene = HardCoderJNI.FUNC_CANCEL_UNIFY_CPU_IO_THREAD_CORE;
                ((com.tencent.mm.plugin.appbrand.n.d) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.d.class)).a(q.this.yyH.getContext(), oM2, null, i, i2, oM4, appBrandStatObject);
            }
        };
        this.yUo = new OnClickListener() {
            public final void onClick(View view) {
                ar arVar = (ar) view.getTag();
                x.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) name click", arVar.userName);
                Map y = bj.y(arVar.fFE.field_content, "msg");
                if (!(y == null || y.size() == 0)) {
                    bi.getInt((String) y.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
                }
                q qVar = q.this;
                view.getContext();
                q.a(qVar, arVar.userName);
            }
        };
        this.yyz = new com.tencent.mm.sdk.b.c<kz>() {
            {
                this.xmG = kz.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                if (q.this.yyH != null) {
                    q.this.yyH.getContext().runOnUiThread(new Runnable() {
                        public final void run() {
                            q.this.yyH.cpZ();
                        }
                    });
                }
                return true;
            }
        };
        this.yUq = new com.tencent.mm.ui.chatting.ChattingUI.b() {
            public final void ctM() {
            }

            public final void ctN() {
            }

            public final void ctO() {
                x.i("MicroMsg.ChattingItemDyeingTemplate", "onChattingExit, then remove AppBrandTmplMsgReceivingSwitchListener.");
                q.yUv.clear();
                com.tencent.mm.sdk.b.a.xmy.c(q.this.yyz);
                if (q.this.yyH != null) {
                    q.this.yyH.b((com.tencent.mm.ui.chatting.ChattingUI.b) this);
                }
            }
        };
        this.yUp = new OnClickListener() {
            public final void onClick(View view) {
                ar arVar = (ar) view.getTag();
                x.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", arVar.userName);
                com.tencent.mm.sdk.b.b qrVar = new qr();
                qrVar.fJd.userName = arVar.userName;
                qrVar.fJd.fJf = arVar.yXB;
                Map y = bj.y(arVar.fFE.field_content, "msg");
                String str = "";
                if (y != null && y.size() > 0) {
                    qrVar.fJd.fJg = bi.getInt((String) y.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
                    str = bi.oM((String) y.get(".msg.appmsg.template_id"));
                }
                qrVar.fJd.fJj = true;
                qrVar.fJd.scene = HardCoderJNI.FUNC_CANCEL_UNIFY_CPU_IO_THREAD_CORE;
                qrVar.fJd.foi = arVar.fFE.field_msgSvrId + ":" + arVar.userName + ":" + q.this.yyH.csn() + ":" + str;
                com.tencent.mm.sdk.b.a.xmy.m(qrVar);
                q.A(9, q.this.mAppId, q.this.yUs);
                com.tencent.mm.plugin.report.service.g.pWK.h(11608, q.this.yUs, arVar.userName, Integer.valueOf(0));
            }
        };
        this.maE = new OnClickListener() {
            public final void onClick(View view) {
                ar arVar = (ar) view.getTag();
                Map y = bj.y(arVar.fFE.field_content, "msg");
                if (y == null) {
                    x.i("MicroMsg.ChattingItemDyeingTemplate", "values map is null.");
                    return;
                }
                int i = bi.getInt((String) y.get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
                String oM;
                if (i == 1) {
                    String str = (String) y.get(".msg.appmsg.mmreader.category.item.weapp_username");
                    String str2 = (String) y.get(".msg.appmsg.mmreader.category.item.weapp_path");
                    int i2 = bi.getInt((String) y.get(".msg.appmsg.mmreader.category.item.weapp_version"), 0);
                    int i3 = bi.getInt((String) y.get(".msg.appmsg.mmreader.category.item.weapp_state"), 0);
                    oM = bi.oM((String) y.get(".msg.appmsg.template_id"));
                    x.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", str);
                    AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                    appBrandStatObject.foi = arVar.fFE.field_msgSvrId + ":" + arVar.userName + ":" + q.this.yyH.csn() + ":" + oM;
                    if (((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.biz.a.a.class)).fX(arVar.userName)) {
                        appBrandStatObject.scene = HardCoderJNI.FUNC_CANCEL_UNIFY_CPU_IO_THREAD_CORE;
                        ((com.tencent.mm.plugin.appbrand.n.d) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.d.class)).a(q.this.yyH.getContext(), str, null, i3, i2, str2, appBrandStatObject);
                    } else {
                        appBrandStatObject.scene = 1043;
                        com.tencent.mm.af.d jV = f.jV(arVar.userName);
                        ((com.tencent.mm.plugin.appbrand.n.d) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.d.class)).a(q.this.yyH.getContext(), str, null, i3, i2, str2, appBrandStatObject, jV == null ? null : jV.field_appId);
                    }
                    q.A(9, q.this.mAppId, q.this.yUs);
                    com.tencent.mm.plugin.report.service.g.pWK.h(11608, q.this.yUs, arVar.userName, Integer.valueOf(0));
                    if (q.this.yUu) {
                        x.i("MicroMsg.ChattingItemDyeingTemplate", "hy: log report p8 click. msg id is: %d", Long.valueOf(q.this.yUw));
                        com.tencent.mm.plugin.report.service.g.pWK.h(836, 6);
                        com.tencent.mm.plugin.report.service.g.pWK.h(15241, Integer.valueOf(2), Long.valueOf(q.this.yUw));
                    }
                } else if (i == 2) {
                    q.b(view.getContext(), (String) y.get(".msg.appmsg.mmreader.category.item.schedule_username"), bi.getLong((String) y.get(".msg.appmsg.mmreader.category.item.schedule_messvrid"), -1));
                    x.i("MicroMsg.ChattingItemDyeingTemplate", "[onClick] Remind! username:%s svrMsgId:%s", oM, Long.valueOf(r2));
                }
            }
        };
    }

    public final boolean ak(int i, boolean z) {
        if (i == 318767153) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddm);
        ap apVar = new ap();
        apVar.mXO = (CheckBox) view.findViewById(R.h.bTE);
        apVar.kbO = view.findViewById(R.h.bUE);
        apVar.qng = (TextView) view.findViewById(R.h.bVm);
        apVar.ikK = (ImageView) view.findViewById(R.h.bTw);
        apVar.ljv = (TextView) view.findViewById(R.h.bVh);
        apVar.yTB = (LinearLayout) view.findViewById(R.h.bTL);
        apVar.yXn.pGP = view.findViewById(R.h.bUr);
        apVar.yXn.yXp = view.findViewById(R.h.com);
        apVar.yXn.jtn = (TextView) apVar.yXn.pGP.findViewById(R.h.title);
        apVar.yXn.nub = (TextView) apVar.yXn.pGP.findViewById(R.h.time);
        apVar.yXn.yXt = (LinearLayout) apVar.yXn.pGP.findViewById(R.h.ccg);
        apVar.yXn.yXs = (TextView) apVar.yTB.findViewById(R.h.cbm);
        apVar.yXn.yXu = apVar.yTB.findViewById(R.h.cLJ);
        apVar.yXn.yXq = view.findViewById(R.h.cxy);
        apVar.yXn.yXr = view.findViewById(R.h.cxz);
        apVar.yXo.yXM = view.findViewById(R.h.bUq);
        apVar.yXo.yXN = (ImageView) view.findViewById(R.h.czL);
        apVar.yXo.yXO = view.findViewById(R.h.czJ);
        apVar.yXo.yXQ = (TextView) view.findViewById(R.h.cAb);
        apVar.yXo.yXP = (ImageView) view.findViewById(R.h.czt);
        apVar.yXo.yXR = view.findViewById(R.h.czu);
        apVar.yXo.yXS = (ImageView) view.findViewById(R.h.czP);
        apVar.yXo.yXT = view.findViewById(R.h.czN);
        apVar.yXo.yXU = view.findViewById(R.h.czO);
        apVar.yXo.yXV = (TextView) view.findViewById(R.h.czU);
        apVar.yXo.yXW = (TextView) view.findViewById(R.h.czT);
        apVar.yXo.yXX = (TextView) view.findViewById(R.h.czI);
        apVar.yXo.yXY = view.findViewById(R.h.czK);
        apVar.yXo.yXZ = (LinearLayout) view.findViewById(R.h.czV);
        apVar.yXo.yYa = (TextView) view.findViewById(R.h.czX);
        apVar.yXo.yYc = (TextView) view.findViewById(R.h.czY);
        apVar.yXo.yYb = (TextView) view.findViewById(R.h.czZ);
        apVar.yXo.yYd = (TextView) view.findViewById(R.h.cAa);
        apVar.yXo.yYe = view.findViewById(R.h.czW);
        apVar.yXo.yYf = (LinearLayout) view.findViewById(R.h.czM);
        apVar.yXo.yYj = view.findViewById(R.h.czH);
        apVar.yXo.yYg = view.findViewById(R.h.bOQ);
        apVar.yXo.yYh = (LinearLayout) view.findViewById(R.h.czF);
        apVar.yXo.yYi = (LinearLayout) view.findViewById(R.h.cdc);
        apVar.yXo.yYk = (LinearLayout) view.findViewById(R.h.czv);
        apVar.yXo.yYn = (TextView) view.findViewById(R.h.czx);
        apVar.yXo.yYp = (ImageView) view.findViewById(R.h.czw);
        apVar.yXo.yYm = view.findViewById(R.h.czG);
        apVar.yXo.yYl = (LinearLayout) view.findViewById(R.h.czy);
        apVar.yXo.yYo = (TextView) view.findViewById(R.h.czA);
        apVar.yXo.yYq = (ImageView) view.findViewById(R.h.czz);
        apVar.yXo.yYr = (ImageView) view.findViewById(R.h.czs);
        apVar.yRN = (ImageView) view.findViewById(R.h.bUp);
        apVar.yXo.yYs = view.findViewById(R.h.czQ);
        apVar.yXo.yYt = (ImageView) view.findViewById(R.h.czR);
        apVar.yXo.yYu = (TextView) view.findViewById(R.h.czS);
        view.setTag(apVar);
        return view;
    }

    protected final boolean cwl() {
        return false;
    }

    public final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
        this.yyH = aVar2;
        aVar = (ap) aVar;
        Map y = bj.y(auVar.field_content, "msg");
        if (y == null || y.size() == 0) {
            x.e("MicroMsg.ChattingItemDyeingTemplate", "filling fail, values is empty");
            aVar.yTB.setVisibility(8);
            return;
        }
        aVar.yTB.setVisibility(0);
        int i2 = bi.getInt((String) y.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
        this.yUs = bi.oM((String) y.get(".msg.appmsg.mmreader.template_header.template_msg_id"));
        this.yUt = bi.getInt((String) y.get(".msg.appmsg.mmreader.template_header.pay_style"), 0);
        this.yUu = bi.getInt((String) y.get(".msg.fromP8"), 0) == 1;
        this.yUw = auVar.field_msgId;
        boolean booleanValue = ((Boolean) yUv.get(this.yUw, Boolean.valueOf(false))).booleanValue();
        if (this.yUu && !booleanValue) {
            x.i("MicroMsg.ChattingItemDyeingTemplate", "hy: is from p8 and not shown. report. msgId is: %d", Long.valueOf(this.yUw));
            yUv.put(this.yUw, Boolean.valueOf(true));
            com.tencent.mm.plugin.report.service.g.pWK.h(836, 5);
            com.tencent.mm.plugin.report.service.g.pWK.h(15241, Integer.valueOf(1), Long.valueOf(this.yUw));
        }
        com.tencent.mm.sdk.b.a.xmy.c(this.yyz);
        aVar2.b(this.yUq);
        String oM;
        String str2;
        String str3;
        View view;
        ar arVar;
        if (i2 != 0) {
            CharSequence charSequence;
            int paddingLeft;
            int i3;
            String oM2;
            Object obj;
            boolean z;
            int d;
            int d2;
            View inflate;
            CharSequence charSequence2;
            int childCount;
            ar arVar2;
            aVar.yXn.pGP.setVisibility(8);
            final aw awVar = aVar.yXo;
            if (bi.getInt((String) y.get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0) == 1) {
                a(awVar, bi.oM((String) y.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url")), bi.oM((String) y.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name")), y, auVar, false);
            } else if (bi.getInt((String) y.get(".msg.appmsg.mmreader.template_header.show_icon_and_display_name"), 0) != 0) {
                a(awVar, bi.oM((String) y.get(".msg.appmsg.mmreader.template_header.icon_url")), bi.oM((String) y.get(".msg.appmsg.mmreader.template_header.display_name")), y, auVar, true);
            } else {
                ((View) awVar.yXS.getParent()).setVisibility(8);
                if ("notifymessage".equals(auVar.field_talker)) {
                    oM = bi.oM((String) y.get(".msg.fromusername"));
                    if (((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.biz.a.a.class)).fX(oM)) {
                        WxaAttributes rf = ((com.tencent.mm.plugin.appbrand.n.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.c.class)).rf(oM);
                        a(awVar.yXP, this.yyH, oM, auVar, rf == null ? null : rf.field_brandIconURL);
                        charSequence = rf == null ? oM : rf.field_nickname;
                    } else {
                        a(awVar.yXP, this.yyH, oM, auVar, null);
                        charSequence = this.yyH.gw(oM);
                    }
                    awVar.yXQ.setText(i.b(this.yyH.getContext(), charSequence, awVar.yXQ.getTextSize()));
                    if (((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.biz.a.a.class)).fX(oM)) {
                        awVar.yXO.setTag(new ar(auVar, oM));
                        awVar.yXO.setOnClickListener(this.yUo);
                    } else {
                        awVar.yXO.setTag(new ar(oM, this.yyH.yAR ? this.yyH.csn() : null));
                        awVar.yXO.setOnClickListener(u(this.yyH));
                    }
                    awVar.yXO.setVisibility(0);
                } else {
                    awVar.yXO.setVisibility(8);
                }
            }
            if (bi.getInt((String) y.get(".msg.appmsg.mmreader.template_header.hide_icon_and_display_name_line"), 0) != 0) {
                awVar.yXO.setBackgroundResource(R.g.bDK);
            } else {
                paddingLeft = awVar.yXO.getPaddingLeft();
                awVar.yXO.setBackgroundResource(R.g.bDq);
                awVar.yXO.setPadding(paddingLeft, 0, 0, 0);
            }
            if (bi.getInt((String) y.get(".msg.appmsg.mmreader.template_header.ignore_hide_title_and_time"), 0) == 0) {
                i3 = bi.getInt((String) y.get(".msg.appmsg.mmreader.template_header.hide_title_and_time"), 0);
            } else {
                i3 = 0;
            }
            int i4 = bi.getInt((String) y.get(".msg.appmsg.mmreader.template_header.hide_title"), 0);
            int i5 = bi.getInt((String) y.get(".msg.appmsg.mmreader.template_header.hide_time"), 0);
            awVar.yXV.setVisibility(8);
            awVar.yXW.setVisibility(8);
            if (i3 == 0) {
                if (i4 == 0) {
                    awVar.yXV.setVisibility(0);
                    charSequence = bi.oM((String) y.get(".msg.appmsg.mmreader.template_header.title"));
                    awVar.yXV.setTextColor(d(y, ".msg.appmsg.mmreader.template_header.title_color", WebView.NIGHT_MODE_COLOR));
                    awVar.yXV.setText(charSequence);
                }
                if (i5 == 0) {
                    long j = bi.getLong(bi.oM((String) y.get(".msg.appmsg.mmreader.template_header.pub_time")), 0);
                    if (j > 0) {
                        awVar.yXW.setText(com.tencent.mm.pluginsdk.h.n.ak(this.yyH.getString(R.l.eiK), j));
                        awVar.yXW.setVisibility(0);
                    } else {
                        awVar.yXW.setVisibility(8);
                    }
                }
            }
            charSequence = bi.oM((String) y.get(".msg.appmsg.mmreader.template_header.first_data"));
            i4 = d(y, ".msg.appmsg.mmreader.template_header.first_color", yUy);
            if (bi.oN(charSequence)) {
                awVar.yXX.setVisibility(8);
            } else {
                awVar.yXX.setTextColor(i4);
                awVar.yXX.setText(charSequence);
                awVar.yXX.setVisibility(0);
                if (i2 == 2) {
                    awVar.yXX.setPadding(0, this.yyH.getResources().getDimensionPixelOffset(R.f.bvw), 0, 0);
                } else {
                    awVar.yXX.setPadding(0, 0, 0, 0);
                }
            }
            if (i3 == 0 || !bi.oN(charSequence)) {
                awVar.yXY.setVisibility(0);
            } else {
                awVar.yXY.setVisibility(8);
            }
            if ("notifymessage".equals(auVar.field_talker)) {
                oM2 = bi.oM((String) y.get(".msg.fromusername"));
                boolean fX = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.biz.a.a.class)).fX(oM2);
                if (fX) {
                    this.yyH.a(this.yUq);
                    com.tencent.mm.sdk.b.a.xmy.b(this.yyz);
                    WxaAttributes rf2 = ((com.tencent.mm.plugin.appbrand.n.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.c.class)).rf(oM2);
                    if (rf2 != null) {
                        obj = (rf2.field_appOpt & 1) > 0 ? 1 : null;
                        this.mAppId = rf2.field_appId;
                        z = fX;
                    } else {
                        x.i("MicroMsg.ChattingItemDyeingTemplate", "try2HandleAppBrandLogic, sync attr username %s", oM2);
                        ((com.tencent.mm.plugin.appbrand.n.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.c.class)).a(oM2, new com.tencent.mm.plugin.appbrand.n.c.a() {
                            public final void b(WxaAttributes wxaAttributes) {
                                int i = 0;
                                if (wxaAttributes != null) {
                                    int i2;
                                    q.this.mAppId = wxaAttributes.field_appId;
                                    if ((wxaAttributes.field_appOpt & 1) > 0) {
                                        i2 = 1;
                                    } else {
                                        i2 = 0;
                                    }
                                    View view = awVar.yXR;
                                    if (i2 == 0) {
                                        i = 8;
                                    }
                                    view.setVisibility(i);
                                }
                            }
                        });
                    }
                }
                obj = null;
                z = fX;
            } else {
                z = false;
                obj = null;
            }
            awVar.yXR.setVisibility(obj != null ? 0 : 8);
            awVar.yXT.setVisibility(z ? 0 : 8);
            awVar.yXT.setTag(R.h.czN, auVar);
            awVar.yXT.setTag(R.h.czu, awVar);
            awVar.yXT.setOnClickListener(this.yUm);
            awVar.yXN.setVisibility(8);
            awVar.yXX.setText(bi.oM((String) y.get(".msg.appmsg.mmreader.template_header.first_data")));
            str2 = (String) y.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.word");
            str3 = (String) y.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.word");
            String str4 = (String) y.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.strikethrough_word");
            if (bi.oN(str3)) {
                awVar.yXZ.setVisibility(8);
            } else {
                d = d(y, ".msg.appmsg.mmreader.template_detail.line_content.topline.key.color", WebView.NIGHT_MODE_COLOR);
                d2 = d(y, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.color", WebView.NIGHT_MODE_COLOR);
                int d3 = d(y, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.strikethrough_word_color", WebView.NIGHT_MODE_COLOR);
                i5 = bi.getInt((String) y.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.small_text_count"), 0);
                awVar.yYa.setTextColor(d);
                awVar.yYc.setTextColor(d2);
                awVar.yYd.setTextColor(d3);
                awVar.yYd.getPaint().setFlags(16);
                awVar.yYa.setText(str2);
                if (i5 <= 0 || i5 >= str3.length()) {
                    awVar.yYb.setTypeface(Typeface.DEFAULT);
                    awVar.yYb.setVisibility(8);
                    awVar.yYc.setTypeface(Typeface.DEFAULT);
                    awVar.yYc.setText(str3);
                } else {
                    awVar.yYb.setVisibility(0);
                    awVar.yYb.setText(str3.substring(0, i5));
                    awVar.yYb.setTextColor(d2);
                    awVar.yYb.setTypeface(((com.tencent.mm.pluginsdk.wallet.b) com.tencent.mm.kernel.g.h(com.tencent.mm.pluginsdk.wallet.b.class)).df(this.yyH.getContext()));
                    awVar.yYc.setTypeface(((com.tencent.mm.pluginsdk.wallet.b) com.tencent.mm.kernel.g.h(com.tencent.mm.pluginsdk.wallet.b.class)).df(this.yyH.getContext()));
                    awVar.yYc.setText(str3.substring(i5));
                }
                if (bi.oN(str4)) {
                    awVar.yYd.setVisibility(8);
                } else {
                    awVar.yYd.setText(str4);
                    awVar.yYd.setVisibility(0);
                }
                awVar.yXZ.setVisibility(0);
            }
            int i6 = bi.getInt((String) y.get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
            if (i6 == 2) {
                x.i("MicroMsg.ChattingItemDyeingTemplate", "[fillingCustomView]");
                awVar.yXW.setVisibility(8);
                awVar.yYf.setVisibility(8);
                ViewGroup viewGroup = (ViewGroup) awVar.yYf.getParent();
                View findViewById = viewGroup.findViewById(R.h.cam);
                if (findViewById == null) {
                    inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.i.dqW, null);
                    ao aoVar = new ao();
                    aoVar.jSg = (ImageView) inflate.findViewById(R.h.bLD);
                    aoVar.yXm = (TextView) inflate.findViewById(R.h.cAq);
                    aoVar.nub = (TextView) inflate.findViewById(R.h.time);
                    aoVar.jtn = (TextView) inflate.findViewById(R.h.title);
                    inflate.setTag(aoVar);
                    viewGroup.addView(inflate);
                    view = inflate;
                } else {
                    view = findViewById;
                }
                view.setVisibility(0);
                ao aoVar2 = (ao) view.getTag();
                charSequence2 = (String) y.get(".msg.appmsg.mmreader.category.item.schedule_content");
                str4 = (String) y.get(".msg.appmsg.mmreader.category.item.schedule_username");
                CharSequence charSequence3 = (String) y.get(".msg.appmsg.mmreader.category.item.schedule_nickname");
                String str5 = (String) y.get(".msg.appmsg.mmreader.category.item.schedule_time");
                d2 = bi.getInt((String) y.get(".msg.appmsg.mmreader.category.item.schedule_remindsubtype"), -1);
                aoVar2.jtn.setText(i.a(aoVar2.jtn.getContext(), charSequence2));
                TextView textView = aoVar2.yXm;
                Context context = aoVar2.jtn.getContext();
                if (bi.oN(str4)) {
                    charSequence3 = "";
                } else {
                    str3 = null;
                    if (s.eX(str4)) {
                        as.Hm();
                        com.tencent.mm.storage.x Xv = com.tencent.mm.y.c.Ff().Xv(str4);
                        if (Xv != null) {
                            str3 = Xv.AX() == null ? Xv.AW() : Xv.AX();
                        }
                    } else {
                        as.Hm();
                        com.tencent.mm.storage.x Xv2 = com.tencent.mm.y.c.Ff().Xv(str4);
                        str3 = Xv2.AX() == null ? Xv2.AW() : Xv2.AX();
                    }
                    if (bi.oN(str3)) {
                        x.i("MicroMsg.ChattingItemDyeingTemplate", "[getDisplayName] username:%s nickname:%s", str4, charSequence3);
                        if (charSequence3 == null) {
                            charSequence3 = ad.getContext().getString(R.l.dSY);
                        }
                    } else {
                        Object charSequence32 = str3;
                    }
                }
                textView.setText(i.a(context, charSequence32));
                aoVar2.nub.setText(str5);
                if (d2 == 2) {
                    aoVar2.jSg.setImageDrawable(ad.getContext().getResources().getDrawable(R.g.byV));
                } else {
                    com.tencent.mm.pluginsdk.ui.a.b.a(aoVar2.jSg, str4);
                }
            } else {
                List arrayList = new ArrayList();
                paddingLeft = 0;
                while (true) {
                    d = paddingLeft;
                    if (d < 100) {
                        oM2 = d == 0 ? ".msg.appmsg.mmreader.template_detail.line_content.lines.line" : ".msg.appmsg.mmreader.template_detail.line_content.lines.line" + d;
                        str2 = (String) y.get(oM2 + ".value.word");
                        str3 = (String) y.get(oM2 + ".key.word");
                        if (bi.oN(str2) && bi.oN(str3)) {
                            x.i("MicroMsg.ChattingItemDyeingTemplate", "fillingLines: lines count=%d", Integer.valueOf(d));
                            break;
                        }
                        at atVar = new at();
                        atVar.yXF = str2;
                        atVar.yXE = bi.oM(str3);
                        atVar.yXG = d(y, oM2 + ".key.color", yUx);
                        atVar.yXH = d(y, oM2 + ".value.color", WebView.NIGHT_MODE_COLOR);
                        atVar.yXI = bi.getInt((String) y.get(new StringBuilder().append(oM2).append(".key.hide").toString()), 0) != 0;
                        paddingLeft = (ZZ(atVar.yXE) + 1) / 2;
                        if (paddingLeft <= 0) {
                            paddingLeft = 0;
                        }
                        arrayList.add(atVar);
                        d++;
                    } else {
                        break;
                    }
                }
                i5 = 0 > 8 ? 8 : 0;
                LinearLayout linearLayout = awVar.yYf;
                linearLayout.setVisibility(0);
                view = ((ViewGroup) awVar.yYf.getParent()).findViewById(R.h.cam);
                if (view != null) {
                    view.setVisibility(8);
                }
                if (linearLayout.getChildCount() > arrayList.size()) {
                    if (arrayList.size() == 0) {
                        linearLayout.removeAllViews();
                    } else {
                        linearLayout.removeViews(arrayList.size(), linearLayout.getChildCount() - arrayList.size());
                    }
                }
                childCount = linearLayout.getChildCount();
                paddingLeft = 0;
                while (true) {
                    d = paddingLeft;
                    if (d >= arrayList.size()) {
                        break;
                    }
                    LinearLayout linearLayout2;
                    at atVar2 = (at) arrayList.get(d);
                    if (d < childCount) {
                        linearLayout2 = (LinearLayout) linearLayout.getChildAt(d);
                    } else {
                        linearLayout2 = (LinearLayout) LayoutInflater.from(this.yyH.getContext()).inflate(R.i.ddd, null, false);
                        au auVar2 = new au();
                        auVar2.yXJ = (TextView) linearLayout2.findViewById(R.h.csZ);
                        auVar2.yXK = (TextView) linearLayout2.findViewById(R.h.ctb);
                        linearLayout2.setTag(auVar2);
                        linearLayout.addView(linearLayout2);
                    }
                    au auVar3 = (au) linearLayout2.getTag();
                    if (atVar2.yXI) {
                        auVar3.yXJ.setVisibility(8);
                    } else {
                        auVar3.yXJ.setVisibility(0);
                        auVar3.yXJ.setEms(i5);
                        auVar3.yXJ.setTextColor(atVar2.yXG);
                        auVar3.yXJ.setText(atVar2.yXE);
                    }
                    auVar3.yXK.setTextColor(atVar2.yXH);
                    auVar3.yXK.setText(atVar2.yXF);
                    paddingLeft = d + 1;
                }
                if (linearLayout.getChildCount() == 0) {
                    awVar.yYe.setVisibility(8);
                    linearLayout.setVisibility(8);
                } else {
                    if (bi.getInt((String) y.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.hide_dash_line"), 0) != 0) {
                        awVar.yYe.setVisibility(8);
                    } else {
                        awVar.yYe.setVisibility(0);
                    }
                    linearLayout.setVisibility(0);
                }
            }
            if (bi.getInt((String) y.get(".msg.appmsg.mmreader.template_detail.opitems.show_type"), 0) != 0) {
                awVar.yYs.setVisibility(8);
                awVar.yYh.setVisibility(8);
                awVar.yYj.setVisibility(8);
                awVar.yYi.setVisibility(0);
                a(awVar, auVar, y);
            } else {
                final String oM3;
                final String str6;
                final String str7;
                final String str8;
                final int i7;
                awVar.yYi.setVisibility(8);
                str2 = (String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.word");
                str3 = (String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.icon");
                if (bi.oN(str2)) {
                    awVar.yYk.setVisibility(8);
                } else {
                    awVar.yYn.setTextColor(d(y, ".msg.appmsg.mmreader.template_detail.opitems.opitem.color", WebView.NIGHT_MODE_COLOR));
                    awVar.yYn.setText(str2);
                    if (bi.oN(str3)) {
                        awVar.yYp.setVisibility(8);
                        awVar.yYn.setPadding(0, 0, 0, 0);
                    } else {
                        awVar.yYp.setVisibility(0);
                        h(awVar.yYp, str3);
                        awVar.yYn.setPadding(0, 0, com.tencent.mm.bu.a.fromDPToPix(this.yyH.getContext(), 16), 0);
                    }
                    str2 = (String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
                    oM3 = bi.oM((String) y.get(".msg.fromusername"));
                    i4 = bi.getInt((String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
                    str6 = (String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
                    arVar2 = new ar(auVar, oM3, str2);
                    awVar.yYk.setTag(arVar2);
                    awVar.yYs.setTag(arVar2);
                    if (i4 != 1 || TextUtils.isEmpty(str6)) {
                        str7 = oM3;
                        awVar.yYk.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                if (!bi.oN(str2)) {
                                    Intent intent = new Intent();
                                    intent.putExtra("rawUrl", str2);
                                    com.tencent.mm.bl.d.b(q.this.yyH.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                    com.tencent.mm.plugin.report.service.g.pWK.h(11608, q.this.yUs, str7, Integer.valueOf(1));
                                }
                            }
                        });
                        awVar.yYs.setOnClickListener(null);
                    } else {
                        str8 = (String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_path");
                        i7 = bi.getInt((String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_version"), 0);
                        childCount = bi.getInt((String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_state"), 0);
                        oM = bi.oM((String) y.get(".msg.appmsg.template_id"));
                        OnClickListener anonymousClass16 = new OnClickListener() {
                            public final void onClick(View view) {
                                ar arVar = (ar) view.getTag();
                                x.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", str6);
                                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                                appBrandStatObject.foi = arVar.fFE.field_msgSvrId + ":" + arVar.userName + ":" + q.this.yyH.csn() + ":" + oM;
                                if (((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.biz.a.a.class)).fX(arVar.userName)) {
                                    appBrandStatObject.scene = HardCoderJNI.FUNC_CANCEL_UNIFY_CPU_IO_THREAD_CORE;
                                    ((com.tencent.mm.plugin.appbrand.n.d) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.d.class)).a(q.this.yyH.getContext(), str6, null, childCount, i7, str8, appBrandStatObject);
                                } else {
                                    appBrandStatObject.scene = 1043;
                                    com.tencent.mm.af.d jV = f.jV(arVar.userName);
                                    ((com.tencent.mm.plugin.appbrand.n.d) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.d.class)).a(q.this.yyH.getContext(), str6, null, childCount, i7, str8, appBrandStatObject, jV == null ? null : jV.field_appId);
                                }
                                q.A(9, q.this.mAppId, q.this.yUs);
                                com.tencent.mm.plugin.report.service.g.pWK.h(11608, q.this.yUs, oM3, Integer.valueOf(1));
                            }
                        };
                        awVar.yYk.setOnClickListener(anonymousClass16);
                        awVar.yYs.setOnClickListener(anonymousClass16);
                    }
                    awVar.yYk.setVisibility(0);
                }
                str2 = (String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.word");
                str4 = (String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.icon");
                if (bi.oN(str2)) {
                    awVar.yYl.setVisibility(8);
                } else {
                    awVar.yYo.setTextColor(d(y, ".msg.appmsg.mmreader.template_detail.opitems.opitem1.color", WebView.NIGHT_MODE_COLOR));
                    awVar.yYo.setText(str2);
                    if (bi.oN(str4)) {
                        awVar.yYq.setVisibility(8);
                        awVar.yYo.setPadding(0, 0, 0, 0);
                    } else {
                        awVar.yYq.setVisibility(0);
                        h(awVar.yYq, str4);
                        awVar.yYo.setPadding(0, 0, com.tencent.mm.bu.a.fromDPToPix(this.yyH.getContext(), 16), 0);
                    }
                    str2 = (String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.url");
                    oM3 = bi.oM((String) y.get(".msg.fromusername"));
                    i5 = bi.getInt((String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.op_type"), 0);
                    str6 = (String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_username");
                    awVar.yYl.setTag(new ar(auVar, oM3, str2));
                    if (i5 != 1 || TextUtils.isEmpty(str6)) {
                        str7 = oM3;
                        awVar.yYl.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                if (!bi.oN(str2)) {
                                    Intent intent = new Intent();
                                    intent.putExtra("rawUrl", str2);
                                    com.tencent.mm.bl.d.b(q.this.yyH.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                    com.tencent.mm.plugin.report.service.g.pWK.h(11608, q.this.yUs, str7, Integer.valueOf(2));
                                }
                            }
                        });
                    } else {
                        str8 = (String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_path");
                        i7 = bi.getInt((String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_version"), 0);
                        childCount = bi.getInt((String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_state"), 0);
                        oM = bi.oM((String) y.get(".msg.appmsg.template_id"));
                        awVar.yYl.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                ar arVar = (ar) view.getTag();
                                x.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", str6);
                                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                                appBrandStatObject.foi = arVar.fFE.field_msgSvrId + ":" + arVar.userName + ":" + q.this.yyH.csn() + ":" + oM;
                                if (((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.biz.a.a.class)).fX(arVar.userName)) {
                                    appBrandStatObject.scene = HardCoderJNI.FUNC_CANCEL_UNIFY_CPU_IO_THREAD_CORE;
                                    ((com.tencent.mm.plugin.appbrand.n.d) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.d.class)).a(q.this.yyH.getContext(), str6, null, childCount, i7, str8, appBrandStatObject);
                                } else {
                                    appBrandStatObject.scene = 1043;
                                    com.tencent.mm.af.d jV = f.jV(arVar.userName);
                                    ((com.tencent.mm.plugin.appbrand.n.d) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.d.class)).a(q.this.yyH.getContext(), str6, null, childCount, i7, str8, appBrandStatObject, jV == null ? null : jV.field_appId);
                                }
                                q.A(9, q.this.mAppId, q.this.yUs);
                                com.tencent.mm.plugin.report.service.g.pWK.h(11608, q.this.yUs, oM3, Integer.valueOf(2));
                            }
                        });
                    }
                    awVar.yYl.setVisibility(0);
                }
                awVar.yYr.setVisibility(8);
                if (awVar.yYk.getVisibility() == 8 && awVar.yYl.getVisibility() == 8) {
                    awVar.yYh.setVisibility(8);
                    awVar.yYg.setVisibility(8);
                    awVar.yYj.setVisibility(8);
                } else {
                    awVar.yYj.setVisibility(0);
                    paddingLeft = this.yyH.getResources().getDimensionPixelOffset(R.f.bvw);
                    if (awVar.yYk.getVisibility() == 0 && awVar.yYl.getVisibility() == 0) {
                        awVar.yYk.setGravity(17);
                        awVar.yYl.setGravity(17);
                        awVar.yYk.setPadding(paddingLeft, 0, paddingLeft, 0);
                        awVar.yYl.setPadding(paddingLeft, 0, paddingLeft, 0);
                    } else if (awVar.yYk.getVisibility() == 0) {
                        if (bi.oN(str3)) {
                            awVar.yYk.setGravity(19);
                            awVar.yYk.setPadding(paddingLeft, 0, 0, 0);
                            awVar.yYr.setVisibility(0);
                        } else {
                            awVar.yYk.setGravity(17);
                            awVar.yYk.setPadding(paddingLeft, 0, paddingLeft, 0);
                        }
                    } else if (bi.oN(str4)) {
                        awVar.yYl.setGravity(19);
                        awVar.yYl.setPadding(this.yyH.getResources().getDimensionPixelOffset(R.f.bvw), 0, 0, 0);
                        awVar.yYr.setVisibility(0);
                    } else {
                        awVar.yYl.setGravity(17);
                        awVar.yYl.setPadding(paddingLeft, 0, paddingLeft, 0);
                    }
                    awVar.yYh.setVisibility(0);
                    awVar.yYg.setVisibility(0);
                }
                if (awVar.yYk.getVisibility() == 0 && awVar.yYl.getVisibility() == 0) {
                    awVar.yYm.setVisibility(0);
                } else {
                    awVar.yYm.setVisibility(8);
                }
                str3 = bi.oM((String) y.get(".msg.fromusername"));
                i4 = bi.getInt((String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
                str2 = (String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
                if (!com.tencent.mm.storage.x.fX(str3) && awVar.yYk.getVisibility() != 8 && awVar.yYl.getVisibility() == 8 && i4 == 1 && com.tencent.mm.storage.x.fX(str2)) {
                    WxaAttributes rf3 = ((com.tencent.mm.plugin.appbrand.n.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.c.class)).rf(str2);
                    str4 = rf3 == null ? null : rf3.field_brandIconURL;
                    charSequence2 = rf3 == null ? str2 : rf3.field_nickname;
                    com.tencent.mm.ap.o.PG().a(str4, awVar.yYt, this.xVd);
                    awVar.yYu.setText(charSequence2);
                    if (rf3 == null) {
                        ((com.tencent.mm.plugin.appbrand.n.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.c.class)).a(str2, new com.tencent.mm.plugin.appbrand.n.c.a() {
                            public final void b(WxaAttributes wxaAttributes) {
                                if (wxaAttributes != null) {
                                    final String str = wxaAttributes.field_brandIconURL;
                                    final String str2 = wxaAttributes.field_nickname;
                                    ah.y(new Runnable() {
                                        public final void run() {
                                            com.tencent.mm.ap.o.PG().a(str, awVar.yYt, q.this.xVd);
                                            awVar.yYu.setText(TextUtils.isEmpty(str2) ? str2 : str2);
                                        }
                                    });
                                }
                            }
                        });
                    }
                    awVar.yYs.setVisibility(0);
                    awVar.yYh.setVisibility(8);
                } else {
                    awVar.yYs.setVisibility(8);
                }
            }
            String oM4 = bi.oM((String) y.get(".msg.fromusername"));
            String str9 = null;
            if (!bi.oN(oM4)) {
                as.Hm();
                str9 = com.tencent.mm.y.c.Ff().Xv(oM4).AW();
            }
            String str10 = (String) y.get(".msg.appmsg.mmreader.category.item.title");
            String str11 = (String) y.get(".msg.appmsg.mmreader.category.item.url");
            str2 = (String) y.get(".msg.appmsg.mmreader.category.item.native_url");
            str3 = (String) y.get(".msg.appmsg.template_id");
            str4 = (String) y.get(".msg.appmsg.mmreader.category.item.weapp_username");
            if (i6 == 1 && !TextUtils.isEmpty(str4)) {
                arVar = new ar(auVar, oM4, str11);
                arVar.position = i;
                awVar.yXM.setTag(arVar);
                awVar.yXM.setOnClickListener(this.maE);
            } else if (i6 == -1 && ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.biz.a.a.class)).fX(oM4)) {
                str4 = (String) y.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
                View view2 = awVar.yXM;
                arVar2 = new ar(auVar, false, i, oM4, false, this.yyH.ctL(), oM4, str9, str10);
                arVar2.fMx = str2;
                arVar2.yXB = str4;
                view2.setTag(arVar2);
                awVar.yXM.setOnClickListener(this.yUp);
            } else if (i6 == 2) {
                arVar = new ar(auVar, oM4, str11);
                arVar.position = i;
                awVar.yXM.setTag(arVar);
                awVar.yXM.setOnClickListener(this.maE);
            } else {
                inflate = awVar.yXM;
                ar arVar3 = new ar(auVar, false, i, str11, false, this.yyH.ctL(), oM4, str9, str10);
                arVar3.fMx = str2;
                inflate.setTag(arVar3);
                awVar.yXM.setOnClickListener(w(this.yyH));
            }
            awVar.yXM.setOnLongClickListener(s(this.yyH));
            if (com.tencent.mm.j.g.Ag().zT()) {
                aVar.yRN.setVisibility(0);
                b.c(this.yyH, aVar.yRN, new com.tencent.mm.ui.chatting.r.n(str3, auVar, str9));
            }
            if (((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.biz.a.a.class)).fX(bi.oM((String) y.get(".msg.fromusername"))) && "notifymessage".equals(auVar.field_talker)) {
                x.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew handled by app brand");
                awVar.yXU.setTag(null);
                awVar.yXU.setVisibility(8);
            } else {
                if ((bi.getInt((String) y.get(".msg.appmsg.mmreader.template_header.show_complaint_button"), 0) == 1 ? 1 : null) == null) {
                    x.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew showMoreV false");
                } else if (awVar.yXO.getVisibility() == 0) {
                    awVar.yXT.setTag(auVar);
                    awVar.yXT.setOnClickListener(this.yUn);
                    awVar.yXT.setVisibility(0);
                    awVar.yXU.setVisibility(8);
                } else if (awVar.yXY.getVisibility() == 0) {
                    awVar.yXU.setTag(auVar);
                    awVar.yXU.setOnClickListener(this.yUn);
                    awVar.yXU.setVisibility(0);
                    awVar.yXT.setVisibility(8);
                }
                awVar.yXT.setTag(null);
                awVar.yXU.setTag(null);
                awVar.yXT.setVisibility(8);
                awVar.yXU.setVisibility(8);
            }
            aVar.yXo.yXM.setVisibility(0);
            return;
        }
        aVar.yXo.yXM.setVisibility(8);
        oM = bi.oM((String) y.get(".msg.fromusername"));
        int i8 = bi.getInt((String) y.get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0);
        x.i("MicroMsg.ChattingItemDyeingTemplate", "fillingOld extType=%d", Integer.valueOf(i8));
        if (i8 == 1) {
            str3 = bi.oM((String) y.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url"));
            b.a(aVar, i.b(this.yyH.getContext(), bi.oM((String) y.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name")), aVar.qng.getTextSize()));
            aVar.ikK.setTag(null);
            aVar.ikK.setOnClickListener(null);
            com.tencent.mm.ap.o.PG().a(str3, aVar.ikK, this.xVd);
        } else {
            a(aVar, this.yyH, auVar, oM);
            a(aVar.ikK, this.yyH, oM, auVar, null);
            if (((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.biz.a.a.class)).fX(oM)) {
                aVar.yXn.yXp.setTag(new ar(auVar, oM));
                aVar.yXn.yXp.setOnClickListener(this.yUo);
            } else {
                aVar.yXn.yXp.setTag(new ar(oM, this.yyH.yAR ? this.yyH.csn() : null));
                aVar.yXn.yXp.setOnClickListener(u(this.yyH));
            }
        }
        x.d("MicroMsg.ChattingItemDyeingTemplate", "dyeing template talker(%s).", auVar.field_talker);
        if ("notifymessage".equals(auVar.field_talker) || i8 == 1) {
            aVar.yXn.yXp.setVisibility(0);
            aVar.yXn.jtn.setTextSize(0, (float) com.tencent.mm.bu.a.aa(aVar.yXn.jtn.getContext(), R.f.bvL));
        } else {
            aVar.yXn.yXp.setVisibility(8);
            aVar.yXn.jtn.setTextSize(0, (float) com.tencent.mm.bu.a.aa(aVar.yXn.jtn.getContext(), R.f.bun));
        }
        aVar.yXn.pGP.setVisibility(0);
        b ay = b.ay(y);
        aVar.yXn.jtn.setText(ay.title);
        aVar.yXn.nub.setText(com.tencent.mm.pluginsdk.h.n.ak(this.yyH.getString(R.l.eiJ), ay.time));
        r.a(aVar.yXn.yXt, y);
        String str12 = null;
        if (!bi.oN(oM)) {
            as.Hm();
            str12 = com.tencent.mm.y.c.Ff().Xv(oM).AW();
        }
        Object obj2 = !bi.oN(ay.url) ? 1 : null;
        str2 = (String) y.get(".msg.appmsg.mmreader.category.item.weapp_username");
        if (bi.getInt((String) y.get(".msg.appmsg.mmreader.category.item.template_op_type"), 0) != 1 || TextUtils.isEmpty(str2)) {
            view = aVar.yXn.pGP;
            ar arVar4 = new ar(auVar, false, i, ay.url, false, this.yyH.ctL(), oM, str12, ay.title);
            arVar4.fMx = ay.fMx;
            view.setTag(arVar4);
            aVar.yXn.pGP.setOnClickListener(w(this.yyH));
        } else {
            arVar = new ar(auVar, oM, ay.url);
            arVar.position = i;
            aVar.yXn.pGP.setTag(arVar);
            aVar.yXn.pGP.setOnClickListener(this.maE);
            obj2 = 1;
        }
        aVar.yXn.pGP.setOnLongClickListener(s(this.yyH));
        if (obj2 == null) {
            aVar.yXn.yXu.setVisibility(8);
            aVar.yXn.yXs.setVisibility(8);
        } else {
            aVar.yXn.yXu.setVisibility(0);
            aVar.yXn.yXs.setVisibility(0);
        }
        if (com.tencent.mm.j.g.Ag().zT()) {
            aVar.yRN.setVisibility(0);
            b.c(this.yyH, aVar.yRN, new com.tencent.mm.ui.chatting.r.n(ay.hdN, auVar, str12));
        }
        aq aqVar = aVar.yXn;
        if ((bi.getInt((String) y.get(".msg.appmsg.mmreader.template_header.show_complaint_button"), 0) == 1 ? 1 : null) == null) {
            x.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew showMoreV false");
            aqVar.yXq.setTag(null);
            aqVar.yXr.setTag(null);
            aqVar.yXq.setVisibility(8);
            aqVar.yXr.setVisibility(8);
        } else if (aqVar.yXp.getVisibility() == 0) {
            aqVar.yXq.setTag(auVar);
            aqVar.yXq.setOnClickListener(this.yUn);
            aqVar.yXq.setVisibility(0);
            aqVar.yXr.setVisibility(8);
        } else {
            aqVar.yXr.setTag(auVar);
            aqVar.yXr.setOnClickListener(this.yUn);
            aqVar.yXr.setVisibility(0);
            aqVar.yXq.setVisibility(8);
        }
        aVar.yXn.pGP.setVisibility(0);
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        ar arVar = (ar) view.getTag();
        if (arVar == null) {
            return false;
        }
        int i = arVar.position;
        if (!this.yyH.ctJ()) {
            contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRS));
        }
        return true;
    }

    protected final boolean cwn() {
        return this.yUt == 0;
    }

    public final boolean b(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
        return false;
    }

    public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
        switch (menuItem.getItemId()) {
            case 100:
                Map y = bj.y(auVar.field_content, "msg");
                if (!(y == null || y.size() == 0)) {
                    if (((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.biz.a.a.class)).fX(bi.oM((String) y.get(".msg.fromusername")))) {
                        A(7, this.mAppId, this.yUs);
                        break;
                    }
                }
                break;
        }
        return false;
    }

    protected final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
        if (str != null && aVar.qng != null) {
            b.a(aVar, i.b(aVar2.getContext(), aVar2.gw(str), aVar.qng.getTextSize()));
        }
    }

    private void a(ImageView imageView, com.tencent.mm.ui.chatting.ChattingUI.a aVar, String str, au auVar, String str2) {
        if (imageView != null) {
            if (s.hq(str)) {
                imageView.setVisibility(8);
                return;
            }
            imageView.setVisibility(0);
            if (((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.biz.a.a.class)).fX(str)) {
                com.tencent.mm.ap.o.PG().a(str2, imageView, this.xVd);
                imageView.setTag(new ar(auVar, str));
                imageView.setOnClickListener(this.yUo);
            } else {
                String csn;
                Bitmap d = m.d(str, null, 0);
                if (d != null) {
                    imageView.setImageBitmap(d);
                } else {
                    imageView.setImageResource(R.g.bAa);
                }
                if (aVar.yAR) {
                    csn = aVar.csn();
                } else {
                    csn = null;
                }
                imageView.setTag(new ar(str, csn));
                imageView.setOnClickListener(u(aVar));
            }
            imageView.setOnLongClickListener(v(aVar));
            imageView.setContentDescription(com.tencent.mm.y.r.gw(str) + aVar.getContext().getString(R.l.bLJ));
        }
    }

    private void a(aw awVar, String str, String str2, Map<String, String> map, au auVar, boolean z) {
        awVar.yXQ.setText(i.b(this.yyH.getContext(), str2, awVar.yXQ.getTextSize()));
        com.tencent.mm.ap.o.PG().a(str, awVar.yXP, this.xVd);
        awVar.yXP.setTag(null);
        awVar.yXP.setOnClickListener(null);
        awVar.yXO.setTag(null);
        awVar.yXO.setOnClickListener(null);
        awVar.yXO.setVisibility(0);
        String oM = bi.oM((String) map.get(".msg.appmsg.mmreader.template_header.weapp_username"));
        String oM2 = bi.oM((String) map.get(".msg.appmsg.mmreader.template_header.header_jump_url"));
        if (bi.oN(oM) && bi.oN(oM2)) {
            awVar.yXO.setOnClickListener(null);
        } else {
            awVar.yXO.setTag(new ar(auVar, bi.oM((String) map.get(".msg.fromusername"))));
            awVar.yXO.setOnClickListener(this.yUr);
        }
        oM = bi.oM((String) map.get(".msg.appmsg.mmreader.template_header.shortcut_icon_url"));
        if (!z || bi.oN(oM)) {
            ((View) awVar.yXS.getParent()).setVisibility(8);
            return;
        }
        ((View) awVar.yXS.getParent()).setVisibility(0);
        com.tencent.mm.ap.o.PG().a(oM, awVar.yXS, this.xVd);
    }

    private void a(aw awVar, au auVar, Map<String, String> map) {
        LinearLayout linearLayout = awVar.yYi;
        int childCount = linearLayout.getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 10) {
                String str = i2 == 0 ? ".msg.appmsg.mmreader.template_detail.opitems.opitem" : ".msg.appmsg.mmreader.template_detail.opitems.opitem" + i2;
                String str2 = (String) map.get(str + ".word");
                String str3 = (String) map.get(str + ".hint_word");
                if (bi.oN(str2)) {
                    x.i("MicroMsg.ChattingItemDyeingTemplate", "fillingVerticalButtons: count=%d", Integer.valueOf(i2));
                    i = linearLayout.getChildCount();
                    if (i <= i2) {
                        return;
                    }
                    if (i2 == 0) {
                        linearLayout.removeAllViews();
                        return;
                    } else {
                        linearLayout.removeViews(i2, i - i2);
                        return;
                    }
                }
                LinearLayout linearLayout2;
                if (i2 < childCount) {
                    linearLayout2 = (LinearLayout) linearLayout.getChildAt(i2);
                } else {
                    linearLayout2 = (LinearLayout) LayoutInflater.from(this.yyH.getContext()).inflate(R.i.ddc, null, false);
                    a aVar = new a();
                    aVar.jtn = (TextView) linearLayout2.findViewById(R.h.czE);
                    aVar.jSg = (ImageView) linearLayout2.findViewById(R.h.czD);
                    aVar.yQZ = (LinearLayout) linearLayout2.findViewById(R.h.czB);
                    aVar.ycX = (TextView) linearLayout2.findViewById(R.h.czC);
                    linearLayout2.setTag(aVar);
                    linearLayout.addView(linearLayout2);
                }
                a aVar2 = (a) linearLayout2.getTag();
                String str4 = (String) map.get(str + ".icon");
                aVar2.jtn.setTextColor(d(map, str + ".color", WebView.NIGHT_MODE_COLOR));
                aVar2.jtn.setText(str2);
                aVar2.ycX.setText(str3);
                if (bi.oN(str4)) {
                    aVar2.jSg.setVisibility(8);
                    aVar2.jtn.setPadding(0, 0, 0, 0);
                } else {
                    aVar2.jSg.setVisibility(0);
                    h(aVar2.jSg, str4);
                    aVar2.jtn.setPadding(0, 0, com.tencent.mm.bu.a.fromDPToPix(this.yyH.getContext(), 28), 0);
                }
                str2 = (String) map.get(str + ".url");
                final String oM = bi.oM((String) map.get(".msg.fromusername"));
                int i3 = bi.getInt((String) map.get(str + ".op_type"), 0);
                str4 = (String) map.get(str + ".weapp_username");
                aVar2.yQZ.setTag(new ar(auVar, oM, str2));
                final int i4 = i2 + 1;
                if (i3 == 1 && !TextUtils.isEmpty(str4)) {
                    final String str5 = (String) map.get(str + ".weapp_path");
                    final int i5 = bi.getInt((String) map.get(str + ".weapp_version"), 0);
                    final int i6 = bi.getInt((String) map.get(str + ".weapp_state"), 0);
                    final String oM2 = bi.oM((String) map.get(".msg.appmsg.template_id"));
                    aVar2.yQZ.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            ar arVar = (ar) view.getTag();
                            x.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", str4);
                            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                            appBrandStatObject.foi = arVar.fFE.field_msgSvrId + ":" + arVar.userName + ":" + q.this.yyH.csn() + ":" + oM2;
                            if (((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.biz.a.a.class)).fX(arVar.userName)) {
                                appBrandStatObject.scene = HardCoderJNI.FUNC_CANCEL_UNIFY_CPU_IO_THREAD_CORE;
                                ((com.tencent.mm.plugin.appbrand.n.d) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.d.class)).a(q.this.yyH.getContext(), str4, null, i6, i5, str5, appBrandStatObject);
                            } else {
                                appBrandStatObject.scene = 1043;
                                com.tencent.mm.af.d jV = f.jV(arVar.userName);
                                ((com.tencent.mm.plugin.appbrand.n.d) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.d.class)).a(q.this.yyH.getContext(), str4, null, i6, i5, str5, appBrandStatObject, jV == null ? null : jV.field_appId);
                            }
                            q.A(9, q.this.mAppId, q.this.yUs);
                            com.tencent.mm.plugin.report.service.g.pWK.h(11608, q.this.yUs, oM, Integer.valueOf(i4));
                        }
                    });
                } else if (i3 == 2) {
                    final Map<String, String> map2 = map;
                    aVar2.yQZ.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            if (i4 == 1) {
                                q.b(view.getContext(), (String) map2.get(".msg.appmsg.mmreader.category.item.schedule_username"), bi.getLong((String) map2.get(".msg.appmsg.mmreader.category.item.schedule_messvrid"), -1));
                                com.tencent.mm.plugin.report.service.g.pWK.a(795, 2, 1, false);
                                x.i("MicroMsg.ChattingItemDyeingTemplate", "[onClick] Remind! username:%s svrMsgId:%s", r0, Long.valueOf(r10));
                            } else if (i4 == 2) {
                                com.tencent.mm.bl.d.a(view.getContext(), ".ui.AllRemindMsgUI", new Intent());
                            }
                        }
                    });
                } else {
                    aVar2.yQZ.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            if (!bi.oN(str2)) {
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", str2);
                                com.tencent.mm.bl.d.b(q.this.yyH.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                com.tencent.mm.plugin.report.service.g.pWK.h(11608, q.this.yUs, oM, Integer.valueOf(i4));
                            }
                        }
                    });
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private static void h(ImageView imageView, String str) {
        if (!bi.oN(str) && imageView != null) {
            com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
            as.Hm();
            aVar.hFo = com.tencent.mm.y.c.Fq();
            aVar.hFl = true;
            aVar.hFI = true;
            com.tencent.mm.ap.o.PG().a(str, imageView, aVar.PQ());
        }
    }

    private static void A(int i, String str, String str2) {
        x.d("MicroMsg.ChattingItemDyeingTemplate", "stev report(%s), eventId : %d, appId %s, templateId %s", Integer.valueOf(13796), Integer.valueOf(i), str, str2);
        com.tencent.mm.plugin.report.service.g.pWK.h(13796, Integer.valueOf(i), str, str2, Integer.valueOf(0), Long.valueOf(bi.Wx()));
    }

    private static int d(Map<String, String> map, String str, int i) {
        if (map == null || bi.oN(str)) {
            return i;
        }
        try {
            return Color.parseColor(bi.oM((String) map.get(str)));
        } catch (Exception e) {
            return i;
        }
    }

    private static int ZZ(String str) {
        int i = 0;
        if (bi.oN(str)) {
            return 0;
        }
        String str2 = "[Α-￥]";
        int i2 = 0;
        while (i < str.length()) {
            if (str.substring(i, i + 1).matches(str2)) {
                i2 += 2;
            } else {
                i2++;
            }
            i++;
        }
        return i2;
    }
}
