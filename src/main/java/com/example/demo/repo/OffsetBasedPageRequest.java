//package com.example.demo.repo;
//
//import org.springframework.data.domain.Sort;
//
//import java.awt.print.PageFormat;
//import java.awt.print.Pageable;
//import java.awt.print.Printable;
//
//public class OffsetBasedPageRequest implements Pageable {
//
//    private int limit;
//
//    private int offset;
//
//
//    // Constructor could be expanded if sorting is needed
//    private Sort sort = new Sort(Sort.Direction.DESC, "id");
//
//    public OffsetBasedPageRequest(int limit, int offset) {
//        if (limit < 1) {
//            throw new IllegalArgumentException("Limit must not be less than one!");
//        }
//        if (offset < 0) {
//            throw new IllegalArgumentException("Offset index must not be less than zero!");
//        }
//        this.limit = limit;
//        this.offset = offset;
//    }
//
//    //todo
//    @Override
//    public int getNumberOfPages() {
//        return 0;
//    }
//    @Override
//    public PageFormat getPageFormat(int pageIndex) throws IndexOutOfBoundsException {
//        return null;
//    }
//    @Override
//    public Printable getPrintable(int pageIndex) throws IndexOutOfBoundsException {
//        return null;
//    }
//
//    public int getPageNumber() {
//        return offset / limit;
//    }
//
//    public int getPageSize() {
//        return limit;
//    }
//
//    public long getOffset() {
//        return offset;
//    }
//
//    public Sort getSort() {
//        return sort;
//    }
//
//    public Pageable next() {
//        // Typecast possible because number of entries cannot be bigger than integer (primary key is integer)
//        return new OffsetBasedPageRequest(getPageSize(), (int) (getOffset() + getPageSize()));
//    }
//
//    public Pageable previous() {
//        // The integers are positive. Subtracting does not let them become bigger than integer.
//        return hasPrevious() ?
//                new OffsetBasedPageRequest(getPageSize(), (int) (getOffset() - getPageSize())): this;
//    }
//
//    public Pageable previousOrFirst() {
//        return hasPrevious() ? previous() : first();
//    }
//
//    public Pageable first() {
//        return new OffsetBasedPageRequest(getPageSize(), 0);
//    }
//
//    public boolean hasPrevious() {
//        return offset > limit;
//    }
//}
