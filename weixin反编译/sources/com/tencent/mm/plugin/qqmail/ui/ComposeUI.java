package com.tencent.mm.plugin.qqmail.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.webkit.ConsoleMessage;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.plugin.qqmail.b.d;
import com.tencent.mm.plugin.qqmail.b.e;
import com.tencent.mm.plugin.qqmail.b.i;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.t;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;
import java.io.File;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"SetJavaScriptEnabled"})
public class ComposeUI extends MMActivity {
    private static List<i> pwe;
    private int mode = 5;
    private int ptM = 1;
    private long pvI;
    private v pvc = w.bla();
    private Map<String, String> pvj = new HashMap();
    private r pwA;
    private String pwB;
    private q pwC;
    public boolean pwD = true;
    public boolean pwE = true;
    public boolean pwF = false;
    private String pwG = ("(function() { \nvar imgList = document.getElementsByTagName('img');var result = ''; \nfor (var i = 0; i < imgList.length; i++) {var img = imgList[i];var info = img.id + '@@' + img.src;result += info + '&&'}return result;" + "})()".trim());
    private String pwH = "document.getElementById('history').innerHTML";
    private String pwI = "<div id=\"htmlContent\" contenteditable=\"true\" >";
    private String pwJ = "</div>";
    private String pwK = null;
    private String pwL = null;
    private String pwM = "weixin://get_img_info/";
    private String pwN = "weixin://get_mail_content/";
    private String pwO = "weixin://img_onclick/";
    private boolean pwP = false;
    private boolean pwQ = false;
    private al pwR = new al(new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            ComposeUI.this.enableOptionMenu(ComposeUI.a(ComposeUI.this, true));
            return true;
        }
    }, true);
    private al pwS = new al(new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            if (ComposeUI.this.pwD && ComposeUI.a(ComposeUI.this, false) && ComposeUI.this.mode == 5) {
                ComposeUI.b(ComposeUI.this);
                if (ComposeUI.this.pwC != null) {
                    ComposeUI.this.pwC.dismiss();
                }
                ComposeUI.this.pwC = u.a(ComposeUI.this, ComposeUI.this.getString(R.l.eAG), 2000);
            }
            return true;
        }
    }, true);
    com.tencent.mm.plugin.qqmail.b.j.a pwT = new com.tencent.mm.plugin.qqmail.b.j.a() {
        public final void onComplete() {
            com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.b bVar = new com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.b(ComposeUI.this, ComposeUI.this.pwx.Io(null));
            ComposeUI.this.pwg.a(bVar);
            ComposeUI.this.pwk.a(bVar);
            ComposeUI.this.pwn.a(bVar);
        }
    };
    private OnClickListener pwU = new OnClickListener() {
        public final void onClick(View view) {
            ComposeUI.this.pwi.setVisibility(8);
            ComposeUI.this.pwj.setVisibility(0);
            ComposeUI.this.pwm.setVisibility(0);
            ComposeUI.this.pwi.post(new Runnable() {
                public final void run() {
                    ComposeUI.this.pwj.requestFocus();
                    ComposeUI.this.pwk.blG();
                    ComposeUI.this.pwn.blG();
                }
            });
        }
    };
    private OnClickListener pwV = new OnClickListener() {
        public final void onClick(View view) {
            h.a(ComposeUI.this, null, new String[]{ComposeUI.this.getString(R.l.eAF), ComposeUI.this.getString(R.l.eAC), ComposeUI.this.getString(R.l.eAD)}, null, new com.tencent.mm.ui.base.h.c() {
                public final void jo(int i) {
                    switch (i) {
                        case 0:
                            x.i("MicroMsg.ComposeUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(ComposeUI.this.mController.xRr, "android.permission.CAMERA", 16, "", "")), bi.chl(), ComposeUI.this.mController.xRr);
                            if (com.tencent.mm.pluginsdk.g.a.a(ComposeUI.this.mController.xRr, "android.permission.CAMERA", 16, "", "")) {
                                ComposeUI.this.asx();
                                return;
                            }
                            return;
                        case 1:
                            k.a(ComposeUI.this, 4, null);
                            return;
                        case 2:
                            ComposeUI.this.startActivityForResult(new Intent(ComposeUI.this, FileExplorerUI.class), 5);
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    };
    private OnMenuItemClickListener pwW = new OnMenuItemClickListener() {
        public final boolean onMenuItemClick(MenuItem menuItem) {
            if ((ComposeUI.a(ComposeUI.this, false) && ComposeUI.this.mode == 5) || ComposeUI.this.mode == 6) {
                h.a(ComposeUI.this.mController.xRr, ComposeUI.this.getString(R.l.eAJ), "", ComposeUI.this.getString(R.l.eAL), ComposeUI.this.getString(R.l.dEy), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ComposeUI.this.setResult(0);
                        ComposeUI.this.finish();
                    }
                }, null);
            } else {
                ComposeUI.this.setResult(0);
                ComposeUI.this.finish();
            }
            return true;
        }
    };
    private OnClickListener pwX = new OnClickListener() {
        public final void onClick(View view) {
            ComposeUI.this.aWY();
            ComposeUI.this.pwp.getText().toString();
            ComposeUI.this.blm();
            if (ComposeUI.this.bln()) {
                ComposeUI composeUI = ComposeUI.this;
                Context context = ComposeUI.this;
                ComposeUI.this.getString(R.l.dGZ);
                composeUI.pwA = h.a(context, ComposeUI.this.getString(R.l.eAx), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        ComposeUI.this.pwy.blv();
                        ComposeUI.this.pwy.pxZ = null;
                        w.bkZ().cancel(ComposeUI.this.pvI);
                    }
                });
                if (ComposeUI.this.pwy.blw()) {
                    ComposeUI.this.pvI = ComposeUI.H(ComposeUI.this);
                    return;
                }
                ComposeUI.this.pwA.setMessage(ComposeUI.this.getString(R.l.eAu));
                ComposeUI.this.pwy.pxZ = new com.tencent.mm.plugin.qqmail.ui.b.b() {
                    public final void blo() {
                        ComposeUI.this.pwA.setMessage(ComposeUI.this.getString(R.l.eAu));
                    }

                    public final void onComplete() {
                        ComposeUI.this.pvI = ComposeUI.H(ComposeUI.this);
                    }
                };
            }
        }
    };
    private OnClickListener pwY = new OnClickListener() {
        public final void onClick(View view) {
            if (ComposeUI.this.pwy.blw()) {
                s.a(ComposeUI.this.pww, ComposeUI.this.pwN, ComposeUI.this.pwH);
                ComposeUI.this.pwQ = true;
                return;
            }
            ComposeUI.this.pwA = h.a(ComposeUI.this, ComposeUI.this.getString(R.l.eAu), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    ComposeUI.this.pwy.blv();
                    ComposeUI.this.pwy.pxZ = null;
                }
            });
            ComposeUI.this.pwy.pxZ = new com.tencent.mm.plugin.qqmail.ui.b.b() {
                public final void blo() {
                }

                public final void onComplete() {
                    ComposeUI.this.pwA.dismiss();
                    s.a(ComposeUI.this.pww, ComposeUI.this.pwN, ComposeUI.this.pwH);
                    ComposeUI.this.pwQ = true;
                }
            };
        }
    };
    private com.tencent.mm.plugin.qqmail.b.p.a pwZ = new com.tencent.mm.plugin.qqmail.b.p.a() {
        public final void onSuccess(String str, Map<String, String> map) {
            h.a(ComposeUI.this, R.l.eAy, R.l.dGZ, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    File file = new File(w.bkZ().puI.ptL.ptV + com.tencent.mm.plugin.qqmail.b.c.bW(ComposeUI.this.pwB, ComposeUI.this.ptM));
                    if (file.exists()) {
                        file.delete();
                    }
                    ComposeUI.this.setResult(-1);
                    ComposeUI.this.finish();
                }
            });
            ComposeUI.this.pwx.br(ComposeUI.this.pwg.pyD);
            ComposeUI.this.pwx.br(ComposeUI.this.pwk.pyD);
            ComposeUI.this.pwx.br(ComposeUI.this.pwn.pyD);
        }

        public final void onError(int i, String str) {
            if (i == -5) {
                ComposeUI.this.pwz.a(new com.tencent.mm.plugin.qqmail.ui.c.a() {
                    public final void blc() {
                        ComposeUI.H(ComposeUI.this);
                    }

                    public final void bld() {
                    }
                });
            } else {
                h.a(ComposeUI.this, str, ComposeUI.this.getString(R.l.eAw), null);
            }
        }

        public final void onComplete() {
            if (ComposeUI.this.pwA != null) {
                ComposeUI.this.pwA.dismiss();
                ComposeUI.this.pwA = null;
            }
        }
    };
    private ScrollView pwf;
    protected MailAddrsViewControl pwg;
    private ImageView pwh;
    private LinearLayout pwi;
    private LinearLayout pwj;
    private MailAddrsViewControl pwk;
    private ImageView pwl;
    private LinearLayout pwm;
    private MailAddrsViewControl pwn;
    private ImageView pwo;
    private EditText pwp;
    private LinearLayout pwq;
    private TextView pwr;
    private ImageView pws;
    private LinearLayout pwt;
    private TextView pwu;
    private EditText pwv;
    private WebView pww;
    private j pwx;
    private b pwy;
    public c pwz = new c(this);

    private class a extends com.tencent.xweb.j {
        private a() {
        }

        /* synthetic */ a(ComposeUI composeUI, byte b) {
            this();
        }

        @Deprecated
        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            x.i("MicroMsg.ComposeUI", "console, consoleMessage: %s", consoleMessage);
            String Tz = s.Tz(consoleMessage != null ? consoleMessage.message() : null);
            String[] split;
            if (Tz.startsWith(ComposeUI.this.pwO)) {
                ComposeUI.this.aWY();
                try {
                    String[] split2 = URLDecoder.decode(Tz.substring(ComposeUI.this.pwO.length()), ProtocolPackage.ServerEncoding).split("@@")[0].split(":");
                    String str = split2[0];
                    String str2 = split2[1];
                    x.i("MicroMsg.ComposeUI", "img onclick, src: %s, msgLocalId: %s, msgSvrId: %s", split[1], str, str2);
                    as.Hm();
                    cg dI = com.tencent.mm.y.c.Fh().dI((long) Integer.valueOf(str).intValue());
                    Intent intent = new Intent(ComposeUI.this, MailImageDownloadUI.class);
                    intent.putExtra("img_msg_id", dI.field_msgId);
                    intent.putExtra("img_server_id", dI.field_msgSvrId);
                    intent.putExtra("img_download_compress_type", 0);
                    intent.putExtra("img_download_username", dI.field_talker);
                    ComposeUI.this.startActivity(intent);
                    return true;
                } catch (Exception e) {
                    x.w("MicroMsg.ComposeUI", "consoleMessage IMG_ONCLICK, ex = %s", e.getMessage());
                }
            } else if (Tz.startsWith(ComposeUI.this.pwN)) {
                try {
                    ComposeUI.this.pwL = URLDecoder.decode(Tz.substring(ComposeUI.this.pwN.length()), ProtocolPackage.ServerEncoding);
                } catch (Exception e2) {
                    x.w("MicroMsg.ComposeUI", "consoleMessage GET_MAIL_CONTENT, ex = %s", e2.getMessage());
                }
                if (ComposeUI.this.pwQ) {
                    if (ComposeUI.this.pwL.indexOf("<img") == -1) {
                        ComposeUI.this.pvj.clear();
                        ComposeUI.r(ComposeUI.this);
                        return true;
                    }
                    s.a(ComposeUI.this.pww, ComposeUI.this.pwM, ComposeUI.this.pwG);
                }
                return true;
            } else {
                if (Tz.startsWith(ComposeUI.this.pwM)) {
                    ComposeUI.this.pvj.clear();
                    try {
                        String[] split3 = URLDecoder.decode(Tz.substring(ComposeUI.this.pwM.length()), ProtocolPackage.ServerEncoding).split("&&");
                        for (String Tz2 : split3) {
                            split = Tz2.split("@@");
                            Object obj = split[0].split(":")[1];
                            Object obj2 = split[1];
                            if (obj2.startsWith("file://")) {
                                obj2 = obj2.replaceFirst("file://", "");
                            }
                            x.i("MicroMsg.ComposeUI", "put msgImgInfoMap, msgSvrId: %s, path: %s", obj, obj2);
                            ComposeUI.this.pvj.put(obj, obj2);
                        }
                        if (ComposeUI.this.pwQ) {
                            ComposeUI.r(ComposeUI.this);
                        }
                        return true;
                    } catch (Exception e22) {
                        x.w("MicroMsg.ComposeUI", "consoleMessage GET_IMG_INFO, ex = %s", e22.getMessage());
                        return true;
                    }
                }
                return super.onConsoleMessage(consoleMessage);
            }
        }
    }

    private class c extends com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.c {
        private ImageView pxn;
        private int tag;

        public c(ImageView imageView, int i) {
            this.pxn = imageView;
            this.tag = i;
        }

        public final void hs(boolean z) {
            ImageView imageView;
            int i = 0;
            ComposeUI.y(ComposeUI.this);
            if (ComposeUI.this.pwF) {
                imageView = this.pxn;
            } else {
                imageView = this.pxn;
                if (!z) {
                    i = 4;
                }
            }
            imageView.setVisibility(i);
            if ((this.tag == 1 || this.tag == 2) && !z) {
                ComposeUI.this.pwi.postDelayed(new Runnable() {
                    public final void run() {
                        if (!ComposeUI.this.pwk.pyE.isFocused() && !ComposeUI.this.pwn.pyE.isFocused() && ComposeUI.this.pwk.pyD.size() == 0 && ComposeUI.this.pwn.pyD.size() == 0 && ComposeUI.this.pwk.blB() && ComposeUI.this.pwn.blB()) {
                            ComposeUI.this.pwi.setVisibility(0);
                            ComposeUI.this.pwj.setVisibility(8);
                            ComposeUI.this.pwm.setVisibility(8);
                        }
                    }
                }, 10);
            }
        }
    }

    private class b extends p {
        private boolean pxm;

        private b() {
            this.pxm = false;
        }

        /* synthetic */ b(ComposeUI composeUI, byte b) {
            this();
        }

        public final boolean b(WebView webView, String str) {
            x.d("MicroMsg.ComposeUI", "shouldOverrideUrlLoading, url = %s", str);
            String[] split;
            String str2;
            if (str.startsWith(ComposeUI.this.pwO)) {
                ComposeUI.this.aWY();
                try {
                    split = URLDecoder.decode(str.substring(ComposeUI.this.pwO.length()), ProtocolPackage.ServerEncoding).split("@@")[0].split(":");
                    String str3 = split[0];
                    str2 = split[1];
                    x.i("MicroMsg.ComposeUI", "img onclick, src: %s, msgLocalId: %s, msgSvrId: %s", r0[1], str3, str2);
                    as.Hm();
                    cg dI = com.tencent.mm.y.c.Fh().dI((long) Integer.valueOf(str3).intValue());
                    Intent intent = new Intent(ComposeUI.this, MailImageDownloadUI.class);
                    intent.putExtra("img_msg_id", dI.field_msgId);
                    intent.putExtra("img_server_id", dI.field_msgSvrId);
                    intent.putExtra("img_download_compress_type", 0);
                    intent.putExtra("img_download_username", dI.field_talker);
                    ComposeUI.this.startActivity(intent);
                } catch (Exception e) {
                    x.w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading IMG_ONCLICK, ex = %s", e.getMessage());
                }
            } else if (str.startsWith(ComposeUI.this.pwN)) {
                try {
                    ComposeUI.this.pwL = URLDecoder.decode(str.substring(ComposeUI.this.pwN.length()), ProtocolPackage.ServerEncoding);
                } catch (Exception e2) {
                    x.w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading GET_MAIL_CONTENT, ex = %s", e2.getMessage());
                }
                if (ComposeUI.this.pwQ) {
                    if (ComposeUI.this.pwL.indexOf("<img") == -1) {
                        ComposeUI.this.pvj.clear();
                        ComposeUI.r(ComposeUI.this);
                    } else {
                        s.a(ComposeUI.this.pww, ComposeUI.this.pwM, ComposeUI.this.pwG);
                    }
                }
            } else if (str.startsWith(ComposeUI.this.pwM)) {
                ComposeUI.this.pvj.clear();
                try {
                    String[] split2 = URLDecoder.decode(str.substring(ComposeUI.this.pwM.length()), ProtocolPackage.ServerEncoding).split("&&");
                    for (String str22 : split2) {
                        split = str22.split("@@");
                        Object obj = split[0].split(":")[1];
                        Object obj2 = split[1];
                        if (obj2.startsWith("file://")) {
                            obj2 = obj2.replaceFirst("file://", "");
                        }
                        x.i("MicroMsg.ComposeUI", "put msgImgInfoMap, msgSvrId: %s, path: %s", obj, obj2);
                        ComposeUI.this.pvj.put(obj, obj2);
                    }
                    if (ComposeUI.this.pwQ) {
                        ComposeUI.r(ComposeUI.this);
                    }
                } catch (Exception e22) {
                    x.w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading GET_IMG_INFO, ex = %s", e22.getMessage());
                }
            }
            return true;
        }

        public final void b(WebView webView, String str, Bitmap bitmap) {
            super.b(webView, str, bitmap);
            if (!ComposeUI.this.pwP) {
                s.a(ComposeUI.this.pww);
                ComposeUI.this.pwP = true;
            }
        }

        public final void a(WebView webView, String str) {
            x.d("MicroMsg.ComposeUI", "onPageFinished, url = %s, firstTimeLoaded = %b", str, Boolean.valueOf(this.pxm));
            if (!this.pxm) {
                this.pxm = true;
                s.a(ComposeUI.this.pww, ComposeUI.this.pwN, ComposeUI.this.pwH);
            }
            super.a(webView, str);
        }
    }

    static /* synthetic */ long H(ComposeUI composeUI) {
        Map hashMap = new HashMap();
        hashMap.put("from", "");
        hashMap.put("to", composeUI.pwg.blE());
        hashMap.put("cc", composeUI.pwk.blE());
        hashMap.put("bcc", composeUI.pwn.blE());
        hashMap.put("subject", composeUI.getSubject());
        hashMap.put("content", composeUI.blm());
        hashMap.put("attachlist", composeUI.pwy.blt());
        hashMap.put("sendtype", (composeUI.ptM == 4 ? 1 : composeUI.ptM));
        hashMap.put("oldmailid", composeUI.pwB);
        com.tencent.mm.plugin.qqmail.b.p.c cVar = new com.tencent.mm.plugin.qqmail.b.p.c();
        cVar.puT = false;
        cVar.puS = true;
        return w.bkZ().a("/cgi-bin/composesendwithattach", hashMap, cVar, composeUI.pwZ);
    }

    static /* synthetic */ boolean a(ComposeUI composeUI, boolean z) {
        if (z && composeUI.pwg.pyD.size() == 0 && composeUI.pwk.pyD.size() == 0 && composeUI.pwn.pyD.size() == 0 && !composeUI.pwg.blD() && !composeUI.pwk.blD() && !composeUI.pwn.blD()) {
            return false;
        }
        if (composeUI.mode == 5) {
            if (composeUI.pwp.getText().toString().trim().length() == 0 && composeUI.pwy.blu().size() == 0 && composeUI.pwv.getText().length() == 0) {
                return false;
            }
        } else if (composeUI.mode == 6 && composeUI.pwp.getText().toString().trim().length() == 0 && composeUI.pwy.blu().size() == 0) {
            return false;
        }
        return true;
    }

    static /* synthetic */ void b(ComposeUI composeUI) {
        d dVar = new d();
        dVar.ptM = composeUI.ptM;
        dVar.ptN = composeUI.pwB;
        dVar.ptO = composeUI.pwg.pyD;
        dVar.ptP = composeUI.pwk.pyD;
        dVar.ptQ = composeUI.pwn.pyD;
        dVar.ptS = composeUI.pwp.getText().toString();
        dVar.ptR = composeUI.pwy.blu();
        if (composeUI.mode != 6 && composeUI.mode == 5) {
            dVar.content = composeUI.blm();
            dVar.ptT = composeUI.mode;
            x.i("MicroMsg.ComposeUI", "save draft mail as normal mode");
        }
        com.tencent.mm.plugin.qqmail.b.c cVar = w.bkZ().puI;
        try {
            cVar.ptL.bkN();
            e.q(cVar.ptL.ptV + com.tencent.mm.plugin.qqmail.b.c.bW(dVar.ptN, dVar.ptM), dVar.toByteArray());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.DraftBoxMgr", e, "", new Object[0]);
        }
    }

    static /* synthetic */ void r(ComposeUI composeUI) {
        Map map;
        String str = null;
        as.Hm();
        String oVar = new o(((Integer) com.tencent.mm.y.c.Db().get(9, null)).intValue()).toString();
        oVar = !bi.oN(oVar) ? oVar + "@qq.com" : null;
        com.tencent.mm.plugin.qqmail.b.u uVar = new com.tencent.mm.plugin.qqmail.b.u();
        uVar.fAJ = oVar;
        uVar.ptS = composeUI.getSubject();
        if (!bi.oN(composeUI.pwg.blE())) {
            uVar.puv = composeUI.pwg.blE().split(",");
        }
        if (!bi.oN(composeUI.pwk.blE())) {
            uVar.puw = composeUI.pwk.blE().split(",");
        }
        if (!bi.oN(composeUI.pwn.blE())) {
            uVar.pux = composeUI.pwn.blE().split(",");
        }
        oVar = composeUI.blm();
        if (!bi.oN(oVar)) {
            str = oVar.replaceAll("src=\"file://", "src=\"cid:").replaceAll("height=\"100\"", "style=\"max-width: 200px; max-width:300px;\"");
        }
        uVar.pvi = str;
        if (composeUI.pvj.size() > 0) {
            map = composeUI.pvj;
            uVar.pvj = new HashMap();
            uVar.pvj.putAll(map);
        }
        x.d("MicroMsg.ComposeUI", "send mail content: \n%s", str);
        x.d("MicroMsg.ComposeUI", "msgImgInfoMap.size: %d", Integer.valueOf(composeUI.pvj.size()));
        x.d("MicroMsg.ComposeUI", "uploadedAttachidMap.size: %d", Integer.valueOf(composeUI.pwy.pxX.size()));
        if (composeUI.pwy.pxX.size() > 0 && composeUI.pwy.pxY.size() > 0) {
            map = composeUI.pwy.pxX;
            uVar.pvk = new LinkedHashMap();
            uVar.pvk.putAll(map);
            map = composeUI.pwy.pxY;
            uVar.pvl = new LinkedHashMap();
            uVar.pvl.putAll(map);
        }
        v vVar = composeUI.pvc;
        if (vVar.pvn == null) {
            vVar.pvn = new t();
        }
        vVar.pvn.a(uVar);
        composeUI.pwQ = false;
        h.bu(composeUI.mController.xRr, composeUI.getString(R.l.eip));
        ah.h(new Runnable() {
            public final void run() {
                ComposeUI.this.setResult(-1);
                ComposeUI.this.finish();
            }
        }, 800);
    }

    static /* synthetic */ void y(ComposeUI composeUI) {
        composeUI.pwh.setVisibility(4);
        composeUI.pwl.setVisibility(4);
        composeUI.pwo.setVisibility(4);
    }

    protected final int getLayoutId() {
        return R.i.dqd;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pwK = this.pwI + "%s" + this.pwJ;
        this.pwP = false;
        this.pwQ = false;
        this.ptM = getIntent().getIntExtra("composeType", 1);
        this.pwB = getIntent().getStringExtra("mailid");
        if (this.pwB == null) {
            this.pwB = "";
        }
        this.mode = getIntent().getIntExtra("mail_mode", 5);
        x.d("MicroMsg.ComposeUI", "onCreate, mode = %d", Integer.valueOf(this.mode));
        initView();
        this.pwx = w.bkZ().puH;
        this.pwx.a(this.pwT);
        this.pwx.bkP();
        this.pwS.K(180000, 180000);
    }

    protected void onResume() {
        super.onResume();
        this.pwR.K(1500, 1500);
    }

    protected void onPause() {
        super.onPause();
        aWY();
        this.pwR.TN();
        if (this.pwC != null) {
            this.pwC.dismiss();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (pwe != null) {
            pwe = null;
        }
        this.pwy.blv();
        as.CN().b(484, this.pwy);
        this.pwx.b(this.pwT);
        this.pwz.release();
        this.pwS.TN();
    }

    private void blk() {
        this.pwg.clearFocus();
        this.pwk.clearFocus();
        this.pwn.clearFocus();
    }

    protected final void initView() {
        String str;
        CharSequence charSequence;
        this.pwf = (ScrollView) findViewById(R.h.cEX);
        this.pwg = (MailAddrsViewControl) findViewById(R.h.cET);
        this.pwh = (ImageView) findViewById(R.h.cEO);
        this.pwi = (LinearLayout) findViewById(R.h.cEW);
        this.pwj = (LinearLayout) findViewById(R.h.cES);
        this.pwk = (MailAddrsViewControl) findViewById(R.h.cER);
        this.pwl = (ImageView) findViewById(R.h.cEN);
        this.pwm = (LinearLayout) findViewById(R.h.cEQ);
        this.pwn = (MailAddrsViewControl) findViewById(R.h.cEP);
        this.pwo = (ImageView) findViewById(R.h.cEM);
        this.pwp = (EditText) findViewById(R.h.cFb);
        this.pwq = (LinearLayout) findViewById(R.h.cEL);
        this.pwu = (TextView) findViewById(R.h.cDg);
        this.pwv = (EditText) findViewById(R.h.cEY);
        this.pww = com.tencent.mm.ui.widget.MMWebView.a.l(this, R.h.cEZ);
        this.pwr = (TextView) findViewById(R.h.cEV);
        this.pws = (ImageView) findViewById(R.h.cEU);
        this.pwt = (LinearLayout) findViewById(R.h.cDf);
        this.pwg.blC();
        this.pwk.blC();
        this.pwn.blC();
        CharSequence stringExtra = getIntent().getStringExtra("mail_content");
        List<String> stringArrayListExtra = getIntent().getStringArrayListExtra("mail_attach");
        List stringArrayListExtra2 = getIntent().getStringArrayListExtra("mail_attach_title");
        d bV = w.bkZ().puI.bV(this.pwB, this.ptM);
        this.pwy = new b(this, this.pwr, this.pws, this.pwt, (byte) 0);
        if (!bi.oN(stringExtra)) {
            x.i("MicroMsg.ComposeUI", "read mail from extra");
            if (this.mode == 6) {
                bll();
                this.pwg.requestFocus();
                this.pwL = String.format(this.pwK, new Object[]{stringExtra});
                this.pww.loadDataWithBaseURL("", this.pwL, "text/html", ProtocolPackage.ServerEncoding, "");
                this.pwv.setVisibility(8);
                this.pww.setVisibility(0);
            } else if (this.mode == 5) {
                this.pwv.setVisibility(0);
                this.pww.setVisibility(8);
                if (stringExtra.indexOf("<div>") != -1) {
                    x.i("MicroMsg.ComposeUI", "set content in html format");
                    this.pwv.setText(Html.fromHtml(stringExtra));
                } else {
                    this.pwv.setText(stringExtra);
                }
            }
            this.pwy.mode = this.mode;
            if (this.mode == 6) {
                int i = 0;
                for (String str2 : stringArrayListExtra) {
                    File file = new File(str2);
                    if (file.exists()) {
                        if (((int) file.length()) + this.pwy.bly() > 52428800) {
                            h.a((Context) this, R.l.eBc, R.l.dGZ, null);
                            break;
                        }
                        x.i("MicroMsg.ComposeUI", "in upload file mode = %d", Integer.valueOf(this.mode));
                        int i2 = i + 1;
                        this.pwy.dP(str2, (String) stringArrayListExtra2.get(i));
                        i = i2;
                    }
                }
            }
        } else if (bV == null || this.mode != 6) {
            x.i("MicroMsg.ComposeUI", "no extra or draf mail content");
            if (this.mode == 6) {
                bll();
                this.pwg.requestFocus();
                this.pwL = String.format(this.pwK, new Object[]{""});
                this.pww.loadDataWithBaseURL("", this.pwL, "text/html", ProtocolPackage.ServerEncoding, "");
                this.pwv.setVisibility(8);
                this.pww.setVisibility(0);
            } else if (this.mode == 5) {
                this.pww.setVisibility(8);
                this.pwv.setVisibility(0);
            }
            this.pwy.mode = this.mode;
        } else {
            x.i("MicroMsg.ComposeUI", "read mail from draftMail");
            this.pwg.bu(bV.ptO);
            this.pwk.bu(bV.ptP);
            this.pwn.bu(bV.ptQ);
            this.pwp.setText(bV.ptS);
            charSequence = bV.content;
            this.mode = 5;
            if (charSequence.indexOf("<div>") != -1) {
                x.i("MicroMsg.ComposeUI", "set content in html format");
                this.pwv.setText(Html.fromHtml(charSequence));
            } else {
                this.pwv.setText(charSequence);
            }
            this.pwy.mode = this.mode;
            this.pwy.bt(bV.ptR);
            this.pwy.blx();
            this.pww.setVisibility(8);
            this.pwv.setVisibility(0);
        }
        String[] stringArrayExtra;
        if (this.ptM != 1) {
            stringArrayExtra = getIntent().getStringArrayExtra("toList");
            String[] stringArrayExtra2 = getIntent().getStringArrayExtra("ccList");
            String[] stringArrayExtra3 = getIntent().getStringArrayExtra("bccList");
            String stringExtra2 = getIntent().getStringExtra("subject");
            this.pwg.a(stringArrayExtra, false);
            this.pwk.a(stringArrayExtra2, false);
            this.pwn.a(stringArrayExtra3, false);
            if (!bi.oN(stringExtra2)) {
                EditText editText = this.pwp;
                StringBuilder stringBuilder = new StringBuilder();
                if (this.ptM == 2) {
                    str2 = "Re:";
                } else {
                    str2 = "Fwd:";
                }
                editText.setText(stringBuilder.append(str2).append(stringExtra2).toString());
            }
        } else if (this.ptM == 2 || this.ptM == 3) {
            this.pwu.setVisibility(0);
        } else if (this.ptM == 4) {
            stringArrayExtra = getIntent().getStringArrayExtra("toList");
            if (stringArrayExtra != null && stringArrayExtra.length > 0) {
                this.pwg.a(stringArrayExtra, false);
            }
        } else if (this.ptM == 1) {
            charSequence = getIntent().getStringExtra("subject");
            if (!bi.oN(charSequence)) {
                this.pwp.setText(charSequence);
            }
        }
        if (this.pwk.pyD.size() > 0 || this.pwn.pyD.size() > 0) {
            this.pwi.setVisibility(8);
            this.pwj.setVisibility(0);
            this.pwm.setVisibility(0);
        }
        if (this.ptM == 2 && this.mode != 6 && this.mode == 5) {
            this.pwv.requestFocus();
            this.pwv.setSelection(0);
            this.pwf.postDelayed(new Runnable() {
                public final void run() {
                    ComposeUI.this.pwf.fullScroll(130);
                }
            }, 1000);
        }
        this.pwg.pyG = new c(this.pwh, 0);
        this.pwk.pyG = new c(this.pwl, 1);
        this.pwn.pyG = new c(this.pwo, 2);
        com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.a anonymousClass19 = new com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.a() {
            public final void b(final MailAddrsViewControl mailAddrsViewControl) {
                h.a(ComposeUI.this.mController.xRr, ComposeUI.this.getString(R.l.eAR), "", new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        mailAddrsViewControl.pyE.setText("");
                        ComposeUI.this.pwS.postDelayed(new Runnable() {
                            public final void run() {
                                ComposeUI.this.blk();
                                mailAddrsViewControl.requestFocus();
                                ComposeUI.this.showVKB();
                            }
                        }, 150);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ComposeUI.this.pwS.postDelayed(new Runnable() {
                            public final void run() {
                                ComposeUI.this.blk();
                                mailAddrsViewControl.requestFocus();
                                ComposeUI.this.showVKB();
                            }
                        }, 150);
                    }
                });
            }

            public final void blp() {
                u.a(ComposeUI.this, ComposeUI.this.getString(R.l.eAR), 1500);
            }
        };
        this.pwg.pyI = anonymousClass19;
        this.pwk.pyI = anonymousClass19;
        this.pwn.pyI = anonymousClass19;
        this.pwh.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent(ComposeUI.this, MailAddrListUI.class);
                intent.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.this.pwg.a(false, null));
                intent.putExtra(com.tencent.mm.ui.u.FLAG_OVERRIDE_EXIT_ANIMATION, R.a.bqm);
                intent.putExtra(com.tencent.mm.ui.u.FLAG_OVERRIDE_ENTER_ANIMATION, R.a.bpZ);
                ComposeUI.this.startActivityForResult(intent, 0);
                ComposeUI.this.overridePendingTransition(R.a.bqo, R.a.bqa);
            }
        });
        this.pwl.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent(ComposeUI.this, MailAddrListUI.class);
                intent.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.this.pwk.a(false, null));
                intent.putExtra(com.tencent.mm.ui.u.FLAG_OVERRIDE_EXIT_ANIMATION, R.a.bqm);
                intent.putExtra(com.tencent.mm.ui.u.FLAG_OVERRIDE_ENTER_ANIMATION, R.a.bpZ);
                ComposeUI.this.startActivityForResult(intent, 1);
                ComposeUI.this.overridePendingTransition(R.a.bqo, R.a.bqa);
            }
        });
        this.pwo.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent(ComposeUI.this, MailAddrListUI.class);
                intent.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.this.pwn.a(false, null));
                intent.putExtra(com.tencent.mm.ui.u.FLAG_OVERRIDE_EXIT_ANIMATION, R.a.bqm);
                intent.putExtra(com.tencent.mm.ui.u.FLAG_OVERRIDE_ENTER_ANIMATION, R.a.bpZ);
                ComposeUI.this.startActivityForResult(intent, 2);
                ComposeUI.this.overridePendingTransition(R.a.bqo, R.a.bqa);
            }
        });
        this.pwi.setOnClickListener(this.pwU);
        final ImageView imageView = (ImageView) findViewById(R.h.cFa);
        if (this.pwE && this.pwp.getText().length() > 0) {
            imageView.setVisibility(0);
        }
        this.pwp.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    ComposeUI.this.pwp.setSelection(ComposeUI.this.pwp.getText().length());
                }
            }
        });
        this.pwp.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                int i4 = 4;
                if (ComposeUI.this.pwE) {
                    ImageView imageView = imageView;
                    if (ComposeUI.this.pwp.getText().length() > 0) {
                        i4 = 0;
                    }
                    imageView.setVisibility(i4);
                    return;
                }
                imageView.setVisibility(4);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        imageView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ComposeUI.this.pwp.getText().clear();
                ComposeUI.this.pwp.requestFocus();
            }
        });
        this.pwq.setOnClickListener(this.pwV);
        setMMTitle(R.l.eAM);
        if (getIntent().getBooleanExtra("show_qqmail", false)) {
            as.Hm();
            int intValue = ((Integer) com.tencent.mm.y.c.Db().get(9, Integer.valueOf(0))).intValue();
            if (intValue == 0) {
                x.w("MicroMsg.ComposeUI", "want to show qqmail address, but unbind qq");
            } else {
                setMMSubTitle(new o(intValue) + "@qq.com");
            }
        }
        setBackBtn(this.pwW);
        if (this.mode == 5) {
            addTextOptionMenu(0, getString(R.l.dGL), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    ComposeUI.this.pwX.onClick(null);
                    return false;
                }
            });
        } else if (this.mode == 6) {
            x.i("MicroMsg.ComposeUI", "set onShareModeSendListener");
            addTextOptionMenu(0, getString(R.l.dGL), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    ComposeUI.this.pwY.onClick(null);
                    return false;
                }
            });
        }
        enableOptionMenu(false);
        blk();
    }

    private void bll() {
        if (this.pww != null) {
            this.pww.clearFocus();
            this.pww.getSettings().setJavaScriptEnabled(true);
            this.pww.setWebViewClient(new b());
            this.pww.setWebChromeClient(new a());
            this.pww.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case 0:
                        case 1:
                            if (!view.hasFocus()) {
                                view.requestFocus();
                                break;
                            }
                            break;
                    }
                    return false;
                }
            });
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        this.pwW.onMenuItemClick(null);
        return true;
    }

    private void asx() {
        if (!k.c((Activity) this, com.tencent.mm.compatible.util.e.gJf, "microMsg." + System.currentTimeMillis() + ".jpg", 3)) {
            Toast.makeText(this, getString(R.l.eJI), 1).show();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.ComposeUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    asx();
                    return;
                } else {
                    h.a((Context) this, getString(R.l.ezZ), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            ComposeUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
            default:
                return;
        }
    }

    private String blm() {
        if (this.mode == 6) {
            s.a(this.pww, this.pwN, this.pwH);
            if (this.pwL != null) {
                int indexOf = this.pwL.indexOf(this.pwI);
                int lastIndexOf = this.pwL.lastIndexOf(this.pwJ);
                if (indexOf == -1 || lastIndexOf == -1) {
                    return this.pwL;
                }
                return this.pwL.substring(indexOf + this.pwI.length(), lastIndexOf + this.pwJ.length());
            }
        } else if (this.mode == 5) {
            return this.pwv.getText().toString();
        }
        return null;
    }

    private String getSubject() {
        int i = 40;
        String obj = this.pwp.getText().toString();
        if (obj.trim().length() > 0) {
            return obj;
        }
        obj = blm();
        if (this.mode == 5) {
            if (obj.length() > 0) {
                if (obj.length() <= 40) {
                    i = obj.length();
                }
                return obj.substring(0, i);
            }
        } else if (this.mode == 6 && !bi.oN(obj)) {
            if (obj.length() <= 40) {
                i = obj.length();
            }
            return obj.substring(0, i);
        }
        return getString(R.l.eAK);
    }

    protected final boolean bln() {
        if (!this.pwg.blF()) {
            Toast.makeText(this, R.l.eAN, 1).show();
            return false;
        } else if (!this.pwk.blF()) {
            Toast.makeText(this, R.l.eAI, 1).show();
            return false;
        } else if (!this.pwn.blF()) {
            Toast.makeText(this, R.l.eAH, 1).show();
            return false;
        } else if ((this.pwg.pyD.size() + this.pwk.pyD.size()) + this.pwn.pyD.size() <= 20) {
            return true;
        } else {
            Toast.makeText(this, R.l.eAT, 1).show();
            return false;
        }
    }

    static void bs(List<i> list) {
        pwe = list;
    }

    private static void a(MailAddrsViewControl mailAddrsViewControl) {
        if (pwe != null) {
            List list = pwe;
            if (list != null) {
                int i;
                i iVar;
                int i2;
                for (i = 0; i < mailAddrsViewControl.pyD.size(); i++) {
                    iVar = (i) mailAddrsViewControl.pyD.get(i);
                    i2 = 0;
                    while (i2 < list.size()) {
                        if (iVar.nWa.equalsIgnoreCase(((i) list.get(i2)).nWa)) {
                            break;
                        }
                        i2++;
                    }
                    if (i2 == list.size()) {
                        mailAddrsViewControl.f(iVar);
                    }
                }
                for (i = 0; i < list.size(); i++) {
                    iVar = (i) list.get(i);
                    i2 = 0;
                    while (i2 < mailAddrsViewControl.pyD.size()) {
                        if (iVar.nWa.equalsIgnoreCase(((i) mailAddrsViewControl.pyD.get(i2)).nWa)) {
                            break;
                        }
                        i2++;
                    }
                    if (i2 == mailAddrsViewControl.pyD.size()) {
                        mailAddrsViewControl.e(iVar);
                    }
                }
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            String b;
            switch (i) {
                case 0:
                    a(this.pwg);
                    showVKB();
                    return;
                case 1:
                    a(this.pwk);
                    showVKB();
                    return;
                case 2:
                    a(this.pwn);
                    showVKB();
                    return;
                case 3:
                    as.Hm();
                    b = k.b(this, intent, com.tencent.mm.y.c.Fp());
                    if (b != null) {
                        Iu(b);
                        blk();
                        return;
                    }
                    return;
                case 4:
                    if (intent != null) {
                        as.Hm();
                        b = com.tencent.mm.ui.tools.a.c(this, intent, com.tencent.mm.y.c.Fp());
                        if (b != null && b.length() > 0) {
                            Iu(b);
                            blk();
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (intent != null) {
                        Iu(intent.getStringExtra("choosed_file_path"));
                        blk();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void Iu(final String str) {
        final File file = new File(str);
        if (!file.exists()) {
            return;
        }
        if (this.pwy.pxV.containsKey(str)) {
            h.h(this.mController.xRr, R.l.eBa, R.l.dGZ);
            return;
        }
        final int length = (int) file.length();
        if (length > 20971520) {
            h.a((Context) this, R.l.eBb, R.l.dGZ, null);
            return;
        }
        h.a((Context) this, getString(R.l.eBd, new Object[]{bi.by((long) length)}), getString(R.l.dGZ), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (ComposeUI.this.pwy.bly() + length > 52428800) {
                    h.a(ComposeUI.this, R.l.eBc, R.l.dGZ, null);
                    return;
                }
                if (ComposeUI.this.pwp.getText().toString().trim().length() == 0) {
                    String trim = file.getName().trim();
                    int lastIndexOf = trim.lastIndexOf(".");
                    EditText j = ComposeUI.this.pwp;
                    if (lastIndexOf <= 0) {
                        lastIndexOf = trim.length();
                    }
                    j.setText(trim.substring(0, lastIndexOf));
                }
                x.i("MicroMsg.ComposeUI", "in upload file mode = %d", Integer.valueOf(ComposeUI.this.mode));
                ComposeUI.this.pwy.dP(str, null);
            }
        }, null);
    }

    public void setRequestedOrientation(int i) {
    }
}
