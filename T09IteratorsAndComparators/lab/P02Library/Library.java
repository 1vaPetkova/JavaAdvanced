package T09IteratorsAndComparators.lab.P02Library;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library implements Iterable<Book> {

    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public Book get(int index) {
        return this.books.get(index);
    }

    public void add(Book book) {
        this.books.add(book);
    }

    public int booksCount() {
        return this.books.size();
    }

    private static class BookIterator implements Iterator<Book> {
        private int i = 0;
        private List<Book> books;

        public BookIterator(List<Book> books) {
            this.books = books;
        }

        @Override
        public boolean hasNext() {
            return i < books.size();
        }

        @Override
        public Book next() {
            return books.get(i++);
        }
    }

//    @Override
//    public Iterator<T09IteratorsAndComparators.lab.P04BookComparator.Book> iterator() {
//        return new Iterator<T09IteratorsAndComparators.lab.P04BookComparator.Book>() {
//        int index = 0;
//            @Override
//            public boolean hasNext() {
//                return index<books.size();
//            }
//
//            @Override
//            public T09IteratorsAndComparators.lab.P04BookComparator.Book next() {
//                return books.get(index++);
//            }
//        };
//    }

    @Override
    public Iterator<Book> iterator() {
        return books.iterator();
    }
}

