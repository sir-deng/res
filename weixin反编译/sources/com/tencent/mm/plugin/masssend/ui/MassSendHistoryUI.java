package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.g.a;
import com.tencent.mm.ad.g.b;
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.g;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.o;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import junit.framework.Assert;

public class MassSendHistoryUI extends MMActivity implements a, b, SensorController.a {
    private static SensorController kIB;
    private com.tencent.mm.audio.a.a fhX;
    private boolean kIE = true;
    private View nQp;
    private ListView oti;
    private c otj;
    private Button otk;
    private Button otl;
    private MMPullDownView otm;
    private boolean otn = false;
    private LinearLayout oto;
    private d otp = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            if (menuItem.getItemId() == 1) {
                com.tencent.mm.plugin.masssend.a.a aVar = (com.tencent.mm.plugin.masssend.a.a) MassSendHistoryUI.this.otj.getItem(menuItem.getGroupId());
                if (aVar != null) {
                    if (aVar.aZb().equals(MassSendHistoryUI.this.otj.osX)) {
                        MassSendHistoryUI.this.stopPlay();
                    }
                    com.tencent.mm.plugin.masssend.a.b aZj = h.aZj();
                    String aZb = aVar.aZb();
                    Cursor a = aZj.hiZ.a("select * from massendinfo ORDER BY createtime DESC  limit 2", null, 0);
                    if (a != null) {
                        com.tencent.mm.plugin.masssend.a.a aVar2;
                        ae aeVar;
                        if (a.getCount() == 0) {
                            a.close();
                        } else if (a.getCount() == 1) {
                            a.moveToFirst();
                            aVar2 = new com.tencent.mm.plugin.masssend.a.a();
                            aVar2.b(a);
                            a.close();
                            aeVar = new ae();
                            aeVar.setUsername("masssendapp");
                            aeVar.setContent(ad.getContext().getResources().getString(R.l.dVM));
                            aeVar.aj(aVar2.hXs);
                            aeVar.eS(0);
                            aeVar.eP(0);
                            as.Hm();
                            c.Fk().a(aeVar, "masssendapp");
                        } else {
                            a.moveToPosition(1);
                            aVar2 = new com.tencent.mm.plugin.masssend.a.a();
                            aVar2.b(a);
                            a.close();
                            aeVar = new ae();
                            aeVar.setUsername("masssendapp");
                            aeVar.setContent(com.tencent.mm.plugin.masssend.a.b.a(aVar2));
                            aeVar.aj(aVar2.hXs);
                            aeVar.eS(0);
                            aeVar.eP(0);
                            as.Hm();
                            c.Fk().a(aeVar, "masssendapp");
                        }
                    }
                    if (aZj.hiZ.delete("massendinfo", "clientid= ?", new String[]{aZb}) > 0) {
                        aZj.doNotify();
                    }
                }
            }
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.euW);
        if (kIB == null) {
            kIB = new SensorController(getApplicationContext());
        }
        initView();
        this.fhX = new com.tencent.mm.audio.a.a(this);
        this.fhX.fjW = this;
        this.fhX.fjV = this;
        this.otj.osY = new e() {
            public final String EO(String str) {
                as.Hm();
                if (c.isSDCardAvailable()) {
                    String oM = bi.oM(str);
                    if (!MassSendHistoryUI.this.fhX.isPlaying() || !oM.equals(MassSendHistoryUI.this.otj.osX)) {
                        return !MassSendHistoryUI.this.EP(oM) ? "" : oM;
                    } else {
                        MassSendHistoryUI.kIB.cgS();
                        MassSendHistoryUI.this.releaseWakeLock();
                        MassSendHistoryUI.this.fhX.aN(false);
                        return "";
                    }
                }
                u.fJ(MassSendHistoryUI.this);
                return "";
            }
        };
        if (this.mController != null) {
            this.mController.ae(3, false);
        }
    }

    protected void onResume() {
        super.onResume();
        h.aZj().c(this.otj);
        this.otj.a(null, null);
        this.oti.setSelection(this.otj.getCount() - 1);
    }

    protected void onPause() {
        super.onPause();
        as.Hn().yc();
        h.aZj().j(this.otj);
        kIB.cgS();
    }

    protected void onDestroy() {
        this.otj.aUU();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dnf;
    }

    protected final void initView() {
        this.otn = getIntent().getBooleanExtra("finish_direct", false);
        x.d("MicroMsg.MassSendHistoryUI", "isFromSearch  " + this.otn);
        this.oto = (LinearLayout) findViewById(R.h.cvv);
        this.oti = (ListView) findViewById(R.h.cvf);
        this.oti.setTranscriptMode(0);
        this.otm = (MMPullDownView) findViewById(R.h.cvg);
        this.otm.ykU = new g() {
            public final boolean azU() {
                int i = 0;
                if (MassSendHistoryUI.this.otj.awL()) {
                    MassSendHistoryUI.this.oti.setSelectionFromTop(0, MassSendHistoryUI.this.otm.ykW);
                } else {
                    c b = MassSendHistoryUI.this.otj;
                    if (!b.awL()) {
                        b.las += 10;
                        if (b.las <= b.hLP) {
                            i = 10;
                        } else {
                            b.las = b.hLP;
                            i = b.hLP % 10;
                        }
                    }
                    x.v("MicroMsg.MassSendHistoryUI", "onLoadData add count:" + i);
                    MassSendHistoryUI.this.otj.a(null, null);
                    MassSendHistoryUI.this.oti.setSelectionFromTop(i, MassSendHistoryUI.this.otm.ykW);
                }
                return true;
            }
        };
        this.otm.mw(true);
        this.otm.ylg = new MMPullDownView.c() {
            public final boolean azT() {
                if (MassSendHistoryUI.this.oti.getChildAt(MassSendHistoryUI.this.oti.getChildCount() - 1).getBottom() > MassSendHistoryUI.this.oti.getHeight() || MassSendHistoryUI.this.oti.getLastVisiblePosition() != MassSendHistoryUI.this.oti.getAdapter().getCount() - 1) {
                    return false;
                }
                return true;
            }
        };
        this.otm.ylh = new MMPullDownView.d() {
            public final boolean azS() {
                View childAt = MassSendHistoryUI.this.oti.getChildAt(MassSendHistoryUI.this.oti.getFirstVisiblePosition());
                if (childAt == null || childAt.getTop() != 0) {
                    return false;
                }
                return true;
            }
        };
        this.otm.mu(true);
        this.otj = new c(this);
        this.otj.xQN = new o.a() {
            public final void XE() {
                MassSendHistoryUI.this.otm.mt(MassSendHistoryUI.this.otj.awL());
                if (MassSendHistoryUI.this.otj.getCount() == 0) {
                    MassSendHistoryUI.this.otm.setVisibility(8);
                    MassSendHistoryUI.this.nQp.setVisibility(0);
                    MassSendHistoryUI.this.oto.setVisibility(8);
                    return;
                }
                MassSendHistoryUI.this.otm.setVisibility(0);
                MassSendHistoryUI.this.nQp.setVisibility(8);
                MassSendHistoryUI.this.oto.setVisibility(0);
            }

            public final void XF() {
            }
        };
        this.nQp = findViewById(R.h.cve);
        this.oti.setAdapter(this.otj);
        this.oti.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                x.v("MicroMsg.MassSendHistoryUI", "onItemClick");
            }
        });
        this.oti.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                x.v("MicroMsg.MassSendHistoryUI", "onTouch");
                return false;
            }
        });
        this.otk = (Button) findViewById(R.h.cvu);
        this.otk.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                MassSendHistoryUI.this.startActivity(new Intent(MassSendHistoryUI.this, MassSendSelectContactUI.class));
            }
        });
        this.otl = (Button) findViewById(R.h.cvw);
        this.otl.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                MassSendHistoryUI.this.startActivity(new Intent(MassSendHistoryUI.this, MassSendSelectContactUI.class));
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (MassSendHistoryUI.this.otn) {
                    MassSendHistoryUI.this.finish();
                } else {
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    com.tencent.mm.plugin.masssend.a.ihN.s(intent, MassSendHistoryUI.this);
                    MassSendHistoryUI.this.finish();
                }
                return true;
            }
        });
        addIconOptionMenu(0, R.l.dGO, R.k.dvn, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", "masssendapp");
                com.tencent.mm.plugin.masssend.a.ihN.d(intent, MassSendHistoryUI.this);
                return true;
            }
        });
        new l(this).a(this.oti, this, this.otp);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.otn) {
            finish();
        } else {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            com.tencent.mm.plugin.masssend.a.ihN.s(intent, this);
            finish();
        }
        return true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        x.v("MicroMsg.MassSendHistoryUI", "onCreateContextMenu");
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        String[] split = ((com.tencent.mm.plugin.masssend.a.a) this.otj.getItem(adapterContextMenuInfo.position)).aZe().split(";");
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : split) {
            as.Hm();
            com.tencent.mm.storage.x Xv = c.Ff().Xv(str);
            if (Xv != null) {
                stringBuilder.append(Xv.AX() + ";");
            }
        }
        contextMenu.setHeaderTitle(stringBuilder.toString());
        contextMenu.add(adapterContextMenuInfo.position, 1, 0, getString(R.l.dRS));
    }

    protected final void releaseWakeLock() {
        this.oti.setKeepScreenOn(false);
    }

    public final void dX(boolean z) {
        if (this.fhX != null) {
            if (this.fhX.isPlaying()) {
                this.fhX.aO(z);
                as.Hn().h(z, false);
                this.kIE = z;
                if (!z) {
                    if (EP(this.otj.osX)) {
                        this.otj.EN(this.otj.osX);
                        return;
                    } else {
                        this.otj.EN("");
                        return;
                    }
                }
                return;
            }
            this.fhX.aO(true);
            as.Hn().h(true, false);
            this.kIE = true;
        }
    }

    private boolean EP(String str) {
        Assert.assertTrue(str != null);
        kIB.a(this);
        com.tencent.mm.plugin.masssend.a.a EK = h.aZj().EK(str);
        as.Hm();
        if (c.isSDCardAvailable() || bi.oN(EK.aZc())) {
            if (this.fhX == null) {
                this.fhX = new com.tencent.mm.audio.a.a(this);
            }
            this.fhX.aN(false);
            if (this.fhX.k(EK.aZc(), this.kIE)) {
                as.Hn().h(this.kIE, false);
                this.fhX.fjW = this;
                this.fhX.fjV = this;
                return true;
            }
            Toast.makeText(this, getString(R.l.dSM), 0).show();
            return false;
        }
        u.fJ(this);
        return false;
    }

    private void stopPlay() {
        kIB.cgS();
        this.fhX.aN(false);
        this.otj.EN("");
        releaseWakeLock();
    }

    public final void vi() {
        stopPlay();
    }

    public final void onError() {
        stopPlay();
    }
}
