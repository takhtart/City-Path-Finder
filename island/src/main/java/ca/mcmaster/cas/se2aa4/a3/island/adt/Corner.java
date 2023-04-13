package ca.mcmaster.cas.se2aa4.a3.island.adt;

public class Corner {
    private final double x, y;
    private int  red, green, blue = 0;
    private int elevation;
    private boolean landCorner = false;
    private boolean city;
    private String citytype;
    private double size = 0.1;

    public Corner(double x, double y) {
        this.x = x;
        this.y = y;

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getSize(){
        return size;
    }

    public String getCityType(){
        return citytype;
    }

    public void setElevation(int value){
        this.elevation = value;
    }
    
    public int getElevation(){
        return elevation;
    }

    public void setLandCorner(){
        this.landCorner = true;
    }

    public boolean isLandCorner(){
        return landCorner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Corner corner = (Corner) o;
        return x == corner.x && y == corner.y;
    }

    public void setColor(int r, int g, int b){
        if (r >= 0 && r <= 255 && g >= 0 && g <= 255 && b >= 0 && b <= 255){
            this.red = r;
            this.green = g;
            this.blue = b;
        }
    }

    public String getStringColor(){
        return red + "," + green + "," + blue;
    }

    public boolean isCity(){
        return city;
    }

    public void createCity(String citytype){
        if (citytype.equals("hamlet")){
            city = true;
            this.citytype = citytype;
            size = 10;
            setColor(212, 245, 179);

        }
        else if(citytype.equals("city")){
            city = true;
            this.citytype = citytype;
            size = 14;
            setColor(205, 212, 208);
        }
        else if(citytype.equals("village")){
            city = true;
            this.citytype = citytype;
            size = 12;
            setColor(64, 51, 37);
        }
        else if(citytype.equals("capital")){
            city = true;
            this.citytype = citytype;
            size = 16;
            setColor(255,215,0);
        }

}

}


