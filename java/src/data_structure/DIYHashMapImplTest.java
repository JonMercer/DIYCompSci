package data_structure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Odin on 2016-10-24.
 */
public class DIYHashMapImplTest {
    private DIYHashMapImpl<String, Integer> map;

    @Before
    public void setUp() throws Exception {
        map = new DIYHashMapImpl<>();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void clear() throws Exception {
        map.put("Hi", 1);
        map.put("Hello", 2);
        assertEquals(2, map.size());
        map.clear();
        assertEquals(0, map.size());
    }

    @Test
    public void containsKey() throws Exception {
        assertEquals(false, map.containsKey("Hi"));
        map.put("Hi", 1);
        assertEquals(true, map.containsKey("Hi"));
    }

    @Test
    public void containsValue() throws Exception {
        assertEquals(false, map.containsValue(1));
        map.put("Hi", 1);
        assertEquals(true, map.containsValue(1));
    }

    @Test
    public void get() throws Exception {
        assertEquals(null, map.get("Hi"));
        map.put("Hi", 1);
        assertEquals(1, (int) map.get("Hi"));
    }

    @Test
    public void isEmpty() throws Exception {
        assertEquals(true, map.isEmpty());
        map.put("Hi", 1);
        assertEquals(false, map.isEmpty());
    }

    @Test
    public void put() throws Exception {
        map.put("Hi", 1);
        assertEquals(1, (int) map.get("Hi"));
    }

    @Test
    public void remove() throws Exception {
        map.put("Hi", 1);
        assertEquals(1, map.size());
        map.remove("Hi");
        assertEquals(0, map.size());
    }

    @Test
    public void size() throws Exception {
        assertEquals(0, map.size());
        map.put("Hi", 1);
        assertEquals(1, map.size());
    }

    @Test
    public void objectTest() throws Exception {
        class CustomItem {
            private String str;
            private Integer i;
            public CustomItem(String str, Integer i) {
                this.str = str;
                this.i = i;
            }

            @Override
            public boolean equals(Object obj) {
                if (obj == null) {
                    return false;
                }

                if (!CustomItem.class.isAssignableFrom(obj.getClass())) {
                    return false;
                }
                final CustomItem other = (CustomItem) obj;
                if ((this.str == null) ? (other.str != null) : !this.str.equals(other.str)) {
                    return false;
                }

                if ((this.i == null) ? (other.i != null) : !this.i.equals(other.i)) {
                    return false;
                }
                return true;
            }

            @Override
            public int hashCode() {
                int hash = 11;
                hash = 53 * hash + (this.str != null ? this.str.hashCode() : 0);
                hash = 53 * hash + (this.i != null ? this.i.hashCode() : 0);
                return hash;
            }
        }

        DIYHashMap<CustomItem, CustomItem> customMap = new DIYHashMapImpl<>();

        assertEquals(true, customMap.isEmpty());
        customMap.put(new CustomItem("Foo", 1), new CustomItem("Bar", 2));
        assertEquals(1, customMap.size());
        customMap.put(new CustomItem("Baz", 3), new CustomItem("Zap", 4));
        assertEquals(2, customMap.size());
        assertEquals(new CustomItem("Bar", 2), customMap.get(new CustomItem("Foo", 1)));
        customMap.remove(new CustomItem("Baz", 3));
        assertEquals(1, customMap.size());
    }

    @Test
    public void bigTest() throws Exception {
        for (int i = 0; i < 500; i++) {
            map.put(String.valueOf(i), i);
            assertEquals(i, (int) map.get(String.valueOf(i)));
        }
        assertEquals(500, map.size());

        for (int i = 0; i < 500; i++) {
            map.remove(String.valueOf(i));
            System.out.println(i);
            assertEquals(false, map.containsValue(i));//FIXME: looks like map empties at this point?
        }
        assertEquals(true, map.isEmpty());
    }

}