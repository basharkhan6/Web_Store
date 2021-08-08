package bd.edu.diu.webstore.model;

import bd.edu.diu.webstore.execption.ItemAlreadyAddedException;
import java.util.HashMap;
import java.util.Iterator;

public class Cart {

    private HashMap items = new HashMap();

    public Cart() {

    }

    public Iterator getItems() {
        return items.values().iterator();
    }

    public void addItem(Product product) throws ItemAlreadyAddedException {
        if (items.containsKey(product.getpID())) {
            throw new ItemAlreadyAddedException("Item Already Added by " + product.getpName());
        }
        items.put(product.getpID(), product);
    }
}
