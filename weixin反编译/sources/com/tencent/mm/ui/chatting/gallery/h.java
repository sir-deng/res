package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.s.a;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.m;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.d;
import com.tencent.wcdb.FileUtils;
import java.util.HashMap;

public final class h extends a implements a, al.a, d.a {
    private d jwC;
    private HashMap<String, i.a> yNx;
    private boolean yNy;

    public h(b bVar) {
        super(bVar);
        this.yNy = false;
        this.yNy = false;
        this.yNx = new HashMap();
        o.Ub().a(this, Looper.getMainLooper());
        this.jwC = new d();
    }

    public final boolean a(j jVar, au auVar, int i) {
        super.a(jVar, auVar, i);
        o.Ub();
        Bitmap b = b.b(s.ny(auVar.field_imgPath), 1.0f);
        if (this.yNx != null) {
            this.yNx.put(auVar.field_imgPath, new i.a(auVar, i));
        }
        a(jVar, false);
        ((View) jVar.cvY().yOS).setVisibility(8);
        jVar.cvY().yOT.setImageBitmap(b);
        jVar.cvY().yOT.setVisibility(0);
        jVar.cvY().yOW.setVisibility(8);
        r nJ = t.nJ(auVar.field_imgPath);
        jVar.yOW.setTag(nJ);
        bnp bnp = nJ == null ? null : nJ.hXE;
        if (bnp == null) {
            jVar.mBO.setVisibility(8);
        } else if (com.tencent.mm.platformtools.t.oN(bnp.heZ)) {
            x.i("MicroMsg.ImageGallerySightHandler", " there is no attachurl, show more info btn");
            CharSequence charSequence = bnp.hfc;
            String str = bnp.hfd;
            if (bi.oN(charSequence) || bi.oN(str)) {
                jVar.mBO.setVisibility(8);
            } else {
                jVar.mBO.setText(charSequence);
                jVar.mBO.setVisibility(0);
                jVar.mBO.setTag(auVar);
            }
        } else {
            jVar.mBO.setVisibility(0);
            jVar.mBO.setText(this.yLG.yLH.getString(R.l.eQc, new Object[]{Integer.valueOf(bnp.wlG)}));
            String string = this.yLG.yLH.getString(R.l.eQc);
            if (bnp.wlG / 60 > 0) {
                string = string + this.yLG.yLH.getString(R.l.eQe, new Object[]{Integer.valueOf(bnp.wlG / 60)});
            }
            if (bnp.wlG % 60 > 0) {
                string = string + this.yLG.yLH.getString(R.l.eQf, new Object[]{Integer.valueOf(bnp.wlG % 60)});
            }
            jVar.mBO.setText(string + this.yLG.yLH.getString(R.l.eQd));
            jVar.mBO.setTag(auVar);
        }
        if (jVar.cvY().yOS instanceof VideoSightView) {
            m.a(jVar.mBO, (VideoSightView) jVar.cvY().yOS);
        }
        return true;
    }

    public final void cvu() {
        SparseArray sparseArray = this.yLG.ynw;
        for (int i = 0; i < sparseArray.size(); i++) {
            int keyAt = sparseArray.keyAt(i);
            if (!(sparseArray.get(keyAt) == null || ((View) sparseArray.get(keyAt)).getTag() == null)) {
                j jVar = (j) ((View) sparseArray.get(keyAt)).getTag();
                if (jVar.yOR != null && jVar.cvY().yOR.getVisibility() == 0) {
                    jVar.cvY().yOS.a(null);
                    if (((View) jVar.cvY().yOS).getVisibility() == 0 && jVar != null) {
                        a(jVar, false);
                        if (jVar.cvY().yOS != null) {
                            jVar.cvY().yOS.stop();
                        }
                        x.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
                        this.jwC.bz(false);
                        this.yLG.yLH.mController.xRr.getWindow().clearFlags(FileUtils.S_IWUSR);
                    }
                }
            }
        }
    }

    public final void Gt(int i) {
        au Ge = this.yLG.Ge(i);
        j Gc = Gc(i);
        if (Ge != null && Gc != null) {
            r nJ = t.nJ(Ge.field_imgPath);
            if (nJ != null) {
                if (Ge.field_isSend == 0) {
                    if (nJ.status == 113 || nJ.status == 111 || nJ.status == MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                        a(nJ, Gc);
                        return;
                    } else if (nJ.status == bc.CTRL_INDEX) {
                        a(nJ, Gc);
                        return;
                    }
                }
                a(Ge, Gc);
            }
        }
    }

    private void a(r rVar, j jVar) {
        if (rVar != null) {
            t.nH(rVar.getFileName());
            jVar.cvY().yOV.setVisibility(0);
            jVar.cvY().yOV.setProgress(t.f(rVar));
            o.Ub().a(this, Looper.getMainLooper());
        }
    }

    private void a(au auVar, final j jVar) {
        if (!this.yNy) {
            jVar.cvY().yOW.setVisibility(8);
            o.Ub();
            String nx = s.nx(auVar.field_imgPath);
            if (auVar.ckh()) {
                Toast.makeText(this.yLG.yLH, R.l.eTq, 0).show();
            } else if (nx == null || !e.bO(nx)) {
                Toast.makeText(this.yLG.yLH, R.l.eTq, 0).show();
            } else {
                this.yLG.yLH.mController.xRr.getWindow().addFlags(FileUtils.S_IWUSR);
                Boolean bool = (Boolean) jVar.yOQ.get(nx);
                if (bool == null || !bool.booleanValue()) {
                    ((View) jVar.cvY().yOS).setTag(nx);
                    jVar.cvY().yOU.setVisibility(8);
                    jVar.cvY().yOS.stop();
                    if (this.yLG.yLH.gn(auVar.field_msgId) == 3) {
                        jVar.cvY().yOS.setMute(true);
                    } else {
                        jVar.cvY().yOS.setMute(false);
                    }
                    jVar.cvY().yOS.setVideoPath(nx);
                    if (jVar.cvY().yOS.k(this.yLG.yLH.mController.xRr, false)) {
                        ((View) jVar.cvY().yOS).setVisibility(0);
                        jVar.cvY().yOT.setVisibility(8);
                    } else {
                        jVar.cvY().yOU.setVisibility(0);
                        jVar.cvY().yOU.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                jVar.cvY().yOS.k(h.this.yLG.yLH.mController.xRr, true);
                            }
                        });
                        ((View) jVar.cvY().yOS).setVisibility(8);
                        jVar.cvY().yOT.setVisibility(0);
                    }
                    x.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool requestFocus");
                    this.jwC.a(this);
                }
                ((View) jVar.cvY().yOS).setVisibility(0);
            }
        }
    }

    private static void a(j jVar, boolean z) {
        if (jVar != null) {
            jVar.cvY().yOV.setVisibility(8);
            if (z) {
                jVar.cvY().yOT.setVisibility(8);
                ((View) jVar.cvY().yOS).setVisibility(0);
                return;
            }
            jVar.cvY().yOT.setVisibility(0);
            ((View) jVar.cvY().yOS).setVisibility(8);
        }
    }

    public final boolean uG() {
        if (this.yLG != null) {
            j cvn = this.yLG.cvn();
            if (!(cvn == null || cvn.yOR == null || cvn.cvY().yOR.getVisibility() != 0)) {
                a(cvn, true);
            }
        }
        return false;
    }

    private boolean a(i.a aVar) {
        if (aVar == null) {
            return false;
        }
        o.Ub().a((a) this);
        if (this.yLG.yLH.cvH() == aVar.pos) {
            j Gc = Gc(aVar.pos);
            if (Gc != null) {
                Gc.cvY().yOV.setVisibility(8);
            }
            return true;
        }
        this.yLG.Gl(aVar.pos);
        return false;
    }

    public final void detach() {
        cvu();
        this.yLG.yLH.mController.xRr.getWindow().clearFlags(FileUtils.S_IWUSR);
        this.yNy = true;
        super.detach();
        this.yNx.clear();
        this.yNx = null;
        o.Ub().a((a) this);
        x.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
        this.jwC.bz(true);
    }

    public final void a(a.a aVar) {
        String str = aVar.fileName;
        if (!com.tencent.mm.platformtools.t.oN(str) && this.yNx != null) {
            i.a aVar2 = (i.a) this.yNx.get(str);
            if (aVar2 != null) {
                au auVar = aVar2.fou;
                if (auVar != null && auVar.field_imgPath != null && auVar.field_imgPath.equals(str)) {
                    r nJ = t.nJ(auVar.field_imgPath);
                    if (nJ == null) {
                        return;
                    }
                    if (!auVar.ckh() && nJ.status != bc.CTRL_INDEX) {
                        int f = t.f(nJ);
                        j Gc = Gc(aVar2.pos);
                        if (this.yLG.yLH.cvH() == aVar2.pos && Gc != null) {
                            Gc.cvY().yOV.setVisibility(0);
                            Gc.cvY().yOV.setProgress(f);
                        } else if (Gc == null) {
                            return;
                        }
                        if (f >= Gc.cvZ().yOV.zDe && a(aVar2)) {
                            a(auVar, Gc);
                        }
                    } else if (a(aVar2)) {
                        Toast.makeText(this.yLG.yLH, R.l.eTq, 0).show();
                    }
                }
            }
        }
    }
}
