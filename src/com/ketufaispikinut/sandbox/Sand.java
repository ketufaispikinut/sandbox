package com.ketufaispikinut.sandbox;

import java.awt.*;

public class Sand {
    public static int NOTHING = 0;
    public static int SAND = 1;
    public static int WALL = -1;//-1//3
    public static int WATER = 2;
    public static int STONE = 3;
    public static int LAVA = 4;
    public static int WETSAND = 5;
    public static int ACID = 6;
    public static int ICE = 7;
    public static int FIRE = 8;
    public static int WOOD = 9;
    public static int LEAF = 10;//:
    public static int MIST = 11;
    public static int DIRT = 12;//gWOOD
    public static int OIL = 13;
    public static int SNOW = 14;
    public static int ANTISAND = 15;//S
    public static int CLONER = 16;
    public static int ANTIWATER = 17;
    public static int MUD = 18;
    public static int TNT = 19;//GUNPOWDER

    //public s t
    //,RANDOM//*
    public static int[] INVENTORY = {NOTHING, SAND, WALL, WATER, STONE, LAVA, ACID, ICE, FIRE, WOOD, MIST, DIRT, LEAF, OIL, SNOW, ANTISAND, CLONER, ANTIWATER, MUD, TNT};//LEAF//P//aNTIS//GUNPOWDER
    public static Color[] COLORS = {Color.lightGray, Color.WHITE, Color.YELLOW,
            Color.BLUE,
            Color.GRAY,
            Color.ORANGE,
            new Color(100, 120, 40),
            Color.GREEN,
            Color.CYAN,
            Color.RED,
            new Color(0x997114),
            new Color(0x13E30F),
            new Color(0x193ea0),
            new Color(0x684818)//Color.
            //RAY
            , new Color(0x333333)//aaaaaa//88//999698
            , new Color(0xf2f2ff)//;//4
            , new Color(0, 255, 200)//;//255
            , new Color(180, 50, 20)//=//0//255//255
            , new Color(220, 40 + 10 + 20, 40)//;
            , new Color(0x5b2904)//;//""
            , new Color(0xFDBBBB)//l;
    }; //
    //pib
    public static String[][] NAMES = {//s//"
            {
                    "Wall", "Nothing", "Sand", "Water", "Stone", "Lava", "Wet Sand", "Acid", "Ice", "Fire", "Wood", "Leaf", "Mist", "Dirt", "Oil", "Snow", "Anti-S", "Cloner", "Anti-W", "Mud", "TNT", ""//o//-S//sand
            },
            {
                    "Mur", "Rien", "Sable", "Eau", "Pierre", "Lave", "Sable humide", "Acide", "Glace", "Feu", "Bois", "Feuille", "Vapeur", "Terre", "Essence", "Neige", "Anti-S", "Cloneur", "Anti-E", "Boue", "TNT", ""//o//-S//sand
            }
    };
}

