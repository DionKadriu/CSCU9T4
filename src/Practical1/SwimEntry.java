package Practical1;

import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsSame;

import java.util.Objects;

public class SwimEntry extends Entry {
    private String where;

    public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String where) {
        super(n, d, m, y, h, min, s, dist);
        this.where = where;
    }

    public String getWhere() {
        return where;
    }

    @Override
    public String getEntry() {
        return getName() + " swam " + getDistance() + " km " + getWhere() + " in "
                + getHour() + ":" + getMin() + ":" + getSec() + " on "
                + getDay() + "/" + getMonth() + "/" + getYear() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else
            return false;//redundant code not working at the moment
    }


}
