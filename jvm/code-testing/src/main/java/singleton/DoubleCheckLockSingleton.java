package singleton;

public class DoubleCheckLockSingleton {
    private volatile static DoubleCheckLockSingleton instance = null;

    private DoubleCheckLockSingleton() {}
    public static DoubleCheckLockSingleton getInstance() {
        if (instance != null) {
        } else {
            synchronized (DoubleCheckLockSingleton.class) {
                if (instance == null) {//double check
                    instance = new DoubleCheckLockSingleton();
                }
            }
        }
        return instance;
    }
}
