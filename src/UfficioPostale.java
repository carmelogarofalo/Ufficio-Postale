import java.util.concurrent.*;

public class UfficioPostale
{

    public static void main(String[] args) throws InterruptedException {

        int k = 10;
        int ticket = 0;
        boolean cicle = true;
        LinkedBlockingQueue<Runnable> sala1 = new LinkedBlockingQueue<>();
        BlockingQueue<Runnable> sala2 = new ArrayBlockingQueue<>(k);
        ExecutorService service = new ThreadPoolExecutor(4,4,500, TimeUnit.MILLISECONDS, sala2);
        ((ThreadPoolExecutor)service).allowCoreThreadTimeOut(true);

        System.out.print("APERTURA UFFICIO\n");

        Cliente cliente = new Cliente(sala1);
        cliente.start();

        while(cicle)
        {
            try
            {
                while(sala2.size() == k)
                {
                    System.out.print("\nSALA 2 PIENA\n\n");
                    Thread.sleep(3000);
                    if( ((ThreadPoolExecutor)service).getActiveCount() == 0) cicle = false;
                }

                service.execute(sala1.take());

                ticket++;
                Thread.sleep(100);

            } catch (InterruptedException e) {throw new RuntimeException(e);}
        }

        cliente.pause();
        service.shutdown();

        Thread.sleep(200);
        System.out.println("\nUFFICIO CHIUSO\n");

    }

}
