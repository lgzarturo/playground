public class ExceptionsTest {

    public static void main(String[] args) throws InterruptedException {
        throwException();
        exception();
    }

    public static void throwException() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("Hello Java!");
    }

    public static void exception() {
        System.out.println("Start");
        int x=4,y=5,z=0;
        String name="abcd";
        int[] xr= new int[4];

        try{
            xr[x]=name.charAt(y)/2;
        }catch (StringIndexOutOfBoundsException e){
            System.out.println(e);
        }catch (RuntimeException e){
            System.out.println("ok");
            System.out.println(e);
        }catch (Exception e){
            System.out.println(e);
        }finally {
            System.out.println("Finally");
        }
        System.out.println("End. ");
    }
}
