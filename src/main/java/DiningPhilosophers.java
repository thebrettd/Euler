/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 10/21/12
 * Time: 9:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class DiningPhilosophers {

    Object[] forks;
    Philosopher[] philosophers;

    public DiningPhilosophers(int dinerCount){
        this.forks = new Object[dinerCount];
        this.philosophers = new Philosopher[dinerCount];

        for (int i=0;i<dinerCount;++i){
            forks[i] =  new Object();


            Philosopher philosopher = null;
            if (i==0){
                philosopher = new Philosopher(i,i,dinerCount-1, forks );
            }else{
                philosopher = new Philosopher(i,i-1,i, forks);
            }
            philosophers[i] = philosopher;
        }
    }

    private int getNumPhilosophers(){
        return forks.length;
    }

    private void beginEating() throws InterruptedException{
        for (int i=0;i<philosophers.length;++i){
            this.philosophers[i].start();
        }
        this.philosophers[0].join();
    }

    public static void main (String[] args){

        DiningPhilosophers d = new DiningPhilosophers(5);

        try{
            for (int i=0;i<d.getNumPhilosophers();++i){
                d.beginEating();

            }
        }catch(InterruptedException e){
            System.out.println("Philospohers dinner was interrupted");
        }




    }
}
