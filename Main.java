package Seminar_6_HW_Java;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Notebook> notebooks = new ArrayList<>();
        notebooks.add(new Notebook("Lenovo", "IdeaPad 5", 8, 512, "Windows 10", "Silver"));
        notebooks.add(new Notebook("HP", "Pavilion x360", 16, 256, "Windows 10", "Black"));
        notebooks.add(new Notebook("Dell", "XPS 13", 16, 512, "Ubuntu", "White"));
        notebooks.add(new Notebook("Apple", "MacBook Pro", 16, 512, "macOS", "Space Gray"));

        Map<Integer, String> criteria = new HashMap<>();
        criteria.put(1, "ram");
        criteria.put(2, "hdd");
        criteria.put(3, "os");
        criteria.put(4, "color");

        Map<String, Integer> filters = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        for (Integer key : criteria.keySet()) {
            System.out.println("Enter minimum value for " + criteria.get(key) + ":");
            int value = scanner.nextInt();
            filters.put(criteria.get(key), value);
        }

        List<Notebook> filteredNotebooks = new ArrayList<>();
        for (Notebook notebook : notebooks) {
            boolean passFilter = true;
            for (String key : filters.keySet()) {
                if (key.equals("ram") && notebook.getRam() < filters.get(key)) {
                    passFilter = false;
                    break;
                } else if (key.equals("hdd") && notebook.getHdd() < filters.get(key)) {
                    passFilter = false;
                    break;
                } else if (key.equals("os") && !notebook.getOs().equals(filters.get(key))) {
                    passFilter = false;
                    break;
                } else if (key.equals("color") && !notebook.getColor().equals(filters.get(key))) {
                    passFilter = false;
                    break;
                }
            }
            if (passFilter) {
                filteredNotebooks.add(notebook);
            }
        }

        System.out.println("Filtered notebooks:");
        for (Notebook notebook : filteredNotebooks) {
            System.out.println(notebook);
        }
    }
}