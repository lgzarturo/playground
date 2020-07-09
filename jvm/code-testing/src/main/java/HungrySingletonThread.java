import singleton.*;

public class HungrySingletonThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hungry: " + HungrySingleton.getInstance().hashCode());
        System.out.println("Lazy: " + LazySingleton.getInstance().hashCode());
        System.out.println("Lazy Sync: " + LazySingletonSync.getInstance().hashCode());
        System.out.println("Lazy Sync Block: " + LazySingletonSync.getInstanceBySyncBlock().hashCode());
        System.out.println("Lazy Sync Smaller: " + LazySingletonSync.getInstanceBySmallerSyncBlock().hashCode());
        System.out.println("Double Check Sync: " + DoubleCheckLockSingleton.getInstance().hashCode());
        System.out.println("Inner class: " + InnerClassSingleton.getInstance().hashCode());
    }

    public static void main(String[] args) {
         hungry();
    }

    public static void hungry() {
        HungrySingletonThread[] mts = new HungrySingletonThread[10];
        for (int i = 0; i < mts.length; i++) {
            mts[i] = new HungrySingletonThread();
        }
        for (int i = 0; i < mts.length; i++) {
            mts[i].start();
        }
    }
}
