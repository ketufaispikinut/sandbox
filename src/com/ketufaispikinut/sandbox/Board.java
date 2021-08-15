package com.ketufaispikinut.sandbox;


//That my child is alota imports
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;
public class Board extends JPanel implements ActionListener{

    private Timer timer;
    //private Eye eye;
    //private List<Mouth> Mouths;
    //private List<Teeth> Teeths;
    //private List<Nose> Noses;
    //private List<Ant> Ants;
    //private List<Food> Foods;
    //private List<Wall> Walls;
    //private Controler CTRL;
    //private boolean ingame;
    //private final String wcause = "You won!";
    //private final String lcause = "You lost";
    //private String cuz = "Do you like trains?";
    private final int ICRAFT_X = 40;
    private final int ICRAFT_Y = 60;
    private final int B_WIDTH = 1000;//400;
    private final int B_HEIGHT = 700;//400;
    private final int DELAY = 0;//15;//100-100+15
    private double FOOD =20;
    private int[][] n=new int[400][300];
    private long START=new Date().toInstant().getEpochSecond();
    private PosMouseListener PML;
    public boolean MousePressed=false;
    public int MouseX=0;
    public int MouseY=0;
    private int[][] e;
    private int PlayerSand=Sand.SAND;
    private int PlayerSandWich=1;//0;
    public static String credits= "A SandBox Made By KetuFaisPikinut      (github.com/KeTuFaisPiKiNut)";// The n come from some AN on the beginning of the string that i removed latter
    private int PlayerScale=0;
    private long dtT=new Date().getTime();//je-
    private float TEMP=1;//  \/ static //int
    private String HELP= """
            HELP FOR THOSE WHO GOT NO IDEA WHAT THIS IS\n
            
            This is a game about sand and diverse other things that\n
             make no sense.\n
            Here are the controls;\n
            \n
             - Left/Right Arrow: Change Pencil Size\n
             - Up/Down Arrow: Change Sand Selection\n
             - Move Mouse: Movez Pencil\n
             - Use Mouse: Use Pencil\n
             - R: Reset
            Also the topmost element in the sand selection pannel (the left collumn)\n
            is an eraser. You can see what you are pointing at the bottom left . \n
            At the bottom right there is two integers, the left one is your pencil size\n
            and the right one is the temperature of the map.\n
            -KTFPKN
            
           
            """;//right
    public Board() {// P.S.: Have Fun Guessing What The Elements Are

        initBoard();

    }
    //static
    public void explode(int x, int y,int radius/*,int Strength*/){//*,int bonk
        e[x][y] = Sand.NOTHING;
        for(int tx = x - radius; tx < x + radius + 1; tx++) {
            for(int ty = y - radius; ty < y + radius + 1; ty++)
                if(getAtPos(tx,ty,e)!=Sand.WALL && Math.sqrt(Math.pow(x - tx, 2) + Math.pow(y - ty, 2)) <= radius) {
                    if(Math.random()>0.8)e[tx][ty] =Sand.FIRE;// Sand.NOTHING;//&&
                    else{e[tx][ty]=Sand.NOTHING;}
                    n[tx][ty] =Sand.NOTHING;//Sand.FIRE;// Sand.NOTHING;

                }
        }

    }
    public void initBoard() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        //ingame = true;

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        // eye = new Eye(ICRAFT_X, ICRAFT_Y);
        //CTRL=new Controler(500, 350);
        init();
        //initFoods();
        //initWalls();
        //pinitMouths();
        ///initTeeths();
        //initNoses();
        PML=new PosMouseListener(this);
        addMouseListener(PML);
        timer = new Timer(DELAY, this);
        timer.start();
    }


    public void init(){//AntsAntsAntsAntsAnts
       // Ants=new ArrayList<>();
        //Ants.add(new Ant(200,200));//Da first one
        //Ants.add(new Ant(200,200));
        //Da copied ones
        //Ants.add(new Ant(200,200));
     //   for(int i=0;i<50;i++){//here was once  2
     //       System.out.println(i);
     //       Ants.add(new Ant(500,350));
     //   }
        //n[100][0]=Sand.SAND;
       // SimplexNoise N=new SimplexNoise(1,(double)3,(int)Math.random()*123123);//new Date().toInstant().getNano()
        //for(int i=0;i<n.length;i++){
        //    for(int j=0;j<n[i].length;j++){
        //        //System.out.println(N.getNoise(i,j));
        //        if(Math.random()>0.99){//&&j>60//N.getNoise(i,j)>0
        //
        //            n[i][j]=Sand.WALL;
        //
        //        }
        //    }
        //}//Rip two / and a o
    }
    public double calculateDistanceBetweenPoints(
            double x1,
            double y1,
            double x2,
            double y2) {
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

////if (ingame) {
        BufferedImage E=new BufferedImage(400+100+50,300+50,BufferedImage.TYPE_3BYTE_BGR);//0
        Graphics gE=E.getGraphics();
        drawObjects(gE);
        g.drawImage(E, 0, 0, (400 + 100 + 50) * Main.W, (300 + 50) * Main.H, new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });//400
        //g.d
        // } else {

        //  drawGameOver(g);
        //}

        Toolkit.getDefaultToolkit().sync();
    }
    private void SquareCollision(int a,int b,int c,int d,int e,int f,int g,int h){}
    private void drawObjects(Graphics g) {
        //Fill Background
        //g.setColor(Color.WHITE);
       // g.setColor(Color.black);
        //Time
        // .

        long ct=new Date().getTime();//.
        long TimeD=ct-dtT;
        //dtT=ct;
        //g.fillRect(0, 0, 800, 800);//1010

        g.setColor(Color.gray);
        //g.fillRect(0, 0,400+100/2,50/2);
        //g.fillRect(0, 0,50/2,300+100/2);
        //g.fillRect(0,800+25,400+25,300+25);
        g.fillRect(0,300,400,400);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(400,0,4,400);//400
        //g.setColor(Color.GRAY);
        //g.fillRect(404,0,400,400);
        //g.setColor(Color.lightGray);
        //g.fillRect(25,25,400+50,300+50);
        for(int i=0;i<Sand.INVENTORY.length;i++){
            g.setColor(Color.RED);
            //50//50
            //boolean n=
            if(Sand.INVENTORY[i]==Sand.SAND)g.setColor(Color.yellow);
            //if(Sand.INVENTORY[i]==Sand.)g.setColor(Color.);
            if(Sand.INVENTORY[i]==Sand.WATER)g.setColor(Color.BLUE);
            if(Sand.INVENTORY[i]==Sand.NOTHING)g.setColor(Color.WHITE);
            if(Sand.INVENTORY[i]==Sand.WALL)g.setColor(Color.LIGHT_GRAY);
            if(Sand.INVENTORY[i]==Sand.STONE)g.setColor(Color.GRAY);
            if(Sand.INVENTORY[i]==Sand.LAVA)g.setColor(Color.ORANGE);
            if(Sand.INVENTORY[i]==Sand.ACID)g.setColor(Color.GREEN);////useless /! Rip ACID GO and ACID GO BRRRRRRRRRRR
            if(Sand.INVENTORY[i]==Sand.ICE)g.setColor(Color.CYAN);
            if(Sand.INVENTORY[i]==Sand.FIRE)g.setColor(Color.RED);////Burn Baby Burn!
            if(Sand.INVENTORY[i]==Sand.WOOD)g.setColor(new Color(0x997114));//BRO);//.//""#FFEEDDNN0xDDBBCCxEEDDCC (WHY 0?)
            if(Sand.INVENTORY[i]==Sand.MIST)g.setColor(new Color(0x193ea0));//LEAF//new Color(0x13E30F)
            if(Sand.INVENTORY[i]==Sand.DIRT)g.setColor(new Color(0x684818));//#
            g.setColor(Sand.COLORS[Sand.INVENTORY[i]+1]);//i+1
            if(25-20+i*(20+10)>350-50){
                g.fillRect(400 + 10+50, 25 - 20 + (i-10) * (20 + 10), 40, 20);//I had forgotten that ;90
                if(PlayerSandWich==i){//Scale)
                    //System.out.println("OOH!");
                    g.fillRect(400+8+10+50-10,25-20+(i-10)*(20+10)+20-5-10,2,10);

                }
                //BLACK//WHITE
                g.setColor(Color.BLACK);//400+8+10+50-10//25-20+(i-10)*(20+10)+20-5-10
                g.drawString(Sand.NAMES[Sand.INVENTORY[i]+1],400 + 10+50,25 - 20 + (i-10) * (20 + 10)+10);
            }
            else {
                g.fillRect(400 + 10, 25 - 20 + i * (20 + 10), 40, 20);//I had forgotten that ;90
                if(PlayerSandWich==i){
                    g.fillRect(400+8,25-20+i*(20+10)+20-5-10,2,10);

                }//BLACK//WHITE
                g.setColor(Color.BLACK);
                g.drawString(Sand.NAMES[Sand.INVENTORY[i]+1],400 + 10,25 - 20 + i * (20 + 10)+10);
            }

                //Rip part of Sand.Inventory...

        }
        for(int i=0;i<n.length;i++){
            for(int j=0;j<n[i].length;j++){
                /*if(n[i][j]==Sand.SAND){
                    g.setColor(Color.YELLOW);
                    //System.out.println("Drawing sand "+n.length);
                    g.fillRect(i,j,1,1);//Here lies an i
                }
                if(n[i][j]==Sand.WATER){
                    g.setColor(Color.blue);//{
                    g.fillRect(i,j,1,1);
                    //}
                }
                if(n[i][j]==Sand.WALL){//WATER
                    g.setColor(Color.lightGray);//{//blue
                    g.fillRect(i,j,1,1);
                    //}
                }
                if(n[i][j]==Sand.STONE){//WATERWALL
                    g.setColor(Color.gray);//{//blue
                    g.fillRect(i,j,1,1);
                    //}
                }
                if(n[i][j]==Sand.WETSAND){

                    g.setColor(new Color(100,120,40));
                    g.fillRect(i,j,1,1);
                }*/
               /* SAMPLE
                if(n[i][j]==Sand.){

                    g.setColor(Color.);
                    g.fillRect(i,j,1,1);
                }*/
                /*if(n[i][j]==Sand.LAVA){

                    g.setColor(Color.ORANGE);
                    g.fillRect(i,j,1,1);
                }
                if(n[i][j]==Sand.ACID){
    //                              | here
                    g.setColor(Color.GREEN);
                    g.fillRect(i,j,1,1);
                }
                if(n[i][j]==Sand.ICE){

                    g.setColor(Color.CYAN);//*l//ICE);
                    g.fillRect(i,j,1,1);
                }
                if(n[i][j]==Sand.FIRE){
                    g.setColor(Color.RED);
                    g.fillRect(i,j,1,1);
                };//new Color(0xDDBBCC)
                if(n[i][j]==Sand.WOOD){

                    g.setColor(new Color(0x997114));//Color.xDDBBCC xEEDDCC (xEEDDCC wasnt actually here (i mean it was but i didnt copy it, i copyed another))xEEDDCC
                    g.fillRect(i,j,1,1);
                }
                if(n[i][j]==Sand.LEAF){
                    g.setColor(new Color(0x13E30F));//f
                    g.fillRect(i,j,1,1);
                }
                if(n[i][j]==Sand.MIST){
                    g.setColor(new Color(0x193ea0));//Color.
                    g.fillRect(i,j,1,1);
                }
                if(n[i][j]==Sand.DIRT){
                    g.setColor(new Color(0x684818));//Colg
                    g.fillRect(i,j,1,1);
                }*/
                if(n[i][j]!=Sand.NOTHING){

                g.setColor(Sand.COLORS[n[i][j]+1]);//.}
                g.fillRect(i,j,1,1);}
            }
        }
        g.setColor(Color.red);
        g.fillRect(MouseX-1,MouseY-1,2,2);
        //g.setColor(Color.WHITE);
        g.setColor(Color.BLACK);//,
        g.drawString(credits,20,300-20+50-20+10);
        g.setColor(Color.WHITE);//t
        g.drawString(""+(PlayerScale+3),20+360-10+20+10+5,300-20+50-20);//

        if(TEMP>1)g.setColor(Color.RED);
        if(TEMP<1)g.setColor(Color.BLUE);
        //I Have No Idea
        //*10-10
        g.drawString(""+(Math.floor(TEMP-1)),20+400-10+20+10+5,300-20+50-20);

        //g.setColor(Color.WHITE);
        g.setColor(Color.YELLOW);
        g.drawString("HELP",0+20+450+40-5,0+20-10);
        if(MouseX>0+20+450+40-5&&MouseY<0+20-10){
            g.setColor(Color.GRAY);
            g.fillRect(0, 0,400,300);
            g.setColor(Color.BLACK);
            String[] help=HELP.split("\n");
            for(int i=0;i<help.length;i++){
                g.drawString(help[i],0+10,10+10*i);//p);00+10//200HELP
            }

        }
        //drawStrij
        g.setColor(Color.WHITE);
        g.drawString(Sand.NAMES[getAtPos(MouseX,MouseY,n)+1],20+360+40-10+20+10+5-10-30,300-20+50-20+20);
        g.drawString("UT: "+TimeD,20+400-10+20+10+5+20,300-20+50-20+10+10);//Dtt//20+360+40-10+20+10+5-10-30+40,300-20+50-20+20//40//dtT//0,20//FPS
        dtT=new Date().getTime();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        inGame();

        updateControls();//                                                                                      ();
        //updateAnts();
        update();
        //Consommation & Autres
        //FOOD-=((double)(Ants.size())/50)/20;
        /*if(FOOD>=100&&Ants.size()<=200){
            //Ants.add(new Ant(500, 350));
        }
        if(FOOD<=-10){
            //Ants.remove((int)Math.floor(Math.random()*Ants.size()));
        }
        CTRL.move();
        //checkCollisions();
        */
        repaint();
    }

    private void inGame() {

        // if (!ingame) {
        //timer.stop();

        //}
    }

    private void updateControls(){
        Point e=getMousePosition();
        if(e==null){//getMousePosition()

        }
        else {
            MouseX = e.x/Main.W;//2;//getMousePosition()
            MouseY = e.y/Main.H;//2;//getMousePosition()
        }
    }
    private int getAtPos(int x, int y,int[][] e){
        if(x>n.length-1||x<0||y>n[0].length-1||y<0){//i
            return Sand.WALL;
        }//[y]x
        else{
            if(e[x][y]!=Sand.NOTHING){
                return e[x][y];
            }
            else{
                return n[x][y];
            }
            //return e[x][y]||n[x][y];
        }
    }
    private void clampPlace(int SND,int x, int y){//Rip defs of e and n (and one e or a)
        int MouseXe=x;
        int MouseYe=y;

        if(x>399){
            MouseXe=399;
        }
        if(x<0){
            MouseXe=0;//RIP 2 MouseX
        }
        if(y>299){
            MouseYe=299;
        }
        if(y<0){//RIP 2 MouseY
            MouseYe=0;
        }

            n[MouseXe][MouseYe]=SND;//Sand.STONE;//Y dupeWATER//AND
            e[MouseXe][MouseYe]=SND;//Sand.STONE;//SAMEWATER//AND//Rip one /

    }
    private void update(){
        //System.out.println("UPDATING!");

        //System.out.println(n[0][0]);
        //for(int i=0;i)
        //n[50][50]=Sand.SAND;
        //n[100][50]=Sand.WATER;
        //n[150][50]=Sand.LAVA;
        //n[200][50]=Sand.STONE;
        //n[250][50]=Sand.WETSAND;
        //n[101][50]=Sand.WATER;
        //n[102][50]=Sand.WATER;
        //n[103][50]=Sand.WATER;
        e=new int[400][300];
        int scale=3+PlayerScale;//PO;
        float TEMP_O=TEMP;
        TEMP=1;
        for(int i=0;i<scale;i++){//3
            for(int j=0;j<scale;j++){
                if(MousePressed){
                //clampPlace(Sand.WALL,MouseX+i,MouseY+j);//,n,e
                    int SND=PlayerSand;//Sand.WALL;//.STONE and 2 , go RIP
                    int x=MouseX+i;
                    int y=MouseY+j;
                    int MouseXe=x-(int)Math.floor(scale/2);//M'a
                    int MouseYe=y-(int)Math.floor(scale/2);

                    if(MouseXe>399){//x
                        MouseXe=399;
                    }
                    if(MouseXe<0){//x
                        MouseXe=0;//RIP 2 MouseX
                    }
                    if(MouseYe>299){//y
                        MouseYe=299;
                    }
                    if(MouseYe<0){//RIP 2 MouseY//y
                        MouseYe=0;
                    }

                    n[MouseXe][MouseYe]=SND;//Sand.STONE;//Y dupeWATER//AND
                    e[MouseXe][MouseYe]=SND;//Sand.STONE;//SAMEWATER//AND//Rip one /
                }
            }
        }


        int z;
        for(int i=0;i<n.length;i++){
            for(int j=0;j<n[i].length;j++){
                int x=i;//j
                int y=j;//i
                int c=n[x][y];
                int below=getAtPos(x,y+1,e);
                int b1=getAtPos(x+1,y+1,e);//-
                int b2=getAtPos(x-1,y+1,e);//Here lies a + and a //-
                int l=getAtPos(x-1,y,e);
                int r=getAtPos(x+1,y,e);
                int up=getAtPos(x,y-1,e);
                int t1=getAtPos(x+1,y-1,e);//+1
                int t2=getAtPos(x-1,y-1,e);
                //e[x][y]=c;
                if(c==Sand.SAND){
                   //System.out.println("Sand go stonks"+"Y+ "+y+"X+ "+x);
                    e[x][y]=Sand.SAND;
                    if(up==Sand.WATER){
                        e[x][y]=Sand.WETSAND;//STONE;
                    }
                    else if(below==Sand.WATER){
                        e[x][y]=Sand.WETSAND;//STONE;
                    }
                    else if(l==Sand.WATER){
                        e[x][y]=Sand.WETSAND;////STONE;
                    }
                    else if(r==Sand.WATER){//Rip 2 or three =
                        e[x][y]=Sand.WETSAND;//STONE;
                    }

                    else if(below==Sand.NOTHING){
                        e[x][y]=Sand.NOTHING;
                        e[x][y+1]=Sand.SAND;
                    }
                    //else if(below==Sand.WATER){
                    //    e[x][y]=Sand.WATER;
                    //    e[x][y+1]=Sand.SAND;
                    //}
                    else if(b1==Sand.NOTHING&&below!=Sand.NOTHING){
                        e[x][y]=Sand.NOTHING;
                        e[x+1][y+1]=Sand.SAND;
                    }
                    //else if(b1==Sand.WATER&&below!=Sand.SAND){
                    //    e[x][y]=Sand.WATER;
                    //    e[x+1][y+1]=Sand.SAND;
                    //}
                    else if(b2==Sand.NOTHING&&below!=Sand.NOTHING){

                        e[x][y]=Sand.NOTHING;
                        e[x-1][y+1]=Sand.SAND;//+
                    }
                    //else if(b2==Sand.WATER&&below!=Sand.SAND){
                    //
                    //    e[x][y]=Sand.WATER;
                    //    e[x-1][y+1]=Sand.SAND;//+
                    //}
                    /*else{
                    if(b1==Sand.NOTHING){
                       e[x][y]=Sand.NOTHING;
                        e[x+1][y+1]=Sand.SAND;
                    }
                    else{ if(b2==Sand.NOTHING){
                        e[x][y]=Sand.NOTHING;
                        e[x-1][y+1]=Sand.SAND;//+
                    }
                    }
                    }*/
                }
                if(c==Sand.WATER){
                    //System.out.println("Sand go stonks"+"Y+ "+y+"X+ "+x);
                    TEMP+=0.005*-1/2;
                    e[x][y]=Sand.WATER;
                    if(TEMP_O<=-100&&Math.random()>0.997){
                        e[x][y]=Sand.ICE;
                    }
                    else if(below==Sand.NOTHING){
                        e[x][y]=Sand.NOTHING;
                        e[x][y+1]=Sand.WATER;
                    }
                    else if(below==Sand.FIRE){//NOTHING//e
                        e[x][y]=Sand.MIST;
                    }
                    else if(b1==Sand.NOTHING){//&&below!=Sand.NOTHING
                        e[x][y]=Sand.NOTHING;
                        e[x+1][y+1]=Sand.WATER;
                    }
                    else if(b2==Sand.NOTHING){//&&below!=Sand.NOTHING

                        e[x][y]=Sand.NOTHING;
                        e[x-1][y+1]=Sand.WATER;//+
                    }
                    //else if(b1==Sand.SAND){
                    //    e[x][y]=Sand.SAND;
                    //    e[x+1][y+1]=Sand.WATER;
                    //}
                   // else if(b2==Sand.SAND){//1
                   //     e[x][y]=Sand.SAND;
                   //     e[x-1][y+1]=Sand.WATER;//+
                    //}
                    else {
                        /*if((float)(new Date().toInstant().getEpochSecond()*1-START)/2==Math.floor((new Date().toInstant().getEpochSecond()*1-START)/2)) {//new Date()OINK
                            if (l == Sand.NOTHING) {
                                e[x][y] = Sand.NOTHING;
                                e[x - 1][y] = Sand.WATER;//We like ]
                            } else if (r == Sand.NOTHING) {
                                e[x][y] = Sand.NOTHING;
                                e[x + 1][y] = Sand.WATER;
                            }
                        }
                        else{
                            if (r == Sand.NOTHING) {
                                e[x][y] = Sand.NOTHING;
                                e[x + 1][y] = Sand.WATER;
                            }
                            else if (l == Sand.NOTHING) {
                                e[x][y] = Sand.NOTHING;
                                e[x - 1][y] = Sand.WATER;//We like ]
                            }
                        }*/
                        if(Math.random()>0.4&&l==Sand.NOTHING){
                            e[x][y]=Sand.NOTHING;
                            e[x-1][y]=Sand.WATER;
                        }
                        else{
                            if(r==Sand.NOTHING){
                                e[x][y]=Sand.NOTHING;
                                e[x+1][y]=Sand.WATER;//+
                            }
                        }

                    }
                    /*else{
                    if(b1==Sand.NOTHING){
                       e[x][y]=Sand.NOTHING;
                        e[x+1][y+1]=Sand.SAND;
                    }
                    else{ if(b2==Sand.NOTHING){
                        e[x][y]=Sand.NOTHING;
                        e[x-1][y+1]=Sand.SAND;//+
                    }
                    }
                    }*/
                }
                if(c==Sand.STONE){
                    e[x][y]=Sand.STONE;
                    if(below==Sand.NOTHING){
                        e[x][y]=Sand.NOTHING;
                        e[x][y+1]=Sand.STONE;//RIP a few things
                    }
                    else if(below==Sand.WATER){
                        e[x][y]=Sand.WATER;
                        n[x][y+1]=Sand.NOTHING;
                        e[x][y+1]=Sand.STONE;
                    }
                    else if(b1==Sand.NOTHING&&Math.random()>0.7){
                        e[x][y]=Sand.NOTHING;
                        e[x+1][y+1]=Sand.STONE;//:
                    }
                    else if(b2==Sand.NOTHING&&Math.random()>0.7){
                        e[x][y]=Sand.NOTHING;
                        e[x-1][y+1]=Sand.STONE;
                    }
                }
                if(c==Sand.LAVA){
                    //System.out.println("Sand go stonks"+"Y+ "+y+"X+ "+x);
                    TEMP+=0.01;
                    TEMP+=0.01;
                    e[x][y]=Sand.LAVA;//WATER;
                    if(TEMP_O<=-100&&Math.random()>0.999){
                        e[x][y]=Sand.STONE;
                    }
                    else if(up==Sand.NOTHING&&Math.random()>0.9){
                        e[x][y-1]=Sand.FIRE;
                    }
                    if(getAtPos(x,y-2,e)==Sand.WATER){
                        e[x][y-2]=Sand.MIST;
                    }
                    if(up==Sand.WATER){
                        e[x][y]=Sand.STONE;
                        e[x][y-1]=Sand.MIST;//+
                        n[x][y-1]=Sand.NOTHING;//e+MIST
                    }
                    else if(below==Sand.WATER){
                        e[x][y]=Sand.STONE;
                    }
                    else if(l==Sand.WATER){
                        e[x][y]=Sand.STONE;
                    }
                    else if(r==Sand.WATER){//Rip 2 or three =
                        e[x][y]=Sand.STONE;
                    }
                    else if(below==Sand.NOTHING){
                        e[x][y]=Sand.NOTHING;
                        e[x][y+1]=Sand.LAVA;//WATER;
                    }
                    else if(b1==Sand.NOTHING){//&&below!=Sand.NOTHING
                        e[x][y]=Sand.NOTHING;
                        e[x+1][y+1]=Sand.LAVA;//WATER;
                    }
                    else if(b2==Sand.NOTHING){//&&below!=Sand.NOTHING

                        e[x][y]=Sand.NOTHING;
                        e[x-1][y+1]=Sand.LAVA;//WATER;//+
                    }
                    //else if(b1==Sand.SAND){
                    //    e[x][y]=Sand.SAND;
                    //    e[x+1][y+1]=Sand.WATER;
                    //}
                    // else if(b2==Sand.SAND){//1
                    //     e[x][y]=Sand.SAND;
                    //     e[x-1][y+1]=Sand.WATER;//+
                    //}
                    else {
                        /*if((float)(new Date().toInstant().getEpochSecond()*1-START)/2==Math.floor((new Date().toInstant().getEpochSecond()*1-START)/2)) {//new Date()OINK
                            if (l == Sand.NOTHING) {
                                e[x][y] = Sand.NOTHING;
                                e[x - 1][y] = Sand.WATER;//We like ]
                            } else if (r == Sand.NOTHING) {
                                e[x][y] = Sand.NOTHING;
                                e[x + 1][y] = Sand.WATER;
                            }
                        }
                        else{
                            if (r == Sand.NOTHING) {
                                e[x][y] = Sand.NOTHING;
                                e[x + 1][y] = Sand.WATER;
                            }
                            else if (l == Sand.NOTHING) {
                                e[x][y] = Sand.NOTHING;
                                e[x - 1][y] = Sand.WATER;//We like ]
                            }
                        }*/
                        if(Math.random()>0.4&&l==Sand.NOTHING){
                            e[x][y]=Sand.NOTHING;
                            e[x-1][y]=Sand.LAVA;//WATER;
                        }
                        else{
                            if(r==Sand.NOTHING){
                                e[x][y]=Sand.NOTHING;
                                e[x+1][y]=Sand.LAVA;//WATER;//+
                            }
                        }

                    }
                    /*else{
                    if(b1==Sand.NOTHING){
                       e[x][y]=Sand.NOTHING;
                        e[x+1][y+1]=Sand.SAND;
                    }
                    else{ if(b2==Sand.NOTHING){
                        e[x][y]=Sand.NOTHING;
                        e[x-1][y+1]=Sand.SAND;//+
                    }
                    }
                    }*/
                }
                if(c==Sand.WALL){
                    e[x][y]=Sand.WALL;
                }
                if(c==Sand.WETSAND){
                    //System.out.println("Sand go stonks"+"Y+ "+y+"X+ "+x);
                    e[x][y]=Sand.WETSAND;
                    if(Math.random()>0.994&&below!=Sand.NOTHING){
                        e[x][y]=Sand.SAND;//WET
                    }
                    else if(below==Sand.NOTHING){
                        e[x][y]=Sand.NOTHING;
                        e[x][y+1]=Sand.WETSAND;
                    }
                    else if(below==Sand.WATER){
                        e[x][y]=Sand.WATER;
                        n[x][y+1]=Sand.NOTHING;
                        e[x][y+1]=Sand.WETSAND;//STONE
                    }
                    else if(b1==Sand.WATER){//below
                        e[x][y]=Sand.WATER;
                        n[x+1][y+1]=Sand.NOTHING;
                        e[x+1][y+1]=Sand.WETSAND;//STONE
                    }
                    else if(b2==Sand.WATER){//below1
                        e[x][y]=Sand.WATER;
                        n[x-1][y+1]=Sand.NOTHING;
                        e[x-1][y+1]=Sand.WETSAND;//STONE
                    }
                    //else if(below==Sand.WATER){
                    //    e[x][y]=Sand.WATER;
                    //    e[x][y+1]=Sand.SAND;
                    //}
                    else if(b1==Sand.NOTHING&&below!=Sand.NOTHING&&Math.random()>0.9){
                        e[x][y]=Sand.NOTHING;
                        e[x+1][y+1]=Sand.WETSAND;
                    }
                    //else if(b1==Sand.WATER&&below!=Sand.SAND){
                    //    e[x][y]=Sand.WATER;
                    //    e[x+1][y+1]=Sand.SAND;
                    //}
                    else if(b2==Sand.NOTHING&&below!=Sand.NOTHING&&Math.random()>0.9){

                        e[x][y]=Sand.NOTHING;
                        e[x-1][y+1]=Sand.WETSAND;//+
                    }
                    //else if(b2==Sand.WATER&&below!=Sand.SAND){
                    //
                    //    e[x][y]=Sand.WATER;
                    //    e[x-1][y+1]=Sand.SAND;//+
                    //}
                    /*else{
                    if(b1==Sand.NOTHING){
                       e[x][y]=Sand.NOTHING;
                        e[x+1][y+1]=Sand.SAND;
                    }
                    else{ if(b2==Sand.NOTHING){
                        e[x][y]=Sand.NOTHING;
                        e[x-1][y+1]=Sand.SAND;//+
                    }
                    }
                    }*/
                }
                if(c==Sand.ACID){
                    TEMP-=0.01;
                    //System.out.println("Sand go stonks"+"Y+ "+y+"X+ "+x);
                    e[x][y]=Sand.ACID;//LAVA;//WATER;RIP two / and a w and a o
                    if(up!=Sand.ACID&&up!=Sand.WALL&&up!=Sand.NOTHING&&up!=Sand.CLONER){//WATER is ripped of 4 times i think
                        e[x][y-1]=Sand.STONE;//And = too
                        e[x][y-1]=Sand.NOTHING;
                    }
                    else if(below!=Sand.ACID&&below!=Sand.WALL&&below!=Sand.NOTHING&&below!=Sand.CLONER){
                        e[x][y+1]=Sand.NOTHING;//STONE;
                        n[x][y+1]=Sand.NOTHING;
                        e[x][y]=Sand.NOTHING;
                    }
                    else if(l!=Sand.ACID&&l!=Sand.WALL&&l!=Sand.NOTHING&&l!=Sand.CLONER){
                        e[x-1][y]=Sand.NOTHING;//STONE;
                        e[x][y]=Sand.NOTHING;
                    }
                    else if(r!=Sand.ACID&&r!=Sand.WALL&&r!=Sand.NOTHING&&r!=Sand.CLONER){//Rip 2 or three =
                        e[x+1][y]=Sand.NOTHING;//STONE;
                        n[x+1][y]=Sand.NOTHING;//rip the e
                        e[x][y]=Sand.NOTHING;
                    }
                    else if(below==Sand.NOTHING){
                        e[x][y]=Sand.NOTHING;
                        e[x][y+1]=Sand.ACID;//LAVA;//WATER;
                    }
                    else if(b1==Sand.NOTHING){//&&below!=Sand.NOTHING
                        e[x][y]=Sand.NOTHING;
                        e[x+1][y+1]=Sand.ACID;//a//LAVA;//WATER;
                    }
                    else if(b2==Sand.NOTHING){//&&below!=Sand.NOTHING

                        e[x][y]=Sand.NOTHING;
                        e[x-1][y+1]=Sand.ACID;//LAVA;//WATER;//+
                    }
                    //else if(b1==Sand.SAND){
                    //    e[x][y]=Sand.SAND;
                    //    e[x+1][y+1]=Sand.WATER;
                    //}
                    // else if(b2==Sand.SAND){//1
                    //     e[x][y]=Sand.SAND;
                    //     e[x-1][y+1]=Sand.WATER;//+
                    //}
                    else {
                        /*if((float)(new Date().toInstant().getEpochSecond()*1-START)/2==Math.floor((new Date().toInstant().getEpochSecond()*1-START)/2)) {//new Date()OINK
                            if (l == Sand.NOTHING) {
                                e[x][y] = Sand.NOTHING;
                                e[x - 1][y] = Sand.WATER;//We like ]
                            } else if (r == Sand.NOTHING) {
                                e[x][y] = Sand.NOTHING;
                                e[x + 1][y] = Sand.WATER;
                            }
                        }
                        else{
                            if (r == Sand.NOTHING) {
                                e[x][y] = Sand.NOTHING;
                                e[x + 1][y] = Sand.WATER;
                            }
                            else if (l == Sand.NOTHING) {
                                e[x][y] = Sand.NOTHING;
                                e[x - 1][y] = Sand.WATER;//We like ]
                            }
                        }*/
                        if(Math.random()>0.4&&l==Sand.NOTHING){
                            e[x][y]=Sand.NOTHING;
                            e[x-1][y]=Sand.ACID;//LAVA;//WATER;
                        }
                        else{
                            if(r==Sand.NOTHING){
                                e[x][y]=Sand.NOTHING;
                                e[x+1][y]=Sand.ACID;//LAVA;//WATER;//+
                            }
                        }

                    }
                    /*else{
                    if(b1==Sand.NOTHING){
                       e[x][y]=Sand.NOTHING;
                        e[x+1][y+1]=Sand.SAND;
                    }
                    else{ if(b2==Sand.NOTHING){
                        e[x][y]=Sand.NOTHING;
                        e[x-1][y+1]=Sand.SAND;//+
                    }
                    }
                    }*/
                }
                if(c==Sand.ICE){
                    TEMP-=0.01;
                    boolean m=false;
                    //System.out.println("Sand go stonks"+"Y+ "+y+"X+ "+x);
                    e[x][y]=Sand.ICE;//LAVA;//WATER;RIP two / and a w and a o
                    if(((getAtPos(x,y-2-2,e)!=Sand.NOTHING&&Math.random()>0.4)||(TEMP_O>1&&Math.random()>0.9))&&TEMP_O>-100){//4//RAndo()//7//=
                        e[x][y]=Sand.WATER;//
                    }
                    else if(up==Sand.LAVA){
                        e[x][y]=Sand.WATER;
                    }//WA//LAVa)

                    else if(up==Sand.STONE){
                        e[x][y-1]=Sand.STONE;
                        e[x][y]=Sand.ICE;

                    }
                    else if(l==Sand.LAVA){
                        e[x][y]=Sand.WATER;
                    }
                    else if(r==Sand.LAVA){
                        e[x][y]=Sand.WATER;
                    }
                    else if(below==Sand.LAVA){
                        e[x][y]=Sand.WATER;//,
                    }
                    else if(up!=Sand.ICE&&up==Sand.WATER&&Math.random()>0.9){//WATER is ripped of 4 times i think
                        e[x][y]=Sand.ICE;//STONE;//And = too
                        e[x][y-1]=Sand.ICE;//NOTHING;
                        n[x][y-1]=Sand.ICE;//e
                    }
                    else if(below==Sand.WATER&&Math.random()>0.9){//[]//*){
                        e[x][y+1]=Sand.ICE;//NOTHING;//STONE;
                        n[x][y+1]=Sand.ICE;//NOTHING;
                        //e[x][y]=Sand.NOTHING;
                    }
                    else if(l==Sand.WATER&&Math.random()>0.9){//!=Sand.ICE&&l!=Sand.WALL&&l!=Sand.NOTHING){
                        e[x-1][y]=Sand.ICE;//l//NOTHING;//STONE;
                        //e[x][y]=Sand.NOTHING;
                    }
                    else if(r==Sand.WATER&&Math.random()>0.9){//Rip 2 or three = //!=Sand.ICE&&r!=Sand.WALL&&r!=Sand.NOTHING
                        e[x+1][y]=Sand.ICE;//NOTHING;//STONE;
                        n[x+1][y]=Sand.ICE;//NOTHING;//rip the e
                       // e[x][y]=Sand.NOTHING;
                    }//RIP a lot of stuff
                    else if(below==Sand.NOTHING){
                        //WHY WOUKD *WOULD I NEED THAT e[x][y]=Sand.ICE;//NOTHING;
                        e[x][y+1]=Sand.ICE;//LAVA;//WATER;
                        e[x][y]=Sand.NOTHING;
                    }


                    else if(b1==Sand.NOTHING&&Math.random()>0.994){//&&below!=&&falseSand.NOTHING
                        e[x][y]=Sand.NOTHING;
                        e[x+1][y+1]=Sand.ICE;//a//LAVA;//WATER;
                    }
                    else if(b2==Sand.NOTHING&&Math.random()>0.994){//99 * why did i wrote this== t&&Math.random()>0.20&&falsewo *those ){//&&below!=Sand.NOTHING

                        e[x][y]=Sand.NOTHING;
                        e[x-1][y+1]=Sand.ICE;//LAVA;//WATER;//+
                    }/*LUL*/
                    //else if(b1==Sand.SAND){
                    //    e[x][y]=Sand.SAND;
                    //    e[x+1][y+1]=Sand.WATER;
                    //}
                    // else if(b2==Sand.SAND){//1
                    //     e[x][y]=Sand.SAND;
                    //     e[x-1][y+1]=Sand.WATER;//+
                    //}
                    else {
                        /*if((float)(new Date().toInstant().getEpochSecond()*1-START)/2==Math.floor((new Date().toInstant().getEpochSecond()*1-START)/2)) {//new Date()OINK
                            if (l == Sand.NOTHING) {
                                e[x][y] = Sand.NOTHING;
                                e[x - 1][y] = Sand.WATER;//We like ]
                            } else if (r == Sand.NOTHING) {
                                e[x][y] = Sand.NOTHING;
                                e[x + 1][y] = Sand.WATER;
                            }
                        }
                        else{
                            if (r == Sand.NOTHING) {
                                e[x][y] = Sand.NOTHING;
                                e[x + 1][y] = Sand.WATER;
                            }
                            else if (l == Sand.NOTHING) {
                                e[x][y] = Sand.NOTHING;
                                e[x - 1][y] = Sand.WATER;//We like ]
                            }
                        }*/
                        /*if(Math.random()>0.4&&l==Sand.NOTHING){
                            e[x][y]=Sand.NOTHING;
                            e[x-1][y]=Sand.ICE;//LAVA;//WATER;
                        }
                        else{
                            if(r==Sand.NOTHING){
                                e[x][y]=Sand.NOTHING;
                                e[x+1][y]=Sand.ICE;//LAVA;//WATER;//+
                            }
                        }*/

                    }
                    /*else{
                    if(b1==Sand.NOTHING){
                       e[x][y]=Sand.NOTHING;
                        e[x+1][y+1]=Sand.SAND;
                    }
                    else{ if(b2==Sand.NOTHING){
                        e[x][y]=Sand.NOTHING;
                        e[x-1][y+1]=Sand.SAND;//+
                    }
                    }
                    }*/
                }
                if(c==Sand.FIRE){
                    TEMP+=0.01;
                    if(Math.random()>0.1){
                        e[x][y]=Sand.FIRE;//,Fire;
                    }
                    if(up==Sand.WATER){
                     e[x][y]=Sand.NOTHING;
                    }
                   //E

                    else if(Math.random()>0.4&&up==Sand.NOTHING){
                        e[x][y]=Sand.NOTHING;//*/l//Noth
                        e[x][y-1]=Sand.FIRE;
                    }
                    else if(up==Sand.WOOD||up==Sand.OIL){
                        e[x][y-1]=Sand.FIRE;
                        //e[x][y]=Sand.NOTHING;
                    }
                    else if(below==Sand.WOOD||below==Sand.OIL){//u
                        e[x][y+1]=Sand.FIRE;//://W
                        n[x][y+1]=Sand.NOTHING;//,x poor//FIRE
                        //System.out.println("C");
                    }
                    else if(up==Sand.ICE){
                        e[x][y-1]=Sand.WATER;//W
                        e[x][y]=Sand.NOTHING;
                    }
                    else if(below==Sand.ICE){//BELl
                        e[x][y+1]=Sand.WATER;
                        e[x][y]=Sand.NOTHING;//l
                    }//dow
                    else {
                        //System.out.println(r);
                        if (r == Sand.WOOD||r==Sand.OIL) {//Wrote the Sand,.OIL before the r==// OOPS!
                            e[x + 1][y] = Sand.FIRE;
                            n[x + 1][y] = Sand.NOTHING;//FIRE
                            //System.out.println(e[x+1][y]);
                        }
                        if (l == Sand.WOOD||l==Sand.OIL) {
                            e[x - 1][y] = Sand.FIRE;//2
                            //e[]
                            //if(r==Sand.WOOD){
                            //    e[x+1][y]=Sand.FIRE;
                            //}
                        }
                        //else

                    }
                }//C)0
                if(c==Sand.WOOD){
                    e[x][y]=Sand.WOOD;
                    boolean Z=true;
                    if(TEMP_O>100&&Math.random()>0.999){
                        e[x][y]=Sand.FIRE;//}
                    }
                    if(TEMP_O<-200&&Math.random()>0.999){
                        e[x][y]=Sand.NOTHING;
                    }

                    else if(b1!=Sand.NOTHING||b1==Sand.SAND){

                    }
                    else if(b2!=Sand.NOTHING||b2==Sand.SAND){

                    }
                    else if(below!=Sand.NOTHING||b2==Sand.SAND){

                    }
                    else{
                        e[x][y]=Sand.NOTHING;
                        e[x][y+1]=Sand.WOOD;
                        n[x][y+1]=Sand.NOTHING;//eWOOD
                        Z=false;
                    }
                    if((below==Sand.DIRT||getAtPos(x,y+2,e)==Sand.DIRT)&&Math.random()>0.99){
                        e[x][y+1]=Sand.WOOD;//d
                        n[x][y+1]=Sand.NOTHING;//}//&//{//m
                    }
                    //else if(below==Sand.SAND&&Math.random()>0.9) {
                    //    e[x][y]=Sand.NOTHING;
                    //}
                    //else
                    if(below==Sand.NOTHING&&getAtPos(x,y+2,e)==Sand.SAND){
                        e[x][y]=Sand.NOTHING;
                    }
                    else if(Z=true&&Math.random()>=0.99&&up==Sand.NOTHING&&(t1==Sand.NOTHING)&&(t2==Sand.NOTHING)){
                        //n[x]
                        //e[x][y-1]=Sand.WOOD;
                        //n[x][y-1]=Sand.NOTHING;

                        if(Math.random()<0.05){
//
                            try {
                                e[x][y - 1] = Sand.LEAF;
                                e[x + 1][y - 1] = Sand.LEAF;
                                e[x - 1][y - 1] = Sand.LEAF;//l
                            }
                            catch(Exception e){

                            }//ex
                        }
                        else if(Math.random()>0.9){//995
                            //n[]èç
                            try {
                                e[x + 1][y - 1] = Sand.WOOD;
                                n[x + 1][y - 1] = Sand.NOTHING;
                                e[x - 1][y - 1] = Sand.WOOD;
                                n[x - 1][y - 1] = Sand.NOTHING;
                            }
                            catch(Exception e){
                                //e
                            }
                        }
                        else if(Math.random()>0.7){
                            try {
                                e[x + 1][y - 1] = Sand.WOOD;//x
                                n[x + 1][y - 1] = Sand.WOOD;//x
                            }
                            catch(Exception e){

                            }
                        }
                        else if(Math.random()>0.5){
                            try {
                                e[x - 1][y - 1] = Sand.WOOD;//+
                                //e[x]

                                n[x - 1][y - 1] = Sand.WOOD;//01]
                            }
                            catch(Exception e){

                            }
                        }
                        else{
                            try {
                                n[x][y - 1] = Sand.WOOD;
                            }
                            catch(Exception e){

                            }
                        }
                    }
                    //return
                }
                if(c==Sand.LEAF){
                    e[x][y]=Sand.LEAF;//l
                    if(b1==Sand.WOOD||below==Sand.WOOD||b2==Sand.WOOD||b1==Sand.LEAF||below==Sand.LEAF||b2==Sand.LEAF||(l==Sand.LEAF&&r==Sand.LEAF) ){//""//"//"

                    }
                    else{
                        if(Math.random()>0.9){
                            e[x][y]=Sand.NOTHING;
                        }
                    }
                }//DF)
                if(c==Sand.MIST){
                    TEMP+=0.01;
                    e[x][y]=Sand.MIST;
                    if(Math.random()>0.2&&up==Sand.NOTHING){//!=Sand.STONE&&up!=Sand.WALL
                        e[x][y-1]=Sand.MIST;
                        //e[x][y]=n[x][y-1];//up;//S
                        e[x][y]=Sand.NOTHING;
                    }
                    else if(up==Sand.WATER){
                        if(e[x][y-1]==Sand.WATER){
                            e[x][y-1]=Sand.MIST;
                            e[x][y]=Sand.WATER;
                        }

                    }
                    else if(Math.random()>0.99){//Sand.NOTHINGup==
                        //nothing (=
                    }
                    else{
                        //if(t1==Sand)
                        if(Math.random()>0.9){
                            //e[x][y]=Sand.WATER;
                            //n[x][y]=Sand.NOTHING;
                            //e[x][y]=Sand.NOTHING;
                            e[x][y]=Sand.WATER;//OOD //That did a weird thing

                        }
                    }
                }
                if(c==Sand.DIRT){//SAND
                    //System.out.println("Sand go stonks"+"Y+ "+y+"X+ "+x);
                    e[x][y]=Sand.DIRT;//SAND
                    if(up==Sand.WATER){
                        //e[x][y]=Sand.WETSAND;//STONE;
                        e[x][y]=Sand.MUD;
                    }
                    else if(below==Sand.WATER){
                        //e[x][y]=Sand.WETSAND;//STONE;
                        e[x][y]=Sand.MUD;
                    }
                    else if(l==Sand.WATER){
                        //e[x][y]=Sand.WETSAND;////STONE;
                        e[x][y]=Sand.MUD;
                    }
                    else if(r==Sand.WATER){//Rip 2 or three =
                        //e[x][y]=Sand.WETSAND;//STONE;
                        e[x][y]=Sand.MUD;
                    }

                    else if(below==Sand.NOTHING){
                        e[x][y]=Sand.NOTHING;
                        e[x][y+1]=Sand.DIRT;//SAND;
                    }
                    //else if(below==Sand.WATER){
                    //    e[x][y]=Sand.WATER;
                    //    e[x][y+1]=Sand.SAND;
                    //}
                    else if(b1==Sand.NOTHING&&below!=Sand.NOTHING){
                        e[x][y]=Sand.NOTHING;
                        e[x+1][y+1]=Sand.DIRT;//SAND;
                    }
                    //else if(b1==Sand.WATER&&below!=Sand.SAND){
                    //    e[x][y]=Sand.WATER;
                    //    e[x+1][y+1]=Sand.SAND;
                    //}
                    else if(b2==Sand.NOTHING&&below!=Sand.NOTHING){

                        e[x][y]=Sand.NOTHING;
                        e[x-1][y+1]=Sand.DIRT;//DIRT//p//SAND;//+
                    }
                    //else if(b2==Sand.WATER&&below!=Sand.SAND){
                    //
                    //    e[x][y]=Sand.WATER;
                    //    e[x-1][y+1]=Sand.SAND;//+
                    //}
                    /*else{
                    if(b1==Sand.NOTHING){
                       e[x][y]=Sand.NOTHING;
                        e[x+1][y+1]=Sand.SAND;
                    }
                    else{ if(b2==Sand.NOTHING){
                        e[x][y]=Sand.NOTHING;
                        e[x-1][y+1]=Sand.SAND;//+
                    }
                    }
                    }*/
                }
                if(c==Sand.OIL){//WATER
                    //System.out.println("Sand go stonks"+"Y+ "+y+"X+ "+x);
                    //TEMP+=0.005*-1/2;
                    e[x][y]=Sand.OIL;//WATER
                    //if(TEMP_O<=-100&&Math.random()>0.997){
                    //    e[x][y]=Sand.ICE;
                    //}
                    //else
                    if(below==Sand.NOTHING){
                        e[x][y]=Sand.NOTHING;
                        e[x][y+1]=c;//Sand.WATER
                    }
                    else if(below==Sand.FIRE){//NOTHING//e
                        e[x][y]=Sand.FIRE;//MIST
                    }
                    else if(b1==Sand.NOTHING||b2==Sand.NOTHING){
                        if(b1==Sand.NOTHING&&b2!=Sand.NOTHING){
                        e[x][y]=Sand.NOTHING;
                        e[x+1][y+1]=c;
                        }
                        else if(b2==Sand.NOTHING&&b1!=Sand.NOTHING){
                            e[x][y]=Sand.NOTHING;
                            e[x-1][y+1]=c;//+1
                        }
                        else if(b1==Sand.NOTHING&&b2==Sand.NOTHING){
                            if(Math.floor(Math.random()*2)==0){
                                e[x][y]=Sand.NOTHING;
                                e[x+1][y+1]=c;
                            }
                            else{
                                e[x][y]=Sand.NOTHING;
                                e[x-1][y+1]=c;
                            }
                        }
                        /*else if(b1==Sand.NOTHING&&Math.random()<0.5){//&&below!=Sand.NOTHING
                        e[x][y]=Sand.NOTHING;
                        e[x+1][y+1]=c;//Sand.WATER
                    }
                    else if(b2==Sand.NOTHING){//&&below!=Sand.NOTHING

                        e[x][y]=Sand.NOTHING;
                        e[x-1][y+1]=c;//+//Sand.WATER
                    }*/
                    }


                    //else if(b1==Sand.SAND){
                    //    e[x][y]=Sand.SAND;
                    //    e[x+1][y+1]=Sand.WATER;
                    //}
                    // else if(b2==Sand.SAND){//1
                    //     e[x][y]=Sand.SAND;
                    //     e[x-1][y+1]=Sand.WATER;//+
                    //}
                    else {
                        /*if((float)(new Date().toInstant().getEpochSecond()*1-START)/2==Math.floor((new Date().toInstant().getEpochSecond()*1-START)/2)) {//new Date()OINK
                            if (l == Sand.NOTHING) {
                                e[x][y] = Sand.NOTHING;
                                e[x - 1][y] = Sand.WATER;//We like ]
                            } else if (r == Sand.NOTHING) {
                                e[x][y] = Sand.NOTHING;
                                e[x + 1][y] = Sand.WATER;
                            }
                        }
                        else{
                            if (r == Sand.NOTHING) {
                                e[x][y] = Sand.NOTHING;
                                e[x + 1][y] = Sand.WATER;
                            }
                            else if (l == Sand.NOTHING) {
                                e[x][y] = Sand.NOTHING;
                                e[x - 1][y] = Sand.WATER;//We like ]
                            }
                        }*/
                        if(l==Sand.NOTHING&&Math.floor(Math.random()*2)==0){//Math.random()>0.4&&//&
                            e[x][y]=Sand.NOTHING;
                            e[x-1][y]=c;//Sand.WATER
                        }
                        else{
                            if(r==Sand.NOTHING){
                                e[x][y]=Sand.NOTHING;
                                e[x+1][y]=c;//+//Sand.WATER
                            }
                        }

                    }
                    /*else{
                    if(b1==Sand.NOTHING){
                       e[x][y]=Sand.NOTHING;
                        e[x+1][y+1]=Sand.SAND;
                    }
                    else{ if(b2==Sand.NOTHING){
                        e[x][y]=Sand.NOTHING;
                        e[x-1][y+1]=Sand.SAND;//+
                    }
                    }
                    }*/
                }
                if(c==Sand.SNOW){//SAND
                    //System.out.println("Sand go stonks"+"Y+ "+y+"X+ "+x);
                    e[x][y]=Sand.SNOW;//Sand.SAND
                    TEMP-=0.005;//+
                    if(TEMP_O>=0+1&&Math.random()>0.9){
                        e[x][y]=Sand.WATER;
                    }
                    else if((up==Sand.WATER||up==Sand.LAVA)&&Math.random()>0.9){
                        e[x][y]=Sand.WATER;//STONE;//WETSAND
                    }
                    else if((below==Sand.WATER||below==Sand.LAVA)&&Math.random()>0.9){
                        e[x][y]=Sand.WATER;//STONAWE;T//WETSAND
                    }
                    else if((l==Sand.WATER||l==Sand.LAVA)&&Math.random()>0.9){
                        e[x][y]=Sand.WATER;////STONE;//WETSAND
                    }
                    else if((r==Sand.WATER||r==Sand.LAVA)&&Math.random()>0.9){//Rip 2 or three =
                        e[x][y]=Sand.WATER;//STONE;//WETSAND
                    }

                    else if(below==Sand.NOTHING){
                        e[x][y]=Sand.NOTHING;
                        e[x][y+1]=c;//Sand.SAND
                    }
                    //else if(below==Sand.WATER){
                    //    e[x][y]=Sand.WATER;
                    //    e[x][y+1]=Sand.SAND;
                    //}
                    else if(b1==Sand.NOTHING&&below!=Sand.NOTHING){
                        e[x][y]=Sand.NOTHING;
                        e[x+1][y+1]=c;//Sand.SAND
                    }
                    //else if(b1==Sand.WATER&&below!=Sand.SAND){
                    //    e[x][y]=Sand.WATER;
                    //    e[x+1][y+1]=Sand.SAND;
                    //}
                    else if(b2==Sand.NOTHING&&below!=Sand.NOTHING){

                        e[x][y]=Sand.NOTHING;
                        e[x-1][y+1]=c;//+//Sand.SAND
                    }
                    //else if(b2==Sand.WATER&&below!=Sand.SAND){
                    //
                    //    e[x][y]=Sand.WATER;
                    //    e[x-1][y+1]=Sand.SAND;//+
                    //}
                    /*else{
                    if(b1==Sand.NOTHING){
                       e[x][y]=Sand.NOTHING;
                        e[x+1][y+1]=Sand.SAND;
                    }
                    else{ if(b2==Sand.NOTHING){
                        e[x][y]=Sand.NOTHING;
                        e[x-1][y+1]=Sand.SAND;//+
                    }
                    }
                    }*/
                }
                if(c==Sand.ANTISAND){
                    e[x][y]=Sand.ANTISAND;
                    if(up==Sand.NOTHING){//||up==Sand.ANTIWATER
                        e[x][y]=up;//if(up==Sand.NOT//Sand.NOTHING
                        e[x][y-1]=Sand.ANTISAND;
                    }
                    else if(t1==Sand.NOTHING){//||t1==Sand.ANTIWATER
                        e[x][y]=t1;//Sand.NOTHING;
                        e[x+1][y-1]=Sand.ANTISAND;
                        n[x+1][y-1]=Sand.NOTHING;
                    }
                    else if(t2==Sand.NOTHING){//""//||t2==Sand.ANTIWATER
                        e[x][y]=t2;//Sand.NOTHING;//e
                        e[x+-1][y-1]=Sand.ANTISAND;//YAY!
                    }
                }
                if(c==Sand.CLONER){
                    e[x][y]=Sand.CLONER;
                    if((up!=Sand.WALL||up!=Sand.NOTHING)&&(below!=Sand.NOTHING||below!=Sand.WALL)){//&&&&){//||
                        try {
                            if(below!=Sand.CLONER)e[x][y - 1] = below;
                            if(up!=Sand.CLONER) {
                                e[x][y + 1] = up;//ip
                                n[x][y + 1] = Sand.NOTHING;//sand
                            }
                        }
                        catch(Exception ezPz){

                        }
                    }
                }//*
                if(c==Sand.ANTIWATER){
                    e[x][y]=Sand.ANTIWATER;
                    /*if(up==Sand.NOTHING){
                        e[x][y]=Sand.NOTHING;
                        e[x][y-1]=Sand.ANTIWATER;//SAND
                    }
                    else if(t1==Sand.NOTHING&&Math.random()>0.49){
                        e[x][y]=Sand.NOTHING;
                        e[x+1][y-1]=Sand.ANTIWATER;
                    }
                    else if(t2==Sand.NOTHING){
                        e[x][y]=Sand.ANTIWATER;//ANTIWATER
                        e[x-1][y-1]=Sand.ANTIWATER;
                    }//t1
                    else if(l==Sand.NOTHING&&Math.random()>0.49){
                        e[x][y]=Sand.NOTHING;
                        e[x-1][y]=Sand.ANTIWATER;//sand
                    }
                    else if(r==Sand.NOTHING){
                        e[x][y]=Sand.NOTHING;
                        e[x+1][y]=Sand.ANTIWATER;
                    }*/
                    if(below==Sand.ANTISAND){//bddlo
                        e[x][y]=below;
                        e[x][y+1]=Sand.ANTIWATER;
                        n[x][y+1]=Sand.ANTIWATER;
                    }
                    else if(up==Sand.NOTHING){//below
                        e[x][y]=Sand.NOTHING;
                        e[x][y-1]=c;//Sand.WATER//+
                    }
                    //else if(below==Sand.FIRE){//NOTHING//e
                    //    e[x][y]=Sand.FIRE;//MIST
                    //}
                    else if(t1==Sand.NOTHING||t2==Sand.NOTHING){//b//b
                        if(t1==Sand.NOTHING&&t2!=Sand.NOTHING){//b//b
                            e[x][y]=Sand.NOTHING;
                            e[x+1][y-1]=c;//+
                        }
                        else if(t2==Sand.NOTHING&&t1!=Sand.NOTHING){//b//b
                            e[x][y]=Sand.NOTHING;
                            e[x-1][y-1]=c;//+1//+
                        }
                        else if(t1==Sand.NOTHING&&t2==Sand.NOTHING){//b//b
                            if(Math.floor(Math.random()*2)==0){
                                e[x][y]=Sand.NOTHING;
                                e[x+1][y-1]=c;//+
                            }
                            else{
                                e[x][y]=Sand.NOTHING;
                                e[x-1][y-1]=c;//+
                            }
                        }
                        /*else if(b1==Sand.NOTHING&&Math.random()<0.5){//&&below!=Sand.NOTHING
                        e[x][y]=Sand.NOTHING;
                        e[x+1][y+1]=c;//Sand.WATER
                    }
                    else if(b2==Sand.NOTHING){//&&below!=Sand.NOTHING

                        e[x][y]=Sand.NOTHING;
                        e[x-1][y+1]=c;//+//Sand.WATER
                    }*/
                    }


                    //else if(b1==Sand.SAND){
                    //    e[x][y]=Sand.SAND;
                    //    e[x+1][y+1]=Sand.WATER;
                    //}
                    // else if(b2==Sand.SAND){//1
                    //     e[x][y]=Sand.SAND;
                    //     e[x-1][y+1]=Sand.WATER;//+
                    //}
                    else {
                        /*if((float)(new Date().toInstant().getEpochSecond()*1-START)/2==Math.floor((new Date().toInstant().getEpochSecond()*1-START)/2)) {//new Date()OINK
                            if (l == Sand.NOTHING) {
                                e[x][y] = Sand.NOTHING;
                                e[x - 1][y] = Sand.WATER;//We like ]
                            } else if (r == Sand.NOTHING) {
                                e[x][y] = Sand.NOTHING;
                                e[x + 1][y] = Sand.WATER;
                            }
                        }
                        else{
                            if (r == Sand.NOTHING) {
                                e[x][y] = Sand.NOTHING;
                                e[x + 1][y] = Sand.WATER;
                            }
                            else if (l == Sand.NOTHING) {
                                e[x][y] = Sand.NOTHING;
                                e[x - 1][y] = Sand.WATER;//We like ]
                            }
                        }*/
                        if(l==Sand.NOTHING&&Math.floor(Math.random()*2)==0){//Math.random()>0.4&&//&
                            e[x][y]=Sand.NOTHING;
                            e[x-1][y]=c;//Sand.WATER
                        }
                        else{
                            if(r==Sand.NOTHING){
                                e[x][y]=Sand.NOTHING;
                                e[x+1][y]=c;//+//Sand.WATER
                            }
                        }

                    }
                   /* else if(t1==Sand.NOTHING){
                        e[x][y]=Sand.NOTHING;
                        e[x+1][y-1]=Sand.ANTIWATER;//SAND
                    }
                    else if(t2==Sand.NOTHING){
                        e[x][y]=Sand.NOTHING;//e
//                        e[x+-1][y-1]=Sand.ANTIWATER;//YAY!// Poor 2 //!
                    }//SAND*/

                }
                if(c==Sand.MUD){//WATER//OIL
                    //System.out.println("Sand go stonks"+"Y+ "+y+"X+ "+x);
                    //TEMP+=0.005*-1/2;
                    TEMP+=0.001;

                    e[x][y]=Sand.MUD;//WATER//OIL
                    //if(TEMP_O<=-100&&Math.random()>0.997){
                    //    e[x][y]=Sand.ICE;
                    //}
                    //else
                    if(TEMP_O<-50&&Math.random()>0.99){
                            e[x][y] = Sand.DIRT;
                    }
                    else if(below!=Sand.WALL&&below!=Sand.STONE&&below!=Sand.MUD&&below!=Sand.DIRT&&below!=Sand.CLONER){//=Sand.NOTHING||below==Sand.WATER///=*//,//Oops it was belo!//-
                        e[x][y]=below;//Sand.NOTHING;//r
                        e[x][y+1]=c;//Sand.WATER
                        n[x][y+1]=Sand.NOTHING;
                    }
                    //else if(){//NOTHING//e//below==Sand.FIRE
                    //    e[x][y]=Sand.FIRE;//MIST
                    //}
                    else if((b1!=Sand.WALL&&b2!=Sand.STONE&&b1!=Sand.MUD)||(b2!=Sand.WALL&&b2!=Sand.STONE&&b2!=Sand.MUD)){//=//=//NOTHING//NOTHING//1
                        if((b1!=Sand.WALL&&b2!=Sand.STONE&&b1!=Sand.MUD)&&!(b2!=Sand.WALL&&b2!=Sand.STONE&&b2!=Sand.MUD)&&Math.random()>0.99){//??///b1==Sand.NOTHING//b2!=Sand.NOTHING//1
                            e[x][y]=b1;////
                            e[x+1][y+1]=c;//Rip a lota 1s
                        }
                        else if((b2!=Sand.WALL&&b2!=Sand.STONE&&b2!=Sand.MUD)&&!(b1!=Sand.WALL&&b1!=Sand.STONE&&b1!=Sand.MUD)&&Math.random()>0.99){//b2==Sand.NOTHING//b1!=Sand.NOTHING//2
                            e[x][y]=b2;//Sand.NOTHING
                            e[x-1][y+1]=c;//+1
                        }
                        else if((b1!=Sand.WALL&&b2!=Sand.STONE&&b2!=Sand.MUD)&&(b2!=Sand.WALL&&b2!=Sand.STONE&&b2!=Sand.MUD)&&Math.random()>0.99){//b1==Sand.NOTHING//b2==Sand.NOTHING//2 go i//1//The 2 was innocent // Oops tabbed out at i
                            if(Math.floor(Math.random()*2)==0){
                                e[x][y]=b1;//Sand.NOTHING
                                e[x+1][y+1]=c;
                            }
                            else{
                                e[x][y]=b2;//Sand.NOTHING
                                e[x-1][y+1]=c;
                            }
                        }
                        /*else if(b1==Sand.NOTHING&&Math.random()<0.5){//&&below!=Sand.NOTHING
                        e[x][y]=Sand.NOTHING;
                        e[x+1][y+1]=c;//Sand.WATER
                    }
                    else if(b2==Sand.NOTHING){//&&below!=Sand.NOTHING

                        e[x][y]=Sand.NOTHING;
                        e[x-1][y+1]=c;//+//Sand.WATER
                    }*/
                    }


                    //else if(b1==Sand.SAND){
                    //    e[x][y]=Sand.SAND;
                    //    e[x+1][y+1]=Sand.WATER;
                    //}
                    // else if(b2==Sand.SAND){//1
                    //     e[x][y]=Sand.SAND;
                    //     e[x-1][y+1]=Sand.WATER;//+
                    //}
                    else {
                        /*if((float)(new Date().toInstant().getEpochSecond()*1-START)/2==Math.floor((new Date().toInstant().getEpochSecond()*1-START)/2)) {//new Date()OINK
                            if (l == Sand.NOTHING) {
                                e[x][y] = Sand.NOTHING;
                                e[x - 1][y] = Sand.WATER;//We like ]
                            } else if (r == Sand.NOTHING) {
                                e[x][y] = Sand.NOTHING;
                                e[x + 1][y] = Sand.WATER;
                            }
                        }
                        else{
                            if (r == Sand.NOTHING) {
                                e[x][y] = Sand.NOTHING;
                                e[x + 1][y] = Sand.WATER;
                            }
                            else if (l == Sand.NOTHING) {
                                e[x][y] = Sand.NOTHING;
                                e[x - 1][y] = Sand.WATER;//We like ]
                            }
                        }*/
                        if(l==Sand.NOTHING&&Math.floor(Math.random()*2)==0){//Math.random()>0.4&&//&
                            if(Math.random()>0.99){//rip a ) and a e
                                e[x][y]=Sand.NOTHING;
                            e[x-1][y]=c;//Sand.WATER
                            }
                        }
                        else{
                            if(r==Sand.NOTHING&&Math.random()>0.99){
                                e[x][y]=Sand.NOTHING;
                                e[x+1][y]=c;//+//Sand.WATER
                            }
                        }

                    }
                    /*else{
                    if(b1==Sand.NOTHING){
                       e[x][y]=Sand.NOTHING;
                        e[x+1][y+1]=Sand.SAND;
                    }
                    else{ if(b2==Sand.NOTHING){
                        e[x][y]=Sand.NOTHING;
                        e[x-1][y+1]=Sand.SAND;//+
                    }
                    }
                    }*/
                }
                if(c==Sand.TNT){//SAND
                    //System.out.println("Sand go stonks"+"Y+ "+y+"X+ "+x);
                    e[x][y]=Sand.TNT;//Sand.SAND;
                    if(up==Sand.FIRE){
                    //    e[x][y]=c;//Sand.WETSAND;//STONE;
                        explode(x, y, 15);
                    }
                    else if(below==Sand.FIRE){
                    //    e[x][y]=c;//Sand.WETSAND;//STONE;
                        explode(x, y, 15);
                    }
                    else if(l==Sand.FIRE){
                    //    e[x][y]=Sand.WETSAND;////STONE;
                        explode(x, y, 15);
                    }
                    else if(r==Sand.FIRE){//Rip 2 or three =
                    //    e[x][y]=Sand.WETSAND;//STONE;
                        explode(x, y, 15);
                    }
                    //else
                    else if(below==Sand.NOTHING){
                        e[x][y]=Sand.NOTHING;
                        e[x][y+1]=c;//Sand.SAND;
                    }
                    //else if(below==Sand.WATER){
                    //    e[x][y]=Sand.WATER;
                    //    e[x][y+1]=Sand.SAND;
                    //}
                    else if(b1==Sand.NOTHING&&below!=Sand.NOTHING){
                        e[x][y]=Sand.NOTHING;
                        e[x+1][y+1]=c;//Sand.SAND;
                    }
                    //else if(b1==Sand.WATER&&below!=Sand.SAND){
                    //    e[x][y]=Sand.WATER;
                    //    e[x+1][y+1]=Sand.SAND;
                    //}
                    else if(b2==Sand.NOTHING&&below!=Sand.NOTHING){

                        e[x][y]=Sand.NOTHING;
                        e[x-1][y+1]=c;//Sand.SAND;//+
                    }
                    //else if(b2==Sand.WATER&&below!=Sand.SAND){
                    //
                    //    e[x][y]=Sand.WATER;
                    //    e[x-1][y+1]=Sand.SAND;//+
                    //}
                    /*else{
                    if(b1==Sand.NOTHING){
                       e[x][y]=Sand.NOTHING;
                        e[x+1][y+1]=Sand.SAND;
                    }
                    else{ if(b2==Sand.NOTHING){
                        e[x][y]=Sand.NOTHING;
                        e[x-1][y+1]=Sand.SAND;//+
                    }
                    }
                    }*/
                }

            }

        }
        n=e;


    }




    private class TAdapter extends KeyAdapter {
        public double calculateDistanceBetweenPoints(
                double x1,
                double y1,
                double x2,
                double y2) {
            return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        }
        @Override
        public void keyReleased(KeyEvent e) {
            //eye.keyReleased(e);
            //CTRL.keyReleased(e);
            if(e.getKeyCode()==KeyEvent.VK_UP){
                PlayerSandWich--;
            }
            if(e.getKeyCode()==KeyEvent.VK_DOWN){
                PlayerSandWich++;
            }
            if(PlayerSandWich>Sand.INVENTORY.length-1){
                PlayerSandWich=0;
            }
            if(PlayerSandWich<0){
                PlayerSandWich=Sand.INVENTORY.length-1;
            }
            PlayerSand=Sand.INVENTORY[PlayerSandWich];//Rip SNA
            if(e.getKeyCode()==KeyEvent.VK_LEFT)PlayerScale--;//Pl)
            if(e.getKeyCode()==KeyEvent.VK_RIGHT)PlayerScale++;

            //e
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_R){
                n=new int[400][300];
            }
            //Time.
            //new Date().no
            //eye.keyPressed(e);
           /* boolean m=true;
            String b=CTRL.keyPressed(e);
            if(b=="F"){
                for(int i=0;i<Foods.size();i++){
                    System.out.println("HoI!");
                    System.out.println(calculateDistanceBetweenPoints((double)CTRL.getX(),(double)CTRL.getY(),(double)Foods.get(i).getX(),(double)Foods.get(i).getY()));
                    if(calculateDistanceBetweenPoints((double)CTRL.getX(),(double)CTRL.getY(),(double)Foods.get(i).getX(),(double)Foods.get(i).getY())<=10){
                        Foods.remove(i);

                        System.out.println("DELETED");
                        m=false;
                    }
                }
                if(m){
                    Foods.add(new Food(CTRL.getX(),CTRL.getY()));
                }
            }//;
            if(b=="W"){
                for(int i=0;i<Walls.size();i++){
                    System.out.println("HoI!");
                    System.out.println(calculateDistanceBetweenPoints((double)CTRL.getX(),(double)CTRL.getY(),(double)Walls.get(i).getX(),(double)Walls.get(i).getY()));
                    if(calculateDistanceBetweenPoints((double)CTRL.getX(),(double)CTRL.getY(),(double)Walls.get(i).getX(),(double)Walls.get(i).getY())<=-5+Walls.get(i).getSize()){
                        Walls.remove(i);

                        System.out.println("DELETED");
                        m=false;
                    }
                }
                if(m){
                    Walls.add(new Wall(CTRL.getX(),CTRL.getY(),40));
                }
            }//;*/
        }
    }
}