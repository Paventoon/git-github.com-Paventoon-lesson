import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map.Entry;

public class Store {

    static Set<Integer> keySet = new HashSet<>(10);
    static HashMap<Integer, NoteBook> storeMap = new HashMap<>(10);

    static HashMap<Integer, NoteBook> getNoteBookMap() {

        NoteBook nb001 = new NoteBook();
        nb001.id = 1;
        nb001.manufacturer = "Acer";
        nb001.size = 13;
        nb001.processor = "Intel Core i3";
        nb001.ram = 4;
        nb001.hdd = 512;
        nb001.os = "Windows 10";
        nb001.color = "black";
        nb001.price = 10000;

        NoteBook nb002 = new NoteBook();
        nb002.id = 2;
        nb002.manufacturer = "Acer";
        nb002.size = 15;
        nb002.processor = "Intel Core i5";
        nb002.ram = 8;
        nb002.hdd = 1024;
        nb002.os = "Windows 11";
        nb002.color = "silver";
        nb002.price = 20000;

        NoteBook nb003 = new NoteBook();
        nb003.id = 3;
        nb003.manufacturer = "Acer";
        nb003.size = 17;
        nb003.processor = "Intel Core i7";
        nb003.ram = 16;
        nb003.hdd = 2000;
        nb003.os = "without OS";
        nb003.color = "white";
        nb003.price = 30000;

        NoteBook nb004 = new NoteBook();
        nb004.id = 4;
        nb004.manufacturer = "Acer";
        nb004.size = 17;
        nb004.processor = "Intel Core i7";
        nb004.ram = 16;
        nb004.hdd = 2000;
        nb004.os = "Windows";
        nb004.color = "black";
        nb004.price = 35000;

        NoteBook nb005 = new NoteBook();
        nb005.id = 5;
        nb005.manufacturer = "ASUS";
        nb005.size = 14;
        nb005.processor = "Intel Core i9";
        nb005.ram = 32;
        nb005.hdd = 1024;
        nb005.os = "Linux";
        nb005.color = "black";
        nb005.price = 33000;

        storeMap.put(keyStore(), nb001);
        storeMap.put(keyStore(), nb002);
        storeMap.put(keyStore(), nb003);
        storeMap.put(keyStore(), nb004);
        storeMap.put(keyStore(), nb005);

        return storeMap;
    }

    static Integer keyStore() {
        if (keySet.isEmpty()) {
            keySet.add(0);
        }
        Integer keyNum = Collections.max(keySet) + 1;
        keySet.add(keyNum);
        return keyNum;
    }

    static HashMap<Integer, NoteBook> getCustomerMap(HashMap<Integer, NoteBook> storeMap,
            HashMap<Integer, String> custom_filter_map) {
        HashMap<Integer, NoteBook> customerMap = new HashMap<>(0);
        for (Entry<Integer, NoteBook> entry : storeMap.entrySet()) {
            customerMap.put(entry.getKey(), entry.getValue());
        }
        // customerMap = (HashMap<Integer, NoteBook>) storeMap.clone();
        for (Entry<Integer, String> entry_f : custom_filter_map.entrySet()) {
            for (Entry<Integer, NoteBook> entry_m : storeMap.entrySet()) {
                switch (entry_f.getKey()) {
                    case 1:
                        if (!entry_m.getValue().manufacturer.equalsIgnoreCase(entry_f.getValue())
                                && !entry_f.getValue().equals("")) {
                            customerMap.remove(entry_m.getKey());
                        }
                        break;
                    case 2:
                        if (entry_m.getValue().size < tryInt(entry_f.getValue())) {
                            customerMap.remove(entry_m.getKey());
                        }
                        break;
                    case 3:
                        if (!entry_m.getValue().processor.equalsIgnoreCase(entry_f.getValue())
                                && !entry_f.getValue().equals("")) {
                            customerMap.remove(entry_m.getKey());
                        }
                        break;
                    case 4:
                        if (entry_m.getValue().ram < tryInt(entry_f.getValue())) {
                            customerMap.remove(entry_m.getKey());
                        }
                        break;
                    case 5:
                        if (entry_m.getValue().hdd < tryInt(entry_f.getValue())) {
                            customerMap.remove(entry_m.getKey());
                        }
                        break;
                    case 6:
                        if (!entry_m.getValue().os.equalsIgnoreCase(entry_f.getValue())
                                && !entry_f.getValue().equals("")) {
                            customerMap.remove(entry_m.getKey());
                        }
                        break;
                    case 7:
                        if (!entry_m.getValue().color.equalsIgnoreCase(entry_f.getValue())
                                && !entry_f.getValue().equals("")) {
                            customerMap.remove(entry_m.getKey());
                        }
                        break;
                    case 8:
                        if (entry_m.getValue().price < tryInt(entry_f.getValue())) {
                            customerMap.remove(entry_m.getKey());
                        }
                        break;
                    default:
                }
            }
        }
        return customerMap;
    }

    public static Integer tryInt(String string) {
        Integer integer = 0;
        try {
            integer = Integer.parseInt(string);
        } catch (Exception e) {
        }
        return integer;
    }
}