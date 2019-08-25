package Nbody;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by baoyu on 2019/8/25.
 */


public class NBody {
    /**
     * Read the second line in the file using the method in In.java
     */
    public static double readRadius(String fileName) {
        File file=new File(fileName);
        In in=new In(file);
        in.readLine();
        return Double.parseDouble(in.readLine());
    }
    public static Body[]readBodies(String fileName)
    {
        File file=new File(fileName);
        In in=new In(file);
        int num=in.readInt();
        Body planet[]=new Body[num];
        String lines[]=in.readAllLines();
        for(int i=0;i<num;i++)
        {
            String mark[]=lines[i+2].split("\\s+");
           planet[i]=new Body(Double.parseDouble(mark[1]),Double.parseDouble(mark[2]),Double.parseDouble(mark[3]),Double.parseDouble(mark[4]),Double.parseDouble(mark[5]),mark[6]);
        }
        return planet;
    }

  public static void main(String []args)
    {
        double T=Double.parseDouble(args[0]);
        double dt=Double.parseDouble(args[1]);
        String filename=args[2];
        Body bodies[]= readBodies(filename);
        double radius=readRadius(filename);
        StdDraw.setXscale(0-radius, radius);
        StdDraw.setYscale(0-radius, radius);

        StdDraw.enableDoubleBuffering();
        double time=0;
        while(time<=T) {
            double xForces[]=new double[bodies.length];
            double yForces[]=new double[bodies.length];
            for(int i=0;i<bodies.length;i++)
            {
                for(int j=0;j<bodies.length;j++)
                {
                    if(i!=j)
                    {
                        xForces[i]+=bodies[i].calcForceExertedByX(bodies[j]);
                        yForces[i]+=bodies[i].calcForceExertedByY(bodies[j]);
                    }
                }
            }
            for(int i=0;i<bodies.length;i++)
            {
                bodies[i].update(dt,xForces[i],yForces[i]);
            }
            StdDraw.picture(0, 0, "C:\\Users\\baoyu\\Desktop\\CS61B\\src\\Nbody\\images\\starfield.jpg");
            for (int i = 0; i < bodies.length; i++) {
                bodies[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time=time+dt;
            System.out.println(time);
        }
        System.out.printf("%d\n", bodies.length);
        System.out.printf("%.2e\n", radius);
        for (int i = 0; i < bodies.length; i++) {
            System.out.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                    bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);
        }
    }
}


       /* {File file=new File(fileName);
        BufferedReader reader=null;
        try{
            reader =new BufferedReader(new FileReader(file));
            String tempString=null;
            for(int line=1;line<3;line++)
            {
                tempString=reader.readLine();
            }
            reader.close();
            return Double.parseDouble(tempString);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }*/

