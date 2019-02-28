package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.f.a.te;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;

public final class f {
    private static int yzl = 1;
    private static int yzm = 2;
    private static int yzn = 3;

    public static class a {
        public int vJT = 3;
        public int yzo;
        public int yzp = -1;
        public int yzq = -1;
        public long yzr = -1;

        public a(int i, int i2, int i3) {
            this.yzo = i;
            this.yzp = i2;
            this.yzq = i3;
        }

        public a(int i, long j) {
            this.yzo = i;
            this.yzr = j;
        }
    }

    public static a e(com.tencent.mm.x.g.a aVar) {
        String FY = q.FY();
        if (aVar.heB == 2 || aVar.heB == 3) {
            String[] split;
            if (!bi.cC(aVar.heF)) {
                for (String split2 : aVar.heF) {
                    split = split2.split(",");
                    if (split.length == 4 && split[0].equals(FY)) {
                        return new a(bi.getInt(split[1], -1), bi.getInt(split[2], -1), bi.getInt(split[3], -1));
                    }
                }
            }
            if (!bi.cC(aVar.heH)) {
                for (String split22 : aVar.heH) {
                    split = split22.split(",");
                    if (split.length == 3 && split[0].equals(FY)) {
                        return new a(bi.getInt(split[2], -1), bi.getLong(split[1], -1));
                    }
                }
            }
        }
        return new a();
    }

    public static int a(com.tencent.mm.x.g.a aVar, boolean z) {
        a e = e(aVar);
        switch (aVar.heB) {
            case 2:
            case 3:
                if (z || e.vJT == 1) {
                    if (e.yzo > 0 && e.yzp >= 0 && e.yzq >= 0) {
                        switch (e.yzo) {
                            case 1:
                            case 2:
                                return R.k.dxo;
                            case 3:
                                return R.k.dxm;
                            case 4:
                                return R.k.dxn;
                        }
                    }
                } else if (e.vJT != 2) {
                    return R.k.dxm;
                } else {
                    if (e.yzo > 0 && e.yzr >= 0) {
                        switch (e.yzo) {
                            case 1:
                                return R.k.dxo;
                            case 2:
                            case 3:
                                return R.k.dxm;
                            case 4:
                                return R.k.dxn;
                        }
                    }
                }
                break;
        }
        return R.k.dxm;
    }

    public static String b(com.tencent.mm.x.g.a aVar, boolean z) {
        try {
            String FY = q.FY();
            if (aVar.heB > 0) {
                int i;
                Object obj;
                int i2;
                Object obj2;
                Object obj3 = null;
                int i3 = -1;
                int i4 = -1;
                int i5 = -1;
                long j = -1;
                String str = aVar.heA;
                b teVar = new te();
                teVar.fMs.fMu = str;
                com.tencent.mm.sdk.b.a.xmy.m(teVar);
                if (aVar.heB == 2 || aVar.heB == 3) {
                    String[] split;
                    if (!bi.cC(aVar.heF)) {
                        for (String str2 : aVar.heF) {
                            split = str2.split(",");
                            if (split.length == 4 && split[0].equals(FY)) {
                                i3 = bi.getInt(split[1], -1);
                                i4 = bi.getInt(split[2], -1);
                                i5 = bi.getInt(split[3], -1);
                                obj3 = 1;
                                break;
                            }
                        }
                    }
                    if (!bi.cC(aVar.heH)) {
                        for (String str22 : aVar.heH) {
                            split = str22.split(",");
                            if (split.length == 3 && split[0].equals(FY)) {
                                j = bi.getLong(split[1], -1);
                                i = bi.getInt(split[2], -1);
                                obj = 1;
                                i2 = i5;
                                i5 = i4;
                                i4 = i3;
                                obj2 = obj3;
                                break;
                            }
                        }
                    }
                }
                i = -1;
                obj = null;
                i2 = i5;
                i5 = i4;
                i4 = i3;
                obj2 = obj3;
                if (teVar.fMt.status == yzn) {
                    return ad.getContext().getString(R.l.dCl);
                }
                if (teVar.fMt.status == yzm) {
                    return ad.getContext().getString(R.l.dCe);
                }
                switch (aVar.heB) {
                    case 1:
                        return z ? aVar.hen : aVar.heo;
                    case 2:
                    case 3:
                        if (FY.equals(aVar.heK) || z || obj2 != null) {
                            if (i4 > 0 && i5 >= 0 && i2 >= 0) {
                                switch (i4) {
                                    case 1:
                                        return ad.getContext().getString(R.l.dCm);
                                    case 2:
                                        return ad.getContext().getString(R.l.dCk, new Object[]{Integer.valueOf(i5 - i2)});
                                    case 3:
                                        return ad.getContext().getString(R.l.dCj);
                                    case 4:
                                        return ad.getContext().getString(R.l.dCl);
                                }
                            }
                        } else if (obj == null) {
                            return ad.getContext().getString(R.l.dCh);
                        } else {
                            if (i > 0 && j >= 0) {
                                switch (i) {
                                    case 1:
                                        return ad.getContext().getString(R.l.dCg, new Object[]{Float.valueOf(((float) j) / 100.0f)});
                                    case 2:
                                        return ad.getContext().getString(R.l.dCf, new Object[]{Float.valueOf(((float) j) / 100.0f)});
                                    case 3:
                                        return ad.getContext().getString(R.l.dCi, new Object[]{Float.valueOf(((float) j) / 100.0f)});
                                    case 4:
                                        return ad.getContext().getString(R.l.dCh);
                                }
                            }
                        }
                        break;
                }
                if (z) {
                    return aVar.hen;
                }
                return aVar.heo;
            } else if (z) {
                return aVar.hen;
            } else {
                return aVar.heo;
            }
        } catch (Exception e) {
            x.e("MicroMsg.C2CAppMsgUtil", "getC2CDescFromAppMsgContent, error: %s", e.getMessage());
        }
    }

    public static String a(int i, int i2, boolean z, com.tencent.mm.x.g.a aVar) {
        Context context = ad.getContext();
        if (i == 5) {
            return context.getString(R.l.etZ);
        }
        return i == 4 ? z ? context.getString(R.l.etY) : context.getString(R.l.eua) : i == 3 ? i2 == 2 ? z ? aVar.hen : context.getString(R.l.eua) : z ? aVar.hen : aVar.heo : z ? aVar.hen : aVar.heo;
    }

    public static int q(int i, int i2, boolean z) {
        if (i != 5) {
            return i == 4 ? z ? R.g.bAk : R.g.bAi : i == 3 ? i2 == 2 ? z ? R.g.bAj : R.g.bAi : z ? R.g.bAj : R.g.bAh : z ? R.g.bAj : R.g.bAh;
        } else {
            if (z) {
                return R.g.bAk;
            }
            return R.g.bAi;
        }
    }

    public static int r(int i, int i2, boolean z) {
        if (i == 5) {
            return R.g.bDA;
        }
        if (i == 4) {
            return R.g.bDA;
        }
        if (i != 3) {
            return -1;
        }
        if (i2 == 2) {
            if (z) {
                return -1;
            }
            return R.g.bDA;
        } else if (z) {
            return -1;
        } else {
            return R.g.bDA;
        }
    }

    public static int c(com.tencent.mm.x.g.a aVar, boolean z) {
        if (aVar != null) {
            String str = aVar.heA;
            b teVar = new te();
            teVar.fMs.fMu = str;
            com.tencent.mm.sdk.b.a.xmy.m(teVar);
            if (teVar.fMt.status == yzn || teVar.fMt.status == yzm) {
                return z ? R.g.byx : R.g.byv;
            } else {
                a e = e(aVar);
                switch (aVar.heB) {
                    case 2:
                    case 3:
                        if (z || e.vJT == 1) {
                            if (e.yzo > 0 && e.yzp >= 0 && e.yzq >= 0) {
                                switch (e.yzo) {
                                    case 1:
                                    case 2:
                                        return z ? R.g.byw : R.g.byu;
                                    case 3:
                                    case 4:
                                        return z ? R.g.byx : R.g.byv;
                                }
                            }
                        } else if (e.vJT != 2) {
                            return z ? R.g.byw : R.g.byu;
                        } else {
                            if (e.yzo > 0 && e.yzr >= 0) {
                                switch (e.yzo) {
                                    case 1:
                                        return z ? R.g.byw : R.g.byu;
                                    case 2:
                                    case 3:
                                    case 4:
                                        return z ? R.g.byx : R.g.byv;
                                }
                            }
                        }
                        break;
                }
                if (z) {
                    return R.g.byw;
                }
                return R.g.byu;
            }
        } else if (z) {
            return R.g.byw;
        } else {
            return R.g.byu;
        }
    }

    public static int d(com.tencent.mm.x.g.a aVar, boolean z) {
        if (aVar == null) {
            return -12479656;
        }
        String str = aVar.heA;
        b teVar = new te();
        teVar.fMs.fMu = str;
        com.tencent.mm.sdk.b.a.xmy.m(teVar);
        if (teVar.fMt.status == yzn || teVar.fMt.status == yzm) {
            return -8868722;
        }
        a e = e(aVar);
        switch (aVar.heB) {
            case 2:
            case 3:
                if (z || e.vJT == 1) {
                    if (e.yzo <= 0 || e.yzp < 0 || e.yzq < 0) {
                        return -12479656;
                    }
                    switch (e.yzo) {
                        case 3:
                        case 4:
                            return -8868722;
                        default:
                            return -12479656;
                    }
                } else if (e.vJT != 2 || e.yzo <= 0 || e.yzr < 0) {
                    return -12479656;
                } else {
                    switch (e.yzo) {
                        case 2:
                        case 3:
                        case 4:
                            return -8868722;
                        default:
                            return -12479656;
                    }
                }
            default:
                return -12479656;
        }
    }
}
