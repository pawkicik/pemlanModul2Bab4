public class Vehicle1 {

    double load, maxLoad;

    public Vehicle1 (double max) {
        this.maxLoad = max;
        this.load = 0.0;

    }

    public double getLoad(){
        return this.load;
    }

    public double getmaxLoad(){
        return this.maxLoad;
    }

    public boolean addBox(double weight){
        double temp = 0.0D;
        temp = this.load + weight;
        if (temp <= maxLoad) {
            this.load = this.load + weight;
            return true;
        } else {
            return false;
        }
    }
}
