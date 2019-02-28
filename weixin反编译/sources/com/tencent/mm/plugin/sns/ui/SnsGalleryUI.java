package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.t.a;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.y.q;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.List;

public class SnsGalleryUI extends SnsBaseGalleryUI implements a {
    private int rFd = 0;
    private String userName = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(FileUtils.S_IWUSR);
        initView();
    }

    public void onDestroy() {
        int max;
        if (this.rFb != null) {
            this.rFb.bBI();
            this.rFb.onDestroy();
        }
        getWindow().clearFlags(FileUtils.S_IWUSR);
        al.a bvV = ae.bvV();
        String str = this.userName;
        if (bvV.rdn.containsKey(str)) {
            max = Math.max(((Integer) bvV.rdn.get(str)).intValue() - 1, 0);
            bvV.rdn.put(str, Integer.valueOf(max));
        } else {
            max = 0;
        }
        if (max <= 0) {
            bvV.rdm.remove(str);
        }
        ae.bwc().K(this);
        super.onDestroy();
    }

    protected void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        if (this.rFb != null) {
            this.rFb.aHX();
        }
    }

    protected final int getLayoutId() {
        return g.qNr;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        x.d("MicroMsg.SnsGalleryUI", "dispatchKeyEvent");
        Intent intent = new Intent();
        intent.putExtra("sns_cmd_list", this.rEY.rzl);
        setResult(-1, intent);
        finish();
        return true;
    }

    protected final void initView() {
        List arrayList;
        an cjF;
        this.userName = getIntent().getStringExtra("sns_gallery_userName");
        int intExtra = getIntent().getIntExtra("sns_gallery_localId", 0);
        final boolean booleanExtra = getIntent().getBooleanExtra("sns_gallery_is_self", false);
        this.rFd = getIntent().getIntExtra("sns_gallery_position", 0);
        x.i("MicroMsg.SnsGalleryUI", "initView localId:%s, pos:%d", u.ag("sns_table_", (long) intExtra), Integer.valueOf(this.rFd));
        cl(r0, this.rFd);
        u(booleanExtra, 1);
        this.rFb = new SnsInfoFlip(this);
        this.rFb.ryD = true;
        al.a bvV = ae.bvV();
        String str = this.userName;
        if (bvV.rdn.containsKey(str)) {
            bvV.rdn.put(str, Integer.valueOf(((Integer) bvV.rdn.get(str)).intValue() + 1));
        } else {
            bvV.rdn.put(str, Integer.valueOf(0));
        }
        ArrayList arrayList2 = (ArrayList) bvV.rdm.get(str);
        if (arrayList2 == null) {
            arrayList = new ArrayList();
        } else {
            Object arrayList3 = arrayList2;
        }
        this.rFb.rId = true;
        this.rFb.rIf = true;
        this.rFb.rIg = false;
        this.rFb.a(arrayList3, this.userName, this.rFd, this.rEW, this);
        this.rFb.rIl = new Runnable() {
            public final void run() {
                SnsGalleryUI.this.rEY.bzZ();
            }
        };
        com.tencent.mm.kernel.g.Dr();
        ag Xv = ((h) com.tencent.mm.kernel.g.h(h.class)).Ff().Xv(this.userName);
        if (Xv == null || ((int) Xv.gKO) <= 0 || !com.tencent.mm.k.a.ga(Xv.field_type)) {
            if (this.userName.equals(q.FY())) {
                cjF = an.cjF();
            } else {
                cjF = an.cjG();
            }
        } else {
            cjF = an.cjE();
        }
        this.rFb.qWV = cjF;
        this.rFb.username = this.userName;
        addView(this.rFb);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SnsGalleryUI.this.rEY.bzZ();
                return true;
            }
        });
        addIconOptionMenu(0, e.bDJ, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                String str;
                b bVar;
                String str2;
                SnsInfoFlip snsInfoFlip = SnsGalleryUI.this.rFb;
                if (snsInfoFlip.rHX == null) {
                    str = "";
                } else {
                    bVar = (b) snsInfoFlip.rHX.getSelectedItem();
                    str = bVar == null ? "" : bVar.rgK;
                }
                snsInfoFlip = SnsGalleryUI.this.rFb;
                if (snsInfoFlip.rHX == null) {
                    str2 = null;
                } else {
                    bVar = (b) snsInfoFlip.rHX.getSelectedItem();
                    str2 = bVar == null ? null : bVar.fIx.nMq;
                }
                b bBG = SnsGalleryUI.this.rFb.bBG();
                x.d("MicroMsg.SnsGalleryUI", "click selectLocalId " + str);
                x.d("MicroMsg.SnsGalleryUI", "click position " + str2);
                m LR = ae.bwf().LR(str);
                try {
                    int i;
                    int i2 = SnsGalleryUI.this.rFb.rIo;
                    int size = LR.byF().wYj.wfh.size();
                    if (size <= 1 || i2 <= 1 || i2 > size) {
                        i = 0;
                    } else {
                        i = i2 - 1;
                    }
                    SnsGalleryUI.this.rEY.a(booleanExtra, LR, bBG.fIx, true, i);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SnsGalleryUI", e, "", new Object[0]);
                }
                return true;
            }
        });
    }

    public final void ck(String str, int i) {
        if (this.rFb != null) {
            if (!(bi.oN(str) || i == 3)) {
                SnsInfoFlip snsInfoFlip = this.rFb;
                if (snsInfoFlip.hkf != null) {
                    int i2 = 0;
                    while (i2 >= 0) {
                        int i3;
                        while (true) {
                            i3 = i2;
                            if (i3 >= snsInfoFlip.hkf.size()) {
                                i3 = -1;
                                break;
                            }
                            b bVar = (b) snsInfoFlip.hkf.get(i3);
                            if (!bi.oN(bVar.rgK) && bVar.rgK.equals(str)) {
                                snsInfoFlip.hkf.remove(i3);
                                break;
                            }
                            i2 = i3 + 1;
                        }
                        i2 = i3;
                    }
                    snsInfoFlip.rHW.notifyDataSetChanged();
                }
            }
            this.rFb.aHX();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.SnsGalleryUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            String str;
            if (2 == i) {
                if (-1 == i2) {
                    are are;
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    String stringExtra2 = intent.getStringExtra("custom_send_text");
                    if (this.rFb != null) {
                        b bBG = this.rFb.bBG();
                        if (bBG.fIx.kzz == 6) {
                            are = bBG.fIx;
                        } else {
                            return;
                        }
                    }
                    are = null;
                    if (are != null) {
                        String r = am.r(ae.getAccSnsPath(), are.nMq);
                        str = "";
                        String str2 = "";
                        String j = i.j(are);
                        if (FileOp.bO(r + j)) {
                            str2 = r + j;
                            str = r + i.e(are);
                        }
                        if (FileOp.bO(r + i.p(are))) {
                            j = r + i.p(are);
                            r = r + i.n(are);
                        } else {
                            j = str2;
                            r = str;
                        }
                        List<String> F = bi.F(stringExtra.split(","));
                        int Kx = i.Kx(j);
                        for (String str3 : F) {
                            x.i("MicroMsg.SnsGalleryUI", "send sight to %s, videopath %s, thumbpath %s duration %d", str3, j, r, Integer.valueOf(Kx));
                            f.aZN().a(this, str3, j, r, 62, Kx, "");
                            f.aZN().dq(stringExtra2, str3);
                        }
                        com.tencent.mm.ui.snackbar.a.h(this, getString(j.epo));
                    }
                }
            } else if (1 == i) {
                int intExtra = intent.getIntExtra("sns_gallery_op_id", 0);
                str = u.ag("sns_table_", (long) intent.getIntExtra("sns_gallery_op_id", 0));
                this.rEY.xJ(intExtra);
                ck(str, 1);
                if (intent.getBooleanExtra("sns_gallery_force_finish", false)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("sns_cmd_list", this.rEY.rzl);
                    setResult(-1, intent2);
                    finish();
                }
            }
        }
    }
}
