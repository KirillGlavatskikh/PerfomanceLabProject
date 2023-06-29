package highload.homework;

import java.util.Objects;

public class Cow {

    int countCow;

    public Cow() {
    }

    public Cow(int countCow) {
        this.countCow = countCow;
    }

    public int getCountCow() {
        return countCow;
    }

    public void setCountCow(int countCow) {
        this.countCow = countCow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cow cow = (Cow) o;
        return countCow == cow.countCow;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countCow);
    }

    @Override
    public String toString() {
        if(countCow == 0){
            return countCow + " Коров";
        }else if(countCow == 1){
            return countCow + " Корова";
        }else{
            return countCow + " Коровы";
        }
    }
}
