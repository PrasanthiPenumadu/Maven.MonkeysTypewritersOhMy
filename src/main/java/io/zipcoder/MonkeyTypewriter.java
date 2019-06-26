package io.zipcoder;

public class MonkeyTypewriter {
    public static void main(String[] args) {
        String introduction = "It was the best of times,\n" +
                "it was the blurst of times,\n" +
                "it was the age of wisdom,\n" +
                "it was the age of foolishness,\n" +
                "it was the epoch of belief,\n" +
                "it was the epoch of incredulity,\n" +
                "it was the season of Light,\n" +
                "it was the season of Darkness,\n" +
                "it was the spring of hope,\n" +
                "it was the winter of despair,\n" +
                "we had everything before us,\n" +
                "we had nothing before us,\n" +
                "we were all going direct to Heaven,\n" +
                "we were all going direct the other way--\n" +
                "in short, the period was so far like the present period, that some of\n" +
                "its noisiest authorities insisted on its being received, for good or for\n" +
                "evil, in the superlative degree of comparison only.";

        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.
    UnsafeCopier usc=new UnsafeCopier(introduction);
    Thread m1=new Thread(usc);
    Thread m2=new Thread(usc);
        Thread m3=new Thread(usc);
        Thread m4=new Thread(usc);
        Thread m5=new Thread(usc);
        m1.start();
        m2.start();
        m3.start();
        m4.start();
        m5.start();
        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
       SafeCopier sc=new SafeCopier(introduction);
        Thread m11=new Thread(sc);
        Thread m21=new Thread(sc);
        Thread m31=new Thread(sc);
        Thread m41=new Thread(sc);
        Thread m51=new Thread(sc);
        m11.start();
        m21.start();
        m31.start();
        m41.start();
        m51.start();
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }

        // Print out the copied versions here.
        System.out.println(sc.copied);
        System.out.println(usc.copied);
    }
}