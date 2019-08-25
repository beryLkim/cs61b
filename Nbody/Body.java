package Nbody;

import java.awt.*;

/**
 * Created by baoyu on 2019/8/25.
 */
public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static final double G=6.67*Math.pow(10,-11);
    public Body(double xP, double yP, double xV, double yV, double m, String img)
    {
        xxPos=xP;
        yyPos=yP;
        xxVel=xV;
        yyVel=yV;
        mass=m;
        imgFileName=img;
    }
    public Body(Body b)
    {
        xxPos=b.xxPos;
        yyPos=b.yyPos;
        xxVel=b.xxVel;
        yyVel=b.yyVel;
        mass=b.mass;
        imgFileName=b.imgFileName;
    }
    public double calcDistance(Body b)
    {
        return Math.sqrt((b.xxPos-xxPos)*(b.xxPos-xxPos)+(b.yyPos-yyPos)*(b.yyPos-yyPos));
    }
    public double calcForceExertedBy(Body b)
    {
        return G*b.mass*this.mass/Math.pow(this.calcDistance(b),2);
    }
    public double calcForceExertedByX(Body b)
    {
        return calcForceExertedBy(b)*(b.xxPos-this.xxPos)/calcDistance(b);
    }
    public double calcForceExertedByY(Body b)
    {
        return calcForceExertedBy(b)*(b.yyPos-this.yyPos)/calcDistance(b);
    }
    public void update(double dt,double fX,double fY)
    {

        this.xxVel+=dt*fX/this.mass;
        this.yyVel+=dt*fY/this.mass;
        this.xxPos+=dt*xxVel;
        this.yyPos+=dt*yyVel;
    }
    public void draw()
    {
        //String img="C:\\Users\\baoyu\\Desktop\\CS61B\\src\\Nbody\\images"+imgFileName;
        StdDraw.picture(xxPos,yyPos,"C:\\Users\\baoyu\\Desktop\\CS61B\\src\\Nbody\\images\\"+imgFileName);
    }
}
