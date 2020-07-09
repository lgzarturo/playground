package singleton;

public class InnerClassSingleton {
    private static class MySingletonHandler{
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }
    private InnerClassSingleton(){}
    public static InnerClassSingleton getInstance() {
        return MySingletonHandler.instance;
    }
}
