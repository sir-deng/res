package com.tencent.mm.plugin.game.gamewebview.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.webkit.WebView;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.e.b;
import com.tencent.mm.plugin.game.gamewebview.ipc.CommonActivityTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.CommonLogicTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.model.QBarLogicTask;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.plugin.webview.modeltools.g.c;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.l;
import com.tencent.xweb.WebView.a;

public final class h implements OnCreateContextMenuListener {
    private MMActivity isO;
    public l jAo;
    String jAp;
    public int jAq;
    public int jAr;
    public g jAs;
    a jAt;
    a jAu;
    private c jAy = new c() {
        public final void ty(String str) {
            GWMainProcessTask qBarLogicTask = new QBarLogicTask();
            qBarLogicTask.type = 1;
            qBarLogicTask.fAn = str;
            GameWebViewMainProcessService.a(qBarLogicTask);
        }
    };
    private e neF;
    private b new;

    /* renamed from: com.tencent.mm.plugin.game.gamewebview.ui.h$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ String jAA;

        public AnonymousClass3(String str) {
            this.jAA = str;
        }

        public final void run() {
            if (h.this.new != null) {
                h.this.jAp = this.jAA;
                h.this.jAo.b(h.this.new, new OnCreateContextMenuListener() {
                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        if (h.this.jAt != null) {
                            x.d("MicroMsg.GameWebViewMenuListHelper", "show webkit menu");
                            h.this.b(contextMenu, h.this.jAt);
                            h.this.jAt = null;
                        } else if (h.this.jAu != null) {
                            x.d("MicroMsg.GameWebViewMenuListHelper", "show IX5 menu");
                            h.this.a(contextMenu, h.this.jAu);
                            h.this.jAu = null;
                        }
                    }
                }, null);
                h.this.jAo.bCH();
            }
        }
    }

    static /* synthetic */ void a(h hVar, String str) {
        CommonActivityTask commonActivityTask = new CommonActivityTask(hVar.isO);
        commonActivityTask.type = 2;
        commonActivityTask.mym.putString("img_path", str);
        commonActivityTask.aLl();
    }

    static /* synthetic */ void b(h hVar, String str) {
        GWMainProcessTask commonLogicTask = new CommonLogicTask();
        commonLogicTask.type = 7;
        commonLogicTask.mym.putString("image_path", str);
        GameWebViewMainProcessService.b(commonLogicTask);
        com.tencent.mm.pluginsdk.model.c.a(commonLogicTask.mym.getInt("fav_simple_img_result"), 34, hVar.isO, i.nfQ);
    }

    static /* synthetic */ String c(h hVar) {
        return hVar.new != null ? hVar.new.getUrl() : "";
    }

    public h(MMActivity mMActivity, b bVar, e eVar) {
        this.isO = mMActivity;
        this.new = bVar;
        this.neF = eVar;
        this.jAo = new l(mMActivity);
        this.jAo.a(this.new, this, null);
        this.jAo.e(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (h.this.jAs != null) {
                    GWMainProcessTask qBarLogicTask = new QBarLogicTask();
                    qBarLogicTask.type = 1;
                    qBarLogicTask.fAn = h.this.jAs.tBB;
                    GameWebViewMainProcessService.a(qBarLogicTask);
                    h.this.jAs.bSt();
                }
            }
        });
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        x.d("MicroMsg.GameWebViewMenuListHelper", "onCreateContextMenu");
        a hitTestResult;
        if (view instanceof WebView) {
            hitTestResult = this.new.getHitTestResult();
            if (hitTestResult != null) {
                if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                    b(contextMenu, hitTestResult);
                    return;
                }
                return;
            }
            return;
        }
        hitTestResult = this.new.getHitTestResult();
        if (hitTestResult == null) {
            return;
        }
        if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
            a(contextMenu, hitTestResult);
        }
    }

    private boolean a(ContextMenu contextMenu, final String str) {
        if (f.zl()) {
            boolean aPk = d.aPk();
            contextMenu.setHeaderTitle(R.l.eYG);
            x.i("MicroMsg.GameWebViewMenuListHelper", "hasSetAcc = %b", Boolean.valueOf(aPk));
            if (aPk) {
                contextMenu.add(0, 0, 0, this.isO.getString(R.l.eBX)).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        s.a(h.this.isO, str, com.tencent.xweb.b.cJc().getCookie(str), f.zl(), new s.b() {
                            public final void tx(String str) {
                                if (bi.oN(str)) {
                                    x.w("MicroMsg.GameWebViewMenuListHelper", "share image to friend fail, imgPath is null");
                                } else {
                                    h.a(h.this, str);
                                }
                            }
                        });
                        return true;
                    }
                });
            }
            contextMenu.add(0, 0, 0, this.isO.getString(R.l.eHt)).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    try {
                        s.a(h.this.isO, str, com.tencent.xweb.b.cJc().getCookie(str), f.zl());
                    } catch (Exception e) {
                        x.e("MicroMsg.GameWebViewMenuListHelper", "save to sdcard failed : %s", e.getMessage());
                    }
                    return true;
                }
            });
            if (aPk) {
                contextMenu.add(0, 0, 0, this.isO.getString(R.l.eAq)).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        String replaceAll = str.replaceAll("tp=webp", "");
                        s.a(h.this.isO, replaceAll, com.tencent.xweb.b.cJc().getCookie(replaceAll), f.zl(), new s.b() {
                            public final void tx(String str) {
                                h.b(h.this, str);
                            }
                        });
                        return true;
                    }
                });
            }
            if (this.jAp == null) {
                return false;
            }
            CharSequence string;
            final String str2 = this.jAp;
            if (this.jAq == 22) {
                string = this.isO.getString(R.l.eCE);
            } else {
                string = this.isO.getString(R.l.eCD);
            }
            contextMenu.add(0, 0, 0, string).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    x.i("MicroMsg.GameWebViewMenuListHelper", "onMenuItemClick recognize qbcode");
                    CommonActivityTask commonActivityTask = new CommonActivityTask(h.this.isO);
                    commonActivityTask.type = 1;
                    commonActivityTask.mym.putString("result", str2);
                    commonActivityTask.mym.putString(SlookSmartClipMetaTag.TAG_TYPE_URL, h.c(h.this));
                    commonActivityTask.mym.putInt("codeType", h.this.jAq);
                    commonActivityTask.mym.putInt("codeVersion", h.this.jAr);
                    commonActivityTask.aLl();
                    return false;
                }
            });
            this.jAp = null;
            return true;
        }
        x.e("MicroMsg.GameWebViewMenuListHelper", "SD card unavailable");
        return true;
    }

    final void a(ContextMenu contextMenu, a aVar) {
        if (!a(contextMenu, aVar.mExtra) && this.neF.bTg().ceo() && aQi()) {
            this.jAu = aVar;
            this.jAs = new g();
            this.jAs.a(this.new, this.jAy);
        }
    }

    final void b(ContextMenu contextMenu, a aVar) {
        if (!a(contextMenu, aVar.mExtra) && this.neF.bTg().ceo() && aQi()) {
            this.jAt = aVar;
            this.jAs = new g();
            this.jAs.a(this.new, this.jAy);
        }
    }

    private static boolean aQi() {
        GWMainProcessTask commonLogicTask = new CommonLogicTask();
        commonLogicTask.type = 5;
        GameWebViewMainProcessService.b(commonLogicTask);
        return commonLogicTask.mym.getBoolean("allow_webview_scan", false);
    }
}
