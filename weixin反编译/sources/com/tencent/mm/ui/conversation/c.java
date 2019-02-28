package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.os.Build.VERSION;
import android.widget.ListView;
import com.tencent.mm.f.a.ba;
import com.tencent.mm.f.a.jh;
import com.tencent.mm.f.a.mz;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.f.b.ak;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.w;
import com.tencent.mm.y.as;
import com.tencent.mm.y.s;
import java.util.HashMap;
import java.util.Map.Entry;

public final class c {
    Activity activity;
    ListView zeU;
    com.tencent.mm.sdk.b.c zfA = new com.tencent.mm.sdk.b.c<mz>() {
        {
            this.xmG = mz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (c.this.zfz != null) {
                ah.y(new Runnable() {
                    public final void run() {
                        x.d("MicroMsg.ConvUnreadHelper", "refresh main ui unread count.");
                        c.this.zfz.notifyDataSetChanged();
                        c.this.cxh();
                    }
                });
            }
            return true;
        }
    };
    com.tencent.mm.sdk.b.c zfB = new com.tencent.mm.sdk.b.c<ba>() {
        {
            this.xmG = ba.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (((ba) bVar).fqb.fqc != c.this.zfy) {
                x.i("MicroMsg.ConvUnreadHelper", "unreadcheck wrong should be %d, but is %d", Integer.valueOf(((ba) bVar).fqb.fqc), Integer.valueOf(c.this.zfy));
                c.this.zfy = -1;
            }
            return true;
        }
    };
    com.tencent.mm.sdk.b.c zfC = new com.tencent.mm.sdk.b.c<jh>() {
        private final long INTERVAL;
        long zfF;
        int zfG;

        {
            this.INTERVAL = 3000;
            this.zfF = 0;
            this.zfG = -1;
            this.xmG = jh.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (c.this.activity != null) {
                x.d("MicroMsg.ConvUnreadHelper", "trigger double tab");
                c.this.zeU.postDelayed(new Runnable() {
                    public final void run() {
                        int firstVisiblePosition;
                        int i;
                        int i2;
                        int abs;
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - AnonymousClass3.this.zfF >= 3000 || AnonymousClass3.this.zfG < 0) {
                            firstVisiblePosition = (c.this.zeU.getFirstVisiblePosition() - c.this.zeU.getHeaderViewsCount()) + 1;
                            if (firstVisiblePosition < 0) {
                                i = 0;
                            } else {
                                i = firstVisiblePosition;
                            }
                        } else {
                            i = AnonymousClass3.this.zfG;
                        }
                        g gVar = c.this.zfz;
                        if (c.this.zfy > 0) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        int count = gVar.getCount();
                        if (count > 0) {
                            for (abs = Math.abs((i + 1) % count); abs != i; abs = (abs + 1) % count) {
                                ae aeVar = (ae) gVar.DV(abs);
                                if (aeVar != null && aeVar.field_unReadCount > 0) {
                                    if (i2 == 0) {
                                        i2 = abs;
                                        break;
                                    } else if (g.a(aeVar, gVar.i(aeVar)) == 2) {
                                        i2 = abs;
                                        break;
                                    }
                                }
                            }
                        }
                        i2 = -1;
                        if (i2 < 0) {
                            com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c.a(c.this.zeU);
                        } else {
                            ListView listView = c.this.zeU;
                            abs = c.this.zeU.getHeaderViewsCount() + i2;
                            if (listView != null) {
                                if (VERSION.SDK_INT >= 11) {
                                    bc bcVar = new bc();
                                    int firstVisiblePosition2 = listView.getFirstVisiblePosition();
                                    if (firstVisiblePosition2 < abs && firstVisiblePosition2 + 10 < abs) {
                                        listView.setSelectionFromTop(abs - 10, 0);
                                    } else if (firstVisiblePosition2 > abs && firstVisiblePosition2 - 10 > abs) {
                                        listView.setSelectionFromTop(abs + 10, 0);
                                    }
                                    if (VERSION.SDK_INT >= 11) {
                                        listView.smoothScrollToPositionFromTop(abs, 0);
                                    }
                                } else {
                                    bb bbVar = new bb();
                                    listView.setSelectionFromTop(abs, 0);
                                }
                            }
                        }
                        AnonymousClass3.this.zfF = currentTimeMillis;
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        if (i2 < 0) {
                            firstVisiblePosition = 0;
                        } else {
                            firstVisiblePosition = i2;
                        }
                        anonymousClass3.zfG = firstVisiblePosition;
                        x.d("MicroMsg.ConvUnreadHelper", "headerCount %d, scroll from %d to %d", Integer.valueOf(c.this.zeU.getHeaderViewsCount()), Integer.valueOf(i), Integer.valueOf(i2));
                    }
                }, 100);
            }
            return false;
        }
    };
    HashMap<String, Integer> zfw = new HashMap();
    int zfx = -1;
    public int zfy = -1;
    g zfz;

    public final void aa(Activity activity) {
        this.zfy = ((LauncherUI) activity).xPu.xOK.cob();
    }

    public final void cxh() {
        if (this.activity != null) {
            long currentTimeMillis = System.currentTimeMillis();
            LauncherUI launcherUI = (LauncherUI) this.activity;
            x.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  resetStatus %d", Integer.valueOf(this.zfx));
            switch (this.zfx) {
                case 1:
                    return;
                case 2:
                    int i = 0;
                    for (Entry entry : this.zfw.entrySet()) {
                        int i2;
                        String str = (String) entry.getKey();
                        int intValue = ((Integer) entry.getValue()).intValue();
                        x.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  username %s, preunread %d", str, Integer.valueOf(intValue));
                        ak aam = aam(str);
                        if (aam == null || af.cou().contains(str)) {
                            x.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  cov == null username %s, change %d", str, Integer.valueOf(0 - intValue));
                            i2 = intValue;
                        } else {
                            x.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  cov != null username %s, change %d", str, Integer.valueOf((aam.field_unReadCount - intValue) + 0));
                            i2 = intValue;
                        }
                        if (i2 != 0 && this.zfz.aan(str)) {
                            x.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  username %s isWithoutItemCache", str);
                            as.Hm();
                            ag Xv = com.tencent.mm.y.c.Ff().Xv(str);
                            if (Xv != null) {
                                if (s.eX(str)) {
                                    if (Xv.fXi == 0) {
                                    }
                                } else if (Xv.AP()) {
                                }
                            }
                        }
                        x.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  real change usename %s, change %d, totalchange %d", str, Integer.valueOf(i2), Integer.valueOf(i + i2));
                        i = intValue;
                    }
                    this.zfy += i;
                    w wVar = launcherUI.xPu.xOK;
                    wVar.xTc.Er(this.zfy);
                    x.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount UNREAD_RESET_PART totalUnReadCount %d, change %d, usetime %d,", Integer.valueOf(this.zfy), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    return;
                default:
                    this.zfy = launcherUI.xPu.xOK.cob();
                    x.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount UNREAD_RESET_ALL totalUnReadCount %d, usetime %d,", Integer.valueOf(this.zfy), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    return;
            }
        }
    }

    final ae aam(String str) {
        if (this.zfz != null) {
            return (ae) this.zfz.cf(str);
        }
        return null;
    }
}
