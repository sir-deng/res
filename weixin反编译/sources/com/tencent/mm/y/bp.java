package com.tencent.mm.y;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.aoc;
import com.tencent.mm.protocal.c.aod;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class bp {
    public static final int hjn;
    public static final int hjo;
    public static final int hjp = (hjn + 2);
    private static bp hjs;
    private long hjq = 0;
    private Map<Integer, a> hjr = new HashMap();

    private abstract class a {
        public abstract boolean a(bn bnVar);

        private a() {
        }

        /* synthetic */ a(bp bpVar, byte b) {
            this();
        }

        public bn d(int i, Object... objArr) {
            int i2 = 1;
            if (objArr != null && objArr.length > 0) {
                i2 = bi.p(objArr[0], 1);
            }
            bn bnVar = new bn();
            bnVar.key = i;
            bnVar.hjk = String.valueOf(i2);
            bnVar.hjl = 0;
            return bnVar;
        }

        public void a(bn bnVar, Object... objArr) {
            int i = 1;
            if (objArr != null && objArr.length > 0) {
                i = bi.p(objArr[0], 1);
            }
            bnVar.hjk = (i + bi.getInt(bnVar.hjk, 0));
        }
    }

    static {
        int hashCode = "kv_key_start".hashCode();
        hjn = hashCode;
        hjo = hashCode + 1;
    }

    private bp() {
        this.hjr.put(Integer.valueOf(hjo), new a() {
            public final boolean a(bn bnVar) {
                if (System.currentTimeMillis() - bnVar.hjl <= 3600000 || bi.getInt(bnVar.hjk, 0) <= 0) {
                    return false;
                }
                bp.r(23, bnVar.hjk + "_3");
                bnVar.hjk = "0";
                bnVar.hjl = System.currentTimeMillis();
                return true;
            }
        });
        this.hjr.put(Integer.valueOf(hjp), new a() {
            public final boolean a(bn bnVar) {
                if (System.currentTimeMillis() - bnVar.hjl <= 3600000 || bi.getInt(bnVar.hjk, 0) <= 0) {
                    return false;
                }
                bp.r(23, bnVar.hjk + "_43");
                bnVar.hjk = "0";
                bnVar.hjl = System.currentTimeMillis();
                return true;
            }
        });
        this.hjr.put(Integer.valueOf(24), new a() {
            public final boolean a(bn bnVar) {
                if (System.currentTimeMillis() - bnVar.hjl <= 3600000 || bi.getInt(bnVar.hjk, 0) <= 0) {
                    return false;
                }
                bp.r(bnVar.key, bnVar.hjk);
                bnVar.hjk = "0";
                bnVar.hjl = System.currentTimeMillis();
                return true;
            }
        });
        this.hjr.put(Integer.valueOf(25), new a() {
            public final bn d(int i, Object... objArr) {
                bn bnVar = new bn();
                bnVar.key = i;
                if (objArr != null && objArr.length > 0) {
                    bnVar.hjk = objArr[0];
                }
                bnVar.hjl = 0;
                return bnVar;
            }

            public final void a(bn bnVar, Object... objArr) {
                if (objArr != null && objArr.length > 0) {
                    bnVar.hjk = objArr[0];
                }
            }

            public final boolean a(bn bnVar) {
                if (System.currentTimeMillis() - bnVar.hjl <= 3600000 || bnVar.hjk.length() <= 0) {
                    return false;
                }
                bp.r(bnVar.key, bnVar.hjk);
                bnVar.hjk = "";
                bnVar.hjl = System.currentTimeMillis();
                return true;
            }
        });
        this.hjr.put(Integer.valueOf(26), new a() {
            public final boolean a(bn bnVar) {
                if (System.currentTimeMillis() - bnVar.hjl <= 3600000 || bi.getInt(bnVar.hjk, 0) <= 0) {
                    return false;
                }
                bp.r(bnVar.key, bnVar.hjk);
                bnVar.hjk = "0";
                bnVar.hjl = System.currentTimeMillis();
                return true;
            }
        });
        this.hjr.put(Integer.valueOf(10071), new a() {
            public final boolean a(bn bnVar) {
                if (System.currentTimeMillis() - bnVar.hjl <= 86400000 || bi.getInt(bnVar.hjk, 0) <= 0) {
                    return false;
                }
                bp.r(bnVar.key, "1");
                bnVar.hjk = "0";
                bnVar.hjl = System.currentTimeMillis();
                return true;
            }
        });
        this.hjr.put(Integer.valueOf(10076), new a() {
            public final boolean a(bn bnVar) {
                if (System.currentTimeMillis() - bnVar.hjl <= 3600000 || bi.getInt(bnVar.hjk, 0) <= 0) {
                    return false;
                }
                bp.r(bnVar.key, bnVar.hjk);
                bnVar.hjk = "0";
                bnVar.hjl = System.currentTimeMillis();
                return true;
            }
        });
        this.hjr.put(Integer.valueOf(19), new a() {
            public final boolean a(bn bnVar) {
                if (System.currentTimeMillis() - bnVar.hjl <= 86400000 || bi.getInt(bnVar.hjk, 0) <= 0) {
                    return false;
                }
                bp.r(bnVar.key, bnVar.hjk);
                bnVar.hjk = "0";
                bnVar.hjl = System.currentTimeMillis();
                return true;
            }
        });
        this.hjr.put(Integer.valueOf(10112), new a() {
            public final boolean a(bn bnVar) {
                if (System.currentTimeMillis() - bnVar.hjl <= 1800000 || bi.getInt(bnVar.hjk, 0) <= 0) {
                    return false;
                }
                bp.r(bnVar.key, bnVar.hjk);
                bnVar.hjk = "0";
                bnVar.hjl = System.currentTimeMillis();
                return true;
            }
        });
        this.hjr.put(Integer.valueOf(10113), new a() {
            public final boolean a(bn bnVar) {
                if (System.currentTimeMillis() - bnVar.hjl <= 1800000 || bi.getInt(bnVar.hjk, 0) <= 0) {
                    return false;
                }
                bp.r(bnVar.key, bnVar.hjk);
                bnVar.hjk = "0";
                bnVar.hjl = System.currentTimeMillis();
                return true;
            }
        });
        this.hjr.put(Integer.valueOf(10114), new a() {
            public final boolean a(bn bnVar) {
                if (System.currentTimeMillis() - bnVar.hjl <= 1800000 || bi.getInt(bnVar.hjk, 0) <= 0) {
                    return false;
                }
                bp.r(bnVar.key, bnVar.hjk);
                bnVar.hjk = "0";
                bnVar.hjl = System.currentTimeMillis();
                return true;
            }
        });
        this.hjr.put(Integer.valueOf(10115), new a() {
            public final boolean a(bn bnVar) {
                if (System.currentTimeMillis() - bnVar.hjl <= 1800000 || bi.getInt(bnVar.hjk, 0) <= 0) {
                    return false;
                }
                bp.r(bnVar.key, bnVar.hjk);
                bnVar.hjk = "0";
                bnVar.hjl = System.currentTimeMillis();
                return true;
            }
        });
        this.hjr.put(Integer.valueOf(10240), new a() {
            public final boolean a(bn bnVar) {
                if (System.currentTimeMillis() - bnVar.hjl <= 1800000 || bi.getInt(bnVar.hjk, 0) <= 0) {
                    return false;
                }
                bp.r(bnVar.key, bnVar.hjk);
                bnVar.hjk = "0";
                bnVar.hjl = System.currentTimeMillis();
                return true;
            }
        });
        this.hjr.put(Integer.valueOf(10241), new a() {
            public final boolean a(bn bnVar) {
                if (System.currentTimeMillis() - bnVar.hjl <= 1800000 || bi.getInt(bnVar.hjk, 0) <= 0) {
                    return false;
                }
                bp.r(bnVar.key, bnVar.hjk);
                bnVar.hjk = "0";
                bnVar.hjl = System.currentTimeMillis();
                return true;
            }
        });
        this.hjr.put(Integer.valueOf(15), new a() {
            public final boolean a(bn bnVar) {
                if (System.currentTimeMillis() - bnVar.hjl <= 1800000 || bi.getInt(bnVar.hjk, 0) <= 0) {
                    return false;
                }
                bp.r(bnVar.key, bnVar.hjk);
                bnVar.hjk = "0";
                bnVar.hjl = System.currentTimeMillis();
                return true;
            }
        });
        this.hjr.put(Integer.valueOf(16), new a() {
            public final boolean a(bn bnVar) {
                if (System.currentTimeMillis() - bnVar.hjl <= 1800000 || bi.getInt(bnVar.hjk, 0) <= 0) {
                    return false;
                }
                bp.r(bnVar.key, bnVar.hjk);
                bnVar.hjk = "0";
                bnVar.hjl = System.currentTimeMillis();
                return true;
            }
        });
        this.hjr.put(Integer.valueOf(27), new a() {
            public final boolean a(bn bnVar) {
                if (System.currentTimeMillis() - bnVar.hjl <= 1800000 || bi.getInt(bnVar.hjk, 0) <= 0) {
                    return false;
                }
                bp.r(bnVar.key, bnVar.hjk);
                bnVar.hjk = "0";
                bnVar.hjl = System.currentTimeMillis();
                return true;
            }
        });
        this.hjr.put(Integer.valueOf(38), new a() {
            public final boolean a(bn bnVar) {
                if (System.currentTimeMillis() - bnVar.hjl <= 1800000 || bi.getInt(bnVar.hjk, 0) <= 0) {
                    return false;
                }
                bp.r(bnVar.key, bnVar.hjk);
                bnVar.hjk = "0";
                bnVar.hjl = System.currentTimeMillis();
                return true;
            }
        });
        this.hjr.put(Integer.valueOf(10090), new a() {
            public final boolean a(bn bnVar) {
                if (System.currentTimeMillis() - bnVar.hjl <= 1800000 || bi.getInt(bnVar.hjk, 0) <= 0) {
                    return false;
                }
                bp.r(bnVar.key, bnVar.hjk);
                bnVar.hjk = "0";
                bnVar.hjl = System.currentTimeMillis();
                return true;
            }
        });
        this.hjr.put(Integer.valueOf(10237), new a() {
            public final boolean a(bn bnVar) {
                if (System.currentTimeMillis() - bnVar.hjl <= 1800000 || bi.getInt(bnVar.hjk, 0) <= 0) {
                    return false;
                }
                bp.r(bnVar.key, bnVar.hjk);
                bnVar.hjk = "0";
                bnVar.hjl = System.currentTimeMillis();
                return true;
            }
        });
        this.hjr.put(Integer.valueOf(10238), new a() {
            public final boolean a(bn bnVar) {
                if (System.currentTimeMillis() - bnVar.hjl <= 1800000 || bi.getInt(bnVar.hjk, 0) <= 0) {
                    return false;
                }
                bp.r(bnVar.key, bnVar.hjk);
                bnVar.hjk = "0";
                bnVar.hjl = System.currentTimeMillis();
                return true;
            }
        });
        this.hjr.put(Integer.valueOf(10239), new a() {
            public final boolean a(bn bnVar) {
                if (System.currentTimeMillis() - bnVar.hjl <= 1800000 || bi.getInt(bnVar.hjk, 0) <= 0) {
                    return false;
                }
                bp.r(bnVar.key, bnVar.hjk);
                bnVar.hjk = "0";
                bnVar.hjl = System.currentTimeMillis();
                return true;
            }
        });
    }

    public static bp HY() {
        if (hjs == null) {
            hjs = new bp();
        }
        return hjs;
    }

    public static void r(int i, String str) {
        LinkedList linkedList = new LinkedList();
        aoc aoc = new aoc();
        aoc.pWg = i;
        aoc.pWq = str;
        linkedList.add(aoc);
        a(linkedList);
    }

    public static void a(LinkedList<aoc> linkedList) {
        if (g.Do().CF()) {
            g.Do();
            if (!com.tencent.mm.kernel.a.Cz()) {
                com.tencent.mm.bp.a aod = new aod();
                aod.kyB = linkedList;
                aod.kyA = linkedList.size();
                ((h) g.h(h.class)).Fe().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(36, aod));
            }
        }
    }

    public final void c(int i, Object... objArr) {
        a aVar = (a) this.hjr.get(Integer.valueOf(i));
        if (aVar != null) {
            bo Ia = Ia();
            for (bn bnVar : Ia.hjm) {
                if (bnVar.key == i) {
                    aVar.a(bnVar, objArr);
                    break;
                }
            }
            Ia.hjm.add(aVar.d(i, objArr));
            a(Ia);
        }
    }

    public final void HZ() {
        if (System.currentTimeMillis() - this.hjq >= 60000) {
            this.hjq = System.currentTimeMillis();
            try {
                bo Ia = Ia();
                int i = 0;
                for (bn bnVar : Ia.hjm) {
                    int i2;
                    a aVar = (a) this.hjr.get(Integer.valueOf(bnVar.key));
                    if (aVar == null || !aVar.a(bnVar)) {
                        i2 = i;
                    } else {
                        i2 = 1;
                    }
                    i = i2;
                }
                if (i != 0) {
                    a(Ia);
                }
            } catch (Throwable e) {
                x.e("MicroMsg.StatisticsKVReportLogic", "exception:%s", bi.i(e));
            }
        }
    }

    private static bo Ia() {
        if (g.Do().CF()) {
            g.Do();
            if (!(com.tencent.mm.kernel.a.Cz() || g.Dq().Db() == null)) {
                byte[] Wj = bi.Wj((String) g.Dq().Db().get(8215, null));
                if (Wj.length <= 0) {
                    return new bo();
                }
                try {
                    bo boVar = new bo();
                    boVar.aH(Wj);
                    return boVar;
                } catch (Throwable e) {
                    x.e("MicroMsg.StatisticsKVReportLogic", "exception:%s", bi.i(e));
                }
            }
        }
        return new bo();
    }

    private static void a(bo boVar) {
        if (boVar != null && g.Do().CF() && g.Dq().Db() != null) {
            g.Do();
            if (!com.tencent.mm.kernel.a.Cz()) {
                try {
                    g.Dq().Db().set(8215, bi.bA(boVar.toByteArray()));
                } catch (Throwable e) {
                    x.e("MicroMsg.StatisticsKVReportLogic", "exception:%s", bi.i(e));
                }
            }
        }
    }
}
