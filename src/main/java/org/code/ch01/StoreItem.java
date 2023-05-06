package org.code.ch01;

import lombok.*;

import java.util.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class StoreItem {
    private String name;
    private double retailPrice;
    private double discount;

    public static Optional<StoreItem> findLeastExpensive(Collection<StoreItem> items) {
        return items.stream().min(Comparator.comparing(StoreItem::calculateCurrentPrice));
    }

    private double calculateCurrentPrice() {
        return retailPrice - (retailPrice * discount);
    }
}
