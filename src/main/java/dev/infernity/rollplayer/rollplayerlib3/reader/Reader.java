package dev.infernity.rollplayer.rollplayerlib3.reader;

import java.util.function.Predicate;

public interface Reader<T, E> {
    E read();
    E peek();
    T getSource();
    int index();

    default E expect(Predicate<E> value) {
        var read = this.read();
        if(value.test(read)) {
            return read;
        } else {
            throw new RuntimeException("Unexpected value: " + read);
        }
    }

    public void backtrackBy(int amount);
}
