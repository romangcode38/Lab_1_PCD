class Nume extends Thread{
    private String nume = " gr.201 Grib Roman";
    public void run() {
        for(int i=0;i<nume.length(); i++) {
            System.out.print(nume.charAt(i));
            try{
                Thread.sleep(100);
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Counter extends Thread{
    private int from, to, step;
    private int[]tablou;

    public Counter(int from, int to, int step, int[] tablou) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.tablou = tablou;
    }
    Thread cnt1 = new Thread() {
        public void run() {
            int s1=0, s2=0, s=0, sum=0; int count=0;
            int i=from;
            for(i=0;i<tablou.length;i++) {
                if(tablou[i] % 2 != 0) {
                    s1=tablou[i];
                    System.out.print(getName()+" Primul element impar: "+s1+" pozitia: "+i+" \n");
                    for(int j=i+=step;j<tablou.length;j++) {
                        if(tablou[j] % 2 !=0 ) {
                            s2=tablou[j];
                            count++;
                            System.out.print(getName()+" Al doilea elem impar: "+s2+" pozitia: "+j+"\n");
                            i=j;
                            s=s1*s2;
                            System.out.print(getName()+" Produsul: "+s+"\n");

                            if(count==1) {
                                sum=s;
                            }
                            if(count==2) {
                                sum=s+sum;
                                System.out.println(getName()+"--Suma produselor este: "+sum);
                                count = 0;
                            }
                            System.out.print("\n\n");
                            break;
                        }
                    }
                }
            }

        }
    };
    Thread cnt2 = new Thread() {
        public void run() {
            int s1=0, s2=0, s=0, sum=0; int count=0;
            int i=from;
            for(i=tablou.length-1;i>=0;i--) {
                if(tablou[i] % 2 != 0) {
                    s1=tablou[i];
                    System.out.print(getName()+" Primul element impar: "+s1+" pozitia: "+i+" \n");
                    for(int j=i-step;j>=0;j--) {
                        if(tablou[j] % 2 !=0 ) {
                            s2=tablou[j];
                            count++;
                            System.out.print(getName()+" Al doilea elem impar: "+s2+" pozitia: "+j+"\n");
                            i=j;
                            s=s1*s2;
                            System.out.print(getName()+" Produsul: "+s+"\n");
                            if(count==1) {
                                sum=s;
                            }
                            if(count==2) {
                                sum=s+sum;
                                System.out.println(getName()+"--Suma produselor este: "+sum);
                                count = 0;
                            }
                            System.out.print("\n\n");
                            break;
                        }
                    }
                }
            }
        }
    };
}

public class Lab1_PCD {

    public static void main(String[] args)  {

        int[] tablou = new int[100];
        for(int i=0; i<tablou.length; i++) {
            tablou[i]=(int)(Math.random()*100);
            if(i==20) {
                System.out.println("");
            }
            if(i==40) {
                System.out.println("");
            }
            if(i==60) {
                System.out.println("");
            }
            if(i==80) {
                System.out.println("");
            }
            if(i==90) {
                System.out.println("");
            }
            System.out.print(tablou[i]+":"+i+", ");
        }
        System.out.println(" \n");
        Thread tred1 = new Counter(0, 99, 1, tablou).cnt1;
        Thread tred2 = new Counter(99, 0, 1, tablou).cnt2;
        Nume   tred3;
        tred1.setName("S1");
        tred2.setName("S2");
        tred1.start();
        tred2.start();
        tred3 = new Nume();
        tred3.start();
    }
}