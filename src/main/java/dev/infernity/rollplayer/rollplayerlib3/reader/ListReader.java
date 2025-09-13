package dev.infernity.rollplayer.rollplayerlib3.reader;

import java.util.List;

public class ListReader<T, E> implements Reader<List<E>, E> {
    List<E> list;
    int index = 0;

    public ListReader(List<E> list) {
        this.list = list;
    }

    @Override
    public E read() {
        return this.list.get(this.index++);
    }

    @Override
    public E peek() {
        return this.list.get(this.index);
    }

    @Override
    public List<E> getSource() {
        return this.list;
    }

    @Override
    public int index() {
        return this.index;
    }

    @Override
    public void backtrackBy(int amount) {
        this.index -= amount;
    }
}
