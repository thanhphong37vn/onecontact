package org.oni.webapp.dto;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * This is a DTO that holds the total number and list of items.
 * @author DungTV
 * @param <T> class of DTO
 */
public class ListDto<T> {

    /** list items */
    private final List<T> items;

    /** Total number */
    private final long total;

    /**
     * Constructor
     * @param items list items
     * @param total Total number
     */
    public ListDto(List<T> items, long total) {
        this.items = items;
        this.total = total;
    }

    /**
     * Get list items
     * @return list items
     */
    public List<T> getItems() {
        return this.items;
    }

    /**
     * get total numer
     * @return total number
     */
    public long getTotal() {
        return this.total;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
