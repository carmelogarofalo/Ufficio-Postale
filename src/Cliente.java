import java.util.concurrent.LinkedBlockingQueue;

public class Cliente extends Thread
{
    boolean cicle = true;
    LinkedBlockingQueue<Runnable> sala1 = new LinkedBlockingQueue<>();

    public Cliente( LinkedBlockingQueue<Runnable> sala1)
    {
        this.sala1=sala1;
    }

    public void run()
    {

        int ticket = 0;

        while(cicle)
        {
            try
            {
                Thread.sleep(100);

                Persone persone = new Persone(ticket);
                this.sala1.add(persone);

                ticket++;

            } catch (InterruptedException e) {throw new RuntimeException(e);}
        }
    }
    public void pause()
    {
        this.cicle = false;
    }

}
