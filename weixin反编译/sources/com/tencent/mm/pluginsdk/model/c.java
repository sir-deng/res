package com.tencent.mm.pluginsdk.model;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import android.support.v4.app.Fragment;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.protocal.c.wa;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.snackbar.b.b;
import com.tencent.mm.x.g;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c {
    private static Map<String, Integer> tXA;
    public static boolean vjO = true;
    private static aa<String, Bitmap> vjP = new aa(20);

    static {
        tXA = new HashMap();
        Map hashMap = new HashMap();
        tXA = hashMap;
        hashMap.put("avi", Integer.valueOf(R.k.dvL));
        tXA.put("m4v", Integer.valueOf(R.k.dvL));
        tXA.put("vob", Integer.valueOf(R.k.dvL));
        tXA.put("mpeg", Integer.valueOf(R.k.dvL));
        tXA.put("mpe", Integer.valueOf(R.k.dvL));
        tXA.put("asx", Integer.valueOf(R.k.dvL));
        tXA.put("asf", Integer.valueOf(R.k.dvL));
        tXA.put("f4v", Integer.valueOf(R.k.dvL));
        tXA.put("flv", Integer.valueOf(R.k.dvL));
        tXA.put("mkv", Integer.valueOf(R.k.dvL));
        tXA.put("wmv", Integer.valueOf(R.k.dvL));
        tXA.put("wm", Integer.valueOf(R.k.dvL));
        tXA.put("3gp", Integer.valueOf(R.k.dvL));
        tXA.put("mp4", Integer.valueOf(R.k.dvL));
        tXA.put("rmvb", Integer.valueOf(R.k.dvL));
        tXA.put("rm", Integer.valueOf(R.k.dvL));
        tXA.put("ra", Integer.valueOf(R.k.dvL));
        tXA.put("ram", Integer.valueOf(R.k.dvL));
        tXA.put("mp3pro", Integer.valueOf(R.k.dvy));
        tXA.put("vqf", Integer.valueOf(R.k.dvy));
        tXA.put("cd", Integer.valueOf(R.k.dvy));
        tXA.put("md", Integer.valueOf(R.k.dvy));
        tXA.put("mod", Integer.valueOf(R.k.dvy));
        tXA.put("vorbis", Integer.valueOf(R.k.dvy));
        tXA.put("au", Integer.valueOf(R.k.dvy));
        tXA.put("amr", Integer.valueOf(R.k.dvy));
        tXA.put("silk", Integer.valueOf(R.k.dvy));
        tXA.put("wma", Integer.valueOf(R.k.dvy));
        tXA.put("mmf", Integer.valueOf(R.k.dvy));
        tXA.put("mid", Integer.valueOf(R.k.dvy));
        tXA.put("midi", Integer.valueOf(R.k.dvy));
        tXA.put("mp3", Integer.valueOf(R.k.dvy));
        tXA.put("aac", Integer.valueOf(R.k.dvy));
        tXA.put("ape", Integer.valueOf(R.k.dvy));
        tXA.put("aiff", Integer.valueOf(R.k.dvy));
        tXA.put("aif", Integer.valueOf(R.k.dvy));
        tXA.put("jfif", Integer.valueOf(R.k.byW));
        tXA.put("tiff", Integer.valueOf(R.k.byW));
        tXA.put("tif", Integer.valueOf(R.k.byW));
        tXA.put("jpe", Integer.valueOf(R.k.byW));
        tXA.put("dib", Integer.valueOf(R.k.byW));
        tXA.put("jpeg", Integer.valueOf(R.k.byW));
        tXA.put("jpg", Integer.valueOf(R.k.byW));
        tXA.put("png", Integer.valueOf(R.k.byW));
        tXA.put("bmp", Integer.valueOf(R.k.byW));
        tXA.put("gif", Integer.valueOf(R.k.byW));
        tXA.put("rar", Integer.valueOf(R.k.dvG));
        tXA.put("zip", Integer.valueOf(R.k.dvG));
        tXA.put("7z", Integer.valueOf(R.k.dvG));
        tXA.put("iso", Integer.valueOf(R.k.dvG));
        tXA.put("cab", Integer.valueOf(R.k.dvG));
        tXA.put("doc", Integer.valueOf(R.k.dvP));
        tXA.put("docx", Integer.valueOf(R.k.dvP));
        tXA.put("ppt", Integer.valueOf(R.k.dvE));
        tXA.put("pptx", Integer.valueOf(R.k.dvE));
        tXA.put("xls", Integer.valueOf(R.k.dvs));
        tXA.put("xlsx", Integer.valueOf(R.k.dvs));
        tXA.put("txt", Integer.valueOf(R.k.dvH));
        tXA.put("rtf", Integer.valueOf(R.k.dvH));
        tXA.put("pdf", Integer.valueOf(R.k.dvC));
        tXA.put("unknown", Integer.valueOf(R.k.dvI));
    }

    public static ve a(int i, vn vnVar, wa waVar) {
        if (vnVar == null) {
            x.w("MicroMsg.FavExportLogic", "proto item is null");
            return null;
        }
        ve veVar = new ve();
        vt vtVar = vnVar.wlW;
        if (vtVar != null) {
            veVar.fAJ = vtVar.fAJ;
            veVar.wlI = vtVar.wlx;
            veVar.appId = vtVar.appId;
            veVar.foe = vtVar.foe;
        }
        if (waVar != null) {
            if (waVar.wmm != null) {
                veVar.wlJ.addAll(waVar.wmm);
            }
            if (waVar.wmn != null) {
                veVar.wlJ.addAll(waVar.wmn);
            }
        }
        veVar.fFC = vnVar;
        veVar.type = i;
        switch (i) {
            case 1:
                veVar.title = "";
                veVar.desc = vnVar.desc;
                return veVar;
            case 2:
                if (vnVar.wlY != null && vnVar.wlY.size() > 0) {
                    veVar.title = ((uz) vnVar.wlY.get(0)).title;
                }
                return veVar;
            case 4:
                if (!(vnVar.wlY == null || vnVar.wlY.isEmpty())) {
                    veVar.title = ((uz) vnVar.wlY.get(0)).title;
                }
                return veVar;
            case 5:
                if (vnVar.wlf != null) {
                    veVar.title = vnVar.wlf.title;
                    veVar.desc = vnVar.wlf.wmD;
                }
                if (!(!bi.oN(veVar.title) || vnVar.wlY == null || vnVar.wlY.isEmpty())) {
                    veVar.title = ((uz) vnVar.wlY.get(0)).title;
                }
                if (bi.oN(veVar.desc) && vtVar != null) {
                    veVar.desc = vtVar.hPT;
                }
                return veVar;
            case 6:
                veVar.title = vnVar.iLo;
                if (bi.oN(veVar.title)) {
                    if (vnVar.wld != null) {
                        veVar.title = vnVar.wld.fEp;
                        veVar.desc = vnVar.wld.label;
                    }
                } else if (vnVar.wld != null) {
                    veVar.desc = vnVar.wld.fEp;
                }
                return veVar;
            case 7:
                if (!(vnVar.wlY == null || vnVar.wlY.isEmpty())) {
                    veVar.title = ((uz) vnVar.wlY.get(0)).title;
                    veVar.desc = ((uz) vnVar.wlY.get(0)).desc;
                }
                return veVar;
            case 8:
                veVar.title = vnVar.title;
                if (!(!bi.oN(veVar.title) || vnVar.wlY == null || vnVar.wlY.isEmpty())) {
                    veVar.title = ((uz) vnVar.wlY.get(0)).title;
                }
                return veVar;
            case 10:
            case 11:
                if (vnVar.wlh != null) {
                    veVar.title = vnVar.wlh.title;
                    veVar.desc = vnVar.wlh.desc;
                }
                return veVar;
            case 12:
            case 15:
                if (vnVar.wlj != null) {
                    veVar.title = vnVar.wlj.title;
                    veVar.desc = vnVar.wlj.desc;
                }
                return veVar;
            case 14:
            case 18:
                List<uz> list = vnVar.wlY;
                if (list == null) {
                    return null;
                }
                for (uz uzVar : list) {
                    if (1 == uzVar.bjS) {
                        veVar.title = uzVar.desc;
                        return veVar;
                    }
                }
                return veVar;
            default:
                x.w("MicroMsg.FavExportLogic", "unknown type %d", Integer.valueOf(i));
                return veVar;
        }
    }

    public static void a(int i, int i2, Activity activity, b bVar) {
        a(-1, i, i2, activity, null, null, null, bVar);
    }

    public static void a(int i, int i2, int i3, Activity activity, Fragment fragment, com.tencent.mm.ui.snackbar.b.c cVar, OnClickListener onClickListener, b bVar) {
        if (activity == null && fragment == null) {
            x.e("MicroMsg.FavExportLogic", "handleErrorType activity = null && fragment = null");
            return;
        }
        b anonymousClass1;
        if (bVar == null) {
            anonymousClass1 = new b() {
                public final void aQv() {
                    com.tencent.mm.sdk.b.b fwVar = new fw();
                    fwVar.fwl.type = 35;
                    a.xmy.m(fwVar);
                }
            };
        } else {
            anonymousClass1 = bVar;
        }
        if (i2 != 0) {
            Context activity2;
            if (activity == null) {
                activity2 = fragment.getActivity();
            } else {
                activity2 = activity;
            }
            String str;
            final OnClickListener onClickListener2;
            switch (i2) {
                case -9:
                case -8:
                case -7:
                case -6:
                case -5:
                case -4:
                    String string;
                    str = "";
                    Context activity3 = fragment == null ? activity2 : fragment.getActivity();
                    if (i2 == -4) {
                        switch (i) {
                            case 2:
                                string = activity3.getString(R.l.efr);
                                break;
                            case 4:
                            case 16:
                                string = activity3.getString(R.l.efs);
                                break;
                            case 8:
                                string = activity3.getString(R.l.efq);
                                break;
                            case 14:
                                string = activity3.getString(R.l.efF);
                                break;
                            default:
                                string = str;
                                break;
                        }
                    } else if (i2 == -5) {
                        string = i != 14 ? activity3.getString(R.l.eeT) : activity3.getString(R.l.efE);
                    } else if (i2 == -6) {
                        string = activity3.getString(R.l.efF);
                    } else if (i2 == -7) {
                        string = activity3.getString(R.l.efE);
                    } else if (i2 == -8) {
                        string = activity3.getString(R.l.efG);
                    } else if (i2 != -9) {
                        string = activity3.getString(R.l.efu);
                    } else if (fragment != null) {
                        com.tencent.mm.ui.snackbar.a.a(0, fragment, activity3.getString(R.l.egi), activity3.getString(R.l.eeS), anonymousClass1, cVar);
                        return;
                    } else {
                        com.tencent.mm.ui.snackbar.a.a(0, (Activity) activity2, activity3.getString(R.l.egi), activity3.getString(R.l.eeS), anonymousClass1, cVar);
                        return;
                    }
                    final OnClickListener onClickListener3 = onClickListener;
                    final Fragment fragment2 = fragment;
                    final com.tencent.mm.ui.snackbar.b.c cVar2 = cVar;
                    final Context context = activity2;
                    onClickListener2 = onClickListener;
                    h.a(activity3, string, "", activity3.getString(R.l.eAq), activity3.getString(R.l.dUl), (OnClickListener) new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            if (onClickListener3 != null) {
                                onClickListener3.onClick(dialogInterface, -2);
                            }
                            if (fragment2 != null) {
                                com.tencent.mm.ui.snackbar.a.a(0, fragment2, fragment2.getActivity().getString(R.l.egi), fragment2.getActivity().getString(R.l.eeS), anonymousClass1, cVar2);
                            } else {
                                com.tencent.mm.ui.snackbar.a.a(0, context, context.getString(R.l.egi), context.getString(R.l.eeS), anonymousClass1, cVar2);
                            }
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            if (onClickListener2 != null) {
                                onClickListener2.onClick(dialogInterface, -1);
                            }
                        }
                    }, R.e.buj);
                    return;
                case -2:
                    str = activity2.getString(R.l.efw);
                    String string2 = activity2.getString(R.l.efx);
                    String string3 = activity2.getString(R.l.efz);
                    String string4 = activity2.getString(R.l.dUl);
                    onClickListener2 = onClickListener;
                    OnClickListener anonymousClass3 = new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent();
                            intent.putExtra("key_enter_fav_cleanui_from", 3);
                            d.b(activity2, "favorite", ".ui.FavCleanUI", intent);
                            dialogInterface.dismiss();
                            if (onClickListener2 != null) {
                                onClickListener2.onClick(dialogInterface, -2);
                            }
                        }
                    };
                    onClickListener2 = onClickListener;
                    h.a(activity2, str, string2, string3, string4, anonymousClass3, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            if (onClickListener2 != null) {
                                onClickListener2.onClick(dialogInterface, -1);
                            }
                        }
                    }, R.e.buj);
                    return;
                default:
                    onClickListener2 = onClickListener;
                    h.a(activity2, i2, 0, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (onClickListener2 != null) {
                                onClickListener2.onClick(dialogInterface, -1);
                            }
                        }
                    });
                    return;
            }
        } else if (fragment != null) {
            com.tencent.mm.ui.snackbar.a.a(i3, fragment, fragment.getString(R.l.egi), fragment.getString(R.l.eeS), anonymousClass1, cVar);
        } else if (activity != null) {
            com.tencent.mm.ui.snackbar.a.a(i3, activity, activity.getString(R.l.egi), activity.getString(R.l.eeS), anonymousClass1, cVar);
        }
    }

    public static int a(au auVar, cg cgVar, boolean z) {
        String str = "";
        x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo msg type is %d", Integer.valueOf(auVar.getType()));
        if (z || cgVar.frk.frq <= 0) {
            boolean z2;
            if (cgVar.frk.type == 4 || cgVar.frk.type == 8 || cgVar.frk.type == 16 || cgVar.frk.type == 2) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (cgVar.frk.type == 14 && cgVar.frk.frm.wlY.size() > 0) {
                uz uzVar = (uz) cgVar.frk.frm.wlY.getLast();
                if (uzVar.bjS == 4 || uzVar.bjS == 8 || uzVar.bjS == 15 || uzVar.bjS == 2) {
                    z2 = false;
                }
            }
            x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo msg type skipCheck %B", Boolean.valueOf(z2));
            if (z2) {
                return a(cgVar, 0);
            }
            if (cgVar.frk.frm == null) {
                return a(cgVar, -1);
            }
            if (cgVar.frk.frm.wlY == null) {
                return a(cgVar, -1);
            }
            String str2;
            if (System.currentTimeMillis() - auVar.field_createTime > 259200000) {
                z2 = true;
            } else {
                z2 = false;
            }
            x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo isOverThreeDays %B", Boolean.valueOf(z2));
            if (1 <= cgVar.frk.frm.wlY.size()) {
                str2 = ((uz) cgVar.frk.frm.wlY.getLast()).wkl;
            } else {
                str2 = str;
            }
            if (z2) {
                String str3;
                if (bi.oN(str2) || !e.bO(str2)) {
                    if (auVar != null && (auVar.getType() == 43 || auVar.getType() == 44 || auVar.getType() == 62)) {
                        r nJ = t.nJ(auVar.field_imgPath);
                        if (nJ != null && nJ.hXC == -1) {
                            str2 = nJ.Um();
                            if (e.bO(str2)) {
                                str3 = str2;
                                if (bi.oN(str3)) {
                                    return a(cgVar, -4);
                                }
                                ((uz) cgVar.frk.frm.wlY.getLast()).Uj(str3);
                            }
                        }
                    }
                    str3 = null;
                    if (bi.oN(str3)) {
                        return a(cgVar, -4);
                    }
                    ((uz) cgVar.frk.frm.wlY.getLast()).Uj(str3);
                } else {
                    str3 = str2;
                }
                if (a(auVar, cgVar, str3, true)) {
                    return a(cgVar, -5);
                }
                x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  isOverThreeDays true not big not expired");
            } else if (a(auVar, cgVar, str2, false)) {
                return a(cgVar, -5);
            }
            x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  fav data is normal");
            return a(cgVar, 0);
        }
        x.i("MicroMsg.FavExportLogic", "(!result)&&(favoriteEvent.data.errorType > FavExportLogic.KEY_FAV_PARA_NO_ERROR)");
        return a(cgVar, cgVar.frk.frq);
    }

    private static int a(cg cgVar, int i) {
        int i2 = 1;
        int i3 = 0;
        if (cgVar.frk.frm.wlY != null && cgVar.frk.frm.wlY.size() > 0) {
            uz uzVar = (uz) cgVar.frk.frm.wlY.getLast();
            if (i <= 0) {
                switch (i) {
                    case -5:
                        uzVar.De(2);
                        uzVar.Uj(null);
                        break;
                    case -4:
                        uzVar.De(1);
                        uzVar.Uj(null);
                        break;
                    default:
                        uzVar.De(0);
                        break;
                }
            }
        }
        if (cgVar.frk.frm.wlY == null || cgVar.frk.frm.wlY.size() == 0) {
            cgVar.frk.frq = i;
        } else if (cgVar.frk.frq != -9) {
            if (i <= 0 && cgVar.frk.frq <= 0) {
                i2 = 0;
            }
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (i3 < cgVar.frk.frm.wlY.size()) {
                switch (((uz) cgVar.frk.frm.wlY.get(i3)).wkV) {
                    case 0:
                        i6++;
                        break;
                    case 1:
                        i4++;
                        break;
                    case 2:
                        i5++;
                        break;
                    default:
                        break;
                }
                int i7 = i4;
                i3++;
                i6 = i6;
                i5 = i5;
                i4 = i7;
            }
            if (i2 > 0) {
                if (i5 > 0 || i4 > 0) {
                    cgVar.frk.frq = -9;
                } else {
                    cgVar.frk.frq = i;
                }
            } else if (i5 > 0) {
                if (i4 > 0) {
                    cgVar.frk.frq = -8;
                } else if (i6 == 0) {
                    cgVar.frk.frq = -5;
                } else if (i6 > 0) {
                    cgVar.frk.frq = -7;
                }
            } else if (i4 > 0) {
                if (i6 == 0) {
                    cgVar.frk.frq = -4;
                } else if (i6 > 0) {
                    cgVar.frk.frq = -6;
                }
            }
        }
        return i;
    }

    private static boolean a(au auVar, cg cgVar, String str, boolean z) {
        g.a I;
        if (!bi.oN(str)) {
            File file = new File(str);
            if (file.exists()) {
                if (file.length() > ((long) com.tencent.mm.j.b.zN())) {
                    x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file is big");
                    return true;
                }
                x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file not big");
            } else if (!z) {
                x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish ！attachFile.exists()");
                ((uz) cgVar.frk.frm.wlY.getLast()).Uj(null);
            }
        }
        String str2 = auVar.field_content;
        if (str2 != null) {
            I = g.a.I(str2, auVar.field_reserved);
        } else {
            I = null;
        }
        if (I != null) {
            if (I.hcQ != 0 || I.hcM > com.tencent.mm.j.b.zN()) {
                x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file is big");
                return true;
            } else if (!(bi.oN(str) || !e.bO(str) || z)) {
                if (((long) I.hcM) > ((long) e.bN(str))) {
                    x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish content.attachlen > datasize");
                    ((uz) cgVar.frk.frm.wlY.getLast()).Uj(null);
                }
            }
        }
        if (str2 == null || I == null) {
            x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  (xml == null ) ||(content == null)");
        }
        return false;
    }

    public static Bitmap aY(String str, boolean z) {
        boolean z2 = true;
        if (bi.oN(str)) {
            return null;
        }
        Bitmap bitmap = (Bitmap) vjP.get(str);
        if (bitmap != null) {
            x.d("MicroMsg.FavExportLogic", "get bm from cache %s", str);
            return bitmap;
        } else if (z) {
            return null;
        } else {
            if (!e.bO(str)) {
                return null;
            }
            int i;
            x.d("MicroMsg.FavExportLogic", "get from cache fail, try to decode from file");
            Options options = new Options();
            options.inJustDecodeBounds = true;
            bitmap = BitmapFactory.decodeFile(str, options);
            if (bitmap != null) {
                x.i("MicroMsg.FavExportLogic", "bitmap recycle %s", bitmap);
                bitmap.recycle();
            }
            boolean z3 = z.bt(options.outWidth, options.outHeight) && options.outWidth > 480;
            boolean z4;
            if (!z.bs(options.outWidth, options.outHeight) || options.outHeight <= 480) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z3 || z4) {
                int i2 = options.outHeight;
                i = options.outWidth;
                while (i * i2 > 2764800) {
                    i >>= 1;
                    i2 >>= 1;
                }
                i = Math.max(1, i);
                i2 = Math.max(1, i2);
                x.w("MicroMsg.FavExportLogic", "fit long picture, beg %d*%d, after %d*%d", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), Integer.valueOf(i), Integer.valueOf(i2));
            }
            i = ExifHelper.Vo(str);
            if (MMNativeJpeg.IsJpegFile(str) && MMNativeJpeg.isProgressive(str)) {
                bitmap = MMNativeJpeg.decodeAsBitmap(str);
                String str2 = "MicroMsg.FavExportLogic";
                String str3 = "Progressive jpeg, result isNull:%b";
                Object[] objArr = new Object[1];
                if (bitmap != null) {
                    z2 = false;
                }
                objArr[0] = Boolean.valueOf(z2);
                x.i(str2, str3, objArr);
            } else {
                bitmap = com.tencent.mm.sdk.platformtools.d.cX(str, 0);
            }
            if (bitmap == null) {
                x.e("MicroMsg.FavExportLogic", "getSuitableBmp fail, temBmp is null, filePath = " + str);
                return null;
            }
            bitmap = com.tencent.mm.sdk.platformtools.d.b(bitmap, (float) i);
            vjP.put(str, bitmap);
            return bitmap;
        }
    }

    public static int RW(String str) {
        Integer num = (Integer) tXA.get(str);
        if (num == null) {
            return ((Integer) tXA.get("unknown")).intValue();
        }
        return num.intValue();
    }

    @TargetApi(8)
    public static Bitmap RX(String str) {
        if (com.tencent.mm.compatible.util.d.fN(8)) {
            return ThumbnailUtils.createVideoThumbnail(str, 1);
        }
        return null;
    }

    public static void bYZ() {
    }
}
