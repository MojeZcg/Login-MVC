package controller;

public class ControllerConstruction{
    public static double tPrice;
    public static double price;
    public static double m2;
    public static String nCalle;

    public ControllerConstruction(double price, double m2, String nCalle) {
        this.price = price;
        this.m2 = m2;
        this.nCalle = nCalle;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getM2() {
        return m2;
    }

    public void setM2(double m2) {
        this.m2 = m2;
    }

    public String getnCalle() {
        return nCalle;
    }

    public void setnCalle(String nCalle) {
        this.nCalle = nCalle;
    }
}

class Build extends ControllerConstruction{
    public static int  pisos;
    public static int dep;
    public static boolean asc;

    public Build(int pisos, int dep, boolean asc, double price, double m2, String nCalle) {
        super(price, m2, nCalle);
        Build.pisos = pisos;
        Build.dep = dep;
        Build.asc = asc;
    }
    
    public static int getPisos() {
        return pisos;
    }

    public static void setPisos(int pisos) {
        Build.pisos = pisos;
    }

    public static int getDep() {
        return dep;
    }

    public static void setDep(int dep) {
        Build.dep = dep;
    }

    public static boolean isAsc() {
        return asc;
    }

    public static void setAsc(boolean asc) {
        Build.asc = asc;
    }
}

class Home extends ControllerConstruction{
    public static int bh;
    public static int hab;
    public static boolean p;
    public static boolean zCen;

    public  Home(int bh, int hab, boolean p, boolean zCen, double price, double m2, String nCalle) {
        super(price, m2, nCalle);
        Home.bh = bh;
        Home.hab = hab;
        Home.p = p;
        Home.zCen = zCen;
    }
    
    public static int idHome(String nC, double tP){
        return model.ModelConstruction.LoadHome(nC,tP);
    }

    public static int getBh() {
        return bh;
    }

    public static void setBh(int bh) {
        Home.bh = bh;
    }

    public static int getHab() {
        return hab;
    }

    public static void setHab(int hab) {
        Home.hab = hab;
    }

    public static boolean isP() {
        return p;
    }

    public static void setP(boolean p) {
        Home.p = p;
    }

    public static boolean iszCen() {
        return zCen;
    }

    public static void setzCen(boolean zCen) {
        Home.zCen = zCen;
    }    
}