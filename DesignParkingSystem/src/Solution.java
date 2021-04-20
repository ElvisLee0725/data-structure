// Use an array of length 3, array[0] is the number of space for big car, array[1] for meduium and array[2] for small
// When addCar is called, check if the car type has space left? If so, space minus 1 and return true; Otherwise, return false
// Time: O(1), Space: O(1)
class ParkingSystem {
    int [] spaces;
    public ParkingSystem(int big, int medium, int small) {
        this.spaces = new int[3];
        this.spaces[0] = big;
        this.spaces[1] = medium;
        this.spaces[2] = small;
    }

    public boolean addCar(int carType) {
        if(carType == 1 && spaces[0] > 0) {
            spaces[0]--;
            return true;
        }
        else if(carType == 2 && spaces[1] > 0) {
            spaces[1]--;
            return true;
        }
        else if(carType == 3 && spaces[2] > 0) {
            spaces[2]--;
            return true;
        }
        return false;
    }
}