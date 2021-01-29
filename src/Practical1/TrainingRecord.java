// An implementation of a Training Record as an ArrayList
package Practical1;


import java.sql.SQLTransactionRollbackException;
import java.util.*;
import java.util.stream.Collectors;


public class TrainingRecord {
    private List<Entry> tr;

    public TrainingRecord() {
        tr = new ArrayList<>();
    }

    // add a record to the list
    public void addEntry(Entry e) {

        tr.add(e);
    } // addClass

    // look up the entry of a given day and month
    public String lookupEntry(int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();

        String result = "No entries found";
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getDay() == d && current.getMonth() == m && current.getYear() == y)
                result = current.getEntry();
        }
        return result;
    } // lookupEntry

    public String remove(String name, int d, int m, int y) {

        ListIterator<Entry> iter = tr.listIterator();
        String result = "";

        for (Entry current : tr) {

            current = iter.next();
            if (current.getName().equals(name) && current.getDay() == d && current.getMonth() == m && current.getYear() == y) {

                iter.remove();
                current = iter.next();
            }
            result = result.concat(current.getEntry());
        }

        return result;
    }

    public String findAllByDate(int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        String result = "";
        /* still not working*/

//        List<String> collect = tr.stream()
//                .filter(current -> current.getDay() == d && current.getMonth() == m && current.getYear() == y)
//                .map(current -> current.getEntry())
//                .collect(Collectors.toList());
        for (Entry current : tr) {
            current = iter.next();
            if (current.getDay() == d && current.getMonth() == m && current.getYear() == y) {
                result = result.concat(current.getEntry());
            }
        }

        return result.equals("") ? "No entries" : result;//not working properly
    }

    public String findAllByName(String name) {
        ListIterator<Entry> iter = tr.listIterator();
        String result = "";

//        List<String> collect = tr.stream()
//                .filter(current -> current.getDay() == d && current.getMonth() == m && current.getYear() == y)
//                .map(current -> current.getEntry())
//                .collect(Collectors.toList());
        for (Entry current : tr) {
            current = iter.next();
            if (current.getName().equals(name)) {
                result = result.concat(current.getEntry());
            }
        }

        return result.equals("") ? "No entries" : result;//not working properly
    }

    // Count the number of entries
    public int getNumberOfEntries() {
        return tr.size();
    }

    // Clear all entries
    public void clearAllEntries() {
        tr.clear();
    }

} // TrainingRecord