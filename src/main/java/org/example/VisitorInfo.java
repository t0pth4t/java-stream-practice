package org.example;

import java.util.Optional;

public class VisitorInfo {
    private Optional<Long> visitCount;


    public VisitorInfo(Optional<Long> visitCount) {
        this.visitCount = visitCount;
    }

    public Optional<Long> getVisitCount() {
        return visitCount;
    }
}
