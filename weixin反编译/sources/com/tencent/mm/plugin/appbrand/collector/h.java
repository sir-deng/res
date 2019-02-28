package com.tencent.mm.plugin.appbrand.collector;

import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class h implements b {
    private Map<String, CollectSession> gOF = new a();
    private Map<String, Set<CollectSession>> iOV = new a();

    private boolean a(String str, CollectSession collectSession) {
        if (str == null || str.length() == 0 || collectSession == null) {
            return false;
        }
        Set set = (Set) this.iOV.get(str);
        if (set == null) {
            set = new LinkedHashSet();
            this.iOV.put(str, set);
        }
        return set.add(collectSession);
    }

    private Set<CollectSession> qP(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return (Set) this.iOV.get(str);
    }

    public final void clear() {
        this.gOF.clear();
        this.iOV.clear();
    }

    private CollectSession qQ(String str) {
        CollectSession collectSession = (CollectSession) this.gOF.get(str);
        if (collectSession != null) {
            return collectSession;
        }
        collectSession = new CollectSession(str);
        this.gOF.put(str, collectSession);
        return collectSession;
    }

    public final void a(CollectSession collectSession) {
        String str = collectSession.id;
        CollectSession collectSession2 = (CollectSession) this.gOF.get(str);
        if (collectSession2 == null) {
            this.gOF.put(str, collectSession);
            a(collectSession.groupId, collectSession);
            return;
        }
        TimePoint timePoint = collectSession.iOL;
        if (collectSession2.iOL == null) {
            collectSession2.iOL = timePoint;
            return;
        }
        while (timePoint != null) {
            String str2 = timePoint.name;
            long j = timePoint.iOX.get();
            if (!(str == null || str.length() == 0)) {
                CollectSession qQ = qQ(str);
                if (qQ.iOL == null) {
                    qQ.qF(str2);
                    qQ.iOL.iOX.set(j);
                } else {
                    TimePoint timePoint2 = (TimePoint) qQ.iON.get(str2);
                    if (timePoint2 == null) {
                        qQ.qG(str2);
                        qQ.iOM.iOX.set(j);
                    } else {
                        timePoint2.iOX.set((j + (timePoint2.iOX.get() * ((long) timePoint2.iOW.get()))) / ((long) (timePoint2.iOW.get() + 1)));
                        timePoint2.iOW.getAndIncrement();
                    }
                }
            }
            timePoint = (TimePoint) timePoint.iOY.get();
        }
    }

    public final CollectSession aU(String str, String str2) {
        if (str == null || str.length() == 0) {
            x.i("MicroMsg.SumCostTimeCollector", "join(%s) failed, sessionId is null or nil.", str2);
            return null;
        }
        CollectSession qQ = qQ(str);
        if (qQ.iOL == null) {
            qQ.qF(str2);
            return qQ;
        }
        qQ.qG(str2);
        return qQ;
    }

    public final void f(String str, String str2, boolean z) {
        if (!z) {
            return;
        }
        if (str == null || str.length() == 0) {
            x.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, sessionId is null or nil.", str2);
            return;
        }
        CollectSession qQ = qQ(str);
        if (qQ.iOL == null) {
            qQ.qF(str2);
        } else {
            qQ.qG(str2);
        }
    }

    public final void c(String str, String str2, String str3, boolean z) {
        if (!z) {
            return;
        }
        if (str2 == null || str2.length() == 0) {
            x.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, sessionId is null or nil.", str3);
        } else if (str == null || str.length() == 0) {
            x.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, groupId is null or nil.", str3);
        } else {
            CollectSession qQ = qQ(str2);
            if (qQ.iOL == null) {
                qQ.groupId = str;
                a(str, qQ);
                qQ.qF(str3);
                return;
            }
            qQ.qG(str3);
        }
    }

    public final CollectSession qH(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return (CollectSession) this.gOF.get(str);
    }

    public final CollectSession qI(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return (CollectSession) this.gOF.remove(str);
    }

    public final void aV(String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            x.i("MicroMsg.SumCostTimeCollector", "setLastPointName(%s, %s) failed, sessionId is null or nil.", str, str2);
            return;
        }
        CollectSession collectSession = (CollectSession) this.gOF.get(str);
        if (collectSession == null) {
            x.i("MicroMsg.SumCostTimeCollector", "setLastPointName(%s, %s) failed,", str, str2);
            return;
        }
        collectSession.iOO = str2;
    }

    public final void print(String str) {
        CollectSession collectSession = (CollectSession) this.gOF.get(str);
        if (collectSession == null) {
            x.i("MicroMsg.SumCostTimeCollector", "print failed, session(%s) is null", str);
            return;
        }
        TimePoint timePoint = collectSession.iOL;
        if (timePoint == null) {
            x.i("MicroMsg.SumCostTimeCollector", "print failed, the session(%s) do not have any point.", str);
            return;
        }
        e.a(timePoint).insert(0, String.format("session : %s\n", new Object[]{collectSession.id}));
        x.i("MicroMsg.SumCostTimeCollector", "%s", r1.toString());
    }

    public final StringBuilder qJ(String str) {
        Collection qP = qP(str);
        if (qP == null || qP.isEmpty()) {
            x.i("MicroMsg.SumCostTimeCollector", "printAverage failed, set(%s) is empty.", str);
            return new StringBuilder().append(String.format("GroupId : %s, size : 0\n", new Object[]{str}));
        }
        Set<CollectSession> linkedHashSet = new LinkedHashSet(qP);
        TimePoint timePoint = new TimePoint();
        for (CollectSession collectSession : linkedHashSet) {
            if (collectSession.iOM == null || !(collectSession.iOO == null || collectSession.iOM.name.equals(collectSession.iOO))) {
                x.e("MicroMsg.SumCostTimeCollector", "error(%s), incorrect point count", collectSession.id);
            } else {
                TimePoint timePoint2 = collectSession.iOL;
                TimePoint timePoint3 = timePoint;
                while (timePoint2 != null) {
                    timePoint3.iOX.set(((timePoint3.iOX.get() * ((long) timePoint3.iOW.get())) + timePoint2.iOX.get()) / ((long) timePoint3.iOW.incrementAndGet()));
                    timePoint3.name = timePoint2.name;
                    timePoint2 = (TimePoint) timePoint2.iOY.get();
                    if (timePoint3.iOY.get() == null && timePoint2 != null) {
                        timePoint3.iOY.set(new TimePoint());
                    }
                    timePoint3 = (TimePoint) timePoint3.iOY.get();
                }
            }
        }
        StringBuilder a = e.a(timePoint);
        a.insert(0, String.format("GroupId : %s, size : %d\n", new Object[]{str, Integer.valueOf(linkedHashSet.size())}));
        return a;
    }

    public final int aW(String str, String str2) {
        Collection qP = qP(str);
        if (qP == null || qP.isEmpty()) {
            x.i("MicroMsg.SumCostTimeCollector", "printAverage failed, set(%s) is empty.", str);
            return 0;
        }
        int i = 0;
        int i2 = 0;
        for (CollectSession collectSession : new LinkedHashSet(qP)) {
            int i3 = collectSession.fxY.getInt(str2);
            if (i3 != 0) {
                i2 += i3;
                i++;
            }
        }
        if (i != 0) {
            return i2 / i;
        }
        return 0;
    }
}
