package sorting;

/**
 * Created by Odin on 2016-10-26.
 */
public class DIYQuicksortCustomItem implements Comparable {


    private final int item;

    public DIYQuicksortCustomItem(int i) {
        this.item = i;
    }

    @Override
    public int compareTo(Object o) {
        if (o.getClass() != this.getClass()) {
            return -99;
        }
        if (this.item == ((DIYQuicksortCustomItem) o).item) {
            return 0;
        } else if (this.item < ((DIYQuicksortCustomItem) o).item) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!DIYQuicksortCustomItem.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final DIYQuicksortCustomItem other = (DIYQuicksortCustomItem) obj;

        if (this.item != other.item) {
            return false;
        }

        return true;
    }
}
