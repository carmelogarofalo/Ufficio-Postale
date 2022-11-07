import java.util.concurrent.ThreadPoolExecutor;

public class Persone implements Runnable
{
    private int ticket;
    public Persone(int ticket)
    {
        this.ticket = ticket;
    }

    @Override
    public void run()
    {
        try
        {
            System.out.print("Persona con ticket: " + this.ticket + " servito allo sportello\n");
            Thread.sleep((long) (Math.random()*2100));
            System.out.print("Persona con ticket: " + this.ticket + " terminato\n");

        } catch (InterruptedException e) {throw new RuntimeException(e);}
    }

}
