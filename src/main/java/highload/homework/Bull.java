package highload.homework;

import java.util.Objects;

public class Bull {

    int countBull;

    public Bull() {
    }

    public Bull(int count) {
        this.countBull = count;
    }

    public int getCountBull() {
        return countBull;
    }

    public void setCountBull(int countBull) {
        this.countBull = countBull;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bull bull = (Bull) o;
        return countBull == bull.countBull;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countBull);
    }

    @Override
    public String toString() {
        if(countBull == 0){
            return countBull + " Быков";
        }else if(countBull == 1){
            return countBull + " Бык";
        }else if(countBull == 4){
            return "Строка была угадана";
        }else{
            return countBull + " Быка";
        }
    }
}
