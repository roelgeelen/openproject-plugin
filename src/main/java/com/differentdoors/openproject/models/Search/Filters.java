package com.differentdoors.openproject.models.Search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Filters {
    private List<Map<String, Filter>> filters;

    public Filters(List<Map<String, Filter>> filters) {
        this.filters = filters;
    }

    public Filters() {
        this.filters = new ArrayList<>();
    }

    public void addFilter(Map<String, Filter> filter) {
        this.filters.add(filter);
    }

    public List<Map<String, Filter>> getFilters() {
        return filters;
    }

    public void setFilters(List<Map<String, Filter>> filters) {
        this.filters = filters;
    }
}
